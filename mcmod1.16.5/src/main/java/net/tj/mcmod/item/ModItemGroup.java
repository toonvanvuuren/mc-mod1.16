package net.tj.mcmod.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup {
    public static final ItemGroup MC_GROUP = new ItemGroup("McModTab")
    {
        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(Moditems.BANANA.get() );
        }
    };

}
