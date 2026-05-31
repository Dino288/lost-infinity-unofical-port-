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
import xol.lostinfinity.mob.entity.misc.EntitySupplyTrader;
import xol.lostinfinity.mob.model.contest.ModelContestNPC;

public class RenderSupplyTrader
extends RenderLiving<EntitySupplyTrader> {
    public static final ResourceLocation TEXTURES = new ResourceLocation("lostinfinity:textures/entity/supply_trader.png");

    public RenderSupplyTrader(RenderManager manager) {
        super(manager, (ModelBase)new ModelContestNPC(), 1.0f);
    }

    protected void applyRotations(EntitySupplyTrader entityLiving, float p1, float rotationYaw, float partialTicks) {
        super.func_77043_a((LivingEntity)entityLiving, p1, rotationYaw, partialTicks);
    }

    protected ResourceLocation getEntityTexture(EntitySupplyTrader entity) {
        return TEXTURES;
    }
}

