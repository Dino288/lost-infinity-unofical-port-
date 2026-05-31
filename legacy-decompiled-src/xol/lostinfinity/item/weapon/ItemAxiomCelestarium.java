/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.util.InteractionResultHolder
 *  net.minecraft.util.InteractionHand
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
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.classify.IHeldTick;
import xol.lostinfinity.projectile.entity.EntityCelestialFire;
import xol.lostinfinity.util.player.HoldItemUtil;

public class ItemAxiomCelestarium
extends Item
implements IHeldTick {
    public ItemAxiomCelestarium(String regName) {
        this.func_77637_a(TabsInit.TAB_INFINITYWEP);
        this.setRegistryName(regName);
        this.func_77655_b(regName);
        ItemInit.ITEMS.add(this);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player player, InteractionHand handIn) {
        ItemStack stack = player.func_184586_b(handIn);
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
            stack.func_77978_p().func_74768_a("Charge", 0);
        }
        if (!this.showDurabilityBar(player.func_184586_b(handIn))) {
            stack.func_77978_p().func_74768_a("Charge", 0);
            if (!worldIn.field_72995_K) {
                worldIn.func_184133_a(null, player.func_180425_c(), SoundInit.MAGIC_WEAPON_3, SoundSource.MASTER, 2.0f, 1.0f);
                for (int yVelo = 1; yVelo < 3; ++yVelo) {
                    float startPos = (float)((double)(yVelo - 1) * Math.PI / 8.0);
                    double x0 = player.field_70165_t;
                    double y0 = player.field_70163_u;
                    double z0 = player.field_70161_v;
                    double radius = 5.0;
                    float angle = startPos;
                    while ((double)angle <= Math.PI * 2 + (double)startPos) {
                        EntityCelestialFire shot = new EntityCelestialFire(worldIn, (LivingEntity)player);
                        shot.func_70107_b(x0, y0, z0);
                        double velocity_x = radius * Math.cos(angle);
                        double velocity_z = radius * Math.sin(angle);
                        shot.setThrower((LivingEntity)player);
                        shot.calculateVelocity(velocity_x, (float)(-yVelo) * 1.5f, velocity_z);
                        shot.func_184538_a((Entity)player, shot.field_70125_A, shot.field_70177_z, 0.0f, 1.3f, 0.0f);
                        worldIn.func_72838_d((Entity)shot);
                        angle = (float)((double)angle + 0.3141592653589793);
                    }
                }
            }
        }
        return super.func_77659_a(worldIn, player, handIn);
    }

    public boolean showDurabilityBar(ItemStack stack) {
        int chrg;
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
            stack.func_77978_p().func_74768_a("Charge", 0);
        }
        return (chrg = stack.func_77978_p().func_74762_e("Charge")) != 25;
    }

    public double getDurabilityForDisplay(ItemStack stack) {
        if (this.showDurabilityBar(stack)) {
            double result = stack.func_77978_p().func_74762_e("Charge");
            double fin = result / 25.0;
            return 1.0 - Math.pow(fin, 1.0);
        }
        return 1.0;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Gold) + "When held destroys incoming projectiles.");
        tooltip.add((Object)((Object)TextFmt.Gold) + "At maximum charge, activate to fire a ring of 50% max health damage attacks.");
        if (stack.func_77942_o() && stack.func_77978_p().func_74764_b("Charge")) {
            int charges = stack.func_77978_p().func_74762_e("Charge");
            tooltip.add((Object)((Object)TextFmt.Aqua) + "Charges: " + charges + "/25");
        }
    }

    @Override
    public void heldTick(Player player, InteractionHand hand, ItemStack stack) {
        HoldItemUtil.axiomProtection(player);
    }
}

