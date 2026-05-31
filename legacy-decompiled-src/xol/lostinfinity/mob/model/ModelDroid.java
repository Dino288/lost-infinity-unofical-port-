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
package xol.lostinfinity.mob.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import xol.lostinfinity.mob.entity.boss.EntityDroidBoss;
import xol.lostinfinity.mob.entity.misc.EntityDroid;

public class ModelDroid
extends ModelBase {
    private final ModelRenderer head;
    private final ModelRenderer body;
    private final ModelRenderer right_arm;
    private final ModelRenderer left_arm;
    private final ModelRenderer right_leg;
    private final ModelRenderer left_leg;
    private final ModelRenderer left_arm_mk1;
    private final ModelRenderer right_arm_mk1;
    private final ModelRenderer left_arm_mk2;
    private final ModelRenderer left_leg_mk2;
    private final ModelRenderer right_leg_mk2;
    private final ModelRenderer body_mk2;
    private final ModelRenderer body_mk2_rot;
    private final ModelRenderer right_arm_mk3;
    private final ModelRenderer right_arm_gravity;
    private final ModelRenderer left_arm_mk3;
    private final ModelRenderer claw;
    private final ModelRenderer cube_r1;
    private final ModelRenderer head_mk3;
    private final ModelRenderer right_pipe1;
    private final ModelRenderer cube_r2;
    private final ModelRenderer cube_r3;
    private final ModelRenderer cube_r4;
    private final ModelRenderer cube_r5;
    private final ModelRenderer cube_r6;
    private final ModelRenderer cube_r7;
    private final ModelRenderer cube_r8;
    private final ModelRenderer cube_r9;
    private final ModelRenderer right_pipe2;
    private final ModelRenderer cube_r10;
    private final ModelRenderer cube_r11;
    private final ModelRenderer cube_r12;
    private final ModelRenderer cube_r13;
    private final ModelRenderer cube_r14;
    private final ModelRenderer cube_r15;
    private final ModelRenderer cube_r16;
    private final ModelRenderer cube_r17;
    private final ModelRenderer left_pipe2;
    private final ModelRenderer cube_r18;
    private final ModelRenderer cube_r19;
    private final ModelRenderer cube_r20;
    private final ModelRenderer cube_r21;
    private final ModelRenderer cube_r22;
    private final ModelRenderer cube_r23;
    private final ModelRenderer cube_r24;
    private final ModelRenderer cube_r25;
    private final ModelRenderer left_pipe1;
    private final ModelRenderer cube_r26;
    private final ModelRenderer cube_r27;
    private final ModelRenderer cube_r28;
    private final ModelRenderer cube_r29;
    private final ModelRenderer cube_r30;
    private final ModelRenderer cube_r31;
    private final ModelRenderer cube_r32;
    private final ModelRenderer cube_r33;
    private final ModelRenderer left_arm_mk3_blade;

    public ModelDroid() {
        this.field_78090_t = 128;
        this.field_78089_u = 64;
        this.head = new ModelRenderer((ModelBase)this);
        this.head.func_78793_a(0.0f, -6.0f, 0.0f);
        this.head.field_78804_l.add(new ModelBox(this.head, 0, 0, -4.0f, -6.0f, -4.0f, 8, 8, 8, 0.0f, false));
        this.head.field_78804_l.add(new ModelBox(this.head, 6, 45, -4.5f, -6.9f, -4.5f, 9, 9, 9, 0.0f, false));
        this.body = new ModelRenderer((ModelBase)this);
        this.body.func_78793_a(0.0f, -2.0f, 0.0f);
        this.body.field_78804_l.add(new ModelBox(this.body, 16, 16, -4.0f, 7.0f, -2.0f, 8, 6, 4, 0.0f, false));
        this.body.field_78804_l.add(new ModelBox(this.body, 34, 0, -3.0f, -2.0f, -3.0f, 6, 2, 6, 0.0f, false));
        this.body.field_78804_l.add(new ModelBox(this.body, 16, 28, -5.0f, 0.0f, -3.0f, 10, 7, 6, 0.0f, false));
        this.right_arm = new ModelRenderer((ModelBase)this);
        this.right_arm.func_78793_a(-5.0f, 0.0f, 0.0f);
        this.right_arm.field_78804_l.add(new ModelBox(this.right_arm, 46, 16, -4.5f, 3.0f, -2.0f, 4, 6, 4, 0.0f, false));
        this.right_arm.field_78804_l.add(new ModelBox(this.right_arm, 44, 53, -5.0f, -2.0f, -2.5f, 5, 5, 5, 0.0f, false));
        this.left_arm = new ModelRenderer((ModelBase)this);
        this.left_arm.func_78793_a(5.0f, 0.0f, 0.0f);
        this.left_arm.field_78804_l.add(new ModelBox(this.left_arm, 46, 16, 0.5f, 3.0f, -2.0f, 4, 6, 4, 0.0f, true));
        this.left_arm.field_78804_l.add(new ModelBox(this.left_arm, 44, 53, 0.0f, -2.0f, -2.5f, 5, 5, 5, 0.0f, true));
        this.right_leg = new ModelRenderer((ModelBase)this);
        this.right_leg.func_78793_a(-2.5f, 11.0f, 0.0f);
        this.right_leg.field_78804_l.add(new ModelBox(this.right_leg, 0, 35, -1.0f, -1.0f, -2.4f, 2, 5, 5, 0.0f, false));
        this.right_leg.field_78804_l.add(new ModelBox(this.right_leg, 0, 16, -2.0f, 1.0f, -1.9f, 4, 12, 4, 0.0f, false));
        this.left_leg = new ModelRenderer((ModelBase)this);
        this.left_leg.func_78793_a(2.5f, 11.0f, 0.0f);
        this.left_leg.field_78804_l.add(new ModelBox(this.left_leg, 0, 16, -2.0f, 1.0f, -1.9f, 4, 12, 4, 0.0f, true));
        this.left_leg.field_78804_l.add(new ModelBox(this.left_leg, 0, 35, -1.0f, -1.0f, -2.4f, 2, 5, 5, 0.0f, false));
        this.left_arm_mk1 = new ModelRenderer((ModelBase)this);
        this.left_arm_mk1.func_78793_a(5.0f, 0.0f, 0.0f);
        this.left_arm_mk1.field_78804_l.add(new ModelBox(this.left_arm_mk1, 46, 41, 0.5f, 9.5f, -2.0f, 4, 6, 4, 0.0f, true));
        this.left_arm_mk1.field_78804_l.add(new ModelBox(this.left_arm_mk1, 38, 10, 1.5f, 8.5f, -1.5f, 2, 1, 3, 0.0f, false));
        this.right_arm_mk1 = new ModelRenderer((ModelBase)this);
        this.right_arm_mk1.func_78793_a(-5.0f, 0.0f, 0.0f);
        this.right_arm_mk1.field_78804_l.add(new ModelBox(this.right_arm_mk1, 46, 41, -4.5f, 9.5f, -2.0f, 4, 6, 4, 0.0f, false));
        this.right_arm_mk1.field_78804_l.add(new ModelBox(this.right_arm_mk1, 38, 10, -3.5f, 8.5f, -1.5f, 2, 1, 3, 0.0f, true));
        this.left_arm_mk2 = new ModelRenderer((ModelBase)this);
        this.left_arm_mk2.func_78793_a(5.0f, 0.0f, 0.0f);
        this.left_arm_mk2.field_78804_l.add(new ModelBox(this.left_arm_mk2, 61, 0, 3.3f, 8.0f, -3.0f, 1, 13, 6, 0.0f, false));
        this.left_leg_mk2 = new ModelRenderer((ModelBase)this);
        this.left_leg_mk2.func_78793_a(2.5f, 11.0f, 0.0f);
        this.left_leg_mk2.field_78804_l.add(new ModelBox(this.left_leg_mk2, 64, 21, -1.5f, 6.0f, -2.9f, 3, 7, 1, 0.0f, false));
        this.right_leg_mk2 = new ModelRenderer((ModelBase)this);
        this.right_leg_mk2.func_78793_a(-2.5f, 11.0f, 0.0f);
        this.right_leg_mk2.field_78804_l.add(new ModelBox(this.right_leg_mk2, 64, 21, -1.5f, 6.0f, -2.9f, 3, 7, 1, 0.0f, false));
        this.body_mk2 = new ModelRenderer((ModelBase)this);
        this.body_mk2.func_78793_a(0.0f, 24.0f, 0.0f);
        this.body_mk2.field_78804_l.add(new ModelBox(this.body_mk2, 64, 32, 3.5f, -27.3f, -4.3f, 1, 7, 6, 0.0f, false));
        this.body_mk2.field_78804_l.add(new ModelBox(this.body_mk2, 64, 32, -4.5f, -27.3f, -4.3f, 1, 7, 6, 0.0f, true));
        this.body_mk2_rot = new ModelRenderer((ModelBase)this);
        this.body_mk2_rot.func_78793_a(0.0f, -23.5f, 3.75f);
        this.body_mk2.func_78792_a(this.body_mk2_rot);
        this.body_mk2_rot.field_78804_l.add(new ModelBox(this.body_mk2_rot, 52, 31, -5.0f, -1.5f, -0.5f, 3, 3, 1, 0.0f, false));
        this.body_mk2_rot.field_78804_l.add(new ModelBox(this.body_mk2_rot, 52, 31, -1.5f, -5.0f, -0.5f, 3, 3, 1, 0.0f, false));
        this.body_mk2_rot.field_78804_l.add(new ModelBox(this.body_mk2_rot, 52, 31, 2.0f, -1.5f, -0.5f, 3, 3, 1, 0.0f, false));
        this.body_mk2_rot.field_78804_l.add(new ModelBox(this.body_mk2_rot, 52, 31, -1.5f, 2.0f, -0.5f, 3, 3, 1, 0.0f, false));
        this.right_arm_mk3 = new ModelRenderer((ModelBase)this);
        this.right_arm_mk3.func_78793_a(-5.0f, 0.0f, 0.0f);
        this.right_arm_mk3.field_78804_l.add(new ModelBox(this.right_arm_mk3, 67, 53, -7.0f, 4.0f, -2.0f, 3, 6, 4, -0.5f, false));
        this.right_arm_mk3.field_78804_l.add(new ModelBox(this.right_arm_mk3, 87, 52, -4.0f, 8.0f, -1.5f, 3, 8, 3, -0.5f, false));
        this.right_arm_mk3.field_78804_l.add(new ModelBox(this.right_arm_mk3, 82, 56, -7.0f, 1.0f, -1.5f, 1, 6, 1, -0.35f, false));
        this.right_arm_mk3.field_78804_l.add(new ModelBox(this.right_arm_mk3, 82, 56, -7.0f, 1.0f, 0.5f, 1, 6, 1, -0.35f, false));
        this.right_arm_mk3.field_78804_l.add(new ModelBox(this.right_arm_mk3, 78, 53, -7.0f, 1.0f, 0.5f, 3, 1, 1, -0.3f, false));
        this.right_arm_mk3.field_78804_l.add(new ModelBox(this.right_arm_mk3, 78, 53, -7.0f, 1.0f, -1.5f, 3, 1, 1, -0.3f, false));
        this.right_arm_gravity = new ModelRenderer((ModelBase)this);
        this.right_arm_gravity.func_78793_a(-2.5f, 12.5f, 0.0f);
        this.right_arm_mk3.func_78792_a(this.right_arm_gravity);
        this.right_arm_gravity.field_78804_l.add(new ModelBox(this.right_arm_gravity, 99, 53, -1.5f, 1.5f, -1.5f, 3, 1, 3, -0.1f, false));
        this.right_arm_gravity.field_78804_l.add(new ModelBox(this.right_arm_gravity, 99, 53, -1.5f, -0.5f, -1.5f, 3, 1, 3, -0.1f, false));
        this.right_arm_gravity.field_78804_l.add(new ModelBox(this.right_arm_gravity, 99, 53, -1.5f, -2.5f, -1.5f, 3, 1, 3, -0.1f, false));
        this.left_arm_mk3 = new ModelRenderer((ModelBase)this);
        this.left_arm_mk3.func_78793_a(5.0f, 0.0f, 0.0f);
        this.claw = new ModelRenderer((ModelBase)this);
        this.claw.func_78793_a(-1.0f, 8.0f, -1.0f);
        this.left_arm_mk3.func_78792_a(this.claw);
        this.claw.field_78804_l.add(new ModelBox(this.claw, 79, 43, 4.0f, -1.0f, -1.0f, 2, 6, 2, -0.2f, false));
        this.claw.field_78804_l.add(new ModelBox(this.claw, 79, 43, 4.0f, -1.0f, 1.0f, 2, 6, 2, -0.2f, false));
        this.cube_r1 = new ModelRenderer((ModelBase)this);
        this.cube_r1.func_78793_a(5.0f, 6.0f, 2.0f);
        this.claw.func_78792_a(this.cube_r1);
        this.setRotationAngle(this.cube_r1, 0.0f, 0.0f, 0.4363f);
        this.cube_r1.field_78804_l.add(new ModelBox(this.cube_r1, 88, 45, -1.5f, -2.0f, -1.0f, 2, 4, 2, -0.4f, false));
        this.cube_r1.field_78804_l.add(new ModelBox(this.cube_r1, 88, 45, -1.5f, -2.0f, -3.0f, 2, 4, 2, -0.4f, false));
        this.head_mk3 = new ModelRenderer((ModelBase)this);
        this.head_mk3.func_78793_a(0.0f, -6.0f, 0.0f);
        this.right_pipe1 = new ModelRenderer((ModelBase)this);
        this.right_pipe1.func_78793_a(-5.0f, -3.5f, 3.5f);
        this.head_mk3.func_78792_a(this.right_pipe1);
        this.setRotationAngle(this.right_pipe1, -0.1309f, 0.0f, 0.0f);
        this.cube_r2 = new ModelRenderer((ModelBase)this);
        this.cube_r2.func_78793_a(-3.25f, 0.0f, 2.5f);
        this.right_pipe1.func_78792_a(this.cube_r2);
        this.setRotationAngle(this.cube_r2, 0.0f, -1.9199f, 0.0f);
        this.cube_r2.field_78804_l.add(new ModelBox(this.cube_r2, 100, 57, -7.95f, -1.5f, -6.1f, 7, 3, 3, -1.2f, false));
        this.cube_r3 = new ModelRenderer((ModelBase)this);
        this.cube_r3.func_78793_a(-3.25f, 0.0f, 2.5f);
        this.right_pipe1.func_78792_a(this.cube_r3);
        this.setRotationAngle(this.cube_r3, 0.0f, -2.5307f, 0.0f);
        this.cube_r3.field_78804_l.add(new ModelBox(this.cube_r3, 87, 38, -5.75f, -1.5f, -4.0f, 4, 3, 3, -1.15f, false));
        this.cube_r4 = new ModelRenderer((ModelBase)this);
        this.cube_r4.func_78793_a(-3.25f, 0.0f, 2.5f);
        this.right_pipe1.func_78792_a(this.cube_r4);
        this.setRotationAngle(this.cube_r4, 0.0f, 3.1416f, 0.0f);
        this.cube_r4.field_78804_l.add(new ModelBox(this.cube_r4, 87, 38, -5.25f, -1.5f, -1.8f, 4, 3, 3, -1.1f, false));
        this.cube_r5 = new ModelRenderer((ModelBase)this);
        this.cube_r5.func_78793_a(-3.25f, 0.0f, 2.5f);
        this.right_pipe1.func_78792_a(this.cube_r5);
        this.setRotationAngle(this.cube_r5, 0.0f, 2.7925f, 0.0f);
        this.cube_r5.field_78804_l.add(new ModelBox(this.cube_r5, 87, 38, -3.55f, -1.5f, -1.0f, 4, 3, 3, -1.05f, false));
        this.cube_r6 = new ModelRenderer((ModelBase)this);
        this.cube_r6.func_78793_a(-3.25f, 0.0f, 2.5f);
        this.right_pipe1.func_78792_a(this.cube_r6);
        this.setRotationAngle(this.cube_r6, 0.0f, 2.1817f, 0.0f);
        this.cube_r6.field_78804_l.add(new ModelBox(this.cube_r6, 87, 38, -1.45f, -1.5f, -0.55f, 4, 3, 3, -1.0f, false));
        this.cube_r7 = new ModelRenderer((ModelBase)this);
        this.cube_r7.func_78793_a(-1.5f, -0.5f, -7.5f);
        this.right_pipe1.func_78792_a(this.cube_r7);
        this.setRotationAngle(this.cube_r7, 0.0f, 1.5708f, 0.0f);
        this.cube_r7.field_78804_l.add(new ModelBox(this.cube_r7, 87, 38, -9.5f, -1.0f, -3.25f, 4, 3, 3, -0.95f, false));
        this.cube_r8 = new ModelRenderer((ModelBase)this);
        this.cube_r8.func_78793_a(-1.5f, -0.5f, -7.5f);
        this.right_pipe1.func_78792_a(this.cube_r8);
        this.setRotationAngle(this.cube_r8, 0.0f, 1.1345f, 0.0f);
        this.cube_r8.field_78804_l.add(new ModelBox(this.cube_r8, 102, 38, -7.7f, -1.0f, -0.3f, 6, 3, 3, -0.85f, false));
        this.cube_r9 = new ModelRenderer((ModelBase)this);
        this.cube_r9.func_78793_a(-1.5f, -0.5f, -7.5f);
        this.right_pipe1.func_78792_a(this.cube_r9);
        this.setRotationAngle(this.cube_r9, 0.0f, 0.6109f, 0.0f);
        this.cube_r9.field_78804_l.add(new ModelBox(this.cube_r9, 102, 46, -3.0f, -1.0f, 1.0f, 6, 3, 3, -0.75f, false));
        this.right_pipe2 = new ModelRenderer((ModelBase)this);
        this.right_pipe2.func_78793_a(-5.0f, -0.5f, 3.5f);
        this.head_mk3.func_78792_a(this.right_pipe2);
        this.setRotationAngle(this.right_pipe2, -0.3054f, 0.0f, 0.0f);
        this.cube_r10 = new ModelRenderer((ModelBase)this);
        this.cube_r10.func_78793_a(-3.25f, 0.0f, 2.5f);
        this.right_pipe2.func_78792_a(this.cube_r10);
        this.setRotationAngle(this.cube_r10, 0.0f, -1.9199f, 0.0f);
        this.cube_r10.field_78804_l.add(new ModelBox(this.cube_r10, 100, 57, -7.95f, -1.5f, -6.1f, 7, 3, 3, -1.2f, false));
        this.cube_r11 = new ModelRenderer((ModelBase)this);
        this.cube_r11.func_78793_a(-3.25f, 0.0f, 2.5f);
        this.right_pipe2.func_78792_a(this.cube_r11);
        this.setRotationAngle(this.cube_r11, 0.0f, -2.5307f, 0.0f);
        this.cube_r11.field_78804_l.add(new ModelBox(this.cube_r11, 87, 38, -5.75f, -1.5f, -4.0f, 4, 3, 3, -1.15f, false));
        this.cube_r12 = new ModelRenderer((ModelBase)this);
        this.cube_r12.func_78793_a(-3.25f, 0.0f, 2.5f);
        this.right_pipe2.func_78792_a(this.cube_r12);
        this.setRotationAngle(this.cube_r12, 0.0f, 3.1416f, 0.0f);
        this.cube_r12.field_78804_l.add(new ModelBox(this.cube_r12, 87, 38, -5.25f, -1.5f, -1.8f, 4, 3, 3, -1.1f, false));
        this.cube_r13 = new ModelRenderer((ModelBase)this);
        this.cube_r13.func_78793_a(-3.25f, 0.0f, 2.5f);
        this.right_pipe2.func_78792_a(this.cube_r13);
        this.setRotationAngle(this.cube_r13, 0.0f, 2.7925f, 0.0f);
        this.cube_r13.field_78804_l.add(new ModelBox(this.cube_r13, 87, 38, -3.55f, -1.5f, -1.0f, 4, 3, 3, -1.05f, false));
        this.cube_r14 = new ModelRenderer((ModelBase)this);
        this.cube_r14.func_78793_a(-3.25f, 0.0f, 2.5f);
        this.right_pipe2.func_78792_a(this.cube_r14);
        this.setRotationAngle(this.cube_r14, 0.0f, 2.1817f, 0.0f);
        this.cube_r14.field_78804_l.add(new ModelBox(this.cube_r14, 87, 38, -1.45f, -1.5f, -0.55f, 4, 3, 3, -1.0f, false));
        this.cube_r15 = new ModelRenderer((ModelBase)this);
        this.cube_r15.func_78793_a(-1.5f, -0.5f, -7.5f);
        this.right_pipe2.func_78792_a(this.cube_r15);
        this.setRotationAngle(this.cube_r15, 0.0f, 1.5708f, 0.0f);
        this.cube_r15.field_78804_l.add(new ModelBox(this.cube_r15, 87, 38, -9.5f, -1.0f, -3.25f, 4, 3, 3, -0.95f, false));
        this.cube_r16 = new ModelRenderer((ModelBase)this);
        this.cube_r16.func_78793_a(-1.5f, -0.5f, -7.5f);
        this.right_pipe2.func_78792_a(this.cube_r16);
        this.setRotationAngle(this.cube_r16, 0.0f, 1.1345f, 0.0f);
        this.cube_r16.field_78804_l.add(new ModelBox(this.cube_r16, 102, 38, -7.7f, -1.0f, -0.3f, 6, 3, 3, -0.85f, false));
        this.cube_r17 = new ModelRenderer((ModelBase)this);
        this.cube_r17.func_78793_a(-1.5f, -0.5f, -7.5f);
        this.right_pipe2.func_78792_a(this.cube_r17);
        this.setRotationAngle(this.cube_r17, 0.0f, 0.6109f, 0.0f);
        this.cube_r17.field_78804_l.add(new ModelBox(this.cube_r17, 102, 46, -3.0f, -1.0f, 1.0f, 6, 3, 3, -0.75f, false));
        this.left_pipe2 = new ModelRenderer((ModelBase)this);
        this.left_pipe2.func_78793_a(5.0f, -0.5f, 3.5f);
        this.head_mk3.func_78792_a(this.left_pipe2);
        this.setRotationAngle(this.left_pipe2, -0.3054f, 0.0f, 0.0f);
        this.cube_r18 = new ModelRenderer((ModelBase)this);
        this.cube_r18.func_78793_a(3.25f, 0.0f, 2.5f);
        this.left_pipe2.func_78792_a(this.cube_r18);
        this.setRotationAngle(this.cube_r18, 0.0f, 1.9199f, 0.0f);
        this.cube_r18.field_78804_l.add(new ModelBox(this.cube_r18, 100, 57, 0.95f, -1.5f, -6.1f, 7, 3, 3, -1.2f, true));
        this.cube_r19 = new ModelRenderer((ModelBase)this);
        this.cube_r19.func_78793_a(3.25f, 0.0f, 2.5f);
        this.left_pipe2.func_78792_a(this.cube_r19);
        this.setRotationAngle(this.cube_r19, 0.0f, 2.5307f, 0.0f);
        this.cube_r19.field_78804_l.add(new ModelBox(this.cube_r19, 87, 38, 1.75f, -1.5f, -4.0f, 4, 3, 3, -1.15f, true));
        this.cube_r20 = new ModelRenderer((ModelBase)this);
        this.cube_r20.func_78793_a(3.25f, 0.0f, 2.5f);
        this.left_pipe2.func_78792_a(this.cube_r20);
        this.setRotationAngle(this.cube_r20, 0.0f, -3.1416f, 0.0f);
        this.cube_r20.field_78804_l.add(new ModelBox(this.cube_r20, 87, 38, 1.25f, -1.5f, -1.8f, 4, 3, 3, -1.1f, true));
        this.cube_r21 = new ModelRenderer((ModelBase)this);
        this.cube_r21.func_78793_a(3.25f, 0.0f, 2.5f);
        this.left_pipe2.func_78792_a(this.cube_r21);
        this.setRotationAngle(this.cube_r21, 0.0f, -2.7925f, 0.0f);
        this.cube_r21.field_78804_l.add(new ModelBox(this.cube_r21, 87, 38, -0.45f, -1.5f, -1.0f, 4, 3, 3, -1.05f, true));
        this.cube_r22 = new ModelRenderer((ModelBase)this);
        this.cube_r22.func_78793_a(3.25f, 0.0f, 2.5f);
        this.left_pipe2.func_78792_a(this.cube_r22);
        this.setRotationAngle(this.cube_r22, 0.0f, -2.1817f, 0.0f);
        this.cube_r22.field_78804_l.add(new ModelBox(this.cube_r22, 87, 38, -2.55f, -1.5f, -0.55f, 4, 3, 3, -1.0f, true));
        this.cube_r23 = new ModelRenderer((ModelBase)this);
        this.cube_r23.func_78793_a(1.5f, -0.5f, -7.5f);
        this.left_pipe2.func_78792_a(this.cube_r23);
        this.setRotationAngle(this.cube_r23, 0.0f, -1.5708f, 0.0f);
        this.cube_r23.field_78804_l.add(new ModelBox(this.cube_r23, 87, 38, 5.5f, -1.0f, -3.25f, 4, 3, 3, -0.95f, true));
        this.cube_r24 = new ModelRenderer((ModelBase)this);
        this.cube_r24.func_78793_a(1.5f, -0.5f, -7.5f);
        this.left_pipe2.func_78792_a(this.cube_r24);
        this.setRotationAngle(this.cube_r24, 0.0f, -1.1345f, 0.0f);
        this.cube_r24.field_78804_l.add(new ModelBox(this.cube_r24, 102, 38, 1.7f, -1.0f, -0.3f, 6, 3, 3, -0.85f, true));
        this.cube_r25 = new ModelRenderer((ModelBase)this);
        this.cube_r25.func_78793_a(1.5f, -0.5f, -7.5f);
        this.left_pipe2.func_78792_a(this.cube_r25);
        this.setRotationAngle(this.cube_r25, 0.0f, -0.6109f, 0.0f);
        this.cube_r25.field_78804_l.add(new ModelBox(this.cube_r25, 102, 46, -3.0f, -1.0f, 1.0f, 6, 3, 3, -0.75f, true));
        this.left_pipe1 = new ModelRenderer((ModelBase)this);
        this.left_pipe1.func_78793_a(5.0f, -3.5f, 3.5f);
        this.head_mk3.func_78792_a(this.left_pipe1);
        this.setRotationAngle(this.left_pipe1, -0.1309f, 0.0f, 0.0f);
        this.cube_r26 = new ModelRenderer((ModelBase)this);
        this.cube_r26.func_78793_a(3.25f, 0.0f, 2.5f);
        this.left_pipe1.func_78792_a(this.cube_r26);
        this.setRotationAngle(this.cube_r26, 0.0f, 1.9199f, 0.0f);
        this.cube_r26.field_78804_l.add(new ModelBox(this.cube_r26, 100, 57, 0.95f, -1.5f, -6.1f, 7, 3, 3, -1.2f, true));
        this.cube_r27 = new ModelRenderer((ModelBase)this);
        this.cube_r27.func_78793_a(3.25f, 0.0f, 2.5f);
        this.left_pipe1.func_78792_a(this.cube_r27);
        this.setRotationAngle(this.cube_r27, 0.0f, 2.5307f, 0.0f);
        this.cube_r27.field_78804_l.add(new ModelBox(this.cube_r27, 87, 38, 1.75f, -1.5f, -4.0f, 4, 3, 3, -1.15f, true));
        this.cube_r28 = new ModelRenderer((ModelBase)this);
        this.cube_r28.func_78793_a(3.25f, 0.0f, 2.5f);
        this.left_pipe1.func_78792_a(this.cube_r28);
        this.setRotationAngle(this.cube_r28, 0.0f, -3.1416f, 0.0f);
        this.cube_r28.field_78804_l.add(new ModelBox(this.cube_r28, 87, 38, 1.25f, -1.5f, -1.8f, 4, 3, 3, -1.1f, true));
        this.cube_r29 = new ModelRenderer((ModelBase)this);
        this.cube_r29.func_78793_a(3.25f, 0.0f, 2.5f);
        this.left_pipe1.func_78792_a(this.cube_r29);
        this.setRotationAngle(this.cube_r29, 0.0f, -2.7925f, 0.0f);
        this.cube_r29.field_78804_l.add(new ModelBox(this.cube_r29, 87, 38, -0.45f, -1.5f, -1.0f, 4, 3, 3, -1.05f, true));
        this.cube_r30 = new ModelRenderer((ModelBase)this);
        this.cube_r30.func_78793_a(3.25f, 0.0f, 2.5f);
        this.left_pipe1.func_78792_a(this.cube_r30);
        this.setRotationAngle(this.cube_r30, 0.0f, -2.1817f, 0.0f);
        this.cube_r30.field_78804_l.add(new ModelBox(this.cube_r30, 87, 38, -2.55f, -1.5f, -0.55f, 4, 3, 3, -1.0f, true));
        this.cube_r31 = new ModelRenderer((ModelBase)this);
        this.cube_r31.func_78793_a(1.5f, -0.5f, -7.5f);
        this.left_pipe1.func_78792_a(this.cube_r31);
        this.setRotationAngle(this.cube_r31, 0.0f, -1.5708f, 0.0f);
        this.cube_r31.field_78804_l.add(new ModelBox(this.cube_r31, 87, 38, 5.5f, -1.0f, -3.25f, 4, 3, 3, -0.95f, true));
        this.cube_r32 = new ModelRenderer((ModelBase)this);
        this.cube_r32.func_78793_a(1.5f, -0.5f, -7.5f);
        this.left_pipe1.func_78792_a(this.cube_r32);
        this.setRotationAngle(this.cube_r32, 0.0f, -1.1345f, 0.0f);
        this.cube_r32.field_78804_l.add(new ModelBox(this.cube_r32, 102, 38, 1.7f, -1.0f, -0.3f, 6, 3, 3, -0.85f, true));
        this.cube_r33 = new ModelRenderer((ModelBase)this);
        this.cube_r33.func_78793_a(1.5f, -0.5f, -7.5f);
        this.left_pipe1.func_78792_a(this.cube_r33);
        this.setRotationAngle(this.cube_r33, 0.0f, -0.6109f, 0.0f);
        this.cube_r33.field_78804_l.add(new ModelBox(this.cube_r33, 102, 46, -3.0f, -1.0f, 1.0f, 6, 3, 3, -0.75f, true));
        this.left_arm_mk3_blade = new ModelRenderer((ModelBase)this);
        this.left_arm_mk3_blade.func_78793_a(5.0f, 0.0f, 0.0f);
        this.left_arm_mk3_blade.field_78804_l.add(new ModelBox(this.left_arm_mk3_blade, 61, 0, 1.3f, 8.0f, -3.0f, 1, 13, 6, 0.0f, false));
    }

    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.head.func_78785_a(f5);
        this.body.func_78785_a(f5);
        this.right_arm.func_78785_a(f5);
        this.left_arm.func_78785_a(f5);
        this.right_leg.func_78785_a(f5);
        this.left_leg.func_78785_a(f5);
        if (entity instanceof EntityDroidBoss) {
            this.left_arm_mk1.func_78785_a(f5);
            this.right_arm_mk1.func_78785_a(f5);
        } else {
            EntityDroid droid = (EntityDroid)entity;
            switch (droid.getGrade()) {
                case 0: {
                    this.left_arm_mk1.func_78785_a(f5);
                    this.right_arm_mk1.func_78785_a(f5);
                    break;
                }
                case 1: {
                    this.right_arm_mk1.func_78785_a(f5);
                    this.left_leg_mk2.func_78785_a(f5);
                    this.right_leg_mk2.func_78785_a(f5);
                    this.body_mk2.func_78785_a(f5);
                    GlStateManager.func_179147_l();
                    GlStateManager.func_179112_b((int)770, (int)771);
                    GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)(0.8f + 0.15f * Mth.func_76126_a((float)f2)));
                    this.left_arm_mk2.func_78785_a(f5);
                    GlStateManager.func_179084_k();
                    break;
                }
                case 2: {
                    this.left_leg_mk2.func_78785_a(f5);
                    this.right_leg_mk2.func_78785_a(f5);
                    this.body_mk2.func_78785_a(f5);
                    this.right_arm_mk3.func_78785_a(f5);
                    this.left_arm_mk3.func_78785_a(f5);
                    this.head_mk3.func_78785_a(f5);
                    GlStateManager.func_179147_l();
                    GlStateManager.func_179112_b((int)770, (int)771);
                    GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)(0.8f + 0.15f * Mth.func_76126_a((float)f2)));
                    this.left_arm_mk3_blade.func_78785_a(f5);
                    GlStateManager.func_179084_k();
                }
            }
        }
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.head.field_78796_g = netHeadYaw * ((float)Math.PI / 180);
        this.head.field_78795_f = headPitch * ((float)Math.PI / 180);
        this.head_mk3.field_78796_g = this.head.field_78796_g;
        this.head_mk3.field_78795_f = this.head.field_78795_f;
        this.right_leg.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 1.4f * limbSwingAmount * 0.5f;
        this.left_leg.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 1.4f * limbSwingAmount * 0.5f;
        this.right_leg_mk2.field_78795_f = this.right_leg.field_78795_f;
        this.left_leg_mk2.field_78795_f = this.left_leg.field_78795_f;
        this.body_mk2_rot.field_78808_h = ageInTicks * 0.5f;
        float extra_rot = 0.0f;
        float right_aim = 0.0f;
        if (entityIn instanceof EntityDroid) {
            EntityDroid droid = (EntityDroid)entityIn;
            extra_rot = -0.1f * (float)droid.getAttackTime();
            if (droid.getGrade() == 2 && droid.getTargetLevel() == 2) {
                this.right_arm_gravity.field_78796_g = ageInTicks * 0.3f;
            }
        }
        this.left_arm_mk1.field_78795_f = this.left_arm.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f + (float)Math.PI)) * 2.0f * limbSwingAmount * 0.5f + extra_rot;
        this.left_arm_mk2.field_78795_f = this.left_arm.field_78795_f;
        this.left_arm_mk3.field_78795_f = this.left_arm.field_78795_f;
        this.left_arm_mk3_blade.field_78795_f = this.left_arm.field_78795_f;
        this.right_arm_mk1.field_78795_f = this.right_arm.field_78795_f = Mth.func_76134_b((float)(limbSwing * 0.6662f)) * 2.0f * limbSwingAmount * 0.5f;
        this.right_arm_mk3.field_78795_f = this.right_arm.field_78795_f;
        this.claw.field_78808_h = Mth.func_76134_b((float)(ageInTicks * 0.1f)) * 0.15f - 0.1f;
    }
}

