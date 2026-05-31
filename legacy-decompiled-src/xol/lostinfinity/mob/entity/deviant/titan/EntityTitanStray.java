/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.deviant.titan;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.Level;
import xol.lostinfinity.mob.entity.base.EntityDeviantTitan;
import xol.lostinfinity.projectile.entity.EntitySkullShot;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.load.LootTableRegistry;

public class EntityTitanStray
extends EntityDeviantTitan {
    public EntityTitanStray(Level worldIn) {
        super(worldIn);
        this.func_70105_a(3.0f, 8.0f);
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.32);
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(2500.0);
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null) {
            IMaxAttack.dealMaxHealth((Entity)this, this.func_70638_az(), 3);
            return true;
        }
        return false;
    }

    protected SoundEvent func_184615_bR() {
        return SoundEvents.field_190033_gv;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundEvents.field_190034_gw;
    }

    protected SoundEvent func_184639_G() {
        return SoundEvents.field_190032_gu;
    }

    public void func_70636_d() {
        super.func_70636_d();
        LivingEntity target = this.func_70638_az();
        if (this.field_70173_aa % 7 == 0 && target != null) {
            if (!this.field_70170_p.field_72995_K) {
                for (int i = 0; i < 8 + this.field_70170_p.field_73012_v.nextInt(4); ++i) {
                    EntitySkullShot shot = new EntitySkullShot(this.field_70170_p, target.field_70165_t - 4.0 + this.field_70170_p.field_73012_v.nextDouble() * 8.0, target.field_70163_u + 15.0, target.field_70161_v - 4.0 + this.field_70170_p.field_73012_v.nextDouble() * 8.0, 1.0f);
                    shot.setThrower((LivingEntity)this);
                    shot.func_70186_c(0.0, -0.05, 0.0, 0.7f, 0.0f);
                    this.field_70170_p.func_72838_d((Entity)shot);
                }
            }
            this.func_184185_a(SoundEvents.field_193784_dd, 1.0f, 1.0f);
        }
    }

    protected ResourceLocation func_184647_J() {
        return this.onFinalLife() ? LootTableRegistry.ENTITIES_TITAN_STRAY : null;
    }
}

