/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.item.ItemEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 */
package xol.lostinfinity.item.misc;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemBasic;
import xol.lostinfinity.mob.entity.misc.EntityDimensionalMerchant;
import xol.lostinfinity.mob.entity.misc.EntityRocketStrappedExplosive;

public class ItemRocketStrappedExplosive
extends ItemBasic {
    public ItemRocketStrappedExplosive(String regName) {
        super(regName, TabsInit.TAB_AUXMATS);
    }

    public boolean func_111207_a(ItemStack stack, Player playerIn, LivingEntity target, InteractionHand hand) {
        if (target instanceof Player) {
            if (!playerIn.field_70170_p.field_72995_K) {
                Player targetPlayer = (Player)target;
                targetPlayer.func_70024_g(0.0, 0.05, 0.0);
                targetPlayer.field_70133_I = true;
                EntityRocketStrappedExplosive boost = new EntityRocketStrappedExplosive(playerIn.field_70170_p);
                boost.func_70107_b(targetPlayer.field_70165_t, targetPlayer.field_70163_u, targetPlayer.field_70161_v);
                boost.setOwner(targetPlayer);
                playerIn.field_70170_p.func_72838_d((Entity)boost);
            }
            stack.func_190918_g(1);
        }
        if (target instanceof EntityDimensionalMerchant) {
            if (!playerIn.field_70170_p.field_72995_K) {
                playerIn.func_145747_a((Component)new Component((Object)((Object)TextFmt.Dark_Aqua) + "The " + target.func_70005_c_() + " decided they would rather not, and traded you an item instead."));
                ItemEntity drop = new ItemEntity(playerIn.field_70170_p);
                drop.func_92058_a(new ItemStack(ItemInit.velocitizedFemur));
                drop.func_70107_b(playerIn.field_70165_t, playerIn.field_70163_u, playerIn.field_70161_v);
                playerIn.field_70170_p.func_72838_d((Entity)drop);
            }
            stack.func_190918_g(1);
        }
        return true;
    }
}

