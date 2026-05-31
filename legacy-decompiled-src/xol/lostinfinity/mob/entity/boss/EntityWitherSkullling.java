/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.PathfinderMob
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.EnumParticleTypes
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 *  net.minecraft.world.ServerLevel
 */
package xol.lostinfinity.mob.entity.boss;

import java.util.Iterator;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import xol.lostinfinity.mob.entity.base.EntityMultipleLives;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityWitherSkullling
extends EntityMultipleLives
implements IMaxAttack {
    public EntityWitherSkullling(Level worldIn) {
        super(worldIn);
        this.func_70105_a(1.3f, 3.25f);
    }

    @Override
    protected void func_184651_r() {
        this.initBasicTasks((PathfinderMob)this);
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(1500.0);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(3.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.3);
        this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a(1.0);
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null) {
            IMaxAttack.dealMaxHealth((Entity)this, this.func_70638_az(), 4);
            ((ServerLevel)this.field_70170_p).func_175739_a(EnumParticleTypes.SMOKE_LARGE, entity.field_70165_t, entity.field_70163_u + 1.0, entity.field_70161_v, 2, -0.5 + this.field_70146_Z.nextDouble(), 0.3 * (-0.5 + this.field_70146_Z.nextDouble()), -0.5 + this.field_70146_Z.nextDouble(), (double)0.15f, new int[0]);
            return true;
        }
        return false;
    }

    public void func_70636_d() {
        block3: {
            Iterator iterator;
            super.func_70636_d();
            this.field_70143_R = -1.0f;
            if (this.field_70173_aa % 200 > 120) {
                this.func_189654_d(true);
                if (this.field_70181_x < 0.5) {
                    this.func_70024_g(0.0, 0.01f, 0.0);
                }
                this.field_70133_I = true;
            } else {
                this.func_189654_d(false);
            }
            if (this.field_70170_p.field_72995_K || this.func_70638_az() != null || !(iterator = this.field_70170_p.func_72872_a(Player.class, this.getArenaAABB()).iterator()).hasNext()) break block3;
            Player near_pl = (Player)iterator.next();
            this.func_70624_b((LivingEntity)near_pl);
        }
    }

    private AABB getArenaAABB() {
        return new AABB(new BlockPos(958.0, 60.0, 877.0), new BlockPos(1012.0, 82.0, 924.0));
    }

    protected SoundEvent func_184615_bR() {
        return SoundEvents.field_190037_hb;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundEvents.field_190038_hc;
    }

    protected SoundEvent func_184639_G() {
        return SoundEvents.field_190036_ha;
    }
}

