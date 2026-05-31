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
package xol.lostinfinity.mob.render.starforge;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.mob.entity.starforge.EntityFlashfly;
import xol.lostinfinity.mob.model.starforge.ModelFlashfly;

public class RenderFlashfly
extends RenderLiving<EntityFlashfly> {
    public static final ResourceLocation TEXTURES = new ResourceLocation("lostinfinity:textures/entity/starforge/flashfly.png");
    public static final ResourceLocation TEXTURES_LIT = new ResourceLocation("lostinfinity:textures/entity/starforge/flashfly_lit.png");

    public RenderFlashfly(RenderManager manager) {
        super(manager, (ModelBase)new ModelFlashfly(), 0.5f);
    }

    protected ResourceLocation getEntityTexture(EntityFlashfly entity) {
        if (entity.field_70173_aa % 40 <= 2) {
            return TEXTURES_LIT;
        }
        return TEXTURES;
    }

    protected void applyRotations(EntityFlashfly entityLiving, float p1, float rotationYaw, float partialTicks) {
        super.func_77043_a((LivingEntity)entityLiving, p1, rotationYaw, partialTicks);
    }
}

