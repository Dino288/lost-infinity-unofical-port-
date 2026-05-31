/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.Mirror
 *  net.minecraft.util.Rotation
 *  net.minecraft.world.ServerLevel
 *  net.minecraft.world.gen.structure.template.PlacementSettings
 *  net.minecraftforge.fml.common.FMLCommonHandler
 */
package xol.lostinfinity.util.load;

import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraftforge.fml.common.FMLCommonHandler;

public interface IStructure {
    public static final ServerLevel worldServer = FMLCommonHandler.instance().getMinecraftServerInstance().func_71218_a(0);
    public static final PlacementSettings settings = new PlacementSettings().func_186218_a(null).func_186222_a(false).func_186226_b(false).func_186214_a(Mirror.NONE).func_186220_a(Rotation.NONE);
}

