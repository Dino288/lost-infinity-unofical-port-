/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.tileentity.BlockEntity
 *  net.minecraft.util.Direction
 *  net.minecraft.util.ITickable
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.util.math.Vec3i
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.block.tileentity;

import java.util.ArrayList;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.core.Direction;
import net.minecraft.util.ITickable;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.Vec3;
import net.minecraft.core.Vec3i;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.block.activator.BlockLightEmitter;
import xol.lostinfinity.block.activator.BlockLightReflector;
import xol.lostinfinity.block.misc.BlockLightReceiver;
import xol.lostinfinity.common.lostinfinity;
import xol.lostinfinity.common.packets.serverbound.PacketLightReceiver;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.util.coordinates.GalaxyCoordinates;

public class BlockEntityLightEmitter
extends BlockEntity
implements ITickable {
    private Vec3i dirUp = new Vec3i(0, 0, 1);
    private Vec3i dirLeft = new Vec3i(1, 0, 0);
    private BlockPos finalBlock;
    private boolean complete;
    private ArrayList<Vec3> dirs;
    private ArrayList<Vec3> reflectors;
    private Vec3 startPos;
    private Vec3 stopPos;

    public void func_73660_a() {
        block15: {
            if (!this.field_145850_b.field_72995_K) {
                BlockEntityLightEmitter tileEntity = (BlockEntityLightEmitter)this.field_145850_b.func_175625_s(this.func_174877_v());
                AABB mazeAABB = tileEntity.getLightMazeAABB();
                this.finalBlock = GalaxyCoordinates.getLightReceiver();
                if (this.finalBlock != null) {
                    int radius = 20;
                    for (int i = -radius; i < radius; ++i) {
                        for (int j = -radius; j < radius; ++j) {
                            for (int k = -radius; k < radius; ++k) {
                                BlockPos checkPos = new BlockPos(this.finalBlock.func_177958_n() + i, this.finalBlock.func_177956_o() + j, this.finalBlock.func_177952_p() + k);
                                Block checkBlock = this.field_145850_b.func_180495_p(checkPos).func_177230_c();
                                if (!checkBlock.equals(BlockInit.lightReceiver)) continue;
                                if (this.isComplete()) {
                                    ((BlockLightReceiver)checkBlock).openGate(this.field_145850_b, checkPos);
                                } else {
                                    ((BlockLightReceiver)checkBlock).closeGate(this.field_145850_b, checkPos);
                                }
                                break block15;
                            }
                        }
                    }
                }
            } else {
                this.complete = false;
                BlockState emitterState = this.field_145850_b.func_180495_p(this.func_174877_v());
                BlockLightEmitter emitterBlock = (BlockLightEmitter)this.field_145850_b.func_180495_p(this.func_174877_v()).func_177230_c();
                BlockEntityLightEmitter tileEntity = (BlockEntityLightEmitter)this.field_145850_b.func_175625_s(this.func_174877_v());
                AABB mazeAABB = tileEntity.getLightMazeAABB();
                this.finalBlock = GalaxyCoordinates.getLightReceiver();
                Vec3 emitterDir = emitterBlock.getBeamDir(emitterState);
                this.startPos = new Vec3((double)this.func_174877_v().func_177958_n(), (double)this.func_174877_v().func_177956_o(), (double)this.func_174877_v().func_177952_p());
                this.reflectors = new ArrayList();
                this.reflectors.add(this.startPos);
                this.dirs = new ArrayList();
                this.dirs.add(emitterDir);
                boolean flag = true;
                int count = 0;
                while (flag) {
                    Vec3 dir = this.dirs.get(count);
                    Vec3 nextPos = this.reflectors.get(count).func_178787_e(dir);
                    for (int dist = 0; this.field_145850_b.func_175623_d(new BlockPos(nextPos.field_72450_a, nextPos.field_72448_b, nextPos.field_72449_c)) && dist < 30; ++dist) {
                        nextPos = nextPos.func_178787_e(dir);
                    }
                    BlockState nextState = this.field_145850_b.func_180495_p(new BlockPos(nextPos.field_72450_a, nextPos.field_72448_b, nextPos.field_72449_c));
                    Block nextBlock = nextState.func_177230_c();
                    if (nextBlock instanceof BlockLightReflector) {
                        Vec3 dirReverse;
                        ArrayList<Vec3> beamDirs = ((BlockLightReflector)nextBlock).getBeamDirs(nextState);
                        if (beamDirs.contains(dirReverse = new Vec3(-1.0 * dir.field_72450_a, -1.0 * dir.field_72448_b, -1.0 * dir.field_72449_c))) {
                            boolean finalFlag = false;
                            BlockState finalState = this.field_145850_b.func_180495_p(new BlockPos(nextPos.field_72450_a, nextPos.field_72448_b, nextPos.field_72449_c));
                            if (finalState.func_177230_c() == BlockInit.lightReflector) {
                                BlockLightReflector finalReflector = (BlockLightReflector)finalState.func_177230_c();
                                boolean bl = finalFlag = finalReflector.getStateWithFacing(Direction.SOUTH) == finalState;
                            }
                            if (new BlockPos(nextPos.field_72450_a, nextPos.field_72448_b, nextPos.field_72449_c).equals((Object)this.finalBlock) && finalFlag) {
                                this.complete = true;
                                this.reflectors.add(nextPos);
                                flag = false;
                                break;
                            }
                            this.reflectors.add(nextPos);
                            beamDirs.remove(dirReverse);
                            this.dirs.add(beamDirs.get(0));
                            ++count;
                            continue;
                        }
                        this.reflectors.add(this.stopPos);
                        this.stopPos = nextPos;
                        flag = false;
                        continue;
                    }
                    if (this.reflectors.size() > 1) {
                        this.reflectors.add(this.stopPos);
                    }
                    this.stopPos = nextPos;
                    flag = false;
                }
                lostinfinity.instance.packetHandler.sendServerBasicPacket(new PacketLightReceiver(this.complete, this.func_174877_v().func_177958_n(), this.func_174877_v().func_177956_o(), this.func_174877_v().func_177952_p()));
            }
        }
    }

    public boolean shouldRenderInPass(int pass) {
        return true;
    }

    public AABB getRenderBoundingBox() {
        AABB bb = INFINITE_EXTENT_AABB;
        return bb;
    }

    @SideOnly(value=Side.CLIENT)
    public double func_145833_n() {
        return 65536.0;
    }

    public AABB getLightMazeAABB() {
        int x = this.func_174877_v().func_177958_n();
        int y = this.func_174877_v().func_177956_o();
        int z = this.func_174877_v().func_177952_p();
        return new AABB((double)x, (double)y, (double)z, (double)(x + this.dirUp.func_177958_n() * 10 + this.dirLeft.func_177958_n() * 10), (double)y, (double)(z + this.dirUp.func_177952_p() * 10 + this.dirLeft.func_177952_p() * 10));
    }

    private void generateLightMaze() {
    }

    public CompoundTag func_189515_b(CompoundTag compound) {
        super.func_189515_b(compound);
        if (this.finalBlock != null) {
            compound.func_74768_a("FinalX", (int)((short)this.finalBlock.func_177958_n()));
            compound.func_74768_a("FinalY", (int)((short)this.finalBlock.func_177956_o()));
            compound.func_74768_a("FinalZ", (int)((short)this.finalBlock.func_177952_p()));
        }
        compound.func_74757_a("Complete", this.complete);
        return compound;
    }

    public void func_145839_a(CompoundTag compound) {
        super.func_145839_a(compound);
        if (compound.func_74764_b("FinalX")) {
            this.finalBlock = new BlockPos(compound.func_74762_e("FinalX"), compound.func_74762_e("FinalY"), compound.func_74762_e("FinalZ"));
        }
        this.complete = compound.func_74767_n("Complete");
    }

    public Vec3 getStartPos() {
        return this.startPos;
    }

    public Vec3 getStopPos() {
        return this.stopPos;
    }

    public ArrayList<Vec3> getReflectors() {
        if (this.reflectors != null) {
            return this.reflectors;
        }
        return new ArrayList<Vec3>();
    }

    public boolean isComplete() {
        return this.complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
}

