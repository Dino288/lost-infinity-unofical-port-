/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.entity.Entity
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

import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.entity.Entity;
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
import xol.lostinfinity.mob.entity.misc.EntityRisingPhantom;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class ItemRiseOfPhantoms
extends ItemChanneling {
    private static final float MIN_VELOCITY = 0.1f;
    private static final float MAX_VELOCITY = 0.5f;
    private static final float MIN_DAMAGE = 0.0f;
    private static final float MAX_DAMAGE = 10.0f;

    public ItemRiseOfPhantoms(String regName) {
        super(regName);
        this.func_77637_a(TabsInit.TAB_AUXWEP);
    }

    @Override
    public void chargeTick(Level worldIn, Player player, InteractionHand hand, ItemStack stack, int chargeTime) {
        if (worldIn.field_72995_K) {
            return;
        }
        float chance = this.spawnChance(chargeTime);
        if (chargeTime % 2 == 0 && worldIn.field_73012_v.nextFloat() <= chance) {
            int spawnX = -10 + worldIn.field_73012_v.nextInt(21) + (int)player.field_70165_t;
            int spawnZ = -10 + worldIn.field_73012_v.nextInt(21) + (int)player.field_70161_v;
            double spawnY = (player.field_70122_E ? (double)worldIn.func_189649_b(spawnX, spawnZ) : player.field_70163_u) - 1.0;
            EntityRisingPhantom phantom = new EntityRisingPhantom(worldIn, player);
            Vec3 loc = new Vec3((double)spawnX + 0.5, spawnY, (double)spawnZ + 0.5);
            phantom.func_70080_a(loc.field_72450_a, loc.field_72448_b - (double)phantom.field_70131_O, loc.field_72449_c, worldIn.field_73012_v.nextFloat() * 360.0f, 0.0f);
            phantom.setVelocity((float)Mth.func_151238_b((double)0.1f, (double)Mth.func_151238_b((double)0.1f, (double)0.5, (double)chance), (double)worldIn.field_73012_v.nextFloat()));
            phantom.setLivesTaken(Mth.func_76128_c((double)Mth.func_151238_b((double)0.0, (double)10.0, (double)chance)));
            worldIn.func_72838_d((Entity)phantom);
            CustomParticleConfig config = new CustomParticleConfig();
            config.createInstance().setParticle(worldIn.field_73012_v.nextBoolean() ? ParticleInit.NIGHTMARE_MAGIC : ParticleInit.GLOOM_SPELL).setCount(3).setSpread(4.0, 2.0, 4.0).setIgnoreRange(true);
            IParticleSpawner.spawnParticle(worldIn, config, loc.field_72450_a, loc.field_72448_b + 1.0, loc.field_72449_c);
            switch (worldIn.field_73012_v.nextInt(5)) {
                case 0: {
                    worldIn.func_184133_a(null, phantom.func_180425_c(), SoundInit.WHISPER_1, SoundSource.PLAYERS, 0.25f, 0.8f + worldIn.field_73012_v.nextFloat() * 0.4f);
                    break;
                }
                case 1: {
                    worldIn.func_184133_a(null, phantom.func_180425_c(), SoundInit.WHISPER_2, SoundSource.PLAYERS, 0.25f, 0.8f + worldIn.field_73012_v.nextFloat() * 0.4f);
                    break;
                }
                case 2: {
                    worldIn.func_184133_a(null, phantom.func_180425_c(), SoundInit.WHISPER_3, SoundSource.PLAYERS, 0.25f, 0.8f + worldIn.field_73012_v.nextFloat() * 0.4f);
                    break;
                }
                case 3: {
                    worldIn.func_184133_a(null, phantom.func_180425_c(), SoundInit.WHISPER_4, SoundSource.PLAYERS, 0.25f, 0.8f + worldIn.field_73012_v.nextFloat() * 0.4f);
                    break;
                }
                case 4: {
                    worldIn.func_184133_a(null, phantom.func_180425_c(), SoundInit.WHISPER_5, SoundSource.PLAYERS, 0.25f, 0.8f + worldIn.field_73012_v.nextFloat() * 0.4f);
                }
            }
        }
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Light_Purple) + "Raises phantoms around you.");
        tooltip.add((Object)((Object)TextFmt.Gold) + "The longer you channel, the more phantoms that spawn.");
        tooltip.add((Object)((Object)TextFmt.Red) + "Phantoms deal 150% Health True Damage.");
        tooltip.add((Object)((Object)TextFmt.Italic) + "Phantoms take an extra lives off of multi-life creatures.");
        tooltip.add((Object)((Object)TextFmt.Red) + "The longer you channel, the more lives phantoms take (max 10).");
        tooltip.add((Object)((Object)TextFmt.Dark_Aqua) + "Darkborn");
    }

    private float spawnChance(int chargeTime) {
        return Math.min(1.0f, (float)chargeTime / 200.0f);
    }
}

