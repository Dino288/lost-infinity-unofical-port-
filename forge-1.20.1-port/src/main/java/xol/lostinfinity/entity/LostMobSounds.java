package xol.lostinfinity.entity;

import java.util.Locale;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import xol.lostinfinity.LostInfinity;

public final class LostMobSounds {
    private LostMobSounds() {
    }

    public static SoundEvent ambient(String id) {
        return sound(resolve(id, "ambient"));
    }

    public static SoundEvent hurt(String id, DamageSource source) {
        return sound(resolve(id, "hurt"));
    }

    public static SoundEvent death(String id) {
        return sound(resolve(id, "death"));
    }

    public static SoundEvent ability(String id) {
        return sound(resolve(id, "ability"));
    }

    private static String resolve(String rawId, String kind) {
        String id = normalize(rawId);
        String exact = exact(id, kind);
        if (!exact.isBlank()) {
            return exact;
        }
        String family = family(id);
        if (!family.isBlank()) {
            return family + "_" + kind;
        }
        if (id.contains("galaxy") || id.contains("nebula") || id.contains("starfiend")) {
            return switch (kind) {
                case "ambient" -> "galactic_terror_ambient";
                case "hurt" -> "galactic_terror_hurt";
                case "death" -> "galactic_terror_death";
                default -> "nebula_wizard_spell";
            };
        }
        if (id.contains("deviant") || id.contains("titan") || id.contains("supermutated")) {
            return switch (kind) {
                case "ambient" -> "entity_possess";
                case "hurt" -> "generic_whack";
                case "death" -> "generic_vanish";
                default -> "entity_possess";
            };
        }
        if (id.contains("cthulhu")) {
            return switch (kind) {
                case "ambient" -> "tt_ambient_5";
                case "hurt" -> "forcefield_hit";
                case "death" -> "tt_death";
                default -> "tt_riseup";
            };
        }
        if (id.contains("machine") || id.contains("droid") || id.contains("robot")) {
            return switch (kind) {
                case "ambient" -> "gear_machine_2";
                case "hurt" -> "generic_whack";
                case "death" -> "robotic_doom";
                default -> "charging_power";
            };
        }
        if (id.contains("water") || id.contains("sea") || id.contains("fish") || id.contains("shark")) {
            return "water_echo";
        }
        return switch (kind) {
            case "ambient" -> "ghostly_clouds";
            case "hurt" -> "generic_whack";
            case "death" -> "generic_vanish";
            default -> "magic_weapon_10";
        };
    }

    private static String exact(String id, String kind) {
        if (id.contains("leviathan")) {
            return "leviathan_" + kind;
        }
        if (id.contains("ribshark") || id.contains("rib_shark")) {
            return "rib_shark_" + kind;
        }
        if (id.contains("eelshark") || id.contains("eel_shark")) {
            return "eelshark_" + kind;
        }
        if (id.contains("crabulon")) {
            return "crabulon_" + kind;
        }
        if (id.contains("underfin")) {
            return "underfin_" + kind;
        }
        if (id.contains("longfin")) {
            return "longfin_" + kind;
        }
        if (id.contains("dragon") && !id.contains("deviant")) {
            return "dragon_" + kind;
        }
        if (id.contains("galactic_terror")) {
            return "galactic_terror_" + kind;
        }
        if (id.contains("nebula_wizard")) {
            return kind.equals("ability") ? "nebula_wizard_spell" : "nebula_wizard_" + kind;
        }
        if (id.contains("nebula_giant")) {
            return kind.equals("ability") ? "nebula_giant_shockwave" : "nebula_giant_" + kind;
        }
        if (id.contains("nebula_grunt")) {
            return "nebula_grunt_" + kind;
        }
        if (id.contains("weaver")) {
            return "weaver_" + kind;
        }
        if (id.contains("sightwalker")) {
            return "sightwalker_" + kind;
        }
        if (id.contains("tentaclon")) {
            return "tentaclon_" + kind;
        }
        if (id.contains("titanopod")) {
            return "titanopod_" + kind;
        }
        if (id.contains("leer")) {
            return "leer_" + kind;
        }
        if (id.contains("wisp")) {
            return "wisp_" + kind;
        }
        if (id.contains("orbiter")) {
            return kind.equals("ability") ? "orbiter_attack" : "orbiter_" + kind;
        }
        if (id.contains("flashfly")) {
            return "flashfly_" + kind;
        }
        if (id.contains("scorpwing")) {
            return "scorpwing_" + kind;
        }
        if (id.contains("tetherbug")) {
            return kind.equals("ability") ? "tetherbug_attack" : "tetherbug_" + kind;
        }
        if (id.contains("drippler")) {
            return kind.equals("ability") ? "drippler_fire" : "drippler_" + kind;
        }
        if (id.contains("doublejaw")) {
            return "doublejaw_" + kind;
        }
        if (id.contains("cave_terror") || id.contains("caveterror")) {
            return "cave_terror_" + kind;
        }
        if (id.contains("terror_fly") || id.contains("terrorfly")) {
            return "terror_fly_" + kind;
        }
        if (id.contains("whisper")) {
            return "whisper_" + kind;
        }
        if (id.contains("torpedon")) {
            return kind.equals("ability") ? "torpedon_ability" : "torpedon_" + kind;
        }
        if (id.contains("lurcher")) {
            return kind.equals("ability") ? "lurcher_ability" : "lurcher_" + kind;
        }
        if (id.contains("livorax")) {
            return kind.equals("ability") ? "livorax_ability" : "livorax_" + kind;
        }
        if (id.contains("sentry")) {
            return kind.equals("ability") ? "sentry_ability" : "sentry_" + kind;
        }
        if (id.equals("nat") || id.contains("_nat")) {
            return "nat_" + kind;
        }
        return "";
    }

    private static String family(String id) {
        for (String family : new String[] {
                "deviantbear", "deviantblaze", "deviantcavespider", "deviantchicken", "deviantcow",
                "deviantcreeper", "deviantenderman", "deviantevoker", "deviantghast", "deviantgolem",
                "deviantskeleton", "deviantslime", "deviantspider", "deviantwitch", "deviantzombie"
        }) {
            if (id.contains(family)) {
                return family;
            }
        }
        return "";
    }

    private static String normalize(String id) {
        return id.toLowerCase(Locale.ROOT).replace("-", "_");
    }

    private static SoundEvent sound(String name) {
        return SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(LostInfinity.MODID, name));
    }
}
