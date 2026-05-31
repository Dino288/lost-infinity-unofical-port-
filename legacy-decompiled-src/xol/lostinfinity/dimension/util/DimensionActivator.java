/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.world.DimensionType
 *  net.minecraftforge.common.util.ITeleporter
 */
package xol.lostinfinity.dimension.util;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.DimensionType;
import net.minecraftforge.common.util.ITeleporter;
import xol.lostinfinity.dimension.util.BasicTeleporter;

public class DimensionActivator {
    public static void transferEntity(Entity e, DimensionType dimTravel) {
        if (e == null || dimTravel == null || e.func_184102_h() == null) {
            return;
        }
        DimensionType current = e.func_130014_f_().field_73011_w.func_186058_p();
        BasicTeleporter teleporter = new BasicTeleporter(e.func_184102_h().func_71218_a(dimTravel.func_186068_a()), e.field_70165_t, e.field_70163_u, e.field_70161_v);
        e.changeDimension(dimTravel.func_186068_a(), (ITeleporter)teleporter);
    }

    public static void transferEntityWithCoords(Entity e, DimensionType dimTravel, double xGo, double yGo, double zGo) {
        if (e == null || dimTravel == null || e.func_184102_h() == null) {
            return;
        }
        DimensionType current = e.func_130014_f_().field_73011_w.func_186058_p();
        BasicTeleporter teleporter = new BasicTeleporter(e.func_184102_h().func_71218_a(dimTravel.func_186068_a()), xGo, yGo, zGo, true);
        e.changeDimension(dimTravel.func_186068_a(), (ITeleporter)teleporter);
    }
}

