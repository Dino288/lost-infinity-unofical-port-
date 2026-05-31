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
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.BlockPos$MutableBlockPos
 *  net.minecraft.util.math.Vec3
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
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemChanneling;
import xol.lostinfinity.projectile.entity.EntityEmberShot;
import xol.lostinfinity.util.data.CustomHitResult;
import xol.lostinfinity.util.data.RayTraceBuilder;
import xol.lostinfinity.util.math.LMath;

public class ItemEmberstorm
extends ItemChanneling {
    public ItemEmberstorm(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_AUXWEP);
    }

    @Override
    public void chargeTick(Level worldIn, Player player, InteractionHand hand, ItemStack stack, int chargeTime) {
        if (worldIn.field_72995_K || chargeTime % 2 != 0 || chargeTime > 100) {
            return;
        }
        EntityEmberShot bullet = new EntityEmberShot(worldIn);
        bullet.setThrower((LivingEntity)player);
        bullet.setItemStack(stack);
        worldIn.func_184133_a(null, player.func_180425_c(), SoundInit.FAST_CHARGE, SoundSource.PLAYERS, 1.0f, 0.7f + worldIn.field_73012_v.nextFloat() * 0.6f);
        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
        do {
            pos.func_189532_c(player.field_70165_t + (double)field_77697_d.nextInt(20) - 10.0, player.field_70163_u + (double)field_77697_d.nextInt(20) - 10.0, player.field_70161_v + (double)field_77697_d.nextInt(20) - 10.0);
        } while (!worldIn.func_175623_d((BlockPos)pos));
        bullet.func_70107_b((double)pos.func_177958_n() + 0.5, (double)pos.func_177956_o() + 0.5, (double)pos.func_177952_p() + 0.5);
        worldIn.func_72838_d((Entity)bullet);
    }

    @Override
    public void chargeStop(ItemStack stack, Level worldIn, LivingEntity entityLiving, int chargeTime) {
        super.chargeStop(stack, worldIn, entityLiving, chargeTime);
        if (worldIn.field_72995_K) {
            return;
        }
        CustomHitResult result = RayTraceBuilder.entity(LivingEntity.class, 50).force(true).trace((Entity)entityLiving, true);
        if (result != null) {
            if (result.getResultEntity() != null) {
                Vec3 target = LMath.getEntityMiddle(result.getResultEntity());
                this.setTargetLocation(stack, target);
                return;
            }
            this.setTargetLocation(stack, result.getResultVector());
            worldIn.func_184133_a(null, entityLiving.func_180425_c(), SoundInit.MAGIC_WEAPON_19, SoundSource.PLAYERS, 1.5f, 1.0f);
        }
    }

    private void setTargetLocation(ItemStack stack, Vec3 target) {
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
        }
        stack.func_77978_p().func_74776_a("targetX", (float)target.field_72450_a);
        stack.func_77978_p().func_74776_a("targetY", (float)target.field_72448_b);
        stack.func_77978_p().func_74776_a("targetZ", (float)target.field_72449_c);
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Aqua) + "Can be channelled to summon fireballs around you.");
        tooltip.add((Object)((Object)TextFmt.Gold) + "When you finish channeling, unleash the fireballs where you are looking.");
        tooltip.add((Object)((Object)TextFmt.Red) + "Each Fireball does 25% Health True Damage");
        tooltip.add((Object)((Object)TextFmt.Yellow) + "Fireballs Also Take Away 3 Lives From Multi-Life Creatures");
        tooltip.add((Object)((Object)TextFmt.Dark_Aqua) + "Darkborn");
    }
}

