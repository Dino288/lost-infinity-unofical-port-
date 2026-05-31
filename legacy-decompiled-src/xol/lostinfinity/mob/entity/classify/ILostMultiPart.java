/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.IEntityMultiPart
 *  net.minecraft.entity.MultiPartEntityPart
 *  net.minecraft.util.DamageSource
 */
package xol.lostinfinity.mob.entity.classify;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.IEntityMultiPart;
import net.minecraft.entity.MultiPartEntityPart;
import net.minecraft.world.damagesource.DamageSource;

public interface ILostMultiPart
extends IEntityMultiPart {
    default public boolean func_70965_a(MultiPartEntityPart dragonPart, DamageSource source, float damage) {
        return false;
    }

    public boolean attackEntityFromPart(LivingEntity var1, DamageSource var2, float var3);
}

