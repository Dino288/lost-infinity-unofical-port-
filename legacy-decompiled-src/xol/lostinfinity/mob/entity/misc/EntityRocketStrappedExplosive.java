/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.misc;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ItemInit;

public class EntityRocketStrappedExplosive
extends Entity {
    private Player owner = null;
    private int timer = 140;
    private double speed = 0.01;

    public EntityRocketStrappedExplosive(Level worldIn) {
        super(worldIn);
        this.func_184224_h(true);
    }

    public void setOwner(Player play) {
        this.owner = play;
    }

    public void func_70071_h_() {
        super.func_70071_h_();
        this.field_70143_R = -1.0f;
        if (!this.field_70170_p.field_72995_K) {
            if (this.owner == null || this.owner.field_70128_L) {
                this.func_70106_y();
            } else {
                if (this.timer % 10 == 0) {
                    this.func_184185_a(SoundEvents.field_191244_bn, 2.0f, 0.5f + this.field_70146_Z.nextFloat());
                }
                this.speed *= 1.04;
                this.owner.func_189654_d(true);
                this.owner.field_70181_x = this.speed;
                this.owner.field_70133_I = true;
                this.func_70634_a(this.owner.field_70165_t, this.owner.field_70163_u + 1.5, this.owner.field_70161_v);
                --this.timer;
                if (this.timer == 0) {
                    this.owner.func_70606_j(0.0f);
                    this.owner.func_189654_d(false);
                    this.func_145779_a(ItemInit.velocitizedFemur, 1);
                    this.func_70106_y();
                }
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

