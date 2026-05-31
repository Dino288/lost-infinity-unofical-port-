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
package xol.lostinfinity.mob.render.prime;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.mob.entity.deviant.prime.EntityZenon;
import xol.lostinfinity.mob.model.boss.ModelZenon;

public class RenderZenon
extends RenderLiving<EntityZenon> {
    public static final ResourceLocation NORMAL = new ResourceLocation("lostinfinity:textures/entity/zenon.png");
    public static final ResourceLocation REFLECT = new ResourceLocation("lostinfinity:textures/entity/zenon_immune.png");

    public RenderZenon(RenderManager manager) {
        super(manager, (ModelBase)new ModelZenon(), 0.5f);
    }

    protected void preRenderCallback(EntityZenon entitylivingbaseIn, float partialTickTime) {
        GlStateManager.func_179152_a((float)1.5f, (float)1.5f, (float)1.5f);
    }

    protected ResourceLocation getEntityTexture(EntityZenon entity) {
        if (!entity.getReflect()) {
            return NORMAL;
        }
        return REFLECT;
    }

    protected void applyRotations(EntityZenon entityLiving, float p1, float rotationYaw, float partialTicks) {
        super.func_77043_a((LivingEntity)entityLiving, p1, rotationYaw, partialTicks);
    }
}

