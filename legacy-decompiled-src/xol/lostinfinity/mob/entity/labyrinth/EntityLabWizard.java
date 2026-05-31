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
 *  net.minecraft.util.math.Mth
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.labyrinth;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.base.EntityMultipleLives;
import xol.lostinfinity.projectile.entity.EntityWizardBlast;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.load.LootTableRegistry;

public class EntityLabWizard
extends EntityMultipleLives
implements IMaxAttack {
    public EntityLabWizard(Level worldIn) {
        super(worldIn);
        this.func_70105_a(1.0f, 2.0f);
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.27);
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(300.0);
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null) {
            IMaxAttack.dealMaxHealth((Entity)this, this.func_70638_az(), 8);
            return true;
        }
        return false;
    }

    protected SoundEvent func_184615_bR() {
        return SoundInit.LAB_CREATURE_DEATH;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundInit.LAB_CREATURE_HIT;
    }

    protected SoundEvent func_184639_G() {
        return null;
    }

    public void func_70636_d() {
        super.func_70636_d();
        LivingEntity target = this.func_70638_az();
        if (this.field_70173_aa % 20 == 0 && target != null) {
            if (!this.field_70170_p.field_72995_K) {
                EntityWizardBlast shot = new EntityWizardBlast(this.field_70170_p, (LivingEntity)this);
                double d0 = target.field_70165_t - this.field_70165_t;
                double d1 = target.func_174813_aQ().field_72338_b + (double)(target.field_70131_O / 5.0f) - shot.field_70163_u;
                double d2 = target.field_70161_v - this.field_70161_v;
                double d3 = Mth.func_76133_a((double)(d0 * d0 + d2 * d2));
                shot.func_70186_c(d0, d1 + d3 * (double)0.2f, d2, 2.0f, 0.0f);
                this.field_70170_p.func_72838_d((Entity)shot);
            }
            this.func_184185_a(SoundEvents.field_191244_bn, 1.0f, 1.0f);
        }
    }

    @Override
    protected int numberOfLives() {
        return 3;
    }

    protected ResourceLocation func_184647_J() {
        if (this.field_70146_Z.nextInt(7) == 0) {
            return LootTableRegistry.LABYRINTH_TOP;
        }
        return null;
    }
}

