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
package xol.lostinfinity.mob.render.contest;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.mob.entity.contest.controller.EntityControllerTrampolineDodgeball;
import xol.lostinfinity.mob.model.contest.ModelGrandmaster;

public class RenderControllerTrampolineDodgeball
extends RenderLiving<EntityControllerTrampolineDodgeball> {
    public static final ResourceLocation TEXTURES = new ResourceLocation("lostinfinity:textures/entity/grandmaster.png");

    public RenderControllerTrampolineDodgeball(RenderManager manager) {
        super(manager, (ModelBase)new ModelGrandmaster(), 1.0f);
    }

    protected void preRenderCallback(EntityControllerTrampolineDodgeball entitylivingbaseIn, float partialTickTime) {
        GlStateManager.func_179152_a((float)9.0f, (float)9.0f, (float)9.0f);
    }

    protected void applyRotations(EntityControllerTrampolineDodgeball entityLiving, float p1, float rotationYaw, float partialTicks) {
        super.func_77043_a((LivingEntity)entityLiving, p1, rotationYaw, partialTicks);
    }

    protected ResourceLocation getEntityTexture(EntityControllerTrampolineDodgeball entity) {
        return TEXTURES;
    }
}

