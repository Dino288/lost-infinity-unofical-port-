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
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.Mth
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.item.weapon;

import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemChanneling;
import xol.lostinfinity.item.classify.IMovingSoundSource;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.CustomHitResult;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.data.RayTraceBuilder;
import xol.lostinfinity.util.fx.IParticleSpawner;
import xol.lostinfinity.util.math.LMath;

public class ItemEtherealGrasp
extends ItemChanneling
implements IMaxAttack,
IMovingSoundSource {
    private static final float PULL_STRENGTH = 0.5f;

    public ItemEtherealGrasp(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_AUXWEP);
    }

    @Override
    public void chargeTick(Level worldIn, Player player, InteractionHand hand, ItemStack stack, int chargeTime) {
        CustomHitResult result;
        if (worldIn.field_72995_K) {
            return;
        }
        if (chargeTime % 30 == 0) {
            worldIn.func_184133_a(null, player.func_180425_c(), SoundInit.GENERIC_WEAPON_12, SoundSource.PLAYERS, 0.7f, 0.5f);
        }
        if ((result = RayTraceBuilder.entity(Entity.class, 75).raySize(1.5f).trace((Entity)player, true)) == null) {
            return;
        }
        for (Entity entity : result.getResultEntities()) {
            Vec3 playerEye;
            if (chargeTime % 10 == 0 && entity instanceof LivingEntity) {
                int denom = Math.max(1, 8 - Mth.func_76141_d((float)chargeTime) / 60);
                IMaxAttack.dealMaxHealth((Entity)player, (LivingEntity)entity, 6, Arrays.asList("Aquatic"));
            }
            float holdDistance = entity.field_70130_N * entity.field_70130_N * 2.25f;
            Vec3 entityMiddle = entity.func_174791_d().func_72441_c(0.0, (double)(entity.field_70131_O / 2.0f), 0.0);
            Vec3 dir = entityMiddle.func_178788_d(playerEye = player.func_174824_e(1.0f));
            if (dir.func_189985_c() > (double)holdDistance) {
                dir = LMath.fastNormalize(dir).func_186678_a(0.5);
                entity.field_70159_w = -dir.field_72450_a;
                entity.field_70181_x = -dir.field_72448_b;
                entity.field_70179_y = -dir.field_72449_c;
            } else {
                entity.field_70159_w = 0.0;
                entity.field_70181_x = 0.0;
                entity.field_70179_y = 0.0;
            }
            entity.field_70133_I = true;
            if (chargeTime % 5 != 0) continue;
            CustomParticleConfig config = new CustomParticleConfig();
            config.createInstance().setParticle(ParticleInit.GRASP).setIgnoreRange(true);
            IParticleSpawner.spawnParticle(worldIn, config, entityMiddle);
        }
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Aqua) + "Can be channelled to pull all entities where you are looking.");
        tooltip.add((Object)((Object)TextFmt.Gold) + "Channeling can last forever.");
        tooltip.add((Object)((Object)TextFmt.Red) + "Deals 12.5%-100% Max Health Damage twice per second.");
        tooltip.add((Object)((Object)TextFmt.Italic) + "Damage ramps up the longer you channel.");
        tooltip.add((Object)((Object)TextFmt.Aqua) + "Aquatic");
    }
}

