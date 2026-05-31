/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.util.math.HitResult$Type
 *  net.minecraft.util.math.Rotations
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.world.World
 */
package xol.lostinfinity.projectile.entity;

import java.util.HashSet;
import java.util.Set;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.HitResult;
import net.minecraft.util.math.Rotations;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.mob.entity.base.EntityMultipleLives;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.math.LMath;

public class EntityCreepingVinePod
extends EntityBaseThrowable {
    private final Set<LivingEntity> pierced = new HashSet<LivingEntity>();
    private Vec3 initDirection;
    private Rotations currentDir;
    private Rotations randomDir;
    private int turnTick;

    public EntityCreepingVinePod(Level worldIn) {
        super(worldIn);
        this.func_70105_a(0.75f, 0.75f);
    }

    @Override
    public void setThrower(LivingEntity throwset) {
        super.setThrower(throwset);
        this.field_184539_c = throwset;
    }

    public void setInitDirection(Vec3 initDirection) {
        this.initDirection = initDirection;
        this.currentDir = LMath.toPitchYaw(initDirection);
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
        if (target == this.field_70192_c || this.pierced.contains(target)) {
            return;
        }
        if (!IMaxAttack.dealTrueDamage((Entity)this.field_70192_c, target, target.func_110138_aP() * 0.75f).wasTargetKilled() && target instanceof EntityMultipleLives) {
            EntityMultipleLives multiLifer = (EntityMultipleLives)target;
            ((EntityMultipleLives)target).takeawayNumLives(5);
        }
        this.pierced.add(target);
    }

    @Override
    public void func_70071_h_() {
        Vec3 motion;
        super.func_70071_h_();
        if (this.field_70170_p.field_72995_K) {
            this.field_70170_p.func_175682_a(ParticleInit.GALAXY_GREEN, true, this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0, 0.0, 0.0, new int[0]);
            return;
        }
        if (this.initDirection == null) {
            this.setInitDirection(LMath.fastNormalize(new Vec3(this.field_70159_w, this.field_70181_x, this.field_70179_y)));
        }
        if (--this.turnTick <= 0) {
            this.turnTick = 30;
            motion = LMath.fastNormalize(new Vec3((double)this.field_70146_Z.nextFloat() - 0.5 + this.initDirection.field_72450_a * 0.2, (double)this.field_70146_Z.nextFloat() - 0.5 + this.initDirection.field_72448_b * 0.2, (double)this.field_70146_Z.nextFloat() - 0.5 + this.initDirection.field_72449_c * 0.2));
            this.randomDir = LMath.toPitchYaw(motion);
        }
        this.currentDir = LMath.lerp(this.currentDir, this.randomDir, (double)(1.0f / (float)this.turnTick));
        motion = LMath.toLookVec(this.currentDir.func_179415_b(), this.currentDir.func_179416_c());
        this.field_70159_w = motion.field_72450_a * 0.25;
        this.field_70181_x = motion.field_72448_b * 0.25;
        this.field_70179_y = motion.field_72449_c * 0.25;
        this.field_70133_I = true;
    }

    protected float func_70185_h() {
        return 0.0f;
    }
}

