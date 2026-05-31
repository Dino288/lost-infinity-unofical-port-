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
import xol.lostinfinity.mob.entity.misc.EntityTNTZombie;
import xol.lostinfinity.mob.model.ModelTNTZombie;

public class RenderTNTZombie
extends RenderLiving<EntityTNTZombie> {
    public static final ResourceLocation TEXTURES = new ResourceLocation("lostinfinity:textures/entity/tnt_zombie.png");

    public RenderTNTZombie(RenderManager manager) {
        super(manager, (ModelBase)new ModelTNTZombie(), 0.5f);
    }

    protected void preRenderCallback(EntityTNTZombie entity, float partialTickTime) {
        int ticks = entity.field_70173_aa;
        if (entity.field_70173_aa < 20) {
            GlStateManager.func_179152_a((float)((float)ticks * 0.05f), (float)((float)ticks * 0.05f), (float)((float)ticks * 0.05f));
        } else {
            GlStateManager.func_179152_a((float)1.0f, (float)1.0f, (float)1.0f);
        }
    }

    protected ResourceLocation getEntityTexture(EntityTNTZombie entity) {
        return TEXTURES;
    }

    protected void applyRotations(EntityTNTZombie entityLiving, float p1, float rotationYaw, float partialTicks) {
        super.func_77043_a((LivingEntity)entityLiving, p1, rotationYaw, partialTicks);
    }
}

