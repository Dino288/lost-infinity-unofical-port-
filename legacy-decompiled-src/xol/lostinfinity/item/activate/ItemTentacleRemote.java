/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
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
import java.util.List;
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
import xol.lostinfinity.item.basics.ItemRemoteControl;
import xol.lostinfinity.mob.entity.misc.EntityTentacleTrap;

public class ItemTentacleRemote
extends ItemRemoteControl {
    public ItemTentacleRemote(String regName) {
        super(regName);
    }

    @Override
    public BlockRemoteControl getControlBlock() {
        return (BlockRemoteControl)BlockInit.tentacleSynthesizer;
    }

    @Override
    public void tickEffect(BlockEntityRemoteControl te, Level world, BlockPos pos, Player owner) {
        if (!world.field_72995_K && te.getExisted() % 20 == 0) {
            AABB aabb = new AABB(pos).func_186662_g(40.0);
            List detected = world.func_72872_a(LivingEntity.class, aabb);
            ArrayList<LivingEntity> trapped = new ArrayList<LivingEntity>();
            detected.remove(owner);
            for (EntityTentacleTrap tent : world.func_72872_a(EntityTentacleTrap.class, aabb)) {
                if (tent.getTarget() == null) continue;
                trapped.add(tent.getTarget());
            }
            for (LivingEntity entity : detected) {
                if (entity instanceof EntityTentacleTrap || trapped.contains(entity)) continue;
                EntityTentacleTrap trap = new EntityTentacleTrap(world);
                trap.func_70107_b(entity.field_70165_t, entity.field_70163_u, entity.field_70161_v);
                trap.setTarget(entity);
                trap.setOwner(owner);
                world.func_72838_d((Entity)trap);
                world.func_184133_a(null, entity.func_180425_c(), SoundInit.SKYCRAB_HURT, SoundSource.HOSTILE, 1.5f, 0.8f + world.field_73012_v.nextFloat() * 0.4f);
            }
        }
    }

    @Override
    public void toggleEffect(BlockEntityRemoteControl te, Level world, BlockPos pos, Player owner, boolean active) {
    }
}

