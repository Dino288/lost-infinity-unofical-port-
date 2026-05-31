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
package xol.lostinfinity.mob.model.galaxy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;

public class ModelGalaxyGulper
extends ModelBase {
    private final ModelRenderer mouth_middle;
    private final ModelRenderer mouth_left;
    private final ModelRenderer mouth_right;
    private final ModelRenderer mainbody;
    private final ModelRenderer spine1;
    private final ModelRenderer cube_r1;
    private final ModelRenderer spine2;
    private final ModelRenderer cube_r2;
    private final ModelRenderer spine3;
    private final ModelRenderer cube_r3;
    private final ModelRenderer fbone1;
    private final ModelRenderer fbone2;
    private final ModelRenderer fbone3;
    private final ModelRenderer fbone4;
    private final ModelRenderer fbone5;
    private final ModelRenderer fbone6;
    private final ModelRenderer fbone7;
    private final ModelRenderer fbone8;
    private final ModelRenderer fbone9;
    private final ModelRenderer fbone10;
    private final ModelRenderer fbone11;
    private final ModelRenderer fbone12;
    private final ModelRenderer rbone1;
    private final ModelRenderer rbone2;
    private final ModelRenderer rbone3;
    private final ModelRenderer rbone4;
    private final ModelRenderer rbone5;
    private final ModelRenderer rbone6;
    private final ModelRenderer rbone7;
    private final ModelRenderer rbone8;
    private final ModelRenderer rbone9;
    private final ModelRenderer rbone10;
    private final ModelRenderer rbone11;
    private final ModelRenderer rbone12;
    private final ModelRenderer lbone1;
    private final ModelRenderer lbone2;
    private final ModelRenderer lbone3;
    private final ModelRenderer lbone4;
    private final ModelRenderer lbone5;
    private final ModelRenderer lbone6;
    private final ModelRenderer lbone7;
    private final ModelRenderer lbone8;
    private final ModelRenderer lbone9;
    private final ModelRenderer lbone10;
    private final ModelRenderer lbone11;
    private final ModelRenderer lbone12;
    private List<ModelRenderer> left_bone_list = new ArrayList<ModelRenderer>();
    private List<ModelRenderer> front_bone_list = new ArrayList<ModelRenderer>();
    private List<ModelRenderer> right_bone_list = new ArrayList<ModelRenderer>();

    public ModelGalaxyGulper() {
        this.field_78090_t = 128;
        this.field_78089_u = 64;
        this.mouth_middle = new ModelRenderer((ModelBase)this);
        this.mouth_middle.func_78793_a(0.0f, 13.0f, 7.0f);
        this.mouth_middle.field_78804_l.add(new ModelBox(this.mouth_middle, 22, 38, -3.0f, 0.0f, -13.0f, 6, 6, 14, 0.0f, false));
        this.mouth_middle.field_78804_l.add(new ModelBox(this.mouth_middle, 0, 53, -2.0f, -3.0f, -12.0f, 1, 3, 1, 0.0f, false));
        this.mouth_middle.field_78804_l.add(new ModelBox(this.mouth_middle, 0, 53, 1.0f, -3.0f, -12.0f, 1, 3, 1, 0.0f, false));
        this.mouth_left = new ModelRenderer((ModelBase)this);
        this.mouth_left.func_78793_a(4.0f, 13.0f, 7.0f);
        this.mouth_left.field_78804_l.add(new ModelBox(this.mouth_left, 0, 44, -1.0f, 0.0f, -13.0f, 4, 6, 14, 0.0f, true));
        this.mouth_left.field_78804_l.add(new ModelBox(this.mouth_left, 0, 53, 1.0f, -3.0f, -12.0f, 1, 3, 1, 0.0f, false));
        this.mouth_left.field_78804_l.add(new ModelBox(this.mouth_left, 0, 53, -0.5f, -2.0f, -12.0f, 1, 3, 1, 0.0f, false));
        this.mouth_left.field_78804_l.add(new ModelBox(this.mouth_left, 0, 53, 1.0f, -2.0f, -9.0f, 1, 3, 1, 0.0f, false));
        this.mouth_left.field_78804_l.add(new ModelBox(this.mouth_left, 0, 53, 1.0f, -2.0f, -6.0f, 1, 3, 1, 0.0f, false));
        this.mouth_left.field_78804_l.add(new ModelBox(this.mouth_left, 0, 53, 1.0f, -2.0f, -3.0f, 1, 3, 1, 0.0f, false));
        this.mouth_right = new ModelRenderer((ModelBase)this);
        this.mouth_right.func_78793_a(-4.0f, 13.0f, 7.0f);
        this.mouth_right.field_78804_l.add(new ModelBox(this.mouth_right, 0, 44, -3.0f, 0.0f, -13.0f, 4, 6, 14, 0.0f, false));
        this.mouth_right.field_78804_l.add(new ModelBox(this.mouth_right, 0, 53, -2.0f, -3.0f, -12.0f, 1, 3, 1, 0.0f, true));
        this.mouth_right.field_78804_l.add(new ModelBox(this.mouth_right, 0, 53, -0.5f, -2.0f, -12.0f, 1, 3, 1, 0.0f, true));
        this.mouth_right.field_78804_l.add(new ModelBox(this.mouth_right, 0, 53, -2.0f, -2.0f, -9.0f, 1, 3, 1, 0.0f, true));
        this.mouth_right.field_78804_l.add(new ModelBox(this.mouth_right, 0, 53, -2.0f, -2.0f, -6.0f, 1, 3, 1, 0.0f, true));
        this.mouth_right.field_78804_l.add(new ModelBox(this.mouth_right, 0, 53, -2.0f, -2.0f, -3.0f, 1, 3, 1, 0.0f, true));
        this.mainbody = new ModelRenderer((ModelBase)this);
        this.mainbody.func_78793_a(0.0f, 12.0f, 7.0f);
        this.mainbody.field_78804_l.add(new ModelBox(this.mainbody, 0, 0, -7.0f, -9.0f, -13.0f, 14, 10, 16, -0.1f, false));
        this.mainbody.field_78804_l.add(new ModelBox(this.mainbody, 0, 26, -2.0f, -11.5f, -12.0f, 4, 4, 14, -0.1f, false));
        this.mainbody.field_78804_l.add(new ModelBox(this.mainbody, 49, 23, -4.0f, -10.5f, -12.5f, 8, 3, 15, -0.1f, false));
        this.spine1 = new ModelRenderer((ModelBase)this);
        this.spine1.func_78793_a(0.0f, 1.5f, -3.0f);
        this.setRotationAngle(this.spine1, 0.6109f, 0.0f, 0.0f);
        this.spine1.field_78804_l.add(new ModelBox(this.spine1, 62, 10, -1.5f, -1.5f, -1.0f, 3, 3, 8, 0.0f, false));
        this.cube_r1 = new ModelRenderer((ModelBase)this);
        this.cube_r1.func_78793_a(0.0f, 0.0f, 10.0f);
        this.spine1.func_78792_a(this.cube_r1);
        this.setRotationAngle(this.cube_r1, -0.1745f, 0.0f, 0.0f);
        this.cube_r1.field_78804_l.add(new ModelBox(this.cube_r1, 85, 10, -1.5f, -1.0f, -4.0f, 3, 3, 8, -0.2f, false));
        this.spine2 = new ModelRenderer((ModelBase)this);
        this.spine2.func_78793_a(0.0f, 2.5f, 6.0f);
        this.setRotationAngle(this.spine2, 0.4363f, 0.0f, 0.0f);
        this.spine2.field_78804_l.add(new ModelBox(this.spine2, 62, 10, -1.5f, -1.5f, -1.0f, 3, 3, 8, 0.0f, false));
        this.cube_r2 = new ModelRenderer((ModelBase)this);
        this.cube_r2.func_78793_a(0.0f, 0.0f, 10.0f);
        this.spine2.func_78792_a(this.cube_r2);
        this.setRotationAngle(this.cube_r2, -0.1745f, 0.0f, 0.0f);
        this.cube_r2.field_78804_l.add(new ModelBox(this.cube_r2, 85, 10, -1.5f, -1.0f, -4.0f, 3, 3, 8, -0.2f, false));
        this.spine3 = new ModelRenderer((ModelBase)this);
        this.spine3.func_78793_a(0.0f, 7.5f, 9.0f);
        this.setRotationAngle(this.spine3, 0.1745f, 0.0f, 0.0f);
        this.spine3.field_78804_l.add(new ModelBox(this.spine3, 62, 10, -1.5f, -1.5f, -1.0f, 3, 3, 8, 0.0f, false));
        this.cube_r3 = new ModelRenderer((ModelBase)this);
        this.cube_r3.func_78793_a(0.0f, 0.0f, 10.0f);
        this.spine3.func_78792_a(this.cube_r3);
        this.setRotationAngle(this.cube_r3, -0.1745f, 0.0f, 0.0f);
        this.cube_r3.field_78804_l.add(new ModelBox(this.cube_r3, 85, 10, -1.5f, -1.0f, -4.0f, 3, 3, 8, -0.2f, false));
        this.fbone1 = new ModelRenderer((ModelBase)this);
        this.fbone1.func_78793_a(5.5f, 12.5f, -5.5f);
        this.fbone1.field_78804_l.add(new ModelBox(this.fbone1, 8, 8, -0.5f, -0.5f, -2.5f, 1, 1, 3, -0.25f, false));
        this.fbone2 = new ModelRenderer((ModelBase)this);
        this.fbone2.func_78793_a(5.5f, 12.5f, -5.5f);
        this.fbone2.field_78804_l.add(new ModelBox(this.fbone2, 1, 11, -1.5f, -0.5f, -2.5f, 1, 1, 3, -0.25f, false));
        this.fbone3 = new ModelRenderer((ModelBase)this);
        this.fbone3.func_78793_a(5.5f, 12.5f, -5.5f);
        this.fbone3.field_78804_l.add(new ModelBox(this.fbone3, 7, 2, -2.5f, -0.5f, -2.5f, 1, 1, 3, -0.25f, false));
        this.fbone4 = new ModelRenderer((ModelBase)this);
        this.fbone4.func_78793_a(5.5f, 12.5f, -5.5f);
        this.fbone4.field_78804_l.add(new ModelBox(this.fbone4, 1, 11, -3.5f, -0.5f, -2.5f, 1, 1, 3, -0.25f, false));
        this.fbone5 = new ModelRenderer((ModelBase)this);
        this.fbone5.func_78793_a(5.5f, 12.5f, -5.5f);
        this.fbone5.field_78804_l.add(new ModelBox(this.fbone5, 8, 8, -4.5f, -0.5f, -2.5f, 1, 1, 3, -0.25f, false));
        this.fbone6 = new ModelRenderer((ModelBase)this);
        this.fbone6.func_78793_a(5.5f, 12.5f, -5.5f);
        this.fbone6.field_78804_l.add(new ModelBox(this.fbone6, 1, 11, -5.5f, -0.5f, -2.5f, 1, 1, 3, -0.25f, false));
        this.fbone7 = new ModelRenderer((ModelBase)this);
        this.fbone7.func_78793_a(5.5f, 12.5f, -5.5f);
        this.fbone7.field_78804_l.add(new ModelBox(this.fbone7, 1, 6, -6.5f, -0.5f, -2.5f, 1, 1, 3, -0.25f, false));
        this.fbone8 = new ModelRenderer((ModelBase)this);
        this.fbone8.func_78793_a(5.5f, 12.5f, -5.5f);
        this.fbone8.field_78804_l.add(new ModelBox(this.fbone8, 1, 11, -7.5f, -0.5f, -2.5f, 1, 1, 3, -0.25f, false));
        this.fbone9 = new ModelRenderer((ModelBase)this);
        this.fbone9.func_78793_a(5.5f, 12.5f, -5.5f);
        this.fbone9.field_78804_l.add(new ModelBox(this.fbone9, 8, 8, -8.5f, -0.5f, -2.5f, 1, 1, 3, -0.25f, false));
        this.fbone10 = new ModelRenderer((ModelBase)this);
        this.fbone10.func_78793_a(5.5f, 12.5f, -5.5f);
        this.fbone10.field_78804_l.add(new ModelBox(this.fbone10, 1, 11, -9.5f, -0.5f, -2.5f, 1, 1, 3, -0.25f, false));
        this.fbone11 = new ModelRenderer((ModelBase)this);
        this.fbone11.func_78793_a(5.5f, 12.5f, -5.5f);
        this.fbone11.field_78804_l.add(new ModelBox(this.fbone11, 7, 2, -10.5f, -0.5f, -2.5f, 1, 1, 3, -0.25f, false));
        this.fbone12 = new ModelRenderer((ModelBase)this);
        this.fbone12.func_78793_a(5.5f, 12.5f, -5.5f);
        this.fbone12.field_78804_l.add(new ModelBox(this.fbone12, 1, 11, -11.5f, -0.5f, -2.5f, 1, 1, 3, -0.25f, false));
        this.rbone1 = new ModelRenderer((ModelBase)this);
        this.rbone1.func_78793_a(-6.5f, 12.5f, -4.5f);
        this.rbone1.field_78804_l.add(new ModelBox(this.rbone1, 55, 10, -2.5f, -0.5f, -0.5f, 3, 1, 1, -0.25f, false));
        this.rbone2 = new ModelRenderer((ModelBase)this);
        this.rbone2.func_78793_a(-6.5f, 12.5f, -4.5f);
        this.rbone2.field_78804_l.add(new ModelBox(this.rbone2, 46, 10, -2.5f, -0.5f, 0.5f, 3, 1, 1, -0.25f, false));
        this.rbone3 = new ModelRenderer((ModelBase)this);
        this.rbone3.func_78793_a(-6.5f, 12.5f, -4.5f);
        this.rbone3.field_78804_l.add(new ModelBox(this.rbone3, 46, 13, -2.5f, -0.5f, 1.5f, 3, 1, 1, -0.25f, false));
        this.rbone4 = new ModelRenderer((ModelBase)this);
        this.rbone4.func_78793_a(-6.5f, 12.5f, -4.5f);
        this.rbone4.field_78804_l.add(new ModelBox(this.rbone4, 46, 13, -2.5f, -0.5f, 2.5f, 3, 1, 1, -0.25f, false));
        this.rbone5 = new ModelRenderer((ModelBase)this);
        this.rbone5.func_78793_a(-6.5f, 12.5f, -4.5f);
        this.rbone5.field_78804_l.add(new ModelBox(this.rbone5, 55, 13, -2.5f, -0.5f, 3.5f, 3, 1, 1, -0.25f, false));
        this.rbone6 = new ModelRenderer((ModelBase)this);
        this.rbone6.func_78793_a(-6.5f, 12.5f, -4.5f);
        this.rbone6.field_78804_l.add(new ModelBox(this.rbone6, 46, 13, -2.5f, -0.5f, 4.5f, 3, 1, 1, -0.25f, false));
        this.rbone7 = new ModelRenderer((ModelBase)this);
        this.rbone7.func_78793_a(-6.5f, 12.5f, -4.5f);
        this.rbone7.field_78804_l.add(new ModelBox(this.rbone7, 46, 10, -2.5f, -0.5f, 5.5f, 3, 1, 1, -0.25f, false));
        this.rbone8 = new ModelRenderer((ModelBase)this);
        this.rbone8.func_78793_a(-6.5f, 12.5f, -4.5f);
        this.rbone8.field_78804_l.add(new ModelBox(this.rbone8, 55, 10, -2.5f, -0.5f, 6.5f, 3, 1, 1, -0.25f, false));
        this.rbone9 = new ModelRenderer((ModelBase)this);
        this.rbone9.func_78793_a(-6.5f, 12.5f, -4.5f);
        this.rbone9.field_78804_l.add(new ModelBox(this.rbone9, 55, 13, -2.5f, -0.5f, 7.5f, 3, 1, 1, -0.25f, false));
        this.rbone10 = new ModelRenderer((ModelBase)this);
        this.rbone10.func_78793_a(-6.5f, 12.5f, -4.5f);
        this.rbone10.field_78804_l.add(new ModelBox(this.rbone10, 46, 13, -2.5f, -0.5f, 8.5f, 3, 1, 1, -0.25f, false));
        this.rbone11 = new ModelRenderer((ModelBase)this);
        this.rbone11.func_78793_a(-6.5f, 12.5f, -4.5f);
        this.rbone11.field_78804_l.add(new ModelBox(this.rbone11, 46, 10, -2.5f, -0.5f, 9.5f, 3, 1, 1, -0.25f, false));
        this.rbone12 = new ModelRenderer((ModelBase)this);
        this.rbone12.func_78793_a(-6.5f, 12.5f, -4.5f);
        this.rbone12.field_78804_l.add(new ModelBox(this.rbone12, 55, 10, -2.5f, -0.5f, 10.5f, 3, 1, 1, -0.25f, false));
        this.lbone1 = new ModelRenderer((ModelBase)this);
        this.lbone1.func_78793_a(6.5f, 12.5f, -4.5f);
        this.lbone1.field_78804_l.add(new ModelBox(this.lbone1, 46, 10, -0.5f, -0.5f, 9.5f, 3, 1, 1, -0.25f, true));
        this.lbone2 = new ModelRenderer((ModelBase)this);
        this.lbone2.func_78793_a(6.5f, 12.5f, -4.5f);
        this.lbone2.field_78804_l.add(new ModelBox(this.lbone2, 46, 13, -0.5f, -0.5f, 8.5f, 3, 1, 1, -0.25f, true));
        this.lbone3 = new ModelRenderer((ModelBase)this);
        this.lbone3.func_78793_a(6.5f, 12.5f, -4.5f);
        this.lbone3.field_78804_l.add(new ModelBox(this.lbone3, 55, 10, -0.5f, -0.5f, 6.5f, 3, 1, 1, -0.25f, true));
        this.lbone4 = new ModelRenderer((ModelBase)this);
        this.lbone4.func_78793_a(6.5f, 12.5f, -4.5f);
        this.lbone4.field_78804_l.add(new ModelBox(this.lbone4, 55, 13, -0.5f, -0.5f, 7.5f, 3, 1, 1, -0.25f, true));
        this.lbone5 = new ModelRenderer((ModelBase)this);
        this.lbone5.func_78793_a(6.5f, 12.5f, -4.5f);
        this.lbone5.field_78804_l.add(new ModelBox(this.lbone5, 46, 10, -0.5f, -0.5f, 5.5f, 3, 1, 1, -0.25f, true));
        this.lbone6 = new ModelRenderer((ModelBase)this);
        this.lbone6.func_78793_a(6.5f, 12.5f, -4.5f);
        this.lbone6.field_78804_l.add(new ModelBox(this.lbone6, 46, 13, -0.5f, -0.5f, 4.5f, 3, 1, 1, -0.25f, true));
        this.lbone7 = new ModelRenderer((ModelBase)this);
        this.lbone7.func_78793_a(6.5f, 12.5f, -4.5f);
        this.lbone7.field_78804_l.add(new ModelBox(this.lbone7, 55, 13, -0.5f, -0.5f, 3.5f, 3, 1, 1, -0.25f, true));
        this.lbone8 = new ModelRenderer((ModelBase)this);
        this.lbone8.func_78793_a(6.5f, 12.5f, -4.5f);
        this.lbone8.field_78804_l.add(new ModelBox(this.lbone8, 46, 13, -0.5f, -0.5f, 2.5f, 3, 1, 1, -0.25f, true));
        this.lbone9 = new ModelRenderer((ModelBase)this);
        this.lbone9.func_78793_a(6.5f, 12.5f, -4.5f);
        this.lbone9.field_78804_l.add(new ModelBox(this.lbone9, 46, 13, -0.5f, -0.5f, 1.5f, 3, 1, 1, -0.25f, true));
        this.lbone10 = new ModelRenderer((ModelBase)this);
        this.lbone10.func_78793_a(6.5f, 12.5f, -4.5f);
        this.lbone10.field_78804_l.add(new ModelBox(this.lbone10, 46, 10, -0.5f, -0.5f, 0.5f, 3, 1, 1, -0.25f, true));
        this.lbone11 = new ModelRenderer((ModelBase)this);
        this.lbone11.func_78793_a(6.5f, 12.5f, -4.5f);
        this.lbone11.field_78804_l.add(new ModelBox(this.lbone11, 55, 10, -0.5f, -0.5f, -0.5f, 3, 1, 1, -0.25f, true));
        this.lbone12 = new ModelRenderer((ModelBase)this);
        this.lbone12.func_78793_a(6.5f, 12.5f, -4.5f);
        this.lbone12.field_78804_l.add(new ModelBox(this.lbone12, 55, 10, -0.5f, -0.5f, 10.5f, 3, 1, 1, -0.25f, true));
        this.front_bone_list.add(this.fbone1);
        this.front_bone_list.add(this.fbone2);
        this.front_bone_list.add(this.fbone3);
        this.front_bone_list.add(this.fbone4);
        this.front_bone_list.add(this.fbone5);
        this.front_bone_list.add(this.fbone6);
        this.front_bone_list.add(this.fbone7);
        this.front_bone_list.add(this.fbone8);
        this.front_bone_list.add(this.fbone9);
        this.front_bone_list.add(this.fbone10);
        this.front_bone_list.add(this.fbone11);
        this.front_bone_list.add(this.fbone12);
        this.left_bone_list.add(this.lbone1);
        this.left_bone_list.add(this.lbone2);
        this.left_bone_list.add(this.lbone3);
        this.left_bone_list.add(this.lbone4);
        this.left_bone_list.add(this.lbone5);
        this.left_bone_list.add(this.lbone6);
        this.left_bone_list.add(this.lbone7);
        this.left_bone_list.add(this.lbone8);
        this.left_bone_list.add(this.lbone9);
        this.left_bone_list.add(this.lbone10);
        this.left_bone_list.add(this.lbone11);
        this.left_bone_list.add(this.lbone12);
        this.right_bone_list.add(this.rbone1);
        this.right_bone_list.add(this.rbone2);
        this.right_bone_list.add(this.rbone3);
        this.right_bone_list.add(this.rbone4);
        this.right_bone_list.add(this.rbone5);
        this.right_bone_list.add(this.rbone6);
        this.right_bone_list.add(this.rbone7);
        this.right_bone_list.add(this.rbone8);
        this.right_bone_list.add(this.rbone9);
        this.right_bone_list.add(this.rbone10);
        this.right_bone_list.add(this.rbone11);
        this.right_bone_list.add(this.rbone12);
        Collections.shuffle(this.front_bone_list);
        Collections.shuffle(this.left_bone_list);
        Collections.shuffle(this.right_bone_list);
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.mouth_middle.func_78785_a(f5);
        this.mouth_left.func_78785_a(f5);
        this.mouth_right.func_78785_a(f5);
        this.mainbody.func_78785_a(f5);
        this.spine1.func_78785_a(f5);
        this.spine2.func_78785_a(f5);
        this.spine3.func_78785_a(f5);
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b((int)770, (int)771);
        for (int i = 0; i < this.left_bone_list.size(); ++i) {
            GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)(0.4f + 0.2f * Mth.func_76126_a((float)((f2 + (float)(i * 2)) * 0.1f))));
            ModelRenderer left_bone = this.left_bone_list.get(i);
            ModelRenderer right_bone = this.right_bone_list.get(i);
            ModelRenderer front_bone = this.front_bone_list.get(i);
            left_bone.func_78785_a(f5);
            right_bone.func_78785_a(f5);
            front_bone.func_78785_a(f5);
        }
        GlStateManager.func_179084_k();
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        for (int i = 0; i < this.left_bone_list.size(); ++i) {
            ModelRenderer left_bone = this.left_bone_list.get(i);
            ModelRenderer right_bone = this.right_bone_list.get(i);
            ModelRenderer front_bone = this.front_bone_list.get(i);
            left_bone.field_78808_h = 0.8f + 0.25f * Mth.func_76126_a((float)((ageInTicks + (float)(i * 2)) * 0.1f));
            right_bone.field_78808_h = -left_bone.field_78808_h;
            front_bone.field_78795_f = left_bone.field_78808_h;
        }
        this.spine1.field_78795_f = 0.6f + 0.35f * Mth.func_76126_a((float)(ageInTicks * 0.05f));
        this.spine2.field_78795_f = 0.43f + 0.35f * Mth.func_76126_a((float)(ageInTicks * 0.05f));
        this.spine3.field_78795_f = 0.17f + 0.35f * Mth.func_76126_a((float)(ageInTicks * 0.05f));
        float degreeAge = ageInTicks % 360.0f;
        float rad = (float)Math.toRadians(degreeAge);
        if (degreeAge > 180.0f) {
            this.mouth_left.field_78795_f = -0.52f * Mth.func_76126_a((float)rad);
            this.mouth_left.field_78808_h = 0.52f * Mth.func_76126_a((float)rad);
            this.mouth_right.field_78795_f = -0.52f * Mth.func_76126_a((float)rad);
            this.mouth_right.field_78808_h = -0.52f * Mth.func_76126_a((float)rad);
            this.mouth_middle.field_78795_f = -0.52f * Mth.func_76126_a((float)rad);
        } else {
            this.mouth_left.field_78795_f = 0.0f;
            this.mouth_left.field_78808_h = 0.0f;
            this.mouth_right.field_78795_f = 0.0f;
            this.mouth_right.field_78808_h = 0.0f;
            this.mouth_middle.field_78795_f = 0.0f;
        }
    }
}

