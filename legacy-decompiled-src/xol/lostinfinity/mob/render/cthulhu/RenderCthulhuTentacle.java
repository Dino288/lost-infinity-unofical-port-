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
package xol.lostinfinity.mob.render.cthulhu;

import javax.annotation.Nullable;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.mob.entity.cthulhu.EntityCthulhuTentacle;
import xol.lostinfinity.mob.model.cthulhu.ModelCthulhuTentacle;

public class RenderCthulhuTentacle
extends RenderLiving<EntityCthulhuTentacle> {
    private static final ResourceLocation TEXTURE = new ResourceLocation("lostinfinity", "textures/entity/cthulhu/tentacle.png");

    public RenderCthulhuTentacle(RenderManager rendermanagerIn) {
        super(rendermanagerIn, (ModelBase)new ModelCthulhuTentacle(), 0.0f);
    }

    protected void preRenderCallback(EntityCthulhuTentacle entitylivingbaseIn, float partialTickTime) {
        float size = entitylivingbaseIn.getSize();
        if (entitylivingbaseIn.isInverted()) {
            GlStateManager.func_179109_b((float)0.0f, (float)(-entitylivingbaseIn.field_70131_O), (float)0.0f);
            GlStateManager.func_179152_a((float)size, (float)(-size), (float)size);
        } else {
            GlStateManager.func_179152_a((float)size, (float)size, (float)size);
        }
    }

    @Nullable
    protected ResourceLocation getEntityTexture(EntityCthulhuTentacle entity) {
        return TEXTURE;
    }
}

