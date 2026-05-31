/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.util.EnumParticleTypes
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.Mth
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.cthulhu;

import net.minecraft.world.entity.Entity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.cthulhu.AbstractCthulhuMinion;
import xol.lostinfinity.mob.entity.cthulhu.EntityCthulhu;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class EntityCthulhuHealingOrb
extends AbstractCthulhuMinion {
    private final int healDelayOffset;
    private int orbitAngle;

    public EntityCthulhuHealingOrb(Level worldIn) {
        this(worldIn, null);
    }

    public EntityCthulhuHealingOrb(Level worldIn, EntityCthulhu owner) {
        super(worldIn);
        this.owner = owner;
        this.healDelayOffset = this.field_70146_Z.nextInt(100) + 1;
        this.func_189654_d(true);
        this.func_94061_f(true);
        this.orbitAngle = this.field_70146_Z.nextInt(360) + 1;
        this.func_70105_a(3.0f, 3.0f);
    }

    @Override
    protected void func_184651_r() {
    }

    @Override
    protected int numberOfLives() {
        return 3;
    }

    public void func_70636_d() {
        super.func_70636_d();
        if (this.owner == null) {
            return;
        }
        this.updatePos();
        if (this.field_70173_aa >= 400 + this.healDelayOffset) {
            if (this.healOwner()) {
                this.func_70106_y();
            } else {
                this.field_70173_aa = 0;
            }
        }
    }

    private boolean healOwner() {
        int phase = this.owner.getPhase();
        float maxHealth = this.owner.func_110138_aP();
        float currentHealth = this.owner.func_110143_aJ();
        this.owner.func_70691_i(maxHealth - currentHealth);
        int healRange = this.owner.numberOfLives() / 50;
        switch (phase) {
            case 1: {
                int livesToHeal;
                if (this.owner.remainingLives() < this.owner.numberOfLives()) {
                    livesToHeal = Math.min(healRange, this.owner.numberOfLives() - this.owner.remainingLives());
                    this.owner.setLivesCount(this.owner.getLivesCount() - livesToHeal);
                    break;
                }
                return false;
            }
            case 2: {
                int livesToHeal;
                if ((double)((float)this.owner.remainingLives() / (float)this.owner.numberOfLives()) < 0.6666) {
                    livesToHeal = (int)Math.min((double)healRange, (double)this.owner.numberOfLives() * 0.6666 - (double)this.owner.remainingLives());
                    this.owner.setLivesCount(this.owner.getLivesCount() - livesToHeal);
                    break;
                }
                return false;
            }
            case 3: {
                int livesToHeal;
                if ((double)((float)this.owner.remainingLives() / (float)this.owner.numberOfLives()) < 0.3333) {
                    livesToHeal = (int)Math.min((double)healRange, (double)this.owner.numberOfLives() * 0.3333 - (double)this.owner.remainingLives());
                    this.owner.setLivesCount(this.owner.getLivesCount() - livesToHeal);
                    break;
                }
                return false;
            }
        }
        CustomParticleConfig config = new CustomParticleConfig();
        config.createInstance().setParticle(EnumParticleTypes.HEART).setCount(5).setSpread(0.5, 0.5, 0.5).setIgnoreRange(true);
        for (int i = 0; i < 20; ++i) {
            double x = this.field_70165_t + (this.owner.field_70165_t - this.field_70165_t) * ((double)i / 20.0);
            double y = this.field_70163_u + (this.owner.field_70163_u + (double)(this.owner.func_70047_e() / 2.0f) - this.field_70163_u) * ((double)i / 20.0);
            double z = this.field_70161_v + (this.owner.field_70161_v - this.field_70161_v) * ((double)i / 20.0);
            IParticleSpawner.spawnParticle(this.field_70170_p, config, x, y, z);
        }
        this.field_70170_p.func_184133_a(null, this.func_180425_c(), SoundInit.LIFEVESSEL_HEAL, SoundSource.PLAYERS, 1.0f, 1.0f);
        return true;
    }

    public void updatePos() {
        double x = this.owner.field_70165_t + (double)(Mth.func_76134_b((float)((float)this.orbitAngle * ((float)Math.PI / 180))) * 36.0f);
        double y = this.owner.field_70163_u + (double)this.owner.func_70047_e();
        double z = this.owner.field_70161_v + (double)(Mth.func_76126_a((float)((float)this.orbitAngle * ((float)Math.PI / 180))) * 36.0f);
        this.func_70634_a(x, y, z);
        this.field_70759_as = 0.0f;
        this.field_70761_aq = 0.0f;
        this.orbitAngle = (this.orbitAngle + 1) % 360;
    }

    public int getOrbitAngle() {
        return this.orbitAngle;
    }

    @Override
    public void func_70014_b(CompoundTag tag) {
        super.func_70014_b(tag);
        tag.func_74768_a("orbitAngle", this.orbitAngle);
        this.write(tag);
    }

    @Override
    public void func_70037_a(CompoundTag tag) {
        super.func_70037_a(tag);
        this.orbitAngle = tag.func_74762_e("orbitAngle");
        this.read(tag, (Entity)this);
    }
}

