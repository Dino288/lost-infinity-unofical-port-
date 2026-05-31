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
package xol.lostinfinity.mob.render.misc;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.mob.entity.misc.EntityTotemPylon;
import xol.lostinfinity.mob.model.ModelTotem;

public class RenderTotemPylon
extends RenderLiving<EntityTotemPylon> {
    public static final ResourceLocation TEXTURES = new ResourceLocation("lostinfinity:textures/entity/totem/totem_pylon.png");

    public RenderTotemPylon(RenderManager manager) {
        super(manager, (ModelBase)new ModelTotem(), 0.5f);
    }

    protected ResourceLocation getEntityTexture(EntityTotemPylon entity) {
        return TEXTURES;
    }

    protected void applyRotations(EntityTotemPylon entityLiving, float p1, float rotationYaw, float partialTicks) {
        super.func_77043_a((LivingEntity)entityLiving, p1, rotationYaw, partialTicks);
    }
}

