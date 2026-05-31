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
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemCooldown;
import xol.lostinfinity.item.classify.ICustomHoldPose;
import xol.lostinfinity.item.classify.IModeSelect;
import xol.lostinfinity.item.classify.ISwitchModels;
import xol.lostinfinity.projectile.entity.EntityCarrierProjectile;
import xol.lostinfinity.projectile.entity.EntityComet;

public class ItemCometCannon
extends ItemCooldown
implements ISwitchModels,
IModeSelect,
ICustomHoldPose {
    private int cooldown = 5000;

    public ItemCometCannon(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_INFINITYWEP);
        this.setModelSwitch("firemode", this, 2);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack stack = playerIn.func_184586_b(handIn);
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
            stack.func_77978_p().func_74768_a("firemode_data", 0);
        }
        if (!this.showDurabilityBar(playerIn.func_184586_b(handIn))) {
            int mode = this.getFireMode(stack);
            if (mode == 1) {
                if (!worldIn.field_72995_K) {
                    EntityCarrierProjectile shot = new EntityCarrierProjectile(worldIn, (LivingEntity)playerIn);
                    shot.setThrower((LivingEntity)playerIn);
                    shot.setForm((byte)1);
                    if (!playerIn.func_70093_af()) {
                        shot.setRemainingLife((byte)40);
                    } else {
                        shot.setRemainingLife((byte)15);
                    }
                    shot.func_184538_a((Entity)playerIn, playerIn.field_70125_A, playerIn.field_70177_z, 0.0f, 1.5f, 1.0f);
                    worldIn.func_72838_d((Entity)shot);
                }
                this.setCooldown(5000);
            } else {
                if (!worldIn.field_72995_K) {
                    EntityComet comet = new EntityComet(worldIn, (LivingEntity)playerIn);
                    comet.setThrower((LivingEntity)playerIn);
                    comet.setCount(2000);
                    comet.func_189654_d(true);
                    comet.func_184538_a((Entity)playerIn, playerIn.field_70125_A, playerIn.field_70177_z, 0.0f, 3.0f, 0.0f);
                    worldIn.func_72838_d((Entity)comet);
                }
                this.setCooldown(500);
            }
            if (!worldIn.field_72995_K) {
                worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundInit.ITEM_STARSTORM, SoundSource.MASTER, 1.0f, 1.0f);
            }
            playerIn.func_184586_b(handIn).func_77978_p().func_74772_a("lastUse", System.currentTimeMillis());
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    @Override
    protected int getCooldown() {
        return this.cooldown;
    }

    private void setCooldown(int newC) {
        this.cooldown = newC;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Aqua) + "Can switch between firing comet showers and comets forwards.");
        tooltip.add((Object)((Object)TextFmt.Yellow) + "Shift Fire for fast detonation.");
        tooltip.add((Object)((Object)TextFmt.Aqua) + "Comets deal:");
        tooltip.add((Object)((Object)TextFmt.Red) + "50% Max Health to creatures");
        tooltip.add((Object)((Object)TextFmt.Red) + "75% Max Health to players");
    }

    @Override
    public void modeUpdate(ItemStack stack, Player player) {
        int attack_style;
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
        }
        if ((attack_style = stack.func_77978_p().func_74762_e("firemode_data")) == 0) {
            stack.func_77978_p().func_74768_a("firemode_data", 1);
        } else {
            stack.func_77978_p().func_74768_a("firemode_data", 0);
        }
    }

    private int getFireMode(ItemStack stack) {
        if (stack.func_77942_o()) {
            return stack.func_77978_p().func_74762_e("firemode_data");
        }
        return 0;
    }
}

