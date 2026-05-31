/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.Mob
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.ai.EntityMoveHelper
 *  net.minecraft.entity.ai.EntityMoveHelper$Action
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.math.Mth
 *  net.minecraft.util.math.Rotations
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.minion.andromeda;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.Mth;
import net.minecraft.util.math.Rotations;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import xol.lostinfinity.mob.entity.classify.IKnockbackImmunity;
import xol.lostinfinity.mob.entity.classify.ILostMultiPart;
import xol.lostinfinity.mob.entity.minion.EntityMinion;
import xol.lostinfinity.mob.entity.minion.andromeda.EntityAndromedaChaser;
import xol.lostinfinity.mob.entity.minion.andromeda.EntityAndromedaSegment;
import xol.lostinfinity.util.data.CustomDamageResult;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.math.LMath;

public class EntityAndromedaController
extends EntityMinion
implements ILostMultiPart,
IKnockbackImmunity {
    private static final List<String> DAMAGE_TYPE = Collections.singletonList("Aquatic");
    private static final int CHARGE_COOLDOWN = 30;
    private static final int TURN_TIME = 30;
    private final EntityAndromedaSegment[] segments = new EntityAndromedaSegment[60];
    private final AndromedaMoveHelper andromedaMoveHelper;
    private LivingEntity target;
    private int syncTick;
    private Vec3 syncPos;
    private Attack attack = Attack.CHARGE;
    private int chargeCooldown;
    private int turnTick;
    private Vec3 chargeDir;

    public EntityAndromedaController(Level worldIn) {
        super(worldIn);
        this.func_70105_a(0.25f, 0.25f);
        this.field_70145_X = true;
        this.andromedaMoveHelper = new AndromedaMoveHelper(this);
        this.field_70765_h = this.andromedaMoveHelper;
        this.func_110163_bv();
        this.populateSegments();
    }

    @Override
    protected boolean func_70692_ba() {
        return false;
    }

    @Override
    protected void onDeath() {
        for (int i = 0; i < this.segments.length; ++i) {
            EntityAndromedaSegment segment = this.segments[i];
            segment.func_70106_y();
            this.field_70170_p.func_72973_f((Entity)segment);
            segment.cleanUp();
            this.segments[i] = null;
        }
    }

    @Override
    protected void livingUpdate() {
        if (this.field_70170_p.field_72995_K || this.field_70128_L) {
            return;
        }
        if (this.field_70173_aa % 400 == 0) {
            this.attack = Attack.cycle(this.attack);
        }
        if (this.target == null || this.target.field_70128_L || this.target.func_70068_e((Entity)this.owner) > 9216.0 || !this.isInRangeOfOwner()) {
            this.findClosestTarget();
        }
        if (this.target != null) {
            switch (this.attack) {
                case CHARGE: {
                    if (this.chargeCooldown <= 0) {
                        Vec3 targetPos = LMath.getEntityMiddle((Entity)this.target);
                        Vec3 delta = LMath.fastNormalize(targetPos.func_178788_d(this.func_174791_d()));
                        Vec3 motion = LMath.fastNormalize(new Vec3(this.field_70159_w, this.field_70181_x, this.field_70179_y));
                        Rotations rotations = LMath.lerp(LMath.toPitchYaw(motion), LMath.toPitchYaw(delta), (double)(1.0f / (float)this.turnTick));
                        Vec3 finalMotion = LMath.toLookVec(rotations.func_179415_b(), rotations.func_179416_c());
                        double speed = Math.max(LMath.fastLength(this.target.field_70159_w, this.target.field_70181_x, this.target.field_70179_y) * 1.5, 2.0);
                        this.field_70159_w = finalMotion.field_72450_a * speed;
                        this.field_70181_x = finalMotion.field_72448_b * speed;
                        this.field_70179_y = finalMotion.field_72449_c * speed;
                        this.field_70133_I = true;
                        if (this.func_70092_e(targetPos.field_72450_a, targetPos.field_72448_b, targetPos.field_72449_c) < 9.0) {
                            this.chargeCooldown = 30;
                        }
                        if (--this.turnTick > 0) break;
                        this.turnTick = 30;
                        break;
                    }
                    this.turnTick = 30;
                    if (this.chargeDir == null) {
                        this.chargeDir = new Vec3(this.field_70159_w, this.field_70181_x, this.field_70179_y);
                    }
                    this.field_70159_w = this.chargeDir.field_72450_a;
                    this.field_70181_x = this.chargeDir.field_72448_b;
                    this.field_70179_y = this.chargeDir.field_72449_c;
                    this.field_70133_I = true;
                    if (--this.chargeCooldown != 0) break;
                    this.chargeDir = null;
                    break;
                }
                case TRACER: {
                    int tick = this.field_70173_aa / 4;
                    if (this.field_70173_aa % 4 != 0) break;
                    int segId = tick % this.segments.length;
                    Vec3 pos = this.segments[segId].func_174791_d();
                    Vec3 dir = LMath.fastNormalize(LMath.getEntityMiddle((Entity)this.target).func_178788_d(pos));
                    EntityAndromedaChaser chaser = new EntityAndromedaChaser(this.field_70170_p);
                    chaser.setTarget(this.target);
                    chaser.setThrower((LivingEntity)this);
                    chaser.setSecondaryThrower((LivingEntity)this.owner);
                    chaser.func_70107_b(pos.field_72450_a, pos.field_72448_b, pos.field_72449_c);
                    chaser.field_70159_w = dir.field_72450_a;
                    chaser.field_70181_x = dir.field_72448_b;
                    chaser.field_70179_y = dir.field_72449_c;
                    this.field_70170_p.func_72838_d((Entity)chaser);
                    break;
                }
            }
        }
        if (!(this.target != null && this.attack == Attack.CHARGE || this.isInRangeOfOwner() && !this.andromedaMoveHelper.hasArrived())) {
            double dX = this.owner.field_70165_t + this.getRandomDouble(128.0);
            double dY = this.owner.field_70163_u + 60.0 + this.getRandomDouble(16.0);
            double dZ = this.owner.field_70161_v + this.getRandomDouble(128.0);
            this.andromedaMoveHelper.func_75642_a(dX, dY, dZ, 1.0);
        }
        if (!this.isInRangeOfOwner(96.0)) {
            this.syncTick = 10;
            this.syncPos = new Vec3(this.getRandomDouble(32.0), 0.0, this.getRandomDouble(32.0));
        }
        if (this.syncTick > 0) {
            float f = 1.0f / (float)this.syncTick;
            this.func_70634_a(Mth.func_151238_b((double)this.field_70165_t, (double)(this.owner.field_70165_t + this.syncPos.field_72450_a), (double)f), this.field_70163_u, Mth.func_151238_b((double)this.field_70161_v, (double)(this.owner.field_70161_v + this.syncPos.field_72449_c), (double)f));
            --this.syncTick;
        }
        if (this.field_70173_aa % 10 == 0) {
            HashSet targets = new HashSet();
            for (EntityAndromedaSegment segment : this.segments) {
                List segList = this.field_70170_p.func_175674_a((Entity)segment, segment.func_174813_aQ(), this::validateTarget);
                targets.addAll(segList);
            }
            if (targets.isEmpty()) {
                return;
            }
            targets.forEach(entity -> {
                LivingEntity livingBase = (LivingEntity)entity;
                IMaxAttack.dealTrueDamage((Entity)this.owner, livingBase, livingBase.func_110138_aP() * 2.0f, DAMAGE_TYPE);
            });
        }
    }

    @Override
    public boolean shouldRender() {
        return true;
    }

    @Override
    protected boolean validateTarget(Entity input) {
        if (input instanceof EntityAndromedaController || input instanceof EntityAndromedaSegment) {
            return false;
        }
        return super.validateTarget(input);
    }

    public void func_70071_h_() {
        super.func_70071_h_();
        if (this.field_70128_L) {
            return;
        }
        for (EntityAndromedaSegment segment : this.segments) {
            this.field_70170_p.func_72866_a((Entity)segment, true);
            segment.updatePosition();
        }
    }

    public boolean func_70072_I() {
        return false;
    }

    public boolean func_180799_ab() {
        return false;
    }

    @Nullable
    public Entity[] func_70021_al() {
        return this.field_70128_L ? null : this.segments;
    }

    @Override
    public float getKnockbackResistance(CustomDamageResult damageResult) {
        return 1.0f;
    }

    @Override
    public boolean attackEntityFromPart(LivingEntity part, DamageSource source, float damage) {
        return false;
    }

    public Level func_82194_d() {
        return this.field_70170_p;
    }

    protected boolean isInRangeOfOwner() {
        return this.isInRangeOfOwner(96.0);
    }

    protected boolean isInRangeOfOwner(double dist) {
        return this.func_70092_e(this.owner.field_70165_t, this.field_70163_u, this.owner.field_70161_v) <= dist * dist;
    }

    private void populateSegments() {
        EntityAndromedaSegment lastSegment = new EntityAndromedaSegment.Head(this.field_70170_p, this);
        lastSegment.updatePosition();
        lastSegment.setId(0);
        this.segments[0] = lastSegment;
        for (int i = 1; i < this.segments.length - 1; ++i) {
            EntityAndromedaSegment segment = new EntityAndromedaSegment(this.field_70170_p, this, lastSegment);
            segment.updatePosition();
            lastSegment = segment;
            segment.setId(i);
            this.segments[i] = segment;
        }
        EntityAndromedaSegment.Tail tail = new EntityAndromedaSegment.Tail(this.field_70170_p, this, lastSegment);
        tail.updatePosition();
        tail.setId(this.segments.length - 1);
        this.segments[this.segments.length - 1] = tail;
        for (EntityAndromedaSegment segment : this.segments) {
            segment.setSize(15);
        }
    }

    private void findClosestTarget() {
        this.target = null;
        List targets = this.field_70170_p.func_175647_a(LivingEntity.class, this.owner.func_174813_aQ().func_186662_g(96.0), this::validateTarget);
        Vec3 pos = this.owner.func_174791_d();
        double targetDist = Double.MAX_VALUE;
        for (LivingEntity entity : targets) {
            double dist = LMath.getDistanceSquaredToAABB(pos, entity.func_174813_aQ());
            if (!(dist < targetDist)) continue;
            targetDist = dist;
            this.target = entity;
        }
    }

    private static enum Attack {
        CHARGE,
        TRACER;


        private static Attack cycle(Attack attack) {
            return Attack.values()[(attack.ordinal() + 1) % Attack.values().length];
        }
    }

    private static class AndromedaMoveHelper
    extends EntityMoveHelper {
        private final EntityAndromedaController parentEntity;
        private int turnTick = 20;

        public AndromedaMoveHelper(EntityAndromedaController andromeda) {
            super((Mob)andromeda);
            this.parentEntity = andromeda;
        }

        protected boolean hasArrived() {
            double d2;
            double d1;
            double d0 = this.func_179917_d() - this.parentEntity.field_70165_t;
            double d3 = d0 * d0 + (d1 = this.func_179919_e() - this.parentEntity.field_70163_u) * d1 + (d2 = this.func_179918_f() - this.parentEntity.field_70161_v) * d2;
            return d3 < 36.0 || d3 > 9216.0;
        }

        public void func_75641_c() {
            if (this.parentEntity.target != null && this.parentEntity.attack == Attack.CHARGE) {
                return;
            }
            if (this.field_188491_h == EntityMoveHelper.Action.MOVE_TO) {
                Vec3 delta = this.getMoveDir(new Vec3(this.func_179917_d(), this.func_179919_e(), this.func_179918_f()));
                this.parentEntity.field_70159_w = delta.field_72450_a * this.field_75645_e;
                this.parentEntity.field_70181_x = delta.field_72448_b * this.field_75645_e;
                this.parentEntity.field_70179_y = delta.field_72449_c * this.field_75645_e;
            }
        }

        private Vec3 getMoveDir(Vec3 targetPos) {
            Vec3 delta = LMath.fastNormalize(targetPos.func_178788_d(this.parentEntity.func_174791_d()));
            Vec3 motion = LMath.fastNormalize(new Vec3(this.parentEntity.field_70159_w, this.parentEntity.field_70181_x, this.parentEntity.field_70179_y));
            Rotations rotations = LMath.lerp(LMath.toPitchYaw(motion), LMath.toPitchYaw(delta), (double)(1.0f / (float)this.turnTick));
            if (--this.turnTick <= 0) {
                this.turnTick = 20;
            }
            return LMath.toLookVec(rotations.func_179415_b(), rotations.func_179416_c());
        }
    }
}

