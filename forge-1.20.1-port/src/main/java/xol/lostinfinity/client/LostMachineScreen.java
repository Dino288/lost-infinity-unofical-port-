package xol.lostinfinity.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import xol.lostinfinity.LostInfinity;
import xol.lostinfinity.menu.LostMachineMenu;

public class LostMachineScreen extends AbstractContainerScreen<LostMachineMenu> {
    private static final ResourceLocation FALLBACK = gui("grinder");

    public LostMachineScreen(LostMachineMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
        imageWidth = 176;
        imageHeight = 166;
        inventoryLabelY = 72;
    }

    @Override
    protected void renderBg(GuiGraphics graphics, float partialTick, int mouseX, int mouseY) {
        int left = leftPos;
        int top = topPos;
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        graphics.blit(textureFor(menu.machineId()), left, top, 0, 0, imageWidth, imageHeight, 256, 256);
        int progressWidth = (int) (52.0F * menu.progress() / menu.processTime());
        int energyHeight = (int) (48.0F * Math.min(1000, menu.energy()) / 1000.0F);
        graphics.fill(left + 73, top + 34, left + 125, top + 39, 0xAA111318);
        graphics.fill(left + 73, top + 34, left + 73 + progressWidth, top + 39, menu.active() ? 0xFF6AF2FF : 0xFF69717C);
        graphics.fill(left + 151, top + 17, left + 158, top + 65, 0xAA111318);
        graphics.fill(left + 151, top + 65 - energyHeight, left + 158, top + 65, 0xFFFFD166);
        graphics.drawString(font, menu.energy() + " EU", left + 117, top + 70, 0xFFE8EDF2, false);
        if (menu.puzzleState() > 0 || menu.machineId().contains("game") || menu.machineId().contains("dial")) {
            graphics.drawString(font, "S " + menu.puzzleState(), left + 117, top + 80, 0xFFE8EDF2, false);
        }
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        renderBackground(graphics);
        super.render(graphics, mouseX, mouseY, partialTick);
        renderTooltip(graphics, mouseX, mouseY);
    }

    private static ResourceLocation textureFor(String machineId) {
        String path = machineId.toLowerCase(java.util.Locale.ROOT);
        if (path.contains("chem")) return gui("chemistry_table");
        if (path.contains("compression")) return gui("compression_table");
        if (path.contains("combustion") || path.contains("engine")) return gui("combustion_engine");
        if (path.contains("cthulhu")) return gui("cthulhu_spawner");
        if (path.contains("fabrication")) return gui("fabrication_station");
        if (path.contains("fossil")) return gui("fossil_combiner");
        if (path.contains("fusion") || path.contains("collider")) return gui("fusion_table");
        if (path.contains("gearbox")) return gui("gearbox");
        if (path.contains("grinder") || path.contains("crusher")) return gui("grinder");
        if (path.contains("charger") || path.contains("charge")) return gui("pick_charging_table");
        if (path.contains("modulator")) return gui("modulator");
        if (path.contains("module")) return gui("module_creator");
        if (path.contains("beacon")) return gui("nebulous_beacon");
        if (path.contains("infuser")) return gui("nicronium_infuser");
        if (path.contains("rainfall")) return gui("rainfall_generator");
        if (path.contains("sap")) return gui("sap_evaporator");
        if (path.contains("shipment")) return gui("shipment_filler");
        if (path.contains("welding")) return gui("welding_chamber");
        return FALLBACK;
    }

    private static ResourceLocation gui(String name) {
        return new ResourceLocation(LostInfinity.MODID, "textures/gui/" + name + ".png");
    }
}
