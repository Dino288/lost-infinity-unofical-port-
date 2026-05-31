/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.util.InteractionResultHolder
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.world.World
 */
package xol.lostinfinity.item.activate;

import java.util.UUID;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.DimensionInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemBasic;
import xol.lostinfinity.mob.entity.mount.EntityJetMount;

public class ItemJetPack
extends ItemBasic {
    private static final String MOUNT_ID = "mount_id";

    public ItemJetPack(String regName) {
        super(regName, TabsInit.TAB_AUXMATS);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack stack = playerIn.func_184586_b(handIn);
        Entity mount = playerIn.func_184208_bv();
        if (!worldIn.field_72995_K) {
            if (mount instanceof EntityJetMount) {
                mount.func_70106_y();
            } else {
                Entity prevMount;
                UUID prev = this.getSpawnedUUID(stack);
                if (prev != null && (prevMount = worldIn.func_73046_m().func_175576_a(prev)) != null) {
                    prevMount.func_70106_y();
                }
                EntityJetMount jetPack = new EntityJetMount(worldIn);
                jetPack.setOwner(playerIn);
                jetPack.func_70107_b(playerIn.field_70165_t, playerIn.field_70163_u, playerIn.field_70161_v);
                worldIn.func_72838_d((Entity)jetPack);
                if (!playerIn.func_184205_a((Entity)jetPack, true)) {
                    jetPack.func_70106_y();
                    return super.func_77659_a(worldIn, playerIn, handIn);
                }
                this.setSpawnedUUID(stack, jetPack.func_110124_au());
                if (worldIn.field_73011_w.func_186058_p() == DimensionInit.infiniteMurk) {
                    jetPack.startCourse(playerIn);
                }
            }
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
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
}

