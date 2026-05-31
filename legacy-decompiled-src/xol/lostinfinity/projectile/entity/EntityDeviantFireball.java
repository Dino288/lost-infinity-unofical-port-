/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.item.ItemEntity
 *  net.minecraft.entity.projectile.EntityFireball
 *  net.minecraft.init.Blocks
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.math.Mth
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.util.math.HitResult$Type
 *  net.minecraft.world.World
 */
package xol.lostinfinity.projectile.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityDeviantFireball
extends EntityFireball
implements IMaxAttack {
    private int denomDamage = 4;
    private float explosWidth = 2.0f;

    public EntityDeviantFireball(Level world, LivingEntity entity, double i, double j, double k) {
        super(world, entity, i, j, k);
    }

    public EntityDeviantFireball(Level world, LivingEntity entity, double i, double j, double k, int newDenom, float newExplos) {
        this(world, entity, i, j, k);
        this.denomDamage = newDenom;
        this.explosWidth = newExplos;
    }

    public EntityDeviantFireball(Level world) {
        super(world);
    }

    protected void func_70227_a(HitResult result) {
        if (!this.field_70170_p.field_72995_K) {
            if (result.field_72308_g != null) {
                result.field_72308_g.func_70097_a(DamageSource.func_76362_a((EntityFireball)this, (Entity)this.field_70235_a), 0.5f);
                if (result.field_72308_g instanceof LivingEntity) {
                    IMaxAttack.dealMaxHealth((Entity)this, (LivingEntity)result.field_72308_g, this.denomDamage);
                }
            } else if (result.field_72313_a == HitResult.Type.BLOCK && this.field_70170_p.func_180495_p(result.func_178782_a()).func_177230_c() == Blocks.field_150366_p) {
                ItemEntity fbdropentity = new ItemEntity(this.field_70170_p, (double)result.func_178782_a().func_177958_n(), (double)result.func_178782_a().func_177956_o(), (double)result.func_178782_a().func_177952_p(), new ItemStack(ItemInit.superheatedIngot));
                fbdropentity.func_184224_h(true);
                this.field_70170_p.func_72838_d((Entity)fbdropentity);
                this.field_70170_p.func_175698_g(result.func_178782_a());
            }
            if (this.explosWidth != 0.0f) {
                this.field_70170_p.func_72876_a(null, this.field_70165_t, this.field_70163_u, this.field_70161_v, this.explosWidth, false);
            }
            this.func_70106_y();
        }
    }

    public void shoot(double x, double y, double z, float velocity, float inaccuracy) {
        float f = Mth.func_76133_a((double)(x * x + y * y + z * z));
        x /= (double)f;
        y /= (double)f;
        z /= (double)f;
        x += this.field_70146_Z.nextGaussian() * (double)0.0075f * (double)inaccuracy;
        y += this.field_70146_Z.nextGaussian() * (double)0.0075f * (double)inaccuracy;
        z += this.field_70146_Z.nextGaussian() * (double)0.0075f * (double)inaccuracy;
        this.field_70159_w = x *= (double)velocity;
        this.field_70181_x = y *= (double)velocity;
        this.field_70179_y = z *= (double)velocity;
        float f1 = Mth.func_76133_a((double)(x * x + z * z));
        this.field_70177_z = (float)(Mth.func_181159_b((double)x, (double)z) * 57.29577951308232);
        this.field_70125_A = (float)(Mth.func_181159_b((double)y, (double)f1) * 57.29577951308232);
        this.field_70126_B = this.field_70177_z;
        this.field_70127_C = this.field_70125_A;
    }
}

