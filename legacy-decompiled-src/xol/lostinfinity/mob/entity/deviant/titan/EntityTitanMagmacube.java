/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.EnumParticleTypes
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.math.Mth
 *  net.minecraft.world.World
 *  net.minecraft.world.ServerLevel
 */
package xol.lostinfinity.mob.entity.deviant.titan;

import net.minecraft.world.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import xol.lostinfinity.mob.entity.base.EntityDeviantTitan;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.load.LootTableRegistry;

public class EntityTitanMagmacube
extends EntityDeviantTitan
implements IMaxAttack {
    public EntityTitanMagmacube(Level worldIn) {
        super(worldIn);
        this.func_70105_a(4.0f, 4.0f);
        this.func_189654_d(true);
    }

    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(0.5);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.35);
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(1500.0);
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null) {
            IMaxAttack.dealMaxHealth((Entity)this, this.func_70638_az(), 3);
            return true;
        }
        return false;
    }

    public void func_70636_d() {
        super.func_70636_d();
        if (this.field_70173_aa % 30 == 0) {
            this.func_70024_g(0.0, 2.0, 0.0);
            this.func_184185_a(SoundEvents.field_187762_di, 1.0f, 0.5f + this.field_70146_Z.nextFloat());
        }
        this.field_70181_x -= 0.25;
        float scl = 4.5f + Mth.func_76126_a((float)((float)this.field_70173_aa * 0.1f));
        this.func_70105_a(scl, scl);
    }

    public void func_180430_e(float distance, float damageMultiplier) {
        if (!this.field_70170_p.field_72995_K) {
            for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.func_174813_aQ().func_72314_b(20.0, 20.0, 20.0))) {
                if (near_pl.func_184812_l_()) continue;
                near_pl.func_70024_g(Math.signum(this.field_70165_t - near_pl.field_70165_t) * 0.5, Math.signum(this.field_70163_u - near_pl.field_70163_u) * 0.5, Math.signum(this.field_70161_v - near_pl.field_70161_v) * 0.5);
                near_pl.field_70133_I = true;
            }
            ((ServerLevel)this.field_70170_p).func_175739_a(EnumParticleTypes.SWEEP_ATTACK, this.field_70165_t, this.field_70163_u, this.field_70161_v, 5, this.field_70146_Z.nextDouble() * 3.0, 0.3, this.field_70146_Z.nextDouble() * 3.0, (double)0.15f, new int[0]);
        }
    }

    protected SoundEvent func_184615_bR() {
        return SoundEvents.field_187758_dg;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundEvents.field_187760_dh;
    }

    protected SoundEvent func_184639_G() {
        return SoundEvents.field_187764_dj;
    }

    protected ResourceLocation func_184647_J() {
        return this.onFinalLife() ? LootTableRegistry.ENTITIES_TITAN_MAGMACUBE : null;
    }
}

