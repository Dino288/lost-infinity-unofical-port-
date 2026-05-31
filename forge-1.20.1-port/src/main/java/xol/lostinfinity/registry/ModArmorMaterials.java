package xol.lostinfinity.registry;

import java.util.LinkedHashMap;
import java.util.Map;
import net.minecraft.world.item.ArmorMaterial;
import xol.lostinfinity.item.LostArmorMaterial;

public final class ModArmorMaterials {
    private static final ArmorMaterial DEFAULT = new LostArmorMaterial("lostinfinity", 33, 3, 6, 8, 3, 15, 2.0F, 0.05F);
    private static final Map<String, ArmorMaterial> MATERIALS = new LinkedHashMap<>();

    static {
        register("bionic_veggitron");
        register("blightcyst");
        register("blightcyst_prime");
        register("graviterium");
        register("plasmythic");
        register("spectros");
        register("spectros_prime");
        register("vampyreon");
        register("vampyreon_prime");
        register("vitraliton");
        register("vitraliton_prime");
        register("celestial");
        register("filtration");
    }

    private ModArmorMaterials() {
    }

    private static void register(String set) {
        MATERIALS.put(set, new LostArmorMaterial(set, 37, 3, 6, 8, 3, 18, 2.5F, 0.08F));
    }

    public static ArmorMaterial forItemName(String name) {
        String normalized = normalize(name);
        for (Map.Entry<String, ArmorMaterial> entry : MATERIALS.entrySet()) {
            if (normalized.startsWith(entry.getKey())) {
                return entry.getValue();
            }
        }
        if (normalized.contains("headguard")) {
            return MATERIALS.getOrDefault("celestial", DEFAULT);
        }
        if (normalized.contains("mask")) {
            return MATERIALS.getOrDefault("filtration", DEFAULT);
        }
        return DEFAULT;
    }

    private static String normalize(String name) {
        return name.replace("_helmet", "")
                .replace("_chestplate", "")
                .replace("_leggings", "")
                .replace("_boots", "")
                .replace("headguard", "celestial")
                .replace("mask", "filtration");
    }
}
