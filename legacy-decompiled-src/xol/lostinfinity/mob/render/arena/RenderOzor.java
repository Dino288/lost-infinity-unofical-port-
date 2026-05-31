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
import xol.lostinfinity.mob.entity.boss.EntityOzor;
import xol.lostinfinity.mob.model.boss.ModelOzor;

public class RenderOzor
extends RenderLiving<EntityOzor> {
    public static final ResourceLocation TEXTURES = new ResourceLocation("lostinfinity:textures/entity/ozor.png");

    public RenderOzor(RenderManager manager) {
        super(manager, (ModelBase)new ModelOzor(), 0.5f);
    }

    protected void preRenderCallback(EntityOzor entitylivingbaseIn, float partialTickTime) {
        GlStateManager.func_179152_a((float)5.0f, (float)5.0f, (float)5.0f);
    }

    protected ResourceLocation getEntityTexture(EntityOzor entity) {
        return TEXTURES;
    }

    protected void applyRotations(EntityOzor entityLiving, float p1, float rotationYaw, float partialTicks) {
        super.func_77043_a((LivingEntity)entityLiving, p1, rotationYaw, partialTicks);
    }
}

