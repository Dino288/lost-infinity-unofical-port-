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
import xol.lostinfinity.mob.entity.labyrinth.EntityGloop;
import xol.lostinfinity.mob.model.labyrinth.ModelGloop;

public class RenderGloop
extends RenderLiving<EntityGloop> {
    public static final ResourceLocation TEXTURES = new ResourceLocation("lostinfinity:textures/entity/labyrinth/gloop.png");

    public RenderGloop(RenderManager manager) {
        super(manager, (ModelBase)new ModelGloop(), 0.5f);
    }

    protected ResourceLocation getEntityTexture(EntityGloop entity) {
        return TEXTURES;
    }

    protected void preRenderCallback(EntityGloop entitylivingbaseIn, float partialTickTime) {
        float scl = 1.0f + 0.3f * Mth.func_76126_a((float)((float)entitylivingbaseIn.field_70173_aa * 0.2f));
        GlStateManager.func_179152_a((float)scl, (float)scl, (float)scl);
    }

    protected void applyRotations(EntityGloop entityLiving, float p1, float rotationYaw, float partialTicks) {
        super.func_77043_a((LivingEntity)entityLiving, p1, rotationYaw, partialTicks);
    }
}

