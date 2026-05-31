/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.projectile.EntityArrow
 *  net.minecraft.entity.projectile.EntityFireball
 *  net.minecraft.entity.projectile.EntityShulkerBullet
 *  net.minecraft.entity.projectile.EntityThrowable
 *  net.minecraft.util.EnumParticleTypes
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.world.World
 */
package xol.lostinfinity.projectile.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.projectile.EntityShulkerBullet;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityProjectileKiller
extends EntityBaseThrowable {
    private int timer = 20;

    public EntityProjectileKiller(Level par1World) {
        super(par1World);
        this.func_70105_a(0.75f, 0.75f);
    }

    public EntityProjectileKiller(Level par1World, LivingEntity par2Mob) {
        super(par1World, par2Mob);
        this.func_70105_a(0.75f, 0.75f);
    }

    public EntityProjectileKiller(Level par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
        this.func_70105_a(0.75f, 0.75f);
    }

    public void shortTimer() {
        this.timer = 5;
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (!this.field_70170_p.field_72995_K) {
            this.func_70106_y();
        }
    }

    @Override
    public void func_70071_h_() {
        super.func_70071_h_();
        if (this.field_70170_p.field_72995_K) {
            for (int k = 0; k < 2; ++k) {
                this.field_70170_p.func_175688_a(EnumParticleTypes.DRIP_LAVA, this.field_70165_t + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * (double)this.field_70131_O - 0.25, this.field_70161_v + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, (this.field_70146_Z.nextDouble() - 0.5) * 2.0, -this.field_70146_Z.nextDouble(), (this.field_70146_Z.nextDouble() - 0.5) * 2.0, new int[0]);
            }
        } else {
            if (this.timer == 0) {
                for (Entity proj : this.field_70170_p.func_72872_a(Entity.class, this.func_174813_aQ().func_72314_b(15.0, 15.0, 15.0))) {
                    if (!(proj instanceof EntityThrowable) && !(proj instanceof EntityArrow) && !(proj instanceof EntityFireball) && !(proj instanceof EntityShulkerBullet)) continue;
                    this.vaporizeProjectile(this.field_70170_p, proj);
                }
                this.field_70170_p.func_72876_a((Entity)this, this.field_70165_t, this.field_70163_u, this.field_70161_v, 3.0f, false);
                this.func_70106_y();
            }
            --this.timer;
        }
    }

    protected float func_70185_h() {
        return 0.0f;
    }

    private void vaporizeProjectile(Level world, Entity projectile) {
        world.func_184133_a(null, new BlockPos(projectile.field_70165_t, projectile.field_70163_u, projectile.field_70161_v), SoundInit.ITEM_AXIOMAVORUM, SoundSource.MASTER, 2.0f, 1.0f);
        if (!world.field_72995_K) {
            if (this.func_85052_h() != null) {
                if (projectile instanceof EntityThrowable) {
                    EntityThrowable thrown_proj = (EntityThrowable)projectile;
                    if (thrown_proj.func_85052_h() != null && !thrown_proj.func_85052_h().func_110124_au().equals(this.func_85052_h().func_110124_au())) {
                        IMaxAttack.dealMaxHealth((Entity)this, thrown_proj.func_85052_h(), 3);
                    }
                } else if (projectile instanceof EntityFireball) {
                    EntityFireball thrown_proj = (EntityFireball)projectile;
                    if (thrown_proj.field_70235_a != null) {
                        IMaxAttack.dealMaxHealth((Entity)this, thrown_proj.field_70235_a, 3);
                    }
                } else if (projectile instanceof EntityArrow) {
                    EntityArrow thrown_proj = (EntityArrow)projectile;
                    if (thrown_proj.field_70250_c != null && thrown_proj.field_70250_c instanceof LivingEntity) {
                        IMaxAttack.dealMaxHealth((Entity)this, (LivingEntity)thrown_proj.field_70250_c, 3);
                    }
                }
                projectile.func_70106_y();
            }
        } else {
            for (int i = 0; i < 2; ++i) {
                world.func_175688_a(EnumParticleTypes.LAVA, projectile.field_70165_t, projectile.field_70163_u, projectile.field_70161_v, (world.field_73012_v.nextDouble() - 0.5) * 2.0, -world.field_73012_v.nextDouble(), (world.field_73012_v.nextDouble() - 0.5) * 2.0, new int[0]);
            }
        }
    }
}

