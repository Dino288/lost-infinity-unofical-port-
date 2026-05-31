/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.MobEffects
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.EnumParticleTypes
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.math.Mth
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.deviant;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.init.MobEffects;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import xol.lostinfinity.mob.entity.base.EntityDeviantMob;
import xol.lostinfinity.projectile.entity.EntitySkullShot;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityDeviantAmalgam
extends EntityDeviantMob
implements IMaxAttack {
    private boolean animationState = false;
    private boolean cageVisible = false;

    public EntityDeviantAmalgam(Level worldIn) {
        super(worldIn);
        this.func_70105_a(3.0f, 5.5f);
    }

    @Override
    public boolean func_180427_aV() {
        return true;
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.54);
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(2000.0);
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null) {
            IMaxAttack.dealMaxHealth((Entity)this, this.func_70638_az(), 6 - this.getMutation());
            return true;
        }
        return false;
    }

    protected SoundEvent func_184615_bR() {
        return SoundEvents.field_187530_aT;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundEvents.field_187864_fh;
    }

    protected SoundEvent func_184639_G() {
        return SoundEvents.field_187773_eO;
    }

    public void func_70636_d() {
        super.func_70636_d();
        LivingEntity target = this.func_70638_az();
        if (this.field_70173_aa % (12 - 2 * this.getMutation()) == 0 && target != null) {
            if (!this.field_70170_p.field_72995_K) {
                EntitySkullShot shot = new EntitySkullShot(this.field_70170_p, (LivingEntity)this);
                double d0 = target.field_70165_t - this.field_70165_t;
                double d1 = target.func_174813_aQ().field_72338_b + (double)(target.field_70131_O / 6.0f) - shot.field_70163_u;
                double d2 = target.field_70161_v - this.field_70161_v;
                double d3 = Mth.func_76133_a((double)(d0 * d0 + d2 * d2));
                shot.func_70186_c(d0, d1 + d3 * (double)0.2f, d2, 2.0f, 0.0f);
                this.field_70170_p.func_72838_d((Entity)shot);
            }
            this.func_184185_a(SoundEvents.field_193784_dd, 1.0f, 1.0f);
        }
        if (this.animationState) {
            if (this.field_70173_aa % 3 == 0) {
                boolean bl = this.cageVisible = !this.cageVisible;
            }
            if (this.field_70173_aa % (50 - this.getMutation() * 7) == 0) {
                this.cageVisible = false;
                this.animationState = false;
                if (!this.field_70170_p.field_72995_K) {
                    this.field_70170_p.func_72876_a(null, this.field_70165_t, this.field_70163_u, this.field_70161_v, 9.0f, false);
                    double range = 4.0 + (double)(5 * this.getMutation());
                    for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.func_174813_aQ().func_72314_b(range, range, range))) {
                        if (near_pl.func_184812_l_()) continue;
                        IMaxAttack.dealMaxHealth((Entity)this, (LivingEntity)near_pl, 5 - this.getMutation());
                    }
                }
            }
        } else if (this.field_70173_aa % (100 - this.getMutation() * 14) == 0) {
            this.animationState = true;
            this.func_184185_a(SoundEvents.field_187572_ar, 2.0f, 1.0f);
        }
        if (this.field_70173_aa % 120 == 0) {
            if (this.field_70170_p.field_72995_K) {
                for (int i = 0; i < 14; ++i) {
                    this.field_70170_p.func_175688_a(EnumParticleTypes.SPELL_WITCH, this.field_70165_t + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * (double)this.field_70131_O - 0.25, this.field_70161_v + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, (this.field_70146_Z.nextDouble() - 0.5) * 2.0, -this.field_70146_Z.nextDouble(), (this.field_70146_Z.nextDouble() - 0.5) * 2.0, new int[0]);
                }
            }
            this.field_70170_p.func_184134_a(this.field_70165_t, this.field_70163_u, this.field_70161_v, SoundEvents.field_187534_aX, SoundSource.HOSTILE, 1.5f, 0.5f + this.field_70170_p.field_73012_v.nextFloat(), true);
            this.func_70690_d(new PotionEffect(MobEffects.field_76441_p, 40));
        }
        if (this.func_82150_aj() && this.field_70170_p.field_72995_K) {
            this.field_70170_p.func_175688_a(EnumParticleTypes.SPELL, this.field_70165_t + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N * 3.0, this.field_70163_u + this.field_70146_Z.nextDouble() * (double)this.field_70131_O - 0.25, this.field_70161_v + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N * 3.0, (this.field_70146_Z.nextDouble() - 0.5) * 2.0, -this.field_70146_Z.nextDouble(), (this.field_70146_Z.nextDouble() - 0.5) * 2.0, new int[0]);
        }
    }

    public boolean getCageVisible() {
        return this.cageVisible;
    }

    @Override
    protected int numberOfLives() {
        return this.getMutation() == 0 ? 8 : 4;
    }
}

