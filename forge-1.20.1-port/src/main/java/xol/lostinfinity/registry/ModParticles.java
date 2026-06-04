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

    static {
        String[] recoveredTextureParticles = {
                "acid_yellow", "attract_field", "barul_chain", "basic_star_type1", "basic_star_type2",
                "basic_star_type3", "basic_star_type4", "blackhole_portal", "blackhole_ring", "blue_skull",
                "bomber_explosion", "claw_marks", "clay_block", "clay_bubble", "cloud_green", "cloud_purple",
                "comet_blue", "comet_white", "corruption_magic", "cosmic_explosion_type2", "cosmic_explosion_type3",
                "cosmic_explosion_type4", "crescent_moon", "cryo_beam", "crystal_magic", "dark_fizzle",
                "dark_flash", "debt_scythe", "dragon_fire", "elastic_thread", "electric_explosion_yellow",
                "eternal_beacon_beam", "explosion_blue", "explosion_fear", "explosion_lavender", "explosion_orange",
                "explosion_red", "explosion_ring", "explosion_ring_dark", "explosion_teal", "explosion_yellow",
                "firegoo", "flame_large", "flame_medium", "flame_small", "generic_dot_acid", "generic_dot_aqua",
                "generic_dot_black", "generic_dot_blue", "generic_dot_green", "generic_dot_orange", "generic_dot_pink",
                "generic_dot_red", "generic_dot_tangerine", "generic_dot_white", "generic_dot_yellow", "glomite_warp",
                "gloom_burst", "gloom_spell", "gold_star", "golden_magic", "goo_ring", "grasp", "honey_bubble",
                "ice_blast", "ion_blast", "ion_fuel", "killer_vine", "large_bubble", "large_bubble_purple",
                "laser_beam", "laser_beam_blue_bright", "laser_beam_bright", "laser_fizzle_large", "light_beam",
                "light_fizzle", "light_flash", "lightning_bolt", "lightning_bolt_blue", "lightning_bolt_bright",
                "lightning_indicator", "luminous_beam", "luminous_beam_end", "meteor_portal", "mirror_chain",
                "nature_dot", "nature_magic", "nature_ring", "nicronium_ring", "nightmare_magic", "nuclear_blast",
                "nuclear_ring", "pickle_portal", "plasma_rift", "poison_bubble", "poison_explosion", "poison_rings",
                "power_field", "power_field_blue", "power_loss", "power_pulse", "prismatic_explosion_type1",
                "prismatic_explosion_type2", "prismatic_explosion_type3", "purple_skull", "quantum_mark", "queen_web",
                "red_skull", "repel_field", "screamer_portal", "slam", "snow_bubble", "stable_plasma",
                "summoning_portal", "tentacle_portal", "tesla_ring_blue", "tesla_ring_yellow", "unstable_plasma",
                "venom_chain", "venom_ring", "watching_eye", "web_magic", "whirlpool", "whirlpool_portal",
                "wither_rings", "wormhole_portal"
        };
        for (String name : recoveredTextureParticles) {
            registerRecovered(name);
        }
    }

    private ModParticles() {
    }

    private static RegistryObject<SimpleParticleType> register(String name) {
        RegistryObject<SimpleParticleType> particle = PARTICLE_TYPES.register(name, () -> new SimpleParticleType(false));
        ALL_PARTICLES.put(name, particle);
        return particle;
    }

    private static void registerRecovered(String name) {
        if (!ALL_PARTICLES.containsKey(name)) {
            register(name);
        }
    }
}
