/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.entity.player.ServerPlayer
 *  net.minecraft.item.Item
 *  net.minecraft.item.Item$ToolMaterial
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.SwordItem
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.server.SPacketEntityVelocity
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
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
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.SPacketEntityVelocity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.util.data.IMaxAttack;

public class ItemBladesOfDuality
extends SwordItem
implements IMaxAttack {
    private static final String MODE = "mode";

    public ItemBladesOfDuality(String regName) {
        super(Item.ToolMaterial.WOOD);
        this.func_77637_a(TabsInit.TAB_INFINITYWEP);
        this.setRegistryName(regName);
        this.func_77655_b(regName);
        ItemInit.ITEMS.add((Item)this);
        this.func_185043_a(new ResourceLocation("lostinfinity", MODE), (stack, worldIn, entityIn) -> this.isMode(stack) ? 1.0f : 0.0f);
    }

    public boolean func_77644_a(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (this.isMode(stack)) {
            boolean killed;
            if (target.field_70163_u > 100.0 && (killed = IMaxAttack.dealMaxHealth((Entity)attacker, target, 1).wasTargetKilled()) && target instanceof Player && !attacker.field_70170_p.field_72995_K) {
                attacker.func_145747_a((Component)new Component((Object)((Object)TextFmt.Green) + "Your blade has consumed " + target.func_70005_c_()));
            }
        } else if (attacker instanceof ServerPlayer) {
            target.field_70159_w = 0.0;
            target.field_70181_x = 4.0;
            target.field_70179_y = 0.0;
            attacker.field_70159_w = 0.0;
            attacker.field_70181_x = 4.0;
            attacker.field_70179_y = 0.0;
            attacker.field_70133_I = true;
            target.field_70133_I = true;
            ((ServerPlayer)attacker).field_71135_a.func_147359_a((Packet)new SPacketEntityVelocity((Entity)attacker));
            ((ServerPlayer)attacker).field_71135_a.func_147359_a((Packet)new SPacketEntityVelocity((Entity)target));
            if (target instanceof ServerPlayer) {
                ((ServerPlayer)target).field_71135_a.func_147359_a((Packet)new SPacketEntityVelocity((Entity)attacker));
                ((ServerPlayer)target).field_71135_a.func_147359_a((Packet)new SPacketEntityVelocity((Entity)target));
            }
        }
        this.toggleMode(stack);
        return true;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Gold) + "A weapon that switches sides when you attack.");
        tooltip.add((Object)((Object)TextFmt.Aqua) + "Blade of Wind: Sends you and the target flying into the sky.");
        tooltip.add((Object)((Object)TextFmt.Red) + "Blade of Treachery: Kills targets over 100 height.");
    }

    private void toggleMode(ItemStack stack) {
        this.setMode(stack, !this.isMode(stack));
    }

    private void setMode(ItemStack stack, boolean flag) {
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
        }
        stack.func_77978_p().func_74757_a(MODE, flag);
    }

    private boolean isMode(ItemStack stack) {
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
            stack.func_77978_p().func_74757_a(MODE, false);
            return false;
        }
        return stack.func_77978_p().func_74767_n(MODE);
    }
}

