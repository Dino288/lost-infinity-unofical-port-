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
import xol.lostinfinity.mob.entity.misc.EntityTentacleTrap;
import xol.lostinfinity.mob.model.ModelTentacleTrap;

public class RenderTentacleTrap
extends RenderLiving<EntityTentacleTrap> {
    public static final ResourceLocation TEXTURES = new ResourceLocation("lostinfinity:textures/entity/tentacle_trap.png");

    public RenderTentacleTrap(RenderManager manager) {
        super(manager, (ModelBase)new ModelTentacleTrap(), 0.5f);
    }

    protected void preRenderCallback(EntityTentacleTrap entity, float partialTickTime) {
        float height;
        float scale = height = 0.5f + entity.getTargetHeight() / 3.0f;
        if (entity.field_70173_aa < 20) {
            scale = (float)entity.field_70173_aa * (height / 20.0f);
        }
        GlStateManager.func_179152_a((float)scale, (float)scale, (float)scale);
    }

    protected ResourceLocation getEntityTexture(EntityTentacleTrap entity) {
        return TEXTURES;
    }

    protected void applyRotations(EntityTentacleTrap entityLiving, float p1, float rotationYaw, float partialTicks) {
        super.func_77043_a((LivingEntity)entityLiving, p1, rotationYaw, partialTicks);
    }
}

