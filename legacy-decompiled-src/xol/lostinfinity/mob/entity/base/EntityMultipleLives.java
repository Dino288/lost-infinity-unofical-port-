/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.PathfinderMob
 *  net.minecraft.entity.monster.Monster
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.Packet
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.network.play.server.SPacketAnimation
 *  net.minecraft.util.DamageSource
 *  net.minecraft.world.EnumDifficulty
 *  net.minecraft.world.World
 *  net.minecraft.world.ServerLevel
 */
package xol.lostinfinity.mob.entity.base;

import java.util.Iterator;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Packet;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.play.server.SPacketAnimation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import xol.lostinfinity.mob.ai.IBasicAI;

public class EntityMultipleLives
extends Monster
implements IBasicAI {
    private static final DataParameter<Integer> LIFECOUNT = EntityDataManager.func_187226_a(EntityMultipleLives.class, (DataSerializer)DataSerializers.field_187192_b);
    private boolean performedDeathAction = false;

    public EntityMultipleLives(Level worldIn) {
        super(worldIn);
    }

    protected void func_184651_r() {
        this.initBasicTasks((PathfinderMob)this);
    }

    public boolean didDeathAction() {
        return this.performedDeathAction;
    }

    public void deathActionComplete() {
        this.performedDeathAction = true;
    }

    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a(LIFECOUNT, (Object)0);
    }

    public int getLivesCount() {
        return (Integer)this.field_70180_af.func_187225_a(LIFECOUNT);
    }

    public void setLivesCount(int f) {
        this.field_70180_af.func_187227_b(LIFECOUNT, (Object)f);
    }

    public void takewayLife() {
        this.field_70180_af.func_187227_b(LIFECOUNT, (Object)(this.getLivesCount() + 1));
        this.updateLifeAction();
        this.doDamageTint();
    }

    public void takeawayNumLives(int lives) {
        for (int i = 0; i < lives && !this.didDeathAction(); ++i) {
            this.func_70606_j(0.0f);
            this.func_70645_a(DamageSource.field_76376_m);
        }
    }

    public void func_70014_b(CompoundTag tag) {
        super.func_70014_b(tag);
        tag.func_74768_a("LivesUsed", this.getLivesCount());
    }

    public void func_70037_a(CompoundTag tag) {
        super.func_70037_a(tag);
        this.setLivesCount(tag.func_74762_e("LivesUsed"));
    }

    public boolean func_70814_o() {
        return true;
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

    public int remainingLives() {
        return this.numberOfLives() - this.getLivesCount();
    }

    protected void updateLifeAction() {
    }

    public void trueDeathAction() {
    }

    protected boolean nothingInRadius(int i) {
        Iterator iterator = this.field_70170_p.func_72872_a(EntityMultipleLives.class, this.func_174813_aQ().func_186662_g((double)i)).iterator();
        if (iterator.hasNext()) {
            EntityMultipleLives nearCreature = (EntityMultipleLives)iterator.next();
            return false;
        }
        return true;
    }

    protected void doDamageTint() {
        if (!this.field_70170_p.field_72995_K) {
            ((ServerLevel)this.field_70170_p).func_73039_n().func_151247_a((Entity)this, (Packet)new SPacketAnimation((Entity)this, 1));
        } else {
            this.func_70057_ab();
        }
    }
}

