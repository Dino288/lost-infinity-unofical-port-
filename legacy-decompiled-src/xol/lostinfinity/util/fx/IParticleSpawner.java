/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.Player
 *  net.minecraft.entity.player.ServerPlayer
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.common.network.NetworkRegistry$TargetPoint
 */
package xol.lostinfinity.util.fx;

import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import xol.lostinfinity.common.lostinfinity;
import xol.lostinfinity.common.packets.clientbound.PacketModParticle;
import xol.lostinfinity.util.data.CustomParticleConfig;

public interface IParticleSpawner {
    public static void spawnParticle(Level world, int id, int extra, Vec3 pos) {
        IParticleSpawner.spawnParticle(world, id, extra, pos.field_72450_a, pos.field_72448_b, pos.field_72449_c);
    }

    public static void spawnParticle(Level world, int id, int extra, double x, double y, double z) {
        lostinfinity.instance.packetHandler.sendToAllAround(new NetworkRegistry.TargetPoint(world.field_73011_w.getDimension(), x, y, z, 90.0), new PacketModParticle(id, extra, x, y, z));
    }

    public static void spawnParticle(Player player, int id, int extra, Vec3 pos) {
        IParticleSpawner.spawnParticle(player, id, extra, pos.field_72450_a, pos.field_72448_b, pos.field_72449_c);
    }

    public static void spawnParticle(Player player, int id, int extra, double x, double y, double z) {
        if (player instanceof ServerPlayer) {
            lostinfinity.instance.packetHandler.sendToPlayer((ServerPlayer)player, new PacketModParticle(id, extra, x, y, z));
        }
    }

    public static void spawnParticle(Level world, CustomParticleConfig config, Vec3 pos) {
        IParticleSpawner.spawnParticle(world, config, pos.field_72450_a, pos.field_72448_b, pos.field_72449_c);
    }

    public static void spawnParticle(Level world, CustomParticleConfig config, double x, double y, double z) {
        config.setOrigin(x, y, z);
        lostinfinity.instance.packetHandler.sendToAllAround(new NetworkRegistry.TargetPoint(world.field_73011_w.getDimension(), x, y, z, 90.0), new PacketModParticle(config));
    }

    public static void spawnParticle(Player player, CustomParticleConfig config, double x, double y, double z) {
        if (player instanceof ServerPlayer) {
            config.setOrigin(x, y, z);
            lostinfinity.instance.packetHandler.sendToPlayer((ServerPlayer)player, new PacketModParticle(config));
        }
    }
}

