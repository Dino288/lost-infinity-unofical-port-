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
package xol.lostinfinity.mob.render.galaxy;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.mob.entity.galaxy.EntityGalaxySpire;
import xol.lostinfinity.mob.model.galaxy.ModelGalaxySpire;

public class RenderGalaxySpire
extends RenderLiving<EntityGalaxySpire> {
    public static final ResourceLocation TEXTURES = new ResourceLocation("lostinfinity:textures/entity/galaxyspire.png");

    public RenderGalaxySpire(RenderManager manager) {
        super(manager, (ModelBase)new ModelGalaxySpire(), 0.5f);
    }

    protected void preRenderCallback(EntityGalaxySpire entitylivingbaseIn, float partialTickTime) {
        GlStateManager.func_179152_a((float)3.0f, (float)3.0f, (float)3.0f);
    }

    protected ResourceLocation getEntityTexture(EntityGalaxySpire entity) {
        return TEXTURES;
    }

    protected void applyRotations(EntityGalaxySpire entityLiving, float p1, float rotationYaw, float partialTicks) {
        super.func_77043_a((LivingEntity)entityLiving, p1, rotationYaw, partialTicks);
    }
}

