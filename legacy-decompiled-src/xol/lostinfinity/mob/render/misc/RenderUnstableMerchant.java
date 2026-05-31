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
import xol.lostinfinity.mob.entity.misc.EntityUnstableMerchant;
import xol.lostinfinity.mob.model.ModelUnstableMerchant;

public class RenderUnstableMerchant
extends RenderLiving<EntityUnstableMerchant> {
    public static final ResourceLocation TEXTURES = new ResourceLocation("lostinfinity:textures/entity/unstablemerchant.png");

    public RenderUnstableMerchant(RenderManager manager) {
        super(manager, (ModelBase)new ModelUnstableMerchant(), 0.5f);
    }

    protected ResourceLocation getEntityTexture(EntityUnstableMerchant entity) {
        return TEXTURES;
    }

    protected void applyRotations(EntityUnstableMerchant entityLiving, float p1, float rotationYaw, float partialTicks) {
        super.func_77043_a((LivingEntity)entityLiving, p1, rotationYaw, partialTicks);
    }
}

