/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.entity.projectile.EntityFireball
 *  net.minecraft.util.ResourceLocation
 */
package xol.lostinfinity.projectile.render;

import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.projectile.render.RenderProjectileBase;

public class RenderInfinityFireball
extends RenderProjectileBase<EntityFireball> {
    private ResourceLocation texture;
    private float scaleFactor;

    public RenderInfinityFireball(RenderManager renderManager, ResourceLocation texture) {
        super(renderManager, 1.0f);
        this.texture = texture;
    }

    public RenderInfinityFireball(RenderManager renderManager, float scaleFactor, ResourceLocation texture) {
        super(renderManager, scaleFactor);
        this.texture = texture;
    }

    protected ResourceLocation getEntityTexture(EntityFireball entity) {
        return this.texture;
    }
}

