/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.IEntityOwnable
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.math.AABB
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
import net.minecraft.entity.IEntityOwnable;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.classify.ICustomHoldPose;
import xol.lostinfinity.item.classify.IHotbarTick;
import xol.lostinfinity.mob.entity.base.EntityImmaterial;
import xol.lostinfinity.mob.entity.misc.EntityStormBomb;

public class ItemStormBauble
extends Item
implements IHotbarTick,
ICustomHoldPose {
    public ItemStormBauble(String regName) {
        this.func_77637_a(TabsInit.TAB_AUXWEP);
        this.setRegistryName(regName);
        this.func_77655_b(regName);
        ItemInit.ITEMS.add(this);
    }

    @Override
    public void hotbarTick(Player player, int slot, ItemStack stack) {
        Level world = player.field_70170_p;
        double pushRadius = 5.0;
        double bombRadius = 8.0;
        if (!world.field_72995_K && player.field_70173_aa - player.func_142013_aG() < 120 && player.func_142013_aG() != 0) {
            AABB checkBox = new AABB(player.func_180425_c().func_177963_a(-pushRadius, -pushRadius, -pushRadius), player.func_180425_c().func_177963_a(pushRadius, pushRadius, pushRadius));
            for (LivingEntity entity : world.func_72872_a(LivingEntity.class, checkBox)) {
                if (entity.func_110124_au().equals(player.func_110124_au()) || entity instanceof IEntityOwnable && ((IEntityOwnable)entity).func_184753_b().equals(player.func_110124_au()) || entity instanceof EntityImmaterial) continue;
                Vec3 dir = entity.func_174791_d().func_178788_d(player.func_174791_d());
                dir.func_72432_b();
                entity.func_70024_g(dir.field_72450_a / 10.0, dir.field_72448_b / 10.0 + 0.1, dir.field_72449_c / 10.0);
                entity.field_70133_I = true;
            }
            if (player.field_70173_aa % 5 == 0) {
                double angle = world.field_73012_v.nextDouble() * Math.PI * 2.0;
                double x = Math.cos(angle) * bombRadius + player.field_70165_t;
                double z = Math.sin(angle) * bombRadius + player.field_70161_v;
                double y = player.field_70163_u + (double)(player.field_70131_O / 2.0f) + 1.0;
                EntityStormBomb bomb = new EntityStormBomb(world);
                bomb.setCreator(player.func_110124_au());
                bomb.func_70107_b(x, y, z);
                world.func_72838_d((Entity)bomb);
            }
        }
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Light_Purple) + "While in the hotbar, if you've taken damage recently:");
        tooltip.add((Object)((Object)TextFmt.Gold) + "Create storm bombs that deal 50% health true damage around you.");
        tooltip.add((Object)((Object)TextFmt.Gold) + "Push living entities away.");
    }
}

