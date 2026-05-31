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
package xol.lostinfinity.mob.render.starforge;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.mob.entity.starforge.EntityClusterweed;
import xol.lostinfinity.mob.model.starforge.ModelClusterweed;

public class RenderClusterweed
extends RenderLiving<EntityClusterweed> {
    public static final ResourceLocation TEXTURES = new ResourceLocation("lostinfinity:textures/entity/starforge/clusterweed.png");

    public RenderClusterweed(RenderManager manager) {
        super(manager, (ModelBase)new ModelClusterweed(), 0.5f);
    }

    protected void preRenderCallback(EntityClusterweed entitylivingbaseIn, float partialTickTime) {
        GlStateManager.func_179152_a((float)1.75f, (float)1.75f, (float)1.75f);
    }

    protected ResourceLocation getEntityTexture(EntityClusterweed entity) {
        return TEXTURES;
    }

    protected void applyRotations(EntityClusterweed entityLiving, float p1, float rotationYaw, float partialTicks) {
        super.func_77043_a((LivingEntity)entityLiving, p1, rotationYaw, partialTicks);
    }
}

