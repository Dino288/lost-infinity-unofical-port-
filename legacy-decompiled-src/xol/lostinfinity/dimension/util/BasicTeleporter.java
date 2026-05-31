/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.longs.Long2ObjectMap
 *  it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap
 *  it.unimi.dsi.fastutil.objects.ObjectIterator
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.Blocks
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.DimensionType
 *  net.minecraft.world.Teleporter
 *  net.minecraft.world.Teleporter$PortalPosition
 *  net.minecraft.world.ServerLevel
 */
package xol.lostinfinity.dimension.util;

import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import java.util.Random;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.Teleporter;
import net.minecraft.server.level.ServerLevel;

public class BasicTeleporter
extends Teleporter {
    private final Long2ObjectMap<Teleporter.PortalPosition> destinationCoordinateCache = new Long2ObjectOpenHashMap(4096);
    private double goToX;
    private double goToY;
    private double goToZ;
    private boolean strict = false;

    public BasicTeleporter(ServerLevel par1ServerLevel, double xpos, double ypos, double zpos) {
        super(par1ServerLevel);
        new Random(par1ServerLevel.func_72905_C());
        this.goToX = xpos;
        this.goToY = ypos;
        this.goToZ = zpos;
    }

    public BasicTeleporter(ServerLevel par1ServerLevel, double xpos, double ypos, double zpos, boolean strictSet) {
        super(par1ServerLevel);
        new Random(par1ServerLevel.func_72905_C());
        this.goToX = xpos;
        this.goToY = ypos;
        this.goToZ = zpos;
        this.strict = strictSet;
    }

    public boolean func_85188_a(Entity p_85188_1_) {
        return false;
    }

    public boolean func_180620_b(Entity entityIn, float p_180620_2_) {
        return false;
    }

    public void func_180266_a(Entity entityIn, float rotationYaw) {
        if (entityIn.field_70170_p.field_73011_w.func_186058_p() == DimensionType.OVERWORLD) {
            entityIn.func_70012_b(this.goToX, this.goToY, this.goToZ, entityIn.field_70177_z, 0.0f);
        } else if (this.strict) {
            entityIn.func_70012_b(this.goToX, this.goToY, this.goToZ, entityIn.field_70177_z, 0.0f);
        } else {
            if (!(entityIn instanceof Player)) {
                return;
            }
            Player player = (Player)entityIn;
            BlockPos bed = player.getBedLocation(0);
            if (bed == null) {
                bed = this.field_85192_a.func_175694_M();
            }
            for (int i = bed.func_177956_o(); i < 255; ++i) {
                if (this.field_85192_a.func_180495_p(new BlockPos(bed.func_177958_n(), i, bed.func_177952_p())).func_177230_c() != Blocks.field_150350_a || this.field_85192_a.func_180495_p(new BlockPos(bed.func_177958_n(), i - 1, bed.func_177952_p())) == Blocks.field_150350_a && i != bed.func_177956_o()) continue;
                player.func_70634_a((double)bed.func_177958_n(), (double)i, (double)bed.func_177952_p());
                break;
            }
        }
        entityIn.field_70179_y = 0.0;
        entityIn.field_70181_x = 0.0;
        entityIn.field_70159_w = 0.0;
    }

    public void func_85189_a(long worldTime) {
        if (worldTime % 100L == 0L) {
            long i = worldTime - 300L;
            ObjectIterator objectiterator = this.destinationCoordinateCache.values().iterator();
            while (objectiterator.hasNext()) {
                Teleporter.PortalPosition teleporter$portalposition = (Teleporter.PortalPosition)objectiterator.next();
                if (teleporter$portalposition != null && teleporter$portalposition.field_85087_d >= i) continue;
                objectiterator.remove();
            }
        }
    }
}

