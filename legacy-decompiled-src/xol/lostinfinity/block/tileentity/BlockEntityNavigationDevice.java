/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
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
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.tileentity;

import java.util.ArrayList;
import net.minecraft.world.level.block.Block;
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
import net.minecraft.world.level.Level;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;

public class BlockEntityNavigationDevice
extends BlockEntity
implements ITickable {
    public boolean active = false;
    private Vec3i upDir = null;
    private Vec3i rightDir = null;
    private BlockPos cornerPos = null;
    private ArrayList<BlockPos> sequencePositions = null;
    private int index = 0;
    private int rows = 0;
    private int columns = 0;
    private static final int numArrows = 8;
    private int arrowTimer = 25;
    private int timer = 0;
    private static final Vec3i offset = new Vec3i(0, 0, 0);
    private BlockPos[][] grid = null;
    ArrayList<Integer> sequence = null;

    public void activate() {
        this.active = true;
        if (!this.field_145850_b.field_72995_K) {
            this.startGame();
        }
    }

    private void findDirs() {
        BlockPos ref = this.func_174877_v().func_177971_a(offset);
        if (this.field_145850_b.func_180495_p(ref.func_177982_a(-1, 0, 0)).func_177230_c() == BlockInit.navigationNodule) {
            this.upDir = new Vec3i(1, 0, 0);
            this.rightDir = new Vec3i(0, 0, 1);
        } else if (this.field_145850_b.func_180495_p(ref.func_177982_a(1, 0, 0)).func_177230_c() == BlockInit.navigationNodule) {
            this.upDir = new Vec3i(-1, 0, 0);
            this.rightDir = new Vec3i(0, 0, -1);
        } else if (this.field_145850_b.func_180495_p(ref.func_177982_a(0, 0, 1)).func_177230_c() == BlockInit.navigationNodule) {
            this.upDir = new Vec3i(0, 0, -1);
            this.rightDir = new Vec3i(1, 0, 0);
        } else if (this.field_145850_b.func_180495_p(ref.func_177982_a(0, 0, -1)).func_177230_c() == BlockInit.navigationNodule) {
            this.upDir = new Vec3i(0, 0, 1);
            this.rightDir = new Vec3i(-1, 0, 0);
        }
    }

    private void startGame() {
        this.findDirs();
        BlockPos ref = this.func_174877_v().func_177971_a(offset);
        BlockPos cur = ref.func_177973_b(this.upDir);
        int upCount = 0;
        while (this.field_145850_b.func_180495_p(cur).func_177230_c() == BlockInit.navigationNodule) {
            cur = cur.func_177973_b(this.upDir);
            ++upCount;
        }
        cur = cur.func_177971_a(this.upDir);
        while (this.field_145850_b.func_180495_p(cur).func_177230_c() == BlockInit.navigationNodule) {
            cur = cur.func_177973_b(this.rightDir);
        }
        this.cornerPos = cur = cur.func_177971_a(this.rightDir);
        BlockPos temp = this.cornerPos.func_177971_a(this.rightDir);
        int rightCount = 0;
        while (this.field_145850_b.func_180495_p(temp).func_177230_c() == BlockInit.navigationNodule) {
            temp = temp.func_177971_a(this.rightDir);
            ++rightCount;
        }
        this.grid = new BlockPos[rightCount][upCount];
        this.columns = rightCount;
        this.rows = upCount;
        for (int i = 0; i < rightCount; ++i) {
            for (int j = 0; j < upCount; ++j) {
                BlockPos gridPos;
                this.grid[i][j] = gridPos = this.cornerPos.func_177982_a(this.rightDir.func_177958_n() * i + this.upDir.func_177958_n() * j, 0, this.rightDir.func_177952_p() * i + this.upDir.func_177952_p() * j);
            }
        }
        int randCol = this.field_145850_b.field_73012_v.nextInt(this.columns);
        int randRow = this.field_145850_b.field_73012_v.nextInt(this.rows);
        BlockPos startPos = this.getGridPos(randCol, randRow);
        this.field_145850_b.func_175656_a(startPos, BlockInit.navigationNodule.func_176203_a(1));
        if (startPos == null) {
            return;
        }
        this.sequencePositions = new ArrayList();
        this.sequencePositions.add(startPos);
        this.sequence = new ArrayList();
        BlockPos curPos = startPos;
        for (int i = 0; i < 8; ++i) {
            int dirNum = this.field_145850_b.field_73012_v.nextInt(4);
            int colorNum = this.field_145850_b.field_73012_v.nextInt(3);
            Vec3i toAdd = this.getDir(dirNum);
            int iterations = 0;
            boolean noDir = false;
            BlockPos checkPos = curPos.func_177971_a(toAdd);
            while (this.sequencePositions.contains(checkPos) || this.field_145850_b.func_180495_p(checkPos).func_177230_c() != BlockInit.navigationNodule) {
                int newNum = this.field_145850_b.field_73012_v.nextInt(4);
                while (newNum == dirNum) {
                    newNum = this.field_145850_b.field_73012_v.nextInt(4);
                }
                dirNum = newNum;
                toAdd = this.getDir(dirNum);
                checkPos = curPos.func_177971_a(toAdd);
                if (++iterations <= 5) continue;
                noDir = true;
                break;
            }
            if (noDir) break;
            int metaNum = dirNum + colorNum * 4 + 1;
            this.sequence.add(metaNum);
            this.sequencePositions.add(checkPos);
            curPos = checkPos;
        }
        this.index = 0;
        this.timer = 0;
    }

    private Vec3i getDir(int dirNum) {
        Vec3i toAdd;
        switch (dirNum) {
            default: {
                toAdd = this.upDir;
                break;
            }
            case 3: {
                toAdd = this.rightDir;
                break;
            }
            case 2: {
                toAdd = new Vec3i(-this.upDir.func_177958_n(), 0, -this.upDir.func_177952_p());
                break;
            }
            case 1: {
                toAdd = new Vec3i(-this.rightDir.func_177958_n(), 0, -this.rightDir.func_177952_p());
            }
        }
        return toAdd;
    }

    private BlockPos getGridPos(int col, int row) {
        if (this.grid != null && col >= 0 && col < this.grid.length && row >= 0 && row < this.grid[col].length) {
            return this.grid[col][row];
        }
        return null;
    }

    public boolean isActive() {
        return this.active;
    }

    public void func_73660_a() {
        if (!this.field_145850_b.field_72995_K) {
            if (this.sequence != null && this.index < this.sequence.size()) {
                if (this.timer == this.arrowTimer) {
                    int meta = this.sequence.get(this.index);
                    this.field_145850_b.func_175656_a(this.func_174877_v(), BlockInit.navigationDevice.func_176203_a(meta));
                    this.field_145850_b.func_175690_a(this.field_174879_c, (BlockEntity)this);
                    this.field_145846_f = false;
                    this.field_145850_b.func_184133_a(null, this.field_174879_c, SoundInit.GAME_DING, SoundSource.BLOCKS, 1.0f, 1.0f);
                    ++this.index;
                    this.timer = 0;
                } else {
                    ++this.timer;
                }
            } else {
                this.active = true;
            }
        }
    }

    public void checkCompletion(Player playerIn) {
        this.active = false;
        if (!this.field_145850_b.field_72995_K) {
            boolean foundAll = true;
            if (this.sequencePositions == null || this.sequencePositions.isEmpty()) {
                foundAll = false;
            } else {
                this.field_145850_b.func_175656_a(this.sequencePositions.get(0), BlockInit.navigationNodule.func_176203_a(0));
                this.sequencePositions.remove(0);
                if (this.sequence != null && this.sequencePositions.size() == this.sequence.size()) {
                    for (int i = 0; i < this.sequence.size(); ++i) {
                        int meta = (this.sequence.get(i) - 1) / 4;
                        BlockPos seqPos = this.sequencePositions.get(i);
                        BlockState state = this.field_145850_b.func_180495_p(seqPos);
                        Block block = state.func_177230_c();
                        if (block == BlockInit.navigationNodule) {
                            int blockMeta = block.func_176201_c(state) - 1;
                            if (blockMeta == meta) continue;
                            foundAll = false;
                            break;
                        }
                        foundAll = false;
                        break;
                    }
                }
            }
            this.reset();
            if (foundAll) {
                playerIn.func_145747_a((Component)new Component((Object)((Object)TextFmt.Green) + "Completed the navigation sequence! Here is your reward!"));
                playerIn.func_191521_c(new ItemStack(ItemInit.mechanicalSextant, 1));
            } else {
                playerIn.func_145747_a((Component)new Component((Object)((Object)TextFmt.Red) + "Failed to complete the sequence. Try again"));
            }
        }
    }

    public boolean shouldRefresh(Level world, BlockPos pos, BlockState oldState, BlockState newSate) {
        return false;
    }

    private void reset() {
        this.field_145850_b.func_175656_a(this.func_174877_v(), BlockInit.navigationDevice.func_176203_a(0));
        this.field_145846_f = false;
        for (int i = -1; i < this.columns + 1; ++i) {
            for (int j = -1; j < this.rows + 1; ++j) {
                BlockPos checkPos = this.cornerPos.func_177982_a(this.rightDir.func_177958_n() * i + this.upDir.func_177958_n() * j, 0, this.rightDir.func_177952_p() * i + this.upDir.func_177952_p() * j);
                if (this.field_145850_b.func_180495_p(checkPos).func_177230_c() != BlockInit.navigationNodule) continue;
                this.field_145850_b.func_175656_a(checkPos, BlockInit.navigationNodule.func_176203_a(0));
            }
        }
        this.grid = null;
        this.columns = 0;
        this.rows = 0;
        this.active = false;
        this.timer = 0;
        this.sequence = null;
        this.sequencePositions = null;
    }
}

