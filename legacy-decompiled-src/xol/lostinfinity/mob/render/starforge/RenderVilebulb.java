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
import xol.lostinfinity.mob.entity.starforge.EntityVilebulb;
import xol.lostinfinity.mob.model.starforge.ModelVilebulb;

public class RenderVilebulb
extends RenderLiving<EntityVilebulb> {
    public static final ResourceLocation TEXTURES = new ResourceLocation("lostinfinity:textures/entity/starforge/vilebulb.png");
    public static final ResourceLocation TEXTURES_EXPLODING = new ResourceLocation("lostinfinity:textures/entity/starforge/vilebulb_exploding.png");

    public RenderVilebulb(RenderManager manager) {
        super(manager, (ModelBase)new ModelVilebulb(), 0.5f);
    }

    protected void preRenderCallback(EntityVilebulb entity, float partialTickTime) {
        GlStateManager.func_179152_a((float)0.5f, (float)0.5f, (float)0.5f);
    }

    protected ResourceLocation getEntityTexture(EntityVilebulb entity) {
        if (entity.isVolatile()) {
            if (entity.field_70173_aa % 4 < 2) {
                return TEXTURES;
            }
            return TEXTURES_EXPLODING;
        }
        return TEXTURES;
    }

    protected void applyRotations(EntityVilebulb entityLiving, float p1, float rotationYaw, float partialTicks) {
        super.func_77043_a((LivingEntity)entityLiving, p1, rotationYaw, partialTicks);
    }
}

