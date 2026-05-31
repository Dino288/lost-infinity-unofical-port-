/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.client.renderer.BufferBuilder
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.vertex.DefaultVertexFormats
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.math.Mth
 *  net.minecraftforge.client.event.RenderGameOverlayEvent$ElementType
 *  net.minecraftforge.client.event.RenderGameOverlayEvent$Post
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package xol.lostinfinity.client.screen;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import xol.lostinfinity.init.PotionInit;

public class DistortionCover {
    Minecraft mc = Minecraft.func_71410_x();
    private float distortionAlpha = 0.0f;

    @SubscribeEvent
    public void onRender(RenderGameOverlayEvent.Post event) {
        if (event.getType() == RenderGameOverlayEvent.ElementType.HELMET) {
            this.onTickRender();
        }
    }

    private void onTickRender() {
        if (this.mc.field_71462_r == null) {
            if (this.mc.field_71439_g.func_70644_a(PotionInit.DISTORTION)) {
                GlStateManager.func_179147_l();
                GlStateManager.func_179112_b((int)770, (int)771);
                int level = this.mc.field_71439_g.func_70660_b(PotionInit.DISTORTION).func_76458_c();
                this.mc.func_110434_K().func_110577_a(this.getResourceFromLevel(level));
                ScaledResolution res = new ScaledResolution(this.mc);
                Tessellator tess = Tessellator.func_178181_a();
                BufferBuilder buff = tess.func_178180_c();
                int ticksExisted = this.mc.field_71439_g.field_70173_aa;
                int remainingDuration = this.mc.field_71439_g.func_70660_b(PotionInit.DISTORTION).func_76459_b();
                if ((float)remainingDuration * 0.05f <= this.distortionAlpha) {
                    this.distortionAlpha -= 0.05f;
                } else if (this.distortionAlpha < 0.95f) {
                    this.distortionAlpha += 0.05f;
                }
                GlStateManager.func_179123_a();
                GlStateManager.func_179131_c((float)1.0f, (float)(0.75f + 0.25f * Mth.func_76126_a((float)((float)ticksExisted * 0.1f))), (float)1.0f, (float)this.distortionAlpha);
                buff.func_181668_a(7, DefaultVertexFormats.field_181710_j);
                buff.func_181662_b(0.0, res.func_78324_d(), -90.0).func_187315_a(0.0, 1.0).func_181663_c(0.0f, 1.0f, 0.0f).func_181675_d();
                buff.func_181662_b(res.func_78327_c(), res.func_78324_d(), -90.0).func_187315_a(1.0, 1.0).func_181663_c(0.0f, 1.0f, 0.0f).func_181675_d();
                buff.func_181662_b(res.func_78327_c(), 0.0, -90.0).func_187315_a(1.0, 0.0).func_181663_c(0.0f, 1.0f, 0.0f).func_181675_d();
                buff.func_181662_b(0.0, 0.0, -90.0).func_187315_a(0.0, 0.0).func_181663_c(0.0f, 1.0f, 0.0f).func_181675_d();
                tess.func_78381_a();
                GlStateManager.func_179084_k();
                GlStateManager.func_179132_a((boolean)true);
                GlStateManager.func_179099_b();
            } else {
                this.distortionAlpha = 0.0f;
            }
        }
    }

    private ResourceLocation getResourceFromLevel(int i) {
        if (i == 0) {
            return new ResourceLocation("lostinfinity", "textures/gui/distortion/distortion_0.png");
        }
        return new ResourceLocation("lostinfinity", "textures/gui/distortion/distortion_1.png");
    }
}

