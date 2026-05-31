/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.util.math.HitResult$Type
 *  net.minecraft.world.World
 */
package xol.lostinfinity.projectile.cthulhu;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.Level;
import xol.lostinfinity.client.fx.ClientParticleRenderer;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.cthulhu.EntityCthulhu;
import xol.lostinfinity.mob.entity.cthulhu.ICthulhuMinion;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityCthulhuMeteor
extends EntityBaseThrowable {
    public EntityCthulhuMeteor(Level worldIn) {
        super(worldIn);
        this.func_70105_a(6.0f, 6.0f);
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (result.field_72313_a == HitResult.Type.BLOCK) {
            if (this.field_70170_p.field_72995_K) {
                CustomParticleConfig config1 = new CustomParticleConfig();
                config1.setOrigin(this.field_70165_t, this.field_70163_u, this.field_70161_v);
                config1.setCount(15);
                config1.createInstance().setParticle(ParticleInit.EXPLOSION_RED).setSpread(25.0, 4.0, 25.0).setIgnoreRange(true);
                config1.createInstance().setParticle(ParticleInit.EXPLOSION_ORANGE).setSpread(25.0, 4.0, 25.0).setIgnoreRange(true);
                ClientParticleRenderer.renderComplex(config1);
            } else {
                this.func_184185_a(SoundInit.ASTEROID_IMPACT, 2.0f, 0.5f + 0.7f * this.field_70146_Z.nextFloat());
            }
        }
    }

    @Override
    public void func_70071_h_() {
        block4: {
            block3: {
                super.func_70071_h_();
                if (this.field_70163_u < 0.0) {
                    this.func_70106_y();
                    return;
                }
                if (!this.field_70170_p.field_72995_K) break block3;
                for (int i = 0; i < 3; ++i) {
                    this.field_70170_p.func_175688_a(this.field_70146_Z.nextBoolean() ? ParticleInit.COSMIC_EXPLOSION_TYPE2 : ParticleInit.COSMIC_EXPLOSION_TYPE4, this.field_70165_t + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * (double)this.field_70131_O - 0.25, this.field_70161_v + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, (this.field_70146_Z.nextDouble() - 0.5) * 2.0, -this.field_70146_Z.nextDouble(), (this.field_70146_Z.nextDouble() - 0.5) * 2.0, new int[0]);
                    this.field_70170_p.func_175688_a(this.field_70146_Z.nextBoolean() ? ParticleInit.GENERIC_DOT_GREEN : ParticleInit.GENERIC_DOT_PURPLE, this.field_70165_t + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * (double)this.field_70131_O - 0.25, this.field_70161_v + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, (this.field_70146_Z.nextDouble() - 0.5) * 2.0, -this.field_70146_Z.nextDouble(), (this.field_70146_Z.nextDouble() - 0.5) * 2.0, new int[0]);
                }
                break block4;
            }
            if (this.field_70173_aa % 5 != 0) break block4;
            for (LivingEntity target : this.field_70170_p.func_72872_a(LivingEntity.class, this.func_174813_aQ().func_186662_g(4.0))) {
                if (target instanceof ICthulhuMinion || target instanceof EntityCthulhu || target == this.func_85052_h() || target == this.getSecondaryThrower()) continue;
                IMaxAttack.dealTrueDamage((Entity)this, target, target.func_110138_aP() * 0.1f);
            }
        }
    }

    protected float func_70185_h() {
        return 0.0f;
    }
}

