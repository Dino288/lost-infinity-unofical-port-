/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.Mob
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.item.ItemEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
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
import java.util.Collections;
import java.util.Random;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
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
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;

public class EntityConnectGameMerchant
extends Mob {
    private boolean game = false;
    private ArrayList<BlockPos> buttons = new ArrayList();
    private boolean win = false;
    private Vec3i dir = new Vec3i(0, 0, 1);
    private int top;
    private BlockPos startPos;
    private boolean lose = false;
    private boolean playerPlaced = false;
    private int numConnect = 4;
    private int lastMove = 0;
    private boolean horizontal = true;
    private int up = 1;

    private int getLastMove() {
        return this.lastMove;
    }

    private void setLastMove(int lastMove) {
        this.lastMove = lastMove;
    }

    public EntityConnectGameMerchant(Level worldIn) {
        super(worldIn);
    }

    public void setDir(Vec3i dir) {
        this.dir = dir;
    }

    protected void func_70088_a() {
        super.func_70088_a();
    }

    public void startGame() {
        this.game = true;
    }

    public BlockPos nearestButton(BlockPos pos, ArrayList<BlockPos> visited) {
        BlockPos a = pos.func_177982_a(1, 0, 1);
        BlockPos b = pos.func_177982_a(-1, 0, 1);
        BlockPos c = pos.func_177982_a(1, 0, 1);
        BlockPos d = pos.func_177982_a(-1, 0, -1);
        BlockPos e = pos.func_177982_a(1, 0, 0);
        BlockPos f = pos.func_177982_a(-1, 0, 0);
        BlockPos g = pos.func_177982_a(0, 0, 1);
        BlockPos h = pos.func_177982_a(0, 0, -1);
        BlockPos i = pos.func_177982_a(1, 0, -1);
        BlockState state = this.field_70170_p.func_180495_p(i);
        if (this.field_70170_p.func_180495_p(a) == BlockInit.connectButton.func_176223_P() && !visited.contains(a)) {
            return a;
        }
        if (this.field_70170_p.func_180495_p(b) == BlockInit.connectButton.func_176223_P() && !visited.contains(b)) {
            return b;
        }
        if (this.field_70170_p.func_180495_p(c) == BlockInit.connectButton.func_176223_P() && !visited.contains(c)) {
            return c;
        }
        if (this.field_70170_p.func_180495_p(d) == BlockInit.connectButton.func_176223_P() && !visited.contains(d)) {
            return d;
        }
        if (this.field_70170_p.func_180495_p(e) == BlockInit.connectButton.func_176223_P() && !visited.contains(e)) {
            return e;
        }
        if (this.field_70170_p.func_180495_p(f) == BlockInit.connectButton.func_176223_P() && !visited.contains(f)) {
            return f;
        }
        if (this.field_70170_p.func_180495_p(g) == BlockInit.connectButton.func_176223_P() && !visited.contains(g)) {
            return g;
        }
        if (this.field_70170_p.func_180495_p(h) == BlockInit.connectButton.func_176223_P() && !visited.contains(h)) {
            return h;
        }
        if (this.field_70170_p.func_180495_p(i) == BlockInit.connectButton.func_176223_P() && !visited.contains(i)) {
            return i;
        }
        return null;
    }

    public void setButtonPositions(BlockPos reference, int stretch, int yRange, int numConnect) {
        boolean operatingX;
        this.numConnect = numConnect;
        this.top = stretch * 2;
        BlockPos pos = reference.func_177982_a(0, -1, 0);
        ArrayList<BlockPos> visited = new ArrayList<BlockPos>();
        ArrayList<BlockPos> tempbuttons = new ArrayList<BlockPos>();
        while (this.nearestButton(pos, visited) != null && this.field_70170_p.func_180495_p(this.nearestButton(pos, visited)) == BlockInit.connectButton.func_176223_P()) {
            pos = this.nearestButton(pos, visited);
            tempbuttons.add(pos);
            visited.add(pos);
        }
        double xref = reference.func_177958_n();
        double yref = reference.func_177956_o() - 1;
        double zref = reference.func_177952_p();
        ArrayList<Double> values = new ArrayList<Double>();
        double yValue = ((BlockPos)tempbuttons.get(0)).func_177956_o();
        double xValue = ((BlockPos)tempbuttons.get(0)).func_177958_n();
        double zValue = ((BlockPos)tempbuttons.get(0)).func_177952_p();
        boolean bl = operatingX = ((BlockPos)tempbuttons.get(0)).func_177958_n() != ((BlockPos)tempbuttons.get(1)).func_177958_n();
        if (!tempbuttons.isEmpty()) {
            for (BlockPos tempPos : tempbuttons) {
                values.add(Double.valueOf(operatingX ? tempPos.func_177958_n() : tempPos.func_177952_p()));
            }
            Collections.sort(values);
            for (Double tempValue : values) {
                this.buttons.add(new BlockPos(operatingX ? tempValue : xValue, yValue, operatingX ? zValue : tempValue));
            }
        }
        BlockPos b1 = this.buttons.get(0);
        BlockPos b2 = this.buttons.get(1);
        BlockPos b3 = b1.func_177982_a(1, 0, 0);
        BlockState state = this.field_70170_p.func_180495_p(b3);
        if (b1.func_177952_p() != b2.func_177952_p()) {
            this.horizontal = false;
            if (this.field_70170_p.func_180495_p(b1.func_177982_a(1, 0, 0)).func_177230_c() == BlockInit.connectBlock || this.field_70170_p.func_180495_p(b1.func_177982_a(1, 0, 0)).func_177230_c() == BlockInit.connectBlockYellow || this.field_70170_p.func_180495_p(b1.func_177982_a(1, 0, 0)).func_177230_c() == BlockInit.connectBlockRed) {
                this.up = 1;
                this.startPos = b1.func_177982_a(1, 0, 0);
            } else {
                this.up = -1;
                this.startPos = b1.func_177982_a(-1, 0, 0);
            }
        } else {
            this.horizontal = true;
            if (this.field_70170_p.func_180495_p(b1.func_177982_a(0, 0, 1)).func_177230_c() == BlockInit.connectBlock || this.field_70170_p.func_180495_p(b1.func_177982_a(0, 0, 1)).func_177230_c() == BlockInit.connectBlockYellow || this.field_70170_p.func_180495_p(b1.func_177982_a(0, 0, 1)).func_177230_c() == BlockInit.connectBlockRed) {
                this.up = 1;
                this.startPos = b1.func_177982_a(0, 0, 1);
            } else {
                this.up = -1;
                this.startPos = b1.func_177982_a(0, 0, 1);
            }
        }
    }

    public boolean playerPlaced() {
        return this.playerPlaced;
    }

    public void clearTokens() {
        BlockPos ref = this.startPos;
        if (ref != null) {
            for (int i = -1; i < this.buttons.size() + 1; ++i) {
                for (int j = 0; j < this.top && j > -this.top; j += this.up) {
                    BlockPos temp = ref.func_177982_a(this.horizontal ? i : j, 0, this.horizontal ? j : i);
                    BlockState state = this.field_70170_p.func_180495_p(temp);
                    if (state != BlockInit.connectBlockRed.func_176223_P() && state != BlockInit.connectBlockYellow.func_176223_P() && state != BlockInit.connectBlock.func_176223_P()) continue;
                    this.field_70170_p.func_175656_a(temp, BlockInit.connectBlock.func_176223_P());
                }
            }
        }
    }

    public boolean func_184645_a(Player player, InteractionHand hand) {
        if (!this.field_70170_p.field_72995_K && this.win) {
            player.func_145747_a((Component)new Component(TextFmt.getFormatting(TextFmt.Bold, TextFmt.Green) + "I have left you a reward!"));
            ItemStack mapstack = new ItemStack(ItemInit.resolveMap);
            mapstack.func_77982_d(new CompoundTag());
            mapstack.func_77978_p().func_74768_a("MapEntityType", this.field_70170_p.field_73012_v.nextInt(8));
            mapstack.func_77978_p().func_74768_a("MapEntityNum", 2 + this.field_70170_p.field_73012_v.nextInt(4));
            ItemEntity geoloc = new ItemEntity(this.field_70170_p, player.field_70165_t, player.field_70163_u + 1.0, player.field_70161_v, mapstack);
            geoloc.field_70159_w = 0.0;
            geoloc.field_70181_x = 0.0;
            geoloc.field_70179_y = 0.0;
            this.field_70170_p.func_72838_d((Entity)geoloc);
            this.win = false;
            this.deathEffect();
        } else if (!this.field_70170_p.field_72995_K && !this.game) {
            this.clearTokens();
            this.startGame();
            player.func_145747_a((Component)new Component(TextFmt.getFormatting(TextFmt.Bold, TextFmt.Green) + "Start!"));
        } else if (!this.field_70170_p.field_72995_K && this.lose) {
            player.func_145747_a((Component)new Component(TextFmt.getFormatting(TextFmt.Bold, TextFmt.Green) + "Sorry, you didn't win this time!"));
            this.game = false;
        }
        return true;
    }

    public void func_70636_d() {
        super.func_70636_d();
        if (!this.field_70170_p.field_72995_K) {
            if (this.field_70173_aa > 5 && this.buttons.isEmpty()) {
                this.deathEffect();
            }
            if (this.win && this.game) {
                for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.func_174813_aQ().func_72314_b(15.0, 15.0, 15.0))) {
                    near_pl.func_145747_a((Component)new Component(TextFmt.getFormatting(TextFmt.Bold, TextFmt.Green) + "You have won! Come get your reward"));
                    this.game = false;
                }
            }
            if (this.lose && this.field_70173_aa % 140 == 5) {
                for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.func_174813_aQ().func_72314_b(15.0, 15.0, 15.0))) {
                    near_pl.func_145747_a((Component)new Component(TextFmt.getFormatting(TextFmt.Bold, TextFmt.Green) + "Sorry, you didn't win this time!"));
                    this.game = false;
                }
                this.deathEffect();
            }
            if (!this.lose && this.game && this.playerPlaced && this.field_70173_aa % 20 == 0) {
                this.opponentPlace();
                if (this.isComplete()) {
                    this.lose = true;
                }
            }
        }
    }

    public boolean isLost() {
        return this.lose;
    }

    private void opponentPlace() {
        BlockPos playerWinPos = this.findPlayerWin();
        if (playerWinPos != null) {
            for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.func_174813_aQ().func_72314_b(15.0, 15.0, 15.0))) {
                near_pl.func_145747_a((Component)new Component(TextFmt.getFormatting(TextFmt.Bold, TextFmt.Green) + "I won't allow you to win that easy!"));
            }
            this.playerPlaced = false;
            this.put(playerWinPos, false);
            return;
        }
        Random rand = new Random();
        int ability = rand.nextInt(4);
        while (ability == this.getLastMove()) {
            ability = rand.nextInt(4);
        }
        this.setLastMove(ability);
        switch (ability) {
            case 0: {
                this.replacePlayerPiece();
                for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.func_174813_aQ().func_72314_b(15.0, 15.0, 15.0))) {
                    near_pl.func_145747_a((Component)new Component(TextFmt.getFormatting(TextFmt.Bold, TextFmt.Green) + "I'll take one of yours!"));
                }
                break;
            }
            case 1: {
                this.randomPlace();
                this.randomPlace();
                for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.func_174813_aQ().func_72314_b(15.0, 15.0, 15.0))) {
                    near_pl.func_145747_a((Component)new Component(TextFmt.getFormatting(TextFmt.Bold, TextFmt.Green) + "Double Up!"));
                }
                break;
            }
            case 2: {
                this.placeOnTop();
                for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.func_174813_aQ().func_72314_b(15.0, 15.0, 15.0))) {
                    near_pl.func_145747_a((Component)new Component(TextFmt.getFormatting(TextFmt.Bold, TextFmt.Green) + "I'll pile up my pieces until you surrender"));
                }
                break;
            }
        }
    }

    private void replacePlayerPiece() {
        BlockPos ref = this.startPos;
        if (ref != null) {
            for (int i = 0; i < this.buttons.size(); ++i) {
                for (int j = 0; j < this.top && j > -this.top; j += this.up) {
                    BlockPos temp = ref.func_177982_a(this.horizontal ? i : j, 0, this.horizontal ? j : i);
                    BlockState state = this.field_70170_p.func_180495_p(temp);
                    if (state != BlockInit.connectBlockYellow.func_176223_P()) continue;
                    this.field_70170_p.func_175656_a(temp, BlockInit.connectBlockRed.func_176223_P());
                    this.playerPlaced = false;
                    return;
                }
            }
        }
    }

    private void placeOnTop() {
        BlockPos ref = this.startPos;
        if (ref != null) {
            for (int i = 0; i < this.buttons.size(); ++i) {
                for (int j = 0; j < this.top && j > -this.top; j += this.up) {
                    BlockPos temp = ref.func_177982_a(this.horizontal ? i : j, 0, this.horizontal ? j : i);
                    BlockState state = this.field_70170_p.func_180495_p(temp);
                    if (state != BlockInit.connectBlockYellow.func_176223_P() && state != BlockInit.connectBlockRed.func_176223_P()) continue;
                    this.playerPlaced = false;
                    this.put(this.buttons.get(i), false);
                    return;
                }
            }
        }
    }

    private BlockPos findPlayerWin() {
        BlockPos ref = this.startPos;
        if (ref != null) {
            for (int i = 0; i < this.buttons.size() && i > this.buttons.size(); i -= this.up) {
                for (int j = 0; j < this.top && j > -this.top; j += this.up) {
                    BlockState belowState;
                    BlockPos temp = ref.func_177982_a(this.horizontal ? i : j, 0, this.horizontal ? j : i);
                    BlockState state = this.field_70170_p.func_180495_p(temp);
                    if (state != BlockInit.connectBlockYellow.func_176223_P()) continue;
                    boolean connectLeft = true;
                    boolean connectRight = true;
                    boolean connectUp = true;
                    boolean connectUpLeft = true;
                    boolean connectUpRight = true;
                    for (int k = 0; k < this.numConnect - 1; ++k) {
                        BlockState stateLeft = this.field_70170_p.func_180495_p(temp.func_177982_a(this.horizontal ? k : 0, 0, this.horizontal ? 0 : k));
                        BlockState stateRight = this.field_70170_p.func_180495_p(temp.func_177982_a(this.horizontal ? -k : 0, 0, this.horizontal ? 0 : -k));
                        BlockState stateUp = this.field_70170_p.func_180495_p(temp.func_177982_a(this.horizontal ? 0 : k * this.up, 0, this.horizontal ? k * this.up : 0));
                        BlockState stateUpLeft = this.field_70170_p.func_180495_p(temp.func_177982_a(this.horizontal ? k : k * this.up, 0, this.horizontal ? k * this.up : k));
                        BlockState stateUpRight = this.field_70170_p.func_180495_p(temp.func_177982_a(this.horizontal ? -k : k * this.up, 0, this.horizontal ? k * this.up : -k));
                        if (stateLeft != BlockInit.connectBlockYellow.func_176223_P()) {
                            connectLeft = false;
                        }
                        if (stateRight != BlockInit.connectBlockYellow.func_176223_P()) {
                            connectRight = false;
                        }
                        if (stateUp != BlockInit.connectBlockYellow.func_176223_P()) {
                            connectUp = false;
                        }
                        if (stateUpLeft != BlockInit.connectBlockYellow.func_176223_P()) {
                            connectUpLeft = false;
                        }
                        if (stateUpRight == BlockInit.connectBlockYellow.func_176223_P()) continue;
                        connectUpRight = false;
                    }
                    if (connectLeft) {
                        BlockState hereState = this.field_70170_p.func_180495_p(temp.func_177982_a(this.horizontal ? this.numConnect - 1 : 0, 0, this.horizontal ? 0 : this.numConnect - 1));
                        belowState = this.field_70170_p.func_180495_p(temp.func_177982_a(this.horizontal ? this.numConnect - 1 : 0, 0, this.horizontal ? 0 : this.numConnect - 1).func_177982_a(this.horizontal ? 0 : -1 * this.up, 0, this.horizontal ? -1 * this.up : 0));
                        if (belowState != BlockInit.connectBlock.func_176223_P() && hereState == BlockInit.connectBlock.func_176223_P()) {
                            return this.buttons.get(i + this.numConnect - 1);
                        }
                    }
                    if (connectRight) {
                        BlockState hereState = this.field_70170_p.func_180495_p(temp.func_177982_a(this.horizontal ? -(this.numConnect - 1) : 0, 0, this.horizontal ? 0 : -(this.numConnect - 1)));
                        belowState = this.field_70170_p.func_180495_p(temp.func_177982_a(this.horizontal ? -(this.numConnect - 1) : 0, 0, this.horizontal ? 0 : -(this.numConnect - 1)).func_177982_a(this.horizontal ? 0 : -1 * this.up, 0, this.horizontal ? -1 * this.up : 0));
                        if (belowState != BlockInit.connectBlock.func_176223_P() && hereState == BlockInit.connectBlock.func_176223_P()) {
                            return this.buttons.get(i - this.numConnect + 1);
                        }
                    }
                    if (connectUp) {
                        BlockState belowState2 = this.field_70170_p.func_180495_p(temp.func_177982_a(this.horizontal ? 0 : this.numConnect * this.up, 0, this.horizontal ? this.numConnect * this.up : 0).func_177982_a(this.horizontal ? 0 : -1 * this.up, 0, this.horizontal ? -1 * this.up : 0));
                        BlockState hereState = this.field_70170_p.func_180495_p(temp.func_177982_a(this.horizontal ? 0 : this.numConnect * this.up, 0, this.horizontal ? this.numConnect * this.up : 0));
                        if (hereState == BlockInit.connectBlock.func_176223_P() && belowState2 != BlockInit.connectBlockRed.func_176223_P()) {
                            return this.buttons.get(i);
                        }
                    }
                    if (connectUpRight) {
                        BlockState hereState = this.field_70170_p.func_180495_p(temp.func_177982_a(this.horizontal ? -(this.numConnect - 1) : this.numConnect * this.up, 0, this.horizontal ? this.numConnect * this.up : -(this.numConnect - 1)));
                        belowState = this.field_70170_p.func_180495_p(temp.func_177982_a(this.horizontal ? -(this.numConnect - 1) : this.numConnect * this.up, 0, this.horizontal ? this.numConnect * this.up : -(this.numConnect - 1)).func_177982_a(this.horizontal ? 0 : -1 * this.up, 0, this.horizontal ? -1 * this.up : 0));
                        if (belowState != BlockInit.connectBlock.func_176223_P() && hereState == BlockInit.connectBlock.func_176223_P()) {
                            return this.buttons.get(i - this.numConnect + 1);
                        }
                    }
                    if (!connectUpLeft) continue;
                    BlockState hereState = this.field_70170_p.func_180495_p(temp.func_177982_a(this.horizontal ? this.numConnect - 1 : this.numConnect * this.up, 0, this.horizontal ? this.numConnect * this.up : this.numConnect - 1));
                    belowState = this.field_70170_p.func_180495_p(temp.func_177982_a(this.horizontal ? this.numConnect - 1 : this.numConnect * this.up, 0, this.horizontal ? this.numConnect * this.up : this.numConnect - 1).func_177982_a(this.horizontal ? 0 : -1 * this.up, 0, this.horizontal ? -1 * this.up : 0));
                    if (belowState == BlockInit.connectBlock.func_176223_P() || hereState != BlockInit.connectBlock.func_176223_P()) continue;
                    return this.buttons.get(i + this.numConnect - 1);
                }
            }
        }
        return null;
    }

    private void randomPlace() {
        Random rand = new Random();
        int randButton = rand.nextInt(this.buttons.size());
        if (this.put(this.buttons.get(randButton), false)) {
            this.playerPlaced = false;
        }
    }

    private void deathEffect() {
        if (!this.buttons.isEmpty()) {
            this.clearTokens();
        }
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

    public boolean put(BlockPos pos, boolean isPlayer) {
        if (this.isComplete()) {
            if (isPlayer) {
                this.win = true;
            } else {
                this.lose = true;
            }
        }
        this.game = true;
        BlockPos ref = null;
        boolean placed = false;
        for (BlockPos button : this.buttons) {
            if (button.func_177958_n() != pos.func_177958_n() || button.func_177956_o() != pos.func_177956_o() || button.func_177952_p() != pos.func_177952_p()) continue;
            ref = button;
            break;
        }
        if (ref != null) {
            BlockPos check = ref.func_177982_a(this.horizontal ? 0 : 1 * this.up, 0, this.horizontal ? 1 * this.up : 0);
            for (int i = 0; i < this.top && i > -this.top; i += this.up) {
                BlockState checkState = this.field_70170_p.func_180495_p(check);
                if (checkState.func_177230_c() == BlockInit.connectBlockYellow || checkState.func_177230_c() == BlockInit.connectBlockRed) {
                    check = check.func_177982_a(this.horizontal ? 0 : 1 * this.up, 0, this.horizontal ? 1 * this.up : 0);
                    continue;
                }
                if (checkState.func_177230_c() == BlockInit.connectBlock) break;
                if (i != 0) continue;
                return false;
            }
            if (isPlayer) {
                if (this.field_70170_p.func_180495_p(check) == BlockInit.connectBlock.func_176223_P()) {
                    this.field_70170_p.func_175656_a(check, BlockInit.connectBlockYellow.func_176223_P());
                    this.playerPlaced = true;
                    placed = true;
                }
            } else if (this.field_70170_p.func_180495_p(check) == BlockInit.connectBlock.func_176223_P()) {
                this.field_70170_p.func_175656_a(check, BlockInit.connectBlockRed.func_176223_P());
                placed = true;
            }
            if (this.isComplete()) {
                if (isPlayer) {
                    this.win = true;
                } else {
                    this.lose = true;
                }
            }
        }
        return placed;
    }

    private boolean isComplete() {
        BlockPos ref = this.startPos;
        if (ref != null) {
            for (int i = -1; i < this.buttons.size(); ++i) {
                for (int j = 0; j < this.top && j > -this.top; j += this.up) {
                    BlockState stateUpRight;
                    BlockState stateUpLeft;
                    BlockState stateUp;
                    BlockState stateRight;
                    BlockState stateLeft;
                    int k;
                    boolean connectUpRight;
                    boolean connectUpLeft;
                    boolean connectUp;
                    boolean connectRight;
                    boolean connectLeft;
                    BlockPos temp = ref.func_177982_a(this.horizontal ? i : j, 0, this.horizontal ? j : i);
                    BlockState state = this.field_70170_p.func_180495_p(temp);
                    if (state == BlockInit.connectBlockYellow.func_176223_P()) {
                        connectLeft = true;
                        connectRight = true;
                        connectUp = true;
                        connectUpLeft = true;
                        connectUpRight = true;
                        for (k = 0; k < this.numConnect; ++k) {
                            stateLeft = this.field_70170_p.func_180495_p(temp.func_177982_a(this.horizontal ? k : 0, 0, this.horizontal ? 0 : k));
                            stateRight = this.field_70170_p.func_180495_p(temp.func_177982_a(this.horizontal ? -k : 0, 0, this.horizontal ? 0 : -k));
                            stateUp = this.field_70170_p.func_180495_p(temp.func_177982_a(this.horizontal ? 0 : k * this.up, 0, this.horizontal ? k * this.up : 0));
                            stateUpLeft = this.field_70170_p.func_180495_p(temp.func_177982_a(this.horizontal ? k : k * this.up, 0, this.horizontal ? k * this.up : k));
                            stateUpRight = this.field_70170_p.func_180495_p(temp.func_177982_a(this.horizontal ? -k : k * this.up, 0, this.horizontal ? k * this.up : -k));
                            if (stateLeft != BlockInit.connectBlockYellow.func_176223_P()) {
                                connectLeft = false;
                            }
                            if (stateRight != BlockInit.connectBlockYellow.func_176223_P()) {
                                connectRight = false;
                            }
                            if (stateUp != BlockInit.connectBlockYellow.func_176223_P()) {
                                connectUp = false;
                            }
                            if (stateUpLeft != BlockInit.connectBlockYellow.func_176223_P()) {
                                connectUpLeft = false;
                            }
                            if (stateUpRight == BlockInit.connectBlockYellow.func_176223_P()) continue;
                            connectUpRight = false;
                        }
                        if (!connectLeft && !connectRight && !connectUp && !connectUpLeft && !connectUpRight) continue;
                        return true;
                    }
                    if (state != BlockInit.connectBlockRed.func_176223_P()) continue;
                    connectLeft = true;
                    connectRight = true;
                    connectUp = true;
                    connectUpLeft = true;
                    connectUpRight = true;
                    for (k = 0; k < this.numConnect; ++k) {
                        stateLeft = this.field_70170_p.func_180495_p(temp.func_177982_a(this.horizontal ? k : 0, 0, this.horizontal ? 0 : k));
                        stateRight = this.field_70170_p.func_180495_p(temp.func_177982_a(this.horizontal ? -k : 0, 0, this.horizontal ? 0 : -k));
                        stateUp = this.field_70170_p.func_180495_p(temp.func_177982_a(this.horizontal ? 0 : k * this.up, 0, this.horizontal ? k * this.up : 0));
                        stateUpLeft = this.field_70170_p.func_180495_p(temp.func_177982_a(this.horizontal ? k : k * this.up, 0, this.horizontal ? k * this.up : k));
                        stateUpRight = this.field_70170_p.func_180495_p(temp.func_177982_a(this.horizontal ? -k : k * this.up, 0, this.horizontal ? k * this.up : -k));
                        if (stateLeft != BlockInit.connectBlockRed.func_176223_P()) {
                            connectLeft = false;
                        }
                        if (stateRight != BlockInit.connectBlockRed.func_176223_P()) {
                            connectRight = false;
                        }
                        if (stateUp != BlockInit.connectBlockRed.func_176223_P()) {
                            connectUp = false;
                        }
                        if (stateUpLeft != BlockInit.connectBlockRed.func_176223_P()) {
                            connectUpLeft = false;
                        }
                        if (stateUpRight == BlockInit.connectBlockRed.func_176223_P()) continue;
                        connectUpRight = false;
                    }
                    if (!connectLeft && !connectRight && !connectUp && !connectUpLeft && !connectUpRight) continue;
                    return true;
                }
            }
        }
        return false;
    }
}

