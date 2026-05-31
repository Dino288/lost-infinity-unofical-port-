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
package xol.lostinfinity.mob.render.prime;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.mob.entity.deviant.prime.EntityLivorax;
import xol.lostinfinity.mob.model.boss.ModelLivorax;

public class RenderLivorax
extends RenderLiving<EntityLivorax> {
    public static final ResourceLocation TEXTURES = new ResourceLocation("lostinfinity:textures/entity/livorax.png");

    public RenderLivorax(RenderManager manager) {
        super(manager, (ModelBase)new ModelLivorax(), 0.5f);
    }

    protected void preRenderCallback(EntityLivorax entitylivingbaseIn, float partialTickTime) {
        GlStateManager.func_179152_a((float)1.5f, (float)1.5f, (float)1.5f);
    }

    protected ResourceLocation getEntityTexture(EntityLivorax entity) {
        return TEXTURES;
    }

    protected void applyRotations(EntityLivorax entityLiving, float p1, float rotationYaw, float partialTicks) {
        super.func_77043_a((LivingEntity)entityLiving, p1, rotationYaw, partialTicks);
    }
}

