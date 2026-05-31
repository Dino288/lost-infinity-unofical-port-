/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.IEntityOwnable
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.misc;

import java.util.UUID;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.IEntityOwnable;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.base.EntityImmaterial;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class EntityStormBomb
extends EntityImmaterial
implements IMaxAttack {
    private UUID creator_UUID = null;

    public EntityStormBomb(Level worldIn) {
        super(worldIn);
        this.func_70105_a(0.25f, 0.25f);
        this.func_189654_d(false);
    }

    public void setCreator(UUID uuid) {
        this.creator_UUID = uuid;
    }

    @Override
    public void func_70636_d() {
        super.func_70636_d();
        if (!this.field_70170_p.field_72995_K && this.field_70173_aa >= 3 && !this.field_70128_L) {
            this.explosionEffect();
        }
    }

    public void explosionEffect() {
        if (this.creator_UUID != null) {
            CustomParticleConfig config1 = new CustomParticleConfig();
            config1.setCount(3);
            config1.createInstance().setParticle(ParticleInit.ELECTRIC_EXPLOSION_BLUE).setSpread(2.0, 1.0, 2.0).setIgnoreRange(true);
            config1.createInstance().setParticle(ParticleInit.ELECTRIC_EXPLOSION_YELLOW).setSpread(2.0, 1.0, 2.0).setIgnoreRange(true);
            IParticleSpawner.spawnParticle(this.field_70170_p, config1, this.field_70165_t, this.field_70163_u, this.field_70161_v);
            this.func_184185_a(SoundInit.GENERIC_WEAPON_13, 1.0f, 0.7f + 0.6f * this.field_70146_Z.nextFloat());
            for (LivingEntity target : this.field_70170_p.func_72872_a(LivingEntity.class, this.func_174813_aQ().func_72314_b(5.0, 3.0, 5.0))) {
                if (target.func_110124_au().equals(this.creator_UUID) || target instanceof IEntityOwnable && ((IEntityOwnable)target).func_184753_b() != null && ((IEntityOwnable)target).func_184753_b().equals(this.creator_UUID)) continue;
                IMaxAttack.dealTrueDamage((Entity)this, target, target.func_110138_aP() * 0.5f);
            }
        }
        this.func_70106_y();
    }
}

