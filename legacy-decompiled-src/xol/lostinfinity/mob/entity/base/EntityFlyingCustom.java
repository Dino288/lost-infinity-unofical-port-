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
import xol.lostinfinity.mob.entity.base.EntityMultipleLives;

public abstract class EntityFlyingCustom
extends EntityMultipleLives {
    protected float rawFlySpeed = 0.91f;

    public EntityFlyingCustom(Level worldIn) {
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

    public void func_191958_b(float strafe, float up, float forward, float friction) {
        float f = strafe * strafe + up * up + forward * forward;
        if (f >= 1.0E-4f) {
            if ((f = Mth.func_76129_c((float)f)) < 1.0f) {
                f = 1.0f;
            }
            f = friction / f;
            strafe *= f;
            up *= f;
            forward *= f;
            if (this.func_70090_H() || this.func_180799_ab()) {
                strafe *= (float)this.func_110148_a(SWIM_SPEED).func_111126_e();
                up *= (float)this.func_110148_a(SWIM_SPEED).func_111126_e();
                forward *= (float)this.func_110148_a(SWIM_SPEED).func_111126_e();
            }
            float f1 = Mth.func_76126_a((float)(this.field_70177_z * ((float)Math.PI / 180)));
            float f2 = Mth.func_76134_b((float)(this.field_70177_z * ((float)Math.PI / 180)));
            this.field_70159_w += (double)(strafe * f2 - forward * f1);
            this.field_70181_x += (double)up;
            this.field_70179_y += (double)(forward * f2 + strafe * f1);
        }
    }

    public boolean func_70617_f_() {
        return false;
    }
}

