/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.entity.RenderLiving
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.util.ResourceLocation
 */
package xol.lostinfinity.mob.render.deviant;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantHusk;
import xol.lostinfinity.mob.model.deviant.ModelDeviantHusk;

public class RenderDeviantHusk
extends RenderLiving<EntityDeviantHusk> {
    public static final ResourceLocation TEXTURES_NORMAL = new ResourceLocation("lostinfinity:textures/entity/deviant/devianthusk.png");
    public static final ResourceLocation TEXTURES_SUPER_MUTATION_1 = new ResourceLocation("lostinfinity:textures/entity/deviant/super_devianthusk_1.png");
    public static final ResourceLocation TEXTURES_SUPER_MUTATION_2 = new ResourceLocation("lostinfinity:textures/entity/deviant/super_devianthusk_2.png");
    public static final ResourceLocation TEXTURES_SUPER_MUTATION_3 = new ResourceLocation("lostinfinity:textures/entity/deviant/super_devianthusk_3.png");

    public RenderDeviantHusk(RenderManager rendermanagerIn) {
        super(rendermanagerIn, (ModelBase)new ModelDeviantHusk(), 1.0f);
    }

    protected void preRenderCallback(EntityDeviantHusk entitylivingbaseIn, float partialTickTime) {
        GlStateManager.func_179152_a((float)2.0f, (float)2.0f, (float)2.0f);
    }

    protected ResourceLocation getEntityTexture(EntityDeviantHusk entity) {
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
}

