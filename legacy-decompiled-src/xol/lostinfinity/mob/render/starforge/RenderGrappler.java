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
import xol.lostinfinity.mob.entity.starforge.EntityGrappler;
import xol.lostinfinity.mob.model.starforge.ModelGrappler;

public class RenderGrappler
extends RenderLiving<EntityGrappler> {
    public static final ResourceLocation TEXTURES = new ResourceLocation("lostinfinity:textures/entity/starforge/grappler.png");

    public RenderGrappler(RenderManager manager) {
        super(manager, (ModelBase)new ModelGrappler(), 0.5f);
    }

    protected void preRenderCallback(EntityGrappler entity, float partialTickTime) {
        GlStateManager.func_179152_a((float)1.8f, (float)1.8f, (float)1.8f);
    }

    protected ResourceLocation getEntityTexture(EntityGrappler entity) {
        return TEXTURES;
    }

    protected void applyRotations(EntityGrappler entityLiving, float p1, float rotationYaw, float partialTicks) {
        super.func_77043_a((LivingEntity)entityLiving, p1, rotationYaw, partialTicks);
    }
}

