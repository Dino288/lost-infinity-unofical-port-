/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.util.math.HitResult$Type
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.world.World
 */
package xol.lostinfinity.projectile.entity;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import xol.lostinfinity.client.fx.ClientParticleRenderer;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.math.BezierCurve;
import xol.lostinfinity.util.math.LMath;

public class EntityCreepingVinePodOld
extends EntityBaseThrowable {
    private static final CustomParticleConfig config = new CustomParticleConfig();
    private Vec3 initDirection;
    private final LinkedList<BezierCurve.Node> path = new LinkedList();
    private final Set<LivingEntity> pierced = new HashSet<LivingEntity>();

    public EntityCreepingVinePodOld(Level worldIn) {
        super(worldIn);
        this.func_70105_a(0.75f, 0.75f);
    }

    public void setInitDirection(Vec3 initDirection) {
        this.initDirection = initDirection;
        Vec3 node = this.func_174791_d();
        Vec3 startHandle = node.func_178788_d(initDirection.func_186678_a(2.0));
        Vec3 endHandle = node.func_178787_e(initDirection.func_186678_a(2.0));
        this.path.add(new BezierCurve.Node(node, startHandle, endHandle));
    }

    @Override
    public void setThrower(LivingEntity throwset) {
        super.setThrower(throwset);
        this.field_184539_c = throwset;
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (this.field_70170_p.field_72995_K) {
            return;
        }
        if (result.field_72313_a != HitResult.Type.ENTITY) {
            return;
        }
        if (!(result.field_72308_g instanceof LivingEntity)) {
            return;
        }
        LivingEntity target = (LivingEntity)result.field_72308_g;
        if (this.pierced.contains(target)) {
            return;
        }
        IMaxAttack.dealTrueDamage((Entity)this.field_70192_c, target, 100.0f);
        this.pierced.add(target);
    }

    @Override
    public void func_70071_h_() {
        if (this.field_70128_L) {
            this.path.clear();
            this.pierced.clear();
            return;
        }
        if (this.field_70170_p.field_72995_K) {
            this.field_70142_S = this.field_70165_t;
            this.field_70137_T = this.field_70163_u;
            this.field_70136_U = this.field_70161_v;
            config.setOrigin(this.field_70165_t, this.field_70163_u, this.field_70161_v);
            ClientParticleRenderer.renderComplex(config);
            return;
        }
        super.func_70071_h_();
        if (this.initDirection == null) {
            this.func_70106_y();
            return;
        }
        int tick = this.field_70173_aa % 60;
        if (tick == 0) {
            this.path.pop();
            this.createRandomNode();
        }
        while (this.path.size() <= 1) {
            this.createRandomNode();
        }
        Vec3 c = BezierCurve.lerpNodes(this.path.get(0), this.path.get(1), (double)tick / 60.0);
        Vec3 motion = c.func_178786_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
        this.field_70159_w = motion.field_72450_a;
        this.field_70181_x = motion.field_72448_b;
        this.field_70179_y = motion.field_72449_c;
        this.func_70012_b(c.field_72450_a, c.field_72448_b, c.field_72449_c, this.field_70177_z, this.field_70125_A);
    }

    public void func_180426_a(double x, double y, double z, float yaw, float pitch, int posRotationIncrements, boolean teleport) {
        super.func_180426_a(x, y, z, yaw, pitch, posRotationIncrements, teleport);
    }

    protected float func_70185_h() {
        return 0.0f;
    }

    private void createRandomNode() {
        double pX = this.field_70165_t;
        double pY = this.field_70163_u;
        double pZ = this.field_70161_v;
        if (this.path.size() >= 1) {
            BezierCurve.Node node = this.path.get(0);
            pX = node.node.field_72450_a;
            pY = node.node.field_72448_b;
            pZ = node.node.field_72449_c;
        }
        Vec3 handleStart = LMath.fastNormalize(new Vec3((double)this.field_70146_Z.nextFloat() - 0.5 + this.initDirection.field_72450_a * 0.25, (double)this.field_70146_Z.nextFloat() - 0.5 + this.initDirection.field_72448_b * 0.25, (double)this.field_70146_Z.nextFloat() - 0.5 + this.initDirection.field_72449_c * 0.25)).func_186678_a(4.0).func_72441_c(pX, pY, pZ);
        Vec3 randDir = LMath.fastNormalize(new Vec3(this.initDirection.field_72450_a * (double)this.field_70146_Z.nextFloat(), this.initDirection.field_72448_b * (double)this.field_70146_Z.nextFloat(), this.initDirection.field_72449_c * (double)this.field_70146_Z.nextFloat())).func_186678_a(8.0);
        Vec3 node = handleStart.func_178787_e(randDir);
        Vec3 handleEnd = node.func_178787_e(randDir);
        this.path.add(new BezierCurve.Node(node, handleStart, handleEnd));
    }

    static {
        config.createInstance().setIgnoreRange(true).setParticle(ParticleInit.GALAXY_GREEN);
    }
}

