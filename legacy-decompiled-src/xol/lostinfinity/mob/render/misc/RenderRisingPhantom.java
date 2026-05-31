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
package xol.lostinfinity.mob.render.misc;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.mob.entity.misc.EntityRisingPhantom;
import xol.lostinfinity.mob.model.ModelRisingPhantom;

public class RenderRisingPhantom
extends RenderLiving<EntityRisingPhantom> {
    public static final ResourceLocation TEXTURES = new ResourceLocation("lostinfinity:textures/entity/rising_phantom.png");

    public RenderRisingPhantom(RenderManager manager) {
        super(manager, (ModelBase)new ModelRisingPhantom(), 0.0f);
    }

    protected ResourceLocation getEntityTexture(EntityRisingPhantom entity) {
        return TEXTURES;
    }

    protected void applyRotations(EntityRisingPhantom entityLiving, float p1, float rotationYaw, float partialTicks) {
        super.func_77043_a((LivingEntity)entityLiving, p1, rotationYaw, partialTicks);
    }
}

