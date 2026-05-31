/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.renderer.culling.ICamera
 *  net.minecraft.client.renderer.entity.RenderLiving
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.util.ResourceLocation
 */
package xol.lostinfinity.mob.render.misc;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.mob.entity.misc.EntityStickyBomb;
import xol.lostinfinity.mob.model.ModelSpecialBomb;

public class RenderStickyBomb
extends RenderLiving<EntityStickyBomb> {
    public static final ResourceLocation TEXTURES = new ResourceLocation("lostinfinity:textures/entity/sticky_bomb.png");

    public RenderStickyBomb(RenderManager manager) {
        super(manager, (ModelBase)new ModelSpecialBomb(), 0.5f);
    }

    public boolean shouldRender(EntityStickyBomb livingEntity, ICamera camera, double camX, double camY, double camZ) {
        return true;
    }

    protected ResourceLocation getEntityTexture(EntityStickyBomb entity) {
        return TEXTURES;
    }

    protected void applyRotations(EntityStickyBomb entityLiving, float p1, float rotationYaw, float partialTicks) {
        super.func_77043_a((LivingEntity)entityLiving, p1, rotationYaw, partialTicks);
    }
}

