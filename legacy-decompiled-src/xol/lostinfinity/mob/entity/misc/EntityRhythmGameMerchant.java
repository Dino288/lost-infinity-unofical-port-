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
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 *  net.minecraft.world.ServerLevel
 */
package xol.lostinfinity.mob.entity.misc;

import java.util.ArrayList;
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
import net.minecraft.core.Vec3i;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import xol.lostinfinity.block.activator.BlockRhythmButton;
import xol.lostinfinity.block.activator.BlockRhythmTile;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;

public class EntityRhythmGameMerchant
extends Mob {
    private boolean game = false;
    private boolean win;
    private BlockPos startPos = null;
    private BlockPos buttonStartPos = null;
    private boolean lose = false;
    int roundsBeforeSpeed = 4;
    private int roundTimer = 21;
    private int columns = 0;
    private int time = 0;
    private int rows = 0;
    private int numButtons = 0;
    private Vec3i dirUp = new Vec3i(0, 0, 0);
    private Vec3i dirLeft = new Vec3i(0, 0, 0);
    private boolean[][] tileMap;
    private boolean[] buttons;
    private boolean sentWinMessage = false;

    public EntityRhythmGameMerchant(Level worldIn) {
        super(worldIn);
    }

    protected void func_70088_a() {
        super.func_70088_a();
    }

    public void startGame() {
        for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.func_174813_aQ().func_72314_b(15.0, 15.0, 15.0))) {
            near_pl.func_145747_a((Component)new Component(TextFmt.getFormatting(TextFmt.Bold, TextFmt.Green) + "Match the rhythm with the buttons to stay in the game!"));
            this.game = false;
        }
        this.game = true;
    }

    public void genRhythmGame(BlockPos ref) {
        this.setRhythmPositions(ref);
        this.roundTimer = 21;
        this.time = 0;
        this.roundsBeforeSpeed = 10;
        if (this.columns <= 0 || this.rows <= 0 || this.numButtons <= 0 || this.numButtons != this.columns) {
            this.func_70106_y();
            return;
        }
        this.tileMap = new boolean[this.columns][this.rows];
        this.buttons = new boolean[this.numButtons];
        this.updateStates();
    }

    private void updateStates() {
        for (int i = 0; i < this.numButtons; ++i) {
            boolean buttonActive = false;
            boolean buttonData = this.getButtonAtLocation(i);
            BlockPos buttonPos = this.getButtonPosFromIndex(i);
            BlockState state = this.field_70170_p.func_180495_p(buttonPos);
            Block block = state.func_177230_c();
            if (block instanceof BlockRhythmButton && state.equals(((BlockRhythmButton)block).getActiveState())) {
                buttonActive = true;
            }
            if (buttonActive == buttonData) continue;
            if (buttonData) {
                this.field_70170_p.func_175656_a(buttonPos, ((BlockRhythmButton)BlockInit.rhythmButton).getActiveState());
                continue;
            }
            this.field_70170_p.func_175656_a(buttonPos, ((BlockRhythmButton)BlockInit.rhythmButton).getInactiveState());
        }
        for (int c = 0; c < this.columns; ++c) {
            for (int r = 0; r < this.rows; ++r) {
                boolean tileActive = false;
                boolean tileData = this.getTileAtLocation(c, r);
                BlockPos tilePos = this.getPosFromGrid(c, r);
                BlockState state = this.field_70170_p.func_180495_p(tilePos);
                Block block = state.func_177230_c();
                if (block instanceof BlockRhythmTile && state.equals(((BlockRhythmTile)block).getActiveState())) {
                    tileActive = true;
                }
                if (tileActive == tileData) continue;
                if (tileData) {
                    this.field_70170_p.func_175656_a(tilePos, ((BlockRhythmTile)BlockInit.rhythmTile).getActiveState());
                    continue;
                }
                this.field_70170_p.func_175656_a(tilePos, ((BlockRhythmTile)BlockInit.rhythmTile).getInactiveState());
            }
        }
    }

    public void setRhythmPositions(BlockPos ref) {
        this.buttonStartPos = this.nearestButton(ref);
        this.startPos = this.nearestTile(this.buttonStartPos);
        if (this.buttonStartPos.func_177958_n() == this.startPos.func_177958_n()) {
            boolean zdir = this.startPos.func_177952_p() > this.buttonStartPos.func_177952_p();
            this.dirUp = new Vec3i(0, 0, zdir ? 1 : -1);
            this.dirLeft = new Vec3i(zdir ? 1 : -1, 0, 0);
        } else {
            boolean xdir = this.startPos.func_177958_n() > this.buttonStartPos.func_177958_n();
            this.dirUp = new Vec3i(xdir ? 1 : -1, 0, 0);
            this.dirLeft = new Vec3i(0, 0, xdir ? -1 : 1);
        }
        boolean buttons = true;
        int b = 0;
        boolean rows = true;
        boolean columns = true;
        int r = 0;
        int c = 0;
        while (buttons) {
            if (this.getBlockAtPos(this.getButtonPosFromIndex(b)) instanceof BlockRhythmButton) {
                ++b;
                continue;
            }
            buttons = false;
        }
        while (rows) {
            if (this.getBlockAtPos(this.getPosFromGrid(0, r)) instanceof BlockRhythmTile) {
                ++r;
                continue;
            }
            rows = false;
        }
        while (columns) {
            if (this.getBlockAtPos(this.getPosFromGrid(c, 0)) instanceof BlockRhythmTile) {
                ++c;
                continue;
            }
            columns = false;
        }
        this.numButtons = b;
        this.rows = r;
        this.columns = c;
    }

    private Block getBlockAtPos(BlockPos pos) {
        return this.field_70170_p.func_180495_p(pos).func_177230_c();
    }

    private BlockPos getButtonPosFromIndex(int i) {
        return this.buttonStartPos.func_177982_a(this.dirLeft.func_177958_n() * i, 0, this.dirLeft.func_177952_p() * i);
    }

    private int getButtonIndexFromPos(BlockPos pos) {
        int i = Math.abs(pos.func_177958_n() - this.buttonStartPos.func_177958_n()) + Math.abs(pos.func_177952_p() - this.buttonStartPos.func_177952_p());
        if (i < this.numButtons) {
            return i;
        }
        return 0;
    }

    private BlockPos getPosFromGrid(int c, int r) {
        return this.startPos.func_177982_a(this.dirUp.func_177958_n() * r + this.dirLeft.func_177958_n() * c, 0, this.dirUp.func_177952_p() * r + this.dirLeft.func_177952_p() * c);
    }

    public BlockPos nearestTile(BlockPos pos) {
        ArrayList<BlockPos> positions = new ArrayList<BlockPos>();
        positions.add(pos.func_177982_a(1, 0, 0));
        positions.add(pos.func_177982_a(0, 0, -1));
        positions.add(pos.func_177982_a(-1, 0, 0));
        positions.add(pos.func_177982_a(0, 0, 1));
        for (BlockPos position : positions) {
            Block block = this.field_70170_p.func_180495_p(position).func_177230_c();
            if (!(block instanceof BlockRhythmTile)) continue;
            return position;
        }
        return null;
    }

    public BlockPos nearestButton(BlockPos pos) {
        ArrayList<BlockPos> positions = new ArrayList<BlockPos>();
        positions.add(pos.func_177982_a(1, 0, 1));
        positions.add(pos.func_177982_a(1, 0, -1));
        positions.add(pos.func_177982_a(-1, 0, 1));
        positions.add(pos.func_177982_a(-1, 0, -1));
        for (BlockPos position : positions) {
            Block block = this.field_70170_p.func_180495_p(position).func_177230_c();
            if (!(block instanceof BlockRhythmButton)) continue;
            return position;
        }
        return null;
    }

    private boolean getButtonAtLocation(int i) {
        if (i >= 0 && i < this.buttons.length) {
            return this.buttons[i];
        }
        return false;
    }

    private boolean getTileAtLocation(int c, int r) {
        if (c >= 0 && c < this.tileMap.length && r >= 0 && r < this.tileMap[c].length) {
            return this.tileMap[c][r];
        }
        return false;
    }

    public boolean func_184645_a(Player player, InteractionHand hand) {
        if (!this.field_70170_p.field_72995_K && this.win) {
            this.func_145779_a(ItemInit.spacetimeTrigger, 1);
            this.win = false;
            this.deathEffect();
        }
        return true;
    }

    public void func_70636_d() {
        super.func_70636_d();
        if (!this.field_70170_p.field_72995_K) {
            ++this.time;
            if (this.field_70173_aa % 5 == 0 && this.startPos == null) {
                this.deathEffect();
            }
            if (this.lose) {
                for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.func_174813_aQ().func_72314_b(25.0, 32.0, 25.0))) {
                    near_pl.func_145747_a((Component)new Component(TextFmt.getFormatting(TextFmt.Bold, TextFmt.Green) + "You have failed to match the rhythm!"));
                }
                this.deathEffect();
            }
            if (this.time == this.roundTimer && this.game) {
                this.func_184185_a(SoundInit.DASH, 0.5f, 1.0f);
                this.progress();
                if (this.roundsBeforeSpeed == 0) {
                    this.roundsBeforeSpeed = 10;
                    for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.func_174813_aQ().func_72314_b(25.0, 32.0, 25.0))) {
                        near_pl.func_145747_a((Component)new Component(TextFmt.getFormatting(TextFmt.Bold, TextFmt.Green) + "Speed Up!"));
                    }
                    --this.roundTimer;
                } else {
                    --this.roundsBeforeSpeed;
                }
            }
            if (this.roundTimer < 18 && !this.sentWinMessage) {
                this.win = true;
                this.game = false;
                for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.func_174813_aQ().func_72314_b(25.0, 32.0, 25.0))) {
                    near_pl.func_145747_a((Component)new Component(TextFmt.getFormatting(TextFmt.Bold, TextFmt.Green) + "You have matched the whole rhythm! Come receive your reward!"));
                }
                this.sentWinMessage = true;
            }
        }
    }

    private void progress() {
        boolean goalRowHasTile = false;
        for (int c = 0; c < this.tileMap.length; ++c) {
            if (!this.getTileAtLocation(c, 0)) continue;
            goalRowHasTile = true;
        }
        if (goalRowHasTile) {
            boolean match = false;
            for (int c = 0; c < this.tileMap.length; ++c) {
                boolean tile = this.getTileAtLocation(c, 0);
                if (!tile || tile != this.getButtonAtLocation(c)) continue;
                match = true;
            }
            if (!match) {
                this.lose = true;
                this.game = false;
                return;
            }
        }
        int randColumn = this.field_70170_p.field_73012_v.nextInt(this.buttons.length);
        boolean[][] newMap = new boolean[this.columns][this.rows];
        for (int r = this.rows - 1; r > 0; --r) {
            if (r == this.rows - 1) {
                newMap[randColumn][r] = true;
            }
            for (int c = 0; c < this.columns; ++c) {
                newMap[c][r - 1] = this.tileMap[c][r];
            }
        }
        this.tileMap = newMap;
        this.time = 0;
        this.updateStates();
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

    public void pressButton(BlockPos pos) {
        int i = this.getButtonIndexFromPos(pos);
        for (int j = 0; j < this.buttons.length; ++j) {
            this.buttons[j] = j == i;
        }
        this.updateStates();
    }
}

