/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.MoverType
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Mth
 *  net.minecraft.world.IBlockAccess
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.base;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.Entity;
import net.minecraft.entity.MoverType;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.level.Level;
import xol.lostinfinity.mob.entity.base.EntityDeviantMob;

public abstract class EntityFlyingDeviant
extends EntityDeviantMob {
    protected float rawFlySpeed = 0.91f;

    public EntityFlyingDeviant(Level worldIn) {
        super(worldIn);
    }

    public void func_180430_e(float distance, float damageMultiplier) {
    }

    protected void func_184231_a(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
    }

    public void func_191986_a(float strafe, float vertical, float forward) {
        if (this.func_70090_H()) {
            this.func_191958_b(strafe, vertical, forward, 0.02f);
            this.func_70091_d(MoverType.SELF, this.field_70159_w, this.field_70181_x, this.field_70179_y);
            this.field_70159_w *= (double)0.8f;
            this.field_70181_x *= (double)0.8f;
            this.field_70179_y *= (double)0.8f;
        } else if (this.func_180799_ab()) {
            this.func_191958_b(strafe, vertical, forward, 0.02f);
            this.func_70091_d(MoverType.SELF, this.field_70159_w, this.field_70181_x, this.field_70179_y);
            this.field_70159_w *= 0.5;
            this.field_70181_x *= 0.5;
            this.field_70179_y *= 0.5;
        } else {
            float f = this.rawFlySpeed;
            if (this.field_70122_E) {
                BlockPos underPos = new BlockPos(Mth.func_76128_c((double)this.field_70165_t), Mth.func_76128_c((double)this.func_174813_aQ().field_72338_b) - 1, Mth.func_76128_c((double)this.field_70161_v));
                BlockState underState = this.field_70170_p.func_180495_p(underPos);
                f = underState.func_177230_c().getSlipperiness(underState, (IBlockAccess)this.field_70170_p, underPos, (Entity)this) * 0.91f;
            }
            float f1 = 0.16277136f / (f * f * f);
            this.func_191958_b(strafe, vertical, forward, this.field_70122_E ? 0.1f * f1 : 0.02f);
            f = this.rawFlySpeed;
            if (this.field_70122_E) {
                BlockPos underPos = new BlockPos(Mth.func_76128_c((double)this.field_70165_t), Mth.func_76128_c((double)this.func_174813_aQ().field_72338_b) - 1, Mth.func_76128_c((double)this.field_70161_v));
                BlockState underState = this.field_70170_p.func_180495_p(underPos);
                f = underState.func_177230_c().getSlipperiness(underState, (IBlockAccess)this.field_70170_p, underPos, (Entity)this) * 0.91f;
            }
            this.func_70091_d(MoverType.SELF, this.field_70159_w, this.field_70181_x, this.field_70179_y);
            this.field_70159_w *= (double)f;
            this.field_70181_x *= (double)f;
            this.field_70179_y *= (double)f;
        }
        this.field_184618_aE = this.field_70721_aZ;
        double d1 = this.field_70165_t - this.field_70169_q;
        double d0 = this.field_70161_v - this.field_70166_s;
        float f2 = Mth.func_76133_a((double)(d1 * d1 + d0 * d0)) * 4.0f;
        if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        this.field_70721_aZ += (f2 - this.field_70721_aZ) * 0.4f;
        this.field_184619_aG += this.field_70721_aZ;
    }

    public boolean func_70617_f_() {
        return false;
    }
}

