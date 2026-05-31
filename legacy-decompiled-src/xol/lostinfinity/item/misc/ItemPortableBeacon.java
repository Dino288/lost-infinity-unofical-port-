/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.NBTBase
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.nbt.NBTTagList
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.InteractionResultHolder
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.text.translation.I18n
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.item.misc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.phys.AABB;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.common.lostinfinity;
import xol.lostinfinity.gui.GuiHandler;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.classify.IHeldTick;

public class ItemPortableBeacon
extends Item
implements IHeldTick {
    public Collection<PotionEffect> getPotionEffects(ItemStack stack) {
        ArrayList<PotionEffect> potionEffects = new ArrayList<PotionEffect>();
        if (stack.func_77942_o() && stack.func_77978_p().func_150297_b("PotionEffects", 9)) {
            NBTTagList nbttaglist = stack.func_77978_p().func_150295_c("PotionEffects", 10);
            for (int i = 0; i < nbttaglist.func_74745_c(); ++i) {
                CompoundTag nbttagcompound = nbttaglist.func_150305_b(i);
                PotionEffect potioneffect = PotionEffect.func_82722_b((CompoundTag)nbttagcompound);
                if (potioneffect == null || potionEffects.contains(potioneffect)) continue;
                potionEffects.add(potioneffect);
            }
        }
        return potionEffects;
    }

    @Override
    public void heldTick(Player player, InteractionHand hand, ItemStack stack) {
        Collection<PotionEffect> effects;
        if (!player.field_70170_p.field_72995_K && hand == InteractionHand.OFF_HAND && player.field_70173_aa % 40 == 0 && !(effects = this.getPotionEffects(stack)).isEmpty()) {
            AABB axisAlignedBB = player.func_174813_aQ().func_72314_b(64.0, 64.0, 64.0);
            player.field_70170_p.func_72872_a(LivingEntity.class, axisAlignedBB).forEach(p -> {
                for (PotionEffect effect : effects) {
                    p.func_70690_d(new PotionEffect(effect.func_188419_a(), 400, effect.func_76458_c(), effect.func_82720_e(), effect.func_188418_e()));
                }
            });
        }
    }

    public void updatePotionEffects(ItemStack input, ItemStack beacon, PotionEffect effect, boolean remove) {
        if (!beacon.func_77942_o()) {
            beacon.func_77982_d(new CompoundTag());
        }
        if (!beacon.func_77978_p().func_74764_b("Capacity")) {
            beacon.func_77978_p().func_74768_a("Capacity", 5);
        }
        NBTTagList tagList = new NBTTagList();
        for (PotionEffect effect1 : this.getPotionEffects(beacon)) {
            if (remove && effect1 == effect) continue;
            tagList.func_74742_a((NBTBase)effect1.func_82719_a(new CompoundTag()));
        }
        if (!remove) {
            tagList.func_74742_a((NBTBase)effect.func_82719_a(new CompoundTag()));
        }
        beacon.func_77978_p().func_74782_a("PotionEffects", (NBTBase)tagList);
    }

    public void clearEffects(ItemStack stack) {
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
            stack.func_77978_p().func_74768_a("Capacity", 5);
        }
        stack.func_77978_p().func_82580_o("PotionEffects");
    }

    public int getLimit(ItemStack stack) {
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
        }
        if (!stack.func_77978_p().func_74764_b("Capacity")) {
            stack.func_77978_p().func_74768_a("Capacity", 5);
        }
        return stack.func_77978_p().func_74762_e("Capacity");
    }

    public void setNewLimit(ItemStack stack, int newLimit) {
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
        }
        stack.func_77978_p().func_74768_a("Capacity", newLimit);
    }

    public ItemPortableBeacon(String regName) {
        this.func_77637_a(TabsInit.TAB_INFINITYWEP);
        this.setRegistryName(regName);
        this.func_77655_b(regName);
        ItemInit.ITEMS.add(this);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        if (playerIn.func_184614_ca().func_77973_b().equals(ItemInit.portableBeacon)) {
            playerIn.openGui((Object)lostinfinity.instance, GuiHandler.RegisteredGuis.PORTABLE_BEACON.getId(), worldIn, 0, 0, 0);
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Gold) + "A portable beacon.");
        if (stack.func_77942_o()) {
            Collection<PotionEffect> effects = this.getPotionEffects(stack);
            tooltip.add((Object)((Object)TextFmt.Green) + "Effect Capacity " + effects.size() + " / " + stack.func_77978_p().func_74762_e("Capacity"));
            int num = 0;
            if (!effects.isEmpty()) {
                for (PotionEffect effect : effects) {
                    ++num;
                    String s1 = I18n.func_74838_a((String)effect.func_76453_d()).trim();
                    if (effect.func_76458_c() > 0) {
                        s1 = s1 + " " + I18n.func_74838_a((String)("potion.potency." + effect.func_76458_c())).trim();
                    }
                    tooltip.add(num + ". " + (Object)((Object)(effect.func_188419_a().func_76398_f() ? TextFmt.Red : TextFmt.Blue)) + s1);
                }
            }
        }
    }
}

