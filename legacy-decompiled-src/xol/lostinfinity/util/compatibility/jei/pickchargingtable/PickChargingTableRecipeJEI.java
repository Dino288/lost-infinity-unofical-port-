/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.HashBasedTable
 *  com.google.common.collect.Table
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
 */
package xol.lostinfinity.util.compatibility.jei.pickchargingtable;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import java.util.Map;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import xol.lostinfinity.init.ItemInit;

public class PickChargingTableRecipeJEI {
    private static final PickChargingTableRecipeJEI INSTANCE = new PickChargingTableRecipeJEI();
    private final Table<ItemStack, ItemStack, ItemStack> pickChargingTableList = HashBasedTable.create();

    public PickChargingTableRecipeJEI() {
        ItemStack pickDefault = new ItemStack(ItemInit.forgeFirePickaxe);
        ItemStack pickEmberium = new ItemStack(ItemInit.forgeFirePickaxe);
        pickEmberium.func_77982_d(new CompoundTag());
        pickEmberium.func_77978_p().func_74768_a("emberium", 250);
        ItemStack reactiveEmberium = new ItemStack(ItemInit.reactiveCrystalEmberium);
        reactiveEmberium.func_190920_e(10);
        this.addPickChargingTableRecipe(reactiveEmberium, pickDefault, pickEmberium);
        ItemStack pickHextorium = new ItemStack(ItemInit.forgeFirePickaxe);
        pickHextorium.func_77982_d(new CompoundTag());
        pickHextorium.func_77978_p().func_74768_a("hextorium", 250);
        ItemStack reactiveHextorium = new ItemStack(ItemInit.reactiveCrystalHextorium);
        reactiveHextorium.func_190920_e(10);
        this.addPickChargingTableRecipe(reactiveHextorium, pickDefault, pickHextorium);
        ItemStack pickCrystonium = new ItemStack(ItemInit.forgeFirePickaxe);
        pickCrystonium.func_77982_d(new CompoundTag());
        pickCrystonium.func_77978_p().func_74768_a("crystonium", 250);
        ItemStack reactiveCrystonium = new ItemStack(ItemInit.reactiveCrystalCrystonium);
        reactiveCrystonium.func_190920_e(10);
        this.addPickChargingTableRecipe(reactiveCrystonium, pickDefault, pickCrystonium);
        ItemStack pickAstrallium = new ItemStack(ItemInit.forgeFirePickaxe);
        pickAstrallium.func_77982_d(new CompoundTag());
        pickAstrallium.func_77978_p().func_74768_a("astrallium", 250);
        ItemStack reactiveAstrallium = new ItemStack(ItemInit.reactiveCrystalAstrallium);
        reactiveAstrallium.func_190920_e(10);
        this.addPickChargingTableRecipe(reactiveAstrallium, pickDefault, pickAstrallium);
        ItemStack pickKylaxium = new ItemStack(ItemInit.forgeFirePickaxe);
        pickKylaxium.func_77982_d(new CompoundTag());
        pickKylaxium.func_77978_p().func_74768_a("kylaxium", 250);
        ItemStack reactiveKylaxium = new ItemStack(ItemInit.reactiveCrystalKylaxium);
        reactiveKylaxium.func_190920_e(10);
        this.addPickChargingTableRecipe(reactiveKylaxium, pickDefault, pickKylaxium);
        ItemStack pickVellorium = new ItemStack(ItemInit.forgeFirePickaxe);
        pickVellorium.func_77982_d(new CompoundTag());
        pickVellorium.func_77978_p().func_74768_a("vellorium", 250);
        ItemStack reactiveVellorium = new ItemStack(ItemInit.reactiveCrystalVellorium);
        reactiveVellorium.func_190920_e(10);
        this.addPickChargingTableRecipe(reactiveVellorium, pickDefault, pickVellorium);
        ItemStack pickIncadium = new ItemStack(ItemInit.forgeFirePickaxe);
        pickIncadium.func_77982_d(new CompoundTag());
        pickIncadium.func_77978_p().func_74768_a("incadium", 250);
        ItemStack reactiveIncadium = new ItemStack(ItemInit.reactiveCrystalIncadium);
        reactiveIncadium.func_190920_e(10);
        this.addPickChargingTableRecipe(reactiveIncadium, pickDefault, pickIncadium);
        ItemStack pickNoxerium = new ItemStack(ItemInit.forgeFirePickaxe);
        pickNoxerium.func_77982_d(new CompoundTag());
        pickNoxerium.func_77978_p().func_74768_a("noxerium", 250);
        ItemStack reactiveNoxerium = new ItemStack(ItemInit.reactiveCrystalNoxerium);
        reactiveNoxerium.func_190920_e(10);
        this.addPickChargingTableRecipe(reactiveNoxerium, pickDefault, pickNoxerium);
        ItemStack pickOlysium = new ItemStack(ItemInit.forgeFirePickaxe);
        pickOlysium.func_77982_d(new CompoundTag());
        pickOlysium.func_77978_p().func_74768_a("olysium", 250);
        ItemStack reactiveOlysium = new ItemStack(ItemInit.reactiveCrystalOlysium);
        reactiveOlysium.func_190920_e(10);
        this.addPickChargingTableRecipe(reactiveOlysium, pickDefault, pickOlysium);
        ItemStack pickDetherium = new ItemStack(ItemInit.forgeFirePickaxe);
        pickDetherium.func_77982_d(new CompoundTag());
        pickDetherium.func_77978_p().func_74768_a("detherium", 250);
        ItemStack reactiveDetherium = new ItemStack(ItemInit.reactiveCrystalDetherium);
        reactiveDetherium.func_190920_e(10);
        this.addPickChargingTableRecipe(reactiveDetherium, pickDefault, pickDetherium);
        ItemStack pickPhytrosium = new ItemStack(ItemInit.forgeFirePickaxe);
        pickPhytrosium.func_77982_d(new CompoundTag());
        pickPhytrosium.func_77978_p().func_74768_a("phytrosium", 250);
        ItemStack reactivePhytrosium = new ItemStack(ItemInit.reactiveCrystalPhytrosium);
        reactivePhytrosium.func_190920_e(10);
        this.addPickChargingTableRecipe(reactivePhytrosium, pickDefault, pickPhytrosium);
        ItemStack pickXerovium = new ItemStack(ItemInit.forgeFirePickaxe);
        pickXerovium.func_77982_d(new CompoundTag());
        pickXerovium.func_77978_p().func_74768_a("xerovium", 250);
        ItemStack reactiveXerovium = new ItemStack(ItemInit.reactiveCrystalXerovium);
        reactiveXerovium.func_190920_e(10);
        this.addPickChargingTableRecipe(reactiveXerovium, pickDefault, pickXerovium);
    }

    public static PickChargingTableRecipeJEI getInstance() {
        return INSTANCE;
    }

    public void addPickChargingTableRecipe(ItemStack input1, ItemStack input2, ItemStack result) {
        if (this.getPickChargingTableResult(input1, input2) != ItemStack.field_190927_a) {
            return;
        }
        this.pickChargingTableList.put((Object)input1, (Object)input2, (Object)result);
    }

    public ItemStack getPickChargingTableResult(ItemStack input1, ItemStack input2) {
        for (Map.Entry entry : this.pickChargingTableList.columnMap().entrySet()) {
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

    public Table<ItemStack, ItemStack, ItemStack> getPickChargingTableList() {
        return this.pickChargingTableList;
    }
}

