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
import xol.lostinfinity.mob.entity.starforge.EntityMinimite;
import xol.lostinfinity.mob.model.starforge.ModelMinimite;

public class RenderMinimite
extends RenderLiving<EntityMinimite> {
    public static final ResourceLocation TEXTURES = new ResourceLocation("lostinfinity:textures/entity/starforge/minimite.png");
    public static final ResourceLocation TEXTURES_ALTERNATE = new ResourceLocation("lostinfinity:textures/entity/starforge/minimite_charging.png");

    public RenderMinimite(RenderManager manager) {
        super(manager, (ModelBase)new ModelMinimite(), 0.5f);
    }

    protected void preRenderCallback(EntityMinimite entitylivingbaseIn, float partialTickTime) {
        float scale = entitylivingbaseIn.myScale();
        GlStateManager.func_179152_a((float)scale, (float)scale, (float)scale);
    }

    protected ResourceLocation getEntityTexture(EntityMinimite entity) {
        if (entity.isGrowing()) {
            if (entity.field_70173_aa % 6 <= 3) {
                return TEXTURES;
            }
            return TEXTURES_ALTERNATE;
        }
        return TEXTURES;
    }

    protected void applyRotations(EntityMinimite entityLiving, float p1, float rotationYaw, float partialTicks) {
        super.func_77043_a((LivingEntity)entityLiving, p1, rotationYaw, partialTicks);
    }
}

