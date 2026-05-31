/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.InteractionResultHolder
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.world.World
 */
package xol.lostinfinity.item.weapon;

import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemCooldown;
import xol.lostinfinity.item.classify.ISummon;
import xol.lostinfinity.mob.entity.minion.EntityAuraOfAllegiance;
import xol.lostinfinity.mob.entity.minion.EntityMinion;

public class ItemAuraOfAllegiance
extends ItemCooldown
implements ISummon {
    public ItemAuraOfAllegiance(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_AUXWEP);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack stack = playerIn.func_184586_b(handIn);
        if (!this.showDurabilityBar(stack)) {
            if (!worldIn.field_72995_K) {
                boolean shouldDespawn = false;
                EntityAuraOfAllegiance aura = null;
                Set minionSet = this.getCurrentMinion(playerIn);
                for (EntityMinion minion : minionSet) {
                    if (minion instanceof EntityAuraOfAllegiance) {
                        aura = (EntityAuraOfAllegiance)minion;
                    } else {
                        shouldDespawn = true;
                    }
                    if (aura == null || !shouldDespawn) continue;
                    break;
                }
                if (shouldDespawn) {
                    this.despawnPrevious(playerIn);
                }
                if (aura == null) {
                    aura = new EntityAuraOfAllegiance(worldIn);
                    aura.setOwner(playerIn);
                    aura.setHand(handIn);
                    aura.setLastSlot(playerIn.field_71071_by.field_70461_c);
                    aura.setTrackedItemStack(stack);
                    aura.func_70107_b(playerIn.field_70165_t, playerIn.field_70163_u, playerIn.field_70161_v);
                    aura.setLives(2);
                    worldIn.func_72838_d((Entity)aura);
                } else {
                    aura.addLives(2);
                }
                worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundInit.MAGIC_WEAPON_16, SoundSource.PLAYERS, 1.5f, 0.7f + worldIn.field_73012_v.nextFloat() * 0.6f);
            }
            this.startCooldown(stack);
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    @Override
    protected int getCooldown() {
        return 4000;
    }

    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Gold) + "Summon the Lost Infinity Stones to protect you.");
        tooltip.add((Object)((Object)TextFmt.Italic) + "Each use creates 2 more stones, up to 6 maximum.");
        tooltip.add((Object)((Object)TextFmt.Green) + "While the stones are active, you take no Max Health and True damage, at the cost of losing 1 stone.");
    }
}

