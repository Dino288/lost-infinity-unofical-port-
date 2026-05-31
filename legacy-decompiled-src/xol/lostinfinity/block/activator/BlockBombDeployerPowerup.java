/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.Direction
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.activator;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.potion.PotionEffect;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasicLight;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.PotionInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.item.activate.ItemBombDeployer;

public class BlockBombDeployerPowerup
extends BlockBasicLight {
    private int power_type = 0;

    public BlockBombDeployerPowerup(String name, int type) {
        super(name);
        this.func_149715_a(1.0f);
        this.power_type = type;
    }

    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        ItemStack held = playerIn.func_184586_b(hand);
        if (held.func_77973_b() instanceof ItemBombDeployer) {
            if (!held.func_77942_o()) {
                held.func_77982_d(new CompoundTag());
            }
            switch (this.power_type) {
                case 0: {
                    int speedVal = held.func_77978_p().func_74762_e("BombSpeed");
                    if (++speedVal > 5) {
                        speedVal = 5;
                        if (!worldIn.field_72995_K) {
                            playerIn.func_145747_a((Component)new Component((Object)((Object)TextFmt.Red) + "Bomb Deployer at max speed."));
                        }
                    }
                    held.func_77978_p().func_74768_a("BombSpeed", speedVal);
                    break;
                }
                case 1: {
                    int sizeVal = held.func_77978_p().func_74762_e("BombSize");
                    if (++sizeVal > 9) {
                        sizeVal = 9;
                        if (!worldIn.field_72995_K) {
                            playerIn.func_145747_a((Component)new Component((Object)((Object)TextFmt.Red) + "Bomb Deployer at max size."));
                        }
                    }
                    held.func_77978_p().func_74768_a("BombSize", sizeVal);
                    break;
                }
                case 2: {
                    int cdVal = held.func_77978_p().func_74762_e("BombCooldown");
                    if (++cdVal > 5) {
                        cdVal = 5;
                        if (!worldIn.field_72995_K) {
                            playerIn.func_145747_a((Component)new Component((Object)((Object)TextFmt.Red) + "Bomb Deployer at max cooldown."));
                        }
                    }
                    held.func_77978_p().func_74768_a("BombCooldown", cdVal);
                    break;
                }
                case 3: {
                    if (worldIn.field_72995_K) break;
                    playerIn.func_70690_d(new PotionEffect(PotionInit.PROTECTED, 400));
                    playerIn.func_145747_a((Component)new Component((Object)((Object)TextFmt.Red) + "You temporarily are immune to bombs."));
                }
            }
            if (!worldIn.field_72995_K) {
                worldIn.func_175656_a(pos, BlockInit.bombersPowerupClosed.func_176223_P());
                worldIn.func_184133_a(null, pos, SoundInit.MINIGAME_POWERUP, SoundSource.PLAYERS, 1.0f, 0.8f + worldIn.field_73012_v.nextFloat() * 0.4f);
            }
        }
        return true;
    }
}

