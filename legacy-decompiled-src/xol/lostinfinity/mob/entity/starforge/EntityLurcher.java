/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.starforge;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.PotionInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.ai.EntityAIFloatAttack;
import xol.lostinfinity.mob.entity.base.EntityFloatingBase;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.load.LootTableRegistry;

public class EntityLurcher
extends EntityFloatingBase
implements IMaxAttack {
    public EntityLurcher(Level worldIn) {
        super(worldIn);
        this.func_70105_a(1.2f, 0.8f);
        this.rawFlySpeed = 0.85f;
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null) {
            if (IMaxAttack.dealMaxHealth((Entity)this, this.func_70638_az(), 2).didSuccessfulHit()) {
                this.func_70638_az().func_70690_d(new PotionEffect(PotionInit.SHATTERED, 120));
            }
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
            if (this.field_70173_aa % 80 == 0) {
                this.func_70024_g((target.field_70165_t - this.field_70165_t) * 0.1, (target.field_70163_u - this.field_70163_u) * 0.1, (target.field_70161_v - this.field_70161_v) * 0.1);
                this.field_70133_I = true;
                this.func_184185_a(SoundInit.LURCHER_ABILITY, 1.0f, 0.8f + 0.4f * this.field_70146_Z.nextFloat());
            }
        }
    }

    @Override
    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(4000.0);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.25);
        this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a(1.0);
    }

    protected SoundEvent func_184615_bR() {
        return SoundInit.LURCHER_DEATH;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundInit.LURCHER_HURT;
    }

    protected SoundEvent func_184639_G() {
        return SoundInit.LURCHER_AMBIENT;
    }

    @Override
    protected int numberOfLives() {
        return 10;
    }

    protected ResourceLocation func_184647_J() {
        return LootTableRegistry.ENTITIES_LURCHER;
    }

    @Override
    protected EntityAIFloatAttack createShootAI() {
        return null;
    }
}

