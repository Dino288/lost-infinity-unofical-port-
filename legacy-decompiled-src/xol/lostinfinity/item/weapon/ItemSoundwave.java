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
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemCooldown;
import xol.lostinfinity.item.classify.ICustomHoldPose;
import xol.lostinfinity.projectile.entity.EntitySoundwaveBullet;

public class ItemSoundwave
extends ItemCooldown
implements ICustomHoldPose {
    public ItemSoundwave(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_AUXWEP);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack stack = playerIn.func_184586_b(handIn);
        if (!this.showDurabilityBar(stack)) {
            if (!worldIn.field_72995_K) {
                EntitySoundwaveBullet bullet = new EntitySoundwaveBullet(worldIn, (LivingEntity)playerIn);
                bullet.setThrower((LivingEntity)playerIn);
                bullet.func_184538_a((Entity)playerIn, playerIn.field_70125_A, playerIn.field_70759_as, 0.0f, 0.5f, 0.0f);
                worldIn.func_72838_d((Entity)bullet);
                worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundInit.SOUND_GUN, SoundSource.PLAYERS, 1.0f, 0.8f + worldIn.field_73012_v.nextFloat() * 0.4f);
            }
            playerIn.func_184586_b(handIn).func_77978_p().func_74772_a("lastUse", System.currentTimeMillis());
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    @Override
    protected int getCooldown() {
        return 600;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Italic) + "Shoots echo projectiles.");
        tooltip.add((Object)((Object)TextFmt.Gold) + "Echo projectiles pierce entities, dealing damage periodically.");
        tooltip.add((Object)((Object)TextFmt.Gold) + "Echoes can bounce off terrain.");
        tooltip.add((Object)((Object)TextFmt.Red) + "Deals 33% Max Health Damage Every 0.5 Seconds");
        tooltip.add((Object)((Object)TextFmt.Red) + "Projectiels Deal True Damage After Bouncing");
    }
}

