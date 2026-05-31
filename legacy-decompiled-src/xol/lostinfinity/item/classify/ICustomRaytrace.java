/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.util.EnumParticleTypes
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.world.World
 *  net.minecraft.world.ServerLevel
 */
package xol.lostinfinity.item.classify;

import java.util.function.Predicate;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import xol.lostinfinity.mob.entity.base.EntityImmaterial;
import xol.lostinfinity.util.data.CustomHitResult;

public interface ICustomRaytrace {
    public static final Predicate<Entity> ANTI_IMMATERIAL = entity -> !(entity instanceof EntityImmaterial);

    default public CustomHitResult simpleBlockTrace(Level world, LivingEntity entityFrom, int distance) {
        return this.doRayTrace(world, (Entity)entityFrom, distance, null, 0, 1, false, null, 1, 1, 0.3f, null);
    }

    default public CustomHitResult forwardTrace(Level world, Entity entityFrom, int distance) {
        return this.doRayTrace(world, entityFrom, distance, null, 0, 0, true, null, 1, 1, 0.3f, null);
    }

    default public CustomHitResult immaterialTrace(Level world, LivingEntity entityFrom, int distance) {
        return this.doRayTrace(world, (Entity)entityFrom, distance, null, 0, 2, false, null, 1, 1, 0.3f, null);
    }

    default public CustomHitResult entityTrace(Level world, LivingEntity entityFrom, int distance, Class<? extends Entity> entityclass) {
        return this.doRayTrace(world, (Entity)entityFrom, distance, null, 0, 1, false, entityclass, 1, 1, 0.3f, ANTI_IMMATERIAL);
    }

    default public CustomHitResult entitiesTrace(Level world, LivingEntity entityFrom, int distance, Class<? extends Entity> entityclass, int count) {
        return this.doRayTrace(world, (Entity)entityFrom, distance, null, 0, 1, false, entityclass, count, 1, 0.3f, ANTI_IMMATERIAL);
    }

    default public CustomHitResult standardFXTrace(Level world, LivingEntity entityFrom, int distance, EnumParticleTypes trailFX, Class<? extends Entity> stopEntityType) {
        return this.doRayTrace(world, (Entity)entityFrom, distance, trailFX, 3, 1, false, stopEntityType, 1, 1, 0.3f, ANTI_IMMATERIAL);
    }

    default public CustomHitResult forcedDistanceTrace(Level world, Entity entityFrom, int distance) {
        return this.doRayTrace(world, entityFrom, distance, null, 0, 1, true, null, 1, 1, 0.3f, null);
    }

    default public CustomHitResult complexTrace(Level world, LivingEntity entityFrom, int distance, EnumParticleTypes trailFX, int trailDelay, int blockType, boolean forceResult, Class<? extends Entity> stopEntityType, int lookYOffset, float expand) {
        return this.doRayTrace(world, (Entity)entityFrom, distance, trailFX, trailDelay, blockType, forceResult, stopEntityType, 1, lookYOffset, expand, ANTI_IMMATERIAL);
    }

    default public CustomHitResult predicateTrace(Level world, LivingEntity entityFrom, int distance, EnumParticleTypes trailFX, int trailDelay, int blockType, boolean forceResult, Class<? extends Entity> stopEntityType, int lookYOffset, float expand, Predicate<Entity> entityPredicate) {
        return this.doRayTrace(world, (Entity)entityFrom, distance, trailFX, trailDelay, blockType, forceResult, stopEntityType, 1, lookYOffset, expand, entityPredicate);
    }

    default public CustomHitResult doRayTrace(Level world, Entity entityFrom, int distance, EnumParticleTypes trailFX, int trailDelay, int stopBlock, boolean forceResult, Class<? extends Entity> stopEntityType, int maxEntity, int lookYOffset, float inaccuracy, Predicate<Entity> entityPredicate) {
        Vec3 vec = entityFrom.func_70040_Z();
        Vec3 modifiedLookPosition = lookYOffset != 0 ? new Vec3(entityFrom.field_70165_t, entityFrom.field_70163_u + 1.5, entityFrom.field_70161_v) : new Vec3(entityFrom.field_70165_t, entityFrom.field_70163_u, entityFrom.field_70161_v);
        CustomHitResult result = new CustomHitResult();
        for (int i = 0; i <= distance; ++i) {
            Vec3 nextPos = modifiedLookPosition.func_72441_c(vec.field_72450_a * (double)i, vec.field_72448_b * (double)i, vec.field_72449_c * (double)i);
            AABB blockBox = new AABB(nextPos.field_72450_a - 0.1, nextPos.field_72448_b - 0.1, nextPos.field_72449_c - 0.1, nextPos.field_72450_a + 0.1, nextPos.field_72448_b + 0.1, nextPos.field_72449_c + 0.1).func_186662_g((double)inaccuracy);
            if (trailFX != null && i >= trailDelay && !world.field_72995_K) {
                Vec3 center_vec = new Vec3(blockBox.field_72340_a + (blockBox.field_72336_d - blockBox.field_72340_a) * 0.5, blockBox.field_72338_b + (blockBox.field_72337_e - blockBox.field_72338_b) * 0.5, blockBox.field_72339_c + (blockBox.field_72334_f - blockBox.field_72339_c) * 0.5);
                ((ServerLevel)world).func_180505_a(trailFX, true, center_vec.field_72450_a, center_vec.field_72448_b, center_vec.field_72449_c, 3, 0.0, 0.0, 0.0, 0.0, new int[0]);
            }
            if (stopEntityType != null) {
                for (Entity near_entity : world.func_72872_a(stopEntityType, blockBox)) {
                    if (near_entity.func_110124_au().equals(entityFrom.func_110124_au()) || entityPredicate != null && !entityPredicate.test(near_entity)) continue;
                    result.addResultEntity(near_entity);
                    if (maxEntity <= 0 || result.getResultEntities().size() < maxEntity) continue;
                    result.setResultPos(nextPos);
                    return result;
                }
            }
            if (stopBlock <= 0) continue;
            BlockState stateResult = world.func_180495_p(new BlockPos(nextPos));
            if (world.func_175623_d(new BlockPos(nextPos)) || !stateResult.func_185904_a().func_76230_c() && stopBlock != 2) continue;
            Vec3 referencePos = modifiedLookPosition.func_72441_c(vec.field_72450_a * (double)(i - 1), vec.field_72448_b * (double)(i - 1), vec.field_72449_c * (double)(i - 1));
            result.setResultPos(referencePos);
            result.setGrabbedVector(nextPos);
            return result;
        }
        if (forceResult) {
            Vec3 forcedVec = modifiedLookPosition.func_72441_c(vec.field_72450_a * (double)distance, vec.field_72448_b * (double)distance, vec.field_72449_c * (double)distance);
            result.setResultPos(forcedVec);
            return result;
        }
        return result.isModified() ? result : null;
    }
}

