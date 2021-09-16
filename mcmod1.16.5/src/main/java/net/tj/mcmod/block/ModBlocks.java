package net.tj.mcmod.block;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.tj.mcmod.McMod;
import net.tj.mcmod.block.custom.BananaBlock;
import net.tj.mcmod.block.custom.LightningChannelerBlock;
import net.tj.mcmod.block.custom.Zombide;
import net.tj.mcmod.block.custom.lavianide;
import net.tj.mcmod.block.custom.trees.CoconutTree;
import net.tj.mcmod.item.ModItemGroup;
import net.tj.mcmod.item.Moditems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, McMod.MOD_ID);








    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);

        registerBlockItem(name, toReturn);


        return toReturn;
    }


    public static final RegistryObject<Block> LAVIAN_ORE = registerBlock("lavian_ore",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(3.0f, 3.0f).harvestLevel(3).harvestTool(ToolType.PICKAXE).setRequiresTool()));

    public static final RegistryObject<Block> LAVIAN_BLOCK = registerBlock("lavian_block",
            () -> new Block(AbstractBlock.Properties.create(Material.IRON).sound(SoundType.METAL).hardnessAndResistance(3.0f, 3.0f).harvestLevel(3).harvestTool(ToolType.PICKAXE).setRequiresTool()));

    public static final RegistryObject<Block> EXPLODE_BLOCK = registerBlock("explode_block",
       () -> new FireBlock(AbstractBlock.Properties.create(Material.IRON).sound(SoundType.BONE).hardnessAndResistance(3.0f, 3.0f).harvestLevel(3).harvestTool(ToolType.PICKAXE).setRequiresTool()));



    public static final RegistryObject<Block> COCONUT_LOG = registerBlock("coconut_log",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.from(Blocks.OAK_LOG)));

    public static final RegistryObject<Block> COCONUT_WOOD = registerBlock("coconut_wood",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.from(Blocks.OAK_WOOD)));

    public static final RegistryObject<Block> STRIPPED_COCONUT_LOG = registerBlock("stripped_coconut_log",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.from(Blocks.STRIPPED_OAK_LOG)));

    public static final RegistryObject<Block> STRIPPED_COCONUT_WOOD = registerBlock("stripped_coconut_wood",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.from(Blocks.STRIPPED_OAK_WOOD)));

    public static final RegistryObject<Block> COCONUT_PLANKS = registerBlock("coconut_planks",
            () -> new Block(AbstractBlock.Properties.from(Blocks.OAK_PLANKS)));



    public static final RegistryObject<Block> COCONUT_LEAVES = registerBlock("coconut_leaves",
            () -> new LeavesBlock(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.1f)
            .tickRandomly().sound(SoundType.PLANT).notSolid()));


    public static final RegistryObject<Block> COCONUT_SAPLING = registerBlock("coconut_sapling",
            () -> new SaplingBlock(new CoconutTree(), AbstractBlock.Properties.from(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> LAVIANIDE = registerBlock("lavianide",
            () -> new lavianide(AbstractBlock.Properties.create(Material.TNT).sound(SoundType.WET_GRASS).hardnessAndResistance(0.0f, 0.0f).harvestLevel(0)));

    public static final RegistryObject<Block> ZOMBIDE = registerBlock("zombide",
            () -> new Zombide(AbstractBlock.Properties.create(Material.ORGANIC).sound(SoundType.GROUND).hardnessAndResistance(1.0f, 1.0f).harvestLevel(0)));

    public static final RegistryObject<Block> LIGHTNING_CHANNELER = registerBlock("lightning_channeler",
            () -> new LightningChannelerBlock(AbstractBlock.Properties.create(Material.IRON).hardnessAndResistance(0.4f)));

    public static final RegistryObject<Block> BANANA = BLOCKS.register("banana_crop",
            () -> new BananaBlock(AbstractBlock.Properties.from(Blocks.WHEAT)));

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        Moditems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().group(ModItemGroup.MC_GROUP)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
