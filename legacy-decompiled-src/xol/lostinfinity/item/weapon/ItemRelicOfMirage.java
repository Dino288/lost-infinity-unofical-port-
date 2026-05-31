/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.item.ItemEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
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
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
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
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.CustomHitResult;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class ItemRelicOfMirage
extends ItemCooldown
implements IMaxAttack,
ICustomRaytrace {
    public ItemRelicOfMirage(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_INFINITYWEP);
    }

    @Override
    protected int getCooldown() {
        return 3000;
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack stack = playerIn.func_184586_b(handIn);
        if (!this.showDurabilityBar(stack)) {
            Player tracedEntity;
            CustomHitResult trace_result;
            if (!worldIn.field_72995_K && (trace_result = this.entityTrace(worldIn, (LivingEntity)playerIn, 60, Player.class)) != null && trace_result.getResultEntity() != null && !(tracedEntity = (Player)trace_result.getResultEntity()).func_184614_ca().func_190926_b()) {
                ItemStack heldByTarget = tracedEntity.func_184614_ca();
                ItemStack stolenCopy = heldByTarget.func_77946_l();
                if (!stolenCopy.func_77942_o()) {
                    stolenCopy.func_77982_d(new CompoundTag());
                }
                stolenCopy.func_77978_p().func_74768_a("InfinityMiraged", playerIn.field_70173_aa);
                stolenCopy.func_190920_e(1);
                ItemEntity stolenItem = new ItemEntity(worldIn, playerIn.field_70165_t, playerIn.field_70163_u + 1.0, playerIn.field_70161_v, stolenCopy);
                stolenItem.field_70159_w = 0.0;
                stolenItem.field_70181_x = 0.0;
                stolenItem.field_70179_y = 0.0;
                worldIn.func_72838_d((Entity)stolenItem);
                CustomParticleConfig config1 = new CustomParticleConfig();
                config1.createInstance().setParticle(ParticleInit.ANCIENT_SPELL).setSpread(1.0, 1.0, 1.0).setSpeed(0.3, 0.0, 0.3).setVelSpread(1.0, 0.0, 1.0).setCount(14).setIgnoreRange(true);
                CustomParticleConfig config2 = new CustomParticleConfig();
                config2.createInstance().setParticle(ParticleInit.ATTRACT_FIELD).setSpread(1.0, 1.0, 1.0).setCount(3).setIgnoreRange(true);
                IParticleSpawner.spawnParticle(worldIn, config1, playerIn.field_70165_t, playerIn.field_70163_u + 1.0, playerIn.field_70161_v);
                IParticleSpawner.spawnParticle(worldIn, config2, tracedEntity.field_70165_t, tracedEntity.field_70163_u + 1.0, tracedEntity.field_70161_v);
                worldIn.func_184133_a(null, playerIn.func_180425_c(), SoundInit.MAGIC_WEAPON_12, SoundSource.PLAYERS, 1.0f, 0.8f + worldIn.field_73012_v.nextFloat() * 0.4f);
            }
            playerIn.func_184586_b(handIn).func_77978_p().func_74772_a("lastUse", System.currentTimeMillis());
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Gold) + "Creates a miraged copy of target player's held item.");
        tooltip.add((Object)((Object)TextFmt.Aqua) + "Miraged items are fully functional but vanish when held after some time.");
    }
}

