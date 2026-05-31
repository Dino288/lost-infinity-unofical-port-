/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.material.Material
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.Mob
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.Direction
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.activator;

import net.minecraft.block.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasic;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.common.lostinfinity;
import xol.lostinfinity.common.packets.serverbound.PacketTextTitle;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.item.activate.ItemTrial;
import xol.lostinfinity.mob.entity.deviant.titan.EntityTrialObserver;

public class BlockTrialGate
extends BlockBasic {
    public BlockTrialGate(String name) {
        super(name, Material.field_151576_e);
    }

    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        if (!playerIn.func_70093_af()) {
            ItemStack heldstack = playerIn.func_184586_b(hand);
            if (heldstack.func_77973_b() instanceof ItemTrial) {
                if (!worldIn.field_72995_K) {
                    for (Mob mob_die : worldIn.func_72872_a(Mob.class, this.getArenaAABB())) {
                        mob_die.func_70106_y();
                    }
                    EntityTrialObserver trialob = new EntityTrialObserver(worldIn);
                    trialob.func_70107_b(522.0, 75.0, 438.0);
                    trialob.setEventType(this.trialType(heldstack.func_77973_b()));
                    worldIn.func_72838_d((Entity)trialob);
                    playerIn.func_70634_a(521.5, 62.0, 450.0);
                } else {
                    lostinfinity.instance.packetHandler.sendTitleToPlayer(new PacketTextTitle(true, false, 80, 30, 30, (Object)((Object)TextFmt.Dark_Aqua) + "Trial of the " + this.getCreatureName(heldstack.func_77973_b())), playerIn);
                }
                heldstack.func_190918_g(1);
            } else if (heldstack.func_77973_b().equals(ItemInit.arenaCard)) {
                playerIn.func_184185_a(SoundInit.ARENA_TELEPORT, 3.0f, 1.0f);
                heldstack.func_190918_g(1);
                if (!worldIn.field_72995_K) {
                    playerIn.func_70634_a(521.5, 62.0, 464.0);
                }
            }
        }
        return true;
    }

    private byte trialType(Item item) {
        if (item.equals(ItemInit.trialBlaze)) {
            return 0;
        }
        if (item.equals(ItemInit.trialSkeleton)) {
            return 1;
        }
        if (item.equals(ItemInit.trialSpider)) {
            return 2;
        }
        if (item.equals(ItemInit.trialCreeper)) {
            return 3;
        }
        if (item.equals(ItemInit.trialEnderman)) {
            return 4;
        }
        if (item.equals(ItemInit.trialLlama)) {
            return 5;
        }
        if (item.equals(ItemInit.trialMagmacube)) {
            return 6;
        }
        if (item.equals(ItemInit.trialPigman)) {
            return 7;
        }
        if (item.equals(ItemInit.trialStray)) {
            return 8;
        }
        if (item.equals(ItemInit.trialVex)) {
            return 9;
        }
        if (item.equals(ItemInit.trialZombie)) {
            return 10;
        }
        if (item.equals(ItemInit.trialShulker)) {
            return 11;
        }
        return 1;
    }

    private String getCreatureName(Item item) {
        if (item.equals(ItemInit.trialBlaze)) {
            return "Blaze";
        }
        if (item.equals(ItemInit.trialSkeleton)) {
            return "Skeleton";
        }
        if (item.equals(ItemInit.trialSpider)) {
            return "Spider";
        }
        if (item.equals(ItemInit.trialCreeper)) {
            return "Creeper";
        }
        if (item.equals(ItemInit.trialEnderman)) {
            return "Enderman";
        }
        if (item.equals(ItemInit.trialLlama)) {
            return "Llama";
        }
        if (item.equals(ItemInit.trialMagmacube)) {
            return "Magma Cube";
        }
        if (item.equals(ItemInit.trialPigman)) {
            return "Pigman";
        }
        if (item.equals(ItemInit.trialStray)) {
            return "Stray";
        }
        if (item.equals(ItemInit.trialVex)) {
            return "Vex";
        }
        if (item.equals(ItemInit.trialZombie)) {
            return "Zombie";
        }
        if (item.equals(ItemInit.trialShulker)) {
            return "Shulker";
        }
        return "Nothing";
    }

    private AABB getArenaAABB() {
        return new AABB(new BlockPos(-493.0, 60.0, 407.0), new BlockPos(548.0, 85.0, 460.0));
    }
}

