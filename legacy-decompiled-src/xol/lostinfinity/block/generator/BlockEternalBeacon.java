/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.block.material.Material
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.IEntityOwnable
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.tileentity.BlockEntity
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.block.generator;

import java.util.List;
import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.block.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.IEntityOwnable;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.block.generator.BlockGenerator;
import xol.lostinfinity.block.tileentity.BlockEntityEternalBeacon;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.PotionInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.mob.entity.minion.EntityMinion;

public class BlockEternalBeacon
extends BlockGenerator {
    public BlockEternalBeacon(String name) {
        super(name, 3.0f, Material.field_151576_e, TabsInit.TAB_BLOCKS);
    }

    @Override
    public BlockEntity createBlockEntity(Level world, BlockState state) {
        return new BlockEntityEternalBeacon();
    }

    @Override
    public void activateGenerator(Level worldIn, BlockPos pos, BlockState state, Player playerIn, int power_upgrade, int efficiency_upgrade, int range_upgrade, int depth_upgrade, UUID placer_uuid) {
        int radius = 20 + range_upgrade * 20;
        AABB bb = new AABB(pos).func_72314_b((double)radius, (double)(20 + depth_upgrade * 25), (double)radius).func_72317_d(0.0, -5.0, 0.0);
        for (LivingEntity detected : worldIn.func_72872_a(LivingEntity.class, bb)) {
            if (detected.func_174818_b(pos) > (double)(radius * radius)) continue;
            if (detected.func_110124_au().equals(placer_uuid)) {
                detected.func_70690_d(new PotionEffect(PotionInit.PROTECTED, 60, 0));
                continue;
            }
            if (detected instanceof IEntityOwnable && !placer_uuid.equals(((IEntityOwnable)detected).func_184753_b())) {
                detected.func_70106_y();
                continue;
            }
            if (!(detected instanceof EntityMinion) || placer_uuid.equals(((EntityMinion)detected).func_184753_b())) continue;
            detected.func_70106_y();
        }
        BlockEntity tile = worldIn.func_175625_s(pos);
        if (tile instanceof BlockEntityEternalBeacon) {
            BlockEntityEternalBeacon beacon = (BlockEntityEternalBeacon)tile;
            beacon.setTickRemaining(60);
            beacon.setRadius(radius);
            beacon.doBlockUpdate();
        }
    }

    @SideOnly(value=Side.CLIENT)
    public void func_190948_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Gold) + "Makes the owner immune inside the forcefield (20 blocks).");
        tooltip.add((Object)((Object)TextFmt.Gold) + "Kills enemy tames inside the forcefield.");
        tooltip.add((Object)((Object)TextFmt.Italic) + "Per Module Upgrades:");
        tooltip.add((Object)((Object)TextFmt.Red) + "NW: Power Modules | NO EFFECT");
        tooltip.add((Object)((Object)TextFmt.Aqua) + "NE: Efficiency Modules | 16% Reduced Consumption");
        tooltip.add((Object)((Object)TextFmt.Light_Purple) + "SE: Depth Modules | +2.5 Blocks Down");
        tooltip.add((Object)((Object)TextFmt.Yellow) + "SW: Range Modules | +20 Block Radius");
    }
}

