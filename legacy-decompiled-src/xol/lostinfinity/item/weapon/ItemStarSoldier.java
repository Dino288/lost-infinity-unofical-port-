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
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.InteractionResultHolder
 *  net.minecraft.util.InteractionHand
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
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.PotionInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemCooldown;
import xol.lostinfinity.item.classify.ICustomHoldPose;
import xol.lostinfinity.item.classify.ICustomRaytrace;
import xol.lostinfinity.projectile.entity.EntityStarBlast;
import xol.lostinfinity.util.data.CustomHitResult;

public class ItemStarSoldier
extends ItemCooldown
implements ICustomHoldPose,
ICustomRaytrace {
    public ItemStarSoldier(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_INFINITYWEP);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        if (!this.showDurabilityBar(playerIn.func_184586_b(handIn))) {
            if (!worldIn.field_72995_K) {
                EntityStarBlast shot = new EntityStarBlast(worldIn, (LivingEntity)playerIn);
                shot.setThrower((LivingEntity)playerIn);
                shot.func_184538_a((Entity)playerIn, playerIn.field_70125_A, playerIn.field_70177_z, 0.0f, 3.0f, 5.0f);
                worldIn.func_72838_d((Entity)shot);
                CustomHitResult trace_result = this.simpleBlockTrace(worldIn, (LivingEntity)playerIn, 5);
                if (trace_result != null) {
                    Vec3 resultVector = trace_result.getGrabbedVector();
                    if (playerIn.func_70011_f(resultVector.field_72450_a, resultVector.field_72448_b, resultVector.field_72449_c) < 5.0) {
                        playerIn.func_70024_g(Math.signum(resultVector.field_72450_a - playerIn.field_70165_t) * -2.5, 1.0, Math.signum(resultVector.field_72449_c - playerIn.field_70161_v) * -2.5);
                        playerIn.field_70133_I = true;
                        playerIn.func_70690_d(new PotionEffect(PotionInit.ADRENALINE, 120, 2));
                    }
                }
            }
            playerIn.func_184185_a(SoundEvents.field_187578_au, 1.0f, 1.0f);
            playerIn.func_184586_b(handIn).func_77978_p().func_74772_a("lastUse", System.currentTimeMillis());
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    @Override
    protected int getCooldown() {
        return 300;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Gold) + "Shoots a projectile that creates a large explosion on impact.");
        tooltip.add((Object)((Object)TextFmt.Italic) + "Explosion deals 75% max health damage.");
        tooltip.add((Object)((Object)TextFmt.Green) + "Can rocket jump using the explosion, gaining Adrenaline III.");
    }
}

