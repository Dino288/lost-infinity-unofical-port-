/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.PathfinderMob
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.monster.Monster
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.Mth
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.contest;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.DimensionInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.ai.IBasicAI;
import xol.lostinfinity.mob.entity.contest.controller.EntityControllerHunters;
import xol.lostinfinity.projectile.entity.EntityBloodhunterBlast;
import xol.lostinfinity.util.coordinates.ContestCoordinates;

public class EntityBloodhunter
extends Monster
implements IBasicAI {
    private boolean ranged = false;

    public EntityBloodhunter(Level worldIn) {
        super(worldIn);
        this.func_70105_a(1.5f, 2.2f);
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(0.5);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.4);
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(10000.0);
    }

    public void setRanged() {
        this.ranged = true;
    }

    protected void func_184651_r() {
        this.initBasicTasks((PathfinderMob)this);
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null && !this.field_70170_p.field_72995_K) {
            if (this.field_70170_p.field_73011_w.func_186058_p() == DimensionInit.grandmasterOutpost && this.func_70638_az() instanceof Player) {
                Player player = (Player)this.func_70638_az();
                for (EntityControllerHunters search_cont : this.field_70170_p.func_72872_a(EntityControllerHunters.class, this.getArenaAABB())) {
                    search_cont.removePlayer(player);
                }
            }
            return true;
        }
        return false;
    }

    public void func_70636_d() {
        super.func_70636_d();
        if (!this.field_70170_p.field_72995_K) {
            if (this.field_70173_aa % 10 == 0 && this.func_70638_az() == null) {
                float closest = 99999.0f;
                Player close_pl = null;
                for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.func_174813_aQ().func_72314_b(12.0, 12.0, 12.0))) {
                    if (near_pl.func_70093_af() || near_pl.field_70159_w == 0.0 && near_pl.field_70179_y != 0.0) continue;
                    float test_dist = this.func_70032_d((Entity)near_pl);
                    if (close_pl != null && !(test_dist < closest)) continue;
                    close_pl = near_pl;
                    closest = test_dist;
                }
                if (close_pl != null) {
                    this.func_70624_b((LivingEntity)close_pl);
                }
            }
            if (this.ranged && this.field_70173_aa % 20 == 0 && this.func_70638_az() != null) {
                this.func_184185_a(SoundEvents.field_191255_dF, 1.0f, 0.5f + this.field_70146_Z.nextFloat());
                LivingEntity target = this.func_70638_az();
                EntityBloodhunterBlast shot = new EntityBloodhunterBlast(this.field_70170_p, (LivingEntity)this);
                double d0 = target.field_70165_t - this.field_70165_t;
                double d1 = target.func_174813_aQ().field_72338_b + (double)(target.field_70131_O / 6.0f) - shot.field_70163_u;
                double d2 = target.field_70161_v - this.field_70161_v;
                double d3 = Mth.func_76133_a((double)(d0 * d0 + d2 * d2));
                shot.func_70186_c(d0, d1 + d3 * (double)0.2f, d2, 2.0f, 0.0f);
                this.field_70170_p.func_72838_d((Entity)shot);
            }
        }
    }

    protected SoundEvent func_184615_bR() {
        return SoundInit.STARFORGE_CRAWKER_DEATH;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundInit.STARFORGE_CRAWKER_HURT;
    }

    protected SoundEvent func_184639_G() {
        return SoundInit.STARFORGE_CRAWKER_AMBIENT;
    }

    protected boolean func_70692_ba() {
        return false;
    }

    public boolean func_70814_o() {
        return true;
    }

    protected AABB getArenaAABB() {
        return ContestCoordinates.huntersArenaAABB();
    }
}

