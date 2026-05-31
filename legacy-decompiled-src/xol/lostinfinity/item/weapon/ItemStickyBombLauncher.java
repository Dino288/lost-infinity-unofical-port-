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
 *  net.minecraft.util.InteractionResultHolder
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.item.weapon;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemCooldown;
import xol.lostinfinity.item.classify.ICustomHoldPose;
import xol.lostinfinity.item.classify.IModeSelect;
import xol.lostinfinity.mob.entity.misc.EntityStickyBomb;
import xol.lostinfinity.projectile.entity.EntityStickyProjectile;

public class ItemStickyBombLauncher
extends ItemCooldown
implements ICustomHoldPose,
IModeSelect {
    private List<EntityStickyBomb> bombs = new ArrayList<EntityStickyBomb>();

    public ItemStickyBombLauncher(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_AUXWEP);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        if (!this.showDurabilityBar(playerIn.func_184586_b(handIn))) {
            if (!worldIn.field_72995_K) {
                ItemStack stack = playerIn.func_184586_b(handIn);
                EntityStickyProjectile shot = new EntityStickyProjectile(worldIn, (LivingEntity)playerIn);
                shot.setThrower((LivingEntity)playerIn);
                shot.func_184538_a((Entity)playerIn, playerIn.field_70125_A, playerIn.field_70177_z, 0.0f, 1.5f, 1.0f);
                shot.setStack(stack);
                worldIn.func_72838_d((Entity)shot);
            }
            playerIn.func_184185_a(SoundInit.ITEM_STARSTORM, 1.0f, 1.0f);
            playerIn.func_184586_b(handIn).func_77978_p().func_74772_a("lastUse", System.currentTimeMillis());
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    public void addBomb(EntityStickyBomb bomb) {
        this.bombs.add(bomb);
    }

    @Override
    protected int getCooldown() {
        return 500;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Yellow) + "Fires sticky bombs.");
        tooltip.add((Object)((Object)TextFmt.Red) + "Bombs can be detonated to deal 50% Max Health Damage.");
    }

    @Override
    public void modeUpdate(ItemStack stack, Player player) {
        if (!this.showDurabilityBar(stack)) {
            Level world = player.field_70170_p;
            if (!world.field_72995_K) {
                for (EntityStickyBomb bomb : this.bombs) {
                    if (bomb == null || bomb.field_70128_L) continue;
                    bomb.explosionEffect();
                }
                this.bombs.clear();
            }
            stack.func_77978_p().func_74772_a("lastUse", System.currentTimeMillis());
        }
    }
}

