/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.world.World
 */
package xol.lostinfinity.projectile.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.PotionInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;
import xol.lostinfinity.util.data.CustomDamageResult;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class EntityMortarShot
extends EntityBaseThrowable {
    public EntityMortarShot(Level par1World) {
        super(par1World);
        this.func_70105_a(0.25f, 0.25f);
    }

    public EntityMortarShot(Level par1World, LivingEntity par2Mob) {
        super(par1World, par2Mob);
        this.func_70105_a(0.75f, 0.75f);
    }

    public EntityMortarShot(Level par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
        this.func_70105_a(0.75f, 0.75f);
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (!this.field_70170_p.field_72995_K) {
            if (this.func_85052_h() != null) {
                for (LivingEntity target : this.field_70170_p.func_72872_a(LivingEntity.class, this.func_174813_aQ().func_186662_g(12.0))) {
                    CustomDamageResult dr;
                    if (target.func_110124_au().equals(this.field_70192_c.func_110124_au()) || target.equals((Object)this.getSecondaryThrower()) || (dr = IMaxAttack.dealMaxHealth((Entity)this, target, 1)).wasTargetKilled() || !dr.didSuccessfulHit()) continue;
                    target.func_70690_d(new PotionEffect(PotionInit.SHATTERED, 300, 2));
                }
                CustomParticleConfig config1 = new CustomParticleConfig();
                config1.createInstance().setParticle(ParticleInit.EXPLOSION).setSpread(8.0, 2.0, 8.0).setCount(10).setIgnoreRange(true);
                IParticleSpawner.spawnParticle(this.field_70170_p, config1, this.field_70165_t, this.field_70163_u, this.field_70161_v);
                this.func_184185_a(SoundInit.GENERIC_WEAPON_10, 2.0f, 0.5f + 0.7f * this.field_70146_Z.nextFloat());
            }
            this.func_70106_y();
        }
    }

    protected float func_70185_h() {
        return 0.03f;
    }
}

