/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Predicate
 *  javax.annotation.Nullable
 *  net.minecraft.block.material.Material
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.EnumParticleTypes
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.world.World
 *  net.minecraft.world.ServerLevel
 */
package xol.lostinfinity.util.data;

import com.google.common.base.Predicate;
import javax.annotation.Nullable;
import net.minecraft.block.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import xol.lostinfinity.mob.entity.base.EntityImmaterial;
import xol.lostinfinity.util.data.CustomHitResult;

public class RayTraceBuilder {
    private int distance;
    private float raySize;
    private boolean force;
    private Predicate<BlockState> blockFilter;
    private Class<? extends Entity> entityClass;
    private Predicate<Entity> entityFilter;
    private int maxEntity;
    private EnumParticleTypes trailFX;
    private int trailDelay;
    private CustomTrace customTrace;

    public static RayTraceBuilder block(int distance) {
        return new RayTraceBuilder().distance(distance).raySize(0.4f).blockFilter((Predicate<BlockState>)((Predicate)RayTraceBuilder::checkSolid));
    }

    public static RayTraceBuilder forward(int distance) {
        return new RayTraceBuilder().distance(distance).raySize(0.4f).force(true);
    }

    public static RayTraceBuilder immaterial(int distance) {
        return new RayTraceBuilder().distance(distance).raySize(0.4f).blockFilter((Predicate<BlockState>)((Predicate)RayTraceBuilder::checkNotAir));
    }

    public static RayTraceBuilder entity(Class<? extends Entity> entityClass, int distance) {
        return new RayTraceBuilder().distance(distance).raySize(0.4f).blockFilter((Predicate<BlockState>)((Predicate)RayTraceBuilder::checkSolid)).entityClass(entityClass).entityFilter((Predicate<Entity>)((Predicate)RayTraceBuilder::checkEntityImmaterial));
    }

    public static RayTraceBuilder fx(Class<? extends Entity> entityClass, int distance, EnumParticleTypes trailFX) {
        return new RayTraceBuilder().distance(distance).raySize(0.4f).blockFilter((Predicate<BlockState>)((Predicate)RayTraceBuilder::checkSolid)).entityClass(entityClass).entityFilter((Predicate<Entity>)((Predicate)RayTraceBuilder::checkEntityImmaterial)).trailFX(trailFX).trailDelay(3);
    }

    public static RayTraceBuilder force(int distance) {
        return new RayTraceBuilder().distance(distance).raySize(0.4f).force(true).blockFilter((Predicate<BlockState>)((Predicate)RayTraceBuilder::checkSolid));
    }

    public RayTraceBuilder distance(int distance) {
        this.distance = distance;
        return this;
    }

    public RayTraceBuilder raySize(float raySize) {
        this.raySize = Math.max(0.1f, raySize);
        return this;
    }

    public RayTraceBuilder force(boolean force) {
        this.force = force;
        return this;
    }

    public RayTraceBuilder blockFilter(Predicate<BlockState> filter) {
        this.blockFilter = filter;
        return this;
    }

    public RayTraceBuilder entityClass(Class<? extends Entity> entityClass) {
        this.entityClass = entityClass;
        return this;
    }

    public RayTraceBuilder entityFilter(Predicate<Entity> filter) {
        this.entityFilter = filter;
        return this;
    }

    public RayTraceBuilder maxEntity(int maxEntity) {
        this.maxEntity = maxEntity;
        return this;
    }

    public RayTraceBuilder trailFX(EnumParticleTypes trailFX) {
        this.trailFX = trailFX;
        return this;
    }

    public RayTraceBuilder trailDelay(int trailDelay) {
        this.trailDelay = trailDelay;
        return this;
    }

    public RayTraceBuilder custom(CustomTrace customTrace) {
        this.customTrace = customTrace;
        return this;
    }

    public CustomHitResult trace(Entity entity, boolean useEyeHeight) {
        return this.trace(entity.field_70170_p, entity, useEyeHeight ? entity.func_174824_e(1.0f) : entity.func_174791_d(), entity.func_70040_Z());
    }

    public CustomHitResult trace(Level world, @Nullable Entity entity, Vec3 pos, Vec3 dir) {
        CustomHitResult result = new CustomHitResult();
        Vec3 lastPos = pos;
        for (int i = 0; i <= this.distance; ++i) {
            BlockState blockState;
            Vec3 nextPos = pos.func_178787_e(dir.func_186678_a((double)i));
            AABB boundingBox = new AABB(nextPos.field_72450_a, nextPos.field_72448_b, nextPos.field_72449_c, nextPos.field_72450_a, nextPos.field_72448_b, nextPos.field_72449_c).func_186662_g((double)this.raySize);
            if (this.trailFX != null && i >= this.trailDelay && !world.field_72995_K) {
                ((ServerLevel)world).func_180505_a(this.trailFX, true, nextPos.field_72450_a, nextPos.field_72448_b, nextPos.field_72449_c, 3, 0.0, 0.0, 0.0, 0.0, new int[0]);
            }
            if (this.entityClass != null) {
                for (Entity nearEntity : world.func_175647_a(this.entityClass, boundingBox, this.entityFilter)) {
                    if (nearEntity == entity) continue;
                    result.addResultEntity(nearEntity);
                    if (this.maxEntity <= 0 || result.getResultEntities().size() < this.maxEntity) continue;
                    result.setResultPos(nextPos);
                    return result;
                }
            }
            if (this.blockFilter != null && this.blockFilter.apply((Object)(blockState = world.func_180495_p(new BlockPos(nextPos))))) {
                result.setResultPos(lastPos);
                result.setGrabbedVector(nextPos);
                return result;
            }
            if (this.customTrace != null) {
                this.customTrace.trace(lastPos, nextPos, i);
            }
            lastPos = nextPos;
        }
        if (this.force) {
            result.setResultPos(lastPos);
            return result;
        }
        return result.isModified() ? result : null;
    }

    public static boolean checkSolid(BlockState block) {
        return block.func_185904_a() != Material.field_151579_a && block.func_185904_a().func_76230_c();
    }

    public static boolean checkImmaterial(BlockState block) {
        return block.func_185904_a() != Material.field_151579_a && !block.func_185904_a().func_76230_c();
    }

    public static boolean checkNotAir(BlockState block) {
        return block.func_185904_a() != Material.field_151579_a;
    }

    public static boolean checkEntityImmaterial(Entity entity) {
        return !(entity instanceof EntityImmaterial);
    }

    @FunctionalInterface
    public static interface CustomTrace {
        public void trace(Vec3 var1, Vec3 var2, float var3);
    }
}

