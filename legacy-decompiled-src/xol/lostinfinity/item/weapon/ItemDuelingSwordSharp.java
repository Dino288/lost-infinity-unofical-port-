/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.Item
 *  net.minecraft.item.Item$ToolMaterial
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.SwordItem
 *  net.minecraft.util.math.AABB
 */
package xol.lostinfinity.item.weapon;

import java.util.List;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.phys.AABB;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.mob.entity.contest.controller.EntityControllerDuelArena;
import xol.lostinfinity.util.coordinates.ContestCoordinates;

public class ItemDuelingSwordSharp
extends SwordItem {
    private static final int numHits = 3;

    public ItemDuelingSwordSharp(String regName) {
        super(Item.ToolMaterial.IRON);
        this.func_77637_a(TabsInit.TAB_AUXWEP);
        this.setRegistryName(regName);
        this.func_77655_b(regName);
        ItemInit.ITEMS.add((Item)this);
    }

    public boolean func_77644_a(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        AABB arena;
        List inAABB;
        stack.func_77964_b(0);
        if (target instanceof Player && attacker instanceof Player && (inAABB = attacker.field_70170_p.func_72872_a(Player.class, arena = ContestCoordinates.duelArenaAABB())).contains((Player)attacker) && inAABB.contains((Player)target)) {
            for (EntityControllerDuelArena controller : attacker.field_70170_p.func_72872_a(EntityControllerDuelArena.class, arena)) {
                controller.hitPlayer((Player)target, 3);
            }
        }
        return true;
    }
}

