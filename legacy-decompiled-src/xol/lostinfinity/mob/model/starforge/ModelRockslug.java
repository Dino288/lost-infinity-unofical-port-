/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelBox
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.monster.Monster
 *  net.minecraft.util.math.Mth
 */
package xol.lostinfinity.mob.model.starforge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.util.Mth;
import xol.lostinfinity.mob.entity.starforge.EntityGiantRockslug;
import xol.lostinfinity.mob.entity.starforge.EntityRockslug;

public class ModelRockslug
extends ModelBase {
    private final ModelRenderer Body;
    private final ModelRenderer faceTendril1;
    private final ModelRenderer faceTendril2;
    private final ModelRenderer faceTendril3;
    private final ModelRenderer faceTendril4;
    private final ModelRenderer faceTendril5;
    private final ModelRenderer faceTendril6;
    private final ModelRenderer faceTendril7;
    private final ModelRenderer faceTendril8;
    private final ModelRenderer chargers;
    private final ModelRenderer Crystal;
    private List<ModelRenderer> tendrils = new ArrayList<ModelRenderer>();

    public ModelRockslug() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.Body = new ModelRenderer((ModelBase)this);
        this.Body.func_78793_a(0.0f, 7.0f, 0.0f);
        this.Body.field_78804_l.add(new ModelBox(this.Body, 0, 0, -6.0f, 4.0f, 0.0f, 12, 8, 16, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 0, 6, 3.0f, 12.0f, 5.0f, 1, 1, 7, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 0, 6, -4.0f, 12.0f, 5.0f, 1, 1, 7, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 0, 6, -2.0f, 12.0f, 5.0f, 1, 1, 7, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 0, 6, 1.0f, 12.0f, 5.0f, 1, 1, 7, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 42, 26, 0.0f, 4.0f, -5.0f, 6, 8, 5, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 42, 26, -6.0f, 4.0f, -5.0f, 6, 8, 5, 0.0f, true));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 0, 24, -5.0f, -3.0f, 12.0f, 10, 16, 16, 0.0f, false));
        this.faceTendril1 = new ModelRenderer((ModelBase)this);
        this.faceTendril1.func_78793_a(4.5f, 9.5f, 0.0f);
        this.Body.func_78792_a(this.faceTendril1);
        this.faceTendril1.field_78804_l.add(new ModelBox(this.faceTendril1, 42, 4, -0.5f, -0.5f, -9.0f, 1, 1, 10, 0.0f, false));
        this.faceTendril2 = new ModelRenderer((ModelBase)this);
        this.faceTendril2.func_78793_a(2.5f, 9.5f, 0.0f);
        this.Body.func_78792_a(this.faceTendril2);
        this.faceTendril2.field_78804_l.add(new ModelBox(this.faceTendril2, 42, 4, -0.5f, -0.5f, -9.0f, 1, 1, 10, 0.0f, false));
        this.faceTendril3 = new ModelRenderer((ModelBase)this);
        this.faceTendril3.func_78793_a(-4.5f, 9.5f, 0.0f);
        this.Body.func_78792_a(this.faceTendril3);
        this.faceTendril3.field_78804_l.add(new ModelBox(this.faceTendril3, 42, 4, -0.5f, -0.5f, -9.0f, 1, 1, 10, 0.0f, false));
        this.faceTendril4 = new ModelRenderer((ModelBase)this);
        this.faceTendril4.func_78793_a(-2.5f, 9.5f, 0.0f);
        this.Body.func_78792_a(this.faceTendril4);
        this.faceTendril4.field_78804_l.add(new ModelBox(this.faceTendril4, 42, 4, -0.5f, -0.5f, -9.0f, 1, 1, 10, 0.0f, false));
        this.faceTendril5 = new ModelRenderer((ModelBase)this);
        this.faceTendril5.func_78793_a(2.5f, 6.5f, 0.0f);
        this.Body.func_78792_a(this.faceTendril5);
        this.faceTendril5.field_78804_l.add(new ModelBox(this.faceTendril5, 42, 4, -0.5f, -0.5f, -9.0f, 1, 1, 10, 0.0f, false));
        this.faceTendril6 = new ModelRenderer((ModelBase)this);
        this.faceTendril6.func_78793_a(-2.5f, 6.5f, 0.0f);
        this.Body.func_78792_a(this.faceTendril6);
        this.faceTendril6.field_78804_l.add(new ModelBox(this.faceTendril6, 42, 4, -0.5f, -0.5f, -9.0f, 1, 1, 10, 0.0f, false));
        this.faceTendril7 = new ModelRenderer((ModelBase)this);
        this.faceTendril7.func_78793_a(-4.5f, 6.5f, 0.0f);
        this.Body.func_78792_a(this.faceTendril7);
        this.faceTendril7.field_78804_l.add(new ModelBox(this.faceTendril7, 42, 4, -0.5f, -0.5f, -9.0f, 1, 1, 10, 0.0f, false));
        this.faceTendril8 = new ModelRenderer((ModelBase)this);
        this.faceTendril8.func_78793_a(4.5f, 6.5f, 0.0f);
        this.Body.func_78792_a(this.faceTendril8);
        this.faceTendril8.field_78804_l.add(new ModelBox(this.faceTendril8, 42, 4, -0.5f, -0.5f, -9.0f, 1, 1, 10, 0.0f, false));
        this.chargers = new ModelRenderer((ModelBase)this);
        this.chargers.func_78793_a(0.0f, 7.0f, 6.0f);
        this.Body.func_78792_a(this.chargers);
        this.chargers.field_78804_l.add(new ModelBox(this.chargers, 0, 26, 2.0f, -4.0f, -5.0f, 3, 8, 3, 0.0f, false));
        this.chargers.field_78804_l.add(new ModelBox(this.chargers, 0, 26, -5.0f, -4.0f, -5.0f, 3, 8, 3, 0.0f, false));
        this.chargers.field_78804_l.add(new ModelBox(this.chargers, 0, 26, -5.0f, -4.0f, 2.0f, 3, 8, 3, 0.0f, false));
        this.chargers.field_78804_l.add(new ModelBox(this.chargers, 0, 26, 2.0f, -4.0f, 2.0f, 3, 8, 3, 0.0f, false));
        this.Crystal = new ModelRenderer((ModelBase)this);
        this.Crystal.func_78793_a(0.0f, 17.0f, 5.0f);
        this.Crystal.field_78804_l.add(new ModelBox(this.Crystal, 46, 48, 4.5f, -9.0f, 11.0f, 1, 8, 8, 0.0f, false));
        this.Crystal.field_78804_l.add(new ModelBox(this.Crystal, 46, 48, -5.5f, -9.0f, 11.0f, 1, 8, 8, 0.0f, true));
        this.tendrils.add(this.faceTendril1);
        this.tendrils.add(this.faceTendril2);
        this.tendrils.add(this.faceTendril3);
        this.tendrils.add(this.faceTendril4);
        this.tendrils.add(this.faceTendril5);
        this.tendrils.add(this.faceTendril6);
        this.tendrils.add(this.faceTendril7);
        this.tendrils.add(this.faceTendril8);
        Collections.shuffle(this.tendrils);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.Body.func_78785_a(f5);
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)0.35f);
        this.Crystal.func_78785_a(f5);
        GlStateManager.func_179084_k();
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        Monster slug;
        for (int i = 0; i < this.tendrils.size(); ++i) {
            ModelRenderer tendril = this.tendrils.get(i);
            tendril.field_78795_f = 0.2f * Mth.func_76126_a((float)(0.3f * (ageInTicks + (float)(i * 15))));
        }
        float dist = 0.0f;
        if (entityIn instanceof EntityGiantRockslug) {
            slug = (EntityGiantRockslug)entityIn;
            dist = slug.getChargerOffset();
        } else {
            slug = (EntityRockslug)entityIn;
            dist = slug.getChargerOffset();
        }
        this.chargers.field_82908_p = -dist;
    }
}

