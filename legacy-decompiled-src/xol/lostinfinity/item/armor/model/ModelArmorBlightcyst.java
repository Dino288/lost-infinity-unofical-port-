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
package xol.lostinfinity.item.armor.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import xol.lostinfinity.item.armor.model.ModelLostArmor;

public class ModelArmorBlightcyst
extends ModelLostArmor {
    private final ModelRenderer HeadTentacle8;
    private final ModelRenderer HeadTentacle1;
    private final ModelRenderer HeadTentacle2;
    private final ModelRenderer HeadTentacle3;
    private final ModelRenderer HeadTentacle4;
    private final ModelRenderer HeadTentacle5;
    private final ModelRenderer HeadTentacle6;
    private final ModelRenderer HeadTentacle10;
    private final ModelRenderer HeadTentacle11;
    private final ModelRenderer HeadTentacle7;
    private final ModelRenderer HeadTentacle9;
    private final ModelRenderer Horn;
    private final ModelRenderer HatLayer_r1;
    private final ModelRenderer HatLayer_r2;
    private final ModelRenderer CageL;
    private final ModelRenderer BodyTent3;
    private final ModelRenderer BodyTent2;
    private final ModelRenderer BodyTent1;
    private final ModelRenderer CageR;
    private final ModelRenderer BodyTent6;
    private final ModelRenderer BodyTent5;
    private final ModelRenderer BodyTent4;
    private final ModelRenderer Tentacle1;
    private final ModelRenderer Tentacle2;
    private final ModelRenderer Tentacle3;
    private final ModelRenderer LeftArmLayer_r1;
    private final ModelRenderer LeftArmLayer_r2;
    private final ModelRenderer LeftArmLayer_r3;
    private final ModelRenderer LeftArmLayer_r4;

    public ModelArmorBlightcyst() {
        this.field_78090_t = 128;
        this.field_78089_u = 64;
        this.field_78116_c.field_78804_l.add(new ModelBox(this.field_78116_c, 88, 8, 3.0f, -4.0f, -5.0f, 3, 3, 10, -0.8f, false));
        this.field_78116_c.field_78804_l.add(new ModelBox(this.field_78116_c, 88, 8, 3.0f, -2.0f, -5.0f, 3, 3, 10, -0.8f, false));
        this.field_78116_c.field_78804_l.add(new ModelBox(this.field_78116_c, 88, 8, 3.0f, -7.0f, -5.0f, 3, 3, 10, -0.8f, false));
        this.field_78116_c.field_78804_l.add(new ModelBox(this.field_78116_c, 88, 8, 3.0f, -9.0f, -5.0f, 3, 3, 10, -0.8f, false));
        this.field_78116_c.field_78804_l.add(new ModelBox(this.field_78116_c, 64, 0, 1.0f, -8.0f, -4.0f, 3, 8, 8, 0.6f, false));
        this.HeadTentacle8 = new ModelRenderer((ModelBase)this);
        this.HeadTentacle8.func_78793_a(4.5f, -0.5f, -4.5f);
        this.field_78116_c.func_78792_a(this.HeadTentacle8);
        this.HeadTentacle8.field_78804_l.add(new ModelBox(this.HeadTentacle8, 79, 1, -7.5f, -1.5f, -1.5f, 9, 3, 3, -0.75f, false));
        this.HeadTentacle1 = new ModelRenderer((ModelBase)this);
        this.HeadTentacle1.func_78793_a(4.5f, -7.5f, -4.5f);
        this.field_78116_c.func_78792_a(this.HeadTentacle1);
        this.HeadTentacle1.field_78804_l.add(new ModelBox(this.HeadTentacle1, 79, 1, -7.5f, -1.5f, -1.5f, 9, 3, 3, -0.75f, false));
        this.HeadTentacle2 = new ModelRenderer((ModelBase)this);
        this.HeadTentacle2.func_78793_a(4.5f, -5.5f, 4.5f);
        this.field_78116_c.func_78792_a(this.HeadTentacle2);
        this.HeadTentacle2.field_78804_l.add(new ModelBox(this.HeadTentacle2, 79, 1, -7.5f, -1.5f, -1.5f, 9, 3, 3, -0.75f, false));
        this.HeadTentacle3 = new ModelRenderer((ModelBase)this);
        this.HeadTentacle3.func_78793_a(4.5f, -0.5f, 4.5f);
        this.field_78116_c.func_78792_a(this.HeadTentacle3);
        this.HeadTentacle3.field_78804_l.add(new ModelBox(this.HeadTentacle3, 79, 1, -7.5f, -1.5f, -1.5f, 9, 3, 3, -0.75f, false));
        this.HeadTentacle4 = new ModelRenderer((ModelBase)this);
        this.HeadTentacle4.func_78793_a(4.5f, -2.5f, 4.5f);
        this.field_78116_c.func_78792_a(this.HeadTentacle4);
        this.HeadTentacle4.field_78804_l.add(new ModelBox(this.HeadTentacle4, 104, 1, -6.5f, -1.5f, -1.5f, 8, 3, 3, -0.75f, false));
        this.HeadTentacle5 = new ModelRenderer((ModelBase)this);
        this.HeadTentacle5.func_78793_a(4.5f, -7.5f, 4.5f);
        this.field_78116_c.func_78792_a(this.HeadTentacle5);
        this.HeadTentacle5.field_78804_l.add(new ModelBox(this.HeadTentacle5, 104, 1, -6.5f, -1.5f, -1.5f, 8, 3, 3, -0.75f, false));
        this.HeadTentacle6 = new ModelRenderer((ModelBase)this);
        this.HeadTentacle6.func_78793_a(4.5f, -2.5f, -4.5f);
        this.field_78116_c.func_78792_a(this.HeadTentacle6);
        this.HeadTentacle6.field_78804_l.add(new ModelBox(this.HeadTentacle6, 104, 1, -6.5f, -1.5f, -1.5f, 8, 3, 3, -0.75f, false));
        this.HeadTentacle10 = new ModelRenderer((ModelBase)this);
        this.HeadTentacle10.func_78793_a(4.5f, -8.5f, 0.0f);
        this.field_78116_c.func_78792_a(this.HeadTentacle10);
        this.HeadTentacle10.field_78804_l.add(new ModelBox(this.HeadTentacle10, 104, 1, -6.5f, -1.5f, -1.5f, 8, 3, 3, -0.75f, false));
        this.HeadTentacle11 = new ModelRenderer((ModelBase)this);
        this.HeadTentacle11.func_78793_a(4.5f, -8.5f, 2.5f);
        this.field_78116_c.func_78792_a(this.HeadTentacle11);
        this.HeadTentacle11.field_78804_l.add(new ModelBox(this.HeadTentacle11, 104, 1, -6.5f, -1.5f, -1.5f, 8, 3, 3, -0.75f, false));
        this.HeadTentacle7 = new ModelRenderer((ModelBase)this);
        this.HeadTentacle7.func_78793_a(4.5f, -5.5f, -4.5f);
        this.field_78116_c.func_78792_a(this.HeadTentacle7);
        this.HeadTentacle7.field_78804_l.add(new ModelBox(this.HeadTentacle7, 106, 8, -5.5f, -1.5f, -1.5f, 7, 3, 3, -0.75f, false));
        this.HeadTentacle9 = new ModelRenderer((ModelBase)this);
        this.HeadTentacle9.func_78793_a(4.5f, -8.5f, -2.5f);
        this.field_78116_c.func_78792_a(this.HeadTentacle9);
        this.HeadTentacle9.field_78804_l.add(new ModelBox(this.HeadTentacle9, 106, 8, -5.5f, -1.5f, -1.5f, 7, 3, 3, -0.75f, false));
        this.Horn = new ModelRenderer((ModelBase)this);
        this.Horn.func_78793_a(8.0f, -10.0f, -1.0f);
        this.field_78116_c.func_78792_a(this.Horn);
        this.HatLayer_r1 = new ModelRenderer((ModelBase)this);
        this.HatLayer_r1.func_78793_a(0.0f, 0.0f, 0.0f);
        this.Horn.func_78792_a(this.HatLayer_r1);
        this.setRotationAngle(this.HatLayer_r1, 0.0f, 0.0f, -0.9599f);
        this.HatLayer_r1.field_78804_l.add(new ModelBox(this.HatLayer_r1, 82, 22, -7.0f, -3.0f, -2.0f, 8, 4, 4, -0.6f, false));
        this.HatLayer_r2 = new ModelRenderer((ModelBase)this);
        this.HatLayer_r2.func_78793_a(0.0f, 0.0f, 0.0f);
        this.Horn.func_78792_a(this.HatLayer_r2);
        this.setRotationAngle(this.HatLayer_r2, 0.0f, 0.0f, -0.4363f);
        this.HatLayer_r2.field_78804_l.add(new ModelBox(this.HatLayer_r2, 65, 18, -2.0f, -8.0f, -2.0f, 4, 10, 4, -0.5f, false));
        this.HatLayer_r2.field_78804_l.add(new ModelBox(this.HatLayer_r2, 116, 16, -5.0f, -8.0f, -0.5f, 4, 10, 2, -0.5f, false));
        this.field_78115_e.field_78804_l.add(new ModelBox(this.field_78115_e, 16, 32, -4.0f, 0.0f, -2.0f, 8, 12, 4, 0.25f, false));
        this.field_78115_e.field_78804_l.add(new ModelBox(this.field_78115_e, 86, 44, 1.0f, -2.0f, 0.0f, 4, 14, 4, -0.5f, false));
        this.field_78115_e.field_78804_l.add(new ModelBox(this.field_78115_e, 86, 44, -5.0f, -2.0f, 0.0f, 4, 14, 4, -0.5f, false));
        this.CageL = new ModelRenderer((ModelBase)this);
        this.CageL.func_78793_a(0.0f, 24.0f, 0.0f);
        this.field_78115_e.func_78792_a(this.CageL);
        this.CageL.field_78804_l.add(new ModelBox(this.CageL, 88, 31, -0.5f, -14.0f, -4.0f, 6, 3, 3, -0.5f, false));
        this.CageL.field_78804_l.add(new ModelBox(this.CageL, 88, 31, -0.5f, -16.3f, -4.0f, 6, 3, 3, -0.5f, false));
        this.CageL.field_78804_l.add(new ModelBox(this.CageL, 88, 31, -0.5f, -25.0f, -4.0f, 6, 3, 3, -0.5f, false));
        this.CageL.field_78804_l.add(new ModelBox(this.CageL, 112, 34, 2.5f, -25.0f, -2.0f, 3, 3, 5, -0.5f, false));
        this.CageL.field_78804_l.add(new ModelBox(this.CageL, 112, 34, 2.5f, -23.0f, -2.0f, 3, 3, 5, -0.5f, false));
        this.CageL.field_78804_l.add(new ModelBox(this.CageL, 112, 34, 2.5f, -21.0f, -2.0f, 3, 3, 5, -0.5f, false));
        this.CageL.field_78804_l.add(new ModelBox(this.CageL, 112, 34, 2.5f, -18.5f, -2.0f, 3, 3, 5, -0.5f, false));
        this.CageL.field_78804_l.add(new ModelBox(this.CageL, 112, 34, 2.5f, -16.3f, -2.0f, 3, 3, 5, -0.5f, false));
        this.CageL.field_78804_l.add(new ModelBox(this.CageL, 112, 34, 2.5f, -14.0f, -2.0f, 3, 3, 5, -0.5f, false));
        this.BodyTent3 = new ModelRenderer((ModelBase)this);
        this.BodyTent3.func_78793_a(4.5f, -17.0f, -2.5f);
        this.CageL.func_78792_a(this.BodyTent3);
        this.BodyTent3.field_78804_l.add(new ModelBox(this.BodyTent3, 90, 14, -4.2f, -0.5f, -0.5f, 2, 1, 1, 0.0f, false));
        this.BodyTent3.field_78804_l.add(new ModelBox(this.BodyTent3, 103, 28, -4.0f, -1.5f, -1.5f, 5, 3, 3, -0.5f, false));
        this.BodyTent2 = new ModelRenderer((ModelBase)this);
        this.BodyTent2.func_78793_a(4.5f, -19.5f, -2.5f);
        this.CageL.func_78792_a(this.BodyTent2);
        this.BodyTent2.field_78804_l.add(new ModelBox(this.BodyTent2, 90, 14, -4.2f, -0.5f, -0.5f, 2, 1, 1, 0.0f, false));
        this.BodyTent2.field_78804_l.add(new ModelBox(this.BodyTent2, 87, 38, -3.0f, -1.5f, -1.5f, 4, 3, 3, -0.5f, false));
        this.BodyTent1 = new ModelRenderer((ModelBase)this);
        this.BodyTent1.func_78793_a(4.5f, -21.5f, -2.5f);
        this.CageL.func_78792_a(this.BodyTent1);
        this.BodyTent1.field_78804_l.add(new ModelBox(this.BodyTent1, 90, 14, -4.2f, -0.5f, -0.5f, 2, 1, 1, 0.0f, false));
        this.BodyTent1.field_78804_l.add(new ModelBox(this.BodyTent1, 103, 28, -4.0f, -1.5f, -1.5f, 5, 3, 3, -0.5f, false));
        this.CageR = new ModelRenderer((ModelBase)this);
        this.CageR.func_78793_a(0.0f, 24.0f, 0.0f);
        this.field_78115_e.func_78792_a(this.CageR);
        this.CageR.field_78804_l.add(new ModelBox(this.CageR, 88, 31, -5.5f, -14.0f, -4.0f, 6, 3, 3, -0.5f, true));
        this.CageR.field_78804_l.add(new ModelBox(this.CageR, 88, 31, -5.5f, -16.3f, -4.0f, 6, 3, 3, -0.5f, true));
        this.CageR.field_78804_l.add(new ModelBox(this.CageR, 88, 31, -5.5f, -25.0f, -4.0f, 6, 3, 3, -0.5f, true));
        this.CageR.field_78804_l.add(new ModelBox(this.CageR, 112, 34, -5.5f, -25.0f, -2.0f, 3, 3, 5, -0.5f, true));
        this.CageR.field_78804_l.add(new ModelBox(this.CageR, 112, 34, -5.5f, -23.0f, -2.0f, 3, 3, 5, -0.5f, true));
        this.CageR.field_78804_l.add(new ModelBox(this.CageR, 112, 34, -5.5f, -21.0f, -2.0f, 3, 3, 5, -0.5f, true));
        this.CageR.field_78804_l.add(new ModelBox(this.CageR, 112, 34, -5.5f, -18.5f, -2.0f, 3, 3, 5, -0.5f, true));
        this.CageR.field_78804_l.add(new ModelBox(this.CageR, 112, 34, -5.5f, -16.3f, -2.0f, 3, 3, 5, -0.5f, true));
        this.CageR.field_78804_l.add(new ModelBox(this.CageR, 112, 34, -5.5f, -14.0f, -2.0f, 3, 3, 5, -0.5f, true));
        this.BodyTent6 = new ModelRenderer((ModelBase)this);
        this.BodyTent6.func_78793_a(-4.5f, -17.0f, -2.5f);
        this.CageR.func_78792_a(this.BodyTent6);
        this.BodyTent6.field_78804_l.add(new ModelBox(this.BodyTent6, 90, 14, 2.2f, -0.5f, -0.5f, 2, 1, 1, 0.0f, true));
        this.BodyTent6.field_78804_l.add(new ModelBox(this.BodyTent6, 103, 28, -1.0f, -1.5f, -1.5f, 5, 3, 3, -0.5f, true));
        this.BodyTent5 = new ModelRenderer((ModelBase)this);
        this.BodyTent5.func_78793_a(-4.5f, -19.5f, -2.5f);
        this.CageR.func_78792_a(this.BodyTent5);
        this.BodyTent5.field_78804_l.add(new ModelBox(this.BodyTent5, 90, 14, 2.2f, -0.5f, -0.5f, 2, 1, 1, 0.0f, true));
        this.BodyTent5.field_78804_l.add(new ModelBox(this.BodyTent5, 72, 47, -1.0f, -1.5f, -1.5f, 4, 3, 3, -0.5f, true));
        this.BodyTent4 = new ModelRenderer((ModelBase)this);
        this.BodyTent4.func_78793_a(-4.5f, -21.5f, -2.5f);
        this.CageR.func_78792_a(this.BodyTent4);
        this.BodyTent4.field_78804_l.add(new ModelBox(this.BodyTent4, 90, 14, 2.2f, -0.5f, -0.5f, 2, 1, 1, 0.0f, true));
        this.BodyTent4.field_78804_l.add(new ModelBox(this.BodyTent4, 103, 28, -1.0f, -1.5f, -1.5f, 5, 3, 3, -0.5f, true));
        this.Tentacle1 = new ModelRenderer((ModelBase)this);
        this.Tentacle1.func_78793_a(3.0f, 1.0f, 2.0f);
        this.field_78115_e.func_78792_a(this.Tentacle1);
        this.Tentacle1.field_78804_l.add(new ModelBox(this.Tentacle1, 104, 42, -3.0f, -3.0f, -3.0f, 6, 16, 6, -2.0f, false));
        this.Tentacle2 = new ModelRenderer((ModelBase)this);
        this.Tentacle2.func_78793_a(-3.0f, 1.0f, 2.0f);
        this.field_78115_e.func_78792_a(this.Tentacle2);
        this.Tentacle2.field_78804_l.add(new ModelBox(this.Tentacle2, 104, 42, -3.0f, -3.0f, -3.0f, 6, 16, 6, -2.0f, false));
        this.Tentacle3 = new ModelRenderer((ModelBase)this);
        this.Tentacle3.func_78793_a(0.0f, 5.0f, 2.0f);
        this.field_78115_e.func_78792_a(this.Tentacle3);
        this.Tentacle3.field_78804_l.add(new ModelBox(this.Tentacle3, 104, 42, -3.0f, -3.0f, -3.0f, 6, 16, 6, -2.0f, false));
        this.field_178723_h.field_78804_l.add(new ModelBox(this.field_178723_h, 41, 41, -5.0f, -2.0f, -2.0f, 6, 3, 4, 0.5f, true));
        this.field_178723_h.field_78804_l.add(new ModelBox(this.field_178723_h, 42, 38, -5.0f, -3.0f, -2.0f, 6, 1, 1, 0.0f, false));
        this.field_178723_h.field_78804_l.add(new ModelBox(this.field_178723_h, 42, 38, -5.0f, -3.0f, 1.0f, 6, 1, 1, 0.0f, false));
        this.field_178723_h.field_78804_l.add(new ModelBox(this.field_178723_h, 40, 49, -3.0f, 1.0f, -2.0f, 2, 9, 4, 0.25f, true));
        this.field_178723_h.field_78804_l.add(new ModelBox(this.field_178723_h, 53, 50, -5.0f, 2.0f, -4.0f, 6, 3, 3, -0.25f, true));
        this.field_178723_h.field_78804_l.add(new ModelBox(this.field_178723_h, 53, 57, -5.0f, 2.0f, -2.0f, 2, 3, 4, -0.3f, true));
        this.field_178723_h.field_78804_l.add(new ModelBox(this.field_178723_h, 53, 57, -5.0f, 6.0f, -2.0f, 2, 3, 4, -0.3f, true));
        this.field_178723_h.field_78804_l.add(new ModelBox(this.field_178723_h, 53, 50, -5.0f, 2.0f, 1.0f, 6, 3, 3, -0.25f, true));
        this.field_178723_h.field_78804_l.add(new ModelBox(this.field_178723_h, 53, 50, -5.0f, 6.0f, 1.0f, 6, 3, 3, -0.25f, true));
        this.field_178723_h.field_78804_l.add(new ModelBox(this.field_178723_h, 53, 50, -5.0f, 6.0f, -4.0f, 6, 3, 3, -0.25f, true));
        this.field_178724_i.field_78804_l.add(new ModelBox(this.field_178724_i, 57, 33, -1.0f, -2.0f, -2.0f, 4, 3, 4, 0.5f, false));
        this.field_178724_i.field_78804_l.add(new ModelBox(this.field_178724_i, 40, 49, 1.0f, 1.0f, -2.0f, 2, 9, 4, 0.25f, false));
        this.field_178724_i.field_78804_l.add(new ModelBox(this.field_178724_i, 53, 50, -1.0f, 2.0f, -4.0f, 6, 3, 3, -0.25f, false));
        this.field_178724_i.field_78804_l.add(new ModelBox(this.field_178724_i, 53, 57, 3.0f, 2.0f, -2.0f, 2, 3, 4, -0.3f, false));
        this.field_178724_i.field_78804_l.add(new ModelBox(this.field_178724_i, 53, 57, 3.0f, 6.0f, -2.0f, 2, 3, 4, -0.3f, false));
        this.field_178724_i.field_78804_l.add(new ModelBox(this.field_178724_i, 53, 50, -1.0f, 2.0f, 1.0f, 6, 3, 3, -0.25f, false));
        this.field_178724_i.field_78804_l.add(new ModelBox(this.field_178724_i, 53, 50, -1.0f, 6.0f, 1.0f, 6, 3, 3, -0.25f, false));
        this.field_178724_i.field_78804_l.add(new ModelBox(this.field_178724_i, 53, 50, -1.0f, 6.0f, -4.0f, 6, 3, 3, -0.25f, false));
        this.LeftArmLayer_r1 = new ModelRenderer((ModelBase)this);
        this.LeftArmLayer_r1.func_78793_a(1.0f, -4.5f, 3.0f);
        this.field_178724_i.func_78792_a(this.LeftArmLayer_r1);
        this.setRotationAngle(this.LeftArmLayer_r1, 0.0f, 0.0f, 0.4363f);
        this.LeftArmLayer_r1.field_78804_l.add(new ModelBox(this.LeftArmLayer_r1, 75, 33, 0.0f, -4.5f, -3.0f, 3, 7, 3, -0.5f, false));
        this.LeftArmLayer_r1.field_78804_l.add(new ModelBox(this.LeftArmLayer_r1, 75, 33, 0.0f, -4.5f, -6.0f, 3, 7, 3, -0.5f, false));
        this.LeftArmLayer_r2 = new ModelRenderer((ModelBase)this);
        this.LeftArmLayer_r2.func_78793_a(1.0f, -4.5f, 3.0f);
        this.field_178724_i.func_78792_a(this.LeftArmLayer_r2);
        this.setRotationAngle(this.LeftArmLayer_r2, 0.0f, 0.0f, 0.1745f);
        this.LeftArmLayer_r2.field_78804_l.add(new ModelBox(this.LeftArmLayer_r2, 62, 41, 1.0f, -6.5f, -3.0f, 3, 4, 3, -0.6f, false));
        this.LeftArmLayer_r2.field_78804_l.add(new ModelBox(this.LeftArmLayer_r2, 62, 41, 1.0f, -6.5f, -6.0f, 3, 4, 3, -0.6f, false));
        this.LeftArmLayer_r3 = new ModelRenderer((ModelBase)this);
        this.LeftArmLayer_r3.func_78793_a(4.0f, -2.5f, 3.0f);
        this.field_178724_i.func_78792_a(this.LeftArmLayer_r3);
        this.setRotationAngle(this.LeftArmLayer_r3, 0.0f, 0.0f, 0.6109f);
        this.LeftArmLayer_r3.field_78804_l.add(new ModelBox(this.LeftArmLayer_r3, 75, 33, 0.0f, -4.5f, -3.0f, 3, 7, 3, -0.5f, false));
        this.LeftArmLayer_r3.field_78804_l.add(new ModelBox(this.LeftArmLayer_r3, 75, 33, 0.0f, -4.5f, -6.0f, 3, 7, 3, -0.5f, false));
        this.LeftArmLayer_r3.field_78804_l.add(new ModelBox(this.LeftArmLayer_r3, 66, 57, -3.0f, 1.5f, -6.0f, 6, 1, 6, 0.3f, false));
        this.LeftArmLayer_r4 = new ModelRenderer((ModelBase)this);
        this.LeftArmLayer_r4.func_78793_a(4.0f, -2.5f, 3.0f);
        this.field_178724_i.func_78792_a(this.LeftArmLayer_r4);
        this.setRotationAngle(this.LeftArmLayer_r4, 0.0f, 0.0f, 0.3491f);
        this.LeftArmLayer_r4.field_78804_l.add(new ModelBox(this.LeftArmLayer_r4, 62, 41, 1.0f, -6.5f, -3.0f, 3, 4, 3, -0.6f, false));
        this.LeftArmLayer_r4.field_78804_l.add(new ModelBox(this.LeftArmLayer_r4, 62, 41, 1.0f, -6.5f, -6.0f, 3, 4, 3, -0.6f, false));
        this.field_178721_j.field_78804_l.add(new ModelBox(this.field_178721_j, 0, 48, -2.0f, 0.0f, -2.0f, 4, 10, 4, 0.25f, false));
        this.field_178721_j.field_78804_l.add(new ModelBox(this.field_178721_j, 53, 50, -4.0f, 1.0f, -4.0f, 6, 3, 3, -0.25f, true));
        this.field_178721_j.field_78804_l.add(new ModelBox(this.field_178721_j, 53, 57, -4.0f, 1.0f, -2.0f, 2, 3, 4, -0.3f, true));
        this.field_178721_j.field_78804_l.add(new ModelBox(this.field_178721_j, 53, 50, -4.0f, 1.0f, 1.0f, 6, 3, 3, -0.25f, true));
        this.field_178721_j.field_78804_l.add(new ModelBox(this.field_178721_j, 53, 50, -4.0f, 4.0f, 1.0f, 6, 3, 3, -0.25f, true));
        this.field_178721_j.field_78804_l.add(new ModelBox(this.field_178721_j, 53, 57, -4.0f, 4.0f, -2.0f, 2, 3, 4, -0.3f, true));
        this.field_178721_j.field_78804_l.add(new ModelBox(this.field_178721_j, 53, 50, -4.0f, 4.0f, -4.0f, 6, 3, 3, -0.25f, true));
        this.field_178722_k.field_78804_l.add(new ModelBox(this.field_178722_k, 18, 48, -2.0f, 0.0f, -2.0f, 4, 12, 4, 0.25f, false));
        this.field_178722_k.field_78804_l.add(new ModelBox(this.field_178722_k, 53, 50, -2.0f, 1.0f, -4.0f, 6, 3, 3, -0.25f, false));
        this.field_178722_k.field_78804_l.add(new ModelBox(this.field_178722_k, 53, 57, 2.0f, 1.0f, -2.0f, 2, 3, 4, -0.3f, false));
        this.field_178722_k.field_78804_l.add(new ModelBox(this.field_178722_k, 53, 50, -2.0f, 1.0f, 1.0f, 6, 3, 3, -0.25f, false));
        this.field_178722_k.field_78804_l.add(new ModelBox(this.field_178722_k, 53, 50, -2.0f, 4.0f, 1.0f, 6, 3, 3, -0.25f, false));
        this.field_178722_k.field_78804_l.add(new ModelBox(this.field_178722_k, 53, 57, 2.0f, 4.0f, -2.0f, 2, 3, 4, -0.3f, false));
        this.field_178722_k.field_78804_l.add(new ModelBox(this.field_178722_k, 53, 50, -2.0f, 4.0f, -4.0f, 6, 3, 3, -0.25f, false));
        this.field_178722_k.field_78804_l.add(new ModelBox(this.field_178722_k, 53, 50, -2.0f, 7.0f, 1.0f, 6, 3, 3, -0.25f, false));
        this.field_178722_k.field_78804_l.add(new ModelBox(this.field_178722_k, 53, 57, 2.0f, 7.0f, -2.0f, 2, 3, 4, -0.3f, false));
        this.field_178722_k.field_78804_l.add(new ModelBox(this.field_178722_k, 53, 50, -2.0f, 7.0f, -4.0f, 6, 3, 3, -0.25f, false));
    }

    public void func_78088_a(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        super.func_78088_a(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    @Override
    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        super.func_78087_a(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
        this.Tentacle1.field_78795_f = 0.5f + 0.3f * Mth.func_76126_a((float)(ageInTicks * 0.1f));
        this.Tentacle2.field_78795_f = 0.5f - 0.3f * Mth.func_76126_a((float)(ageInTicks * 0.1f));
        this.Tentacle3.field_78795_f = 0.5f + 0.3f * Mth.func_76134_b((float)(ageInTicks * 0.1f));
        this.HeadTentacle1.field_78796_g = 0.1f * Mth.func_76126_a((float)(ageInTicks * 0.15f));
        this.HeadTentacle2.field_78796_g = 0.1f * Mth.func_76126_a((float)((ageInTicks + 10.0f) * 0.15f));
        this.HeadTentacle3.field_78796_g = 0.1f * Mth.func_76126_a((float)((ageInTicks + 20.0f) * 0.15f));
        this.HeadTentacle4.field_78796_g = 0.1f * Mth.func_76126_a((float)((ageInTicks + 30.0f) * 0.15f));
        this.HeadTentacle5.field_78796_g = 0.1f * Mth.func_76126_a((float)((ageInTicks + 40.0f) * 0.15f));
        this.HeadTentacle6.field_78796_g = 0.1f * Mth.func_76126_a((float)((ageInTicks + 50.0f) * 0.15f));
        this.HeadTentacle7.field_78796_g = 0.1f * Mth.func_76126_a((float)((ageInTicks + 60.0f) * 0.15f));
        this.HeadTentacle8.field_78796_g = 0.1f * Mth.func_76126_a((float)((ageInTicks + 70.0f) * 0.15f));
        this.HeadTentacle9.field_78808_h = 0.1f * Mth.func_76126_a((float)(ageInTicks * 0.15f));
        this.HeadTentacle10.field_78808_h = 0.1f * Mth.func_76126_a((float)((ageInTicks + 20.0f) * 0.15f));
        this.HeadTentacle11.field_78808_h = 0.1f * Mth.func_76126_a((float)((ageInTicks + 40.0f) * 0.15f));
        this.BodyTent1.field_78796_g = 0.15f * Mth.func_76126_a((float)(ageInTicks * 0.2f));
        this.BodyTent2.field_78796_g = 0.15f * Mth.func_76126_a((float)((ageInTicks + 10.0f) * 0.2f));
        this.BodyTent3.field_78796_g = 0.15f * Mth.func_76126_a((float)((ageInTicks + 20.0f) * 0.2f));
        this.BodyTent4.field_78796_g = 0.15f * Mth.func_76126_a((float)((ageInTicks + 30.0f) * 0.2f));
        this.BodyTent5.field_78796_g = 0.15f * Mth.func_76126_a((float)((ageInTicks + 40.0f) * 0.2f));
        this.BodyTent6.field_78796_g = 0.15f * Mth.func_76126_a((float)((ageInTicks + 50.0f) * 0.2f));
    }
}

