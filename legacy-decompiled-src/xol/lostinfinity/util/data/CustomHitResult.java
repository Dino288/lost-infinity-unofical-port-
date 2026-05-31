/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3
 */
package xol.lostinfinity.util.data;

import java.util.HashSet;
import java.util.Set;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.Vec3;

public class CustomHitResult {
    private boolean modified;
    private Vec3 block_result_position = null;
    private Vec3 block_grabbed_position = null;
    private final Set<Entity> entity_result = new HashSet<Entity>();

    public CustomHitResult() {
    }

    public CustomHitResult(Vec3 pos, Entity entity) {
        this.setResultPos(pos);
        this.addResultEntity(entity);
    }

    public CustomHitResult(Vec3 pos, Vec3 grabbed, Entity entity) {
        this.setResultPos(pos);
        this.addResultEntity(entity);
        this.setGrabbedVector(grabbed);
    }

    public boolean isModified() {
        return this.modified;
    }

    public void setResultPos(Vec3 pos) {
        this.modified = true;
        this.block_result_position = pos;
    }

    public BlockPos getResultPos() {
        return new BlockPos(this.block_result_position);
    }

    public Vec3 getResultVector() {
        return this.block_result_position;
    }

    public void addResultEntity(Entity pos) {
        this.modified = true;
        this.entity_result.add(pos);
    }

    public Entity getResultEntity() {
        return this.entity_result.isEmpty() ? null : this.entity_result.iterator().next();
    }

    public Set<Entity> getResultEntities() {
        return this.entity_result;
    }

    public void setGrabbedVector(Vec3 pos) {
        this.modified = true;
        this.block_grabbed_position = pos;
    }

    public Vec3 getGrabbedVector() {
        return this.block_grabbed_position;
    }
}

