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
import xol.lostinfinity.mob.entity.deviant.EntityDeviantWolf;
import xol.lostinfinity.mob.model.deviant.ModelDeviantWolf;

public class RenderDeviantWolf
extends RenderLiving<EntityDeviantWolf> {
    public static final ResourceLocation TEXTURES_NORMAL = new ResourceLocation("lostinfinity:textures/entity/deviant/deviantwolf.png");
    public static final ResourceLocation TEXTURES_SUPER_MUTATION_1 = new ResourceLocation("lostinfinity:textures/entity/deviant/super_deviantwolf_1.png");
    public static final ResourceLocation TEXTURES_SUPER_MUTATION_2 = new ResourceLocation("lostinfinity:textures/entity/deviant/super_deviantwolf_2.png");
    public static final ResourceLocation TEXTURES_SUPER_MUTATION_3 = new ResourceLocation("lostinfinity:textures/entity/deviant/super_deviantwolf_3.png");

    public RenderDeviantWolf(RenderManager rendermanagerIn) {
        super(rendermanagerIn, (ModelBase)new ModelDeviantWolf(), 1.0f);
    }

    protected void preRenderCallback(EntityDeviantWolf entitylivingbaseIn, float partialTickTime) {
        GlStateManager.func_179152_a((float)2.0f, (float)2.0f, (float)2.0f);
    }

    protected ResourceLocation getEntityTexture(EntityDeviantWolf entity) {
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

