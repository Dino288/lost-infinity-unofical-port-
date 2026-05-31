/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.renderer.BufferBuilder
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.entity.RenderLiving
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.client.renderer.vertex.DefaultVertexFormats
 *  net.minecraft.entity.Mob
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.util.ResourceLocation
 */
package xol.lostinfinity.mob.render.misc;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.mob.entity.misc.EntityTotemSplitter;
import xol.lostinfinity.mob.model.ModelTotem;

public class RenderTotemSplitter
extends RenderLiving<EntityTotemSplitter> {
    public static final ResourceLocation TEXTURES = new ResourceLocation("lostinfinity:textures/entity/totem/totem_splitter.png");
    public static final ResourceLocation TEXTURE_NICRONIUM_RING = new ResourceLocation("lostinfinity:textures/particles/nicronium_ring.png");

    public RenderTotemSplitter(RenderManager manager) {
        super(manager, (ModelBase)new ModelTotem(), 0.5f);
    }

    public void doRender(EntityTotemSplitter entity, double x, double y, double z, float entityYaw, float partialTicks) {
        super.func_76986_a((Mob)entity, x, y, z, entityYaw, partialTicks);
        double targetHeight = 1.0;
        this.func_110776_a(TEXTURE_NICRONIUM_RING);
        Tessellator tessellator = Tessellator.func_178181_a();
        BufferBuilder bufferbuilder = tessellator.func_178180_c();
        GlStateManager.func_179129_p();
        GlStateManager.func_179141_d();
        float growth = 0.5f;
        GlStateManager.func_179147_l();
        GlStateManager.func_179092_a((int)516, (float)0.2f);
        float a = 1.0f;
        growth = 0.1f + (float)(entity.field_70173_aa % 40) * 0.3f;
        a = 1.0f - (float)(entity.field_70173_aa % 40) * 0.022224f;
        if (a <= 0.0f) {
            a = 0.0f;
        }
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)a);
        bufferbuilder.func_181668_a(7, DefaultVertexFormats.field_181707_g);
        double xPos = x + 0.0;
        double yPos = y + 0.5;
        double zPos = z + 0.0;
        bufferbuilder.func_181662_b((double)(-0.5f * growth) + xPos, targetHeight + yPos, (double)(0.5f * growth) + zPos).func_187315_a(0.0, 1.0).func_181675_d();
        bufferbuilder.func_181662_b((double)(-0.5f * growth) + xPos, targetHeight + yPos, (double)(-0.5f * growth) + zPos).func_187315_a(0.0, 0.0).func_181675_d();
        bufferbuilder.func_181662_b((double)(0.5f * growth) + xPos, targetHeight + yPos, (double)(-0.5f * growth) + zPos).func_187315_a(1.0, 0.0).func_181675_d();
        bufferbuilder.func_181662_b((double)(0.5f * growth) + xPos, targetHeight + yPos, (double)(0.5f * growth) + zPos).func_187315_a(1.0, 1.0).func_181675_d();
        tessellator.func_78381_a();
        GlStateManager.func_179089_o();
        GlStateManager.func_179084_k();
    }

    protected ResourceLocation getEntityTexture(EntityTotemSplitter entity) {
        return TEXTURES;
    }

    protected void applyRotations(EntityTotemSplitter entityLiving, float p1, float rotationYaw, float partialTicks) {
        super.func_77043_a((LivingEntity)entityLiving, p1, rotationYaw, partialTicks);
    }
}

