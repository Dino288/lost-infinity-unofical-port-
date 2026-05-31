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
 *  net.minecraft.util.math.Mth
 */
package xol.lostinfinity.mob.render.labyrinth;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import xol.lostinfinity.mob.entity.labyrinth.EntityGloopMother;
import xol.lostinfinity.mob.model.labyrinth.ModelGloopMother;

public class RenderGloopMother
extends RenderLiving<EntityGloopMother> {
    public static final ResourceLocation TEXTURES = new ResourceLocation("lostinfinity:textures/entity/labyrinth/gloopmother.png");

    public RenderGloopMother(RenderManager manager) {
        super(manager, (ModelBase)new ModelGloopMother(), 0.5f);
    }

    protected void preRenderCallback(EntityGloopMother entitylivingbaseIn, float partialTickTime) {
        float scl = 1.0f + 0.7f * Mth.func_76126_a((float)((float)entitylivingbaseIn.field_70173_aa * 0.1f));
        GlStateManager.func_179152_a((float)1.0f, (float)scl, (float)1.0f);
    }

    protected ResourceLocation getEntityTexture(EntityGloopMother entity) {
        return TEXTURES;
    }

    protected void applyRotations(EntityGloopMother entityLiving, float p1, float rotationYaw, float partialTicks) {
        super.func_77043_a((LivingEntity)entityLiving, p1, rotationYaw, partialTicks);
    }
}

