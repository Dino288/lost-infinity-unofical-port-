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
        addMachine(recipes, "grinder_sunstone_ore", "grinder", "sunstone_ore", null, "", "sunstone", 2, 45, 120, false, "");
        addMachine(recipes, "grinder_darksteel_ore", "grinder", "darksteel_ore", null, "", "darksteel_ingot", 1, 45, 120, false, "");
        addMachine(recipes, "chemistry_volatile_blood", "chemistry", "volatile_blood", "concentrated_acid", "lostinfinity:concentrated_acid", "volatility_solution", 1, 55, 140, true, "");
        addMachine(recipes, "calibrated_fresh_data_chip", "calibrator", "blank_data_chip", null, "", "fresh_data_chip", 1, 90, 180, false, "{LostInfinityCalibrated:1b}");
        return CompletableFuture.allOf(recipes.entrySet().stream()
                .map(entry -> DataProvider.saveStable(cache, GSON.toJsonTree(entry.getValue()), root.resolve(entry.getKey() + ".json")))
                .toArray(CompletableFuture[]::new));
    }

    private static void addMachine(Map<String, JsonObject> recipes, String id, String machine, String input, String catalyst,
                                   String fluid, String output, int count, int energy, int time, boolean consumeCatalyst, String nbt) {
        JsonObject recipe = new JsonObject();
        recipe.addProperty("type", LostInfinity.MODID + ":machine");
        recipe.addProperty("machine", machine);
        JsonObject inputJson = new JsonObject();
        inputJson.addProperty("item", LostInfinity.MODID + ":" + input);
        recipe.add("input", inputJson);
        if (catalyst != null) {
            JsonObject catalystJson = new JsonObject();
            catalystJson.addProperty("item", LostInfinity.MODID + ":" + catalyst);
            recipe.add("catalyst", catalystJson);
        }
        if (!fluid.isBlank()) {
            recipe.addProperty("fluid", fluid);
        }
        recipe.addProperty("consume_catalyst", consumeCatalyst);
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
