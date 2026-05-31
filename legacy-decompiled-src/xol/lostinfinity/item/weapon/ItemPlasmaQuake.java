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
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemCooldown;
import xol.lostinfinity.item.classify.ICustomRaytrace;
import xol.lostinfinity.mob.entity.misc.EntityPlasmaBomb;
import xol.lostinfinity.util.data.CustomHitResult;
import xol.lostinfinity.util.data.IMaxAttack;

public class ItemPlasmaQuake
extends ItemCooldown
implements IMaxAttack,
ICustomRaytrace {
    public ItemPlasmaQuake(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_AUXWEP);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack stack = playerIn.func_184586_b(handIn);
        if (!this.showDurabilityBar(stack)) {
            if (!worldIn.field_72995_K) {
                CustomHitResult trace_result = this.forwardTrace(worldIn, (Entity)playerIn, 2);
                Vec3 dir = trace_result.getResultVector().func_178788_d(playerIn.func_174791_d());
                dir = dir.func_178788_d(new Vec3(0.0, dir.field_72448_b, 0.0));
                dir = dir.func_72432_b();
                EntityPlasmaBomb bomb = new EntityPlasmaBomb(worldIn);
                bomb.setCreator(playerIn.func_110124_au());
                int height = worldIn.func_189649_b(playerIn.func_180425_c().func_177958_n() + (int)dir.field_72450_a * 2, playerIn.func_180425_c().func_177952_p() + (int)dir.field_72449_c * 2);
                bomb.func_70107_b((double)playerIn.func_180425_c().func_177958_n() + dir.field_72450_a * 2.0, height + 1, (double)playerIn.func_180425_c().func_177952_p() + dir.field_72449_c * 2.0);
                bomb.setTimer(0);
                bomb.setDir(dir);
                bomb.setRepeats(30);
                worldIn.func_72838_d((Entity)bomb);
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
        tooltip.add((Object)((Object)TextFmt.Light_Purple) + "Creates a Plasma Quake along the ground.");
        tooltip.add((Object)((Object)TextFmt.Aqua) + "Direction of quake is the direction you are facing.");
        tooltip.add((Object)((Object)TextFmt.Gold) + "Deals 100% Health As True Damage");
    }
}

