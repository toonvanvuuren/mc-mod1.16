package net.tj.mcmod.world;

import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.tj.mcmod.McMod;
import net.tj.mcmod.world.gen.ModTreeGeneration;


@Mod.EventBusSubscriber(modid = McMod.MOD_ID)
public class ModWorldEvents {


    @SubscribeEvent
    public static void biomeloadingevent (final BiomeLoadingEvent event){
        ModTreeGeneration.generatetrees(event);

    }
}
