/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.ItemStack
 */
package xol.lostinfinity.util.compatibility.jei.mysterybox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import net.minecraft.world.item.ItemStack;
import xol.lostinfinity.init.ItemInit;

public class MysteryBoxRecipeJEI {
    private static final MysteryBoxRecipeJEI INSTANCE = new MysteryBoxRecipeJEI();
    private final Map<ItemStack, List<ItemStack>> mysteryBoxList = new HashMap<ItemStack, List<ItemStack>>();
    protected final List<ItemStack> emptyList = Collections.emptyList();

    public MysteryBoxRecipeJEI() {
        this.addMysteryBoxRecipe(new ItemStack(ItemInit.mysteryBox), new ArrayList<ItemStack>(Arrays.asList(new ItemStack(ItemInit.zirconiaAubergine), new ItemStack(ItemInit.zirconiaCeladon), new ItemStack(ItemInit.zirconiaCerulean), new ItemStack(ItemInit.zirconiaCitrine), new ItemStack(ItemInit.zirconiaCrimson), new ItemStack(ItemInit.zirconiaIvory), new ItemStack(ItemInit.zirconiaMalachite), new ItemStack(ItemInit.zirconiaMidnight), new ItemStack(ItemInit.zirconiaMusky), new ItemStack(ItemInit.zirconiaMythic), new ItemStack(ItemInit.zirconiaOyster), new ItemStack(ItemInit.zirconiaRosewood))));
    }

    public static MysteryBoxRecipeJEI getInstance() {
        return INSTANCE;
    }

    public void addMysteryBoxRecipe(ItemStack input, List<ItemStack> results) {
        if (this.getMysteryBoxResult(input) != this.emptyList) {
            return;
        }
        this.mysteryBoxList.put(input, results);
    }

    public List<ItemStack> getMysteryBoxResult(ItemStack input) {
        for (Map.Entry<ItemStack, List<ItemStack>> entry : this.mysteryBoxList.entrySet()) {
            if (!Objects.equals(input, entry.getKey())) continue;
            return entry.getValue();
        }
        return this.emptyList;
    }

    public Map<ItemStack, List<ItemStack>> getMysteryBoxList() {
        return this.mysteryBoxList;
    }
}

