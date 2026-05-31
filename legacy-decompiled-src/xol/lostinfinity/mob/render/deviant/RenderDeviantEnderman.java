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
import xol.lostinfinity.mob.entity.deviant.EntityDeviantEnderman;
import xol.lostinfinity.mob.model.deviant.ModelDeviantEnderman;

public class RenderDeviantEnderman
extends RenderLiving<EntityDeviantEnderman> {
    public static final ResourceLocation TEXTURES_NORMAL = new ResourceLocation("lostinfinity:textures/entity/deviant/deviantenderman.png");
    public static final ResourceLocation TEXTURES_SUPER_MUTATION_1 = new ResourceLocation("lostinfinity:textures/entity/deviant/super_deviantenderman_1.png");
    public static final ResourceLocation TEXTURES_SUPER_MUTATION_2 = new ResourceLocation("lostinfinity:textures/entity/deviant/super_deviantenderman_2.png");
    public static final ResourceLocation TEXTURES_SUPER_MUTATION_3 = new ResourceLocation("lostinfinity:textures/entity/deviant/super_deviantenderman_3.png");
    private float scale = 3.0f;

    public RenderDeviantEnderman(RenderManager manager) {
        super(manager, (ModelBase)new ModelDeviantEnderman(), 0.5f);
    }

    protected void preRenderCallback(EntityDeviantEnderman entitylivingbaseIn, float partialTickTime) {
        GlStateManager.func_179152_a((float)this.scale, (float)this.scale, (float)this.scale);
    }

    protected ResourceLocation getEntityTexture(EntityDeviantEnderman entity) {
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

    protected void applyRotations(EntityDeviantEnderman entityLiving, float p1, float rotationYaw, float partialTicks) {
        super.func_77043_a((LivingEntity)entityLiving, p1, rotationYaw, partialTicks);
    }
}

