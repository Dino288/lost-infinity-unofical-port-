/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.world.World
 */
package xol.lostinfinity.projectile.entity;

import java.util.Arrays;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;
import xol.lostinfinity.projectile.entity.EntityMiniChakram;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityIonicChakram
extends EntityBaseThrowable {
    public EntityIonicChakram(Level par1World) {
        super(par1World);
        this.func_70105_a(0.75f, 0.75f);
    }

    public EntityIonicChakram(Level par1World, LivingEntity par2Mob) {
        super(par1World, par2Mob);
        this.func_70105_a(0.75f, 0.75f);
    }

    public EntityIonicChakram(Level par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
        this.func_70105_a(0.75f, 0.75f);
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (!this.field_70170_p.field_72995_K) {
            if (result.field_72308_g != null && this.func_85052_h() != null) {
                LivingEntity thrower = this.func_85052_h();
                if (result.field_72308_g instanceof LivingEntity && !result.field_72308_g.func_110124_au().equals(thrower.func_110124_au())) {
                    IMaxAttack.dealTrueDamage((Entity)thrower, (LivingEntity)result.field_72308_g, ((LivingEntity)result.field_72308_g).func_110138_aP() * 0.33f, Arrays.asList("Darkborn"));
                    this.split();
                    return;
                }
            }
            if (this.field_70192_c == null) {
                this.func_70106_y();
            }
            if (result.field_72308_g != null || this.field_70170_p.func_180495_p(result.func_178782_a()).func_185904_a().func_76230_c()) {
                this.split();
            }
        }
    }

    private void split() {
        Vec3 dir = new Vec3(1.0, 0.0, 1.0);
        for (int i = 0; i < 8; ++i) {
            Vec3 rotated = this.rotVecAboutY(dir, Math.PI * (double)i / 4.0);
            EntityMiniChakram shot = new EntityMiniChakram(this.field_70170_p, this.field_70192_c);
            shot.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
            if (i == 0) {
                shot.setMaster();
            }
            shot.func_70186_c(rotated.field_72450_a, rotated.field_72448_b, rotated.field_72449_c, 0.9f, 0.0f);
            this.field_70170_p.func_72838_d((Entity)shot);
        }
        this.field_70170_p.func_184133_a(null, this.func_180425_c(), SoundInit.GENERIC_WEAPON_19, SoundSource.PLAYERS, 1.5f, 0.5f);
        this.field_70170_p.func_184133_a(null, this.func_180425_c(), SoundInit.GENERIC_WEAPON_20, SoundSource.PLAYERS, 1.5f, 1.0f);
        this.func_70106_y();
    }

    private Vec3 rotVecAboutY(Vec3 vec, double rad) {
        double x = vec.field_72450_a * Math.cos(rad) + vec.field_72449_c * Math.sin(rad);
        double y = vec.field_72448_b;
        double z = -vec.field_72450_a * Math.sin(rad) + vec.field_72449_c * Math.cos(rad);
        return new Vec3(x, y, z);
    }

    @Override
    public void func_70071_h_() {
        super.func_70071_h_();
        if (!this.field_70170_p.field_72995_K) {
            this.field_70159_w *= 0.96;
            this.field_70181_x *= 0.96;
            this.field_70179_y *= 0.96;
            this.field_70133_I = true;
            if (this.field_70173_aa > 40 && this.func_85052_h() != null) {
                this.split();
            }
        } else {
            this.field_70170_p.func_175688_a(ParticleInit.GENERIC_DOT_ORANGE, this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.25 * (-0.5 + this.field_70146_Z.nextDouble()), 0.0, 0.25 * (-0.5 + this.field_70146_Z.nextDouble()), new int[0]);
        }
    }

    protected float func_70185_h() {
        return 0.0f;
    }
}

