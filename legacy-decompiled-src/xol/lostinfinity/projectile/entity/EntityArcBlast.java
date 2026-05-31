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

public class EntityArcBlast
extends EntityBaseThrowable {
    public EntityArcBlast(Level par1World) {
        super(par1World);
        this.func_70105_a(0.75f, 0.75f);
    }

    public EntityArcBlast(Level par1World, LivingEntity par2Mob) {
        super(par1World, par2Mob);
        this.func_70105_a(0.75f, 0.75f);
    }

    public EntityArcBlast(Level par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
        this.func_70105_a(0.75f, 0.75f);
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (!this.field_70170_p.field_72995_K) {
            LivingEntity hit;
            if (result.field_72308_g != null && result.field_72308_g instanceof LivingEntity && this.func_85052_h() != null && !(hit = (LivingEntity)result.field_72308_g).equals((Object)this.func_85052_h())) {
                if (hit.func_70644_a(PotionInit.SHOCKED)) {
                    if (IMaxAttack.dealMaxHealth((Entity)this, (LivingEntity)result.field_72308_g, 4, 5.0f).didSuccessfulHit()) {
                        hit.func_184589_d(PotionInit.SHOCKED);
                    }
                } else if (IMaxAttack.dealMaxHealth((Entity)this, (LivingEntity)result.field_72308_g, 4, 3.0f).didSuccessfulHit()) {
                    hit.func_70690_d(new PotionEffect(PotionInit.SHOCKED, 100));
                }
            }
            this.func_70106_y();
        }
    }

    protected float func_70185_h() {
        return 0.0f;
    }
}

