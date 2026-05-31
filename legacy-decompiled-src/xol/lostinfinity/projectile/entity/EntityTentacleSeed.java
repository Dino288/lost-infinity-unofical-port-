/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.util.math.HitResult$Type
 *  net.minecraft.world.World
 */
package xol.lostinfinity.projectile.entity;

import java.util.ArrayList;
import java.util.Collections;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;

public class EntityTentacleSeed
extends EntityBaseThrowable {
    public EntityTentacleSeed(Level par1World) {
        super(par1World);
    }

    public EntityTentacleSeed(Level par1World, LivingEntity par2Mob) {
        super(par1World, par2Mob);
    }

    public EntityTentacleSeed(Level par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (!this.field_70170_p.field_72995_K) {
            if (result.field_72313_a == HitResult.Type.BLOCK) {
                BlockPos startPos = result.func_178782_a();
                int max = 30;
                ArrayList<BlockPos> visited = new ArrayList<BlockPos>();
                visited.add(startPos);
                block0: for (int count = 0; count < max; ++count) {
                    ArrayList<BlockPos> neighbours = this.getNeighbours(startPos);
                    Collections.shuffle(neighbours);
                    for (BlockPos neighbour : neighbours) {
                        if (visited.contains(neighbour)) continue;
                        Boolean canAdd = true;
                        for (BlockPos subNeighbour : this.getNeighbours(neighbour)) {
                            if (!visited.contains(subNeighbour)) continue;
                            canAdd = false;
                            break;
                        }
                        if (!canAdd.booleanValue()) continue;
                        this.field_70170_p.func_175656_a(neighbour, BlockInit.viralGrowth.func_176223_P());
                        startPos = neighbour;
                        visited.add(neighbour);
                        continue block0;
                    }
                }
            }
            this.func_70106_y();
        }
    }

    private ArrayList<BlockPos> getNeighbours(BlockPos pos) {
        ArrayList<BlockPos> neighbours = new ArrayList<BlockPos>();
        ArrayList<BlockPos> positions = new ArrayList<BlockPos>();
        positions.add(pos.func_177982_a(1, 0, 0));
        positions.add(pos.func_177982_a(-1, 0, 0));
        positions.add(pos.func_177982_a(0, 1, 0));
        positions.add(pos.func_177982_a(0, -1, 0));
        positions.add(pos.func_177982_a(0, 0, 1));
        positions.add(pos.func_177982_a(0, 0, -1));
        for (BlockPos position : positions) {
            if (!this.field_70170_p.func_175623_d(position)) continue;
            neighbours.add(position);
        }
        return neighbours;
    }

    protected float func_70185_h() {
        return 0.05f;
    }
}

