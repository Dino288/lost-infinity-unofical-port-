/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.tileentity.BlockEntity
 *  net.minecraft.util.ITickable
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3i
 */
package xol.lostinfinity.block.tileentity;

import java.util.ArrayList;
import java.util.Collections;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.util.ITickable;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import xol.lostinfinity.init.BlockInit;

public class BlockEntityAncientSymbolInterpreter
extends BlockEntity
implements ITickable {
    private Vec3i dir = null;
    private int[][] symbols = null;
    private ArrayList<BlockPos> tiles = null;
    private BlockPos first = null;
    private BlockPos second = null;
    private BlockPos ref = null;
    private boolean flipBack = false;
    private static final int numSymbols = 15;

    public void flip(BlockPos pos) {
        if (!this.flipBack) {
            int symbol = this.getSymbol(pos);
            if (this.first == null) {
                this.first = pos;
            } else if (this.second == null) {
                this.second = pos;
                int firstSymbol = this.getSymbol(this.first);
                if (symbol == firstSymbol) {
                    this.field_145850_b.func_175656_a(pos, BlockInit.ancientSymbol.func_176203_a(symbol));
                    this.field_145850_b.func_184133_a(null, pos.func_177984_a(), SoundEvents.field_187750_dc, SoundSource.BLOCKS, 2.0f, 1.0f);
                    this.first = null;
                    this.second = null;
                    return;
                }
                this.flipBack = true;
            } else {
                return;
            }
            this.field_145850_b.func_175656_a(pos, BlockInit.ancientSymbol.func_176203_a(symbol));
            this.field_145850_b.func_184133_a(null, pos.func_177984_a(), SoundEvents.field_187750_dc, SoundSource.BLOCKS, 2.0f, 1.0f);
        }
    }

    public int getSymbol(BlockPos pos) {
        if (this.ref != null && this.symbols != null) {
            int i = Math.abs(pos.func_177958_n() - this.ref.func_177958_n());
            int j = Math.abs(pos.func_177952_p() - this.ref.func_177952_p());
            if (i < this.symbols.length && j < this.symbols[i].length) {
                return this.symbols[i][j];
            }
        }
        return 0;
    }

    public void setSymbol(BlockPos pos, int symbol) {
        if (this.ref != null && this.symbols != null) {
            int i = Math.abs(pos.func_177958_n() - this.ref.func_177958_n());
            int j = Math.abs(pos.func_177952_p() - this.ref.func_177952_p());
            if (i < this.symbols.length && j < this.symbols[i].length) {
                this.symbols[i][j] = symbol;
            }
        }
    }

    public void setDir(Vec3i dir) {
        this.dir = dir;
    }

    public void reset(int dimension) {
        this.first = null;
        this.second = null;
        this.flipBack = false;
        this.ref = null;
        this.symbols = new int[dimension][dimension];
        if (this.dir != null && this.tiles != null) {
            this.ref = this.field_174879_c.func_177971_a(this.dir).func_177982_a(0, -3, 0);
            Collections.shuffle(this.tiles);
            int symbol = 1;
            for (int i = 0; i < this.tiles.size(); i += 2) {
                BlockPos tile2 = this.tiles.get(i + 1);
                BlockPos tile1 = this.tiles.get(i);
                if (tile1 != null && tile2 != null) {
                    this.setSymbol(tile2, symbol);
                    this.setSymbol(tile1, symbol);
                }
                if (symbol >= 15) continue;
                ++symbol;
            }
        }
    }

    public void setTiles(ArrayList<BlockPos> tiles) {
        this.tiles = tiles;
    }

    public void func_73660_a() {
        if (!this.field_145850_b.field_72995_K && this.field_145850_b.func_82737_E() % 20L == 0L && this.flipBack && this.first != null && this.second != null) {
            this.flipBack = false;
            this.field_145850_b.func_175656_a(this.first, BlockInit.ancientSymbol.func_176203_a(0));
            this.field_145850_b.func_175656_a(this.second, BlockInit.ancientSymbol.func_176203_a(0));
            this.first = null;
            this.second = null;
        }
    }
}

