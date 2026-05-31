/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.block.model.ItemCameraTransforms$TransformType
 *  net.minecraft.client.renderer.entity.RenderLivingBase
 *  net.minecraft.client.renderer.entity.layers.LayerHeldItem
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.InteractionHandSide
 */
package xol.lostinfinity.mob.layer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.util.InteractionHandSide;

public class LayerHeldItemOffset
extends LayerHeldItem {
    public LayerHeldItemOffset(RenderLivingBase<?> livingEntityRendererIn) {
        super(livingEntityRendererIn);
    }

    public void func_177141_a(LivingEntity entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        ItemStack right;
        boolean flag = entitylivingbaseIn.func_184591_cq() == InteractionHandSide.RIGHT;
        ItemStack left = flag ? entitylivingbaseIn.func_184592_cb() : entitylivingbaseIn.func_184614_ca();
        ItemStack itemStack = right = flag ? entitylivingbaseIn.func_184614_ca() : entitylivingbaseIn.func_184592_cb();
        if (left.func_190926_b() && right.func_190926_b()) {
            return;
        }
        GlStateManager.func_179094_E();
        if (this.field_177206_a.func_177087_b().field_78091_s) {
            GlStateManager.func_179109_b((float)0.0f, (float)0.75f, (float)0.0f);
            GlStateManager.func_179152_a((float)0.5f, (float)0.5f, (float)0.5f);
        }
        this.renderHeldItem(entitylivingbaseIn, right, ItemCameraTransforms.TransformType.THIRD_PERSON_RIGHT_HAND, InteractionHandSide.RIGHT);
        this.renderHeldItem(entitylivingbaseIn, left, ItemCameraTransforms.TransformType.THIRD_PERSON_LEFT_HAND, InteractionHandSide.LEFT);
        GlStateManager.func_179121_F();
    }

    private void renderHeldItem(LivingEntity p_188358_1_, ItemStack p_188358_2_, ItemCameraTransforms.TransformType p_188358_3_, InteractionHandSide handSide) {
        if (!p_188358_2_.func_190926_b()) {
            GlStateManager.func_179094_E();
            if (p_188358_1_.func_70093_af()) {
                GlStateManager.func_179109_b((float)0.0f, (float)0.2f, (float)0.0f);
            }
            this.func_191361_a(handSide);
            GlStateManager.func_179114_b((float)-90.0f, (float)1.0f, (float)0.0f, (float)0.0f);
            GlStateManager.func_179114_b((float)180.0f, (float)0.0f, (float)1.0f, (float)0.0f);
            boolean flag = handSide == InteractionHandSide.LEFT;
            GlStateManager.func_179109_b((float)((float)(flag ? -1 : 1) / 16.0f), (float)0.125f, (float)-0.625f);
            this.offsetItem(p_188358_1_, p_188358_2_, p_188358_3_, handSide);
            Minecraft.func_71410_x().func_175597_ag().func_187462_a(p_188358_1_, p_188358_2_, p_188358_3_, flag);
            GlStateManager.func_179121_F();
        }
    }

    protected void offsetItem(LivingEntity entityLivingBase, ItemStack itemStack, ItemCameraTransforms.TransformType transformType, InteractionHandSide handSide) {
    }
}

