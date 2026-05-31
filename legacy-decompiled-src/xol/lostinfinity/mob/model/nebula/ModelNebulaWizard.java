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
package xol.lostinfinity.mob.model.nebula;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import xol.lostinfinity.mob.entity.nebula.EntityNebulaWizard;

public class ModelNebulaWizard
extends ModelBase {
    private final ModelRenderer Body;
    private final ModelRenderer Bottom;
    private final ModelRenderer cube_r1;
    private final ModelRenderer Head;
    private final ModelRenderer ArmLeft1;
    private final ModelRenderer ArmRight1;
    private final ModelRenderer ArmLeft2;
    private final ModelRenderer ArmRight2;
    private final ModelRenderer BodyDuplicate;
    private final ModelRenderer Bottom2;
    private final ModelRenderer cube_r2;
    private final ModelRenderer Head2;
    private final ModelRenderer ArmLeft3;
    private final ModelRenderer ArmRight3;
    private final ModelRenderer ArmLeft4;
    private final ModelRenderer ArmRight4;

    public ModelNebulaWizard() {
        this.field_78090_t = 128;
        this.field_78089_u = 64;
        this.Body = new ModelRenderer((ModelBase)this);
        this.Body.func_78793_a(0.0f, 0.0f, 0.0f);
        this.Body.field_78804_l.add(new ModelBox(this.Body, 0, 0, -5.0f, -7.0f, -2.0f, 10, 14, 4, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 28, 9, -2.0f, -8.0f, -3.0f, 4, 16, 6, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 46, 4, -2.0f, -13.0f, -2.0f, 4, 5, 5, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 60, 34, 1.0f, -13.0f, 3.0f, 1, 20, 1, 0.0f, true));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 60, 34, -2.0f, -13.0f, 3.0f, 1, 20, 1, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 48, 16, 4.0f, -1.0f, -3.0f, 2, 11, 6, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 48, 16, -6.0f, -1.0f, -3.0f, 2, 11, 6, 0.0f, true));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 28, 0, 2.0f, -8.0f, -3.0f, 4, 2, 6, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 28, 0, -6.0f, -8.0f, -3.0f, 4, 2, 6, 0.0f, true));
        this.Bottom = new ModelRenderer((ModelBase)this);
        this.Bottom.func_78793_a(0.0f, 10.5f, 0.0f);
        this.Body.func_78792_a(this.Bottom);
        this.Bottom.field_78804_l.add(new ModelBox(this.Bottom, 27, 55, -6.0f, -0.5f, -6.0f, 12, 1, 1, 0.0f, true));
        this.Bottom.field_78804_l.add(new ModelBox(this.Bottom, 27, 55, -6.0f, -0.5f, 6.0f, 12, 1, 1, 0.0f, true));
        this.Bottom.field_78804_l.add(new ModelBox(this.Bottom, 27, 53, -6.0f, 2.5f, -6.0f, 12, 1, 1, 0.4f, true));
        this.Bottom.field_78804_l.add(new ModelBox(this.Bottom, 27, 53, -6.0f, 2.5f, 6.0f, 12, 1, 1, 0.4f, true));
        this.Bottom.field_78804_l.add(new ModelBox(this.Bottom, 27, 51, -6.0f, 6.5f, 6.0f, 12, 1, 1, 0.8f, true));
        this.Bottom.field_78804_l.add(new ModelBox(this.Bottom, 27, 51, -6.0f, 6.5f, -6.0f, 12, 1, 1, 0.8f, true));
        this.Bottom.field_78804_l.add(new ModelBox(this.Bottom, 27, 49, -6.0f, 11.5f, 6.0f, 12, 1, 1, 1.2f, true));
        this.Bottom.field_78804_l.add(new ModelBox(this.Bottom, 27, 49, -6.0f, 11.5f, -6.0f, 12, 1, 1, 1.2f, true));
        this.cube_r1 = new ModelRenderer((ModelBase)this);
        this.cube_r1.func_78793_a(0.0f, 12.0f, 6.5f);
        this.Bottom.func_78792_a(this.cube_r1);
        this.setRotationAngle(this.cube_r1, 0.0f, -1.5708f, 0.0f);
        this.cube_r1.field_78804_l.add(new ModelBox(this.cube_r1, 27, 49, -12.0f, -0.6f, 6.0f, 12, 1, 1, 1.2f, true));
        this.cube_r1.field_78804_l.add(new ModelBox(this.cube_r1, 27, 49, -12.0f, -0.6f, -7.0f, 12, 1, 1, 1.2f, true));
        this.cube_r1.field_78804_l.add(new ModelBox(this.cube_r1, 27, 51, -12.0f, -5.6f, 6.0f, 12, 1, 1, 0.8f, true));
        this.cube_r1.field_78804_l.add(new ModelBox(this.cube_r1, 27, 51, -12.0f, -5.6f, -7.0f, 12, 1, 1, 0.8f, true));
        this.cube_r1.field_78804_l.add(new ModelBox(this.cube_r1, 27, 53, -12.0f, -9.6f, -7.0f, 12, 1, 1, 0.4f, true));
        this.cube_r1.field_78804_l.add(new ModelBox(this.cube_r1, 27, 53, -12.0f, -9.6f, 6.0f, 12, 1, 1, 0.4f, true));
        this.cube_r1.field_78804_l.add(new ModelBox(this.cube_r1, 27, 55, -12.0f, -12.5f, -7.0f, 12, 1, 1, 0.0f, true));
        this.cube_r1.field_78804_l.add(new ModelBox(this.cube_r1, 27, 55, -12.0f, -12.5f, 6.0f, 12, 1, 1, 0.0f, true));
        this.Head = new ModelRenderer((ModelBase)this);
        this.Head.func_78793_a(0.0f, -13.0f, 0.0f);
        this.Body.func_78792_a(this.Head);
        this.Head.field_78804_l.add(new ModelBox(this.Head, 24, 34, -4.0f, -8.0f, -4.0f, 8, 8, 5, 0.0f, false));
        this.Head.field_78804_l.add(new ModelBox(this.Head, 43, 57, -6.0f, -7.0f, -3.0f, 2, 1, 6, 0.0f, false));
        this.Head.field_78804_l.add(new ModelBox(this.Head, 43, 57, 4.0f, -7.0f, -3.0f, 2, 1, 6, 0.0f, true));
        this.Head.field_78804_l.add(new ModelBox(this.Head, 43, 57, -6.0f, -5.0f, -3.0f, 2, 1, 6, 0.0f, false));
        this.Head.field_78804_l.add(new ModelBox(this.Head, 43, 57, 4.0f, -5.0f, -3.0f, 2, 1, 6, 0.0f, true));
        this.Head.field_78804_l.add(new ModelBox(this.Head, 0, 57, -6.0f, -3.0f, -3.0f, 2, 1, 6, 0.0f, false));
        this.Head.field_78804_l.add(new ModelBox(this.Head, 0, 57, 4.0f, -3.0f, -3.0f, 2, 1, 6, 0.0f, true));
        this.Head.field_78804_l.add(new ModelBox(this.Head, 0, 45, -5.0f, -9.0f, 1.0f, 10, 9, 3, 0.0f, false));
        this.ArmLeft1 = new ModelRenderer((ModelBase)this);
        this.ArmLeft1.func_78793_a(5.0f, -4.5f, 1.0f);
        this.Body.func_78792_a(this.ArmLeft1);
        this.setRotationAngle(this.ArmLeft1, 0.0f, 0.3491f, -0.1745f);
        this.ArmLeft1.field_78804_l.add(new ModelBox(this.ArmLeft1, 0, 19, -1.0f, -1.5f, -1.5f, 12, 2, 2, 0.0f, false));
        this.ArmLeft1.field_78804_l.add(new ModelBox(this.ArmLeft1, 0, 24, 10.0f, -1.5f, -1.5f, 12, 2, 2, -0.2f, false));
        this.ArmLeft1.field_78804_l.add(new ModelBox(this.ArmLeft1, 0, 29, 16.0f, -4.5f, -0.5f, 12, 8, 1, -0.2f, false));
        this.ArmRight1 = new ModelRenderer((ModelBase)this);
        this.ArmRight1.func_78793_a(-5.0f, -4.5f, 1.0f);
        this.Body.func_78792_a(this.ArmRight1);
        this.setRotationAngle(this.ArmRight1, 0.0f, -0.3491f, 0.1745f);
        this.ArmRight1.field_78804_l.add(new ModelBox(this.ArmRight1, 0, 19, -11.0f, -1.5f, -1.5f, 12, 2, 2, 0.0f, true));
        this.ArmRight1.field_78804_l.add(new ModelBox(this.ArmRight1, 0, 24, -22.0f, -1.5f, -1.5f, 12, 2, 2, -0.2f, true));
        this.ArmRight1.field_78804_l.add(new ModelBox(this.ArmRight1, 0, 29, -28.0f, -4.5f, -0.5f, 12, 8, 1, -0.2f, true));
        this.ArmLeft2 = new ModelRenderer((ModelBase)this);
        this.ArmLeft2.func_78793_a(5.0f, -1.5f, 1.0f);
        this.Body.func_78792_a(this.ArmLeft2);
        this.setRotationAngle(this.ArmLeft2, 0.0f, 0.6109f, 0.0873f);
        this.ArmLeft2.field_78804_l.add(new ModelBox(this.ArmLeft2, 0, 19, -1.0f, -1.5f, -1.5f, 12, 2, 2, 0.0f, false));
        this.ArmLeft2.field_78804_l.add(new ModelBox(this.ArmLeft2, 0, 24, 10.0f, -1.5f, -1.5f, 12, 2, 2, -0.2f, false));
        this.ArmLeft2.field_78804_l.add(new ModelBox(this.ArmLeft2, 0, 29, 16.0f, -4.5f, -0.5f, 12, 8, 1, -0.2f, false));
        this.ArmRight2 = new ModelRenderer((ModelBase)this);
        this.ArmRight2.func_78793_a(-5.0f, -1.5f, 1.0f);
        this.Body.func_78792_a(this.ArmRight2);
        this.setRotationAngle(this.ArmRight2, 0.0f, -0.6109f, -0.0873f);
        this.ArmRight2.field_78804_l.add(new ModelBox(this.ArmRight2, 0, 19, -11.0f, -1.5f, -1.5f, 12, 2, 2, 0.0f, true));
        this.ArmRight2.field_78804_l.add(new ModelBox(this.ArmRight2, 0, 24, -22.0f, -1.5f, -1.5f, 12, 2, 2, -0.2f, true));
        this.ArmRight2.field_78804_l.add(new ModelBox(this.ArmRight2, 0, 29, -28.0f, -4.5f, -0.5f, 12, 8, 1, -0.2f, true));
        this.BodyDuplicate = new ModelRenderer((ModelBase)this);
        this.BodyDuplicate.func_78793_a(0.0f, 0.0f, 0.0f);
        this.BodyDuplicate.field_78804_l.add(new ModelBox(this.BodyDuplicate, 64, 0, -5.0f, -7.0f, -2.0f, 10, 14, 4, 0.2f, false));
        this.BodyDuplicate.field_78804_l.add(new ModelBox(this.BodyDuplicate, 92, 9, -2.0f, -8.0f, -3.0f, 4, 16, 6, 0.2f, false));
        this.BodyDuplicate.field_78804_l.add(new ModelBox(this.BodyDuplicate, 110, 4, -2.0f, -13.0f, -2.0f, 4, 5, 5, 0.2f, false));
        this.BodyDuplicate.field_78804_l.add(new ModelBox(this.BodyDuplicate, 124, 34, 1.0f, -13.0f, 3.0f, 1, 20, 1, 0.2f, true));
        this.BodyDuplicate.field_78804_l.add(new ModelBox(this.BodyDuplicate, 124, 34, -2.0f, -13.0f, 3.0f, 1, 20, 1, 0.2f, false));
        this.BodyDuplicate.field_78804_l.add(new ModelBox(this.BodyDuplicate, 112, 16, 4.0f, -1.0f, -3.0f, 2, 11, 6, 0.2f, false));
        this.BodyDuplicate.field_78804_l.add(new ModelBox(this.BodyDuplicate, 112, 16, -6.0f, -1.0f, -3.0f, 2, 11, 6, 0.2f, true));
        this.BodyDuplicate.field_78804_l.add(new ModelBox(this.BodyDuplicate, 92, 0, 2.0f, -8.0f, -3.0f, 4, 2, 6, 0.2f, false));
        this.BodyDuplicate.field_78804_l.add(new ModelBox(this.BodyDuplicate, 92, 0, -6.0f, -8.0f, -3.0f, 4, 2, 6, 0.2f, true));
        this.Bottom2 = new ModelRenderer((ModelBase)this);
        this.Bottom2.func_78793_a(0.0f, 10.5f, 0.0f);
        this.BodyDuplicate.func_78792_a(this.Bottom2);
        this.Bottom2.field_78804_l.add(new ModelBox(this.Bottom2, 91, 55, -6.0f, -0.5f, -6.0f, 12, 1, 1, 0.2f, true));
        this.Bottom2.field_78804_l.add(new ModelBox(this.Bottom2, 91, 55, -6.0f, -0.5f, 6.0f, 12, 1, 1, 0.2f, true));
        this.Bottom2.field_78804_l.add(new ModelBox(this.Bottom2, 91, 53, -6.0f, 2.5f, -6.0f, 12, 1, 1, 0.6f, true));
        this.Bottom2.field_78804_l.add(new ModelBox(this.Bottom2, 91, 53, -6.0f, 2.5f, 6.0f, 12, 1, 1, 0.6f, true));
        this.Bottom2.field_78804_l.add(new ModelBox(this.Bottom2, 91, 51, -6.0f, 6.5f, 6.0f, 12, 1, 1, 1.0f, true));
        this.Bottom2.field_78804_l.add(new ModelBox(this.Bottom2, 91, 51, -6.0f, 6.5f, -6.0f, 12, 1, 1, 1.0f, true));
        this.Bottom2.field_78804_l.add(new ModelBox(this.Bottom2, 91, 49, -6.0f, 11.5f, 6.0f, 12, 1, 1, 1.6f, true));
        this.Bottom2.field_78804_l.add(new ModelBox(this.Bottom2, 91, 49, -6.0f, 11.5f, -6.0f, 12, 1, 1, 1.6f, true));
        this.cube_r2 = new ModelRenderer((ModelBase)this);
        this.cube_r2.func_78793_a(0.0f, 12.0f, 6.5f);
        this.Bottom2.func_78792_a(this.cube_r2);
        this.setRotationAngle(this.cube_r2, 0.0f, -1.5708f, 0.0f);
        this.cube_r2.field_78804_l.add(new ModelBox(this.cube_r2, 91, 49, -12.0f, -0.6f, 6.0f, 12, 1, 1, 1.6f, true));
        this.cube_r2.field_78804_l.add(new ModelBox(this.cube_r2, 91, 49, -12.0f, -0.6f, -7.0f, 12, 1, 1, 1.6f, true));
        this.cube_r2.field_78804_l.add(new ModelBox(this.cube_r2, 91, 51, -12.0f, -5.6f, 6.0f, 12, 1, 1, 1.0f, true));
        this.cube_r2.field_78804_l.add(new ModelBox(this.cube_r2, 91, 51, -12.0f, -5.6f, -7.0f, 12, 1, 1, 1.0f, true));
        this.cube_r2.field_78804_l.add(new ModelBox(this.cube_r2, 91, 53, -12.0f, -9.6f, -7.0f, 12, 1, 1, 0.6f, true));
        this.cube_r2.field_78804_l.add(new ModelBox(this.cube_r2, 91, 53, -12.0f, -9.6f, 6.0f, 12, 1, 1, 0.6f, true));
        this.cube_r2.field_78804_l.add(new ModelBox(this.cube_r2, 91, 55, -12.0f, -12.5f, -7.0f, 12, 1, 1, 0.2f, true));
        this.cube_r2.field_78804_l.add(new ModelBox(this.cube_r2, 91, 55, -12.0f, -12.5f, 6.0f, 12, 1, 1, 0.2f, true));
        this.Head2 = new ModelRenderer((ModelBase)this);
        this.Head2.func_78793_a(0.0f, -13.0f, 0.0f);
        this.BodyDuplicate.func_78792_a(this.Head2);
        this.Head2.field_78804_l.add(new ModelBox(this.Head2, 88, 34, -4.0f, -8.0f, -4.0f, 8, 8, 5, 0.2f, false));
        this.Head2.field_78804_l.add(new ModelBox(this.Head2, 107, 57, -6.0f, -7.0f, -3.0f, 2, 1, 6, 0.2f, false));
        this.Head2.field_78804_l.add(new ModelBox(this.Head2, 107, 57, 4.0f, -7.0f, -3.0f, 2, 1, 6, 0.2f, true));
        this.Head2.field_78804_l.add(new ModelBox(this.Head2, 107, 57, -6.0f, -5.0f, -3.0f, 2, 1, 6, 0.2f, false));
        this.Head2.field_78804_l.add(new ModelBox(this.Head2, 107, 57, 4.0f, -5.0f, -3.0f, 2, 1, 6, 0.2f, true));
        this.Head2.field_78804_l.add(new ModelBox(this.Head2, 64, 57, -6.0f, -3.0f, -3.0f, 2, 1, 6, 0.2f, false));
        this.Head2.field_78804_l.add(new ModelBox(this.Head2, 64, 57, 4.0f, -3.0f, -3.0f, 2, 1, 6, 0.2f, true));
        this.Head2.field_78804_l.add(new ModelBox(this.Head2, 64, 45, -5.0f, -9.0f, 1.0f, 10, 9, 3, 0.2f, false));
        this.ArmLeft3 = new ModelRenderer((ModelBase)this);
        this.ArmLeft3.func_78793_a(5.0f, -4.5f, 1.0f);
        this.BodyDuplicate.func_78792_a(this.ArmLeft3);
        this.setRotationAngle(this.ArmLeft3, 0.0f, 0.3491f, -0.1745f);
        this.ArmLeft3.field_78804_l.add(new ModelBox(this.ArmLeft3, 64, 19, -1.0f, -1.5f, -1.5f, 12, 2, 2, 0.2f, false));
        this.ArmLeft3.field_78804_l.add(new ModelBox(this.ArmLeft3, 64, 24, 10.0f, -1.5f, -1.5f, 12, 2, 2, 0.2f, false));
        this.ArmLeft3.field_78804_l.add(new ModelBox(this.ArmLeft3, 64, 29, 16.0f, -4.5f, -0.5f, 12, 8, 1, 0.2f, false));
        this.ArmRight3 = new ModelRenderer((ModelBase)this);
        this.ArmRight3.func_78793_a(-5.0f, -4.5f, 1.0f);
        this.BodyDuplicate.func_78792_a(this.ArmRight3);
        this.setRotationAngle(this.ArmRight3, 0.0f, -0.3491f, 0.1745f);
        this.ArmRight3.field_78804_l.add(new ModelBox(this.ArmRight3, 64, 19, -11.0f, -1.5f, -1.5f, 12, 2, 2, 0.2f, true));
        this.ArmRight3.field_78804_l.add(new ModelBox(this.ArmRight3, 64, 24, -22.0f, -1.5f, -1.5f, 12, 2, 2, 0.2f, true));
        this.ArmRight3.field_78804_l.add(new ModelBox(this.ArmRight3, 64, 29, -28.0f, -4.5f, -0.5f, 12, 8, 1, 0.2f, true));
        this.ArmLeft4 = new ModelRenderer((ModelBase)this);
        this.ArmLeft4.func_78793_a(5.0f, -1.5f, 1.0f);
        this.BodyDuplicate.func_78792_a(this.ArmLeft4);
        this.setRotationAngle(this.ArmLeft4, 0.0f, 0.6109f, 0.0873f);
        this.ArmLeft4.field_78804_l.add(new ModelBox(this.ArmLeft4, 64, 19, -1.0f, -1.5f, -1.5f, 12, 2, 2, 0.2f, false));
        this.ArmLeft4.field_78804_l.add(new ModelBox(this.ArmLeft4, 64, 24, 10.0f, -1.5f, -1.5f, 12, 2, 2, 0.2f, false));
        this.ArmLeft4.field_78804_l.add(new ModelBox(this.ArmLeft4, 64, 29, 16.0f, -4.5f, -0.5f, 12, 8, 1, 0.2f, false));
        this.ArmRight4 = new ModelRenderer((ModelBase)this);
        this.ArmRight4.func_78793_a(-5.0f, -1.5f, 1.0f);
        this.BodyDuplicate.func_78792_a(this.ArmRight4);
        this.setRotationAngle(this.ArmRight4, 0.0f, -0.6109f, -0.0873f);
        this.ArmRight4.field_78804_l.add(new ModelBox(this.ArmRight4, 64, 19, -11.0f, -1.5f, -1.5f, 12, 2, 2, 0.2f, true));
        this.ArmRight4.field_78804_l.add(new ModelBox(this.ArmRight4, 64, 24, -22.0f, -1.5f, -1.5f, 12, 2, 2, 0.2f, true));
        this.ArmRight4.field_78804_l.add(new ModelBox(this.ArmRight4, 64, 29, -28.0f, -4.5f, -0.5f, 12, 8, 1, 0.2f, true));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        EntityNebulaWizard nebula = (EntityNebulaWizard)entity;
        float baseAlpha = nebula.getModelAlpha();
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)baseAlpha);
        this.Body.func_78785_a(f5);
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)(baseAlpha * (0.5f + 0.5f * Mth.func_76126_a((float)(f2 * 0.2f)))));
        this.BodyDuplicate.func_78785_a(f5);
        GlStateManager.func_179084_k();
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        float armSpeed = 0.2f;
        float armRange = 0.4f;
        this.ArmLeft1.field_78796_g = Mth.func_76134_b((float)(ageInTicks * armSpeed)) * armRange;
        this.ArmLeft3.field_78796_g = Mth.func_76134_b((float)(ageInTicks * armSpeed)) * armRange;
        this.ArmLeft2.field_78796_g = Mth.func_76134_b((float)((ageInTicks + 5.0f) * armSpeed)) * armRange;
        this.ArmLeft4.field_78796_g = Mth.func_76134_b((float)((ageInTicks + 5.0f) * armSpeed)) * armRange;
        this.ArmRight1.field_78796_g = Mth.func_76134_b((float)(ageInTicks * armSpeed)) * armRange;
        this.ArmRight3.field_78796_g = Mth.func_76134_b((float)(ageInTicks * armSpeed)) * armRange;
        this.ArmRight2.field_78796_g = Mth.func_76134_b((float)((ageInTicks + 5.0f) * armSpeed)) * armRange;
        this.ArmRight4.field_78796_g = Mth.func_76134_b((float)((ageInTicks + 5.0f) * armSpeed)) * armRange;
        this.Bottom.field_78796_g = 0.1f * ageInTicks;
        this.Bottom.field_78808_h = 0.2f * Mth.func_76126_a((float)(ageInTicks * 0.2f));
        this.Bottom2.field_78796_g = this.Bottom.field_78796_g;
        this.Bottom2.field_78808_h = this.Bottom.field_78808_h;
    }
}

