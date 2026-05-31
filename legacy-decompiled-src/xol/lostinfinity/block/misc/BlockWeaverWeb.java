/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.SoundType
 *  net.minecraft.block.material.Material
 */
package xol.lostinfinity.block.misc;

import net.minecraft.world.level.block.SoundType;
import net.minecraft.block.material.Material;
import xol.lostinfinity.block.basic.BlockBasicPlant;
import xol.lostinfinity.block.basic.ITetherable;

public class BlockWeaverWeb
extends BlockBasicPlant
implements ITetherable {
    public BlockWeaverWeb(String name) {
        super(name, Material.field_151569_G);
        this.func_149672_a(SoundType.field_185854_g);
    }
}

