/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.entity.player.ServerPlayer
 *  net.minecraftforge.fml.common.FMLCommonHandler
 *  net.minecraftforge.fml.common.network.NetworkRegistry
 *  net.minecraftforge.fml.common.network.NetworkRegistry$TargetPoint
 *  net.minecraftforge.fml.common.network.simpleimpl.IMessage
 *  net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper
 *  net.minecraftforge.fml.relauncher.Side
 */
package xol.lostinfinity.common.packets;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
import xol.lostinfinity.common.packets.PacketSendInput;
import xol.lostinfinity.common.packets.clientbound.PacketHeadHunterUpdate;
import xol.lostinfinity.common.packets.clientbound.PacketModParticle;
import xol.lostinfinity.common.packets.clientbound.PacketSetControlled;
import xol.lostinfinity.common.packets.clientbound.PacketShipmentBoxUpdate;
import xol.lostinfinity.common.packets.clientbound.PacketSupplyInventoryClient;
import xol.lostinfinity.common.packets.clientbound.PacketSyncParts;
import xol.lostinfinity.common.packets.clientbound.PacketUniversalMovingSound;
import xol.lostinfinity.common.packets.serverbound.PacketChemistryTable;
import xol.lostinfinity.common.packets.serverbound.PacketCthulhuBarrier;
import xol.lostinfinity.common.packets.serverbound.PacketDismount;
import xol.lostinfinity.common.packets.serverbound.PacketFusionTable;
import xol.lostinfinity.common.packets.serverbound.PacketGearbox;
import xol.lostinfinity.common.packets.serverbound.PacketGrinder;
import xol.lostinfinity.common.packets.serverbound.PacketItemMode;
import xol.lostinfinity.common.packets.serverbound.PacketLightReceiver;
import xol.lostinfinity.common.packets.serverbound.PacketNBTSyncLong;
import xol.lostinfinity.common.packets.serverbound.PacketSetBonus;
import xol.lostinfinity.common.packets.serverbound.PacketSupplyInventoryServer;
import xol.lostinfinity.common.packets.serverbound.PacketTextTitle;
import xol.lostinfinity.common.packets.serverbound.PacketUpdatePlayerPickedItem;
import xol.lostinfinity.common.packets.serverbound.PacketWeldingChamber;
import xol.lostinfinity.util.animation.packet.PacketAnimation;

public class LostInfinityPacketHandler {
    public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel("lostinfinity");

    public LostInfinityPacketHandler() {
        INSTANCE.registerMessage(PacketTextTitle.TitlePacketHandler.class, PacketTextTitle.class, PacketID.TITLE.ordinal(), Side.SERVER);
        INSTANCE.registerMessage(PacketSetBonus.SetBonusPacketHandler.class, PacketSetBonus.class, PacketID.ARMOR_SET.ordinal(), Side.SERVER);
        INSTANCE.registerMessage(PacketItemMode.ItemModePacketHandler.class, PacketItemMode.class, PacketID.ITEM_MODE.ordinal(), Side.SERVER);
        INSTANCE.registerMessage(PacketLightReceiver.LightReceiverPacketHandler.class, PacketLightReceiver.class, PacketID.LIGHT_RECEIVER.ordinal(), Side.SERVER);
        INSTANCE.registerMessage(PacketNBTSyncLong.PacketNBTSyncLongHandler.class, PacketNBTSyncLong.class, PacketID.NBT_SYNC_LONG.ordinal(), Side.CLIENT);
        INSTANCE.registerMessage(PacketWeldingChamber.WeldingChamberGUIPacketHandler.class, PacketWeldingChamber.class, PacketID.WELDING_CHAMBER_GUI.ordinal(), Side.SERVER);
        INSTANCE.registerMessage(PacketGearbox.GUIGearboxPacketHandler.class, PacketGearbox.class, PacketID.GEARBOX.ordinal(), Side.SERVER);
        INSTANCE.registerMessage(PacketGrinder.GUIGrinderPacketHandler.class, PacketGrinder.class, PacketID.GRINDER.ordinal(), Side.SERVER);
        INSTANCE.registerMessage(PacketFusionTable.FusionTableGUIPacketHandler.class, PacketFusionTable.class, PacketID.FUSION_TABLE_GUI.ordinal(), Side.SERVER);
        INSTANCE.registerMessage(PacketSendInput.SendInputPacketHandler.class, PacketSendInput.class, PacketID.SERVER_INPUT.ordinal(), Side.SERVER);
        INSTANCE.registerMessage(PacketDismount.DismountPacketHandler.class, PacketDismount.class, PacketID.DISMOUNT.ordinal(), Side.SERVER);
        INSTANCE.registerMessage(PacketChemistryTable.ChemistryTableGUIPacketHandler.class, PacketChemistryTable.class, PacketID.CHEMISTRY_TABLE.ordinal(), Side.SERVER);
        INSTANCE.registerMessage(PacketSupplyInventoryServer.SupplyInventoryServerPacketHandler.class, PacketSupplyInventoryServer.class, PacketID.SUPPLY_INVENTORY_SERVER.ordinal(), Side.SERVER);
        INSTANCE.registerMessage(PacketUpdatePlayerPickedItem.UpdatePlayerPickedItemPacketHandler.class, PacketUpdatePlayerPickedItem.class, PacketID.UPDATE_PLAYER_PICKED_ITEM.ordinal(), Side.SERVER);
        INSTANCE.registerMessage(PacketCthulhuBarrier.CthulhuBarrierPacketHandler.class, PacketCthulhuBarrier.class, PacketID.CTHULHU_BARRIER.ordinal(), Side.SERVER);
        INSTANCE.registerMessage(PacketUniversalMovingSound.UniversalMovingSoundPacketHandler.class, PacketUniversalMovingSound.class, PacketID.UNIVERSAL_MOVING_SOUND.ordinal(), Side.CLIENT);
        INSTANCE.registerMessage(PacketModParticle.ModParticlePacketHandler.class, PacketModParticle.class, PacketID.MOD_PARTICLE.ordinal(), Side.CLIENT);
        INSTANCE.registerMessage(PacketSetControlled.SetControlledPacketHandler.class, PacketSetControlled.class, PacketID.CONTROLLED.ordinal(), Side.CLIENT);
        INSTANCE.registerMessage(PacketSendInput.SendInputPacketHandler.class, PacketSendInput.class, PacketID.CLIENT_INPUT.ordinal(), Side.CLIENT);
        INSTANCE.registerMessage(PacketSyncParts.SyncPartsPacketHandler.class, PacketSyncParts.class, PacketID.SYNC_PART.ordinal(), Side.CLIENT);
        INSTANCE.registerMessage(PacketHeadHunterUpdate.HeadHunterUpdatePacketHandler.class, PacketHeadHunterUpdate.class, PacketID.HEAD_HUNTER.ordinal(), Side.CLIENT);
        INSTANCE.registerMessage(PacketSupplyInventoryClient.SupplyInventoryClientPacketHandler.class, PacketSupplyInventoryClient.class, PacketID.SUPPLY_INVENTORY_CLIENT.ordinal(), Side.CLIENT);
        INSTANCE.registerMessage(PacketShipmentBoxUpdate.ShipmentBoxUpdatePacketHandler.class, PacketShipmentBoxUpdate.class, PacketID.SHIPMENT_BOX_UPDATE.ordinal(), Side.CLIENT);
        INSTANCE.registerMessage(PacketAnimation.AnimationPacketHandler.class, PacketAnimation.class, PacketID.ANIMATION.ordinal(), Side.CLIENT);
    }

    public void sendServerBasicPacket(IMessage msg) {
        INSTANCE.sendToServer(msg);
    }

    public void sendTitleToPlayer(PacketTextTitle packet, Player player) {
        if (FMLCommonHandler.instance().getSide() == Side.SERVER || !player.field_70170_p.field_72995_K) {
            return;
        }
        INSTANCE.sendToServer((IMessage)packet);
    }

    public void sendToAllAround(NetworkRegistry.TargetPoint location, IMessage msg) {
        INSTANCE.sendToAllAround(msg, location);
    }

    public void sendToPlayerExcept(Entity exclude, IMessage msg) {
        INSTANCE.sendToAllTracking(msg, exclude);
    }

    public void sendToPlayer(ServerPlayer player, IMessage msg) {
        INSTANCE.sendTo(msg, player);
    }

    protected static enum PacketID {
        TITLE,
        ARMOR_SET,
        ITEM_MODE,
        SYNC_ESSENCES,
        ESSENCE_SELECTED,
        LIGHT_RECEIVER,
        NBT_SYNC_LONG,
        PHANTOM_MOVEMENT,
        WELDING_CHAMBER_GUI,
        FUSION_TABLE_GUI,
        SERVER_INPUT,
        DISMOUNT,
        GEARBOX,
        GRINDER,
        UNIVERSAL_MOVING_SOUND,
        MOD_PARTICLE,
        CONTROLLED,
        CLIENT_INPUT,
        SYNC_PART,
        HEAD_HUNTER,
        CHEMISTRY_TABLE,
        SUPPLY_INVENTORY_CLIENT,
        SUPPLY_INVENTORY_SERVER,
        UPDATE_PLAYER_PICKED_ITEM,
        SHIPMENT_BOX_UPDATE,
        ANIMATION,
        CTHULHU_BARRIER;

    }
}

