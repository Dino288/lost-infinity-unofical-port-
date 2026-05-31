/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.world.World
 */
package xol.lostinfinity.projectile.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.PotionInit;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityDeviantEvokerShot
extends EntityBaseThrowable {
    public EntityDeviantEvokerShot(Level par1World) {
        super(par1World);
    }

    public EntityDeviantEvokerShot(Level par1World, LivingEntity par2Mob) {
        super(par1World, par2Mob);
    }

    public EntityDeviantEvokerShot(Level par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
    }

    public EntityDeviantEvokerShot(Level par1World, double par2, double par4, double par6, float size) {
        super(par1World, par2, par4, par6);
        this.func_70105_a(size, size);
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (!this.field_70170_p.field_72995_K) {
            if (result.field_72308_g != null && this.func_85052_h() != null && result.field_72308_g != this.func_85052_h() && result.field_72308_g instanceof LivingEntity) {
                IMaxAttack.dealMaxHealth((Entity)this, (LivingEntity)result.field_72308_g, 2);
                if (result.field_72308_g instanceof Player) {
                    ((Player)result.field_72308_g).func_70690_d(new PotionEffect(PotionInit.NULLIFIED, 300));
                }
            }
            this.func_70106_y();
        }
    }

    protected float func_70185_h() {
        return 0.05f;
    }
}

