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
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemCooldown;
import xol.lostinfinity.mob.entity.mount.EntityXScreacher;

public class ItemXScreacher
extends ItemCooldown {
    private static final String MOUNT_ID = "mount_id";

    public ItemXScreacher(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_AUXWEP);
    }

    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return false;
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack stack = playerIn.func_184586_b(handIn);
        Entity mount = playerIn.func_184208_bv();
        if (!this.showDurabilityBar(stack)) {
            if (mount instanceof EntityXScreacher) {
                if (!worldIn.field_72995_K) {
                    this.useAttack(playerIn, (EntityXScreacher)mount);
                }
            } else {
                if (!worldIn.field_72995_K) {
                    Entity prevMount;
                    UUID prev = this.getSpawnedUUID(stack);
                    if (prev != null && (prevMount = worldIn.func_73046_m().func_175576_a(prev)) != null) {
                        prevMount.func_70106_y();
                    }
                    EntityXScreacher screacher = new EntityXScreacher(worldIn);
                    screacher.func_70107_b(playerIn.field_70165_t, playerIn.field_70163_u, playerIn.field_70161_v);
                    screacher.setOwner(playerIn);
                    worldIn.func_72838_d((Entity)screacher);
                    playerIn.func_184205_a((Entity)screacher, true);
                    this.setSpawnedUUID(stack, screacher.func_110124_au());
                }
                this.startCooldown(stack);
            }
        } else if (!worldIn.field_72995_K && mount instanceof EntityXScreacher) {
            this.useAttack(playerIn, (EntityXScreacher)mount);
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    private void useAttack(Player player, EntityXScreacher screacher) {
        screacher.fireAttack(player);
    }

    @Override
    protected int getCooldown() {
        return 120000;
    }

    private void setSpawnedUUID(ItemStack stack, UUID uuid) {
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
        }
        stack.func_77978_p().func_186854_a(MOUNT_ID, uuid);
    }

    private UUID getSpawnedUUID(ItemStack stack) {
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
            return null;
        }
        return stack.func_77978_p().func_186857_a(MOUNT_ID);
    }

    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Light_Purple) + "Summons a powerful X-Screacher creature for you to ride.");
        tooltip.add((Object)((Object)TextFmt.Aqua) + "The X-Screacher will grant you increased regeneration and can fire terrain piercing attacks.");
    }
}

