package xol.lostinfinity.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import xol.lostinfinity.LostInfinity;
import xol.lostinfinity.registry.ModEffects;

@Mod.EventBusSubscriber(modid = LostInfinity.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class LostHudOverlays {
    private static final ResourceLocation HEALTH_ICON = gui("healthicon.png");
    private static final ResourceLocation DISTORTION_0 = gui("distortion/distortion_0.png");
    private static final ResourceLocation DISTORTION_1 = gui("distortion/distortion_1.png");
    private static final String ENERGY_TAG = "LostEnergy";
    private static final String AMMO_TAG = "LostAmmo";
    private static final String MODE_TAG = "LostMode";
    private static float distortionAlpha;

    private LostHudOverlays() {
    }

    @SubscribeEvent
    public static void registerOverlays(RegisterGuiOverlaysEvent event) {
        event.registerAboveAll("lost_health_values", (gui, graphics, partialTick, width, height) -> renderHealth(graphics, width, height));
        event.registerAboveAll("lost_item_status", (gui, graphics, partialTick, width, height) -> renderItemStatus(graphics, width, height));
        event.registerAboveAll("lost_distortion_cover", (gui, graphics, partialTick, width, height) -> renderDistortion(graphics, width, height));
    }

    private static void renderHealth(GuiGraphics graphics, int width, int height) {
        Minecraft minecraft = Minecraft.getInstance();
        Player player = minecraft.player;
        if (player == null || minecraft.options.hideGui || player.isCreative() || player.isSpectator()) {
            return;
        }
        int current = Math.round(player.getHealth());
        int max = Math.round(player.getMaxHealth());
        String text = healthText(current) + "/" + healthText(max);
        int x = Math.max(4, width / 2 - 168);
        int y = height - 18;
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        graphics.blit(HEALTH_ICON, x, y, 0, 0, 9, 9, 256, 256);
        graphics.drawString(minecraft.font, text, x + 12, y + 1, 0xFFE8F8FF, true);
    }

    private static void renderItemStatus(GuiGraphics graphics, int width, int height) {
        Minecraft minecraft = Minecraft.getInstance();
        Player player = minecraft.player;
        if (player == null || minecraft.options.hideGui) {
            return;
        }
        ItemStack stack = statusStack(player);
        if (stack.isEmpty() || !stack.hasTag()) {
            return;
        }
        CompoundTag tag = stack.getOrCreateTag();
        boolean hasEnergy = tag.contains(ENERGY_TAG);
        boolean hasAmmo = tag.contains(AMMO_TAG);
        boolean hasMode = tag.contains(MODE_TAG);
        if (!hasEnergy && !hasAmmo && !hasMode) {
            return;
        }
        int x = width / 2 + 96;
        int y = height - 44;
        graphics.fill(x - 4, y - 4, x + 96, y + 29, 0x77080B12);
        int line = 0;
        if (hasEnergy) {
            int energy = Math.max(0, tag.getInt(ENERGY_TAG));
            int bar = Mth.clamp(energy, 0, 500) * 64 / 500;
            graphics.drawString(minecraft.font, "Energy " + energy, x, y + line, 0xFFFFD166, true);
            graphics.fill(x, y + line + 10, x + 64, y + line + 13, 0xAA111318);
            graphics.fill(x, y + line + 10, x + bar, y + line + 13, 0xFFFFD166);
            line += 16;
        }
        if (hasAmmo) {
            graphics.drawString(minecraft.font, "Ammo " + Math.max(0, tag.getInt(AMMO_TAG)), x, y + line, 0xFFB6EAFF, true);
            line += 10;
        }
        if (hasMode) {
            graphics.drawString(minecraft.font, "Mode " + tag.getInt(MODE_TAG), x, y + line, 0xFFE6D4FF, true);
        }
    }

    private static void renderDistortion(GuiGraphics graphics, int width, int height) {
        Minecraft minecraft = Minecraft.getInstance();
        Player player = minecraft.player;
        if (player == null || minecraft.options.hideGui) {
            return;
        }
        MobEffectInstance effect = player.getEffect(ModEffects.DISTORTION.get());
        if (effect == null) {
            distortionAlpha = Math.max(0.0F, distortionAlpha - 0.05F);
            if (distortionAlpha <= 0.0F) {
                return;
            }
        } else {
            float durationFade = Math.min(0.9F, effect.getDuration() * 0.05F);
            distortionAlpha = Math.min(0.9F, Math.max(distortionAlpha + 0.05F, durationFade));
        }
        ResourceLocation texture = effect != null && effect.getAmplifier() > 0 ? DISTORTION_1 : DISTORTION_0;
        float pulse = 0.75F + 0.25F * Mth.sin((minecraft.player.tickCount + minecraft.getFrameTime()) * 0.1F);
        RenderSystem.enableBlend();
        RenderSystem.setShaderColor(1.0F, pulse, 1.0F, distortionAlpha);
        graphics.blit(texture, 0, 0, 0, 0, width, height, width, height);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.disableBlend();
    }

    private static ItemStack statusStack(Player player) {
        ItemStack main = player.getMainHandItem();
        if (main.hasTag() && hasStatusTag(main.getOrCreateTag())) {
            return main;
        }
        ItemStack off = player.getOffhandItem();
        return off.hasTag() && hasStatusTag(off.getOrCreateTag()) ? off : ItemStack.EMPTY;
    }

    private static boolean hasStatusTag(CompoundTag tag) {
        return tag.contains(ENERGY_TAG) || tag.contains(AMMO_TAG) || tag.contains(MODE_TAG);
    }

    private static String healthText(int health) {
        if (health >= 1000) {
            return Math.round(health / 100.0F) / 10.0F + "k";
        }
        return Integer.toString(Math.max(0, health));
    }

    private static ResourceLocation gui(String path) {
        return new ResourceLocation(LostInfinity.MODID, "textures/gui/" + path);
    }
}
