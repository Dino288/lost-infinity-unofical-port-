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
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.projectile.entity.EntityGalaxyBomb;

public class ItemGalaxyBomb
extends Item {
    private String wep = "";

    public ItemGalaxyBomb(String regName) {
        this.func_77637_a(TabsInit.TAB_GALAXY);
        this.setRegistryName(regName);
        this.func_77655_b(regName);
        this.wep = regName;
        ItemInit.ITEMS.add(this);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack stack = playerIn.func_184586_b(handIn);
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
            stack.func_77978_p().func_74768_a("Bombs", 400);
        }
        stack.func_77978_p().func_74768_a("Bombs", stack.func_77978_p().func_74762_e("Bombs") - 1);
        if (!worldIn.field_72995_K) {
            EntityGalaxyBomb shot = new EntityGalaxyBomb(worldIn, (LivingEntity)playerIn);
            shot.setThrower((LivingEntity)playerIn);
            shot.func_184538_a((Entity)playerIn, playerIn.field_70125_A, playerIn.field_70177_z, 0.0f, 0.7f, 0.0f);
            switch (this.wep) {
                case "moonglow_bomb": {
                    shot.setForm((byte)0);
                    break;
                }
                case "novacron_bomb": {
                    shot.setForm((byte)1);
                    break;
                }
                case "aurorus_bomb": {
                    shot.setForm((byte)2);
                    break;
                }
                case "starfire_bomb": {
                    shot.setForm((byte)3);
                }
            }
            worldIn.func_72838_d((Entity)shot);
        }
        if (stack.func_77978_p().func_74762_e("Bombs") == 0) {
            stack.func_190918_g(1);
        }
        playerIn.func_184185_a(SoundEvents.field_187578_au, 1.0f, 1.0f);
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Red) + "In an area on impact:");
        switch (this.wep) {
            case "moonglow_bomb": {
                tooltip.add((Object)((Object)TextFmt.Gold) + "While Above 80% Life:");
                tooltip.add((Object)((Object)TextFmt.Aqua) + "Deal 15% Max Health Damage");
                break;
            }
            case "novacron_bomb": {
                tooltip.add((Object)((Object)TextFmt.Gold) + "To Targets Below 50% Health:");
                tooltip.add((Object)((Object)TextFmt.Light_Purple) + "Deal 10% Max Health Damage");
                break;
            }
            case "aurorus_bomb": {
                tooltip.add((Object)((Object)TextFmt.Gold) + "To Targets Above 50% Health:");
                tooltip.add((Object)((Object)TextFmt.Green) + "Deal 10% Max Health Damage");
                break;
            }
            case "starfire_bomb": {
                tooltip.add((Object)((Object)TextFmt.Gold) + "While Below 20% Life:");
                tooltip.add((Object)((Object)TextFmt.Yellow) + "Deal 20% Max Health Damage");
            }
        }
        if (stack.func_77942_o() && stack.func_77978_p().func_74764_b("Bombs")) {
            tooltip.add((Object)((Object)TextFmt.Red) + "Bombs Remaining: " + stack.func_77978_p().func_74762_e("Bombs"));
        }
    }
}

