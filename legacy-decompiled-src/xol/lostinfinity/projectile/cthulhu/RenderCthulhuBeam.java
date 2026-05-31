/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.renderer.BufferBuilder
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.OpenGlHelper
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.entity.Render
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.client.renderer.vertex.DefaultVertexFormats
 *  net.minecraft.util.ResourceLocation
 */
package xol.lostinfinity.projectile.cthulhu;

import javax.annotation.Nullable;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.projectile.cthulhu.EntityCthulhuBeam;

public class RenderCthulhuBeam
extends Render<EntityCthulhuBeam> {
    private static final ResourceLocation TEXTURE_BEAM = new ResourceLocation("lostinfinity", "textures/projectiles/cthulhu/beam.png");
    private static final ResourceLocation TEXTURE_PORTAL = new ResourceLocation("lostinfinity", "textures/projectiles/cthulhu/portal.png");

    public RenderCthulhuBeam(RenderManager renderManager) {
        super(renderManager);
    }

    public void doRender(EntityCthulhuBeam entity, double x, double y, double z, float yaw, float partialTicks) {
        float size;
        GlStateManager.func_179129_p();
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        this.enableMaxLighting();
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        Tessellator tessellator = Tessellator.func_178181_a();
        BufferBuilder bufferbuilder = tessellator.func_178180_c();
        GlStateManager.func_179094_E();
        GlStateManager.func_179137_b((double)x, (double)y, (double)z);
        GlStateManager.func_179114_b((float)entity.yaw, (float)0.0f, (float)-1.0f, (float)0.0f);
        GlStateManager.func_179114_b((float)entity.pitch, (float)1.0f, (float)0.0f, (float)0.0f);
        if (entity.field_70173_aa >= 15 && entity.field_70173_aa < 30) {
            size = 1.0f - ((float)entity.field_70173_aa + partialTicks - 15.0f) / 15.0f;
            this.func_110776_a(TEXTURE_BEAM);
            bufferbuilder.func_181668_a(7, DefaultVertexFormats.field_181707_g);
            bufferbuilder.func_181662_b(0.0, -0.5 * (double)size, 0.0).func_187315_a(1.0, 0.0).func_181675_d();
            bufferbuilder.func_181662_b(0.0, -0.5 * (double)size, 128.0).func_187315_a(0.0, 0.0).func_181675_d();
            bufferbuilder.func_181662_b(0.0, 0.5 * (double)size, 128.0).func_187315_a(0.0, 1.0).func_181675_d();
            bufferbuilder.func_181662_b(0.0, 0.5 * (double)size, 0.0).func_187315_a(1.0, 1.0).func_181675_d();
            bufferbuilder.func_181662_b(-0.5 * (double)size, 0.0, 0.0).func_187315_a(1.0, 0.0).func_181675_d();
            bufferbuilder.func_181662_b(-0.5 * (double)size, 0.0, 128.0).func_187315_a(0.0, 0.0).func_181675_d();
            bufferbuilder.func_181662_b(0.5 * (double)size, 0.0, 128.0).func_187315_a(0.0, 1.0).func_181675_d();
            bufferbuilder.func_181662_b(0.5 * (double)size, 0.0, 0.0).func_187315_a(1.0, 1.0).func_181675_d();
            tessellator.func_78381_a();
        }
        GlStateManager.func_179114_b((float)(((float)entity.field_70173_aa + partialTicks) * 3.0f), (float)0.0f, (float)0.0f, (float)1.0f);
        this.func_110776_a(TEXTURE_PORTAL);
        bufferbuilder.func_181668_a(7, DefaultVertexFormats.field_181707_g);
        size = entity.field_70173_aa < 15 ? ((float)entity.field_70173_aa + partialTicks) / 15.0f : (entity.field_70173_aa >= 30 ? 1.0f - ((float)entity.field_70173_aa + partialTicks - 30.0f) / 15.0f : 1.0f);
        bufferbuilder.func_181662_b(1.5 * (double)size, -1.5 * (double)size, 0.0).func_187315_a(1.0, 0.0).func_181675_d();
        bufferbuilder.func_181662_b(-1.5 * (double)size, -1.5 * (double)size, 0.0).func_187315_a(0.0, 0.0).func_181675_d();
        bufferbuilder.func_181662_b(-1.5 * (double)size, 1.5 * (double)size, 0.0).func_187315_a(0.0, 1.0).func_181675_d();
        bufferbuilder.func_181662_b(1.5 * (double)size, 1.5 * (double)size, 0.0).func_187315_a(1.0, 1.0).func_181675_d();
        tessellator.func_78381_a();
        GlStateManager.func_179121_F();
        GlStateManager.func_179089_o();
        GlStateManager.func_179084_k();
        GlStateManager.func_179145_e();
    }

    @Nullable
    protected ResourceLocation getEntityTexture(EntityCthulhuBeam entity) {
        return TEXTURE_BEAM;
    }

    private void enableMaxLighting() {
        GlStateManager.func_179140_f();
        OpenGlHelper.func_77475_a((int)OpenGlHelper.field_77476_b, (float)240.0f, (float)240.0f);
    }
}

