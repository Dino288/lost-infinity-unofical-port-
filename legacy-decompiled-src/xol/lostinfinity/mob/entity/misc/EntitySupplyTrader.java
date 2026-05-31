/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.Player
 *  net.minecraft.entity.player.ServerPlayer
 *  net.minecraft.inventory.ItemStackHelper
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.NonNullList
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.village.MerchantRecipe
 *  net.minecraft.village.MerchantRecipeList
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.misc;

import java.util.List;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.NonNullList;
import net.minecraft.world.phys.AABB;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.level.Level;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.common.lostinfinity;
import xol.lostinfinity.common.packets.clientbound.PacketSupplyInventoryClient;
import xol.lostinfinity.common.packets.serverbound.PacketSupplyInventoryServer;
import xol.lostinfinity.gui.GuiHandler;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.mob.entity.base.EntityBaseMerchant;

public class EntitySupplyTrader
extends EntityBaseMerchant {
    private static final DataParameter<Integer> TRADE_MODE = EntityDataManager.func_187226_a(EntitySupplyTrader.class, (DataSerializer)DataSerializers.field_187192_b);
    private static final DataParameter<Integer> ITEM1_COUNT = EntityDataManager.func_187226_a(EntitySupplyTrader.class, (DataSerializer)DataSerializers.field_187192_b);
    private static final DataParameter<Integer> ITEM2_COUNT = EntityDataManager.func_187226_a(EntitySupplyTrader.class, (DataSerializer)DataSerializers.field_187192_b);
    private static final DataParameter<Integer> ITEM3_COUNT = EntityDataManager.func_187226_a(EntitySupplyTrader.class, (DataSerializer)DataSerializers.field_187192_b);
    private static final DataParameter<Integer> ITEM4_COUNT = EntityDataManager.func_187226_a(EntitySupplyTrader.class, (DataSerializer)DataSerializers.field_187192_b);
    private NonNullList<ItemStack> inventory = NonNullList.func_191197_a((int)100, (Object)ItemStack.field_190927_a);

    public int getItem1Count() {
        return (Integer)this.field_70180_af.func_187225_a(ITEM1_COUNT);
    }

    public int getItem2Count() {
        return (Integer)this.field_70180_af.func_187225_a(ITEM2_COUNT);
    }

    public int getItem3Count() {
        return (Integer)this.field_70180_af.func_187225_a(ITEM3_COUNT);
    }

    public int getItem4Count() {
        return (Integer)this.field_70180_af.func_187225_a(ITEM4_COUNT);
    }

    public void setItem1Count(int count) {
        this.field_70180_af.func_187227_b(ITEM1_COUNT, (Object)count);
    }

    public void setItem2Count(int count) {
        this.field_70180_af.func_187227_b(ITEM2_COUNT, (Object)count);
    }

    public void setItem3Count(int count) {
        this.field_70180_af.func_187227_b(ITEM3_COUNT, (Object)count);
    }

    public void setItem4Count(int count) {
        this.field_70180_af.func_187227_b(ITEM4_COUNT, (Object)count);
    }

    public EntitySupplyTrader(Level worldIn) {
        super(worldIn);
    }

    protected void func_70088_a() {
        super.func_70088_a();
        this.func_184212_Q().func_187214_a(TRADE_MODE, (Object)0);
        this.field_70180_af.func_187214_a(ITEM1_COUNT, (Object)0);
        this.field_70180_af.func_187214_a(ITEM2_COUNT, (Object)0);
        this.field_70180_af.func_187214_a(ITEM3_COUNT, (Object)0);
        this.field_70180_af.func_187214_a(ITEM4_COUNT, (Object)0);
    }

    @Override
    public MerchantRecipeList getRecipeList() {
        MerchantRecipeList list = new MerchantRecipeList();
        for (int i = 0; i < SupplyTraderRecipe.getTotAmountRecipes(); ++i) {
            SupplyTraderRecipe recipe = SupplyTraderRecipe.getRecipeById(i);
            if (recipe == null) continue;
            list.add((Object)recipe.getRecipe());
        }
        return list;
    }

    @Override
    public boolean func_184645_a(Player player, InteractionHand hand) {
        if (!this.field_70170_p.field_72995_K) {
            this.updateInventoryToClient(player);
            if (player.func_70093_af()) {
                if (this.getTradeMode() == 0) {
                    this.setTradeMode(1);
                    player.func_145747_a((Component)new Component((Object)((Object)TextFmt.Gold) + "Supply Trader: " + (Object)((Object)TextFmt.Reset) + "Selling items!"));
                } else if (this.getTradeMode() == 1) {
                    this.setTradeMode(0);
                    player.func_145747_a((Component)new Component((Object)((Object)TextFmt.Gold) + "Supply Trader: " + (Object)((Object)TextFmt.Reset) + "Taking shipments!"));
                }
            }
        }
        if (!player.func_70093_af()) {
            if (!this.field_70170_p.field_72995_K) {
                this.updateInventoryToClient(player);
            }
            if (this.getTradeMode() == 0) {
                if (!this.field_70170_p.field_72995_K) {
                    player.openGui((Object)lostinfinity.instance, GuiHandler.RegisteredGuis.SUPPLY_DEPOSIT.getId(), this.field_70170_p, this.func_180425_c().func_177958_n(), this.func_180425_c().func_177956_o(), this.func_180425_c().func_177952_p());
                }
            } else if (this.getTradeMode() == 1 && !this.field_70170_p.field_72995_K) {
                player.openGui((Object)lostinfinity.instance, GuiHandler.RegisteredGuis.SUPPLY_STORE.getId(), this.field_70170_p, this.func_180425_c().func_177958_n(), this.func_180425_c().func_177956_o(), this.func_180425_c().func_177952_p());
            }
        }
        return true;
    }

    public void updateInventoryToClient(Player player) {
        for (int i = 0; i < this.inventory.size(); ++i) {
            lostinfinity.instance.packetHandler.sendToPlayer((ServerPlayer)player, new PacketSupplyInventoryClient(this.func_145782_y(), i, (ItemStack)this.inventory.get(i)));
        }
    }

    public void updateInventoryToServer(int slot, ItemStack stack) {
        for (int i = 0; i < this.inventory.size(); ++i) {
            lostinfinity.instance.packetHandler.sendServerBasicPacket(new PacketSupplyInventoryServer(this.func_145782_y(), i, (ItemStack)this.inventory.get(i)));
        }
    }

    public void setInventorySlotContents(int index, ItemStack stack) {
        this.inventory.set(index, (Object)stack);
        if (!this.field_70170_p.field_72995_K) {
            List nearPlayers = this.field_70170_p.func_72872_a(Player.class, new AABB(this.func_180425_c()).func_186662_g(32.0));
            nearPlayers.forEach(this::updateInventoryToClient);
        }
    }

    public void func_70014_b(CompoundTag compound) {
        ItemStackHelper.func_191282_a((CompoundTag)compound, this.inventory);
        compound.func_74768_a("trade_mode", this.getTradeMode());
        compound.func_74768_a("item1_count", this.getItem1Count());
        compound.func_74768_a("item2_count", this.getItem2Count());
        compound.func_74768_a("item3_count", this.getItem3Count());
        compound.func_74768_a("item4_count", this.getItem4Count());
        super.func_70014_b(compound);
    }

    public void func_70037_a(CompoundTag compound) {
        ItemStackHelper.func_191283_b((CompoundTag)compound, this.inventory);
        this.setTradeMode(compound.func_74762_e("trade_mode"));
        this.setItem1Count(compound.func_74762_e("item1_count"));
        this.setItem2Count(compound.func_74762_e("item2_count"));
        this.setItem3Count(compound.func_74762_e("item3_count"));
        this.setItem4Count(compound.func_74762_e("item4_count"));
        super.func_70037_a(compound);
    }

    public int getTradeMode() {
        return (Integer)this.func_184212_Q().func_187225_a(TRADE_MODE);
    }

    public void setTradeMode(int tradeMode) {
        this.func_184212_Q().func_187227_b(TRADE_MODE, (Object)tradeMode);
    }

    public NonNullList<ItemStack> getInventory() {
        return this.inventory;
    }

    public int stock(Item item) {
        int count = 0;
        for (ItemStack stack : this.inventory) {
            if (stack.func_77973_b() != item) continue;
            count += stack.func_190916_E();
        }
        return count;
    }

    public ItemStack getStack(Item item) {
        for (ItemStack stack : this.inventory) {
            if (stack.func_77973_b() != item) continue;
            return stack;
        }
        return ItemStack.field_190927_a;
    }

    public int getStackIndex(Item item) {
        for (int i = 0; i < this.inventory.size(); ++i) {
            if (((ItemStack)this.inventory.get(i)).func_77973_b() != item) continue;
            return i;
        }
        return -1;
    }

    private void displayItems(Player player) {
        for (int i = 0; i < this.inventory.size(); ++i) {
            if (this.inventory.get(i) == ItemStack.field_190927_a) continue;
            player.func_145747_a((Component)new Component((Object)((Object)TextFmt.Gold) + "Item: " + (Object)((Object)TextFmt.Reset) + ((ItemStack)this.inventory.get(i)).func_82833_r()));
            player.func_145747_a((Component)new Component((Object)((Object)TextFmt.Gold) + "Quantity: " + (Object)((Object)TextFmt.Reset) + ((ItemStack)this.inventory.get(i)).func_190916_E()));
        }
    }

    public static enum SupplyTraderRecipe {
        AZURE_LEAF(ItemInit.azureLeaf, ItemInit.amazoniteToken, 0, 15, 1, 0, 166),
        VINES(ItemInit.constrictingVines, ItemInit.amazoniteToken, 1, 10, 1, 16, 166),
        INGOT(ItemInit.lucientIngot, ItemInit.amazoniteToken, 2, 3, 3, 32, 166),
        BLOSSOM(ItemInit.bumbleBlossom, ItemInit.amazoniteToken, 3, 4, 1, 48, 166);

        private Item item;
        private Item output;
        private int id;
        private int buyAmount;
        private int sellAmount;
        private int pixelX;
        private int pixelY;
        private MerchantRecipe recipe;

        private SupplyTraderRecipe(Item item, Item output, int id, int buyAmount, int sellAmount, int pixelX, int pixelY) {
            this.item = item;
            this.output = output;
            this.id = id;
            this.buyAmount = buyAmount;
            this.sellAmount = sellAmount;
            this.pixelX = pixelX;
            this.pixelY = pixelY;
            this.recipe = new MerchantRecipe(new ItemStack(item, buyAmount), new ItemStack(output, sellAmount));
        }

        public Item getItem() {
            return this.item;
        }

        public Item getOutput() {
            return this.output;
        }

        public int getBuyAmount() {
            return this.buyAmount;
        }

        public int getSellAmount() {
            return this.sellAmount;
        }

        public int getId() {
            return this.id;
        }

        public int getPixelX() {
            return this.pixelX;
        }

        public int getPixelY() {
            return this.pixelY;
        }

        public MerchantRecipe getRecipe() {
            return this.recipe;
        }

        public static SupplyTraderRecipe getRecipeById(int id) {
            for (SupplyTraderRecipe recipe : SupplyTraderRecipe.values()) {
                if (recipe.getId() != id) continue;
                return recipe;
            }
            return null;
        }

        public static boolean isItemInRecipe(Item item) {
            for (SupplyTraderRecipe recipe : SupplyTraderRecipe.values()) {
                if (recipe.getItem() != item) continue;
                return true;
            }
            return false;
        }

        public static int getTotAmountRecipes() {
            return SupplyTraderRecipe.values().length;
        }
    }
}

