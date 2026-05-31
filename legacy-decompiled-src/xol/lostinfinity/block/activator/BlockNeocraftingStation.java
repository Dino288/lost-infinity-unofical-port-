/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.Direction
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.activator;

import java.util.ArrayList;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.activator.BlockNeocraft;
import xol.lostinfinity.block.basic.BlockBasic;
import xol.lostinfinity.dimension.data.TetrisMap;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;

public class BlockNeocraftingStation
extends BlockBasic {
    private static int[][][] linePiece = new int[][][]{new int[][]{{0, 1, 2, 3}, {0, 0, 0, 0}}, new int[][]{{0, 0, 0, 0}, {0, 1, 2, 3}}};
    private static int[][][] lPiece = new int[][][]{new int[][]{{0, 1, 2, 2}, {0, 0, 0, 1}}, new int[][]{{0, 0, 0, 1}, {0, 1, 2, 2}}, new int[][]{{0, 0, 0, -1}, {0, 1, 2, 2}}, new int[][]{{-1, 0, 0, 0}, {0, 0, 1, 2}}, new int[][]{{1, 0, 0, 0}, {0, 0, 1, 2}}, new int[][]{{0, 1, 2, 2}, {0, 0, 0, -1}}, new int[][]{{0, 0, 1, 2}, {-1, 0, 0, 0}}, new int[][]{{0, 0, 1, 2}, {1, 0, 0, 0}}};
    private static int[][][] tPiece = new int[][][]{new int[][]{{0, 1, 1, 2}, {0, 0, -1, 0}}, new int[][]{{0, 1, 1, 1}, {0, 1, 0, -1}}, new int[][]{{0, 0, 0, 1}, {1, 0, -1, 0}}, new int[][]{{0, 1, 1, 2}, {0, 0, 1, 0}}};
    private static int[][][] zigPiece = new int[][][]{new int[][]{{0, 0, 1, 1}, {-1, 0, 0, 1}}, new int[][]{{1, 1, 0, 0}, {1, 0, 0, -1}}, new int[][]{{0, 1, 1, 2}, {0, 0, 1, 1}}, new int[][]{{0, 1, 1, 2}, {0, 0, -1, -1}}};
    private static int[][][] squarePiece = new int[][][]{new int[][]{{0, 0, 1, 1}, {0, 1, 0, 1}}};

    public BlockNeocraftingStation(String name) {
        super(name);
    }

    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        ItemStack stack = playerIn.func_184586_b(hand);
        if (stack.func_77973_b() == ItemInit.polychargeSolution) {
            if (!worldIn.field_72995_K) {
                int i;
                int randN = worldIn.field_73012_v.nextInt(3) + 1;
                int randM = worldIn.field_73012_v.nextInt(3) + 1;
                TetrisMap map = new TetrisMap(randN * 4, randM * 4);
                playerIn.func_145747_a((Component)new Component("Fill in an " + randN * 4 + " by " + randM * 4 + " area with the pieces shown."));
                int[] pieceList = map.getPieceList();
                int linePieces = pieceList[0];
                int lPieces = pieceList[1];
                int tPieces = pieceList[2];
                int zigPieces = pieceList[3];
                int squarePieces = pieceList[4];
                Vec3i upDir = new Vec3i(0, 0, 0);
                Vec3i rightDir = new Vec3i(0, 0, 0);
                Vec3i offset = new Vec3i(-7, -2, 13);
                BlockPos ref = pos.func_177971_a(offset);
                if (worldIn.func_180495_p(ref.func_177982_a(-1, 0, 0)).func_177230_c() instanceof BlockNeocraft) {
                    upDir = new Vec3i(1, 0, 0);
                    rightDir = new Vec3i(0, 0, 1);
                } else if (worldIn.func_180495_p(ref.func_177982_a(1, 0, 0)).func_177230_c() instanceof BlockNeocraft) {
                    upDir = new Vec3i(-1, 0, 0);
                    rightDir = new Vec3i(0, 0, -1);
                } else if (worldIn.func_180495_p(ref.func_177982_a(0, 0, 1)).func_177230_c() instanceof BlockNeocraft) {
                    upDir = new Vec3i(0, 0, -1);
                    rightDir = new Vec3i(1, 0, 0);
                } else if (worldIn.func_180495_p(ref.func_177982_a(0, 0, -1)).func_177230_c() instanceof BlockNeocraft) {
                    upDir = new Vec3i(0, 0, 1);
                    rightDir = new Vec3i(-1, 0, 0);
                }
                BlockPos linePos = ref.func_177982_a(rightDir.func_177958_n() * 1, 1, rightDir.func_177952_p() * 1);
                BlockPos lPos = ref.func_177982_a(rightDir.func_177958_n() * 3, 1, rightDir.func_177952_p() * 3);
                BlockPos tPos = ref.func_177982_a(rightDir.func_177958_n() * 5, 1, rightDir.func_177952_p() * 5);
                BlockPos zigPos = ref.func_177982_a(rightDir.func_177958_n() * 7, 1, rightDir.func_177952_p() * 7);
                BlockPos squarePos = ref.func_177982_a(rightDir.func_177958_n() * 9, 1, rightDir.func_177952_p() * 9);
                this.reset(upDir, rightDir, worldIn, ref);
                for (i = 0; i < linePieces; ++i) {
                    worldIn.func_175656_a(linePos.func_177982_a(0, i, 0), BlockInit.neocraftGoalBlue.func_176223_P());
                }
                for (i = 0; i < lPieces; ++i) {
                    worldIn.func_175656_a(lPos.func_177982_a(0, i, 0), BlockInit.neocraftGoalOrange.func_176223_P());
                }
                for (i = 0; i < tPieces; ++i) {
                    worldIn.func_175656_a(tPos.func_177982_a(0, i, 0), BlockInit.neocraftGoalPink.func_176223_P());
                }
                for (i = 0; i < zigPieces; ++i) {
                    worldIn.func_175656_a(zigPos.func_177982_a(0, i, 0), BlockInit.neocraftGoalGreen.func_176223_P());
                }
                for (i = 0; i < squarePieces; ++i) {
                    worldIn.func_175656_a(squarePos.func_177982_a(0, i, 0), BlockInit.neocraftGoalYellow.func_176223_P());
                }
            }
            stack.func_190918_g(1);
        } else if (!worldIn.field_72995_K) {
            ArrayList visited = new ArrayList();
            Vec3i upDir = new Vec3i(0, 0, 0);
            Vec3i rightDir = new Vec3i(0, 0, 0);
            Vec3i offset = new Vec3i(-7, -2, 13);
            BlockPos ref = pos.func_177971_a(offset);
            if (worldIn.func_180495_p(ref.func_177982_a(-1, 0, 0)).func_177230_c() instanceof BlockNeocraft) {
                upDir = new Vec3i(1, 0, 0);
                rightDir = new Vec3i(0, 0, 1);
            } else if (worldIn.func_180495_p(ref.func_177982_a(1, 0, 0)).func_177230_c() instanceof BlockNeocraft) {
                upDir = new Vec3i(-1, 0, 0);
                rightDir = new Vec3i(0, 0, -1);
            } else if (worldIn.func_180495_p(ref.func_177982_a(0, 0, 1)).func_177230_c() instanceof BlockNeocraft) {
                upDir = new Vec3i(0, 0, -1);
                rightDir = new Vec3i(1, 0, 0);
            } else if (worldIn.func_180495_p(ref.func_177982_a(0, 0, -1)).func_177230_c() instanceof BlockNeocraft) {
                upDir = new Vec3i(0, 0, 1);
                rightDir = new Vec3i(-1, 0, 0);
            }
            BlockPos linePos = ref.func_177982_a(rightDir.func_177958_n() * 1, 1, rightDir.func_177952_p() * 1);
            BlockPos lPos = ref.func_177982_a(rightDir.func_177958_n() * 3, 1, rightDir.func_177952_p() * 3);
            BlockPos tPos = ref.func_177982_a(rightDir.func_177958_n() * 5, 1, rightDir.func_177952_p() * 5);
            BlockPos zigPos = ref.func_177982_a(rightDir.func_177958_n() * 7, 1, rightDir.func_177952_p() * 7);
            BlockPos squarePos = ref.func_177982_a(rightDir.func_177958_n() * 9, 1, rightDir.func_177952_p() * 9);
            int lineCount = 0;
            int lCount = 0;
            int tCount = 0;
            int zigCount = 0;
            int squareCount = 0;
            BlockPos checkPos = new BlockPos((Vec3i)linePos);
            while (worldIn.func_180495_p(checkPos).func_177230_c() == BlockInit.neocraftGoalBlue) {
                ++lineCount;
                checkPos = checkPos.func_177982_a(0, 1, 0);
            }
            checkPos = new BlockPos((Vec3i)lPos);
            while (worldIn.func_180495_p(checkPos).func_177230_c() == BlockInit.neocraftGoalOrange) {
                ++lCount;
                checkPos = checkPos.func_177982_a(0, 1, 0);
            }
            checkPos = new BlockPos((Vec3i)tPos);
            while (worldIn.func_180495_p(checkPos).func_177230_c() == BlockInit.neocraftGoalPink) {
                ++tCount;
                checkPos = checkPos.func_177982_a(0, 1, 0);
            }
            checkPos = new BlockPos((Vec3i)zigPos);
            while (worldIn.func_180495_p(checkPos).func_177230_c() == BlockInit.neocraftGoalGreen) {
                ++zigCount;
                checkPos = checkPos.func_177982_a(0, 1, 0);
            }
            checkPos = new BlockPos((Vec3i)squarePos);
            while (worldIn.func_180495_p(checkPos).func_177230_c() == BlockInit.neocraftGoalYellow) {
                ++squareCount;
                checkPos = checkPos.func_177982_a(0, 1, 0);
            }
            if (lineCount + squareCount + zigCount + lCount + tCount == 0) {
                playerIn.func_145747_a((Component)new Component("No Goal Blocks Present. Cannot craft"));
                return true;
            }
            checkPos = ref.func_177973_b(upDir);
            while (worldIn.func_180495_p(checkPos).func_177230_c() instanceof BlockNeocraft) {
                checkPos = checkPos.func_177973_b(upDir);
            }
            checkPos = checkPos.func_177971_a(upDir);
            while (worldIn.func_180495_p(checkPos).func_177230_c() instanceof BlockNeocraft) {
                checkPos = checkPos.func_177973_b(rightDir);
            }
            BlockPos startPos = checkPos = checkPos.func_177971_a(rightDir);
            int blueCount = 0;
            int greenCount = 0;
            int orangeCount = 0;
            int pinkCount = 0;
            int yellowCount = 0;
            boolean notFound = false;
            block12: for (int i = 0; i < 12; ++i) {
                for (int j = 0; j < 12; ++j) {
                    BlockPos countPos = startPos.func_177982_a(rightDir.func_177958_n() * i + upDir.func_177958_n() * j, 0, rightDir.func_177952_p() * i + upDir.func_177952_p() * j);
                    Block block = worldIn.func_180495_p(countPos).func_177230_c();
                    if (block == BlockInit.neocraftBlue) {
                        ++blueCount;
                        notFound = !this.findPiece(worldIn, countPos, "line");
                    } else if (block == BlockInit.neocraftGreen) {
                        ++greenCount;
                        notFound = !this.findPiece(worldIn, countPos, "zig");
                    } else if (block == BlockInit.neocraftPink) {
                        ++pinkCount;
                        notFound = !this.findPiece(worldIn, countPos, "t");
                    } else if (block == BlockInit.neocraftYellow) {
                        ++yellowCount;
                        notFound = !this.findPiece(worldIn, countPos, "square");
                    } else if (block == BlockInit.neocraftOrange) {
                        ++orangeCount;
                        boolean bl = notFound = !this.findPiece(worldIn, countPos, "l");
                    }
                    if (notFound) break block12;
                }
            }
            if (blueCount / 4 < lineCount || pinkCount / 4 < tCount || greenCount / 4 < zigCount || yellowCount / 4 < squareCount || orangeCount / 4 < lCount) {
                notFound = true;
            }
            if (notFound) {
                playerIn.func_145747_a((Component)new Component("You have failed to input the correct configuration."));
            } else {
                playerIn.func_145747_a((Component)new Component("Craft Successful!"));
                playerIn.func_191521_c(new ItemStack(ItemInit.solarumVial, 1));
                worldIn.func_184133_a(null, pos, SoundInit.MACHINE_CRAFT, SoundSource.MASTER, 1.0f, 1.0f);
                this.reset(upDir, rightDir, worldIn, ref);
            }
        }
        return true;
    }

    private void reset(Vec3i upDir, Vec3i rightDir, Level worldIn, BlockPos ref) {
        int count = 0;
        for (int i = 0; i <= 5; ++i) {
            BlockPos clearPos = ref.func_177982_a(rightDir.func_177958_n() * (i * 2 + 1), 1, rightDir.func_177952_p() * (i * 2 + 1));
            while (worldIn.func_180495_p(clearPos).func_177230_c() != BlockInit.neocraftGoalEmpty && count <= 9) {
                ++count;
                worldIn.func_175656_a(clearPos, BlockInit.neocraftGoalEmpty.func_176223_P());
                clearPos = clearPos.func_177982_a(0, 1, 0);
            }
            count = 0;
        }
        BlockPos checkPos = ref.func_177973_b(upDir);
        while (worldIn.func_180495_p(checkPos).func_177230_c() instanceof BlockNeocraft) {
            checkPos = checkPos.func_177973_b(upDir);
        }
        checkPos = checkPos.func_177971_a(upDir);
        while (worldIn.func_180495_p(checkPos).func_177230_c() instanceof BlockNeocraft) {
            checkPos = checkPos.func_177973_b(rightDir);
        }
        BlockPos startPos = checkPos = checkPos.func_177971_a(rightDir);
        for (int i = 0; i < 12; ++i) {
            for (int j = 0; j < 12; ++j) {
                BlockPos countPos = startPos.func_177982_a(rightDir.func_177958_n() * i + upDir.func_177958_n() * j, 0, rightDir.func_177952_p() * i + upDir.func_177952_p() * j);
                Block block = worldIn.func_180495_p(countPos).func_177230_c();
                if (!(block instanceof BlockNeocraft)) continue;
                worldIn.func_175656_a(countPos, BlockInit.neocraftUnpowered.func_176223_P());
            }
        }
    }

    private boolean findPiece(Level worldIn, BlockPos pos, String pieceName) {
        int[][][] orientations = null;
        Block block = null;
        switch (pieceName) {
            case "line": {
                orientations = linePiece;
                block = BlockInit.neocraftBlue;
                break;
            }
            case "l": {
                orientations = lPiece;
                block = BlockInit.neocraftOrange;
                break;
            }
            case "t": {
                orientations = tPiece;
                block = BlockInit.neocraftPink;
                break;
            }
            case "square": {
                orientations = squarePiece;
                block = BlockInit.neocraftYellow;
                break;
            }
            case "zig": {
                orientations = zigPiece;
                block = BlockInit.neocraftGreen;
            }
        }
        if (orientations == null || block == null) {
            return false;
        }
        for (int i = 0; i < orientations.length; ++i) {
            int[][] orientation = orientations[i];
            for (int n = 0; n < orientation[0].length; ++n) {
                int startX = orientation[0][n];
                int startZ = orientation[1][n];
                boolean orientationFits = true;
                for (int k = 0; k < orientation[0].length; ++k) {
                    int relX = orientation[0][k] - startX;
                    int relZ = orientation[1][k] - startZ;
                    BlockPos checkPos = pos.func_177982_a(relX, 0, relZ);
                    if (worldIn.func_180495_p(checkPos).func_177230_c() == block) continue;
                    orientationFits = false;
                }
                if (!orientationFits) continue;
                return true;
            }
        }
        return false;
    }
}

