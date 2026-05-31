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

import java.util.List;
import java.util.stream.Collectors;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.Level;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;
import xol.lostinfinity.util.PotionBasic;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityLaunchedKnife
extends EntityBaseThrowable {
    public EntityLaunchedKnife(Level par1World) {
        super(par1World);
        this.func_70105_a(0.75f, 0.75f);
    }

    public EntityLaunchedKnife(Level par1World, LivingEntity par2Mob) {
        super(par1World, par2Mob);
        this.func_70105_a(0.75f, 0.75f);
    }

    public EntityLaunchedKnife(Level par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
        this.func_70105_a(0.75f, 0.75f);
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (!this.field_70170_p.field_72995_K) {
            LivingEntity hit;
            if (result.field_72308_g != null && result.field_72308_g instanceof LivingEntity && this.func_85052_h() != null && !(hit = (LivingEntity)result.field_72308_g).equals((Object)this.func_85052_h()) && IMaxAttack.dealMaxHealth((Entity)this, (LivingEntity)result.field_72308_g, 5, 2.0f).didSuccessfulHit()) {
                List potionList = hit.func_70651_bq().stream().map(PotionEffect::func_188419_a).collect(Collectors.toList());
                for (Potion potion : potionList) {
                    boolean flag = false;
                    if (potion instanceof PotionBasic) {
                        PotionBasic lost_potion = (PotionBasic)potion;
                        if (lost_potion.negativeLostEffect()) {
                            flag = true;
                        }
                    } else if (potion.func_76398_f()) {
                        flag = true;
                    }
                    if (!flag) continue;
                    int amplifier = Math.min(9, hit.func_70660_b(potion).func_76458_c() + 1);
                    int duration = hit.func_70660_b(potion).func_76459_b();
                    hit.func_70690_d(new PotionEffect(potion, duration + 100, amplifier));
                }
            }
            this.func_70106_y();
        }
    }

    protected float func_70185_h() {
        return 0.0f;
    }
}

