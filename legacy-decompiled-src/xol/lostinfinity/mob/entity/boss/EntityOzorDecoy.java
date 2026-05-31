/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.monster.Monster
 *  net.minecraft.entity.player.Player
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.boss;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.boss.EntityOzor;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class EntityOzorDecoy
extends Monster
implements IMaxAttack {
    private float ozorAlpha = 0.0f;
    private float growAlphaSpeed = 0.05f * (float)(1 + this.field_70146_Z.nextInt(9));
    private int fadeTimer = 30;
    private static final DataParameter<Boolean> FADING = EntityDataManager.func_187226_a(EntityOzor.class, (DataSerializer)DataSerializers.field_187198_h);

    public EntityOzorDecoy(Level worldIn) {
        super(worldIn);
        this.func_70105_a(7.5f, 7.5f);
    }

    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a(FADING, (Object)false);
    }

    public boolean getFading() {
        return (Boolean)this.field_70180_af.func_187225_a(FADING);
    }

    public void setFading(boolean fade) {
        this.field_70180_af.func_187227_b(FADING, (Object)fade);
    }

    public void func_70014_b(CompoundTag tag) {
        super.func_70014_b(tag);
        tag.func_74757_a("FadingStage", this.getFading());
    }

    public void func_70037_a(CompoundTag tag) {
        super.func_70037_a(tag);
        this.setFading(tag.func_74767_n("FadingStage"));
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.32);
        this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(15000.0);
    }

    public float getAlpha() {
        return this.ozorAlpha;
    }

    private AABB getArenaAABB() {
        return new AABB(new BlockPos(-3.0, 60.0, -149.0), new BlockPos(52.0, 85.0, -36.0));
    }

    public void func_70636_d() {
        super.func_70636_d();
        this.field_70143_R = -1.0f;
        if (this.field_70170_p.field_72995_K) {
            boolean fading = this.getFading();
            if (!fading) {
                if (this.ozorAlpha < 1.0f) {
                    this.ozorAlpha += this.growAlphaSpeed;
                }
            } else if (this.ozorAlpha > 0.0f) {
                this.ozorAlpha = (float)((double)this.ozorAlpha - 0.05);
            }
        } else if (this.getFading()) {
            if (this.fadeTimer == 0) {
                this.func_70106_y();
            }
            --this.fadeTimer;
        }
    }

    public void func_70645_a(DamageSource cause) {
        if (!this.field_70170_p.field_72995_K) {
            CustomParticleConfig config1 = new CustomParticleConfig();
            config1.createInstance().setParticle(ParticleInit.EXPLOSION_RING).setSpread(2.0, 1.0, 2.0).setCount(3).setIgnoreRange(true);
            IParticleSpawner.spawnParticle(this.field_70170_p, config1, this.field_70165_t, this.field_70163_u, this.field_70161_v);
            this.func_184185_a(SoundInit.GENERIC_STYLE3_DEATH, 1.0f, 0.8f + 0.4f * this.field_70146_Z.nextFloat());
            for (Player target : this.field_70170_p.func_72872_a(Player.class, this.getArenaAABB())) {
                IMaxAttack.dealMaxHealth((Entity)this, (LivingEntity)target, 3, 2.0f);
                target.func_145747_a((Component)new Component((Object)((Object)TextFmt.Yellow) + "The decoy releases a toxic fume into the air."));
            }
        }
    }

    protected SoundEvent func_184615_bR() {
        return null;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return null;
    }

    protected SoundEvent func_184639_G() {
        return null;
    }

    protected void messagePlayers(String message) {
        for (Player contender : this.field_70170_p.func_72872_a(Player.class, this.getArenaAABB())) {
            contender.func_145747_a((Component)new Component(message));
        }
    }

    protected void soundPlayers(SoundEvent sound, float vol) {
        for (Player contender : this.field_70170_p.func_72872_a(Player.class, this.getArenaAABB())) {
            this.field_70170_p.func_184133_a(null, contender.func_180425_c(), sound, SoundSource.MASTER, vol, 0.9f + this.field_70146_Z.nextFloat() * 0.2f);
        }
    }

    protected boolean func_70692_ba() {
        return false;
    }

    public boolean func_70814_o() {
        return true;
    }
}

