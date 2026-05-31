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
 *  net.minecraft.util.InteractionResultHolder
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.EnumParticleTypes
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.item.weapon;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.classify.ICustomRaytrace;
import xol.lostinfinity.item.weapon.ItemCooldownSword;
import xol.lostinfinity.util.data.CustomHitResult;
import xol.lostinfinity.util.data.IMaxAttack;

public class ItemBladeOfDead
extends ItemCooldownSword
implements IMaxAttack,
ICustomRaytrace {
    public ItemBladeOfDead(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_INFINITYWEP);
    }

    public boolean func_77644_a(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        IMaxAttack.dealMaxHealth((Entity)attacker, target, 5);
        return true;
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        if (!this.showDurabilityBar(playerIn.func_184586_b(handIn))) {
            if (!worldIn.field_72995_K) {
                CustomHitResult trace_result = this.entityTrace(worldIn, (LivingEntity)playerIn, 45, LivingEntity.class);
                BlockPos startPos = playerIn.func_180425_c();
                if (trace_result != null && trace_result.getResultEntity() != null) {
                    LivingEntity targeted = (LivingEntity)trace_result.getResultEntity();
                    BlockPos resultPos = trace_result.getResultPos();
                    float dist = targeted.func_70032_d((Entity)playerIn);
                    playerIn.func_70634_a(targeted.field_70165_t, targeted.field_70163_u, targeted.field_70161_v);
                    worldIn.func_184133_a(null, resultPos, SoundInit.ITEM_GHOSTHUNTER, SoundSource.MASTER, 2.0f, 1.0f);
                    int multiplier = Math.round(dist / 12.0f);
                    multiplier = Math.min(3, multiplier);
                    multiplier = Math.max(1, multiplier);
                    IMaxAttack.dealMaxHealth((Entity)playerIn, targeted, 4, multiplier);
                    ArrayList<UUID> found_living = new ArrayList<UUID>();
                    found_living.add(playerIn.func_110124_au());
                    found_living.add(targeted.func_110124_au());
                    int repeats = 18 + Math.abs(Math.round(dist));
                    double xdiff = startPos.func_177958_n() - resultPos.func_177958_n();
                    double ydiff = startPos.func_177956_o() - resultPos.func_177956_o();
                    double zdiff = startPos.func_177952_p() - resultPos.func_177952_p();
                    for (int part = 0; part < repeats; ++part) {
                        BlockPos curPos = new BlockPos((double)startPos.func_177958_n() + -xdiff / (double)repeats * (double)part, (double)startPos.func_177956_o() + -ydiff / (double)repeats * (double)part, (double)startPos.func_177952_p() + -zdiff / (double)repeats * (double)part);
                        if (worldIn.field_72995_K) {
                            worldIn.func_175688_a(EnumParticleTypes.SMOKE_LARGE, (double)curPos.func_177958_n(), (double)curPos.func_177956_o(), (double)curPos.func_177952_p(), (worldIn.field_73012_v.nextDouble() - 0.5) * 0.1, 0.0, (worldIn.field_73012_v.nextDouble() - 0.5) * 0.1, new int[0]);
                            continue;
                        }
                        if (part == repeats - 1) continue;
                        for (LivingEntity near_entity : worldIn.func_72872_a(LivingEntity.class, new AABB(curPos.func_177982_a(-4, -4, -4), curPos.func_177982_a(4, 4, 4)))) {
                            UUID entity_id = near_entity.func_110124_au();
                            if (found_living.contains(entity_id)) continue;
                            found_living.add(entity_id);
                            IMaxAttack.dealMaxHealth((Entity)playerIn, near_entity, 3);
                        }
                    }
                }
            }
            playerIn.func_184586_b(handIn).func_77978_p().func_74772_a("lastUse", System.currentTimeMillis());
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    @Override
    protected int getCooldown() {
        return 1000;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Gold) + "Deals 20% Max Health Damage");
        tooltip.add((Object)((Object)TextFmt.Dark_Purple) + "Right click to teleport up to 45 blocks to an entity.");
        tooltip.add((Object)((Object)TextFmt.Dark_Purple) + "Deal 33% Max Health Damage To Enemies Near The Trail");
        tooltip.add(TextFmt.getFormatting(TextFmt.Italic, TextFmt.Light_Purple) + "On Arrival:");
        tooltip.add((Object)((Object)TextFmt.Red) + "Deal up to 75% Max Health Damage to Targeted Entity");
        tooltip.add((Object)((Object)TextFmt.Italic) + "Damage based on distance travelled.");
    }
}

