/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.util.ResourceLocation
 */
package xol.lostinfinity.mob.render.minion.andromeda;

import javax.annotation.Nullable;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.mob.entity.minion.andromeda.EntityAndromedaSegment;
import xol.lostinfinity.mob.model.minion.ModelAndromeda;
import xol.lostinfinity.mob.render.minion.RenderMinion;

public class RenderAndromedaSegment
extends RenderMinion<EntityAndromedaSegment> {
    private static final ResourceLocation TEXTURE = new ResourceLocation("lostinfinity:textures/entity/andromeda.png");

    public RenderAndromedaSegment(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelAndromeda(), 0.0f);
    }

    @Nullable
    protected ResourceLocation getEntityTexture(EntityAndromedaSegment entity) {
        return TEXTURE;
    }

    protected void preRenderCallback(EntityAndromedaSegment entitylivingbaseIn, float partialTickTime) {
        double scale = entitylivingbaseIn.func_70603_bj();
        GlStateManager.func_179139_a((double)scale, (double)scale, (double)scale);
    }
}

