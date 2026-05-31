/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.block.properties.Property
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.item.ItemEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.util.InteractionResultHolder
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.item.tool;

import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.block.basic.BlockBasicBoolState;
import xol.lostinfinity.block.harvest.BlockSeaClay;
import xol.lostinfinity.block.misc.BlockMoldedSeaClay;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.DimensionInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemBasic;
import xol.lostinfinity.item.classify.ICustomHoldPose;
import xol.lostinfinity.item.classify.ICustomRaytrace;
import xol.lostinfinity.item.classify.IHeldTick;
import xol.lostinfinity.item.classify.IModeSelect;
import xol.lostinfinity.item.classify.ISwitchModels;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.CustomHitResult;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class ItemClayTerraformer
extends ItemBasic
implements IModeSelect,
ISwitchModels,
ICustomRaytrace,
IHeldTick,
ICustomHoldPose {
    private static final Component FAILED_HARVEST = new Component((Object)((Object)TextFmt.Red) + "You can't harvest anything here.");
    private static final Component FAILED_DEPLOY_INSUFFICIENT = new Component((Object)((Object)TextFmt.Red) + "You don't have enough clay stored to form a molded block.");
    private static final String STORED_CLAY_AMOUNT = (Object)((Object)TextFmt.Green) + "You have %d clay stored.";

    public ItemClayTerraformer(String regName) {
        super(regName, TabsInit.TAB_AUXMATS);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack heldItem = playerIn.func_184586_b(handIn);
        if (!worldIn.field_72995_K && worldIn.field_73011_w.func_186058_p() == DimensionInit.shadowSea) {
            if (heldItem.func_77978_p().func_74762_e("mode") == 0) {
                CustomHitResult trace = this.simpleBlockTrace(worldIn, (LivingEntity)playerIn, 15);
                BlockPos startPos = playerIn.func_180425_c();
                if (trace != null) {
                    BlockPos resultPos = new BlockPos(trace.getGrabbedVector());
                    if (!(worldIn.func_180495_p(resultPos).func_177230_c() instanceof BlockSeaClay)) {
                        worldIn.func_184133_a(null, startPos, SoundInit.WEAPON_ERROR, SoundSource.PLAYERS, 1.0f, worldIn.field_73012_v.nextFloat() * 0.2f + 0.9f);
                        playerIn.func_145747_a((Component)FAILED_HARVEST);
                        return super.func_77659_a(worldIn, playerIn, handIn);
                    }
                    BlockState state = worldIn.func_180495_p(resultPos);
                    boolean active = (Boolean)state.func_177229_b((Property)BlockBasicBoolState.ACTIVE);
                    if (active) {
                        worldIn.func_175656_a(resultPos, BlockInit.seaClay.func_176203_a(0));
                        worldIn.func_184133_a(null, startPos, SoundInit.CLAY_SUCK, SoundSource.PLAYERS, 1.0f, worldIn.field_73012_v.nextFloat() * 0.2f + 0.9f);
                        CustomParticleConfig config1 = new CustomParticleConfig();
                        config1.createInstance().setParticle(ParticleInit.CLAY_BUBBLE).setSpread(0.5, 0.5, 0.5).setCount(5).setIgnoreRange(true);
                        IParticleSpawner.spawnParticle(worldIn, config1, (double)resultPos.func_177958_n(), (double)resultPos.func_177956_o(), (double)resultPos.func_177952_p());
                        int clayCount = heldItem.func_77978_p().func_74762_e("stored_clay");
                        if ((clayCount += worldIn.field_73012_v.nextInt(5) + 4) > 100) {
                            clayCount = 100;
                        }
                        heldItem.func_77978_p().func_74768_a("stored_clay", clayCount);
                        String storedClay = STORED_CLAY_AMOUNT;
                        storedClay = storedClay.replace("%d", String.valueOf(clayCount));
                        playerIn.func_145747_a((Component)new Component(storedClay));
                    }
                } else {
                    playerIn.func_145747_a((Component)FAILED_HARVEST);
                }
            } else if (heldItem.func_77978_p().func_74762_e("mode") == 1 && heldItem.func_77978_p().func_74764_b("PreviewX")) {
                BlockPos resultPos = new BlockPos(heldItem.func_77978_p().func_74769_h("PreviewX"), heldItem.func_77978_p().func_74769_h("PreviewY"), heldItem.func_77978_p().func_74769_h("PreviewZ"));
                int clayCount = heldItem.func_77978_p().func_74762_e("stored_clay");
                if (clayCount >= 4) {
                    heldItem.func_77978_p().func_74768_a("stored_clay", clayCount -= 4);
                    worldIn.func_175656_a(resultPos, BlockInit.moldedSeaClay.func_176223_P());
                    worldIn.func_184133_a(null, resultPos, SoundInit.CLAY_PLACE, SoundSource.PLAYERS, 1.0f, worldIn.field_73012_v.nextFloat() * 0.2f + 0.9f);
                    CustomParticleConfig config1 = new CustomParticleConfig();
                    config1.createInstance().setParticle(ParticleInit.CLAY_BLOCK).setSpread(2.0, 2.0, 2.0).setCount(10).setIgnoreRange(true);
                    IParticleSpawner.spawnParticle(worldIn, config1, (double)resultPos.func_177958_n(), (double)resultPos.func_177956_o(), (double)resultPos.func_177952_p());
                    this.checkForStructure(resultPos, worldIn, playerIn);
                    String storedClay = STORED_CLAY_AMOUNT;
                    storedClay = storedClay.replace("%d", String.valueOf(clayCount));
                    playerIn.func_145747_a((Component)new Component(storedClay));
                } else {
                    playerIn.func_145747_a((Component)FAILED_DEPLOY_INSUFFICIENT);
                    worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundInit.WEAPON_ERROR, SoundSource.PLAYERS, 1.0f, worldIn.field_73012_v.nextFloat() * 0.2f + 0.9f);
                }
            }
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    private void checkForStructure(BlockPos block, Level world, Player player) {
        int j;
        int i;
        int range = 5;
        Iterable structureBlocks = BlockPos.func_177980_a((BlockPos)block.func_177982_a(-range, -range, -range), (BlockPos)block.func_177982_a(range, range, range));
        int clayCount = 0;
        boolean doContinue = false;
        for (BlockPos pos : structureBlocks) {
            if (!(world.func_180495_p(pos).func_177230_c() instanceof BlockMoldedSeaClay)) continue;
            ++clayCount;
        }
        for (BlockPos pos : structureBlocks) {
            doContinue = false;
            if (clayCount < 35) break;
            if (!(world.func_180495_p(pos).func_177230_c() instanceof BlockMoldedSeaClay)) continue;
            for (i = 1; i <= 4; ++i) {
                if (world.func_180495_p(pos.func_177982_a(i, 0, 0)).func_177230_c() instanceof BlockMoldedSeaClay) continue;
                doContinue = true;
                break;
            }
            if (doContinue) continue;
            for (i = -1; i >= -4; --i) {
                if (world.func_180495_p(pos.func_177982_a(0, 0, i)).func_177230_c() instanceof BlockMoldedSeaClay) continue;
                doContinue = true;
                break;
            }
            if (doContinue) continue;
            for (i = 1; i <= 4; ++i) {
                for (j = -1; j >= -4; --j) {
                    if (world.func_180495_p(pos.func_177982_a(i, 0, j)).func_177230_c() instanceof BlockMoldedSeaClay) continue;
                    doContinue = true;
                    break;
                }
                if (doContinue) break;
            }
            for (i = 1; i <= 3; ++i) {
                if (world.func_180495_p(pos.func_177982_a(i, 1, -1)).func_177230_c() instanceof BlockMoldedSeaClay) continue;
                doContinue = true;
                break;
            }
            if (doContinue) continue;
            for (i = -1; i >= -3; --i) {
                if (world.func_180495_p(pos.func_177982_a(1, 1, i)).func_177230_c() instanceof BlockMoldedSeaClay) continue;
                doContinue = true;
                break;
            }
            if (doContinue) continue;
            for (i = 1; i <= 3; ++i) {
                for (j = -1; j >= -3; --j) {
                    if (world.func_180495_p(pos.func_177982_a(i, 1, j)).func_177230_c() instanceof BlockMoldedSeaClay) continue;
                    doContinue = true;
                    break;
                }
                if (doContinue) break;
            }
            if (!(world.func_180495_p(pos.func_177982_a(2, 2, -2)).func_177230_c() instanceof BlockMoldedSeaClay)) continue;
            structureBlocks.forEach(pos1 -> {
                if (world.func_180495_p(pos1).func_177230_c() instanceof BlockMoldedSeaClay) {
                    world.func_175698_g(pos1);
                }
            });
            ItemEntity reward = new ItemEntity(world, (double)block.func_177958_n(), (double)block.func_177956_o(), (double)block.func_177952_p(), new ItemStack(ItemInit.claySupportCap, 1));
            reward.field_70159_w = 0.0;
            reward.field_70181_x = 0.0;
            reward.field_70179_y = 0.0;
            world.func_72838_d((Entity)reward);
            world.func_184133_a(null, player.func_180425_c(), SoundInit.CLAY_BUILD, SoundSource.PLAYERS, 1.0f, world.field_73012_v.nextFloat() * 0.2f + 0.9f);
            return;
        }
        for (BlockPos pos : structureBlocks) {
            doContinue = false;
            if (clayCount < 29) break;
            if (!(world.func_180495_p(pos).func_177230_c() instanceof BlockMoldedSeaClay) || !(world.func_180495_p(pos.func_177982_a(4, 0, 0)).func_177230_c() instanceof BlockMoldedSeaClay) || !(world.func_180495_p(pos.func_177982_a(0, 0, -4)).func_177230_c() instanceof BlockMoldedSeaClay) || !(world.func_180495_p(pos.func_177982_a(4, 0, -4)).func_177230_c() instanceof BlockMoldedSeaClay) || !(world.func_180495_p(pos.func_177982_a(0, 1, 0)).func_177230_c() instanceof BlockMoldedSeaClay) || !(world.func_180495_p(pos.func_177982_a(4, 1, 0)).func_177230_c() instanceof BlockMoldedSeaClay) || !(world.func_180495_p(pos.func_177982_a(0, 1, -4)).func_177230_c() instanceof BlockMoldedSeaClay) || !(world.func_180495_p(pos.func_177982_a(4, 1, -4)).func_177230_c() instanceof BlockMoldedSeaClay)) continue;
            for (i = 1; i <= 4; ++i) {
                if (world.func_180495_p(pos.func_177982_a(i, 2, 0)).func_177230_c() instanceof BlockMoldedSeaClay) continue;
                doContinue = true;
                break;
            }
            if (doContinue) continue;
            for (i = -1; i >= -4; --i) {
                if (world.func_180495_p(pos.func_177982_a(0, 2, i)).func_177230_c() instanceof BlockMoldedSeaClay) continue;
                doContinue = true;
                break;
            }
            if (doContinue) continue;
            for (i = -1; i >= -4; --i) {
                if (world.func_180495_p(pos.func_177982_a(4, 2, i)).func_177230_c() instanceof BlockMoldedSeaClay) continue;
                doContinue = true;
                break;
            }
            if (doContinue) continue;
            for (i = -1; i >= -4; --i) {
                if (world.func_180495_p(pos.func_177982_a(2, 2, i)).func_177230_c() instanceof BlockMoldedSeaClay) continue;
                doContinue = true;
                break;
            }
            if (doContinue) continue;
            for (i = 1; i <= 3; ++i) {
                if (i == 2) continue;
                block27: for (j = -1; j >= -4; --j) {
                    switch (j % 2) {
                        case 0: {
                            if (world.func_180495_p(pos.func_177982_a(i, 2, j)).func_177230_c() instanceof BlockMoldedSeaClay) continue block27;
                            doContinue = true;
                            continue block27;
                        }
                        case -1: {
                            if (world.func_175623_d(pos.func_177982_a(i, 2, j))) continue block27;
                            doContinue = true;
                        }
                    }
                }
                if (doContinue) break;
            }
            if (doContinue) continue;
            structureBlocks.forEach(pos1 -> {
                if (world.func_180495_p(pos1).func_177230_c() instanceof BlockMoldedSeaClay) {
                    world.func_175698_g(pos1);
                }
            });
            ItemEntity reward = new ItemEntity(world, (double)block.func_177958_n(), (double)block.func_177956_o(), (double)block.func_177952_p(), new ItemStack(ItemInit.claySupportBase, 1));
            reward.field_70159_w = 0.0;
            reward.field_70181_x = 0.0;
            reward.field_70179_y = 0.0;
            world.func_72838_d((Entity)reward);
            world.func_184133_a(null, player.func_180425_c(), SoundInit.CLAY_BUILD, SoundSource.PLAYERS, 1.0f, world.field_73012_v.nextFloat() * 0.2f + 0.9f);
            return;
        }
        for (BlockPos pos : structureBlocks) {
            doContinue = false;
            if (clayCount < 33) break;
            if (!world.func_175623_d(pos)) continue;
            for (i = 1; i <= 5; ++i) {
                block4 : switch (i) {
                    case 1: {
                        for (j = 1; j <= 4; ++j) {
                            if (world.func_180495_p(pos.func_177982_a(2, j, 0)).func_177230_c() instanceof BlockMoldedSeaClay) continue;
                            doContinue = true;
                            break block4;
                        }
                        break;
                    }
                    case 2: {
                        for (j = 1; j <= 4; ++j) {
                            if (world.func_180495_p(pos.func_177982_a(4, j, -2)).func_177230_c() instanceof BlockMoldedSeaClay) continue;
                            doContinue = true;
                            break block4;
                        }
                        break;
                    }
                    case 3: {
                        for (j = 1; j <= 4; ++j) {
                            if (world.func_180495_p(pos.func_177982_a(2, j, -4)).func_177230_c() instanceof BlockMoldedSeaClay) continue;
                            doContinue = true;
                            break block4;
                        }
                        break;
                    }
                    case 4: {
                        for (j = 1; j <= 4; ++j) {
                            if (world.func_180495_p(pos.func_177982_a(0, j, -2)).func_177230_c() instanceof BlockMoldedSeaClay) continue;
                            doContinue = true;
                            break block4;
                        }
                        break;
                    }
                    case 5: {
                        for (j = 1; j <= 4; ++j) {
                            if (world.func_180495_p(pos.func_177982_a(2, j, -2)).func_177230_c() instanceof BlockMoldedSeaClay) continue;
                            doContinue = true;
                            break block4;
                        }
                        break;
                    }
                }
                if (doContinue) break;
            }
            if (doContinue || !(world.func_180495_p(pos.func_177982_a(1, 2, -2)).func_177230_c() instanceof BlockMoldedSeaClay) || !(world.func_180495_p(pos.func_177982_a(2, 2, -3)).func_177230_c() instanceof BlockMoldedSeaClay) || !(world.func_180495_p(pos.func_177982_a(3, 2, -2)).func_177230_c() instanceof BlockMoldedSeaClay) || !(world.func_180495_p(pos.func_177982_a(2, 2, -1)).func_177230_c() instanceof BlockMoldedSeaClay) || !(world.func_180495_p(pos.func_177982_a(1, 4, -2)).func_177230_c() instanceof BlockMoldedSeaClay) || !(world.func_180495_p(pos.func_177982_a(2, 4, -3)).func_177230_c() instanceof BlockMoldedSeaClay) || !(world.func_180495_p(pos.func_177982_a(3, 4, -2)).func_177230_c() instanceof BlockMoldedSeaClay) || !(world.func_180495_p(pos.func_177982_a(2, 4, -1)).func_177230_c() instanceof BlockMoldedSeaClay)) continue;
            structureBlocks.forEach(pos1 -> {
                if (world.func_180495_p(pos1).func_177230_c() instanceof BlockMoldedSeaClay) {
                    world.func_175698_g(pos1);
                }
            });
            ItemEntity reward = new ItemEntity(world, (double)block.func_177958_n(), (double)block.func_177956_o(), (double)block.func_177952_p(), new ItemStack(ItemInit.clayReinforcement, 1));
            reward.field_70159_w = 0.0;
            reward.field_70181_x = 0.0;
            reward.field_70179_y = 0.0;
            world.func_72838_d((Entity)reward);
            world.func_184133_a(null, player.func_180425_c(), SoundInit.CLAY_BUILD, SoundSource.PLAYERS, 1.0f, world.field_73012_v.nextFloat() * 0.2f + 0.9f);
            return;
        }
    }

    @Override
    public void heldTick(Player player, InteractionHand hand, ItemStack stack) {
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
        }
        Level world = player.field_70170_p;
        if (!player.field_70170_p.field_72995_K && player.field_70173_aa % 5 == 0) {
            CustomHitResult trace;
            if (stack.func_77978_p().func_74764_b("PreviewX")) {
                BlockPos pos = new BlockPos(stack.func_77978_p().func_74769_h("PreviewX"), stack.func_77978_p().func_74769_h("PreviewY"), stack.func_77978_p().func_74769_h("PreviewZ"));
                if (world.func_180495_p(pos).func_177230_c() == BlockInit.selectionPreview) {
                    world.func_175698_g(pos);
                }
                stack.func_77978_p().func_82580_o("PreviewX");
                stack.func_77978_p().func_82580_o("PreviewY");
                stack.func_77978_p().func_82580_o("PreviewZ");
            }
            if (stack.func_77978_p().func_74762_e("mode") == 1 && (trace = this.simpleBlockTrace(world, (LivingEntity)player, 15)) != null) {
                BlockPos result = trace.getResultPos();
                world.func_175656_a(result, BlockInit.selectionPreview.func_176223_P());
                stack.func_77978_p().func_74780_a("PreviewX", (double)result.func_177958_n());
                stack.func_77978_p().func_74780_a("PreviewY", (double)result.func_177956_o());
                stack.func_77978_p().func_74780_a("PreviewZ", (double)result.func_177952_p());
            }
        }
    }

    @Override
    public void modeUpdate(ItemStack stack, Player player) {
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
        }
        player.field_70170_p.func_184133_a(null, player.func_180425_c(), SoundEvents.field_187750_dc, SoundSource.PLAYERS, 1.0f, 1.0f);
        int mode = stack.func_77978_p().func_74762_e("mode");
        if (mode == 0) {
            player.func_145747_a((Component)new Component((Object)((Object)TextFmt.Aqua) + "Deploy mode active!"));
            stack.func_77978_p().func_74768_a("mode", 1);
        } else {
            player.func_145747_a((Component)new Component((Object)((Object)TextFmt.Red) + "Harvest Mode active!"));
            stack.func_77978_p().func_74768_a("mode", 0);
        }
    }

    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return false;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
        }
        tooltip.add((Object)((Object)TextFmt.Red) + "Harvest Mode: Collects clay from active sea clay nodes.");
        tooltip.add((Object)((Object)TextFmt.Aqua) + "Deploy Mode: Places sea clay at targeted location.");
        tooltip.add("");
        tooltip.add((Object)((Object)TextFmt.Gold) + "Right Click: Mode Action");
        tooltip.add((Object)((Object)TextFmt.Gold) + "Shift-Right Click: Change Mode");
        tooltip.add("");
        tooltip.add((Object)((Object)TextFmt.Gray) + "Stored Clay: " + stack.func_77978_p().func_74762_e("stored_clay"));
    }
}

