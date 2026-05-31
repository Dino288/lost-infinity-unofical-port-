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
import xol.lostinfinity.mob.entity.starforge.EntityDrippler;
import xol.lostinfinity.mob.model.starforge.ModelDrippler;

public class RenderDrippler
extends RenderLiving<EntityDrippler> {
    public static final ResourceLocation TEXTURES = new ResourceLocation("lostinfinity:textures/entity/starforge/drippler.png");

    public RenderDrippler(RenderManager manager) {
        super(manager, (ModelBase)new ModelDrippler(), 0.5f);
    }

    protected void preRenderCallback(EntityDrippler entitylivingbaseIn, float partialTickTime) {
        GlStateManager.func_179152_a((float)1.25f, (float)1.25f, (float)1.25f);
    }

    protected ResourceLocation getEntityTexture(EntityDrippler entity) {
        return TEXTURES;
    }

    protected void applyRotations(EntityDrippler entityLiving, float p1, float rotationYaw, float partialTicks) {
        super.func_77043_a((LivingEntity)entityLiving, p1, rotationYaw, partialTicks);
    }
}

