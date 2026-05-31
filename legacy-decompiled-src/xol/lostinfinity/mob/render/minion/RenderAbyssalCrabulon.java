/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.util.ResourceLocation
 */
package xol.lostinfinity.mob.render.minion;

import javax.annotation.Nullable;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.mob.entity.minion.EntityAbyssalCrabulon;
import xol.lostinfinity.mob.model.sea.ModelCrabulon;
import xol.lostinfinity.mob.render.minion.RenderMinion;

public class RenderAbyssalCrabulon
extends RenderMinion<EntityAbyssalCrabulon> {
    public static final ResourceLocation TEXTURES = new ResourceLocation("lostinfinity:textures/entity/abyssal_crabulon.png");

    public RenderAbyssalCrabulon(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelCrabulon(), 0.0f);
    }

    protected void preRenderCallback(EntityAbyssalCrabulon entitylivingbaseIn, float partialTickTime) {
        GlStateManager.func_179152_a((float)0.3f, (float)0.3f, (float)0.3f);
    }

    @Nullable
    protected ResourceLocation getEntityTexture(EntityAbyssalCrabulon entity) {
        return TEXTURES;
    }
}

