/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.Mob
 *  net.minecraft.entity.player.Player
 *  net.minecraft.entity.projectile.EntityArrow
 *  net.minecraft.entity.projectile.EntityFireball
 *  net.minecraft.entity.projectile.EntityThrowable
 *  net.minecraft.util.math.AABB
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.misc;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class EntityTotemPylon
extends Mob {
    private Player owner = null;
    private int timer = 200;

    public EntityTotemPylon(Level worldIn) {
        super(worldIn);
        this.func_70105_a(1.0f, 1.0f);
        this.func_184224_h(true);
    }

    public void setOwner(Player play) {
        this.owner = play;
    }

    public void func_70636_d() {
        super.func_70636_d();
        this.field_70143_R = -1.0f;
        if (!this.field_70170_p.field_72995_K) {
            if (this.timer % 5 == 0) {
                for (Entity proj : this.field_70170_p.func_72872_a(Entity.class, new AABB(this.func_180425_c()).func_186662_g(20.0))) {
                    boolean flag = true;
                    if (proj instanceof EntityThrowable) {
                        if (((EntityThrowable)proj).func_85052_h() != null && this.owner != null && ((EntityThrowable)proj).func_85052_h().func_110124_au().equals(this.owner.func_110124_au())) {
                            flag = false;
                        }
                    } else if (proj instanceof EntityArrow) {
                        if (((EntityArrow)proj).field_70250_c != null && this.owner != null && ((EntityArrow)proj).field_70250_c.func_110124_au().equals(this.owner.func_110124_au())) {
                            flag = false;
                        }
                    } else if (proj instanceof EntityFireball) {
                        if (((EntityFireball)proj).field_70235_a != null && this.owner != null && ((EntityFireball)proj).field_70235_a.func_110124_au().equals(this.owner.func_110124_au())) {
                            flag = false;
                        }
                    } else {
                        flag = false;
                    }
                    if (!flag) continue;
                    CustomParticleConfig config1 = new CustomParticleConfig();
                    config1.createInstance().setParticle(ParticleInit.FLAME_LARGE).setSpread(1.0, 0.0, 1.0).setSpeed(0.3, 0.0, 0.3).setVelSpread(1.0, 0.0, 1.0).setCount(5).setIgnoreRange(true);
                    IParticleSpawner.spawnParticle(this.field_70170_p, config1, proj.field_70165_t, proj.field_70163_u, proj.field_70161_v);
                    this.func_184185_a(SoundInit.ITEM_AXIOMAVORUM, 1.0f, 0.8f + 0.4f * this.field_70146_Z.nextFloat());
                    proj.func_70106_y();
                }
            }
            if (this.timer <= 0) {
                this.func_70106_y();
            }
            --this.timer;
        }
    }
}

