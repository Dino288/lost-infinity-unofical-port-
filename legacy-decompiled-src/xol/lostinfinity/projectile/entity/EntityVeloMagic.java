/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.util.EnumParticleTypes
 *  net.minecraft.util.math.Mth
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.projectile.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityVeloMagic
extends EntityBaseThrowable {
    private static final DataParameter<Float> PROJWEIGHT = EntityDataManager.func_187226_a(EntityVeloMagic.class, (DataSerializer)DataSerializers.field_187193_c);
    private int denom = 8;

    public EntityVeloMagic(Level par1World) {
        super(par1World);
        this.func_70105_a(0.4f, 0.4f);
    }

    public EntityVeloMagic(Level par1World, LivingEntity par2Mob) {
        super(par1World, par2Mob);
    }

    public EntityVeloMagic(Level par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
    }

    public void setGravity(Float g) {
        this.field_70180_af.func_187227_b(PROJWEIGHT, (Object)g);
    }

    public void setDenom(int d) {
        this.denom = d;
    }

    protected void func_70088_a() {
        this.field_70180_af.func_187214_a(PROJWEIGHT, (Object)Float.valueOf(0.06f));
    }

    @Override
    public void calculateVelocity(double x, double y, double z) {
        this.field_70159_w = x;
        this.field_70181_x = y;
        this.field_70179_y = z;
        if (this.field_70127_C == 0.0f && this.field_70126_B == 0.0f) {
            float f = Mth.func_76133_a((double)(x * x + z * z));
            this.field_70177_z = (float)(Mth.func_181159_b((double)x, (double)z) * 57.29577951308232);
            this.field_70125_A = (float)(Mth.func_181159_b((double)y, (double)f) * 57.29577951308232);
            this.field_70126_B = this.field_70177_z;
            this.field_70127_C = this.field_70125_A;
        }
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (!this.field_70170_p.field_72995_K) {
            if (result.field_72308_g != null && this.func_85052_h() != null && result.field_72308_g != this.func_85052_h() && result.field_72308_g instanceof LivingEntity) {
                IMaxAttack.dealMaxHealth((Entity)this, (LivingEntity)result.field_72308_g, this.denom);
            }
            this.func_70106_y();
        }
    }

    protected float func_70185_h() {
        return ((Float)this.field_70180_af.func_187225_a(PROJWEIGHT)).floatValue();
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_70071_h_() {
        super.func_70071_h_();
        if (this.field_70170_p.field_72995_K) {
            this.field_70170_p.func_175688_a(EnumParticleTypes.SPELL_WITCH, this.field_70165_t + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * (double)this.field_70131_O - 0.25, this.field_70161_v + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, (this.field_70146_Z.nextDouble() - 0.5) * 2.0, -this.field_70146_Z.nextDouble(), (this.field_70146_Z.nextDouble() - 0.5) * 2.0, new int[0]);
        }
    }
}

