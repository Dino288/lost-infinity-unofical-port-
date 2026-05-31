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
package xol.lostinfinity.mob.render.titan;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.mob.entity.deviant.titan.EntityTitanSpider;
import xol.lostinfinity.mob.model.deviant.ModelDeviantSpider;

public class RenderTitanSpider
extends RenderLiving<EntityTitanSpider> {
    public static final ResourceLocation TEXTURES = new ResourceLocation("lostinfinity:textures/entity/titan/deviantspider_titan.png");
    private float scale = 4.0f;

    public RenderTitanSpider(RenderManager manager) {
        super(manager, (ModelBase)new ModelDeviantSpider(), 0.5f);
    }

    protected void preRenderCallback(EntityTitanSpider entitylivingbaseIn, float partialTickTime) {
        GlStateManager.func_179152_a((float)this.scale, (float)this.scale, (float)this.scale);
    }

    protected ResourceLocation getEntityTexture(EntityTitanSpider entity) {
        return TEXTURES;
    }

    protected void applyRotations(EntityTitanSpider entityLiving, float p1, float rotationYaw, float partialTicks) {
        super.func_77043_a((LivingEntity)entityLiving, p1, rotationYaw, partialTicks);
    }
}

