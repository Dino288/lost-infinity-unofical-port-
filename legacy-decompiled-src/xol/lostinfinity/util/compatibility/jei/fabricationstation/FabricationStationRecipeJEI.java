/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 */
package xol.lostinfinity.util.compatibility.jei.fabricationstation;

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

public class FabricationStationRecipeJEI {
    private static final FabricationStationRecipeJEI INSTANCE = new FabricationStationRecipeJEI();
    private final Map<List<ItemStack>, ItemStack> fabricationStationList = new HashMap<List<ItemStack>, ItemStack>();

    public FabricationStationRecipeJEI() {
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
        ArrayList<ItemStack> vampH = new ArrayList<ItemStack>(Arrays.asList(inc, inc, emb, ItemStack.field_190927_a, emb, ItemStack.field_190927_a, ItemStack.field_190927_a));
        this.addFabricationStationRecipe(vampH, new ItemStack((Item)ArmorInit.vampyreonSet.helmet));
        ArrayList<ItemStack> vampC = new ArrayList<ItemStack>(Arrays.asList(inc, inc, emb, nox, emb, emb, emb));
        this.addFabricationStationRecipe(vampC, new ItemStack((Item)ArmorInit.vampyreonSet.chestplate));
        ArrayList<ItemStack> vampL = new ArrayList<ItemStack>(Arrays.asList(emb, emb, emb, ItemStack.field_190927_a, emb, emb, emb));
        this.addFabricationStationRecipe(vampL, new ItemStack((Item)ArmorInit.vampyreonSet.leggings));
        ArrayList<ItemStack> vampB = new ArrayList<ItemStack>(Arrays.asList(ItemStack.field_190927_a, ItemStack.field_190927_a, emb, ItemStack.field_190927_a, emb, nox, nox));
        this.addFabricationStationRecipe(vampB, new ItemStack((Item)ArmorInit.vampyreonSet.boots));
        ArrayList<ItemStack> plasH = new ArrayList<ItemStack>(Arrays.asList(cry, cry, kyl, ItemStack.field_190927_a, kyl, ItemStack.field_190927_a, ItemStack.field_190927_a));
        this.addFabricationStationRecipe(plasH, new ItemStack((Item)ArmorInit.plasmythicSet.helmet));
        ArrayList<ItemStack> plasC = new ArrayList<ItemStack>(Arrays.asList(cry, cry, kyl, phy, kyl, kyl, kyl));
        this.addFabricationStationRecipe(plasC, new ItemStack((Item)ArmorInit.plasmythicSet.chestplate));
        ArrayList<ItemStack> plasL = new ArrayList<ItemStack>(Arrays.asList(kyl, kyl, cry, ItemStack.field_190927_a, cry, kyl, kyl));
        this.addFabricationStationRecipe(plasL, new ItemStack((Item)ArmorInit.plasmythicSet.leggings));
        ArrayList<ItemStack> plasB = new ArrayList<ItemStack>(Arrays.asList(ItemStack.field_190927_a, ItemStack.field_190927_a, kyl, ItemStack.field_190927_a, kyl, phy, phy));
        this.addFabricationStationRecipe(plasB, new ItemStack((Item)ArmorInit.plasmythicSet.boots));
        ArrayList<ItemStack> specH = new ArrayList<ItemStack>(Arrays.asList(oly, oly, det, ItemStack.field_190927_a, det, ItemStack.field_190927_a, ItemStack.field_190927_a));
        this.addFabricationStationRecipe(specH, new ItemStack((Item)ArmorInit.spectrosSet.helmet));
        ArrayList<ItemStack> specC = new ArrayList<ItemStack>(Arrays.asList(oly, oly, det, xer, det, det, det));
        this.addFabricationStationRecipe(specC, new ItemStack((Item)ArmorInit.spectrosSet.chestplate));
        ArrayList<ItemStack> specL = new ArrayList<ItemStack>(Arrays.asList(det, det, det, ItemStack.field_190927_a, det, det, det));
        this.addFabricationStationRecipe(specL, new ItemStack((Item)ArmorInit.spectrosSet.leggings));
        ArrayList<ItemStack> specB = new ArrayList<ItemStack>(Arrays.asList(ItemStack.field_190927_a, ItemStack.field_190927_a, det, ItemStack.field_190927_a, det, xer, xer));
        this.addFabricationStationRecipe(specB, new ItemStack((Item)ArmorInit.spectrosSet.boots));
        ArrayList<ItemStack> vitrH = new ArrayList<ItemStack>(Arrays.asList(phy, phy, xer, ItemStack.field_190927_a, xer, ItemStack.field_190927_a, ItemStack.field_190927_a));
        this.addFabricationStationRecipe(vitrH, new ItemStack((Item)ArmorInit.vitralitonSet.helmet));
        ArrayList<ItemStack> vitrC = new ArrayList<ItemStack>(Arrays.asList(xer, xer, phy, hex, phy, xer, xer));
        this.addFabricationStationRecipe(vitrC, new ItemStack((Item)ArmorInit.vitralitonSet.chestplate));
        ArrayList<ItemStack> vitrL = new ArrayList<ItemStack>(Arrays.asList(xer, xer, hex, ItemStack.field_190927_a, hex, xer, xer));
        this.addFabricationStationRecipe(vitrL, new ItemStack((Item)ArmorInit.vitralitonSet.leggings));
        ArrayList<ItemStack> vitrB = new ArrayList<ItemStack>(Arrays.asList(ItemStack.field_190927_a, ItemStack.field_190927_a, phy, ItemStack.field_190927_a, phy, xer, xer));
        this.addFabricationStationRecipe(vitrB, new ItemStack((Item)ArmorInit.vitralitonSet.boots));
        ArrayList<ItemStack> bligH = new ArrayList<ItemStack>(Arrays.asList(vel, vel, kyl, ItemStack.field_190927_a, kyl, ItemStack.field_190927_a, ItemStack.field_190927_a));
        this.addFabricationStationRecipe(bligH, new ItemStack((Item)ArmorInit.blightcystSet.helmet));
        ArrayList<ItemStack> bligC = new ArrayList<ItemStack>(Arrays.asList(vel, vel, vel, kyl, vel, hex, hex));
        this.addFabricationStationRecipe(bligC, new ItemStack((Item)ArmorInit.blightcystSet.chestplate));
        ArrayList<ItemStack> bligL = new ArrayList<ItemStack>(Arrays.asList(vel, vel, hex, ItemStack.field_190927_a, vel, vel, vel));
        this.addFabricationStationRecipe(bligL, new ItemStack((Item)ArmorInit.blightcystSet.leggings));
        ArrayList<ItemStack> bligB = new ArrayList<ItemStack>(Arrays.asList(ItemStack.field_190927_a, ItemStack.field_190927_a, hex, ItemStack.field_190927_a, hex, vel, vel));
        this.addFabricationStationRecipe(bligB, new ItemStack((Item)ArmorInit.blightcystSet.boots));
        ArrayList<ItemStack> veggH = new ArrayList<ItemStack>(Arrays.asList(bio, bio, bio, ItemStack.field_190927_a, bio, ItemStack.field_190927_a, ItemStack.field_190927_a));
        this.addFabricationStationRecipe(veggH, new ItemStack((Item)ArmorInit.bionicveggitronSet.helmet));
        ArrayList<ItemStack> veggC = new ArrayList<ItemStack>(Arrays.asList(bio, bio, bio, bio, bio, bio, bio));
        this.addFabricationStationRecipe(veggC, new ItemStack((Item)ArmorInit.bionicveggitronSet.chestplate));
        ArrayList<ItemStack> veggL = new ArrayList<ItemStack>(Arrays.asList(bio, bio, bio, ItemStack.field_190927_a, bio, bio, bio));
        this.addFabricationStationRecipe(veggL, new ItemStack((Item)ArmorInit.bionicveggitronSet.leggings));
        ArrayList<ItemStack> veggB = new ArrayList<ItemStack>(Arrays.asList(ItemStack.field_190927_a, ItemStack.field_190927_a, bio, ItemStack.field_190927_a, bio, bio, bio));
        this.addFabricationStationRecipe(veggB, new ItemStack((Item)ArmorInit.bionicveggitronSet.boots));
        ArrayList<ItemStack> gravH = new ArrayList<ItemStack>(Arrays.asList(det, det, ast, ItemStack.field_190927_a, ast, ItemStack.field_190927_a, ItemStack.field_190927_a));
        this.addFabricationStationRecipe(gravH, new ItemStack((Item)ArmorInit.graviteriumSet.helmet));
        ArrayList<ItemStack> gravC = new ArrayList<ItemStack>(Arrays.asList(det, det, ast, emb, ast, ast, ast));
        this.addFabricationStationRecipe(gravC, new ItemStack((Item)ArmorInit.graviteriumSet.chestplate));
        ArrayList<ItemStack> gravL = new ArrayList<ItemStack>(Arrays.asList(ast, ast, det, ItemStack.field_190927_a, det, ast, ast));
        this.addFabricationStationRecipe(gravL, new ItemStack((Item)ArmorInit.graviteriumSet.leggings));
        ArrayList<ItemStack> gravB = new ArrayList<ItemStack>(Arrays.asList(ItemStack.field_190927_a, ItemStack.field_190927_a, ast, ItemStack.field_190927_a, ast, emb, emb));
        this.addFabricationStationRecipe(gravB, new ItemStack((Item)ArmorInit.graviteriumSet.boots));
    }

    public static FabricationStationRecipeJEI getInstance() {
        return INSTANCE;
    }

    public void addFabricationStationRecipe(List<ItemStack> inputs, ItemStack result) {
        if (this.getFabricationStationResult(inputs) != ItemStack.field_190927_a) {
            return;
        }
        this.fabricationStationList.put(inputs, result);
    }

    public ItemStack getFabricationStationResult(List<ItemStack> inputs) {
        for (Map.Entry<List<ItemStack>, ItemStack> entry : this.fabricationStationList.entrySet()) {
            if (!Objects.equals(inputs, entry.getKey())) continue;
            return entry.getValue();
        }
        return ItemStack.field_190927_a;
    }

    public Map<List<ItemStack>, ItemStack> getFabricationStationList() {
        return this.fabricationStationList;
    }
}

