/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.renderer.entity.RenderLiving
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.util.ResourceLocation
 */
package xol.lostinfinity.mob.render.nebula;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.mob.entity.nebula.EntityNebulaWizard;
import xol.lostinfinity.mob.model.nebula.ModelNebulaWizard;

public class RenderNebulaWizard
extends RenderLiving<EntityNebulaWizard> {
    public static final ResourceLocation TEXTURES = new ResourceLocation("lostinfinity:textures/entity/nebula_wizard.png");

    public RenderNebulaWizard(RenderManager manager) {
        super(manager, (ModelBase)new ModelNebulaWizard(), 0.0f);
    }

    protected ResourceLocation getEntityTexture(EntityNebulaWizard entity) {
        return TEXTURES;
    }

    protected void applyRotations(EntityNebulaWizard entityLiving, float p1, float rotationYaw, float partialTicks) {
        super.func_77043_a((LivingEntity)entityLiving, p1, rotationYaw, partialTicks);
    }
}

