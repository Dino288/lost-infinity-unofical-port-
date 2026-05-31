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
package xol.lostinfinity.mob.model.minion;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import xol.lostinfinity.mob.entity.minion.EntityLostBlade;
import xol.lostinfinity.util.math.LMath;

public class ModelLostBlade
extends ModelBase {
    private final ModelRenderer lostBlade;
    private final ModelRenderer lostBladeParts;

    public ModelLostBlade() {
        this.field_78090_t = 256;
        this.field_78089_u = 256;
        this.lostBlade = new ModelRenderer((ModelBase)this);
        this.lostBlade.func_78793_a(0.0f, 24.0f, 0.0f);
        this.lostBladeParts = new ModelRenderer((ModelBase)this);
        this.lostBladeParts.func_78793_a(0.0f, 0.0f, 0.0f);
        this.lostBlade.func_78792_a(this.lostBladeParts);
        this.setRotationAngle(this.lostBladeParts, 0.0f, -0.7854f, 0.0f);
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 8, 3, 12.0f, -0.5f, 31.0f, 2, 1, 1, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 8, 7, 29.0f, -0.5f, 31.0f, 2, 1, 1, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 0, 0, 11.0f, -0.5f, 29.0f, 1, 1, 2, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 0, 3, 31.0f, -0.5f, 29.0f, 1, 1, 2, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 0, 22, 12.0f, -0.5f, 28.0f, 3, 1, 3, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 19, 24, 28.0f, -0.5f, 28.0f, 3, 1, 3, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 0, 16, 19.0f, -0.5f, 26.0f, 1, 1, 1, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 19, 16, 11.0f, -0.5f, 25.0f, 4, 1, 3, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 17, 2, 22.0f, -0.5f, 25.0f, 1, 1, 1, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 19, 20, 28.0f, -0.5f, 25.0f, 4, 1, 3, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 25, 93, 15.0f, -0.5f, 24.0f, 1, 1, 8, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 93, 57, 27.0f, -0.5f, 24.0f, 1, 1, 8, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 85, 84, 16.0f, -0.5f, 23.0f, 1, 1, 9, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 91, 26, 26.0f, -0.5f, 23.0f, 1, 1, 9, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 17, 4, 0.0f, -0.5f, 22.0f, 1, 1, 1, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 72, 11, 25.0f, -0.5f, 22.0f, 1, 1, 10, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 17, 8, -2.0f, -0.5f, 20.0f, 1, 1, 1, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 17, 10, 25.0f, -0.5f, 20.0f, 1, 1, 1, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 8, 9, -3.0f, -0.5f, 19.0f, 2, 1, 1, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 0, 10, 25.0f, -0.5f, 19.0f, 2, 1, 1, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 17, 12, -5.0f, -0.5f, 17.0f, 1, 1, 1, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 0, 26, -4.0f, -0.5f, 17.0f, 3, 1, 2, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 0, 92, 21.0f, -0.5f, 17.0f, 2, 1, 8, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 0, 65, 19.0f, -0.5f, 16.0f, 2, 1, 10, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 62, 35, 23.0f, -0.5f, 16.0f, 1, 1, 11, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 25, 8, 9.0f, -0.5f, 15.0f, 1, 1, 3, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 0, 18, 11.0f, -0.5f, 15.0f, 1, 1, 1, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 0, 35, 18.0f, -0.5f, 15.0f, 1, 1, 13, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 31, 35, 24.0f, -0.5f, 15.0f, 1, 1, 13, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 26, 0, 31.0f, -0.5f, 15.0f, 1, 1, 3, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 12, 30, -10.0f, -0.5f, 14.0f, 1, 1, 3, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 8, 11, 10.0f, -0.5f, 14.0f, 2, 1, 1, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 93, 108, 17.0f, -0.5f, 13.0f, 1, 1, 19, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 0, 16, -9.0f, -0.5f, 12.0f, 1, 1, 5, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 30, 66, -1.0f, -0.5f, 12.0f, 2, 1, 10, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 91, 36, 16.0f, -0.5f, 12.0f, 1, 1, 9, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 0, 0, 28.0f, -0.5f, 12.0f, 1, 1, 6, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 0, 7, 31.0f, -0.5f, 12.0f, 1, 1, 2, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 62, 57, -8.0f, -0.5f, 11.0f, 7, 1, 6, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 93, 66, 15.0f, -0.5f, 11.0f, 1, 1, 8, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 30, 77, 25.0f, -0.5f, 11.0f, 3, 1, 8, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 58, 84, 29.0f, -0.5f, 11.0f, 2, 1, 7, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 85, 94, 14.0f, -0.5f, 10.0f, 1, 1, 8, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 7, 16, 15.0f, -0.5f, 9.0f, 2, 1, 1, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 0, 35, -8.0f, -0.5f, 2.0f, 1, 1, 4, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 0, 16, 9.0f, -0.5f, 1.0f, 3, 1, 13, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 99, 0, 8.0f, -0.5f, 0.0f, 1, 1, 20, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 0, 7, 22.0f, -0.5f, 0.0f, 1, 1, 6, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 61, 84, 7.0f, -0.5f, -1.0f, 1, 1, 22, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 99, 0, 21.0f, -0.5f, -1.0f, 1, 1, 8, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 0, 76, 20.0f, -0.5f, -2.0f, 1, 1, 10, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 31, 67, 6.0f, -0.5f, -3.0f, 1, 1, 25, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 0, 49, 19.0f, -0.5f, -3.0f, 1, 1, 12, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 42, 0, 18.0f, -0.5f, -4.0f, 1, 1, 13, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 7, 18, -10.0f, -0.5f, -5.0f, 1, 1, 1, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 0, 0, 17.0f, -0.5f, -5.0f, 1, 1, 15, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 20, 3, -12.0f, -0.5f, -6.0f, 1, 1, 1, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 0, 35, 5.0f, -0.5f, -6.0f, 1, 1, 29, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 17, 0, 11.0f, -0.5f, -8.0f, 1, 1, 7, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 0, 65, 12.0f, -0.5f, -9.0f, 2, 1, 26, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 15, 35, -15.0f, -0.5f, -10.0f, 1, 1, 4, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 93, 57, 14.0f, -0.5f, -10.0f, 3, 1, 19, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 0, 0, 1.0f, -0.5f, -11.0f, 4, 1, 34, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 17, 8, -14.0f, -0.5f, -12.0f, 1, 1, 6, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 49, 107, 0.0f, -0.5f, -12.0f, 1, 1, 20, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 71, 108, -1.0f, -0.5f, -13.0f, 1, 1, 20, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 17, 30, -27.0f, -0.5f, -15.0f, 4, 1, 1, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 85, 85, -2.0f, -0.5f, -15.0f, 1, 1, 22, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 72, 0, -13.0f, -0.5f, -16.0f, 2, 1, 10, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 17, 0, -22.0f, -0.5f, -17.0f, 2, 1, 1, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 72, 0, -3.0f, -0.5f, -18.0f, 1, 1, 25, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 65, 57, -4.0f, -0.5f, -20.0f, 1, 1, 26, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 62, 29, -5.0f, -0.5f, -21.0f, 1, 1, 27, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 42, 0, -6.0f, -0.5f, -22.0f, 1, 1, 28, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 8, 0, -28.0f, -0.5f, -23.0f, 1, 1, 2, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 62, 47, -27.0f, -0.5f, -23.0f, 5, 1, 8, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 31, 36, -7.0f, -0.5f, -23.0f, 1, 1, 29, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 25, 93, -8.0f, -0.5f, -24.0f, 1, 1, 21, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 91, 26, -9.0f, -0.5f, -25.0f, 1, 1, 22, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 20, 5, -30.0f, -0.5f, -26.0f, 1, 1, 1, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 0, 92, -11.0f, -0.5f, -26.0f, 2, 1, 21, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 42, 14, -14.0f, -0.5f, -27.0f, 3, 1, 11, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 26, 4, -31.0f, -0.5f, -28.0f, 2, 1, 2, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 31, 49, -16.0f, -0.5f, -28.0f, 2, 1, 11, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 48, 93, -19.0f, -0.5f, -29.0f, 3, 1, 12, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 58, 66, -22.0f, -0.5f, -30.0f, 3, 1, 13, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 0, 30, -32.0f, -0.5f, -31.0f, 3, 1, 3, 0.0f, false));
        this.lostBladeParts.field_78804_l.add(new ModelBox(this.lostBladeParts, 109, 84, -29.0f, -0.5f, -31.0f, 7, 1, 8, 0.0f, false));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.lostBlade.func_78785_a(f5);
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        EntityLostBlade blade = (EntityLostBlade)entityIn;
        if (blade.isActive()) {
            double dX = blade.field_70159_w;
            double dY = blade.field_70181_x;
            double dZ = blade.field_70179_y;
            double hMagnitude = LMath.fastSqrt(dX * dX + dZ * dZ);
            this.lostBlade.field_78795_f = (float)Mth.func_181159_b((double)(-dY), (double)hMagnitude);
            this.lostBlade.field_78796_g = (float)Mth.func_181159_b((double)(-dX), (double)dZ);
            this.lostBlade.field_78808_h = 0.0f;
        } else {
            this.lostBlade.field_78795_f = 1.5707964f;
            this.lostBlade.field_78796_g = 0.0f;
            float angle = 0.0f;
            switch (blade.getPose()) {
                case 0: {
                    angle = -15.0f;
                    break;
                }
                case 1: {
                    angle = -30.0f;
                    break;
                }
                case 2: {
                    angle = -45.0f;
                    break;
                }
                case 3: {
                    angle = 15.0f;
                    break;
                }
                case 4: {
                    angle = 30.0f;
                    break;
                }
                case 5: {
                    angle = 45.0f;
                }
            }
            this.lostBlade.field_78808_h = angle * ((float)Math.PI / 180);
        }
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }
}

