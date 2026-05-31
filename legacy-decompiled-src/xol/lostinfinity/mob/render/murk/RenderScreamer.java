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
package xol.lostinfinity.mob.render.murk;

import javax.annotation.Nullable;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.mob.entity.murk.EntityScreamer;
import xol.lostinfinity.mob.model.murk.ModelScreamer;

public class RenderScreamer
extends RenderLiving<EntityScreamer> {
    public static final ResourceLocation TEXTURES = new ResourceLocation("lostinfinity:textures/entity/murk/screamer.png");
    public static final ResourceLocation TEXTURES2 = new ResourceLocation("lostinfinity:textures/entity/murk/screamer_flash.png");

    public RenderScreamer(RenderManager rendermanagerIn) {
        super(rendermanagerIn, (ModelBase)new ModelScreamer(), 0.5f);
    }

    protected void preRenderCallback(EntityScreamer entity, float partialTickTime) {
        int ticks = entity.field_70173_aa;
        if (entity.field_70173_aa < 60) {
            GlStateManager.func_179152_a((float)((float)ticks * 0.05f), (float)((float)ticks * 0.05f), (float)((float)ticks * 0.05f));
        } else {
            GlStateManager.func_179152_a((float)3.0f, (float)3.0f, (float)3.0f);
        }
    }

    @Nullable
    protected ResourceLocation getEntityTexture(EntityScreamer entity) {
        if (entity.field_70173_aa < 40) {
            if (entity.field_70173_aa % 4 < 2) {
                return TEXTURES2;
            }
            return TEXTURES;
        }
        if (entity.field_70173_aa % 40 < 5) {
            return TEXTURES2;
        }
        return TEXTURES;
    }
}

