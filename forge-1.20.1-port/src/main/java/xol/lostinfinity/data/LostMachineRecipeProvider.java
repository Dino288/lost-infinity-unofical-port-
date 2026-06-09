package xol.lostinfinity.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import xol.lostinfinity.LostInfinity;

import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class LostMachineRecipeProvider implements DataProvider {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private final PackOutput output;

    public LostMachineRecipeProvider(PackOutput output) {
        this.output = output;
    }

    @Override
    public CompletableFuture<?> run(CachedOutput cache) {
        Path root = output.getOutputFolder(PackOutput.Target.DATA_PACK).resolve(LostInfinity.MODID).resolve("recipes/generated_machine");
        Map<String, JsonObject> recipes = new LinkedHashMap<>();
        addOreProcessing(recipes);
        addChemistry(recipes);
        addCalibration(recipes);
        addFabrication(recipes);
        addCompression(recipes);
        addCharging(recipes);
        return CompletableFuture.allOf(recipes.entrySet().stream()
                .map(entry -> DataProvider.saveStable(cache, GSON.toJsonTree(entry.getValue()), root.resolve(entry.getKey() + ".json")))
                .toArray(CompletableFuture[]::new));
    }

    private static void addOreProcessing(Map<String, JsonObject> recipes) {
        addMachine(recipes, "grinder_astrallium_ore", "grinder", "astrallium_ore", null, "", "astrallium_ingot", 2, 55, 130, false, "");
        addMachine(recipes, "grinder_atomite_ore", "grinder", "atomite_ore", null, "", "atomite_fragments", 3, 45, 110, false, "");
        addMachine(recipes, "grinder_auradine_ore", "grinder", "auradine_ore", null, "", "auradine", 2, 50, 120, false, "");
        addMachine(recipes, "grinder_catatonite_ore", "grinder", "catatonite_ore", null, "", "catatonite_shard", 3, 50, 120, false, "");
        addMachine(recipes, "grinder_cellular_ore", "grinder", "cellular_ore", null, "", "cellular_crystal", 2, 50, 120, false, "");
        addMachine(recipes, "grinder_clovinite_ore", "grinder", "clovinite_ore", null, "", "clovinite", 2, 50, 120, false, "");
        addMachine(recipes, "grinder_crystonium_ore", "grinder", "crystonium_ore", null, "", "crystonium_ingot", 2, 55, 130, false, "");
        addMachine(recipes, "grinder_darksteel_ore", "grinder", "darksteel_ore", null, "", "darksteel_shards", 2, 45, 120, false, "");
        addMachine(recipes, "grinder_detherium_ore", "grinder", "detherium_ore", null, "", "detherium_ingot", 2, 60, 140, false, "");
        addMachine(recipes, "grinder_emberium_ore", "grinder", "emberium_ore", null, "", "emberium_ingot", 2, 55, 130, false, "");
        addMachine(recipes, "grinder_exothermite_ore", "grinder", "exothermite_ore", null, "", "impure_exothermite", 2, 65, 150, false, "");
        addMachine(recipes, "grinder_gloominessence_ore", "grinder", "gloominessence_ore", null, "", "gloominessence", 2, 50, 120, false, "");
        addMachine(recipes, "grinder_hextorium_ore", "grinder", "hextorium_ore", null, "", "hextorium_ingot", 2, 60, 140, false, "");
        addMachine(recipes, "grinder_hivenite_ore", "grinder", "hivenite_ore", null, "", "hivenite", 2, 50, 120, false, "");
        addMachine(recipes, "grinder_igneous_pearl_ore", "grinder", "igneous_pearl_ore", null, "", "pearl_igneous", 2, 45, 110, false, "");
        addMachine(recipes, "grinder_incadium_ore", "grinder", "incadium_ore", null, "", "incadium_ingot", 2, 55, 130, false, "");
        addMachine(recipes, "grinder_incandescite_ore", "grinder", "incandescite_ore", null, "", "incandescite_ingot", 2, 55, 130, false, "");
        addMachine(recipes, "grinder_ionite_ore", "grinder", "ionite_ore", null, "", "ionite", 2, 50, 120, false, "");
        addMachine(recipes, "grinder_kylaxium_ore", "grinder", "kylaxium_ore", null, "", "kylaxium_ingot", 2, 60, 140, false, "");
        addMachine(recipes, "grinder_lucient_ore", "grinder", "lucient_ore", null, "", "lucient_ingot", 2, 45, 110, false, "");
        addMachine(recipes, "grinder_lumio_ore", "grinder", "lumio_ore", null, "", "luminessence", 2, 45, 110, false, "");
        addMachine(recipes, "grinder_myrite_ore", "grinder", "myrite_ore", null, "", "myrite", 2, 50, 120, false, "");
        addMachine(recipes, "grinder_noxerium_ore", "grinder", "noxerium_ore", null, "", "noxerium_ingot", 2, 60, 140, false, "");
        addMachine(recipes, "grinder_olysium_ore", "grinder", "olysium_ore", null, "", "olysium_ingot", 2, 60, 140, false, "");
        addMachine(recipes, "grinder_phototenzyte_ore", "grinder", "phototenzyte_ore", null, "", "phototenzyte_ingot", 2, 55, 130, false, "");
        addMachine(recipes, "grinder_phytrosium_ore", "grinder", "phytrosium_ore", null, "", "phytrosium_ingot", 2, 55, 130, false, "");
        addMachine(recipes, "grinder_prismosis_ore", "grinder", "prismosis_ore", null, "", "prismosis_shards", 3, 50, 120, false, "");
        addMachine(recipes, "grinder_serpentine_ore", "grinder", "serpentine_ore", null, "", "serpentine_crystal", 2, 50, 120, false, "");
        addMachine(recipes, "grinder_sunstone_ore", "grinder", "sunstone_ore", null, "", "sunstone", 2, 45, 120, false, "");
        addMachine(recipes, "grinder_vellorium_ore", "grinder", "vellorium_ore", null, "", "vellorium_ingot", 2, 60, 140, false, "");
        addMachine(recipes, "grinder_xerovium_ore", "grinder", "xerovium_ore", null, "", "xerovium_ingot", 2, 60, 140, false, "");
    }

    private static void addChemistry(Map<String, JsonObject> recipes) {
        addMachine(recipes, "chemistry_volatile_blood", "chemistry", "volatile_blood", "concentrated_acid", "lostinfinity:concentrated_acid", "volatility_solution", 1, 55, 140, true, "");
        addMachine(recipes, "chemistry_dimensional_polymer", "chemistry", "dimensional_capacitor", "nanofluoric_acid", "lostinfinity:nanofluoric_acid", "dimensional_polymer", 1, 120, 220, true, "");
        addMachine(recipes, "chemistry_bioreactive_solution", "chemistry", "toxic_spore_sample", "acidblood_solution", "lostinfinity:concentrated_acid", "bioreactive_solution", 1, 80, 180, true, "");
        addMachine(recipes, "nicronium_infuser_infused_nicronium", "nicronium_infuser", "nicronium", null, "", "infused_nicronium", 1, 90, 180, false, "");
        addMachine(recipes, "sap_evaporator_jar_of_syrup", "sap_evaporator", "jar_of_sap", null, "", "jar_of_syrup", 1, 35, 120, false, "");
        addMachine(recipes, "sap_evaporator_jar_of_sap", "sap", "sunderwood_sap", null, "", "jar_of_sap", 1, 35, 120, false, "");
    }

    private static void addCalibration(Map<String, JsonObject> recipes) {
        addMachine(recipes, "calibrated_fresh_data_chip", "calibrator", "fresh_data_chip", null, "", "fresh_data_chip", 1, 90, 180, false, "{LostInfinityCalibrated:1b}");
        addMachine(recipes, "formatter_basic_storage_chip", "formatter", "fresh_data_chip", "datadrive", "", "basic_storage_chip", 1, 80, 160, true, "{LostFormatted:1b}");
        addMachine(recipes, "fused_synchronite", "calibrator", "synchronite_ore", "advanced_synchronizer", "", "fused_synchronite", 1, 140, 240, false, "{LostStability:100}");
    }

    private static void addFabrication(Map<String, JsonObject> recipes) {
        addRecoveredModuleRecipes(recipes);
        addRecoveredModulatorRecipes(recipes);
        addMachine(recipes, "fabrication_dimensionalizer_blueprint", "fabrication", "dimensional_capacitor", "synchronizer", "", "dimensionalizer_blueprint", 1, 150, 260, true, "");
        addMachine(recipes, "fabrication_geodimensional_tunnel", "fabrication", "dimensionalizer_blueprint", "dimensional_polymer", "", "geodimensional_tunnel", 1, 180, 320, true, "");
    }

    private static void addRecoveredModuleRecipes(Map<String, JsonObject> recipes) {
        addMachineWithExtras(recipes, "module_creator_acceleration", "module_creator", "supermutated_batwing", "supermutated_wing", "", "module_acceleration", 1, 75, 150, true, "", "superstimulant");
        addMachineWithExtras(recipes, "module_creator_power", "module_creator", "power_control_disc", "overcharged_cell", "", "module_power", 1, 75, 150, true, "", "power_clamp");
        addMachineWithExtras(recipes, "module_creator_restoration", "module_creator", "lifeboundemerald", "jar_of_syrup", "", "module_restoration", 1, 75, 150, true, "", "lifestrain_enigma");
        addMachineWithExtras(recipes, "module_creator_range", "module_creator", "advanced_signal_receiver", "geocoordinated_orb", "", "module_range", 1, 75, 150, true, "", "nanofluoric_acid");
        addMachineWithExtras(recipes, "module_creator_conversion", "module_creator", "atomic_cell", "fractured_multiversite", "", "module_conversion", 1, 75, 150, true, "", "volatile_gloop");
        addMachineWithExtras(recipes, "module_creator_durability", "module_creator", "durable_husk", "crystallized_alloy", "", "module_durability", 1, 75, 150, true, "", "supermutated_pelt");
        addMachineWithExtras(recipes, "module_creator_hexing", "module_creator", "crystal_of_curses", "ghostly_husk", "", "module_hexing", 1, 75, 150, true, "", "cursedemerald");
        addMachineWithExtras(recipes, "module_creator_weight", "module_creator", "ultralight_dust", "weightless_gem", "", "module_weight", 1, 75, 150, true, "", "gravity_core");
        addMachineWithExtras(recipes, "module_creator_transmitting", "module_creator", "murky_clay", "reconfigured_matter", "", "module_transmitting", 1, 75, 150, true, "", "advanced_signal_receiver");
        addMachineWithExtras(recipes, "module_creator_biocalibration", "module_creator", "astral_organ", "organic_shadow_matter", "", "module_biocalibration", 1, 75, 150, true, "", "biosynced_clock");
    }

    private static void addRecoveredModulatorRecipes(Map<String, JsonObject> recipes) {
        addPrimeArmorSet(recipes, "vampyreon", "malicium_condensed",
                new String[][]{{"helmet", "module_range", "module_power"}, {"leggings", "module_range", "module_restoration"},
                        {"boots", "module_range", "module_acceleration"}, {"chestplate", "module_range", "module_conversion"}});
        addPrimeArmorSet(recipes, "spectros", "etherium_condensed",
                new String[][]{{"helmet", "module_hexing", "module_weight"}, {"leggings", "module_hexing", "module_restoration"},
                        {"boots", "module_hexing", "module_transmitting"}, {"chestplate", "module_hexing", "module_durability"}});
        addPrimeArmorSet(recipes, "vitraliton", "polarium_condensed",
                new String[][]{{"helmet", "module_restoration", "module_power"}, {"leggings", "module_restoration", "module_durability"},
                        {"boots", "module_restoration", "module_conversion"}, {"chestplate", "module_restoration", "module_acceleration"}});
        addPrimeArmorSet(recipes, "blightcyst", "kyvorium_condensed",
                new String[][]{{"helmet", "module_biocalibration", "module_power"}, {"leggings", "module_biocalibration", "module_durability"},
                        {"boots", "module_biocalibration", "module_transmitting"}, {"chestplate", "module_biocalibration", "module_conversion"}});
    }

    private static void addPrimeArmorSet(Map<String, JsonObject> recipes, String set, String condensed, String[][] pieces) {
        for (String[] piece : pieces) {
            String part = piece[0];
            addMachineWithExtras(recipes, "modulator_" + set + "_prime_" + part, "modulator", set + "_" + part,
                    piece[1], "", set + "_prime_" + part, 1, 180, 300, true, "", piece[2], condensed, condensed, condensed);
        }
    }

    private static void addCharging(Map<String, JsonObject> recipes) {
        addMachine(recipes, "charger_unpowered_cell", "charger", "unpowered_cell", "power_fuel", "", "superchargedcell", 1, 90, 180, true, "{LostEnergy:1000}");
        addMachine(recipes, "charger_advanced_synchronizer", "charger", "synchronizer", "dimensional_capacitor", "", "advanced_synchronizer", 1, 120, 220, false, "{LostEnergy:1500}");
    }

    private static void addCompression(Map<String, JsonObject> recipes) {
        addCompressionRecipe(recipes, "astrallium");
        addCompressionRecipe(recipes, "crystonium");
        addCompressionRecipe(recipes, "detherium");
        addCompressionRecipe(recipes, "emberium");
        addCompressionRecipe(recipes, "hextorium");
        addCompressionRecipe(recipes, "incadium");
        addCompressionRecipe(recipes, "kylaxium");
        addCompressionRecipe(recipes, "noxerium");
        addCompressionRecipe(recipes, "olysium");
        addCompressionRecipe(recipes, "vellorium");
        addCompressionRecipe(recipes, "xerovium");
        addCompressionRecipe(recipes, "phytrosium");
        addCompressionRecipe(recipes, "kyvorium");
        addCompressionRecipe(recipes, "biosynthium");
        addCompressionRecipe(recipes, "malicium");
        addCompressionRecipe(recipes, "etherium");
        addCompressionRecipe(recipes, "polarium");
    }

    private static void addCompressionRecipe(Map<String, JsonObject> recipes, String material) {
        addMachineWithInputCount(recipes, "compressiontable_" + material + "_condensed", "compressiontable",
                material + "_ingot", 25, null, "", material + "_condensed", 1, 120, 500, false, "");
    }

    private static void addMachine(Map<String, JsonObject> recipes, String id, String machine, String input, String catalyst,
                                   String fluid, String output, int count, int energy, int time, boolean consumeCatalyst, String nbt) {
        addMachineWithInputCount(recipes, id, machine, input, 1, catalyst, fluid, output, count, energy, time, consumeCatalyst, nbt);
    }

    private static void addMachineWithExtras(Map<String, JsonObject> recipes, String id, String machine, String input, String catalyst,
                                             String fluid, String output, int count, int energy, int time, boolean consumeCatalyst,
                                             String nbt, String... extras) {
        addMachineWithInputCount(recipes, id, machine, input, 1, catalyst, fluid, output, count, energy, time, consumeCatalyst, nbt, extras);
    }

    private static void addMachineWithInputCount(Map<String, JsonObject> recipes, String id, String machine, String input, int inputCount,
                                                 String catalyst, String fluid, String output, int count, int energy, int time,
                                                 boolean consumeCatalyst, String nbt, String... extras) {
        JsonObject recipe = new JsonObject();
        recipe.addProperty("type", LostInfinity.MODID + ":machine");
        recipe.addProperty("machine", machine);
        JsonObject inputJson = new JsonObject();
        inputJson.addProperty("item", LostInfinity.MODID + ":" + input);
        recipe.add("input", inputJson);
        if (inputCount > 1) {
            recipe.addProperty("input_count", inputCount);
        }
        if (catalyst != null) {
            JsonObject catalystJson = new JsonObject();
            catalystJson.addProperty("item", LostInfinity.MODID + ":" + catalyst);
            recipe.add("catalyst", catalystJson);
        }
        if (!fluid.isBlank()) {
            recipe.addProperty("fluid", fluid);
        }
        recipe.addProperty("consume_catalyst", consumeCatalyst);
        if (extras.length > 0) {
            JsonArray extrasJson = new JsonArray();
            for (String extra : extras) {
                JsonObject extraJson = new JsonObject();
                extraJson.addProperty("item", LostInfinity.MODID + ":" + extra);
                extrasJson.add(extraJson);
            }
            recipe.add("extras", extrasJson);
            recipe.addProperty("consume_extras", true);
        }
        recipe.addProperty("energy", energy);
        recipe.addProperty("time", time);
        JsonObject outputJson = new JsonObject();
        outputJson.addProperty("item", LostInfinity.MODID + ":" + output);
        outputJson.addProperty("count", count);
        if (!nbt.isBlank()) {
            outputJson.addProperty("nbt", nbt);
        }
        recipe.add("output", outputJson);
        recipes.put(id, recipe);
    }

    @Override
    public String getName() {
        return "Lost Infinity machine recipes";
    }
}
