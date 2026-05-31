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
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
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
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemCooldown;
import xol.lostinfinity.item.classify.ICustomHoldPose;
import xol.lostinfinity.item.classify.IHeldTick;
import xol.lostinfinity.item.classify.IModeSelect;
import xol.lostinfinity.item.classify.ISwitchModels;
import xol.lostinfinity.projectile.entity.EntitySelectionLaser;
import xol.lostinfinity.util.data.IMaxAttack;

public class ItemRayOfSelection
extends ItemCooldown
implements IMaxAttack,
ISwitchModels,
IHeldTick,
IModeSelect,
ICustomHoldPose {
    public ItemRayOfSelection(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_INFINITYWEP);
        this.setModelSwitch("characters", this, 4);
    }

    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return false;
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack stack = playerIn.func_184586_b(handIn);
        if (!this.showDurabilityBar(stack)) {
            if (!worldIn.field_72995_K) {
                EntitySelectionLaser shot = new EntitySelectionLaser(worldIn, (LivingEntity)playerIn);
                shot.setThrower((LivingEntity)playerIn);
                shot.setSelectionType(stack.func_77978_p().func_74762_e("characters_data"));
                shot.func_184538_a((Entity)playerIn, playerIn.field_70125_A, playerIn.field_70177_z, 0.0f, 1.0f, 0.0f);
                worldIn.func_72838_d((Entity)shot);
            }
            playerIn.func_184185_a(SoundInit.LASER_WEAPON_4, 1.0f, 1.0f);
            stack.func_77978_p().func_74772_a("lastUse", System.currentTimeMillis());
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    @Override
    protected int getCooldown() {
        return 500;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Light_Purple) + "Right Click: Toggle cycling through groups of characters.");
        tooltip.add((Object)((Object)TextFmt.Red) + "When shooting an entity who's name begins with a character in the group:");
        tooltip.add((Object)((Object)TextFmt.Green) + "Deal 150% maximum life damage to the entity.");
    }

    @Override
    public void heldTick(Player player, InteractionHand hand, ItemStack stack) {
        if (stack.func_77942_o() && stack.func_77978_p().func_74764_b("cycling_style") && player.field_70173_aa % 5 == 0 && stack.func_77978_p().func_74767_n("cycling_style")) {
            int data = stack.func_77978_p().func_74762_e("characters_data");
            data = data < 3 ? ++data : 0;
            player.field_70170_p.func_184133_a(null, player.func_180425_c(), SoundInit.GENERIC_WEAPON_3, SoundSource.MASTER, 1.0f, 0.9f + player.field_70170_p.field_73012_v.nextFloat() * 0.2f);
            stack.func_77978_p().func_74768_a("characters_data", data);
        }
    }

    @Override
    public void modeUpdate(ItemStack stack, Player player) {
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
            stack.func_77978_p().func_74757_a("cycling_style", true);
            stack.func_77978_p().func_74768_a("characters_data", 0);
        } else {
            stack.func_77978_p().func_74757_a("cycling_style", !stack.func_77978_p().func_74767_n("cycling_style"));
        }
        if (!player.field_70170_p.field_72995_K) {
            player.field_70170_p.func_184133_a(null, player.func_180425_c(), SoundEvents.field_187556_aj, SoundSource.MASTER, 1.0f, 1.0f);
        }
    }
}

