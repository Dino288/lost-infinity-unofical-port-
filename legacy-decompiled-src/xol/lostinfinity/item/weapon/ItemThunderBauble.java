/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.item.weapon;

import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.classify.IHeldTick;
import xol.lostinfinity.item.classify.IMovingSoundSource;

public class ItemThunderBauble
extends Item
implements IHeldTick,
IMovingSoundSource {
    public ItemThunderBauble(String regName) {
        this.func_77637_a(TabsInit.TAB_DEVIANTWEP);
        this.setRegistryName(regName);
        this.func_77655_b(regName);
        ItemInit.ITEMS.add(this);
    }

    @Override
    public void heldTick(Player player, InteractionHand hand, ItemStack stack) {
        Level world = player.field_70170_p;
        if (player.field_70173_aa % 20 == 0) {
            if (world.field_72995_K) {
                if (player == Minecraft.func_71410_x().field_71439_g) {
                    this.playSound(SoundInit.ITEM_THUNDERBAUBLE, SoundSource.PLAYERS, MOVING, 0.7f, 1.0f);
                }
            } else {
                this.playSoundAround(SoundInit.ITEM_THUNDERBAUBLE, SoundSource.PLAYERS, (Entity)player, 2.0f, 1.0f, false, 0);
            }
        }
        if (player.field_70173_aa % 5 == 0) {
            for (LivingEntity li : world.func_72872_a(LivingEntity.class, player.func_174813_aQ().func_72314_b(6.0, 5.0, 6.0))) {
                if (li.func_110124_au() == player.func_110124_au()) continue;
                li.func_70024_g(Math.signum(player.field_70165_t - li.field_70165_t) * -1.5, 0.2, Math.signum(player.field_70161_v - li.field_70161_v) * -1.5);
            }
        }
        float maxSpd = 1.5f;
        if (player.func_70051_ag()) {
            maxSpd = 2.0f;
        } else if (player.func_70093_af()) {
            maxSpd = 1.0f;
        }
        if (player.field_70159_w > (double)(-maxSpd) && player.field_70159_w < (double)maxSpd && player.field_70179_y > (double)(-maxSpd) && player.field_70179_y < (double)maxSpd) {
            player.field_70159_w *= (double)1.2f;
            player.field_70179_y *= (double)1.2f;
            player.field_70181_x *= (double)1.02f;
        }
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Aqua) + "When held:");
        tooltip.add((Object)((Object)TextFmt.Gold) + "Grants super speed.");
        tooltip.add((Object)((Object)TextFmt.Gold) + "Forces creatures in your path out of the way.");
    }
}

