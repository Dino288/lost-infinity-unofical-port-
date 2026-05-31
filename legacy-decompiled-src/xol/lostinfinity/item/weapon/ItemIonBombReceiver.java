/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.InteractionResultHolder
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.item.weapon;

import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemCooldown;
import xol.lostinfinity.item.classify.ICustomRaytrace;
import xol.lostinfinity.item.classify.IModeSelect;
import xol.lostinfinity.mob.entity.misc.EntityIonExplosion;
import xol.lostinfinity.util.data.CustomHitResult;

public class ItemIonBombReceiver
extends ItemCooldown
implements ICustomRaytrace,
IModeSelect {
    public ItemIonBombReceiver(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_AUXWEP);
    }

    @Override
    protected boolean hasSimpleCooldown() {
        return false;
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        if (!this.showDurabilityBar(playerIn.func_184586_b(handIn))) {
            CustomHitResult trace_result;
            ItemStack stack = playerIn.func_184586_b(handIn);
            if (!worldIn.field_72995_K && (trace_result = this.simpleBlockTrace(worldIn, (LivingEntity)playerIn, 60)) != null) {
                if (!stack.func_77978_p().func_74764_b("BombY0")) {
                    this.clearBombs(stack);
                }
                int foundEmpty = -1;
                for (int i = 0; i < 5; ++i) {
                    double zValue;
                    double yValue = stack.func_77978_p().func_74769_h("BombY" + i);
                    if (yValue == -10.0) {
                        foundEmpty = i;
                        break;
                    }
                    double xValue = stack.func_77978_p().func_74769_h("BombX" + i);
                    BlockPos pos = new BlockPos(xValue, yValue, zValue = stack.func_77978_p().func_74769_h("BombZ" + i));
                    if (worldIn.func_180495_p(pos).func_177230_c() == BlockInit.ionBomb) continue;
                    foundEmpty = i;
                    break;
                }
                if (foundEmpty == -1) {
                    BlockPos firstBomb = new BlockPos(stack.func_77978_p().func_74769_h("BombX0"), stack.func_77978_p().func_74769_h("BombY0"), stack.func_77978_p().func_74769_h("BombZ0"));
                    worldIn.func_175698_g(firstBomb);
                    foundEmpty = 0;
                }
                BlockPos resultPos = trace_result.getResultPos();
                stack.func_77978_p().func_74780_a("BombX" + foundEmpty, (double)resultPos.func_177958_n());
                stack.func_77978_p().func_74780_a("BombY" + foundEmpty, (double)resultPos.func_177956_o());
                stack.func_77978_p().func_74780_a("BombZ" + foundEmpty, (double)resultPos.func_177952_p());
                worldIn.func_175656_a(resultPos, BlockInit.ionBomb.func_176223_P());
                worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundEvents.field_187772_dn, SoundSource.MASTER, 1.5f, 0.9f + worldIn.field_73012_v.nextFloat() * 0.2f);
            }
            stack.func_77978_p().func_74768_a("ComplexCooldown", 150);
            playerIn.func_184586_b(handIn).func_77978_p().func_74772_a("lastUse", System.currentTimeMillis());
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    private boolean areNoBombs(ItemStack stack) {
        if (stack.func_77978_p().func_74764_b("BombY0")) {
            boolean foundBomb = false;
            for (int i = 0; i < 5; ++i) {
                double bombY = stack.func_77978_p().func_74769_h("BombY" + i);
                if (bombY == -10.0) continue;
                foundBomb = true;
            }
            return !foundBomb;
        }
        return true;
    }

    private void clearBombs(ItemStack stack) {
        for (int i = 0; i < 5; ++i) {
            stack.func_77978_p().func_74780_a("BombX" + i, -10.0);
            stack.func_77978_p().func_74780_a("BombY" + i, -10.0);
            stack.func_77978_p().func_74780_a("BombZ" + i, -10.0);
        }
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Aqua) + "Can place up to 5 Ion Bombs which can be detonated.");
        tooltip.add((Object)((Object)TextFmt.Gold) + "Ion Bomb Explosions Deal 200% Max Health Damage");
    }

    @Override
    public void modeUpdate(ItemStack stack, Player player) {
        if (!this.showDurabilityBar(stack)) {
            Level worldIn = player.field_70170_p;
            if (!worldIn.field_72995_K) {
                if (this.areNoBombs(stack)) {
                    player.func_145747_a((Component)new Component((Object)((Object)TextFmt.Red) + "No bombs are placed."));
                } else {
                    for (int i = 0; i < 5; ++i) {
                        double zValue;
                        double xValue;
                        BlockPos pos;
                        double yValue = stack.func_77978_p().func_74769_h("BombY" + i);
                        if (yValue == -10.0 || worldIn.func_180495_p(pos = new BlockPos(xValue = stack.func_77978_p().func_74769_h("BombX" + i), yValue, zValue = stack.func_77978_p().func_74769_h("BombZ" + i))).func_177230_c() != BlockInit.ionBomb) continue;
                        EntityIonExplosion bomb = new EntityIonExplosion(worldIn);
                        bomb.setCreator(player.func_110124_au());
                        bomb.func_70107_b(pos.func_177958_n(), pos.func_177956_o(), pos.func_177952_p());
                        worldIn.func_72838_d((Entity)bomb);
                        worldIn.func_175698_g(pos);
                    }
                    this.clearBombs(stack);
                    worldIn.func_184133_a(null, player.func_180425_c(), SoundInit.GENERIC_WEAPON_3, SoundSource.MASTER, 1.5f, 0.9f + worldIn.field_73012_v.nextFloat() * 0.2f);
                }
            }
            stack.func_77978_p().func_74768_a("ComplexCooldown", 1500);
        }
    }
}

