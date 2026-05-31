/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.world.World
 */
package xol.lostinfinity.projectile.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.Level;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityEnergyBurst
extends EntityBaseThrowable {
    public EntityEnergyBurst(Level par1World) {
        super(par1World);
        this.func_70105_a(0.75f, 0.75f);
    }

    public EntityEnergyBurst(Level par1World, LivingEntity par2Mob) {
        super(par1World, par2Mob);
        this.func_70105_a(0.75f, 0.75f);
    }

    public EntityEnergyBurst(Level par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
        this.func_70105_a(0.75f, 0.75f);
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (!this.field_70170_p.field_72995_K) {
            LivingEntity hit;
            if (result.field_72308_g != null && result.field_72308_g instanceof LivingEntity && this.func_85052_h() != null && !(hit = (LivingEntity)result.field_72308_g).equals((Object)this.func_85052_h())) {
                if (hit.func_110143_aJ() <= hit.func_110138_aP() / 3.0f) {
                    IMaxAttack.dealTrueDamage((Entity)this, hit, hit.func_110138_aP() * 0.33f);
                } else {
                    IMaxAttack.dealMaxHealth((Entity)this, hit, 3);
                }
            }
            this.func_70106_y();
        }
    }

    protected float func_70185_h() {
        return 0.0f;
    }
}

