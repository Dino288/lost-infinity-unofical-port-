/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.Player
 */
package xol.lostinfinity.item.classify;

import java.util.Set;
import net.minecraft.world.entity.player.Player;
import xol.lostinfinity.common.special.CommonMinionHandler;
import xol.lostinfinity.mob.entity.minion.EntityMinion;

public interface ISummon {
    default public Set<EntityMinion> getCurrentMinion(Player player) {
        return CommonMinionHandler.getMinions(player.func_110124_au());
    }

    default public void despawnPrevious(Player player) {
        CommonMinionHandler.unregisterAll(player.func_110124_au());
    }
}

