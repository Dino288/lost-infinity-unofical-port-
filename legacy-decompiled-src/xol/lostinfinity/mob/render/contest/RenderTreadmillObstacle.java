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
package xol.lostinfinity.mob.render.contest;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.mob.entity.contest.misc.EntityTreadmillObstacle;
import xol.lostinfinity.mob.model.contest.ModelTreadmillObstacle;

public class RenderTreadmillObstacle
extends RenderLiving<EntityTreadmillObstacle> {
    public static final ResourceLocation TEXTURES_1 = new ResourceLocation("lostinfinity:textures/entity/treadmill_obstacle_1.png");
    public static final ResourceLocation TEXTURES_2 = new ResourceLocation("lostinfinity:textures/entity/treadmill_obstacle_2.png");
    public static final ResourceLocation TEXTURES_3 = new ResourceLocation("lostinfinity:textures/entity/treadmill_obstacle_3.png");
    public static final ResourceLocation TEXTURES_4 = new ResourceLocation("lostinfinity:textures/entity/treadmill_obstacle_4.png");
    public static final ResourceLocation TEXTURES_5 = new ResourceLocation("lostinfinity:textures/entity/treadmill_obstacle_5.png");

    public RenderTreadmillObstacle(RenderManager manager) {
        super(manager, (ModelBase)new ModelTreadmillObstacle(), 1.0f);
    }

    protected void applyRotations(EntityTreadmillObstacle entityLiving, float p1, float rotationYaw, float partialTicks) {
        super.func_77043_a((LivingEntity)entityLiving, p1, rotationYaw, partialTicks);
    }

    protected ResourceLocation getEntityTexture(EntityTreadmillObstacle entity) {
        switch (entity.getVisual()) {
            case 0: {
                return TEXTURES_1;
            }
            case 1: {
                return TEXTURES_2;
            }
            case 2: {
                return TEXTURES_3;
            }
            case 3: {
                return TEXTURES_4;
            }
            case 4: {
                return TEXTURES_5;
            }
        }
        return TEXTURES_1;
    }
}

