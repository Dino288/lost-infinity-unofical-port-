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
package xol.lostinfinity.mob.render.starforge;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.mob.entity.starforge.EntityGorger;
import xol.lostinfinity.mob.model.starforge.ModelGorger;

public class RenderGorger
extends RenderLiving<EntityGorger> {
    public static final ResourceLocation TEXTURES = new ResourceLocation("lostinfinity:textures/entity/starforge/gorger.png");

    public RenderGorger(RenderManager manager) {
        super(manager, (ModelBase)new ModelGorger(), 0.5f);
    }

    protected void preRenderCallback(EntityGorger entity, float partialTickTime) {
        GlStateManager.func_179152_a((float)entity.getMyScale(), (float)entity.getMyScale(), (float)entity.getMyScale());
    }

    protected ResourceLocation getEntityTexture(EntityGorger entity) {
        return TEXTURES;
    }

    protected void applyRotations(EntityGorger entityLiving, float p1, float rotationYaw, float partialTicks) {
        super.func_77043_a((LivingEntity)entityLiving, p1, rotationYaw, partialTicks);
    }
}

