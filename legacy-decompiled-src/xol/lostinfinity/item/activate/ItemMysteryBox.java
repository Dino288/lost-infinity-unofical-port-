/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.item.ItemEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.InteractionResultHolder
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 *  net.minecraft.world.storage.loot.LootContext
 *  net.minecraft.world.storage.loot.LootContext$Builder
 *  net.minecraft.world.storage.loot.LootTable
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.item.activate;

import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.storage.loot.LootTable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.TabsInit;

public class ItemMysteryBox
extends Item {
    public ItemMysteryBox(String regName) {
        this.setRegistryName(regName);
        this.func_77655_b(regName);
        this.func_77637_a(TabsInit.TAB_AUXMATS);
        ItemInit.ITEMS.add(this);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        if (!worldIn.field_72995_K) {
            LootContext ctx;
            LootTable mysteryBox = worldIn.func_184146_ak().func_186521_a(new ResourceLocation("lostinfinity:mysterybox"));
            List loot = mysteryBox.func_186462_a(worldIn.field_73012_v, ctx = new LootContext.Builder(worldIn.func_73046_m().func_71218_a(playerIn.field_71093_bK)).func_186471_a());
            if (!playerIn.func_191521_c((ItemStack)loot.get(0))) {
                BlockPos playerPos = playerIn.func_180425_c();
                ItemEntity lootDrop = new ItemEntity(worldIn, (double)playerPos.func_177958_n(), (double)playerPos.func_177956_o(), (double)playerPos.func_177952_p(), (ItemStack)loot.get(0));
                playerIn.func_184586_b(handIn).func_190918_g(1);
                lootDrop.func_145779_a(((ItemStack)loot.get(0)).func_77973_b(), ((ItemStack)loot.get(0)).func_190916_E());
            }
            playerIn.func_184586_b(handIn).func_190918_g(1);
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Green) + "Open to get a random amount of a random Zirconia type.");
    }
}

