/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.util.EnumParticleTypes
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.projectile.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityAtlasAttack
extends EntityBaseThrowable {
    public EntityAtlasAttack(Level worldIn) {
        super(worldIn);
    }

    public EntityAtlasAttack(Level worldIn, LivingEntity entityIn) {
        super(worldIn, entityIn);
    }

    public EntityAtlasAttack(Level worldIn, double x, double y, double z) {
        super(worldIn, x, y, z);
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (!this.field_70170_p.field_72995_K) {
            this.field_70170_p.func_72876_a(null, this.field_70165_t, this.field_70163_u, this.field_70161_v, 1.25f, false);
            for (Player target : this.field_70170_p.func_72872_a(Player.class, this.func_174813_aQ().func_72314_b(1.0, 1.0, 1.0))) {
                IMaxAttack.dealMaxHealth((Entity)this, (LivingEntity)target, 4);
            }
            this.func_70106_y();
        }
    }

    protected float func_70185_h() {
        return 0.0f;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_70071_h_() {
        super.func_70071_h_();
        if (this.field_70170_p.field_72995_K) {
            for (int k = 0; k < 4; ++k) {
                this.field_70170_p.func_175688_a(EnumParticleTypes.SPELL_INSTANT, this.field_70165_t + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * (double)this.field_70131_O - 0.25, this.field_70161_v + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, (this.field_70146_Z.nextDouble() - 0.5) * 2.0, -this.field_70146_Z.nextDouble(), (this.field_70146_Z.nextDouble() - 0.5) * 2.0, new int[0]);
            }
        }
    }
}

