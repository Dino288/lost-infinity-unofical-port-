/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.misc;

import java.util.UUID;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.base.EntityImmaterial;
import xol.lostinfinity.mob.entity.boss.EntityThundyron;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class EntityThunderBomb
extends EntityImmaterial
implements IMaxAttack {
    private UUID creator_UUID;

    public EntityThunderBomb(Level worldIn) {
        super(worldIn);
        this.func_70105_a(0.5f, 0.5f);
        this.func_189654_d(false);
    }

    public void setCreator(UUID uuid) {
        this.creator_UUID = uuid;
    }

    @Override
    public void func_70636_d() {
        super.func_70636_d();
        if (!this.field_70170_p.field_72995_K && this.field_70173_aa >= 100 && !this.field_70128_L) {
            this.explosionEffect();
        }
    }

    public void explosionEffect() {
        CustomParticleConfig config1 = new CustomParticleConfig();
        config1.setCount(3);
        config1.createInstance().setParticle(ParticleInit.ELECTRIC_EXPLOSION_BLUE).setSpread(2.0, 1.0, 2.0).setIgnoreRange(true);
        config1.createInstance().setParticle(ParticleInit.ELECTRIC_EXPLOSION_YELLOW).setSpread(2.0, 1.0, 2.0).setIgnoreRange(true);
        IParticleSpawner.spawnParticle(this.field_70170_p, config1, this.field_70165_t, this.field_70163_u, this.field_70161_v);
        this.func_184185_a(SoundInit.GENERIC_WEAPON_5, 4.0f, 1.0f);
        for (LivingEntity target : this.field_70170_p.func_72872_a(LivingEntity.class, this.func_174813_aQ().func_72314_b(3.0, 3.0, 3.0))) {
            if (target instanceof EntityThunderBomb || target instanceof EntityThundyron) continue;
            IMaxAttack.dealMaxHealth((Entity)this, target, 2);
        }
        this.func_70106_y();
    }
}

