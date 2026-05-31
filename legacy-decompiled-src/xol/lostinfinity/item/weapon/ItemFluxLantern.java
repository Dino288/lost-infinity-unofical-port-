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
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 *  net.minecraftforge.common.util.ITeleporter
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
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.util.ITeleporter;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.dimension.util.BasicTeleporter;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.classify.ICustomHoldPose;
import xol.lostinfinity.projectile.entity.EntityFluxBall;

public class ItemFluxLantern
extends Item
implements ICustomHoldPose {
    public ItemFluxLantern(String regName) {
        this.func_77637_a(TabsInit.TAB_INFINITYWEP);
        this.setRegistryName(regName);
        this.func_77655_b(regName);
        this.func_77625_d(1);
        ItemInit.ITEMS.add(this);
    }

    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        if (entity instanceof Player && stack.func_77942_o() && stack.func_77978_p().func_74764_b("flux_dimension_id")) {
            int dim_id = stack.func_77978_p().func_74762_e("flux_dimension_id");
            double goX = stack.func_77978_p().func_74769_h("flux_pos_x");
            double goY = stack.func_77978_p().func_74769_h("flux_pos_y");
            double goZ = stack.func_77978_p().func_74769_h("flux_pos_z");
            if (!player.field_70170_p.field_72995_K) {
                if (entity.field_71093_bK != dim_id) {
                    BasicTeleporter teleporter = new BasicTeleporter(entity.func_184102_h().func_71218_a(dim_id), goX, goY, goZ);
                    entity.changeDimension(dim_id, (ITeleporter)teleporter);
                } else {
                    entity.func_70634_a(goX, goY, goZ);
                }
            }
            player.field_70170_p.func_184134_a(player.field_70165_t, player.field_70163_u, player.field_70161_v, SoundEvents.field_187534_aX, SoundSource.MASTER, 2.0f, 1.0f, false);
            return true;
        }
        return false;
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack stack = playerIn.func_184586_b(handIn);
        if (playerIn.func_70093_af()) {
            if (!stack.func_77942_o()) {
                stack.func_77982_d(new CompoundTag());
            }
            stack.func_77978_p().func_74768_a("flux_dimension_id", worldIn.field_73011_w.func_186058_p().func_186068_a());
            stack.func_77978_p().func_74780_a("flux_pos_x", playerIn.field_70165_t);
            stack.func_77978_p().func_74780_a("flux_pos_y", playerIn.field_70163_u);
            stack.func_77978_p().func_74780_a("flux_pos_z", playerIn.field_70161_v);
            worldIn.func_184134_a(playerIn.field_70165_t, playerIn.field_70163_u, playerIn.field_70161_v, SoundInit.FLUX_MARK, SoundSource.MASTER, 2.0f, 1.0f, false);
            if (worldIn.field_72995_K) {
                playerIn.func_145747_a((Component)new Component((Object)((Object)TextFmt.Dark_Purple) + "Coordinates marked for fluxation."));
            }
        } else if (stack.func_77942_o() && stack.func_77978_p().func_74764_b("flux_dimension_id")) {
            if (!worldIn.field_72995_K) {
                int dim_id = stack.func_77978_p().func_74762_e("flux_dimension_id");
                double goX = stack.func_77978_p().func_74769_h("flux_pos_x");
                double goY = stack.func_77978_p().func_74769_h("flux_pos_y");
                double goZ = stack.func_77978_p().func_74769_h("flux_pos_z");
                EntityFluxBall shot = new EntityFluxBall(worldIn, (LivingEntity)playerIn);
                shot.setThrower((LivingEntity)playerIn);
                shot.setFlux(dim_id, goX, goY, goZ);
                shot.func_184538_a((Entity)playerIn, playerIn.field_70125_A, playerIn.field_70177_z, 0.0f, 1.5f, 1.0f);
                worldIn.func_72838_d((Entity)shot);
            }
            playerIn.func_184185_a(SoundEvents.field_187775_eP, 1.0f, 1.0f);
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Gold) + "Shift+Right Click: Mark a location and dimension for fluxation.");
        tooltip.add((Object)((Object)TextFmt.Dark_Purple) + "Shoot a projectile that fluxes players.");
        tooltip.add((Object)((Object)TextFmt.Dark_Purple) + "Fluxes hit players on melee hit.");
        boolean mark = false;
        if (stack.func_77942_o() && stack.func_77978_p().func_74764_b("flux_dimension_id")) {
            mark = true;
        }
        if (mark) {
            tooltip.add((Object)((Object)TextFmt.Green) + "Flux Marked:");
            tooltip.add((Object)((Object)TextFmt.Green) + "Dimension: " + stack.func_77978_p().func_74762_e("flux_dimension_id"));
            tooltip.add((Object)((Object)TextFmt.Green) + "X:" + stack.func_77978_p().func_74769_h("flux_pos_x"));
            tooltip.add((Object)((Object)TextFmt.Green) + "Y:" + stack.func_77978_p().func_74769_h("flux_pos_y"));
            tooltip.add((Object)((Object)TextFmt.Green) + "Z:" + stack.func_77978_p().func_74769_h("flux_pos_z"));
        } else {
            tooltip.add((Object)((Object)TextFmt.Red) + "NO FLUX LOCATION SET");
        }
    }
}

