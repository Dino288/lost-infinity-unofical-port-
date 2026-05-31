/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.renderer.entity.Render
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.util.ResourceLocation
 */
package xol.lostinfinity.mob.render.cthulhu;

import javax.annotation.Nullable;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.mob.entity.cthulhu.EntityCthulhuPart;

public class RenderCthulhuPart
extends Render<EntityCthulhuPart> {
    public RenderCthulhuPart(RenderManager renderManager) {
        super(renderManager);
    }

    @Nullable
    protected ResourceLocation getEntityTexture(EntityCthulhuPart entity) {
        return null;
    }
}

