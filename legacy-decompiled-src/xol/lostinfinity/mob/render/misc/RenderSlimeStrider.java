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
package xol.lostinfinity.mob.render.misc;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import xol.lostinfinity.mob.entity.misc.EntitySlimeStrider;
import xol.lostinfinity.mob.model.ModelSlimeStrider;

public class RenderSlimeStrider
extends RenderLiving<EntitySlimeStrider> {
    public static final ResourceLocation TEXTURES = new ResourceLocation("lostinfinity:textures/entity/slimestrider.png");

    public RenderSlimeStrider(RenderManager manager) {
        super(manager, (ModelBase)new ModelSlimeStrider(), 0.5f);
    }

    protected void preRenderCallback(EntitySlimeStrider entitylivingbaseIn, float partialTickTime) {
        float scl = 1.8f + 0.5f * Mth.func_76126_a((float)((float)entitylivingbaseIn.field_70173_aa * 0.05f));
        GlStateManager.func_179152_a((float)scl, (float)scl, (float)scl);
    }

    protected ResourceLocation getEntityTexture(EntitySlimeStrider entity) {
        return TEXTURES;
    }

    protected void applyRotations(EntitySlimeStrider entityLiving, float p1, float rotationYaw, float partialTicks) {
        super.func_77043_a((LivingEntity)entityLiving, p1, rotationYaw, partialTicks);
    }
}

