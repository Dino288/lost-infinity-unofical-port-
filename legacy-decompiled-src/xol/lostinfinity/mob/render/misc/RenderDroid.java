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
package xol.lostinfinity.mob.render.misc;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.mob.entity.misc.EntityDroid;
import xol.lostinfinity.mob.model.ModelDroid;

public class RenderDroid
extends RenderLiving<EntityDroid> {
    public static final ResourceLocation TEXTURES_MK1_AGGRO = new ResourceLocation("lostinfinity:textures/entity/droid_mk1_aggressive.png");
    public static final ResourceLocation TEXTURES_MK1_REACT = new ResourceLocation("lostinfinity:textures/entity/droid_mk1_reactive.png");
    public static final ResourceLocation TEXTURES_MK2_AGGRO = new ResourceLocation("lostinfinity:textures/entity/droid_mk2_aggressive.png");
    public static final ResourceLocation TEXTURES_MK2_REACT = new ResourceLocation("lostinfinity:textures/entity/droid_mk2_reactive.png");
    public static final ResourceLocation TEXTURES_MK3_AGGRO = new ResourceLocation("lostinfinity:textures/entity/droid_mk3_aggressive.png");
    public static final ResourceLocation TEXTURES_MK3_REACT = new ResourceLocation("lostinfinity:textures/entity/droid_mk3_reactive.png");

    public RenderDroid(RenderManager manager) {
        super(manager, (ModelBase)new ModelDroid(), 0.5f);
    }

    protected ResourceLocation getEntityTexture(EntityDroid entity) {
        switch (entity.getGrade()) {
            case 0: {
                if (entity.isAggressive()) {
                    return TEXTURES_MK1_AGGRO;
                }
                return TEXTURES_MK1_REACT;
            }
            case 1: {
                if (entity.isAggressive()) {
                    return TEXTURES_MK2_AGGRO;
                }
                return TEXTURES_MK2_REACT;
            }
            case 2: {
                if (entity.isAggressive()) {
                    return TEXTURES_MK3_AGGRO;
                }
                return TEXTURES_MK3_REACT;
            }
        }
        if (entity.isAggressive()) {
            return TEXTURES_MK1_AGGRO;
        }
        return TEXTURES_MK1_REACT;
    }

    protected void applyRotations(EntityDroid entityLiving, float p1, float rotationYaw, float partialTicks) {
        super.func_77043_a((LivingEntity)entityLiving, p1, rotationYaw, partialTicks);
    }
}

