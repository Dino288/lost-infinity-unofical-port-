/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.entity.projectile.EntityThrowable
 *  net.minecraft.util.ResourceLocation
 */
package xol.lostinfinity.projectile.render;

import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.projectile.render.RenderProjectileBase;

public class RenderAlternatingThrowable
extends RenderProjectileBase<EntityThrowable> {
    private ResourceLocation texture;
    private ResourceLocation texture2;
    private int switch_timer = 5;

    public RenderAlternatingThrowable(RenderManager renderManager, ResourceLocation texture, ResourceLocation texture2) {
        super(renderManager, 1.0f);
        this.texture = texture;
        this.texture2 = texture2;
    }

    public RenderAlternatingThrowable(RenderManager renderManager, float scaleFactor, ResourceLocation texture, ResourceLocation texture2) {
        super(renderManager, scaleFactor);
        this.texture = texture;
        this.texture2 = texture2;
    }

    public RenderAlternatingThrowable(RenderManager renderManager, float scaleFactor, ResourceLocation texture, ResourceLocation texture2, int timer) {
        super(renderManager, scaleFactor);
        this.texture = texture;
        this.texture2 = texture2;
        this.switch_timer = timer;
    }

    protected ResourceLocation getEntityTexture(EntityThrowable entity) {
        if (entity.field_70173_aa % this.switch_timer * 2 < this.switch_timer) {
            return this.texture;
        }
        return this.texture2;
    }
}

