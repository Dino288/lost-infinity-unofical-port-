/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.IEntityOwnable
 *  net.minecraft.entity.player.Player
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.Mth
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.IEntityOwnable;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.minion.EntityMinion;
import xol.lostinfinity.mob.entity.misc.EntityRisingPhantom;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityEidolonMist
extends EntityBaseThrowable {
    private double speed = 0.3;
    private LivingEntity target = null;
    private static final int homingRadius = 30;
    private ArrayList<UUID> hitEntities = new ArrayList();
    int chaseTime = 600;
    double accel = 0.0;

    public EntityEidolonMist(Level par1World) {
        super(par1World);
        this.func_70105_a(0.75f, 0.75f);
    }

    public EntityEidolonMist(Level par1World, LivingEntity par2Mob) {
        super(par1World, par2Mob);
        this.func_70105_a(0.75f, 0.75f);
    }

    public EntityEidolonMist(Level par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
        this.func_70105_a(0.75f, 0.75f);
    }

    protected void func_145775_I() {
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (!this.field_70170_p.field_72995_K) {
            if (this.func_85052_h() != null) {
                boolean hit = false;
                for (LivingEntity target : this.field_70170_p.func_72872_a(LivingEntity.class, this.func_174813_aQ().func_186662_g(3.0))) {
                    if (this.hitEntities.contains(target.func_110124_au()) || target.func_110124_au().equals(this.func_85052_h().func_110124_au()) || target instanceof IEntityOwnable && ((IEntityOwnable)target).func_184753_b() == this.func_85052_h().func_110124_au() || target instanceof EntityMinion && ((EntityMinion)target).getOwner() == this.func_85052_h() || !IMaxAttack.dealTrueDamage((Entity)this, target, target.func_110138_aP() * 3.0f, Arrays.asList("Darkborn")).didSuccessfulHit()) continue;
                    this.hitEntities.add(target.func_110124_au());
                    hit = true;
                }
                if (hit) {
                    this.chaseTime = 600;
                    this.accel = 0.0;
                    if (this.field_70146_Z.nextInt(6) == 0) {
                        int numNew = this.field_70146_Z.nextInt(3);
                        for (int i = 0; i < numNew; ++i) {
                            EntityEidolonMist newMist = new EntityEidolonMist(this.field_70170_p);
                            newMist.func_70634_a(this.target.field_70165_t, this.target.field_70163_u + (double)(this.target.field_70131_O / 2.0f), this.target.field_70161_v);
                            newMist.addInitialTarget(this.target);
                            newMist.setThrower(this.func_85052_h());
                            this.field_70170_p.func_72838_d((Entity)newMist);
                        }
                    }
                }
            }
            this.target = null;
            this.field_70170_p.func_184133_a(null, this.func_180425_c(), SoundInit.GHOSTLY_CLOUDS, SoundSource.PLAYERS, 1.5f, 0.6f + 0.4f * this.field_70146_Z.nextFloat());
        }
    }

    @Override
    public void func_70071_h_() {
        block10: {
            block9: {
                super.func_70071_h_();
                if (this.field_70170_p.field_72995_K) break block9;
                if (this.field_70173_aa > 2400) {
                    this.func_70106_y();
                }
                if (this.field_70173_aa % 4 == 0 && this.func_85052_h() != null && this.func_85052_h() instanceof Player) {
                    EntityRisingPhantom phantom = new EntityRisingPhantom(this.field_70170_p, (Player)this.func_85052_h());
                    Vec3 loc = new Vec3(this.field_70165_t, this.field_70163_u, this.field_70161_v);
                    phantom.func_70080_a(loc.field_72450_a, loc.field_72448_b - (double)phantom.field_70131_O, loc.field_72449_c, this.field_70170_p.field_73012_v.nextFloat() * 360.0f, 0.0f);
                    phantom.setVelocity((float)Mth.func_151238_b((double)0.1f, (double)Mth.func_151238_b((double)0.1f, (double)0.5, (double)this.field_70173_aa), (double)this.field_70170_p.field_73012_v.nextFloat()));
                    phantom.setLivesTaken(Mth.func_76128_c((double)Mth.func_151238_b((double)0.0, (double)10.0, (double)this.field_70173_aa)));
                    this.field_70170_p.func_72838_d((Entity)phantom);
                }
                --this.chaseTime;
                if (this.accel < 2.5) {
                    this.accel += 0.04;
                }
                if (this.chaseTime <= 0) {
                    this.func_70106_y();
                }
                if (this.field_70173_aa % 20 == 0) {
                    this.field_70170_p.func_184133_a(null, this.func_180425_c(), this.randomWhisper(this.field_70146_Z.nextInt(5)), SoundSource.PLAYERS, 1.25f, 0.7f + this.field_70146_Z.nextFloat() * 0.6f);
                }
                if (this.field_70173_aa <= 2) break block10;
                if (this.target == null || this.target.field_70128_L) {
                    LivingEntity closest = null;
                    double minDist = 9999.0;
                    for (LivingEntity entity : this.field_70170_p.func_72872_a(LivingEntity.class, new AABB(this.func_180425_c().func_177982_a(-30, -30, -30), this.func_180425_c().func_177982_a(30, 30, 30)))) {
                        double dist;
                        if (this.hitEntities.contains(entity.func_110124_au()) || this.func_85052_h() != null && this.func_85052_h().func_110124_au().equals(entity.func_110124_au()) || entity instanceof EntityRisingPhantom || entity == null || this.func_85052_h() == null || entity instanceof IEntityOwnable && ((IEntityOwnable)entity).func_184753_b() == this.func_85052_h().func_110124_au() || entity instanceof EntityMinion && ((EntityMinion)entity).getOwner() == this.func_85052_h() || !((dist = (double)this.func_70032_d((Entity)entity)) < minDist)) continue;
                        minDist = dist;
                        closest = entity;
                    }
                    if (closest == null) {
                        this.func_70106_y();
                        return;
                    }
                    this.target = closest;
                }
                if (this.target == null) break block10;
                Vec3 dir = this.target.func_174791_d().func_178787_e(new Vec3(0.0, (double)this.target.field_70131_O / 3.0, 0.0)).func_178788_d(this.func_174791_d());
                dir = dir.func_72432_b();
                Vec3 motionVec = new Vec3(this.field_70159_w, this.field_70181_x, this.field_70179_y);
                motionVec = motionVec.func_72432_b();
                Vec3 diff = dir.func_178788_d(motionVec);
                this.field_70159_w += diff.field_72450_a * (this.speed + this.accel);
                this.field_70181_x += diff.field_72448_b * (this.speed + this.accel);
                this.field_70179_y += diff.field_72449_c * (this.speed + this.accel);
                this.field_70133_I = true;
                break block10;
            }
            for (int i = 0; i < 3; ++i) {
                this.field_70170_p.func_175682_a(ParticleInit.MURK, true, this.field_70165_t + this.field_70146_Z.nextDouble() * 2.0 - 1.0, this.field_70163_u + this.field_70146_Z.nextDouble() * 2.0 - 1.0, this.field_70161_v + this.field_70146_Z.nextDouble() * 2.0 - 1.0, this.field_70146_Z.nextDouble() * 0.25 - 0.125, this.field_70146_Z.nextDouble() * 0.25 - 0.125, this.field_70146_Z.nextDouble() * 0.25 - 0.125, new int[0]);
                this.field_70170_p.func_175682_a(ParticleInit.MURKY_MIST, true, this.field_70165_t + this.field_70146_Z.nextDouble() * 1.0 - 0.5, this.field_70163_u + this.field_70146_Z.nextDouble() * 1.0 - 0.5, this.field_70161_v + this.field_70146_Z.nextDouble() * 1.0 - 0.5, this.field_70146_Z.nextDouble() * 0.25 - 0.125, this.field_70146_Z.nextDouble() * 0.25 - 0.125, this.field_70146_Z.nextDouble() * 0.25 - 0.125, new int[0]);
            }
        }
    }

    private SoundEvent randomWhisper(int i) {
        switch (i) {
            case 0: {
                return SoundInit.WHISPER_1;
            }
            case 1: {
                return SoundInit.WHISPER_2;
            }
            case 2: {
                return SoundInit.WHISPER_3;
            }
            case 3: {
                return SoundInit.WHISPER_4;
            }
            case 4: {
                return SoundInit.WHISPER_5;
            }
        }
        return SoundInit.WHISPER_5;
    }

    protected float func_70185_h() {
        return 0.0f;
    }

    public void addInitialTarget(LivingEntity target) {
        if (target != null) {
            this.hitEntities.add(target.func_110124_au());
        }
    }
}

