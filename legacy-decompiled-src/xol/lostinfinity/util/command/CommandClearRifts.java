/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.command.CommandBase
 *  net.minecraft.command.CommandException
 *  net.minecraft.command.ICommandSender
 *  net.minecraft.entity.player.Player
 *  net.minecraft.server.MinecraftServer
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 */
package xol.lostinfinity.util.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.MinecraftServer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.mob.entity.misc.EntityBaseRift;

public class CommandClearRifts
extends CommandBase {
    public String func_71517_b() {
        return "clearrifts";
    }

    public String func_71518_a(ICommandSender sender) {
        return "clearrifts <Range>";
    }

    public boolean func_184882_a(MinecraftServer server, ICommandSender sender) {
        return true;
    }

    public void func_184881_a(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if (args.length > 0 && sender instanceof Player) {
            int range;
            int rifts;
            Player player;
            block5: {
                player = (Player)sender;
                rifts = 0;
                range = 5;
                try {
                    range = Integer.parseInt(args[0]);
                }
                catch (NumberFormatException e) {
                    if (player.field_70170_p.field_72995_K) break block5;
                    player.func_145747_a((Component)new Component((Object)((Object)TextFmt.Red) + "Invalid number format"));
                }
            }
            for (EntityBaseRift near_pl : player.field_70170_p.func_72872_a(EntityBaseRift.class, player.func_174813_aQ().func_186662_g((double)range))) {
                near_pl.func_70106_y();
                ++rifts;
            }
            if (!player.field_70170_p.field_72995_K) {
                player.func_145747_a((Component)new Component((Object)((Object)TextFmt.Gold) + "Rifts cleared: " + rifts));
            }
        }
    }
}

