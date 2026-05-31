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
import xol.lostinfinity.mob.entity.sea.seaserpent.EntitySeaSerpentController;
import xol.lostinfinity.mob.entity.sea.seaserpent.EntitySeaSerpentSegment;
import xol.lostinfinity.util.math.LMath;

public class EntitySeaSerpentHead
extends EntitySeaSerpentSegment {
    public EntitySeaSerpentHead(EntitySeaSerpentController parent) {
        super(parent, null, 1.0f, 1.0f);
        this.dSocketOffset = 0.4375f;
        this.dOriginDistance = 0.4375f;
    }

    @Override
    protected void updatePosition() {
        if (this.awaitSync) {
            this.awaitSync = false;
            this.func_70080_a(this.syncX, this.syncY, this.syncZ, this.syncYaw, this.syncPitch);
            return;
        }
        Vec3 parentPos = ((EntitySeaSerpentController)this.relay).func_174791_d();
        Vec3 dir = LMath.fastNormalize(parentPos.func_178786_a(this.field_70165_t, this.field_70163_u, this.field_70161_v));
        double hMagnitude = LMath.fastSqrt(dir.field_72450_a * dir.field_72450_a + dir.field_72449_c * dir.field_72449_c);
        float pitch = (float)Mth.func_181159_b((double)(-dir.field_72448_b), (double)hMagnitude) * 57.29578f;
        float yaw = (float)Mth.func_181159_b((double)(-dir.field_72450_a), (double)dir.field_72449_c) * 57.29578f;
        dir = dir.func_186678_a((double)(-this.originDistance));
        this.func_70080_a(parentPos.field_72450_a + dir.field_72450_a, parentPos.field_72448_b + dir.field_72448_b, parentPos.field_72449_c + dir.field_72449_c, yaw, pitch);
    }
}

