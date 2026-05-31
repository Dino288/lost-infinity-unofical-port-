/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.util.InteractionResultHolder
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.item.weapon;

import java.util.List;
import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemCooldown;
import xol.lostinfinity.mob.entity.minion.EntityBombDrone;

public class ItemBombDeliveryDrone
extends ItemCooldown {
    public ItemBombDeliveryDrone(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_AUXWEP);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack stack = playerIn.func_184586_b(handIn);
        if (!this.showDurabilityBar(stack)) {
            if (!worldIn.field_72995_K) {
                UUID uuid;
                if (!this.canSummon(worldIn, stack) && (uuid = this.getSpawnedUUID(stack)) != null) {
                    worldIn.func_73046_m().func_175576_a(uuid).func_70106_y();
                }
                EntityBombDrone drone = new EntityBombDrone(worldIn);
                drone.setOwner(playerIn);
                drone.func_70107_b(playerIn.field_70165_t, playerIn.field_70163_u, playerIn.field_70161_v);
                worldIn.func_72838_d((Entity)drone);
                this.setSpawnedUUID(stack, drone.func_110124_au());
                playerIn.func_184220_m((Entity)drone);
            }
            this.startCooldown(stack);
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    private boolean canSummon(Level world, ItemStack stack) {
        UUID uuid = this.getSpawnedUUID(stack);
        if (uuid == null) {
            return true;
        }
        Entity bound = world.func_73046_m().func_175576_a(uuid);
        return !(bound instanceof EntityBombDrone);
    }

    private void setSpawnedUUID(ItemStack stack, UUID uuid) {
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
        }
        stack.func_77978_p().func_186854_a("summon", uuid);
    }

    private UUID getSpawnedUUID(ItemStack stack) {
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
            return null;
        }
        return stack.func_77978_p().func_186857_a("summon");
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Aqua) + "Take control of a bomb drone.");
        tooltip.add((Object)((Object)TextFmt.Gold) + "Dismounting the drone causes it to explode.");
        tooltip.add((Object)((Object)TextFmt.Red) + "Deals 110% Health True Damage To Nearby Targets");
        tooltip.add((Object)((Object)TextFmt.Italic) + "Detonating returns you to your starting position.");
    }
}

