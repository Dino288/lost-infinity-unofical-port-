/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.util.InteractionResultHolder
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.item.activate;

import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.DimensionInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.classify.ICustomRaytrace;
import xol.lostinfinity.mob.entity.misc.EntityDimensionalMerchant;
import xol.lostinfinity.mob.entity.misc.EntityMarkOfInfiniteDespair;
import xol.lostinfinity.util.data.CustomHitResult;

public class ItemRapidTunnelingDevice
extends Item
implements ICustomRaytrace {
    public ItemRapidTunnelingDevice(String regName) {
        this.setRegistryName(regName);
        this.func_77655_b(regName);
        this.func_77637_a(TabsInit.TAB_AUXMATS);
        this.func_77625_d(1);
        ItemInit.ITEMS.add(this);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack stack = playerIn.func_184586_b(handIn);
        if (!worldIn.field_72995_K && worldIn.field_73011_w.func_186058_p() == DimensionInit.infiniteMurk) {
            CustomHitResult trace_result;
            if (!stack.func_77942_o()) {
                stack.func_77982_d(new CompoundTag());
            }
            if ((trace_result = this.entityTrace(worldIn, (LivingEntity)playerIn, 3, LivingEntity.class)) != null && trace_result.getResultEntity() != null) {
                Object stuck;
                EntityMarkOfInfiniteDespair mark = new EntityMarkOfInfiniteDespair(worldIn);
                if (trace_result.getResultEntity() instanceof Player) {
                    stuck = (Player)trace_result.getResultEntity();
                    mark.setOwner(playerIn);
                    mark.setPlayerTarget((Player)stuck);
                    mark.func_70634_a(stuck.field_70165_t, stuck.field_70163_u + 1.5, stuck.field_70161_v);
                    worldIn.func_72838_d((Entity)mark);
                    playerIn.func_145747_a((Component)new Component((Object)((Object)TextFmt.Dark_Aqua) + "You have sent " + stuck.func_70005_c_() + " tunneling down to the void."));
                    playerIn.func_184611_a(handIn, ItemStack.field_190927_a);
                }
                if (trace_result.getResultEntity() instanceof EntityDimensionalMerchant) {
                    stuck = (EntityDimensionalMerchant)trace_result.getResultEntity();
                    mark.setOwner(playerIn);
                    mark.func_70634_a(stuck.field_70165_t, stuck.field_70163_u - 20.5, stuck.field_70161_v);
                    worldIn.func_72838_d((Entity)mark);
                    playerIn.func_145747_a((Component)new Component((Object)((Object)TextFmt.Dark_Aqua) + "The " + stuck.func_70005_c_() + " decided they would rather not, and traded you an item instead."));
                    playerIn.func_184611_a(handIn, new ItemStack(ItemInit.voidAlteredSpine));
                }
            }
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Gold) + "Attach this to an entity inside the Infinite Murk to make it tunnel downwards.");
    }
}

