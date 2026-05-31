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
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Rotations
 *  net.minecraft.util.math.Vec3
 */
package xol.lostinfinity.block.tileentity.render;

import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.BlockEntitySpecialRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.util.math.Rotations;
import net.minecraft.world.phys.Vec3;
import xol.lostinfinity.block.tileentity.BlockEntityTeslaTower;
import xol.lostinfinity.util.math.LMath;

public class RenderTeslaTower
extends BlockEntitySpecialRenderer<BlockEntityTeslaTower> {
    public static final ResourceLocation TEXTURE_LIGHTNING_BOLT_YELLOW = new ResourceLocation("lostinfinity:textures/particles/lightning_bolt.png");
    public static final ResourceLocation TEXTURE_LIGHTNING_BOLT_BRIGHT = new ResourceLocation("lostinfinity:textures/particles/lightning_bolt_bright.png");
    public static final ResourceLocation TEXTURE_LIGHTNING_BOLT_BLUE = new ResourceLocation("lostinfinity:textures/particles/lightning_bolt_blue.png");

    public void render(BlockEntityTeslaTower te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
        if (!te.isActive()) {
            return;
        }
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        this.enableMaxLighting();
        if (te.getTickExisted() % (te.getRandom1() + 1) == 0) {
            if (te.getRandom1() > 10) {
                GlStateManager.func_179112_b((int)770, (int)1);
            } else {
                GlStateManager.func_179084_k();
                return;
            }
        }
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        this.bindTextureForTE(te);
        Tessellator tessellator = Tessellator.func_178181_a();
        BufferBuilder bufferbuilder = tessellator.func_178180_c();
        GlStateManager.func_179094_E();
        GlStateManager.func_179137_b((double)(x + 0.5), (double)(y + 0.5), (double)(z + 0.5));
        for (BlockPos pos : te.getConnected()) {
            GlStateManager.func_179094_E();
            float offset = te.getTickExisted() % (te.getRandom1() + 1) == 0 ? te.getRandom3() - 0.5f : 0.0f;
            double targetX = pos.func_177958_n() - te.func_174877_v().func_177958_n();
            double targetY = pos.func_177956_o() - te.func_174877_v().func_177956_o();
            double targetZ = pos.func_177952_p() - te.func_174877_v().func_177952_p();
            Vec3 delta = new Vec3(targetX, targetY, targetZ);
            Rotations rotations = LMath.toPitchYaw(delta);
            GlStateManager.func_179114_b((float)rotations.func_179416_c(), (float)0.0f, (float)-1.0f, (float)0.0f);
            GlStateManager.func_179114_b((float)rotations.func_179415_b(), (float)1.0f, (float)0.0f, (float)0.0f);
            double length = LMath.fastLength(delta);
            int i = 0;
            while ((double)i < length - 1.0) {
                bufferbuilder.func_181668_a(7, DefaultVertexFormats.field_181707_g);
                bufferbuilder.func_181662_b(0.01, -0.5, (double)(offset + (float)i)).func_187315_a(1.0, 0.0).func_181675_d();
                bufferbuilder.func_181662_b(0.01, -0.5, (double)(offset + (float)i + 1.0f)).func_187315_a(0.0, 0.0).func_181675_d();
                bufferbuilder.func_181662_b(0.01, 0.5, (double)(offset + (float)i + 1.0f)).func_187315_a(0.0, 1.0).func_181675_d();
                bufferbuilder.func_181662_b(0.01, 0.5, (double)(offset + (float)i)).func_187315_a(1.0, 1.0).func_181675_d();
                tessellator.func_78381_a();
                ++i;
            }
            double fraction = length % 1.0;
            double last = length - fraction;
            bufferbuilder.func_181668_a(7, DefaultVertexFormats.field_181707_g);
            bufferbuilder.func_181662_b(0.01, -0.5, (double)offset + last).func_187315_a(fraction, 0.0).func_181675_d();
            bufferbuilder.func_181662_b(0.01, -0.5, (double)offset + last + fraction).func_187315_a(0.0, 0.0).func_181675_d();
            bufferbuilder.func_181662_b(0.01, 0.5, (double)offset + last + fraction).func_187315_a(0.0, 1.0).func_181675_d();
            bufferbuilder.func_181662_b(0.01, 0.5, (double)offset + last).func_187315_a(fraction, 1.0).func_181675_d();
            tessellator.func_78381_a();
            GlStateManager.func_179121_F();
        }
        GlStateManager.func_179121_F();
        GlStateManager.func_179084_k();
    }

    public boolean isGlobalRenderer(BlockEntityTeslaTower te) {
        return true;
    }

    private void bindTextureForTE(BlockEntityTeslaTower te) {
        int remainder = te.getTickExisted() % (te.getRandom2() + 1);
        switch (remainder) {
            case 0: {
                this.func_147499_a(TEXTURE_LIGHTNING_BOLT_BRIGHT);
                break;
            }
            case 1: {
                this.func_147499_a(TEXTURE_LIGHTNING_BOLT_BLUE);
                break;
            }
            default: {
                this.func_147499_a(TEXTURE_LIGHTNING_BOLT_YELLOW);
            }
        }
    }

    private void enableMaxLighting() {
        GlStateManager.func_179140_f();
        OpenGlHelper.func_77475_a((int)OpenGlHelper.field_77476_b, (float)240.0f, (float)240.0f);
    }
}

