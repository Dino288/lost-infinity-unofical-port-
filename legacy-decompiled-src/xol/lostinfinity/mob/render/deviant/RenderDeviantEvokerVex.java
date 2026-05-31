/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.renderer.entity.RenderLiving
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.util.ResourceLocation
 */
package xol.lostinfinity.mob.render.deviant;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantEvokerVex;
import xol.lostinfinity.mob.model.deviant.ModelDeviantVex;

public class RenderDeviantEvokerVex
extends RenderLiving<EntityDeviantEvokerVex> {
    public static final ResourceLocation TEXTURES_NORMAL = new ResourceLocation("lostinfinity:textures/entity/deviant/deviantvex.png");

    public RenderDeviantEvokerVex(RenderManager manager) {
        super(manager, (ModelBase)new ModelDeviantVex(), 0.5f);
    }

    protected ResourceLocation getEntityTexture(EntityDeviantEvokerVex entity) {
        return TEXTURES_NORMAL;
    }

    protected void applyRotations(EntityDeviantEvokerVex entityLiving, float p1, float rotationYaw, float partialTicks) {
        super.func_77043_a((LivingEntity)entityLiving, p1, rotationYaw, partialTicks);
    }
}

