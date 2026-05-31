/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.command.CommandBase
 *  net.minecraft.command.CommandException
 *  net.minecraft.command.ICommandSender
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.server.MinecraftServer
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 */
package xol.lostinfinity.util.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.item.weapon.ItemBranchOfLife;

public class CommandSetDeviant
extends CommandBase {
    public String func_71517_b() {
        return "setdeviant";
    }

    public String func_71518_a(ICommandSender sender) {
        return "setdeviant <NameOfStoredDeviant>";
    }

    public boolean func_184882_a(MinecraftServer server, ICommandSender sender) {
        return true;
    }

    public void func_184881_a(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if (args.length > 0 && sender instanceof Player) {
            int flag = 0;
            Player player = (Player)sender;
            Item held = player.func_184614_ca().func_77973_b();
            if (held instanceof ItemBranchOfLife) {
                ItemStack stack = player.func_184614_ca();
                ItemBranchOfLife branch = (ItemBranchOfLife)held;
                if (stack.func_77942_o()) {
                    if (stack.func_77978_p().func_74764_b(args[0])) {
                        stack.func_77978_p().func_74778_a("currentdeviant", args[0]);
                        if (!player.field_70170_p.field_72995_K) {
                            player.field_70170_p.func_184133_a(null, player.func_180425_c(), SoundEvents.field_187556_aj, SoundSource.MASTER, 1.0f, 1.0f);
                        }
                    } else {
                        flag = 2;
                    }
                } else {
                    flag = 1;
                }
            } else {
                flag = 3;
            }
            if (flag > 0 && !player.field_70170_p.field_72995_K) {
                switch (flag) {
                    case 1: {
                        player.func_145747_a((Component)new Component((Object)((Object)TextFmt.Red) + "No deviants saved."));
                        break;
                    }
                    case 2: {
                        player.func_145747_a((Component)new Component((Object)((Object)TextFmt.Red) + "That deviant is not saved."));
                        break;
                    }
                    case 3: {
                        player.func_145747_a((Component)new Component((Object)((Object)TextFmt.Red) + "Not holding a compatible item."));
                    }
                }
            }
        }
    }
}

