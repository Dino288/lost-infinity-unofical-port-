/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.entity.player.ServerPlayer
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.InteractionResultHolder
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.Mth
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.world.World
 */
package xol.lostinfinity.item.weapon;

import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.AABB;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.common.lostinfinity;
import xol.lostinfinity.common.packets.clientbound.PacketHeadHunterUpdate;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemCooldown;
import xol.lostinfinity.item.classify.ICustomHoldPose;
import xol.lostinfinity.item.classify.IHeldTick;
import xol.lostinfinity.util.data.IMaxAttack;

public class ItemHeadHunter
extends ItemCooldown
implements ICustomHoldPose,
IHeldTick {
    public ItemHeadHunter(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_AUXWEP);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack stack = playerIn.func_184586_b(handIn);
        if (!this.showDurabilityBar(stack)) {
            if (!worldIn.field_72995_K) {
                Vec3 eye = playerIn.func_174824_e(1.0f);
                Vec3 dir = playerIn.func_70040_Z();
                for (Player player : worldIn.func_73046_m().func_184103_al().func_181057_v()) {
                    Vec3 delta;
                    double lSqr;
                    if (player == playerIn || (lSqr = (delta = eye.func_178788_d(player.func_174824_e(1.0f))).func_189985_c()) > 250000.0) continue;
                    AABB closerBB = player.func_174813_aQ();
                    double distance = lSqr * Mth.func_181161_i((double)lSqr);
                    if (distance > 5.0) {
                        Vec3 closer = delta.func_186678_a((distance - 5.0) / distance);
                        closerBB = closerBB.func_191194_a(closer);
                        distance = 5.0;
                    }
                    Vec3 tracePoint = eye.func_178787_e(dir.func_186678_a(distance));
                    if (!closerBB.func_186668_a(tracePoint.field_72450_a - 0.3, tracePoint.field_72448_b - 0.3, tracePoint.field_72449_c - 0.3, tracePoint.field_72450_a + 0.3, tracePoint.field_72448_b + 0.3, tracePoint.field_72449_c + 0.3)) continue;
                    IMaxAttack.dealTrueDamage((Entity)playerIn, (LivingEntity)player, player.func_110138_aP() * 2.0f);
                }
                worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundInit.GENERIC_WEAPON_9, SoundSource.PLAYERS, 1.0f, 0.7f + worldIn.field_73012_v.nextFloat() * 0.6f);
            }
            this.startCooldown(stack);
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    @Override
    public void heldTick(Player player, InteractionHand hand, ItemStack stack) {
        if (player.field_70170_p.field_72995_K) {
            return;
        }
        for (Player other : player.field_70170_p.func_73046_m().func_184103_al().func_181057_v()) {
            if (other == player) continue;
            lostinfinity.instance.packetHandler.sendToPlayer((ServerPlayer)player, new PacketHeadHunterUpdate(other));
        }
    }

    @Override
    protected int getCooldown() {
        return 1000;
    }

    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Red) + "Shoot a bullet that travels in the 4th dimension.");
        tooltip.add((Object)((Object)TextFmt.Gold) + "While holding this gun, you can sense the location of other players.");
        tooltip.add((Object)((Object)TextFmt.Red) + "Dimensional bullets deal 200% Health True Damage");
    }
}

