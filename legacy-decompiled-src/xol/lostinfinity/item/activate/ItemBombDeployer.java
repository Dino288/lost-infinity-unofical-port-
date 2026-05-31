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
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.item.activate;

import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemCooldown;
import xol.lostinfinity.mob.entity.misc.EntityBomberBomb;

public class ItemBombDeployer
extends ItemCooldown {
    public ItemBombDeployer(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_AUXMATS);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        if (!this.showDurabilityBar(playerIn.func_184586_b(handIn))) {
            ItemStack stack = playerIn.func_184586_b(handIn);
            if (!worldIn.field_72995_K) {
                int speedVal = stack.func_77978_p().func_74762_e("BombSpeed");
                int sizeVal = stack.func_77978_p().func_74762_e("BombSize");
                EntityBomberBomb bomb = new EntityBomberBomb(worldIn);
                double xPos = Math.floor(playerIn.field_70165_t) + 0.5;
                double zPos = Math.floor(playerIn.field_70161_v) + 0.5;
                bomb.func_70107_b(xPos, playerIn.field_70163_u, zPos);
                bomb.setCreator(playerIn.func_110124_au());
                bomb.setDeploymentTime(80 - 12 * speedVal);
                bomb.setBombSize(1 + sizeVal);
                worldIn.func_72838_d((Entity)bomb);
            }
            playerIn.func_184586_b(handIn).func_77978_p().func_74772_a("lastUse", System.currentTimeMillis());
            int cdVal = stack.func_77978_p().func_74762_e("BombCooldown");
            stack.func_77978_p().func_74768_a("ComplexCooldown", 6000 - 1000 * cdVal);
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    @Override
    protected boolean hasSimpleCooldown() {
        return false;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Gold) + "Deploys bombs that explode into two crossing lines.");
        tooltip.add((Object)((Object)TextFmt.Italic) + "Bombs break soft walls.");
    }
}

