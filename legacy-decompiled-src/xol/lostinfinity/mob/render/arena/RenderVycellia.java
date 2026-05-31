/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.entity.RenderLiving
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.util.ResourceLocation
 */
package xol.lostinfinity.mob.render.arena;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.mob.entity.boss.EntityVycellia;
import xol.lostinfinity.mob.model.boss.ModelVycellia;

public class RenderVycellia
extends RenderLiving<EntityVycellia> {
    public static final ResourceLocation TEXTURES = new ResourceLocation("lostinfinity:textures/entity/vycellia.png");

    public RenderVycellia(RenderManager manager) {
        super(manager, (ModelBase)new ModelVycellia(), 0.5f);
    }

    protected void preRenderCallback(EntityVycellia vycellia, float partialTickTime) {
        if (vycellia.isEasy()) {
            GlStateManager.func_179152_a((float)2.0f, (float)2.0f, (float)2.0f);
        } else {
            float scale = vycellia.getFormScale();
            GlStateManager.func_179152_a((float)scale, (float)scale, (float)scale);
        }
    }

    protected ResourceLocation getEntityTexture(EntityVycellia entity) {
        return TEXTURES;
    }

    protected void applyRotations(EntityVycellia entityLiving, float p1, float rotationYaw, float partialTicks) {
        super.func_77043_a((LivingEntity)entityLiving, p1, rotationYaw, partialTicks);
    }
}

