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

public class EntityContraderRedlight
extends EntityBaseMerchant
implements INpc,
IMerchant {
    public EntityContraderRedlight(Level worldIn) {
        super(worldIn);
    }

    @Override
    public MerchantRecipeList getRecipeList() {
        MerchantRecipeList list = new MerchantRecipeList();
        list.add((Object)new MerchantRecipe(new ItemStack(ItemInit.celestialDiamond, 10), new ItemStack(ItemInit.contenderPass)));
        list.add((Object)new MerchantRecipe(new ItemStack(ItemInit.celestialDiamond, 15), new ItemStack(ItemInit.mysteryBox)));
        list.add((Object)new MerchantRecipe(new ItemStack(ItemInit.zirconiaMalachite, 20), new ItemStack(ItemInit.movementSensor)));
        list.add((Object)new MerchantRecipe(new ItemStack(ItemInit.zirconiaMalachite, 50), new ItemStack(ItemInit.zirconiaMalachite, 50), new ItemStack(ItemInit.malachiteInclinometer)));
        return list;
    }
}

