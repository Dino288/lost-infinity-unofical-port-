/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.inventory.GuiContainer
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.entity.player.Inventory
 *  net.minecraft.inventory.Container
 *  net.minecraft.inventory.Slot
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.ResourceLocation
 */
package xol.lostinfinity.gui.guis;

import java.io.IOException;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import xol.lostinfinity.common.lostinfinity;
import xol.lostinfinity.common.packets.serverbound.PacketUpdatePlayerPickedItem;
import xol.lostinfinity.gui.containers.ContainerSupplyStore;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.mob.entity.misc.EntitySupplyTrader;
import xol.lostinfinity.util.client.GuiUtil;

public class GuiSupplyStore
extends GuiContainer {
    private static final ResourceLocation TEXTURE = new ResourceLocation("lostinfinity", "textures/gui/supply_trader.png");
    private final ContainerSupplyStore container;
    private final EntitySupplyTrader trader;
    private final int pageCount;
    private int page;

    public GuiSupplyStore(Inventory invPlayer) {
        super((Container)new ContainerSupplyStore(invPlayer));
        this.container = (ContainerSupplyStore)this.field_147002_h;
        this.trader = this.container.getTrader();
        this.pageCount = EntitySupplyTrader.SupplyTraderRecipe.getTotAmountRecipes();
        this.page = 0;
    }

    public void func_73863_a(int mouseX, int mouseY, float partialTicks) {
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        this.func_146276_q_();
        super.func_73863_a(mouseX, mouseY, partialTicks);
        this.func_191948_b(mouseX, mouseY);
        GlStateManager.func_179140_f();
        GlStateManager.func_179084_k();
    }

    public void func_73876_c() {
        ItemStack stack;
        super.func_73876_c();
        EntitySupplyTrader.SupplyTraderRecipe recipe = EntitySupplyTrader.SupplyTraderRecipe.getRecipeById(this.page);
        if (recipe == null) {
            return;
        }
        Slot outputSlot = this.container.func_75139_a(0);
        if (outputSlot.func_75216_d()) {
            if (outputSlot.func_75211_c().func_77973_b() != recipe.getOutput()) {
                outputSlot.func_75215_d(ItemStack.field_190927_a);
            } else {
                return;
            }
        }
        switch (this.page) {
            case 0: {
                if (this.trader.getItem1Count() >= recipe.getBuyAmount()) {
                    stack = new ItemStack(ItemInit.amazoniteToken, 1);
                    break;
                }
                stack = ItemStack.field_190927_a;
                break;
            }
            case 1: {
                if (this.trader.getItem2Count() >= recipe.getBuyAmount()) {
                    stack = new ItemStack(ItemInit.amazoniteToken, 1);
                    break;
                }
                stack = ItemStack.field_190927_a;
                break;
            }
            case 2: {
                if (this.trader.getItem3Count() >= recipe.getBuyAmount()) {
                    stack = new ItemStack(ItemInit.amazoniteToken, 3);
                    break;
                }
                stack = ItemStack.field_190927_a;
                break;
            }
            case 3: {
                if (this.trader.getItem4Count() >= recipe.getBuyAmount()) {
                    stack = new ItemStack(ItemInit.amazoniteToken, 1);
                    break;
                }
                stack = ItemStack.field_190927_a;
                break;
            }
            default: {
                stack = ItemStack.field_190927_a;
            }
        }
        if (stack.func_190926_b()) {
            outputSlot.func_75215_d(ItemStack.field_190927_a);
            return;
        }
        int cost = recipe.getBuyAmount();
        if (stack.func_190916_E() >= 0) {
            outputSlot.func_75215_d(stack);
        } else {
            outputSlot.func_75215_d(ItemStack.field_190927_a);
        }
    }

    protected void func_73864_a(int mouseX, int mouseY, int mouseButton) throws IOException {
        super.func_73864_a(mouseX, mouseY, mouseButton);
        EntitySupplyTrader.SupplyTraderRecipe recipe = EntitySupplyTrader.SupplyTraderRecipe.getRecipeById(this.page);
        if (recipe == null) {
            return;
        }
        if (this.page == 0) {
            if (GuiUtil.isInRect(this.field_147003_i + 145, this.field_147009_r + 33, 10, 15, mouseX, mouseY)) {
                ++this.page;
            }
        } else if (this.page == this.pageCount - 1) {
            if (GuiUtil.isInRect(this.field_147003_i + 25, this.field_147009_r + 33, 10, 15, mouseX, mouseY)) {
                --this.page;
            }
        } else if (GuiUtil.isInRect(this.field_147003_i + 25, this.field_147009_r + 33, 10, 15, mouseX, mouseY)) {
            --this.page;
        } else if (GuiUtil.isInRect(this.field_147003_i + 145, this.field_147009_r + 33, 10, 15, mouseX, mouseY)) {
            ++this.page;
        }
        if (GuiUtil.isInRect(this.field_147003_i + 120, this.field_147009_r + 33, 16, 16, mouseX, mouseY)) {
            Item output = recipe.getOutput();
            if (this.container.func_75139_a(0).func_75211_c().func_190926_b()) {
                return;
            }
            int stock = 0;
            switch (this.page) {
                case 0: {
                    stock = this.trader.getItem1Count();
                    break;
                }
                case 1: {
                    stock = this.trader.getItem2Count();
                    break;
                }
                case 2: {
                    stock = this.trader.getItem3Count();
                    break;
                }
                case 3: {
                    stock = this.trader.getItem4Count();
                }
            }
            int cost = recipe.getBuyAmount();
            if (stock > cost) {
                switch (this.page) {
                    case 0: {
                        int oldCount = this.trader.getItem1Count();
                        int newCount = oldCount - cost;
                        this.trader.setItem1Count(newCount);
                        break;
                    }
                    case 1: {
                        int oldCount2 = this.trader.getItem2Count();
                        int newCount2 = oldCount2 - cost;
                        this.trader.setItem2Count(newCount2);
                        break;
                    }
                    case 2: {
                        int oldCount3 = this.trader.getItem3Count();
                        int newCount3 = oldCount3 - cost;
                        this.trader.setItem3Count(newCount3);
                        break;
                    }
                    case 3: {
                        int oldCount4 = this.trader.getItem4Count();
                        int newCount4 = oldCount4 - cost;
                        this.trader.setItem4Count(newCount4);
                    }
                }
                if (this.field_146297_k.field_71439_g.field_71071_by.func_70445_o().func_190926_b()) {
                    this.field_146297_k.field_71439_g.field_71071_by.func_70437_b(this.container.func_75139_a(0).func_75211_c());
                } else {
                    this.field_146297_k.field_71439_g.field_71071_by.func_70445_o().func_190917_f(this.container.func_75139_a(0).func_75211_c().func_190916_E());
                }
                lostinfinity.instance.packetHandler.sendServerBasicPacket(new PacketUpdatePlayerPickedItem(this.field_146297_k.field_71439_g.func_145782_y(), this.field_146297_k.field_71439_g.field_71071_by.func_70445_o()));
                this.container.func_75139_a(0).func_75215_d(ItemStack.field_190927_a);
            } else if (stock == cost) {
                switch (this.page) {
                    case 0: {
                        this.trader.setItem1Count(0);
                        break;
                    }
                    case 1: {
                        this.trader.setItem2Count(0);
                        break;
                    }
                    case 2: {
                        this.trader.setItem3Count(0);
                        break;
                    }
                    case 3: {
                        this.trader.setItem4Count(0);
                    }
                }
                if (this.field_146297_k.field_71439_g.field_71071_by.func_70445_o().func_190926_b()) {
                    this.field_146297_k.field_71439_g.field_71071_by.func_70437_b(this.container.func_75139_a(0).func_75211_c());
                } else {
                    this.field_146297_k.field_71439_g.field_71071_by.func_70445_o().func_190917_f(this.container.func_75139_a(0).func_75211_c().func_190916_E());
                }
                lostinfinity.instance.packetHandler.sendServerBasicPacket(new PacketUpdatePlayerPickedItem(this.field_146297_k.field_71439_g.func_145782_y(), this.field_146297_k.field_71439_g.field_71071_by.func_70445_o()));
                this.container.func_75139_a(0).func_75215_d(ItemStack.field_190927_a);
            } else {
                this.container.func_75139_a(0).func_75215_d(ItemStack.field_190927_a);
            }
        }
    }

    protected void func_146976_a(float partialTicks, int mouseX, int mouseY) {
        EntitySupplyTrader.SupplyTraderRecipe recipe;
        this.field_146297_k.func_110434_K().func_110577_a(TEXTURE);
        this.func_73729_b(this.field_147003_i, this.field_147009_r, 0, 0, this.field_146999_f, this.field_147000_g);
        if (this.container.func_75139_a(0).func_75211_c().func_190926_b()) {
            this.func_73729_b(this.field_147003_i + 83, this.field_147009_r + 30, 212, 0, 28, 21);
        }
        if (this.page == 0) {
            this.func_73729_b(this.field_147003_i + 25, this.field_147009_r + 33, 201, 21, 10, 15);
        } else if (this.page == this.pageCount - 1) {
            this.func_73729_b(this.field_147003_i + 145, this.field_147009_r + 33, 201, 2, 10, 15);
        }
        if (this.page == 0) {
            if (GuiUtil.isInRect(this.field_147003_i + 145, this.field_147009_r + 33, 10, 15, mouseX, mouseY)) {
                this.func_73729_b(this.field_147003_i + 145, this.field_147009_r + 33, 189, 2, 10, 15);
            }
        } else if (this.page == this.pageCount - 1) {
            if (GuiUtil.isInRect(this.field_147003_i + 25, this.field_147009_r + 33, 10, 15, mouseX, mouseY)) {
                this.func_73729_b(this.field_147003_i + 25, this.field_147009_r + 33, 189, 21, 10, 15);
            }
        } else if (GuiUtil.isInRect(this.field_147003_i + 25, this.field_147009_r + 33, 10, 15, mouseX, mouseY)) {
            this.func_73729_b(this.field_147003_i + 25, this.field_147009_r + 33, 189, 21, 10, 15);
        } else if (GuiUtil.isInRect(this.field_147003_i + 145, this.field_147009_r + 33, 10, 15, mouseX, mouseY)) {
            this.func_73729_b(this.field_147003_i + 145, this.field_147009_r + 33, 189, 2, 10, 15);
        }
        if ((recipe = EntitySupplyTrader.SupplyTraderRecipe.getRecipeById(this.page)) != null) {
            this.func_73729_b(this.field_147003_i + 36, this.field_147009_r + 33, recipe.getPixelX(), recipe.getPixelY(), 16, 16);
        }
    }

    protected void func_146979_b(int mouseX, int mouseY) {
        this.field_146289_q.func_78276_b("Supply Store", 52, 6, 0);
        EntitySupplyTrader.SupplyTraderRecipe recipe = EntitySupplyTrader.SupplyTraderRecipe.getRecipeById(this.page);
        if (recipe != null) {
            switch (this.page) {
                case 0: {
                    this.field_146289_q.func_78276_b(String.valueOf(this.trader.getItem1Count()), 43, 42, -1);
                    break;
                }
                case 1: {
                    this.field_146289_q.func_78276_b(String.valueOf(this.trader.getItem2Count()), 43, 42, -1);
                    break;
                }
                case 2: {
                    this.field_146289_q.func_78276_b(String.valueOf(this.trader.getItem3Count()), 43, 42, -1);
                    break;
                }
                case 3: {
                    this.field_146289_q.func_78276_b(String.valueOf(this.trader.getItem4Count()), 43, 42, -1);
                }
            }
            this.field_146289_q.func_78276_b("x" + recipe.getBuyAmount(), 62, 36, -1);
        }
    }
}

