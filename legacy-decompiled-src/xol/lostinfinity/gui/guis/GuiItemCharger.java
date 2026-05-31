/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiTextField
 *  net.minecraft.client.gui.inventory.GuiContainer
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.entity.player.Inventory
 *  net.minecraft.inventory.Container
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.world.World
 *  org.lwjgl.input.Keyboard
 */
package xol.lostinfinity.gui.guis;

import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.inventory.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import org.lwjgl.input.Keyboard;
import xol.lostinfinity.gui.containers.ContainerItemCharger;

public class GuiItemCharger
extends GuiContainer {
    private static final ResourceLocation texture = new ResourceLocation("lostinfinity", "textures/gui/item_charger.png");
    private final ContainerItemCharger charger;
    private final ItemStack chargeable;
    private GuiTextField nameField;

    public GuiItemCharger(Inventory invPlayer, Level worldIn) {
        super((Container)new ContainerItemCharger(invPlayer, worldIn, invPlayer.func_70448_g()));
        this.chargeable = invPlayer.func_70448_g();
        this.charger = (ContainerItemCharger)this.field_147002_h;
    }

    public void func_73866_w_() {
        super.func_73866_w_();
        Keyboard.enableRepeatEvents((boolean)true);
        int i = (this.field_146294_l - this.field_146999_f) / 2;
        int j = (this.field_146295_m - this.field_147000_g) / 2;
        this.nameField = new GuiTextField(0, this.field_146289_q, i + 45, j + 63, 103, 12);
        this.nameField.func_146193_g(-1);
        this.nameField.func_146204_h(-1);
        this.nameField.func_146185_a(false);
        this.nameField.func_146203_f(35);
    }

    public void func_146281_b() {
        super.func_146281_b();
    }

    protected void func_146979_b(int mouseX, int mouseY) {
        GlStateManager.func_179140_f();
        GlStateManager.func_179084_k();
        this.field_146289_q.func_78276_b("Item Charger", 55, 2, 0x404040);
        switch (this.charger.status) {
            case AWAITING_INPUT: 
            case PARTIAL_INPUT: 
            case VALID: {
                if (this.charger.charger.func_77942_o()) {
                    this.nameField.func_146180_a("Cur Charge: " + (int)((double)this.charger.charger.func_77978_p().func_74762_e("Charge") / (double)this.charger.getMaxChargeForItem() * 100.0) + "%");
                    break;
                }
                this.nameField.func_146180_a("Cur Charge: 0%");
                break;
            }
            case FULLY_CHARGED: {
                this.nameField.func_146180_a("Fully charged.");
            }
        }
        this.nameField.func_146193_g(this.charger.status.getColor());
        GlStateManager.func_179145_e();
    }

    public void func_73863_a(int mouseX, int mouseY, float partialTicks) {
        this.func_146276_q_();
        super.func_73863_a(mouseX, mouseY, partialTicks);
        this.func_191948_b(mouseX, mouseY);
        GlStateManager.func_179140_f();
        GlStateManager.func_179084_k();
        this.nameField.func_146194_f();
    }

    protected void func_146976_a(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        this.field_146297_k.func_110434_K().func_110577_a(texture);
        int i = (this.field_146294_l - this.field_146999_f) / 2;
        int j = (this.field_146295_m - this.field_147000_g) / 2;
        this.func_73729_b(i, j, 0, 0, this.field_146999_f, this.field_147000_g);
        this.func_73729_b(i + 33, j + 60, 0, this.field_147000_g, 110, 16);
    }
}

