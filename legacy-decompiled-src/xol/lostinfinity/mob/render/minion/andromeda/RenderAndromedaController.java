/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.renderer.entity.Render
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.util.ResourceLocation
 */
package xol.lostinfinity.mob.render.minion.andromeda;

import javax.annotation.Nullable;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.mob.entity.minion.andromeda.EntityAndromedaController;

public class RenderAndromedaController
extends Render<EntityAndromedaController> {
    public RenderAndromedaController(RenderManager rendermanagerIn) {
        super(rendermanagerIn);
    }

    @Nullable
    protected ResourceLocation getEntityTexture(EntityAndromedaController entity) {
        return null;
    }
}

