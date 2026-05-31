/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.world.World
 */
package xol.lostinfinity.projectile.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class EntitySunstoneRock
extends EntityBaseThrowable {
    public EntitySunstoneRock(Level par1World) {
        super(par1World);
        this.func_70105_a(0.75f, 0.75f);
    }

    public EntitySunstoneRock(Level par1World, LivingEntity par2Mob) {
        super(par1World, par2Mob);
        this.func_70105_a(0.75f, 0.75f);
    }

    public EntitySunstoneRock(Level par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
        this.func_70105_a(0.75f, 0.75f);
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (!this.field_70170_p.field_72995_K) {
            if (result.field_72308_g == null) {
                BlockPos prev;
                BlockPos resultPos = result.func_178782_a();
                if (this.field_70170_p.func_180495_p(resultPos).func_177230_c() != BlockInit.sunstoneOre && this.field_70170_p.func_175623_d(prev = this.func_180425_c())) {
                    this.field_70170_p.func_175656_a(prev, BlockInit.sunstoneOre.func_176223_P());
                    if (this.func_85052_h() != null) {
                        for (LivingEntity target : this.field_70170_p.func_72872_a(LivingEntity.class, this.func_174813_aQ().func_186662_g(20.0))) {
                            if (target.func_110124_au().equals(this.field_70192_c.func_110124_au())) continue;
                            IMaxAttack.dealTrueDamage((Entity)this, target, target.func_110138_aP() * 0.75f);
                        }
                        CustomParticleConfig config1 = new CustomParticleConfig();
                        config1.setCount(5);
                        config1.createInstance().setParticle(ParticleInit.EXPLOSION_RED).setSpread(5.0, 2.0, 5.0).setIgnoreRange(true);
                        config1.createInstance().setParticle(ParticleInit.EXPLOSION_ORANGE).setSpread(5.0, 2.0, 5.0).setIgnoreRange(true);
                        IParticleSpawner.spawnParticle(this.field_70170_p, config1, this.field_70165_t, this.field_70163_u, this.field_70161_v);
                    }
                }
            } else if (result.field_72308_g instanceof LivingEntity) {
                LivingEntity targetHit = (LivingEntity)result.field_72308_g;
                IMaxAttack.dealMaxHealth((Entity)this, targetHit, 1);
                if (this.func_85052_h() != null) {
                    for (LivingEntity target : this.field_70170_p.func_72872_a(LivingEntity.class, this.func_174813_aQ().func_186662_g(20.0))) {
                        if (target.func_110124_au().equals(this.field_70192_c.func_110124_au())) continue;
                        IMaxAttack.dealTrueDamage((Entity)this, target, target.func_110138_aP() * 0.75f);
                    }
                    CustomParticleConfig config1 = new CustomParticleConfig();
                    config1.setCount(5);
                    config1.createInstance().setParticle(ParticleInit.EXPLOSION_RED).setSpread(5.0, 2.0, 5.0).setIgnoreRange(true);
                    config1.createInstance().setParticle(ParticleInit.EXPLOSION_ORANGE).setSpread(5.0, 2.0, 5.0).setIgnoreRange(true);
                    IParticleSpawner.spawnParticle(this.field_70170_p, config1, this.field_70165_t, this.field_70163_u, this.field_70161_v);
                }
            }
            this.func_70106_y();
        }
    }

    protected float func_70185_h() {
        return 0.0f;
    }
}

