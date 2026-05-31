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
 */
package xol.lostinfinity.block.tileentity.render;

import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.BlockEntitySpecialRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.block.tileentity.BlockEntityCthulhuSpawner;

public class RenderCthulhuSpawner
extends BlockEntitySpecialRenderer<BlockEntityCthulhuSpawner> {
    private static final ResourceLocation TEXTURE = new ResourceLocation("lostinfinity:textures/particles/cthulhu/spawner_beam.png");

    public void render(BlockEntityCthulhuSpawner te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
        if (!te.isBurning()) {
            return;
        }
        GlStateManager.func_179094_E();
        GlStateManager.func_179129_p();
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GlStateManager.func_179137_b((double)(x + 0.5), (double)(y + 0.5), (double)(z + 0.5));
        this.enableMaxLighting();
        this.func_147499_a(TEXTURE);
        Tessellator tessellator = Tessellator.func_178181_a();
        BufferBuilder bufferbuilder = tessellator.func_178180_c();
        block6: for (int i = 1; i <= 30; ++i) {
            switch (te.getFacing()) {
                case NORTH: {
                    bufferbuilder.func_181668_a(7, DefaultVertexFormats.field_181707_g);
                    bufferbuilder.func_181662_b(0.0, -0.5, (double)(-(i - 1))).func_187315_a(1.0, 0.0).func_181675_d();
                    bufferbuilder.func_181662_b(0.0, -0.5, (double)(-i)).func_187315_a(0.0, 0.0).func_181675_d();
                    bufferbuilder.func_181662_b(0.0, 0.5, (double)(-i)).func_187315_a(0.0, 1.0).func_181675_d();
                    bufferbuilder.func_181662_b(0.0, 0.5, (double)(-(i - 1))).func_187315_a(1.0, 1.0).func_181675_d();
                    tessellator.func_78381_a();
                    continue block6;
                }
                case EAST: {
                    bufferbuilder.func_181668_a(7, DefaultVertexFormats.field_181707_g);
                    bufferbuilder.func_181662_b((double)(i - 1), -0.5, 0.0).func_187315_a(1.0, 0.0).func_181675_d();
                    bufferbuilder.func_181662_b((double)i, -0.5, 0.0).func_187315_a(0.0, 0.0).func_181675_d();
                    bufferbuilder.func_181662_b((double)i, 0.5, 0.0).func_187315_a(0.0, 1.0).func_181675_d();
                    bufferbuilder.func_181662_b((double)(i - 1), 0.5, 0.0).func_187315_a(1.0, 1.0).func_181675_d();
                    tessellator.func_78381_a();
                    continue block6;
                }
                case SOUTH: {
                    bufferbuilder.func_181668_a(7, DefaultVertexFormats.field_181707_g);
                    bufferbuilder.func_181662_b(0.0, -0.5, (double)(i - 1)).func_187315_a(1.0, 0.0).func_181675_d();
                    bufferbuilder.func_181662_b(0.0, -0.5, (double)i).func_187315_a(0.0, 0.0).func_181675_d();
                    bufferbuilder.func_181662_b(0.0, 0.5, (double)i).func_187315_a(0.0, 1.0).func_181675_d();
                    bufferbuilder.func_181662_b(0.0, 0.5, (double)(i - 1)).func_187315_a(1.0, 1.0).func_181675_d();
                    tessellator.func_78381_a();
                    continue block6;
                }
                case WEST: {
                    bufferbuilder.func_181668_a(7, DefaultVertexFormats.field_181707_g);
                    bufferbuilder.func_181662_b((double)(-(i - 1)), -0.5, 0.0).func_187315_a(1.0, 0.0).func_181675_d();
                    bufferbuilder.func_181662_b((double)(-i), -0.5, 0.0).func_187315_a(0.0, 0.0).func_181675_d();
                    bufferbuilder.func_181662_b((double)(-i), 0.5, 0.0).func_187315_a(0.0, 1.0).func_181675_d();
                    bufferbuilder.func_181662_b((double)(-(i - 1)), 0.5, 0.0).func_187315_a(1.0, 1.0).func_181675_d();
                    tessellator.func_78381_a();
                }
            }
        }
        GlStateManager.func_179121_F();
        GlStateManager.func_179145_e();
        GlStateManager.func_179084_k();
        GlStateManager.func_179089_o();
    }

    public boolean isGlobalRenderer(BlockEntityCthulhuSpawner te) {
        return true;
    }

    private void enableMaxLighting() {
        GlStateManager.func_179140_f();
        OpenGlHelper.func_77475_a((int)OpenGlHelper.field_77476_b, (float)240.0f, (float)240.0f);
    }
}

