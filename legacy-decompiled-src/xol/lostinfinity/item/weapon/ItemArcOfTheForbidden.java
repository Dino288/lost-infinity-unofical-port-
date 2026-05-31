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
 *  net.minecraft.util.SoundSource
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
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemCooldown;
import xol.lostinfinity.item.classify.IMaxNullable;
import xol.lostinfinity.item.classify.IMaxReducible;
import xol.lostinfinity.projectile.entity.EntityArcBlast;

public class ItemArcOfTheForbidden
extends ItemCooldown
implements IMaxReducible,
IMaxNullable {
    public ItemArcOfTheForbidden(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_INFINITYWEP);
    }

    @Override
    protected int getCooldown() {
        return 2000;
    }

    @Override
    public float reduceMaxDamage(Player player, boolean isMainHand, float damage, float reductionMultiplier, ItemStack stack) {
        float newMulti = reductionMultiplier;
        if (this.showDurabilityBar(stack)) {
            newMulti -= 0.25f;
        }
        return newMulti;
    }

    @Override
    public float nullableReaction(Player player, boolean isMainHand, float originalDamage, float newDamage, ItemStack stack) {
        if (!this.showDurabilityBar(stack)) {
            Level world = player.field_70170_p;
            if (!world.field_72995_K) {
                double x0 = player.field_70165_t;
                double y0 = player.field_70163_u + 1.0;
                double z0 = player.field_70161_v;
                double radius = 5.0;
                float angle = 0.0f;
                while ((double)angle <= Math.PI * 2) {
                    EntityArcBlast shot = new EntityArcBlast(world, (LivingEntity)player);
                    shot.func_70107_b(x0, y0, z0);
                    double velocity_x = radius * Math.cos(angle);
                    double velocity_z = radius * Math.sin(angle);
                    shot.setThrower((LivingEntity)player);
                    shot.calculateVelocity(velocity_x * 0.25, 0.1f, velocity_z * 0.25);
                    world.func_72838_d((Entity)shot);
                    angle = (float)((double)angle + 0.39269908169872414);
                }
            }
            player.field_70170_p.func_184133_a(null, player.func_180425_c(), SoundInit.SHIELD_BLOCK, SoundSource.PLAYERS, 1.0f, 0.8f + player.field_70170_p.field_73012_v.nextFloat() * 0.4f);
            stack.func_77978_p().func_74772_a("lastUse", System.currentTimeMillis());
            return 0.0f;
        }
        return newDamage;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Bold) + "Reflects 70% of Max Health Damage Taken");
        tooltip.add((Object)((Object)TextFmt.Italic) + "Ocasionally Blocks a Full Max Health Hit");
        tooltip.add((Object)((Object)TextFmt.Aqua) + "Fires a Ring of Arc Blasts When Blocking a Hit");
        tooltip.add((Object)((Object)TextFmt.Gold) + "Counts as an Arc Blaster");
        tooltip.add((Object)((Object)TextFmt.Red) + "Grants 30% Max Health Damage Reduction While on Cooldown");
    }
}

