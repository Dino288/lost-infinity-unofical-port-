package xol.lostinfinity.registry;

import java.util.LinkedHashMap;
import java.util.Map;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import xol.lostinfinity.LostInfinity;

public final class ModParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES =
            DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, LostInfinity.MODID);

    public static final Map<String, RegistryObject<SimpleParticleType>> ALL_PARTICLES = new LinkedHashMap<>();

    public static final RegistryObject<SimpleParticleType> ACID = register("acid");
    public static final RegistryObject<SimpleParticleType> ANCIENT_SPELL = register("ancient_spell");
    public static final RegistryObject<SimpleParticleType> BAD_MAGIC = register("bad_magic");
    public static final RegistryObject<SimpleParticleType> BLIGHT_SPELL_GREEN = register("blight_spell_green");
    public static final RegistryObject<SimpleParticleType> BLIGHT_SPELL_PINK = register("blight_spell_pink");
    public static final RegistryObject<SimpleParticleType> BLOOD_DROP = register("blood_drop");
    public static final RegistryObject<SimpleParticleType> COSMIC_EXPLOSION_TYPE1 = register("cosmic_explosion_type1");
    public static final RegistryObject<SimpleParticleType> DARK_MAGIC = register("dark_magic");
    public static final RegistryObject<SimpleParticleType> ELECTRIC_EXPLOSION_BLUE = register("electric_explosion_blue");
    public static final RegistryObject<SimpleParticleType> EXPLOSION = register("explosion");
    public static final RegistryObject<SimpleParticleType> GALAXY_BLUE = register("galaxy_blue");
    public static final RegistryObject<SimpleParticleType> GALAXY_GREEN = register("galaxy_green");
    public static final RegistryObject<SimpleParticleType> GALAXY_PURPLE = register("galaxy_purple");
    public static final RegistryObject<SimpleParticleType> GALAXY_YELLOW = register("galaxy_yellow");
    public static final RegistryObject<SimpleParticleType> GENERIC_DOT_PURPLE = register("generic_dot_purple");
    public static final RegistryObject<SimpleParticleType> GRAVITY_RING = register("gravity_ring");
    public static final RegistryObject<SimpleParticleType> LASER_FIZZLE = register("laser_fizzle");
    public static final RegistryObject<SimpleParticleType> MIASMA = register("miasma");
    public static final RegistryObject<SimpleParticleType> MURK = register("murk");
    public static final RegistryObject<SimpleParticleType> MURKY_MIST = register("murky_mist");
    public static final RegistryObject<SimpleParticleType> PLAGUE = register("plague");
    public static final RegistryObject<SimpleParticleType> PLASMA = register("plasma");
    public static final RegistryObject<SimpleParticleType> PLASMA_EXPLOSION = register("plasma_explosion");
    public static final RegistryObject<SimpleParticleType> PORTAL_BEAM = register("portal_beam");
    public static final RegistryObject<SimpleParticleType> SHADOW_BLAST = register("shadow_blast");
    public static final RegistryObject<SimpleParticleType> SMALL_SPARK = register("small_spark");
    public static final RegistryObject<SimpleParticleType> SPACE_MAGIC = register("space_magic");
    public static final RegistryObject<SimpleParticleType> SPECTRAL = register("spectral");
    public static final RegistryObject<SimpleParticleType> SUPERSONIC_BLUE = register("supersonic_blue");
    public static final RegistryObject<SimpleParticleType> SUPERSONIC_RED = register("supersonic_red");
    public static final RegistryObject<SimpleParticleType> VENOM = register("venom");
    public static final RegistryObject<SimpleParticleType> WARP = register("warp");
    public static final RegistryObject<SimpleParticleType> ZAP = register("zap");

    private ModParticles() {
    }

    private static RegistryObject<SimpleParticleType> register(String name) {
        RegistryObject<SimpleParticleType> particle = PARTICLE_TYPES.register(name, () -> new SimpleParticleType(false));
        ALL_PARTICLES.put(name, particle);
        return particle;
    }
}
