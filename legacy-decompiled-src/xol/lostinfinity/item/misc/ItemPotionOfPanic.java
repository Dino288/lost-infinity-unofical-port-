/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.passive.EntityTameable
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.InteractionResultHolder
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.AABB
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.item.misc;

import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.PotionInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemCooldown;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class ItemPotionOfPanic
extends ItemCooldown {
    public ItemPotionOfPanic(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_INFINITYWEP);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        if (!this.showDurabilityBar(playerIn.func_184586_b(handIn))) {
            if (!worldIn.field_72995_K) {
                worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundInit.EVIL_LAUGH, SoundSource.MASTER, 1.5f, 1.0f);
                worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundInit.DEEP_EXPLOSION, SoundSource.MASTER, 0.5f, 1.0f);
                CustomParticleConfig config1 = new CustomParticleConfig();
                config1.createInstance().setParticle(ParticleInit.EXPLOSION_FEAR).setSpread(30.0, 4.0, 30.0).setCount(5).setIgnoreRange(true);
                CustomParticleConfig config2 = new CustomParticleConfig();
                config2.createInstance().setParticle(ParticleInit.EXPLOSION_YELLOW).setSpread(30.0, 4.0, 30.0).setCount(15).setIgnoreRange(true);
                IParticleSpawner.spawnParticle(worldIn, config1, playerIn.field_70165_t, playerIn.field_70163_u + 1.0, playerIn.field_70161_v);
                IParticleSpawner.spawnParticle(worldIn, config2, playerIn.field_70165_t, playerIn.field_70163_u + 1.0, playerIn.field_70161_v);
                playerIn.func_70690_d(new PotionEffect(PotionInit.FEARED, 400));
                double radius = 15.0;
                for (LivingEntity entity : worldIn.func_72872_a(LivingEntity.class, new AABB(playerIn.func_180425_c()).func_186662_g(radius))) {
                    if (entity.func_110124_au().equals(playerIn.func_110124_au())) continue;
                    if (entity instanceof EntityTameable) {
                        if (((EntityTameable)entity).func_70902_q().func_110124_au().equals(playerIn.func_110124_au())) {
                            entity.func_70690_d(new PotionEffect(PotionInit.FEARED, 400));
                            continue;
                        }
                        entity.func_70690_d(new PotionEffect(PotionInit.TERRIFIED, 400));
                        continue;
                    }
                    entity.func_70690_d(new PotionEffect(PotionInit.TERRIFIED, 400));
                }
            }
            playerIn.func_184586_b(handIn).func_77978_p().func_74772_a("lastUse", System.currentTimeMillis());
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    @Override
    protected int getCooldown() {
        return 45000;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Gold) + "When drunk, creates a cloud of fear around you.");
        tooltip.add((Object)((Object)TextFmt.Light_Purple) + "The cloud causes enemies to fear you and your tames.");
        tooltip.add((Object)((Object)TextFmt.Italic) + "Entities who are afraid of another entity cannot go near them.");
        tooltip.add((Object)((Object)TextFmt.Italic) + "Entities who are afraid of another entity have a 50% chance to miss attacks on them.");
    }
}

