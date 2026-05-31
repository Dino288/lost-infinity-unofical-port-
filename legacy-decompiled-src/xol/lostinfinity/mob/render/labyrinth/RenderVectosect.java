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
package xol.lostinfinity.mob.render.labyrinth;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.mob.entity.labyrinth.EntityVectosect;
import xol.lostinfinity.mob.model.labyrinth.ModelVectosect;

public class RenderVectosect
extends RenderLiving<EntityVectosect> {
    public static final ResourceLocation TEXTURES = new ResourceLocation("lostinfinity:textures/entity/labyrinth/vectosect.png");

    public RenderVectosect(RenderManager manager) {
        super(manager, (ModelBase)new ModelVectosect(), 0.5f);
    }

    protected ResourceLocation getEntityTexture(EntityVectosect entity) {
        return TEXTURES;
    }

    protected void applyRotations(EntityVectosect entityLiving, float p1, float rotationYaw, float partialTicks) {
        super.func_77043_a((LivingEntity)entityLiving, p1, rotationYaw, partialTicks);
    }
}

