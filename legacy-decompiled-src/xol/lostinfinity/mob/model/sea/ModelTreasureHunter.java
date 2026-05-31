/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelBox
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.Mth
 */
package xol.lostinfinity.mob.model.sea;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;

public class ModelTreasureHunter
extends ModelBase {
    private final ModelRenderer root;
    private final ModelRenderer head;
    private final ModelRenderer armr;
    private final ModelRenderer arml;
    private final ModelRenderer legl;
    private final ModelRenderer bodytop;
    private final ModelRenderer coat;
    private final ModelRenderer legr;

    public ModelTreasureHunter() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.root = new ModelRenderer((ModelBase)this);
        this.root.func_78793_a(0.0f, 0.0f, 0.0f);
        this.head = new ModelRenderer((ModelBase)this);
        this.head.func_78793_a(0.0f, 0.0f, 0.0f);
        this.root.func_78792_a(this.head);
        this.head.field_78804_l.add(new ModelBox(this.head, 0, 0, -4.0f, -8.0f, -4.0f, 8, 8, 8, 0.0f, false));
        this.head.field_78804_l.add(new ModelBox(this.head, 25, 0, -5.0f, -6.0f, -5.0f, 10, 3, 1, 0.0f, false));
        this.head.field_78804_l.add(new ModelBox(this.head, 36, 9, -5.0f, -5.0f, -4.0f, 1, 1, 6, 0.0f, false));
        this.head.field_78804_l.add(new ModelBox(this.head, 36, 9, 4.0f, -5.0f, -4.0f, 1, 1, 6, 0.0f, false));
        this.head.field_78804_l.add(new ModelBox(this.head, 2, 17, -3.0f, -3.0f, -5.0f, 6, 3, 1, 0.0f, false));
        this.head.field_78804_l.add(new ModelBox(this.head, 14, 22, 3.0f, -2.0f, -5.0f, 2, 1, 1, 0.0f, false));
        this.head.field_78804_l.add(new ModelBox(this.head, 45, 19, -1.0f, -2.0f, 4.0f, 6, 1, 1, 0.0f, false));
        this.head.field_78804_l.add(new ModelBox(this.head, 40, 20, -1.0f, -1.0f, 3.0f, 1, 2, 2, 0.0f, false));
        this.head.field_78804_l.add(new ModelBox(this.head, 25, 9, 4.0f, -2.0f, -4.0f, 1, 1, 8, 0.0f, false));
        this.armr = new ModelRenderer((ModelBase)this);
        this.armr.func_78793_a(0.0f, 3.0f, 0.0f);
        this.root.func_78792_a(this.armr);
        this.armr.field_78804_l.add(new ModelBox(this.armr, 44, 22, 4.0f, -2.0f, -2.0f, 4, 12, 4, 0.0f, true));
        this.arml = new ModelRenderer((ModelBase)this);
        this.arml.func_78793_a(0.0f, 3.0f, 0.0f);
        this.root.func_78792_a(this.arml);
        this.arml.field_78804_l.add(new ModelBox(this.arml, 44, 22, -8.0f, -2.0f, -2.0f, 4, 12, 4, 0.0f, false));
        this.legl = new ModelRenderer((ModelBase)this);
        this.legl.func_78793_a(-2.0f, 12.0f, 0.0f);
        this.root.func_78792_a(this.legl);
        this.legl.field_78804_l.add(new ModelBox(this.legl, 0, 22, -2.0f, 0.0f, -2.0f, 4, 12, 4, 0.0f, true));
        this.bodytop = new ModelRenderer((ModelBase)this);
        this.bodytop.func_78793_a(0.0f, 0.0f, 0.0f);
        this.root.func_78792_a(this.bodytop);
        this.bodytop.field_78804_l.add(new ModelBox(this.bodytop, 16, 20, -4.0f, 0.0f, -3.0f, 8, 12, 6, -0.1f, false));
        this.coat = new ModelRenderer((ModelBase)this);
        this.coat.func_78793_a(0.0f, 0.0f, 0.0f);
        this.root.func_78792_a(this.coat);
        this.coat.field_78804_l.add(new ModelBox(this.coat, 0, 38, -4.0f, 0.0f, -3.0f, 8, 18, 6, 0.2f, false));
        this.coat.field_78804_l.add(new ModelBox(this.coat, 29, 39, 0.0f, 0.5f, 3.0f, 3, 10, 3, -0.1f, false));
        this.coat.field_78804_l.add(new ModelBox(this.coat, 29, 39, -3.0f, 0.5f, 3.0f, 3, 10, 3, -0.1f, false));
        this.legr = new ModelRenderer((ModelBase)this);
        this.legr.func_78793_a(2.0f, 12.0f, 0.0f);
        this.root.func_78792_a(this.legr);
        this.legr.field_78804_l.add(new ModelBox(this.legr, 0, 22, -2.0f, 0.0f, -2.0f, 4, 12, 4, 0.0f, false));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.root.func_78785_a(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.head.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.head.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.legr.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 1.4f * limbSwingAmount * 0.5f;
        this.legl.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 1.4f * limbSwingAmount * 0.5f;
        this.armr.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 2.0f * limbSwingAmount * 0.5f;
        this.arml.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 2.0f * limbSwingAmount * 0.5f;
    }
}

