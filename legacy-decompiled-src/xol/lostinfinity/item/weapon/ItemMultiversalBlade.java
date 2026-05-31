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
 *  net.minecraft.util.EnumInteractionResultHolder
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.Mth
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
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.util.EnumInteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemCooldown;
import xol.lostinfinity.item.classify.ICustomRaytrace;
import xol.lostinfinity.mob.entity.misc.EntityMultiverseGhost;
import xol.lostinfinity.util.data.CustomHitResult;
import xol.lostinfinity.util.data.IMaxAttack;

public class ItemMultiversalBlade
extends ItemCooldown
implements IMaxAttack,
ICustomRaytrace {
    public ItemMultiversalBlade(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_AUXWEP);
    }

    @Override
    protected int getCooldown() {
        return 600;
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack stack = playerIn.func_184586_b(handIn);
        if (!this.showDurabilityBar(stack)) {
            if (!worldIn.field_72995_K) {
                CustomHitResult result = this.complexTrace(worldIn, (LivingEntity)playerIn, 20, null, 0, 0, true, LivingEntity.class, 1, 0.3f);
                Vec3 target = result.getResultVector();
                float rYaw = playerIn.field_70177_z * ((float)Math.PI / 180);
                float x = -Mth.func_76126_a((float)rYaw);
                float z = Mth.func_76134_b((float)rYaw);
                float yawOffset = -1.0f + 2.0f * worldIn.field_73012_v.nextFloat();
                yawOffset = (float)((double)yawOffset + (Math.signum(yawOffset) < 0.0f ? -1.14 : 1.14));
                Vec3 spawn = playerIn.func_174791_d().func_178788_d(new Vec3((double)x * 2.5, -0.5, (double)z * 2.5).func_178785_b(yawOffset));
                Vec3 dir = target.func_178786_a(0.0, 1.5, 0.0).func_178788_d(spawn).func_72432_b();
                EntityMultiverseGhost ghost = new EntityMultiverseGhost(worldIn, dir.func_186678_a((double)0.1f));
                ghost.setCopiedPlay(playerIn);
                ghost.func_70080_a(spawn.field_72450_a, spawn.field_72448_b, spawn.field_72449_c, (float)Mth.func_181159_b((double)(-dir.field_72450_a), (double)dir.field_72449_c) * 57.29578f, 0.0f);
                worldIn.func_72838_d((Entity)ghost);
                worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundInit.MULTIVERSAL_BLADE, SoundSource.PLAYERS, 0.7f, 0.7f + worldIn.field_73012_v.nextFloat() * 0.6f);
            }
            playerIn.func_184609_a(handIn);
            playerIn.func_184586_b(handIn).func_77978_p().func_74772_a("lastUse", System.currentTimeMillis());
        }
        return new InteractionResultHolder(EnumInteractionResultHolder.SUCCESS, (Object)stack);
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Light_Purple) + "Call upon yourself from another universe to attack for you.");
        tooltip.add((Object)((Object)TextFmt.Red) + "Your alternate self deals 75% Health True Damage");
        tooltip.add((Object)((Object)TextFmt.Dark_Aqua) + "Darkborn");
    }
}

