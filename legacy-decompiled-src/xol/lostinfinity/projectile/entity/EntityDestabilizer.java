/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.Mob
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.monster.Monster
 *  net.minecraft.entity.player.Player
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.world.World
 */
package xol.lostinfinity.projectile.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantAmalgam;
import xol.lostinfinity.mob.entity.deviant.EntityLostDeviant;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;

public class EntityDestabilizer
extends EntityBaseThrowable {
    private int type = 0;

    public EntityDestabilizer(Level par1World) {
        super(par1World);
    }

    public EntityDestabilizer(Level par1World, LivingEntity par2Mob) {
        super(par1World, par2Mob);
    }

    public void setType(int t) {
        this.type = t;
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (!this.field_70170_p.field_72995_K) {
            Player attack = null;
            if (result.field_72308_g != null && result.field_72308_g instanceof Player) {
                attack = (Player)result.field_72308_g;
            }
            if (this.type == 0) {
                this.impactType0(attack);
            } else if (this.type == 1) {
                this.impactType1(attack);
            }
            this.func_70106_y();
        }
        this.func_184185_a(SoundInit.DEVIATION, 3.0f, 1.0f);
    }

    private void impactType0(Player targeted) {
        for (Monster creature : this.field_70170_p.func_72872_a(Monster.class, this.func_174813_aQ().func_72314_b(10.0, 10.0, 10.0))) {
            creature.func_70106_y();
            this.summonLostDeviant(targeted, (Mob)creature);
        }
    }

    private void impactType1(Player targeted) {
        int count = 0;
        for (Mob creature : this.field_70170_p.func_72872_a(Mob.class, this.func_174813_aQ().func_72314_b(15.0, 15.0, 15.0))) {
            ++count;
        }
        for (Mob creature : this.field_70170_p.func_72872_a(Mob.class, this.func_174813_aQ().func_72314_b(15.0, 15.0, 15.0))) {
            creature.func_70106_y();
            if (count >= 4) {
                if (count % 4 == 0) {
                    this.summonAmalgam(targeted);
                }
            } else {
                this.summonLostDeviant(targeted, creature);
            }
            --count;
        }
    }

    private void summonLostDeviant(Player target, Mob replace_creature) {
        EntityLostDeviant dev = new EntityLostDeviant(this.field_70170_p);
        dev.func_70107_b(replace_creature.field_70165_t, replace_creature.field_70163_u + 0.2, replace_creature.field_70161_v);
        if (target != null) {
            dev.func_70624_b((LivingEntity)target);
        }
        this.field_70170_p.func_72838_d((Entity)dev);
    }

    private void summonAmalgam(Player target) {
        EntityDeviantAmalgam dev = new EntityDeviantAmalgam(this.field_70170_p);
        dev.func_70107_b(this.field_70165_t, this.field_70163_u + 0.2, this.field_70161_v);
        dev.setMutation(1);
        if (target != null) {
            dev.func_70624_b((LivingEntity)target);
        }
        this.field_70170_p.func_72838_d((Entity)dev);
    }

    protected float func_70185_h() {
        return 0.05f;
    }
}

