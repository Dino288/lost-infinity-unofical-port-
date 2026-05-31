/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.util.math.Mth
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.minion;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import xol.lostinfinity.mob.entity.classify.IOwnerReactive;
import xol.lostinfinity.mob.entity.minion.EntityMinion;
import xol.lostinfinity.util.data.CustomDamageResult;

public class EntityAuraOfAllegiance
extends EntityMinion
implements IOwnerReactive {
    private static final DataParameter<Integer> LIVES = EntityDataManager.func_187226_a(EntityAuraOfAllegiance.class, (DataSerializer)DataSerializers.field_187192_b);
    private static final int MAX_LIVES = 6;

    public EntityAuraOfAllegiance(Level worldIn) {
        super(worldIn);
        this.func_70105_a(0.25f, 0.25f);
    }

    @Override
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a(LIVES, (Object)1);
    }

    @Override
    protected void livingUpdate() {
        Player owner = this.getOwner();
        if (owner == null) {
            return;
        }
        this.updatePosition();
    }

    public void setLives(int lives) {
        this.field_70180_af.func_187227_b(LIVES, (Object)Mth.func_76125_a((int)lives, (int)0, (int)6));
    }

    public int getLives() {
        return (Integer)this.field_70180_af.func_187225_a(LIVES);
    }

    public void addLives(int lives) {
        this.setLives(this.getLives() + lives);
    }

    public void removeLives(int lives) {
        this.addLives(-lives);
    }

    private void updatePosition() {
        this.func_70080_a(this.owner.field_70165_t, this.owner.field_70163_u + 1.0, this.owner.field_70161_v, 0.0f, 0.0f);
        this.field_70759_as = 0.0f;
        this.field_70761_aq = 0.0f;
    }

    @Override
    public void trueDamageEffect(Entity attacker, CustomDamageResult result) {
        result.setHitMissed();
        this.removeLives(1);
        if (this.getLives() <= 0) {
            this.func_70106_y();
        }
    }
}

