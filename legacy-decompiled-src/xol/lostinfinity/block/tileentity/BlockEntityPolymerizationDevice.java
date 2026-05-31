/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.tileentity.BlockEntity
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 */
package xol.lostinfinity.block.tileentity;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;

public class BlockEntityPolymerizationDevice
extends BlockEntity {
    private boolean active = false;
    private int nextMonomer = 0;

    public AABB getTank() {
        int minY = this.field_174879_c.func_177956_o() + 3;
        int minX = this.field_174879_c.func_177958_n() - 2;
        int minZ = this.field_174879_c.func_177952_p() - 2;
        int maxY = minY + 1;
        int maxX = minX + 4;
        int maxZ = minZ + 4;
        return new AABB((double)minX, (double)minY, (double)minZ, (double)maxX, (double)maxY, (double)maxZ);
    }

    public boolean isActivated() {
        return this.active;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void activate(Player playerIn, InteractionHand hand) {
        if (!this.active) {
            this.clearTank();
            int radius = 7;
            this.nextMonomer = this.field_145850_b.field_73012_v.nextInt(5);
            for (Player player : this.field_145850_b.func_72872_a(Player.class, new AABB(this.func_174877_v().func_177982_a(-radius, -4, -radius), this.func_174877_v().func_177982_a(radius, 4, radius)))) {
                ItemStack newStack = new ItemStack(ItemInit.monomerCollector, 1);
                newStack.func_77982_d(new CompoundTag());
                newStack.func_77978_p().func_74772_a("EndTime", System.currentTimeMillis() + 200000L);
                player.func_191521_c(newStack);
                player.func_145747_a((Component)new Component((Object)((Object)TextFmt.Green) + "Collect monomer samples around the labyrinth and return them to start the polymerization process."));
                this.messageMonomer(player);
                this.field_145850_b.func_184133_a(null, this.field_174879_c, SoundInit.GENERIC_UI_4, SoundSource.PLAYERS, 1.25f, 1.0f);
            }
            this.active = true;
            return;
        } else {
            BlockState state;
            Item nextMonomer;
            if (!this.active) return;
            switch (this.nextMonomer) {
                case 0: {
                    nextMonomer = ItemInit.purpleMonomerSample;
                    break;
                }
                case 1: {
                    nextMonomer = ItemInit.blueMonomerSample;
                    break;
                }
                case 2: {
                    nextMonomer = ItemInit.redMonomerSample;
                    break;
                }
                case 3: {
                    nextMonomer = ItemInit.yellowMonomerSample;
                    break;
                }
                case 4: {
                    nextMonomer = ItemInit.greenMonomerSample;
                    break;
                }
                default: {
                    nextMonomer = ItemInit.purpleMonomerSample;
                }
            }
            ItemStack stack = playerIn.func_184586_b(hand);
            Item item = stack.func_77973_b();
            if (item.equals(nextMonomer)) {
                if (item.equals(ItemInit.purpleMonomerSample)) {
                    state = BlockInit.monomerCube.func_176203_a(0);
                } else if (item.equals(ItemInit.blueMonomerSample)) {
                    state = BlockInit.monomerCube.func_176203_a(1);
                } else if (item.equals(ItemInit.redMonomerSample)) {
                    state = BlockInit.monomerCube.func_176203_a(2);
                } else if (item.equals(ItemInit.yellowMonomerSample)) {
                    state = BlockInit.monomerCube.func_176203_a(3);
                } else {
                    if (!item.equals(ItemInit.greenMonomerSample)) return;
                    state = BlockInit.monomerCube.func_176203_a(4);
                }
            } else {
                playerIn.func_145747_a((Component)new Component((Object)((Object)TextFmt.Red) + "That is not the correct monomer!"));
                this.messageMonomer(playerIn);
                return;
            }
            AABB tank = this.getTank();
            int xMin = (int)tank.field_72340_a;
            int xMax = (int)tank.field_72336_d;
            int zMin = (int)tank.field_72339_c;
            int zMax = (int)tank.field_72334_f;
            int yMin = (int)tank.field_72338_b;
            int yMax = (int)tank.field_72337_e;
            boolean placed = false;
            block8: for (int i = yMin; i <= yMax; ++i) {
                for (int j = xMin; j <= xMax; ++j) {
                    for (int k = zMin; k <= zMax; ++k) {
                        BlockPos checkPos = new BlockPos(j, i, k);
                        if (!this.field_145850_b.func_175623_d(checkPos)) continue;
                        this.field_145850_b.func_175656_a(checkPos, state);
                        placed = true;
                        stack.func_190918_g(1);
                        break block8;
                    }
                }
            }
            if (!placed) {
                int radius = 7;
                for (Player player : this.field_145850_b.func_72872_a(Player.class, new AABB(this.func_174877_v().func_177982_a(-radius, -4, -radius), this.func_174877_v().func_177982_a(radius, 4, radius)))) {
                    player.func_145747_a((Component)new Component((Object)((Object)TextFmt.Green) + "Sucessfully Combined Monomers into Polymer!"));
                    for (int i = 0; i < player.field_71071_by.func_70302_i_(); ++i) {
                        if (player.field_71071_by.func_70301_a(i).func_77973_b() != ItemInit.monomerCollector) continue;
                        player.field_71071_by.func_70299_a(i, ItemStack.field_190927_a);
                    }
                    player.func_191521_c(new ItemStack(ItemInit.dimensionalPolymer, 1));
                    this.field_145850_b.func_184133_a(null, this.field_174879_c, SoundInit.CHEMICAL_MIXING, SoundSource.PLAYERS, 0.7f, 0.7f + this.field_145850_b.field_73012_v.nextFloat() * 0.6f);
                }
                this.clearTank();
                this.active = false;
                return;
            } else {
                int randMonomer = this.field_145850_b.field_73012_v.nextInt(5);
                while (randMonomer == this.nextMonomer) {
                    randMonomer = this.field_145850_b.field_73012_v.nextInt(5);
                }
                this.nextMonomer = randMonomer;
                this.messageMonomer(playerIn);
                this.field_145850_b.func_184133_a(null, this.field_174879_c, SoundEvents.field_187620_cL, SoundSource.PLAYERS, 1.0f, 0.7f + this.field_145850_b.field_73012_v.nextFloat() * 0.6f);
            }
        }
    }

    private void messageMonomer(Player player) {
        String monomer;
        TextFmt fmt = TextFmt.Dark_Purple;
        switch (this.nextMonomer) {
            case 0: {
                monomer = "Purple";
                fmt = TextFmt.Dark_Purple;
                break;
            }
            case 1: {
                monomer = "Blue";
                fmt = TextFmt.Dark_Blue;
                break;
            }
            case 2: {
                monomer = "Red";
                fmt = TextFmt.Dark_Red;
                break;
            }
            case 3: {
                monomer = "Yellow";
                fmt = TextFmt.Yellow;
                break;
            }
            case 4: {
                monomer = "Green";
                fmt = TextFmt.Green;
                break;
            }
            default: {
                monomer = "Purple";
                fmt = TextFmt.Dark_Purple;
            }
        }
        player.func_145747_a((Component)new Component(String.format((Object)((Object)fmt) + "%s monomer is needed next", monomer)));
    }

    private void clearTank() {
        AABB tank = this.getTank();
        int xMin = (int)tank.field_72340_a;
        int xMax = (int)tank.field_72336_d;
        int zMin = (int)tank.field_72339_c;
        int zMax = (int)tank.field_72334_f;
        int yMin = (int)tank.field_72338_b;
        int yMax = (int)tank.field_72337_e;
        for (BlockPos pos : BlockPos.func_191532_a((int)xMin, (int)yMin, (int)zMin, (int)xMax, (int)yMax, (int)zMax)) {
            this.field_145850_b.func_175698_g(pos);
        }
    }
}

