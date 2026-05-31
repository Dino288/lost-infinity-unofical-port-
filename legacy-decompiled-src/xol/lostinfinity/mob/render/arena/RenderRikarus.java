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
package xol.lostinfinity.mob.render.arena;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.mob.entity.boss.EntityRikarus;
import xol.lostinfinity.mob.model.boss.ModelRikarus;

public class RenderRikarus
extends RenderLiving<EntityRikarus> {
    public static final ResourceLocation TEXTURES = new ResourceLocation("lostinfinity:textures/entity/rikarus.png");

    public RenderRikarus(RenderManager manager) {
        super(manager, (ModelBase)new ModelRikarus(), 0.5f);
    }

    protected void preRenderCallback(EntityRikarus entitylivingbaseIn, float partialTickTime) {
        GlStateManager.func_179152_a((float)3.0f, (float)3.0f, (float)3.0f);
    }

    protected ResourceLocation getEntityTexture(EntityRikarus entity) {
        return TEXTURES;
    }

    protected void applyRotations(EntityRikarus entityLiving, float p1, float rotationYaw, float partialTicks) {
        super.func_77043_a((LivingEntity)entityLiving, p1, rotationYaw, partialTicks);
    }
}

