/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.culling.ICamera
 *  net.minecraft.client.renderer.entity.RenderLiving
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.util.ResourceLocation
 */
package xol.lostinfinity.mob.render.misc;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.mob.entity.misc.EntityRift;
import xol.lostinfinity.mob.model.ModelRift;

public class RenderRift
extends RenderLiving<EntityRift> {
    public static final ResourceLocation TEXTURES = new ResourceLocation("lostinfinity:textures/entity/rift/rift1.png");
    public static final ResourceLocation TEXTURES2 = new ResourceLocation("lostinfinity:textures/entity/rift/rift2.png");
    public static final ResourceLocation TEXTURES3 = new ResourceLocation("lostinfinity:textures/entity/rift/rift3.png");

    public RenderRift(RenderManager manager) {
        super(manager, (ModelBase)new ModelRift(), 0.5f);
    }

    protected void preRenderCallback(EntityRift entitylivingbaseIn, float partialTickTime) {
        GlStateManager.func_179152_a((float)5.0f, (float)5.0f, (float)5.0f);
    }

    public boolean shouldRender(EntityRift livingEntity, ICamera camera, double camX, double camY, double camZ) {
        return true;
    }

    protected ResourceLocation getEntityTexture(EntityRift entity) {
        switch (entity.field_70173_aa % 15) {
            case 0: {
                return TEXTURES2;
            }
            case 1: {
                return TEXTURES3;
            }
            case 2: {
                return TEXTURES2;
            }
            case 3: {
                return TEXTURES;
            }
            case 4: {
                return TEXTURES2;
            }
            case 5: {
                return TEXTURES3;
            }
            case 6: {
                return TEXTURES2;
            }
        }
        return TEXTURES;
    }

    protected void applyRotations(EntityRift entityLiving, float p1, float rotationYaw, float partialTicks) {
        super.func_77043_a((LivingEntity)entityLiving, p1, rotationYaw, partialTicks);
    }
}

