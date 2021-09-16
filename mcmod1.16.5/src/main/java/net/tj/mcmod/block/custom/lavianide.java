package net.tj.mcmod.block.custom;

import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.TNTEntity;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import java.util.Random;

public class lavianide extends Block {
    public lavianide(Properties properties) {
        super(properties);
    }

    public static void setExplodeonBlock(Entity entity, int amplifier, BlockPos pos) {
        entity.getEntityWorld().createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), amplifier, Explosion.Mode.BREAK);



    }

    @Override
    public void onEntityWalk(World world, BlockPos pos, Entity entity) {
        lavianide.setExplodeonBlock(entity, 8, pos.up());
        super.onEntityWalk(world, pos, entity);
    }

    @Override
    public void animateTick(BlockState state, World world, BlockPos pos, Random random) {
        double p0 = (double)pos.getX() + 0.5D;
        double p1 = (double)pos.getY() + 1.0D;
        double p2 = (double)pos.getZ() + 0.5D;

        world.addParticle(ParticleTypes.LAVA.getType(), p0, p1, p2, 2.0D, 2.0D, 2.0D);
        super.animateTick(state, world, pos, random);
    }
}