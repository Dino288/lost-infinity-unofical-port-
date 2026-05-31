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
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.DimensionType
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
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.Vec3;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.DimensionType;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemCooldown;
import xol.lostinfinity.item.classify.ICustomHoldPose;
import xol.lostinfinity.item.classify.ICustomRaytrace;
import xol.lostinfinity.item.classify.IModeSelect;
import xol.lostinfinity.item.classify.ISwitchModels;
import xol.lostinfinity.projectile.entity.EntityTormentorChain;
import xol.lostinfinity.util.data.CustomHitResult;
import xol.lostinfinity.util.data.IMaxAttack;

public class ItemMirrorOfConsumption
extends ItemCooldown
implements IMaxAttack,
ICustomRaytrace,
ICustomHoldPose,
IModeSelect,
ISwitchModels {
    public ItemMirrorOfConsumption(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_AUXWEP);
        this.setModelSwitch("mirrortype", this, 2);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack stack = playerIn.func_184586_b(handIn);
        if (!this.showDurabilityBar(stack)) {
            if (!worldIn.field_72995_K) {
                boolean teleMode = stack.func_77978_p().func_74762_e("mirrortype_data") == 1;
                CustomHitResult trace_result = this.entityTrace(worldIn, (LivingEntity)playerIn, 60, LivingEntity.class);
                if (trace_result != null) {
                    if (trace_result.getResultEntity() != null) {
                        LivingEntity hit_entity = (LivingEntity)trace_result.getResultEntity();
                        EntityTormentorChain chain = new EntityTormentorChain(worldIn);
                        chain.setTarget(hit_entity);
                        chain.setOwner(playerIn);
                        if (teleMode) {
                            double spawnX = stack.func_77978_p().func_74769_h("MarkedX");
                            double spawnY = stack.func_77978_p().func_74769_h("MarkedY");
                            double spawnZ = stack.func_77978_p().func_74769_h("MarkedZ");
                            if (spawnX != 0.0 || spawnY != 0.0 || spawnZ != 0.0) {
                                chain.setRespawnPosition(new BlockPos(spawnX, spawnY, spawnZ));
                            }
                        }
                        Vec3 lookVec = playerIn.func_70040_Z().func_178785_b(1.5707964f).func_72432_b();
                        chain.func_70107_b(playerIn.field_70165_t - lookVec.field_72450_a / 2.0, playerIn.field_70163_u + (double)playerIn.field_70131_O / 2.2, playerIn.field_70161_v - lookVec.field_72449_c / 2.0);
                        worldIn.func_72838_d((Entity)chain);
                        worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundInit.MAGIC_WEAPON_18, SoundSource.PLAYERS, 1.0f, 0.9f + worldIn.field_73012_v.nextFloat() * 0.2f);
                    } else if (teleMode && worldIn.field_73011_w.func_186058_p() == DimensionType.OVERWORLD) {
                        BlockPos resultPos = trace_result.getResultPos();
                        stack.func_77978_p().func_74780_a("MarkedX", (double)resultPos.func_177958_n());
                        stack.func_77978_p().func_74780_a("MarkedY", (double)resultPos.func_177956_o());
                        stack.func_77978_p().func_74780_a("MarkedZ", (double)resultPos.func_177952_p());
                        playerIn.func_145747_a((Component)new Component((Object)((Object)TextFmt.Dark_Purple) + "Coordinate: " + resultPos.func_177958_n() + "," + resultPos.func_177956_o() + "," + resultPos.func_177952_p() + " marked."));
                        worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundInit.FLUX_MARK, SoundSource.PLAYERS, 1.0f, 1.0f);
                    }
                }
            }
            playerIn.func_184586_b(handIn).func_77978_p().func_74772_a("lastUse", System.currentTimeMillis());
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    @Override
    protected int getCooldown() {
        return 5000;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Light_Purple) + "A very magical mirror that consumes enemies.");
        tooltip.add((Object)((Object)TextFmt.Gold) + "Slowly pull an enemy into the mirror to consume them.");
        tooltip.add((Object)((Object)TextFmt.Red) + "Consuming an enemy deals true damage equal to their max health to all nearby creatures.");
        tooltip.add((Object)((Object)TextFmt.Aqua) + "Can enable a mode which alters targets respawn location.");
    }

    @Override
    public void modeUpdate(ItemStack stack, Player player) {
        int attack_style;
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
        }
        if ((attack_style = stack.func_77978_p().func_74762_e("mirrortype_data")) == 0) {
            stack.func_77978_p().func_74768_a("mirrortype_data", 1);
        } else {
            stack.func_77978_p().func_74768_a("mirrortype_data", 0);
        }
    }
}

