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
 *  net.minecraft.world.World
 *  net.minecraft.world.ServerLevel
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
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;
import xol.lostinfinity.projectile.entity.EntityComet;
import xol.lostinfinity.projectile.entity.EntityFallingStar;

public class EntityCarrierProjectile
extends EntityBaseThrowable {
    private static final DataParameter<Byte> TYPE = EntityDataManager.func_187226_a(EntityCarrierProjectile.class, (DataSerializer)DataSerializers.field_187191_a);
    private static final DataParameter<Byte> LIFETICKS = EntityDataManager.func_187226_a(EntityCarrierProjectile.class, (DataSerializer)DataSerializers.field_187191_a);

    public EntityCarrierProjectile(Level par1World) {
        super(par1World);
    }

    public EntityCarrierProjectile(Level par1World, LivingEntity par2Mob) {
        super(par1World, par2Mob);
    }

    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a(TYPE, (Object)0);
        this.field_70180_af.func_187214_a(LIFETICKS, (Object)0);
    }

    public byte getForm() {
        return (Byte)this.field_70180_af.func_187225_a(TYPE);
    }

    public void setForm(byte f) {
        this.field_70180_af.func_187227_b(TYPE, (Object)f);
    }

    public byte getRemainingLife() {
        return (Byte)this.field_70180_af.func_187225_a(LIFETICKS);
    }

    public void setRemainingLife(byte f) {
        this.field_70180_af.func_187227_b(LIFETICKS, (Object)f);
    }

    public void func_70014_b(CompoundTag tag) {
        super.func_70014_b(tag);
        tag.func_74774_a("WepType", this.getForm());
        tag.func_74774_a("LifeTicks", this.getRemainingLife());
    }

    public void func_70037_a(CompoundTag tag) {
        super.func_70037_a(tag);
        this.setForm(tag.func_74771_c("WepType"));
        this.setRemainingLife(tag.func_74771_c("LifeTicks"));
    }

    @Override
    public void func_70071_h_() {
        super.func_70071_h_();
        if (!this.field_70170_p.field_72995_K) {
            int life = this.getRemainingLife() - 1;
            if (life == 0) {
                if (this.getForm() == 0) {
                    EntityFallingStar star = new EntityFallingStar(this.field_70170_p);
                    star.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
                    star.setStartLoc(this.field_70165_t, this.field_70163_u, this.field_70161_v);
                    star.func_70186_c((this.field_70146_Z.nextDouble() - 0.5) * (double)0.1f, -0.1, (this.field_70146_Z.nextDouble() - 0.5) * (double)0.1f, 0.4f, 0.0f);
                    star.setThrower(this.func_85052_h());
                    this.field_70170_p.func_72838_d((Entity)star);
                } else if (this.getForm() == 1) {
                    EntityComet comet = new EntityComet(this.field_70170_p);
                    comet.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
                    comet.setStartLoc(this.field_70165_t, this.field_70163_u, this.field_70161_v);
                    comet.func_70186_c((this.field_70146_Z.nextDouble() - 0.5) * (double)0.1f, -0.1, (this.field_70146_Z.nextDouble() - 0.5) * (double)0.1f, 0.4f, 0.0f);
                    comet.setThrower(this.func_85052_h());
                    ((ServerLevel)this.field_70170_p).func_175739_a(EnumParticleTypes.LAVA, comet.field_70165_t, comet.field_70163_u, comet.field_70161_v, 2, this.field_70146_Z.nextDouble() * 3.0, 0.3, this.field_70146_Z.nextDouble() * 3.0, (double)0.15f, new int[0]);
                    this.field_70170_p.func_72838_d((Entity)comet);
                }
                this.func_70106_y();
            } else {
                this.setRemainingLife((byte)life);
            }
        } else {
            for (int k = 0; k < 4; ++k) {
                this.field_70170_p.func_175688_a(EnumParticleTypes.SPELL_INSTANT, this.field_70165_t + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * (double)this.field_70131_O - 0.25, this.field_70161_v + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, (this.field_70146_Z.nextDouble() - 0.5) * 2.0, -this.field_70146_Z.nextDouble(), (this.field_70146_Z.nextDouble() - 0.5) * 2.0, new int[0]);
            }
        }
    }

    protected float func_70185_h() {
        return 0.020000001f;
    }

    @Override
    protected void func_70184_a(HitResult result) {
        this.setRemainingLife((byte)1);
    }
}

