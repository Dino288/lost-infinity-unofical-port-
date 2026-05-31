/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.Mob
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.misc;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.dimension.data.LightSwitchGameGenerator;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;

public class EntityLightGame
extends Mob {
    private boolean lit = false;
    private List<BlockPos> lights = new ArrayList<BlockPos>();
    private List<BlockPos> switches = new ArrayList<BlockPos>();
    private List<Boolean> switchStates = new ArrayList<Boolean>();
    private LightSwitchGameGenerator game;

    public EntityLightGame(Level worldIn) {
        super(worldIn);
    }

    public EntityLightGame(Level worldIn, List<BlockPos> lights, List<BlockPos> switches) {
        super(worldIn);
        this.lights = lights;
        this.switches = switches;
    }

    public void func_70636_d() {
        block13: {
            super.func_70636_d();
            if (this.field_70170_p.field_72995_K) break block13;
            if (this.game == null) {
                int j;
                int numSwitches = this.switches.size();
                int numLights = this.lights.size();
                if (numSwitches == 0 || numLights == 0) {
                    this.func_70106_y();
                    return;
                }
                this.game = new LightSwitchGameGenerator(numSwitches, numLights);
                for (j = 0; j < numSwitches; ++j) {
                    boolean switched = this.game.getSwitch(j).isSwitched();
                    if (switched) {
                        this.field_70170_p.func_175656_a(this.switches.get(j), BlockInit.lightSwitchOn.func_176223_P());
                        this.switchStates.add(true);
                        continue;
                    }
                    this.field_70170_p.func_175656_a(this.switches.get(j), BlockInit.lightSwitchOff.func_176223_P());
                    this.switchStates.add(false);
                }
                for (j = 0; j < numLights; ++j) {
                    boolean lightLit = this.game.getLight(j).isLit();
                    if (lightLit) {
                        this.field_70170_p.func_175656_a(this.lights.get(j), BlockInit.switchableLightOn.func_176223_P());
                        continue;
                    }
                    this.field_70170_p.func_175656_a(this.lights.get(j), BlockInit.switchableLightOff.func_176223_P());
                }
            } else {
                int numSwitches = this.switches.size();
                int numLights = this.lights.size();
                if (numSwitches == 0 || numLights == 0) {
                    this.func_70106_y();
                    return;
                }
                for (int j = 0; j < numSwitches; ++j) {
                    boolean switched = this.switchStates.get(j);
                    boolean toggled = false;
                    if (switched) {
                        if (this.field_70170_p.func_180495_p(this.switches.get(j)) == BlockInit.lightSwitchOff.func_176223_P()) {
                            this.switchStates.set(j, false);
                            toggled = true;
                        }
                    } else if (this.field_70170_p.func_180495_p(this.switches.get(j)) == BlockInit.lightSwitchOn.func_176223_P()) {
                        this.switchStates.set(j, true);
                        toggled = true;
                    }
                    if (!toggled) continue;
                    boolean[] lightsToToggle = this.game.getSwitch(j).getLights();
                    this.toggle(lightsToToggle);
                }
            }
        }
    }

    public boolean func_184645_a(Player player, InteractionHand hand) {
        ItemStack held = player.func_184586_b(hand);
        if (held.func_77973_b() == ItemInit.digitalPanel) {
            if (this.win()) {
                if (!this.field_70170_p.field_72995_K) {
                    player.func_145747_a((Component)new Component(TextFmt.getFormatting(TextFmt.Bold, TextFmt.Green) + "Light Watcher: I have left you a reward!"));
                    this.func_145779_a(ItemInit.holoscreen, 1);
                    this.func_70106_y();
                }
                held.func_190918_g(1);
            } else if (!this.field_70170_p.field_72995_K) {
                player.func_145747_a((Component)new Component(TextFmt.getFormatting(TextFmt.Bold, TextFmt.Red) + "Light Watcher: The lights are not yet lit. Try again."));
            }
        }
        return true;
    }

    private boolean win() {
        boolean won = true;
        for (int i = 0; i < this.lights.size(); ++i) {
            BlockState lightState = this.field_70170_p.func_180495_p(this.lights.get(i));
            if (lightState == BlockInit.switchableLightOn.func_176223_P()) continue;
            won = false;
        }
        return won;
    }

    private void toggle(boolean[] lightsToToggle) {
        for (int i = 0; i < lightsToToggle.length; ++i) {
            BlockPos lightPos = this.lights.get(i);
            BlockState lightState = this.field_70170_p.func_180495_p(lightPos);
            if (!lightsToToggle[i]) continue;
            if (lightState == BlockInit.switchableLightOff.func_176223_P()) {
                this.field_70170_p.func_175656_a(lightPos, BlockInit.switchableLightOn.func_176223_P());
                continue;
            }
            this.field_70170_p.func_175656_a(lightPos, BlockInit.switchableLightOff.func_176223_P());
        }
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
}

