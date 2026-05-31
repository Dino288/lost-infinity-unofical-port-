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
package xol.lostinfinity.mob.render.starforge;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.mob.entity.starforge.EntityRockpest;
import xol.lostinfinity.mob.model.starforge.ModelRockpest;

public class RenderRockpest
extends RenderLiving<EntityRockpest> {
    public static final ResourceLocation TEXTURES = new ResourceLocation("lostinfinity:textures/entity/starforge/rockpest.png");

    public RenderRockpest(RenderManager manager) {
        super(manager, (ModelBase)new ModelRockpest(), 0.5f);
    }

    protected ResourceLocation getEntityTexture(EntityRockpest entity) {
        return TEXTURES;
    }

    protected void applyRotations(EntityRockpest entityLiving, float p1, float rotationYaw, float partialTicks) {
        super.func_77043_a((LivingEntity)entityLiving, p1, rotationYaw, partialTicks);
    }
}

