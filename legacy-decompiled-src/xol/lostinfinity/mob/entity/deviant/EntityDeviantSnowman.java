/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.math.Mth
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.deviant;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import xol.lostinfinity.mob.entity.base.EntityDeviantMob;
import xol.lostinfinity.projectile.entity.EntityDeviantSnowball;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.load.LootTableRegistry;

public class EntityDeviantSnowman
extends EntityDeviantMob {
    public EntityDeviantSnowman(Level worldIn) {
        super(worldIn);
        this.func_70105_a(2.2f, 5.0f);
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.35);
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(800.0);
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null) {
            IMaxAttack.dealMaxHealth((Entity)this, this.func_70638_az(), 5);
            return true;
        }
        return false;
    }

    protected SoundEvent func_184615_bR() {
        return SoundEvents.field_187801_fC;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundEvents.field_187803_fD;
    }

    protected SoundEvent func_184639_G() {
        return SoundEvents.field_187799_fB;
    }

    public void func_70636_d() {
        super.func_70636_d();
        this.field_70143_R = -1.0f;
        LivingEntity target = this.func_70638_az();
        if (!this.field_70170_p.field_72995_K && this.field_70173_aa % (8 - this.getMutation()) == 0 && this.field_70181_x > 0.0) {
            for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.func_174813_aQ().func_72314_b(24.0, 24.0, 24.0))) {
                EntityDeviantSnowball shot = new EntityDeviantSnowball(this.field_70170_p, (LivingEntity)this);
                double d0 = near_pl.field_70165_t - this.field_70165_t;
                double d1 = near_pl.func_174813_aQ().field_72338_b + (double)(near_pl.field_70131_O / 6.0f) - shot.field_70163_u;
                double d2 = near_pl.field_70161_v - this.field_70161_v;
                double d3 = Mth.func_76133_a((double)(d0 * d0 + d2 * d2));
                shot.func_70186_c(d0, d1 + d3 * (double)0.2f, d2, 2.0f, 0.0f);
                this.field_70170_p.func_72838_d((Entity)shot);
            }
            this.func_184185_a(SoundEvents.field_187797_fA, 1.0f, 1.0f);
        }
        if (this.field_70173_aa % 60 == 0 && this.func_70638_az() != null && this.func_70638_az() instanceof LivingEntity) {
            LivingEntity pl = this.func_70638_az();
            this.func_70024_g((pl.field_70165_t - this.field_70165_t) * 0.145, 2.2, (pl.field_70161_v - this.field_70161_v) * 0.145);
            this.field_70133_I = true;
        }
    }

    @Override
    protected ResourceLocation deviantDrop() {
        return LootTableRegistry.ENTITIES_DEVIANTSNOWMAN;
    }

    @Override
    protected ResourceLocation superMutatedDrop() {
        return LootTableRegistry.ENTITIES_SUPERMUTANT_SNOWMAN;
    }
}

