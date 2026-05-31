/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.util.ITooltipFlag
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
package xol.lostinfinity.item.misc;

import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
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
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemCooldown;
import xol.lostinfinity.item.classify.ICustomRaytrace;
import xol.lostinfinity.mob.entity.murk.EntitySkyre;
import xol.lostinfinity.mob.entity.murk.EntityWhisper;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.CustomHitResult;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class ItemBeaconOfDarkness
extends ItemCooldown
implements ICustomRaytrace {
    public ItemBeaconOfDarkness(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_AUXMATS);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        if (!this.showDurabilityBar(playerIn.func_184586_b(handIn))) {
            CustomHitResult trace_result;
            if (!worldIn.field_72995_K && (trace_result = this.entityTrace(worldIn, (LivingEntity)playerIn, 45, LivingEntity.class)) != null && trace_result.getResultEntity() != null) {
                LivingEntity hit_entity = (LivingEntity)trace_result.getResultEntity();
                for (EntitySkyre skyre : worldIn.func_72872_a(EntitySkyre.class, playerIn.func_174813_aQ().func_186662_g(20.0))) {
                    skyre.setMyDarkTarget(hit_entity);
                }
                for (EntityWhisper whisper : worldIn.func_72872_a(EntityWhisper.class, playerIn.func_174813_aQ().func_186662_g(45.0))) {
                    whisper.setFollowingTarget((LivingEntity)playerIn);
                }
                CustomParticleConfig config1 = new CustomParticleConfig();
                config1.createInstance().setParticle(ParticleInit.CORRUPTION_MAGIC).setSpread(4.0, 1.0, 4.0).setCount(10).setIgnoreRange(true);
                IParticleSpawner.spawnParticle(worldIn, config1, hit_entity.field_70165_t, hit_entity.field_70163_u + (double)(hit_entity.field_70131_O / 2.0f), hit_entity.field_70161_v);
                worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundInit.DARKBIND, SoundSource.PLAYERS, 1.0f, 1.0f);
            }
            playerIn.func_184586_b(handIn).func_77978_p().func_74772_a("lastUse", System.currentTimeMillis());
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    @Override
    protected int getCooldown() {
        return 100;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Dark_Purple) + "Attracts certain dark creatures.");
        tooltip.add((Object)((Object)TextFmt.Light_Purple) + "Can be used to send dark creatures to a target.");
    }
}

