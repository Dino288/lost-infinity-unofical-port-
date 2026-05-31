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
import xol.lostinfinity.mob.entity.misc.EntityPickleMan;
import xol.lostinfinity.mob.model.ModelPickleMan;

public class RenderPickleMan
extends RenderLiving<EntityPickleMan> {
    public static final ResourceLocation TEXTURES = new ResourceLocation("lostinfinity:textures/entity/pickleman.png");

    public RenderPickleMan(RenderManager manager) {
        super(manager, (ModelBase)new ModelPickleMan(), 0.5f);
    }

    protected void preRenderCallback(EntityPickleMan entity, float partialTickTime) {
        int ticks = entity.field_70173_aa;
        if (entity.field_70173_aa < 20) {
            GlStateManager.func_179152_a((float)((float)ticks * 0.05f), (float)((float)ticks * 0.05f), (float)((float)ticks * 0.05f));
        } else {
            float pickleScale = entity.getMyStepScale();
            GlStateManager.func_179152_a((float)pickleScale, (float)pickleScale, (float)pickleScale);
        }
    }

    protected ResourceLocation getEntityTexture(EntityPickleMan entity) {
        return TEXTURES;
    }

    protected void applyRotations(EntityPickleMan entityLiving, float p1, float rotationYaw, float partialTicks) {
        super.func_77043_a((LivingEntity)entityLiving, p1, rotationYaw, partialTicks);
    }
}

