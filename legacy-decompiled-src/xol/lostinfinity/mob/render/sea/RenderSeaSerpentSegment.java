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
import xol.lostinfinity.mob.entity.sea.seaserpent.EntitySeaSerpentSegment;
import xol.lostinfinity.mob.model.sea.ModelSeaSerpent;

public class RenderSeaSerpentSegment
extends RenderLiving<EntitySeaSerpentSegment> {
    private static final ResourceLocation TEXTURE = new ResourceLocation("lostinfinity:textures/entity/sea/sea_serpent.png");

    public RenderSeaSerpentSegment(RenderManager rendermanagerIn) {
        super(rendermanagerIn, (ModelBase)new ModelSeaSerpent(), 1.0f);
    }

    @Nullable
    protected ResourceLocation getEntityTexture(EntitySeaSerpentSegment entity) {
        return TEXTURE;
    }

    protected void preRenderCallback(EntitySeaSerpentSegment entitylivingbaseIn, float partialTickTime) {
        double scale = entitylivingbaseIn.func_70603_bj();
        GlStateManager.func_179139_a((double)scale, (double)scale, (double)scale);
    }
}

