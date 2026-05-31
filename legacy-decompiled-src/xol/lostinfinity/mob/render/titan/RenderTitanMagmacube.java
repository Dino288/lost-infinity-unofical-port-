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
 *  net.minecraft.util.math.Mth
 */
package xol.lostinfinity.mob.render.titan;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import xol.lostinfinity.mob.entity.deviant.titan.EntityTitanMagmacube;
import xol.lostinfinity.mob.model.deviant.ModelDeviantMagmacube;

public class RenderTitanMagmacube
extends RenderLiving<EntityTitanMagmacube> {
    public static final ResourceLocation TEXTURES = new ResourceLocation("lostinfinity:textures/entity/titan/deviantmagmacube_titan.png");

    public RenderTitanMagmacube(RenderManager manager) {
        super(manager, (ModelBase)new ModelDeviantMagmacube(), 0.5f);
    }

    protected void preRenderCallback(EntityTitanMagmacube entitylivingbaseIn, float partialTickTime) {
        float scl = 5.5f + Mth.func_76126_a((float)((float)entitylivingbaseIn.field_70173_aa * 0.1f));
        GlStateManager.func_179152_a((float)scl, (float)scl, (float)scl);
    }

    protected ResourceLocation getEntityTexture(EntityTitanMagmacube entity) {
        return TEXTURES;
    }

    protected void applyRotations(EntityTitanMagmacube entityLiving, float p1, float rotationYaw, float partialTicks) {
        super.func_77043_a((LivingEntity)entityLiving, p1, rotationYaw, partialTicks);
    }
}

