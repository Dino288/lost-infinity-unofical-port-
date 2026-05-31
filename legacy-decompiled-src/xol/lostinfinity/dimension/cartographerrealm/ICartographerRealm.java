/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.Rotation
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.dimension.cartographerrealm;

import java.util.Random;
import net.minecraft.util.Rotation;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.dimension.util.WorldGenStructure;

public interface ICartographerRealm {
    default public void doGeneration(Level world, Random rand, int chunkX, int chunkZ) {
        String top_name;
        String bottom_name;
        int posX = chunkX * 16;
        int posZ = chunkZ * 16;
        Rotation top_rot = this.randomRota(rand);
        Rotation bottom_rot = this.randomRota(rand);
        int x_off = Math.abs(chunkX % 10);
        int z_off = Math.abs(chunkZ % 10);
        if (x_off == 0 && z_off == 0) {
            if (chunkX == chunkZ) {
                bottom_name = this.gateRoom();
                top_name = this.teleRoom();
            } else {
                bottom_name = this.teleRoom();
                top_name = this.gateRoom();
            }
        } else {
            int style_pick = rand.nextInt(20);
            if (style_pick == 0) {
                top_name = this.crossRoom();
                bottom_name = this.portalRoom();
            } else if (style_pick == 2) {
                top_name = this.crossRoom();
                bottom_name = this.gameRoom();
            } else if (style_pick == 3) {
                top_name = this.gameRoom();
                bottom_name = this.crossRoom();
            } else if (style_pick == 4 || style_pick == 5) {
                top_name = this.crossRoom();
                bottom_name = this.crossRoom();
            } else if (style_pick == 6 || style_pick == 7) {
                String[] stairs = this.stairsRoom();
                top_name = stairs[0];
                bottom_name = stairs[1];
            } else if (style_pick == 8) {
                String[] stairs = this.twoLevelRoom();
                top_name = stairs[0];
                bottom_name = stairs[1];
            } else {
                top_name = this.connectorRoom();
                bottom_name = this.connectorRoom();
            }
        }
        new WorldGenStructure(top_name).generateWithRotation(world, rand, new BlockPos(posX + 8, 20, posZ + 8), top_rot);
        new WorldGenStructure(bottom_name).generateWithRotation(world, rand, new BlockPos(posX + 8, 11, posZ + 8), bottom_rot);
    }

    public String teleRoom();

    public String gateRoom();

    public String[] stairsRoom();

    public String[] twoLevelRoom();

    public String connectorRoom();

    public String crossRoom();

    public String gameRoom();

    public String portalRoom();

    default public Rotation randomRota(Random rand) {
        int rot_pick = rand.nextInt(4);
        switch (rot_pick) {
            case 0: {
                return Rotation.NONE;
            }
            case 1: {
                return Rotation.CLOCKWISE_90;
            }
            case 2: {
                return Rotation.COUNTERCLOCKWISE_90;
            }
            case 3: {
                return Rotation.CLOCKWISE_180;
            }
        }
        return Rotation.NONE;
    }
}

