/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.EnumInteractionResultHolder
 *  net.minecraft.util.MovementInput
 *  net.minecraftforge.client.event.InputUpdateEvent
 *  net.minecraftforge.event.entity.player.PlayerInteractEvent
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.network.FMLNetworkEvent$ClientDisconnectionFromServerEvent
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.client.special;

import net.minecraft.util.EnumInteractionResultHolder;
import net.minecraft.util.MovementInput;
import net.minecraftforge.client.event.InputUpdateEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.common.lostinfinity;
import xol.lostinfinity.common.packets.PacketSendInput;
import xol.lostinfinity.common.special.CommonMindControlHandler;

@SideOnly(value=Side.CLIENT)
public class ClientMindControlHandler {
    public static ClientMindControlHandler INSTANCE;
    public CommonMindControlHandler.State state = CommonMindControlHandler.State.NONE;
    public float lastForward = 0.0f;
    public float lastStrafe = 0.0f;
    public boolean lastJump = false;
    public boolean lastSneak = false;

    public ClientMindControlHandler() {
        INSTANCE = this;
    }

    @SubscribeEvent
    public void onClientDisconnect(FMLNetworkEvent.ClientDisconnectionFromServerEvent event) {
        this.state = CommonMindControlHandler.State.NONE;
    }

    @SubscribeEvent
    public void onRightClick(PlayerInteractEvent event) {
        if (this.state == CommonMindControlHandler.State.CONTROLLED) {
            event.setCancellationResult(EnumInteractionResultHolder.PASS);
            if (event.isCancelable()) {
                event.setCanceled(true);
            }
        }
    }

    @SubscribeEvent
    public void onInputEvent(InputUpdateEvent event) {
        switch (this.state) {
            case CONTROLLED: {
                MovementInput input = event.getMovementInput();
                this.forceInput(input);
                break;
            }
            case CONTROLLING: {
                MovementInput input = event.getMovementInput();
                if (this.lastForward == input.field_192832_b && this.lastStrafe == input.field_78902_a && this.lastJump == input.field_78901_c && this.lastSneak == input.field_78899_d) {
                    this.voidInput(input);
                    break;
                }
                this.recordInput(input);
                this.voidInput(input);
                break;
            }
        }
    }

    private void recordInput(MovementInput input) {
        this.lastForward = input.field_192832_b;
        this.lastStrafe = input.field_78902_a;
        this.lastJump = input.field_78901_c;
        this.lastSneak = input.field_78899_d;
        lostinfinity.instance.packetHandler.sendServerBasicPacket(new PacketSendInput(this.lastForward, this.lastStrafe, this.lastJump, this.lastSneak));
    }

    private void voidInput(MovementInput input) {
        input.field_192832_b = 0.0f;
        input.field_78902_a = 0.0f;
        input.field_78901_c = false;
        input.field_78899_d = false;
    }

    private void forceInput(MovementInput input) {
        input.field_192832_b = this.lastForward;
        input.field_78902_a = this.lastStrafe;
        input.field_78901_c = this.lastJump;
        input.field_78899_d = this.lastSneak;
    }
}

