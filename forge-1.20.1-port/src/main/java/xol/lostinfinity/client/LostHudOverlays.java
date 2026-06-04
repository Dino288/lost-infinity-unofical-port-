package xol.lostinfinity.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import xol.lostinfinity.LostInfinity;
import xol.lostinfinity.registry.ModEffects;

@Mod.EventBusSubscriber(modid = LostInfinity.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class LostHudOverlays {
    private static final ResourceLocation HEALTH_ICON = gui("healthicon.png");
    private static final ResourceLocation BOSS_HP_BAR = gui("boss_hp_bar.png");
    private static final ResourceLocation BULLSEYE = gui("bullseye.png");
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
        event.registerAboveAll("lost_dimension_status", (gui, graphics, partialTick, width, height) -> renderDimensionStatus(graphics, width, height));
        event.registerAboveAll("lost_target_status", (gui, graphics, partialTick, width, height) -> renderTargetStatus(graphics, width, height));
        event.registerAboveAll("lost_contest_status", (gui, graphics, partialTick, width, height) -> renderContestStatus(graphics, width, height));
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

    private static void renderDimensionStatus(GuiGraphics graphics, int width, int height) {
        Minecraft minecraft = Minecraft.getInstance();
        Player player = minecraft.player;
        if (player == null || minecraft.options.hideGui) {
            return;
        }
        ResourceLocation dimension = player.level().dimension().location();
        if (!LostInfinity.MODID.equals(dimension.getNamespace())) {
            return;
        }
        DimensionHud hud = dimensionHud(dimension.getPath());
        int x = 8;
        int y = 8;
        int color = hud.color();
        graphics.fill(x - 3, y - 3, x + 125, y + 24, 0x66040810);
        graphics.fill(x - 3, y - 3, x - 1, y + 24, 0xDD000000 | color);
        graphics.drawString(minecraft.font, hud.title(), x + 5, y, 0xFFE8EDF2, true);
        graphics.drawString(minecraft.font, hud.subtitle(player.tickCount), x + 5, y + 11, 0xFFB6EAFF, false);
    }

    private static void renderTargetStatus(GuiGraphics graphics, int width, int height) {
        Minecraft minecraft = Minecraft.getInstance();
        Player player = minecraft.player;
        if (player == null || minecraft.options.hideGui || !(minecraft.hitResult instanceof EntityHitResult entityHit)
                || !(entityHit.getEntity() instanceof LivingEntity target) || !target.isAlive()) {
            return;
        }
        ResourceLocation targetId = target.getType().builtInRegistryHolder().key().location();
        if (!LostInfinity.MODID.equals(targetId.getNamespace())) {
            return;
        }
        int x = width / 2 - 91;
        int y = 18;
        int barWidth = 182;
        float health = Math.max(0.0F, target.getHealth());
        float max = Math.max(1.0F, target.getMaxHealth());
        int fill = Mth.clamp((int) (barWidth * health / max), 0, barWidth);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        graphics.blit(BOSS_HP_BAR, x, y, 0, 0, barWidth, 12, 256, 256);
        graphics.fill(x + 5, y + 4, x + 5 + Math.max(0, fill - 10), y + 8, targetColor(targetId.getPath()));
        String name = target.getDisplayName().getString();
        graphics.drawString(minecraft.font, name, width / 2 - minecraft.font.width(name) / 2, y - 10, 0xFFE8EDF2, true);
        String hp = healthText(Math.round(health)) + "/" + healthText(Math.round(max));
        graphics.drawString(minecraft.font, hp, width / 2 - minecraft.font.width(hp) / 2, y + 14, 0xFFFFD166, true);
    }

    private static void renderContestStatus(GuiGraphics graphics, int width, int height) {
        Minecraft minecraft = Minecraft.getInstance();
        Player player = minecraft.player;
        if (player == null || minecraft.options.hideGui || !isContestContext(player)) {
            return;
        }
        int x = width - 94;
        int y = 10;
        graphics.fill(x - 5, y - 5, x + 86, y + 38, 0x77040810);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 0.9F);
        graphics.blit(BULLSEYE, x + 2, y + 4, 0, 0, 24, 24, 256, 256);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        graphics.drawString(minecraft.font, contestTitle(player), x + 31, y + 3, 0xFFE8EDF2, true);
        graphics.drawString(minecraft.font, contestPulse(player.tickCount), x + 31, y + 15, 0xFF6AF2FF, false);
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

    private static DimensionHud dimensionHud(String dimension) {
        return switch (dimension) {
            case "infinitemurk" -> new DimensionHud("Infinite Murk", "reflection unstable", 0x7E5AD6);
            case "shadowsea" -> new DimensionHud("Shadow Sea", "current pressure rising", 0x2EC7D3);
            case "nonexistence" -> new DimensionHud("Nonexistence", "void signal detected", 0xF4D35E);
            case "celestialvoid" -> new DimensionHud("Celestial Void", "stellar exposure", 0xA7D8FF);
            case "grandmasteroutpost" -> new DimensionHud("Grandmaster Outpost", "contest systems online", 0xFF4F8B);
            case "cartographerrealmtop" -> new DimensionHud("Cartographer Realm", "top labyrinth floor", 0x64B5F6);
            case "cartographerrealmmid" -> new DimensionHud("Cartographer Realm", "middle labyrinth floor", 0xFF6B6B);
            case "cartographerrealmbot" -> new DimensionHud("Cartographer Realm", "bottom labyrinth floor", 0xB388FF);
            default -> new DimensionHud(dimension, "route recorded", 0xB6EAFF);
        };
    }

    private static int targetColor(String id) {
        if (id.contains("galaxy") || id.contains("nebula") || id.contains("star")) {
            return 0xFFF4D35E;
        }
        if (id.contains("shadow") || id.contains("murk") || id.contains("spectre")) {
            return 0xFF8D6BFF;
        }
        if (id.contains("sea") || id.contains("shark") || id.contains("leviathan")) {
            return 0xFF2EC7D3;
        }
        if (id.contains("deviant") || id.contains("titan")) {
            return 0xFFFF4F8B;
        }
        return 0xFF6AF2FF;
    }

    private static boolean isContestContext(Player player) {
        ResourceLocation dimension = player.level().dimension().location();
        if (LostInfinity.MODID.equals(dimension.getNamespace())
                && ("grandmasteroutpost".equals(dimension.getPath()) || dimension.getPath().startsWith("cartographerrealm"))) {
            return true;
        }
        HitResult hit = Minecraft.getInstance().hitResult;
        if (hit instanceof EntityHitResult entityHit) {
            ResourceLocation entityId = entityHit.getEntity().getType().builtInRegistryHolder().key().location();
            return LostInfinity.MODID.equals(entityId.getNamespace())
                    && (entityId.getPath().contains("contest") || entityId.getPath().contains("operator") || entityId.getPath().contains("controller"));
        }
        return false;
    }

    private static String contestTitle(Player player) {
        ResourceLocation dimension = player.level().dimension().location();
        if (LostInfinity.MODID.equals(dimension.getNamespace()) && dimension.getPath().startsWith("cartographerrealm")) {
            return "Labyrinth";
        }
        return "Contest";
    }

    private static String contestPulse(int tickCount) {
        return switch ((tickCount / 20) % 4) {
            case 0 -> "READY";
            case 1 -> "TRACK";
            case 2 -> "SYNC";
            default -> "GO";
        };
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

    private record DimensionHud(String title, String baseSubtitle, int color) {
        private String subtitle(int tickCount) {
            return baseSubtitle + (tickCount / 20 % 2 == 0 ? "" : ".");
        }
    }
}
