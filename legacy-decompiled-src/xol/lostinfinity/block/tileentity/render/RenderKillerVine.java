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
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.math.Mth
 *  net.minecraft.util.math.Vec3
 */
package xol.lostinfinity.block.tileentity.render;

import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.BlockEntitySpecialRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import xol.lostinfinity.block.tileentity.BlockEntityKillerVine;

public class RenderKillerVine
extends BlockEntitySpecialRenderer<BlockEntityKillerVine> {
    public static final ResourceLocation TEXTURE_VINE = new ResourceLocation("lostinfinity:textures/particles/killer_vine.png");

    public void render(BlockEntityKillerVine te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
        if (!te.isKiller()) {
            return;
        }
        GlStateManager.func_179084_k();
        GlStateManager.func_179141_d();
        GlStateManager.func_179129_p();
        this.enableMaxLighting();
        this.func_147499_a(TEXTURE_VINE);
        Tessellator tessellator = Tessellator.func_178181_a();
        BufferBuilder bufferbuilder = tessellator.func_178180_c();
        Object playerPos = null;
        for (BlockEntityKillerVine.VineNode node : te.getNodes()) {
            LivingEntity entity = node.getEntity();
            Vec3 pos = new Vec3(Mth.func_151238_b((double)entity.field_70169_q, (double)entity.field_70165_t, (double)partialTicks), Mth.func_151238_b((double)entity.field_70167_r, (double)entity.field_70163_u, (double)partialTicks), Mth.func_151238_b((double)entity.field_70166_s, (double)entity.field_70161_v, (double)partialTicks)).func_72441_c(-0.5, (double)(entity.field_70131_O / 2.0f) - 0.5, -0.5);
            bufferbuilder.func_181668_a(7, DefaultVertexFormats.field_181707_g);
            Vec3 tePos = new Vec3((double)te.func_174877_v().func_177958_n(), (double)te.func_174877_v().func_177956_o(), (double)te.func_174877_v().func_177952_p());
            double dist = pos.func_72438_d(tePos);
            Vec3 dir = pos.func_178788_d(tePos);
            dir = dir.func_72432_b();
            float segmentHeight = 0.5f;
            float segmentLength = 1.0f;
            for (int i = 0; i < (int)Math.floor(dist * Math.min((double)node.getGrowth() / 20.0, 1.0) / (double)segmentLength); ++i) {
                double xPos = x + 0.5 + dir.field_72450_a * (double)i * (double)segmentLength;
                double yPos = y + dir.field_72448_b * (double)i * (double)segmentLength + 0.5;
                double zPos = z + 0.5 + dir.field_72449_c * (double)i * (double)segmentLength;
                bufferbuilder.func_181662_b(xPos, yPos + (double)segmentHeight, zPos).func_187315_a(0.0, 1.0).func_181675_d();
                bufferbuilder.func_181662_b(xPos, yPos, zPos).func_187315_a(0.0, 0.0).func_181675_d();
                bufferbuilder.func_181662_b(xPos + (double)segmentLength * dir.field_72450_a, yPos + (double)segmentLength * dir.field_72448_b, zPos + (double)segmentLength * dir.field_72449_c).func_187315_a(1.0, 0.0).func_181675_d();
                bufferbuilder.func_181662_b(xPos + (double)segmentLength * dir.field_72450_a, yPos + (double)segmentHeight + (double)segmentLength * dir.field_72448_b, zPos + (double)segmentLength * dir.field_72449_c).func_187315_a(1.0, 1.0).func_181675_d();
            }
            tessellator.func_78381_a();
        }
        GlStateManager.func_179147_l();
        GlStateManager.func_179118_c();
        GlStateManager.func_179089_o();
    }

    public boolean isGlobalRenderer(BlockEntityKillerVine te) {
        return true;
    }

    private void enableMaxLighting() {
        GlStateManager.func_179140_f();
        OpenGlHelper.func_77475_a((int)OpenGlHelper.field_77476_b, (float)240.0f, (float)240.0f);
    }
}

