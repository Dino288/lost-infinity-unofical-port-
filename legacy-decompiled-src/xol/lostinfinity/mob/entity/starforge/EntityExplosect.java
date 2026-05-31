/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.PathfinderMob
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.monster.Monster
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.world.EnumDifficulty
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.starforge;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.Difficulty;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.ai.IBasicAI;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.load.LootTableRegistry;

public class EntityExplosect
extends Monster
implements IMaxAttack,
IBasicAI {
    public EntityExplosect(Level worldIn) {
        super(worldIn);
        this.func_70105_a(1.0f, 0.75f);
    }

    protected void func_184651_r() {
        this.initBasicTasks((PathfinderMob)this);
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null) {
            IMaxAttack.dealMaxHealth((Entity)this, this.func_70638_az(), 3);
            return true;
        }
        return false;
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(700.0);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.3);
        this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a(1.0);
    }

    public void func_70636_d() {
        super.func_70636_d();
        this.field_70143_R = -1.0f;
        if (!this.field_70170_p.field_72995_K) {
            if (this.func_70638_az() != null) {
                LivingEntity target = this.func_70638_az();
                if (this.func_70032_d((Entity)target) > 2.0f) {
                    this.func_70024_g(Math.signum(target.field_70165_t - this.field_70165_t) * 0.05, 0.0, Math.signum(target.field_70161_v - this.field_70161_v) * 0.05);
                    if (target.field_70163_u > this.field_70163_u) {
                        this.field_70181_x = 0.1;
                    }
                } else {
                    this.field_70170_p.func_72876_a((Entity)this, this.field_70165_t, this.field_70163_u, this.field_70161_v, 6.0f, false);
                    for (LivingEntity near_pl : this.field_70170_p.func_72872_a(LivingEntity.class, this.func_174813_aQ().func_72314_b(3.0, 3.0, 3.0))) {
                        IMaxAttack.dealMaxHealth((Entity)this, near_pl, 2);
                    }
                    this.func_70106_y();
                }
            } else if (this.field_70173_aa % 100 < 50) {
                this.field_70181_x = 0.1;
            }
        }
    }

    protected SoundEvent func_184615_bR() {
        return SoundInit.STARFORGE_EXPLOSECT_DEATH;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundInit.STARFORGE_EXPLOSECT_HURT;
    }

    protected SoundEvent func_184639_G() {
        return SoundInit.STARFORGE_EXPLOSECT_AMBIENT;
    }

    protected ResourceLocation func_184647_J() {
        return LootTableRegistry.ENTITIES_STARFORGE_EXPLOSECT;
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

