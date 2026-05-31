/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.entity.RenderLiving
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.util.ResourceLocation
 */
package xol.lostinfinity.mob.render.misc;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.mob.entity.misc.EntityStarfiend;
import xol.lostinfinity.mob.model.galaxy.ModelStarfiend;

public class RenderStarfiend
extends RenderLiving<EntityStarfiend> {
    public static final ResourceLocation TEXTURES = new ResourceLocation("lostinfinity:textures/entity/starfiend.png");

    public RenderStarfiend(RenderManager manager) {
        super(manager, (ModelBase)new ModelStarfiend(), 1.0f);
    }

    protected void preRenderCallback(EntityStarfiend entitylivingbaseIn, float partialTickTime) {
        float scale = entitylivingbaseIn.getPhysicalScale();
        GlStateManager.func_179152_a((float)scale, (float)scale, (float)scale);
    }

    protected void applyRotations(EntityStarfiend entityLiving, float p1, float rotationYaw, float partialTicks) {
        super.func_77043_a((LivingEntity)entityLiving, p1, rotationYaw, partialTicks);
    }

    protected ResourceLocation getEntityTexture(EntityStarfiend entity) {
        return TEXTURES;
    }
}

