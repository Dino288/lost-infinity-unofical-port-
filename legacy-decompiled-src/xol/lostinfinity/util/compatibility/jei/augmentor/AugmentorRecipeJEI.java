/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.HashBasedTable
 *  com.google.common.collect.Table
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.NBTBase
 *  net.minecraft.nbt.NBTTagInt
 *  net.minecraft.nbt.NBTTagList
 */
package xol.lostinfinity.util.compatibility.jei.augmentor;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import java.util.Map;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.nbt.NBTTagList;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.item.misc.ItemAugmenticonBox;

public class AugmentorRecipeJEI {
    private static final AugmentorRecipeJEI INSTANCE = new AugmentorRecipeJEI();
    private final Table<ItemStack, ItemStack, ItemStack> augmentorList = HashBasedTable.create();

    public AugmentorRecipeJEI() {
        ItemStack boxDash = new ItemStack(ItemInit.augmenticonBox);
        NBTTagList nbtDash = ItemAugmenticonBox.getAugmentList(boxDash);
        nbtDash.func_74742_a((NBTBase)new NBTTagInt(0));
        this.addAugmentorRecipe(new ItemStack(ItemInit.augmentSlideDash), new ItemStack(ItemInit.augmenticonBox), boxDash);
        ItemStack boxSlam = new ItemStack(ItemInit.augmenticonBox);
        NBTTagList nbtSlam = ItemAugmenticonBox.getAugmentList(boxSlam);
        nbtSlam.func_74742_a((NBTBase)new NBTTagInt(1));
        this.addAugmentorRecipe(new ItemStack(ItemInit.augmentSlideSlam), new ItemStack(ItemInit.augmenticonBox), boxSlam);
        ItemStack boxInvis = new ItemStack(ItemInit.augmenticonBox);
        NBTTagList nbtInvis = ItemAugmenticonBox.getAugmentList(boxInvis);
        nbtInvis.func_74742_a((NBTBase)new NBTTagInt(2));
        this.addAugmentorRecipe(new ItemStack(ItemInit.augmentSlideInvis), new ItemStack(ItemInit.augmenticonBox), boxInvis);
        ItemStack boxForcefield = new ItemStack(ItemInit.augmenticonBox);
        NBTTagList nbtForcefield = ItemAugmenticonBox.getAugmentList(boxForcefield);
        nbtForcefield.func_74742_a((NBTBase)new NBTTagInt(3));
        this.addAugmentorRecipe(new ItemStack(ItemInit.augmentSlideForcefield), new ItemStack(ItemInit.augmenticonBox), boxForcefield);
        ItemStack boxTeleport = new ItemStack(ItemInit.augmenticonBox);
        NBTTagList nbtTeleport = ItemAugmenticonBox.getAugmentList(boxTeleport);
        nbtTeleport.func_74742_a((NBTBase)new NBTTagInt(4));
        this.addAugmentorRecipe(new ItemStack(ItemInit.augmentSlideTeleport), new ItemStack(ItemInit.augmenticonBox), boxTeleport);
        ItemStack boxHeal = new ItemStack(ItemInit.augmenticonBox);
        NBTTagList nbtHeal = ItemAugmenticonBox.getAugmentList(boxHeal);
        nbtHeal.func_74742_a((NBTBase)new NBTTagInt(5));
        this.addAugmentorRecipe(new ItemStack(ItemInit.augmentSlideHeal), new ItemStack(ItemInit.augmenticonBox), boxHeal);
        ItemStack boxHurt = new ItemStack(ItemInit.augmenticonBox);
        NBTTagList nbtHurt = ItemAugmenticonBox.getAugmentList(boxHurt);
        nbtHurt.func_74742_a((NBTBase)new NBTTagInt(6));
        this.addAugmentorRecipe(new ItemStack(ItemInit.augmentSlideHurt), new ItemStack(ItemInit.augmenticonBox), boxHurt);
        ItemStack boxSummon = new ItemStack(ItemInit.augmenticonBox);
        NBTTagList nbtSummon = ItemAugmenticonBox.getAugmentList(boxSummon);
        nbtSummon.func_74742_a((NBTBase)new NBTTagInt(7));
        this.addAugmentorRecipe(new ItemStack(ItemInit.augmentSlideSummon), new ItemStack(ItemInit.augmenticonBox), boxSummon);
        ItemStack boxBlight = new ItemStack(ItemInit.augmenticonBox);
        NBTTagList nbtBlight = ItemAugmenticonBox.getAugmentList(boxBlight);
        nbtBlight.func_74742_a((NBTBase)new NBTTagInt(8));
        this.addAugmentorRecipe(new ItemStack(ItemInit.augmentSlideBlight), new ItemStack(ItemInit.augmenticonBox), boxBlight);
        ItemStack boxPlague = new ItemStack(ItemInit.augmenticonBox);
        NBTTagList nbtPlague = ItemAugmenticonBox.getAugmentList(boxPlague);
        nbtPlague.func_74742_a((NBTBase)new NBTTagInt(9));
        this.addAugmentorRecipe(new ItemStack(ItemInit.augmentSlidePlague), new ItemStack(ItemInit.augmenticonBox), boxPlague);
        ItemStack boxEMP = new ItemStack(ItemInit.augmenticonBox);
        NBTTagList nbtEMP = ItemAugmenticonBox.getAugmentList(boxEMP);
        nbtEMP.func_74742_a((NBTBase)new NBTTagInt(10));
        this.addAugmentorRecipe(new ItemStack(ItemInit.augmentSlideEMP), new ItemStack(ItemInit.augmenticonBox), boxEMP);
        ItemStack boxShatter = new ItemStack(ItemInit.augmenticonBox);
        NBTTagList nbtShatter = ItemAugmenticonBox.getAugmentList(boxShatter);
        nbtShatter.func_74742_a((NBTBase)new NBTTagInt(11));
        this.addAugmentorRecipe(new ItemStack(ItemInit.augmentSlideShatter), new ItemStack(ItemInit.augmenticonBox), boxShatter);
        ItemStack boxTether = new ItemStack(ItemInit.augmenticonBox);
        NBTTagList nbtTether = ItemAugmenticonBox.getAugmentList(boxTether);
        nbtTether.func_74742_a((NBTBase)new NBTTagInt(12));
        this.addAugmentorRecipe(new ItemStack(ItemInit.augmentSlideTether), new ItemStack(ItemInit.augmenticonBox), boxTether);
        ItemStack boxUnleash = new ItemStack(ItemInit.augmenticonBox);
        NBTTagList nbtUnleash = ItemAugmenticonBox.getAugmentList(boxUnleash);
        nbtUnleash.func_74742_a((NBTBase)new NBTTagInt(13));
        this.addAugmentorRecipe(new ItemStack(ItemInit.augmentSlideUnleash), new ItemStack(ItemInit.augmenticonBox), boxUnleash);
        ItemStack boxGravity = new ItemStack(ItemInit.augmenticonBox);
        NBTTagList nbtGravity = ItemAugmenticonBox.getAugmentList(boxGravity);
        nbtGravity.func_74742_a((NBTBase)new NBTTagInt(14));
        this.addAugmentorRecipe(new ItemStack(ItemInit.augmentSlideGravity), new ItemStack(ItemInit.augmenticonBox), boxGravity);
        ItemStack boxNightmares = new ItemStack(ItemInit.augmenticonBox);
        NBTTagList nbtNightmares = ItemAugmenticonBox.getAugmentList(boxNightmares);
        nbtNightmares.func_74742_a((NBTBase)new NBTTagInt(15));
        this.addAugmentorRecipe(new ItemStack(ItemInit.augmentSlideNightmares), new ItemStack(ItemInit.augmenticonBox), boxNightmares);
        ItemStack boxExplosive = new ItemStack(ItemInit.augmenticonBox);
        NBTTagList nbtExplosive = ItemAugmenticonBox.getAugmentList(boxExplosive);
        nbtExplosive.func_74742_a((NBTBase)new NBTTagInt(16));
        this.addAugmentorRecipe(new ItemStack(ItemInit.augmentSlideExplosive), new ItemStack(ItemInit.augmenticonBox), boxExplosive);
        ItemStack boxTrailing = new ItemStack(ItemInit.augmenticonBox);
        NBTTagList nbtTrailing = ItemAugmenticonBox.getAugmentList(boxTrailing);
        nbtTrailing.func_74742_a((NBTBase)new NBTTagInt(17));
        this.addAugmentorRecipe(new ItemStack(ItemInit.augmentSlideTrailing), new ItemStack(ItemInit.augmenticonBox), boxTrailing);
        ItemStack boxDestructive = new ItemStack(ItemInit.augmenticonBox);
        NBTTagList nbtDestructive = ItemAugmenticonBox.getAugmentList(boxDestructive);
        nbtDestructive.func_74742_a((NBTBase)new NBTTagInt(18));
        this.addAugmentorRecipe(new ItemStack(ItemInit.augmentSlideDestructive), new ItemStack(ItemInit.augmenticonBox), boxDestructive);
        ItemStack boxRegenerative = new ItemStack(ItemInit.augmenticonBox);
        NBTTagList nbtRegenerative = ItemAugmenticonBox.getAugmentList(boxRegenerative);
        nbtRegenerative.func_74742_a((NBTBase)new NBTTagInt(19));
        this.addAugmentorRecipe(new ItemStack(ItemInit.augmentSlideRegenerative), new ItemStack(ItemInit.augmenticonBox), boxRegenerative);
    }

    public static AugmentorRecipeJEI getInstance() {
        return INSTANCE;
    }

    public void addAugmentorRecipe(ItemStack input1, ItemStack input2, ItemStack result) {
        if (this.getAugmentorResult(input1, input2) != ItemStack.field_190927_a) {
            return;
        }
        this.augmentorList.put((Object)input1, (Object)input2, (Object)result);
    }

    public ItemStack getAugmentorResult(ItemStack input1, ItemStack input2) {
        for (Map.Entry entry : this.augmentorList.columnMap().entrySet()) {
            if (!this.compareItemStacks(input1, (ItemStack)entry.getKey())) continue;
            for (Map.Entry ent : ((Map)entry.getValue()).entrySet()) {
                if (!this.compareItemStacks(input2, (ItemStack)ent.getKey())) continue;
                return (ItemStack)ent.getValue();
            }
        }
        return ItemStack.field_190927_a;
    }

    private boolean compareItemStacks(ItemStack stack1, ItemStack stack2) {
        return stack1.func_77973_b() == stack2.func_77973_b() && stack1.func_77960_j() == stack2.func_77960_j();
    }

    public Table<ItemStack, ItemStack, ItemStack> getAugmentorList() {
        return this.augmentorList;
    }
}

