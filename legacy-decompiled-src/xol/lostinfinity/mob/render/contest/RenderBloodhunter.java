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
package xol.lostinfinity.mob.render.contest;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.mob.entity.contest.EntityBloodhunter;
import xol.lostinfinity.mob.model.contest.ModelBloodhunter;

public class RenderBloodhunter
extends RenderLiving<EntityBloodhunter> {
    public static final ResourceLocation TEXTURES = new ResourceLocation("lostinfinity:textures/entity/bloodhunter.png");

    public RenderBloodhunter(RenderManager manager) {
        super(manager, (ModelBase)new ModelBloodhunter(), 0.5f);
    }

    protected void preRenderCallback(EntityBloodhunter entitylivingbaseIn, float partialTickTime) {
        GlStateManager.func_179152_a((float)1.75f, (float)1.75f, (float)1.75f);
    }

    protected ResourceLocation getEntityTexture(EntityBloodhunter entity) {
        return TEXTURES;
    }

    protected void applyRotations(EntityBloodhunter entityLiving, float p1, float rotationYaw, float partialTicks) {
        super.func_77043_a((LivingEntity)entityLiving, p1, rotationYaw, partialTicks);
    }
}

