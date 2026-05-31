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
package xol.lostinfinity.mob.render.nebula;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.mob.entity.nebula.EntityNebulaGiant;
import xol.lostinfinity.mob.model.nebula.ModelNebulaGiant;

public class RenderNebulaGiant
extends RenderLiving<EntityNebulaGiant> {
    public static final ResourceLocation TEXTURES = new ResourceLocation("lostinfinity:textures/entity/nebula_giant.png");
    public static final ResourceLocation TEXTURES_ALTERNATE = new ResourceLocation("lostinfinity:textures/entity/nebula_giant_alternate.png");

    public RenderNebulaGiant(RenderManager manager) {
        super(manager, (ModelBase)new ModelNebulaGiant(), 0.0f);
    }

    protected void preRenderCallback(EntityNebulaGiant entitylivingbaseIn, float partialTickTime) {
        GlStateManager.func_179152_a((float)3.0f, (float)3.0f, (float)3.0f);
    }

    protected ResourceLocation getEntityTexture(EntityNebulaGiant entity) {
        if (entity.field_70173_aa % 4 < 2) {
            return TEXTURES_ALTERNATE;
        }
        return TEXTURES;
    }

    protected void applyRotations(EntityNebulaGiant entityLiving, float p1, float rotationYaw, float partialTicks) {
        super.func_77043_a((LivingEntity)entityLiving, p1, rotationYaw, partialTicks);
    }
}

