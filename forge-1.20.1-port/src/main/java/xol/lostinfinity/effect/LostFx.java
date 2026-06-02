package xol.lostinfinity.effect;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.RegistryObject;
import xol.lostinfinity.LostInfinity;
import xol.lostinfinity.network.LostClientParticlePacket;
import xol.lostinfinity.network.LostClientSoundPacket;
import xol.lostinfinity.network.LostNetwork;
import xol.lostinfinity.registry.ModParticles;

public final class LostFx {
    private LostFx() {
    }

    public static void play(Level level, BlockPos pos, String soundName, SoundSource source, float volume, float pitch) {
        SoundEvent sound = SoundEvent.createVariableRangeEvent(new ResourceLocation(LostInfinity.MODID, soundName));
        level.playSound(null, pos, sound, source, volume, pitch);
    }

    public static void playFor(ServerPlayer player, BlockPos pos, String soundName, SoundSource source, float volume, float pitch) {
        LostNetwork.sendToPlayer(player, new LostClientSoundPacket(soundName, pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D, source, volume, pitch));
    }

    public static void burst(Level level, BlockPos pos, String particleName, int count, double spread, double speed) {
        if (!(level instanceof ServerLevel serverLevel)) {
            return;
        }
        ParticleOptions particle = particle(particleName);
        serverLevel.sendParticles(particle, pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D, count, spread, spread, spread, speed);
    }

    public static void burstFor(ServerPlayer player, BlockPos pos, String particleName, int count, double spread, double speed) {
        LostNetwork.sendToPlayer(player, new LostClientParticlePacket(particleName, pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D, count, spread, speed));
    }

    public static void trail(Level level, Entity entity, String particleName, int count) {
        if (!(level instanceof ServerLevel serverLevel)) {
            return;
        }
        ParticleOptions particle = particle(particleName);
        serverLevel.sendParticles(particle, entity.getX(), entity.getY() + entity.getBbHeight() * 0.5D, entity.getZ(), count, 0.15D, 0.15D, 0.15D, 0.02D);
    }

    public static ParticleOptions particle(String name) {
        RegistryObject<net.minecraft.core.particles.SimpleParticleType> particle = ModParticles.ALL_PARTICLES.get(name);
        return particle == null ? ModParticles.GENERIC_DOT_PURPLE.get() : particle.get();
    }
}
