/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.deviant.titan;

import net.minecraft.world.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.Level;
import xol.lostinfinity.mob.entity.base.EntityDeviantTitan;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.load.LootTableRegistry;

public class EntityTitanVex
extends EntityDeviantTitan
implements IMaxAttack {
    public EntityTitanVex(Level worldIn) {
        super(worldIn);
        this.func_70105_a(2.0f, 3.8f);
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.4);
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(2000.0);
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null) {
            IMaxAttack.dealMaxHealth((Entity)this, this.func_70638_az(), 2);
            return true;
        }
        return false;
    }

    public void func_70636_d() {
        super.func_70636_d();
        this.field_70143_R = -1.0f;
        if (this.func_70638_az() != null && !this.field_70170_p.field_72995_K && this.func_70638_az().field_70163_u > this.field_70163_u + 2.0) {
            this.field_70181_x = 0.45;
            this.func_70024_g(Math.signum(this.func_70638_az().field_70165_t - this.field_70165_t) * 0.08, 0.0, Math.signum(this.func_70638_az().field_70161_v - this.field_70161_v) * 0.08);
        }
    }

    protected SoundEvent func_184615_bR() {
        return SoundEvents.field_191266_he;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundEvents.field_191267_hf;
    }

    protected SoundEvent func_184639_G() {
        return SoundEvents.field_191264_hc;
    }

    protected ResourceLocation func_184647_J() {
        return this.onFinalLife() ? LootTableRegistry.ENTITIES_TITAN_VEX : null;
    }
}

