/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.projectile.entity;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;

public class EntityPowerPulse
extends EntityBaseThrowable {
    public EntityPowerPulse(Level par1World) {
        super(par1World);
        this.func_70105_a(0.75f, 0.75f);
    }

    public EntityPowerPulse(Level par1World, LivingEntity par2Mob) {
        super(par1World, par2Mob);
        this.func_70105_a(0.75f, 0.75f);
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (!this.field_70170_p.field_72995_K) {
            if (result.field_72308_g != null && this.func_85052_h() != null && !result.field_72308_g.equals((Object)this.func_85052_h()) && result.field_72308_g instanceof LivingEntity) {
                result.field_72308_g.func_70024_g(this.field_70159_w * 8.0, this.field_70181_x * 8.0, this.field_70179_y * 8.0);
                result.field_72308_g.field_70133_I = true;
            }
            this.func_70106_y();
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_70071_h_() {
        super.func_70071_h_();
        if (this.field_70170_p.field_72995_K) {
            for (int i = 0; i < 3; ++i) {
                this.field_70170_p.func_175682_a(ParticleInit.POWER_PULSE, true, this.field_70165_t + this.getROD(1), this.field_70163_u + this.getROD(1), this.field_70161_v + this.getROD(1), 0.0, 0.0, 0.0, new int[0]);
            }
        }
    }

    protected float func_70185_h() {
        return 0.0f;
    }
}

