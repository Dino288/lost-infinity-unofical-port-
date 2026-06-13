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
        sendPatternExtras(serverLevel, pos, particleName, count, spread, speed);
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
        sendTrailExtras(serverLevel, entity, particleName, count);
    }

    public static ParticleOptions particle(String name) {
        RegistryObject<net.minecraft.core.particles.SimpleParticleType> particle = ModParticles.ALL_PARTICLES.get(name);
        if (particle == null) {
            particle = ModParticles.ALL_PARTICLES.get(alias(name));
        }
        return particle == null ? ModParticles.GENERIC_DOT_PURPLE.get() : particle.get();
    }

    private static void sendPatternExtras(ServerLevel level, BlockPos pos, String name, int count, double spread, double speed) {
        double x = pos.getX() + 0.5D;
        double y = pos.getY() + 0.5D;
        double z = pos.getZ() + 0.5D;
        switch (name) {
            case "portal_beam" -> {
                send(level, "blackhole_ring", x, y, z, Math.max(4, count / 4), spread * 0.45D, speed * 0.35D);
                send(level, "eternal_beacon_beam", x, y + 0.35D, z, Math.max(3, count / 5), spread * 0.2D, speed * 0.2D);
            }
            case "space_magic" -> {
                send(level, "basic_star_type1", x, y, z, Math.max(5, count / 3), spread * 0.8D, speed);
                send(level, "basic_star_type4", x, y, z, Math.max(3, count / 5), spread * 0.55D, speed * 0.8D);
            }
            case "warp" -> send(level, "glomite_warp", x, y, z, Math.max(3, count / 3), spread * 0.55D, speed * 0.8D);
            case "murky_mist" -> {
                send(level, "large_bubble_purple", x, y, z, Math.max(4, count / 4), spread * 0.7D, speed * 0.45D);
                send(level, "whirlpool", x, y, z, Math.max(2, count / 6), spread * 0.4D, speed * 0.35D);
            }
            case "murk" -> send(level, "mirror_chain", x, y, z, Math.max(3, count / 5), spread * 0.45D, speed * 0.5D);
            case "plasma_explosion" -> {
                send(level, "plasma_rift", x, y, z, Math.max(4, count / 4), spread * 0.55D, speed * 0.7D);
                send(level, "explosion_ring", x, y, z, Math.max(3, count / 6), spread * 0.4D, speed * 0.4D);
            }
            case "electric_explosion_blue", "zap" -> {
                send(level, "tesla_ring_blue", x, y, z, Math.max(4, count / 4), spread * 0.45D, speed * 0.8D);
                send(level, "lightning_bolt_blue", x, y, z, Math.max(3, count / 5), spread * 0.35D, speed);
            }
            case "laser_fizzle" -> send(level, "laser_beam_bright", x, y, z, Math.max(3, count / 4), spread * 0.3D, speed * 0.6D);
            case "gravity_ring" -> send(level, "repel_field", x, y, z, Math.max(4, count / 3), spread * 0.5D, speed * 0.45D);
            case "venom" -> send(level, "venom_ring", x, y, z, Math.max(3, count / 4), spread * 0.45D, speed * 0.45D);
            case "plague" -> send(level, "poison_rings", x, y, z, Math.max(3, count / 4), spread * 0.55D, speed * 0.45D);
            case "blood_drop" -> send(level, "red_skull", x, y, z, Math.max(1, count / 8), spread * 0.25D, speed * 0.35D);
            case "ancient_spell" -> send(level, "gold_star", x, y, z, Math.max(3, count / 4), spread * 0.5D, speed * 0.5D);
            case "power_field", "power_field_blue" -> {
                send(level, "repel_field", x, y, z, Math.max(3, count / 4), spread * 0.45D, speed * 0.35D);
                send(level, "light_flash", x, y, z, Math.max(2, count / 5), spread * 0.25D, speed * 0.25D);
            }
            case "power_pulse" -> {
                send(level, "power_field_blue", x, y, z, Math.max(4, count / 3), spread * 0.5D, speed * 0.45D);
                send(level, "electric_explosion_blue", x, y, z, Math.max(2, count / 6), spread * 0.35D, speed * 0.65D);
            }
            case "power_loss" -> {
                send(level, "generic_dot_black", x, y, z, Math.max(4, count / 3), spread * 0.55D, speed * 0.35D);
                send(level, "dark_fizzle", x, y, z, Math.max(2, count / 5), spread * 0.45D, speed * 0.5D);
            }
            case "nicronium_ring" -> send(level, "power_field", x, y, z, Math.max(3, count / 4), spread * 0.45D, speed * 0.35D);
            case "blackhole_ring", "blackhole_portal" -> {
                send(level, "attract_field", x, y, z, Math.max(4, count / 4), spread * 0.55D, speed * 0.35D);
                send(level, "dark_fizzle", x, y, z, Math.max(3, count / 5), spread * 0.7D, speed * 0.55D);
            }
            case "wormhole_portal", "whirlpool_portal" -> {
                send(level, "portal_beam", x, y, z, Math.max(3, count / 5), spread * 0.4D, speed * 0.45D);
                send(level, "warp", x, y, z, Math.max(4, count / 4), spread * 0.55D, speed * 0.7D);
            }
            case "web_magic", "queen_web" -> {
                send(level, "elastic_thread", x, y, z, Math.max(3, count / 4), spread * 0.55D, speed * 0.35D);
                send(level, "claw_marks", x, y, z, Math.max(1, count / 8), spread * 0.25D, speed * 0.25D);
            }
            case "ice_blast", "cryo_beam" -> {
                send(level, "snow_bubble", x, y, z, Math.max(4, count / 4), spread * 0.55D, speed * 0.35D);
                send(level, "generic_dot_aqua", x, y, z, Math.max(3, count / 5), spread * 0.5D, speed * 0.45D);
            }
            case "supersonic_blue", "supersonic_red" -> {
                send(level, "repel_field", x, y, z, Math.max(3, count / 5), spread * 0.45D, speed * 0.45D);
                send(level, "light_fizzle", x, y, z, Math.max(2, count / 6), spread * 0.35D, speed * 0.6D);
            }
            case "bad_magic", "nightmare_magic" -> {
                send(level, "purple_skull", x, y, z, Math.max(1, count / 8), spread * 0.35D, speed * 0.25D);
                send(level, "corruption_magic", x, y, z, Math.max(4, count / 4), spread * 0.6D, speed * 0.45D);
            }
            case "explosion_fear" -> {
                send(level, "purple_skull", x, y, z, Math.max(2, count / 5), spread * 0.45D, speed * 0.35D);
                send(level, "bad_magic", x, y, z, Math.max(3, count / 4), spread * 0.55D, speed * 0.45D);
            }
            case "shadow_blast", "dark_magic" -> {
                send(level, "dark_flash", x, y, z, Math.max(2, count / 6), spread * 0.35D, speed * 0.45D);
                send(level, "gloom_burst", x, y, z, Math.max(3, count / 5), spread * 0.5D, speed * 0.5D);
            }
            case "cosmic_explosion_type1", "galaxy_blue", "galaxy_purple", "galaxy_green", "galaxy_yellow" -> {
                send(level, "comet_blue", x, y, z, Math.max(2, count / 6), spread * 0.4D, speed * 0.65D);
                send(level, "basic_star_type2", x, y, z, Math.max(4, count / 4), spread * 0.65D, speed * 0.55D);
            }
            default -> {
            }
        }
    }

    private static void sendTrailExtras(ServerLevel level, Entity entity, String name, int count) {
        if ("laser_fizzle".equals(name) || "portal_beam".equals(name)) {
            send(level, "light_fizzle", entity.getX(), entity.getY() + entity.getBbHeight() * 0.5D, entity.getZ(), Math.max(1, count / 2), 0.08D, 0.01D);
        } else if ("venom".equals(name)) {
            send(level, "venom_chain", entity.getX(), entity.getY() + entity.getBbHeight() * 0.5D, entity.getZ(), Math.max(1, count / 2), 0.08D, 0.01D);
        } else if ("murky_mist".equals(name)) {
            send(level, "large_bubble", entity.getX(), entity.getY() + entity.getBbHeight() * 0.5D, entity.getZ(), Math.max(1, count / 2), 0.08D, 0.01D);
        } else if ("space_magic".equals(name) || "cosmic_explosion_type1".equals(name)) {
            send(level, "basic_star_type3", entity.getX(), entity.getY() + entity.getBbHeight() * 0.5D, entity.getZ(), Math.max(1, count / 2), 0.08D, 0.01D);
        } else if ("web_magic".equals(name) || "barul_chain".equals(name)) {
            send(level, "elastic_thread", entity.getX(), entity.getY() + entity.getBbHeight() * 0.5D, entity.getZ(), Math.max(1, count / 2), 0.08D, 0.01D);
        } else if ("ice_blast".equals(name) || "cryo_beam".equals(name)) {
            send(level, "snow_bubble", entity.getX(), entity.getY() + entity.getBbHeight() * 0.5D, entity.getZ(), Math.max(1, count / 2), 0.08D, 0.01D);
        } else if ("shadow_blast".equals(name) || "dark_magic".equals(name)) {
            send(level, "dark_fizzle", entity.getX(), entity.getY() + entity.getBbHeight() * 0.5D, entity.getZ(), Math.max(1, count / 2), 0.08D, 0.01D);
        } else if ("power_loss".equals(name) || "nightmare_magic".equals(name)) {
            send(level, "dark_fizzle", entity.getX(), entity.getY() + entity.getBbHeight() * 0.5D, entity.getZ(), Math.max(1, count / 2), 0.08D, 0.01D);
        } else if ("power_pulse".equals(name) || "nicronium_ring".equals(name)) {
            send(level, "power_field", entity.getX(), entity.getY() + entity.getBbHeight() * 0.5D, entity.getZ(), Math.max(1, count / 2), 0.08D, 0.01D);
        }
    }

    private static void send(ServerLevel level, String name, double x, double y, double z, int count, double spread, double speed) {
        if (ModParticles.ALL_PARTICLES.containsKey(name)) {
            level.sendParticles(particle(name), x, y, z, count, spread, spread, spread, speed);
        }
    }

    private static String alias(String name) {
        return switch (name) {
            case "cosmic_explosion" -> "cosmic_explosion_type1";
            case "poison" -> "poison_bubble";
            case "water_magic" -> "large_bubble";
            case "soundwave" -> "supersonic_blue";
            case "fire", "flame" -> "flame_medium";
            case "lightning" -> "lightning_bolt";
            case "blackhole" -> "blackhole_portal";
            case "wormhole" -> "wormhole_portal";
            case "web" -> "web_magic";
            case "ice", "cryo" -> "ice_blast";
            case "solar", "celestial" -> "space_magic";
            case "forbidden", "nightmare" -> "nightmare_magic";
            case "electric", "tesla" -> "electric_explosion_blue";
            case "sonic", "echo" -> "supersonic_blue";
            case "blood" -> "blood_drop";
            case "shield" -> "power_field";
            case "charge" -> "power_pulse";
            case "nullify" -> "power_loss";
            case "fear" -> "explosion_fear";
            default -> name;
        };
    }
}
