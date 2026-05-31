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
 *  net.minecraft.entity.player.Player
 *  net.minecraft.util.ResourceLocation
 */
package xol.lostinfinity.mob.render.cthulhu;

import javax.annotation.Nullable;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.mob.entity.cthulhu.EntityCthulhuSpear;

public class RenderCthulhuSpear
extends Render<EntityCthulhuSpear> {
    private static final ResourceLocation TEXTURE = new ResourceLocation("lostinfinity", "textures/projectiles/cthulhu/beam.png");

    public RenderCthulhuSpear(RenderManager renderManager) {
        super(renderManager);
    }

    public void doRender(EntityCthulhuSpear entity, double x, double y, double z, float entityYaw, float partialTicks) {
        GlStateManager.func_179094_E();
        GlStateManager.func_179129_p();
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        this.enableMaxLighting();
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GlStateManager.func_179137_b((double)x, (double)(y + (double)entity.func_70047_e()), (double)z);
        double dist = entity.getLaserDistance();
        Player player = entity.getOwner();
        if (player != null) {
            GlStateManager.func_179114_b((float)player.field_70177_z, (float)0.0f, (float)-1.0f, (float)0.0f);
            GlStateManager.func_179114_b((float)player.field_70125_A, (float)1.0f, (float)0.0f, (float)0.0f);
        }
        this.func_110776_a(TEXTURE);
        Tessellator tessellator = Tessellator.func_178181_a();
        BufferBuilder bufferbuilder = tessellator.func_178180_c();
        bufferbuilder.func_181668_a(7, DefaultVertexFormats.field_181707_g);
        bufferbuilder.func_181662_b(0.0, -0.5, 0.0).func_187315_a(1.0, 0.0).func_181675_d();
        bufferbuilder.func_181662_b(0.0, -0.5, dist).func_187315_a(0.0, 0.0).func_181675_d();
        bufferbuilder.func_181662_b(0.0, 0.5, dist).func_187315_a(0.0, 1.0).func_181675_d();
        bufferbuilder.func_181662_b(0.0, 0.5, 0.0).func_187315_a(1.0, 1.0).func_181675_d();
        bufferbuilder.func_181662_b(-0.5, 0.0, 0.0).func_187315_a(1.0, 0.0).func_181675_d();
        bufferbuilder.func_181662_b(-0.5, 0.0, dist).func_187315_a(0.0, 0.0).func_181675_d();
        bufferbuilder.func_181662_b(0.5, 0.0, dist).func_187315_a(0.0, 1.0).func_181675_d();
        bufferbuilder.func_181662_b(0.5, 0.0, 0.0).func_187315_a(1.0, 1.0).func_181675_d();
        tessellator.func_78381_a();
        GlStateManager.func_179121_F();
        GlStateManager.func_179089_o();
        GlStateManager.func_179084_k();
        GlStateManager.func_179145_e();
    }

    @Nullable
    protected ResourceLocation getEntityTexture(EntityCthulhuSpear entity) {
        return TEXTURE;
    }

    private void enableMaxLighting() {
        GlStateManager.func_179140_f();
        OpenGlHelper.func_77475_a((int)OpenGlHelper.field_77476_b, (float)240.0f, (float)240.0f);
    }
}

