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

public class EntityContraderMarket
extends EntityBaseMerchant
implements INpc,
IMerchant {
    public EntityContraderMarket(Level worldIn) {
        super(worldIn);
    }

    @Override
    public MerchantRecipeList getRecipeList() {
        MerchantRecipeList list = new MerchantRecipeList();
        list.add((Object)new MerchantRecipe(new ItemStack(ItemInit.masterCraftedAlloy, 15), new ItemStack(ItemInit.containerOfCollectionFull, 1), new ItemStack(ItemInit.dualWeaponConvertor)));
        list.add((Object)new MerchantRecipe(new ItemStack(ItemInit.crystallizedAlloy, 15), new ItemStack(ItemInit.containerOfCollectionFull, 1), new ItemStack(ItemInit.directWeaponConvertor)));
        list.add((Object)new MerchantRecipe(new ItemStack(ItemInit.starcrystalCapacitor, 10), new ItemStack(ItemInit.containerOfCollectionFull, 1), new ItemStack(ItemInit.ultrapoweredCapacitor)));
        list.add((Object)new MerchantRecipe(new ItemStack(ItemInit.gigachargeSolutions, 10), new ItemStack(ItemInit.containerOfCollectionFull, 1), new ItemStack(ItemInit.minorMultiversalDevice)));
        list.add((Object)new MerchantRecipe(new ItemStack(ItemInit.unstableIngot, 20), new ItemStack(ItemInit.containerOfCollectionFull, 1), new ItemStack(ItemInit.radioactiveIsotopes)));
        list.add((Object)new MerchantRecipe(new ItemStack(ItemInit.deviantFragmentBL, 1), new ItemStack(ItemInit.broachOfDeviancy)));
        list.add((Object)new MerchantRecipe(new ItemStack(ItemInit.deviantFragmentBR, 1), new ItemStack(ItemInit.broachOfDeviancy)));
        list.add((Object)new MerchantRecipe(new ItemStack(ItemInit.deviantFragmentTR, 1), new ItemStack(ItemInit.broachOfDeviancy)));
        list.add((Object)new MerchantRecipe(new ItemStack(ItemInit.deviantFragmentTL, 1), new ItemStack(ItemInit.broachOfDeviancy)));
        list.add((Object)new MerchantRecipe(new ItemStack(ItemInit.silverToken, 10), new ItemStack(ItemInit.hypersonicDriveChamber)));
        list.add((Object)new MerchantRecipe(new ItemStack(ItemInit.amazoniteToken, 4), new ItemStack(ItemInit.reactiveMushroom, 1), new ItemStack(ItemInit.superCell, 2)));
        list.add((Object)new MerchantRecipe(new ItemStack(ItemInit.amazoniteToken, 4), new ItemStack(ItemInit.ghostlyHusk, 60), new ItemStack(ItemInit.etherstockSeeds, 1)));
        list.add((Object)new MerchantRecipe(new ItemStack(ItemInit.boxOfLife, 1), new ItemStack(ItemInit.goldToken, 10)));
        return list;
    }
}

