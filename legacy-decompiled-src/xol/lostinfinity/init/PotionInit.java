/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.potion.Potion
 *  net.minecraftforge.fml.common.registry.ForgeRegistries
 *  net.minecraftforge.registries.IForgeRegistryEntry
 */
package xol.lostinfinity.init;

import net.minecraft.potion.Potion;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistryEntry;
import xol.lostinfinity.util.PotionBasic;

public class PotionInit {
    public static final Potion SECURITY_CLEARANCE = new PotionBasic("security_clearance", false, 16711757, 0, 0);
    public static final Potion IRONHEART = new PotionBasic("ironheart", false, 16711757, 1, 0);
    public static final Potion ADRENALINE = new PotionBasic("adrenaline", false, 16711757, 2, 0);
    public static final Potion ULTRAHEAVY = new PotionBasic("ultraheavy", false, 16711757, 3, 0);
    public static final Potion GRAVITATIONAL = new PotionBasic("gravitational", false, 16711757, 4, 0);
    public static final Potion VULNERABILITY = new PotionBasic("vulnerability", true, 16711757, 5, 0);
    public static final Potion PLAGUE = new PotionBasic("plague", true, 16711757, 6, 0);
    public static final Potion SHOCKED = new PotionBasic("shocked", true, 16711757, 7, 0);
    public static final Potion DIMENSIONAL_TEAR = new PotionBasic("dimensional_tear", true, 16711757, 8, 0);
    public static final Potion PROTECTED = new PotionBasic("protected", false, 16711757, 9, 0);
    public static final Potion RAMPAGING = new PotionBasic("rampaging", false, 16711757, 10, 0);
    public static final Potion RACING_HEART = new PotionBasic("racing_heart", false, 16711757, 11, 0);
    public static final Potion ARMORED = new PotionBasic("armored", false, 16711757, 12, 0);
    public static final Potion CHARGING = new PotionBasic("charging", false, 16711757, 13, 0);
    public static final Potion NULLIFIED = new PotionBasic("nullified", true, 16711757, 14, 0);
    public static final Potion CONTAGIOUS = new PotionBasic("contagious", true, 16711757, 15, 0);
    public static final Potion TETHERED = new PotionBasic("tethered", true, 16711757, 16, 0);
    public static final Potion BLIGHTED = new PotionBasic("blighted", true, 16711757, 17, 0);
    public static final Potion INTANGIBLE = new PotionBasic("intangible", true, 16711757, 18, 0);
    public static final Potion LAST_BREATH = new PotionBasic("last_breath", true, 16711757, 19, 0);
    public static final Potion NITROUS = new PotionBasic("nitrous", false, 16711757, 20, 0);
    public static final Potion SHATTERED = new PotionBasic("shattered", true, 16711757, 21, 0);
    public static final Potion BLOOD_TOXIN = new PotionBasic("blood_toxin", true, 16711757, 22, 0);
    public static final Potion SPECTRAL = new PotionBasic("spectral", true, 16711757, 23, 0);
    public static final Potion DISTORTION = new PotionBasic("distortion", true, 16711757, 24, 0);
    public static final Potion PHASED = new PotionBasic("phased", true, 16711757, 25, 0);
    public static final Potion POTION_AFFINITY = new PotionBasic("potion_affinity", false, 16711757, 26, 0);
    public static final Potion OTHERWORLDLY = new PotionBasic("otherworldly", true, 16711757, 27, 0);
    public static final Potion SPONTANEOUS_COMBUSTION = new PotionBasic("spontaneous_combustion", true, 16711757, 28, 0);
    public static final Potion PLANESPLIT = new PotionBasic("planesplit", true, 16711757, 29, 0);
    public static final Potion UNLEASHING = new PotionBasic("unleashing", false, 16711757, 30, 0);
    public static final Potion MIASMA = new PotionBasic("miasma", false, 16711757, 31, 0);
    public static final Potion TRANSFUSION = new PotionBasic("transfusion", false, 16711757, 32, 0);
    public static final Potion SUPERSONIC = new PotionBasic("supersonic", false, 16711757, 33, 0);
    public static final Potion ACIDIC = new PotionBasic("acidic", false, 16711757, 34, 0);
    public static final Potion FRACTURE = new PotionBasic("fracture", false, 16711757, 35, 0);
    public static final Potion FEARED = new PotionBasic("feared", false, 16711757, 36, 0);
    public static final Potion TERRIFIED = new PotionBasic("terrified", false, 16711757, 37, 0);
    public static final Potion SUPERCHARGED = new PotionBasic("supercharged", false, 16711757, 38, 0);

    public static void registerPotions() {
        ForgeRegistries.POTIONS.register((IForgeRegistryEntry)SECURITY_CLEARANCE);
        ForgeRegistries.POTIONS.register((IForgeRegistryEntry)IRONHEART);
        ForgeRegistries.POTIONS.register((IForgeRegistryEntry)ADRENALINE);
        ForgeRegistries.POTIONS.register((IForgeRegistryEntry)ULTRAHEAVY);
        ForgeRegistries.POTIONS.register((IForgeRegistryEntry)GRAVITATIONAL);
        ForgeRegistries.POTIONS.register((IForgeRegistryEntry)VULNERABILITY);
        ForgeRegistries.POTIONS.register((IForgeRegistryEntry)PLAGUE);
        ForgeRegistries.POTIONS.register((IForgeRegistryEntry)SHOCKED);
        ForgeRegistries.POTIONS.register((IForgeRegistryEntry)DIMENSIONAL_TEAR);
        ForgeRegistries.POTIONS.register((IForgeRegistryEntry)PROTECTED);
        ForgeRegistries.POTIONS.register((IForgeRegistryEntry)RAMPAGING);
        ForgeRegistries.POTIONS.register((IForgeRegistryEntry)RACING_HEART);
        ForgeRegistries.POTIONS.register((IForgeRegistryEntry)ARMORED);
        ForgeRegistries.POTIONS.register((IForgeRegistryEntry)CHARGING);
        ForgeRegistries.POTIONS.register((IForgeRegistryEntry)NULLIFIED);
        ForgeRegistries.POTIONS.register((IForgeRegistryEntry)CONTAGIOUS);
        ForgeRegistries.POTIONS.register((IForgeRegistryEntry)TETHERED);
        ForgeRegistries.POTIONS.register((IForgeRegistryEntry)BLIGHTED);
        ForgeRegistries.POTIONS.register((IForgeRegistryEntry)INTANGIBLE);
        ForgeRegistries.POTIONS.register((IForgeRegistryEntry)LAST_BREATH);
        ForgeRegistries.POTIONS.register((IForgeRegistryEntry)NITROUS);
        ForgeRegistries.POTIONS.register((IForgeRegistryEntry)SHATTERED);
        ForgeRegistries.POTIONS.register((IForgeRegistryEntry)BLOOD_TOXIN);
        ForgeRegistries.POTIONS.register((IForgeRegistryEntry)SPECTRAL);
        ForgeRegistries.POTIONS.register((IForgeRegistryEntry)DISTORTION);
        ForgeRegistries.POTIONS.register((IForgeRegistryEntry)PHASED);
        ForgeRegistries.POTIONS.register((IForgeRegistryEntry)POTION_AFFINITY);
        ForgeRegistries.POTIONS.register((IForgeRegistryEntry)OTHERWORLDLY);
        ForgeRegistries.POTIONS.register((IForgeRegistryEntry)SPONTANEOUS_COMBUSTION);
        ForgeRegistries.POTIONS.register((IForgeRegistryEntry)PLANESPLIT);
        ForgeRegistries.POTIONS.register((IForgeRegistryEntry)UNLEASHING);
        ForgeRegistries.POTIONS.register((IForgeRegistryEntry)MIASMA);
        ForgeRegistries.POTIONS.register((IForgeRegistryEntry)TRANSFUSION);
        ForgeRegistries.POTIONS.register((IForgeRegistryEntry)SUPERSONIC);
        ForgeRegistries.POTIONS.register((IForgeRegistryEntry)ACIDIC);
        ForgeRegistries.POTIONS.register((IForgeRegistryEntry)FRACTURE);
        ForgeRegistries.POTIONS.register((IForgeRegistryEntry)TERRIFIED);
        ForgeRegistries.POTIONS.register((IForgeRegistryEntry)FEARED);
        ForgeRegistries.POTIONS.register((IForgeRegistryEntry)SUPERCHARGED);
    }
}

