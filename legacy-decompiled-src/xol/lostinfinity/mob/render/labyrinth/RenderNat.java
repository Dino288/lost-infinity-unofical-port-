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
package xol.lostinfinity.mob.render.labyrinth;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.mob.entity.labyrinth.EntityNat;
import xol.lostinfinity.mob.model.labyrinth.ModelNat;

public class RenderNat
extends RenderLiving<EntityNat> {
    public static final ResourceLocation TEXTURES = new ResourceLocation("lostinfinity:textures/entity/labyrinth/nat.png");

    public RenderNat(RenderManager manager) {
        super(manager, (ModelBase)new ModelNat(), 0.5f);
    }

    protected void preRenderCallback(EntityNat entitylivingbaseIn, float partialTickTime) {
        GlStateManager.func_179152_a((float)0.5f, (float)0.5f, (float)0.5f);
    }

    protected ResourceLocation getEntityTexture(EntityNat entity) {
        return TEXTURES;
    }

    protected void applyRotations(EntityNat entityLiving, float p1, float rotationYaw, float partialTicks) {
        super.func_77043_a((LivingEntity)entityLiving, p1, rotationYaw, partialTicks);
    }
}

