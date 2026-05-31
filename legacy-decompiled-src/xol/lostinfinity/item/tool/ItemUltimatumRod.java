/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.util.InteractionResultHolder
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.DimensionType
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.item.tool;

import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.DimensionType;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.dimension.util.DimensionActivator;
import xol.lostinfinity.init.DimensionInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.classify.IDeviator;

public class ItemUltimatumRod
extends Item
implements IDeviator {
    public ItemUltimatumRod(String regName) {
        this.func_77637_a(TabsInit.TAB_AUXWEP);
        this.setRegistryName(regName);
        this.func_77655_b(regName);
        ItemInit.ITEMS.add(this);
    }

    public boolean onLeftClickEntity(ItemStack stack, Player attacker, Entity target) {
        if (!this.superMutateCreature(stack, attacker, target) && !this.deviateCreature(stack, attacker, target)) {
            this.ultimatumMutation(stack, attacker, target);
        }
        return true;
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack stack = playerIn.func_184586_b(handIn);
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
            stack.func_77978_p().func_74757_a("teleporter_active", false);
        }
        if (!playerIn.func_70093_af()) {
            if (!worldIn.field_72995_K && stack.func_77978_p().func_74767_n("teleporter_active")) {
                if (worldIn.field_73011_w.func_186058_p() != DimensionInit.celestialVoid) {
                    DimensionActivator.transferEntityWithCoords((Entity)playerIn, DimensionInit.celestialVoid, 985.0, 31.0, 989.0);
                } else {
                    DimensionActivator.transferEntity((Entity)playerIn, DimensionType.OVERWORLD);
                }
            }
        } else {
            boolean tele_enabled = !stack.func_77978_p().func_74767_n("teleporter_active");
            stack.func_77978_p().func_74757_a("teleporter_active", tele_enabled);
            if (!worldIn.field_72995_K) {
                if (tele_enabled) {
                    playerIn.func_145747_a((Component)new Component((Object)((Object)TextFmt.Gold) + "Teleporter enabled."));
                    worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundInit.FLUX_MARK, SoundSource.MASTER, 1.0f, 1.0f);
                } else {
                    playerIn.func_145747_a((Component)new Component((Object)((Object)TextFmt.Red) + "Teleporter disabled."));
                    worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundEvents.field_187556_aj, SoundSource.MASTER, 1.0f, 1.0f);
                }
            }
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Dark_Aqua) + "Deviates creatures.");
        tooltip.add((Object)((Object)TextFmt.Yellow) + "Super-mutates deviants.");
        tooltip.add((Object)((Object)TextFmt.Aqua) + "Deviates powerful creatures when near a deviation energy source.");
        if (stack.func_77942_o()) {
            tooltip.add((Object)((Object)TextFmt.Light_Purple) + "Teleporter " + (stack.func_77978_p().func_74767_n("teleporter_active") ? "Enabled" : "Disabled"));
        }
    }
}

