/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityAgeable
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.player.Player
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.EnumParticleTypes
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Mth
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.world.EnumDifficulty
 *  net.minecraft.world.World
 *  net.minecraft.world.ServerLevel
 */
package xol.lostinfinity.mob.entity.misc;

import net.minecraft.world.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.Difficulty;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import xol.lostinfinity.dimension.data.FlightCurve;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.base.EntityMultiLivesTameable;
import xol.lostinfinity.projectile.entity.EntitySkycrabAttack;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntitySkycrab
extends EntityMultiLivesTameable
implements IMaxAttack {
    private LivingEntity target = null;
    private Double moveSpeed = 5.0;
    private static final double radius = 50.0;
    private static BlockPos homePos;
    private BlockPos goalPosition = null;
    private FlightCurve flightCurve = null;
    public static float radians;
    private boolean targeting = false;
    private int time = 0;
    private boolean aggressive = false;
    private static final double closeChaseSpeed = (double)0.2f;
    private static final double mediumChaseSpeed = (double)0.077f;
    private static final double swoopSpeed = 2.0;

    public EntitySkycrab(Level worldIn) {
        super(worldIn);
        this.func_70105_a(12.0f, 12.0f);
        this.func_189654_d(true);
    }

    protected void func_184651_r() {
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.0);
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(35000.0);
    }

    public boolean func_70652_k(Entity entity) {
        return false;
    }

    public void func_70636_d() {
        super.func_70636_d();
        this.field_70143_R = -1.0f;
        LivingEntity owner = this.func_70902_q();
        if (!this.field_70170_p.field_72995_K) {
            if (owner == null) {
                this.func_70106_y();
                return;
            }
            if (this.isAggressive()) {
                BlockPos goalPosition = this.getGoalPosition();
                LivingEntity targetEntity = this.getTarget();
                if (goalPosition == null || targetEntity == null) {
                    for (LivingEntity target : this.field_70170_p.func_72872_a(LivingEntity.class, this.func_174813_aQ().func_72314_b(50.0, 50.0, 50.0))) {
                        if (target.func_110124_au().equals(owner.func_110124_au()) || target.func_110124_au().equals(this.func_110124_au()) || this.field_70173_aa % 20 != 0 || this.isTargeting()) continue;
                        this.setTarget(target);
                        this.updateGoalPosition(target);
                    }
                    if (this.getGoalPosition() == null) {
                        double centreX = this.getHomePos().func_177958_n();
                        double centreZ = this.getHomePos().func_177952_p();
                        double X = this.func_180425_c().func_177958_n();
                        double Y = this.func_180425_c().func_177956_o();
                        double Z = this.func_180425_c().func_177952_p();
                        double xDiff = X - centreX;
                        double zDiff = Z - centreZ;
                        double distToCircle = Math.sqrt(Math.pow(xDiff, 2.0) + Math.pow(zDiff, 2.0)) - 50.0;
                        if (distToCircle > 50.0) {
                            this.moveToOrbit(this.func_180425_c().func_177958_n(), this.func_180425_c().func_177952_p(), this.getHomePos().func_177958_n(), this.getHomePos().func_177952_p());
                            radians = 1.5707964f;
                        } else {
                            this.circle();
                        }
                    }
                } else {
                    this.updateGoalPosition(targetEntity);
                    BlockPos pos = this.func_180425_c();
                    BlockPos goalPos = this.getGoalPosition();
                    double x = pos.func_177958_n();
                    double y = pos.func_177956_o();
                    double z = pos.func_177952_p();
                    double goalX = goalPos.func_177958_n();
                    double goalY = goalPos.func_177956_o();
                    double goalZ = goalPos.func_177952_p();
                    double xDiff = Math.abs(goalX - x);
                    double yDiff = Math.abs(goalY - y);
                    double zDiff = Math.abs(goalZ - z);
                    if (xDiff + yDiff + zDiff > 10.0) {
                        this.swoopToPosition();
                    } else if (xDiff + yDiff + zDiff < 5.0) {
                        if (this.field_70173_aa % 3 == 0) {
                            this.fire();
                        }
                        if (targetEntity.field_70128_L || this.time > 1000) {
                            this.time = 0;
                            this.setTarget(null);
                            this.setGoalPosition(null);
                        }
                    } else {
                        Vec3 toTarget = new Vec3(goalX - x, goalY - y, goalZ - z);
                        toTarget.func_72432_b();
                        if (goalX - x < 5.0 && goalZ - z < 5.0) {
                            this.calculateVelocity(toTarget.field_72450_a * (double)0.2f, toTarget.field_72448_b * (double)0.077f, toTarget.field_72449_c * (double)0.2f);
                        } else {
                            this.calculateVelocity(toTarget.field_72450_a * (double)0.077f, toTarget.field_72448_b * (double)0.077f, toTarget.field_72449_c * (double)0.077f);
                        }
                        this.field_70133_I = true;
                    }
                }
            } else {
                this.circle();
            }
            if (this.field_70170_p.func_175659_aa() == EnumDifficulty.PEACEFUL) {
                this.func_70106_y();
            }
            ++this.time;
        }
    }

    private boolean isTargeting() {
        return this.targeting;
    }

    public void setTargeting(boolean targeting) {
        this.targeting = targeting;
    }

    private void updateGoalPosition(LivingEntity target) {
        BlockPos targetPos;
        this.goalPosition = targetPos = target.func_180425_c().func_177963_a(0.0, (double)(target.field_70131_O + 10.0f), 0.0);
    }

    private LivingEntity getTarget() {
        return this.target;
    }

    public void setTarget(LivingEntity target) {
        this.target = target;
    }

    public BlockPos getGoalPosition() {
        return this.goalPosition;
    }

    public void circle() {
        if (this.getHomePos() != null) {
            double centreX = this.getHomePos().func_177958_n();
            double centreY = this.getHomePos().func_177956_o();
            double centreZ = this.getHomePos().func_177952_p();
            double X = this.func_180425_c().func_177958_n();
            double Y = this.func_180425_c().func_177956_o();
            double Z = this.func_180425_c().func_177952_p();
            double xDiff = X - centreX;
            double yDiff = Y - centreY;
            double zDiff = Z - centreZ;
            if (Math.abs(yDiff) > 1.0) {
                Vec3 YVec = new Vec3(0.0, -yDiff, 0.0);
                YVec = YVec.func_72432_b();
                this.calculateVelocity(YVec.field_72450_a, YVec.field_72448_b, YVec.field_72449_c);
                this.field_70133_I = true;
            } else {
                double distToCircle = Math.sqrt(Math.pow(xDiff, 2.0) + Math.pow(zDiff, 2.0)) - 50.0;
                if (Math.abs(distToCircle) > 50.0) {
                    this.moveToOrbit(X, Z, centreX, centreZ);
                } else {
                    float rads = 0.06283186f;
                    if ((double)(radians += rads) >= Math.PI * 2) {
                        radians = 0.0f;
                    }
                    double x1 = 50.0 * (double)Mth.func_76126_a((float)radians) + centreX;
                    double z1 = 50.0 * (double)Mth.func_76134_b((float)radians) + centreZ;
                    Vec3 dir = new Vec3(x1 - X, 0.0, z1 - Z);
                    dir = dir.func_72432_b();
                    this.calculateVelocity(dir.field_72450_a * 2.0, dir.field_72448_b * 2.0, dir.field_72449_c * 2.0);
                    this.field_70133_I = true;
                }
            }
        }
    }

    public void calculateVelocity(double x, double y, double z) {
        this.field_70159_w = x;
        this.field_70181_x = y;
        this.field_70179_y = z;
    }

    public void moveToOrbit(double X, double Z, double centreX, double centreZ) {
        double startX = centreX + 50.0;
        double startZ = centreZ;
        Vec3 toCentre = new Vec3(startX - X, 0.0, startZ - Z);
        toCentre = toCentre.func_72432_b();
        this.calculateVelocity(toCentre.field_72450_a, toCentre.field_72448_b, toCentre.field_72449_c);
        this.field_70133_I = true;
        radians = 1.5707964f;
    }

    public void swoopToPosition() {
        int remainder = this.field_70173_aa % 20;
        if (remainder == 0) {
            this.flightCurve = new FlightCurve(this.func_180425_c(), this.getGoalPosition(), this.moveSpeed);
        } else if (this.flightCurve != null) {
            Vec3 toTarget = new Vec3((double)(this.getGoalPosition().func_177958_n() - this.func_180425_c().func_177958_n()), (double)(this.getGoalPosition().func_177956_o() - this.func_180425_c().func_177956_o()), (double)(this.getGoalPosition().func_177952_p() - this.func_180425_c().func_177952_p()));
            toTarget = toTarget.func_72432_b();
            System.out.println(String.format("%f", this.flightCurve.getYVelocity((double)remainder / 100.0) * this.moveSpeed / 200.0));
            double xVel = toTarget.field_72450_a / 2.0;
            double yVel = toTarget.field_72448_b / 2.0 + this.flightCurve.getYVelocity((double)remainder / 20.0) * this.moveSpeed / 200.0;
            double zVel = toTarget.field_72449_c / 2.0;
            System.out.println(String.format("X: %f Y: %f Z: %f", xVel, yVel, zVel));
            this.calculateVelocity(xVel * 5.0, yVel * 5.0, zVel * 5.0);
            this.field_70133_I = true;
        }
    }

    @Override
    protected int numberOfLives() {
        return 10;
    }

    @Override
    protected void updateLifeAction() {
    }

    @Override
    public void trueDeathAction() {
        if (!this.field_70170_p.field_72995_K) {
            return;
        }
    }

    public void fire() {
        if (this.func_70902_q() != null) {
            EntitySkycrabAttack attack = new EntitySkycrabAttack(this.field_70170_p);
            attack.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
            attack.func_70186_c((this.field_70146_Z.nextDouble() - 0.5) * (double)0.1f, -0.1, (this.field_70146_Z.nextDouble() - 0.5) * (double)0.1f, 0.4f, 0.0f);
            attack.setThrower((LivingEntity)this);
            attack.setCrabOwner((Player)this.func_70902_q());
            ((ServerLevel)this.field_70170_p).func_175739_a(EnumParticleTypes.LAVA, this.field_70165_t, this.field_70163_u, this.field_70161_v, 2, this.field_70146_Z.nextDouble() * 3.0, 0.3, this.field_70146_Z.nextDouble() * 3.0, (double)0.15f, new int[0]);
            this.field_70170_p.func_72838_d((Entity)attack);
            this.func_184185_a(SoundInit.LASER_WEAPON_1, 1.5f, 0.7f + this.field_70146_Z.nextFloat() * 0.6f);
        }
    }

    protected SoundEvent func_184615_bR() {
        return SoundInit.SKYCRAB_DEATH;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundInit.SKYCRAB_HURT;
    }

    protected SoundEvent func_184639_G() {
        return SoundInit.SKYCRAB_AMBIENT;
    }

    public void playTargetSound() {
        this.func_184185_a(SoundInit.SKYCRAB_TARGET, 2.0f, 1.0f);
    }

    protected boolean func_70692_ba() {
        return this.func_70902_q() == null;
    }

    @Override
    public boolean func_70601_bi() {
        return this.field_70170_p.func_175659_aa() != EnumDifficulty.PEACEFUL;
    }

    @Override
    public EntityAgeable func_90011_a(EntityAgeable ageable) {
        return null;
    }

    public void setHomePos(BlockPos hpos) {
        homePos = hpos;
    }

    public BlockPos getHomePos() {
        return homePos;
    }

    @Override
    public void func_70014_b(CompoundTag tag) {
        super.func_70014_b(tag);
        tag.func_74768_a("HomePositionX", this.getHomePos().func_177958_n());
        tag.func_74768_a("HomePositionZ", this.getHomePos().func_177952_p());
        tag.func_74768_a("HomePositionY", this.getHomePos().func_177956_o());
        tag.func_74757_a("Aggressive", this.isAggressive());
    }

    public boolean isAggressive() {
        return this.aggressive;
    }

    public void setAggressive(boolean aggressive) {
        this.aggressive = aggressive;
    }

    @Override
    public void func_70037_a(CompoundTag tag) {
        super.func_70037_a(tag);
        BlockPos homePosition = new BlockPos(tag.func_74762_e("HomePositionX"), tag.func_74762_e("HomePositionY"), tag.func_74762_e("HomePositionZ"));
        this.setHomePos(homePosition);
        this.setAggressive(tag.func_74767_n("Aggressive"));
    }

    public void setGoalPosition(BlockPos targetPos) {
        this.goalPosition = targetPos;
    }

    static {
        radians = 0.0f;
    }
}

