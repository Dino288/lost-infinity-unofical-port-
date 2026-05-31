/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.NBTBase
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.nbt.NBTTagInt
 *  net.minecraft.nbt.NBTTagList
 *  net.minecraft.potion.Potion
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.item.misc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemBasic;
import xol.lostinfinity.item.classify.IHotbarTick;
import xol.lostinfinity.util.PotionBasic;

public class ItemPotionPolarizer
extends ItemBasic
implements IHotbarTick {
    public ItemPotionPolarizer(String regName) {
        super(regName, TabsInit.TAB_AUXWEP);
    }

    @Override
    public void hotbarTick(Player player, int itemSlot, ItemStack stack) {
        Object tag2;
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
        }
        Collection effectList = player.func_70651_bq();
        ArrayList<Integer> potionIDs = new ArrayList<Integer>();
        for (Object tag2 : stack.func_77978_p().func_150295_c("potionID", 3)) {
            if (!(tag2 instanceof NBTTagInt)) continue;
            NBTTagInt intTag = (NBTTagInt)tag2;
            potionIDs.add(intTag.func_150287_d());
        }
        ArrayList<Integer> toRemove = new ArrayList<Integer>();
        tag2 = potionIDs.iterator();
        while (tag2.hasNext()) {
            int id = (Integer)tag2.next();
            boolean found = false;
            for (PotionEffect effect : effectList) {
                if (Potion.func_188409_a((Potion)effect.func_188419_a()) != id) continue;
                found = true;
                break;
            }
            if (found) continue;
            toRemove.add(potionIDs.indexOf(id));
        }
        NBTTagList tagList = stack.func_77978_p().func_150295_c("potionID", 3);
        Iterator id = toRemove.iterator();
        while (id.hasNext()) {
            int index = (Integer)id.next();
            if (index >= potionIDs.size()) continue;
            potionIDs.remove(index);
            tagList.func_74744_a(index);
        }
        stack.func_77978_p().func_74782_a("potionID", (NBTBase)tagList);
        ArrayList<Potion> potionsToRemove = new ArrayList<Potion>();
        ArrayList<PotionEffect> effectsToAdd = new ArrayList<PotionEffect>();
        for (PotionEffect effect : effectList) {
            int newDur;
            int newAmp;
            Potion potion = effect.func_188419_a();
            int id2 = Potion.func_188409_a((Potion)potion);
            if (potionIDs.contains(id2)) continue;
            stack.func_77978_p().func_74768_a("tempID", id2);
            NBTBase idTag = stack.func_77978_p().func_74781_a("tempID");
            NBTTagList newTagList = stack.func_77978_p().func_150295_c("potionID", 3);
            newTagList.func_74742_a(idTag);
            stack.func_77978_p().func_74782_a("potionID", (NBTBase)newTagList);
            int amp = effect.func_76458_c();
            int duration = effect.func_76459_b();
            if (potion instanceof PotionBasic && !((PotionBasic)potion).negativeLostEffect() || !(potion instanceof PotionBasic) && !potion.func_76398_f()) {
                potionsToRemove.add(potion);
                newAmp = (int)Math.ceil(Math.min((double)amp * 1.5, 10.0));
                newDur = duration * 2;
                effectsToAdd.add(new PotionEffect(potion, newDur, newAmp));
                continue;
            }
            newAmp = (int)Math.floor(Math.max((double)amp * 0.5, 1.0));
            newDur = duration / 2;
            potionsToRemove.add(potion);
            effectsToAdd.add(new PotionEffect(potion, newDur, newAmp));
        }
        for (Potion potion : potionsToRemove) {
            player.func_184589_d(potion);
        }
        for (PotionEffect effect : effectsToAdd) {
            player.func_70690_d(effect);
        }
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Gold) + "While in the hotbar, adjusts potion effects added to you.");
        tooltip.add((Object)((Object)TextFmt.Green) + "Positive potion effects become 50% stronger and last 50% longer.");
        tooltip.add((Object)((Object)TextFmt.Red) + "Negative potion effects become half as strong and last half as long.");
    }
}

