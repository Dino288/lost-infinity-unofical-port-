/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.GuiIngame
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.client.renderer.GlStateManager
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
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import xol.lostinfinity.util.ConfigurationHandler;

public class HealthValueGUI {
    private int tick_count = 0;
    private int diffclr = 0;
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
            GlStateManager.func_179124_c((float)1.0f, (float)1.0f, (float)1.0f);
            GuiIngame gig = this.mc.field_71456_v;
            ScaledResolution scaledresolution = new ScaledResolution(this.mc);
            int i = scaledresolution.func_78326_a();
            int k = scaledresolution.func_78328_b();
            this.mc.func_110434_K().func_110577_a(new ResourceLocation("lostinfinity", "textures/gui/healthicon.png"));
            int max_hp = Math.round(this.mc.field_71439_g.func_110138_aP());
            int cur_hp = Math.round(this.mc.field_71439_g.func_110143_aJ());
            String maxstr = this.convert_health(max_hp);
            String curstr = this.convert_health(cur_hp);
            String healthtxt = curstr + "/" + maxstr;
            if (this.tick_count % 5 == 0) {
                ++this.diffclr;
                if (this.diffclr == healthtxt.length() * 4 + 4) {
                    this.diffclr = 0;
                }
            }
            String lenstr = healthtxt.replace(".", "");
            int width = lenstr.length() * 9;
            int x = (scaledresolution.func_78326_a() / 2 - 91) / 2 - width / 2 + ConfigurationHandler.health_x;
            int y = scaledresolution.func_78328_b() - 13 + ConfigurationHandler.health_y;
            int hsep = 0;
            for (int ind = 0; ind < healthtxt.length(); ++ind) {
                char c = healthtxt.charAt(ind);
                int sep = this.getFontSprFromCh(c);
                gig.func_73729_b(x + hsep, y, sep, Math.floorDiv(this.diffclr, 4) != ind ? 0 : 9 * (this.diffclr % 4), 9, 9);
                if (c == '.') {
                    hsep += 3;
                    continue;
                }
                hsep += 9;
            }
            gig.func_73729_b(x - 11, y, 0, 0, 9, 9);
        }
    }

    private String convert_health(int hNum) {
        String retstr;
        if (hNum > 1000) {
            float newVal = (float)Math.round((float)hNum / 100.0f) / 10.0f;
            retstr = String.valueOf(newVal) + "k";
        } else {
            retstr = Integer.toString(hNum);
        }
        return retstr;
    }

    private int getFontSprFromCh(char s) {
        if (s == '.' || s == 'k' || s == '/') {
            switch (s) {
                case '.': {
                    return 118;
                }
                case 'k': {
                    return 100;
                }
                case '/': {
                    return 109;
                }
            }
            return 100;
        }
        return 10 + Character.getNumericValue(s) * 9;
    }
}

