/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.client.gui.GuiTextField
 *  net.minecraft.client.gui.inventory.GuiContainer
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.entity.player.Inventory
 *  net.minecraft.inventory.Container
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 *  org.lwjgl.input.Keyboard
 */
package xol.lostinfinity.gui.guis;

import net.minecraft.world.level.block.Block;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.inventory.Container;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import org.lwjgl.input.Keyboard;
import xol.lostinfinity.gui.containers.ContainerModuleCreator;

public class GuiModuleCreator
extends GuiContainer {
    private static final ResourceLocation texture = new ResourceLocation("lostinfinity", "textures/gui/module_creator.png");
    private final ContainerModuleCreator sFab;
    private final Inventory playerInventory;
    private GuiTextField nameField;

    public GuiModuleCreator(Inventory invPlayer, Level worldIn, BlockPos pos, Block block) {
        super((Container)new ContainerModuleCreator(invPlayer, worldIn, pos, block));
        this.sFab = (ContainerModuleCreator)this.field_147002_h;
        this.playerInventory = invPlayer;
    }

    public void func_73866_w_() {
        super.func_73866_w_();
        Keyboard.enableRepeatEvents((boolean)true);
        int i = (this.field_146294_l - this.field_146999_f) / 2;
        int j = (this.field_146295_m - this.field_147000_g) / 2;
        this.nameField = new GuiTextField(0, this.field_146289_q, i + 62, j + 24, 103, 12);
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
        this.field_146289_q.func_78276_b("Module Creator", 48, 3, 0x404040);
        boolean hasBeenSet = false;
        if (this.sFab.func_75139_a(1).func_75216_d() && this.sFab.status == ContainerModuleCreator.ModulatorStatus.VALID) {
            hasBeenSet = true;
            this.nameField.func_146193_g(ContainerModuleCreator.ModulatorStatus.VALID.getColor());
        }
        if (!hasBeenSet) {
            this.nameField.func_146180_a("");
            this.nameField.func_146193_g(this.sFab.status.getColor());
        }
        if (this.sFab.status != ContainerModuleCreator.ModulatorStatus.AWAITING_INPUT) {
            int i = 8453920;
            boolean flag = true;
            String s = "";
            if (!this.sFab.func_75139_a(2).func_75216_d()) {
                flag = false;
            } else if (!this.sFab.func_75139_a(2).func_82869_a(this.playerInventory.field_70458_d)) {
                i = 0xFF6060;
            }
            if (flag) {
                int j = 0xFF000000 | (i & 0xFCFCFC) >> 2 | i & 0xFF000000;
                int k = this.field_146999_f - 8 - this.field_146289_q.func_78256_a(s);
                int l = 67;
                if (this.field_146289_q.func_82883_a()) {
                    GuiModuleCreator.func_73734_a((int)(k - 3), (int)65, (int)(this.field_146999_f - 7), (int)77, (int)-16777216);
                    GuiModuleCreator.func_73734_a((int)(k - 2), (int)66, (int)(this.field_146999_f - 8), (int)76, (int)-12895429);
                } else {
                    this.field_146289_q.func_78276_b(s, k, 68, j);
                    this.field_146289_q.func_78276_b(s, k + 1, 67, j);
                    this.field_146289_q.func_78276_b(s, k + 1, 68, j);
                }
                this.field_146289_q.func_78276_b(s, k, 67, i);
            }
        }
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
        boolean shouldLightUp = !(!this.sFab.func_75139_a(0).func_75216_d() && !this.sFab.func_75139_a(1).func_75216_d() || !this.sFab.func_75139_a(2).func_75216_d() || !this.sFab.func_75139_a(3).func_75216_d() || this.sFab.status != ContainerModuleCreator.ModulatorStatus.AWAITING_INPUT && this.sFab.status != ContainerModuleCreator.ModulatorStatus.VALID);
        this.func_73729_b(i + 59, j + 20, 0, this.field_147000_g + (shouldLightUp ? 0 : 16), 110, 16);
        if ((this.sFab.func_75139_a(0).func_75216_d() || this.sFab.func_75139_a(1).func_75216_d()) && this.sFab.func_75139_a(3).func_75216_d() && !this.sFab.func_75139_a(4).func_75216_d()) {
            this.func_73729_b(i + 97, j + 33, this.field_146999_f, 0, 27, 21);
        }
    }
}

