/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.ItemEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.InteractionResultHolder
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.item.activate;

import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.mob.entity.starforge.EntityWisp;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class ItemDarkbinder
extends Item {
    public ItemDarkbinder(String regName) {
        this.setRegistryName(regName);
        this.func_77655_b(regName);
        this.func_77637_a(TabsInit.TAB_AUXMATS);
        ItemInit.ITEMS.add(this);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        if (!worldIn.field_72995_K) {
            boolean foundLeaves = false;
            Iterable nearblocks = BlockPos.func_177980_a((BlockPos)playerIn.func_180425_c().func_177982_a(-6, -6, -6), (BlockPos)playerIn.func_180425_c().func_177982_a(6, 6, 6));
            for (BlockPos pos : nearblocks) {
                if (worldIn.func_180495_p(pos).func_177230_c() != BlockInit.leavesDarkborn) continue;
                foundLeaves = true;
                break;
            }
            if (foundLeaves) {
                boolean didWisp = false;
                for (EntityWisp creature : worldIn.func_72872_a(EntityWisp.class, playerIn.func_174813_aQ().func_72314_b(10.0, 10.0, 10.0))) {
                    if (creature.field_70128_L) continue;
                    ItemEntity heart = new ItemEntity(worldIn, creature.field_70165_t, creature.field_70163_u, creature.field_70161_v, new ItemStack(ItemInit.heartOfDarkness));
                    heart.field_70159_w = 0.0;
                    heart.field_70181_x = 0.0;
                    heart.field_70179_y = 0.0;
                    worldIn.func_72838_d((Entity)heart);
                    creature.func_70106_y();
                    didWisp = true;
                }
                if (didWisp) {
                    playerIn.func_145747_a((Component)new Component((Object)((Object)TextFmt.Light_Purple) + "Yes! Extinguish the light... Grow my power..."));
                }
            }
            worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundInit.DARKBIND, SoundSource.PLAYERS, 1.0f, 1.0f);
            CustomParticleConfig config1 = new CustomParticleConfig();
            config1.createInstance().setParticle(ParticleInit.CORRUPTION_MAGIC).setSpread(4.0, 1.0, 4.0).setCount(10).setIgnoreRange(true);
            IParticleSpawner.spawnParticle(worldIn, config1, playerIn.field_70165_t, playerIn.field_70163_u + (double)(playerIn.field_70131_O / 2.0f), playerIn.field_70161_v);
        }
        playerIn.func_184586_b(handIn).func_190918_g(1);
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Light_Purple) + "Binds darkness to a creature of light.");
    }
}

