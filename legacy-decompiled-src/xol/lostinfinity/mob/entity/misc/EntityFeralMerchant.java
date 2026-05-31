/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.PathfinderMob
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.item.ItemEntity
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.misc;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.ai.IBasicAI;
import xol.lostinfinity.mob.entity.base.EntityMultipleLives;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityFeralMerchant
extends EntityMultipleLives
implements IMaxAttack,
IBasicAI {
    private int mode = 0;

    public EntityFeralMerchant(Level worldIn) {
        super(worldIn);
        this.func_70105_a(1.2f, 2.2f);
    }

    public int getMode() {
        return this.mode;
    }

    public void setMode(int b) {
        this.mode = b;
    }

    @Override
    public void func_70014_b(CompoundTag tag) {
        super.func_70014_b(tag);
        tag.func_74768_a("FindState", this.getMode());
    }

    @Override
    public void func_70037_a(CompoundTag tag) {
        super.func_70037_a(tag);
        this.setMode(tag.func_74762_e("FindState"));
    }

    @Override
    protected void func_184651_r() {
        this.initBasicTasks((PathfinderMob)this);
    }

    public void func_70636_d() {
        super.func_70636_d();
        this.field_70143_R = -1.0f;
        if (!this.field_70170_p.field_72995_K && this.field_70173_aa % (80 - 15 * this.getMode()) == 0 && this.func_70638_az() != null) {
            this.func_70634_a(this.func_70638_az().field_70165_t, this.func_70638_az().field_70163_u, this.func_70638_az().field_70161_v);
            this.func_184185_a(SoundInit.BIG_WARP, 1.0f, 0.7f + this.field_70146_Z.nextFloat() * 0.6f);
        }
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null) {
            IMaxAttack.dealMaxHealth((Entity)this, this.func_70638_az(), 3, 1 + this.getMode());
            return true;
        }
        return false;
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(4000.0);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.3);
        this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a(1.0);
    }

    protected SoundEvent func_184615_bR() {
        return SoundInit.FERAL_MERCHANT_DEATH;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundInit.FERAL_MERCHANT_HURT;
    }

    protected SoundEvent func_184639_G() {
        return SoundInit.FERAL_MERCHANT_AMBIENT;
    }

    protected boolean func_70692_ba() {
        return false;
    }

    @Override
    protected int numberOfLives() {
        return 4 + 4 * this.getMode();
    }

    @Override
    public void trueDeathAction() {
        if (!this.field_70170_p.field_72995_K) {
            if (this.getMode() == 2) {
                this.func_145779_a(ItemInit.warpedDisc, 1);
            } else {
                ItemStack newCorrelator = new ItemStack(ItemInit.geocorrelator);
                newCorrelator.func_77982_d(new CompoundTag());
                newCorrelator.func_77978_p().func_74768_a("GameState", this.getMode() + 2);
                this.doTeleport(newCorrelator);
                ItemEntity itemEntity = new ItemEntity(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v, newCorrelator);
                itemEntity.field_70159_w = 0.0;
                itemEntity.field_70181_x = 0.0;
                itemEntity.field_70179_y = 0.0;
                this.field_70170_p.func_72838_d((Entity)itemEntity);
            }
        }
    }

    private BlockPos findTeleport() {
        double d0 = this.field_70165_t + (this.field_70146_Z.nextDouble() - 0.5) * 400.0;
        double d2 = this.field_70161_v + (this.field_70146_Z.nextDouble() - 0.5) * 400.0;
        double d1 = 5 + this.field_70146_Z.nextInt(95);
        return new BlockPos(d0, d1, d2);
    }

    private void doTeleport(ItemStack held) {
        BlockPos telepos = this.findTeleport();
        held.func_77978_p().func_74780_a("FindX", (double)telepos.func_177958_n());
        held.func_77978_p().func_74780_a("FindY", (double)telepos.func_177956_o());
        held.func_77978_p().func_74780_a("FindZ", (double)telepos.func_177952_p());
    }
}

