/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.Item
 *  net.minecraft.item.Item$ToolMaterial
 *  net.minecraft.item.SwordItem
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.item.cthulhu;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.common.lostinfinity;
import xol.lostinfinity.common.packets.serverbound.PacketCthulhuBarrier;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.mob.entity.cthulhu.EntityCthulhu;

public abstract class AbstractCthulhuSword
extends SwordItem {
    public AbstractCthulhuSword(String regName) {
        super(Item.ToolMaterial.DIAMOND);
        this.func_77637_a(TabsInit.TAB_INFINITYWEP);
        this.setRegistryName(regName);
        this.func_77655_b(regName);
        this.func_77625_d(1);
        ItemInit.ITEMS.add((Item)this);
    }

    @SideOnly(value=Side.CLIENT)
    protected static void sendCthulhuPacket(int flag, int value, int entityId) {
        lostinfinity.instance.packetHandler.sendServerBasicPacket(new PacketCthulhuBarrier(flag, value, entityId));
    }

    @SideOnly(value=Side.CLIENT)
    protected static boolean isHittingBarrier(Player player) {
        EntityCthulhu cthulhu = player.field_70170_p.field_72996_f.stream().filter(entity -> entity instanceof EntityCthulhu).map(entity -> (EntityCthulhu)entity).findFirst().orElse(null);
        if (cthulhu == null) {
            return false;
        }
        if (!cthulhu.isBarrierActive()) {
            return false;
        }
        if (cthulhu.getPhase() != 3) {
            return false;
        }
        double distance = cthulhu.func_70011_f(player.func_180425_c().func_177958_n(), cthulhu.func_180425_c().func_177956_o(), player.func_180425_c().func_177952_p());
        return !(distance < 48.0) && !(distance > 52.0);
    }
}

