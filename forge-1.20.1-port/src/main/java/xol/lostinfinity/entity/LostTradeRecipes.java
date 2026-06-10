package xol.lostinfinity.entity;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.registries.ForgeRegistries;
import xol.lostinfinity.LostInfinity;
import xol.lostinfinity.effect.LostFx;

public final class LostTradeRecipes {
    private LostTradeRecipes() {
    }

    public static boolean tryTrade(String mobId, Player player, InteractionHand hand) {
        List<Trade> trades = tradesFor(mobId);
        if (trades.isEmpty()) {
            return false;
        }
        ItemStack main = player.getItemInHand(hand);
        ItemStack offhand = player.getOffhandItem();
        for (Trade trade : trades) {
            if (!matches(main, trade.firstItem(), trade.firstCount())) {
                continue;
            }
            if (!trade.secondItem().isBlank() && !matches(offhand, trade.secondItem(), trade.secondCount())) {
                continue;
            }
            if (!player.getAbilities().instabuild) {
                main.shrink(trade.firstCount());
                if (!trade.secondItem().isBlank()) {
                    offhand.shrink(trade.secondCount());
                }
            }
            ItemStack output = stack(trade.outputItem(), trade.outputCount());
            if (!player.addItem(output.copy())) {
                player.drop(output, false);
            }
            LostFx.play(player.level(), player.blockPosition(), "special_craft", SoundSource.NEUTRAL, 0.7F, 1.1F);
            LostFx.burst(player.level(), player.blockPosition(), "golden_magic", 14, 0.45D, 0.03D);
            return true;
        }
        return false;
    }

    private static List<Trade> tradesFor(String mobId) {
        List<Trade> trades = new ArrayList<>();
        switch (mobId) {
            case "supply_trader" -> {
                trades.add(new Trade("azure_leaf", 15, "", 0, "amazonite_token", 1));
                trades.add(new Trade("constricting_vines", 10, "", 0, "amazonite_token", 1));
                trades.add(new Trade("lucient_ingot", 3, "", 0, "amazonite_token", 3));
                trades.add(new Trade("bumble_blossom", 4, "", 0, "amazonite_token", 1));
            }
            case "archeologist" -> trades.add(new Trade("remains_pelican_eel", 1, "", 0, "silver_token", 16));
            case "chemist" -> addChemistTrades(trades);
            case "contrader_market" -> addBlackMarketTrades(trades);
            case "contrader_trampoline_dodgeball" -> addZirconiaTrades(trades, "zirconia_aubergine", "dangerous_accelerant", "energy_splitter", false);
            case "contrader_battle_snakes" -> addZirconiaTrades(trades, "zirconia_celadon", "super_inductor", "advanced_relay", false);
            case "contrader_holodeck" -> addZirconiaTrades(trades, "zirconia_cerulean", "power_plug", "cerulean_lens", false);
            case "contrader_bombers" -> addZirconiaTrades(trades, "zirconia_citrine", "citrine_thyratron", "citrine_supercharger", false);
            case "contrader_hunters" -> addZirconiaTrades(trades, "zirconia_crimson", "power_funnel", "crimson_transducer", false);
            case "contrader_ink_battle" -> addZirconiaTrades(trades, "zirconia_ivory", "chrome_alum_vial", "ink_pen", false);
            case "contrader_redlight" -> addZirconiaTrades(trades, "zirconia_malachite", "movement_sensor", "malachite_inclinometer", false);
            case "contrader_laser_tag" -> addZirconiaTrades(trades, "zirconia_midnight", "laser_pointer", "rgb_illuminator", false);
            case "contrader_parkour" -> addZirconiaTrades(trades, "zirconia_musky", "void_box", "super_booster", true);
            case "contrader_treadmill" -> addZirconiaTrades(trades, "zirconia_mythic", "spacebound_altimeter", "complex_gyroscope", false);
            case "contrader_lightbridge" -> addZirconiaTrades(trades, "zirconia_oyster", "elliptical_projector", "simple_microcontroller", false);
            case "contrader_targets" -> addZirconiaTrades(trades, "zirconia_rosewood", "polyswitch", "spark_chamber", true);
            default -> {
            }
        }
        return trades;
    }

    private static void addZirconiaTrades(List<Trade> trades, String zirconia, String midReward, String highReward, boolean elite) {
        trades.add(new Trade(elite ? "mastercut_diamond" : "celestialdiamond", elite ? 5 : 10, "", 0,
                elite ? "elite_contender_pass" : "contenderpass", 1));
        trades.add(new Trade(elite ? "mastercut_diamond" : "celestialdiamond", elite ? 10 : 15, "", 0,
                "mystery_box", elite ? 4 : 1));
        trades.add(new Trade(zirconia, 20, "", 0, midReward, 1));
        trades.add(new Trade(zirconia, 50, zirconia, 50, highReward, 1));
    }

    private static void addChemistTrades(List<Trade> trades) {
        trades.add(new Trade("gold_token", 1, "", 0, "blue_monomer_sample", 15));
        trades.add(new Trade("gold_token", 1, "", 0, "green_monomer_sample", 15));
        trades.add(new Trade("gold_token", 1, "", 0, "red_monomer_sample", 15));
        trades.add(new Trade("gold_token", 1, "", 0, "purple_monomer_sample", 15));
        trades.add(new Trade("gold_token", 1, "", 0, "yellow_monomer_sample", 15));
        trades.add(new Trade("amazonite_token", 1, "", 0, "magic_biopowder", 10));
        trades.add(new Trade("corrupted_root", 60, "container_of_collection_full", 1, "colixium_catenation_pouch", 1));
        trades.add(new Trade("ghostly_husk", 60, "container_of_collection_full", 1, "phoroxium_catenation_pouch", 1));
        trades.add(new Trade("luminescent_cubes", 60, "container_of_collection_full", 1, "laraxium_catenation_pouch", 1));
    }

    private static void addBlackMarketTrades(List<Trade> trades) {
        trades.add(new Trade("mastercrafted_alloy", 15, "container_of_collection_full", 1, "dual_weapon_convertor", 1));
        trades.add(new Trade("crystallized_alloy", 15, "container_of_collection_full", 1, "direct_weapon_convertor", 1));
        trades.add(new Trade("starcrystal_capacitor", 10, "container_of_collection_full", 1, "ultrapowered_capacitor", 1));
        trades.add(new Trade("gigacharge_solutions", 10, "container_of_collection_full", 1, "minor_multiversal_device", 1));
        trades.add(new Trade("unstable_ingot", 20, "container_of_collection_full", 1, "radioactive_isotopes", 1));
        trades.add(new Trade("deviant_fragment_bl", 1, "", 0, "broach_of_deviancy", 1));
        trades.add(new Trade("deviant_fragment_br", 1, "", 0, "broach_of_deviancy", 1));
        trades.add(new Trade("deviant_fragment_tr", 1, "", 0, "broach_of_deviancy", 1));
        trades.add(new Trade("deviant_fragment_tl", 1, "", 0, "broach_of_deviancy", 1));
        trades.add(new Trade("silver_token", 10, "", 0, "hypersonic_drive_chamber", 1));
        trades.add(new Trade("amazonite_token", 4, "reactive_mushroom", 1, "super_cell", 2));
        trades.add(new Trade("amazonite_token", 4, "ghostly_husk", 60, "etherstock_seeds", 1));
        trades.add(new Trade("box_of_life", 1, "", 0, "gold_token", 10));
    }

    private static boolean matches(ItemStack stack, String itemId, int count) {
        return !stack.isEmpty() && stack.getCount() >= count && stack.is(item(itemId));
    }

    private static ItemStack stack(String itemId, int count) {
        return new ItemStack(item(itemId), count);
    }

    private static Item item(String itemId) {
        Item item = ForgeRegistries.ITEMS.getValue(ResourceLocation.fromNamespaceAndPath(LostInfinity.MODID, itemId));
        return item == null ? Items.AIR : item;
    }

    private record Trade(String firstItem, int firstCount, String secondItem, int secondCount, String outputItem, int outputCount) {
    }
}
