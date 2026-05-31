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
import xol.lostinfinity.mob.entity.starforge.EntityFlapper;
import xol.lostinfinity.mob.model.starforge.ModelFlapper;

public class RenderFlapper
extends RenderLiving<EntityFlapper> {
    public static final ResourceLocation TEXTURES = new ResourceLocation("lostinfinity:textures/entity/starforge/flapper.png");

    public RenderFlapper(RenderManager manager) {
        super(manager, (ModelBase)new ModelFlapper(), 0.5f);
    }

    protected void preRenderCallback(EntityFlapper entitylivingbaseIn, float partialTickTime) {
        GlStateManager.func_179152_a((float)2.0f, (float)2.0f, (float)2.0f);
    }

    protected ResourceLocation getEntityTexture(EntityFlapper entity) {
        return TEXTURES;
    }

    protected void applyRotations(EntityFlapper entityLiving, float p1, float rotationYaw, float partialTicks) {
        super.func_77043_a((LivingEntity)entityLiving, p1, rotationYaw, partialTicks);
    }
}

