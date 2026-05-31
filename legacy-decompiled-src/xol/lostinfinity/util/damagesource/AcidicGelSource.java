/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 */
package xol.lostinfinity.util.damagesource;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;

public class AcidicGelSource
extends DamageSource {
    public AcidicGelSource(String damageTypeIn) {
        super("lostinfinity." + damageTypeIn);
    }

    public Component func_151519_b(LivingEntity entityLivingBaseIn) {
        LivingEntity entitylivingbase = entityLivingBaseIn.func_94060_bK();
        String baseMsg = "%l$s was melted by acid.";
        baseMsg = baseMsg.replace("%l$s", entityLivingBaseIn.func_145748_c_().func_150254_d());
        return entitylivingbase == null ? new Component(baseMsg) : new Component((baseMsg + ",  while running from %2$s").replace("%2$s", entitylivingbase.func_145748_c_().func_150254_d()));
    }
}

