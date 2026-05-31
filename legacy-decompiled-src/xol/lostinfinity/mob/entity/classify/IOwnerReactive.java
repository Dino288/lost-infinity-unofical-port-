/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 */
package xol.lostinfinity.mob.entity.classify;

import net.minecraft.world.entity.Entity;
import xol.lostinfinity.util.data.CustomDamageResult;

public interface IOwnerReactive {
    default public void maxHealthDamageEffect(Entity attacker, CustomDamageResult result) {
    }

    default public void trueDamageEffect(Entity attacker, CustomDamageResult result) {
    }
}

