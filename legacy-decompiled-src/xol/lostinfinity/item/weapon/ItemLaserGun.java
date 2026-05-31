/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.InteractionResultHolder
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
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
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemChanneling;
import xol.lostinfinity.projectile.entity.EntityLaserGunBeam;

public class ItemLaserGun
extends ItemChanneling {
    public ItemLaserGun(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_AUXWEP);
        this.setMaxChargeTime(34);
    }

    @Override
    public InteractionResultHolder<ItemStack> chargeStart(Level worldIn, Player player, InteractionHand handIn, ItemStack stack) {
        if (!worldIn.field_72995_K) {
            EntityLaserGunBeam laserBeam = new EntityLaserGunBeam(worldIn);
            double dist = laserBeam.getDist();
            Vec3 targetPos = player.func_70040_Z().func_186678_a(dist).func_178787_e(player.func_174791_d());
            laserBeam.setOwner(player);
            laserBeam.setTargetPos(targetPos);
            laserBeam.setStack(stack);
            Vec3 lookVec = player.func_70040_Z().func_178785_b(1.5707964f);
            laserBeam.func_70107_b(player.field_70165_t - lookVec.field_72450_a / 2.0, player.field_70163_u + (double)player.field_70131_O / 1.8, player.field_70161_v - lookVec.field_72449_c / 2.0);
            worldIn.func_72838_d((Entity)laserBeam);
            worldIn.func_184133_a(null, player.func_180425_c(), SoundInit.MAGIC_WEAPON_20, SoundSource.PLAYERS, 0.7f, 0.8f + worldIn.field_73012_v.nextFloat() * 0.4f);
        }
        return super.chargeStart(worldIn, player, handIn, stack);
    }

    @Override
    protected int getCooldown() {
        return 2000;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Italic) + "The Super-Mega-Ultimate Laser Gun");
        tooltip.add((Object)((Object)TextFmt.Gold) + "Charges up a high damage, terrain-piercing laser.");
        tooltip.add((Object)((Object)TextFmt.Red) + "Also Deals 50% Health True Damage");
        tooltip.add((Object)((Object)TextFmt.Underline) + "Also takes off 50% of remaining lives from multi-life creatures (max 10)");
    }
}

