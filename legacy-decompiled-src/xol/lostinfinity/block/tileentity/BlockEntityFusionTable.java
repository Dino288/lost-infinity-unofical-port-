/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.Player
 *  net.minecraft.inventory.IInventory
 *  net.minecraft.inventory.ItemStackHelper
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.tileentity.BlockEntity
 *  net.minecraft.util.ITickable
 *  net.minecraft.util.NonNullList
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.block.tileentity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.world.entity.player.Player;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.util.ITickable;
import net.minecraft.core.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.common.lostinfinity;
import xol.lostinfinity.common.packets.serverbound.PacketFusionTable;
import xol.lostinfinity.init.ItemInit;

public class BlockEntityFusionTable
extends BlockEntity
implements IInventory,
ITickable {
    private static final boolean DEBUG = false;
    public static final int BOARD_ROWS = 4;
    public static final int BOARD_COLUMNS = 6;
    public static final int BOARD_SIZE = 24;
    private NonNullList<ItemStack> inventory = NonNullList.func_191197_a((int)3, (Object)ItemStack.field_190927_a);
    private List<BoardPiece> board = new ArrayList<BoardPiece>();
    private List<Integer> upcomingPieces = new ArrayList<Integer>();
    private int progress = 0;

    public void func_73660_a() {
        int weight = 0;
        for (BoardPiece piece : this.board) {
            weight += piece.getShapeId();
        }
        if (weight > 0) {
            if (this.field_145850_b.field_72995_K) {
                this.checkMatches();
            }
            if (this.progress == 6) {
                this.fuseCraft();
                return;
            }
        }
        if ((((ItemStack)this.inventory.get(0)).func_77973_b().equals(ItemInit.ioniteBar) || ((ItemStack)this.inventory.get(0)).func_77973_b().equals(ItemInit.inverseMagnecronite)) && (((ItemStack)this.inventory.get(1)).func_77973_b().equals(ItemInit.ioniteBar) || ((ItemStack)this.inventory.get(1)).func_77973_b().equals(ItemInit.inverseMagnecronite)) && weight <= 0) {
            if (this.field_145850_b.field_72995_K) {
                this.fillBoard();
                this.fillUpcomingPieces();
            }
        } else if ((((ItemStack)this.inventory.get(0)).func_190926_b() || ((ItemStack)this.inventory.get(1)).func_190926_b() && weight > 0) && this.field_145850_b.field_72995_K) {
            this.resetBoard();
        }
    }

    public int func_174887_a_(int id) {
        if (this.upcomingPieces.isEmpty() || this.board.isEmpty()) {
            return 0;
        }
        if (id >= 0 && id < 24) {
            return this.board.get(id).getShapeId();
        }
        if (id == 24) {
            return this.upcomingPieces.get(0);
        }
        if (id == 25) {
            return this.upcomingPieces.get(1);
        }
        if (id == 27) {
            return this.progress;
        }
        return 0;
    }

    public void func_174885_b(int id, int value) {
        if (!this.field_145850_b.field_72995_K && this.board.isEmpty()) {
            for (int i = 0; i < 24; ++i) {
                this.board.add(new BoardPiece(0, 0, 0));
            }
            if (this.upcomingPieces.isEmpty()) {
                this.upcomingPieces.add(0);
                this.upcomingPieces.add(0);
            }
        }
        if (id >= 0 && id < 24) {
            this.board.get(id).setShapeId(value);
        } else if (id == 24) {
            this.upcomingPieces.set(0, value);
        } else if (id == 25) {
            this.upcomingPieces.set(1, value);
        } else if (id == 27) {
            this.progress = value;
        }
    }

    @SideOnly(value=Side.CLIENT)
    private void resetBoard() {
        int i;
        this.board.clear();
        this.upcomingPieces.clear();
        for (i = 0; i < 4; ++i) {
            for (int j = 0; j < 6; ++j) {
                this.board.add(new BoardPiece(i, j, 0));
            }
        }
        this.upcomingPieces.add(0);
        this.upcomingPieces.add(0);
        this.progress = 0;
        for (i = 0; i < 24; ++i) {
            lostinfinity.instance.packetHandler.sendServerBasicPacket(new PacketFusionTable(this.func_174877_v(), this.func_174887_a_(i), i));
        }
        lostinfinity.instance.packetHandler.sendServerBasicPacket(new PacketFusionTable(this.func_174877_v(), this.func_174887_a_(24), 24));
        lostinfinity.instance.packetHandler.sendServerBasicPacket(new PacketFusionTable(this.func_174877_v(), this.func_174887_a_(25), 25));
        lostinfinity.instance.packetHandler.sendServerBasicPacket(new PacketFusionTable(this.func_174877_v(), this.func_174887_a_(27), 27));
    }

    @SideOnly(value=Side.CLIENT)
    private void fillBoard() {
        int i;
        for (int i2 = 0; i2 < 4; ++i2) {
            for (int j = 0; j < 6; ++j) {
                this.board.add(new BoardPiece(i2, j, 0));
            }
        }
        int weight = 0;
        for (i = 0; i < 4; ++i) {
            for (int j = 0; j < 6; ++j) {
                int shapeId = new Random().nextInt(12) + 1;
                int boardIndex = i * 6 + j;
                weight = shapeId > 0 && shapeId < 6 ? ++weight : --weight;
                this.board.set(boardIndex, new BoardPiece(i, j, shapeId));
            }
            new Random().nextInt(12);
        }
        if (weight != -4) {
            this.resetBoard();
            this.fillBoard();
        }
        for (i = 0; i < 24; ++i) {
            lostinfinity.instance.packetHandler.sendServerBasicPacket(new PacketFusionTable(this.func_174877_v(), this.func_174887_a_(i), i));
        }
    }

    @SideOnly(value=Side.CLIENT)
    private void fillUpcomingPieces() {
        this.upcomingPieces.add(0);
        this.upcomingPieces.add(0);
        for (int i = 0; i < 2; ++i) {
            int shapeId = new Random().nextInt(5) + 1;
            this.upcomingPieces.set(i, shapeId);
        }
        lostinfinity.instance.packetHandler.sendServerBasicPacket(new PacketFusionTable(this.func_174877_v(), this.func_174887_a_(24), 24));
        lostinfinity.instance.packetHandler.sendServerBasicPacket(new PacketFusionTable(this.func_174877_v(), this.func_174887_a_(25), 25));
    }

    @SideOnly(value=Side.CLIENT)
    public void checkMatches() {
        int i;
        if (this.board.isEmpty() || this.upcomingPieces.isEmpty()) {
            return;
        }
        for (i = 1; i <= 24; ++i) {
            if (i % 6 == 0) continue;
            if (i >= 19) break;
            int currentPiece = this.board.get(i - 1).getShapeId();
            int nextPiece = this.board.get(i).getShapeId();
            int pieceBelow = this.board.get(i + 5).getShapeId();
            int pieceBelowNext = this.board.get(i + 6).getShapeId();
            if (currentPiece != nextPiece || currentPiece != pieceBelow || currentPiece != pieceBelowNext || currentPiece == 0) continue;
            if (this.field_145850_b.field_72995_K) {
                int clientProg = this.progress + 1;
                this.shuffleBoard();
                lostinfinity.instance.packetHandler.sendServerBasicPacket(new PacketFusionTable(this.func_174877_v(), clientProg, 27));
            }
            return;
        }
        for (i = 0; i < 24; ++i) {
            if (this.board.get(i).getShapeId() <= 0 || this.board.get(i).getShapeId() >= 6) {
                return;
            }
            if (i != 23 || !this.field_145850_b.field_72995_K) continue;
            this.shuffleBoard();
            int clientProg = 0;
            lostinfinity.instance.packetHandler.sendServerBasicPacket(new PacketFusionTable(this.func_174877_v(), clientProg, 27));
        }
    }

    @SideOnly(value=Side.CLIENT)
    private void shuffleBoard() {
        this.resetBoard();
        this.fillBoard();
        this.fillUpcomingPieces();
    }

    private void fuseCraft() {
        if (this.field_145850_b.field_72995_K) {
            this.shuffleBoard();
        } else {
            ItemStack output;
            ItemStack input1 = (ItemStack)this.inventory.get(0);
            ItemStack input2 = (ItemStack)this.inventory.get(1);
            this.progress = 0;
            if (((ItemStack)this.inventory.get(2)).func_190926_b()) {
                output = new ItemStack(ItemInit.polyionite, 1);
            } else {
                output = (ItemStack)this.inventory.get(2);
                output.func_190920_e(output.func_190916_E() + 1);
            }
            input1.func_190920_e(input1.func_190916_E() - 1);
            input2.func_190920_e(input2.func_190916_E() - 1);
            this.inventory.set(0, (Object)input1);
            this.inventory.set(1, (Object)input2);
            this.inventory.set(2, (Object)output);
        }
        this.func_70296_d();
    }

    public int func_70302_i_() {
        return this.inventory.size();
    }

    public boolean func_191420_l() {
        for (ItemStack stack : this.inventory) {
            if (stack.func_190926_b()) continue;
            return false;
        }
        return true;
    }

    public ItemStack func_70301_a(int index) {
        return (ItemStack)this.inventory.get(index);
    }

    public ItemStack func_70298_a(int index, int count) {
        return ItemStackHelper.func_188382_a(this.inventory, (int)index, (int)count);
    }

    public ItemStack func_70304_b(int index) {
        return ItemStackHelper.func_188383_a(this.inventory, (int)index);
    }

    public void func_70299_a(int index, ItemStack stack) {
        this.inventory.set(index, (Object)stack);
        int limit = this.func_70297_j_();
        if (stack.func_190916_E() > limit) {
            stack.func_190920_e(limit);
        }
    }

    public int func_70297_j_() {
        return 64;
    }

    public boolean func_70300_a(Player player) {
        if (this.field_145850_b.func_175625_s(this.field_174879_c) != this) {
            return false;
        }
        return player.func_70092_e((double)this.field_174879_c.func_177958_n() + 0.5, (double)this.field_174879_c.func_177956_o() + 0.5, (double)this.field_174879_c.func_177952_p() + 0.5) <= 64.0;
    }

    public void func_174889_b(Player player) {
    }

    public void func_174886_c(Player player) {
    }

    public boolean func_94041_b(int index, ItemStack stack) {
        return false;
    }

    public CompoundTag func_189515_b(CompoundTag compound) {
        super.func_189515_b(compound);
        compound.func_74768_a("progress", this.progress);
        ItemStackHelper.func_191282_a((CompoundTag)compound, this.inventory);
        if (this.board.size() > 0) {
            for (int i = 0; i < 24; ++i) {
                compound.func_74768_a("board" + i, this.board.get(i).getShapeId());
            }
            compound.func_74768_a("upcomingPieces0", this.upcomingPieces.get(0).intValue());
            compound.func_74768_a("upcomingPieces1", this.upcomingPieces.get(1).intValue());
        }
        return compound;
    }

    public void func_145839_a(CompoundTag compound) {
        super.func_145839_a(compound);
        this.progress = compound.func_74762_e("progress");
        ItemStackHelper.func_191283_b((CompoundTag)compound, this.inventory);
        for (int i = 0; i < 24; ++i) {
            this.board.add(new BoardPiece(i / 6, i % 6, compound.func_74762_e("board" + i)));
        }
        this.upcomingPieces.add(compound.func_74762_e("upcomingPieces0"));
        this.upcomingPieces.add(compound.func_74762_e("upcomingPieces1"));
    }

    public int func_174890_g() {
        return 27;
    }

    public void func_174888_l() {
        this.inventory.clear();
    }

    public String func_70005_c_() {
        return "tile.fusion_table";
    }

    public boolean func_145818_k_() {
        return false;
    }

    public static enum Shapes {
        SQUARE(1, 0, 166),
        VERTICAL_RECTANGLE(2, 12, 166),
        DIAGONAL_RECTANGLE(3, 24, 166),
        TRIANGLE(4, 36, 166),
        HORIZONTAL_RECTANGLE(5, 48, 166);

        private final int id;
        private final int pixelX;
        private final int pixelY;

        private Shapes(int id, int pixelX, int pixelY) {
            this.id = id;
            this.pixelX = pixelX;
            this.pixelY = pixelY;
        }

        public int getId() {
            return this.id;
        }

        public int getPixelX() {
            return this.pixelX;
        }

        public int getPixelY() {
            return this.pixelY;
        }

        public static Shapes getShapeFromId(int id) {
            for (Shapes shape : Shapes.values()) {
                if (shape.getId() != id) continue;
                return shape;
            }
            return null;
        }
    }

    public class BoardPiece {
        private final int row;
        private final int column;
        private int shapeId;

        public BoardPiece(int row, int column, int shapeId) {
            this.row = row;
            this.column = column;
            this.shapeId = shapeId;
        }

        public int getRow() {
            return this.row;
        }

        public int getColumn() {
            return this.column;
        }

        public int getShapeId() {
            return this.shapeId;
        }

        public void setShapeId(int shapeId) {
            this.shapeId = shapeId;
        }

        public String toString() {
            return "Row: " + this.row + " Column: " + this.column + " ShapeId: " + this.shapeId;
        }
    }
}

