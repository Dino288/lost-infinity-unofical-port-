/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.potion.Potion
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.world.World
 */
package xol.lostinfinity.projectile.entity;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.Level;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityTekBullet
extends EntityBaseThrowable {
    public EntityTekBullet(Level par1World) {
        super(par1World);
        this.func_70105_a(0.5f, 0.5f);
    }

    public EntityTekBullet(Level par1World, LivingEntity par2Mob) {
        super(par1World, par2Mob);
        this.func_70105_a(0.5f, 0.5f);
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (!this.field_70170_p.field_72995_K) {
            if (result.field_72308_g != null && this.func_85052_h() != null && result.field_72308_g != this.func_85052_h() && result.field_72308_g instanceof LivingEntity) {
                LivingEntity target = (LivingEntity)result.field_72308_g;
                List potionList = target.func_70651_bq().stream().map(PotionEffect::func_188419_a).collect(Collectors.toList());
                if (potionList.size() > 0) {
                    Collections.shuffle(potionList);
                    target.func_184589_d((Potion)potionList.get(0));
                }
                IMaxAttack.dealMaxHealth((Entity)this, (LivingEntity)result.field_72308_g, 5);
            }
            this.func_70106_y();
        }
    }

    protected float func_70185_h() {
        return 0.0f;
    }
}

