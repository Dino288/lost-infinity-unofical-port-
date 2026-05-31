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
package xol.lostinfinity.mob.model.starforge;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import xol.lostinfinity.mob.entity.starforge.EntityRockworm;

public class ModelRockworm
extends ModelBase {
    private final ModelRenderer Body;
    private final ModelRenderer Body2;
    private final ModelRenderer Body3;
    private final ModelRenderer Body4;
    private final ModelRenderer Body5;
    private final ModelRenderer Body6;
    private List<ModelRenderer> Segments = new ArrayList<ModelRenderer>();

    public ModelRockworm() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        this.Body = new ModelRenderer((ModelBase)this);
        this.Body.func_78793_a(0.0f, 17.5f, -3.0f);
        this.Body.field_78804_l.add(new ModelBox(this.Body, 0, 0, -6.0f, -6.0f, -5.0f, 12, 12, 10, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 3, 4, 2.0f, -5.0f, -6.0f, 1, 1, 1, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 3, 4, -3.0f, -5.0f, -6.0f, 1, 1, 1, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 3, 4, -5.0f, -3.0f, -6.0f, 1, 1, 1, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 3, 4, -5.0f, 2.0f, -6.0f, 1, 1, 1, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 3, 4, -3.0f, 4.0f, -6.0f, 1, 1, 1, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 3, 4, 4.0f, -3.0f, -6.0f, 1, 1, 1, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 3, 4, 4.0f, 2.0f, -6.0f, 1, 1, 1, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 3, 4, 4.0f, -0.5f, -6.0f, 1, 1, 1, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 3, 4, -5.0f, -0.5f, -6.0f, 1, 1, 1, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 3, 4, 2.0f, 4.0f, -6.0f, 1, 1, 1, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 3, 4, -0.5f, 4.0f, -6.0f, 1, 1, 1, 0.0f, false));
        this.Body.field_78804_l.add(new ModelBox(this.Body, 3, 4, -0.5f, -5.0f, -6.0f, 1, 1, 1, 0.0f, false));
        this.Body2 = new ModelRenderer((ModelBase)this);
        this.Body2.func_78793_a(0.0f, 0.0f, 4.0f);
        this.Body.func_78792_a(this.Body2);
        this.Body2.field_78804_l.add(new ModelBox(this.Body2, 20, 22, -6.0f, -6.0f, 0.0f, 12, 12, 10, -0.2f, false));
        this.Body2.field_78804_l.add(new ModelBox(this.Body2, 0, 23, -3.0f, -6.0f, 2.0f, 6, 1, 6, 0.0f, false));
        this.Body3 = new ModelRenderer((ModelBase)this);
        this.Body3.func_78793_a(0.0f, 0.0f, 9.0f);
        this.Body2.func_78792_a(this.Body3);
        this.Body3.field_78804_l.add(new ModelBox(this.Body3, 20, 22, -6.0f, -6.0f, 0.0f, 12, 12, 10, -0.4f, true));
        this.Body3.field_78804_l.add(new ModelBox(this.Body3, 0, 23, -3.0f, -6.0f, 2.0f, 6, 1, 6, 0.0f, false));
        this.Body4 = new ModelRenderer((ModelBase)this);
        this.Body4.func_78793_a(0.0f, 0.0f, 9.0f);
        this.Body3.func_78792_a(this.Body4);
        this.Body4.field_78804_l.add(new ModelBox(this.Body4, 20, 22, -6.0f, -6.0f, 0.0f, 12, 12, 10, -0.6f, false));
        this.Body4.field_78804_l.add(new ModelBox(this.Body4, 0, 23, -3.0f, -6.0f, 2.0f, 6, 1, 6, 0.0f, false));
        this.Body5 = new ModelRenderer((ModelBase)this);
        this.Body5.func_78793_a(0.0f, 0.0f, 8.0f);
        this.Body4.func_78792_a(this.Body5);
        this.Body5.field_78804_l.add(new ModelBox(this.Body5, 20, 22, -6.0f, -6.0f, 0.0f, 12, 12, 10, -0.8f, true));
        this.Body5.field_78804_l.add(new ModelBox(this.Body5, 0, 23, -3.0f, -5.5f, 2.0f, 6, 1, 6, 0.0f, false));
        this.Body6 = new ModelRenderer((ModelBase)this);
        this.Body6.func_78793_a(0.0f, 0.0f, 8.0f);
        this.Body5.func_78792_a(this.Body6);
        this.Body6.field_78804_l.add(new ModelBox(this.Body6, 0, 44, -6.0f, -6.0f, 0.0f, 12, 12, 8, -1.0f, false));
        this.Segments.add(this.Body);
        this.Segments.add(this.Body2);
        this.Segments.add(this.Body3);
        this.Segments.add(this.Body4);
        this.Segments.add(this.Body5);
        this.Segments.add(this.Body6);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.Body.func_78785_a(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        EntityRockworm worm = (EntityRockworm)entityIn;
        if (worm.isAwake()) {
            float goalAngle = 0.0f;
            for (int i = 0; i < this.Segments.size(); ++i) {
                ModelRenderer piece = this.Segments.get(i);
                switch (i) {
                    case 0: {
                        goalAngle = 0.1f * Mth.func_76126_a((float)(ageInTicks * 0.1f));
                        break;
                    }
                    case 1: {
                        goalAngle = 0.2f * Mth.func_76126_a((float)(ageInTicks * 0.1f));
                        break;
                    }
                    case 2: {
                        goalAngle = 0.2f * Mth.func_76126_a((float)(ageInTicks * 0.1f));
                        break;
                    }
                    case 3: {
                        goalAngle = -0.4f * Mth.func_76126_a((float)(ageInTicks * 0.1f));
                        break;
                    }
                    case 4: {
                        goalAngle = -0.4f * Mth.func_76126_a((float)(ageInTicks * 0.1f));
                        break;
                    }
                    case 5: {
                        goalAngle = -0.4f * Mth.func_76126_a((float)(ageInTicks * 0.1f));
                    }
                }
                if (Math.abs(piece.field_78796_g - goalAngle) > 0.01f) {
                    if (piece.field_78796_g < goalAngle) {
                        piece.field_78796_g += 0.005f;
                        continue;
                    }
                    piece.field_78796_g -= 0.005f;
                    continue;
                }
                piece.field_78796_g = goalAngle;
            }
        } else {
            for (int i = 0; i < this.Segments.size(); ++i) {
                float goalAngle = i == 0 ? 0.0f : 0.6f;
                ModelRenderer piece = this.Segments.get(i);
                if (!(Math.abs(piece.field_78796_g - goalAngle) > 0.01f)) continue;
                if (piece.field_78796_g < goalAngle) {
                    piece.field_78796_g += 0.005f;
                    continue;
                }
                piece.field_78796_g -= 0.005f;
            }
        }
    }
}

