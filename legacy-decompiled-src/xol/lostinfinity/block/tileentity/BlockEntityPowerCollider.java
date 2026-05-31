/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.ItemEntity
 *  net.minecraft.item.ItemStack
 *  net.minecraft.tileentity.BlockEntity
 *  net.minecraft.util.ITickable
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3i
 */
package xol.lostinfinity.block.tileentity;

import java.util.ArrayList;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.util.ITickable;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import xol.lostinfinity.dimension.data.PowerColliderGrid;
import xol.lostinfinity.dimension.data.PowerColliderNode;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;

public class BlockEntityPowerCollider
extends BlockEntity
implements ITickable {
    private static final int dimension = 25;
    private static final Vec3i offset = new Vec3i(0, 0, 0);
    private Vec3i upDir = new Vec3i(0, 0, 1);
    private Vec3i leftDir = new Vec3i(1, 0, 0);
    private ArrayList<BlockPos> tiles = new ArrayList();
    private boolean game = false;
    private static final int numTicks = 3;
    private static final int numPaths = 2;
    private static final int minLength = 25;
    private BlockPos ref = null;
    private ArrayList<ArrayList<PowerColliderNode>> tracks = null;
    private int[] trackIndices = null;
    private PowerColliderGrid grid = null;
    private boolean[] trackActive = null;
    private boolean wonLast = false;

    public void setUpDir(Vec3i upDir) {
        this.upDir = upDir;
    }

    public void setLeftDir(Vec3i leftDir) {
        this.leftDir = leftDir;
    }

    private Vec3i findTileDir(BlockPos pos) {
        ArrayList<Vec3i> dirs = new ArrayList<Vec3i>();
        dirs.add(new Vec3i(1, 0, 1));
        dirs.add(new Vec3i(-1, 0, 1));
        dirs.add(new Vec3i(-1, 0, -1));
        dirs.add(new Vec3i(1, 0, -1));
        for (Vec3i dir : dirs) {
            if (!this.field_145850_b.func_180495_p(pos.func_177971_a(dir)).func_177230_c().equals(BlockInit.powerColliderTrack)) continue;
            return dir;
        }
        return null;
    }

    public void reset() {
        this.tiles.clear();
        BlockPos ref = this.field_174879_c.func_177971_a(offset);
        Vec3i dir = new Vec3i(-1, 0, 1);
        Vec3i upDir = new Vec3i(0, 0, 1);
        Vec3i leftDir = new Vec3i(-1, 0, 0);
        this.ref = ref = ref.func_177971_a(dir);
        int leftCount = 25;
        int upCount = 25;
        this.grid = new PowerColliderGrid(leftCount, upCount, 25, 2);
        this.tracks = this.grid.getPaths();
        if (this.tracks == null || this.tracks.size() < 1) {
            return;
        }
        this.trackIndices = new int[this.tracks.size()];
        this.trackActive = new boolean[this.tracks.size()];
        for (int k = 0; k < this.trackIndices.length; ++k) {
            this.trackIndices[k] = this.tracks.get(k).size() - 1;
            this.trackActive[k] = false;
        }
        for (int i = 0; i < upCount; ++i) {
            for (int j = 0; j < leftCount; ++j) {
                BlockPos tile = ref.func_177982_a(upDir.func_177958_n() * i + leftDir.func_177958_n() * j, 0, upDir.func_177952_p() * i + leftDir.func_177952_p() * j);
                PowerColliderNode node = this.grid.getNodeAtLocation(i, j);
                boolean isTrack = false;
                boolean start = false;
                boolean end = false;
                if (node != null) {
                    for (ArrayList<PowerColliderNode> track : this.tracks) {
                        if (!track.contains(node)) continue;
                        if (track.indexOf(node) == track.size() - 1) {
                            start = true;
                        }
                        if (track.indexOf(node) == 0) {
                            end = true;
                        }
                        isTrack = true;
                        break;
                    }
                }
                if (isTrack) {
                    if (start) {
                        this.field_145850_b.func_175656_a(tile, BlockInit.powerColliderTrack.func_176203_a(1));
                    } else if (end) {
                        this.field_145850_b.func_175656_a(tile, BlockInit.powerColliderTrack.func_176203_a(2));
                    } else {
                        this.field_145850_b.func_175656_a(tile, BlockInit.powerColliderTrack.func_176203_a(0));
                    }
                } else {
                    this.field_145850_b.func_175656_a(tile, BlockInit.neosteelBlack.func_176223_P());
                }
                this.tiles.add(tile);
            }
        }
        this.upDir = upDir;
        this.leftDir = leftDir;
        this.game = true;
        this.field_145850_b.func_184133_a(null, this.field_174879_c, SoundInit.MANUFACTURE_MACHINE, SoundSource.BLOCKS, 1.0f, 1.0f);
    }

    public void setTiles(ArrayList<BlockPos> tiles) {
        this.tiles = tiles;
    }

    public void func_73660_a() {
        if (!this.field_145850_b.field_72995_K && this.field_145850_b.func_82737_E() % 3L == 0L && this.game && this.trackActive != null) {
            int count = 0;
            if (this.wonLast) {
                ++count;
                this.wonLast = false;
            }
            for (int i = 0; i < this.trackActive.length; ++i) {
                if (!this.trackActive[i]) continue;
                ArrayList<PowerColliderNode> track = this.tracks.get(i);
                int index = this.trackIndices[i];
                PowerColliderNode trackNode = track.get(index);
                BlockPos trackPos = this.ref.func_177982_a(this.upDir.func_177958_n() * trackNode.getX() + this.leftDir.func_177958_n() * trackNode.getZ(), 0, this.upDir.func_177952_p() * trackNode.getX() + this.leftDir.func_177952_p() * trackNode.getZ());
                if (index > 0) {
                    this.field_145850_b.func_175656_a(trackPos, BlockInit.powerColliderTrack.func_176203_a(0));
                    this.trackIndices[i] = index - 1;
                    trackNode = track.get(index - 1);
                    trackPos = this.ref.func_177982_a(this.upDir.func_177958_n() * trackNode.getX() + this.leftDir.func_177958_n() * trackNode.getZ(), 0, this.upDir.func_177952_p() * trackNode.getX() + this.leftDir.func_177952_p() * trackNode.getZ());
                    this.field_145850_b.func_175656_a(trackPos, BlockInit.powerColliderTrack.func_176203_a(1));
                    continue;
                }
                this.field_145850_b.func_175656_a(trackPos, BlockInit.powerColliderTrack.func_176203_a(2));
                this.trackIndices[i] = track.size() - 1;
                trackNode = track.get(track.size() - 1);
                trackPos = this.ref.func_177982_a(this.upDir.func_177958_n() * trackNode.getX() + this.leftDir.func_177958_n() * trackNode.getZ(), 0, this.upDir.func_177952_p() * trackNode.getX() + this.leftDir.func_177952_p() * trackNode.getZ());
                this.field_145850_b.func_175656_a(trackPos, BlockInit.powerColliderTrack.func_176203_a(1));
                this.trackActive[i] = false;
                ++count;
                this.wonLast = true;
            }
            if (count == 2) {
                ItemEntity item = new ItemEntity(this.field_145850_b, (double)this.field_174879_c.func_177958_n(), (double)(this.field_174879_c.func_177956_o() + 2), (double)this.field_174879_c.func_177952_p(), new ItemStack(ItemInit.powerClamp, 1));
                item.field_70159_w = 0.0;
                item.field_70181_x = 0.0;
                item.field_70179_y = 0.0;
                this.field_145850_b.func_72838_d((Entity)item);
                this.game = false;
            }
        }
    }

    public void light(BlockPos pos) {
        if (this.game && this.ref != null && this.grid != null) {
            int i = 0;
            int j = 0;
            if (this.upDir.func_177958_n() == 0) {
                i = Math.abs(pos.func_177952_p() - this.ref.func_177952_p());
                j = Math.abs(pos.func_177958_n() - this.ref.func_177958_n());
            } else {
                j = Math.abs(pos.func_177952_p() - this.ref.func_177952_p());
                i = Math.abs(pos.func_177958_n() - this.ref.func_177958_n());
            }
            PowerColliderNode node = this.grid.getNodeAtLocation(i, j);
            if (node != null && this.trackIndices != null && this.trackActive != null) {
                for (int k = 0; k < this.trackIndices.length; ++k) {
                    int index = this.trackIndices[k];
                    ArrayList<PowerColliderNode> track = this.tracks.get(k);
                    if (index != track.size() - 1) continue;
                    this.field_145850_b.func_184133_a(null, pos, SoundInit.GENERIC_UI_1, SoundSource.BLOCKS, 1.0f, 0.8f * this.field_145850_b.field_73012_v.nextFloat() * 0.4f);
                    PowerColliderNode trackNode = track.get(index);
                    BlockPos trackPos = this.ref.func_177982_a(this.upDir.func_177958_n() * trackNode.getX() + this.leftDir.func_177958_n() * trackNode.getZ(), 0, this.upDir.func_177952_p() * trackNode.getX() + this.leftDir.func_177952_p() * trackNode.getZ());
                    if (!trackPos.equals((Object)pos)) continue;
                    this.trackActive[k] = true;
                    break;
                }
            }
        }
    }
}

