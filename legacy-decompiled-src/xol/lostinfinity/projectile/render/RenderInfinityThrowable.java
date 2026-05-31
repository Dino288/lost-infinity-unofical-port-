/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.culling.ICamera
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.projectile.EntityThrowable
 *  net.minecraft.util.ResourceLocation
 */
package xol.lostinfinity.projectile.render;

import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.world.entity.Entity;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.projectile.render.RenderProjectileBase;

public class RenderInfinityThrowable
extends RenderProjectileBase<EntityThrowable> {
    private ResourceLocation texture;
    private boolean farRender = false;

    public RenderInfinityThrowable(RenderManager renderManager, ResourceLocation texture) {
        super(renderManager, 1.0f);
        this.texture = texture;
    }

    public RenderInfinityThrowable(RenderManager renderManager, float scaleFactor, ResourceLocation texture) {
        super(renderManager, scaleFactor);
        this.texture = texture;
    }

    public RenderInfinityThrowable(RenderManager renderManager, float scaleFactor, ResourceLocation texture, boolean farRender) {
        super(renderManager, scaleFactor);
        this.texture = texture;
        this.farRender = farRender;
    }

    protected ResourceLocation getEntityTexture(EntityThrowable entity) {
        return this.texture;
    }

    public boolean shouldRender(EntityThrowable livingEntity, ICamera camera, double camX, double camY, double camZ) {
        if (this.farRender) {
            double xDiff = camX - livingEntity.field_70165_t;
            double yDiff = camY - livingEntity.field_70163_u;
            double zDiff = camZ - livingEntity.field_70161_v;
            return xDiff * xDiff + yDiff * yDiff + zDiff * zDiff < 100000.0;
        }
        return super.func_177071_a((Entity)livingEntity, camera, camX, camY, camZ);
    }
}

