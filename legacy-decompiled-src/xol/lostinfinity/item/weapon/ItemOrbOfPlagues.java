/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.player.Player
 *  net.minecraft.entity.player.ServerPlayer
 *  net.minecraft.item.ItemStack
 *  net.minecraft.potion.Potion
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.InteractionResultHolder
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.item.weapon;

import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.PotionInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemCooldown;
import xol.lostinfinity.util.PotionBasic;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class ItemOrbOfPlagues
extends ItemCooldown {
    public ItemOrbOfPlagues(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_AUXWEP);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        if (!this.showDurabilityBar(playerIn.func_184586_b(handIn))) {
            if (!worldIn.field_72995_K) {
                for (ServerPlayer playerMP : worldIn.func_73046_m().func_184103_al().func_181057_v()) {
                    if (playerMP.func_110124_au().equals(playerIn.func_110124_au())) continue;
                    int removed_potions = 0;
                    List potionList = playerMP.func_70651_bq().stream().map(PotionEffect::func_188419_a).collect(Collectors.toList());
                    for (Potion potion : potionList) {
                        if (potion instanceof PotionBasic) {
                            PotionBasic lost_potion = (PotionBasic)potion;
                            if (lost_potion.negativeLostEffect()) continue;
                            playerMP.func_184589_d(potion);
                            ++removed_potions;
                            continue;
                        }
                        if (potion.func_76398_f()) continue;
                        playerMP.func_184589_d(potion);
                        ++removed_potions;
                    }
                    playerMP.func_70690_d(new PotionEffect(PotionInit.PLAGUE, 200, removed_potions));
                    playerMP.func_145747_a((Component)new Component((Object)((Object)TextFmt.Dark_Green) + "You begin to feel very sick."));
                    playerMP.field_70170_p.func_184133_a(null, playerMP.func_180425_c(), SoundInit.IMPENDING_DOOM, SoundSource.PLAYERS, 1.5f, 1.0f);
                }
                double radius = 3.0;
                float angle = 0.0f;
                while ((double)angle <= Math.PI * 2) {
                    double velocity_x = radius * Math.cos(angle);
                    double velocity_z = radius * Math.sin(angle);
                    CustomParticleConfig config1 = new CustomParticleConfig();
                    config1.createInstance().setParticle(ParticleInit.DARK_MAGIC).setIgnoreRange(true);
                    CustomParticleConfig config2 = new CustomParticleConfig();
                    config2.createInstance().setParticle(ParticleInit.PLAGUE).setIgnoreRange(true);
                    IParticleSpawner.spawnParticle(worldIn, config1, playerIn.field_70165_t + velocity_x, playerIn.field_70163_u + 0.5, playerIn.field_70161_v + velocity_z);
                    IParticleSpawner.spawnParticle(worldIn, config2, playerIn.field_70165_t + velocity_x, playerIn.field_70163_u + 0.5, playerIn.field_70161_v + velocity_z);
                    angle = (float)((double)angle + 0.3141592653589793);
                }
                worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundInit.IMPENDING_DOOM, SoundSource.PLAYERS, 1.0f, 1.0f);
            }
            playerIn.func_184586_b(handIn).func_77978_p().func_74772_a("lastUse", System.currentTimeMillis());
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    @Override
    protected int getCooldown() {
        return 30000;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Gold) + "Plagues EVERY other player on the server.");
        tooltip.add((Object)((Object)TextFmt.Green) + "Plague replaces all positive potion effects.");
        tooltip.add((Object)((Object)TextFmt.Red) + "Plague severity is increased by number of effects replaced.");
    }
}

