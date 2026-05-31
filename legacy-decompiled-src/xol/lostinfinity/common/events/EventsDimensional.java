/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.enchantment.Enchantment
 *  net.minecraft.enchantment.EnchantmentHelper
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.ItemEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.Enchantments
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.world.DimensionType
 *  net.minecraftforge.event.world.BlockEvent$BreakEvent
 *  net.minecraftforge.event.world.BlockEvent$EntityPlaceEvent
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package xol.lostinfinity.common.events;

import net.minecraft.world.level.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.DimensionType;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import xol.lostinfinity.block.basic.BlockStarforgeOre;
import xol.lostinfinity.block.basic.ISpecialHarvest;
import xol.lostinfinity.block.misc.BlockPowerCrystal;
import xol.lostinfinity.dimension.util.DimensionActivator;
import xol.lostinfinity.dimension.util.DimensionNoBuild;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.DimensionInit;
import xol.lostinfinity.init.ItemInit;

public class EventsDimensional {
    @SubscribeEvent
    public void celestialArenaNoBuild(BlockEvent.EntityPlaceEvent event) {
        Player pl;
        if (event.getWorld().func_180494_b(event.getPos()) instanceof DimensionNoBuild && event.getEntity() instanceof Player && !(pl = (Player)event.getEntity()).func_184812_l_() && !(event.getPlacedBlock().func_177230_c() instanceof BlockPowerCrystal) && !event.getPlacedBlock().func_177230_c().equals(Blocks.field_150350_a)) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public void celestialArenaProt(BlockEvent.BreakEvent event) {
        ItemStack held;
        if (event.getWorld().func_180494_b(event.getPos()).equals(DimensionInit.biomeNonexistence) && event.getState().func_177230_c().equals(Blocks.field_189877_df) && event.getPlayer() != null && !(held = event.getPlayer().func_184586_b(event.getPlayer().func_184600_cs())).func_190926_b() && held.func_77973_b().equals(ItemInit.forgeFirePickaxe)) {
            DimensionActivator.transferEntity((Entity)event.getPlayer(), DimensionType.OVERWORLD);
            event.setCanceled(true);
        }
        if (event.getWorld().func_180494_b(event.getPos()) instanceof DimensionNoBuild) {
            if (event.getState().func_177230_c() instanceof BlockStarforgeOre) {
                BlockStarforgeOre block = (BlockStarforgeOre)event.getState().func_177230_c();
                boolean schedule = false;
                if (!block.isDepletedType) {
                    ItemStack held2;
                    if (event.getPlayer() != null && !(held2 = event.getPlayer().func_184586_b(event.getPlayer().func_184600_cs())).func_190926_b() && held2.func_77973_b().equals(ItemInit.forgeFirePickaxe)) {
                        int fortune = EnchantmentHelper.func_77506_a((Enchantment)Enchantments.field_185308_t, (ItemStack)event.getPlayer().func_184614_ca());
                        Item drop = event.getState().func_177230_c().func_180660_a(event.getState(), event.getWorld().field_73012_v, fortune);
                        if (!held2.func_77942_o()) {
                            held2.func_77982_d(new CompoundTag());
                        } else {
                            String[] split = drop.getRegistryName().func_110623_a().split("_");
                            int chargesLeft = held2.func_77978_p().func_74762_e(split[split.length - 2]);
                            if (chargesLeft > 0) {
                                event.getState().func_177230_c().func_176226_b(event.getWorld(), event.getPlayer().func_180425_c().func_177982_a(0, 2, 0), event.getState(), fortune);
                                event.getWorld().func_175656_a(event.getPos(), BlockInit.oreDepleted.func_176223_P());
                                schedule = true;
                                held2.func_77978_p().func_74768_a(split[split.length - 2], chargesLeft - 1);
                            } else {
                                event.setCanceled(true);
                            }
                        }
                    }
                } else {
                    boolean bl = schedule = !event.getWorld().func_184145_b(event.getPos(), (Block)block);
                }
                if (schedule) {
                    int lowestDelay = 10;
                    int highestDelay = 31;
                    int delay = event.getWorld().field_73012_v.nextInt(highestDelay - lowestDelay) + lowestDelay;
                    event.getWorld().func_175684_a(event.getPos(), (Block)block, delay * 20);
                }
            } else if (event.getState().func_177230_c() instanceof ISpecialHarvest) {
                ISpecialHarvest harvest_block = (ISpecialHarvest)event.getState().func_177230_c();
                if (harvest_block.isHarvestable(event.getWorld(), event.getPos(), event.getPlayer())) {
                    if (event.getPlayer().func_184614_ca().func_77973_b() == harvest_block.getToolNeeded()) {
                        if (!event.getWorld().field_72995_K) {
                            ItemEntity crystal = new ItemEntity(event.getWorld(), (double)event.getPos().func_177958_n(), (double)event.getPos().func_177956_o(), (double)event.getPos().func_177952_p(), new ItemStack(harvest_block.getHarvestResult(event.getWorld(), event.getPos())));
                            crystal.field_70159_w = 0.0;
                            crystal.field_70181_x = 0.0;
                            crystal.field_70179_y = 0.0;
                            event.getWorld().func_72838_d((Entity)crystal);
                        }
                        harvest_block.worldHarvestEffect(event.getWorld(), event.getPos(), event.getPlayer());
                    }
                } else {
                    harvest_block.failedHarvest(event.getWorld(), event.getPos(), event.getPlayer());
                }
            }
            event.setCanceled(!event.getPlayer().func_184812_l_());
        }
    }
}

