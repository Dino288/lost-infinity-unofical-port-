/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.renderer.BufferBuilder
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.OpenGlHelper
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.entity.RenderLiving
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.client.renderer.vertex.DefaultVertexFormats
 *  net.minecraft.entity.Mob
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.math.Mth
 */
package xol.lostinfinity.mob.render.cthulhu;

import javax.annotation.Nullable;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.world.entity.Mob;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import xol.lostinfinity.mob.entity.cthulhu.EntityCthulhu;
import xol.lostinfinity.mob.model.cthulhu.ModelCthulhu;
import xol.lostinfinity.util.math.LMath;

public class RenderCthulhu
extends RenderLiving<EntityCthulhu> {
    private static final ResourceLocation TEXTURE = new ResourceLocation("lostinfinity", "textures/entity/cthulhu/cthulhu.png");
    private static final ResourceLocation PORTAL = new ResourceLocation("lostinfinity", "textures/entity/cthulhu/cthulhu_portal.png");
    private static final ResourceLocation BARRIER_1 = new ResourceLocation("lostinfinity", "textures/particles/cthulhu/barrier_1.png");
    private static final ResourceLocation BARRIER_2 = new ResourceLocation("lostinfinity", "textures/particles/cthulhu/barrier_2.png");

    public RenderCthulhu(RenderManager rendermanagerIn) {
        super(rendermanagerIn, (ModelBase)new ModelCthulhu(), 0.0f);
    }

    @Nullable
    protected ResourceLocation getEntityTexture(EntityCthulhu entity) {
        return TEXTURE;
    }

    public void doRender(EntityCthulhu entity, double x, double y, double z, float entityYaw, float partialTicks) {
        super.func_76986_a((Mob)entity, x, y, z, entityYaw, partialTicks);
        GlStateManager.func_179129_p();
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        this.enableMaxLighting();
        Tessellator tessellator = Tessellator.func_178181_a();
        BufferBuilder bufferbuilder = tessellator.func_178180_c();
        GlStateManager.func_179094_E();
        GlStateManager.func_179137_b((double)x, (double)y, (double)z);
        GlStateManager.func_179094_E();
        GlStateManager.func_179114_b((float)(((float)entity.field_70173_aa + partialTicks) * 3.0f), (float)0.0f, (float)1.0f, (float)0.0f);
        this.func_110776_a(PORTAL);
        float ratio = entity.isActivated() ? 1.0f : ((float)entity.field_70173_aa + partialTicks) / 280.0f;
        bufferbuilder.func_181668_a(7, DefaultVertexFormats.field_181707_g);
        float portalRadius = 30.0f;
        bufferbuilder.func_181662_b((double)(portalRadius * ratio), 0.1, (double)(-portalRadius * ratio)).func_187315_a(1.0, 0.0).func_181675_d();
        bufferbuilder.func_181662_b((double)(-portalRadius * ratio), 0.1, (double)(-portalRadius * ratio)).func_187315_a(0.0, 0.0).func_181675_d();
        bufferbuilder.func_181662_b((double)(-portalRadius * ratio), 0.1, (double)(portalRadius * ratio)).func_187315_a(0.0, 1.0).func_181675_d();
        bufferbuilder.func_181662_b((double)(portalRadius * ratio), 0.1, (double)(portalRadius * ratio)).func_187315_a(1.0, 1.0).func_181675_d();
        tessellator.func_78381_a();
        GlStateManager.func_179121_F();
        if (entity.isBarrierActive()) {
            GlStateManager.func_179112_b((int)770, (int)1);
            this.func_110776_a(entity.getPhase() == 2 ? BARRIER_1 : BARRIER_2);
            float seg = 24.0f;
            float offset = ((float)entity.field_70173_aa + partialTicks) * 0.25f * ((float)Math.PI / 180);
            float delta = 360.0f / seg * ((float)Math.PI / 180);
            float radius = 48.0f;
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
        }
        GlStateManager.func_179121_F();
        GlStateManager.func_179089_o();
        GlStateManager.func_179084_k();
        GlStateManager.func_179145_e();
    }

    protected void preRenderCallback(EntityCthulhu entitylivingbaseIn, float partialTickTime) {
        GlStateManager.func_179152_a((float)4.0f, (float)4.0f, (float)4.0f);
    }

    private void enableMaxLighting() {
        GlStateManager.func_179140_f();
        OpenGlHelper.func_77475_a((int)OpenGlHelper.field_77476_b, (float)240.0f, (float)240.0f);
    }
}

