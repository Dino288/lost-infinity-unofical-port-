/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.entity.player.ServerPlayer
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.InteractionResultHolder
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.item.weapon;

import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.common.lostinfinity;
import xol.lostinfinity.common.packets.clientbound.PacketSetControlled;
import xol.lostinfinity.common.special.CommonMindControlHandler;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemCooldown;
import xol.lostinfinity.item.classify.ICustomRaytrace;
import xol.lostinfinity.item.classify.IHeldTick;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.CustomHitResult;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class ItemPuppetMaster
extends ItemCooldown
implements IHeldTick,
ICustomRaytrace {
    public ItemPuppetMaster(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_AUXWEP);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack stack = playerIn.func_184586_b(handIn);
        if (!this.showDurabilityBar(stack)) {
            ServerPlayer oldTarget;
            ServerPlayer target;
            CustomHitResult result;
            if (!worldIn.field_72995_K && CommonMindControlHandler.getControllerOfPlayer(playerIn) == null && (result = this.entityTrace(worldIn, (LivingEntity)playerIn, 60, Player.class)) != null && (target = (ServerPlayer)result.getResultEntity()) != (oldTarget = (ServerPlayer)CommonMindControlHandler.getTargetOfPlayer(playerIn))) {
                worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundInit.MIND_CONTROL, SoundSource.PLAYERS, 0.7f, 1.0f);
                worldIn.func_184133_a(null, target.func_180425_c(), SoundInit.ENTITY_POSSESS, SoundSource.PLAYERS, 1.5f, 1.0f);
                if (oldTarget != null) {
                    CommonMindControlHandler.unregisterPair(playerIn, (Player)oldTarget);
                    lostinfinity.instance.packetHandler.sendToPlayer(oldTarget, new PacketSetControlled());
                }
                CommonMindControlHandler.registerPair(playerIn, (Player)target);
                lostinfinity.instance.packetHandler.sendToPlayer(target, new PacketSetControlled(CommonMindControlHandler.State.CONTROLLED));
                lostinfinity.instance.packetHandler.sendToPlayer((ServerPlayer)playerIn, new PacketSetControlled(CommonMindControlHandler.State.CONTROLLING));
                CustomParticleConfig config1 = new CustomParticleConfig();
                config1.createInstance().setParticle(ParticleInit.WATCHING_EYE).setSpread(0.0, 0.0, 0.0).setCount(1).setIgnoreRange(true);
                IParticleSpawner.spawnParticle(worldIn, config1, target.field_70165_t, target.field_70163_u + (double)target.field_70131_O + 0.5, target.field_70161_v);
            }
            playerIn.func_184586_b(handIn).func_77978_p().func_74772_a("lastUse", System.currentTimeMillis());
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    @Override
    public void stopHolding(Player player, InteractionHand hand, ItemStack stack) {
        Player target = CommonMindControlHandler.getTargetOfPlayer(player);
        if (target != null) {
            CommonMindControlHandler.unregisterPair(player, target);
            lostinfinity.instance.packetHandler.sendToPlayer((ServerPlayer)target, new PacketSetControlled());
            lostinfinity.instance.packetHandler.sendToPlayer((ServerPlayer)player, new PacketSetControlled());
        }
    }

    @Override
    protected int getCooldown() {
        return 50;
    }

    @Override
    public void heldTick(Player player, InteractionHand hand, ItemStack stack) {
        if (!player.field_70170_p.field_72995_K) {
            Player target = CommonMindControlHandler.getTargetOfPlayer(player);
            float growthDist = 3.0f;
            float rotation = player.field_70173_aa / 10;
            double velocity_x = (double)growthDist * Math.cos(rotation);
            double velocity_z = (double)growthDist * Math.sin(rotation);
            if (target != null) {
                CustomParticleConfig config = new CustomParticleConfig();
                config.createInstance().setParticle(ParticleInit.BAD_MAGIC).setIgnoreRange(true);
                IParticleSpawner.spawnParticle(player.field_70170_p, config, target.func_174791_d().func_72441_c(velocity_x / 2.0, 0.0, velocity_z / 2.0));
            }
        }
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Gold) + "Takes control of a target player.");
        tooltip.add((Object)((Object)TextFmt.Aqua) + "While you are holding this item, you remain in control of their body.");
    }
}

