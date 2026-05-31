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
import xol.lostinfinity.mob.entity.starforge.EntityTerrorFly;
import xol.lostinfinity.mob.model.starforge.ModelTerrorFly;

public class RenderTerrorFly
extends RenderLiving<EntityTerrorFly> {
    public static final ResourceLocation TEXTURES = new ResourceLocation("lostinfinity:textures/entity/starforge/terrorfly.png");

    public RenderTerrorFly(RenderManager manager) {
        super(manager, (ModelBase)new ModelTerrorFly(), 0.5f);
    }

    protected ResourceLocation getEntityTexture(EntityTerrorFly entity) {
        return TEXTURES;
    }

    protected void applyRotations(EntityTerrorFly entityLiving, float p1, float rotationYaw, float partialTicks) {
        super.func_77043_a((LivingEntity)entityLiving, p1, rotationYaw, partialTicks);
    }
}

