/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.PathfinderMob
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.ai.EntityAIBase
 *  net.minecraft.entity.ai.EntityAIWanderAvoidWater
 *  net.minecraft.entity.monster.Monster
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.fungal;

import java.util.Random;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class EntityMushmerraClone
extends Monster {
    private float alpha = new Random().nextBoolean() ? 0.0f : 1.0f;

    public EntityMushmerraClone(Level worldIn) {
        super(worldIn);
    }

    public void func_70071_h_() {
        super.func_70071_h_();
        if (this.alpha < 1.0f && this.field_70173_aa > 120 && this.field_70173_aa < 160) {
            this.fadeIn();
        } else if (this.alpha > 0.0f && this.field_70173_aa > 500) {
            this.fadeOut();
        } else if (this.field_70173_aa > 540) {
            this.func_70106_y();
        }
    }

    protected void func_184651_r() {
        super.func_184651_r();
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAIWanderAvoidWater((PathfinderMob)this, 1.0));
    }

    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)0.23f);
    }

    public float getAlpha() {
        return this.alpha;
    }

    private void fadeIn() {
        this.alpha += 0.05f;
    }

    private void fadeOut() {
        this.alpha -= 0.05f;
    }
}

