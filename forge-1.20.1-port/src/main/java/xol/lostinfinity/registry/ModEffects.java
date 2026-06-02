package xol.lostinfinity.registry;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import xol.lostinfinity.LostInfinity;
import xol.lostinfinity.effect.LostSimpleEffect;

public final class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, LostInfinity.MODID);

    public static final RegistryObject<MobEffect> SECURITY_CLEARANCE = beneficial("security_clearance", 0xFF033D);
    public static final RegistryObject<MobEffect> IRONHEART = beneficial("ironheart", 0xB8B8C8);
    public static final RegistryObject<MobEffect> ADRENALINE = beneficial("adrenaline", 0xFF3333);
    public static final RegistryObject<MobEffect> ULTRAHEAVY = beneficial("ultraheavy", 0x555555);
    public static final RegistryObject<MobEffect> GRAVITATIONAL = beneficial("gravitational", 0x6755C8);
    public static final RegistryObject<MobEffect> VULNERABILITY = harmful("vulnerability", 0xD86A6A);
    public static final RegistryObject<MobEffect> PLAGUE = harmful("plague", 0x4C7A1F);
    public static final RegistryObject<MobEffect> SHOCKED = harmful("shocked", 0x65D8FF);
    public static final RegistryObject<MobEffect> DIMENSIONAL_TEAR = harmful("dimensional_tear", 0x8D55FF);
    public static final RegistryObject<MobEffect> PROTECTED = beneficial("protected", 0xF7E36D);
    public static final RegistryObject<MobEffect> RAMPAGING = beneficial("rampaging", 0xE64524);
    public static final RegistryObject<MobEffect> RACING_HEART = beneficial("racing_heart", 0xE51B4C);
    public static final RegistryObject<MobEffect> ARMORED = beneficial("armored", 0x9CA6AD);
    public static final RegistryObject<MobEffect> CHARGING = beneficial("charging", 0x5DD4FF);
    public static final RegistryObject<MobEffect> NULLIFIED = harmful("nullified", 0x6F88A8);
    public static final RegistryObject<MobEffect> CONTAGIOUS = harmful("contagious", 0x669933);
    public static final RegistryObject<MobEffect> TETHERED = harmful("tethered", 0x35305F);
    public static final RegistryObject<MobEffect> BLIGHTED = harmful("blighted", 0x7B2DA8);
    public static final RegistryObject<MobEffect> INTANGIBLE = harmful("intangible", 0x99BBFF);
    public static final RegistryObject<MobEffect> LAST_BREATH = harmful("last_breath", 0x101820);
    public static final RegistryObject<MobEffect> NITROUS = beneficial("nitrous", 0xD6F7FF);
    public static final RegistryObject<MobEffect> SHATTERED = harmful("shattered", 0xB6EAFF);
    public static final RegistryObject<MobEffect> BLOOD_TOXIN = harmful("blood_toxin", 0x7A0011);
    public static final RegistryObject<MobEffect> SPECTRAL = harmful("spectral", 0x88D7FF);
    public static final RegistryObject<MobEffect> DISTORTION = harmful("distortion", 0xAA55DD);
    public static final RegistryObject<MobEffect> PHASED = harmful("phased", 0xB2A7FF);
    public static final RegistryObject<MobEffect> POTION_AFFINITY = beneficial("potion_affinity", 0xFF77D6);
    public static final RegistryObject<MobEffect> OTHERWORLDLY = harmful("otherworldly", 0x2C1748);
    public static final RegistryObject<MobEffect> SPONTANEOUS_COMBUSTION = harmful("spontaneous_combustion", 0xFF5E1A);
    public static final RegistryObject<MobEffect> PLANESPLIT = harmful("planesplit", 0x5ED6FF);
    public static final RegistryObject<MobEffect> UNLEASHING = beneficial("unleashing", 0xFFB347);
    public static final RegistryObject<MobEffect> MIASMA = beneficial("miasma", 0x647F3B);
    public static final RegistryObject<MobEffect> TRANSFUSION = beneficial("transfusion", 0xA3132B);
    public static final RegistryObject<MobEffect> SUPERSONIC = beneficial("supersonic", 0xBDEFFF);
    public static final RegistryObject<MobEffect> ACIDIC = beneficial("acidic", 0xB2FF35);
    public static final RegistryObject<MobEffect> FRACTURE = beneficial("fracture", 0xFFC1A6);
    public static final RegistryObject<MobEffect> FEARED = beneficial("feared", 0x58335F);
    public static final RegistryObject<MobEffect> TERRIFIED = beneficial("terrified", 0x24132B);
    public static final RegistryObject<MobEffect> SUPERCHARGED = beneficial("supercharged", 0xFFD95E);

    private ModEffects() {
    }

    private static RegistryObject<MobEffect> beneficial(String name, int color) {
        return MOB_EFFECTS.register(name, () -> new LostSimpleEffect(MobEffectCategory.BENEFICIAL, color));
    }

    private static RegistryObject<MobEffect> harmful(String name, int color) {
        return MOB_EFFECTS.register(name, () -> new LostSimpleEffect(MobEffectCategory.HARMFUL, color));
    }
}
