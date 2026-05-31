/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.world.World
 */
package xol.lostinfinity.projectile.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.base.EntityParticleTrojan;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class EntityFearBomb
extends EntityBaseThrowable {
    private boolean splitting = false;

    public EntityFearBomb(Level par1World) {
        super(par1World);
    }

    public EntityFearBomb(Level par1World, LivingEntity par2Mob) {
        super(par1World, par2Mob);
    }

    public EntityFearBomb(Level par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
    }

    public void setSplitting() {
        this.splitting = true;
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (!this.field_70170_p.field_72995_K) {
            UUID thrower_uuid = null;
            if (this.func_85052_h() != null) {
                thrower_uuid = this.func_85052_h().func_110124_au();
            }
            List caughtCreatures = this.field_70170_p.func_72872_a(LivingEntity.class, this.func_174813_aQ().func_72314_b(4.0, 4.0, 4.0));
            ArrayList<LivingEntity> damageableCreatures = new ArrayList<LivingEntity>();
            for (LivingEntity creature : caughtCreatures) {
                if (creature instanceof EntityParticleTrojan || creature.equals((Object)this.func_85052_h())) continue;
                damageableCreatures.add(creature);
            }
            for (LivingEntity target : damageableCreatures) {
                if (target.func_110124_au().equals(thrower_uuid)) continue;
                IMaxAttack.dealMaxHealth((Entity)this, target, 10, 4 + 3 * (damageableCreatures.size() - 1));
            }
            CustomParticleConfig config1 = new CustomParticleConfig();
            config1.createInstance().setParticle(ParticleInit.EXPLOSION_RING).setSpread(2.0, 1.0, 2.0).setCount(3).setIgnoreRange(true);
            IParticleSpawner.spawnParticle(this.field_70170_p, config1, this.field_70165_t, this.field_70163_u, this.field_70161_v);
            this.func_184185_a(SoundInit.GENERIC_WEAPON_6, 1.0f, 0.8f + 0.4f * this.field_70146_Z.nextFloat());
            this.func_70106_y();
        }
    }

    protected float func_70185_h() {
        return 0.05f;
    }

    @Override
    public void func_70071_h_() {
        super.func_70071_h_();
        if (this.field_70170_p.field_72995_K) {
            for (int i = 0; i < 2; ++i) {
                this.field_70170_p.func_175688_a(ParticleInit.FLAME_LARGE, this.field_70165_t + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * (double)this.field_70131_O - 0.25, this.field_70161_v + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, (this.field_70146_Z.nextDouble() - 0.5) * 2.0, -this.field_70146_Z.nextDouble(), (this.field_70146_Z.nextDouble() - 0.5) * 2.0, new int[0]);
            }
        } else if (!this.field_70128_L && this.splitting && this.field_70173_aa >= 15 && this.func_85052_h() != null) {
            for (int i = 0; i < 12; ++i) {
                EntityFearBomb split = new EntityFearBomb(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v);
                split.setThrower(this.func_85052_h());
                split.func_70186_c(this.field_70159_w, this.field_70181_x, this.field_70179_y, 1.5f, 20.0f);
                this.field_70170_p.func_72838_d((Entity)split);
            }
            this.func_184185_a(SoundInit.GENERIC_POP, 1.5f, 1.0f);
            this.func_70106_y();
        }
    }
}

