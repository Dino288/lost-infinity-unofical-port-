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
import xol.lostinfinity.mob.entity.starforge.EntitySightwalker;
import xol.lostinfinity.mob.model.starforge.ModelSightwalker;

public class RenderSightwalker
extends RenderLiving<EntitySightwalker> {
    public static final ResourceLocation TEXTURES = new ResourceLocation("lostinfinity:textures/entity/starforge/sightwalker.png");

    public RenderSightwalker(RenderManager manager) {
        super(manager, (ModelBase)new ModelSightwalker(), 0.5f);
    }

    protected void preRenderCallback(EntitySightwalker entity, float partialTickTime) {
        float scl = entity.getMyScale();
        GlStateManager.func_179152_a((float)scl, (float)scl, (float)scl);
    }

    protected ResourceLocation getEntityTexture(EntitySightwalker entity) {
        return TEXTURES;
    }

    protected void applyRotations(EntitySightwalker entityLiving, float p1, float rotationYaw, float partialTicks) {
        super.func_77043_a((LivingEntity)entityLiving, p1, rotationYaw, partialTicks);
    }
}

