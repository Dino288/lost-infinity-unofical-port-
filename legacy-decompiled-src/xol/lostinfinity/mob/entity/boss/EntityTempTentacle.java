/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.player.Player
 *  net.minecraft.entity.player.ServerPlayer
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.Mth
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.boss;

import java.util.ArrayList;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.base.EntityMultipleLives;
import xol.lostinfinity.projectile.entity.EntityBlightedComet;
import xol.lostinfinity.projectile.entity.EntityBossPortalEffect;
import xol.lostinfinity.projectile.entity.EntityHomingBlight;
import xol.lostinfinity.projectile.entity.EntityTentacleSeed;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityTempTentacle
extends EntityMultipleLives
implements IMaxAttack {
    private int phase;
    private int nextFormTimer = 80;
    private Vec3 homePos = null;
    private ArrayList<LivingEntity> targets = null;
    private LivingEntity swoopTarget = null;
    private static final double radius = 50.0;
    private static final double circleSpeed = 2.0;
    private double theta = 0.0;
    private boolean swooped = false;
    private static final double swoopHeight = 1.0;
    private static final double swoopSpeed = 3.0;
    private ArrayList<LivingEntity> offsetMobs = null;
    private boolean pulled = false;

    public EntityTempTentacle(Level worldIn) {
        super(worldIn);
        this.func_70105_a(2.0f, 7.0f);
    }

    protected void func_82167_n(Entity entityIn) {
        Player play;
        if (entityIn instanceof Player && !(play = (Player)entityIn).func_184812_l_()) {
            IMaxAttack.dealMaxHealth((Entity)this, (LivingEntity)play, 5);
            play.func_70024_g(this.field_70159_w * 1.5, 2.0, this.field_70179_y * 1.5);
            play.field_70133_I = true;
        }
        entityIn.func_70108_f((Entity)this);
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.32);
        this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(15000.0);
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null) {
            IMaxAttack.dealMaxHealth((Entity)this, this.func_70638_az(), 2);
            return true;
        }
        return false;
    }

    public void func_70636_d() {
        super.func_70636_d();
        if (this.getLivesCount() >= this.numberOfLives() / 2) {
            // empty if block
        }
        if (this.field_70173_aa > 5) {
            this.circle();
        }
        if (this.phase == 0) {
            this.charge();
            this.launchSeeds();
        } else if (this.phase == 1) {
            this.rainComets();
            this.summonPortals();
        } else if (this.phase == 2) {
            this.launchSeeds();
            this.rainComets();
        } else if (this.phase == 3) {
            this.charge();
            this.warpReality();
        } else if (this.phase == 4) {
            this.rainComets();
            this.groupPlayers();
        } else if (this.phase == 5) {
            this.fireHomingBlights();
            this.groupPlayers();
        }
        this.updatePhase(this.phase);
    }

    private void fireHomingBlights() {
        if (!this.field_70170_p.field_72995_K && this.field_70173_aa % 80 == 20) {
            this.targetPlayers();
            if (this.targets != null) {
                for (LivingEntity entity : this.targets) {
                    EntityHomingBlight homer = new EntityHomingBlight(this.field_70170_p, (LivingEntity)this);
                    homer.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
                    homer.setTarget(entity);
                    homer.func_70186_c(0.0, 0.0, 0.0, 0.0f, 0.0f);
                    this.field_70170_p.func_72838_d((Entity)homer);
                }
            }
        }
    }

    private void groupPlayers() {
        if (!this.field_70170_p.field_72995_K && !this.pulled) {
            this.targetPlayers();
            if (this.targets != null) {
                double minDist = 99999.0;
                LivingEntity closest = null;
                for (LivingEntity entity : this.targets) {
                    double dist = this.func_174791_d().func_72438_d(entity.func_174791_d());
                    if (!(dist < minDist)) continue;
                    minDist = dist;
                    closest = entity;
                }
                for (LivingEntity target : this.targets) {
                    target.func_70634_a(closest.field_70165_t, closest.field_70163_u, closest.field_70161_v);
                }
                this.pulled = true;
            }
        }
    }

    private void warpReality() {
        double particleDiv = 0.5;
        this.targetMobs();
        if (this.offsetMobs == null && this.targets != null) {
            this.offsetMobs = new ArrayList();
            for (LivingEntity target : this.targets) {
                if (target.equals((Object)this)) continue;
                double x = this.field_70170_p.field_73012_v.nextDouble() * 5.0 - 2.5;
                double y = this.field_70170_p.field_73012_v.nextDouble() * 5.0 - 2.5;
                double z = this.field_70170_p.field_73012_v.nextDouble() * 5.0 - 2.5;
                AABB entityBox = target.func_174813_aQ().func_72317_d(x, y, z);
                target.func_174826_a(entityBox);
                this.offsetMobs.add(target);
            }
            this.targets = null;
        } else if (this.field_70170_p.field_72995_K && this.offsetMobs != null && this.field_70173_aa % 10 == 0) {
            for (LivingEntity offsetMob : this.offsetMobs) {
                AABB entityBox = offsetMob.func_174813_aQ();
                for (double i = entityBox.field_72340_a; i <= entityBox.field_72336_d; i += particleDiv) {
                    for (double j = entityBox.field_72338_b; j <= entityBox.field_72337_e; j += particleDiv) {
                        for (double k = entityBox.field_72339_c; k <= entityBox.field_72334_f; k += particleDiv) {
                            this.field_70170_p.func_175688_a(ParticleInit.CLAW_MARKS, i, j, k, (-0.5 + this.field_70146_Z.nextDouble()) * 3.0, 0.3, (-0.5 + this.field_70146_Z.nextDouble()) * 3.0, new int[0]);
                        }
                    }
                }
            }
        }
        this.targets = null;
    }

    private void charge() {
        if (!this.field_70170_p.field_72995_K) {
            if (this.swoopTarget == null) {
                double minDist = 99999.0;
                LivingEntity swoop = null;
                if (this.targets == null) {
                    this.targetPlayers();
                }
                for (LivingEntity entity : this.targets) {
                    double dist = this.func_174791_d().func_72438_d(entity.func_174791_d());
                    if (!(dist < minDist)) continue;
                    minDist = dist;
                    swoop = entity;
                }
                this.swoopTarget = swoop;
                this.swooped = false;
            } else if (!this.swooped && !this.swoopTarget.field_70128_L) {
                Vec3 dest = this.swoopTarget.func_174791_d().func_72441_c(0.0, 1.0, 0.0);
                Vec3 dir = dest.func_178788_d(this.func_174791_d());
                dir = dir.func_72432_b();
                double dist = this.func_174791_d().func_72438_d(dest);
                if (dist < 0.5) {
                    this.swooped = true;
                    return;
                }
                if (dist < 5.0) {
                    this.calculateVelocity(dir.field_72450_a * 3.0 / 3.0, dir.field_72448_b * 3.0 / 3.0, dir.field_72449_c * 3.0 / 3.0);
                } else {
                    this.calculateVelocity(dir.field_72450_a * 3.0, dir.field_72448_b * 3.0, dir.field_72449_c * 3.0);
                }
                this.field_70133_I = true;
            } else if (this.field_70173_aa % 140 == 20) {
                this.swoopTarget = null;
                this.swooped = false;
            }
        }
    }

    private void launchSeeds() {
        if (!this.field_70170_p.field_72995_K && this.field_70173_aa % 40 == 10) {
            EntityTentacleSeed seed = new EntityTentacleSeed(this.field_70170_p);
            seed.setThrower((LivingEntity)this);
            seed.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
            seed.func_70186_c(this.field_70170_p.field_73012_v.nextDouble() * 0.2 - 0.1, this.field_70170_p.field_73012_v.nextDouble() * 0.05 - 0.1, this.field_70170_p.field_73012_v.nextDouble() * 0.2 - 0.1, 1.0f, 4.0f);
            this.field_70170_p.func_72838_d((Entity)seed);
        }
    }

    private void rainComets() {
        if (!this.field_70170_p.field_72995_K) {
            if (this.targets == null) {
                this.targetPlayers();
            }
            for (LivingEntity entity : this.targets) {
                if (this.field_70173_aa % 10 != 5) continue;
                EntityBlightedComet comet = new EntityBlightedComet(this.field_70170_p, (LivingEntity)this);
                comet.func_70107_b(entity.field_70165_t + this.field_70170_p.field_73012_v.nextDouble() * 5.0 - 2.5, entity.field_70163_u + 40.0, entity.field_70161_v + this.field_70170_p.field_73012_v.nextDouble() * 5.0 - 2.5);
                comet.func_70186_c(0.0, -0.5, 0.0, 2.0f, 4.0f);
                this.field_70170_p.func_72838_d((Entity)comet);
            }
        }
    }

    private void summonPortals() {
        if (!this.field_70170_p.field_72995_K) {
            if (this.targets == null) {
                this.targetPlayers();
            }
            for (LivingEntity entity : this.targets) {
                if (this.field_70173_aa % 80 != 20) continue;
                EntityBossPortalEffect portal = new EntityBossPortalEffect(this.field_70170_p);
                portal.func_70107_b(entity.field_70165_t, entity.field_70163_u + (double)entity.field_70131_O + 2.0, entity.field_70161_v);
                portal.setCreator(this);
                this.field_70170_p.func_72838_d((Entity)portal);
                this.field_70170_p.func_184133_a(null, entity.func_180425_c(), SoundInit.PORTAL_OPEN, SoundSource.PLAYERS, 1.0f, 1.0f);
            }
        }
    }

    private void targetMobs() {
        this.targets = new ArrayList();
        for (LivingEntity entity : this.field_70170_p.func_72872_a(LivingEntity.class, this.func_174813_aQ().func_72314_b(9.0, 9.0, 9.0))) {
            if (entity instanceof Player || entity.equals((Object)this)) continue;
            this.targets.add(entity);
        }
    }

    private void targetPlayers() {
        this.targets = new ArrayList();
        for (ServerPlayer playerMP : this.field_70170_p.func_73046_m().func_184103_al().func_181057_v()) {
            if (!(playerMP.func_70011_f(this.field_70165_t, this.field_70163_u, this.field_70161_v) < 100.0)) continue;
            this.targets.add((LivingEntity)playerMP);
        }
    }

    private void circle() {
        if (!this.field_70170_p.field_72995_K && this.swoopTarget == null) {
            if (this.homePos == null) {
                this.homePos = new Vec3(-120.0, 108.0, 746.0);
                this.theta = 1.5707963267948966;
            }
            double yDiff = this.field_70163_u - this.homePos.field_72448_b;
            double xDiff = this.field_70165_t - this.homePos.field_72450_a;
            double zDiff = this.field_70161_v - this.homePos.field_72449_c;
            double distToCircle = Math.sqrt(Math.pow(xDiff, 2.0) + Math.pow(zDiff, 2.0)) - 50.0;
            if (Math.abs(yDiff) > 1.0) {
                Vec3 YVec = new Vec3(0.0, -yDiff, 0.0);
                YVec = YVec.func_72432_b();
                this.calculateVelocity(YVec.field_72450_a, YVec.field_72448_b, YVec.field_72449_c);
                this.field_70133_I = true;
            } else if (Math.abs(distToCircle) > 50.0) {
                Vec3 toHome = new Vec3(-xDiff + 50.0, 0.0, -zDiff);
                toHome = toHome.func_72432_b();
                this.calculateVelocity(toHome.field_72450_a, toHome.field_72448_b, toHome.field_72449_c);
                this.field_70133_I = true;
                this.theta = 1.5707963705062866;
            } else {
                this.theta += 0.06283185307179587;
                if (this.theta >= Math.PI * 2) {
                    this.theta -= Math.PI * 2;
                }
                double x1 = 50.0 * (double)Mth.func_76126_a((float)((float)this.theta)) + this.homePos.field_72450_a;
                double z1 = 50.0 * (double)Mth.func_76134_b((float)((float)this.theta)) + this.homePos.field_72449_c;
                Vec3 dir = new Vec3(x1 - this.field_70165_t, 0.0, z1 - this.field_70161_v);
                dir = dir.func_72432_b();
                this.calculateVelocity(dir.field_72450_a * 2.0, dir.field_72448_b * 2.0, dir.field_72449_c * 2.0);
                this.field_70133_I = true;
            }
        }
    }

    private void calculateVelocity(double x, double y, double z) {
        this.field_70159_w = x;
        this.field_70181_x = y;
        this.field_70179_y = z;
    }

    private void updatePhase(int phase) {
        --this.nextFormTimer;
        if (this.nextFormTimer == 0) {
            this.nextFormTimer = 80;
            this.swoopTarget = null;
            this.swooped = false;
            this.pulled = false;
            this.phase = phase < 5 ? ++this.phase : 0;
        }
    }

    protected SoundEvent func_184615_bR() {
        return SoundInit.GENERIC_STYLE3_DEATH;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundInit.GENERIC_STYLE3_HURT;
    }

    protected SoundEvent func_184639_G() {
        return null;
    }

    @Override
    protected int numberOfLives() {
        return 2000;
    }

    @Override
    protected void updateLifeAction() {
        int lifePercent = Math.round(100 * (this.numberOfLives() - this.getLivesCount()) / this.numberOfLives());
    }

    @Override
    public void trueDeathAction() {
    }

    protected boolean func_70692_ba() {
        return false;
    }
}

