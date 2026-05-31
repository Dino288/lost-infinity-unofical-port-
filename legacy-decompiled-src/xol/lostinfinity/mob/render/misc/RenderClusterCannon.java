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
import xol.lostinfinity.mob.entity.misc.EntityClusterCannon;
import xol.lostinfinity.mob.model.ModelCannon;

public class RenderClusterCannon
extends RenderLiving<EntityClusterCannon> {
    public static final ResourceLocation TEXTURES = new ResourceLocation("lostinfinity:textures/entity/cluster_cannon.png");

    public RenderClusterCannon(RenderManager manager) {
        super(manager, (ModelBase)new ModelCannon(), 0.5f);
    }

    protected ResourceLocation getEntityTexture(EntityClusterCannon entity) {
        return TEXTURES;
    }

    protected void applyRotations(EntityClusterCannon entityLiving, float p1, float rotationYaw, float partialTicks) {
        super.func_77043_a((LivingEntity)entityLiving, p1, rotationYaw, partialTicks);
    }
}

