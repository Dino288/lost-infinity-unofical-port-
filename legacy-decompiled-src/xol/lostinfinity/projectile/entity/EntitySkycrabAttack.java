/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.world.World
 */
package xol.lostinfinity.projectile.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class EntitySkycrabAttack
extends EntityBaseThrowable {
    private Player crabOwner = null;

    public EntitySkycrabAttack(Level par1World) {
        super(par1World);
        this.func_70105_a(1.0f, 1.0f);
    }

    public EntitySkycrabAttack(Level par1World, LivingEntity par2Mob) {
        super(par1World, par2Mob);
        this.func_70105_a(1.0f, 1.0f);
    }

    public EntitySkycrabAttack(Level par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
        this.func_70105_a(1.0f, 1.0f);
    }

    @Override
    public void setThrower(LivingEntity throwset) {
        this.field_70192_c = throwset;
    }

    public void setCrabOwner(Player player) {
        this.crabOwner = player;
    }

    private Player getCrabOwner() {
        return this.crabOwner;
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (!this.field_70170_p.field_72995_K) {
            if (this.getCrabOwner() != null && this.func_85052_h() != null) {
                for (LivingEntity target : this.field_70170_p.func_72872_a(LivingEntity.class, this.func_174813_aQ().func_72314_b(4.0, 4.0, 4.0))) {
                    if (target.func_110124_au().equals(this.crabOwner.func_110124_au()) || target.func_110124_au().equals(this.func_85052_h().func_110124_au())) continue;
                    IMaxAttack.dealMaxHealth((Entity)this.func_85052_h(), target, 4, 2.0f);
                }
            }
            CustomParticleConfig config1 = new CustomParticleConfig();
            config1.createInstance().setParticle(ParticleInit.EXPLOSION_RING).setSpread(2.0, 1.0, 2.0).setCount(3).setIgnoreRange(true);
            IParticleSpawner.spawnParticle(this.field_70170_p, config1, this.field_70165_t, this.field_70163_u, this.field_70161_v);
            this.func_184185_a(SoundInit.GENERIC_WEAPON_6, 1.0f, 0.8f + 0.4f * this.field_70146_Z.nextFloat());
            this.func_70106_y();
        }
    }

    protected float func_70185_h() {
        if (this.func_189652_ae()) {
            return 0.0f;
        }
        return 0.0366f;
    }

    @Override
    public void func_70071_h_() {
        super.func_70071_h_();
        if (this.field_70170_p.field_72995_K) {
            this.field_70170_p.func_175688_a(ParticleInit.LASER_FIZZLE_LARGE, this.field_70165_t + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * (double)this.field_70131_O - 0.25, this.field_70161_v + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, (this.field_70146_Z.nextDouble() - 0.5) * 2.0, -this.field_70146_Z.nextDouble(), (this.field_70146_Z.nextDouble() - 0.5) * 2.0, new int[0]);
        }
    }
}

