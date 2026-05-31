/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.ItemStack
 */
package xol.lostinfinity.util.compatibility.jei.compressiontable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import net.minecraft.world.item.ItemStack;
import xol.lostinfinity.init.ItemInit;

public class CompressionTableRecipeJEI {
    private static final CompressionTableRecipeJEI INSTANCE = new CompressionTableRecipeJEI();
    private final Map<ItemStack, ItemStack> compressionList = new HashMap<ItemStack, ItemStack>();

    public CompressionTableRecipeJEI() {
        ItemStack astrallium = new ItemStack(ItemInit.astralliumIngot);
        astrallium.func_190920_e(25);
        this.addCompressionTableRecipe(astrallium, new ItemStack(ItemInit.astralliumCondensed));
        ItemStack crystonium = new ItemStack(ItemInit.crystoniumIngot);
        crystonium.func_190920_e(25);
        this.addCompressionTableRecipe(crystonium, new ItemStack(ItemInit.crystoniumCondensed));
        ItemStack detherium = new ItemStack(ItemInit.detheriumIngot);
        detherium.func_190920_e(25);
        this.addCompressionTableRecipe(detherium, new ItemStack(ItemInit.detheriumCondensed));
        ItemStack emberium = new ItemStack(ItemInit.emberiumIngot);
        emberium.func_190920_e(25);
        this.addCompressionTableRecipe(emberium, new ItemStack(ItemInit.emberiumCondensed));
        ItemStack hextorium = new ItemStack(ItemInit.hextoriumIngot);
        hextorium.func_190920_e(25);
        this.addCompressionTableRecipe(hextorium, new ItemStack(ItemInit.hextoriumCondensed));
        ItemStack incadium = new ItemStack(ItemInit.incadiumIngot);
        incadium.func_190920_e(25);
        this.addCompressionTableRecipe(incadium, new ItemStack(ItemInit.incadiumCondensed));
        ItemStack kylaxium = new ItemStack(ItemInit.kylaxiumIngot);
        kylaxium.func_190920_e(25);
        this.addCompressionTableRecipe(kylaxium, new ItemStack(ItemInit.kylaxiumCondensed));
        ItemStack noxerium = new ItemStack(ItemInit.noxeriumIngot);
        noxerium.func_190920_e(25);
        this.addCompressionTableRecipe(noxerium, new ItemStack(ItemInit.noxeriumCondensed));
        ItemStack olysium = new ItemStack(ItemInit.olysiumIngot);
        olysium.func_190920_e(25);
        this.addCompressionTableRecipe(olysium, new ItemStack(ItemInit.olysiumCondensed));
        ItemStack vellorium = new ItemStack(ItemInit.velloriumIngot);
        vellorium.func_190920_e(25);
        this.addCompressionTableRecipe(vellorium, new ItemStack(ItemInit.velloriumCondensed));
        ItemStack xerovium = new ItemStack(ItemInit.xeroviumIngot);
        xerovium.func_190920_e(25);
        this.addCompressionTableRecipe(xerovium, new ItemStack(ItemInit.xeroviumCondensed));
        ItemStack phytrosium = new ItemStack(ItemInit.phytrosiumIngot);
        phytrosium.func_190920_e(25);
        this.addCompressionTableRecipe(phytrosium, new ItemStack(ItemInit.phytrosiumCondensed));
        ItemStack kyvorium = new ItemStack(ItemInit.kyvoriumIngot);
        kyvorium.func_190920_e(25);
        this.addCompressionTableRecipe(kyvorium, new ItemStack(ItemInit.kyvoriumCondensed));
        ItemStack biosynthium = new ItemStack(ItemInit.biosynthiumIngot);
        biosynthium.func_190920_e(25);
        this.addCompressionTableRecipe(biosynthium, new ItemStack(ItemInit.biosynthiumCondensed));
        ItemStack malicium = new ItemStack(ItemInit.maliciumIngot);
        malicium.func_190920_e(25);
        this.addCompressionTableRecipe(malicium, new ItemStack(ItemInit.maliciumCondensed));
        ItemStack etherium = new ItemStack(ItemInit.etheriumIngot);
        etherium.func_190920_e(25);
        this.addCompressionTableRecipe(etherium, new ItemStack(ItemInit.etheriumCondensed));
        ItemStack polarium = new ItemStack(ItemInit.polariumIngot);
        polarium.func_190920_e(25);
        this.addCompressionTableRecipe(polarium, new ItemStack(ItemInit.polariumCondensed));
    }

    public static CompressionTableRecipeJEI getInstance() {
        return INSTANCE;
    }

    public void addCompressionTableRecipe(ItemStack input, ItemStack result) {
        if (this.getCompressionTableResult(input) != ItemStack.field_190927_a) {
            return;
        }
        this.compressionList.put(input, result);
    }

    public ItemStack getCompressionTableResult(ItemStack input) {
        for (Map.Entry<ItemStack, ItemStack> entry : this.compressionList.entrySet()) {
            if (!Objects.equals(input, entry.getKey())) continue;
            return entry.getValue();
        }
        return ItemStack.field_190927_a;
    }

    public Map<ItemStack, ItemStack> getCompressionTableList() {
        return this.compressionList;
    }
}

