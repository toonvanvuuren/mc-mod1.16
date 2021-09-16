package net.tj.mcmod.item.custom;

import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.tj.mcmod.tileentity.LightningChannelerTile;

public class lavian_hammer extends Item {
    public lavian_hammer(Properties properties) {
        super(properties);
    }
    @Override
    public ActionResultType onItemUseFirst(ItemStack stack, ItemUseContext context) {
        World world = context.getWorld();

        if (!world.isRemote){
            PlayerEntity playerEntity = context.getPlayer();
            BlockState clickedBLock = world.getBlockState(context.getPos());


            rightClickOnCertainBlockStates(clickedBLock, context, playerEntity);
            assert playerEntity != null;
            stack.damageItem(1,playerEntity, player -> player.sendBreakAnimation(context.getHand()));

        }
        
        return super.onItemUseFirst(stack, context);
    }

    private void rightClickOnCertainBlockStates(BlockState clickedBLock, ItemUseContext context,
                                                PlayerEntity playerEntity) {

        boolean playerIsNotOnFire = !playerEntity.isBurning();

        if (random.nextFloat() > 1f){
            lightEntityOnFire(playerEntity, 6);

        } else if (playerIsNotOnFire && blockIsValidForResistance (clickedBLock)){
            gainFireResistanceAndDestroyBlock(playerEntity, context.getWorld(),context.getPos());


        } else {
            lightGroundOnFire(context);

        }


    }

    private boolean blockIsValidForResistance(BlockState clickedBLock) {
        return clickedBLock.getBlock() == Blocks.OBSIDIAN || clickedBLock.getBlock() == Blocks.NETHERRACK;
    }

    public static void lightEntityOnFire(Entity entity, int second) {
        entity.setFire(second);
    }
    private void gainFireResistanceAndDestroyBlock (PlayerEntity playerEntity, World world, BlockPos pos){

        gainFireResistance(playerEntity);
        world.destroyBlock(pos, false);
    }

    public static void gainFireResistance(PlayerEntity playerentity) {
        playerentity.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 200));
    }

    public static void lightGroundOnFire (ItemUseContext context){


        PlayerEntity playerentity = context.getPlayer();
        World world = context.getWorld();
        BlockPos blockpos = context.getPos().offset(context.getFace());
        BlockState blockstate = world.getBlockState(blockpos);

        if (AbstractFireBlock.canLightBlock(world, blockpos, context.getPlacementHorizontalFacing())) {
            world.playSound(playerentity, blockpos, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F,
                    random.nextFloat() * 0.4F + 0.8F);

            BlockState blockstate1 = AbstractFireBlock.getFireForPlacement(world, blockpos);
            world.setBlockState(blockpos, blockstate1, 11);

            }




        }
}
