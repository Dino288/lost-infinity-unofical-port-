/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.IMerchant
 *  net.minecraft.entity.INpc
 *  net.minecraft.item.ItemStack
 *  net.minecraft.village.MerchantRecipe
 *  net.minecraft.village.MerchantRecipeList
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.contest.trader;

import net.minecraft.entity.IMerchant;
import net.minecraft.entity.INpc;
import net.minecraft.world.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.mob.entity.base.EntityBaseMerchant;

public class EntityChemist
extends EntityBaseMerchant
implements INpc,
IMerchant {
    public EntityChemist(Level worldIn) {
        super(worldIn);
    }

    @Override
    public MerchantRecipeList getRecipeList() {
        MerchantRecipeList list = new MerchantRecipeList();
        list.add((Object)new MerchantRecipe(new ItemStack(ItemInit.goldToken, 1), new ItemStack(ItemInit.cureSampleBlue, 16)));
        list.add((Object)new MerchantRecipe(new ItemStack(ItemInit.goldToken, 1), new ItemStack(ItemInit.cureSampleGreen, 16)));
        list.add((Object)new MerchantRecipe(new ItemStack(ItemInit.goldToken, 1), new ItemStack(ItemInit.cureSampleOrange, 16)));
        list.add((Object)new MerchantRecipe(new ItemStack(ItemInit.goldToken, 1), new ItemStack(ItemInit.cureSamplePink, 16)));
        list.add((Object)new MerchantRecipe(new ItemStack(ItemInit.goldToken, 1), new ItemStack(ItemInit.cureSampleYellow, 16)));
        list.add((Object)new MerchantRecipe(new ItemStack(ItemInit.amazoniteToken, 10), new ItemStack(ItemInit.magicBiopowder, 16)));
        list.add((Object)new MerchantRecipe(new ItemStack(ItemInit.corruptedRoot, 60), new ItemStack(ItemInit.containerOfCollectionFull, 1), new ItemStack(ItemInit.colixiumCatenationPouch)));
        list.add((Object)new MerchantRecipe(new ItemStack(ItemInit.ghostlyHusk, 60), new ItemStack(ItemInit.containerOfCollectionFull, 1), new ItemStack(ItemInit.phoroxiumCatenationPouch)));
        list.add((Object)new MerchantRecipe(new ItemStack(ItemInit.luminescentCubes, 60), new ItemStack(ItemInit.containerOfCollectionFull, 1), new ItemStack(ItemInit.laraxiumCatenationPouch)));
        return list;
    }
}

