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
 *  net.minecraft.util.math.Vec3
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
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityGalaxyBomb
extends EntityBaseThrowable {
    private float grav = 0.030000001f;
    private static final DataParameter<Byte> TYPE = EntityDataManager.func_187226_a(EntityGalaxyBomb.class, (DataSerializer)DataSerializers.field_187191_a);

    public EntityGalaxyBomb(Level par1World) {
        super(par1World);
    }

    public EntityGalaxyBomb(Level par1World, LivingEntity par2Mob) {
        super(par1World, par2Mob);
    }

    public EntityGalaxyBomb(Level par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
    }

    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a(TYPE, (Object)0);
    }

    public void setGravity(Float g) {
        this.grav = g.floatValue();
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
            if (this.func_85052_h() != null) {
                LivingEntity attacker = this.func_85052_h();
                this.field_70170_p.func_72876_a(null, this.field_70165_t, this.field_70163_u, this.field_70161_v, 4.0f, false);
                for (LivingEntity target : this.field_70170_p.func_72872_a(LivingEntity.class, this.func_174813_aQ().func_72314_b(4.0, 4.0, 4.0))) {
                    switch (this.getForm()) {
                        case 0: {
                            if (!(attacker.func_110143_aJ() >= 4.0f * (attacker.func_110138_aP() / 5.0f))) break;
                            IMaxAttack.dealMaxHealth((Entity)this, target, 20, 3.0f);
                            break;
                        }
                        case 1: {
                            if (!(target.func_110143_aJ() <= target.func_110138_aP() / 2.0f)) break;
                            IMaxAttack.dealMaxHealth((Entity)this, target, 10);
                            break;
                        }
                        case 2: {
                            if (!(target.func_110143_aJ() >= target.func_110138_aP() / 2.0f)) break;
                            IMaxAttack.dealMaxHealth((Entity)this, target, 10);
                            break;
                        }
                        case 3: {
                            if (!(attacker.func_110143_aJ() <= attacker.func_110138_aP() / 5.0f)) break;
                            IMaxAttack.dealMaxHealth((Entity)this, target, 5);
                        }
                    }
                }
            }
            this.func_70106_y();
        }
        this.circle();
    }

    protected float func_70185_h() {
        return this.grav;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void func_70071_h_() {
        super.func_70071_h_();
        if (this.field_70170_p.field_72995_K) {
            EnumParticleTypes particle = EnumParticleTypes.SMOKE_LARGE;
            switch (this.getForm()) {
                case 0: {
                    particle = EnumParticleTypes.WATER_WAKE;
                    break;
                }
                case 1: {
                    particle = EnumParticleTypes.SPELL_WITCH;
                    break;
                }
                case 2: {
                    particle = EnumParticleTypes.TOTEM;
                    break;
                }
                case 3: {
                    particle = EnumParticleTypes.DRIP_LAVA;
                }
            }
            for (int par = 0; par < 5; ++par) {
                this.field_70170_p.func_175688_a(particle, this.field_70165_t + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, this.field_70163_u + this.field_70146_Z.nextDouble() * (double)this.field_70131_O - 0.25, this.field_70161_v + (this.field_70146_Z.nextDouble() - 0.5) * (double)this.field_70130_N, (this.field_70146_Z.nextDouble() - 0.5) * 2.0, -this.field_70146_Z.nextDouble(), (this.field_70146_Z.nextDouble() - 0.5) * 2.0, new int[0]);
            }
        }
    }

    private void circle() {
        if (this.field_70170_p.field_72995_K && this.field_70173_aa > 5) {
            for (double i = 0.0; i <= Math.PI * 2; i += 0.3141592653589793) {
                for (double a = 0.0; a <= 360.0; a += 0.3141592653589793) {
                    double r = 2.0;
                    double x = r * Math.cos(a) * Math.sin(i);
                    double y = r * Math.cos(i);
                    double z = r * Math.sin(a) * Math.sin(i);
                    double newX = this.func_174791_d().field_72450_a + x;
                    double newY = this.func_174791_d().field_72448_b - y;
                    double newZ = this.func_174791_d().field_72449_c + z;
                    Vec3 newVec = new Vec3(newX, newY, newZ).func_178788_d(this.func_174791_d()).func_186678_a(0.5);
                    this.field_70170_p.func_190523_a(EnumParticleTypes.FLAME.func_179348_c(), newX, newY, newZ, newVec.field_72450_a, newVec.field_72448_b, newVec.field_72449_c, new int[0]);
                }
            }
        }
    }
}

