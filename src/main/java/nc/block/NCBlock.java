package nc.block;

import nc.Global;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class NCBlock extends Block {

	public NCBlock(String unlocalizedName, String registryName, Material material) {
		super(material);
		setUnlocalizedName(unlocalizedName);
		setRegistryName(new ResourceLocation(Global.MOD_ID, registryName));
		setHarvestLevel("pickaxe", 0);
		setHardness(2);
		setResistance(15);
	}
	
	public boolean canCreatureSpawn(IBlockState state, IBlockAccess world, BlockPos pos, net.minecraft.entity.EntityLiving.SpawnPlacementType type) {
		return false;
	}
	
	public boolean rotateBlock(World world, BlockPos pos, EnumFacing axis) {
		return false;
	}
}
