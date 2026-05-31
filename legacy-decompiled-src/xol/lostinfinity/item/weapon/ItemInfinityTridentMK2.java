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
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.classify.ISwitchModels;
import xol.lostinfinity.projectile.entity.EntityInfinityTrident;
import xol.lostinfinity.projectile.entity.EntityInfinityTridentMK2;

public class ItemInfinityTridentMK2
extends Item
implements ISwitchModels {
    public ItemInfinityTridentMK2(String regName) {
        this.func_77637_a(TabsInit.TAB_AUXWEP);
        this.setRegistryName(regName);
        this.func_77655_b(regName);
        this.func_77625_d(1);
        this.setModelSwitch("empty", this, 2);
        ItemInit.ITEMS.add(this);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack stack = playerIn.func_184586_b(handIn);
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
        }
        int mode = stack.func_77978_p().func_74762_e("empty_data");
        int essence = stack.func_77978_p().func_74762_e("essence");
        if (mode == 0) {
            if (essence >= 10) {
                stack.func_77978_p().func_74768_a("essence", 0);
                if (!worldIn.field_72995_K) {
                    EntityInfinityTridentMK2 shot = new EntityInfinityTridentMK2(worldIn, (LivingEntity)playerIn);
                    shot.setThrower((LivingEntity)playerIn);
                    shot.func_184538_a((Entity)playerIn, playerIn.field_70125_A, playerIn.field_70177_z, 0.0f, 2.0f, 0.0f);
                    worldIn.func_72838_d((Entity)shot);
                    worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundEvents.field_187737_v, SoundSource.PLAYERS, 1.0f, 1.0f);
                }
            } else if (!worldIn.field_72995_K) {
                EntityInfinityTrident shot = new EntityInfinityTrident(worldIn, (LivingEntity)playerIn);
                shot.setThrower((LivingEntity)playerIn);
                shot.setUpgraded();
                shot.setEssence(essence);
                shot.func_184538_a((Entity)playerIn, playerIn.field_70125_A, playerIn.field_70177_z, 0.0f, 2.0f, 0.0f);
                worldIn.func_72838_d((Entity)shot);
                worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundEvents.field_187737_v, SoundSource.PLAYERS, 1.0f, 1.0f);
            }
            stack.func_77978_p().func_74768_a("empty_data", 1);
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
        }
        tooltip.add((Object)((Object)TextFmt.Aqua) + "Throws out a returning trident.");
        tooltip.add((Object)((Object)TextFmt.Red) + "Deals 100% Health True Damage");
        tooltip.add((Object)((Object)TextFmt.Green) + "Builds up essence on each hit. At full essence, the next attack will chain between all nearby enemies");
        tooltip.add((Object)((Object)TextFmt.Dark_Purple) + String.format("%d essence stored", stack.func_77978_p().func_74762_e("essence")));
        tooltip.add((Object)((Object)TextFmt.Dark_Aqua) + "Aquatic");
    }
}

