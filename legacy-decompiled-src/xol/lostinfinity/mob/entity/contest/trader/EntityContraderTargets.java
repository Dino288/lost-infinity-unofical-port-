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

public class EntityContraderTargets
extends EntityBaseMerchant
implements INpc,
IMerchant {
    public EntityContraderTargets(Level worldIn) {
        super(worldIn);
    }

    @Override
    public MerchantRecipeList getRecipeList() {
        MerchantRecipeList list = new MerchantRecipeList();
        list.add((Object)new MerchantRecipe(new ItemStack(ItemInit.masterCutDiamond, 5), new ItemStack(ItemInit.eliteContenderPass)));
        list.add((Object)new MerchantRecipe(new ItemStack(ItemInit.masterCutDiamond, 10), new ItemStack(ItemInit.mysteryBox, 4)));
        list.add((Object)new MerchantRecipe(new ItemStack(ItemInit.zirconiaRosewood, 20), new ItemStack(ItemInit.polyswitch)));
        list.add((Object)new MerchantRecipe(new ItemStack(ItemInit.zirconiaRosewood, 50), new ItemStack(ItemInit.zirconiaRosewood, 50), new ItemStack(ItemInit.sparkChamber)));
        return list;
    }
}

