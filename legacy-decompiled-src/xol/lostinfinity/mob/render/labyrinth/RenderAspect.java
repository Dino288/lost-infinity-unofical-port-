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
import xol.lostinfinity.mob.entity.labyrinth.EntityAspect;
import xol.lostinfinity.mob.model.labyrinth.ModelAspect;

public class RenderAspect
extends RenderLiving<EntityAspect> {
    public static final ResourceLocation TEXTURES_RED = new ResourceLocation("lostinfinity:textures/entity/labyrinth/aspect_red.png");
    public static final ResourceLocation TEXTURES_BLUE = new ResourceLocation("lostinfinity:textures/entity/labyrinth/aspect_blue.png");
    public static final ResourceLocation TEXTURES_YELLOW = new ResourceLocation("lostinfinity:textures/entity/labyrinth/aspect_yellow.png");
    public static final ResourceLocation TEXTURES_PURPLE = new ResourceLocation("lostinfinity:textures/entity/labyrinth/aspect_purple.png");

    public RenderAspect(RenderManager manager) {
        super(manager, (ModelBase)new ModelAspect(), 0.5f);
    }

    protected void preRenderCallback(EntityAspect entitylivingbaseIn, float partialTickTime) {
        GlStateManager.func_179152_a((float)1.5f, (float)1.5f, (float)1.5f);
    }

    protected ResourceLocation getEntityTexture(EntityAspect entity) {
        switch (entity.getStyle()) {
            case 0: {
                return TEXTURES_BLUE;
            }
            case 1: {
                return TEXTURES_YELLOW;
            }
            case 2: {
                return TEXTURES_PURPLE;
            }
        }
        return TEXTURES_RED;
    }

    protected void applyRotations(EntityAspect entityLiving, float p1, float rotationYaw, float partialTicks) {
        super.func_77043_a((LivingEntity)entityLiving, p1, rotationYaw, partialTicks);
    }
}

