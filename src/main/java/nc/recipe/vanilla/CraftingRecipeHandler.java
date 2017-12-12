package nc.recipe.vanilla;

import nc.handler.EnumHandler.IngotTypes;
import nc.init.NCArmor;
import nc.init.NCBlocks;
import nc.init.NCItems;
import nc.init.NCTools;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class CraftingRecipeHandler {
	
	public static void registerCraftingRecipes() {
		for (int i = 0; i < IngotTypes.values().length; i++) {
			blockCompress(new ItemStack(NCBlocks.ingot_block, 1, i), new ItemStack(NCItems.ingot, 1, i));
			blockOpen(NCItems.ingot, i, new ItemStack(NCBlocks.ingot_block, 1, i));
		}
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NCBlocks.fission_block, 4, 0), new Object[] {" P ", "PTP", " P ", 'P', "plateBasic", 'T', "ingotTough"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NCBlocks.reactor_casing_transparent, 4), new Object[] {"GPG", "PTP", "GPG", 'P', "plateBasic", 'T', "ingotTough", 'G', "blockGlass"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NCBlocks.fission_block, 4, 1), new Object[] {" P ", "POP", " P ", 'P', "plateBasic", 'O', "obsidian"}));
		GameRegistry.addRecipe(new ShapelessOreRecipe(NCBlocks.reactor_casing_transparent, new Object[] {new ItemStack(NCBlocks.fission_block, 1, 0), "blockGlass"}));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(NCBlocks.fission_block, 1, 0), new Object[] {NCBlocks.reactor_casing_transparent}));
		GameRegistry.addRecipe(new ShapedOreRecipe(NCBlocks.cell_block, new Object[] {"TGT", "G G", "TGT", 'T', "ingotTough", 'G', "blockGlass"}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NCBlocks.cooler, 2, 0), new Object[] {"TIT", "I I", "TIT", 'T', "ingotTough", 'I', "ingotSteel"}));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(NCBlocks.cooler, 1, 1), new Object[] {new ItemStack(NCBlocks.cooler, 1, 0), Items.WATER_BUCKET}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NCBlocks.cooler, 1, 2), new Object[] {"R", "C", "R", 'C', new ItemStack(NCBlocks.cooler, 1, 0), 'R', "blockRedstone"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NCBlocks.cooler, 1, 2), new Object[] {"RCR", 'C', new ItemStack(NCBlocks.cooler, 1, 0), 'R', "blockRedstone"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NCBlocks.cooler, 1, 3), new Object[] {"DQD", "DCD", "DQD", 'C', new ItemStack(NCBlocks.cooler, 1, 0), 'Q', "blockQuartz", 'D', "dustQuartz"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NCBlocks.cooler, 1, 3), new Object[] {"DDD", "QCQ", "DDD", 'C', new ItemStack(NCBlocks.cooler, 1, 0), 'Q', "blockQuartz", 'D', "dustQuartz"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NCBlocks.cooler, 1, 4), new Object[] {"GGG", " C ", "GGG", 'C', new ItemStack(NCBlocks.cooler, 1, 0), 'G', "ingotGold"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NCBlocks.cooler, 1, 4), new Object[] {"G G", "GCG", "G G", 'C', new ItemStack(NCBlocks.cooler, 1, 0), 'G', "ingotGold"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NCBlocks.cooler, 1, 5), new Object[] {"DGD", "DCD", "DGD", 'C', new ItemStack(NCBlocks.cooler, 1, 0), 'G', "glowstone", 'D', "dustGlowstone"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NCBlocks.cooler, 1, 5), new Object[] {"DDD", "GCG", "DDD", 'C', new ItemStack(NCBlocks.cooler, 1, 0), 'G', "glowstone", 'D', "dustGlowstone"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NCBlocks.cooler, 1, 6), new Object[] {"LLL", "LCL", "LLL", 'C', new ItemStack(NCBlocks.cooler, 1, 0), 'L', "gemLapis"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NCBlocks.cooler, 1, 7), new Object[] {"DDD", " C ", "DDD", 'C', new ItemStack(NCBlocks.cooler, 1, 0), 'D', "gemDiamond"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NCBlocks.cooler, 1, 7), new Object[] {"D D", "DCD", "D D", 'C', new ItemStack(NCBlocks.cooler, 1, 0), 'D', "gemDiamond"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NCBlocks.cooler, 1, 9), new Object[] {" E ", "ECE", " E ", 'C', new ItemStack(NCBlocks.cooler, 1, 0), 'E', "ingotEnderium"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NCBlocks.cooler, 1, 10), new Object[] {"DDD", "DCD", "DDD", 'C', new ItemStack(NCBlocks.cooler, 1, 0), 'D', "dustCryotheum"}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(NCItems.reactor_door, new Object[] {"CC", "CC", "CC", 'C', new ItemStack(NCBlocks.fission_block, 1, 0)}));
		GameRegistry.addRecipe(new ShapedOreRecipe(NCBlocks.reactor_trapdoor, new Object[] {"CCC", "CCC", 'C', new ItemStack(NCBlocks.fission_block, 1, 0)}));
		
		blockCompress(NCBlocks.block_depleted_thorium, "ingotThorium230");
		blockCompress(NCBlocks.block_depleted_uranium, "ingotUranium238");
		blockOpen(NCItems.thorium, 0, NCBlocks.block_depleted_thorium);
		blockOpen(NCItems.uranium, 8, NCBlocks.block_depleted_uranium);
		
		GameRegistry.addRecipe(new ShapedOreRecipe(NCBlocks.nuclear_furnace_idle, new Object[] {"PTP", "TFT", "PTP", 'T', "ingotTough", 'P', "plateBasic", 'F', Blocks.FURNACE}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(NCBlocks.manufactory_idle, new Object[] {"LCL", "CPC", "LCL", 'C', "solenoidCopper", 'L', "ingotLead", 'P', Blocks.PISTON}));
		GameRegistry.addRecipe(new ShapedOreRecipe(NCBlocks.alloy_furnace_idle, new Object[] {"PIP", "IMI", "PIP", 'I', "ingotIron", 'P', "plateBasic", 'M', NCBlocks.manufactory_idle}));
		GameRegistry.addRecipe(new ShapedOreRecipe(NCBlocks.decay_hastener_idle, new Object[] {"PMP", "MAM", "PMP", 'M', "ingotMagnesium", 'P', "plateAdvanced", 'A', NCBlocks.alloy_furnace_idle}));
		GameRegistry.addRecipe(new ShapedOreRecipe(NCBlocks.fuel_reprocessor_idle, new Object[] {"PBP", "BAB", "PBP", 'B', "ingotBronze", 'P', "plateAdvanced", 'A', NCBlocks.alloy_furnace_idle}));
		GameRegistry.addRecipe(new ShapedOreRecipe(NCBlocks.isotope_separator_idle, new Object[] {"PFP", "FAF", "PFP", 'F', "ingotFerroboron", 'P', "plateAdvanced", 'A', NCBlocks.alloy_furnace_idle}));
		GameRegistry.addRecipe(new ShapedOreRecipe(NCBlocks.pressurizer_idle, new Object[] {"PBP", "BAB", "PBP", 'B', Blocks.PISTON, 'P', "plateAdvanced", 'A', NCBlocks.alloy_furnace_idle}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(NCBlocks.salt_mixer_idle, new Object[] {"PGP", "GMG", "PGP", 'G', "blockGlass", 'P', "plateBasic", 'M', NCBlocks.manufactory_idle}));
		GameRegistry.addRecipe(new ShapedOreRecipe(NCBlocks.dissolver_idle, new Object[] {"POP", "OSO", "POP", 'O', "dustObsidian", 'P', "plateAdvanced", 'S', NCBlocks.salt_mixer_idle}));
		GameRegistry.addRecipe(new ShapedOreRecipe(NCBlocks.chemical_reactor_idle, new Object[] {"PZP", "ZSZ", "PZP", 'Z', "ingotZirconium", 'P', "plateAdvanced", 'S', NCBlocks.salt_mixer_idle}));
		GameRegistry.addRecipe(new ShapedOreRecipe(NCBlocks.electrolyser_idle, new Object[] {"PRP", "RSR", "PRP", 'R', "dustRedstone", 'P', "plateAdvanced", 'S', NCBlocks.salt_mixer_idle}));
		GameRegistry.addRecipe(new ShapedOreRecipe(NCBlocks.irradiator_idle, new Object[] {"PGP", "GSG", "PGP", 'G', "ingotGold", 'P', "plateAdvanced", 'S', NCBlocks.salt_mixer_idle}));
		GameRegistry.addRecipe(new ShapedOreRecipe(NCBlocks.supercooler_idle, new Object[] {"PGP", "GSG", "PGP", 'G', "dustGlowstone", 'P', "plateAdvanced", 'S', NCBlocks.salt_mixer_idle}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(NCBlocks.ingot_former_idle, new Object[] {"PBP", "BMB", "PBP", 'B', "ingotBoron", 'P', "plateBasic", 'M', NCBlocks.manufactory_idle}));
		GameRegistry.addRecipe(new ShapedOreRecipe(NCBlocks.melter_idle, new Object[] {"PNP", "NAN", "PNP", 'N', Items.NETHERBRICK, 'P', "plateAdvanced", 'A', NCBlocks.alloy_furnace_idle}));
		GameRegistry.addRecipe(new ShapedOreRecipe(NCBlocks.crystallizer_idle, new Object[] {"PBP", "BIB", "PBP", 'B', "ingotBeryllium", 'P', "plateAdvanced", 'I', NCBlocks.ingot_former_idle}));
		GameRegistry.addRecipe(new ShapedOreRecipe(NCBlocks.infuser_idle, new Object[] {"PTP", "TAT", "PTP", 'T', "ingotTin", 'P', "plateAdvanced", 'A', NCBlocks.alloy_furnace_idle}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(NCBlocks.machine_interface, new Object[] {" P ", "PBP", " P ", 'P', "plateBasic", 'B', NCBlocks.buffer}));

		GameRegistry.addRecipe(new ShapedOreRecipe(NCBlocks.fission_controller_idle, new Object[] {"PSP", "SFS", "PSP", 'S', "solenoidMagnesiumDiboride", 'P', "plateElite", 'F', NCBlocks.nuclear_furnace_idle}));
		GameRegistry.addRecipe(new ShapedOreRecipe(NCBlocks.fission_port, new Object[] {" S ", "RHR", " S ", 'S', "solenoidCopper", 'R', new ItemStack(NCBlocks.fission_block, 1, 0), 'H', Blocks.HOPPER}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(NCBlocks.fusion_core, new Object[] {"PSP", "SCS", "PSP", 'S', "solenoidMagnesiumDiboride", 'P', "plateElite", 'C', NCBlocks.chemical_reactor_idle}));
		GameRegistry.addRecipe(new ShapedOreRecipe(NCBlocks.fusion_connector, new Object[] {"TPT", "PCP", "TPT", 'T', "ingotTough", 'P', "plateBasic", 'C', "ingotCopper"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NCBlocks.fusion_electromagnet_idle, 2), new Object[] {"SPS", "P P", "SPS", 'P', "plateAdvanced", 'S', "solenoidCopper"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NCBlocks.fusion_electromagnet_transparent_idle, 2), new Object[] {"SPS", "PGP", "SPS", 'P', "plateAdvanced", 'S', "solenoidCopper", 'G', "blockGlass"}));
		GameRegistry.addRecipe(new ShapelessOreRecipe(NCBlocks.fusion_electromagnet_transparent_idle, new Object[] {NCBlocks.fusion_electromagnet_idle, "blockGlass"}));
		GameRegistry.addRecipe(new ShapelessOreRecipe(NCBlocks.fusion_electromagnet_idle, new Object[] {NCBlocks.fusion_electromagnet_transparent_idle}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(NCBlocks.rtg_uranium, new Object[] {"PGP", "GUG", "PGP", 'G', "ingotGraphite", 'P', "plateBasic", 'U', "blockDepletedUranium"}));
		//GameRegistry.addRecipe(new ShapedOreRecipe(NCBlocks.rtg_uranium, new Object[] {"LLL", "CUC", "LLL", 'L', "ingotLead", 'C', "blockCoal", 'U', "blockUranium"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(NCBlocks.rtg_plutonium, new Object[] {"PGP", "GUG", "PGP", 'G', "ingotGraphite", 'P', "plateAdvanced", 'U', "ingotPlutonium238"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(NCBlocks.rtg_americium, new Object[] {"PGP", "GAG", "PGP", 'G', "ingotGraphite", 'P', "plateAdvanced", 'A', "ingotAmericium241"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(NCBlocks.rtg_californium, new Object[] {"PGP", "GCG", "PGP", 'G', "ingotGraphite", 'P', "plateAdvanced", 'C', "ingotCalifornium250"}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(NCBlocks.solar_panel_basic, new Object[] {"GQG", "PLP", "WPW", 'G', "dustGraphite", 'Q', "dustQuartz", 'P', Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE, 'L', "gemLapis", 'W', new ItemStack(NCItems.part, 1, 4)}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(NCBlocks.decay_generator, new Object[] {"LCL", "CRC", "LCL", 'C', "cobblestone", 'L', "ingotLead", 'R', "dustRedstone"}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(NCBlocks.voltaic_pile_basic, new Object[] {"PWP", "WMW", "PWP", 'P', "plateBasic", 'W', new ItemStack(NCItems.part, 1, 4), 'M', "blockMagnesium"}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(NCBlocks.buffer, new Object[] {"PSP", "BHB", "PSP", 'S', "solenoidCopper", 'P', "plateBasic", 'H', Blocks.HOPPER, 'B', Items.BUCKET}));
		GameRegistry.addRecipe(new ShapedOreRecipe(NCBlocks.active_cooler, new Object[] {"PSP", "BHB", "PSP", 'S', "ingotTin", 'P', "plateBasic", 'H', Items.CAULDRON, 'B', "ingotCopper"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(NCBlocks.bin, new Object[] {"PZP", "Z Z", "PZP", 'P', "plateBasic", 'Z', "ingotZirconium"}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NCBlocks.accelerator_electromagnet_idle, 2), new Object[] {"SPS", "P P", "SPS", 'P', "plateElite", 'S', "solenoidMagnesiumDiboride"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(NCBlocks.electromagnet_supercooler_idle, new Object[] {"TIT", "IEI", "TIT", 'T', "ingotTin", 'I', NCBlocks.block_ice, 'E', NCBlocks.accelerator_electromagnet_idle}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(NCBlocks.helium_collector, new Object[] {"PIP", "ITI", "PIP", 'I', "ingotTin", 'P', "plateBasic", 'T', "blockDepletedThorium"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NCBlocks.cobblestone_generator, 2), new Object[] {"PIP", "L W", "PIP", 'I', "ingotTin", 'P', "plateBasic", 'L', Items.LAVA_BUCKET, 'W', Items.WATER_BUCKET}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NCBlocks.cobblestone_generator, 2), new Object[] {"PIP", "W L", "PIP", 'I', "ingotTin", 'P', "plateBasic", 'L', Items.LAVA_BUCKET, 'W', Items.WATER_BUCKET}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NCBlocks.water_source, 2), new Object[] {"PIP", "W W", "PIP", 'I', "ingotTin", 'P', "plateBasic", 'W', Items.WATER_BUCKET}));
		GameRegistry.addRecipe(new ShapedOreRecipe(NCBlocks.nitrogen_collector, new Object[] {"PIP", "B B", "PIP", 'I', "ingotBeryllium", 'P', "plateAdvanced", 'B', Items.BUCKET}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NCItems.part, 2, 0), new Object[] {"LG", "GL", 'L', "ingotLead", 'G', "dustGraphite"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NCItems.part, 2, 0), new Object[] {"GL", "LG", 'L', "ingotLead", 'G', "dustGraphite"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NCItems.part, 1, 1), new Object[] {"RTR", "TPT", "RTR", 'R', "dustRedstone", 'T', "ingotTough", 'P', "plateBasic"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NCItems.part, 1, 2), new Object[] {"SUS", "UPU", "SUS", 'S', "dustSulfurBinder", 'U', "ingotUranium238", 'P', "plateAdvanced"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NCItems.part, 1, 3), new Object[] {"RBR", "BPB", "RBR", 'R', "dustCrystalBinder", 'B', "ingotBoron", 'P', "plateDU"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NCItems.part, 2, 4), new Object[] {"CC", "II", "CC", 'C', "ingotCopper", 'I', "ingotIron"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NCItems.part, 2, 5), new Object[] {"MM", "TT", "MM", 'M', "ingotMagnesiumDiboride", 'T', "ingotTough"}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NCItems.upgrade, 1, 0), new Object[] {"LRL", "RPR", "LRL", 'L', "gemLapis", 'R', "dustRedstone", 'P', Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(NCItems.fuel_rod_empty, 32), new Object[] {" I ", "B B", " I ", 'I', "ingotIron", 'B', "ingotTin"}));
		
		blockCompress(new ItemStack(NCItems.dust, 1, 2), "tinyDustLead");
		blockOpen(NCItems.tiny_dust_lead, "dustLead");
		
		tools("ingotBoron", NCTools.sword_boron, NCTools.pickaxe_boron, NCTools.shovel_boron, NCTools.axe_boron, NCTools.hoe_boron, NCTools.spaxelhoe_boron);
		tools("ingotTough", NCTools.sword_tough, NCTools.pickaxe_tough, NCTools.shovel_tough, NCTools.axe_tough, NCTools.hoe_tough, NCTools.spaxelhoe_tough);
		tools("ingotHardCarbon", NCTools.sword_hard_carbon, NCTools.pickaxe_hard_carbon, NCTools.shovel_hard_carbon, NCTools.axe_hard_carbon, NCTools.hoe_hard_carbon, NCTools.spaxelhoe_hard_carbon);
		tools("gemBoronNitride", NCTools.sword_boron_nitride, NCTools.pickaxe_boron_nitride, NCTools.shovel_boron_nitride, NCTools.axe_boron_nitride, NCTools.hoe_boron_nitride, NCTools.spaxelhoe_boron_nitride);
		
		armor("ingotBoron", NCArmor.helm_boron, NCArmor.chest_boron, NCArmor.legs_boron, NCArmor.boots_boron);
		armor("ingotTough", NCArmor.helm_tough, NCArmor.chest_tough, NCArmor.legs_tough, NCArmor.boots_tough);
		armor("ingotHardCarbon", NCArmor.helm_hard_carbon, NCArmor.chest_hard_carbon, NCArmor.legs_hard_carbon, NCArmor.boots_hard_carbon);
		armor("gemBoronNitride", NCArmor.helm_boron_nitride, NCArmor.chest_boron_nitride, NCArmor.legs_boron_nitride, NCArmor.boots_boron_nitride);
		
		blockCompress(new ItemStack(NCItems.fuel_thorium, 1, 0), "ingotThorium232");
		blockCompress(new ItemStack(NCItems.fuel_thorium, 1, 1), "ingotThorium232Oxide");
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(NCItems.fuel_rod_thorium, 1, 0), new Object[] {NCItems.fuel_rod_empty, "fuelTBU"}));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(NCItems.fuel_rod_thorium, 1, 1), new Object[] {NCItems.fuel_rod_empty, "fuelTBUOxide"}));
		
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(NCItems.fuel_mixed_oxide, 1, 0), new Object[] {"ingotPlutonium239Oxide", "ingotUranium238", "ingotUranium238", "ingotUranium238", "ingotUranium238", "ingotUranium238", "ingotUranium238", "ingotUranium238", "ingotUranium238"}));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(NCItems.fuel_mixed_oxide, 1, 1), new Object[] {"ingotPlutonium241Oxide", "ingotUranium238", "ingotUranium238", "ingotUranium238", "ingotUranium238", "ingotUranium238", "ingotUranium238", "ingotUranium238", "ingotUranium238"}));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(NCItems.fuel_rod_mixed_oxide, 1, 0), new Object[] {NCItems.fuel_rod_empty, "fuelMOX239"}));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(NCItems.fuel_rod_mixed_oxide, 1, 1), new Object[] {NCItems.fuel_rod_empty, "fuelMOX241"}));
		
		fissionClumpRecipes("Thorium", NCItems.thorium, 230, 232);
		fissionClumpRecipes("Uranium", NCItems.uranium, 233, 235, 238);
		fissionClumpRecipes("Neptunium", NCItems.neptunium, 236, 237);
		fissionClumpRecipes("Plutonium", NCItems.plutonium, 238, 239, 241, 242);
		fissionClumpRecipes("Americium", NCItems.americium, 241, 242, 243);
		fissionClumpRecipes("Curium", NCItems.curium, 243, 245, 246, 247);
		fissionClumpRecipes("Berkelium", NCItems.berkelium, 247, 248);
		fissionClumpRecipes("Californium", NCItems.californium, 249, 250, 251, 252);
		
		fissionFuelRecipes("Uranium", "U", NCItems.fuel_uranium, NCItems.fuel_rod_uranium, 238, 233, 235);
		fissionFuelRecipes("Neptunium", "N", NCItems.fuel_neptunium, NCItems.fuel_rod_neptunium, 237, 236);
		fissionFuelRecipes("Plutonium", "P", NCItems.fuel_plutonium, NCItems.fuel_rod_plutonium, 242, 239, 241);
		fissionFuelRecipes("Americium", "A", NCItems.fuel_americium, NCItems.fuel_rod_americium, 243, 242);
		fissionFuelRecipes("Curium", "Cm", NCItems.fuel_curium, NCItems.fuel_rod_curium, 246, 243, 245, 247);
		fissionFuelRecipes("Berkelium", "B", NCItems.fuel_berkelium, NCItems.fuel_rod_berkelium, 247, 248);
		fissionFuelRecipes("Californium", "Cf", NCItems.fuel_californium, NCItems.fuel_rod_californium, 252, 249, 251);
		
		tinyClumpRecipes("Boron", NCItems.boron, 10, 11);
		tinyClumpRecipes("Lithium", NCItems.lithium, 6, 7);
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(NCItems.compound, 4, 1), new Object[] {"dustRhodochrosite", "dustSulfurBinder", "dustObsidian", "dustMagnesium"}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(NCItems.portable_ender_chest, new Object[] {" S ", "WCW", "LWL", 'C', Blocks.ENDER_CHEST, 'W', new ItemStack(Blocks.WOOL, 1, 10), 'S', Items.STRING, 'L', "ingotTough"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(NCItems.portable_ender_chest, new Object[] {" S ", "WCW", "LWL", 'C', Blocks.ENDER_CHEST, 'W', new ItemStack(Blocks.WOOL, 1, 15), 'S', Items.STRING, 'L', "ingotTough"}));
		
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(NCItems.dominos, 4), new Object[] {Items.BREAD, Items.BREAD, Items.BREAD, Items.COOKED_PORKCHOP, Items.COOKED_BEEF, Items.COOKED_CHICKEN, Items.COOKED_MUTTON, Blocks.BROWN_MUSHROOM, Blocks.BROWN_MUSHROOM}));
		GameRegistry.addRecipe(new ShapelessOreRecipe(Blocks.BROWN_MUSHROOM, new Object[] {NCBlocks.glowing_mushroom}));
		GameRegistry.addRecipe(new ShapelessOreRecipe(NCBlocks.glowing_mushroom, new Object[] {Blocks.BROWN_MUSHROOM, "dustGlowstone"}));
		
		GameRegistry.addRecipe(new ShapelessOreRecipe(NCItems.record_wanderer, new Object[] {"record", "ingotTough"}));
		GameRegistry.addRecipe(new ShapelessOreRecipe(NCItems.record_end_of_the_world, new Object[] {"record", "ingotUranium"}));
		GameRegistry.addRecipe(new ShapelessOreRecipe(NCItems.record_money_for_nothing, new Object[] {"record", "ingotBronze"}));
	}
	
	public static void fissionFuelRecipes(String element, String fuelLetter, Item fuelType, Item rodType, int fertileNo, int... fissileNo) {
		for (int i = 0; i < fissileNo.length; i++) {
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(fuelType, 1, 4*i), new Object[] {"ingot" + element + fissileNo[i], "ingot" + element + fertileNo, "ingot" + element + fertileNo, "ingot" + element + fertileNo, "ingot" + element + fertileNo, "ingot" + element + fertileNo, "ingot" + element + fertileNo, "ingot" + element + fertileNo, "ingot" + element + fertileNo}));
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(fuelType, 1, 1 + 4*i), new Object[] {"ingot" + element + fissileNo[i] + "Oxide", "ingot" + element + fertileNo, "ingot" + element + fertileNo, "ingot" + element + fertileNo, "ingot" + element + fertileNo, "ingot" + element + fertileNo, "ingot" + element + fertileNo, "ingot" + element + fertileNo, "ingot" + element + fertileNo}));
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(rodType, 1, 4*i), new Object[] {NCItems.fuel_rod_empty, "fuelLE" + fuelLetter + fissileNo[i]}));
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(rodType, 1, 1 + 4*i), new Object[] {NCItems.fuel_rod_empty, "fuelLE" + fuelLetter + fissileNo[i] + "Oxide"}));
			
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(fuelType, 1, 2 + 4*i), new Object[] {"ingot" + element + fissileNo[i], "ingot" + element + fissileNo[i], "ingot" + element + fissileNo[i], "ingot" + element + fissileNo[i], "ingot" + element + fertileNo, "ingot" + element + fertileNo, "ingot" + element + fertileNo, "ingot" + element + fertileNo, "ingot" + element + fertileNo}));
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(fuelType, 1, 3 + 4*i), new Object[] {"ingot" + element + fissileNo[i] + "Oxide", "ingot" + element + fissileNo[i] + "Oxide", "ingot" + element + fissileNo[i] + "Oxide", "ingot" + element + fissileNo[i] + "Oxide", "ingot" + element + fertileNo, "ingot" + element + fertileNo, "ingot" + element + fertileNo, "ingot" + element + fertileNo, "ingot" + element + fertileNo}));
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(rodType, 1, 2 + 4*i), new Object[] {NCItems.fuel_rod_empty, "fuelHE" + fuelLetter + fissileNo[i]}));
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(rodType, 1, 3 + 4*i), new Object[] {NCItems.fuel_rod_empty, "fuelHE" + fuelLetter + fissileNo[i] + "Oxide"}));
		}	
	}
	
	public static void fissionClumpRecipes(String element, Item material, int... types) {
		for (int i = 0; i < types.length; i++) {
			blockCompress(new ItemStack(material, 1, 4*i), "tiny" + element + types[i]);
			blockCompress(new ItemStack(material, 1, 1 + 4*i), "tiny" + element + types[i] + "Oxide");
			blockOpen(material, 2 + 4*i, "ingot" + element + types[i]);
			blockOpen(material, 3 + 4*i, "ingot" + element + types[i] + "Oxide");
		}
	}
	
	public static void tinyClumpRecipes(String element, Item material, int... types) {
		for (int i = 0; i < types.length; i++) {
			blockCompress(new ItemStack(material, 1, 2*i), "tiny" + element + types[i]);
			blockOpen(material, 1 + 2*i, "ingot" + element + types[i]);
		}
	}
	
	public static void blockCompress(ItemStack itemOut, Object itemIn) {
		GameRegistry.addRecipe(new ShapedOreRecipe(itemOut, new Object[] {"III", "III", "III", 'I', itemIn}));
	}
	
	public static void blockCompress(Item itemOut, Object itemIn) {
		GameRegistry.addRecipe(new ShapedOreRecipe(itemOut, new Object[] {"III", "III", "III", 'I', itemIn}));
	}
	
	public static void blockCompress(Block itemOut, Object itemIn) {
		GameRegistry.addRecipe(new ShapedOreRecipe(itemOut, new Object[] {"III", "III", "III", 'I', itemIn}));
	}
	
	public static void blockOpen(Item itemOut, int metaOut, Object itemIn) {
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(itemOut, 9, metaOut), new Object[] {itemIn}));
	}
	
	public static void blockOpen(Item itemOut, Object itemIn) {
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(itemOut, 9, 0), new Object[] {itemIn}));
	}
	
	public static void tools(Object material, Item sword, Item pick, Item shovel, Item axe, Item hoe, Item spaxelhoe) {
		GameRegistry.addRecipe(new ShapedOreRecipe(sword, new Object[] {"M", "M", "S", 'M', material, 'S', "stickWood"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(pick, new Object[] {"MMM", " S ", " S ", 'M', material, 'S', "stickWood"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(shovel, new Object[] {"M", "S", "S", 'M', material, 'S', "stickWood"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(axe, new Object[] {"MM", "MS", " S", 'M', material, 'S', "stickWood"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(axe, new Object[] {"MM", "SM", "S ", 'M', material, 'S', "stickWood"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(hoe, new Object[] {"MM", " S", " S", 'M', material, 'S', "stickWood"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(hoe, new Object[] {"MM", "S ", "S ", 'M', material, 'S', "stickWood"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(spaxelhoe, new Object[] {"ASP", "HIW", " I ", 'A', axe, 'S', shovel, 'P', pick, 'H', hoe, 'W', sword, 'I', "ingotIron"}));
	}
	
	public static void armor(Object material, Item helm, Item chest, Item legs, Item boots) {
		GameRegistry.addRecipe(new ShapedOreRecipe(helm, new Object[] {"MMM", "M M", 'M', material}));
		GameRegistry.addRecipe(new ShapedOreRecipe(chest, new Object[] {"M M", "MMM", "MMM", 'M', material}));
		GameRegistry.addRecipe(new ShapedOreRecipe(legs, new Object[] {"MMM", "M M", "M M", 'M', material}));
		GameRegistry.addRecipe(new ShapedOreRecipe(boots, new Object[] {"M M", "M M", 'M', material}));
	}
}
