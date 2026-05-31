/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.util.InteractionResultHolder
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.DimensionType
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.item.activate;

import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.DimensionType;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemCooldown;
import xol.lostinfinity.mob.entity.misc.EntityUnstableMerchant;

public class ItemGeoCorrelator
extends ItemCooldown {
    private double lastDistance = 9.9999997952E10;

    public ItemGeoCorrelator(String regName) {
        super(regName);
        this.func_77625_d(1);
        this.func_77637_a(TabsInit.TAB_AUXMATS);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        if (!this.showDurabilityBar(playerIn.func_184586_b(handIn))) {
            ItemStack stack = playerIn.func_184586_b(handIn);
            if (!stack.func_77942_o()) {
                stack.func_77982_d(new CompoundTag());
                stack.func_77978_p().func_74768_a("GameState", 0);
            }
            if (!worldIn.field_72995_K && worldIn.field_73011_w.func_186058_p() == DimensionType.OVERWORLD) {
                int state = stack.func_77978_p().func_74762_e("GameState");
                if (state == 0) {
                    EntityUnstableMerchant newMerchant = new EntityUnstableMerchant(worldIn);
                    newMerchant.func_70107_b(playerIn.field_70165_t, playerIn.field_70163_u, playerIn.field_70161_v);
                    worldIn.func_72838_d((Entity)newMerchant);
                    worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundEvents.field_187791_eX, SoundSource.NEUTRAL, 1.0f, 1.0f);
                    playerIn.func_145747_a((Component)new Component((Object)((Object)TextFmt.Gold) + "Unstable Merchant: " + (Object)((Object)TextFmt.Reset) + (Object)((Object)TextFmt.Italic) + "Greetings fellow traveller! Pass me your new geocorrelator and I'll set your next coordinates."));
                } else {
                    double needX = stack.func_77978_p().func_74769_h("FindX");
                    double needY = stack.func_77978_p().func_74769_h("FindY");
                    double needZ = stack.func_77978_p().func_74769_h("FindZ");
                    double newDist = playerIn.func_70011_f(needX, needY, needZ);
                    worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundEvents.field_187750_dc, SoundSource.NEUTRAL, 1.0f, 1.0f);
                    if (newDist < 7.0) {
                        EntityUnstableMerchant newMerchant = new EntityUnstableMerchant(worldIn);
                        newMerchant.func_70107_b(playerIn.field_70165_t, playerIn.field_70163_u, playerIn.field_70161_v);
                        newMerchant.setMode(1);
                        worldIn.func_72838_d((Entity)newMerchant);
                        worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundEvents.field_187791_eX, SoundSource.NEUTRAL, 1.0f, 1.0f);
                        playerIn.func_145747_a((Component)new Component((Object)((Object)TextFmt.Gold) + "Unstable Merchant: " + (Object)((Object)TextFmt.Reset) + (Object)((Object)TextFmt.Italic) + "You found me! Pass me the correlator."));
                    } else if (newDist < this.lastDistance) {
                        if (newDist < 50.0) {
                            playerIn.func_145747_a((Component)new Component((Object)((Object)TextFmt.Green) + "Very Warm!"));
                        } else {
                            playerIn.func_145747_a((Component)new Component((Object)((Object)TextFmt.Green) + "Warmer"));
                        }
                    } else {
                        playerIn.func_145747_a((Component)new Component((Object)((Object)TextFmt.Aqua) + "Colder"));
                    }
                    this.lastDistance = newDist;
                }
            }
            playerIn.func_184586_b(handIn).func_77978_p().func_74772_a("lastUse", System.currentTimeMillis());
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    @Override
    protected int getCooldown() {
        return 700;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        boolean flag = false;
        if (!stack.func_77942_o()) {
            flag = true;
        } else if (stack.func_77978_p().func_74762_e("GameState") == 0) {
            flag = true;
        }
        if (flag) {
            tooltip.add((Object)((Object)TextFmt.Gold) + "Activate to call an interdimensional traveller to your location.");
        } else {
            tooltip.add((Object)((Object)TextFmt.Gold) + "Activate to track the Unstable Merchant's location.");
            if (stack.func_77978_p().func_74762_e("GameState") > 1) {
                tooltip.add((Object)((Object)TextFmt.Italic) + "Traveller, I apologize for what happened back there.");
            }
        }
    }
}

