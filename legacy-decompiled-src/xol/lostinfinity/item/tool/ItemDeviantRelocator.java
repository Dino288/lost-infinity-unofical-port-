/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.Mob
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.InteractionResultHolder
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.item.tool;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.projectile.entity.EntityDeviantDeployer;
import xol.lostinfinity.projectile.entity.EntityDeviantSucker;

public class ItemDeviantRelocator
extends Item {
    private List<Class<? extends Mob>> devList = new ArrayList<Class<? extends Mob>>();

    public ItemDeviantRelocator(String regName) {
        this.func_77637_a(TabsInit.TAB_AUXWEP);
        this.setRegistryName(regName);
        this.func_77655_b(regName);
        ItemInit.ITEMS.add(this);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack stack = playerIn.func_184586_b(handIn);
        if (!worldIn.field_72995_K) {
            if (playerIn.func_70093_af()) {
                EntityDeviantDeployer shot = new EntityDeviantDeployer(worldIn, (LivingEntity)playerIn);
                shot.giveList(this.devList);
                this.devList.clear();
                shot.setThrower((LivingEntity)playerIn);
                shot.func_184538_a((Entity)playerIn, playerIn.field_70125_A, playerIn.field_70177_z, 0.0f, 1.5f, 1.0f);
                worldIn.func_72838_d((Entity)shot);
            } else {
                EntityDeviantSucker shot = new EntityDeviantSucker(worldIn, (LivingEntity)playerIn);
                shot.setThrower((LivingEntity)playerIn);
                shot.func_184538_a((Entity)playerIn, playerIn.field_70125_A, playerIn.field_70177_z, 0.0f, 1.5f, 1.0f);
                worldIn.func_72838_d((Entity)shot);
            }
        }
        playerIn.func_184185_a(SoundInit.MAGIC_WEAPON_1, 1.0f, 1.0f);
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    public void passDeviantList(List<Class<? extends Mob>> newList) {
        this.devList.addAll(newList);
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Aqua) + "Fire: Shoots a projectile that stores all nearby deviants.");
        tooltip.add((Object)((Object)TextFmt.Light_Purple) + "Shift-Fire: Shoots a projectile to deploy all stored deviants.");
        tooltip.add((Object)((Object)TextFmt.Red) + "> If deployment hits a player, super-mutate all stored deviants.");
        tooltip.add((Object)((Object)TextFmt.Gold) + "Stored: " + this.devList.size());
    }
}

