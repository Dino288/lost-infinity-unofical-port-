/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.EntityAgeable
 *  net.minecraft.entity.passive.EntityTameable
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.util.DamageSource
 *  net.minecraft.world.EnumDifficulty
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.base;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.level.Level;

public class EntityMultiLivesTameable
extends EntityTameable {
    private static final DataParameter<Integer> LIFECOUNT_TAMEABLE = EntityDataManager.func_187226_a(EntityMultiLivesTameable.class, (DataSerializer)DataSerializers.field_187192_b);
    private boolean performedDeathAction = false;

    public EntityMultiLivesTameable(Level worldIn) {
        super(worldIn);
    }

    public boolean didDeathAction() {
        return this.performedDeathAction;
    }

    public void deathActionComplete() {
        this.performedDeathAction = true;
    }

    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a(LIFECOUNT_TAMEABLE, (Object)0);
    }

    public int getLivesCount() {
        return (Integer)this.field_70180_af.func_187225_a(LIFECOUNT_TAMEABLE);
    }

    public void setLivesCount(int f) {
        this.field_70180_af.func_187227_b(LIFECOUNT_TAMEABLE, (Object)f);
    }

    public void takewayLife() {
        this.field_70180_af.func_187227_b(LIFECOUNT_TAMEABLE, (Object)(this.getLivesCount() + 1));
        this.updateLifeAction();
    }

    public void func_70014_b(CompoundTag tag) {
        super.func_70014_b(tag);
        tag.func_74768_a("LivesUsed", this.getLivesCount());
    }

    public void func_70037_a(CompoundTag tag) {
        super.func_70037_a(tag);
        this.setLivesCount(tag.func_74762_e("LivesUsed"));
    }

    public boolean func_70601_bi() {
        return this.field_70170_p.func_175659_aa() != EnumDifficulty.PEACEFUL;
    }

    public boolean onFinalLife() {
        return this.getLivesCount() == this.numberOfLives();
    }

    protected int numberOfLives() {
        return 10;
    }

    protected void updateLifeAction() {
    }

    public void trueDeathAction() {
    }

    public EntityAgeable func_90011_a(EntityAgeable ageable) {
        return null;
    }

    public void func_70645_a(DamageSource cause) {
        if (this.onFinalLife()) {
            super.func_70645_a(cause);
        }
    }
}

