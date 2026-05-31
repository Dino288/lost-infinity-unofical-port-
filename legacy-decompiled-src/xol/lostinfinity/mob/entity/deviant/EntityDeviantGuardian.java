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
package xol.lostinfinity.mob.entity.deviant;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.Level;
import xol.lostinfinity.mob.ai.EntityAIFloatAttack;
import xol.lostinfinity.mob.entity.base.EntityFloatingDeviant;
import xol.lostinfinity.mob.entity.base.IConditionalDamage;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.load.LootTableRegistry;

public class EntityDeviantGuardian
extends EntityFloatingDeviant
implements IMaxAttack,
IConditionalDamage {
    public EntityDeviantGuardian(Level worldIn) {
        super(worldIn);
        this.func_70105_a(2.0f, 2.0f);
    }

    @Override
    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.4);
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(1500.0);
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null) {
            IMaxAttack.dealMaxHealth((Entity)this, this.func_70638_az(), 4 - this.getMutation());
            return true;
        }
        return false;
    }

    @Override
    public void func_70636_d() {
        super.func_70636_d();
        if (!this.field_70170_p.field_72995_K && this.func_70638_az() != null) {
            LivingEntity target = this.func_70638_az();
            this.func_70605_aq().func_75642_a(target.field_70165_t, target.field_70163_u, target.field_70161_v, 1.0);
        }
    }

    public boolean func_70648_aU() {
        return true;
    }

    protected SoundEvent func_184615_bR() {
        return SoundEvents.field_187678_ce;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundEvents.field_187687_ch;
    }

    protected SoundEvent func_184639_G() {
        return SoundEvents.field_187670_cb;
    }

    @Override
    protected ResourceLocation deviantDrop() {
        return LootTableRegistry.ENTITIES_DEVIANTGUARDIAN;
    }

    @Override
    protected ResourceLocation superMutatedDrop() {
        return LootTableRegistry.ENTITIES_SUPERMUTANT_GUARDIAN;
    }

    @Override
    protected EntityAIFloatAttack createShootAI() {
        return null;
    }

    @Override
    public boolean canBeDamaged(Entity attacker) {
        return this.func_70090_H() && attacker.func_70090_H();
    }
}

