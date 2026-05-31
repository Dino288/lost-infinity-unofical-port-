/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.util.EnumParticleTypes
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.projectile.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityDeviantSpit
extends EntityBaseThrowable {
    public EntityDeviantSpit(Level par1World) {
        super(par1World);
    }

    public EntityDeviantSpit(Level par1World, LivingEntity par2Mob) {
        super(par1World, par2Mob);
    }

    public EntityDeviantSpit(Level par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (!this.field_70170_p.field_72995_K) {
            if (result.field_72308_g != null && this.func_85052_h() != null && result.field_72308_g != this.func_85052_h() && result.field_72308_g instanceof LivingEntity) {
                LivingEntity hit_entity = (LivingEntity)result.field_72308_g;
                IMaxAttack.dealMaxHealth((Entity)this, hit_entity, 3);
                hit_entity.field_70159_w = 0.0;
                hit_entity.field_70181_x = 0.0;
                hit_entity.field_70179_y = 0.0;
                hit_entity.func_70024_g(Math.signum(this.func_85052_h().field_70165_t - hit_entity.field_70165_t) * 1.1, Math.signum(this.func_85052_h().field_70163_u - hit_entity.field_70163_u) * 0.5, Math.signum(this.func_85052_h().field_70161_v - hit_entity.field_70161_v) * 1.1);
                hit_entity.field_70133_I = true;
            }
            this.func_70106_y();
        }
    }

    protected float func_70185_h() {
        return 0.05f;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_70071_h_() {
        super.func_70071_h_();
        for (int i = 0; i < 4; ++i) {
            this.field_70170_p.func_175688_a(EnumParticleTypes.SPIT, this.field_70165_t, this.field_70163_u, this.field_70161_v, -0.5 + this.field_70146_Z.nextDouble(), -0.5 + this.field_70146_Z.nextDouble(), -0.5 + this.field_70146_Z.nextDouble(), new int[0]);
        }
    }
}

