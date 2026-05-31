/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.block.material.Material
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
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
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.block.generator.BlockGenerator;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.util.data.IMaxAttack;

public class BlockTetherCreator
extends BlockGenerator
implements IMaxAttack {
    public BlockTetherCreator(String name) {
        super(name, 3.0f, Material.field_151576_e, TabsInit.TAB_BLOCKS);
    }

    @Override
    public void activateGenerator(Level worldIn, BlockPos pos, BlockState state, Player playerIn, int power_upgrade, int efficiency_upgrade, int range_upgrade, int depth_upgrade, UUID placer_uuid) {
        for (Player detected_player : worldIn.func_72872_a(Player.class, new AABB(pos).func_72314_b(20.0 + (double)(range_upgrade * 8), 10.0 + (double)(depth_upgrade * 4), 20.0 + (double)(range_upgrade * 8)))) {
            if (detected_player.func_110124_au().equals(placer_uuid) || !this.is_detectable((LivingEntity)detected_player)) continue;
            detected_player.setSpawnDimension(Integer.valueOf(worldIn.field_73011_w.getDimension()));
            detected_player.func_180473_a(detected_player.func_180425_c(), true);
        }
    }

    @SideOnly(value=Side.CLIENT)
    public void func_190948_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Italic) + "Tethers nearby players spawn points when given a Celestial Redstone.");
        tooltip.add((Object)((Object)TextFmt.Italic) + "Per Module Upgrades:");
        tooltip.add((Object)((Object)TextFmt.Red) + "NW: Power Modules | NO EFFECT");
        tooltip.add((Object)((Object)TextFmt.Aqua) + "NE: Efficiency Modules | 16% Reduced Consumption");
        tooltip.add((Object)((Object)TextFmt.Light_Purple) + "SE: Depth Modules | 4 Blocks Up/Down");
        tooltip.add((Object)((Object)TextFmt.Yellow) + "SW: Range Modules | 8 Block Radius");
    }
}

