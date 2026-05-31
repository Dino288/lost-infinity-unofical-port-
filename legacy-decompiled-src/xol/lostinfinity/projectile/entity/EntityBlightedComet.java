/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.world.World
 */
package xol.lostinfinity.projectile.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.PotionInit;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityBlightedComet
extends EntityBaseThrowable {
    public EntityBlightedComet(Level par1World) {
        super(par1World);
        this.func_70105_a(1.0f, 1.0f);
    }

    public EntityBlightedComet(Level par1World, LivingEntity par2Mob) {
        super(par1World, par2Mob);
        this.func_70105_a(1.0f, 1.0f);
    }

    public EntityBlightedComet(Level par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
        this.func_70105_a(1.0f, 1.0f);
    }

    @Override
    public void setThrower(LivingEntity throwset) {
        this.field_70192_c = throwset;
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (!this.field_70170_p.field_72995_K) {
            for (LivingEntity target : this.field_70170_p.func_72872_a(LivingEntity.class, this.func_174813_aQ().func_72314_b(4.0, 4.0, 4.0))) {
                if (!IMaxAttack.dealMaxHealth((Entity)this, target, 4, 3.0f).didSuccessfulHit()) continue;
                target.func_70690_d(new PotionEffect(PotionInit.BLIGHTED, 200));
            }
            this.field_70170_p.func_72876_a((Entity)this, this.field_70165_t, this.field_70163_u, this.field_70161_v, 4.0f, false);
            this.func_70106_y();
        }
    }

    protected float func_70185_h() {
        return 0.0366f;
    }
}

