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
import xol.lostinfinity.mob.entity.misc.EntityPlasmaExplosion;
import xol.lostinfinity.mob.model.ModelPlasmaExplosion;

public class RenderPlasmaExplosion
extends RenderLiving<EntityPlasmaExplosion> {
    public static final ResourceLocation TEXTURES = new ResourceLocation("lostinfinity:textures/entity/plasma_explosion.png");

    public RenderPlasmaExplosion(RenderManager manager) {
        super(manager, (ModelBase)new ModelPlasmaExplosion(), 0.5f);
    }

    protected void preRenderCallback(EntityPlasmaExplosion entitylivingbaseIn, float partialTickTime) {
        float scale = 4 + entitylivingbaseIn.getExplScale();
        GlStateManager.func_179152_a((float)scale, (float)scale, (float)scale);
    }

    protected ResourceLocation getEntityTexture(EntityPlasmaExplosion entity) {
        return TEXTURES;
    }

    protected void applyRotations(EntityPlasmaExplosion entityLiving, float p1, float rotationYaw, float partialTicks) {
        super.func_77043_a((LivingEntity)entityLiving, p1, rotationYaw, partialTicks);
    }
}

