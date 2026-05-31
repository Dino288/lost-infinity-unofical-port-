/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelBox
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.util.math.Mth
 */
package xol.lostinfinity.mob.model.minion;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.util.Mth;
import xol.lostinfinity.mob.entity.minion.andromeda.EntityAndromedaController;
import xol.lostinfinity.mob.entity.minion.andromeda.EntityAndromedaSegment;

public class ModelAndromeda
extends ModelBase {
    private final ModelRenderer BodyPlate;
    private final ModelRenderer LeftPlate;
    private final ModelRenderer RightPlate;
    private final ModelRenderer BodyWire;
    private final ModelRenderer WiresLeft;
    private final ModelRenderer WiresLeft2;
    private final ModelRenderer BodyRotor;
    private final ModelRenderer Rotor;
    private final ModelRenderer Head;
    private final ModelRenderer Head2;
    private final ModelRenderer AttachmentL;
    private final ModelRenderer AttachmentR;
    private final ModelRenderer Drill1;
    private final ModelRenderer Drill2;
    private final ModelRenderer Drill3;
    private final ModelRenderer Tail;

    public ModelAndromeda() {
        this.field_78090_t = 128;
        this.field_78089_u = 64;
        this.BodyPlate = new ModelRenderer((ModelBase)this);
        this.BodyPlate.func_78793_a(0.0f, 16.0f, 0.0f);
        this.BodyPlate.field_78804_l.add(new ModelBox(this.BodyPlate, 0, 0, -6.0f, -6.0f, -8.0f, 12, 12, 16, 0.0f, false));
        this.BodyPlate.field_78804_l.add(new ModelBox(this.BodyPlate, 0, 44, -8.0f, -8.0f, -2.0f, 16, 16, 4, 0.0f, false));
        this.BodyPlate.field_78804_l.add(new ModelBox(this.BodyPlate, 38, 31, -7.0f, -7.0f, -6.0f, 14, 14, 2, 0.0f, false));
        this.BodyPlate.field_78804_l.add(new ModelBox(this.BodyPlate, 38, 31, -7.0f, -7.0f, 4.0f, 14, 14, 2, 0.0f, false));
        this.LeftPlate = new ModelRenderer((ModelBase)this);
        this.LeftPlate.func_78793_a(0.0f, 7.5f, 0.0f);
        this.BodyPlate.func_78792_a(this.LeftPlate);
        this.LeftPlate.field_78804_l.add(new ModelBox(this.LeftPlate, 0, 29, 7.5f, -10.0f, -2.5f, 1, 5, 5, 0.0f, false));
        this.LeftPlate.field_78804_l.add(new ModelBox(this.LeftPlate, 1, 40, 5.5f, -8.0f, 2.5f, 3, 1, 1, 0.0f, false));
        this.LeftPlate.field_78804_l.add(new ModelBox(this.LeftPlate, 1, 40, 5.5f, -8.0f, -3.5f, 3, 1, 1, 0.0f, false));
        this.LeftPlate.field_78804_l.add(new ModelBox(this.LeftPlate, 10, 40, 8.5f, -10.0f, -2.5f, 2, 1, 1, 0.0f, false));
        this.LeftPlate.field_78804_l.add(new ModelBox(this.LeftPlate, 10, 40, 8.5f, -6.0f, -2.5f, 2, 1, 1, 0.0f, false));
        this.LeftPlate.field_78804_l.add(new ModelBox(this.LeftPlate, 10, 40, 8.5f, -6.0f, 1.5f, 2, 1, 1, 0.0f, false));
        this.LeftPlate.field_78804_l.add(new ModelBox(this.LeftPlate, 10, 40, 8.5f, -10.0f, 1.5f, 2, 1, 1, 0.0f, false));
        this.RightPlate = new ModelRenderer((ModelBase)this);
        this.RightPlate.func_78793_a(0.0f, 7.5f, 0.0f);
        this.BodyPlate.func_78792_a(this.RightPlate);
        this.RightPlate.field_78804_l.add(new ModelBox(this.RightPlate, 0, 29, -8.5f, -10.0f, -2.5f, 1, 5, 5, 0.0f, true));
        this.RightPlate.field_78804_l.add(new ModelBox(this.RightPlate, 1, 40, -8.5f, -8.0f, 2.5f, 3, 1, 1, 0.0f, true));
        this.RightPlate.field_78804_l.add(new ModelBox(this.RightPlate, 1, 40, -8.5f, -8.0f, -3.5f, 3, 1, 1, 0.0f, true));
        this.RightPlate.field_78804_l.add(new ModelBox(this.RightPlate, 10, 40, -10.5f, -10.0f, -2.5f, 2, 1, 1, 0.0f, true));
        this.RightPlate.field_78804_l.add(new ModelBox(this.RightPlate, 10, 40, -10.5f, -6.0f, -2.5f, 2, 1, 1, 0.0f, true));
        this.RightPlate.field_78804_l.add(new ModelBox(this.RightPlate, 10, 40, -10.5f, -6.0f, 1.5f, 2, 1, 1, 0.0f, true));
        this.RightPlate.field_78804_l.add(new ModelBox(this.RightPlate, 10, 40, -10.5f, -10.0f, 1.5f, 2, 1, 1, 0.0f, true));
        this.BodyWire = new ModelRenderer((ModelBase)this);
        this.BodyWire.func_78793_a(0.0f, 16.0f, 0.0f);
        this.BodyWire.field_78804_l.add(new ModelBox(this.BodyWire, 0, 0, -6.0f, -6.0f, -8.0f, 12, 12, 16, 0.0f, false));
        this.BodyWire.field_78804_l.add(new ModelBox(this.BodyWire, 38, 31, -7.0f, -7.0f, -6.0f, 14, 14, 2, 0.0f, false));
        this.BodyWire.field_78804_l.add(new ModelBox(this.BodyWire, 38, 31, -7.0f, -7.0f, 4.0f, 14, 14, 2, 0.0f, false));
        this.BodyWire.field_78804_l.add(new ModelBox(this.BodyWire, 13, 30, -3.0f, -7.0f, -3.0f, 6, 1, 6, 0.0f, false));
        this.BodyWire.field_78804_l.add(new ModelBox(this.BodyWire, 20, 38, -1.0f, -8.0f, -2.0f, 2, 1, 4, 0.0f, false));
        this.WiresLeft = new ModelRenderer((ModelBase)this);
        this.WiresLeft.func_78793_a(0.0f, 3.5f, 0.0f);
        this.BodyWire.func_78792_a(this.WiresLeft);
        this.WiresLeft.field_78804_l.add(new ModelBox(this.WiresLeft, 0, 0, 2.0f, -11.5f, -2.0f, 6, 8, 1, 0.0f, false));
        this.WiresLeft.field_78804_l.add(new ModelBox(this.WiresLeft, 41, 7, 6.0f, -4.5f, -3.0f, 1, 2, 6, 0.0f, false));
        this.WiresLeft.field_78804_l.add(new ModelBox(this.WiresLeft, 41, 0, 6.0f, -1.5f, -3.0f, 1, 1, 6, 0.0f, false));
        this.WiresLeft.field_78804_l.add(new ModelBox(this.WiresLeft, 0, 0, 2.0f, -11.5f, 1.0f, 6, 8, 1, 0.0f, false));
        this.WiresLeft2 = new ModelRenderer((ModelBase)this);
        this.WiresLeft2.func_78793_a(0.0f, 3.5f, 0.0f);
        this.BodyWire.func_78792_a(this.WiresLeft2);
        this.WiresLeft2.field_78804_l.add(new ModelBox(this.WiresLeft2, 0, 0, -8.0f, -11.5f, -2.0f, 6, 8, 1, 0.0f, true));
        this.WiresLeft2.field_78804_l.add(new ModelBox(this.WiresLeft2, 41, 7, -7.0f, -4.5f, -3.0f, 1, 2, 6, 0.0f, true));
        this.WiresLeft2.field_78804_l.add(new ModelBox(this.WiresLeft2, 41, 0, -7.0f, -1.5f, -3.0f, 1, 1, 6, 0.0f, true));
        this.WiresLeft2.field_78804_l.add(new ModelBox(this.WiresLeft2, 0, 0, -8.0f, -11.5f, 1.0f, 6, 8, 1, 0.0f, true));
        this.BodyRotor = new ModelRenderer((ModelBase)this);
        this.BodyRotor.func_78793_a(0.0f, 16.0f, 0.0f);
        this.BodyRotor.field_78804_l.add(new ModelBox(this.BodyRotor, 0, 0, -6.0f, -6.0f, -8.0f, 12, 12, 16, 0.0f, false));
        this.BodyRotor.field_78804_l.add(new ModelBox(this.BodyRotor, 38, 31, -7.0f, -7.0f, -6.0f, 14, 14, 2, 0.0f, false));
        this.BodyRotor.field_78804_l.add(new ModelBox(this.BodyRotor, 38, 31, -7.0f, -7.0f, 4.0f, 14, 14, 2, 0.0f, false));
        this.Rotor = new ModelRenderer((ModelBase)this);
        this.Rotor.func_78793_a(0.0f, 0.0f, 0.0f);
        this.BodyRotor.func_78792_a(this.Rotor);
        this.Rotor.field_78804_l.add(new ModelBox(this.Rotor, 71, 44, -9.0f, -9.0f, -1.0f, 18, 18, 2, 0.0f, false));
        this.Rotor.field_78804_l.add(new ModelBox(this.Rotor, 58, 48, 5.0f, -11.0f, -1.0f, 4, 2, 2, 0.0f, false));
        this.Rotor.field_78804_l.add(new ModelBox(this.Rotor, 58, 48, -2.0f, -11.0f, -1.0f, 4, 2, 2, 0.0f, false));
        this.Rotor.field_78804_l.add(new ModelBox(this.Rotor, 58, 48, -9.0f, -11.0f, -1.0f, 4, 2, 2, 0.0f, false));
        this.Rotor.field_78804_l.add(new ModelBox(this.Rotor, 58, 54, -2.0f, 9.0f, -1.0f, 4, 2, 2, 0.0f, false));
        this.Rotor.field_78804_l.add(new ModelBox(this.Rotor, 58, 54, -9.0f, 9.0f, -1.0f, 4, 2, 2, 0.0f, false));
        this.Rotor.field_78804_l.add(new ModelBox(this.Rotor, 58, 54, 5.0f, 9.0f, -1.0f, 4, 2, 2, 0.0f, false));
        this.Rotor.field_78804_l.add(new ModelBox(this.Rotor, 41, 56, 9.0f, 5.0f, -1.0f, 2, 4, 2, 0.0f, false));
        this.Rotor.field_78804_l.add(new ModelBox(this.Rotor, 41, 56, 9.0f, -2.0f, -1.0f, 2, 4, 2, 0.0f, false));
        this.Rotor.field_78804_l.add(new ModelBox(this.Rotor, 41, 56, 9.0f, -9.0f, -1.0f, 2, 4, 2, 0.0f, false));
        this.Rotor.field_78804_l.add(new ModelBox(this.Rotor, 41, 49, -11.0f, -9.0f, -1.0f, 2, 4, 2, 0.0f, false));
        this.Rotor.field_78804_l.add(new ModelBox(this.Rotor, 41, 49, -11.0f, -2.0f, -1.0f, 2, 4, 2, 0.0f, false));
        this.Rotor.field_78804_l.add(new ModelBox(this.Rotor, 41, 49, -11.0f, 5.0f, -1.0f, 2, 4, 2, 0.0f, false));
        this.Head = new ModelRenderer((ModelBase)this);
        this.Head.func_78793_a(0.0f, 16.0f, 0.0f);
        this.Head2 = new ModelRenderer((ModelBase)this);
        this.Head2.func_78793_a(0.0f, 0.0f, 0.0f);
        this.Head.func_78792_a(this.Head2);
        this.Head2.field_78804_l.add(new ModelBox(this.Head2, 88, 22, -6.0f, -6.0f, 0.0f, 12, 12, 8, 0.0f, false));
        this.Head2.field_78804_l.add(new ModelBox(this.Head2, 88, 1, -6.0f, -6.0f, -8.0f, 12, 12, 8, 0.0f, false));
        this.Head2.field_78804_l.add(new ModelBox(this.Head2, 38, 31, -7.0f, -7.0f, 4.0f, 14, 14, 2, 0.0f, false));
        this.Head2.field_78804_l.add(new ModelBox(this.Head2, 45, 17, -1.0f, -6.5f, -8.0f, 2, 1, 12, 0.0f, false));
        this.Head2.field_78804_l.add(new ModelBox(this.Head2, 41, 51, -1.0f, 5.5f, -8.0f, 2, 1, 12, 0.0f, false));
        this.AttachmentL = new ModelRenderer((ModelBase)this);
        this.AttachmentL.func_78793_a(0.0f, 7.5f, 0.0f);
        this.Head2.func_78792_a(this.AttachmentL);
        this.AttachmentL.field_78804_l.add(new ModelBox(this.AttachmentL, 72, 29, 7.0f, -9.5f, -1.0f, 4, 4, 2, 0.0f, false));
        this.AttachmentL.field_78804_l.add(new ModelBox(this.AttachmentL, 72, 36, 6.0f, -9.5f, 1.0f, 5, 1, 1, 0.0f, false));
        this.AttachmentL.field_78804_l.add(new ModelBox(this.AttachmentL, 72, 36, 6.0f, -6.5f, 1.0f, 5, 1, 1, 0.0f, false));
        this.AttachmentR = new ModelRenderer((ModelBase)this);
        this.AttachmentR.func_78793_a(0.0f, 7.5f, 0.0f);
        this.Head2.func_78792_a(this.AttachmentR);
        this.AttachmentR.field_78804_l.add(new ModelBox(this.AttachmentR, 72, 29, -11.0f, -9.5f, -1.0f, 4, 4, 2, 0.0f, true));
        this.AttachmentR.field_78804_l.add(new ModelBox(this.AttachmentR, 72, 36, -11.0f, -9.5f, 1.0f, 5, 1, 1, 0.0f, true));
        this.AttachmentR.field_78804_l.add(new ModelBox(this.AttachmentR, 72, 36, -11.0f, -6.5f, 1.0f, 5, 1, 1, 0.0f, true));
        this.Drill1 = new ModelRenderer((ModelBase)this);
        this.Drill1.func_78793_a(0.0f, 0.0f, -5.0f);
        this.Head2.func_78792_a(this.Drill1);
        this.Drill1.field_78804_l.add(new ModelBox(this.Drill1, 63, 14, -2.0f, -2.0f, -5.0f, 4, 4, 10, 0.0f, false));
        this.Drill1.field_78804_l.add(new ModelBox(this.Drill1, 62, 18, -2.0f, -2.0f, -3.0f, 4, 4, 1, 0.2f, false));
        this.Drill1.field_78804_l.add(new ModelBox(this.Drill1, 62, 18, -2.0f, -2.0f, 0.0f, 4, 4, 1, 0.2f, false));
        this.Drill1.field_78804_l.add(new ModelBox(this.Drill1, 62, 18, -2.0f, -2.0f, 3.0f, 4, 4, 1, 0.2f, false));
        this.Drill2 = new ModelRenderer((ModelBase)this);
        this.Drill2.func_78793_a(9.0f, 0.0f, -6.0f);
        this.Head2.func_78792_a(this.Drill2);
        this.Drill2.field_78804_l.add(new ModelBox(this.Drill2, 50, 0, -1.0f, -1.0f, -5.0f, 2, 2, 10, 0.0f, false));
        this.Drill2.field_78804_l.add(new ModelBox(this.Drill2, 50, 0, -1.0f, -1.0f, -3.0f, 2, 2, 1, 0.2f, false));
        this.Drill2.field_78804_l.add(new ModelBox(this.Drill2, 50, 0, -1.0f, -1.0f, 0.0f, 2, 2, 1, 0.2f, false));
        this.Drill2.field_78804_l.add(new ModelBox(this.Drill2, 50, 0, -1.0f, -1.0f, 3.0f, 2, 2, 1, 0.2f, false));
        this.Drill3 = new ModelRenderer((ModelBase)this);
        this.Drill3.func_78793_a(-9.0f, 0.0f, -6.0f);
        this.Head2.func_78792_a(this.Drill3);
        this.Drill3.field_78804_l.add(new ModelBox(this.Drill3, 50, 0, -1.0f, -1.0f, -5.0f, 2, 2, 10, 0.0f, false));
        this.Drill3.field_78804_l.add(new ModelBox(this.Drill3, 50, 0, -1.0f, -1.0f, -3.0f, 2, 2, 1, 0.2f, false));
        this.Drill3.field_78804_l.add(new ModelBox(this.Drill3, 50, 0, -1.0f, -1.0f, 0.0f, 2, 2, 1, 0.2f, false));
        this.Drill3.field_78804_l.add(new ModelBox(this.Drill3, 50, 0, -1.0f, -1.0f, 3.0f, 2, 2, 1, 0.2f, false));
        this.Tail = new ModelRenderer((ModelBase)this);
        this.Tail.func_78793_a(0.0f, 16.0f, 0.0f);
        this.Tail.field_78804_l.add(new ModelBox(this.Tail, 65, 0, 1.0f, -6.0f, -8.0f, 5, 5, 5, 0.0f, false));
        this.Tail.field_78804_l.add(new ModelBox(this.Tail, 112, 55, 2.0f, -5.0f, -3.0f, 3, 3, 5, 0.0f, false));
        this.Tail.field_78804_l.add(new ModelBox(this.Tail, 112, 46, 2.5f, -4.5f, 2.0f, 2, 2, 6, 0.0f, false));
        this.Tail.field_78804_l.add(new ModelBox(this.Tail, 65, 0, -6.0f, -6.0f, -8.0f, 5, 5, 5, 0.0f, false));
        this.Tail.field_78804_l.add(new ModelBox(this.Tail, 112, 55, -5.0f, -5.0f, -3.0f, 3, 3, 5, 0.0f, false));
        this.Tail.field_78804_l.add(new ModelBox(this.Tail, 112, 46, -4.5f, -4.5f, 2.0f, 2, 2, 6, 0.0f, false));
        this.Tail.field_78804_l.add(new ModelBox(this.Tail, 65, 0, -6.0f, 1.0f, -8.0f, 5, 5, 5, 0.0f, false));
        this.Tail.field_78804_l.add(new ModelBox(this.Tail, 112, 55, -5.0f, 2.0f, -3.0f, 3, 3, 5, 0.0f, false));
        this.Tail.field_78804_l.add(new ModelBox(this.Tail, 112, 46, -4.5f, 2.5f, 2.0f, 2, 2, 6, 0.0f, false));
        this.Tail.field_78804_l.add(new ModelBox(this.Tail, 65, 0, 1.0f, 1.0f, -8.0f, 5, 5, 5, 0.0f, false));
        this.Tail.field_78804_l.add(new ModelBox(this.Tail, 112, 55, 2.0f, 2.0f, -3.0f, 3, 3, 5, 0.0f, false));
        this.Tail.field_78804_l.add(new ModelBox(this.Tail, 112, 46, 2.5f, 2.5f, 2.0f, 2, 2, 6, 0.0f, false));
        this.Tail.field_78804_l.add(new ModelBox(this.Tail, 38, 31, -7.0f, -7.0f, -6.0f, 14, 14, 2, 0.0f, false));
    }

    /*
     * Enabled aggressive block sorting
     */
    public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        EntityAndromedaSegment segment = (EntityAndromedaSegment)entity;
        EntityAndromedaController controller = segment.getController();
        if (controller == null) {
            return;
        }
        Player owner = controller.getOwner();
        if (owner != null && owner == Minecraft.func_71410_x().field_71439_g) {
            double d;
            double dst = segment.func_70068_e((Entity)owner);
            if (d <= 900.0) {
                GlStateManager.func_179147_l();
                GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)Mth.func_76131_a((float)((float)(dst - 225.0) / 675.0f), (float)0.0f, (float)1.0f));
                this.getModelRenderer(entity).func_78785_a(f5);
                GlStateManager.func_179084_k();
                return;
            }
        }
        this.getModelRenderer(entity).func_78785_a(f5);
    }

    public void func_78087_a(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        ModelRenderer renderer = this.getModelRenderer(entityIn);
        renderer.field_78795_f = headPitch * ((float)Math.PI / 180);
        if (renderer == this.Head) {
            this.Head2.field_78808_h = ageInTicks * ((float)Math.PI / 180);
            this.Drill1.field_78808_h = ageInTicks;
            this.Drill2.field_78808_h = ageInTicks;
            this.Drill3.field_78808_h = ageInTicks;
        } else if (renderer == this.BodyRotor) {
            this.Rotor.field_78808_h = -ageInTicks * 18.0f * ((float)Math.PI / 180);
        }
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }

    protected ModelRenderer getModelRenderer(Entity entity) {
        if (entity instanceof EntityAndromedaSegment.Head) {
            return this.Head;
        }
        if (entity instanceof EntityAndromedaSegment.Tail) {
            return this.Tail;
        }
        if (entity instanceof EntityAndromedaSegment) {
            switch (((EntityAndromedaSegment)entity).getId() % 3) {
                case 0: {
                    return this.BodyRotor;
                }
                case 1: {
                    return this.BodyPlate;
                }
                case 2: {
                    return this.BodyWire;
                }
            }
        }
        return this.BodyPlate;
    }
}

