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
package xol.lostinfinity.mob.render.starforge;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.mob.entity.starforge.EntityGravhead;
import xol.lostinfinity.mob.model.starforge.ModelGravhead;

public class RenderGravhead
extends RenderLiving<EntityGravhead> {
    public static final ResourceLocation TEXTURES = new ResourceLocation("lostinfinity:textures/entity/starforge/gravhead.png");
    public static final ResourceLocation TEXTURES_RED = new ResourceLocation("lostinfinity:textures/entity/starforge/gravhead_pulling.png");

    public RenderGravhead(RenderManager manager) {
        super(manager, (ModelBase)new ModelGravhead(), 0.5f);
    }

    protected ResourceLocation getEntityTexture(EntityGravhead entity) {
        if (entity.field_70173_aa % 100 < 30) {
            return TEXTURES_RED;
        }
        return TEXTURES;
    }

    protected void applyRotations(EntityGravhead entityLiving, float p1, float rotationYaw, float partialTicks) {
        super.func_77043_a((LivingEntity)entityLiving, p1, rotationYaw, partialTicks);
    }
}

