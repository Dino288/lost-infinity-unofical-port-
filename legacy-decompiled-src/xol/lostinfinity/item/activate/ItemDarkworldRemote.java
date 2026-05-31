/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockSlab
 *  net.minecraft.block.BlockStairs
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.player.Player
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.item.activate;

import java.util.ArrayList;
import net.minecraft.world.level.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockStairs;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.player.Player;
import net.minecraft.potion.PotionEffect;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.misc.BlockRemoteControl;
import xol.lostinfinity.block.tileentity.BlockEntityRemoteControl;
import xol.lostinfinity.common.events.EventsMurk;
import xol.lostinfinity.dimension.data.BlockData;
import xol.lostinfinity.dimension.data.CustomWorldSavedData;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.PotionInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemRemoteControl;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class ItemDarkworldRemote
extends ItemRemoteControl {
    private static final int radius = 60;

    public ItemDarkworldRemote(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_AUXWEP);
    }

    @Override
    protected int getCooldown() {
        return 2000;
    }

    @Override
    public BlockRemoteControl getControlBlock() {
        return (BlockRemoteControl)BlockInit.darkworldConverter;
    }

    @Override
    public void tickEffect(BlockEntityRemoteControl te, Level world, BlockPos pos, Player owner) {
        if (!world.field_72995_K && te.getExisted() % 10 == 0 && owner.func_70011_f((double)te.func_174877_v().func_177958_n(), (double)te.func_174877_v().func_177956_o(), (double)te.func_174877_v().func_177952_p()) < 60.0) {
            owner.func_70690_d(new PotionEffect(PotionInit.OTHERWORLDLY, 30));
        }
    }

    @Override
    public void toggleEffect(BlockEntityRemoteControl te, Level worldIn, BlockPos checkpos, Player owner, boolean active) {
        CustomWorldSavedData savedData = CustomWorldSavedData.get(worldIn);
        ArrayList<BlockData> blockData = savedData.getBlockData(te.func_174877_v());
        if (blockData != null) {
            for (BlockData data : blockData) {
                BlockPos pos = data.getPos();
                int meta = data.getMeta();
                int id = data.getId();
                Block block = Block.func_149729_e((int)id);
                worldIn.func_175656_a(pos, block.func_176203_a(meta));
            }
            savedData.clearBlockData(te.func_174877_v());
        }
        if (!active && blockData != null) {
            worldIn.func_184133_a(null, owner.func_180425_c(), SoundInit.SLOW_TRANSITION, SoundSource.PLAYERS, 1.5f, 1.0f);
        } else if (active) {
            worldIn.func_184133_a(null, owner.func_180425_c(), SoundInit.INSTANT_TRANSITION, SoundSource.PLAYERS, 1.5f, 1.0f);
            ArrayList<BlockData> newData = new ArrayList<BlockData>();
            for (int i = -60; i <= 60; ++i) {
                for (int j = -60; j <= 60; ++j) {
                    if (i * i + j * j >= 3600) continue;
                    int k = 0;
                    while ((float)k <= 90.0f) {
                        BlockPos pos = checkpos.func_177982_a(i, k, j);
                        BlockState state = worldIn.func_180495_p(pos);
                        Block block = state.func_177230_c();
                        int id = Block.func_149682_b((Block)block);
                        int meta = block.func_176201_c(state);
                        BlockData data = new BlockData(pos, meta, id);
                        if (!worldIn.func_175623_d(pos)) {
                            newData.add(data);
                        }
                        if (worldIn.func_175623_d(pos)) {
                            if (!worldIn.func_175623_d(pos.func_177977_b()) && worldIn.field_73012_v.nextInt(50) == 0) {
                                CustomParticleConfig config1 = new CustomParticleConfig();
                                config1.setCount(3);
                                config1.createInstance().setParticle(ParticleInit.EXPLOSION_BLUE).setSpread(5.0, 1.0, 5.0).setIgnoreRange(true);
                                config1.createInstance().setParticle(ParticleInit.EXPLOSION_TEAL).setSpread(5.0, 1.0, 5.0).setIgnoreRange(true);
                                CustomParticleConfig config2 = new CustomParticleConfig();
                                config2.createInstance().setParticle(ParticleInit.MURK).setSpread(10.0, 2.0, 10.0).setCount(7).setIgnoreRange(true);
                                IParticleSpawner.spawnParticle(worldIn, config1, (double)pos.func_177958_n(), (double)pos.func_177956_o(), (double)pos.func_177952_p());
                                IParticleSpawner.spawnParticle(worldIn, config2, (double)pos.func_177958_n(), (double)pos.func_177956_o(), (double)pos.func_177952_p());
                                if (worldIn.field_73012_v.nextInt(3) == 0) {
                                    worldIn.func_184133_a(null, pos, this.randomWhisper(worldIn.field_73012_v.nextInt(5)), SoundSource.PLAYERS, 1.25f, 0.7f + worldIn.field_73012_v.nextFloat() * 0.6f);
                                }
                            }
                        } else {
                            boolean canChange = true;
                            if (!block.func_149686_d(state) && !(block instanceof BlockStairs) && !(block instanceof BlockSlab) || block.func_149716_u()) {
                                canChange = false;
                            }
                            if (canChange) {
                                if (block.getRegistryName().toString().contains("obsidian")) {
                                    worldIn.func_175656_a(pos, BlockInit.glowingIgneousMurkstone.func_176223_P());
                                } else {
                                    worldIn.func_175656_a(pos, EventsMurk.getBlockToPlace(state, pos.func_177956_o() + k));
                                }
                            }
                        }
                        ++k;
                    }
                }
            }
            if (newData.size() > 0) {
                savedData.setBlockData(newData, te.func_174877_v());
            }
        }
    }

    private SoundEvent randomWhisper(int i) {
        switch (i) {
            case 0: {
                return SoundInit.WHISPER_1;
            }
            case 1: {
                return SoundInit.WHISPER_2;
            }
            case 2: {
                return SoundInit.WHISPER_3;
            }
            case 3: {
                return SoundInit.WHISPER_4;
            }
            case 4: {
                return SoundInit.WHISPER_5;
            }
        }
        return SoundInit.WHISPER_5;
    }
}

