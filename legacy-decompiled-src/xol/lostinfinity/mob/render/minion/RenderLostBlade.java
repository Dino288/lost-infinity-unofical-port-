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
import xol.lostinfinity.mob.entity.minion.EntityLostBlade;
import xol.lostinfinity.mob.model.minion.ModelLostBlade;
import xol.lostinfinity.mob.render.minion.RenderMinion;

public class RenderLostBlade
extends RenderMinion<EntityLostBlade> {
    public static final ResourceLocation TEXTURES = new ResourceLocation("lostinfinity:textures/entity/lost_blade.png");

    public RenderLostBlade(RenderManager renderManager) {
        super(renderManager, new ModelLostBlade(), 0.0f);
    }

    @Nullable
    protected ResourceLocation getEntityTexture(EntityLostBlade entity) {
        return TEXTURES;
    }

    protected void preRenderCallback(EntityLostBlade entitylivingbaseIn, float partialTickTime) {
        GlStateManager.func_179139_a((double)0.25, (double)0.25, (double)0.25);
    }
}

