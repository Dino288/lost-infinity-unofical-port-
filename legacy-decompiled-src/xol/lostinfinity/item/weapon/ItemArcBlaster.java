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
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemCooldown;
import xol.lostinfinity.item.classify.ICustomHoldPose;
import xol.lostinfinity.item.weapon.ItemArcOfTheForbidden;
import xol.lostinfinity.projectile.entity.EntityArcBlast;
import xol.lostinfinity.util.data.IMaxAttack;

public class ItemArcBlaster
extends ItemCooldown
implements IMaxAttack,
ICustomHoldPose {
    public ItemArcBlaster(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_AUXWEP);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack stack;
        if (handIn == InteractionHand.MAIN_HAND && !this.showDurabilityBar(stack = playerIn.func_184586_b(handIn))) {
            boolean hasOffhand;
            if (!worldIn.field_72995_K) {
                EntityArcBlast shot = new EntityArcBlast(worldIn, (LivingEntity)playerIn);
                shot.setThrower((LivingEntity)playerIn);
                shot.func_184538_a((Entity)playerIn, playerIn.field_70125_A, playerIn.field_70177_z, 0.0f, 4.0f, 0.0f);
                worldIn.func_72838_d((Entity)shot);
                worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundInit.LASER_WEAPON_7, SoundSource.PLAYERS, 0.7f, 0.7f + worldIn.field_73012_v.nextFloat() * 0.6f);
            }
            boolean bl = hasOffhand = playerIn.func_184592_cb().func_77973_b() instanceof ItemArcBlaster || playerIn.func_184592_cb().func_77973_b() instanceof ItemArcOfTheForbidden;
            if (hasOffhand) {
                stack.func_77978_p().func_74768_a("ComplexCooldown", 100);
            } else {
                stack.func_77978_p().func_74768_a("ComplexCooldown", 500);
            }
            playerIn.func_184586_b(handIn).func_77978_p().func_74772_a("lastUse", System.currentTimeMillis());
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    @Override
    protected boolean hasSimpleCooldown() {
        return false;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Light_Purple) + "Shoots an electric attack.");
        tooltip.add((Object)((Object)TextFmt.Gold) + "Attack deals 75% maximum health and applies shock.");
        tooltip.add((Object)((Object)TextFmt.Gold) + "If shock is already applied, deal 125% damage instead and consume the shock.");
    }
}

