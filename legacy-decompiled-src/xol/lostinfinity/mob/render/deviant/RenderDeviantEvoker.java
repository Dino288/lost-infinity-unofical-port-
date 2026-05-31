/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.entity.RenderLiving
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.entity.Mob
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.util.ResourceLocation
 */
package xol.lostinfinity.mob.render.deviant;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantEvoker;
import xol.lostinfinity.mob.model.deviant.ModelDeviantEvoker;

public class RenderDeviantEvoker
extends RenderLiving<EntityDeviantEvoker> {
    private float scale = 2.0f;

    public RenderDeviantEvoker(RenderManager manager) {
        super(manager, (ModelBase)new ModelDeviantEvoker(), 0.5f);
    }

    protected void preRenderCallback(EntityDeviantEvoker entitylivingbaseIn, float partialTickTime) {
        GlStateManager.func_179152_a((float)this.scale, (float)this.scale, (float)this.scale);
    }

    protected ResourceLocation getEntityTexture(EntityDeviantEvoker entity) {
        return entity.getCurTexture();
    }

    public void doRender(EntityDeviantEvoker entity, double x, double y, double z, float entityYaw, float partialTicks) {
        this.field_77045_g = entity.getCurModel();
        super.func_76986_a((Mob)entity, x, y, z, entityYaw, partialTicks);
    }

    protected void applyRotations(EntityDeviantEvoker entityLiving, float p1, float rotationYaw, float partialTicks) {
        super.func_77043_a((LivingEntity)entityLiving, p1, rotationYaw, partialTicks);
    }
}

