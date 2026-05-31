/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.world.World
 */
package xol.lostinfinity.projectile.entity;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.PotionInit;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;

public class EntityPoisonousBubble
extends EntityBaseThrowable {
    public EntityPoisonousBubble(Level par1World) {
        super(par1World);
        this.func_70105_a(0.9f, 0.9f);
    }

    public EntityPoisonousBubble(Level par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
        this.func_70105_a(0.9f, 0.9f);
    }

    @Override
    public void func_70071_h_() {
        super.func_70071_h_();
        if (!this.field_70170_p.field_72995_K) {
            if (this.field_70173_aa > 30) {
                this.func_70106_y();
            }
        } else {
            this.field_70170_p.func_175682_a(this.field_70146_Z.nextBoolean() ? ParticleInit.ACID : ParticleInit.ACID_YELLOW, true, this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0, 0.0, 0.0, new int[0]);
        }
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (!this.field_70170_p.field_72995_K) {
            LivingEntity entity;
            if (!(result.field_72308_g == null || !(result.field_72308_g instanceof LivingEntity) || (entity = (LivingEntity)result.field_72308_g) instanceof Player && ((Player)entity).func_70644_a(PotionInit.ACIDIC))) {
                entity.func_70690_d(new PotionEffect(PotionInit.PLAGUE, 100, 2));
            }
            this.func_70106_y();
        }
    }

    protected float func_70185_h() {
        return 0.0f;
    }
}

