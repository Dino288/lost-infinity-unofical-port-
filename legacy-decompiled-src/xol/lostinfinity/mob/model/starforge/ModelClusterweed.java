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
package xol.lostinfinity.mob.model.starforge;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;

public class ModelClusterweed
extends ModelBase {
    private final ModelRenderer Orb;
    private final ModelRenderer OrbInner;
    private final ModelRenderer OrbInner2;
    private final ModelRenderer Body;
    private final ModelRenderer Needle1;
    private final ModelRenderer Needle2;
    private final ModelRenderer Needle3;
    private final ModelRenderer Needle4;
    private final ModelRenderer Needle5;
    private final ModelRenderer Needle6;
    private final ModelRenderer Needle7;
    private final ModelRenderer Needle8;
    private final ModelRenderer Needle9;
    private final ModelRenderer Needle10;
    private final ModelRenderer Needle11;
    private final ModelRenderer Needle12;
    private final ModelRenderer Needle13;
    private final ModelRenderer Needle14;
    private final ModelRenderer Needle15;
    private final ModelRenderer Needle16;
    private List<ModelRenderer> needles = new ArrayList<ModelRenderer>();

    public ModelClusterweed() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.Orb = new ModelRenderer((ModelBase)this);
        this.Orb.func_78793_a(0.0f, -6.0f, 0.0f);
        this.Orb.field_78804_l.add(new ModelBox(this.Orb, 16, 26, -6.0f, -6.0f, -6.0f, 12, 12, 12, 0.0f, false));
        this.OrbInner = new ModelRenderer((ModelBase)this);
        this.OrbInner.func_78793_a(0.0f, -6.0f, 0.0f);
        this.OrbInner.field_78804_l.add(new ModelBox(this.OrbInner, 16, 26, -6.0f, -6.0f, -6.0f, 12, 12, 12, -2.0f, false));
        this.OrbInner2 = new ModelRenderer((ModelBase)this);
        this.OrbInner2.func_78793_a(-3.0f, -9.0f, 3.0f);
        this.OrbInner2.field_78804_l.add(new ModelBox(this.OrbInner2, 0, 51, 0.0f, 0.0f, -6.0f, 6, 6, 6, -1.0f, false));
        this.Body = new ModelRenderer((ModelBase)this);
        this.Body.func_78793_a(0.0f, 22.0f, 0.0f);
        this.Body.field_78804_l.add(new ModelBox(this.Body, 0, 0, 0.0f, -22.0f, -6.0f, 1, 24, 12, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 28, 0, -6.0f, -22.0f, 0.0f, 12, 24, 1, 0.0f, false));
        this.Needle1 = new ModelRenderer((ModelBase)this);
        this.Needle1.func_78793_a(0.0f, 2.0f, 0.0f);
        this.setRotationAngle(this.Needle1, -1.309f, 0.0f, 0.0f);
        this.Needle1.field_78804_l.add(new ModelBox(this.Needle1, 58, 0, -0.5f, -16.0f, -0.5f, 1, 12, 1, 0.0f, false));
        this.Needle2 = new ModelRenderer((ModelBase)this);
        this.Needle2.func_78793_a(0.0f, 2.0f, 0.0f);
        this.setRotationAngle(this.Needle2, -1.309f, -0.3927f, 0.0f);
        this.Needle2.field_78804_l.add(new ModelBox(this.Needle2, 58, 0, -0.5f, -16.0f, -0.5f, 1, 12, 1, 0.0f, false));
        this.Needle3 = new ModelRenderer((ModelBase)this);
        this.Needle3.func_78793_a(0.0f, 2.0f, 0.0f);
        this.setRotationAngle(this.Needle3, -1.309f, -0.7854f, 0.0f);
        this.Needle3.field_78804_l.add(new ModelBox(this.Needle3, 58, 0, -0.5f, -16.0f, -0.5f, 1, 12, 1, 0.0f, false));
        this.Needle4 = new ModelRenderer((ModelBase)this);
        this.Needle4.func_78793_a(0.0f, 2.0f, 0.0f);
        this.setRotationAngle(this.Needle4, -1.309f, -1.1781f, 0.0f);
        this.Needle4.field_78804_l.add(new ModelBox(this.Needle4, 58, 0, -0.5f, -16.0f, -0.5f, 1, 12, 1, 0.0f, false));
        this.Needle5 = new ModelRenderer((ModelBase)this);
        this.Needle5.func_78793_a(0.0f, 2.0f, 0.0f);
        this.setRotationAngle(this.Needle5, -1.309f, -1.5708f, 0.0f);
        this.Needle5.field_78804_l.add(new ModelBox(this.Needle5, 58, 0, -0.5f, -16.0f, -0.5f, 1, 12, 1, 0.0f, false));
        this.Needle6 = new ModelRenderer((ModelBase)this);
        this.Needle6.func_78793_a(0.0f, 2.0f, 0.0f);
        this.setRotationAngle(this.Needle6, -1.309f, -1.9635f, 0.0f);
        this.Needle6.field_78804_l.add(new ModelBox(this.Needle6, 58, 0, -0.5f, -16.0f, -0.5f, 1, 12, 1, 0.0f, false));
        this.Needle7 = new ModelRenderer((ModelBase)this);
        this.Needle7.func_78793_a(0.0f, 2.0f, 0.0f);
        this.setRotationAngle(this.Needle7, -1.309f, -2.3562f, 0.0f);
        this.Needle7.field_78804_l.add(new ModelBox(this.Needle7, 58, 0, -0.5f, -16.0f, -0.5f, 1, 12, 1, 0.0f, false));
        this.Needle8 = new ModelRenderer((ModelBase)this);
        this.Needle8.func_78793_a(0.0f, 2.0f, 0.0f);
        this.setRotationAngle(this.Needle8, -1.309f, -2.7489f, 0.0f);
        this.Needle8.field_78804_l.add(new ModelBox(this.Needle8, 58, 0, -0.5f, -16.0f, -0.5f, 1, 12, 1, 0.0f, false));
        this.Needle9 = new ModelRenderer((ModelBase)this);
        this.Needle9.func_78793_a(0.0f, 2.0f, 0.0f);
        this.setRotationAngle(this.Needle9, -1.309f, 3.1416f, 0.0f);
        this.Needle9.field_78804_l.add(new ModelBox(this.Needle9, 58, 0, -0.5f, -16.0f, -0.5f, 1, 12, 1, 0.0f, false));
        this.Needle10 = new ModelRenderer((ModelBase)this);
        this.Needle10.func_78793_a(0.0f, 2.0f, 0.0f);
        this.setRotationAngle(this.Needle10, -1.309f, 2.7489f, 0.0f);
        this.Needle10.field_78804_l.add(new ModelBox(this.Needle10, 58, 0, -0.5f, -16.0f, -0.5f, 1, 12, 1, 0.0f, false));
        this.Needle11 = new ModelRenderer((ModelBase)this);
        this.Needle11.func_78793_a(0.0f, 2.0f, 0.0f);
        this.setRotationAngle(this.Needle11, -1.309f, 2.3562f, 0.0f);
        this.Needle11.field_78804_l.add(new ModelBox(this.Needle11, 58, 0, -0.5f, -16.0f, -0.5f, 1, 12, 1, 0.0f, false));
        this.Needle12 = new ModelRenderer((ModelBase)this);
        this.Needle12.func_78793_a(0.0f, 2.0f, 0.0f);
        this.setRotationAngle(this.Needle12, -1.309f, 1.9635f, 0.0f);
        this.Needle12.field_78804_l.add(new ModelBox(this.Needle12, 58, 0, -0.5f, -16.0f, -0.5f, 1, 12, 1, 0.0f, false));
        this.Needle13 = new ModelRenderer((ModelBase)this);
        this.Needle13.func_78793_a(0.0f, 2.0f, 0.0f);
        this.setRotationAngle(this.Needle13, -1.309f, 1.5708f, 0.0f);
        this.Needle13.field_78804_l.add(new ModelBox(this.Needle13, 58, 0, -0.5f, -16.0f, -0.5f, 1, 12, 1, 0.0f, false));
        this.Needle14 = new ModelRenderer((ModelBase)this);
        this.Needle14.func_78793_a(0.0f, 2.0f, 0.0f);
        this.setRotationAngle(this.Needle14, -1.309f, 1.1781f, 0.0f);
        this.Needle14.field_78804_l.add(new ModelBox(this.Needle14, 58, 0, -0.5f, -16.0f, -0.5f, 1, 12, 1, 0.0f, false));
        this.Needle15 = new ModelRenderer((ModelBase)this);
        this.Needle15.func_78793_a(0.0f, 2.0f, 0.0f);
        this.setRotationAngle(this.Needle15, -1.309f, 0.7854f, 0.0f);
        this.Needle15.field_78804_l.add(new ModelBox(this.Needle15, 58, 0, -0.5f, -16.0f, -0.5f, 1, 12, 1, 0.0f, false));
        this.Needle16 = new ModelRenderer((ModelBase)this);
        this.Needle16.func_78793_a(0.0f, 2.0f, 0.0f);
        this.setRotationAngle(this.Needle16, -1.309f, 0.3927f, 0.0f);
        this.Needle16.field_78804_l.add(new ModelBox(this.Needle16, 58, 0, -0.5f, -16.0f, -0.5f, 1, 12, 1, 0.0f, false));
        this.needles.add(this.Needle1);
        this.needles.add(this.Needle2);
        this.needles.add(this.Needle3);
        this.needles.add(this.Needle4);
        this.needles.add(this.Needle5);
        this.needles.add(this.Needle6);
        this.needles.add(this.Needle7);
        this.needles.add(this.Needle8);
        this.needles.add(this.Needle9);
        this.needles.add(this.Needle10);
        this.needles.add(this.Needle11);
        this.needles.add(this.Needle12);
        this.needles.add(this.Needle13);
        this.needles.add(this.Needle14);
        this.needles.add(this.Needle15);
        this.needles.add(this.Needle16);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.OrbInner2.func_78785_a(f5);
        this.Body.func_78785_a(f5);
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)0.6f);
        this.Needle1.func_78785_a(f5);
        this.Needle2.func_78785_a(f5);
        this.Needle3.func_78785_a(f5);
        this.Needle4.func_78785_a(f5);
        this.Needle5.func_78785_a(f5);
        this.Needle6.func_78785_a(f5);
        this.Needle7.func_78785_a(f5);
        this.Needle8.func_78785_a(f5);
        this.Needle9.func_78785_a(f5);
        this.Needle10.func_78785_a(f5);
        this.Needle11.func_78785_a(f5);
        this.Needle12.func_78785_a(f5);
        this.Needle13.func_78785_a(f5);
        this.Needle14.func_78785_a(f5);
        this.Needle15.func_78785_a(f5);
        this.Needle16.func_78785_a(f5);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)0.6f);
        this.OrbInner.func_78785_a(f5);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)0.5f);
        this.Orb.func_78785_a(f5);
        GlStateManager.func_179084_k();
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        for (int i = 0; i < this.needles.size(); ++i) {
            ModelRenderer need = this.needles.get(i);
            need.field_78795_f = -1.309f + 0.1f * Mth.func_76126_a((float)((ageInTicks + (float)(i * 5)) * 0.1f));
        }
    }
}

