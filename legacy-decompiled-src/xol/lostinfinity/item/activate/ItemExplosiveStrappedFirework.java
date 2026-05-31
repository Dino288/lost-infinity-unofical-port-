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
 *  net.minecraft.util.InteractionResultHolder
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.item.activate;

import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemCooldown;
import xol.lostinfinity.projectile.entity.EntityStrappedFirework;

public class ItemExplosiveStrappedFirework
extends ItemCooldown {
    public ItemExplosiveStrappedFirework(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_AUXMATS);
        this.func_77625_d(16);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack stack = playerIn.func_184586_b(handIn);
        if (!this.showDurabilityBar(stack)) {
            if (playerIn.field_70163_u <= (double)(worldIn.func_175645_m(playerIn.func_180425_c()).func_177956_o() + 3)) {
                if (!worldIn.field_72995_K) {
                    EntityStrappedFirework shot = new EntityStrappedFirework(worldIn, (LivingEntity)playerIn);
                    shot.setThrower((LivingEntity)playerIn);
                    worldIn.func_72838_d((Entity)shot);
                }
                playerIn.func_184586_b(handIn).func_190918_g(1);
                playerIn.func_184185_a(SoundEvents.field_187626_cN, 1.0f, 1.0f);
            } else if (!worldIn.field_72995_K) {
                playerIn.func_145747_a((Component)new Component((Object)((Object)TextFmt.Red) + "Fireworks must be launched close to the ground."));
            }
            playerIn.func_184586_b(handIn).func_77978_p().func_74772_a("lastUse", System.currentTimeMillis());
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    @Override
    protected int getCooldown() {
        return 400;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Aqua) + "Explosive vials attached to a firework.");
        tooltip.add((Object)((Object)TextFmt.Gold) + "Good for killing airborne creatures.");
    }
}

