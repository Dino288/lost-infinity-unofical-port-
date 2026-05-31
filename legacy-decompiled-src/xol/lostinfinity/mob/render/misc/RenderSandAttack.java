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
package xol.lostinfinity.mob.render.misc;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.mob.entity.misc.EntitySandAttack;
import xol.lostinfinity.mob.model.ModelSandAttack;

public class RenderSandAttack
extends RenderLiving<EntitySandAttack> {
    public static final ResourceLocation TEXTURES = new ResourceLocation("lostinfinity:textures/entity/sand_attack.png");

    public RenderSandAttack(RenderManager manager) {
        super(manager, (ModelBase)new ModelSandAttack(), 0.5f);
    }

    protected void preRenderCallback(EntitySandAttack sa, float partialTickTime) {
        GlStateManager.func_179152_a((float)sa.getCubeSize(), (float)sa.getCubeSize(), (float)sa.getCubeSize());
    }

    protected ResourceLocation getEntityTexture(EntitySandAttack entity) {
        return TEXTURES;
    }
}

