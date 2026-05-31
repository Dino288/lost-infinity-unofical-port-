/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.ItemStack
 */
package xol.lostinfinity.recipes;

import java.util.ArrayList;
import net.minecraft.world.item.ItemStack;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.recipes.Recipe;

public class ModuleCreatorRecipes {
    private static ArrayList<Recipe> recipes = new ArrayList();

    private static void init() {
        Recipe acceleration = new Recipe(ItemInit.moduleAcceleration, new ItemStack(ItemInit.supermutatedBatwing), new ItemStack(ItemInit.supermutatedWing), new ItemStack(ItemInit.superStimulant));
        Recipe power = new Recipe(ItemInit.modulePower, new ItemStack(ItemInit.powerControlDisc), new ItemStack(ItemInit.overchargedCell), new ItemStack(ItemInit.powerClamp));
        Recipe restoration = new Recipe(ItemInit.moduleRestoration, new ItemStack(ItemInit.lifeboundEmerald), new ItemStack(ItemInit.jarOfSyrup), new ItemStack(ItemInit.lifestrainEnigma));
        Recipe range = new Recipe(ItemInit.moduleRange, new ItemStack(ItemInit.advancedSignalReceiver), new ItemStack(ItemInit.geocoordinatedOrb), new ItemStack(ItemInit.nanofluoricAcid));
        Recipe conversion = new Recipe(ItemInit.moduleConversion, new ItemStack(ItemInit.atomicCell), new ItemStack(ItemInit.fracturedMultiversite), new ItemStack(ItemInit.volatileGloop));
        Recipe durability = new Recipe(ItemInit.moduleDurability, new ItemStack(ItemInit.durableHusk), new ItemStack(ItemInit.crystallizedAlloy), new ItemStack(ItemInit.supermutatedPelt));
        Recipe hexing = new Recipe(ItemInit.moduleHexing, new ItemStack(ItemInit.crystalOfCurses), new ItemStack(ItemInit.ghostlyHusk), new ItemStack(ItemInit.cursedEmerald));
        Recipe weight = new Recipe(ItemInit.moduleWeight, new ItemStack(ItemInit.ultralightDust), new ItemStack(ItemInit.weightlessGem), new ItemStack(ItemInit.gravityCore));
        Recipe transmitting = new Recipe(ItemInit.moduleTransmitting, new ItemStack(ItemInit.murkyClay), new ItemStack(ItemInit.reconfiguredMatter), new ItemStack(ItemInit.advancedSignalReceiver));
        Recipe biocalibration = new Recipe(ItemInit.moduleBiocalibration, new ItemStack(ItemInit.astralOrgan), new ItemStack(ItemInit.organicShadowMatter), new ItemStack(ItemInit.biosyncedClock));
        recipes.add(acceleration);
        recipes.add(power);
        recipes.add(range);
        recipes.add(restoration);
        recipes.add(conversion);
        recipes.add(durability);
        recipes.add(hexing);
        recipes.add(weight);
        recipes.add(transmitting);
        recipes.add(biocalibration);
    }

    public static ItemStack getResult(ItemStack ... inputs) {
        if (recipes.isEmpty()) {
            ModuleCreatorRecipes.init();
        }
        for (int i = 0; i < recipes.size(); ++i) {
            Recipe recipe = recipes.get(i);
            if (inputs.length != 3) continue;
            ArrayList<ItemStack> foundInputs = new ArrayList<ItemStack>();
            ArrayList<ItemStack> neededInputs = new ArrayList<ItemStack>();
            neededInputs.add(recipe.values[0]);
            neededInputs.add(recipe.values[1]);
            neededInputs.add(recipe.values[2]);
            for (int k = 0; k < 3; ++k) {
                for (ItemStack stack : neededInputs) {
                    if (!stack.func_77969_a(inputs[k])) continue;
                    foundInputs.add(stack);
                }
            }
            if (!foundInputs.containsAll(neededInputs)) continue;
            return new ItemStack(recipe.result);
        }
        return null;
    }
}

