/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.HashBasedTable
 *  com.google.common.collect.Table
 *  net.minecraft.item.ItemStack
 */
package xol.lostinfinity.util.compatibility.jei.trades.blackmarket;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import java.util.Map;
import net.minecraft.world.item.ItemStack;
import xol.lostinfinity.init.ItemInit;

public class BlackMarketTradeJEI {
    private static final BlackMarketTradeJEI INSTANCE = new BlackMarketTradeJEI();
    private final Table<ItemStack, ItemStack, ItemStack> blackMarketTradeList = HashBasedTable.create();

    public BlackMarketTradeJEI() {
        ItemStack masterAlloy = new ItemStack(ItemInit.masterCraftedAlloy);
        masterAlloy.func_190920_e(15);
        this.addBlackMarketTradeRecipe(masterAlloy, new ItemStack(ItemInit.containerOfCollectionFull), new ItemStack(ItemInit.dualWeaponConvertor));
        ItemStack crystalAlloy = new ItemStack(ItemInit.crystallizedAlloy);
        crystalAlloy.func_190920_e(15);
        this.addBlackMarketTradeRecipe(crystalAlloy, new ItemStack(ItemInit.containerOfCollectionFull), new ItemStack(ItemInit.directWeaponConvertor));
        ItemStack starCrystal = new ItemStack(ItemInit.starcrystalCapacitor);
        starCrystal.func_190920_e(10);
        this.addBlackMarketTradeRecipe(starCrystal, new ItemStack(ItemInit.containerOfCollectionFull), new ItemStack(ItemInit.ultrapoweredCapacitor));
        ItemStack gigaCharge = new ItemStack(ItemInit.gigachargeSolutions);
        gigaCharge.func_190920_e(10);
        this.addBlackMarketTradeRecipe(gigaCharge, new ItemStack(ItemInit.containerOfCollectionFull), new ItemStack(ItemInit.minorMultiversalDevice));
        ItemStack unstableIngot = new ItemStack(ItemInit.unstableIngot);
        unstableIngot.func_190920_e(20);
        this.addBlackMarketTradeRecipe(unstableIngot, new ItemStack(ItemInit.containerOfCollectionFull), new ItemStack(ItemInit.radioactiveIsotopes));
        this.addBlackMarketTradeRecipe(new ItemStack(ItemInit.deviantFragmentBL), ItemStack.field_190927_a, new ItemStack(ItemInit.broachOfDeviancy));
        this.addBlackMarketTradeRecipe(new ItemStack(ItemInit.deviantFragmentBR), ItemStack.field_190927_a, new ItemStack(ItemInit.broachOfDeviancy));
        this.addBlackMarketTradeRecipe(new ItemStack(ItemInit.deviantFragmentTR), ItemStack.field_190927_a, new ItemStack(ItemInit.broachOfDeviancy));
        this.addBlackMarketTradeRecipe(new ItemStack(ItemInit.deviantFragmentTL), ItemStack.field_190927_a, new ItemStack(ItemInit.broachOfDeviancy));
        ItemStack silverToken = new ItemStack(ItemInit.silverToken);
        silverToken.func_190920_e(10);
        this.addBlackMarketTradeRecipe(silverToken, ItemStack.field_190927_a, new ItemStack(ItemInit.hypersonicDriveChamber));
        ItemStack amazonToken = new ItemStack(ItemInit.amazoniteToken);
        amazonToken.func_190920_e(4);
        ItemStack superCell = new ItemStack(ItemInit.superCell);
        superCell.func_190920_e(2);
        this.addBlackMarketTradeRecipe(amazonToken, new ItemStack(ItemInit.reactiveMushroom), superCell);
        ItemStack ghostlyHusk = new ItemStack(ItemInit.ghostlyHusk);
        ghostlyHusk.func_190920_e(60);
        this.addBlackMarketTradeRecipe(amazonToken, ghostlyHusk, new ItemStack(ItemInit.etherstockSeeds));
        ItemStack goldToken = new ItemStack(ItemInit.goldToken);
        this.addBlackMarketTradeRecipe(new ItemStack(ItemInit.boxOfLife), ItemStack.field_190927_a, goldToken);
    }

    public static BlackMarketTradeJEI getInstance() {
        return INSTANCE;
    }

    public void addBlackMarketTradeRecipe(ItemStack input1, ItemStack input2, ItemStack result) {
        if (this.getBlackMarketTradeResult(input1, input2) != ItemStack.field_190927_a) {
            return;
        }
        this.blackMarketTradeList.put((Object)input1, (Object)input2, (Object)result);
    }

    public ItemStack getBlackMarketTradeResult(ItemStack input1, ItemStack input2) {
        for (Map.Entry entry : this.blackMarketTradeList.columnMap().entrySet()) {
            if (!this.compareItemStacks(input1, (ItemStack)entry.getKey())) continue;
            for (Map.Entry ent : ((Map)entry.getValue()).entrySet()) {
                if (!this.compareItemStacks(input2, (ItemStack)ent.getKey())) continue;
                return (ItemStack)ent.getValue();
            }
        }
        return ItemStack.field_190927_a;
    }

    private boolean compareItemStacks(ItemStack stack1, ItemStack stack2) {
        return stack1.func_77973_b() == stack2.func_77973_b() && stack1.func_77960_j() == stack2.func_77960_j();
    }

    public Table<ItemStack, ItemStack, ItemStack> getBlackMarketTradeList() {
        return this.blackMarketTradeList;
    }
}

