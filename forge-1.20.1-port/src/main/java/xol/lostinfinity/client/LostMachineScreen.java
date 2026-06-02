package xol.lostinfinity.client;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import xol.lostinfinity.menu.LostMachineMenu;

public class LostMachineScreen extends AbstractContainerScreen<LostMachineMenu> {
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
        graphics.fill(left, top, left + imageWidth, top + imageHeight, 0xFF2D3138);
        graphics.fill(left + 4, top + 4, left + imageWidth - 4, top + imageHeight - 4, 0xFF3A404A);
        graphics.fill(left + 59, top + 14, left + 117, top + 72, 0xFF1D2026);
        graphics.fill(left + 7, top + 81, left + 169, top + 160, 0xFF242931);
        int progressWidth = (int) (52.0F * menu.progress() / menu.processTime());
        int energyHeight = (int) (48.0F * Math.min(1000, menu.energy()) / 1000.0F);
        graphics.fill(left + 62, top + 74, left + 114, top + 78, 0xFF111318);
        graphics.fill(left + 62, top + 74, left + 62 + progressWidth, top + 78, menu.active() ? 0xFF66D9EF : 0xFF68707D);
        graphics.fill(left + 122, top + 20, left + 128, top + 68, 0xFF111318);
        graphics.fill(left + 122, top + 68 - energyHeight, left + 128, top + 68, 0xFFFFD166);
        graphics.drawString(font, "E " + menu.energy(), left + 132, top + 20, 0xFFE8EDF2, false);
        graphics.drawString(font, "P " + menu.puzzleState(), left + 132, top + 32, 0xFFE8EDF2, false);
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        renderBackground(graphics);
        super.render(graphics, mouseX, mouseY, partialTick);
        renderTooltip(graphics, mouseX, mouseY);
    }
}
