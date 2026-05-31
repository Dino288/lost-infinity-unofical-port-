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
package xol.lostinfinity.mob.render.nebula;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.mob.entity.nebula.EntityNebulaGrunt;
import xol.lostinfinity.mob.model.nebula.ModelNebulaGrunt;

public class RenderNebulaGrunt
extends RenderLiving<EntityNebulaGrunt> {
    public static final ResourceLocation TEXTURES = new ResourceLocation("lostinfinity:textures/entity/nebula_grunt.png");

    public RenderNebulaGrunt(RenderManager manager) {
        super(manager, (ModelBase)new ModelNebulaGrunt(), 0.0f);
    }

    protected ResourceLocation getEntityTexture(EntityNebulaGrunt entity) {
        return TEXTURES;
    }

    protected void applyRotations(EntityNebulaGrunt entityLiving, float p1, float rotationYaw, float partialTicks) {
        super.func_77043_a((LivingEntity)entityLiving, p1, rotationYaw, partialTicks);
    }
}

