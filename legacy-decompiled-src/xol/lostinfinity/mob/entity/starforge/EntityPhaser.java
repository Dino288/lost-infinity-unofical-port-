/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.PathfinderMob
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.monster.Monster
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.math.Mth
 *  net.minecraft.world.EnumDifficulty
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.starforge;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.Difficulty;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.ai.IBasicAI;
import xol.lostinfinity.projectile.entity.EntityStunAttack;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.load.LootTableRegistry;

public class EntityPhaser
extends Monster
implements IMaxAttack,
IBasicAI {
    public EntityPhaser(Level worldIn) {
        super(worldIn);
        this.func_70105_a(1.5f, 1.5f);
    }

    protected void func_184651_r() {
        this.initBasicTasks((PathfinderMob)this);
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null) {
            IMaxAttack.dealMaxHealth((Entity)this, this.func_70638_az(), 5);
            return true;
        }
        return false;
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(900.0);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.3);
        this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a(1.0);
    }

    public void func_70636_d() {
        super.func_70636_d();
        if (Math.sin((double)((float)this.field_70173_aa * 0.05f) + 1.5707963267948966) > 0.0) {
            LivingEntity target = this.func_70638_az();
            if (this.field_70173_aa % 20 == 0 && target != null) {
                if (!this.field_70170_p.field_72995_K) {
                    EntityStunAttack shot = new EntityStunAttack(this.field_70170_p, (LivingEntity)this);
                    double d0 = target.field_70165_t - this.field_70165_t;
                    double d1 = target.func_174813_aQ().field_72338_b + (double)(target.field_70131_O / 6.0f) - shot.field_70163_u;
                    double d2 = target.field_70161_v - this.field_70161_v;
                    double d3 = Mth.func_76133_a((double)(d0 * d0 + d2 * d2));
                    shot.func_70186_c(d0, d1 + d3 * (double)0.2f, d2, 2.0f, 0.0f);
                    this.field_70170_p.func_72838_d((Entity)shot);
                }
                this.func_184185_a(SoundEvents.field_193784_dd, 1.0f, 1.0f);
            }
        } else {
            LivingEntity target = this.func_70638_az();
            if (this.field_70173_aa % 7 == 0 && target != null) {
                if (!this.field_70170_p.field_72995_K) {
                    EntityStunAttack shot = new EntityStunAttack(this.field_70170_p, (LivingEntity)this);
                    double d0 = target.field_70165_t - this.field_70165_t;
                    double d1 = target.func_174813_aQ().field_72338_b + (double)(target.field_70131_O / 6.0f) - shot.field_70163_u;
                    double d2 = target.field_70161_v - this.field_70161_v;
                    double d3 = Mth.func_76133_a((double)(d0 * d0 + d2 * d2));
                    shot.func_70186_c(d0, d1 + d3 * (double)0.2f, d2, 2.0f, 0.0f);
                    shot.setForm((byte)1);
                    this.field_70170_p.func_72838_d((Entity)shot);
                }
                this.func_184185_a(SoundEvents.field_191265_hd, 1.0f, 1.0f);
            }
        }
    }

    protected SoundEvent func_184615_bR() {
        return SoundInit.STARFORGE_PHASER_DEATH;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundInit.STARFORGE_PHASER_HURT;
    }

    protected SoundEvent func_184639_G() {
        return SoundInit.STARFORGE_PHASER_AMBIENT;
    }

    protected ResourceLocation func_184647_J() {
        return LootTableRegistry.ENTITIES_STARFORGE_PHASER;
    }

    protected boolean func_70692_ba() {
        return false;
    }

    public boolean func_70814_o() {
        return true;
    }

    public int func_70641_bl() {
        return 1;
    }

    public boolean func_70601_bi() {
        return this.field_70170_p.func_175659_aa() != EnumDifficulty.PEACEFUL;
    }
}

