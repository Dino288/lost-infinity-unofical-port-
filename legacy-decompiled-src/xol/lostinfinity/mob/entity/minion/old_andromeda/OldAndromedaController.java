/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.math.Mth
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.minion.old_andromeda;

import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import xol.lostinfinity.mob.entity.classify.IKnockbackImmunity;
import xol.lostinfinity.mob.entity.classify.ILostMultiPart;
import xol.lostinfinity.mob.entity.minion.EntityMinion;
import xol.lostinfinity.mob.entity.minion.andromeda.EntityAndromedaChaser;
import xol.lostinfinity.mob.entity.minion.old_andromeda.OldAndromedaSegment;
import xol.lostinfinity.util.data.CustomDamageResult;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.math.BezierCurve;
import xol.lostinfinity.util.math.LMath;

public class OldAndromedaController
extends EntityMinion
implements ILostMultiPart,
IKnockbackImmunity {
    private static final List<String> DAMAGE_TYPE = Collections.singletonList("Aquatic");
    private static final int CYCLE_TICK = 100;
    private static final int PHASE_CHANGE_TICK = 20;
    private static final int CHARGE_COOLDOWN = 16;
    private final OldAndromedaSegment[] segments = new OldAndromedaSegment[10];
    private LivingEntity target;
    private Attack attack = Attack.IDLE;
    private Attack nextAttack = Attack.IDLE;
    private int attackCycleTick = 100;
    private int attackTransitionTick;
    private int chargeCooldown;
    private BezierCurve.Node chargeStartNode;
    private BezierCurve.Node chargeEndNode;
    private BezierCurve.Node chargeRandomNode;

    public OldAndromedaController(Level worldIn) {
        super(worldIn);
        this.func_70105_a(0.25f, 0.25f);
        this.field_70145_X = true;
        OldAndromedaSegment lastSegment = new OldAndromedaSegment.Head(worldIn, this);
        ((OldAndromedaSegment)lastSegment).updatePosition();
        this.segments[0] = lastSegment;
        for (int i = 1; i < this.segments.length - 1; ++i) {
            OldAndromedaSegment segment = new OldAndromedaSegment(worldIn, this, lastSegment);
            segment.updatePosition();
            lastSegment = segment;
            this.segments[i] = segment;
        }
        OldAndromedaSegment.Tail tail = new OldAndromedaSegment.Tail(worldIn, this, lastSegment);
        tail.updatePosition();
        this.segments[this.segments.length - 1] = tail;
        for (OldAndromedaSegment segment : this.segments) {
            segment.setSize(15);
        }
    }

    public void func_70071_h_() {
        super.func_70071_h_();
        for (OldAndromedaSegment segment : this.segments) {
            this.field_70170_p.func_72866_a((Entity)segment, true);
            segment.updatePosition();
        }
    }

    protected void func_82167_n(Entity entityIn) {
        if (this.field_70170_p.field_72995_K || !this.isActive()) {
            return;
        }
        if (this.validateTarget(entityIn)) {
            double dX = entityIn.field_70159_w;
            double dY = entityIn.field_70181_x;
            double dZ = entityIn.field_70179_y;
            CustomDamageResult damageResult = IMaxAttack.dealTrueDamage((Entity)this.getOwner(), (LivingEntity)entityIn, 100.0f, DAMAGE_TYPE);
            if (damageResult.didSuccessfulHit() && damageResult.targetHealthChanged()) {
                Vec3 dir = LMath.fastNormalize(new Vec3(this.field_70165_t - this.segments[0].field_70165_t, this.field_70163_u - this.segments[0].field_70163_u, this.field_70161_v - this.segments[0].field_70161_v));
                entityIn.field_70159_w = dX + dir.field_72450_a * 0.5;
                entityIn.field_70181_x = dY + dir.field_72448_b * 0.5;
                entityIn.field_70179_y = dZ + dir.field_72449_c * 0.5;
                entityIn.field_70133_I = true;
            }
        }
    }

    @Override
    public void func_70106_y() {
        super.func_70106_y();
        for (OldAndromedaSegment segment : this.segments) {
            this.field_70170_p.func_72973_f((Entity)segment);
        }
    }

    @Nullable
    public Entity[] func_70021_al() {
        return this.segments;
    }

    @Override
    protected void livingUpdate() {
        Player owner = this.getOwner();
        if (owner == null) {
            return;
        }
        if (!this.field_70170_p.field_72995_K) {
            if (this.attack != this.nextAttack) {
                if (this.attackTransitionTick >= 20) {
                    this.attackTransitionTick = 0;
                    this.attack = this.nextAttack;
                    this.getOwner().func_145747_a((Component)new Component("State: " + this.attack.name()));
                }
                if (this.attack != this.nextAttack) {
                    this.transitionTick();
                    ++this.attackTransitionTick;
                }
            }
            if (this.attack == this.nextAttack) {
                if (this.attack == Attack.IDLE || this.attackCycleTick >= 100) {
                    this.attackCycleTick = 0;
                    this.nextAttack = Attack.nextAttack(this.attack);
                }
                if (this.target == null || this.target.field_70128_L) {
                    this.target = null;
                    this.findClosestTarget();
                    if (this.target == null) {
                        this.nextAttack = Attack.IDLE;
                    }
                }
                if (this.target != null) {
                    this.setActive(true);
                    this.attackTick();
                } else if (this.attack == Attack.IDLE) {
                    this.setActive(false);
                    this.resetCharge();
                }
                ++this.attackCycleTick;
            }
        }
        if (!this.isActive()) {
            this.updatePosition();
        }
    }

    protected void transitionTick() {
        switch (this.nextAttack) {
            case IDLE: {
                float x = Mth.func_76126_a((float)((float)this.field_70173_aa * 0.05f)) * 5.0f;
                float y = Mth.func_76126_a((float)((float)this.field_70173_aa * 0.05f)) * 0.5f;
                float z = Mth.func_76134_b((float)((float)this.field_70173_aa * 0.05f)) * 5.0f;
                Vec3 targetPosition = new Vec3(this.owner.field_70165_t + (double)x, this.owner.field_70163_u + 2.0 + (double)y, this.owner.field_70161_v + (double)z);
                Vec3 location = LMath.lerp(this.func_174791_d(), targetPosition, (double)(1.0f / (float)(20 - this.attackTransitionTick)));
                this.func_70107_b(location.field_72450_a, location.field_72448_b, location.field_72449_c);
                break;
            }
            case CHARGE: {
                this.resetCharge();
                this.attackTransitionTick = 0;
                this.attack = this.nextAttack;
                break;
            }
            case TRACER: {
                float x = Mth.func_76126_a((float)((float)this.field_70173_aa * 0.15f)) * (this.target.field_70130_N + 5.0f);
                float y = Mth.func_76126_a((float)((float)this.field_70173_aa * 0.15f)) * 0.5f;
                float z = Mth.func_76134_b((float)((float)this.field_70173_aa * 0.15f)) * (this.target.field_70130_N + 5.0f);
                Vec3 targetPosition = LMath.getEntityMiddle((Entity)this.target).func_72441_c((double)x, (double)y, (double)z);
                Vec3 location = LMath.lerp(this.func_174791_d(), targetPosition, (double)(1.0f / (float)(20 - this.attackTransitionTick)));
                this.func_70107_b(location.field_72450_a, location.field_72448_b, location.field_72449_c);
                break;
            }
            case BEAM: {
                float x = Mth.func_76126_a((float)((float)this.field_70173_aa * 0.15f)) * (this.target.field_70130_N + 5.0f);
                float y = Mth.func_76126_a((float)((float)this.field_70173_aa * 0.5f));
                float z = Mth.func_76134_b((float)((float)this.field_70173_aa * 0.15f)) * (this.target.field_70130_N + 5.0f);
                Vec3 targetPosition = LMath.getEntityMiddle((Entity)this.target).func_72441_c((double)x, (double)y, (double)z);
                Vec3 location = LMath.lerp(this.func_174791_d(), targetPosition, (double)(1.0f / (float)(20 - this.attackTransitionTick)));
                this.func_70107_b(location.field_72450_a, location.field_72448_b, location.field_72449_c);
            }
        }
    }

    protected void attackTick() {
        switch (this.attack) {
            case CHARGE: {
                Vec3 pos;
                double half;
                if (this.chargeCooldown == 0) {
                    this.chargeCooldown = 16;
                    this.chargeStartNode = this.chargeRandomNode;
                    if (this.chargeStartNode == null) {
                        Vec3 randomNode = this.func_174791_d();
                        Vec3 randomDirection = LMath.fastNormalize(new Vec3(this.getRandomDouble(1.0), this.getRandomDouble(1.0), this.getRandomDouble(1.0)));
                        Vec3 randomStartHandle = randomNode.func_178787_e(randomDirection.func_186678_a(-20.0));
                        Vec3 randomEndHandle = randomNode.func_178787_e(randomDirection.func_186678_a(20.0));
                        this.chargeStartNode = new BezierCurve.Node(randomNode, randomStartHandle, randomEndHandle);
                    }
                    Vec3 targetNode = LMath.getEntityMiddle((Entity)this.target);
                    Vec3 slideDirection = LMath.fastNormalize(new Vec3(this.getRandomDouble(1.0) + (targetNode.field_72450_a - this.chargeStartNode.node.field_72450_a) * 0.1, this.getRandomDouble(1.0) + (targetNode.field_72448_b - this.chargeStartNode.node.field_72448_b) * 0.1, this.getRandomDouble(1.0) + (targetNode.field_72449_c - this.chargeStartNode.node.field_72449_c) * 0.1));
                    Vec3 targetStartHandle = targetNode.func_178787_e(slideDirection.func_186678_a(-10.0));
                    Vec3 targetEndHandle = targetNode.func_178787_e(slideDirection.func_186678_a(10.0));
                    this.chargeEndNode = new BezierCurve.Node(targetNode, targetStartHandle, targetEndHandle);
                    Vec3 randomNode = targetNode.func_178787_e(LMath.fastNormalize(new Vec3(targetNode.field_72450_a - this.chargeStartNode.node.field_72450_a, 0.0, targetNode.field_72449_c - this.chargeStartNode.node.field_72449_c)).func_186678_a(20.0)).func_178787_e(new Vec3(this.getRandomDouble(10.0), this.getRandomDouble(10.0), this.getRandomDouble(10.0)));
                    Vec3 randomDirection = LMath.fastNormalize(new Vec3(this.getRandomDouble(1.0), this.getRandomDouble(1.0), this.getRandomDouble(1.0)));
                    Vec3 randomStartHandle = randomNode.func_178787_e(randomDirection.func_186678_a(-20.0));
                    Vec3 randomEndHandle = randomNode.func_178787_e(randomDirection.func_186678_a(20.0));
                    this.chargeRandomNode = new BezierCurve.Node(randomNode, randomStartHandle, randomEndHandle);
                }
                if ((double)this.chargeCooldown >= (half = 8.0)) {
                    double ratio = 1.0 - ((double)this.chargeCooldown - half) / half;
                    pos = BezierCurve.lerpNodes(this.chargeStartNode, this.chargeEndNode, ratio);
                    this.func_70107_b(pos.field_72450_a, pos.field_72448_b, pos.field_72449_c);
                } else {
                    double ratio = 1.0 - (double)this.chargeCooldown / half;
                    pos = BezierCurve.lerpNodes(this.chargeEndNode, this.chargeRandomNode, ratio);
                    this.func_70107_b(pos.field_72450_a, pos.field_72448_b, pos.field_72449_c);
                }
                if ((double)this.chargeCooldown == half) {
                    this.func_82167_n((Entity)this.target);
                }
                --this.chargeCooldown;
                break;
            }
            case TRACER: {
                float x = Mth.func_76126_a((float)((float)this.field_70173_aa * 0.15f)) * (this.target.field_70130_N + 5.0f);
                float y = Mth.func_76126_a((float)((float)this.field_70173_aa * 0.15f)) * 0.5f;
                float z = Mth.func_76134_b((float)((float)this.field_70173_aa * 0.15f)) * (this.target.field_70130_N + 5.0f);
                Vec3 targetPosition = LMath.getEntityMiddle((Entity)this.target).func_72441_c((double)x, (double)y, (double)z);
                this.func_70107_b(targetPosition.field_72450_a, targetPosition.field_72448_b, targetPosition.field_72449_c);
                int segId = this.attackCycleTick % this.segments.length;
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
            case BEAM: {
                float x = Mth.func_76126_a((float)((float)this.field_70173_aa * 0.15f)) * (this.target.field_70130_N + 5.0f);
                float y = Mth.func_76126_a((float)((float)this.field_70173_aa * 0.5f));
                float z = Mth.func_76134_b((float)((float)this.field_70173_aa * 0.15f)) * (this.target.field_70130_N + 5.0f);
                Vec3 targetPosition = LMath.getEntityMiddle((Entity)this.target).func_72441_c((double)x, (double)y, (double)z);
                this.func_70107_b(targetPosition.field_72450_a, targetPosition.field_72448_b, targetPosition.field_72449_c);
                break;
            }
        }
    }

    protected void resetCharge() {
        this.chargeStartNode = null;
        this.chargeEndNode = null;
        this.chargeRandomNode = null;
        this.chargeCooldown = 0;
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

    private void updatePosition() {
        float x = Mth.func_76126_a((float)((float)this.field_70173_aa * 0.05f)) * 5.0f;
        float y = Mth.func_76126_a((float)((float)this.field_70173_aa * 0.05f)) * 0.5f;
        float z = Mth.func_76134_b((float)((float)this.field_70173_aa * 0.05f)) * 5.0f;
        this.func_70080_a(this.owner.field_70165_t + (double)x, this.owner.field_70163_u + 2.0 + (double)y, this.owner.field_70161_v + (double)z, 0.0f, 0.0f);
        this.field_70759_as = 0.0f;
        this.field_70761_aq = 0.0f;
    }

    private void findClosestTarget() {
        List targets = this.field_70170_p.func_175647_a(LivingEntity.class, this.owner.func_174813_aQ().func_186662_g(24.0), this::validateTarget);
        Vec3 pos = this.owner.func_174791_d();
        double targetDist = Double.MAX_VALUE;
        for (LivingEntity entity : targets) {
            double dist = LMath.getDistanceSquaredToAABB(pos, entity.func_174813_aQ());
            if (!(dist < targetDist)) continue;
            targetDist = dist;
            this.target = entity;
        }
    }

    public static enum Attack {
        IDLE,
        CHARGE,
        TRACER,
        BEAM;


        public static Attack nextAttack(Attack attack) {
            int i = attack.ordinal();
            Attack a = Attack.values()[(i + 1) % Attack.values().length];
            return a == IDLE ? CHARGE : a;
        }
    }
}

