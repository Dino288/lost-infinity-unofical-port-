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
package xol.lostinfinity.mob.render.galaxy;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.mob.entity.galaxy.EntityGalaxySorcerer;
import xol.lostinfinity.mob.model.galaxy.ModelGalaxySorcerer;

public class RenderGalaxySorcerer
extends RenderLiving<EntityGalaxySorcerer> {
    public static final ResourceLocation TEXTURE_BLUE = new ResourceLocation("lostinfinity:textures/entity/galaxysorcerer_blue.png");
    public static final ResourceLocation TEXTURE_GREEN = new ResourceLocation("lostinfinity:textures/entity/galaxysorcerer_green.png");
    public static final ResourceLocation TEXTURE_YELLOW = new ResourceLocation("lostinfinity:textures/entity/galaxysorcerer_yellow.png");
    public static final ResourceLocation TEXTURE_PURPLE = new ResourceLocation("lostinfinity:textures/entity/galaxysorcerer_purple.png");
    private float scale = 2.0f;

    public RenderGalaxySorcerer(RenderManager manager) {
        super(manager, (ModelBase)new ModelGalaxySorcerer(), 0.5f);
    }

    protected void preRenderCallback(EntityGalaxySorcerer entitylivingbaseIn, float partialTickTime) {
        GlStateManager.func_179152_a((float)this.scale, (float)this.scale, (float)this.scale);
    }

    protected ResourceLocation getEntityTexture(EntityGalaxySorcerer entity) {
        switch (entity.getColor()) {
            case 1: {
                return TEXTURE_BLUE;
            }
            case 2: {
                return TEXTURE_GREEN;
            }
            case 3: {
                return TEXTURE_YELLOW;
            }
            case 4: {
                return TEXTURE_PURPLE;
            }
        }
        return TEXTURE_BLUE;
    }

    protected void applyRotations(EntityGalaxySorcerer entityLiving, float p1, float rotationYaw, float partialTicks) {
        super.func_77043_a((LivingEntity)entityLiving, p1, rotationYaw, partialTicks);
    }
}

