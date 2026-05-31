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
 *  net.minecraft.util.math.AABB
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
import net.minecraft.world.phys.AABB;
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
import xol.lostinfinity.mob.entity.misc.EntityPickleMan;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.CustomHitResult;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class ItemVeggiRelocator
extends ItemCooldown
implements ICustomRaytrace {
    public ItemVeggiRelocator(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_AUXWEP);
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack stack = playerIn.func_184586_b(handIn);
        if (!this.showDurabilityBar(stack)) {
            CustomHitResult trace_result;
            if (!worldIn.field_72995_K && (trace_result = this.entityTrace(worldIn, (LivingEntity)playerIn, 45, LivingEntity.class)) != null) {
                boolean isDeploying = stack.func_77978_p().func_74767_n("Deploying");
                BlockPos resultPos = trace_result.getResultPos();
                if (!isDeploying) {
                    int count = 0;
                    for (EntityPickleMan pickle : worldIn.func_72872_a(EntityPickleMan.class, new AABB(resultPos).func_186662_g(10.0))) {
                        pickle.func_70106_y();
                        ++count;
                    }
                    stack.func_77978_p().func_74768_a("StoredPickles", count);
                    stack.func_77978_p().func_74757_a("Deploying", true);
                    worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundInit.LASER_WEAPON_6, SoundSource.PLAYERS, 0.7f, 0.7f + worldIn.field_73012_v.nextFloat() * 0.6f);
                } else {
                    stack.func_77978_p().func_74757_a("Deploying", false);
                    int pickles = stack.func_77978_p().func_74762_e("StoredPickles");
                    if (pickles > 0) {
                        for (int i = 0; i < pickles; ++i) {
                            EntityPickleMan pickleman = new EntityPickleMan(worldIn);
                            pickleman.func_70107_b(resultPos.func_177958_n(), (double)resultPos.func_177956_o() + 0.5, resultPos.func_177952_p());
                            pickleman.func_193101_c(playerIn);
                            worldIn.func_72838_d((Entity)pickleman);
                        }
                        CustomParticleConfig config1 = new CustomParticleConfig();
                        config1.createInstance().setParticle(ParticleInit.NATURE_MAGIC).setSpread(4.0, 1.0, 4.0).setCount(10).setIgnoreRange(true);
                        IParticleSpawner.spawnParticle(worldIn, config1, (double)resultPos.func_177958_n(), (double)resultPos.func_177956_o() + 0.5, (double)resultPos.func_177952_p());
                        worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundInit.MAGIC_WEAPON_8, SoundSource.PLAYERS, 0.7f, 0.7f + worldIn.field_73012_v.nextFloat() * 0.6f);
                    }
                }
            }
            playerIn.func_184586_b(handIn).func_77978_p().func_74772_a("lastUse", System.currentTimeMillis());
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    @Override
    protected int getCooldown() {
        return 500;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Light_Purple) + "Stores nearby Pickle Men where you aim.");
        tooltip.add((Object)((Object)TextFmt.Gold) + "Firing again redploys the Pickle Men.");
    }
}

