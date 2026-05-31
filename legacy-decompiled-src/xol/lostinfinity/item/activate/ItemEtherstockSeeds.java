/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.InteractionResultHolder
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.item.activate;

import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.TabsInit;

public class ItemEtherstockSeeds
extends Item {
    public ItemEtherstockSeeds(String regName) {
        this.setRegistryName(regName);
        this.func_77655_b(regName);
        this.func_77637_a(TabsInit.TAB_AUXMATS);
        ItemInit.ITEMS.add(this);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        if (worldIn.func_180495_p(playerIn.func_180425_c().func_177977_b()).func_177230_c() == BlockInit.poweredCrystallizedSoil && worldIn.func_175623_d(playerIn.func_180425_c())) {
            if (!worldIn.field_72995_K) {
                worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundEvents.field_187693_cj, SoundSource.PLAYERS, 1.0f, 1.0f);
                worldIn.func_175656_a(playerIn.func_180425_c(), BlockInit.etherstock.func_176203_a(0));
            }
            playerIn.func_184586_b(handIn).func_190918_g(1);
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Aqua) + "Can be used to grow an Etherstock on fueled soil.");
    }
}

