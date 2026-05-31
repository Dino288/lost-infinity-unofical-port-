/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
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
 *  net.minecraft.world.World
 */
package xol.lostinfinity.item.misc;

import java.util.UUID;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
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
import net.minecraft.world.level.Level;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.classify.IHotbarTick;
import xol.lostinfinity.projectile.entity.EntityExothermite;
import xol.lostinfinity.util.damagesource.DeathMessage;

public class ItemExothermite
extends Item
implements IHotbarTick {
    public ItemExothermite(String regName) {
        this.func_77637_a(TabsInit.TAB_AUXMATS);
        this.setRegistryName(regName);
        this.func_77655_b(regName);
        this.func_77625_d(1);
        ItemInit.ITEMS.add(this);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack stack = playerIn.func_184586_b(handIn);
        if (!worldIn.field_72995_K) {
            EntityExothermite shot = new EntityExothermite(worldIn, (LivingEntity)playerIn);
            shot.setThrower((LivingEntity)playerIn);
            shot.setStack(stack.func_77946_l());
            shot.func_184538_a((Entity)playerIn, playerIn.field_70125_A, playerIn.field_70177_z, 0.0f, 2.0f, 0.0f);
            worldIn.func_72838_d((Entity)shot);
        }
        stack.func_190918_g(1);
        playerIn.func_184185_a(SoundEvents.field_187578_au, 1.0f, 1.0f);
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    @Override
    public void hotbarTick(Player player, int itemSlot, ItemStack stack) {
        if (this.showDurabilityBar(stack)) {
            long progress = stack.func_77978_p().func_74763_f("progress");
            UUID holderID = player.func_110124_au();
            if (stack.func_77978_p().func_74764_b("lastholder")) {
                if (!holderID.equals(stack.func_77978_p().func_186857_a("lastholder"))) {
                    stack.func_77978_p().func_186854_a("lastholder", holderID);
                    stack.func_77978_p().func_74768_a("damageramp", 0);
                }
            } else {
                stack.func_77978_p().func_186854_a("lastholder", holderID);
            }
            if (progress < (long)ItemExothermite.getDuration()) {
                stack.func_77978_p().func_74772_a("progress", ++progress);
                if (player.field_70173_aa % 40 == 0 && !player.field_70170_p.field_72995_K) {
                    float newHp = 0.0f;
                    int ramp = stack.func_77978_p().func_74762_e("damageramp");
                    float hpMulti = 0.05f * (float)ramp;
                    for (Player nearPlayer : player.field_70170_p.func_72872_a(Player.class, player.func_174813_aQ().func_186662_g(6.0))) {
                        newHp = nearPlayer.func_110143_aJ() - nearPlayer.func_110138_aP() * hpMulti;
                        if (newHp > 0.0f) {
                            nearPlayer.func_70606_j(newHp);
                            continue;
                        }
                        nearPlayer.func_70606_j(0.0f);
                        DeathMessage.broadcastDeathMessage(player.func_184102_h(), (Object)((Object)TextFmt.Red) + nearPlayer.func_70005_c_() + " melted.");
                    }
                    stack.func_77978_p().func_74768_a("damageramp", Math.min(15, ramp + 1));
                }
            } else if (!player.field_70170_p.field_72995_K) {
                player.func_145747_a((Component)new Component("This exothermite has cooled."));
                player.field_71071_by.func_70299_a(itemSlot, new ItemStack(ItemInit.exothermite, 1));
                player.field_70170_p.func_184133_a(null, player.func_180425_c(), SoundEvents.field_187659_cY, SoundSource.PLAYERS, 1.0f, 1.0f);
            }
        }
    }

    public boolean showDurabilityBar(ItemStack stack) {
        long progress;
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
            stack.func_77978_p().func_74772_a("progress", 0L);
        }
        return (progress = stack.func_77978_p().func_74763_f("progress")) <= (long)ItemExothermite.getDuration();
    }

    protected static int getDuration() {
        return 1000;
    }

    public double getDurabilityForDisplay(ItemStack stack) {
        if (this.showDurabilityBar(stack)) {
            double progress = stack.func_77978_p().func_74763_f("progress");
            double fin = progress / (double)ItemExothermite.getDuration();
            return 1.0 - Math.pow(fin, 1.0);
        }
        return 1.0;
    }
}

