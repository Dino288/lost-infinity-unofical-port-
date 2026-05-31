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
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.item.misc;

import java.util.List;
import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemBasic;
import xol.lostinfinity.projectile.entity.EntityEffigyShot;

public class ItemEffigyDoll
extends ItemBasic {
    public ItemEffigyDoll(String regName) {
        super(regName, TabsInit.TAB_AUXMATS);
        this.func_77625_d(1);
    }

    public boolean func_111207_a(ItemStack stack, Player playerIn, LivingEntity target, InteractionHand hand) {
        if (target instanceof Player) {
            ItemStack realStack = playerIn.func_184586_b(hand);
            Player targetPlayer = (Player)target;
            if (!realStack.func_77942_o()) {
                realStack.func_77982_d(new CompoundTag());
            }
            realStack.func_77978_p().func_186854_a("targetID", targetPlayer.func_110124_au());
            if (!playerIn.field_70170_p.field_72995_K) {
                playerIn.func_145747_a((Component)new Component("Stored " + targetPlayer.func_70005_c_() + " in the effigy doll"));
            }
        }
        return true;
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack stack = playerIn.func_184586_b(handIn);
        if (stack.func_77942_o() && stack.func_77978_p().func_186855_b("targetID")) {
            if (!worldIn.field_72995_K) {
                EntityEffigyShot shot = new EntityEffigyShot(worldIn, (LivingEntity)playerIn);
                shot.setStack(stack);
                shot.setThrower((LivingEntity)playerIn);
                shot.func_184538_a((Entity)playerIn, playerIn.field_70125_A, playerIn.field_70177_z, 0.0f, 1.0f, 0.0f);
                worldIn.func_72838_d((Entity)shot);
            }
            stack.func_190918_g(1);
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        UUID targetID;
        Player target;
        tooltip.add((Object)((Object)TextFmt.Red) + "A creepy doll. Use on a player to store their likeness.");
        if (stack.func_77942_o() && stack.func_77978_p().func_186855_b("targetID") && (target = worldIn.func_152378_a(targetID = stack.func_77978_p().func_186857_a("targetID"))) != null) {
            tooltip.add((Object)((Object)TextFmt.Red) + "Stored: " + target.func_70005_c_());
        }
    }
}

