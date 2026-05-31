/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelBox
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.entity.Entity
 */
package xol.lostinfinity.mob.model.boss;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.world.entity.Entity;

public class ModelDeviantWither
extends ModelBase {
    private final ModelRenderer BackFinsL;
    private final ModelRenderer BackFinL4_r1;
    private final ModelRenderer BackFinL3_r1;
    private final ModelRenderer BackFinL2_r1;
    private final ModelRenderer BackFinL1_r1;
    private final ModelRenderer BackFinsR;
    private final ModelRenderer BackFinR4_r1;
    private final ModelRenderer BackFinR3_r1;
    private final ModelRenderer BackFinR2_r1;
    private final ModelRenderer BackFinR1_r1;
    private final ModelRenderer head1;
    private final ModelRenderer head2;
    private final ModelRenderer head3;
    private final ModelRenderer bb_main;
    private final ModelRenderer BackConnector_r1;
    private final ModelRenderer ConnectorFin2_r1;
    private final ModelRenderer ConnectorFin1_r1;
    private final ModelRenderer LowerBody_r1;

    public ModelDeviantWither() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.BackFinsL = new ModelRenderer((ModelBase)this);
        this.BackFinsL.func_78793_a(0.0f, 2.0f, 6.0f);
        this.BackFinL4_r1 = new ModelRenderer((ModelBase)this);
        this.BackFinL4_r1.func_78793_a(0.0f, 0.0f, 0.0f);
        this.BackFinsL.func_78792_a(this.BackFinL4_r1);
        this.setRotationAngle(this.BackFinL4_r1, 0.0f, 0.0f, 2.618f);
        this.BackFinL4_r1.field_78804_l.add(new ModelBox(this.BackFinL4_r1, 55, 35, -0.5f, -19.0f, 1.5f, 3, 18, 1, 0.0f, false));
        this.BackFinL3_r1 = new ModelRenderer((ModelBase)this);
        this.BackFinL3_r1.func_78793_a(0.0f, 0.0f, 0.0f);
        this.BackFinsL.func_78792_a(this.BackFinL3_r1);
        this.setRotationAngle(this.BackFinL3_r1, 0.0f, 0.0f, 2.0944f);
        this.BackFinL3_r1.field_78804_l.add(new ModelBox(this.BackFinL3_r1, 55, 35, 1.5f, -19.0f, -0.5f, 3, 18, 1, 0.0f, false));
        this.BackFinL2_r1 = new ModelRenderer((ModelBase)this);
        this.BackFinL2_r1.func_78793_a(0.0f, 0.0f, 0.0f);
        this.BackFinsL.func_78792_a(this.BackFinL2_r1);
        this.setRotationAngle(this.BackFinL2_r1, 0.0f, 0.0f, 1.2217f);
        this.BackFinL2_r1.field_78804_l.add(new ModelBox(this.BackFinL2_r1, 55, 35, 1.5f, -17.0f, 0.5f, 3, 18, 1, 0.0f, false));
        this.BackFinL1_r1 = new ModelRenderer((ModelBase)this);
        this.BackFinL1_r1.func_78793_a(0.0f, 0.0f, 0.0f);
        this.BackFinsL.func_78792_a(this.BackFinL1_r1);
        this.setRotationAngle(this.BackFinL1_r1, 0.0f, 0.0f, 0.5236f);
        this.BackFinL1_r1.field_78804_l.add(new ModelBox(this.BackFinL1_r1, 55, 35, 0.5f, -15.0f, -0.5f, 3, 18, 1, 0.0f, false));
        this.BackFinsR = new ModelRenderer((ModelBase)this);
        this.BackFinsR.func_78793_a(0.0f, 2.0f, 6.0f);
        this.BackFinR4_r1 = new ModelRenderer((ModelBase)this);
        this.BackFinR4_r1.func_78793_a(0.0f, 0.0f, 0.0f);
        this.BackFinsR.func_78792_a(this.BackFinR4_r1);
        this.setRotationAngle(this.BackFinR4_r1, 0.0f, 0.0f, -2.618f);
        this.BackFinR4_r1.field_78804_l.add(new ModelBox(this.BackFinR4_r1, 55, 35, -2.5f, -19.0f, 1.4f, 3, 18, 1, 0.0f, true));
        this.BackFinR3_r1 = new ModelRenderer((ModelBase)this);
        this.BackFinR3_r1.func_78793_a(0.0f, 0.0f, 0.0f);
        this.BackFinsR.func_78792_a(this.BackFinR3_r1);
        this.setRotationAngle(this.BackFinR3_r1, 0.0f, 0.0f, -2.0944f);
        this.BackFinR3_r1.field_78804_l.add(new ModelBox(this.BackFinR3_r1, 55, 35, -4.5f, -19.0f, -0.5f, 3, 18, 1, 0.0f, true));
        this.BackFinR2_r1 = new ModelRenderer((ModelBase)this);
        this.BackFinR2_r1.func_78793_a(0.0f, 0.0f, 0.0f);
        this.BackFinsR.func_78792_a(this.BackFinR2_r1);
        this.setRotationAngle(this.BackFinR2_r1, 0.0f, 0.0f, -1.2217f);
        this.BackFinR2_r1.field_78804_l.add(new ModelBox(this.BackFinR2_r1, 55, 35, -4.5f, -17.0f, 0.5f, 3, 18, 1, 0.0f, true));
        this.BackFinR1_r1 = new ModelRenderer((ModelBase)this);
        this.BackFinR1_r1.func_78793_a(0.0f, 0.0f, 0.0f);
        this.BackFinsR.func_78792_a(this.BackFinR1_r1);
        this.setRotationAngle(this.BackFinR1_r1, 0.0f, 0.0f, -0.5236f);
        this.BackFinR1_r1.field_78804_l.add(new ModelBox(this.BackFinR1_r1, 55, 35, -3.5f, -15.0f, -0.5f, 3, 18, 1, 0.0f, true));
        this.head1 = new ModelRenderer((ModelBase)this);
        this.head1.func_78793_a(0.0f, 1.0f, 0.0f);
        this.head1.field_78804_l.add(new ModelBox(this.head1, 0, 0, -4.0f, -4.0f, -4.0f, 8, 8, 8, 0.0f, false));
        this.head2 = new ModelRenderer((ModelBase)this);
        this.head2.func_78793_a(-10.0f, 2.0f, 1.0f);
        this.head2.field_78804_l.add(new ModelBox(this.head2, 0, 16, -4.0f, -4.0f, -4.0f, 8, 8, 8, 0.0f, false));
        this.head3 = new ModelRenderer((ModelBase)this);
        this.head3.func_78793_a(10.0f, 2.0f, 1.0f);
        this.head3.field_78804_l.add(new ModelBox(this.head3, 32, 0, -4.0f, -4.0f, -4.0f, 8, 8, 8, 0.0f, false));
        this.bb_main = new ModelRenderer((ModelBase)this);
        this.bb_main.func_78793_a(0.0f, 24.0f, 0.0f);
        this.bb_main.field_78804_l.add(new ModelBox(this.bb_main, 0, 34, -1.5f, -19.0f, -1.5f, 3, 14, 3, 0.0f, false));
        this.BackConnector_r1 = new ModelRenderer((ModelBase)this);
        this.BackConnector_r1.func_78793_a(0.0f, -10.0f, 0.0f);
        this.bb_main.func_78792_a(this.BackConnector_r1);
        this.setRotationAngle(this.BackConnector_r1, -0.7854f, 0.0f, 0.0f);
        this.BackConnector_r1.field_78804_l.add(new ModelBox(this.BackConnector_r1, 40, 35, -1.5f, -14.0f, -3.5f, 3, 12, 3, 0.25f, false));
        this.ConnectorFin2_r1 = new ModelRenderer((ModelBase)this);
        this.ConnectorFin2_r1.func_78793_a(0.0f, -14.0f, 0.0f);
        this.bb_main.func_78792_a(this.ConnectorFin2_r1);
        this.setRotationAngle(this.ConnectorFin2_r1, 0.0f, 0.0f, -0.6981f);
        this.ConnectorFin2_r1.field_78804_l.add(new ModelBox(this.ConnectorFin2_r1, 23, 33, -11.0f, -10.0f, 0.5f, 6, 14, 1, 0.0f, false));
        this.ConnectorFin2_r1.field_78804_l.add(new ModelBox(this.ConnectorFin2_r1, 13, 33, -5.0f, -10.0f, -1.0f, 2, 14, 2, 0.0f, false));
        this.ConnectorFin1_r1 = new ModelRenderer((ModelBase)this);
        this.ConnectorFin1_r1.func_78793_a(0.0f, -14.0f, 0.0f);
        this.bb_main.func_78792_a(this.ConnectorFin1_r1);
        this.setRotationAngle(this.ConnectorFin1_r1, 0.0f, 0.0f, 0.6981f);
        this.ConnectorFin1_r1.field_78804_l.add(new ModelBox(this.ConnectorFin1_r1, 23, 33, 5.0f, -10.0f, 0.5f, 6, 14, 1, 0.0f, true));
        this.ConnectorFin1_r1.field_78804_l.add(new ModelBox(this.ConnectorFin1_r1, 13, 33, 3.0f, -10.0f, -1.0f, 2, 14, 2, 0.0f, true));
        this.LowerBody_r1 = new ModelRenderer((ModelBase)this);
        this.LowerBody_r1.func_78793_a(0.0f, -5.0f, 0.0f);
        this.bb_main.func_78792_a(this.LowerBody_r1);
        this.setRotationAngle(this.LowerBody_r1, 0.4363f, 0.0f, 0.0f);
        this.LowerBody_r1.field_78804_l.add(new ModelBox(this.LowerBody_r1, 0, 53, -1.5f, -1.0f, -1.5f, 3, 6, 3, -0.25f, false));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.BackFinsL.func_78785_a(f5);
        this.BackFinsR.func_78785_a(f5);
        this.head1.func_78785_a(f5);
        this.head2.func_78785_a(f5);
        this.head3.func_78785_a(f5);
        this.bb_main.func_78785_a(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.head1.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.head1.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.head2.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.head2.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.head3.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.head3.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.LowerBody_r1.field_78795_f = (float)((double)0.3f + (double)0.3f * Math.sin(ageInTicks * 0.1f));
        this.BackFinR4_r1.field_78795_f = (float)((double)-0.3f + 0.5 * Math.sin(ageInTicks * 0.1f));
        this.BackFinR3_r1.field_78795_f = (float)((double)-0.3f + 0.5 * Math.sin((ageInTicks + 20.0f) * 0.1f));
        this.BackFinR2_r1.field_78795_f = (float)((double)-0.3f + 0.5 * Math.sin((ageInTicks + 40.0f) * 0.1f));
        this.BackFinR1_r1.field_78795_f = (float)((double)-0.3f + 0.5 * Math.sin((ageInTicks + 60.0f) * 0.1f));
        this.BackFinL1_r1.field_78795_f = (float)((double)-0.3f + 0.5 * Math.sin(ageInTicks * 0.1f));
        this.BackFinL2_r1.field_78795_f = (float)((double)-0.3f + 0.5 * Math.sin((ageInTicks + 20.0f) * 0.1f));
        this.BackFinL3_r1.field_78795_f = (float)((double)-0.3f + 0.5 * Math.sin((ageInTicks + 40.0f) * 0.1f));
        this.BackFinL4_r1.field_78795_f = (float)((double)-0.3f + 0.5 * Math.sin((ageInTicks + 60.0f) * 0.1f));
    }
}

