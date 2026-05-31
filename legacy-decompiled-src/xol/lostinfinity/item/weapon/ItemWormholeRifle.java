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
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.util.InteractionResultHolder
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
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
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.phys.Vec3;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemChanneling;
import xol.lostinfinity.item.classify.IModeSelect;
import xol.lostinfinity.mob.entity.misc.EntityWormholePortal;

public class ItemWormholeRifle
extends ItemChanneling
implements IModeSelect {
    public ItemWormholeRifle(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_AUXWEP);
    }

    @Override
    public void modeUpdate(ItemStack stack, Player player) {
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
        }
        if (!this.showDurabilityBar(stack) && !ItemChanneling.isChanneling((LivingEntity)player, stack)) {
            int type = stack.func_77978_p().func_74762_e("usetype_data");
            int newType = type < 4 ? type + 1 : 0;
            stack.func_77978_p().func_74768_a("usetype_data", newType);
            if (!player.field_70170_p.field_72995_K) {
                player.func_145747_a((Component)new Component("Portal Range: " + (newType + 1) * 10));
            }
        }
    }

    @Override
    public InteractionResultHolder<ItemStack> chargeStart(Level worldIn, Player player, InteractionHand handIn, ItemStack stack) {
        if (!worldIn.field_72995_K) {
            EntityWormholePortal firstPortal = new EntityWormholePortal(worldIn);
            Vec3 look = player.func_70040_Z().func_72432_b();
            Vec3 sideVec = player.func_70040_Z().func_178785_b(1.5707964f);
            int range = (stack.func_77978_p().func_74762_e("usetype_data") + 1) * 10;
            Vec3 firstPortalPos = player.func_174791_d().func_72441_c(-sideVec.field_72450_a / 3.0, (double)player.field_70131_O / 1.1, -sideVec.field_72449_c / 3.0).func_72441_c(look.field_72450_a, 0.0, look.field_72449_c);
            Vec3 secondPortalPos = firstPortalPos.func_178787_e(look.func_186678_a((double)range));
            firstPortal.func_70634_a(firstPortalPos.field_72450_a, firstPortalPos.field_72448_b, firstPortalPos.field_72449_c);
            firstPortal.setCaster(player);
            firstPortal.setPlayerLook(player.func_70040_Z());
            worldIn.func_72838_d((Entity)firstPortal);
            EntityWormholePortal secondPortal = new EntityWormholePortal(worldIn);
            secondPortal.func_70634_a(secondPortalPos.field_72450_a, secondPortalPos.field_72448_b, secondPortalPos.field_72449_c);
            secondPortal.setCaster(player);
            secondPortal.setPlayerLook(player.func_70040_Z());
            secondPortal.setShoot();
            worldIn.func_72838_d((Entity)secondPortal);
        }
        return super.chargeStart(worldIn, player, handIn, stack);
    }

    @Override
    protected int getCooldown() {
        return 500;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Gold) + "Shoots rapid fire wormhole travelling bullets.");
        tooltip.add((Object)((Object)TextFmt.Italic) + "Wormhole distance can be set by adjusting item mode.");
        tooltip.add((Object)((Object)TextFmt.Red) + "Each bullet does 50% Max Health Damage");
        tooltip.add((Object)((Object)TextFmt.Italic) + "Deals True Damage to targets below 25% Life.");
        tooltip.add((Object)((Object)TextFmt.Dark_Aqua) + "Darkborn");
    }
}

