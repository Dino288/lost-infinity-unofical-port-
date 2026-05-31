/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.Mob
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.item.Item
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
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
import java.util.Collections;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.Mob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;

public class EntityMemPuzzleMerchant
extends Mob {
    private static final DataParameter<Boolean> HARD_MODE = EntityDataManager.func_187226_a(EntityMemPuzzleMerchant.class, (DataSerializer)DataSerializers.field_187198_h);
    private int puzzleStage = 0;
    private int puzzleTimer = 0;
    private int currentLight = 0;
    private ArrayList<BlockPos> lightPositions = new ArrayList();

    public EntityMemPuzzleMerchant(Level worldIn) {
        super(worldIn);
    }

    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a(HARD_MODE, (Object)false);
    }

    public boolean isHardmode() {
        return (Boolean)this.field_70180_af.func_187225_a(HARD_MODE);
    }

    public void setHardMode(boolean b) {
        this.field_70180_af.func_187227_b(HARD_MODE, (Object)b);
    }

    public void setLightPositions(BlockPos reference, int stretch, int yRange) {
        double xref = reference.func_177958_n();
        double yref = reference.func_177956_o() + 1;
        double zref = reference.func_177952_p();
        for (int y_offset = 0; y_offset <= yRange; ++y_offset) {
            for (int z_offset = -stretch; z_offset <= stretch; ++z_offset) {
                for (int x_offset = -stretch; x_offset <= stretch; ++x_offset) {
                    BlockPos checkPos = new BlockPos(xref + (double)x_offset, yref + (double)y_offset, zref + (double)z_offset);
                    BlockState checkState = this.field_70170_p.func_180495_p(checkPos);
                    if (checkState.equals(BlockInit.labyrinthChargerUnpowered.func_176223_P())) {
                        this.lightPositions.add(checkPos);
                        continue;
                    }
                    if (!checkState.equals(BlockInit.labyrinthChargerLit.func_176223_P())) continue;
                    this.lightPositions.add(checkPos);
                    this.field_70170_p.func_175656_a(checkPos, BlockInit.labyrinthChargerUnpowered.func_176223_P());
                }
            }
        }
    }

    private void randomizeLightOrder() {
        Collections.shuffle(this.lightPositions);
    }

    private void lightBlock(int list_index) {
        if (list_index > 0 && list_index <= this.lightPositions.size()) {
            BlockPos selected_pos = this.lightPositions.get(list_index - 1);
            this.field_70170_p.func_175656_a(selected_pos, BlockInit.labyrinthChargerLit.func_176223_P());
        }
    }

    private void darkenBlock(int list_index) {
        if (list_index > 0 && list_index <= this.lightPositions.size()) {
            BlockPos selected_pos = this.lightPositions.get(list_index - 1);
            this.field_70170_p.func_175656_a(selected_pos, BlockInit.labyrinthChargerUnpowered.func_176223_P());
        }
    }

    private boolean litCorrectly() {
        BlockPos selected_pos = this.lightPositions.get(this.currentLight);
        if (this.field_70170_p.func_180495_p(selected_pos).equals(BlockInit.labyrinthChargerUnpowered.func_176223_P())) {
            return false;
        }
        if (this.currentLight < this.lightPositions.size() - 1) {
            for (int check = this.currentLight + 1; check < this.lightPositions.size(); ++check) {
                BlockPos check_pos = this.lightPositions.get(check);
                if (!this.field_70170_p.func_180495_p(check_pos).equals(BlockInit.labyrinthChargerLit.func_176223_P())) continue;
                return false;
            }
        }
        return true;
    }

    private void darkenAllLights() {
        for (BlockPos pos : this.lightPositions) {
            this.field_70170_p.func_175656_a(pos, BlockInit.labyrinthChargerUnpowered.func_176223_P());
        }
    }

    private boolean validInput(Item item) {
        if (this.isHardmode()) {
            return item.equals(ItemInit.unpoweredEmberstar);
        }
        return item.equals(ItemInit.unpoweredStarcrystal);
    }

    public boolean func_184645_a(Player player, InteractionHand hand) {
        if (this.puzzleStage == 0) {
            if (this.validInput(player.func_184586_b(hand).func_77973_b())) {
                player.func_184586_b(hand).func_190918_g(1);
                this.puzzleStage = 1;
                if (!this.field_70170_p.field_72995_K) {
                    if (this.lightPositions.isEmpty()) {
                        if (this.isHardmode()) {
                            this.func_145779_a(ItemInit.unpoweredStarcrystal, 1);
                        } else {
                            this.func_145779_a(ItemInit.unpoweredEmberstar, 1);
                        }
                        player.func_145747_a((Component)new Component(TextFmt.getFormatting(TextFmt.Underline, TextFmt.Red) + "Merchant: Error detecting puzzle. Call a new merchant."));
                        this.deathEffect();
                    } else {
                        this.func_184185_a(SoundEvents.field_187620_cL, 1.0f, 1.0f);
                        this.func_184185_a(SoundEvents.field_187915_go, 1.0f, 1.0f);
                        this.randomizeLightOrder();
                        player.func_145747_a((Component)new Component(TextFmt.getFormatting(TextFmt.Italic, TextFmt.Gold) + "Merchant: I will show you a sequence of lights. You will have to memorize the sequence and power the chargers with Electrified Quartz in that order."));
                        player.func_145747_a((Component)new Component(TextFmt.getFormatting(TextFmt.Underline, TextFmt.Red) + "Merchant: After I show you, you have to interact with me after EACH charger you power within a few seconds."));
                        player.func_145747_a((Component)new Component(TextFmt.getFormatting(TextFmt.Bold, TextFmt.Green) + "Merchant: Interact with me again to begin."));
                    }
                }
            }
        } else if (!this.field_70170_p.field_72995_K) {
            if (this.puzzleStage == 1) {
                this.puzzleStage = 2;
                this.puzzleTimer = 30;
                this.currentLight = 0;
                player.func_145747_a((Component)new Component(TextFmt.getFormatting(TextFmt.Bold, TextFmt.Gold) + "Merchant: Starting sequence..."));
                this.func_184185_a(SoundEvents.field_187914_gn, 1.0f, 1.0f);
            } else if (this.puzzleStage == 3) {
                if (this.litCorrectly()) {
                    ++this.currentLight;
                    if (this.currentLight == this.lightPositions.size()) {
                        player.func_145747_a((Component)new Component(TextFmt.getFormatting(TextFmt.Bold, TextFmt.Green) + "Merchant: The core was successfully charged! I have left you a reward!"));
                        if (this.isHardmode()) {
                            this.func_145779_a(ItemInit.eternalEmberstarGenerator, 1);
                        } else {
                            this.func_145779_a(ItemInit.starcrystalCapacitor, 1);
                        }
                        this.deathEffect();
                    } else {
                        this.puzzleTimer = 140;
                        player.func_145747_a((Component)new Component(TextFmt.getFormatting(TextFmt.Bold, TextFmt.Green) + "Merchant: Correct! Charge the next one!"));
                        this.func_184185_a(SoundEvents.field_187915_go, 1.0f, 1.0f);
                    }
                } else {
                    player.func_145747_a((Component)new Component(TextFmt.getFormatting(TextFmt.Bold, TextFmt.Red) + "Merchant: Incorrect Order! The core has lost power."));
                    this.func_184185_a(SoundEvents.field_187913_gm, 1.0f, 1.0f);
                    this.deathEffect();
                }
            }
        }
        return true;
    }

    public void func_70636_d() {
        super.func_70636_d();
        if (!this.field_70170_p.field_72995_K) {
            if (this.field_70173_aa > 5 && this.lightPositions.isEmpty()) {
                this.func_70106_y();
            }
            if (this.puzzleTimer > 0) {
                --this.puzzleTimer;
                if (this.puzzleTimer == 0) {
                    if (this.puzzleStage == 2) {
                        if (this.currentLight < this.lightPositions.size()) {
                            this.puzzleTimer = 25;
                            this.darkenBlock(this.currentLight);
                            ++this.currentLight;
                            this.lightBlock(this.currentLight);
                            this.func_184185_a(SoundEvents.field_187649_bu, 2.0f, 1.0f);
                        } else {
                            for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.func_174813_aQ().func_72314_b(15.0, 15.0, 15.0))) {
                                near_pl.func_145747_a((Component)new Component(TextFmt.getFormatting(TextFmt.Bold, TextFmt.Green) + "Merchant: BEGIN!"));
                            }
                            this.puzzleTimer = 200;
                            this.darkenBlock(this.currentLight);
                            this.currentLight = 0;
                            this.puzzleStage = 3;
                        }
                    } else {
                        for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.func_174813_aQ().func_72314_b(15.0, 15.0, 15.0))) {
                            near_pl.func_145747_a((Component)new Component(TextFmt.getFormatting(TextFmt.Bold, TextFmt.Red) + "Merchant: Times up. The core has lost power!"));
                        }
                        this.deathEffect();
                    }
                }
            }
        }
    }

    private void deathEffect() {
        if (!this.lightPositions.isEmpty()) {
            this.darkenAllLights();
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
}

