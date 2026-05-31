/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.Mob
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.player.Player
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.misc;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.level.Level;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityTentacleTrap
extends Mob
implements IMaxAttack {
    private static final DataParameter<Float> TARGET_HEIGHT = EntityDataManager.func_187226_a(EntityTentacleTrap.class, (DataSerializer)DataSerializers.field_187193_c);
    private Player owner = null;
    private LivingEntity target = null;
    private float tentacleAngle = 3.0f;

    public EntityTentacleTrap(Level worldIn) {
        super(worldIn);
        this.func_70105_a(1.0f, 1.0f);
        this.func_184224_h(true);
    }

    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a(TARGET_HEIGHT, (Object)Float.valueOf(1.0f));
    }

    public float getTargetHeight() {
        return ((Float)this.field_70180_af.func_187225_a(TARGET_HEIGHT)).floatValue();
    }

    public void setTargetHeight(float i) {
        this.field_70180_af.func_187227_b(TARGET_HEIGHT, (Object)Float.valueOf(i));
    }

    public boolean func_70067_L() {
        return false;
    }

    public void setOwner(Player play) {
        this.owner = play;
    }

    public void setTarget(LivingEntity t) {
        this.target = t;
    }

    public LivingEntity getTarget() {
        return this.target;
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(5000.0);
    }

    public float getTentacleAngle() {
        return this.tentacleAngle;
    }

    public void func_70636_d() {
        super.func_70636_d();
        this.field_70143_R = -1.0f;
        if (!this.field_70170_p.field_72995_K) {
            if (this.target == null || this.target.field_70128_L || this.field_70173_aa > 300) {
                this.func_70106_y();
            } else {
                this.setTargetHeight(this.target.field_70131_O);
                this.target.func_70634_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
                this.target.field_70159_w = 0.0;
                this.target.field_70181_x = 0.0;
                this.target.field_70179_y = 0.0;
                this.target.field_70133_I = true;
                if (this.field_70173_aa % 20 == 0) {
                    IMaxAttack.dealMaxHealth((Entity)this, this.target, 5);
                }
            }
        } else if ((double)this.tentacleAngle > 1.5707963267948966) {
            this.tentacleAngle -= 0.05f;
        }
    }
}

