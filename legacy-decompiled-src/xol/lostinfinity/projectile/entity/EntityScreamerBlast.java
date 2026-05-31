/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.world.World
 */
package xol.lostinfinity.projectile.entity;

import java.util.Arrays;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityScreamerBlast
extends EntityBaseThrowable {
    private boolean redirected = false;

    public EntityScreamerBlast(Level par1World) {
        super(par1World);
        this.func_70105_a(0.75f, 0.75f);
    }

    public EntityScreamerBlast(Level par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
        this.func_70105_a(0.75f, 0.75f);
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (!this.field_70170_p.field_72995_K) {
            if (result.field_72308_g != null && this.func_85052_h() != null && result.field_72308_g != this.func_85052_h() && result.field_72308_g instanceof LivingEntity) {
                IMaxAttack.dealMaxHealth((Entity)this, (LivingEntity)result.field_72308_g, 10, Arrays.asList("Darkborn", "Aquatic"));
            }
            this.func_70106_y();
        }
    }

    protected float func_70185_h() {
        return 0.0f;
    }

    @Override
    public void func_70071_h_() {
        super.func_70071_h_();
        if (this.field_70170_p.field_72995_K) {
            this.field_70170_p.func_175688_a(this.field_70173_aa >= 26 ? ParticleInit.EXPLOSION_BLUE : ParticleInit.GLOOM_SPELL, this.field_70165_t + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * (double)this.field_70131_O - 0.25, this.field_70161_v + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, 0.0, 0.0, 0.0, new int[0]);
        } else if (this.field_70173_aa > 30) {
            if (!this.redirected) {
                Player player = this.field_70170_p.func_72890_a((Entity)this, 70.0);
                if (player != null) {
                    double d2 = player.field_70165_t - this.field_70165_t;
                    double d3 = player.func_174813_aQ().field_72338_b + (double)(player.field_70131_O / 2.0f) - this.field_70163_u;
                    double d4 = player.field_70161_v - this.field_70161_v;
                    this.func_70186_c(d2, d3, d4, 1.7f, 0.0f);
                    this.field_70133_I = true;
                    this.redirected = true;
                    for (Player contender : this.field_70170_p.func_72872_a(Player.class, new AABB(this.func_180425_c()).func_186662_g(25.0))) {
                        this.field_70170_p.func_184133_a(null, contender.func_180425_c(), SoundInit.LASER_WEAPON_2, SoundSource.HOSTILE, 0.6f, 0.8f + this.field_70146_Z.nextFloat() * 0.4f);
                    }
                } else {
                    this.func_70106_y();
                }
            }
        } else {
            this.field_70181_x *= (double)0.97f;
            this.field_70133_I = true;
        }
    }
}

