/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.Item
 *  net.minecraft.item.Item$ToolMaterial
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.SwordItem
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.util.EnumParticleTypes
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 */
package xol.lostinfinity.item.weapon;

import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.Vec3;
import net.minecraft.core.Vec3i;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.classify.IModeSelect;
import xol.lostinfinity.mob.entity.misc.PlayerLimb;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class SwordItemOfInsanity
extends SwordItem
implements IModeSelect,
IMaxAttack {
    public SwordItemOfInsanity(String regName) {
        super(Item.ToolMaterial.DIAMOND);
        this.func_77637_a(TabsInit.TAB_INFINITYWEP);
        this.setRegistryName(regName);
        this.func_77655_b(regName);
        this.func_77625_d(1);
        ItemInit.ITEMS.add((Item)this);
    }

    public boolean func_77644_a(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        boolean mode = this.getMode(stack);
        if (mode) {
            this.amputationAttack(stack, target, attacker);
            target.field_70170_p.func_184133_a(null, target.func_180425_c(), SoundInit.SWING_HIT, SoundSource.PLAYERS, 1.0f, 0.6f + target.field_70170_p.field_73012_v.nextFloat() * 0.4f);
        } else {
            this.destructionAttack(stack, target, attacker);
            target.field_70170_p.func_184133_a(null, target.func_180425_c(), SoundInit.MISSILE_EXPLOSION, SoundSource.PLAYERS, 1.0f, 0.6f + target.field_70170_p.field_73012_v.nextFloat() * 0.4f);
        }
        return true;
    }

    private void amputationAttack(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (!IMaxAttack.dealTrueDamage((Entity)attacker, target, target.func_110138_aP(), null).wasTargetKilled() && !IMaxAttack.dealTrueDamage((Entity)attacker, target, target.func_110138_aP(), null).wasTargetKilled()) {
            IMaxAttack.dealTrueDamage((Entity)attacker, target, target.func_110138_aP(), null);
        }
        if (!(target instanceof Player)) {
            return;
        }
        PlayerLimb entityLimb = new PlayerLimb(target.field_70170_p, target.func_110124_au());
        Vec3 targetPos = target.func_174791_d();
        Vec3 targetLook = target.func_70040_Z();
        Vec3 targetLookScaled = targetLook.func_186678_a(0.5);
        Vec3 targetPosBehind = targetPos.func_178788_d(targetLookScaled);
        entityLimb.func_70107_b(targetPosBehind.field_72450_a, targetPosBehind.field_72448_b, targetPosBehind.field_72449_c);
        Vec3 lookVec = attacker.func_70040_Z();
        entityLimb.field_70159_w = lookVec.field_72450_a * 0.7;
        entityLimb.field_70181_x = lookVec.field_72448_b * 0.7 + 0.6;
        entityLimb.field_70179_y = lookVec.field_72449_c * 0.7;
        if (!target.field_70170_p.field_72995_K) {
            attacker.field_70170_p.func_72838_d((Entity)entityLimb);
        }
    }

    private void destructionAttack(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        IMaxAttack.dealTrueDamage((Entity)attacker, target, target.func_110138_aP(), null);
        if (!(target instanceof Player)) {
            return;
        }
        Iterable blocks = BlockPos.func_177980_a((BlockPos)target.func_180425_c().func_177982_a(-3, -3, -3), (BlockPos)target.func_180425_c().func_177982_a(3, 3, 3));
        for (BlockPos pos : blocks) {
            if (!(pos.func_177951_i((Vec3i)target.func_180425_c()) < 9.0) || target.field_70170_p.func_180495_p(pos).func_185887_b(target.field_70170_p, pos) == -1.0f) continue;
            target.field_70170_p.func_175655_b(pos, true);
        }
        CustomParticleConfig config = new CustomParticleConfig();
        config.createInstance().setCount(50).setParticle(EnumParticleTypes.DRAGON_BREATH).setSpread(3.0, 2.0, 3.0).setSpeed(new Vec3(0.0, (double)0.1f, 0.0));
        IParticleSpawner.spawnParticle(target.field_70170_p, config, target.field_70165_t, target.field_70163_u, target.field_70161_v);
    }

    @Override
    public void modeUpdate(ItemStack stack, Player player) {
        if (stack.func_77978_p() == null) {
            stack.func_77982_d(new CompoundTag());
        }
        boolean mode = !this.getMode(stack);
        this.setMode(stack, mode);
        this.announceUpdate(player, mode);
    }

    private void announceUpdate(Player player, boolean mode) {
        if (mode) {
            player.func_146105_b((Component)new Component("Amputation Mode"), true);
        } else {
            player.func_146105_b((Component)new Component("Destruction Mode"), true);
        }
    }

    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Light_Purple) + "Amputation Mode: Slices the limbs off of enemies (100% Health True Damage 3 Times)");
        tooltip.add((Object)((Object)TextFmt.Light_Purple) + "Destruction Mode: Destroys blocks around enemy players (100% Health True Damage)");
    }

    private void setMode(ItemStack stack, boolean mode) {
        if (stack.func_77978_p() == null) {
            stack.func_77982_d(new CompoundTag());
        }
        stack.func_77978_p().func_74757_a("mode", mode);
    }

    private boolean getMode(ItemStack stack) {
        if (stack.func_77978_p() == null) {
            stack.func_77982_d(new CompoundTag());
        }
        return stack.func_77978_p().func_74767_n("mode");
    }
}

