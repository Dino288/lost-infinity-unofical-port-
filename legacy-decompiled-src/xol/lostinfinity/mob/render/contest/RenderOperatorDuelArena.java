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
package xol.lostinfinity.mob.render.contest;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.mob.entity.contest.operator.EntityOperatorDuelArena;
import xol.lostinfinity.mob.model.contest.ModelContestNPC;

public class RenderOperatorDuelArena
extends RenderLiving<EntityOperatorDuelArena> {
    public static final ResourceLocation TEXTURES = new ResourceLocation("lostinfinity:textures/entity/contest_npc_operator.png");

    public RenderOperatorDuelArena(RenderManager manager) {
        super(manager, (ModelBase)new ModelContestNPC(), 1.0f);
    }

    protected void applyRotations(EntityOperatorDuelArena entityLiving, float p1, float rotationYaw, float partialTicks) {
        super.func_77043_a((LivingEntity)entityLiving, p1, rotationYaw, partialTicks);
    }

    protected ResourceLocation getEntityTexture(EntityOperatorDuelArena entity) {
        return TEXTURES;
    }
}

