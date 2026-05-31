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
package xol.lostinfinity.mob.render.misc;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.mob.entity.misc.EntityIonExplosion;
import xol.lostinfinity.mob.model.ModelMirrorZombie;

public class RenderIonExplosion
extends RenderLiving<EntityIonExplosion> {
    public RenderIonExplosion(RenderManager manager) {
        super(manager, (ModelBase)new ModelMirrorZombie(), 0.1f);
    }

    protected ResourceLocation getEntityTexture(EntityIonExplosion entity) {
        return null;
    }

    protected void applyRotations(EntityIonExplosion entityLiving, float p1, float rotationYaw, float partialTicks) {
        super.func_77043_a((LivingEntity)entityLiving, p1, rotationYaw, partialTicks);
    }
}

