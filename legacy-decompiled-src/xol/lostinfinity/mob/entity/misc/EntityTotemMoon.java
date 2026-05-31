/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.Mob
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.player.Player
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.misc;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.projectile.entity.EntityGenericBomb;

public class EntityTotemMoon
extends Mob {
    private Player owner = null;
    private int timer = 150;

    public EntityTotemMoon(Level worldIn) {
        super(worldIn);
        this.func_70105_a(1.0f, 1.0f);
        this.func_184224_h(true);
    }

    public void setOwner(Player play) {
        this.owner = play;
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(3000.0);
    }

    public void func_70636_d() {
        super.func_70636_d();
        this.field_70143_R = -1.0f;
        if (!this.field_70170_p.field_72995_K) {
            if (this.timer >= 40 && this.timer % 40 == 0 || this.timer <= 40 && this.timer % 10 == 0) {
                double x0 = this.field_70165_t;
                double y0 = this.field_70163_u + 0.5;
                double z0 = this.field_70161_v;
                double radius = 5.0;
                float angle = 0.0f;
                while ((double)angle <= Math.PI * 2) {
                    EntityGenericBomb shot = new EntityGenericBomb(this.field_70170_p);
                    shot.func_70107_b(x0, y0, z0);
                    double velocity_x = (double)0.06f * radius * Math.cos(angle);
                    double velocity_z = (double)0.06f * radius * Math.sin(angle);
                    shot.setThrower((LivingEntity)this);
                    shot.calculateVelocity(velocity_x, 0.8f, velocity_z);
                    this.field_70170_p.func_72838_d((Entity)shot);
                    angle = (float)((double)angle + 0.39269908169872414);
                }
                this.func_184185_a(SoundInit.GENERIC_WEAPON_7, 1.0f, 1.0f);
            }
            if (this.timer <= 0) {
                this.func_70106_y();
            }
            --this.timer;
        }
    }
}

