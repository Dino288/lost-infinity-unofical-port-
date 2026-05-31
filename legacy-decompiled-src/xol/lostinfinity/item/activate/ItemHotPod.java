/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.InteractionResultHolder
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.item.activate;

import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class ItemHotPod
extends Item {
    public ItemHotPod(String regName) {
        this.setRegistryName(regName);
        this.func_77655_b(regName);
        this.func_77637_a(TabsInit.TAB_AUXMATS);
        ItemInit.ITEMS.add(this);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        if (!worldIn.field_72995_K) {
            Iterable nearblocks = BlockPos.func_177980_a((BlockPos)playerIn.func_180425_c().func_177982_a(-3, -3, -3), (BlockPos)playerIn.func_180425_c().func_177982_a(3, 3, 3));
            for (BlockPos pos : nearblocks) {
                if (worldIn.func_180495_p(pos).func_177230_c() != BlockInit.honeyGel) continue;
                worldIn.func_175656_a(pos, BlockInit.honeyGelEmpty.func_176223_P());
            }
            worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundInit.HOT_POD, SoundSource.PLAYERS, 1.0f, 1.0f);
            CustomParticleConfig config1 = new CustomParticleConfig();
            config1.createInstance().setParticle(ParticleInit.FLAME_LARGE).setSpread(1.0, 0.0, 1.0).setSpeed(0.3, 0.0, 0.3).setVelSpread(1.0, 0.0, 1.0).setCount(13).setIgnoreRange(true);
            IParticleSpawner.spawnParticle(worldIn, config1, playerIn.field_70165_t, playerIn.field_70163_u + (double)(playerIn.field_70131_O / 2.0f), playerIn.field_70161_v);
        }
        playerIn.func_184586_b(handIn).func_190918_g(1);
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Gold) + "Good for melting goo-ey substances.");
    }
}

