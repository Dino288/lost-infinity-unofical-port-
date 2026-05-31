/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
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
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.item.weapon;

import java.util.List;
import java.util.UUID;
import javax.annotation.Nullable;
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
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemCooldown;
import xol.lostinfinity.item.classify.ICustomRaytrace;
import xol.lostinfinity.item.classify.IModeSelect;
import xol.lostinfinity.mob.entity.misc.EntitySkycrab;
import xol.lostinfinity.util.data.CustomHitResult;

public class ItemSkycrabController
extends ItemCooldown
implements IModeSelect,
ICustomRaytrace {
    public ItemSkycrabController(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_AUXWEP);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack stack = playerIn.func_184586_b(handIn);
        if (!this.showDurabilityBar(playerIn.func_184586_b(handIn))) {
            if (!worldIn.field_72995_K) {
                int itemMode = stack.func_77978_p().func_74762_e("use_mode");
                UUID crab_uuid = stack.func_77978_p().func_186857_a("crabID");
                switch (itemMode) {
                    case 0: {
                        EntitySkycrab existing;
                        if (this.isExistingCrab(crab_uuid) && (existing = (EntitySkycrab)worldIn.func_73046_m().func_175576_a(crab_uuid)) != null) {
                            existing.func_70106_y();
                        }
                        EntitySkycrab crab = new EntitySkycrab(worldIn);
                        crab.func_70107_b(playerIn.field_70165_t, playerIn.field_70163_u + 10.0, playerIn.field_70161_v);
                        crab.func_193101_c(playerIn);
                        BlockPos homePosition = new BlockPos(playerIn.field_70165_t, playerIn.field_70163_u + 10.0, playerIn.field_70161_v);
                        crab.setHomePos(homePosition);
                        worldIn.func_72838_d((Entity)crab);
                        stack.func_77978_p().func_186854_a("crabID", crab.func_110124_au());
                        worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundInit.SKYCRAB_AMBIENT, SoundSource.PLAYERS, 1.0f, 1.0f);
                        break;
                    }
                    case 1: {
                        if (!this.isExistingCrab(crab_uuid)) break;
                        EntitySkycrab existing = (EntitySkycrab)worldIn.func_73046_m().func_175576_a(crab_uuid);
                        boolean aggressive = existing.isAggressive();
                        aggressive = !aggressive;
                        existing.setTarget(null);
                        existing.setTargeting(false);
                        existing.setGoalPosition(null);
                        existing.setAggressive(aggressive);
                        playerIn.func_145747_a((Component)new Component((Object)((Object)TextFmt.Gold) + "Skycrab is now " + (aggressive ? "aggressive." : "passive.")));
                        break;
                    }
                    case 2: {
                        if (!this.isExistingCrab(crab_uuid)) break;
                        EntitySkycrab existing = (EntitySkycrab)worldIn.func_73046_m().func_175576_a(crab_uuid);
                        existing.setAggressive(true);
                        existing.setTargeting(true);
                        CustomHitResult trace_result = this.entityTrace(worldIn, (LivingEntity)playerIn, 60, LivingEntity.class);
                        if (trace_result == null || trace_result.getResultEntity() == null || trace_result.getResultEntity() instanceof EntitySkycrab) break;
                        LivingEntity trace_entity = (LivingEntity)trace_result.getResultEntity();
                        existing.setTarget(trace_entity);
                        BlockPos targetPos = trace_entity.func_180425_c().func_177963_a(0.0, (double)(trace_entity.field_70131_O + 10.0f), 0.0);
                        playerIn.func_145747_a((Component)new Component((Object)((Object)TextFmt.Gold) + "Skycrab is now targeting " + trace_entity.func_70005_c_()));
                        existing.setGoalPosition(targetPos);
                        existing.playTargetSound();
                    }
                }
            }
            playerIn.func_184586_b(handIn).func_77978_p().func_74772_a("lastUse", System.currentTimeMillis());
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    private boolean isExistingCrab(UUID idToCheck) {
        return idToCheck != null && !idToCheck.equals(UUID.fromString("00000000-0000-0000-0000-000000000000"));
    }

    @Override
    protected int getCooldown() {
        return 750;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Gold) + "Summons a Sky Crab to defend an area.");
        tooltip.add((Object)((Object)TextFmt.Aqua) + "Switch modes to control your Sky Crab.");
        tooltip.add((Object)((Object)TextFmt.Italic) + "The Sky Crab obliterates targets that it detects.");
    }

    @Override
    public void modeUpdate(ItemStack stack, Player player) {
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
        }
        int current_mode = stack.func_77978_p().func_74762_e("use_mode");
        if (++current_mode == 3) {
            current_mode = 0;
        }
        stack.func_77978_p().func_74768_a("use_mode", current_mode);
        if (!player.field_70170_p.field_72995_K) {
            switch (current_mode) {
                case 0: {
                    player.func_145747_a((Component)new Component((Object)((Object)TextFmt.Gold) + "Summoning Mode Enabled"));
                    break;
                }
                case 1: {
                    player.func_145747_a((Component)new Component((Object)((Object)TextFmt.Gold) + "Stance Switching Mode Enabled"));
                    break;
                }
                case 2: {
                    player.func_145747_a((Component)new Component((Object)((Object)TextFmt.Gold) + "Targeting Mode Enabled"));
                }
            }
        }
    }
}

