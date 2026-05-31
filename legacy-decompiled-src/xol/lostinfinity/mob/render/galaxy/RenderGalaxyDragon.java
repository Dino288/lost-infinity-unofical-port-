/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.entity.RenderLiving
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.util.ResourceLocation
 */
package xol.lostinfinity.mob.render.galaxy;

import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.mob.entity.galaxy.EntityGalaxyDragon;
import xol.lostinfinity.mob.model.galaxy.ModelGalaxyDragon;

public class RenderGalaxyDragon
extends RenderLiving<EntityGalaxyDragon> {
    private static final ResourceLocation TEXTURES = new ResourceLocation("lostinfinity:textures/entity/galaxy_dragon.png");

    public RenderGalaxyDragon(RenderManager rendermanagerIn) {
        super(rendermanagerIn, (ModelBase)new ModelGalaxyDragon(), 1.5f);
    }

    @Nullable
    protected ResourceLocation getEntityTexture(EntityGalaxyDragon entity) {
        return TEXTURES;
    }

    protected void preRenderCallback(EntityGalaxyDragon entitylivingbaseIn, float partialTickTime) {
        if (Minecraft.func_71410_x().field_71474_y.field_74320_O == 0 && Minecraft.func_71410_x().field_71439_g.func_184208_bv() == entitylivingbaseIn) {
            GlStateManager.func_179152_a((float)0.5f, (float)0.4f, (float)0.4f);
        } else {
            GlStateManager.func_179152_a((float)1.0f, (float)1.0f, (float)1.0f);
        }
    }
}

