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
 *  net.minecraft.util.math.BlockPos
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
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemCooldown;
import xol.lostinfinity.item.classify.ICustomRaytrace;
import xol.lostinfinity.mob.entity.misc.EntityTotemSplitter;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.CustomHitResult;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class ItemWorldSplitter
extends ItemCooldown
implements ICustomRaytrace {
    public ItemWorldSplitter(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_AUXWEP);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        if (!this.showDurabilityBar(playerIn.func_184586_b(handIn))) {
            CustomHitResult trace_result;
            if (!worldIn.field_72995_K && (trace_result = this.simpleBlockTrace(worldIn, (LivingEntity)playerIn, 40)) != null) {
                BlockPos pylonPos = trace_result.getResultPos();
                EntityTotemSplitter pylon = new EntityTotemSplitter(worldIn);
                pylon.func_70107_b(pylonPos.func_177958_n(), pylonPos.func_177956_o(), pylonPos.func_177952_p());
                pylon.setOwner(playerIn);
                worldIn.func_72838_d((Entity)pylon);
                CustomParticleConfig config1 = new CustomParticleConfig();
                config1.createInstance().setParticle(ParticleInit.FLAME_MEDIUM).setSpread(1.0, 1.0, 1.0).setCount(7).setIgnoreRange(true);
                IParticleSpawner.spawnParticle(worldIn, config1, (double)pylonPos.func_177958_n(), (double)pylonPos.func_177956_o(), (double)pylonPos.func_177952_p());
                worldIn.func_184133_a(null, pylonPos, SoundInit.MAGIC_WEAPON_8, SoundSource.PLAYERS, 1.0f, 1.0f);
            }
            playerIn.func_184586_b(handIn).func_77978_p().func_74772_a("lastUse", System.currentTimeMillis());
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    @Override
    protected int getCooldown() {
        return 22000;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Gold) + "Summons a Level Splitter where you aim.");
        tooltip.add((Object)((Object)TextFmt.Green) + "Level Splitters apply Phased, Intangible & Ultraheavy");
    }
}

