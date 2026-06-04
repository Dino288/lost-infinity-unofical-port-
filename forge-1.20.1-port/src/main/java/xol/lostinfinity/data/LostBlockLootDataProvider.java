package xol.lostinfinity.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import xol.lostinfinity.LostInfinity;
import xol.lostinfinity.registry.ModBlocks;

public class LostBlockLootDataProvider implements DataProvider {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private final PackOutput output;

    public LostBlockLootDataProvider(PackOutput output) {
        this.output = output;
    }

    @Override
    public CompletableFuture<?> run(CachedOutput cache) {
        Path root = output.getOutputFolder(PackOutput.Target.DATA_PACK).resolve(LostInfinity.MODID).resolve("loot_tables/blocks");
        return CompletableFuture.allOf(ModBlocks.ALL_BLOCKS.stream()
                .map(block -> DataProvider.saveStable(cache, GSON.toJsonTree(lootTable(block)), root.resolve(block.getId().getPath() + ".json")))
                .toArray(CompletableFuture[]::new));
    }

    private static JsonObject lootTable(RegistryObject<Block> block) {
        String blockId = LostInfinity.MODID + ":" + block.getId().getPath();
        JsonObject table = new JsonObject();
        table.addProperty("type", "minecraft:block");
        JsonArray pools = new JsonArray();
        JsonObject pool = new JsonObject();
        pool.addProperty("rolls", 1.0D);
        JsonArray entries = new JsonArray();
        JsonObject entry = new JsonObject();
        entry.addProperty("type", "minecraft:item");
        entry.addProperty("name", blockId);
        entries.add(entry);
        pool.add("entries", entries);
        JsonArray conditions = new JsonArray();
        JsonObject survivesExplosion = new JsonObject();
        survivesExplosion.addProperty("condition", "minecraft:survives_explosion");
        conditions.add(survivesExplosion);
        pool.add("conditions", conditions);
        pools.add(pool);
        table.add("pools", pools);
        return table;
    }

    @Override
    public String getName() {
        return "Lost Infinity block loot tables";
    }
}
