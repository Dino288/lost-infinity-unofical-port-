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
import xol.lostinfinity.mob.entity.minion.EntityLuminousGuardian;
import xol.lostinfinity.mob.model.starforge.ModelWisp;
import xol.lostinfinity.mob.render.minion.RenderMinion;

public class RenderLuminousGuardian
extends RenderMinion<EntityLuminousGuardian> {
    public static final ResourceLocation TEXTURES = new ResourceLocation("lostinfinity:textures/entity/luminous_guardian.png");

    public RenderLuminousGuardian(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelWisp(), 0.0f);
    }

    protected void preRenderCallback(EntityLuminousGuardian entitylivingbaseIn, float partialTickTime) {
        GlStateManager.func_179152_a((float)0.3f, (float)0.3f, (float)0.3f);
    }

    @Nullable
    protected ResourceLocation getEntityTexture(EntityLuminousGuardian entity) {
        return TEXTURES;
    }
}

