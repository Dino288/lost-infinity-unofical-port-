/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.Player
 *  net.minecraft.tileentity.BlockEntity
 *  net.minecraft.util.ITickable
 */
package xol.lostinfinity.block.tileentity;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.util.ITickable;

public class BlockEntityChromaGame
extends BlockEntity
implements ITickable {
    private Player first = null;
    private Player second = null;

    public void func_73660_a() {
    }

    public void setPlayers(Player first, Player second) {
        this.first = first;
        this.second = second;
    }

    public boolean isFirst(Player check) {
        return this.first != null && check.equals((Object)this.first);
    }

    public boolean isSecond(Player check) {
        return this.second != null && check.equals((Object)this.second);
    }

    public Player getFirst() {
        return this.first;
    }

    public Player getSecond() {
        return this.second;
    }
}

