/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.ItemEntity
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.misc;

import java.util.Random;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasicLight;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantBlaze;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantCreeper;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantDimTrader;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantEnderman;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantPiglin;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantSkeleton;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantSpider;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantStray;

public class BlockTrackTrigger
extends BlockBasicLight {
    private int active_num = 0;

    public BlockTrackTrigger(String name, int triggernum) {
        super(name);
        this.active_num = triggernum;
        BlockInit.TRIGGER_BLOCKS.add(this);
    }

    public void trigger(Level world, BlockPos pos) {
        if (!world.field_72995_K) {
            switch (this.active_num) {
                case 0: {
                    EntityDeviantCreeper Creeper = new EntityDeviantCreeper(world);
                    Creeper.func_70107_b(pos.func_177958_n(), pos.func_177956_o() + 2, pos.func_177952_p());
                    world.func_72838_d((Entity)Creeper);
                    break;
                }
                case 1: {
                    EntityDeviantSkeleton Skeleton = new EntityDeviantSkeleton(world);
                    Skeleton.func_70107_b(pos.func_177958_n(), pos.func_177956_o() + 2, pos.func_177952_p());
                    world.func_72838_d((Entity)Skeleton);
                    break;
                }
                case 2: {
                    EntityDeviantStray Stray = new EntityDeviantStray(world);
                    Stray.func_70107_b(pos.func_177958_n(), pos.func_177956_o() + 2, pos.func_177952_p());
                    world.func_72838_d((Entity)Stray);
                    break;
                }
                case 3: {
                    EntityDeviantPiglin Piglin = new EntityDeviantPiglin(world);
                    Piglin.func_70107_b(pos.func_177958_n(), pos.func_177956_o() + 2, pos.func_177952_p());
                    world.func_72838_d((Entity)Piglin);
                    break;
                }
                case 4: {
                    EntityDeviantEnderman Enderman = new EntityDeviantEnderman(world);
                    Enderman.func_70107_b(pos.func_177958_n(), pos.func_177956_o() + 2, pos.func_177952_p());
                    world.func_72838_d((Entity)Enderman);
                    break;
                }
                case 5: {
                    EntityDeviantSpider Spider = new EntityDeviantSpider(world);
                    Spider.func_70107_b(pos.func_177958_n(), pos.func_177956_o() + 2, pos.func_177952_p());
                    world.func_72838_d((Entity)Spider);
                    break;
                }
                case 6: {
                    EntityDeviantBlaze Blaze = new EntityDeviantBlaze(world);
                    Blaze.func_70107_b(pos.func_177958_n(), pos.func_177956_o() + 2, pos.func_177952_p());
                    world.func_72838_d((Entity)Blaze);
                    break;
                }
                case 7: {
                    EntityDeviantDimTrader Dimtrader = new EntityDeviantDimTrader(world);
                    Dimtrader.func_70107_b(pos.func_177958_n(), pos.func_177956_o() + 2, pos.func_177952_p());
                    world.func_72838_d((Entity)Dimtrader);
                    break;
                }
                case 8: {
                    if (world.field_73012_v.nextBoolean()) {
                        EntityDeviantBlaze DevBlaze = new EntityDeviantBlaze(world);
                        DevBlaze.func_70107_b(pos.func_177958_n(), pos.func_177956_o() + 2, pos.func_177952_p());
                        DevBlaze.setMutation(2);
                        world.func_72838_d((Entity)DevBlaze);
                        break;
                    }
                    ItemEntity crystal = new ItemEntity(world, (double)pos.func_177958_n(), (double)(pos.func_177956_o() + 3), (double)pos.func_177952_p(), new ItemStack(ItemInit.crystallizedAlloy, 2 + world.field_73012_v.nextInt(3)));
                    crystal.field_70159_w = 0.0;
                    crystal.field_70181_x = 0.0;
                    crystal.field_70179_y = 0.0;
                    world.func_72838_d((Entity)crystal);
                    break;
                }
                case 9: {
                    ItemEntity crystal = new ItemEntity(world, (double)pos.func_177958_n(), (double)(pos.func_177956_o() + 3), (double)pos.func_177952_p(), new ItemStack(ItemInit.masterForgedIngot, 5 + world.field_73012_v.nextInt(5)));
                    crystal.field_70159_w = 0.0;
                    crystal.field_70181_x = 0.0;
                    crystal.field_70179_y = 0.0;
                    world.func_72838_d((Entity)crystal);
                }
            }
        }
    }

    public static Block randomTriggerBlock(Random rand) {
        return BlockInit.TRIGGER_BLOCKS.get(rand.nextInt(BlockInit.TRIGGER_BLOCKS.size()));
    }
}

