/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.server.MinecraftServer
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 */
package xol.lostinfinity.util.damagesource;

import net.minecraft.server.MinecraftServer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;

public class DeathMessage {
    public static void broadcastDeathMessage(MinecraftServer server, String message) {
        server.func_184103_al().func_148539_a((Component)new Component(message));
    }
}

