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
 *  net.minecraft.util.InteractionResultHolder
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.AABB
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
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemCooldown;
import xol.lostinfinity.item.classify.ICustomHoldPose;
import xol.lostinfinity.item.classify.ICustomRaytrace;
import xol.lostinfinity.mob.entity.contest.controller.EntityControllerLaserTag;
import xol.lostinfinity.util.coordinates.ContestCoordinates;
import xol.lostinfinity.util.data.CustomHitResult;

public class ItemLaserZapper
extends ItemCooldown
implements ICustomRaytrace,
ICustomHoldPose {
    public ItemLaserZapper(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_AUXWEP);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack stack = playerIn.func_184586_b(handIn);
        if (!this.showDurabilityBar(stack)) {
            if (!worldIn.field_72995_K) {
                Entity hitEntity;
                CustomHitResult trace_result = this.entityTrace(worldIn, (LivingEntity)playerIn, 60, Player.class);
                worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundInit.LASER_WEAPON_7, SoundSource.PLAYERS, 1.0f, 0.8f + worldIn.field_73012_v.nextFloat() * 0.4f);
                if (trace_result != null && (hitEntity = trace_result.getResultEntity()) != null) {
                    Player target = (Player)hitEntity;
                    AABB arena = ContestCoordinates.laserTagControllerAABB();
                    for (EntityControllerLaserTag controller : worldIn.func_72872_a(EntityControllerLaserTag.class, arena)) {
                        controller.hitPlayer(playerIn, target, 1);
                    }
                }
            }
            playerIn.func_184586_b(handIn).func_77978_p().func_74772_a("lastUse", System.currentTimeMillis());
        } else if (!worldIn.field_72995_K) {
            worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundInit.WEAPON_ERROR, SoundSource.PLAYERS, 1.0f, 0.9f + worldIn.field_73012_v.nextFloat() * 0.2f);
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    @Override
    protected int getCooldown() {
        return 3000;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
    }
}

