/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.PlayerSP
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.entity.projectile.EntityArrow
 *  net.minecraft.entity.projectile.EntityFireball
 *  net.minecraft.entity.projectile.EntityShulkerBullet
 *  net.minecraft.entity.projectile.EntityThrowable
 *  net.minecraft.item.Item
 *  net.minecraft.item.Item$ToolMaterial
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.SwordItem
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.potion.Potion
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.math.Mth
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.item.weapon;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.PlayerSP;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.projectile.EntityShulkerBullet;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.classify.IHitReactive;
import xol.lostinfinity.item.classify.IModeSelect;
import xol.lostinfinity.item.classify.IPotionReactive;
import xol.lostinfinity.item.classify.ISwitchModels;
import xol.lostinfinity.item.weapon.ItemDawnOfEternity;
import xol.lostinfinity.mob.entity.base.EntityImmaterial;
import xol.lostinfinity.util.PotionBasic;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.fx.IParticleSpawner;
import xol.lostinfinity.util.math.LMath;

public class ItemDuskOfEternity
extends SwordItem
implements IMaxAttack,
IHitReactive,
IPotionReactive,
ISwitchModels,
IModeSelect {
    private static final String MODE_DATA = "mode_data";
    private static final int HEX_MODE = 0;
    private static final float HEX_HIT_DAMAGE = 0.5f;
    private static final int SEN_MODE = 1;
    private static final float SEN_HIT_DAMAGE = 0.75f;
    private static final float SEN_SWEEP_ANGLE = 120.0f;
    private static final float SEN_SWEEP_RANGE = 10.0f;
    private static final float SEN_SWEEP_VELOCITY = 5.0f;
    private static final float SEN_SWEEP_DAMAGE = 0.33f;

    public ItemDuskOfEternity(String regName) {
        super(Item.ToolMaterial.DIAMOND);
        this.func_77637_a(TabsInit.TAB_AUXWEP);
        this.setRegistryName(regName);
        this.func_77655_b(regName);
        ItemInit.ITEMS.add((Item)this);
        this.setModelSwitch("mode", (Item)this, 2);
    }

    public boolean func_77644_a(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (!this.isPaired(attacker, InteractionHand.OFF_HAND)) {
            return true;
        }
        switch (this.getMode(stack)) {
            case 0: {
                IMaxAttack.dealTrueDamage((Entity)attacker, target, target.func_110138_aP() * 0.5f);
                for (PotionEffect effect : attacker.func_70651_bq()) {
                    Potion potion = effect.func_188419_a();
                    if (!this.isBadPotion(potion)) continue;
                    target.func_70690_d(new PotionEffect(potion, effect.func_76459_b(), effect.func_76458_c(), effect.func_82720_e(), effect.func_188418_e()));
                }
                break;
            }
            case 1: {
                IMaxAttack.dealTrueDamage((Entity)attacker, target, target.func_110138_aP() * 0.75f);
                float yaw = attacker.field_70177_z;
                Vec3 attackerPos = attacker.func_174791_d();
                for (Entity entity : attacker.field_70170_p.func_72872_a(Entity.class, attacker.func_174813_aQ().func_72314_b(10.0, 5.0, 10.0))) {
                    float angle;
                    float dif;
                    Vec3 dir;
                    if (entity == attacker || entity == target || !(entity instanceof LivingEntity) || entity instanceof EntityImmaterial || (dir = entity.func_174791_d().func_178788_d(attackerPos)).func_189985_c() > 100.0 || (dif = Mth.func_76135_e((float)LMath.degreeDifference(yaw, angle = (float)(Mth.func_181159_b((double)(-dir.field_72450_a), (double)dir.field_72449_c) * (double)57.29578f)))) > 60.0f) continue;
                    Vec3 loc = entity.func_174791_d();
                    CustomParticleConfig config = new CustomParticleConfig();
                    config.createInstance().setParticle(ParticleInit.GRAVITY_RING).setSpread(1.5, 1.5, 1.5).setIgnoreRange(true);
                    IParticleSpawner.spawnParticle(entity.field_70170_p, config, loc);
                    IMaxAttack.dealTrueDamage((Entity)attacker, (LivingEntity)entity, ((LivingEntity)entity).func_110138_aP() * 0.33f);
                    dir = LMath.fastNormalize(dir).func_186678_a(5.0);
                    entity.func_70024_g(dir.field_72450_a, dir.field_72448_b, dir.field_72449_c);
                    entity.field_70133_I = true;
                }
                break;
            }
        }
        ItemStack other = attacker.func_184592_cb();
        attacker.func_184611_a(InteractionHand.MAIN_HAND, other);
        attacker.func_184611_a(InteractionHand.OFF_HAND, stack);
        return true;
    }

    @Override
    public void hitReaction(Player player, Entity attacker, float damage, ItemStack stack) {
        if (player.field_70170_p.field_72995_K) {
            return;
        }
        if (player.func_184586_b(InteractionHand.OFF_HAND) != stack) {
            return;
        }
        if (this.getMode(stack) != 1) {
            return;
        }
        if (!this.isPaired((LivingEntity)player, InteractionHand.MAIN_HAND)) {
            return;
        }
        for (Entity entity : player.field_70170_p.func_72872_a(Entity.class, player.func_174813_aQ().func_72314_b(10.0, 5.0, 10.0))) {
            if (!this.isProjectile(entity) || entity == attacker) continue;
            entity.func_70106_y();
            Vec3 loc = entity.func_174791_d();
            CustomParticleConfig config = new CustomParticleConfig();
            config.createInstance().setParticle(ParticleInit.GRAVITY_RING).setIgnoreRange(true);
            IParticleSpawner.spawnParticle(entity.field_70170_p, config, loc);
        }
    }

    @Override
    public void potionAddReaction(Player player, ItemStack stack, InteractionHand hand, PotionEffect newEffect, PotionEffect prevEffect) {
        if (hand != InteractionHand.OFF_HAND) {
            return;
        }
        if (this.getMode(stack) != 0) {
            return;
        }
        if (!this.isPaired((LivingEntity)player, InteractionHand.MAIN_HAND)) {
            return;
        }
        Potion newPotion = newEffect.func_188419_a();
        if (!this.isBadPotion(newPotion)) {
            return;
        }
        ArrayList<Potion> removed = new ArrayList<Potion>();
        for (PotionEffect effect : player.func_70651_bq()) {
            Potion potion = effect.func_188419_a();
            if (!this.isBadPotion(potion)) continue;
            removed.add(potion);
        }
        if (!removed.isEmpty()) {
            player.func_184589_d((Potion)removed.get(player.field_70170_p.field_73012_v.nextInt(removed.size())));
        }
    }

    @Override
    public void modeUpdate(ItemStack stack, Player player) {
        this.toggleMode(stack);
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add("Twin sword of the " + (Object)((Object)TextFmt.Light_Purple) + "Dawn of Eternity" + (Object)((Object)TextFmt.Reset) + ".");
        PlayerSP player = Minecraft.func_71410_x().field_71439_g;
        if (player != null) {
            if (player.func_184586_b(InteractionHand.MAIN_HAND) == stack && this.isPaired((LivingEntity)player, InteractionHand.OFF_HAND) || player.func_184586_b(InteractionHand.OFF_HAND) == stack && this.isPaired((LivingEntity)player, InteractionHand.MAIN_HAND)) {
                tooltip.add(TextFmt.getFormatting(TextFmt.Dark_Purple, TextFmt.Bold) + "You can feel their power resonating!");
            } else {
                tooltip.add((Object)((Object)TextFmt.Dark_Gray) + "Without its twins, the sword feels strangely heavier...");
            }
        }
        switch (this.getMode(stack)) {
            case 0: {
                tooltip.add((Object)((Object)TextFmt.Light_Purple) + "Current mode: Hexcorum");
                tooltip.add((Object)((Object)TextFmt.Red) + "Main hand: Copy all negative effects to your target.");
                tooltip.add((Object)((Object)TextFmt.Red) + "50% Health True Damage");
                tooltip.add((Object)((Object)TextFmt.Blue) + "Off hand: When receiving a negative effect, cleanse a random negative effect you have.");
                break;
            }
            case 1: {
                tooltip.add((Object)((Object)TextFmt.Gold) + "Current mode: Sentinum");
                tooltip.add((Object)((Object)TextFmt.Red) + "Main hand: Send a shockwave behind your target and blast anything away.");
                tooltip.add((Object)((Object)TextFmt.Red) + "75% Health True Damage To Target, 33% Health True Damage Shockwave");
                tooltip.add((Object)((Object)TextFmt.Blue) + "Off hand: When damaged, destroy all nearby projectiles.");
            }
        }
    }

    private void toggleMode(ItemStack stack) {
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
        }
        CompoundTag compound = stack.func_77978_p();
        compound.func_74768_a(MODE_DATA, (compound.func_74762_e(MODE_DATA) + 1) % 2);
    }

    private int getMode(ItemStack stack) {
        if (!stack.func_77942_o()) {
            stack.func_77982_d(new CompoundTag());
        }
        return stack.func_77978_p().func_74762_e(MODE_DATA);
    }

    private boolean isBadPotion(Potion potion) {
        return potion.func_76398_f() || potion instanceof PotionBasic && ((PotionBasic)potion).negativeLostEffect();
    }

    private boolean isProjectile(Entity entity) {
        return entity instanceof EntityThrowable || entity instanceof EntityArrow || entity instanceof EntityFireball || entity instanceof EntityShulkerBullet;
    }

    private boolean isPaired(LivingEntity player, InteractionHand other) {
        return player.func_184586_b(other).func_77973_b() instanceof ItemDawnOfEternity;
    }
}

