/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.entity.Render
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.ResourceLocation
 */
package xol.lostinfinity.projectile.render;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;

public class RenderForbiddenBrand<T extends Entity>
extends Render<T> {
    public RenderForbiddenBrand(RenderManager renderManager) {
        super(renderManager);
    }

    public void func_76986_a(T entity, double x, double y, double z, float entityYaw, float partialTicks) {
    }

    protected ResourceLocation func_110775_a(T entity) {
        return null;
    }
}

