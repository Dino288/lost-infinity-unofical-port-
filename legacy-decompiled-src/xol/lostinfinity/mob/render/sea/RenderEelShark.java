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
import xol.lostinfinity.mob.entity.sea.EntityEelShark;
import xol.lostinfinity.mob.model.sea.ModelEelshark;

public class RenderEelShark
extends RenderLiving<EntityEelShark> {
    public RenderEelShark(RenderManager rendermanagerIn) {
        super(rendermanagerIn, (ModelBase)new ModelEelshark(), 0.5f);
    }

    protected void preRenderCallback(EntityEelShark entitylivingbaseIn, float partialTickTime) {
        GlStateManager.func_179152_a((float)3.0f, (float)3.0f, (float)3.0f);
    }

    @Nullable
    protected ResourceLocation getEntityTexture(EntityEelShark entity) {
        switch (entity.getVisualStyle()) {
            case 0: {
                return new ResourceLocation("lostinfinity:textures/entity/sea/eelshark1.png");
            }
            case 1: {
                return new ResourceLocation("lostinfinity:textures/entity/sea/eelshark2.png");
            }
            case 2: {
                return new ResourceLocation("lostinfinity:textures/entity/sea/eelshark3.png");
            }
            case 3: {
                return new ResourceLocation("lostinfinity:textures/entity/sea/eelshark4.png");
            }
        }
        return new ResourceLocation("lostinfinity:textures/entity/sea/eelshark1.png");
    }
}

