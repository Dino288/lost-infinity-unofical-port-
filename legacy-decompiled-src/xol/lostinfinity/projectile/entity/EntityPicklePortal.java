/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.world.World
 */
package xol.lostinfinity.projectile.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.misc.EntityPickleMan;

public class EntityPicklePortal
extends Entity {
    private float growth = 0.0f;
    private float rotation = 0.0f;
    float angle = 0.0f;
    private Player creator = null;

    public float getGrowth() {
        return this.growth;
    }

    public float getRotation() {
        return this.rotation;
    }

    public void setCreator(Player play) {
        this.creator = play;
    }

    public EntityPicklePortal(Level worldIn) {
        super(worldIn);
        this.func_70105_a(0.5f, 0.5f);
    }

    public void func_70071_h_() {
        super.func_70071_h_();
        if (this.field_70173_aa < 40) {
            this.growth += 0.1f;
        }
        this.rotation += 0.2f;
        if (!this.field_70170_p.field_72995_K) {
            if (this.field_70173_aa >= 140) {
                this.func_70106_y();
            }
            if (this.field_70173_aa >= 48 && this.field_70173_aa <= 120 && this.field_70173_aa % 8 == 0 && this.creator != null) {
                EntityPickleMan pickle = new EntityPickleMan(this.field_70170_p);
                pickle.func_70107_b(this.field_70165_t - 0.5 + this.field_70146_Z.nextDouble(), this.field_70163_u, this.field_70161_v - 0.5 + this.field_70146_Z.nextDouble());
                pickle.func_70024_g(0.0, this.field_70146_Z.nextDouble() * 1.5 - 0.75, this.field_70146_Z.nextDouble() * 1.0 + 1.0);
                pickle.field_70133_I = true;
                pickle.func_193101_c(this.creator);
                this.field_70170_p.func_72838_d((Entity)pickle);
                this.func_184185_a(SoundInit.CARTOON_APPEAR, 1.5f, 0.7f + 0.6f * this.field_70146_Z.nextFloat());
            }
        } else {
            for (int i = 0; i < 1; ++i) {
                float growthDist = this.growth * 1.06f;
                this.angle += 0.3f;
                double velocity_x = (double)growthDist * Math.cos(this.angle);
                double velocity_y = (double)growthDist * Math.sin(this.angle);
                this.field_70170_p.func_175688_a(ParticleInit.NATURE_DOT, this.field_70165_t + velocity_x / 2.0, this.field_70163_u + velocity_y / 2.0, this.field_70161_v, 0.0, 0.0, 0.0, new int[0]);
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

