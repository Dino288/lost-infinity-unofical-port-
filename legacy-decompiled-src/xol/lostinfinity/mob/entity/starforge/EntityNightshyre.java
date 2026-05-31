/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.EnumDifficulty
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.starforge;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.ai.EntityAIFloatAttack;
import xol.lostinfinity.mob.entity.base.EntityFloatingBase;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class EntityNightshyre
extends EntityFloatingBase
implements IMaxAttack {
    public EntityNightshyre(Level worldIn) {
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

    protected boolean func_70692_ba() {
        return false;
    }

    @Override
    public void func_70636_d() {
        super.func_70636_d();
        if (!(this.field_70170_p.field_72995_K && this.field_70173_aa % 5 == 0 || this.field_70170_p.field_72995_K || this.field_70173_aa % 20 != 0)) {
            Iterable nearblocks = BlockPos.func_177980_a((BlockPos)this.func_180425_c().func_177982_a(-4, -4, -4), (BlockPos)this.func_180425_c().func_177982_a(4, 4, 4));
            boolean darkened = false;
            for (BlockPos pos : nearblocks) {
                if (this.field_70170_p.func_180495_p(pos).func_177230_c() != BlockInit.myriteOre) continue;
                this.field_70170_p.func_175656_a(pos, BlockInit.myriteOreDark.func_176223_P());
                darkened = true;
            }
            if (darkened) {
                this.func_184185_a(SoundInit.NIGHTSHYRE_DARKEN, 1.0f, 1.0f);
                CustomParticleConfig config1 = new CustomParticleConfig();
                config1.createInstance().setParticle(ParticleInit.DARK_FLASH).setSpread(4.0, 1.0, 4.0).setCount(10).setIgnoreRange(true);
                IParticleSpawner.spawnParticle(this.field_70170_p, config1, this.field_70165_t, this.field_70163_u + (double)(this.field_70131_O / 2.0f), this.field_70161_v);
            }
        }
    }

    public int func_70641_bl() {
        return 1;
    }

    @Override
    public boolean func_70601_bi() {
        return this.field_70170_p.func_175659_aa() != EnumDifficulty.PEACEFUL;
    }

    @Override
    protected EntityAIFloatAttack createShootAI() {
        return null;
    }
}

