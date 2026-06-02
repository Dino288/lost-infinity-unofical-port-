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
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class LostBiomeTagDataProvider implements DataProvider {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private final PackOutput output;

    public LostBiomeTagDataProvider(PackOutput output) {
        this.output = output;
    }

    @Override
    public CompletableFuture<?> run(CachedOutput cache) {
        Path root = output.getOutputFolder(PackOutput.Target.DATA_PACK).resolve(LostInfinity.MODID).resolve("tags/worldgen/biome");
        Map<String, List<String>> tags = new LinkedHashMap<>();
        tags.put("lost_dimensions", List.of("cartographerrealm", "shadowsea", "nonexistence", "moltensea", "infinitemurk", "grandmasteroutpost", "celestialvoid"));
        tags.put("shadow_sea", List.of("shadowsea", "moltensea"));
        tags.put("infinite_murk", List.of("infinitemurk"));
        tags.put("nonexistence", List.of("nonexistence"));
        tags.put("cartographer_realm", List.of("cartographerrealm"));
        tags.put("celestial", List.of("celestialvoid", "grandmasteroutpost"));
        return CompletableFuture.allOf(tags.entrySet().stream()
                .map(entry -> DataProvider.saveStable(cache, GSON.toJsonTree(tag(entry.getValue())), root.resolve(entry.getKey() + ".json")))
                .toArray(CompletableFuture[]::new));
    }

    private static JsonObject tag(List<String> biomes) {
        JsonObject json = new JsonObject();
        json.addProperty("replace", false);
        JsonArray values = new JsonArray();
        for (String biome : biomes) {
            values.add(LostInfinity.MODID + ":" + biome);
        }
        json.add("values", values);
        return json;
    }

    @Override
    public String getName() {
        return "Lost Infinity biome tags";
    }
}
