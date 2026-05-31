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
import xol.lostinfinity.mob.entity.starforge.EntityGiantFyreweed;
import xol.lostinfinity.mob.model.starforge.ModelGiantFyreweed;

public class RenderGiantFyreweed
extends RenderLiving<EntityGiantFyreweed> {
    public static final ResourceLocation TEXTURES = new ResourceLocation("lostinfinity:textures/entity/starforge/giantfyreweed.png");

    public RenderGiantFyreweed(RenderManager manager) {
        super(manager, (ModelBase)new ModelGiantFyreweed(), 0.5f);
    }

    protected void preRenderCallback(EntityGiantFyreweed fyreweed, float partialTickTime) {
        if (fyreweed.field_70173_aa > 40) {
            GlStateManager.func_179152_a((float)3.0f, (float)3.0f, (float)3.0f);
        } else {
            float scale = (float)fyreweed.field_70173_aa * 0.075f;
            GlStateManager.func_179152_a((float)scale, (float)scale, (float)scale);
        }
    }

    protected ResourceLocation getEntityTexture(EntityGiantFyreweed entity) {
        return TEXTURES;
    }

    protected void applyRotations(EntityGiantFyreweed entityLiving, float p1, float rotationYaw, float partialTicks) {
        super.func_77043_a((LivingEntity)entityLiving, p1, rotationYaw, partialTicks);
    }
}

