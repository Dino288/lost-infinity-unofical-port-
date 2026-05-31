/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.command.CommandKill
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.entity.player.ServerPlayer
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.Items
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemBucket
 *  net.minecraft.item.ItemStack
 *  net.minecraft.potion.Potion
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Mth
 *  net.minecraft.util.math.HitResult$Type
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.DimensionType
 *  net.minecraft.world.World
 *  net.minecraftforge.event.CommandEvent
 *  net.minecraftforge.event.entity.living.LivingDeathEvent
 *  net.minecraftforge.event.entity.living.LivingEvent$LivingJumpEvent
 *  net.minecraftforge.event.entity.living.LivingHurtEvent
 *  net.minecraftforge.event.entity.living.PotionEvent$PotionAddedEvent
 *  net.minecraftforge.event.entity.living.PotionEvent$PotionExpiryEvent
 *  net.minecraftforge.event.entity.living.PotionEvent$PotionRemoveEvent
 *  net.minecraftforge.event.entity.player.FillBucketEvent
 *  net.minecraftforge.event.entity.player.PlayerInteractEvent
 *  net.minecraftforge.event.world.BlockEvent$HarvestDropsEvent
 *  net.minecraftforge.fluids.UniversalBucket
 *  net.minecraftforge.fml.common.eventhandler.EventPriority
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.PlayerEvent$ItemCraftedEvent
 *  net.minecraftforge.fml.common.gameevent.PlayerEvent$PlayerChangedDimensionEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$Phase
 *  net.minecraftforge.fml.common.gameevent.TickEvent$PlayerTickEvent
 *  net.minecraftforge.fml.server.FMLServerHandler
 */
package xol.lostinfinity.common.events;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.command.CommandKill;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.Items;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;
import net.minecraft.item.ItemBucket;
import net.minecraft.world.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.core.Vec3i;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.DimensionType;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.CommandEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.living.PotionEvent;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fluids.UniversalBucket;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.server.FMLServerHandler;
import xol.lostinfinity.block.basic.BlockBasicFluid;
import xol.lostinfinity.block.basic.ITetherable;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.dimension.util.DimensionActivator;
import xol.lostinfinity.dimension.util.DimensionEffectRegistry;
import xol.lostinfinity.dimension.util.DimensionNoBuild;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.DimensionInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.PotionInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.item.activate.ItemRiftWalker;
import xol.lostinfinity.item.armor.ItemLostArmor;
import xol.lostinfinity.item.classify.IChargeItem;
import xol.lostinfinity.item.classify.IDimensionSwitch;
import xol.lostinfinity.item.classify.IHeldTick;
import xol.lostinfinity.item.classify.IHotbarTick;
import xol.lostinfinity.item.classify.IMoveTick;
import xol.lostinfinity.item.classify.IPotionReactive;
import xol.lostinfinity.item.classify.ItemSoulbound;
import xol.lostinfinity.mob.entity.base.EntityMultipleLives;
import xol.lostinfinity.mob.entity.misc.EntitySkybooster;
import xol.lostinfinity.util.coordinates.GalaxyCoordinates;
import xol.lostinfinity.util.damagesource.DeathMessage;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.fx.IParticleSpawner;
import xol.lostinfinity.util.player.PlayerManager;

public class EventsPlayerAction
implements IMaxAttack {
    private final Map<Player, ItemStack> clientMainhandItem = new ConcurrentHashMap<Player, ItemStack>();
    private final Map<Player, ItemStack> serverMainhandItem = new ConcurrentHashMap<Player, ItemStack>();
    private final Map<Player, ItemStack> clientOffhandItem = new ConcurrentHashMap<Player, ItemStack>();
    private final Map<Player, ItemStack> serverOffhandItem = new ConcurrentHashMap<Player, ItemStack>();

    private Player getPlayerByUUID(Level world, UUID uuid) {
        return uuid == null ? null : (world.field_72995_K ? FMLServerHandler.instance().getServer().func_184103_al().func_177451_a(uuid) : world.func_73046_m().func_184103_al().func_177451_a(uuid));
    }

    @SubscribeEvent
    public void onDimensionTransfer(PlayerEvent.PlayerChangedDimensionEvent event) {
        ItemStack stack;
        Item item;
        ItemSoulbound.removeSoulBound(event.player);
        if (!(event.fromDim != DimensionInit.celestialVoid.func_186068_a() && event.fromDim != DimensionInit.grandmasterOutpost.func_186068_a() || event.player.field_70170_p.field_72995_K)) {
            event.player.func_184589_d(Potion.func_188412_a((int)23));
        }
        if ((item = (stack = event.player.func_184614_ca()).func_77973_b()) instanceof IDimensionSwitch) {
            ((IDimensionSwitch)item).onDimensionSwitch(event.player, stack);
        }
    }

    @SubscribeEvent
    public void onPlayerCraft(PlayerEvent.ItemCraftedEvent event) {
        Player crafter = event.player;
        if (!crafter.field_70170_p.field_72995_K && event.crafting.func_77973_b() == ItemInit.puzzleKey) {
            crafter.func_145747_a((Component)new Component((Object)((Object)TextFmt.Dark_Aqua) + "The Echo: I see everywhere " + crafter.func_70005_c_() + ". Are you looking to play" + (Object)((Object)TextFmt.Reset) + (Object)((Object)TextFmt.Gold) + " one last game?"));
        }
    }

    @SubscribeEvent
    public void onPlayerHurt(LivingHurtEvent event) {
        if (!event.getEntity().func_130014_f_().field_72995_K && event.getEntity() instanceof Player) {
            Player owner;
            if (event.getSource() == DamageSource.field_76380_i && event.getEntity().field_70170_p.field_73011_w.func_186058_p() == DimensionInit.nonexistence) {
                BlockPos teleport = GalaxyCoordinates.galaxyDungeonEntry();
                ((Player)event.getEntity()).func_70634_a((double)teleport.func_177958_n(), (double)teleport.func_177956_o(), (double)teleport.func_177952_p());
                ((Player)event.getEntity()).field_70143_R = -1.0f;
                event.setCanceled(true);
            }
            if (PlayerManager.isWearingAnySet(owner = (Player)event.getEntity())) {
                event.setCanceled(true);
            } else {
                ItemStack vessel = null;
                for (int i = 0; i <= 8; ++i) {
                    ItemStack stack = owner.field_71071_by.func_70301_a(i);
                    if (!stack.func_77973_b().equals(ItemInit.lifeVessel) || !stack.func_77942_o() || this.getPlayerByUUID(event.getEntity().field_70170_p, stack.func_77978_p().func_186857_a("target")) == null) continue;
                    vessel = stack;
                    break;
                }
                if (vessel != null) {
                    ServerPlayer target = owner.field_70170_p.func_73046_m().func_184103_al().func_177451_a(vessel.func_77978_p().func_186857_a("target"));
                    if (target != null) {
                        if (!target.field_70128_L) {
                            target.func_130011_c((Entity)owner);
                            target.func_184185_a(SoundEvents.field_187718_dS, 2.0f, 3.0f);
                            target.func_70606_j(target.func_110143_aJ() - event.getAmount());
                            owner.func_184185_a(SoundEvents.field_187604_bf, 1.0f, 1.0f);
                            if (event.getSource().func_76347_k()) {
                                target.func_70015_d(5);
                            }
                            if (target.func_110143_aJ() <= 0.0f) {
                                vessel.func_77978_p().func_82580_o("targetMost");
                                vessel.func_77978_p().func_82580_o("targetLeast");
                                vessel.func_77978_p().func_82580_o("targetName");
                                owner.func_184185_a(SoundEvents.field_187561_bM, 1.0f, 1.0f);
                                target.func_70066_B();
                                target.func_70645_a(event.getSource());
                                target.func_70106_y();
                            }
                            event.setCanceled(true);
                            return;
                        }
                    } else {
                        vessel.func_77978_p().func_82580_o("targetMost");
                        vessel.func_77978_p().func_82580_o("targetLeast");
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public void onPlayerDeath(LivingDeathEvent event) {
        Player owner;
        if (event.getEntity() instanceof Player && (owner = (Player)event.getEntity()) != null) {
            ServerPlayer victim;
            ItemStack vessel = null;
            for (int i = 0; i <= 8; ++i) {
                ItemStack stack = owner.field_71071_by.func_70301_a(i);
                if (!stack.func_77973_b().equals(ItemInit.lifeVessel) || !stack.func_77942_o() || owner.field_70170_p.func_73046_m().func_184103_al().func_177451_a(stack.func_77978_p().func_186857_a("target")) == null) continue;
                vessel = stack;
                break;
            }
            if (vessel != null && (victim = owner.field_70170_p.func_73046_m().func_184103_al().func_177451_a(vessel.func_77978_p().func_186857_a("target"))) != null && !victim.field_70128_L) {
                vessel.func_77978_p().func_82580_o("targetMost");
                vessel.func_77978_p().func_82580_o("targetLeast");
                vessel.func_77978_p().func_82580_o("targetName");
                owner.func_184185_a(SoundEvents.field_187561_bM, 1.0f, 1.0f);
                IMaxAttack.dealMaxHealth((Entity)owner, (LivingEntity)victim, 1);
                owner.func_70606_j(owner.func_110138_aP());
                event.setCanceled(true);
            }
        }
    }

    @SubscribeEvent
    public void onBucketFill(FillBucketEvent event) {
        BlockState block;
        if (event.getTarget() != null && event.getTarget().field_72313_a == HitResult.Type.BLOCK && (block = event.getWorld().func_180495_p(event.getTarget().func_178782_a())).func_177230_c() instanceof BlockBasicFluid) {
            ((BlockBasicFluid)block.func_177230_c()).handleFill(event, block);
        }
    }

    @SubscribeEvent
    public void rightClickBlock(PlayerInteractEvent event) {
        ItemStack stack = event.getItemStack();
        if (event.getPlayer().func_70644_a(PotionInit.SPECTRAL) && event.isCancelable() && !stack.func_77973_b().equals(ItemInit.riftWalker)) {
            event.setCanceled(true);
        }
        if (event.getPlayer().func_70644_a(PotionInit.PHASED) && event.isCancelable()) {
            event.setCanceled(true);
        }
        if ((stack.func_77973_b() instanceof ItemBucket && !stack.func_77973_b().equals(Items.field_151133_ar) || stack.func_77973_b() instanceof UniversalBucket) && event.getWorld().func_180494_b(event.getPos()) instanceof DimensionNoBuild) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent(priority=EventPriority.LOWEST)
    public void soulboundClear(LivingDeathEvent event) {
        if (!event.isCanceled() && event.getEntity() instanceof Player) {
            ItemSoulbound.removeSoulBound((Player)event.getEntity());
        }
    }

    @SubscribeEvent
    public void onPlayerJump(LivingEvent.LivingJumpEvent event) {
        if (event.getEntity() instanceof Player) {
            Level world = event.getEntity().field_70170_p;
            Player player = (Player)event.getEntity();
            if (!world.field_72995_K) {
                if (world.func_180495_p(player.func_180425_c().func_177977_b()).func_177230_c().equals(BlockInit.launchPad)) {
                    if (world.field_73011_w.func_186058_p() == DimensionType.OVERWORLD) {
                        player.field_70181_x = 0.01;
                        player.field_70133_I = true;
                        EntitySkybooster boost = new EntitySkybooster(world);
                        boost.func_70107_b(player.field_70165_t, player.field_70163_u, player.field_70161_v);
                        boost.setOwner(player);
                        world.func_72838_d((Entity)boost);
                    } else {
                        DimensionActivator.transferEntity((Entity)player, DimensionType.OVERWORLD);
                    }
                } else if (world.func_180495_p(player.func_180425_c().func_177977_b()).func_177230_c().equals(BlockInit.fabricReformulator) || world.func_180495_p(player.func_180425_c().func_177977_b().func_177977_b()).func_177230_c().equals(BlockInit.fabricReformulator)) {
                    if (world.field_73011_w.func_186058_p() == DimensionType.OVERWORLD) {
                        DimensionActivator.transferEntityWithCoords((Entity)player, DimensionInit.infiniteMurk, player.field_70165_t, player.field_70163_u, player.field_70161_v);
                    } else {
                        DimensionActivator.transferEntityWithCoords((Entity)player, DimensionType.OVERWORLD, player.field_70165_t, player.field_70163_u, player.field_70161_v);
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public void onPotionExpire(PotionEvent.PotionExpiryEvent event) {
        if (event.getEntity() != null && event.getEntity() instanceof Player) {
            Player player = (Player)event.getEntity();
            if (event.getPotionEffect().func_188419_a().equals(PotionInit.SPECTRAL)) {
                ItemRiftWalker.endEffect(player);
            }
        }
        if (event.getPotionEffect().func_188419_a().equals(PotionInit.SPONTANEOUS_COMBUSTION) && !event.getEntity().field_70170_p.field_72995_K) {
            int level = event.getMob().func_70660_b(PotionInit.SPONTANEOUS_COMBUSTION).func_76458_c();
            IMaxAttack.dealPotionDamage(event.getMob(), event.getMob().func_110138_aP() * (0.3f + 0.15f * (float)level));
            if (event.getMob() instanceof EntityMultipleLives) {
                EntityMultipleLives multiEntity = (EntityMultipleLives)event.getMob();
                multiEntity.takeawayNumLives(1 + Mth.func_76141_d((float)(level / 2)));
            }
            LivingEntity living = event.getMob();
            CustomParticleConfig config1 = new CustomParticleConfig();
            config1.createInstance().setParticle(ParticleInit.EXPLOSION).setIgnoreRange(true);
            IParticleSpawner.spawnParticle(living.field_70170_p, config1, living.field_70165_t, living.field_70163_u, living.field_70161_v);
            event.getMob().field_70170_p.func_184133_a(null, event.getMob().func_180425_c(), SoundInit.GENERIC_EXPLOSION, SoundSource.PLAYERS, 1.0f, 1.0f);
        }
    }

    @SubscribeEvent
    public void onCommandEvent(CommandEvent event) {
        if (event.getCommand() instanceof CommandKill) {
            String sender = "";
            if (event.getParameters().length == 0) {
                sender = event.getSender().func_70005_c_();
            } else if (event.getParameters().length == 1) {
                sender = event.getParameters()[0];
            }
            ServerPlayer target = event.getSender().func_130014_f_().func_73046_m().func_184103_al().func_152612_a(sender);
            if (target != null) {
                ServerPlayer victim;
                ItemStack vessel = null;
                for (int i = 0; i <= 8; ++i) {
                    ItemStack stack = target.field_71071_by.func_70301_a(i);
                    if (!stack.func_77973_b().equals(ItemInit.lifeVessel) || !stack.func_77942_o() || this.getPlayerByUUID(event.getSender().func_130014_f_(), stack.func_77978_p().func_186857_a("target")) == null) continue;
                    vessel = stack;
                    break;
                }
                if (vessel != null && (victim = event.getSender().func_130014_f_().func_73046_m().func_184103_al().func_177451_a(vessel.func_77978_p().func_186857_a("target"))) != null && !victim.field_70128_L) {
                    vessel.func_77978_p().func_82580_o("targetMost");
                    vessel.func_77978_p().func_82580_o("targetLeast");
                    vessel.func_77978_p().func_82580_o("targetName");
                    target.func_184185_a(SoundEvents.field_187561_bM, 1.0f, 1.0f);
                    IMaxAttack.dealMaxHealth((Entity)target, (LivingEntity)victim, 1);
                    event.setCanceled(true);
                }
            }
        }
    }

    @SubscribeEvent
    public void onHarvestBlock(BlockEvent.HarvestDropsEvent event) {
        Item held;
        if (event.getState().func_177230_c() == Blocks.field_150482_ag) {
            Item held2;
            if (event.getHarvester() != null && (held2 = event.getHarvester().func_184586_b(event.getHarvester().func_184600_cs()).func_77973_b()) != null && held2 == ItemInit.celestialMinersPickaxe && event.getWorld().field_73012_v.nextInt(25) == 1) {
                event.getDrops().add(new ItemStack(ItemInit.celestialDiamond));
            }
        } else if (event.getState().func_177230_c() == Blocks.field_150412_bA) {
            Item held3;
            if (event.getHarvester() != null && (held3 = event.getHarvester().func_184586_b(event.getHarvester().func_184600_cs()).func_77973_b()) != null && held3 == ItemInit.celestialMinersPickaxe && event.getWorld().field_73012_v.nextInt(15) == 1) {
                event.getDrops().add(new ItemStack(ItemInit.celestialEmerald));
            }
        } else if (event.getState().func_177230_c() == Blocks.field_150450_ax || event.getState().func_177230_c() == Blocks.field_150439_ay) {
            Item held4;
            if (event.getHarvester() != null && (held4 = event.getHarvester().func_184586_b(event.getHarvester().func_184600_cs()).func_77973_b()) != null && held4 == ItemInit.celestialMinersPickaxe && event.getWorld().field_73012_v.nextInt(35) == 1) {
                event.getDrops().add(new ItemStack(ItemInit.celestialRedstone));
            }
        } else if (event.getState().func_177230_c() == Blocks.field_150449_bY) {
            Item held5;
            if (event.getHarvester() != null && (held5 = event.getHarvester().func_184586_b(event.getHarvester().func_184600_cs()).func_77973_b()) != null && held5 == ItemInit.celestialMinersPickaxe && event.getWorld().field_73012_v.nextInt(35) == 1) {
                event.getDrops().add(new ItemStack(ItemInit.celestialQuartz));
            }
        } else if (event.getState().func_177230_c() == Blocks.field_150366_p && event.getHarvester() != null && (held = event.getHarvester().func_184586_b(event.getHarvester().func_184600_cs()).func_77973_b()) != null && held == ItemInit.celestialMinersPickaxe && event.getWorld().field_73012_v.nextInt(25) == 1) {
            event.getDrops().add(new ItemStack(ItemInit.celestialIron));
        }
    }

    @SubscribeEvent
    public void onPlayerPotionAdd(PotionEvent.PotionAddedEvent event) {
        ItemStack offItem;
        if (!(event.getMob() instanceof Player)) {
            return;
        }
        Player player = (Player)event.getMob();
        if (player.field_70170_p.field_72995_K) {
            return;
        }
        ItemStack mainItem = player.func_184586_b(InteractionHand.MAIN_HAND);
        if (mainItem.func_77973_b() instanceof IPotionReactive) {
            ((IPotionReactive)mainItem.func_77973_b()).potionAddReaction(player, mainItem, InteractionHand.MAIN_HAND, event.getPotionEffect(), event.getOldPotionEffect());
        }
        if ((offItem = player.func_184586_b(InteractionHand.OFF_HAND)).func_77973_b() instanceof IPotionReactive) {
            ((IPotionReactive)offItem.func_77973_b()).potionAddReaction(player, offItem, InteractionHand.OFF_HAND, event.getPotionEffect(), event.getOldPotionEffect());
        }
    }

    @SubscribeEvent
    public void onPlayerPotionRemove(PotionEvent.PotionRemoveEvent event) {
        ItemStack offItem;
        if (!(event.getMob() instanceof Player)) {
            return;
        }
        Player player = (Player)event.getMob();
        if (player.field_70170_p.field_72995_K) {
            return;
        }
        ItemStack mainItem = player.func_184586_b(InteractionHand.MAIN_HAND);
        if (mainItem.func_77973_b() instanceof IPotionReactive) {
            ((IPotionReactive)mainItem.func_77973_b()).potionRemoveReaction(player, mainItem, InteractionHand.MAIN_HAND, event.getPotion(), event.getPotionEffect());
        }
        if ((offItem = player.func_184586_b(InteractionHand.OFF_HAND)).func_77973_b() instanceof IPotionReactive) {
            ((IPotionReactive)offItem.func_77973_b()).potionRemoveReaction(player, offItem, InteractionHand.OFF_HAND, event.getPotion(), event.getPotionEffect());
        }
    }

    @SubscribeEvent
    public void onTickEvent(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.START) {
            ItemStack held;
            int duration;
            int level;
            int ticksExisted;
            int mirageTime;
            boolean enableArmor = PlayerManager.isWearingAnySet(event.player) && !event.player.func_70644_a(PotionInit.NULLIFIED);
            ItemLostArmor.handleStandardArmorBonus(event.player, enableArmor);
            ItemStack mainHand = event.player.func_184614_ca();
            ItemStack offhand = event.player.func_184592_cb();
            this.processIHeldTick(event.player, InteractionHand.MAIN_HAND, mainHand);
            this.processIHeldTick(event.player, InteractionHand.OFF_HAND, offhand);
            for (int i = 0; i <= 8; ++i) {
                ItemStack stack = event.player.field_71071_by.func_70301_a(i);
                if (!(stack.func_77973_b() instanceof IHotbarTick)) continue;
                IHotbarTick hotbarItem = (IHotbarTick)stack.func_77973_b();
                hotbarItem.hotbarTick(event.player, i, stack);
            }
            if (!event.player.field_70170_p.field_72995_K && mainHand.func_77942_o() && mainHand.func_77978_p().func_74764_b("InfinityMiraged") && Math.abs((mirageTime = mainHand.func_77978_p().func_74762_e("InfinityMiraged")) - (ticksExisted = event.player.field_70173_aa)) > 300) {
                event.player.func_184611_a(InteractionHand.MAIN_HAND, ItemStack.field_190927_a);
                event.player.func_145747_a((Component)new Component((Object)((Object)TextFmt.Aqua) + "The miraged item vanishes into thin air..."));
                event.player.field_70170_p.func_184133_a(null, event.player.func_180425_c(), SoundInit.MAGIC_WEAPON_13, SoundSource.PLAYERS, 1.0f, 0.8f + event.player.field_70170_p.field_73012_v.nextFloat() * 0.4f);
            }
            if (!event.player.field_70170_p.field_72995_K && offhand.func_77942_o() && offhand.func_77978_p().func_74764_b("InfinityMiraged") && Math.abs((mirageTime = offhand.func_77978_p().func_74762_e("InfinityMiraged")) - (ticksExisted = event.player.field_70173_aa)) > 300) {
                event.player.func_184611_a(InteractionHand.OFF_HAND, ItemStack.field_190927_a);
                event.player.func_145747_a((Component)new Component((Object)((Object)TextFmt.Aqua) + "The miraged item vanishes into thin air..."));
                event.player.field_70170_p.func_184133_a(null, event.player.func_180425_c(), SoundInit.MAGIC_WEAPON_13, SoundSource.PLAYERS, 1.0f, 0.8f + event.player.field_70170_p.field_73012_v.nextFloat() * 0.4f);
            }
            DimensionEffectRegistry.tickPlayerDimensionEffects(event.player);
            if (event.player.func_70644_a(PotionInit.DIMENSIONAL_TEAR) && !event.player.field_70170_p.field_72995_K && event.player.field_70173_aa % 30 == 0) {
                if (event.player.func_184614_ca().func_77973_b() == ItemInit.synchronizer || event.player.func_184592_cb().func_77973_b() == ItemInit.synchronizer || event.player.func_184614_ca().func_77973_b() == ItemInit.advancedSynchronizer || event.player.func_184592_cb().func_77973_b() == ItemInit.advancedSynchronizer) {
                    event.player.func_184589_d(PotionInit.DIMENSIONAL_TEAR);
                } else {
                    level = event.player.func_70660_b(PotionInit.DIMENSIONAL_TEAR).func_76458_c() + 1;
                    float damage = (float)level * event.player.func_110138_aP() / 20.0f;
                    IMaxAttack.dealPotionDamage((LivingEntity)event.player, damage);
                    if (event.player.func_110143_aJ() <= 0.0f) {
                        DeathMessage.broadcastDeathMessage(event.player.func_184102_h(), (Object)((Object)TextFmt.Red) + event.player.func_70005_c_() + " was split interdimensionally.");
                    } else {
                        float speedMulti = level / 2;
                        event.player.func_70024_g((double)this.getRandomFloat(event.player, speedMulti), (double)this.getRandomFloat(event.player, speedMulti), (double)this.getRandomFloat(event.player, speedMulti));
                        event.player.field_70133_I = true;
                    }
                }
            }
            if (event.player.func_70644_a(PotionInit.SUPERSONIC) && !event.player.field_70170_p.field_72995_K) {
                boolean found = false;
                if (mainHand.func_77973_b() instanceof IMoveTick) {
                    IMoveTick tickable = (IMoveTick)mainHand.func_77973_b();
                    tickable.moveTick(event.player, InteractionHand.MAIN_HAND, mainHand);
                    found = true;
                }
                if (offhand.func_77973_b() instanceof IMoveTick) {
                    IMoveTick tickable = (IMoveTick)offhand.func_77973_b();
                    tickable.moveTick(event.player, InteractionHand.OFF_HAND, mainHand);
                    found = true;
                }
                if (!found) {
                    event.player.func_184596_c(PotionInit.SUPERSONIC);
                }
            }
            if (event.player.func_70644_a(PotionInit.RAMPAGING) && !event.player.field_70170_p.field_72995_K && event.player.field_70173_aa % 10 == 0) {
                level = event.player.func_70660_b(PotionInit.RAMPAGING).func_76458_c();
                int particleLevel = 16 + Math.floorDiv(level, 4);
                int extra = level % 4;
                CustomParticleConfig config1 = new CustomParticleConfig();
                CustomParticleConfig.Instance instance = config1.createInstance();
                switch (Math.min(18, particleLevel)) {
                    case 16: {
                        instance.setParticle(ParticleInit.FLAME_SMALL).setCount(1 + extra);
                        break;
                    }
                    case 17: {
                        instance.setParticle(ParticleInit.FLAME_MEDIUM).setCount(1 + extra * 2);
                        break;
                    }
                    case 18: {
                        instance.setParticle(ParticleInit.FLAME_LARGE).setCount(1 + extra * 4);
                    }
                }
                instance.setSpread(1.0, 0.0, 1.0).setSpeed(0.3, 0.0, 0.3).setVelSpread(1.0, 0.0, 1.0).setIgnoreRange(true);
                IParticleSpawner.spawnParticle(event.player.field_70170_p, config1, event.player.field_70165_t, event.player.field_70163_u, event.player.field_70161_v);
            }
            if (event.player.func_70644_a(PotionInit.SPECTRAL) && !event.player.field_70170_p.field_72995_K && event.player.field_70173_aa % 10 == 0) {
                CustomParticleConfig config1 = new CustomParticleConfig();
                config1.createInstance().setParticle(ParticleInit.SPECTRAL).setSpread(1.0, 1.0, 1.0).setIgnoreRange(true);
                IParticleSpawner.spawnParticle(event.player.field_70170_p, config1, event.player.field_70165_t, event.player.field_70163_u, event.player.field_70161_v);
            }
            if (event.player.func_70644_a(PotionInit.TERRIFIED) && !event.player.field_70170_p.field_72995_K) {
                double radius = 8.0;
                for (LivingEntity near : event.player.field_70170_p.func_72872_a(LivingEntity.class, new AABB(event.player.func_180425_c()).func_186662_g(radius))) {
                    if (!near.func_70644_a(PotionInit.FEARED)) continue;
                    Vec3 dir = event.player.func_174791_d().func_178788_d(near.func_174791_d()).func_72432_b();
                    event.player.func_70024_g(dir.field_72450_a / 10.0, dir.field_72448_b / 10.0 + 0.1, dir.field_72449_c / 10.0);
                    event.player.field_70133_I = true;
                }
            }
            if (event.player.func_70644_a(PotionInit.CHARGING) && !event.player.field_70170_p.field_72995_K && (duration = event.player.func_70660_b(PotionInit.CHARGING).func_76459_b()) <= 1 && (held = event.player.func_184614_ca()).func_77973_b() instanceof IChargeItem) {
                IChargeItem charger = (IChargeItem)held.func_77973_b();
                charger.endChargeEffect(held, event.player);
                event.player.func_184589_d(PotionInit.CHARGING);
            }
            if (event.player.func_70644_a(PotionInit.TETHERED) && !event.player.field_70170_p.field_72995_K) {
                this.tether(event);
            }
        }
    }

    private void tether(TickEvent.PlayerTickEvent event) {
        double z;
        double y;
        double x;
        double distToLog;
        int radius = 7;
        double pullSpeed = 0.4;
        BlockPos logPos = this.getNearestLog(event, radius);
        if (logPos != null && (distToLog = logPos.func_177954_c(x = event.player.field_70165_t, y = event.player.field_70163_u, z = event.player.field_70161_v)) > 0.0) {
            double diffX = (double)logPos.func_177958_n() - x;
            double diffY = (double)logPos.func_177956_o() - y;
            double diffZ = (double)logPos.func_177952_p() - z;
            Vec3 dir = new Vec3(diffX, diffY, diffZ);
            dir.func_72432_b();
            event.player.field_70159_w = dir.field_72450_a * pullSpeed;
            event.player.field_70181_x = dir.field_72448_b * pullSpeed;
            event.player.field_70179_y = dir.field_72449_c * pullSpeed;
            event.player.field_70133_I = true;
        }
    }

    private BlockPos getNearestLog(TickEvent.PlayerTickEvent event, int radius) {
        double minDist = 99.0;
        BlockPos nearest = null;
        BlockPos playerPos = event.player.func_180425_c();
        for (int x = playerPos.func_177958_n() - radius; x <= playerPos.func_177958_n() + radius; ++x) {
            for (int y = playerPos.func_177956_o() - radius; y <= playerPos.func_177956_o() + radius; ++y) {
                for (int z = playerPos.func_177952_p() - radius; z <= playerPos.func_177952_p() + radius; ++z) {
                    double dist;
                    BlockPos pos = new BlockPos(x, y, z);
                    BlockState state = event.player.field_70170_p.func_180495_p(pos);
                    if (!(state.func_177230_c() instanceof ITetherable) || !((dist = pos.func_185332_f((int)event.player.field_70165_t, (int)event.player.field_70163_u, (int)event.player.field_70161_v)) <= minDist)) continue;
                    minDist = dist;
                    nearest = new BlockPos((Vec3i)pos);
                }
            }
        }
        return nearest;
    }

    private void processIHeldTick(Player player, InteractionHand hand, ItemStack curr) {
        Map<Player, ItemStack> map = hand == InteractionHand.MAIN_HAND ? (player.field_70170_p.field_72995_K ? this.clientMainhandItem : this.serverMainhandItem) : (player.field_70170_p.field_72995_K ? this.clientOffhandItem : this.serverOffhandItem);
        ItemStack prev = map.get(player);
        if (curr.func_77973_b() instanceof IHeldTick) {
            IHeldTick tickable = (IHeldTick)curr.func_77973_b();
            if (curr != prev) {
                tickable.startHolding(player, hand, curr);
                if (prev != null && prev.func_77973_b() instanceof IHeldTick) {
                    IHeldTick oldTickable = (IHeldTick)prev.func_77973_b();
                    oldTickable.stopHolding(player, hand, prev);
                }
                map.put(player, curr);
            }
            tickable.heldTick(player, hand, curr);
        } else if (prev != null && prev.func_77973_b() instanceof IHeldTick) {
            IHeldTick oldTickable = (IHeldTick)prev.func_77973_b();
            oldTickable.stopHolding(player, hand, prev);
            map.remove(player);
        }
    }

    private float getRandomFloat(Player player, float mutli) {
        return (-0.5f + player.field_70170_p.field_73012_v.nextFloat()) * mutli;
    }
}

