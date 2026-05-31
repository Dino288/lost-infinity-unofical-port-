/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelBox
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.Mth
 */
package xol.lostinfinity.mob.model.boss;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import xol.lostinfinity.mob.entity.boss.EntityOzor;
import xol.lostinfinity.mob.entity.boss.EntityOzorDecoy;

public class ModelOzor
extends ModelBase {
    private final ModelRenderer BaseOzor;
    private final ModelRenderer Body;
    private final ModelRenderer Rod1;
    private final ModelRenderer Rod2;
    private final ModelRenderer Rod3;
    private final ModelRenderer Rod4;
    private final ModelRenderer Rod5;
    private final ModelRenderer Rod6;
    private final ModelRenderer Rod7;
    private final ModelRenderer Rod8;
    private final ModelRenderer Head;
    private final ModelRenderer Rotor;
    private final ModelRenderer Rotor2;
    private final ModelRenderer Mirage;
    private final ModelRenderer Body2;
    private final ModelRenderer Rod9;
    private final ModelRenderer Rod10;
    private final ModelRenderer Rod11;
    private final ModelRenderer Rod12;
    private final ModelRenderer Rod13;
    private final ModelRenderer Rod14;
    private final ModelRenderer Rod15;
    private final ModelRenderer Rod16;
    private final ModelRenderer Head2;
    private final ModelRenderer Rotor3;
    private final ModelRenderer Rotor4;
    private Random rand = new Random();
    private List<ModelRenderer> BodyRods = new ArrayList<ModelRenderer>();
    private int decoyTickOffset = 50 + this.rand.nextInt(12) * 50;

    public ModelOzor() {
        this.field_78090_t = 128;
        this.field_78089_u = 64;
        this.BaseOzor = new ModelRenderer((ModelBase)this);
        this.BaseOzor.func_78793_a(0.0f, 24.0f, 0.0f);
        this.Body = new ModelRenderer((ModelBase)this);
        this.Body.func_78793_a(0.0f, -17.0f, 0.0f);
        this.BaseOzor.func_78792_a(this.Body);
        this.Body.field_78804_l.add(new ModelBox(this.Body, 0, 16, -8.0f, -7.0f, -8.0f, 16, 7, 16, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 0, 39, -10.0f, 0.0f, -10.0f, 10, 5, 20, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 0, 39, 0.0f, 0.0f, -10.0f, 10, 5, 20, 0.0f, true));
        this.Rod1 = new ModelRenderer((ModelBase)this);
        this.Rod1.func_78793_a(0.0f, 3.0f, -9.0f);
        this.Body.func_78792_a(this.Rod1);
        this.Rod1.field_78804_l.add(new ModelBox(this.Rod1, 0, 17, -2.0f, -8.0f, -2.0f, 4, 10, 4, -1.0f, false));
        this.Rod1.field_78804_l.add(new ModelBox(this.Rod1, 0, 2, -3.0f, -12.0f, -3.0f, 6, 6, 6, -1.0f, false));
        this.Rod2 = new ModelRenderer((ModelBase)this);
        this.Rod2.func_78793_a(8.0f, 3.0f, -8.0f);
        this.Body.func_78792_a(this.Rod2);
        this.setRotationAngle(this.Rod2, 0.0f, -0.7854f, 0.0f);
        this.Rod2.field_78804_l.add(new ModelBox(this.Rod2, 0, 17, -2.0f, -8.0f, -2.0f, 4, 10, 4, -1.0f, false));
        this.Rod2.field_78804_l.add(new ModelBox(this.Rod2, 0, 2, -3.0f, -12.0f, -3.0f, 6, 6, 6, -1.0f, false));
        this.Rod3 = new ModelRenderer((ModelBase)this);
        this.Rod3.func_78793_a(9.0f, 3.0f, 0.0f);
        this.Body.func_78792_a(this.Rod3);
        this.setRotationAngle(this.Rod3, 0.0f, -1.5708f, 0.0f);
        this.Rod3.field_78804_l.add(new ModelBox(this.Rod3, 0, 17, -2.0f, -8.0f, -2.0f, 4, 10, 4, -1.0f, false));
        this.Rod3.field_78804_l.add(new ModelBox(this.Rod3, 0, 2, -3.0f, -12.0f, -3.0f, 6, 6, 6, -1.0f, false));
        this.Rod4 = new ModelRenderer((ModelBase)this);
        this.Rod4.func_78793_a(8.0f, 3.0f, 8.0f);
        this.Body.func_78792_a(this.Rod4);
        this.setRotationAngle(this.Rod4, 0.0f, -2.3562f, 0.0f);
        this.Rod4.field_78804_l.add(new ModelBox(this.Rod4, 0, 17, -2.0f, -8.0f, -2.0f, 4, 10, 4, -1.0f, false));
        this.Rod4.field_78804_l.add(new ModelBox(this.Rod4, 0, 2, -3.0f, -12.0f, -3.0f, 6, 6, 6, -1.0f, false));
        this.Rod5 = new ModelRenderer((ModelBase)this);
        this.Rod5.func_78793_a(0.0f, 3.0f, 9.0f);
        this.Body.func_78792_a(this.Rod5);
        this.setRotationAngle(this.Rod5, 0.0f, 3.1416f, 0.0f);
        this.Rod5.field_78804_l.add(new ModelBox(this.Rod5, 0, 17, -2.0f, -8.0f, -2.0f, 4, 10, 4, -1.0f, false));
        this.Rod5.field_78804_l.add(new ModelBox(this.Rod5, 0, 2, -3.0f, -12.0f, -3.0f, 6, 6, 6, -1.0f, false));
        this.Rod6 = new ModelRenderer((ModelBase)this);
        this.Rod6.func_78793_a(-8.0f, 3.0f, 8.0f);
        this.Body.func_78792_a(this.Rod6);
        this.setRotationAngle(this.Rod6, 0.0f, 2.3562f, 0.0f);
        this.Rod6.field_78804_l.add(new ModelBox(this.Rod6, 0, 17, -2.0f, -8.0f, -2.0f, 4, 10, 4, -1.0f, false));
        this.Rod6.field_78804_l.add(new ModelBox(this.Rod6, 0, 2, -3.0f, -12.0f, -3.0f, 6, 6, 6, -1.0f, false));
        this.Rod7 = new ModelRenderer((ModelBase)this);
        this.Rod7.func_78793_a(-9.0f, 3.0f, 0.0f);
        this.Body.func_78792_a(this.Rod7);
        this.setRotationAngle(this.Rod7, 0.0f, 1.5708f, 0.0f);
        this.Rod7.field_78804_l.add(new ModelBox(this.Rod7, 0, 17, -2.0f, -8.0f, -2.0f, 4, 10, 4, -1.0f, false));
        this.Rod7.field_78804_l.add(new ModelBox(this.Rod7, 0, 2, -3.0f, -12.0f, -3.0f, 6, 6, 6, -1.0f, false));
        this.Rod8 = new ModelRenderer((ModelBase)this);
        this.Rod8.func_78793_a(-8.0f, 3.0f, -8.0f);
        this.Body.func_78792_a(this.Rod8);
        this.setRotationAngle(this.Rod8, 0.0f, 0.7854f, 0.0f);
        this.Rod8.field_78804_l.add(new ModelBox(this.Rod8, 0, 17, -2.0f, -8.0f, -2.0f, 4, 10, 4, -1.0f, false));
        this.Rod8.field_78804_l.add(new ModelBox(this.Rod8, 0, 2, -3.0f, -12.0f, -3.0f, 6, 6, 6, -1.0f, false));
        this.Head = new ModelRenderer((ModelBase)this);
        this.Head.func_78793_a(0.0f, -27.0f, 0.0f);
        this.BaseOzor.func_78792_a(this.Head);
        this.Head.field_78804_l.add(new ModelBox(this.Head, 24, 0, -5.0f, -3.0f, -5.0f, 10, 6, 10, 0.0f, false));
        this.Rotor = new ModelRenderer((ModelBase)this);
        this.Rotor.func_78793_a(0.0f, -5.0f, 0.0f);
        this.BaseOzor.func_78792_a(this.Rotor);
        this.Rotor.field_78804_l.add(new ModelBox(this.Rotor, 0, 40, 6.0f, -1.0f, -10.0f, 4, 4, 4, 0.0f, false));
        this.Rotor.field_78804_l.add(new ModelBox(this.Rotor, 0, 40, -9.0f, -2.0f, -8.0f, 4, 4, 4, 0.0f, false));
        this.Rotor.field_78804_l.add(new ModelBox(this.Rotor, 0, 40, -18.0f, -1.0f, -4.0f, 4, 4, 4, 0.0f, false));
        this.Rotor.field_78804_l.add(new ModelBox(this.Rotor, 0, 40, 13.0f, -3.0f, 5.0f, 4, 4, 4, 0.0f, false));
        this.Rotor.field_78804_l.add(new ModelBox(this.Rotor, 0, 40, 11.0f, -3.0f, -14.0f, 4, 4, 4, 0.0f, false));
        this.Rotor.field_78804_l.add(new ModelBox(this.Rotor, 0, 40, 1.0f, 0.0f, 11.0f, 4, 4, 4, 0.0f, false));
        this.Rotor.field_78804_l.add(new ModelBox(this.Rotor, 0, 40, -6.0f, -1.0f, 5.0f, 4, 4, 4, 0.0f, false));
        this.Rotor.field_78804_l.add(new ModelBox(this.Rotor, 0, 49, 3.0f, 0.0f, 7.0f, 3, 3, 3, 0.0f, false));
        this.Rotor.field_78804_l.add(new ModelBox(this.Rotor, 0, 49, 9.0f, -1.0f, 2.0f, 3, 3, 3, 0.0f, false));
        this.Rotor.field_78804_l.add(new ModelBox(this.Rotor, 0, 49, -1.0f, -2.0f, -14.0f, 3, 3, 3, 0.0f, false));
        this.Rotor.field_78804_l.add(new ModelBox(this.Rotor, 0, 49, -8.0f, -2.0f, -16.0f, 3, 3, 3, 0.0f, false));
        this.Rotor.field_78804_l.add(new ModelBox(this.Rotor, 0, 49, 13.0f, -2.0f, -8.0f, 3, 3, 3, 0.0f, false));
        this.Rotor.field_78804_l.add(new ModelBox(this.Rotor, 0, 49, 10.0f, -3.0f, 11.0f, 3, 3, 3, 0.0f, false));
        this.Rotor.field_78804_l.add(new ModelBox(this.Rotor, 0, 49, -13.0f, -1.0f, 7.0f, 3, 3, 3, 0.0f, false));
        this.Rotor.field_78804_l.add(new ModelBox(this.Rotor, 0, 49, -13.0f, 0.0f, -13.0f, 3, 3, 3, 0.0f, false));
        this.Rotor.field_78804_l.add(new ModelBox(this.Rotor, 0, 49, -15.0f, -2.0f, 1.0f, 3, 3, 3, 0.0f, false));
        this.Rotor.field_78804_l.add(new ModelBox(this.Rotor, 11, 54, 3.0f, -1.0f, -11.0f, 2, 2, 2, 0.0f, false));
        this.Rotor.field_78804_l.add(new ModelBox(this.Rotor, 11, 54, -4.0f, 1.0f, -11.0f, 2, 2, 2, 0.0f, false));
        this.Rotor.field_78804_l.add(new ModelBox(this.Rotor, 11, 54, -11.0f, 0.0f, -3.0f, 2, 2, 2, 0.0f, false));
        this.Rotor.field_78804_l.add(new ModelBox(this.Rotor, 11, 54, -14.0f, -2.0f, -7.0f, 2, 2, 2, 0.0f, false));
        this.Rotor.field_78804_l.add(new ModelBox(this.Rotor, 11, 54, 4.0f, -2.0f, -15.0f, 2, 2, 2, 0.0f, false));
        this.Rotor.field_78804_l.add(new ModelBox(this.Rotor, 11, 54, 13.0f, -3.0f, 0.0f, 2, 2, 2, 0.0f, false));
        this.Rotor.field_78804_l.add(new ModelBox(this.Rotor, 11, 54, -10.0f, -2.0f, 2.0f, 2, 2, 2, 0.0f, false));
        this.Rotor.field_78804_l.add(new ModelBox(this.Rotor, 11, 54, -4.0f, -2.0f, 11.0f, 2, 2, 2, 0.0f, false));
        this.Rotor.field_78804_l.add(new ModelBox(this.Rotor, 11, 54, -7.0f, 1.0f, 10.0f, 2, 2, 2, 0.0f, false));
        this.Rotor.field_78804_l.add(new ModelBox(this.Rotor, 11, 54, 8.0f, -1.0f, 7.0f, 2, 2, 2, 0.0f, false));
        this.Rotor.field_78804_l.add(new ModelBox(this.Rotor, 11, 54, 10.0f, 1.0f, -3.0f, 2, 2, 2, 0.0f, false));
        this.Rotor2 = new ModelRenderer((ModelBase)this);
        this.Rotor2.func_78793_a(0.0f, -10.0f, 0.0f);
        this.BaseOzor.func_78792_a(this.Rotor2);
        this.Rotor2.field_78804_l.add(new ModelBox(this.Rotor2, 0, 40, 6.0f, -1.0f, -10.0f, 4, 4, 4, 0.0f, false));
        this.Rotor2.field_78804_l.add(new ModelBox(this.Rotor2, 0, 40, -9.0f, -2.0f, -8.0f, 4, 4, 4, 0.0f, false));
        this.Rotor2.field_78804_l.add(new ModelBox(this.Rotor2, 0, 40, -18.0f, -1.0f, -4.0f, 4, 4, 4, 0.0f, false));
        this.Rotor2.field_78804_l.add(new ModelBox(this.Rotor2, 0, 40, 13.0f, -3.0f, 5.0f, 4, 4, 4, 0.0f, false));
        this.Rotor2.field_78804_l.add(new ModelBox(this.Rotor2, 0, 40, 11.0f, -3.0f, -14.0f, 4, 4, 4, 0.0f, false));
        this.Rotor2.field_78804_l.add(new ModelBox(this.Rotor2, 0, 40, 1.0f, 0.0f, 11.0f, 4, 4, 4, 0.0f, false));
        this.Rotor2.field_78804_l.add(new ModelBox(this.Rotor2, 0, 40, -6.0f, -1.0f, 5.0f, 4, 4, 4, 0.0f, false));
        this.Rotor2.field_78804_l.add(new ModelBox(this.Rotor2, 0, 49, 3.0f, 0.0f, 7.0f, 3, 3, 3, 0.0f, false));
        this.Rotor2.field_78804_l.add(new ModelBox(this.Rotor2, 0, 49, 9.0f, -1.0f, 2.0f, 3, 3, 3, 0.0f, false));
        this.Rotor2.field_78804_l.add(new ModelBox(this.Rotor2, 0, 49, -1.0f, -2.0f, -14.0f, 3, 3, 3, 0.0f, false));
        this.Rotor2.field_78804_l.add(new ModelBox(this.Rotor2, 0, 49, -8.0f, -2.0f, -16.0f, 3, 3, 3, 0.0f, false));
        this.Rotor2.field_78804_l.add(new ModelBox(this.Rotor2, 0, 49, 13.0f, -2.0f, -8.0f, 3, 3, 3, 0.0f, false));
        this.Rotor2.field_78804_l.add(new ModelBox(this.Rotor2, 0, 49, 10.0f, -3.0f, 11.0f, 3, 3, 3, 0.0f, false));
        this.Rotor2.field_78804_l.add(new ModelBox(this.Rotor2, 0, 49, -13.0f, -1.0f, 7.0f, 3, 3, 3, 0.0f, false));
        this.Rotor2.field_78804_l.add(new ModelBox(this.Rotor2, 0, 49, -13.0f, 0.0f, -13.0f, 3, 3, 3, 0.0f, false));
        this.Rotor2.field_78804_l.add(new ModelBox(this.Rotor2, 0, 49, -15.0f, -2.0f, 1.0f, 3, 3, 3, 0.0f, false));
        this.Rotor2.field_78804_l.add(new ModelBox(this.Rotor2, 11, 54, 3.0f, -1.0f, -11.0f, 2, 2, 2, 0.0f, false));
        this.Rotor2.field_78804_l.add(new ModelBox(this.Rotor2, 11, 54, -4.0f, 1.0f, -11.0f, 2, 2, 2, 0.0f, false));
        this.Rotor2.field_78804_l.add(new ModelBox(this.Rotor2, 11, 54, -11.0f, 0.0f, -3.0f, 2, 2, 2, 0.0f, false));
        this.Rotor2.field_78804_l.add(new ModelBox(this.Rotor2, 11, 54, -14.0f, -2.0f, -7.0f, 2, 2, 2, 0.0f, false));
        this.Rotor2.field_78804_l.add(new ModelBox(this.Rotor2, 11, 54, 4.0f, -2.0f, -15.0f, 2, 2, 2, 0.0f, false));
        this.Rotor2.field_78804_l.add(new ModelBox(this.Rotor2, 11, 54, 13.0f, -3.0f, 0.0f, 2, 2, 2, 0.0f, false));
        this.Rotor2.field_78804_l.add(new ModelBox(this.Rotor2, 11, 54, -10.0f, -2.0f, 2.0f, 2, 2, 2, 0.0f, false));
        this.Rotor2.field_78804_l.add(new ModelBox(this.Rotor2, 11, 54, -4.0f, -2.0f, 11.0f, 2, 2, 2, 0.0f, false));
        this.Rotor2.field_78804_l.add(new ModelBox(this.Rotor2, 11, 54, -7.0f, 1.0f, 10.0f, 2, 2, 2, 0.0f, false));
        this.Rotor2.field_78804_l.add(new ModelBox(this.Rotor2, 11, 54, 8.0f, -1.0f, 7.0f, 2, 2, 2, 0.0f, false));
        this.Rotor2.field_78804_l.add(new ModelBox(this.Rotor2, 11, 54, 10.0f, 1.0f, -3.0f, 2, 2, 2, 0.0f, false));
        this.Mirage = new ModelRenderer((ModelBase)this);
        this.Mirage.func_78793_a(0.0f, 24.0f, 0.0f);
        this.Body2 = new ModelRenderer((ModelBase)this);
        this.Body2.func_78793_a(0.0f, -17.0f, 0.0f);
        this.Mirage.func_78792_a(this.Body2);
        this.Body2.field_78804_l.add(new ModelBox(this.Body2, 64, 16, -8.0f, -7.0f, -8.0f, 16, 7, 16, 0.05f, false));
        this.Body2.field_78804_l.add(new ModelBox(this.Body2, 64, 39, -10.0f, 0.0f, -10.0f, 10, 5, 20, 0.05f, false));
        this.Body2.field_78804_l.add(new ModelBox(this.Body2, 64, 39, 0.0f, 0.0f, -10.0f, 10, 5, 20, 0.05f, true));
        this.Rod9 = new ModelRenderer((ModelBase)this);
        this.Rod9.func_78793_a(0.0f, 3.0f, -9.0f);
        this.Body2.func_78792_a(this.Rod9);
        this.Rod9.field_78804_l.add(new ModelBox(this.Rod9, 64, 17, -2.0f, -8.0f, -2.0f, 4, 10, 4, 0.05f, false));
        this.Rod9.field_78804_l.add(new ModelBox(this.Rod9, 64, 2, -3.0f, -12.0f, -3.0f, 6, 6, 6, 0.05f, false));
        this.Rod10 = new ModelRenderer((ModelBase)this);
        this.Rod10.func_78793_a(8.0f, 3.0f, -8.0f);
        this.Body2.func_78792_a(this.Rod10);
        this.setRotationAngle(this.Rod10, 0.0f, -0.7854f, 0.0f);
        this.Rod10.field_78804_l.add(new ModelBox(this.Rod10, 64, 17, -2.0f, -8.0f, -2.0f, 4, 10, 4, 0.05f, false));
        this.Rod10.field_78804_l.add(new ModelBox(this.Rod10, 64, 2, -3.0f, -12.0f, -3.0f, 6, 6, 6, 0.05f, false));
        this.Rod11 = new ModelRenderer((ModelBase)this);
        this.Rod11.func_78793_a(9.0f, 3.0f, 0.0f);
        this.Body2.func_78792_a(this.Rod11);
        this.setRotationAngle(this.Rod11, 0.0f, -1.5708f, 0.0f);
        this.Rod11.field_78804_l.add(new ModelBox(this.Rod11, 64, 17, -2.0f, -8.0f, -2.0f, 4, 10, 4, 0.05f, false));
        this.Rod11.field_78804_l.add(new ModelBox(this.Rod11, 64, 2, -3.0f, -12.0f, -3.0f, 6, 6, 6, 0.05f, false));
        this.Rod12 = new ModelRenderer((ModelBase)this);
        this.Rod12.func_78793_a(8.0f, 3.0f, 8.0f);
        this.Body2.func_78792_a(this.Rod12);
        this.setRotationAngle(this.Rod12, 0.0f, -2.3562f, 0.0f);
        this.Rod12.field_78804_l.add(new ModelBox(this.Rod12, 64, 17, -2.0f, -8.0f, -2.0f, 4, 10, 4, 0.05f, false));
        this.Rod12.field_78804_l.add(new ModelBox(this.Rod12, 64, 2, -3.0f, -12.0f, -3.0f, 6, 6, 6, 0.05f, false));
        this.Rod13 = new ModelRenderer((ModelBase)this);
        this.Rod13.func_78793_a(0.0f, 3.0f, 9.0f);
        this.Body2.func_78792_a(this.Rod13);
        this.setRotationAngle(this.Rod13, 0.0f, 3.1416f, 0.0f);
        this.Rod13.field_78804_l.add(new ModelBox(this.Rod13, 64, 17, -2.0f, -8.0f, -2.0f, 4, 10, 4, 0.05f, false));
        this.Rod13.field_78804_l.add(new ModelBox(this.Rod13, 64, 2, -3.0f, -12.0f, -3.0f, 6, 6, 6, 0.05f, false));
        this.Rod14 = new ModelRenderer((ModelBase)this);
        this.Rod14.func_78793_a(-8.0f, 3.0f, 8.0f);
        this.Body2.func_78792_a(this.Rod14);
        this.setRotationAngle(this.Rod14, 0.0f, 2.3562f, 0.0f);
        this.Rod14.field_78804_l.add(new ModelBox(this.Rod14, 64, 17, -2.0f, -8.0f, -2.0f, 4, 10, 4, 0.05f, false));
        this.Rod14.field_78804_l.add(new ModelBox(this.Rod14, 64, 2, -3.0f, -12.0f, -3.0f, 6, 6, 6, 0.05f, false));
        this.Rod15 = new ModelRenderer((ModelBase)this);
        this.Rod15.func_78793_a(-9.0f, 3.0f, 0.0f);
        this.Body2.func_78792_a(this.Rod15);
        this.setRotationAngle(this.Rod15, 0.0f, 1.5708f, 0.0f);
        this.Rod15.field_78804_l.add(new ModelBox(this.Rod15, 64, 17, -2.0f, -8.0f, -2.0f, 4, 10, 4, 0.05f, false));
        this.Rod15.field_78804_l.add(new ModelBox(this.Rod15, 64, 2, -3.0f, -12.0f, -3.0f, 6, 6, 6, 0.05f, false));
        this.Rod16 = new ModelRenderer((ModelBase)this);
        this.Rod16.func_78793_a(-8.0f, 3.0f, -8.0f);
        this.Body2.func_78792_a(this.Rod16);
        this.setRotationAngle(this.Rod16, 0.0f, 0.7854f, 0.0f);
        this.Rod16.field_78804_l.add(new ModelBox(this.Rod16, 64, 17, -2.0f, -8.0f, -2.0f, 4, 10, 4, 0.05f, false));
        this.Rod16.field_78804_l.add(new ModelBox(this.Rod16, 64, 2, -3.0f, -12.0f, -3.0f, 6, 6, 6, 0.05f, false));
        this.Head2 = new ModelRenderer((ModelBase)this);
        this.Head2.func_78793_a(0.0f, -27.0f, 0.0f);
        this.Mirage.func_78792_a(this.Head2);
        this.Head2.field_78804_l.add(new ModelBox(this.Head2, 88, 0, -5.0f, -3.0f, -5.0f, 10, 6, 10, 0.05f, false));
        this.Rotor3 = new ModelRenderer((ModelBase)this);
        this.Rotor3.func_78793_a(0.0f, -5.0f, 0.0f);
        this.Mirage.func_78792_a(this.Rotor3);
        this.Rotor3.field_78804_l.add(new ModelBox(this.Rotor3, 64, 40, 6.0f, -1.0f, -10.0f, 4, 4, 4, 0.05f, false));
        this.Rotor3.field_78804_l.add(new ModelBox(this.Rotor3, 64, 40, -9.0f, -2.0f, -8.0f, 4, 4, 4, 0.05f, false));
        this.Rotor3.field_78804_l.add(new ModelBox(this.Rotor3, 64, 40, -18.0f, -1.0f, -4.0f, 4, 4, 4, 0.05f, false));
        this.Rotor3.field_78804_l.add(new ModelBox(this.Rotor3, 64, 40, 13.0f, -3.0f, 5.0f, 4, 4, 4, 0.05f, false));
        this.Rotor3.field_78804_l.add(new ModelBox(this.Rotor3, 64, 40, 11.0f, -3.0f, -14.0f, 4, 4, 4, 0.05f, false));
        this.Rotor3.field_78804_l.add(new ModelBox(this.Rotor3, 64, 40, 1.0f, 0.0f, 11.0f, 4, 4, 4, 0.05f, false));
        this.Rotor3.field_78804_l.add(new ModelBox(this.Rotor3, 64, 40, -6.0f, -1.0f, 5.0f, 4, 4, 4, 0.05f, false));
        this.Rotor3.field_78804_l.add(new ModelBox(this.Rotor3, 64, 49, 3.0f, 0.0f, 7.0f, 3, 3, 3, 0.05f, false));
        this.Rotor3.field_78804_l.add(new ModelBox(this.Rotor3, 64, 49, 9.0f, -1.0f, 2.0f, 3, 3, 3, 0.05f, false));
        this.Rotor3.field_78804_l.add(new ModelBox(this.Rotor3, 64, 49, -1.0f, -2.0f, -14.0f, 3, 3, 3, 0.05f, false));
        this.Rotor3.field_78804_l.add(new ModelBox(this.Rotor3, 64, 49, -8.0f, -2.0f, -16.0f, 3, 3, 3, 0.05f, false));
        this.Rotor3.field_78804_l.add(new ModelBox(this.Rotor3, 64, 49, 13.0f, -2.0f, -8.0f, 3, 3, 3, 0.05f, false));
        this.Rotor3.field_78804_l.add(new ModelBox(this.Rotor3, 64, 49, 10.0f, -3.0f, 11.0f, 3, 3, 3, 0.05f, false));
        this.Rotor3.field_78804_l.add(new ModelBox(this.Rotor3, 64, 49, -13.0f, -1.0f, 7.0f, 3, 3, 3, 0.05f, false));
        this.Rotor3.field_78804_l.add(new ModelBox(this.Rotor3, 64, 49, -13.0f, 0.0f, -13.0f, 3, 3, 3, 0.05f, false));
        this.Rotor3.field_78804_l.add(new ModelBox(this.Rotor3, 64, 49, -15.0f, -2.0f, 1.0f, 3, 3, 3, 0.05f, false));
        this.Rotor3.field_78804_l.add(new ModelBox(this.Rotor3, 75, 54, 3.0f, -1.0f, -11.0f, 2, 2, 2, 0.05f, false));
        this.Rotor3.field_78804_l.add(new ModelBox(this.Rotor3, 75, 54, -4.0f, 1.0f, -11.0f, 2, 2, 2, 0.05f, false));
        this.Rotor3.field_78804_l.add(new ModelBox(this.Rotor3, 75, 54, -11.0f, 0.0f, -3.0f, 2, 2, 2, 0.05f, false));
        this.Rotor3.field_78804_l.add(new ModelBox(this.Rotor3, 75, 54, -14.0f, -2.0f, -7.0f, 2, 2, 2, 0.05f, false));
        this.Rotor3.field_78804_l.add(new ModelBox(this.Rotor3, 75, 54, 4.0f, -2.0f, -15.0f, 2, 2, 2, 0.05f, false));
        this.Rotor3.field_78804_l.add(new ModelBox(this.Rotor3, 75, 54, 13.0f, -3.0f, 0.0f, 2, 2, 2, 0.05f, false));
        this.Rotor3.field_78804_l.add(new ModelBox(this.Rotor3, 75, 54, -10.0f, -2.0f, 2.0f, 2, 2, 2, 0.05f, false));
        this.Rotor3.field_78804_l.add(new ModelBox(this.Rotor3, 75, 54, -4.0f, -2.0f, 11.0f, 2, 2, 2, 0.05f, false));
        this.Rotor3.field_78804_l.add(new ModelBox(this.Rotor3, 75, 54, -7.0f, 1.0f, 10.0f, 2, 2, 2, 0.05f, false));
        this.Rotor3.field_78804_l.add(new ModelBox(this.Rotor3, 75, 54, 8.0f, -1.0f, 7.0f, 2, 2, 2, 0.05f, false));
        this.Rotor3.field_78804_l.add(new ModelBox(this.Rotor3, 75, 54, 10.0f, 1.0f, -3.0f, 2, 2, 2, 0.05f, false));
        this.Rotor4 = new ModelRenderer((ModelBase)this);
        this.Rotor4.func_78793_a(0.0f, -10.0f, 0.0f);
        this.Mirage.func_78792_a(this.Rotor4);
        this.Rotor4.field_78804_l.add(new ModelBox(this.Rotor4, 64, 40, 6.0f, -1.0f, -10.0f, 4, 4, 4, 0.05f, false));
        this.Rotor4.field_78804_l.add(new ModelBox(this.Rotor4, 64, 40, -9.0f, -2.0f, -8.0f, 4, 4, 4, 0.05f, false));
        this.Rotor4.field_78804_l.add(new ModelBox(this.Rotor4, 64, 40, -18.0f, -1.0f, -4.0f, 4, 4, 4, 0.05f, false));
        this.Rotor4.field_78804_l.add(new ModelBox(this.Rotor4, 64, 40, 13.0f, -3.0f, 5.0f, 4, 4, 4, 0.05f, false));
        this.Rotor4.field_78804_l.add(new ModelBox(this.Rotor4, 64, 40, 11.0f, -3.0f, -14.0f, 4, 4, 4, 0.05f, false));
        this.Rotor4.field_78804_l.add(new ModelBox(this.Rotor4, 64, 40, 1.0f, 0.0f, 11.0f, 4, 4, 4, 0.05f, false));
        this.Rotor4.field_78804_l.add(new ModelBox(this.Rotor4, 64, 40, -6.0f, -1.0f, 5.0f, 4, 4, 4, 0.05f, false));
        this.Rotor4.field_78804_l.add(new ModelBox(this.Rotor4, 64, 49, 3.0f, 0.0f, 7.0f, 3, 3, 3, 0.05f, false));
        this.Rotor4.field_78804_l.add(new ModelBox(this.Rotor4, 64, 49, 9.0f, -1.0f, 2.0f, 3, 3, 3, 0.05f, false));
        this.Rotor4.field_78804_l.add(new ModelBox(this.Rotor4, 64, 49, -1.0f, -2.0f, -14.0f, 3, 3, 3, 0.05f, false));
        this.Rotor4.field_78804_l.add(new ModelBox(this.Rotor4, 64, 49, -8.0f, -2.0f, -16.0f, 3, 3, 3, 0.05f, false));
        this.Rotor4.field_78804_l.add(new ModelBox(this.Rotor4, 64, 49, 13.0f, -2.0f, -8.0f, 3, 3, 3, 0.05f, false));
        this.Rotor4.field_78804_l.add(new ModelBox(this.Rotor4, 64, 49, 10.0f, -3.0f, 11.0f, 3, 3, 3, 0.05f, false));
        this.Rotor4.field_78804_l.add(new ModelBox(this.Rotor4, 64, 49, -13.0f, -1.0f, 7.0f, 3, 3, 3, 0.05f, false));
        this.Rotor4.field_78804_l.add(new ModelBox(this.Rotor4, 64, 49, -13.0f, 0.0f, -13.0f, 3, 3, 3, 0.05f, false));
        this.Rotor4.field_78804_l.add(new ModelBox(this.Rotor4, 64, 49, -15.0f, -2.0f, 1.0f, 3, 3, 3, 0.05f, false));
        this.Rotor4.field_78804_l.add(new ModelBox(this.Rotor4, 75, 54, 3.0f, -1.0f, -11.0f, 2, 2, 2, 0.05f, false));
        this.Rotor4.field_78804_l.add(new ModelBox(this.Rotor4, 75, 54, -4.0f, 1.0f, -11.0f, 2, 2, 2, 0.05f, false));
        this.Rotor4.field_78804_l.add(new ModelBox(this.Rotor4, 75, 54, -11.0f, 0.0f, -3.0f, 2, 2, 2, 0.05f, false));
        this.Rotor4.field_78804_l.add(new ModelBox(this.Rotor4, 75, 54, -14.0f, -2.0f, -7.0f, 2, 2, 2, 0.05f, false));
        this.Rotor4.field_78804_l.add(new ModelBox(this.Rotor4, 75, 54, 4.0f, -2.0f, -15.0f, 2, 2, 2, 0.05f, false));
        this.Rotor4.field_78804_l.add(new ModelBox(this.Rotor4, 75, 54, 13.0f, -3.0f, 0.0f, 2, 2, 2, 0.05f, false));
        this.Rotor4.field_78804_l.add(new ModelBox(this.Rotor4, 75, 54, -10.0f, -2.0f, 2.0f, 2, 2, 2, 0.05f, false));
        this.Rotor4.field_78804_l.add(new ModelBox(this.Rotor4, 75, 54, -4.0f, -2.0f, 11.0f, 2, 2, 2, 0.05f, false));
        this.Rotor4.field_78804_l.add(new ModelBox(this.Rotor4, 75, 54, -7.0f, 1.0f, 10.0f, 2, 2, 2, 0.05f, false));
        this.Rotor4.field_78804_l.add(new ModelBox(this.Rotor4, 75, 54, 8.0f, -1.0f, 7.0f, 2, 2, 2, 0.05f, false));
        this.Rotor4.field_78804_l.add(new ModelBox(this.Rotor4, 75, 54, 10.0f, 1.0f, -3.0f, 2, 2, 2, 0.05f, false));
        this.BodyRods.add(this.Rod1);
        this.BodyRods.add(this.Rod2);
        this.BodyRods.add(this.Rod3);
        this.BodyRods.add(this.Rod4);
        this.BodyRods.add(this.Rod5);
        this.BodyRods.add(this.Rod6);
        this.BodyRods.add(this.Rod7);
        this.BodyRods.add(this.Rod8);
        Collections.shuffle(this.BodyRods);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        float baseAlpha = 1.0f;
        if (entity instanceof EntityOzor) {
            EntityOzor ozor = (EntityOzor)entity;
            baseAlpha = ozor.getAlpha();
        } else if (entity instanceof EntityOzorDecoy) {
            EntityOzorDecoy ozor = (EntityOzorDecoy)entity;
            baseAlpha = ozor.getAlpha();
        }
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)baseAlpha);
        this.BaseOzor.func_78785_a(f5);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)(baseAlpha * (0.5f + 0.25f * Mth.func_76126_a((float)(f2 * 0.2f)))));
        this.Mirage.func_78785_a(f5);
        GlStateManager.func_179084_k();
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.Mirage.field_82906_o = -0.05f * (float)Math.sin(ageInTicks * 0.15f);
        this.Mirage.field_82908_p = 0.05f * (float)Math.sin(ageInTicks * 0.1f);
        if (entityIn instanceof EntityOzor) {
            EntityOzor ozor = (EntityOzor)entityIn;
            if (ozor.getIllusionPhase() == 2) {
                ageInTicks = this.decoyTickOffset;
            }
        } else if (entityIn instanceof EntityOzorDecoy) {
            ageInTicks = this.decoyTickOffset;
        }
        this.Head2.field_78796_g = this.Head.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        for (int i = 0; i < this.BodyRods.size(); ++i) {
            ModelRenderer indiv_rod = this.BodyRods.get(i);
            indiv_rod.field_78795_f = 0.6109f + 0.5f * Mth.func_76126_a((float)(0.15f * (ageInTicks + (float)(i * 15))));
        }
        this.Body2.field_78796_g = this.Body.field_78796_g = ageInTicks * 0.05f;
        this.Rotor.field_78796_g = ageInTicks * 0.3f;
        this.Rotor2.field_78796_g = ageInTicks * -0.3f;
        this.Rotor3.field_78796_g = this.Rotor.field_78796_g;
        this.Rotor4.field_78796_g = this.Rotor2.field_78796_g;
        this.Rod9.field_78795_f = this.Rod1.field_78795_f;
        this.Rod10.field_78795_f = this.Rod2.field_78795_f;
        this.Rod11.field_78795_f = this.Rod3.field_78795_f;
        this.Rod12.field_78795_f = this.Rod4.field_78795_f;
        this.Rod13.field_78795_f = this.Rod5.field_78795_f;
        this.Rod14.field_78795_f = this.Rod6.field_78795_f;
        this.Rod15.field_78795_f = this.Rod7.field_78795_f;
        this.Rod16.field_78795_f = this.Rod8.field_78795_f;
    }
}

