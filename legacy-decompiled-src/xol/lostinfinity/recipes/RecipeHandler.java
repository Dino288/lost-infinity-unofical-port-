/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 */
package xol.lostinfinity.recipes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Optional;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import xol.lostinfinity.init.ArmorInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.recipes.Recipe;

public class RecipeHandler {
    private static HashMap<Item, Recipe> recipes = new HashMap();

    private static void init() {
        ItemStack emb = new ItemStack(ItemInit.emberiumCondensed);
        ItemStack inc = new ItemStack(ItemInit.incadiumCondensed);
        ItemStack nox = new ItemStack(ItemInit.noxeriumCondensed);
        ItemStack kyl = new ItemStack(ItemInit.kylaxiumCondensed);
        ItemStack phy = new ItemStack(ItemInit.phytrosiumCondensed);
        ItemStack cry = new ItemStack(ItemInit.crystoniumCondensed);
        ItemStack det = new ItemStack(ItemInit.detheriumCondensed);
        ItemStack oly = new ItemStack(ItemInit.olysiumCondensed);
        ItemStack xer = new ItemStack(ItemInit.xeroviumCondensed);
        ItemStack ast = new ItemStack(ItemInit.astralliumCondensed);
        ItemStack vel = new ItemStack(ItemInit.velloriumCondensed);
        ItemStack hex = new ItemStack(ItemInit.hextoriumCondensed);
        ItemStack bio = new ItemStack(ItemInit.biosynthiumCondensed);
        Arrays.stream(new Recipe[]{new Recipe((Item)ArmorInit.vampyreonSet.helmet, inc, inc, emb, ItemStack.field_190927_a, emb, ItemStack.field_190927_a, ItemStack.field_190927_a), new Recipe((Item)ArmorInit.vampyreonSet.chestplate, inc, inc, emb, nox, emb, emb, emb), new Recipe((Item)ArmorInit.vampyreonSet.leggings, emb, emb, emb, ItemStack.field_190927_a, emb, emb, emb), new Recipe((Item)ArmorInit.vampyreonSet.boots, ItemStack.field_190927_a, ItemStack.field_190927_a, emb, ItemStack.field_190927_a, emb, nox, nox), new Recipe((Item)ArmorInit.plasmythicSet.helmet, cry, cry, kyl, ItemStack.field_190927_a, kyl, ItemStack.field_190927_a, ItemStack.field_190927_a), new Recipe((Item)ArmorInit.plasmythicSet.chestplate, cry, cry, kyl, phy, kyl, kyl, kyl), new Recipe((Item)ArmorInit.plasmythicSet.leggings, kyl, kyl, cry, ItemStack.field_190927_a, cry, kyl, kyl), new Recipe((Item)ArmorInit.plasmythicSet.boots, ItemStack.field_190927_a, ItemStack.field_190927_a, kyl, ItemStack.field_190927_a, kyl, phy, phy), new Recipe((Item)ArmorInit.spectrosSet.helmet, oly, oly, det, ItemStack.field_190927_a, det, ItemStack.field_190927_a, ItemStack.field_190927_a), new Recipe((Item)ArmorInit.spectrosSet.chestplate, oly, oly, det, xer, det, det, det), new Recipe((Item)ArmorInit.spectrosSet.leggings, det, det, det, ItemStack.field_190927_a, det, det, det), new Recipe((Item)ArmorInit.spectrosSet.boots, ItemStack.field_190927_a, ItemStack.field_190927_a, det, ItemStack.field_190927_a, det, xer, xer), new Recipe((Item)ArmorInit.vitralitonSet.helmet, phy, phy, xer, ItemStack.field_190927_a, xer, ItemStack.field_190927_a, ItemStack.field_190927_a), new Recipe((Item)ArmorInit.vitralitonSet.chestplate, xer, xer, phy, hex, phy, xer, xer), new Recipe((Item)ArmorInit.vitralitonSet.leggings, xer, xer, hex, ItemStack.field_190927_a, hex, xer, xer), new Recipe((Item)ArmorInit.vitralitonSet.boots, ItemStack.field_190927_a, ItemStack.field_190927_a, phy, ItemStack.field_190927_a, phy, xer, xer), new Recipe((Item)ArmorInit.blightcystSet.helmet, vel, vel, kyl, ItemStack.field_190927_a, kyl, ItemStack.field_190927_a, ItemStack.field_190927_a), new Recipe((Item)ArmorInit.blightcystSet.chestplate, vel, vel, vel, kyl, vel, hex, hex), new Recipe((Item)ArmorInit.blightcystSet.leggings, vel, vel, hex, ItemStack.field_190927_a, vel, vel, vel), new Recipe((Item)ArmorInit.blightcystSet.boots, ItemStack.field_190927_a, ItemStack.field_190927_a, hex, ItemStack.field_190927_a, hex, vel, vel), new Recipe((Item)ArmorInit.bionicveggitronSet.helmet, bio, bio, bio, ItemStack.field_190927_a, bio, ItemStack.field_190927_a, ItemStack.field_190927_a), new Recipe((Item)ArmorInit.bionicveggitronSet.chestplate, bio, bio, bio, bio, bio, bio, bio), new Recipe((Item)ArmorInit.bionicveggitronSet.leggings, bio, bio, bio, ItemStack.field_190927_a, bio, bio, bio), new Recipe((Item)ArmorInit.bionicveggitronSet.boots, ItemStack.field_190927_a, ItemStack.field_190927_a, bio, ItemStack.field_190927_a, bio, bio, bio), new Recipe((Item)ArmorInit.graviteriumSet.helmet, det, det, ast, ItemStack.field_190927_a, ast, ItemStack.field_190927_a, ItemStack.field_190927_a), new Recipe((Item)ArmorInit.graviteriumSet.chestplate, det, det, ast, emb, ast, ast, ast), new Recipe((Item)ArmorInit.graviteriumSet.leggings, ast, ast, det, ItemStack.field_190927_a, det, ast, ast), new Recipe((Item)ArmorInit.graviteriumSet.boots, ItemStack.field_190927_a, ItemStack.field_190927_a, ast, ItemStack.field_190927_a, ast, emb, emb)}).forEach(recipe -> recipes.put(recipe.result, (Recipe)recipe));
    }

    public static Optional<Recipe> getRecipeFor(ItemStack ... items) {
        if (recipes.isEmpty()) {
            RecipeHandler.init();
        }
        return recipes.values().stream().filter(it -> it.recipeMatches(items)).findFirst();
    }
}

