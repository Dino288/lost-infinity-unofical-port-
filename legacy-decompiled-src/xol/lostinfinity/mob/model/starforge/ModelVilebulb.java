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

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;

public class ModelVilebulb
extends ModelBase {
    private final ModelRenderer Cube;
    private final ModelRenderer bone;
    private final ModelRenderer bone4;
    private final ModelRenderer bone5;
    private final ModelRenderer bone6;
    private final ModelRenderer bone2;
    private final ModelRenderer bone3;

    public ModelVilebulb() {
        this.field_78090_t = 64;
        this.field_78089_u = 32;
        this.Cube = new ModelRenderer((ModelBase)this);
        this.Cube.func_78793_a(0.0f, 16.0f, 0.0f);
        this.Cube.field_78804_l.add(new ModelBox(this.Cube, 0, 0, -8.0f, -8.0f, -8.0f, 16, 16, 16, 0.0f, false));
        this.bone = new ModelRenderer((ModelBase)this);
        this.bone.func_78793_a(0.0f, -8.0f, 0.0f);
        this.Cube.func_78792_a(this.bone);
        this.bone.field_78804_l.add(new ModelBox(this.bone, 1, 1, 6.0f, -9.0f, -7.0f, 1, 9, 1, 0.0f, false));
        this.bone.field_78804_l.add(new ModelBox(this.bone, 1, 1, -7.0f, -9.0f, -7.0f, 1, 9, 1, 0.0f, false));
        this.bone.field_78804_l.add(new ModelBox(this.bone, 1, 1, -7.0f, -9.0f, 6.0f, 1, 9, 1, 0.0f, false));
        this.bone.field_78804_l.add(new ModelBox(this.bone, 1, 1, 6.0f, -9.0f, 6.0f, 1, 9, 1, 0.0f, false));
        this.bone4 = new ModelRenderer((ModelBase)this);
        this.bone4.func_78793_a(0.0f, 8.0f, 0.0f);
        this.Cube.func_78792_a(this.bone4);
        this.setRotationAngle(this.bone4, 0.0f, 0.0f, -3.1416f);
        this.bone4.field_78804_l.add(new ModelBox(this.bone4, 1, 1, 6.0f, -9.0f, -7.0f, 1, 9, 1, 0.0f, false));
        this.bone4.field_78804_l.add(new ModelBox(this.bone4, 1, 1, -7.0f, -9.0f, -7.0f, 1, 9, 1, 0.0f, false));
        this.bone4.field_78804_l.add(new ModelBox(this.bone4, 1, 1, -7.0f, -9.0f, 6.0f, 1, 9, 1, 0.0f, false));
        this.bone4.field_78804_l.add(new ModelBox(this.bone4, 1, 1, 6.0f, -9.0f, 6.0f, 1, 9, 1, 0.0f, false));
        this.bone5 = new ModelRenderer((ModelBase)this);
        this.bone5.func_78793_a(0.0f, 0.0f, 8.0f);
        this.Cube.func_78792_a(this.bone5);
        this.setRotationAngle(this.bone5, -1.5708f, 0.0f, -3.1416f);
        this.bone5.field_78804_l.add(new ModelBox(this.bone5, 1, 1, 6.0f, -9.0f, -7.0f, 1, 9, 1, 0.0f, false));
        this.bone5.field_78804_l.add(new ModelBox(this.bone5, 1, 1, -7.0f, -9.0f, -7.0f, 1, 9, 1, 0.0f, false));
        this.bone5.field_78804_l.add(new ModelBox(this.bone5, 1, 1, -7.0f, -9.0f, 6.0f, 1, 9, 1, 0.0f, false));
        this.bone5.field_78804_l.add(new ModelBox(this.bone5, 1, 1, 6.0f, -9.0f, 6.0f, 1, 9, 1, 0.0f, false));
        this.bone6 = new ModelRenderer((ModelBase)this);
        this.bone6.func_78793_a(0.0f, 0.0f, -8.0f);
        this.Cube.func_78792_a(this.bone6);
        this.setRotationAngle(this.bone6, 1.5708f, 0.0f, -3.1416f);
        this.bone6.field_78804_l.add(new ModelBox(this.bone6, 1, 1, 6.0f, -9.0f, -7.0f, 1, 9, 1, 0.0f, false));
        this.bone6.field_78804_l.add(new ModelBox(this.bone6, 1, 1, -7.0f, -9.0f, -7.0f, 1, 9, 1, 0.0f, false));
        this.bone6.field_78804_l.add(new ModelBox(this.bone6, 1, 1, -7.0f, -9.0f, 6.0f, 1, 9, 1, 0.0f, false));
        this.bone6.field_78804_l.add(new ModelBox(this.bone6, 1, 1, 6.0f, -9.0f, 6.0f, 1, 9, 1, 0.0f, false));
        this.bone2 = new ModelRenderer((ModelBase)this);
        this.bone2.func_78793_a(8.0f, 0.0f, 0.0f);
        this.Cube.func_78792_a(this.bone2);
        this.setRotationAngle(this.bone2, 0.0f, 0.0f, 1.5708f);
        this.bone2.field_78804_l.add(new ModelBox(this.bone2, 1, 1, 6.0f, -9.0f, -7.0f, 1, 9, 1, 0.0f, false));
        this.bone2.field_78804_l.add(new ModelBox(this.bone2, 1, 1, -7.0f, -9.0f, -7.0f, 1, 9, 1, 0.0f, false));
        this.bone2.field_78804_l.add(new ModelBox(this.bone2, 1, 1, -7.0f, -9.0f, 6.0f, 1, 9, 1, 0.0f, false));
        this.bone2.field_78804_l.add(new ModelBox(this.bone2, 1, 1, 6.0f, -9.0f, 6.0f, 1, 9, 1, 0.0f, false));
        this.bone3 = new ModelRenderer((ModelBase)this);
        this.bone3.func_78793_a(-8.0f, 0.0f, 0.0f);
        this.Cube.func_78792_a(this.bone3);
        this.setRotationAngle(this.bone3, 0.0f, 0.0f, -1.5708f);
        this.bone3.field_78804_l.add(new ModelBox(this.bone3, 1, 1, -7.0f, -9.0f, -7.0f, 1, 9, 1, 0.0f, true));
        this.bone3.field_78804_l.add(new ModelBox(this.bone3, 1, 1, 6.0f, -9.0f, -7.0f, 1, 9, 1, 0.0f, true));
        this.bone3.field_78804_l.add(new ModelBox(this.bone3, 1, 1, 6.0f, -9.0f, 6.0f, 1, 9, 1, 0.0f, true));
        this.bone3.field_78804_l.add(new ModelBox(this.bone3, 1, 1, -7.0f, -9.0f, 6.0f, 1, 9, 1, 0.0f, true));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)(0.6f + 0.2f * Mth.func_76126_a((float)(f2 * 0.1f))));
        this.Cube.func_78785_a(f5);
        GlStateManager.func_179084_k();
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
    }
}

