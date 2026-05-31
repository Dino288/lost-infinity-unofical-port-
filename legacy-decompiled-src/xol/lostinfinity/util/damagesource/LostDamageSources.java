/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.DamageSource
 */
package xol.lostinfinity.util.damagesource;

import net.minecraft.world.damagesource.DamageSource;
import xol.lostinfinity.util.damagesource.AcidicGelSource;
import xol.lostinfinity.util.damagesource.ConcentratedAcidSource;

public enum LostDamageSources {
    ACIDIC_GEL((Object)((Object)new AcidicGelSource("acidic_gel"))),
    CONCENTRATED_ACID((Object)((Object)new ConcentratedAcidSource("concentrated_acid")));

    public DamageSource source;

    private LostDamageSources(Object source) {
        this.source = source instanceof DamageSource ? (DamageSource)source : DamageSource.field_76380_i;
    }
}

