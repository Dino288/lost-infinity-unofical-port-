/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.tileentity.BlockEntity
 *  net.minecraft.util.ITickable
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 */
package xol.lostinfinity.block.tileentity;

import java.util.Random;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.util.ITickable;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;

public class BlockEntityCircuitCalibrator
extends BlockEntity
implements ITickable {
    private boolean game = false;
    private int cur = 0;
    private int time = 0;
    private int switchTime = 0;
    private static int timeRange = 10;
    private int baseTime = 25;
    private int score = 0;
    private Player player = null;
    private boolean pressed = false;
    private static Random rand = new Random();
    BlockPos monPos = null;

    public void func_73660_a() {
        if (!this.field_145850_b.field_72995_K && this.game) {
            if (this.score >= 15) {
                this.game = false;
                if (this.player != null) {
                    this.player.func_191521_c(new ItemStack(ItemInit.biosyncedClock));
                    this.player.func_145747_a((Component)new Component((Object)((Object)TextFmt.Green) + "You have managed to fully calibrate the circuit!"));
                    if (this.monPos != null) {
                        this.field_145850_b.func_175656_a(this.monPos, BlockInit.circuitMonitor.func_176203_a(0));
                    }
                }
            } else if (this.score < 0) {
                this.game = false;
                if (this.player != null) {
                    this.player.func_145747_a((Component)new Component((Object)((Object)TextFmt.Dark_Red) + "You have failed to calibrate the circuit."));
                }
            } else if (this.time >= this.switchTime) {
                this.time = 0;
                if (this.baseTime > 12) {
                    this.baseTime -= 3;
                }
                this.switchTime = rand.nextInt(timeRange) + this.baseTime;
                if (this.monPos != null) {
                    int meta = 0;
                    try {
                        meta = BlockInit.circuitMonitor.func_176201_c(this.field_145850_b.func_180495_p(this.monPos));
                    }
                    catch (Exception e) {
                        meta = 0;
                    }
                    int newMeta = 0;
                    switch (meta) {
                        case 0: {
                            newMeta = rand.nextBoolean() ? 1 : 2;
                            break;
                        }
                        case 1: {
                            newMeta = 0;
                            if (this.pressed) {
                                ++this.score;
                                this.field_145850_b.func_184133_a(null, this.field_174879_c, SoundInit.MINIGAME_SCORE, SoundSource.BLOCKS, 1.5f, 0.8f + rand.nextFloat() * 0.4f);
                                this.pressed = false;
                            } else {
                                this.score -= 3;
                                this.field_145850_b.func_184133_a(null, this.field_174879_c, SoundInit.GAME_BUZZER, SoundSource.BLOCKS, 1.5f, 0.8f + rand.nextFloat() * 0.4f);
                            }
                            if (this.player == null) break;
                            this.player.func_145747_a((Component)new Component((Object)((Object)TextFmt.Green) + "Score: " + this.score));
                            break;
                        }
                        case 2: {
                            newMeta = 0;
                            if (!this.pressed) break;
                            this.score -= 3;
                            this.field_145850_b.func_184133_a(null, this.field_174879_c, SoundInit.GAME_BUZZER, SoundSource.BLOCKS, 1.5f, 0.8f + rand.nextFloat() * 0.4f);
                            if (this.player != null) {
                                this.player.func_145747_a((Component)new Component((Object)((Object)TextFmt.Green) + "Score: " + this.score));
                            }
                            this.pressed = false;
                        }
                    }
                    this.field_145850_b.func_175656_a(this.monPos, BlockInit.circuitMonitor.func_176203_a(newMeta));
                    if (newMeta != 0) {
                        this.field_145850_b.func_184133_a(null, this.field_174879_c, SoundInit.BLOCK_DING, SoundSource.BLOCKS, 1.5f, 0.8f + rand.nextFloat() * 0.4f);
                    }
                }
            } else {
                ++this.time;
            }
        }
    }

    public void startGame() {
        this.pressed = false;
        this.game = true;
        this.cur = 0;
        this.time = 0;
        this.baseTime = 32;
        this.score = 0;
        this.switchTime = rand.nextInt(timeRange) + this.baseTime;
        int radius = 7;
        Vec3i offset = new Vec3i(0, 0, 0);
        block0: for (int i = -radius; i <= radius; ++i) {
            for (int k = -radius; k <= radius; ++k) {
                BlockPos check = this.func_174877_v().func_177971_a(offset).func_177982_a(i, 0, k);
                BlockState state = this.field_145850_b.func_180495_p(check);
                if (state.func_177230_c() != BlockInit.circuitMonitor) continue;
                this.monPos = check;
                this.field_145850_b.func_175656_a(this.monPos, BlockInit.circuitMonitor.func_176203_a(0));
                break block0;
            }
        }
    }

    public void press(int meta, BlockPos pos, Player playerIn) {
        this.monPos = pos;
        this.player = playerIn;
        if (meta == 2 || meta == 1) {
            this.pressed = true;
            this.time = this.switchTime;
        }
    }
}

