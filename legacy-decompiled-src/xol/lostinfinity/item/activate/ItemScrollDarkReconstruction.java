/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.InteractionResultHolder
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.item.activate;

import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.phys.AABB;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.DimensionInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.classify.ICustomRaytrace;
import xol.lostinfinity.mob.entity.murk.EntityWhisper;

public class ItemScrollDarkReconstruction
extends Item
implements ICustomRaytrace {
    public ItemScrollDarkReconstruction(String regName) {
        ((Item)this.setRegistryName(regName)).func_77655_b(regName).func_77637_a(TabsInit.TAB_AUXMATS).func_77625_d(1);
        ItemInit.ITEMS.add(this);
        MinecraftForge.EVENT_BUS.register((Object)this);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        if (!worldIn.field_72995_K) {
            if (worldIn.field_73011_w.func_186058_p() == DimensionInit.infiniteMurk) {
                List sacrifices = playerIn.field_70170_p.func_72872_a(EntityWhisper.class, new AABB(playerIn.func_180425_c()).func_186662_g(25.0));
                if (sacrifices.size() >= 6) {
                    EntityWhisper leader = (EntityWhisper)sacrifices.get(0);
                    leader.setLeader(true);
                    for (int i = 1; i < sacrifices.size(); ++i) {
                        EntityWhisper sacrfice = (EntityWhisper)sacrifices.get(i);
                        sacrfice.setSacrificed(true);
                    }
                } else {
                    playerIn.func_145747_a((Component)new Component((Object)((Object)TextFmt.Red) + "You need 6 Whispers to begin the ritual."));
                    playerIn.func_184185_a(SoundEvents.field_187646_bt, 1.0f, 1.0f);
                }
            } else {
                playerIn.func_145747_a((Component)new Component((Object)((Object)TextFmt.Red) + "You must be in the Infinite Murk to cast this ritual."));
                playerIn.func_184185_a(SoundEvents.field_187646_bt, 1.0f, 1.0f);
            }
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Gold) + "This scroll can be used within the Infinite Murk");
        tooltip.add((Object)((Object)TextFmt.Gold) + "to summon a horrific, ancient terror.");
        tooltip.add("");
        tooltip.add((Object)((Object)TextFmt.Aqua) + "Reagents: " + (Object)((Object)TextFmt.Red) + "6 Whispers");
    }
}

