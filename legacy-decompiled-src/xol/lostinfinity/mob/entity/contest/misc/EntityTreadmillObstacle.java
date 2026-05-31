/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.Player
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.util.math.AABB
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.contest.misc;

import net.minecraft.world.entity.player.Player;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.Level;
import xol.lostinfinity.mob.entity.base.EntityImmaterial;
import xol.lostinfinity.mob.entity.fungal.EntityFungfly;
import xol.lostinfinity.util.coordinates.ContestCoordinates;

public class EntityTreadmillObstacle
extends EntityImmaterial {
    private static final DataParameter<Integer> VISUAL_STYLE = EntityDataManager.func_187226_a(EntityFungfly.class, (DataSerializer)DataSerializers.field_187192_b);
    private float speed = 0.2f;

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a(VISUAL_STYLE, (Object)-1);
    }

    public int getVisual() {
        return (Integer)this.field_70180_af.func_187225_a(VISUAL_STYLE);
    }

    public void setVisual(int v) {
        this.field_70180_af.func_187227_b(VISUAL_STYLE, (Object)v);
    }

    public EntityTreadmillObstacle(Level worldIn) {
        super(worldIn);
        this.func_70105_a(1.0f, 1.0f);
        this.func_189654_d(true);
    }

    @Override
    public void func_70636_d() {
        super.func_70636_d();
        if (!this.field_70170_p.field_72995_K) {
            this.field_70181_x = 0.0;
            this.field_70179_y = 0.0;
            this.field_70159_w = -this.speed;
            this.field_70133_I = true;
            AABB grid = ContestCoordinates.treadmillGridAABB();
            if (this.field_70165_t < grid.field_72340_a) {
                this.func_70106_y();
            }
        }
    }

    @Override
    public boolean func_70067_L() {
        return true;
    }

    public void func_70100_b_(Player entityIn) {
        if (!this.field_70170_p.field_72995_K && this.field_70165_t > entityIn.field_70165_t && Math.abs(this.field_70161_v - entityIn.field_70161_v) < 0.3) {
            entityIn.field_70159_w += this.field_70159_w;
            entityIn.field_70133_I = true;
        }
    }
}

