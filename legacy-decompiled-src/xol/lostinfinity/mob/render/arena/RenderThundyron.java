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
package xol.lostinfinity.mob.render.arena;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import xol.lostinfinity.mob.entity.boss.EntityThundyron;
import xol.lostinfinity.mob.model.boss.ModelThundyron;

public class RenderThundyron
extends RenderLiving<EntityThundyron> {
    public static final ResourceLocation TEXTURES = new ResourceLocation("lostinfinity:textures/entity/thundyron.png");
    public static final ResourceLocation TEXTURES2 = new ResourceLocation("lostinfinity:textures/entity/thundyron2.png");
    public static final ResourceLocation TEXTURES3 = new ResourceLocation("lostinfinity:textures/entity/thundyron3.png");

    public RenderThundyron(RenderManager manager) {
        super(manager, (ModelBase)new ModelThundyron(), 0.5f);
    }

    protected void preRenderCallback(EntityThundyron entitylivingbaseIn, float partialTickTime) {
        GlStateManager.func_179152_a((float)4.0f, (float)4.0f, (float)4.0f);
    }

    protected ResourceLocation getEntityTexture(EntityThundyron entity) {
        int textureSwitch = Mth.func_76141_d((float)(entity.field_70173_aa % 15 / 5));
        switch (textureSwitch) {
            case 0: {
                return TEXTURES;
            }
            case 1: {
                return TEXTURES2;
            }
            case 2: {
                return TEXTURES3;
            }
        }
        return TEXTURES;
    }

    protected void applyRotations(EntityThundyron entityLiving, float p1, float rotationYaw, float partialTicks) {
        super.func_77043_a((LivingEntity)entityLiving, p1, rotationYaw, partialTicks);
    }
}

