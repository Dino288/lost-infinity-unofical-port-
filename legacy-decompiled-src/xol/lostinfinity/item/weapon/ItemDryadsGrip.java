/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.block.Block
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.util.InteractionResultHolder
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.item.weapon;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.world.level.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;
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
import xol.lostinfinity.item.classify.ISwitchModels;
import xol.lostinfinity.mob.entity.misc.EntityNitroExplosion;
import xol.lostinfinity.projectile.entity.EntityDryadsGripAttack;
import xol.lostinfinity.util.data.CustomHitResult;

public class ItemDryadsGrip
extends ItemCooldown
implements IModeSelect,
ICustomRaytrace,
ISwitchModels {
    public ItemDryadsGrip(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_AUXWEP);
        this.setModelSwitch("usetype", this, 2);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack stack = playerIn.func_184586_b(handIn);
        if (!this.showDurabilityBar(stack)) {
            if (!worldIn.field_72995_K) {
                int attack_style = stack.func_77978_p().func_74762_e("usetype_data");
                if (attack_style == 0) {
                    EntityDryadsGripAttack shot = new EntityDryadsGripAttack(worldIn, (LivingEntity)playerIn);
                    shot.setThrower((LivingEntity)playerIn);
                    shot.func_184538_a((Entity)playerIn, playerIn.field_70125_A, playerIn.field_70177_z, 0.0f, 2.0f, 0.0f);
                    worldIn.func_72838_d((Entity)shot);
                    worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundInit.LASER_WEAPON_5, SoundSource.PLAYERS, 1.0f, 0.8f + worldIn.field_73012_v.nextFloat() * 0.4f);
                } else {
                    CustomHitResult trace_result = this.simpleBlockTrace(worldIn, (LivingEntity)playerIn, 60);
                    worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundInit.LASER_WEAPON_4, SoundSource.PLAYERS, 1.0f, 0.8f + worldIn.field_73012_v.nextFloat() * 0.4f);
                    if (trace_result != null) {
                        BlockPos pos = trace_result.getResultPos();
                        block0: for (int i = -2; i <= 2; ++i) {
                            for (int j = -2; j <= 2; ++j) {
                                for (int k = -2; k <= 2; ++k) {
                                    Block result_block;
                                    if (i == 0 && j == 0 && k == 0 || !(result_block = worldIn.func_180495_p(pos.func_177982_a(i, j, k)).func_177230_c()).equals(BlockInit.leavesNitro) && !result_block.equals(BlockInit.logsNitro)) continue;
                                    int numBlocks = 0;
                                    ArrayList<BlockPos> toExplode = this.propogateExplosions(worldIn, pos.func_177982_a(i, j, k), null);
                                    for (BlockPos explodePos : toExplode) {
                                        Block block = worldIn.func_180495_p(explodePos).func_177230_c();
                                        if (block.equals(BlockInit.leavesNitro)) {
                                            ++numBlocks;
                                        }
                                        if (block.equals(BlockInit.logsNitro)) {
                                            ++numBlocks;
                                        }
                                        worldIn.func_175698_g(explodePos);
                                    }
                                    this.createExplosion(worldIn, pos.func_177982_a(i, j, k), numBlocks, playerIn);
                                    break block0;
                                }
                            }
                        }
                    }
                }
            }
            playerIn.func_184586_b(handIn).func_77978_p().func_74772_a("lastUse", System.currentTimeMillis());
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    private ArrayList<BlockPos> propogateExplosions(Level worldIn, BlockPos pos, ArrayList<BlockPos> visited) {
        if (visited == null) {
            visited = new ArrayList();
        }
        for (int i = -1; i <= 1; ++i) {
            for (int j = -1; j <= 1; ++j) {
                for (int k = -1; k <= 1; ++k) {
                    BlockPos check = pos.func_177982_a(i, j, k);
                    Block result_block = worldIn.func_180495_p(check).func_177230_c();
                    if (visited.contains(check) || !result_block.equals(BlockInit.leavesNitro) && !result_block.equals(BlockInit.logsNitro)) continue;
                    visited.add(check);
                    ArrayList<BlockPos> neighbours = this.propogateExplosions(worldIn, check, visited);
                    for (BlockPos n : neighbours) {
                        if (visited.contains(n)) continue;
                        visited.add(n);
                    }
                }
            }
        }
        return visited;
    }

    public void createExplosion(Level worldIn, BlockPos pos, int numBlocks, Player player) {
        EntityNitroExplosion bomb = new EntityNitroExplosion(worldIn);
        bomb.setNumBlocks(numBlocks);
        bomb.setThrower(player);
        bomb.func_70107_b(pos.func_177958_n(), pos.func_177956_o(), pos.func_177952_p());
        worldIn.func_72838_d((Entity)bomb);
        worldIn.func_175698_g(pos);
    }

    @Override
    protected int getCooldown() {
        return 100;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Green) + "Summons a tree and tethers nearby entities to them.");
        tooltip.add((Object)((Object)TextFmt.Gold) + "Alt Fire: Detonates trees, dealing 5% Health True Damage per Block");
    }

    @Override
    public void modeUpdate(ItemStack stack, Player player) {
        int attack_style;
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
        }
        if ((attack_style = stack.func_77978_p().func_74762_e("usetype_data")) == 0) {
            stack.func_77978_p().func_74768_a("usetype_data", 1);
        } else {
            stack.func_77978_p().func_74768_a("usetype_data", 0);
        }
    }
}

