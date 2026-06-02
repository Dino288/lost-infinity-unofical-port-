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
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        renderBackground(graphics);
        super.render(graphics, mouseX, mouseY, partialTick);
        renderTooltip(graphics, mouseX, mouseY);
    }
}
