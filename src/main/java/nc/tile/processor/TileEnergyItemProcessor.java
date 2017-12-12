package nc.tile.processor;

import java.util.ArrayList;

import nc.config.NCConfig;
import nc.energy.EnumStorage.EnergyConnection;
import nc.init.NCItems;
import nc.recipe.BaseRecipeHandler;
import nc.recipe.IIngredient;
import nc.recipe.IRecipe;
import nc.recipe.RecipeMethods;
import nc.recipe.SorptionType;
import nc.tile.IGui;
import nc.tile.dummy.IInterfaceable;
import nc.tile.energy.TileEnergySidedInventory;
import nc.util.NCUtil;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.MathHelper;

public abstract class TileEnergyItemProcessor extends TileEnergySidedInventory implements IInterfaceable, IGui {
	
	public final int defaultProcessTime;
	public int baseProcessTime;
	public final int baseProcessPower;
	public final int inputSize;
	public final int outputSize;
	
	public int time;
	public boolean isProcessing;
	
	public final boolean hasUpgrades;
	public final int upgradeMeta;
	
	public int tickCount;
	
	public final BaseRecipeHandler recipes;
	
	public TileEnergyItemProcessor(String name, int inSize, int outSize, int time, int power, BaseRecipeHandler recipes) {
		this(name, inSize, outSize, time, power, false, recipes, 1);
	}
	
	public TileEnergyItemProcessor(String name, int inSize, int outSize, int time, int power, BaseRecipeHandler recipes, int upgradeMeta) {
		this(name, inSize, outSize, time, power, true, recipes, upgradeMeta);
	}
	
	public TileEnergyItemProcessor(String name, int inSize, int outSize, int time, int power, boolean upgrades, BaseRecipeHandler recipes, int upgradeMeta) {
		super(name, inSize + outSize + (upgrades ? 2 : 0), 32000, power != 0 ? EnergyConnection.IN : EnergyConnection.NON);
		inputSize = inSize;
		outputSize = outSize;
		defaultProcessTime = time;
		baseProcessTime = time;
		baseProcessPower = power;
		hasUpgrades = upgrades;
		this.recipes = recipes;
		this.upgradeMeta = upgradeMeta;
		
		int[] topSlots1 = new int[inSize];
		for (int i = 0; i < topSlots1.length; i++) {
			topSlots1[i] = i;
		}
		topSlots = topSlots1;
		
		int[] sideSlots1 = new int[inSize + outSize];
		for (int i = 0; i < sideSlots1.length; i++) {
			sideSlots1[i] = i;
		}
		sideSlots = sideSlots1;
		
		int[] bottomSlots1 = new int[outSize];
		for (int i = inSize; i < inSize + bottomSlots1.length; i++) {
			bottomSlots1[i - inSize] = i;
		}
		bottomSlots = bottomSlots1;
	}
	
	public void update() {
		super.update();
		updateProcessor();
	}
	
	public void updateProcessor() {
		boolean flag = isProcessing;
		boolean flag1 = false;
		setCapacityFromSpeed();
		if(!worldObj.isRemote) {
			tick();
			if (canProcess() && !isPowered()) {
				isProcessing = true;
				time += getSpeedMultiplier();
				storage.changeEnergyStored(-getProcessPower());
				if (time >= baseProcessTime) {
					time = 0;
					process();
				}
			} else {
				isProcessing = false;
				if (time != 0 && !isPowered()) time = MathHelper.clamp_int(time - 2*getSpeedMultiplier(), 0, baseProcessTime);
			}
			if (flag != isProcessing) {
				flag1 = true;
				if (NCConfig.update_block_type) {
					removeTileFromENet();
					setBlockState();
					worldObj.notifyNeighborsOfStateChange(pos, blockType);
					addTileToENet();
				}
			}
		} else {
			isProcessing = canProcess() && !isPowered();
		}
		
		if (flag1) {
			markDirty();
		}
	}
	
	public abstract void setBlockState();
	
	public void tick() {
		if (tickCount > NCConfig.processor_update_rate) {
			tickCount = 0;
		} else {
			tickCount++;
		}
	}
	
	public boolean shouldCheck() {
		return tickCount > NCConfig.processor_update_rate;
	}
	
	public void onAdded() {
		super.onAdded();
		baseProcessTime = defaultProcessTime;
		if (!worldObj.isRemote) isProcessing = isProcessing();
	}
	
	public boolean isProcessing() {
		if (worldObj.isRemote) return isProcessing;
		return !isPowered() && canProcess();
	}
	
	public boolean isPowered() {
		return worldObj.isBlockPowered(pos);
	}
	
	public boolean canProcess() {
		return canProcessStacks();
	}
	
	// IC2 Tiers
	
	public int getSourceTier() {
		return 1;
	}
	
	public int getSinkTier() {
		return 2;
	}
	
	// Processing
	
	public int getSpeedMultiplier() {
		if (!hasUpgrades) return 1;
		ItemStack speedStack = inventoryStacks[inputSize + outputSize];
		if (speedStack == null) return 1;
		return speedStack.stackSize + 1;
	}
	
	public int getProcessTime() {
		return Math.max(1, baseProcessTime/getSpeedMultiplier());
	}
	
	public int getProcessPower() {
		return baseProcessPower*getSpeedMultiplier()*(getSpeedMultiplier() + 1) / 2;
	}
	
	public int getProcessEnergy() {
		return getProcessTime()*getProcessPower();
	}
	
	public void setCapacityFromSpeed() {
		storage.setStorageCapacity(MathHelper.clamp_int(2*getProcessPower(), 32000, Integer.MAX_VALUE));
	}
	
	public boolean canProcessStacks() {
		for (int i = 0; i < inputSize; i++) {
			if (inventoryStacks[i] == null) {
				return false;
			}
		}
		if (time >= baseProcessTime) {
			return true;
		}
		if (getProcessEnergy() > getMaxEnergyStored() && time <= 0 && getEnergyStored() < getMaxEnergyStored() /*- getProcessPower()*/) {
			return false;
		}
		if (getProcessEnergy() <= getMaxEnergyStored() && time <= 0 && getProcessEnergy() > getEnergyStored()) {
			return false;
		}
		if (getEnergyStored() < getProcessPower()) {
			return false;
		}
		Object[] outputs = outputs();
		if (outputs == null || outputs.length != outputSize) {
			return false;
		}
		for(int j = 0; j < outputSize; j++) {
			if (outputs[j] == null) {
				return false;
			} else {
				if (inventoryStacks[j + inputSize] != null) {
					if (!inventoryStacks[j + inputSize].isItemEqual((ItemStack) outputs[j])) {
						return false;
					} else if (inventoryStacks[j + inputSize].stackSize + ((ItemStack) outputs[j]).stackSize > inventoryStacks[j + inputSize].getMaxStackSize()) {
						return false;
					}
				}
			}
		}
		Object[] inputs = inputs();
		if (recipes.getRecipeFromInputs(inputs).extras().get(0) instanceof Integer) baseProcessTime = (int) recipes.getRecipeFromInputs(inputs).extras().get(0);
		return true;
	}
	
	public void process() {
		IRecipe recipe = getRecipe();
		Object[] outputs = outputs();
		int[] inputOrder = inputOrder();
		if (outputs == null || inputOrder == NCUtil.INVALID) return;
		for (int j = 0; j < outputSize; j++) {
			ItemStack outputStack = (ItemStack) outputs[j];
			if (inventoryStacks[j + inputSize] == null) {
				inventoryStacks[j + inputSize] = outputStack;
			} else if (inventoryStacks[j + inputSize].isItemEqual(outputStack)) {
				inventoryStacks[j + inputSize].stackSize += outputStack.stackSize;
			}
		}
		for (int i = 0; i < inputSize; i++) {
			if (recipes != null) {
				inventoryStacks[i].stackSize -= recipe.inputs().get(inputOrder[i]).getStackSize();
			} else {
				inventoryStacks[i].stackSize --;
			}
			if (inventoryStacks[i].stackSize <= 0) {
				inventoryStacks[i] = null;
			}
		}
	}
	
	public IRecipe getRecipe() {
		return recipes.getRecipeFromInputs(inputs());
	}
	
	public Object[] inputs() {
		Object[] input = new Object[inputSize];
		for (int i = 0; i < inputSize; i++) {
			input[i] = inventoryStacks[i];
		}
		return input;
	}
	
	public int[] inputOrder() {
		int[] inputOrder = new int[inputSize];
		IRecipe recipe = getRecipe();
		if (recipe == null) return new int[] {};
		ArrayList<IIngredient> recipeIngredients = recipe.inputs();
		for (int i = 0; i < inputSize; i++) {
			inputOrder[i] = -1;
			for (int j = 0; j < recipeIngredients.size(); j++) {
				if (recipeIngredients.get(j).matches(inputs()[i], SorptionType.INPUT)) {
					inputOrder[i] = j;
					break;
				}
			}
			if (inputOrder[i] == -1) return NCUtil.INVALID;
		}
		return inputOrder;
	}
	
	public Object[] outputs() {
		Object[] output = new Object[outputSize];
		IRecipe recipe = getRecipe();
		if (recipe == null) return null;
		ArrayList<IIngredient> outputs = recipe.outputs();
		for (int i = 0; i < outputSize; i++) {
			Object out = RecipeMethods.getIngredientFromList(outputs, i);
			if (out == null) return null;
			else output[i] = out;
		}
		return output;
	}
	
	// Inventory
	
	public boolean isItemValidForSlot(int slot, ItemStack stack) {
		if (stack == null) return false;
		if (hasUpgrades) {
			if (stack.getItem() == NCItems.upgrade) {
				if (slot == inputSize + outputSize) return stack.getMetadata() == 0;
				else if (slot == inputSize + outputSize + 1) return stack.getMetadata() == upgradeMeta;
			}
		}
		if (slot >= inputSize) return false;
		return recipes.isValidManualInput(stack);
	}
	
	// SidedInventory
	
	public int[] getSlotsForFace(EnumFacing side) {
		return side == EnumFacing.DOWN ? bottomSlots : (side == EnumFacing.UP ? topSlots : sideSlots);
	}

	public boolean canInsertItem(int slot, ItemStack stack, EnumFacing direction) {
		return isItemValidForSlot(slot, stack) && direction != EnumFacing.DOWN;
	}

	public boolean canExtractItem(int slot, ItemStack stack, EnumFacing direction) {
		return direction != EnumFacing.UP && slot >= inputSize && slot < inputSize + outputSize;
	}
	
	// NBT
	
	public NBTTagCompound writeAll(NBTTagCompound nbt) {
		super.writeAll(nbt);
		nbt.setInteger("time", time);
		nbt.setBoolean("isProcessing", isProcessing);
		return nbt;
	}
	
	public void readAll(NBTTagCompound nbt) {
		super.readAll(nbt);
		time = nbt.getInteger("time");
		isProcessing = nbt.getBoolean("isProcessing");
	}
	
	// Inventory Fields

	public int getFieldCount() {
		return 3;
	}

	public int getField(int id) {
		switch (id) {
		case 0:
			return time;
		case 1:
			return getEnergyStored();
		case 2:
			return baseProcessTime;
		default:
			return 0;
		}
	}

	public void setField(int id, int value) {
		switch (id) {
		case 0:
			time = value;
			break;
		case 1:
			storage.setEnergyStored(value);
			break;
		case 2:
			baseProcessTime = value;
		}
	}
}
