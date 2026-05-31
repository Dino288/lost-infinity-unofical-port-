/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.BufferBuilder
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.OpenGlHelper
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.tileentity.BlockEntitySpecialRenderer
 *  net.minecraft.client.renderer.vertex.DefaultVertexFormats
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.math.Mth
 */
package xol.lostinfinity.block.tileentity.render;

import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.BlockEntitySpecialRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import xol.lostinfinity.block.tileentity.BlockEntityEternalBeacon;
import xol.lostinfinity.util.math.LMath;

public class RenderEternalBeacon
extends BlockEntitySpecialRenderer<BlockEntityEternalBeacon> {
    private static final ResourceLocation TEXTURE = new ResourceLocation("lostinfinity:textures/particles/eternal_beacon_beam.png");

    public void render(BlockEntityEternalBeacon te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
        if (te.getTickRemaining() <= 0) {
            return;
        }
        GlStateManager.func_179129_p();
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)1);
        this.enableMaxLighting();
        this.func_147499_a(TEXTURE);
        Tessellator tessellator = Tessellator.func_178181_a();
        BufferBuilder bufferbuilder = tessellator.func_178180_c();
        GlStateManager.func_179094_E();
        GlStateManager.func_179137_b((double)(x + 0.5), (double)y, (double)(z + 0.5));
        float seg = 24.0f;
        float offset = ((float)(te.getActiveTick() - 1) + partialTicks) * 0.25f * ((float)Math.PI / 180);
        float delta = 360.0f / seg * ((float)Math.PI / 180);
        float radius = te.getRadius();
        double height = -1.0;
        int i = 0;
        while ((float)i < seg) {
            double x1 = Mth.func_76126_a((float)(offset + (float)i * delta)) * radius;
            double z1 = Mth.func_76134_b((float)(offset + (float)i * delta)) * radius;
            double x2 = Mth.func_76126_a((float)(offset + (float)(i + 1) * delta)) * radius;
            double z2 = Mth.func_76134_b((float)(offset + (float)(i + 1) * delta)) * radius;
            if (height < 0.0) {
                height = LMath.fastLength(x2 - x1, 0.0, z2 - z1);
            }
            float j = -16.0f;
            while (j < 256.0f) {
                float r = Mth.func_76131_a((float)((256.0f - j) / 256.0f), (float)0.0f, (float)1.0f);
                GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)r);
                bufferbuilder.func_181668_a(7, DefaultVertexFormats.field_181707_g);
                bufferbuilder.func_181662_b(x2, (double)j, z2).func_187315_a(1.0, 0.0).func_181675_d();
                bufferbuilder.func_181662_b(x1, (double)j, z1).func_187315_a(0.0, 0.0).func_181675_d();
                bufferbuilder.func_181662_b(x1, (double)j + height, z1).func_187315_a(0.0, 1.0).func_181675_d();
                bufferbuilder.func_181662_b(x2, (double)j + height, z2).func_187315_a(1.0, 1.0).func_181675_d();
                tessellator.func_78381_a();
                j = (float)((double)j + height);
            }
            ++i;
        }
        GlStateManager.func_179121_F();
        GlStateManager.func_179089_o();
        GlStateManager.func_179084_k();
    }

    public boolean isGlobalRenderer(BlockEntityEternalBeacon te) {
        return true;
    }

    private void enableMaxLighting() {
        GlStateManager.func_179140_f();
        OpenGlHelper.func_77475_a((int)OpenGlHelper.field_77476_b, (float)240.0f, (float)240.0f);
    }
}

