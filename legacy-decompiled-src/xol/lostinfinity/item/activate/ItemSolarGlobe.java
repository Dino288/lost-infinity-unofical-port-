/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.util.InteractionResultHolder
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.DimensionType
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.item.activate;

import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
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
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.classify.IModeSelect;
import xol.lostinfinity.item.classify.ISwitchModels;

public class ItemSolarGlobe
extends Item
implements IModeSelect,
ISwitchModels {
    public ItemSolarGlobe(String regName) {
        this.setRegistryName(regName);
        this.func_77655_b(regName);
        this.func_77637_a(TabsInit.TAB_AUXMATS);
        ItemInit.ITEMS.add(this);
        this.func_77625_d(1);
        this.setModelSwitch("floor", this, 3);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        if (!worldIn.field_72995_K) {
            if (worldIn.field_73011_w.func_186058_p() == DimensionType.OVERWORLD) {
                int roomRand_Z;
                int bound = 1000;
                int roomRand_X = worldIn.field_73012_v.nextInt(bound) - bound / 2;
                double yPlace = roomRand_X == (roomRand_Z = worldIn.field_73012_v.nextInt(bound) - bound / 2) ? 16.0 : 25.0;
                ItemStack stack = playerIn.func_184586_b(handIn);
                if (!stack.func_77942_o()) {
                    stack.func_77982_d(new CompoundTag());
                }
                DimensionType goTo = DimensionInit.cartographerRealmTop;
                int teleStyle = stack.func_77978_p().func_74762_e("floor_data");
                if (teleStyle == 1) {
                    goTo = DimensionInit.cartographerRealmMid;
                } else if (teleStyle == 2) {
                    goTo = DimensionInit.cartographerRealmBot;
                }
                DimensionActivator.transferEntityWithCoords((Entity)playerIn, goTo, 15 + 160 * roomRand_X, yPlace, 15 + 160 * roomRand_Z);
            } else {
                DimensionActivator.transferEntity((Entity)playerIn, DimensionType.OVERWORLD);
            }
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Gold) + "Teleports you in and out of the Cartographers Labyrinth.");
        tooltip.add((Object)((Object)TextFmt.Gold) + "Can select any floor to teleport to.");
    }

    @Override
    public void modeUpdate(ItemStack stack, Player player) {
        int floor;
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
        }
        if ((floor = stack.func_77978_p().func_74762_e("floor_data")) == 0) {
            stack.func_77978_p().func_74768_a("floor_data", 1);
            player.func_145747_a((Component)new Component((Object)((Object)TextFmt.Red) + "Teleport set to middle (red)."));
        } else if (floor == 1) {
            stack.func_77978_p().func_74768_a("floor_data", 2);
            player.func_145747_a((Component)new Component((Object)((Object)TextFmt.Light_Purple) + "Teleport set to bottom (purple)."));
        } else {
            stack.func_77978_p().func_74768_a("floor_data", 0);
            player.func_145747_a((Component)new Component((Object)((Object)TextFmt.Aqua) + "Teleport set to top (blue)."));
        }
    }
}

