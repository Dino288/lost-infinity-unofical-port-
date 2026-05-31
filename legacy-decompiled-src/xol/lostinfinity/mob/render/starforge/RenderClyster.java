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
import xol.lostinfinity.mob.entity.starforge.EntityClyster;
import xol.lostinfinity.mob.model.starforge.ModelClyster;

public class RenderClyster
extends RenderLiving<EntityClyster> {
    public static final ResourceLocation TEXTURES = new ResourceLocation("lostinfinity:textures/entity/starforge/clyster.png");
    public static final ResourceLocation TEXTURES_BLUE = new ResourceLocation("lostinfinity:textures/entity/starforge/clyster_blue.png");

    public RenderClyster(RenderManager manager) {
        super(manager, (ModelBase)new ModelClyster(), 0.5f);
    }

    protected void preRenderCallback(EntityClyster entitylivingbaseIn, float partialTickTime) {
        if (entitylivingbaseIn.isEnlarged()) {
            GlStateManager.func_179152_a((float)(2.5f * entitylivingbaseIn.getUltraScl()), (float)(2.5f * entitylivingbaseIn.getUltraScl()), (float)(2.5f * entitylivingbaseIn.getUltraScl()));
        } else {
            GlStateManager.func_179152_a((float)2.5f, (float)2.5f, (float)2.5f);
        }
    }

    protected ResourceLocation getEntityTexture(EntityClyster entity) {
        if (entity.isEnlarged()) {
            return TEXTURES_BLUE;
        }
        return TEXTURES;
    }

    protected void applyRotations(EntityClyster entityLiving, float p1, float rotationYaw, float partialTicks) {
        super.func_77043_a((LivingEntity)entityLiving, p1, rotationYaw, partialTicks);
    }
}

