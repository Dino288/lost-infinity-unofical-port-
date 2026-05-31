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
package xol.lostinfinity.mob.render.fungal;

import javax.annotation.Nullable;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.mob.entity.fungal.EntityFungfly;
import xol.lostinfinity.mob.model.fungal.ModelFungfly;

public class RenderFungfly
extends RenderLiving<EntityFungfly> {
    public static final ResourceLocation TEXTURES_R = new ResourceLocation("lostinfinity:textures/entity/fungal/fungfly_red.png");
    public static final ResourceLocation TEXTURES_G = new ResourceLocation("lostinfinity:textures/entity/fungal/fungfly_green.png");
    public static final ResourceLocation TEXTURES_B = new ResourceLocation("lostinfinity:textures/entity/fungal/fungfly_blue.png");
    public static final ResourceLocation TEXTURES_Y = new ResourceLocation("lostinfinity:textures/entity/fungal/fungfly_yellow.png");
    public static final ResourceLocation TEXTURES_P = new ResourceLocation("lostinfinity:textures/entity/fungal/fungfly_purple.png");

    public RenderFungfly(RenderManager rendermanagerIn) {
        super(rendermanagerIn, (ModelBase)new ModelFungfly(), 0.0f);
    }

    protected void preRenderCallback(EntityFungfly entitylivingbaseIn, float partialTickTime) {
        GlStateManager.func_179152_a((float)0.3f, (float)0.3f, (float)0.3f);
    }

    @Nullable
    protected ResourceLocation getEntityTexture(EntityFungfly entity) {
        switch (entity.getVisual()) {
            case 0: {
                return TEXTURES_R;
            }
            case 1: {
                return TEXTURES_G;
            }
            case 2: {
                return TEXTURES_B;
            }
            case 3: {
                return TEXTURES_Y;
            }
            case 4: {
                return TEXTURES_P;
            }
        }
        return TEXTURES_R;
    }
}

