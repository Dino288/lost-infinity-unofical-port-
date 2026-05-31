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
 *  net.minecraft.util.SoundSource
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
import net.minecraft.sounds.SoundSource;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemCooldown;
import xol.lostinfinity.item.classify.IModeSelect;
import xol.lostinfinity.projectile.entity.EntityTitanRing;

public class ItemTitanRing
extends ItemCooldown
implements IModeSelect {
    public ItemTitanRing(String regName) {
        super(regName);
        this.func_77625_d(5);
        this.func_77637_a(TabsInit.TAB_AUXWEP);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack stack = playerIn.func_184586_b(handIn);
        if (!this.showDurabilityBar(stack)) {
            if (!worldIn.field_72995_K) {
                EntityTitanRing shot = new EntityTitanRing(worldIn, (LivingEntity)playerIn);
                shot.setThrower((LivingEntity)playerIn);
                int throwMode = stack.func_77978_p().func_74762_e("throw_mode");
                if (throwMode == 1) {
                    shot.setHighVelo();
                }
                shot.shootNoVel((Entity)playerIn, playerIn.field_70125_A, playerIn.field_70177_z, 0.0f, 2.0f + (float)(throwMode * 3), 0.0f);
                worldIn.func_72838_d((Entity)shot);
                worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundInit.GENERIC_WEAPON_19, SoundSource.PLAYERS, 0.2f + 0.5f * (float)throwMode, 0.6f + worldIn.field_73012_v.nextFloat() * 0.4f + 0.5f * (float)throwMode);
                worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundInit.GENERIC_WEAPON_20, SoundSource.PLAYERS, 0.2f, 0.7f + worldIn.field_73012_v.nextFloat() * 0.6f);
            }
            playerIn.func_184586_b(handIn).func_77978_p().func_74772_a("lastUse", System.currentTimeMillis());
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    @Override
    public void modeUpdate(ItemStack stack, Player player) {
        int throwMode;
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
            stack.func_77978_p().func_74768_a("throw_mode", 0);
        }
        if ((throwMode = stack.func_77978_p().func_74762_e("throw_mode")) == 0) {
            player.func_145747_a((Component)new Component((Object)((Object)TextFmt.Italic) + "High velocity throws enabled."));
            stack.func_77978_p().func_74768_a("throw_mode", 1);
        } else {
            player.func_145747_a((Component)new Component((Object)((Object)TextFmt.Italic) + "High velocity throws disabled."));
            stack.func_77978_p().func_74768_a("throw_mode", 0);
        }
    }

    @Override
    protected int getCooldown() {
        return 50;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Aqua) + "Throws out an unfolding, returning ring.");
        tooltip.add((Object)((Object)TextFmt.Gold) + "Can deploy as many rings as you can keep in the air.");
        tooltip.add((Object)((Object)TextFmt.Red) + "Deals 50% Health True Damage");
        tooltip.add((Object)((Object)TextFmt.Yellow) + "Hits increase shock level on target, adding 25% Health True Damage per stack");
        tooltip.add((Object)((Object)TextFmt.Italic) + "Can enable high velocity throws, throwing faster rings but dealing 30% less damage.");
        tooltip.add((Object)((Object)TextFmt.Dark_Aqua) + "Aquatic, Darkborn");
    }
}

