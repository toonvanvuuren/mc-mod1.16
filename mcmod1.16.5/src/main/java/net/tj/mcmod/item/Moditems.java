package net.tj.mcmod.item;

import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.tj.mcmod.McMod;
import net.tj.mcmod.block.ModBlocks;
import net.tj.mcmod.item.custom.SpecialItem;
import net.tj.mcmod.item.custom.lavian_hammer;

public class Moditems
{
    public static final DeferredRegister<Item> ITEMS =
        DeferredRegister.create(ForgeRegistries.ITEMS, McMod.MOD_ID);

    //public static  final RegistryObject<Item> BANANA = ITEMS.register("banana",
           // () -> new BlockItem(ModBlocks.BANANA.get(),
                //    new Item.Properties()
               //     .food(new Food.Builder()
                    //        .hunger(2)
                   //         .saturation(0.4f)
                     //       .fastToEat()
                   //         .setAlwaysEdible()
                   //         .effect(new EffectInstance(Effects.JUMP_BOOST, 200, 10), 1.0f).build())
                   // .group(ModItemGroup.MC_GROUP)));

    public static final RegistryObject<Item> COCONUT = ITEMS.register("coconut",
            () -> new Item(new Item.Properties().group(ModItemGroup.MC_GROUP)));

    public static final RegistryObject<Item> LAVIAN = ITEMS.register("lavian",
            () -> new Item(new Item.Properties().group(ModItemGroup.MC_GROUP)));


    public static final RegistryObject<Item> LAVIAN_SWORDS = ITEMS.register("lavian_swords",
            () -> new SwordItem(ModItemTier.LAVIAN, 5, 3f,
                    new Item.Properties().group(ModItemGroup.MC_GROUP)));

    public static final RegistryObject<Item> LAVIAN_PICKAXE = ITEMS.register("lavian_pickaxe",
            () -> new PickaxeItem(ModItemTier.LAVIAN, -7, -1f,
                    new Item.Properties().group(ModItemGroup.MC_GROUP)));

    public static final RegistryObject<Item> LAVIAN_AXE = ITEMS.register("lavian_axe",
            () -> new AxeItem(ModItemTier.LAVIAN, 4, 0f,
                    new Item.Properties().group(ModItemGroup.MC_GROUP)));

    public static final RegistryObject<Item> LAVIAN_HOE = ITEMS.register("lavian_hoe",
            () -> new HoeItem(ModItemTier.LAVIAN, -8, 0f,
                    new Item.Properties().group(ModItemGroup.MC_GROUP)));

    public static final RegistryObject<Item> LAVIAN_SHOVEL = ITEMS.register("lavian_shovel",
            () -> new ShovelItem(ModItemTier.LAVIAN, -7, 0f,
                    new Item.Properties().group(ModItemGroup.MC_GROUP)));


    public  static final RegistryObject<SpecialItem> SPECIAL_ITEM = ITEMS.register("special_item",
            () -> new SpecialItem(new Item.Properties().group(ModItemGroup.MC_GROUP)));


    public static final RegistryObject<Item> LAVIAN_HAMMER = ITEMS.register("lavian_hammer",
            () -> new lavian_hammer(new Item.Properties().group(ModItemGroup.MC_GROUP).maxDamage(8)));


    public static final RegistryObject<Item> BANANA = ITEMS.register("banana",
            () -> new BlockItem(ModBlocks.BANANA.get(), new Item.Properties()
                    .food(new Food.Builder().hunger(1).saturation(0.1f).fastToEat().setAlwaysEdible().effect(new EffectInstance(Effects.JUMP_BOOST, 200, 10), 1.0f).build())
                    .group(ModItemGroup.MC_GROUP)));







    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}
