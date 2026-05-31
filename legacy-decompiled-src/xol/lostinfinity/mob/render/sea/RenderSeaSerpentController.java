/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.renderer.entity.Render
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.util.ResourceLocation
 */
package xol.lostinfinity.mob.render.sea;

import javax.annotation.Nullable;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.mob.entity.sea.seaserpent.EntitySeaSerpentController;

public class RenderSeaSerpentController
extends Render<EntitySeaSerpentController> {
    public RenderSeaSerpentController(RenderManager rendermanagerIn) {
        super(rendermanagerIn);
    }

    @Nullable
    protected ResourceLocation getEntityTexture(EntitySeaSerpentController entity) {
        return null;
    }
}

