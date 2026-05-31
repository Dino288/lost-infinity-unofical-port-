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
import xol.lostinfinity.mob.entity.misc.EntityTornIndividual;
import xol.lostinfinity.mob.model.labyrinth.ModelTornIndividual;

public class RenderTornIndividual
extends RenderLiving<EntityTornIndividual> {
    public static final ResourceLocation TEXTURES = new ResourceLocation("lostinfinity:textures/entity/tornindividual.png");

    public RenderTornIndividual(RenderManager manager) {
        super(manager, (ModelBase)new ModelTornIndividual(), 0.5f);
    }

    protected ResourceLocation getEntityTexture(EntityTornIndividual entity) {
        return TEXTURES;
    }

    protected void applyRotations(EntityTornIndividual entityLiving, float p1, float rotationYaw, float partialTicks) {
        super.func_77043_a((LivingEntity)entityLiving, p1, rotationYaw, partialTicks);
    }
}

