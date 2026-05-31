/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 */
package xol.lostinfinity.util.compatibility.jei.modulator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import xol.lostinfinity.init.ArmorInit;
import xol.lostinfinity.init.ItemInit;

public class ModulatorRecipeJEI {
    private static final ModulatorRecipeJEI INSTANCE = new ModulatorRecipeJEI();
    private final Map<List<ItemStack>, ItemStack> modulatorList = new HashMap<List<ItemStack>, ItemStack>();

    public ModulatorRecipeJEI() {
        ArrayList<ItemStack> vampHelmetInputs = new ArrayList<ItemStack>(Arrays.asList(new ItemStack(ItemInit.moduleRange), new ItemStack(ItemInit.modulePower), new ItemStack((Item)ArmorInit.vampyreonSet.helmet), new ItemStack(ItemInit.maliciumCondensed), new ItemStack(ItemInit.maliciumCondensed), new ItemStack(ItemInit.maliciumCondensed)));
        this.addModulatorRecipe(vampHelmetInputs, new ItemStack((Item)ArmorInit.vampyreonPrimeSet.helmet));
        ArrayList<ItemStack> vampLeggingsInputs = new ArrayList<ItemStack>(Arrays.asList(new ItemStack(ItemInit.moduleRange), new ItemStack(ItemInit.moduleRestoration), new ItemStack((Item)ArmorInit.vampyreonSet.leggings), new ItemStack(ItemInit.maliciumCondensed), new ItemStack(ItemInit.maliciumCondensed), new ItemStack(ItemInit.maliciumCondensed)));
        this.addModulatorRecipe(vampLeggingsInputs, new ItemStack((Item)ArmorInit.vampyreonPrimeSet.leggings));
        ArrayList<ItemStack> vampBootsInputs = new ArrayList<ItemStack>(Arrays.asList(new ItemStack(ItemInit.moduleRange), new ItemStack(ItemInit.moduleAcceleration), new ItemStack((Item)ArmorInit.vampyreonSet.boots), new ItemStack(ItemInit.maliciumCondensed), new ItemStack(ItemInit.maliciumCondensed), new ItemStack(ItemInit.maliciumCondensed)));
        this.addModulatorRecipe(vampBootsInputs, new ItemStack((Item)ArmorInit.vampyreonPrimeSet.boots));
        ArrayList<ItemStack> vampChestplateInputs = new ArrayList<ItemStack>(Arrays.asList(new ItemStack(ItemInit.moduleRange), new ItemStack(ItemInit.moduleConversion), new ItemStack((Item)ArmorInit.vampyreonSet.chestplate), new ItemStack(ItemInit.maliciumCondensed), new ItemStack(ItemInit.maliciumCondensed), new ItemStack(ItemInit.maliciumCondensed)));
        this.addModulatorRecipe(vampChestplateInputs, new ItemStack((Item)ArmorInit.vampyreonPrimeSet.chestplate));
        ArrayList<ItemStack> spectrosHelmetInputs = new ArrayList<ItemStack>(Arrays.asList(new ItemStack(ItemInit.moduleHexing), new ItemStack(ItemInit.moduleWeight), new ItemStack((Item)ArmorInit.spectrosSet.helmet), new ItemStack(ItemInit.etheriumCondensed), new ItemStack(ItemInit.etheriumCondensed), new ItemStack(ItemInit.etheriumCondensed)));
        this.addModulatorRecipe(spectrosHelmetInputs, new ItemStack((Item)ArmorInit.spectrosPrimeSet.helmet));
        ArrayList<ItemStack> spectrosLeggingsInputs = new ArrayList<ItemStack>(Arrays.asList(new ItemStack(ItemInit.moduleHexing), new ItemStack(ItemInit.moduleRestoration), new ItemStack((Item)ArmorInit.spectrosSet.leggings), new ItemStack(ItemInit.etheriumCondensed), new ItemStack(ItemInit.etheriumCondensed), new ItemStack(ItemInit.etheriumCondensed)));
        this.addModulatorRecipe(spectrosLeggingsInputs, new ItemStack((Item)ArmorInit.spectrosPrimeSet.leggings));
        ArrayList<ItemStack> spectrosBootsInputs = new ArrayList<ItemStack>(Arrays.asList(new ItemStack(ItemInit.moduleHexing), new ItemStack(ItemInit.moduleTransmitting), new ItemStack((Item)ArmorInit.spectrosSet.boots), new ItemStack(ItemInit.etheriumCondensed), new ItemStack(ItemInit.etheriumCondensed), new ItemStack(ItemInit.etheriumCondensed)));
        this.addModulatorRecipe(spectrosBootsInputs, new ItemStack((Item)ArmorInit.spectrosPrimeSet.boots));
        ArrayList<ItemStack> spectrosChestplateInputs = new ArrayList<ItemStack>(Arrays.asList(new ItemStack(ItemInit.moduleHexing), new ItemStack(ItemInit.moduleDurability), new ItemStack((Item)ArmorInit.spectrosSet.chestplate), new ItemStack(ItemInit.etheriumCondensed), new ItemStack(ItemInit.etheriumCondensed), new ItemStack(ItemInit.etheriumCondensed)));
        this.addModulatorRecipe(spectrosChestplateInputs, new ItemStack((Item)ArmorInit.spectrosPrimeSet.chestplate));
        ArrayList<ItemStack> vitralitonHelmetInputs = new ArrayList<ItemStack>(Arrays.asList(new ItemStack(ItemInit.moduleRestoration), new ItemStack(ItemInit.modulePower), new ItemStack((Item)ArmorInit.vitralitonSet.helmet), new ItemStack(ItemInit.polariumCondensed), new ItemStack(ItemInit.polariumCondensed), new ItemStack(ItemInit.polariumCondensed)));
        this.addModulatorRecipe(vitralitonHelmetInputs, new ItemStack((Item)ArmorInit.vitralitonPrimeSet.helmet));
        ArrayList<ItemStack> vitralitonLeggingsInputs = new ArrayList<ItemStack>(Arrays.asList(new ItemStack(ItemInit.moduleRestoration), new ItemStack(ItemInit.moduleDurability), new ItemStack((Item)ArmorInit.vitralitonSet.leggings), new ItemStack(ItemInit.polariumCondensed), new ItemStack(ItemInit.polariumCondensed), new ItemStack(ItemInit.polariumCondensed)));
        this.addModulatorRecipe(vitralitonLeggingsInputs, new ItemStack((Item)ArmorInit.vitralitonPrimeSet.leggings));
        ArrayList<ItemStack> vitralitonBootsInputs = new ArrayList<ItemStack>(Arrays.asList(new ItemStack(ItemInit.moduleRestoration), new ItemStack(ItemInit.moduleConversion), new ItemStack((Item)ArmorInit.vitralitonSet.boots), new ItemStack(ItemInit.polariumCondensed), new ItemStack(ItemInit.polariumCondensed), new ItemStack(ItemInit.polariumCondensed)));
        this.addModulatorRecipe(vitralitonBootsInputs, new ItemStack((Item)ArmorInit.vitralitonPrimeSet.boots));
        ArrayList<ItemStack> vitralitonChestplateInputs = new ArrayList<ItemStack>(Arrays.asList(new ItemStack(ItemInit.moduleRestoration), new ItemStack(ItemInit.moduleAcceleration), new ItemStack((Item)ArmorInit.vitralitonSet.chestplate), new ItemStack(ItemInit.polariumCondensed), new ItemStack(ItemInit.polariumCondensed), new ItemStack(ItemInit.polariumCondensed)));
        this.addModulatorRecipe(vitralitonChestplateInputs, new ItemStack((Item)ArmorInit.vitralitonPrimeSet.chestplate));
        ArrayList<ItemStack> blightcystHelmetInputs = new ArrayList<ItemStack>(Arrays.asList(new ItemStack(ItemInit.moduleBiocalibration), new ItemStack(ItemInit.modulePower), new ItemStack((Item)ArmorInit.blightcystSet.helmet), new ItemStack(ItemInit.kyvoriumCondensed), new ItemStack(ItemInit.kyvoriumCondensed), new ItemStack(ItemInit.kyvoriumCondensed)));
        this.addModulatorRecipe(blightcystHelmetInputs, new ItemStack((Item)ArmorInit.blightcystPrimeSet.helmet));
        ArrayList<ItemStack> blightcystLeggingsInputs = new ArrayList<ItemStack>(Arrays.asList(new ItemStack(ItemInit.moduleBiocalibration), new ItemStack(ItemInit.moduleDurability), new ItemStack((Item)ArmorInit.blightcystSet.leggings), new ItemStack(ItemInit.kyvoriumCondensed), new ItemStack(ItemInit.kyvoriumCondensed), new ItemStack(ItemInit.kyvoriumCondensed)));
        this.addModulatorRecipe(blightcystLeggingsInputs, new ItemStack((Item)ArmorInit.blightcystPrimeSet.leggings));
        ArrayList<ItemStack> blightcystBootsInputs = new ArrayList<ItemStack>(Arrays.asList(new ItemStack(ItemInit.moduleBiocalibration), new ItemStack(ItemInit.moduleTransmitting), new ItemStack((Item)ArmorInit.blightcystSet.boots), new ItemStack(ItemInit.kyvoriumCondensed), new ItemStack(ItemInit.kyvoriumCondensed), new ItemStack(ItemInit.kyvoriumCondensed)));
        this.addModulatorRecipe(blightcystBootsInputs, new ItemStack((Item)ArmorInit.blightcystPrimeSet.boots));
        ArrayList<ItemStack> blightcystChestplateInputs = new ArrayList<ItemStack>(Arrays.asList(new ItemStack(ItemInit.moduleBiocalibration), new ItemStack(ItemInit.moduleConversion), new ItemStack((Item)ArmorInit.blightcystSet.chestplate), new ItemStack(ItemInit.kyvoriumCondensed), new ItemStack(ItemInit.kyvoriumCondensed), new ItemStack(ItemInit.kyvoriumCondensed)));
        this.addModulatorRecipe(blightcystChestplateInputs, new ItemStack((Item)ArmorInit.blightcystPrimeSet.chestplate));
    }

    public static ModulatorRecipeJEI getInstance() {
        return INSTANCE;
    }

    public void addModulatorRecipe(List<ItemStack> inputs, ItemStack result) {
        if (this.getModulatorResult(inputs) != ItemStack.field_190927_a) {
            return;
        }
        this.modulatorList.put(inputs, result);
    }

    public ItemStack getModulatorResult(List<ItemStack> inputs) {
        for (Map.Entry<List<ItemStack>, ItemStack> entry : this.modulatorList.entrySet()) {
            if (!Objects.equals(inputs, entry.getKey())) continue;
            return entry.getValue();
        }
        return ItemStack.field_190927_a;
    }

    public Map<List<ItemStack>, ItemStack> getModulatorList() {
        return this.modulatorList;
    }
}

