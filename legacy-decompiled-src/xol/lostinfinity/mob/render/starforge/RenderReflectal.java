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
import xol.lostinfinity.mob.entity.starforge.EntityReflectal;
import xol.lostinfinity.mob.model.starforge.ModelReflectal;

public class RenderReflectal
extends RenderLiving<EntityReflectal> {
    public static final ResourceLocation TEXTURES = new ResourceLocation("lostinfinity:textures/entity/starforge/reflectal.png");
    public static final ResourceLocation TEXTURES_BLUE = new ResourceLocation("lostinfinity:textures/entity/starforge/reflectal_blue.png");

    public RenderReflectal(RenderManager manager) {
        super(manager, (ModelBase)new ModelReflectal(), 0.5f);
    }

    protected void preRenderCallback(EntityReflectal entitylivingbaseIn, float partialTickTime) {
        if (entitylivingbaseIn.isEnlarged()) {
            GlStateManager.func_179152_a((float)entitylivingbaseIn.getUltraScl(), (float)entitylivingbaseIn.getUltraScl(), (float)entitylivingbaseIn.getUltraScl());
        } else {
            GlStateManager.func_179152_a((float)1.0f, (float)1.0f, (float)1.0f);
        }
    }

    protected ResourceLocation getEntityTexture(EntityReflectal entity) {
        if (entity.isEnlarged()) {
            return TEXTURES_BLUE;
        }
        return TEXTURES;
    }

    protected void applyRotations(EntityReflectal entityLiving, float p1, float rotationYaw, float partialTicks) {
        super.func_77043_a((LivingEntity)entityLiving, p1, rotationYaw, partialTicks);
    }
}

