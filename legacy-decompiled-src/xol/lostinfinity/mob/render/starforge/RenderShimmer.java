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
import xol.lostinfinity.mob.entity.starforge.EntityShimmer;
import xol.lostinfinity.mob.model.starforge.ModelShimmer;

public class RenderShimmer
extends RenderLiving<EntityShimmer> {
    public static final ResourceLocation TEXTURES = new ResourceLocation("lostinfinity:textures/entity/starforge/shimmer.png");

    public RenderShimmer(RenderManager manager) {
        super(manager, (ModelBase)new ModelShimmer(), 0.5f);
    }

    protected ResourceLocation getEntityTexture(EntityShimmer entity) {
        return TEXTURES;
    }

    protected void applyRotations(EntityShimmer entityLiving, float p1, float rotationYaw, float partialTicks) {
        super.func_77043_a((LivingEntity)entityLiving, p1, rotationYaw, partialTicks);
    }
}

