/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.Mob
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.world.World
 */
package xol.lostinfinity.projectile.entity;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.base.EntityDeviantMob;
import xol.lostinfinity.mob.entity.base.EntityFloatingDeviant;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;

public class EntityDeviantDeployer
extends EntityBaseThrowable {
    private List<Class<? extends Mob>> summonList = new ArrayList<Class<? extends Mob>>();

    public EntityDeviantDeployer(Level par1World) {
        super(par1World);
    }

    public EntityDeviantDeployer(Level par1World, LivingEntity par2Mob) {
        super(par1World, par2Mob);
    }

    public void giveList(List<Class<? extends Mob>> newList) {
        this.summonList.addAll(newList);
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (!this.field_70170_p.field_72995_K) {
            if (this.summonList.size() > 0) {
                this.func_184185_a(SoundInit.DEVIATION, 1.0f, 1.0f);
                boolean flag = false;
                if (result.field_72308_g != null && result.field_72308_g instanceof Player) {
                    flag = true;
                }
                for (Class<? extends Mob> dev : this.summonList) {
                    try {
                        Constructor<? extends Mob> con = dev.getConstructor(World.class);
                        Object[] obj = new Object[]{this.field_70170_p};
                        Mob devEntity = con.newInstance(obj);
                        ((Entity)devEntity).func_70107_b(this.field_70165_t - 1.0 + this.field_70146_Z.nextDouble() * 2.0, this.field_70163_u + 0.2, this.field_70161_v - 1.0 + this.field_70146_Z.nextDouble() * 2.0);
                        if (flag) {
                            if (devEntity instanceof EntityDeviantMob) {
                                ((EntityDeviantMob)devEntity).setMutation(3);
                            } else if (devEntity instanceof EntityFloatingDeviant) {
                                ((EntityFloatingDeviant)devEntity).setMutation(3);
                            }
                        }
                        this.field_70170_p.func_72838_d((Entity)devEntity);
                    }
                    catch (IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | SecurityException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
            this.func_70106_y();
        }
    }

    protected float func_70185_h() {
        return 0.05f;
    }
}

