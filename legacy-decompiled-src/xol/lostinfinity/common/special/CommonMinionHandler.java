/*
 * Decompiled with CFR 0.152.
 */
package xol.lostinfinity.common.special;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import xol.lostinfinity.mob.entity.minion.EntityMinion;

public class CommonMinionHandler {
    private static CommonMinionHandler INSTANCE;
    private final Map<UUID, Set<EntityMinion>> minionMaps = new ConcurrentHashMap<UUID, Set<EntityMinion>>();

    public static void init() {
        if (INSTANCE == null) {
            INSTANCE = new CommonMinionHandler();
        }
    }

    public static void registerMinion(UUID player, EntityMinion minion) {
        Set minionSet = CommonMinionHandler.INSTANCE.minionMaps.computeIfAbsent(player, k -> new HashSet());
        minionSet.add(minion);
    }

    public static void unregisterMinion(UUID player, EntityMinion minion) {
        Set minionSet = CommonMinionHandler.INSTANCE.minionMaps.computeIfAbsent(player, k -> new HashSet());
        minionSet.remove((Object)minion);
    }

    public static void unregisterAll(UUID player) {
        Set<EntityMinion> minionSet = CommonMinionHandler.INSTANCE.minionMaps.get(player);
        if (minionSet == null || minionSet.isEmpty()) {
            return;
        }
        minionSet.forEach(EntityMinion::setDeadNoTrigger);
        minionSet.clear();
    }

    public static Set<EntityMinion> getMinions(UUID player) {
        return CommonMinionHandler.INSTANCE.minionMaps.computeIfAbsent(player, k -> new HashSet());
    }

    private CommonMinionHandler() {
    }
}

