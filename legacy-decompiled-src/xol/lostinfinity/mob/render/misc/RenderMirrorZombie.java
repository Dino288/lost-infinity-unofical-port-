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
package xol.lostinfinity.mob.render.misc;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.mob.entity.misc.EntityMirrorZombie;
import xol.lostinfinity.mob.model.ModelMirrorZombie;

public class RenderMirrorZombie
extends RenderLiving<EntityMirrorZombie> {
    public static final ResourceLocation TEXTURES = new ResourceLocation("lostinfinity:textures/entity/mirrorzombie.png");

    public RenderMirrorZombie(RenderManager manager) {
        super(manager, (ModelBase)new ModelMirrorZombie(), 1.0f);
    }

    protected void preRenderCallback(EntityMirrorZombie entitylivingbaseIn, float partialTickTime) {
        if (entitylivingbaseIn.field_70173_aa < 80) {
            GlStateManager.func_179152_a((float)(1.0f + 0.025f * (float)entitylivingbaseIn.field_70173_aa), (float)(1.0f + 0.025f * (float)entitylivingbaseIn.field_70173_aa), (float)(1.0f + 0.025f * (float)entitylivingbaseIn.field_70173_aa));
        } else {
            GlStateManager.func_179152_a((float)3.0f, (float)3.0f, (float)3.0f);
        }
    }

    protected ResourceLocation getEntityTexture(EntityMirrorZombie entity) {
        return TEXTURES;
    }

    protected void applyRotations(EntityMirrorZombie entityLiving, float p1, float rotationYaw, float partialTicks) {
        super.func_77043_a((LivingEntity)entityLiving, p1, rotationYaw, partialTicks);
    }
}

