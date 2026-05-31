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
import xol.lostinfinity.mob.entity.sea.EntityRibshark;
import xol.lostinfinity.mob.model.sea.ModelRibshark;

public class RenderRibshark
extends RenderLiving<EntityRibshark> {
    public RenderRibshark(RenderManager rendermanagerIn) {
        super(rendermanagerIn, (ModelBase)new ModelRibshark(), 0.0f);
    }

    protected void preRenderCallback(EntityRibshark entitylivingbaseIn, float partialTickTime) {
        GlStateManager.func_179152_a((float)2.0f, (float)2.0f, (float)2.0f);
    }

    @Nullable
    protected ResourceLocation getEntityTexture(EntityRibshark entity) {
        switch (entity.getVisualStyle()) {
            case 0: {
                return new ResourceLocation("lostinfinity:textures/entity/sea/ribshark1.png");
            }
            case 1: {
                return new ResourceLocation("lostinfinity:textures/entity/sea/ribshark2.png");
            }
            case 2: {
                return new ResourceLocation("lostinfinity:textures/entity/sea/ribshark3.png");
            }
            case 3: {
                return new ResourceLocation("lostinfinity:textures/entity/sea/ribshark4.png");
            }
        }
        return new ResourceLocation("lostinfinity:textures/entity/sea/ribshark1.png");
    }
}

