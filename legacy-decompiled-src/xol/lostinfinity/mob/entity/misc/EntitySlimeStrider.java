/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.PathfinderMob
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
package xol.lostinfinity.mob.entity.misc;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.Difficulty;
import net.minecraft.world.level.Level;
import xol.lostinfinity.mob.ai.IBasicAI;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.load.LootTableRegistry;

public class EntitySlimeStrider
extends Monster
implements IMaxAttack,
IBasicAI {
    public EntitySlimeStrider(Level worldIn) {
        super(worldIn);
        this.func_70105_a(1.5f, 0.5f);
    }

    protected void func_184651_r() {
        this.initBasicTasks((PathfinderMob)this);
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.378);
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(200.0);
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
        return SoundEvents.field_187874_fm;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundEvents.field_187880_fp;
    }

    protected SoundEvent func_184639_G() {
        return SoundEvents.field_187886_fs;
    }

    public boolean func_70814_o() {
        return true;
    }

    public void func_70636_d() {
        super.func_70636_d();
        this.field_70143_R = -0.5f;
        float scl = 1.8f + 0.5f * Mth.func_76126_a((float)((float)this.field_70173_aa * 0.05f));
        this.func_70105_a(1.1f + scl, 0.2f + scl);
        if (this.field_70171_ac && this.func_70638_az() != null) {
            if (this.func_70638_az().field_70163_u > this.field_70163_u) {
                this.field_70181_x = 0.25;
                this.field_70133_I = true;
            }
            if (this.field_70159_w > (double)-1.6f && this.field_70159_w < (double)1.6f) {
                this.field_70159_w *= (double)1.3f;
                this.field_70133_I = true;
            }
            if (this.field_70179_y > (double)-1.6f && this.field_70179_y < (double)1.6f) {
                this.field_70179_y *= (double)1.3f;
                this.field_70133_I = true;
            }
        }
    }

    public boolean func_70648_aU() {
        return true;
    }

    protected boolean func_70692_ba() {
        int time = (int)(this.field_70170_p.func_72820_D() % 24000L);
        return time > 13000 && time < 18000;
    }

    public boolean func_70601_bi() {
        return this.field_70170_p.func_175659_aa() != EnumDifficulty.PEACEFUL && this.field_70163_u > 45.0 && this.field_70163_u < (double)this.field_70170_p.func_181545_F();
    }

    protected ResourceLocation func_184647_J() {
        return LootTableRegistry.ENTITIES_SLIMESTRIDER;
    }
}

