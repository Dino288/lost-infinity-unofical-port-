/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.entity.Render
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.util.ResourceLocation
 */
package xol.lostinfinity.mob.render.misc;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.mob.entity.misc.EntityRocketStrappedExplosive;

public class RenderRocketStrappedExplosive
extends Render<EntityRocketStrappedExplosive> {
    public RenderRocketStrappedExplosive(RenderManager renderManager) {
        super(renderManager);
    }

    protected ResourceLocation getEntityTexture(EntityRocketStrappedExplosive entity) {
        return null;
    }
}

