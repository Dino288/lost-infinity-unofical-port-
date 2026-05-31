/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.cthulhu;

import net.minecraft.world.level.Level;
import xol.lostinfinity.mob.entity.base.EntityMultipleLivesRelay;
import xol.lostinfinity.mob.entity.cthulhu.EntityCthulhu;
import xol.lostinfinity.mob.entity.cthulhu.ICthulhuMinion;

public class EntityCthulhuPart
extends EntityMultipleLivesRelay<EntityCthulhu>
implements ICthulhuMinion {
    private float yOffset;

    public EntityCthulhuPart(Level worldIn) {
        super(worldIn);
    }

    public EntityCthulhuPart(EntityCthulhu relay, float width, float height, float yOffset) {
        super(relay, width, height);
        this.yOffset = yOffset;
    }

    protected void updatePosition() {
        this.func_70080_a(((EntityCthulhu)this.relay).field_70165_t, ((EntityCthulhu)this.relay).field_70163_u + (double)this.yOffset, ((EntityCthulhu)this.relay).field_70161_v, ((EntityCthulhu)this.relay).field_70177_z, ((EntityCthulhu)this.relay).field_70125_A);
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

    @Override
    public void setOwner(EntityCthulhu owner) {
    }

    @Override
    public EntityCthulhu getOwner() {
        return (EntityCthulhu)this.relay;
    }
}

