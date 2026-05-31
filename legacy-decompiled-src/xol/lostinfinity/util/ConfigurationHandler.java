/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraftforge.common.config.Configuration
 */
package xol.lostinfinity.util;

import java.io.File;
import net.minecraftforge.common.config.Configuration;

public class ConfigurationHandler {
    public static Configuration cfg;
    public static int celestial_void_id;
    public static int cartographer_realm_bot_id;
    public static int cartographer_realm_mid_id;
    public static int cartographer_realm_top_id;
    public static int grandmaster_outpost_id;
    public static int nonexistence_id;
    public static int infinite_murk_id;
    public static int shadow_sea_id;
    public static boolean armor_flight;
    public static int health_x;
    public static int health_y;

    public static void init(File dir) {
        cfg = new Configuration(new File(dir, "LostInfinityStones.cfg"));
        cfg.load();
        ConfigurationHandler.do_IDs();
        ConfigurationHandler.do_GUI();
        cfg.save();
    }

    public static void do_IDs() {
        celestial_void_id = cfg.get("Dimension", "CelestialVoid ID", 2150).getInt();
        cartographer_realm_top_id = cfg.get("Dimension", "CartographerRealmTop ID", 2151).getInt();
        grandmaster_outpost_id = cfg.get("Dimension", "GrandmasterOutpost ID", 2152).getInt();
        nonexistence_id = cfg.get("Dimension", "Nonexistence ID", 2153).getInt();
        infinite_murk_id = cfg.get("Dimension", "InfiniteMurk ID", 2154).getInt();
        cartographer_realm_mid_id = cfg.get("Dimension", "CartographerRealmMid ID", 2155).getInt();
        cartographer_realm_bot_id = cfg.get("Dimension", "CartographerRealmBot ID", 2156).getInt();
        shadow_sea_id = cfg.get("Dimension", "Shadow Sea ID", 2157).getInt();
        armor_flight = cfg.get("Item Effects", "Armor Flight Allowed", true).getBoolean();
    }

    public static void do_GUI() {
        health_x = cfg.get("GUI", "HealthGUI offsetY", 0).getInt();
        health_y = cfg.get("GUI", "HealthGUI offsetX", 0).getInt();
    }
}

