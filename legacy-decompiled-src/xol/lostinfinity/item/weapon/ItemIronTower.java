/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.entity.player.ServerPlayer
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.Mth
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.common.network.simpleimpl.IMessage
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.item.weapon;

import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.common.packets.LostInfinityPacketHandler;
import xol.lostinfinity.common.packets.serverbound.PacketNBTSyncLong;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.classify.ICooldown;
import xol.lostinfinity.item.classify.IHitReactive;
import xol.lostinfinity.item.classify.IMaxReducible;

public class ItemIronTower
extends Item
implements IMaxReducible,
IHitReactive {
    public ItemIronTower(String regName) {
        this.func_77637_a(TabsInit.TAB_AUXWEP);
        this.setRegistryName(regName);
        this.func_77655_b(regName);
        ItemInit.ITEMS.add(this);
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Light_Purple) + "When held, reduces max health damage taken by 30%.");
        tooltip.add((Object)((Object)TextFmt.Aqua) + "When reducing damage, advance ALL cooldowns in your hotbar by 30%.");
    }

    @Override
    public float reduceMaxDamage(Player player, boolean isMainHand, float damage, float reductionMultiplier, ItemStack stack) {
        return reductionMultiplier - 0.3f;
    }

    @Override
    public void hitReaction(Player player, Entity attacker, float damage, ItemStack stack) {
        boolean didSound = false;
        if (damage > 0.0f) {
            for (int i = 0; i <= 8; ++i) {
                Item hotbarItem;
                ItemStack invyStack = player.field_71071_by.func_70301_a(i);
                if (!(invyStack.func_77973_b() instanceof ICooldown) || !(hotbarItem = invyStack.func_77973_b()).showDurabilityBar(invyStack)) continue;
                long storedTime = invyStack.func_77978_p().func_74763_f("lastUse");
                long currentTime = System.currentTimeMillis();
                double barProgress = 1.0 - hotbarItem.getDurabilityForDisplay(invyStack);
                long passedTime = currentTime - storedTime;
                int originalCD = Mth.func_76128_c((double)((double)passedTime / barProgress));
                int cooldownReduction = Mth.func_76128_c((double)((double)originalCD * 0.3));
                long replaceLong = storedTime - (long)cooldownReduction;
                invyStack.func_77978_p().func_74772_a("lastUse", replaceLong);
                LostInfinityPacketHandler.INSTANCE.sendTo((IMessage)new PacketNBTSyncLong("lastUse", replaceLong, invyStack), (ServerPlayer)player);
                didSound = true;
            }
        }
        if (didSound) {
            player.field_70170_p.func_184133_a(null, player.func_180425_c(), SoundInit.SHIELD_BLOCK, SoundSource.PLAYERS, 1.0f, 0.8f + player.field_70170_p.field_73012_v.nextFloat() * 0.4f);
            player.field_70170_p.func_184133_a(null, player.func_180425_c(), SoundInit.MAGIC_WEAPON_19, SoundSource.PLAYERS, 1.0f, 0.8f + player.field_70170_p.field_73012_v.nextFloat() * 0.4f);
        }
    }
}

