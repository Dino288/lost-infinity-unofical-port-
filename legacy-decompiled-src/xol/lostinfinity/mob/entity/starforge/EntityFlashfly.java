/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.player.Player
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.starforge;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.ai.EntityAIFloatAttack;
import xol.lostinfinity.mob.entity.base.EntityFloatingBase;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class EntityFlashfly
extends EntityFloatingBase
implements IMaxAttack {
    public EntityFlashfly(Level worldIn) {
        super(worldIn);
        this.func_70105_a(1.25f, 1.0f);
    }

    @Override
    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(300.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.0);
        this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a(1.0);
    }

    protected SoundEvent func_184615_bR() {
        return SoundInit.NIGHTSHYRE_DEATH;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundInit.NIGHTSHYRE_HURT;
    }

    protected SoundEvent func_184639_G() {
        return SoundInit.NIGHTSHYRE_AMBIENT;
    }

    @Override
    public void func_70636_d() {
        super.func_70636_d();
        for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.func_174813_aQ().func_72314_b(15.0, 15.0, 15.0))) {
            if (near_pl.func_184614_ca().func_77973_b() != ItemInit.beaconOfLight) continue;
            this.func_70605_aq().func_75642_a(near_pl.field_70165_t, near_pl.field_70163_u, near_pl.field_70161_v, 1.0);
            break;
        }
    }

    public void func_70645_a(DamageSource cause) {
        if (!this.field_70170_p.field_72995_K) {
            Iterable nearblocks = BlockPos.func_177980_a((BlockPos)this.func_180425_c().func_177982_a(-3, -3, -3), (BlockPos)this.func_180425_c().func_177982_a(3, 3, 3));
            for (BlockPos pos : nearblocks) {
                if (this.field_70170_p.func_180495_p(pos).func_177230_c() != BlockInit.incandesciteOre) continue;
                this.field_70170_p.func_175656_a(pos, BlockInit.incandesciteOre.func_176203_a(1));
            }
            this.func_184185_a(SoundInit.GLOW_BOMB, 1.0f, 1.0f);
            CustomParticleConfig config1 = new CustomParticleConfig();
            config1.createInstance().setParticle(ParticleInit.LIGHT_FLASH).setSpread(4.0, 1.0, 4.0).setCount(10).setIgnoreRange(true);
            IParticleSpawner.spawnParticle(this.field_70170_p, config1, this.field_70165_t, this.field_70163_u + (double)(this.field_70131_O / 2.0f), this.field_70161_v);
        }
    }

    @Override
    protected EntityAIFloatAttack createShootAI() {
        return null;
    }
}

