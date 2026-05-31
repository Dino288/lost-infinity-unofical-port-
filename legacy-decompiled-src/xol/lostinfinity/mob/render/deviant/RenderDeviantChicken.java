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
package xol.lostinfinity.mob.render.deviant;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantChicken;
import xol.lostinfinity.mob.model.deviant.ModelDeviantChicken;

public class RenderDeviantChicken
extends RenderLiving<EntityDeviantChicken> {
    public static final ResourceLocation TEXTURES_NORMAL = new ResourceLocation("lostinfinity:textures/entity/deviant/deviantchicken.png");
    public static final ResourceLocation TEXTURES_SUPER_MUTATION_1 = new ResourceLocation("lostinfinity:textures/entity/deviant/super_deviantchicken_1.png");
    public static final ResourceLocation TEXTURES_SUPER_MUTATION_2 = new ResourceLocation("lostinfinity:textures/entity/deviant/super_deviantchicken_2.png");
    public static final ResourceLocation TEXTURES_SUPER_MUTATION_3 = new ResourceLocation("lostinfinity:textures/entity/deviant/super_deviantchicken_3.png");
    private float scale = 2.0f;

    public RenderDeviantChicken(RenderManager manager) {
        super(manager, (ModelBase)new ModelDeviantChicken(), 0.5f);
    }

    protected void preRenderCallback(EntityDeviantChicken entitylivingbaseIn, float partialTickTime) {
        GlStateManager.func_179152_a((float)this.scale, (float)this.scale, (float)this.scale);
    }

    protected ResourceLocation getEntityTexture(EntityDeviantChicken entity) {
        switch (entity.getMutation()) {
            case 1: {
                return TEXTURES_SUPER_MUTATION_1;
            }
            case 2: {
                return TEXTURES_SUPER_MUTATION_2;
            }
            case 3: {
                return TEXTURES_SUPER_MUTATION_3;
            }
        }
        return TEXTURES_NORMAL;
    }

    protected void applyRotations(EntityDeviantChicken entityLiving, float p1, float rotationYaw, float partialTicks) {
        super.func_77043_a((LivingEntity)entityLiving, p1, rotationYaw, partialTicks);
    }
}

