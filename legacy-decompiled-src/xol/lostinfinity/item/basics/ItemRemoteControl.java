/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.tileentity.BlockEntity
 *  net.minecraft.util.InteractionResultHolder
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 */
package xol.lostinfinity.item.basics;

import javax.annotation.Nullable;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.misc.BlockRemoteControl;
import xol.lostinfinity.block.tileentity.BlockEntityRemoteControl;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.item.basics.ItemCooldown;
import xol.lostinfinity.item.classify.ICustomRaytrace;

public abstract class ItemRemoteControl
extends ItemCooldown
implements ICustomRaytrace {
    public ItemRemoteControl(String regName) {
        super(regName);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack held = playerIn.func_184586_b(handIn);
        if (!this.showDurabilityBar(held)) {
            if (!worldIn.field_72995_K) {
                double blockZ;
                double blockY;
                double blockX;
                BlockPos checkpos;
                if (!held.func_77942_o()) {
                    held.func_77982_d(new CompoundTag());
                }
                if (worldIn.func_180495_p(checkpos = new BlockPos(blockX = held.func_77978_p().func_74769_h("BlockStoredX"), blockY = held.func_77978_p().func_74769_h("BlockStoredY"), blockZ = held.func_77978_p().func_74769_h("BlockStoredZ"))).func_177230_c() == this.getControlBlock()) {
                    BlockEntity te = worldIn.func_175625_s(checkpos);
                    if (te != null && te instanceof BlockEntityRemoteControl) {
                        BlockEntityRemoteControl remTe = (BlockEntityRemoteControl)te;
                        if (remTe.getController() == null) {
                            remTe.setController(this);
                        }
                        if (remTe.getPlacerID() != null && remTe.getPlacerID().equals(playerIn.func_110124_au())) {
                            boolean nowActive = !remTe.getActive();
                            remTe.setActive(nowActive);
                            this.toggleEffect(remTe, worldIn, checkpos, playerIn, nowActive);
                            playerIn.func_145747_a((Component)new Component((Object)((Object)(nowActive ? TextFmt.Green : TextFmt.Red)) + "Remote block was " + (nowActive ? "activated." : "deactivated.")));
                            worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundInit.GENERIC_WEAPON_3, SoundSource.MASTER, 1.5f, 0.9f + worldIn.field_73012_v.nextFloat() * 0.2f);
                        }
                    }
                } else {
                    playerIn.func_145747_a((Component)new Component((Object)((Object)TextFmt.Dark_Red) + "No compatible remote block found at " + blockX + "," + blockY + "," + blockZ));
                }
            }
            held.func_77978_p().func_74772_a("lastUse", System.currentTimeMillis());
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    @Override
    protected int getCooldown() {
        return 500;
    }

    @Nullable
    public abstract BlockRemoteControl getControlBlock();

    public abstract void tickEffect(BlockEntityRemoteControl var1, Level var2, BlockPos var3, Player var4);

    public abstract void toggleEffect(BlockEntityRemoteControl var1, Level var2, BlockPos var3, Player var4, boolean var5);
}

