/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.Mob
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.EnumParticleTypes
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 *  net.minecraft.world.ServerLevel
 */
package xol.lostinfinity.mob.entity.misc;

import java.util.ArrayList;
import java.util.Random;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.Mob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import xol.lostinfinity.block.activator.BlockCellContainer;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;

public class EntityCellGameMerchant
extends Mob {
    private boolean game = false;
    private boolean win = false;
    private boolean lose = false;
    private int cell1 = -1;
    private int cell2 = -1;
    private static int numSteps = 30;
    private boolean sentWinMessage = false;
    private ArrayList<BlockPos> cells = null;
    private ArrayList<Integer> amounts = null;
    private ArrayList<Integer> winningAmounts = null;
    private ArrayList<Integer> capacities = null;

    public void setCellPositions(BlockPos ref, int radius, Level world, Player playerIn) {
        this.cells = new ArrayList();
        this.amounts = new ArrayList();
        this.capacities = new ArrayList();
        this.winningAmounts = new ArrayList();
        for (int i = -radius; i <= radius; ++i) {
            for (int k = -radius; k <= radius; ++k) {
                if (!(world.func_180495_p(ref.func_177982_a(i, 1, k)).func_177230_c() instanceof BlockCellContainer)) continue;
                this.cells.add(ref.func_177982_a(i, 1, k));
                BlockState state = this.getRandomCell();
                this.field_70170_p.func_175656_a(ref.func_177982_a(i, 1, k), state);
                Block cell = state.func_177230_c();
                int capacity = this.getBlockCapacity(cell);
                int randAmount = world.field_73012_v.nextInt(capacity + 1);
                this.capacities.add(capacity);
                this.amounts.add(randAmount);
                this.setCellState(this.cells.size() - 1, randAmount, world);
            }
        }
        this.setGoalAmounts(world, playerIn);
        this.startGame();
    }

    public BlockState getRandomCell() {
        Random rand = new Random();
        int randCell = rand.nextInt(4);
        switch (randCell) {
            case 0: {
                return BlockInit.cellContainer3.func_176223_P();
            }
            case 1: {
                return BlockInit.cellContainer5.func_176223_P();
            }
            case 2: {
                return BlockInit.cellContainer7.func_176223_P();
            }
            case 3: {
                return BlockInit.cellContainer9.func_176223_P();
            }
        }
        return BlockInit.cellContainer3.func_176223_P();
    }

    private int getBlockCapacity(Block block) {
        if (block.equals(BlockInit.cellContainer3)) {
            return 3;
        }
        if (block.equals(BlockInit.cellContainer5)) {
            return 5;
        }
        if (block.equals(BlockInit.cellContainer7)) {
            return 7;
        }
        if (block.equals(BlockInit.cellContainer9)) {
            return 9;
        }
        return 0;
    }

    private void setGoalAmounts(Level world, Player playerIn) {
        ArrayList<Integer> tempAmounts = new ArrayList<Integer>();
        tempAmounts.addAll(this.amounts);
        for (int i = 0; i < numSteps; ++i) {
            int first = world.field_73012_v.nextInt(this.cells.size());
            int second = world.field_73012_v.nextInt(this.cells.size());
            while (second == first) {
                second = world.field_73012_v.nextInt(this.cells.size());
            }
            int amount1 = (Integer)tempAmounts.get(first);
            int amount2 = (Integer)tempAmounts.get(second);
            int capacity = this.capacities.get(second);
            int space = capacity - amount2;
            if (amount1 <= space) {
                amount2 += amount1;
                amount1 = 0;
            } else if (amount1 > space) {
                amount1 -= space;
                amount2 += space;
            }
            tempAmounts.set(first, amount1);
            tempAmounts.set(second, amount2);
        }
        this.winningAmounts.addAll(tempAmounts);
    }

    public EntityCellGameMerchant(Level worldIn) {
        super(worldIn);
    }

    public void selectCell1(BlockPos pos, Level world, Player playerIn) {
        for (int i = 0; i < this.cells.size(); ++i) {
            BlockPos cellPos = this.cells.get(i);
            if (!pos.equals((Object)cellPos)) continue;
            if (this.cell1 != i) {
                this.cell1 = i;
                playerIn.func_145747_a((Component)new Component(TextFmt.getFormatting(TextFmt.Bold, TextFmt.Green) + String.format("Container %d selected to transfer from", i + 1)));
            }
            if (this.cell1 != -1 && this.cell2 != -1) {
                this.pour(world, playerIn);
            }
            return;
        }
    }

    public void selectCell2(BlockPos pos, Level world, Player playerIn) {
        for (int i = 0; i < this.cells.size(); ++i) {
            BlockPos cellPos = this.cells.get(i);
            if (!pos.equals((Object)cellPos)) continue;
            if (this.cell2 != i) {
                this.cell2 = i;
                playerIn.func_145747_a((Component)new Component(TextFmt.getFormatting(TextFmt.Bold, TextFmt.Green) + String.format("Container %d selected as receptacle", i + 1)));
            }
            if (this.cell1 != -1 && this.cell2 != -1) {
                this.pour(world, playerIn);
            }
            return;
        }
    }

    private void pour(Level world, Player playerIn) {
        if (this.cell1 != -1 && this.cell2 != -1 && this.cell1 != this.cell2) {
            int amount1 = this.amounts.get(this.cell1);
            int amount2 = this.amounts.get(this.cell2);
            int capacity = this.capacities.get(this.cell2);
            int space = capacity - amount2;
            if (amount1 <= space) {
                amount2 += amount1;
                amount1 = 0;
            } else if (amount1 > space) {
                amount1 -= space;
                amount2 += space;
            }
            this.amounts.set(this.cell1, amount1);
            this.amounts.set(this.cell2, amount2);
            this.setCellState(this.cell1, amount1, world);
            this.setCellState(this.cell2, amount2, world);
            playerIn.func_145747_a((Component)new Component(TextFmt.getFormatting(TextFmt.Bold, TextFmt.Green) + String.format("Transferred possible cells from container %d to container %d", this.cell1 + 1, this.cell2 + 1)));
            this.cell1 = -1;
            this.cell2 = -1;
            if (this.game) {
                this.checkWin(playerIn);
            }
        }
    }

    private void checkWin(Player playerIn) {
        for (int i = 0; i < this.amounts.size(); ++i) {
            if (this.amounts.get(i) == this.winningAmounts.get(i)) continue;
            this.win = false;
            return;
        }
        this.win = true;
    }

    private void setCellState(int cell, int amount, Level world) {
        Block block = world.func_180495_p(this.cells.get(cell)).func_177230_c();
        if (block instanceof BlockCellContainer) {
            this.field_70170_p.func_175656_a(this.cells.get(cell), ((BlockCellContainer)block).getStateWithAmount(amount));
        }
    }

    protected void func_70088_a() {
        super.func_70088_a();
    }

    public void startGame() {
        for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.func_174813_aQ().func_72314_b(15.0, 15.0, 15.0))) {
            near_pl.func_145747_a((Component)new Component(TextFmt.getFormatting(TextFmt.Bold, TextFmt.Green) + "Transfer cells between the containers to balance them to the correct levels, click with power analyzer to select which container to transfer from, click with hand to set the container receiving power."));
        }
        this.game = true;
    }

    public boolean func_184645_a(Player player, InteractionHand hand) {
        if (!this.field_70170_p.field_72995_K && this.win) {
            if (this.func_110143_aJ() == 69.0f) {
                this.func_145779_a(ItemInit.powerBlade, 1);
            } else if (this.func_110143_aJ() == 420.0f) {
                this.func_145779_a(ItemInit.microstoragePowerCluster, 1);
            }
            this.win = false;
            this.deathEffect();
        }
        return true;
    }

    public void func_70636_d() {
        super.func_70636_d();
        if (!this.field_70170_p.field_72995_K) {
            if (this.field_70173_aa % 5 == 0 && this.cells == null) {
                this.deathEffect();
            }
            if (this.field_70173_aa % 140000 == 0 && this.cells != null && !this.win) {
                for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.func_174813_aQ().func_72314_b(25.0, 35.0, 25.0))) {
                    near_pl.func_145747_a((Component)new Component(TextFmt.getFormatting(TextFmt.Bold, TextFmt.Red) + "Oh no! The levels are still incorrect!"));
                    this.game = false;
                }
                this.deathEffect();
            }
            if (this.win && !this.sentWinMessage) {
                for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.func_174813_aQ().func_72314_b(25.0, 32.0, 25.0))) {
                    near_pl.func_145747_a((Component)new Component(TextFmt.getFormatting(TextFmt.Bold, TextFmt.Green) + "The levels are correct! Come receive your reward!"));
                }
                this.sentWinMessage = true;
            }
        }
    }

    private void deathEffect() {
        ((ServerLevel)this.field_70170_p).func_175739_a(EnumParticleTypes.PORTAL, this.field_70165_t, this.field_70163_u, this.field_70161_v, 12, (-0.5 + this.field_70146_Z.nextDouble()) * 3.0, 0.3, (-0.5 + this.field_70146_Z.nextDouble()) * 3.0, (double)0.15f, new int[0]);
        this.func_70106_y();
    }

    protected SoundEvent func_184639_G() {
        return SoundEvents.field_187910_gj;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundEvents.field_187912_gl;
    }

    protected SoundEvent func_184615_bR() {
        return SoundEvents.field_187911_gk;
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.2);
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(20.0);
    }

    public void readPowerLevel(BlockPos pos, Level worldIn, Player playerIn) {
        for (int i = 0; i < this.cells.size(); ++i) {
            BlockPos cellPos = this.cells.get(i);
            if (!pos.equals((Object)cellPos)) continue;
            int goalAmount = this.winningAmounts.get(i);
            playerIn.func_145747_a((Component)new Component(TextFmt.getFormatting(TextFmt.Bold, TextFmt.Green) + String.format("This container needs %d cells", goalAmount)));
            return;
        }
    }
}

