/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.util.EnumParticleTypes
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.projectile.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.phys.HitResult;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityStunAttack
extends EntityBaseThrowable {
    private float grav = 0.030000001f;
    private static final DataParameter<Byte> TYPE = EntityDataManager.func_187226_a(EntityStunAttack.class, (DataSerializer)DataSerializers.field_187191_a);

    public EntityStunAttack(Level par1World) {
        super(par1World);
    }

    public EntityStunAttack(Level par1World, LivingEntity par2Mob) {
        super(par1World, par2Mob);
    }

    public EntityStunAttack(Level par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
    }

    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a(TYPE, (Object)0);
    }

    public byte getForm() {
        return (Byte)this.field_70180_af.func_187225_a(TYPE);
    }

    public void setForm(byte f) {
        this.field_70180_af.func_187227_b(TYPE, (Object)f);
    }

    public void func_70014_b(CompoundTag tag) {
        super.func_70014_b(tag);
        tag.func_74774_a("AttackStyle", this.getForm());
    }

    public void func_70037_a(CompoundTag tag) {
        super.func_70037_a(tag);
        this.setForm(tag.func_74771_c("AttackStyle"));
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (!this.field_70170_p.field_72995_K) {
            if (result.field_72308_g != null && this.func_85052_h() != null && result.field_72308_g != this.func_85052_h() && result.field_72308_g instanceof LivingEntity) {
                IMaxAttack.dealMaxHealth((Entity)this, (LivingEntity)result.field_72308_g, 4);
                result.field_72308_g.field_70159_w = 0.0;
                result.field_72308_g.field_70181_x = 0.0;
                result.field_72308_g.field_70179_y = 0.0;
                result.field_72308_g.func_145747_a((Component)new Component((Object)((Object)TextFmt.Dark_Purple) + "Your muscles briefly freeze up."));
            }
            this.func_70106_y();
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_70071_h_() {
        super.func_70071_h_();
        if (this.field_70170_p.field_72995_K) {
            if (this.getForm() == 0) {
                for (int i = 0; i < 3; ++i) {
                    this.field_70170_p.func_175688_a(EnumParticleTypes.WATER_DROP, this.field_70165_t + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * (double)this.field_70131_O - 0.25, this.field_70161_v + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, (this.field_70146_Z.nextDouble() - 0.5) * 2.0, -this.field_70146_Z.nextDouble(), (this.field_70146_Z.nextDouble() - 0.5) * 2.0, new int[0]);
                }
            } else {
                this.field_70170_p.func_175688_a(EnumParticleTypes.LAVA, this.field_70165_t + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * (double)this.field_70131_O - 0.25, this.field_70161_v + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, (this.field_70146_Z.nextDouble() - 0.5) * 2.0, -this.field_70146_Z.nextDouble(), (this.field_70146_Z.nextDouble() - 0.5) * 2.0, new int[0]);
            }
        }
    }
}

