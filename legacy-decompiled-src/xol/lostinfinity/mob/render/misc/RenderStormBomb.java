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
package xol.lostinfinity.mob.render.misc;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.mob.entity.misc.EntityStormBomb;
import xol.lostinfinity.mob.model.ModelSpecialBomb;

public class RenderStormBomb
extends RenderLiving<EntityStormBomb> {
    public static final ResourceLocation TEXTURES = new ResourceLocation("lostinfinity:textures/entity/storm_bomb.png");

    public RenderStormBomb(RenderManager manager) {
        super(manager, (ModelBase)new ModelSpecialBomb(), 0.25f);
    }

    protected void preRenderCallback(EntityStormBomb entitylivingbaseIn, float partialTickTime) {
        if (entitylivingbaseIn.field_70173_aa >= 40) {
            GlStateManager.func_179152_a((float)1.5f, (float)1.5f, (float)1.5f);
        } else {
            float scl = 0.0375f * (float)entitylivingbaseIn.field_70173_aa;
            GlStateManager.func_179152_a((float)scl, (float)scl, (float)scl);
        }
    }

    protected ResourceLocation getEntityTexture(EntityStormBomb entity) {
        return TEXTURES;
    }

    protected void applyRotations(EntityStormBomb entityLiving, float p1, float rotationYaw, float partialTicks) {
        super.func_77043_a((LivingEntity)entityLiving, p1, rotationYaw, partialTicks);
    }
}

