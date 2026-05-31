/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.GuiIngame
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.ResourceLocation
 *  net.minecraftforge.client.event.RenderGameOverlayEvent$ElementType
 *  net.minecraftforge.client.event.RenderGameOverlayEvent$Post
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package xol.lostinfinity.client.screen;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import xol.lostinfinity.mob.entity.cthulhu.EntityCthulhu;

public class CthulhuBossBar {
    private int tick_count = 0;
    private int ticks = 0;
    private static final int totalNameWidth = 114;
    private static final int animationTime = 300;
    Minecraft mc = Minecraft.func_71410_x();

    @SubscribeEvent
    public void onRender(RenderGameOverlayEvent.Post event) {
        if (event.getType() == RenderGameOverlayEvent.ElementType.ALL) {
            this.onTickRender();
            ++this.tick_count;
            if (this.tick_count == 100) {
                this.tick_count = 0;
            }
        }
    }

    private void onTickRender() {
        if (this.mc.field_71462_r == null) {
            ++this.ticks;
            EntityCthulhu cthulhu = null;
            for (Entity entity : this.mc.field_71441_e.field_72996_f) {
                if (!(entity instanceof EntityCthulhu)) continue;
                cthulhu = (EntityCthulhu)entity;
                break;
            }
            if (cthulhu == null) {
                return;
            }
            GlStateManager.func_179124_c((float)1.0f, (float)1.0f, (float)1.0f);
            GuiIngame gig = this.mc.field_71456_v;
            ScaledResolution scaledresolution = new ScaledResolution(this.mc);
            this.mc.func_110434_K().func_110577_a(new ResourceLocation("lostinfinity", "textures/gui/boss_hp_bar.png"));
            int max = cthulhu.numberOfLives();
            int cur = cthulhu.remainingLives();
            int parts = (int)((double)(cur * 160) / (double)max);
            int x = scaledresolution.func_78326_a() / 2 - 84;
            int y = (int)((double)scaledresolution.func_78328_b() / 50.0);
            gig.func_73729_b(x, y, 0, 0, 167, 25);
            gig.func_73729_b(x + 4, y + 16, 0, 28, parts, 5);
            int width = 114;
            int offsetX = 0;
            int mod = this.ticks % 300;
            if (mod < 150) {
                width = (int)(114.0 * ((double)(mod * 2) / 300.0));
            } else {
                int k = mod - 150;
                width = (int)(114.0 * ((double)(300 - k * 2) / 300.0));
                offsetX = (int)(114.0 * ((double)(k * 2) / 300.0));
            }
            gig.func_73729_b(x + 27 + offsetX, y + 2, offsetX, 36, width, 9);
        }
    }
}

