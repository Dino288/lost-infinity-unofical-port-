/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.misc;

import java.util.UUID;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.base.EntityImmaterial;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class EntityStickyBomb
extends EntityImmaterial
implements IMaxAttack {
    private UUID creator_UUID;
    private LivingEntity holdEntity = null;
    private BlockPos holdPos = null;

    public EntityStickyBomb(Level worldIn) {
        super(worldIn);
        this.func_70105_a(0.25f, 0.25f);
    }

    public void setCreator(UUID uuid) {
        this.creator_UUID = uuid;
    }

    public void setHoldPos(BlockPos pos) {
        this.holdPos = pos;
    }

    public void setHoldPos(LivingEntity entity) {
        this.holdEntity = entity;
    }

    @Override
    public void func_70636_d() {
        super.func_70636_d();
        if (!this.field_70170_p.field_72995_K && this.field_70173_aa > 1) {
            if (this.creator_UUID == null) {
                this.func_70106_y();
            } else if (this.holdEntity != null) {
                if (this.holdEntity.field_70128_L) {
                    this.explosionEffect();
                } else {
                    this.func_70634_a(this.holdEntity.field_70165_t, this.holdEntity.field_70163_u + (double)this.holdEntity.field_70131_O, this.holdEntity.field_70161_v);
                }
            } else if (this.field_70170_p.func_175623_d(this.holdPos)) {
                this.explosionEffect();
            }
        }
    }

    public void explosionEffect() {
        CustomParticleConfig config1 = new CustomParticleConfig();
        config1.createInstance().setParticle(ParticleInit.EXPLOSION).setIgnoreRange(true);
        IParticleSpawner.spawnParticle(this.field_70170_p, config1, this.field_70165_t, this.field_70163_u, this.field_70161_v);
        this.func_184185_a(SoundInit.GENERIC_WEAPON_5, 4.0f, 1.0f);
        for (LivingEntity target : this.field_70170_p.func_72872_a(LivingEntity.class, this.func_174813_aQ().func_72314_b(6.0, 6.0, 6.0))) {
            if (target.func_110124_au().equals(this.creator_UUID) || target.func_110124_au().equals(this.func_110124_au())) continue;
            IMaxAttack.dealMaxHealth((Entity)this, target, 2);
        }
        this.func_70106_y();
    }
}

