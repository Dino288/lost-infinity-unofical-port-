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
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemCooldown;
import xol.lostinfinity.item.classify.ICustomRaytrace;
import xol.lostinfinity.item.classify.IModeSelect;
import xol.lostinfinity.mob.entity.misc.EntityNuclearExplosion;
import xol.lostinfinity.util.data.CustomHitResult;

public class ItemNuclearReceiver
extends ItemCooldown
implements IModeSelect,
ICustomRaytrace {
    private static final int MAX_BOMB = 3;

    public ItemNuclearReceiver(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_AUXWEP);
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
                for (int i = 0; i < 3; ++i) {
                    int zValue;
                    int yValue = stack.func_77978_p().func_74762_e("BombY" + i);
                    if (yValue == -10) {
                        foundEmpty = i;
                        break;
                    }
                    int xValue = stack.func_77978_p().func_74762_e("BombX" + i);
                    BlockPos pos = new BlockPos(xValue, yValue, zValue = stack.func_77978_p().func_74762_e("BombZ" + i));
                    if (worldIn.func_180495_p(pos).func_177230_c() == BlockInit.nuclearBomb) continue;
                    foundEmpty = i;
                    break;
                }
                if (foundEmpty == -1) {
                    BlockPos firstBomb = new BlockPos(stack.func_77978_p().func_74762_e("BombX0"), stack.func_77978_p().func_74762_e("BombY0"), stack.func_77978_p().func_74762_e("BombZ0"));
                    worldIn.func_175698_g(firstBomb);
                    foundEmpty = 0;
                }
                BlockPos resultPos = trace_result.getResultPos();
                stack.func_77978_p().func_74768_a("BombX" + foundEmpty, resultPos.func_177958_n());
                stack.func_77978_p().func_74768_a("BombY" + foundEmpty, resultPos.func_177956_o());
                stack.func_77978_p().func_74768_a("BombZ" + foundEmpty, resultPos.func_177952_p());
                worldIn.func_175656_a(resultPos, BlockInit.nuclearBomb.func_176223_P());
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
            for (int i = 0; i < 3; ++i) {
                int bombY = stack.func_77978_p().func_74762_e("BombY" + i);
                if (bombY == -10) continue;
                foundBomb = true;
            }
            return !foundBomb;
        }
        return true;
    }

    private void clearBombs(ItemStack stack) {
        for (int i = 0; i < 3; ++i) {
            stack.func_77978_p().func_74768_a("BombX" + i, -10);
            stack.func_77978_p().func_74768_a("BombY" + i, -10);
            stack.func_77978_p().func_74768_a("BombZ" + i, -10);
        }
    }

    @Override
    public void modeUpdate(ItemStack stack, Player player) {
        if (!this.showDurabilityBar(stack)) {
            Level worldIn = player.field_70170_p;
            if (!worldIn.field_72995_K) {
                if (this.areNoBombs(stack)) {
                    player.func_145747_a((Component)new Component((Object)((Object)TextFmt.Red) + "No bombs are placed."));
                } else {
                    for (int i = 0; i < 3; ++i) {
                        int zValue;
                        int xValue;
                        BlockPos pos;
                        int yValue = stack.func_77978_p().func_74762_e("BombY" + i);
                        if (yValue == -10 || worldIn.func_180495_p(pos = new BlockPos(xValue = stack.func_77978_p().func_74762_e("BombX" + i), yValue, zValue = stack.func_77978_p().func_74762_e("BombZ" + i))).func_177230_c() != BlockInit.nuclearBomb) continue;
                        EntityNuclearExplosion bomb = new EntityNuclearExplosion(worldIn);
                        bomb.setOwner(player.func_110124_au());
                        bomb.func_70107_b((double)pos.func_177958_n() + 0.5, (double)pos.func_177956_o() + 0.5, (double)pos.func_177952_p() + 0.5);
                        worldIn.func_72838_d((Entity)bomb);
                        worldIn.func_175698_g(pos);
                    }
                    this.clearBombs(stack);
                    worldIn.func_184133_a(null, player.func_180425_c(), SoundInit.GENERIC_WEAPON_3, SoundSource.MASTER, 1.5f, 0.9f + worldIn.field_73012_v.nextFloat() * 0.2f);
                }
            }
            stack.func_77978_p().func_74768_a("ComplexCooldown", 14000);
            this.startCooldown(stack);
        }
    }

    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Yellow) + "Can place up to 3 Nuclear Bombs which can be detonated.");
        tooltip.add((Object)((Object)TextFmt.Red) + "Deals 200% Health True Damage To Nearby Enemies");
        tooltip.add((Object)((Object)TextFmt.Red) + "Deals 400% Max Health Damage In a Giant Radius");
        tooltip.add((Object)((Object)TextFmt.Gold) + "Nearby Multi-Life Creatures Lose 8 lives");
    }

    @Override
    protected boolean hasSimpleCooldown() {
        return false;
    }
}

