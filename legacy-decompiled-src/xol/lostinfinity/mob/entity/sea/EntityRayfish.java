/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.sea;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.sea.EntityFish;

public class EntityRayfish
extends EntityFish {
    public EntityRayfish(Level worldIn) {
        super(worldIn);
        this.func_70105_a(1.0f, 1.5f);
    }

    protected SoundEvent func_184615_bR() {
        return SoundInit.RAYFISH_DEATH;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundInit.RAYFISH_HURT;
    }

    protected SoundEvent func_184639_G() {
        return SoundInit.RAYFISH_AMBIENT;
    }
}

