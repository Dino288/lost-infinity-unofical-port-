/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.PlayerSP
 *  net.minecraft.client.model.ModelBiped
 *  net.minecraft.client.model.ModelBiped$ArmPose
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.RenderHelper
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.InteractionHandSide
 *  net.minecraftforge.client.event.EntityViewRenderEvent$FogColors
 *  net.minecraftforge.client.event.EntityViewRenderEvent$FogDensity
 *  net.minecraftforge.client.event.FOVUpdateEvent
 *  net.minecraftforge.client.event.RenderHandEvent
 *  net.minecraftforge.client.event.RenderLivingEvent$Post
 *  net.minecraftforge.client.event.RenderLivingEvent$Pre
 *  net.minecraftforge.client.event.RenderWorldLastEvent
 *  net.minecraftforge.event.entity.player.ItemTooltipEvent
 *  net.minecraftforge.event.world.WorldEvent$Unload
 *  net.minecraftforge.fml.common.Mod$EventBusSubscriber
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.network.FMLNetworkEvent$ClientDisconnectionFromServerEvent
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.common.events;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.PlayerSP;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.InteractionHandSide;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.client.event.FOVUpdateEvent;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.dimension.util.DimensionNoBuild;
import xol.lostinfinity.init.DimensionInit;
import xol.lostinfinity.item.basics.ItemChanneling;
import xol.lostinfinity.item.classify.ICustomHoldPose;
import xol.lostinfinity.mob.entity.cthulhu.EntityCthulhu;
import xol.lostinfinity.mob.entity.galaxy.EntityGalaxyDragon;
import xol.lostinfinity.mob.entity.minion.EntityBombDrone;
import xol.lostinfinity.mob.entity.minion.andromeda.EntityAndromedaSegment;

@Mod.EventBusSubscriber(value={Side.CLIENT})
public class EventsClientRender {
    private static final Map<Integer, Entity> renderLast = new HashMap<Integer, Entity>();
    private static final Map<Integer, Entity> rendered = new HashMap<Integer, Entity>();
    public static final Map<Integer, Entity> renderForce = new HashMap<Integer, Entity>();
    private static boolean lock = false;

    @SideOnly(value=Side.CLIENT)
    @SubscribeEvent
    public void onFogEvent(EntityViewRenderEvent.FogColors event) {
        if (event.getEntity().field_70170_p.field_73011_w.func_186058_p() == DimensionInit.nonexistence) {
            float var_clr;
            double height = event.getEntity().field_70163_u - 30.0;
            if (height < 0.0) {
                height = 0.0;
            }
            if ((var_clr = (float)height / 400.0f) > 0.5f) {
                var_clr = 0.5f;
            }
            event.setRed(var_clr);
            event.setGreen(var_clr / 2.0f);
            event.setBlue(0.0f);
        } else if (event.getEntity().field_70170_p.field_73011_w.func_186058_p() == DimensionInit.infiniteMurk) {
            event.setRed(0.0f);
            event.setBlue(0.1f);
            event.setGreen(0.05f);
        } else if (event.getEntity().field_70170_p.func_180494_b(event.getEntity().func_180425_c()) instanceof DimensionNoBuild) {
            event.setRed(0.0f);
            event.setBlue(0.0f);
            event.setGreen(0.0f);
        }
    }

    @SideOnly(value=Side.CLIENT)
    @SubscribeEvent
    public void onFogDensity(EntityViewRenderEvent.FogDensity event) {
        if (event.getEntity().field_70170_p.field_73011_w.func_186058_p() == DimensionInit.nonexistence) {
            event.setDensity(0.03f);
            event.setCanceled(true);
        }
    }

    @SideOnly(value=Side.CLIENT)
    @SubscribeEvent(receiveCanceled=true)
    public void itemToolTip(ItemTooltipEvent event) {
        if (event.getItemStack().func_77942_o() && event.getItemStack().func_77978_p().func_74764_b("InfinityMiraged")) {
            event.getToolTip().add(TextFmt.getFormatting(TextFmt.Italic, TextFmt.Aqua) + "MIRAGED");
        }
    }

    @SideOnly(value=Side.CLIENT)
    @SubscribeEvent
    public static void onRenderHand(RenderHandEvent event) {
        PlayerSP player = Minecraft.func_71410_x().field_71439_g;
        if (player.func_82150_aj()) {
            event.setCanceled(true);
        }
    }

    @SideOnly(value=Side.CLIENT)
    @SubscribeEvent
    public static void onRenderPlayer(RenderLivingEvent.Pre<Player> event) {
        if (!(event.getEntity() instanceof Player)) {
            return;
        }
        Player player = (Player)event.getEntity();
        if (player.func_82150_aj()) {
            event.setCanceled(true);
        }
        if (player.func_184208_bv() instanceof EntityBombDrone) {
            GlStateManager.func_179094_E();
            GlStateManager.func_179152_a((float)0.0f, (float)0.0f, (float)0.0f);
        }
        InteractionHand right = InteractionHand.MAIN_HAND;
        InteractionHand left = InteractionHand.OFF_HAND;
        if (player instanceof PlayerSP && player.func_184591_cq() == InteractionHandSide.LEFT) {
            right = InteractionHand.OFF_HAND;
            left = InteractionHand.MAIN_HAND;
        }
        if (event.getRenderer().func_177087_b() instanceof ModelBiped) {
            if (EventsClientRender.isHoldingCustomPose(player, right)) {
                ((ModelBiped)event.getRenderer().func_177087_b()).field_187076_m = ModelBiped.ArmPose.BOW_AND_ARROW;
            } else if (EventsClientRender.isHoldingCustomPose(player, left)) {
                ((ModelBiped)event.getRenderer().func_177087_b()).field_187075_l = ModelBiped.ArmPose.BOW_AND_ARROW;
            }
        }
    }

    @SideOnly(value=Side.CLIENT)
    @SubscribeEvent
    public static void onPostRenderPlayer(RenderLivingEvent.Post<Player> event) {
        if (!(event.getEntity() instanceof Player)) {
            return;
        }
        Player player = (Player)event.getEntity();
        if (player.func_82150_aj()) {
            event.setCanceled(true);
        }
        if (player.func_184208_bv() instanceof EntityBombDrone) {
            GlStateManager.func_179121_F();
        }
    }

    @SideOnly(value=Side.CLIENT)
    @SubscribeEvent
    public static void onFOVChange(FOVUpdateEvent event) {
        Player player = event.getEntity();
        ItemStack stack = player.func_184607_cu();
        if (player.func_184587_cr() && stack.func_77973_b() instanceof ItemChanneling) {
            ItemChanneling channeling = (ItemChanneling)stack.func_77973_b();
            float oldFOV = event.getFov();
            event.setNewfov(channeling.updateFOV(player, stack, oldFOV));
        }
    }

    private static boolean isHoldingCustomPose(Player player, InteractionHand hand) {
        return player.func_184586_b(hand).func_77973_b() instanceof ICustomHoldPose;
    }

    @SideOnly(value=Side.CLIENT)
    @SubscribeEvent
    public static void onRenderGalaxyDragon(RenderLivingEvent.Pre<EntityGalaxyDragon> event) {
        if (lock || !(event.getEntity() instanceof EntityGalaxyDragon)) {
            return;
        }
        EntityGalaxyDragon dragon = (EntityGalaxyDragon)event.getEntity();
        if (Minecraft.func_71410_x().field_71474_y.field_74320_O == 0 && Minecraft.func_71410_x().field_71439_g.func_184208_bv() == dragon) {
            event.setCanceled(true);
            renderLast.put(dragon.func_145782_y(), (Entity)dragon);
        }
    }

    @SideOnly(value=Side.CLIENT)
    @SubscribeEvent
    public static void onRenderAndromeda(RenderLivingEvent.Pre<EntityAndromedaSegment> event) {
        if (lock || !(event.getEntity() instanceof EntityAndromedaSegment)) {
            return;
        }
        EntityAndromedaSegment segment = (EntityAndromedaSegment)event.getEntity();
        Player owner = segment.getController().getOwner();
        if (owner != null && owner == Minecraft.func_71410_x().field_71439_g && segment.func_70068_e((Entity)owner) <= 900.0) {
            event.setCanceled(true);
            renderLast.put(segment.func_145782_y(), (Entity)segment);
        } else {
            rendered.put(segment.func_145782_y(), (Entity)segment);
        }
    }

    @SideOnly(value=Side.CLIENT)
    @SubscribeEvent
    public static void onRenderCthulhu(RenderLivingEvent.Pre<EntityCthulhu> event) {
        if (lock || !(event.getEntity() instanceof EntityCthulhu)) {
            return;
        }
        EntityCthulhu cthulhu = (EntityCthulhu)event.getEntity();
        rendered.put(cthulhu.func_145782_y(), (Entity)cthulhu);
    }

    @SideOnly(value=Side.CLIENT)
    @SubscribeEvent
    public static void onRenderLast(RenderWorldLastEvent event) {
        if (renderLast.isEmpty() && renderForce.isEmpty()) {
            rendered.clear();
            return;
        }
        lock = true;
        GlStateManager.func_179127_m();
        RenderHelper.func_74519_b();
        Minecraft.func_71410_x().field_71460_t.func_180436_i();
        Iterator<Integer> i = renderForce.keySet().iterator();
        while (i.hasNext()) {
            int id = i.next();
            Entity entity = renderForce.get(id);
            if (entity == null || entity.field_70128_L) {
                i.remove();
                continue;
            }
            if (rendered.containsKey(id) || renderLast.containsKey(id)) continue;
            Minecraft.func_71410_x().func_175598_ae().func_188388_a(entity, event.getPartialTicks(), false);
        }
        for (Entity entity : renderLast.values()) {
            if (entity == null || entity.field_70128_L) continue;
            Minecraft.func_71410_x().func_175598_ae().func_188388_a(entity, event.getPartialTicks(), false);
        }
        Minecraft.func_71410_x().field_71460_t.func_175072_h();
        RenderHelper.func_74518_a();
        GlStateManager.func_179106_n();
        lock = false;
        renderLast.clear();
        rendered.clear();
    }

    @SubscribeEvent
    public void onClientDisconnect(FMLNetworkEvent.ClientDisconnectionFromServerEvent event) {
        renderLast.clear();
        renderForce.clear();
        rendered.clear();
    }

    @SubscribeEvent
    public void onPlayerChangeWorld(WorldEvent.Unload event) {
        renderLast.clear();
        renderForce.clear();
        rendered.clear();
    }
}

