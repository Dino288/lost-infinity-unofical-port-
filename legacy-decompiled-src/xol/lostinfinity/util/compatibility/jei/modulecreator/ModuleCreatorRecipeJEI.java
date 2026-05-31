/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.ItemStack
 */
package xol.lostinfinity.util.compatibility.jei.modulecreator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import net.minecraft.world.item.ItemStack;
import xol.lostinfinity.init.ItemInit;

public class ModuleCreatorRecipeJEI {
    private static final ModuleCreatorRecipeJEI INSTANCE = new ModuleCreatorRecipeJEI();
    private final Map<List<ItemStack>, ItemStack> moduleCreatorList = new HashMap<List<ItemStack>, ItemStack>();

    public ModuleCreatorRecipeJEI() {
        ItemStack moduleEmpty = new ItemStack(ItemInit.moduleContainer);
        ArrayList<ItemStack> acceleration = new ArrayList<ItemStack>(Arrays.asList(new ItemStack(ItemInit.supermutatedBatwing), new ItemStack(ItemInit.supermutatedWing), new ItemStack(ItemInit.superStimulant), moduleEmpty));
        this.addModuleCreatorRecipe(acceleration, new ItemStack(ItemInit.moduleAcceleration));
        ArrayList<ItemStack> power = new ArrayList<ItemStack>(Arrays.asList(new ItemStack(ItemInit.powerControlDisc), new ItemStack(ItemInit.overchargedCell), new ItemStack(ItemInit.powerClamp), moduleEmpty));
        this.addModuleCreatorRecipe(power, new ItemStack(ItemInit.modulePower));
        ArrayList<ItemStack> restoration = new ArrayList<ItemStack>(Arrays.asList(new ItemStack(ItemInit.lifeboundEmerald), new ItemStack(ItemInit.jarOfSyrup), new ItemStack(ItemInit.lifestrainEnigma), moduleEmpty));
        this.addModuleCreatorRecipe(restoration, new ItemStack(ItemInit.moduleRestoration));
        ArrayList<ItemStack> range = new ArrayList<ItemStack>(Arrays.asList(new ItemStack(ItemInit.advancedSignalReceiver), new ItemStack(ItemInit.geocoordinatedOrb), new ItemStack(ItemInit.nanofluoricAcid), moduleEmpty));
        this.addModuleCreatorRecipe(range, new ItemStack(ItemInit.moduleRange));
        ArrayList<ItemStack> conversion = new ArrayList<ItemStack>(Arrays.asList(new ItemStack(ItemInit.atomicCell), new ItemStack(ItemInit.fracturedMultiversite), new ItemStack(ItemInit.volatileGloop), moduleEmpty));
        this.addModuleCreatorRecipe(conversion, new ItemStack(ItemInit.moduleConversion));
        ArrayList<ItemStack> durability = new ArrayList<ItemStack>(Arrays.asList(new ItemStack(ItemInit.durableHusk), new ItemStack(ItemInit.crystallizedAlloy), new ItemStack(ItemInit.supermutatedPelt), moduleEmpty));
        this.addModuleCreatorRecipe(durability, new ItemStack(ItemInit.moduleDurability));
        ArrayList<ItemStack> hexing = new ArrayList<ItemStack>(Arrays.asList(new ItemStack(ItemInit.crystalOfCurses), new ItemStack(ItemInit.ghostlyHusk), new ItemStack(ItemInit.cursedEmerald), moduleEmpty));
        this.addModuleCreatorRecipe(hexing, new ItemStack(ItemInit.moduleHexing));
        ArrayList<ItemStack> weight = new ArrayList<ItemStack>(Arrays.asList(new ItemStack(ItemInit.ultralightDust), new ItemStack(ItemInit.weightlessGem), new ItemStack(ItemInit.gravityCore), moduleEmpty));
        this.addModuleCreatorRecipe(weight, new ItemStack(ItemInit.moduleWeight));
        ArrayList<ItemStack> transmitting = new ArrayList<ItemStack>(Arrays.asList(new ItemStack(ItemInit.murkyClay), new ItemStack(ItemInit.reconfiguredMatter), new ItemStack(ItemInit.advancedSignalReceiver), moduleEmpty));
        this.addModuleCreatorRecipe(transmitting, new ItemStack(ItemInit.moduleTransmitting));
        ArrayList<ItemStack> biocalibration = new ArrayList<ItemStack>(Arrays.asList(new ItemStack(ItemInit.astralOrgan), new ItemStack(ItemInit.organicShadowMatter), new ItemStack(ItemInit.biosyncedClock), moduleEmpty));
        this.addModuleCreatorRecipe(biocalibration, new ItemStack(ItemInit.moduleBiocalibration));
    }

    public static ModuleCreatorRecipeJEI getInstance() {
        return INSTANCE;
    }

    public void addModuleCreatorRecipe(List<ItemStack> inputs, ItemStack result) {
        if (this.getModuleCreatorResult(inputs) != ItemStack.field_190927_a) {
            return;
        }
        this.moduleCreatorList.put(inputs, result);
    }

    public ItemStack getModuleCreatorResult(List<ItemStack> inputs) {
        for (Map.Entry<List<ItemStack>, ItemStack> entry : this.moduleCreatorList.entrySet()) {
            if (!Objects.equals(inputs, entry.getKey())) continue;
            return entry.getValue();
        }
        return ItemStack.field_190927_a;
    }

    public Map<List<ItemStack>, ItemStack> getModuleCreatorList() {
        return this.moduleCreatorList;
    }
}

