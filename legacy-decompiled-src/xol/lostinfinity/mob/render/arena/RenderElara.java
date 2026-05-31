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
import xol.lostinfinity.mob.entity.boss.EntityElara;
import xol.lostinfinity.mob.model.boss.ModelElara;

public class RenderElara
extends RenderLiving<EntityElara> {
    public static final ResourceLocation TEXTURES_SIREN = new ResourceLocation("lostinfinity:textures/entity/elarasiren.png");
    public static final ResourceLocation TEXTURES_BOUNDLESS = new ResourceLocation("lostinfinity:textures/entity/elaraboundless.png");
    private float scale = 3.0f;

    public RenderElara(RenderManager manager) {
        super(manager, (ModelBase)new ModelElara(), 0.5f);
    }

    protected void preRenderCallback(EntityElara entitylivingbaseIn, float partialTickTime) {
        GlStateManager.func_179152_a((float)this.scale, (float)this.scale, (float)this.scale);
    }

    protected ResourceLocation getEntityTexture(EntityElara entity) {
        switch (entity.getForm()) {
            case 0: {
                return TEXTURES_SIREN;
            }
            case 1: {
                return TEXTURES_BOUNDLESS;
            }
        }
        return TEXTURES_SIREN;
    }

    protected void applyRotations(EntityElara entityLiving, float p1, float rotationYaw, float partialTicks) {
        super.func_77043_a((LivingEntity)entityLiving, p1, rotationYaw, partialTicks);
    }
}

