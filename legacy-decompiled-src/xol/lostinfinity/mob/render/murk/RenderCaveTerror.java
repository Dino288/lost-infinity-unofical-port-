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
package xol.lostinfinity.mob.render.murk;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.mob.entity.murk.EntityCaveTerror;
import xol.lostinfinity.mob.model.murk.ModelCaveTerror;

public class RenderCaveTerror
extends RenderLiving<EntityCaveTerror> {
    public static final ResourceLocation TEXTURES = new ResourceLocation("lostinfinity:textures/entity/murk/caveterror.png");
    public static final ResourceLocation TEXTURES_GLOW = new ResourceLocation("lostinfinity:textures/entity/murk/caveterror_lit.png");

    public RenderCaveTerror(RenderManager manager) {
        super(manager, (ModelBase)new ModelCaveTerror(), 0.5f);
    }

    protected void preRenderCallback(EntityCaveTerror entitylivingbaseIn, float partialTickTime) {
        GlStateManager.func_179152_a((float)2.0f, (float)2.0f, (float)2.0f);
    }

    protected ResourceLocation getEntityTexture(EntityCaveTerror entity) {
        if (entity.field_70173_aa % 12 < 6) {
            return TEXTURES_GLOW;
        }
        return TEXTURES;
    }

    protected void applyRotations(EntityCaveTerror entityLiving, float p1, float rotationYaw, float partialTicks) {
        super.func_77043_a((LivingEntity)entityLiving, p1, rotationYaw, partialTicks);
    }
}

