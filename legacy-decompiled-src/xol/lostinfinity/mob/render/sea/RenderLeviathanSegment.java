/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.entity.RenderLiving
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.util.ResourceLocation
 */
package xol.lostinfinity.mob.render.sea;

import javax.annotation.Nullable;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.mob.entity.sea.leviathan.EntityLeviathanSegment;
import xol.lostinfinity.mob.model.sea.ModelLeviathan;

public class RenderLeviathanSegment
extends RenderLiving<EntityLeviathanSegment> {
    private static final ResourceLocation TEXTURE = new ResourceLocation("lostinfinity:textures/entity/sea/leviathan.png");

    public RenderLeviathanSegment(RenderManager rendermanagerIn) {
        super(rendermanagerIn, (ModelBase)new ModelLeviathan(), 1.0f);
    }

    @Nullable
    protected ResourceLocation getEntityTexture(EntityLeviathanSegment entity) {
        return TEXTURE;
    }

    protected void preRenderCallback(EntityLeviathanSegment entitylivingbaseIn, float partialTickTime) {
        double scale = entitylivingbaseIn.func_70603_bj();
        GlStateManager.func_179139_a((double)scale, (double)scale, (double)scale);
    }
}

