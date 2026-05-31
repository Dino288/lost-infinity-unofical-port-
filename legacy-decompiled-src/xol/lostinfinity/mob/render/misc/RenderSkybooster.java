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
import xol.lostinfinity.mob.entity.misc.EntitySkybooster;
import xol.lostinfinity.mob.model.ModelSkybooster;

public class RenderSkybooster
extends RenderLiving<EntitySkybooster> {
    public static final ResourceLocation TEXTURES = new ResourceLocation("lostinfinity:textures/entity/skybooster.png");

    public RenderSkybooster(RenderManager manager) {
        super(manager, (ModelBase)new ModelSkybooster(), 0.5f);
    }

    protected void preRenderCallback(EntitySkybooster entitylivingbaseIn, float partialTickTime) {
        GlStateManager.func_179152_a((float)entitylivingbaseIn.getMyScale(), (float)entitylivingbaseIn.getMyScale(), (float)entitylivingbaseIn.getMyScale());
    }

    protected ResourceLocation getEntityTexture(EntitySkybooster entity) {
        return TEXTURES;
    }

    protected void applyRotations(EntitySkybooster entityLiving, float p1, float rotationYaw, float partialTicks) {
        super.func_77043_a((LivingEntity)entityLiving, p1, rotationYaw, partialTicks);
    }
}

