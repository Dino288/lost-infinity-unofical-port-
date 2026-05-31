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
package xol.lostinfinity.mob.render.mount;

import javax.annotation.Nullable;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.mob.entity.mount.EntityJetMount;
import xol.lostinfinity.mob.model.ModelRocketMount;

public class RenderJetMount
extends RenderLiving<EntityJetMount> {
    private static final ResourceLocation TEXTURES = new ResourceLocation("lostinfinity:textures/entity/rocket_mount.png");

    public RenderJetMount(RenderManager rendermanagerIn) {
        super(rendermanagerIn, (ModelBase)new ModelRocketMount(), 1.5f);
    }

    protected void preRenderCallback(EntityJetMount entitylivingbaseIn, float partialTickTime) {
        GlStateManager.func_179152_a((float)1.5f, (float)1.5f, (float)1.5f);
    }

    @Nullable
    protected ResourceLocation getEntityTexture(EntityJetMount entity) {
        return TEXTURES;
    }
}

