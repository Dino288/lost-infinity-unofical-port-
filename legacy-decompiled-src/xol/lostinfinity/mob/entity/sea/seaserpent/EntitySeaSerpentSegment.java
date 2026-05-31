/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.math.Mth
 *  net.minecraft.util.math.Vec3
 */
package xol.lostinfinity.mob.entity.sea.seaserpent;

import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import xol.lostinfinity.mob.entity.base.EntityMultipleLivesRelay;
import xol.lostinfinity.mob.entity.sea.seaserpent.EntitySeaSerpentController;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.math.LMath;

public class EntitySeaSerpentSegment
extends EntityMultipleLivesRelay<EntitySeaSerpentController>
implements IMaxAttack {
    protected final EntitySeaSerpentSegment parentSegment;
    protected float dWidth;
    protected float dHeight;
    protected float dSocketOffset;
    protected float dOriginDistance;
    protected int size = 1;
    protected float socketOffset;
    protected float originDistance;
    protected float segmentMaxPitch;
    protected float segmentMaxYaw;

    public EntitySeaSerpentSegment(EntitySeaSerpentController parent, EntitySeaSerpentSegment parentSegment) {
        this(parent, parentSegment, 1.0f, 1.0f);
    }

    public EntitySeaSerpentSegment(EntitySeaSerpentController parent, EntitySeaSerpentSegment parentSegment, float width, float height) {
        super(parent, width, height);
        this.parentSegment = parentSegment;
        this.dWidth = width;
        this.dHeight = height;
        this.socketOffset = this.dSocketOffset = 0.5f;
        this.originDistance = this.dOriginDistance = 0.5f;
        this.segmentMaxPitch = 60.0f;
        this.segmentMaxYaw = 60.0f;
    }

    protected void updatePosition() {
        if (this.parentSegment == null || this.parentSegment.field_70128_L) {
            return;
        }
        if (this.awaitSync) {
            this.awaitSync = false;
            this.func_70080_a(this.syncX, this.syncY, this.syncZ, this.syncYaw, this.syncPitch);
            return;
        }
        Vec3 parentPos = this.parentSegment.getSocketPosition();
        Vec3 dir = LMath.fastNormalize(parentPos.func_178786_a(this.field_70165_t, this.field_70163_u, this.field_70161_v));
        if (dir.func_189985_c() == 0.0) {
            return;
        }
        double hMagnitude = LMath.fastSqrt(dir.field_72450_a * dir.field_72450_a + dir.field_72449_c * dir.field_72449_c);
        float pitch = (float)Mth.func_181159_b((double)(-dir.field_72448_b), (double)hMagnitude) * 57.29578f;
        float parentPitch = this.parentSegment.field_70125_A;
        pitch = parentPitch + Mth.func_76131_a((float)LMath.degreeDifference(parentPitch, pitch), (float)(-this.segmentMaxPitch), (float)this.segmentMaxPitch);
        pitch = (float)Mth.func_151238_b((double)pitch, (double)parentPitch, (double)0.02);
        float yaw = (float)Mth.func_181159_b((double)(-dir.field_72450_a), (double)dir.field_72449_c) * 57.29578f;
        float parentYaw = this.parentSegment.field_70177_z;
        yaw = parentYaw + Mth.func_76131_a((float)LMath.degreeDifference(parentYaw, yaw), (float)(-this.segmentMaxYaw), (float)this.segmentMaxYaw);
        yaw = (float)Mth.func_151238_b((double)yaw, (double)parentYaw, (double)0.02);
        dir = Vec3.func_189986_a((float)pitch, (float)yaw).func_186678_a((double)(-this.originDistance));
        this.func_70080_a(parentPos.field_72450_a + dir.field_72450_a, parentPos.field_72448_b + dir.field_72448_b, parentPos.field_72449_c + dir.field_72449_c, yaw, pitch);
    }

    protected Vec3 getSocketPosition() {
        return this.func_174791_d().func_178787_e(this.func_70040_Z().func_186678_a((double)(-this.socketOffset)));
    }

    public boolean func_70072_I() {
        return false;
    }

    public boolean func_180799_ab() {
        return false;
    }

    public void func_70080_a(double x, double y, double z, float yaw, float pitch) {
        this.field_70169_q = this.field_70165_t;
        this.field_70167_r = this.field_70163_u;
        this.field_70166_s = this.field_70161_v;
        this.field_70165_t = x;
        this.field_70163_u = y;
        this.field_70161_v = z;
        this.field_70126_B = this.field_70177_z;
        this.field_70127_C = this.field_70125_A;
        this.field_70758_at = this.field_70759_as;
        this.field_70760_ar = this.field_70761_aq;
        this.field_70177_z = yaw;
        this.field_70759_as = yaw;
        this.field_70761_aq = yaw;
        this.field_70125_A = pitch;
        if (!this.field_70170_p.field_72995_K) {
            this.field_70170_p.func_72964_e((int)Math.floor(this.field_70165_t) >> 4, (int)Math.floor(this.field_70161_v) >> 4);
        }
        this.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
        this.func_70101_b(yaw, pitch);
    }

    public float func_70047_e() {
        return this.field_70131_O / 2.0f;
    }

    public void setSize(int size) {
        this.size = size;
        this.func_70105_a(this.dWidth * (float)size, this.dHeight * (float)size);
        this.socketOffset = this.dSocketOffset * (float)size;
        this.originDistance = this.dOriginDistance * (float)size;
    }

    public float func_70603_bj() {
        return this.size;
    }
}

