/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.world.World
 */
package xol.lostinfinity.projectile.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ParticleInit;

public class EntityScreamerPortalEffect
extends Entity {
    private float growth = 0.0f;
    private float rotation = 0.0f;
    float angle = 0.0f;

    public float getGrowth() {
        return this.growth;
    }

    public float getRotation() {
        return this.rotation;
    }

    public EntityScreamerPortalEffect(Level worldIn) {
        super(worldIn);
        this.func_70105_a(0.5f, 0.5f);
    }

    public void func_70071_h_() {
        super.func_70071_h_();
        if (this.field_70173_aa < 70) {
            this.growth += 0.2f;
        }
        this.rotation += 0.2f;
        if (!this.field_70170_p.field_72995_K) {
            if (this.field_70173_aa >= 200) {
                this.func_70106_y();
            }
        } else {
            for (int i = 0; i < 4; ++i) {
                float growthDist = this.growth * 1.06f;
                this.angle += 0.15f;
                double velocity_x = (double)growthDist * Math.cos(this.angle);
                double velocity_z = (double)growthDist * Math.sin(this.angle);
                this.field_70170_p.func_175688_a(ParticleInit.GLOOM_SPELL, this.field_70165_t + velocity_x / 2.0, this.field_70163_u, this.field_70161_v + velocity_z / 2.0, 0.0, 0.0, 0.0, new int[0]);
            }
        }
    }

    protected void func_70088_a() {
    }

    protected void func_70037_a(CompoundTag compound) {
    }

    protected void func_70014_b(CompoundTag compound) {
    }
}

