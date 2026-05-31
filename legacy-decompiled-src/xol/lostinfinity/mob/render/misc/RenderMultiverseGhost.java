/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.renderer.block.model.ItemCameraTransforms$TransformType
 *  net.minecraft.client.renderer.entity.RenderLiving
 *  net.minecraft.client.renderer.entity.RenderLivingBase
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.client.renderer.entity.layers.LayerRenderer
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.InteractionHandSide
 *  net.minecraft.util.ResourceLocation
 */
package xol.lostinfinity.mob.render.misc;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.util.InteractionHandSide;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.mob.entity.misc.EntityMultiverseGhost;
import xol.lostinfinity.mob.layer.LayerHeldItemOffset;
import xol.lostinfinity.mob.model.ModelMultiverseGhost;

public class RenderMultiverseGhost
extends RenderLiving<EntityMultiverseGhost> {
    public RenderMultiverseGhost(RenderManager manager) {
        super(manager, (ModelBase)new ModelMultiverseGhost(), 0.5f);
        this.func_177094_a((LayerRenderer)new LayerHeldItemOffset((RenderLivingBase)this){

            @Override
            protected void offsetItem(LivingEntity entityLivingBase, ItemStack itemStack, ItemCameraTransforms.TransformType transformType, InteractionHandSide handSide) {
                EntityMultiverseGhost ghost = (EntityMultiverseGhost)entityLivingBase;
                ghost.getPose().offsetItem();
            }
        });
    }

    protected ResourceLocation getEntityTexture(EntityMultiverseGhost entity) {
        return entity.getSkinForMyCopy();
    }
}

