/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.world.World
 */
package xol.lostinfinity.projectile.entity;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.starforge.EntityClyster;
import xol.lostinfinity.mob.entity.starforge.EntityReflectal;
import xol.lostinfinity.mob.entity.starforge.EntitySpyker;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;

public class EntityUltraCrystalGel
extends EntityBaseThrowable {
    public EntityUltraCrystalGel(Level par1World) {
        super(par1World);
    }

    public EntityUltraCrystalGel(Level par1World, LivingEntity par2Mob) {
        super(par1World, par2Mob);
    }

    public EntityUltraCrystalGel(Level par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (!this.field_70170_p.field_72995_K) {
            if (result.field_72308_g != null) {
                EntityClyster hitEntity;
                boolean flag = false;
                if (result.field_72308_g instanceof EntitySpyker) {
                    EntitySpyker hitEntity2 = (EntitySpyker)result.field_72308_g;
                    if (!hitEntity2.isEnlarged()) {
                        hitEntity2.setEnlarged(true);
                        hitEntity2.func_70606_j(hitEntity2.func_110138_aP());
                        flag = true;
                    }
                } else if (result.field_72308_g instanceof EntityReflectal) {
                    EntityReflectal hitEntity3 = (EntityReflectal)result.field_72308_g;
                    if (!hitEntity3.isEnlarged()) {
                        hitEntity3.setEnlarged(true);
                        hitEntity3.func_70606_j(hitEntity3.func_110138_aP());
                        hitEntity3.setLivesCount(0);
                        flag = true;
                    }
                } else if (result.field_72308_g instanceof EntityClyster && !(hitEntity = (EntityClyster)result.field_72308_g).isEnlarged()) {
                    hitEntity.setEnlarged(true);
                    hitEntity.func_70606_j(hitEntity.func_110138_aP());
                    flag = true;
                }
                if (flag) {
                    this.func_184185_a(SoundInit.GENERIC_WEAPON_2, 2.0f, 1.0f);
                    this.func_184185_a(SoundInit.MAGIC_WEAPON_3, 2.0f, 1.0f);
                }
            }
            this.func_70106_y();
        }
    }

    protected float func_70185_h() {
        return 0.05f;
    }
}

