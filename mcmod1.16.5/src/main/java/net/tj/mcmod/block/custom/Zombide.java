package net.tj.mcmod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class Zombide extends Block {
    public Zombide(Properties properties) {
        super(properties);
    }

    public static void makeZombieSpawn(ServerWorld world, BlockPos pos) {
        ZombieEntity entity = new ZombieEntity(world);
        entity.setPosition(pos.getX(), pos.getY(), pos.getZ());
        world.addEntity(entity);
    }
    @Override
    public void spawnAdditionalDrops(BlockState state, ServerWorld serverWorld, BlockPos pos, ItemStack itemStack) {
        Zombide.makeZombieSpawn(serverWorld, pos.up());
        super.spawnAdditionalDrops(state, serverWorld, pos, itemStack);
    }




    @Override
    public void animateTick(BlockState state, World world, BlockPos pos, Random random) {
        double p0 = (double)pos.getX() + 0.5D;
        double p1 = (double)pos.getY() + 1.0D;
        double p2 = (double)pos.getZ() + 0.5D;

        world.addParticle(ParticleTypes.SMOKE.getType(), p0, p1, p2, 0.0D, 0.0D, 0.0D);
        super.animateTick(state, world, pos, random);
    }


}