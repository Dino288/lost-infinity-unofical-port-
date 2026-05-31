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
import xol.lostinfinity.mob.entity.sea.EntityCrabulon;
import xol.lostinfinity.mob.model.sea.ModelCrabulon;

public class RenderCrabulon
extends RenderLiving<EntityCrabulon> {
    public RenderCrabulon(RenderManager rendermanagerIn) {
        super(rendermanagerIn, (ModelBase)new ModelCrabulon(), 0.0f);
    }

    protected void preRenderCallback(EntityCrabulon entitylivingbaseIn, float partialTickTime) {
        GlStateManager.func_179152_a((float)5.0f, (float)5.0f, (float)5.0f);
    }

    @Nullable
    protected ResourceLocation getEntityTexture(EntityCrabulon entity) {
        switch (entity.getVisualStyle()) {
            case 0: {
                return new ResourceLocation("lostinfinity:textures/entity/sea/crabulon1.png");
            }
            case 1: {
                return new ResourceLocation("lostinfinity:textures/entity/sea/crabulon2.png");
            }
            case 2: {
                return new ResourceLocation("lostinfinity:textures/entity/sea/crabulon3.png");
            }
            case 3: {
                return new ResourceLocation("lostinfinity:textures/entity/sea/crabulon4.png");
            }
        }
        return new ResourceLocation("lostinfinity:textures/entity/sea/crabulon1.png");
    }
}

