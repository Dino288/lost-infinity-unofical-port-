/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.command.CommandBase
 *  net.minecraft.command.CommandException
 *  net.minecraft.command.ICommandSender
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.server.MinecraftServer
 */
package xol.lostinfinity.util.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.MinecraftServer;
import xol.lostinfinity.item.weapon.ItemEssencePossessor;

public class CommandChargeEP
extends CommandBase {
    public String func_71517_b() {
        return "chargeep";
    }

    public String func_71518_a(ICommandSender sender) {
        return "chargeep";
    }

    public boolean func_184882_a(MinecraftServer server, ICommandSender sender) {
        return true;
    }

    public void func_184881_a(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if (sender instanceof Player) {
            Player player = (Player)sender;
            this.chargeItem(player.func_184614_ca());
            this.chargeItem(player.func_184592_cb());
        }
    }

    private void chargeItem(ItemStack stack) {
        if (stack.func_77973_b() instanceof ItemEssencePossessor) {
            CompoundTag compound = stack.func_77978_p();
            if (compound == null) {
                compound = new CompoundTag();
                stack.func_77982_d(compound);
            }
            compound.func_74768_a("essence", 10);
        }
    }
}

