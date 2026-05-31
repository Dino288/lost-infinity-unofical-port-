/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.item.Item
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

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;
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
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.classify.ICustomRaytrace;
import xol.lostinfinity.util.data.CustomHitResult;

public class ItemFluxocron
extends Item
implements ICustomRaytrace {
    List<LivingEntity> storage_list = new ArrayList<LivingEntity>();

    public ItemFluxocron(String regName) {
        this.func_77637_a(TabsInit.TAB_INFINITYWEP);
        this.setRegistryName(regName);
        this.func_77655_b(regName);
        this.func_77625_d(1);
        ItemInit.ITEMS.add(this);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack stack = playerIn.func_184586_b(handIn);
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
            stack.func_77978_p().func_74768_a("mode_style", 0);
        }
        if (playerIn.func_70093_af()) {
            int newMode = stack.func_77978_p().func_74762_e("mode_style") + 1;
            if (newMode == 4) {
                newMode = 0;
            }
            stack.func_77978_p().func_74768_a("mode_style", newMode);
            if (!worldIn.field_72995_K) {
                playerIn.func_145747_a((Component)new Component((Object)((Object)TextFmt.Gold) + "Mode Switched: " + this.modeFromInt(newMode)));
            }
        } else {
            switch (stack.func_77978_p().func_74762_e("mode_style")) {
                case 0: {
                    stack.func_77978_p().func_74780_a("flux_pos_x", playerIn.field_70165_t);
                    stack.func_77978_p().func_74780_a("flux_pos_y", playerIn.field_70163_u);
                    stack.func_77978_p().func_74780_a("flux_pos_z", playerIn.field_70161_v);
                    if (worldIn.field_72995_K) break;
                    playerIn.func_145747_a((Component)new Component((Object)((Object)TextFmt.Dark_Purple) + "Coordinate marked for fluxation."));
                    worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundInit.FLUX_MARK, SoundSource.MASTER, 2.0f, 1.0f);
                    break;
                }
                case 1: {
                    LivingEntity target;
                    if (worldIn.field_72995_K) break;
                    CustomHitResult trace_result = this.entityTrace(worldIn, (LivingEntity)playerIn, 45, LivingEntity.class);
                    if (trace_result != null && trace_result.getResultEntity() != null && !this.storage_list.contains(target = (LivingEntity)trace_result.getResultEntity())) {
                        this.storage_list.add(target);
                        playerIn.func_145747_a((Component)new Component((Object)((Object)TextFmt.Dark_Purple) + target.func_70005_c_() + " added to fluxation."));
                    }
                    worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundInit.FLUX_MARK, SoundSource.MASTER, 2.0f, 1.0f);
                    break;
                }
                case 2: {
                    if (worldIn.field_72995_K || this.storage_list.isEmpty()) break;
                    this.performTeleport(worldIn, playerIn, playerIn.field_70165_t, playerIn.field_70163_u, playerIn.field_70161_v);
                    break;
                }
                case 3: {
                    if (worldIn.field_72995_K || this.storage_list.isEmpty() || !stack.func_77978_p().func_74764_b("flux_pos_x")) break;
                    double goX = stack.func_77978_p().func_74769_h("flux_pos_x");
                    double goY = stack.func_77978_p().func_74769_h("flux_pos_y");
                    double goZ = stack.func_77978_p().func_74769_h("flux_pos_z");
                    this.performTeleport(worldIn, playerIn, goX, goY, goZ);
                }
            }
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    private void performTeleport(Level worldIn, Player playerIn, double goX, double goY, double goZ) {
        worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundEvents.field_187534_aX, SoundSource.MASTER, 1.0f, 1.0f);
        for (LivingEntity entity : this.storage_list) {
            entity.func_70634_a(goX, goY, goZ);
        }
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Dark_Purple) + "Mass Teleports Entities To Your/Marked Position");
        if (stack.func_77942_o()) {
            int style = stack.func_77978_p().func_74762_e("mode_style");
            switch (style) {
                case 0: {
                    tooltip.add((Object)((Object)TextFmt.Light_Purple) + "Mode: " + this.modeFromInt(style));
                    break;
                }
                case 1: {
                    tooltip.add((Object)((Object)TextFmt.Light_Purple) + "Mode: " + this.modeFromInt(style));
                    break;
                }
                case 2: {
                    tooltip.add((Object)((Object)TextFmt.Light_Purple) + "Mode: " + this.modeFromInt(style));
                    break;
                }
                case 3: {
                    tooltip.add((Object)((Object)TextFmt.Light_Purple) + "Mode: " + this.modeFromInt(style));
                }
            }
        }
    }

    private String modeFromInt(int mode) {
        switch (mode) {
            case 0: {
                return "Mark Location";
            }
            case 1: {
                return "Mark Entity";
            }
            case 2: {
                return "Teleport To You";
            }
            case 3: {
                return "Teleport To Marked Location";
            }
        }
        return "";
    }
}

