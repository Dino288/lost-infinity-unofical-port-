/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.util.InteractionResultHolder
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.EnumParticleTypes
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.item.weapon;

import java.util.List;
import java.util.Random;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.Vec3;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.common.lostinfinity;
import xol.lostinfinity.common.packets.serverbound.PacketTextTitle;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.util.data.IMaxAttack;

public class ItemLifeVessel
extends Item
implements IMaxAttack {
    public ItemLifeVessel(String regName) {
        this.func_77637_a(TabsInit.TAB_INFINITYWEP);
        this.setRegistryName(regName);
        this.func_77655_b(regName);
        ItemInit.ITEMS.add(this);
    }

    private void sendSubtitleToPlayer(Player player, String string) {
        lostinfinity.instance.packetHandler.sendTitleToPlayer(new PacketTextTitle(true, false, 40, 20, 20, ""), player);
        lostinfinity.instance.packetHandler.sendTitleToPlayer(new PacketTextTitle(false, true, 40, 20, 20, string + "."), player);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        boolean charged;
        ItemStack stack = playerIn.func_184586_b(handIn);
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
            stack.func_77978_p().func_74776_a("charge", 0.0f);
        }
        boolean bl = charged = stack.func_77978_p().func_74760_g("charge") == 100.0f;
        if (charged) {
            if (playerIn.func_70093_af()) {
                worldIn.func_184133_a(null, new BlockPos(playerIn.field_70165_t, playerIn.field_70163_u, playerIn.field_70161_v), SoundInit.LIFEVESSEL_DAMAGE, SoundSource.MASTER, 3.0f, 1.0f);
                for (LivingEntity detected_player : worldIn.func_72872_a(LivingEntity.class, playerIn.func_174813_aQ().func_72314_b(20.0, 10.0, 20.0))) {
                    double zboost;
                    if (detected_player.func_110124_au().equals(playerIn.func_110124_au())) continue;
                    IMaxAttack.dealMaxHealth((Entity)playerIn, detected_player, 10, 7.0f);
                    if (!(detected_player.field_70159_w <= 7.0) || !(detected_player.field_70159_w >= -7.0) || !(detected_player.field_70179_y <= 7.0) || !(detected_player.field_70179_y >= -7.0)) continue;
                    double xboost = Math.signum(playerIn.field_70165_t - detected_player.field_70165_t) * -5.0;
                    for (zboost = Math.signum(playerIn.field_70161_v - detected_player.field_70161_v) * -5.0; xboost > 7.0 || zboost > 7.0 || xboost < -7.0 || zboost < -7.0; xboost *= 0.98, zboost *= 0.98) {
                    }
                    detected_player.func_70024_g(xboost, 1.0, zboost);
                    detected_player.field_70133_I = true;
                }
                stack.func_77978_p().func_74776_a("charge", 0.0f);
            } else {
                worldIn.func_184133_a(null, new BlockPos(playerIn.field_70165_t, playerIn.field_70163_u, playerIn.field_70161_v), SoundInit.LIFEVESSEL_HEAL, SoundSource.MASTER, 3.0f, 1.0f);
                if (playerIn.func_110143_aJ() != playerIn.func_110138_aP()) {
                    playerIn.func_70606_j(playerIn.func_110138_aP());
                    for (int i = 0; i < 20; ++i) {
                        Vec3 pos = playerIn.func_174791_d();
                        Random rand = playerIn.field_70170_p.field_73012_v;
                        if (!playerIn.field_70170_p.field_72995_K) continue;
                        playerIn.field_70170_p.func_175688_a(EnumParticleTypes.HEART, pos.field_72450_a + (double)(rand.nextFloat() * playerIn.field_70130_N * 2.0f) - (double)playerIn.field_70130_N, pos.field_72448_b + 0.5 + (double)(rand.nextFloat() * playerIn.field_70131_O), pos.field_72449_c + (double)(rand.nextFloat() * playerIn.field_70130_N * 2.0f) - (double)playerIn.field_70130_N, 0.0, 0.0, 0.0, new int[0]);
                    }
                    if (playerIn.field_70170_p.field_72995_K) {
                        playerIn.func_146105_b((Component)new Component((Object)((Object)TextFmt.Light_Purple) + "Your life force has been replenished"), true);
                    }
                    stack.func_77978_p().func_74776_a("charge", 0.0f);
                } else if (playerIn.field_70170_p.field_72995_K) {
                    playerIn.func_146105_b((Component)new Component((Object)((Object)TextFmt.Red) + "You are already at full health."), true);
                }
            }
        } else {
            this.sendSubtitleToPlayer(playerIn, (Object)((Object)TextFmt.Red) + "You do not have enough charge to perform this action.");
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
            stack.func_77978_p().func_74776_a("charge", 0.0f);
        }
        if (entity instanceof Player) {
            boolean charged = stack.func_77978_p().func_74760_g("charge") == 100.0f;
            boolean hasTarget = stack.func_77978_p().func_186855_b("target");
            if (!hasTarget && charged) {
                Player target = (Player)entity;
                Player[] players = new Player[]{player, target};
                for (int i = 0; i < players.length; ++i) {
                    Vec3 playerVector = players[i].func_174791_d();
                    boolean radius = true;
                    for (int f = 0; f < 360; ++f) {
                        double angle = (double)f * Math.PI / 180.0;
                        double x = (double)radius * Math.cos(angle);
                        double z = (double)radius * Math.sin(angle);
                        Vec3 loc = playerVector.func_72441_c(x, 1.0, z);
                        players[i].field_70170_p.func_175688_a(EnumParticleTypes.REDSTONE, loc.field_72450_a, loc.field_72448_b, loc.field_72449_c, 0.0, 0.0, 0.0, new int[0]);
                    }
                }
                stack.func_77978_p().func_186854_a("target", target.func_110124_au());
                stack.func_77978_p().func_74778_a("targetName", target.getDisplayNameString());
                stack.func_77978_p().func_74776_a("charge", 0.0f);
                player.field_70170_p.func_184133_a(null, new BlockPos(player.field_70165_t, player.field_70163_u, player.field_70161_v), SoundInit.LIFEVESSEL_BIND, SoundSource.MASTER, 3.0f, 1.0f);
                if (player.field_70170_p.field_72995_K) {
                    player.func_146105_b((Component)new Component((Object)((Object)TextFmt.Light_Purple) + target.getDisplayNameString() + " has been bound to this vessel"), true);
                } else {
                    target.func_146105_b((Component)new Component(TextFmt.getFormatting(TextFmt.Black, TextFmt.Bold, TextFmt.Obfuscated) + "&& " + (Object)((Object)TextFmt.Reset) + TextFmt.getFormatting(TextFmt.Dark_Red, TextFmt.Bold) + "Your soul has been bound to " + player.getDisplayNameString() + TextFmt.getFormatting(TextFmt.Black, TextFmt.Bold, TextFmt.Obfuscated) + " &&"), true);
                }
                player.func_184185_a(SoundEvents.field_193781_bp, 1.0f, 1.0f);
                target.func_184185_a(SoundEvents.field_193781_bp, 1.0f, 1.0f);
                return true;
            }
            if (hasTarget) {
                if (player.field_70170_p.field_72995_K) {
                    this.sendSubtitleToPlayer(player, (Object)((Object)TextFmt.Red) + "You already have a victim bound to you.");
                }
            } else if (!charged && player.field_70170_p.field_72995_K) {
                this.sendSubtitleToPlayer(player, (Object)((Object)TextFmt.Red) + "You do not have enough charge to perform this action.");
            }
        }
        return false;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Gold) + "While in hotbar this charges when you take max health damage.");
        tooltip.add((Object)((Object)TextFmt.Gold) + "Current Charge: 0%");
        tooltip.add((Object)((Object)TextFmt.Green) + "Right Click: Heal to full.");
        tooltip.add((Object)((Object)TextFmt.Dark_Purple) + "Shift Right Click: Deal 70% max hp to anything in range, uses all charge.");
        tooltip.add((Object)((Object)TextFmt.Yellow) + "Attack: Bind a player. They take damage on your behalf until their untimely passing.");
        tooltip.add((Object)((Object)TextFmt.Gray) + "Currently Bound To: Nobody");
        if (stack.func_77942_o() && worldIn != null) {
            for (int i = 0; i < tooltip.size(); ++i) {
                String str = tooltip.get(i);
                if (str.contains("Current Charge:")) {
                    tooltip.set(i, (Object)((Object)TextFmt.Gold) + "Current Charge: " + Math.round(stack.func_77978_p().func_74760_g("charge")) + "%");
                    continue;
                }
                if (!str.contains("Bound To:") || !stack.func_77978_p().func_186855_b("target")) continue;
                tooltip.set(i, (Object)((Object)TextFmt.Red) + "Currently Bound To: " + stack.func_77978_p().func_74779_i("targetName"));
            }
        }
    }
}

