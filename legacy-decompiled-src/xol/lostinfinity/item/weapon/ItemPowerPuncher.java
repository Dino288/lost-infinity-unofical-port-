/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.potion.Potion
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.InteractionResultHolder
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Mth
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.item.weapon;

import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.PotionInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemCooldown;
import xol.lostinfinity.item.classify.ICustomHoldPose;
import xol.lostinfinity.item.classify.ICustomRaytrace;
import xol.lostinfinity.item.classify.IMoveTick;
import xol.lostinfinity.item.classify.IMovingSoundSource;
import xol.lostinfinity.item.classify.ITransfusionEffect;
import xol.lostinfinity.mob.entity.misc.EntityBaseRift;
import xol.lostinfinity.util.data.CustomHitResult;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class ItemPowerPuncher
extends ItemCooldown
implements IMaxAttack,
ICustomRaytrace,
ICustomHoldPose,
IMoveTick,
ITransfusionEffect,
IMovingSoundSource {
    public ItemPowerPuncher(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_AUXWEP);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack stack = playerIn.func_184586_b(handIn);
        if (!this.showDurabilityBar(stack)) {
            if (!worldIn.field_72995_K) {
                CustomHitResult trace_result = this.forcedDistanceTrace(worldIn, (Entity)playerIn, 75);
                if (trace_result != null) {
                    Vec3 resultVec = trace_result.getResultVector();
                    stack.func_77978_p().func_74780_a("TargetDist", playerIn.func_70011_f(resultVec.field_72450_a, resultVec.field_72448_b, resultVec.field_72449_c) / 8.0);
                    stack.func_77978_p().func_74780_a("TargetX", resultVec.field_72450_a);
                    stack.func_77978_p().func_74780_a("TargetY", resultVec.field_72448_b);
                    stack.func_77978_p().func_74780_a("TargetZ", resultVec.field_72449_c);
                    playerIn.func_70690_d(new PotionEffect(PotionInit.SUPERSONIC, 60));
                    playerIn.func_70690_d(new PotionEffect(PotionInit.TRANSFUSION, 60));
                }
                this.playSoundAround(SoundInit.SUPERSONIC_DASH, SoundSource.PLAYERS, (Entity)playerIn, 5.0f, 0.7f + worldIn.field_73012_v.nextFloat() * 0.6f, false, 0);
            } else {
                this.playSound(SoundInit.SUPERSONIC_DASH, SoundSource.PLAYERS, MOVING, 0.7f, 0.7f + worldIn.field_73012_v.nextFloat() * 0.6f);
            }
            playerIn.func_184586_b(handIn).func_77978_p().func_74772_a("lastUse", System.currentTimeMillis());
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    @Override
    protected int getCooldown() {
        return 600;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Aqua) + "Dashes where you are looking towards.");
        tooltip.add((Object)((Object)TextFmt.Gold) + "Dashing past entities steals their buffs.");
        tooltip.add((Object)((Object)TextFmt.Red) + "Deal 20% Health True Damage Per Buff Stolen");
        tooltip.add((Object)((Object)TextFmt.Underline) + "Dashes close nearby dimensional anomalies.");
    }

    @Override
    public void moveTick(Player player, InteractionHand hand, ItemStack stack) {
        if (this.isTravelling(stack) && !player.field_70170_p.field_72995_K) {
            Vec3 targetPos = new Vec3(stack.func_77978_p().func_74769_h("TargetX"), stack.func_77978_p().func_74769_h("TargetY"), stack.func_77978_p().func_74769_h("TargetZ"));
            Vec3 dir = targetPos.func_178788_d(player.func_174791_d()).func_72432_b();
            double dist = targetPos.func_72438_d(player.func_174791_d());
            double mult = Mth.func_151237_a((double)(dist / 14.0), (double)(player.field_70122_E ? 3.0 : 1.0), (double)7.0);
            if (dist > 2.0) {
                player.field_70159_w = dir.field_72450_a * mult;
                player.field_70181_x = dir.field_72448_b * mult;
                player.field_70179_y = dir.field_72449_c * mult;
                player.field_70133_I = true;
                if (dist > 2.0) {
                    float rYaw = player.field_70177_z * ((float)Math.PI / 180);
                    float x = -Mth.func_76126_a((float)rYaw);
                    float z = Mth.func_76134_b((float)rYaw);
                    Vec3 look = player.func_174791_d().func_178788_d(new Vec3(dir.field_72450_a * mult, dir.field_72448_b * mult, dir.field_72449_c * mult));
                    IParticleSpawner.spawnParticle(player.field_70170_p, 58, 0, look.field_72450_a, look.field_72448_b + 1.0, look.field_72449_c);
                }
            } else {
                stack.func_77978_p().func_82580_o("TargetX");
                stack.func_77978_p().func_82580_o("TargetY");
                stack.func_77978_p().func_82580_o("TargetZ");
                player.field_70159_w = 0.0;
                player.field_70179_y = 0.0;
                player.field_70181_x = 0.0;
                player.field_70133_I = true;
                player.func_184589_d(PotionInit.TRANSFUSION);
                player.func_184589_d(PotionInit.SUPERSONIC);
            }
            for (EntityBaseRift rift : player.field_70170_p.func_72872_a(EntityBaseRift.class, player.func_174813_aQ().func_186662_g(4.0))) {
                rift.func_70106_y();
            }
            Iterable nearblocks = BlockPos.func_177980_a((BlockPos)player.func_180425_c().func_177982_a(-4, -4, -4), (BlockPos)player.func_180425_c().func_177982_a(4, 4, 4));
            for (BlockPos nearpos : nearblocks) {
                if (player.field_70170_p.func_180495_p(nearpos).func_177230_c() != BlockInit.cosmicFracture) continue;
                player.field_70170_p.func_175698_g(nearpos);
            }
        }
    }

    @Override
    public void transfuse(Player player, LivingEntity stolenFrom, InteractionHand hand, ItemStack stack, List<Potion> potionsStolen) {
        IMaxAttack.dealTrueDamage((Entity)player, stolenFrom, stolenFrom.func_110138_aP() * (0.2f * (float)potionsStolen.size()));
        stolenFrom.field_70170_p.func_184133_a(player, stolenFrom.func_180425_c(), SoundInit.SUPERSONIC_DASH, SoundSource.PLAYERS, 0.7f, 0.7f + stolenFrom.field_70170_p.field_73012_v.nextFloat() * 0.6f);
    }

    public boolean isTravelling(ItemStack stack) {
        return stack.func_77942_o() && stack.func_77978_p().func_74764_b("TargetX") && stack.func_77978_p().func_74764_b("TargetY") && stack.func_77978_p().func_74764_b("TargetZ");
    }
}

