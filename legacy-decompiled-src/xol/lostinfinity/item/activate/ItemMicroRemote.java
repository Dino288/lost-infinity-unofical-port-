/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.item.activate;

import java.util.ArrayList;
import javax.annotation.Nullable;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.misc.BlockRemoteControl;
import xol.lostinfinity.block.tileentity.BlockEntityRemoteControl;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemRemoteControl;
import xol.lostinfinity.projectile.entity.EntityMicroRocket;

public class ItemMicroRemote
extends ItemRemoteControl {
    private static final int GROUP_RADIUS = 20;
    private static final int TARGETING_RADIUS = 30;

    public ItemMicroRemote(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_AUXMATS);
    }

    @Override
    @Nullable
    public BlockRemoteControl getControlBlock() {
        return (BlockRemoteControl)BlockInit.microRocket;
    }

    @Override
    public void tickEffect(BlockEntityRemoteControl te, Level world, BlockPos pos, Player owner) {
        if (!world.field_72995_K && te.getExisted() % 60 == 0) {
            boolean toShoot = false;
            for (LivingEntity target : (ArrayList)world.func_72872_a(LivingEntity.class, new AABB((double)(pos.func_177958_n() - 30), (double)pos.func_177956_o(), (double)(pos.func_177952_p() - 30), (double)(pos.func_177958_n() + 30), (double)(pos.func_177956_o() + 30), (double)(pos.func_177952_p() + 30)))) {
                if (target.func_110124_au().equals(owner.func_110124_au())) continue;
                toShoot = true;
                break;
            }
            if (toShoot) {
                Iterable blocks = BlockPos.func_177980_a((BlockPos)pos.func_177982_a(-20, -10, -20), (BlockPos)pos.func_177982_a(20, 20, 20));
                for (BlockPos blockPos : blocks) {
                    if (world.func_180495_p(blockPos).func_177230_c() != BlockInit.microRocket) continue;
                    EntityMicroRocket shot2 = new EntityMicroRocket(world, (double)blockPos.func_177958_n() + 0.5, (double)blockPos.func_177956_o() + 1.5, (double)blockPos.func_177952_p() + 0.5);
                    shot2.setThrower((LivingEntity)owner);
                    shot2.setTargetingHeight(pos.func_177956_o());
                    world.func_72838_d((Entity)shot2);
                    world.func_184133_a(null, blockPos, SoundInit.MISSILE_LAUNCH, SoundSource.BLOCKS, 1.0f, 0.7f + world.field_73012_v.nextFloat() * 0.6f);
                }
            }
        }
    }

    @Override
    public void toggleEffect(BlockEntityRemoteControl te, Level worldIn, BlockPos checkpos, Player owner, boolean active) {
    }
}

