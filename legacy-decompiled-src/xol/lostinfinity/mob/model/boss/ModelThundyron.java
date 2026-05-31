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
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import xol.lostinfinity.mob.entity.boss.EntityThundyron;

public class ModelThundyron
extends ModelBase {
    private final ModelRenderer Orb;
    private final ModelRenderer Eye;
    private final ModelRenderer ThunderOrb1;
    private final ModelRenderer ThunderOrb2;
    private final ModelRenderer ThunderOrb3;
    private final ModelRenderer Tendril1;
    private final ModelRenderer Tendril2;
    private final ModelRenderer Tendril3;
    private final ModelRenderer Tendril4;
    private final ModelRenderer Tendril5;
    private final ModelRenderer Tendril6;
    private final ModelRenderer Tendril7;
    private final ModelRenderer Tendril8;
    private final ModelRenderer Tendril9;
    private final ModelRenderer Tendril10;
    private final ModelRenderer Tendril11;
    private final ModelRenderer Tendril12;
    private List<ModelRenderer> Tendrils = new ArrayList<ModelRenderer>();

    public ModelThundyron() {
        this.field_78090_t = 128;
        this.field_78089_u = 64;
        this.Orb = new ModelRenderer((ModelBase)this);
        this.Orb.func_78793_a(0.0f, 7.0f, 0.0f);
        this.Orb.field_78804_l.add(new ModelBox(this.Orb, 0, 0, -6.0f, -6.0f, -6.0f, 12, 12, 12, 0.0f, false));
        this.Eye = new ModelRenderer((ModelBase)this);
        this.Eye.func_78793_a(0.0f, 7.0f, 0.0f);
        this.Eye.field_78804_l.add(new ModelBox(this.Eye, 0, 25, -6.0f, -6.0f, -6.0f, 12, 12, 12, -2.0f, false));
        this.ThunderOrb1 = new ModelRenderer((ModelBase)this);
        this.ThunderOrb1.func_78793_a(0.0f, 7.0f, 0.0f);
        this.ThunderOrb1.field_78804_l.add(new ModelBox(this.ThunderOrb1, 59, 0, -6.0f, -6.0f, -6.0f, 12, 12, 12, 0.35f, false));
        this.ThunderOrb2 = new ModelRenderer((ModelBase)this);
        this.ThunderOrb2.func_78793_a(0.0f, 7.0f, 0.0f);
        this.setRotationAngle(this.ThunderOrb2, -0.7854f, -0.7854f, 0.0f);
        this.ThunderOrb2.field_78804_l.add(new ModelBox(this.ThunderOrb2, 59, 0, -6.0f, -6.0f, -6.0f, 12, 12, 12, 1.0f, false));
        this.ThunderOrb3 = new ModelRenderer((ModelBase)this);
        this.ThunderOrb3.func_78793_a(0.0f, 7.0f, 0.0f);
        this.setRotationAngle(this.ThunderOrb3, -0.7854f, -2.3562f, 0.0f);
        this.ThunderOrb3.field_78804_l.add(new ModelBox(this.ThunderOrb3, 59, 0, -6.0f, -6.0f, -6.0f, 12, 12, 12, 1.5f, false));
        this.Tendril1 = new ModelRenderer((ModelBase)this);
        this.Tendril1.func_78793_a(0.0f, 7.0f, 0.0f);
        this.setRotationAngle(this.Tendril1, -0.7854f, -0.7854f, 0.0f);
        this.Tendril1.field_78804_l.add(new ModelBox(this.Tendril1, 50, 39, -4.0f, -16.0f, -4.0f, 8, 2, 8, 0.0f, false));
        this.Tendril1.field_78804_l.add(new ModelBox(this.Tendril1, 54, 26, -3.0f, -22.0f, -3.0f, 6, 6, 6, 0.0f, false));
        this.Tendril2 = new ModelRenderer((ModelBase)this);
        this.Tendril2.func_78793_a(0.0f, 7.0f, 0.0f);
        this.setRotationAngle(this.Tendril2, -0.7854f, 0.7854f, 0.0f);
        this.Tendril2.field_78804_l.add(new ModelBox(this.Tendril2, 50, 39, -4.0f, -16.0f, -4.0f, 8, 2, 8, 0.0f, false));
        this.Tendril2.field_78804_l.add(new ModelBox(this.Tendril2, 54, 26, -3.0f, -22.0f, -3.0f, 6, 6, 6, 0.0f, false));
        this.Tendril3 = new ModelRenderer((ModelBase)this);
        this.Tendril3.func_78793_a(0.0f, 7.0f, 0.0f);
        this.setRotationAngle(this.Tendril3, -0.7854f, 2.3562f, 0.0f);
        this.Tendril3.field_78804_l.add(new ModelBox(this.Tendril3, 50, 39, -4.0f, -16.0f, -4.0f, 8, 2, 8, 0.0f, false));
        this.Tendril3.field_78804_l.add(new ModelBox(this.Tendril3, 54, 26, -3.0f, -22.0f, -3.0f, 6, 6, 6, 0.0f, false));
        this.Tendril4 = new ModelRenderer((ModelBase)this);
        this.Tendril4.func_78793_a(0.0f, 7.0f, 0.0f);
        this.setRotationAngle(this.Tendril4, -0.7854f, -2.3562f, 0.0f);
        this.Tendril4.field_78804_l.add(new ModelBox(this.Tendril4, 50, 39, -4.0f, -16.0f, -4.0f, 8, 2, 8, 0.0f, false));
        this.Tendril4.field_78804_l.add(new ModelBox(this.Tendril4, 54, 26, -3.0f, -22.0f, -3.0f, 6, 6, 6, 0.0f, false));
        this.Tendril5 = new ModelRenderer((ModelBase)this);
        this.Tendril5.func_78793_a(0.0f, 7.0f, 0.0f);
        this.setRotationAngle(this.Tendril5, -2.3562f, -0.7854f, 0.0f);
        this.Tendril5.field_78804_l.add(new ModelBox(this.Tendril5, 50, 39, -4.0f, -16.0f, -4.0f, 8, 2, 8, 0.0f, false));
        this.Tendril5.field_78804_l.add(new ModelBox(this.Tendril5, 54, 26, -3.0f, -22.0f, -3.0f, 6, 6, 6, 0.0f, false));
        this.Tendril6 = new ModelRenderer((ModelBase)this);
        this.Tendril6.func_78793_a(0.0f, 7.0f, 0.0f);
        this.setRotationAngle(this.Tendril6, -2.3562f, -2.3562f, 0.0f);
        this.Tendril6.field_78804_l.add(new ModelBox(this.Tendril6, 50, 39, -4.0f, -16.0f, -4.0f, 8, 2, 8, 0.0f, false));
        this.Tendril6.field_78804_l.add(new ModelBox(this.Tendril6, 54, 26, -3.0f, -22.0f, -3.0f, 6, 6, 6, 0.0f, false));
        this.Tendril7 = new ModelRenderer((ModelBase)this);
        this.Tendril7.func_78793_a(0.0f, 7.0f, 0.0f);
        this.setRotationAngle(this.Tendril7, -2.3562f, 2.3562f, 0.0f);
        this.Tendril7.field_78804_l.add(new ModelBox(this.Tendril7, 50, 39, -4.0f, -16.0f, -4.0f, 8, 2, 8, 0.0f, false));
        this.Tendril7.field_78804_l.add(new ModelBox(this.Tendril7, 54, 26, -3.0f, -22.0f, -3.0f, 6, 6, 6, 0.0f, false));
        this.Tendril8 = new ModelRenderer((ModelBase)this);
        this.Tendril8.func_78793_a(0.0f, 7.0f, 0.0f);
        this.setRotationAngle(this.Tendril8, -2.3562f, 0.7854f, 0.0f);
        this.Tendril8.field_78804_l.add(new ModelBox(this.Tendril8, 50, 39, -4.0f, -16.0f, -4.0f, 8, 2, 8, 0.0f, false));
        this.Tendril8.field_78804_l.add(new ModelBox(this.Tendril8, 54, 26, -3.0f, -22.0f, -3.0f, 6, 6, 6, 0.0f, false));
        this.Tendril9 = new ModelRenderer((ModelBase)this);
        this.Tendril9.func_78793_a(0.0f, 7.0f, 0.0f);
        this.setRotationAngle(this.Tendril9, -1.5708f, 0.0f, 0.0f);
        this.Tendril9.field_78804_l.add(new ModelBox(this.Tendril9, 50, 39, -4.0f, -16.0f, -4.0f, 8, 2, 8, 0.0f, false));
        this.Tendril9.field_78804_l.add(new ModelBox(this.Tendril9, 54, 26, -3.0f, -22.0f, -3.0f, 6, 6, 6, 0.0f, false));
        this.Tendril10 = new ModelRenderer((ModelBase)this);
        this.Tendril10.func_78793_a(0.0f, 7.0f, 0.0f);
        this.Tendril10.field_78804_l.add(new ModelBox(this.Tendril10, 50, 39, -4.0f, -16.0f, -4.0f, 8, 2, 8, 0.0f, false));
        this.Tendril10.field_78804_l.add(new ModelBox(this.Tendril10, 54, 26, -3.0f, -22.0f, -3.0f, 6, 6, 6, 0.0f, false));
        this.Tendril11 = new ModelRenderer((ModelBase)this);
        this.Tendril11.func_78793_a(0.0f, 7.0f, 0.0f);
        this.setRotationAngle(this.Tendril11, 3.1416f, 0.0f, 0.0f);
        this.Tendril11.field_78804_l.add(new ModelBox(this.Tendril11, 50, 39, -4.0f, -16.0f, -4.0f, 8, 2, 8, 0.0f, false));
        this.Tendril11.field_78804_l.add(new ModelBox(this.Tendril11, 54, 26, -3.0f, -22.0f, -3.0f, 6, 6, 6, 0.0f, false));
        this.Tendril12 = new ModelRenderer((ModelBase)this);
        this.Tendril12.func_78793_a(0.0f, 7.0f, 0.0f);
        this.setRotationAngle(this.Tendril12, 1.5708f, 0.0f, 0.0f);
        this.Tendril12.field_78804_l.add(new ModelBox(this.Tendril12, 50, 39, -4.0f, -16.0f, -4.0f, 8, 2, 8, 0.0f, false));
        this.Tendril12.field_78804_l.add(new ModelBox(this.Tendril12, 54, 26, -3.0f, -22.0f, -3.0f, 6, 6, 6, 0.0f, false));
        this.Tendrils.add(this.Tendril1);
        this.Tendrils.add(this.Tendril2);
        this.Tendrils.add(this.Tendril3);
        this.Tendrils.add(this.Tendril4);
        this.Tendrils.add(this.Tendril5);
        this.Tendrils.add(this.Tendril6);
        this.Tendrils.add(this.Tendril7);
        this.Tendrils.add(this.Tendril8);
        this.Tendrils.add(this.Tendril9);
        this.Tendrils.add(this.Tendril10);
        this.Tendrils.add(this.Tendril11);
        this.Tendrils.add(this.Tendril12);
        Collections.shuffle(this.Tendrils);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.Eye.func_78785_a(f5);
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)0.75f);
        this.Orb.func_78785_a(f5);
        EntityThundyron thundyron = (EntityThundyron)entity;
        int orb = thundyron.getThunderOrb();
        float opacity = thundyron.getThunderAlpha();
        float animationSpeed = thundyron.getLivesCount() > 75 ? 0.8f : 0.2f;
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)opacity);
        switch (orb) {
            case 0: {
                this.ThunderOrb1.func_78785_a(f5);
                break;
            }
            case 1: {
                this.ThunderOrb2.func_78785_a(f5);
                break;
            }
            case 2: {
                this.ThunderOrb3.func_78785_a(f5);
            }
        }
        for (int i = 0; i < this.Tendrils.size(); ++i) {
            ModelRenderer piece = this.Tendrils.get(i);
            opacity = 0.9f * (float)Math.sin(animationSpeed * (f2 + (float)(i * 10)));
            GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)opacity);
            piece.func_78785_a(f5);
        }
        GlStateManager.func_179084_k();
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.Eye.field_78796_g = ageInTicks * 0.2f;
        this.Eye.field_78808_h = 0.1f * Mth.func_76126_a((float)(ageInTicks * 0.2f));
        this.Orb.field_78796_g = ageInTicks * -0.1f;
        this.Orb.field_78808_h = 0.1f * Mth.func_76126_a((float)(ageInTicks * 0.2f));
    }
}

