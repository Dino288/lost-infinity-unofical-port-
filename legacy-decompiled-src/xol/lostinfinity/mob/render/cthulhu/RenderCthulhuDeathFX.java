/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.renderer.BufferBuilder
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.entity.Render
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.client.renderer.vertex.DefaultVertexFormats
 *  net.minecraft.util.ResourceLocation
 */
package xol.lostinfinity.mob.render.cthulhu;

import javax.annotation.Nullable;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.mob.entity.cthulhu.EntityCthulhuDeathFX;

public class RenderCthulhuDeathFX
extends Render<EntityCthulhuDeathFX> {
    private static final ResourceLocation TEXTURE_CORE = new ResourceLocation("lostinfinity", "textures/particles/cthulhu/death_explosion.png");

    public RenderCthulhuDeathFX(RenderManager renderManager) {
        super(renderManager);
    }

    @Nullable
    protected ResourceLocation getEntityTexture(EntityCthulhuDeathFX entity) {
        return null;
    }

    public void doRender(EntityCthulhuDeathFX entity, double x, double y, double z, float entityYaw, float partialTicks) {
        Tessellator tessellator = Tessellator.func_178181_a();
        BufferBuilder bufferbuilder = tessellator.func_178180_c();
        GlStateManager.func_179129_p();
        GlStateManager.func_179141_d();
        GlStateManager.func_179140_f();
        GlStateManager.func_179147_l();
        GlStateManager.func_179092_a((int)516, (float)0.15f);
        GlStateManager.func_179112_b((int)770, (int)1);
        GlStateManager.func_179094_E();
        GlStateManager.func_179137_b((double)x, (double)y, (double)z);
        this.func_110776_a(TEXTURE_CORE);
        float coreSize = Math.min(((float)entity.field_70173_aa + partialTicks) / 40.0f, 1.0f) * 360.0f;
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)(entity.field_70173_aa < 320 ? 1.0f : 1.0f - ((float)entity.field_70173_aa + partialTicks - 320.0f) / 20.0f));
        if (coreSize > 0.0f) {
            bufferbuilder.func_181668_a(7, DefaultVertexFormats.field_181707_g);
            bufferbuilder.func_181662_b((double)(-coreSize), 0.0, (double)coreSize).func_187315_a(0.0, 1.0).func_181675_d();
            bufferbuilder.func_181662_b((double)(-coreSize), 0.0, (double)(-coreSize)).func_187315_a(0.0, 0.0).func_181675_d();
            bufferbuilder.func_181662_b((double)coreSize, 0.0, (double)(-coreSize)).func_187315_a(1.0, 0.0).func_181675_d();
            bufferbuilder.func_181662_b((double)coreSize, 0.0, (double)coreSize).func_187315_a(1.0, 1.0).func_181675_d();
            bufferbuilder.func_181662_b((double)(-coreSize), (double)coreSize, 0.0).func_187315_a(0.0, 1.0).func_181675_d();
            bufferbuilder.func_181662_b((double)(-coreSize), (double)(-coreSize), 0.0).func_187315_a(0.0, 0.0).func_181675_d();
            bufferbuilder.func_181662_b((double)coreSize, (double)(-coreSize), 0.0).func_187315_a(1.0, 0.0).func_181675_d();
            bufferbuilder.func_181662_b((double)coreSize, (double)coreSize, 0.0).func_187315_a(1.0, 1.0).func_181675_d();
            bufferbuilder.func_181662_b(0.0, (double)(-coreSize), (double)coreSize).func_187315_a(0.0, 1.0).func_181675_d();
            bufferbuilder.func_181662_b(0.0, (double)(-coreSize), (double)(-coreSize)).func_187315_a(0.0, 0.0).func_181675_d();
            bufferbuilder.func_181662_b(0.0, (double)coreSize, (double)(-coreSize)).func_187315_a(1.0, 0.0).func_181675_d();
            bufferbuilder.func_181662_b(0.0, (double)coreSize, (double)coreSize).func_187315_a(1.0, 1.0).func_181675_d();
            tessellator.func_78381_a();
        }
        GlStateManager.func_179121_F();
        GlStateManager.func_179118_c();
        GlStateManager.func_179145_e();
        GlStateManager.func_179089_o();
        GlStateManager.func_179084_k();
    }
}

