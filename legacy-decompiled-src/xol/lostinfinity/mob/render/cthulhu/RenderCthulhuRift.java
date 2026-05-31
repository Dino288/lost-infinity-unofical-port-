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
package xol.lostinfinity.mob.render.cthulhu;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.mob.entity.cthulhu.EntityCthulhuRift;
import xol.lostinfinity.mob.model.ModelRift;

public class RenderCthulhuRift
extends RenderLiving<EntityCthulhuRift> {
    public static final ResourceLocation TEXTURES = new ResourceLocation("lostinfinity:textures/entity/rift/boss_rift1.png");
    public static final ResourceLocation TEXTURES2 = new ResourceLocation("lostinfinity:textures/entity/rift/boss_rift2.png");
    public static final ResourceLocation TEXTURES3 = new ResourceLocation("lostinfinity:textures/entity/rift/boss_rift3.png");

    public RenderCthulhuRift(RenderManager manager) {
        super(manager, (ModelBase)new ModelRift(), 0.5f);
    }

    protected void preRenderCallback(EntityCthulhuRift entitylivingbaseIn, float partialTickTime) {
        GlStateManager.func_179152_a((float)5.0f, (float)5.0f, (float)5.0f);
    }

    public boolean shouldRender(EntityCthulhuRift livingEntity, ICamera camera, double camX, double camY, double camZ) {
        return true;
    }

    protected ResourceLocation getEntityTexture(EntityCthulhuRift entity) {
        switch (entity.field_70173_aa % 15) {
            case 0: 
            case 2: 
            case 4: 
            case 6: {
                return TEXTURES2;
            }
            case 1: 
            case 5: {
                return TEXTURES3;
            }
            case 3: {
                return TEXTURES;
            }
        }
        return TEXTURES;
    }

    protected void applyRotations(EntityCthulhuRift entityLiving, float p1, float rotationYaw, float partialTicks) {
        super.func_77043_a((LivingEntity)entityLiving, p1, rotationYaw, partialTicks);
    }
}

