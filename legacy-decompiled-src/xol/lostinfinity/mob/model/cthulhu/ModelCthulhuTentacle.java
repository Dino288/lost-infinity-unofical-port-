/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBox
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.ResourceLocation
 */
package xol.lostinfinity.mob.model.cthulhu;

import net.minecraft.client.model.ModelBox;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.mob.model.cthulhu.AnimatedModelBase;
import xol.lostinfinity.util.animation.model.IXolModel;
import xol.lostinfinity.util.animation.model.ModelRenderer;

public class ModelCthulhuTentacle
extends AnimatedModelBase {
    private static final ResourceLocation ANIMATION = new ResourceLocation("lostinfinity", "animation/cthulhu/tentacle.json");
    private final ModelRenderer root;
    private final ModelRenderer root2;
    private final ModelRenderer root3;
    private final ModelRenderer root4;
    private final ModelRenderer portal;

    public ModelCthulhuTentacle() {
        this.field_78090_t = 256;
        this.field_78089_u = 256;
        this.root = new ModelRenderer(this);
        this.root.func_78793_a(0.0f, 24.0f, 0.0f);
        this.root.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.root, 0, 51, -11.0f, -27.0f, -6.0f, 22, 27, 12, 0.0f, false));
        this.root2 = new ModelRenderer(this);
        this.root2.func_78793_a(0.0f, -27.0f, -0.5f);
        this.root.func_78792_a(this.root2);
        this.root2.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.root2, 0, 0, -9.0f, -41.0f, -5.0f, 18, 41, 10, 0.0f, false));
        this.root3 = new ModelRenderer(this);
        this.root3.func_78793_a(0.0f, -41.0f, -0.5f);
        this.root2.func_78792_a(this.root3);
        this.root3.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.root3, 68, 60, -8.0f, -43.0f, -4.0f, 16, 43, 8, 0.0f, false));
        this.root4 = new ModelRenderer(this);
        this.root4.func_78793_a(0.0f, -43.0f, -0.5f);
        this.root3.func_78792_a(this.root4);
        this.root4.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.root4, 0, 90, -7.0f, -43.0f, -3.0f, 14, 43, 6, 0.0f, false));
        this.portal = new ModelRenderer(this);
        this.portal.func_78793_a(0.0f, 24.0f, 0.0f);
        this.portal.field_78804_l.add(new ModelBox((net.minecraft.client.model.ModelRenderer)this.portal, 0, 0, -30.0f, 0.0f, -30.0f, 60, 0, 60, 0.0f, false));
        IXolModel.initializeModel(this);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.animate(entity);
        this.root.func_78785_a(f5);
        this.portal.func_78785_a(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    @Override
    public ResourceLocation getAnimationJson() {
        return ANIMATION;
    }
}

