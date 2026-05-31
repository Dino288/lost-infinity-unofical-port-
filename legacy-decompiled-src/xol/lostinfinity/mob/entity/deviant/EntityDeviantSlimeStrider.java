/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.item.Item
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.math.Mth
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.deviant;

import net.minecraft.world.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.mob.entity.base.EntityDeviantMob;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.load.LootTableRegistry;

public class EntityDeviantSlimeStrider
extends EntityDeviantMob
implements IMaxAttack {
    public EntityDeviantSlimeStrider(Level worldIn) {
        super(worldIn);
        this.func_70105_a(1.5f, 0.5f);
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
            IMaxAttack.dealMaxHealth((Entity)this, this.func_70638_az(), 3);
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

    @Override
    public boolean func_70814_o() {
        return true;
    }

    @Override
    protected Item playerInput() {
        return ItemInit.deviantMilk;
    }

    @Override
    protected Item mutantOutput() {
        return ItemInit.superStimulant;
    }

    public void func_70636_d() {
        super.func_70636_d();
        this.field_70143_R = -0.5f;
        float scl = 1.8f + 0.5f * Mth.func_76126_a((float)((float)this.field_70173_aa * 0.05f));
        this.func_70105_a(1.1f + scl, 0.2f + scl);
        if (this.field_70171_ac && this.func_70638_az() != null) {
            float motionCap;
            if (this.func_70638_az().field_70163_u > this.field_70163_u) {
                this.field_70181_x = 0.25;
                this.field_70133_I = true;
            }
            if (this.field_70159_w > (double)(-(motionCap = 1.5f + (float)this.getMutation() * 0.4f)) && this.field_70159_w < (double)motionCap) {
                this.field_70159_w *= (double)1.3f;
                this.field_70133_I = true;
            }
            if (this.field_70179_y > (double)(-motionCap) && this.field_70179_y < (double)motionCap) {
                this.field_70179_y *= (double)1.3f;
                this.field_70133_I = true;
            }
        }
    }

    public boolean func_70648_aU() {
        return true;
    }

    @Override
    protected ResourceLocation deviantDrop() {
        return LootTableRegistry.ENTITIES_DEVIANTSLIMESTRIDER;
    }

    @Override
    protected ResourceLocation superMutatedDrop() {
        return LootTableRegistry.ENTITIES_SUPERMUTANT_SLIMESTRIDER;
    }
}

