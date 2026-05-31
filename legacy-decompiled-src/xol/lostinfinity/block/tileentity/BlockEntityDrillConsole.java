/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.ItemEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.tileentity.BlockEntity
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 */
package xol.lostinfinity.block.tileentity;

import java.util.ArrayList;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.util.coordinates.GalaxyCoordinates;

public class BlockEntityDrillConsole
extends BlockEntity {
    private boolean active = false;
    private static final Vec3i forwardDir = new Vec3i(-1, 0, 0);
    private static final Vec3i rightDir = new Vec3i(0, 0, -1);
    private ArrayList<BlockPos> horizontalBeam = new ArrayList();
    private ArrayList<BlockPos> verticalBeam = new ArrayList();
    private BlockPos drillPos = null;
    private int drillHeight = 0;
    private boolean drilling = false;

    public void adjustDrill(boolean down) {
        Block drillBeamBlock = BlockInit.drillShaft;
        Block drillHeadBlock = BlockInit.drillHead;
        Block oreBlock = BlockInit.lucientOre;
        BlockPos drillHeadPos = this.drillPos.func_177982_a(0, -this.drillHeight, 0);
        boolean didMine = false;
        if (down) {
            if (this.field_145850_b.func_175623_d(drillHeadPos.func_177977_b())) {
                ++this.drillHeight;
            } else {
                didMine = true;
                BlockPos checkPos = drillHeadPos.func_177977_b();
                BlockState state = this.field_145850_b.func_180495_p(checkPos);
                if (state.func_177230_c() == oreBlock && oreBlock.func_176201_c(state) == 1) {
                    this.field_145850_b.func_175656_a(checkPos, oreBlock.func_176203_a(0));
                    ++this.drillHeight;
                    BlockPos funnelPos = GalaxyCoordinates.lucientOreFunnelPos();
                    ItemEntity item = new ItemEntity(this.field_145850_b, (double)funnelPos.func_177958_n(), (double)(funnelPos.func_177956_o() + 1), (double)funnelPos.func_177952_p(), new ItemStack(ItemInit.lucient, 1));
                    item.field_70159_w = 0.0;
                    item.field_70179_y = 0.0;
                    item.field_70181_x = 0.0;
                    this.field_145850_b.func_72838_d((Entity)item);
                    this.field_145850_b.func_184133_a(null, drillHeadPos, SoundInit.MACHINE_CRAFT, SoundSource.MASTER, 1.0f, 1.0f);
                }
            }
        } else if (this.drillHeight > 0) {
            if (this.field_145850_b.func_180495_p(this.drillPos.func_177982_a(0, -this.drillHeight, 0)).func_177230_c() == drillHeadBlock) {
                this.field_145850_b.func_175698_g(this.drillPos.func_177982_a(0, -this.drillHeight, 0));
            }
            --this.drillHeight;
        }
        for (int i = 0; i <= this.drillHeight; ++i) {
            BlockPos beamPos = this.drillPos.func_177982_a(0, -i, 0);
            if (i == this.drillHeight) {
                if (didMine) continue;
                this.field_145850_b.func_175656_a(beamPos, drillHeadBlock.func_176223_P());
                continue;
            }
            this.field_145850_b.func_175656_a(beamPos, drillBeamBlock.func_176223_P());
        }
    }

    public void activateDrill(Player player) {
        if (!this.field_145850_b.field_72995_K && !this.drilling) {
            BlockPos beamPos;
            int k;
            BlockPos checkPos;
            int i;
            Block beamBlock = BlockInit.drillBeam;
            BlockState drillHeadState = BlockInit.drillHead.func_176223_P();
            this.active = true;
            player.func_145747_a((Component)new Component((Object)((Object)TextFmt.Green) + "Maneuver the drill to mine the ores!"));
            AABB drillBB = GalaxyCoordinates.lucientDrillAABB();
            this.horizontalBeam.clear();
            this.verticalBeam.clear();
            for (i = (int)drillBB.field_72340_a; i <= (int)drillBB.field_72336_d; ++i) {
                checkPos = new BlockPos((double)i, drillBB.field_72337_e, drillBB.field_72339_c);
                if (this.field_145850_b.func_180495_p(checkPos).func_177230_c() != beamBlock) continue;
                for (k = (int)drillBB.field_72339_c; k <= (int)drillBB.field_72334_f; ++k) {
                    beamPos = new BlockPos((double)i, drillBB.field_72337_e, (double)k);
                    this.horizontalBeam.add(beamPos);
                }
            }
            for (i = (int)drillBB.field_72339_c; i <= (int)drillBB.field_72334_f; ++i) {
                checkPos = new BlockPos(drillBB.field_72340_a, drillBB.field_72337_e, (double)i);
                if (this.field_145850_b.func_180495_p(checkPos).func_177230_c() != beamBlock) continue;
                for (k = (int)drillBB.field_72340_a; k <= (int)drillBB.field_72336_d; ++k) {
                    beamPos = new BlockPos((double)k, drillBB.field_72337_e, (double)i);
                    this.verticalBeam.add(beamPos);
                }
            }
            for (BlockPos pos : this.horizontalBeam) {
                if (!this.verticalBeam.contains(pos)) continue;
                this.drillPos = pos.func_177977_b();
                this.field_145850_b.func_175656_a(this.drillPos, drillHeadState);
                break;
            }
        }
    }

    public void moveDrill(int i) {
        if (this.active) {
            if (i == 4) {
                this.adjustDrill(false);
                return;
            }
            if (i == 5) {
                this.adjustDrill(true);
                return;
            }
            if (this.drillHeight == 0 && this.horizontalBeam != null && !this.horizontalBeam.isEmpty() && this.verticalBeam != null && !this.verticalBeam.isEmpty()) {
                Vec3i dir;
                AABB drillBB = GalaxyCoordinates.lucientDrillAABB();
                boolean horizontal = false;
                switch (i) {
                    case 1: {
                        dir = rightDir;
                        break;
                    }
                    case 2: {
                        horizontal = true;
                        dir = new Vec3i(-forwardDir.func_177958_n(), 0, -forwardDir.func_177952_p());
                        break;
                    }
                    case 3: {
                        dir = new Vec3i(-rightDir.func_177958_n(), 0, -rightDir.func_177952_p());
                        break;
                    }
                    default: {
                        horizontal = true;
                        dir = forwardDir;
                    }
                }
                BlockPos testPos = horizontal ? this.horizontalBeam.get(0) : this.verticalBeam.get(0);
                if (testPos.func_177958_n() + dir.func_177958_n() <= (int)drillBB.field_72336_d && testPos.func_177958_n() + dir.func_177958_n() >= (int)drillBB.field_72340_a && (double)(testPos.func_177952_p() + dir.func_177952_p()) <= drillBB.field_72334_f && (double)(testPos.func_177952_p() + dir.func_177952_p()) >= drillBB.field_72339_c) {
                    BlockPos newPos;
                    BlockState beamState = BlockInit.drillBeam.func_176223_P();
                    BlockState drillHeadState = BlockInit.drillHead.func_176223_P();
                    if (this.drillPos != null) {
                        this.field_145850_b.func_175698_g(this.drillPos);
                    }
                    ArrayList<BlockPos> newBeam = new ArrayList<BlockPos>();
                    if (horizontal) {
                        for (BlockPos pos : this.horizontalBeam) {
                            if (!this.verticalBeam.contains(pos)) {
                                this.field_145850_b.func_175698_g(pos);
                            }
                            newPos = pos.func_177971_a(dir);
                            newBeam.add(newPos);
                            this.field_145850_b.func_175656_a(newPos, beamState);
                        }
                        this.horizontalBeam.clear();
                        this.horizontalBeam.addAll(newBeam);
                    } else {
                        for (BlockPos pos : this.verticalBeam) {
                            if (!this.horizontalBeam.contains(pos)) {
                                this.field_145850_b.func_175698_g(pos);
                            }
                            newPos = pos.func_177971_a(dir);
                            newBeam.add(newPos);
                            this.field_145850_b.func_175656_a(newPos, beamState);
                        }
                        this.verticalBeam.clear();
                        this.verticalBeam.addAll(newBeam);
                    }
                    for (BlockPos pos : this.horizontalBeam) {
                        if (!this.verticalBeam.contains(pos)) continue;
                        this.drillPos = pos.func_177977_b();
                        this.field_145850_b.func_175656_a(this.drillPos, drillHeadState);
                        break;
                    }
                }
            }
        }
    }
}

