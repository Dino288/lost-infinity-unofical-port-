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

    public static final RegistryObject<MobEffect> NULLIFIED = MOB_EFFECTS.register("nullified",
            () -> new LostSimpleEffect(MobEffectCategory.HARMFUL, 0x6F88A8));

    private ModEffects() {
    }
}
