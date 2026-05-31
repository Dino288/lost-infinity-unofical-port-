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
 *  net.minecraft.util.math.HitResult
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
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityGalaxyKnife
extends EntityBaseThrowable {
    private float grav = 0.030000001f;
    private boolean doubleDamage = false;
    private static final DataParameter<Byte> TYPE = EntityDataManager.func_187226_a(EntityGalaxyKnife.class, (DataSerializer)DataSerializers.field_187191_a);

    public EntityGalaxyKnife(Level par1World) {
        super(par1World);
    }

    public EntityGalaxyKnife(Level par1World, LivingEntity par2Mob) {
        super(par1World, par2Mob);
    }

    public EntityGalaxyKnife(Level par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
    }

    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a(TYPE, (Object)0);
    }

    public void setGravity(Float g) {
        this.grav = g.floatValue();
    }

    public void setDouble() {
        this.doubleDamage = true;
    }

    public byte getForm() {
        return (Byte)this.field_70180_af.func_187225_a(TYPE);
    }

    public void setForm(byte f) {
        this.field_70180_af.func_187227_b(TYPE, (Object)f);
    }

    public void func_70014_b(CompoundTag tag) {
        super.func_70014_b(tag);
        tag.func_74774_a("WepType", this.getForm());
    }

    public void func_70037_a(CompoundTag tag) {
        super.func_70037_a(tag);
        this.setForm(tag.func_74771_c("WepType"));
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (!this.field_70170_p.field_72995_K) {
            if (result.field_72308_g != null && this.func_85052_h() != null && result.field_72308_g != this.func_85052_h() && result.field_72308_g instanceof LivingEntity) {
                LivingEntity attacker = this.func_85052_h();
                LivingEntity target = (LivingEntity)result.field_72308_g;
                int multi = this.doubleDamage ? 2 : 1;
                switch (this.getForm()) {
                    case 0: {
                        if (!(attacker.func_110143_aJ() >= 4.0f * (attacker.func_110138_aP() / 5.0f))) break;
                        IMaxAttack.dealMaxHealth((Entity)this, target, 5, multi);
                        break;
                    }
                    case 1: {
                        if (!(target.func_110143_aJ() <= target.func_110138_aP() / 2.0f)) break;
                        IMaxAttack.dealMaxHealth((Entity)this, target, 20, 3 * multi);
                        break;
                    }
                    case 2: {
                        if (!(target.func_110143_aJ() >= target.func_110138_aP() / 2.0f)) break;
                        IMaxAttack.dealMaxHealth((Entity)this, target, 20, 3 * multi);
                        break;
                    }
                    case 3: {
                        if (!(attacker.func_110143_aJ() <= attacker.func_110138_aP() / 5.0f)) break;
                        IMaxAttack.dealMaxHealth((Entity)this, target, 4, multi);
                    }
                }
            }
            this.func_70106_y();
        }
    }

    protected float func_70185_h() {
        return this.grav;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_70071_h_() {
        super.func_70071_h_();
        if (this.field_70170_p.field_72995_K) {
            switch (this.getForm()) {
                case 0: {
                    this.field_70170_p.func_175688_a(ParticleInit.GALAXY_BLUE, this.field_70165_t + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * (double)this.field_70131_O - 0.25, this.field_70161_v + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, 0.0, 0.0, 0.0, new int[0]);
                    break;
                }
                case 1: {
                    this.field_70170_p.func_175688_a(ParticleInit.GALAXY_PURPLE, this.field_70165_t + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * (double)this.field_70131_O - 0.25, this.field_70161_v + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, 0.0, 0.0, 0.0, new int[0]);
                    break;
                }
                case 2: {
                    this.field_70170_p.func_175688_a(ParticleInit.GALAXY_GREEN, this.field_70165_t + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * (double)this.field_70131_O - 0.25, this.field_70161_v + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, 0.0, 0.0, 0.0, new int[0]);
                    break;
                }
                case 3: {
                    this.field_70170_p.func_175688_a(ParticleInit.GALAXY_YELLOW, this.field_70165_t + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * (double)this.field_70131_O - 0.25, this.field_70161_v + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, 0.0, 0.0, 0.0, new int[0]);
                }
            }
        }
    }
}

