/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.player.Player
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

import java.util.Iterator;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.ai.EntityAIFloatAttack;
import xol.lostinfinity.mob.entity.base.EntityFloatingBase;
import xol.lostinfinity.projectile.entity.EntityCryoBeamEffect;
import xol.lostinfinity.projectile.entity.EntityCryoBolt;
import xol.lostinfinity.stone.EntityInfinityStone;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityCryonus
extends EntityFloatingBase
implements IMaxAttack {
    private int phase;
    private int nextFormTimer = 200;
    EntityCryoBeamEffect beam = null;
    EntityCryoBeamEffect blast = null;
    private boolean givenFrozenMessage = false;

    public EntityCryonus(Level worldIn) {
        super(worldIn);
        this.func_70105_a(2.0f, 7.0f);
        this.rawFlySpeed = 0.95f;
    }

    @Override
    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.32);
        this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(15000.0);
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null) {
            IMaxAttack.dealMaxHealth((Entity)this, this.func_70638_az(), 2);
            return true;
        }
        return false;
    }

    private AABB getArenaAABB() {
        return new AABB(new BlockPos(-3.0, 60.0, -149.0), new BlockPos(52.0, 85.0, -36.0));
    }

    @Override
    public void func_70636_d() {
        super.func_70636_d();
        this.field_70143_R = -1.0f;
        if (this.getLivesCount() >= this.numberOfLives() / 2) {
            this.freeze();
        }
        if (!this.field_70170_p.field_72995_K) {
            if (this.phase == 0) {
                this.shoot();
            } else if (this.phase == 1) {
                if (this.beam == null) {
                    this.cryoBeam();
                    this.soundPlayers(SoundInit.CRYONUS_ICEBEAM, 1.0f);
                } else if (this.field_70173_aa % 50 == 0) {
                    this.soundPlayers(SoundInit.CRYONUS_ICEBEAM, 1.0f);
                }
            } else if (this.phase == 2) {
                this.iceSmash();
            }
            this.updatePhase(this.phase);
        }
    }

    private void freeze() {
        AABB arena = this.getArenaAABB();
        if (this.field_70170_p.field_72995_K) {
            for (int i = 0; i < 10; ++i) {
                double randX = this.field_70170_p.field_73012_v.nextDouble() * (arena.field_72336_d - arena.field_72340_a) + arena.field_72340_a;
                double randY = this.field_70170_p.field_73012_v.nextDouble() * (arena.field_72337_e - arena.field_72338_b) + arena.field_72338_b;
                double randZ = this.field_70170_p.field_73012_v.nextDouble() * (arena.field_72334_f - arena.field_72339_c) + arena.field_72339_c;
                this.field_70170_p.func_175688_a(ParticleInit.SNOW_BUBBLE, randX, randY, randZ, 0.0, 0.0, 0.0, new int[0]);
            }
        } else {
            if (!this.givenFrozenMessage) {
                this.soundPlayers(SoundInit.WIND_GUST, 1.0f);
                this.messagePlayers((Object)((Object)TextFmt.Aqua) + "Cryonus: The world freezes... I am the only warmth.");
                this.givenFrozenMessage = true;
            }
            for (Player contender : this.field_70170_p.func_72872_a(Player.class, this.getArenaAABB())) {
                double dist = Math.sqrt((this.field_70165_t - contender.field_70165_t) * (this.field_70165_t - contender.field_70165_t) + (this.field_70161_v - contender.field_70161_v) * (this.field_70161_v - contender.field_70161_v));
                if (contender.func_184812_l_() || this.field_70173_aa % 20 != 0) continue;
                if (dist > 20.0) {
                    dist = 20.0;
                }
                int denom = (int)(40.0 / dist);
                IMaxAttack.dealMaxHealth((Entity)this, (LivingEntity)contender, denom);
            }
        }
    }

    private void cryoBeam() {
        Player target = null;
        Iterator iterator = this.field_70170_p.func_72872_a(Player.class, this.getArenaAABB()).iterator();
        if (iterator.hasNext()) {
            Player contender;
            target = contender = (Player)iterator.next();
        }
        if (target != null) {
            this.beam = new EntityCryoBeamEffect(this.field_70170_p);
            this.beam.setOwner(this);
            this.beam.setTarget(target);
            this.beam.func_70107_b(this.field_70165_t, this.field_70163_u + (double)(this.field_70131_O / 2.0f), this.field_70161_v);
            this.field_70170_p.func_72838_d((Entity)this.beam);
        }
    }

    private void iceSmash() {
        if (this.blast == null || this.blast.getGrowth() > 20.2f) {
            Player target = null;
            Iterator iterator = this.field_70170_p.func_72872_a(Player.class, this.getArenaAABB()).iterator();
            if (iterator.hasNext()) {
                Player contender;
                target = contender = (Player)iterator.next();
            }
            this.blast = new EntityCryoBeamEffect(this.field_70170_p);
            this.blast.setIceBlast(true);
            this.blast.setOwner(this);
            this.blast.setTarget(target);
            this.blast.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
            this.field_70170_p.func_72838_d((Entity)this.blast);
            this.soundPlayers(SoundInit.CRYONUS_RINGS, 0.7f);
        }
    }

    private void updatePhase(int phase) {
        --this.nextFormTimer;
        if (this.nextFormTimer == 0) {
            this.nextFormTimer = 200;
            if (this.beam != null) {
                this.beam.func_70106_y();
                this.beam = null;
            }
            if (this.blast != null) {
                this.blast.func_70106_y();
                this.blast = null;
            }
            this.phase = phase < 2 ? ++this.phase : 0;
        }
    }

    private void shoot() {
        Player near_pl;
        boolean fired = false;
        Iterator iterator = this.field_70170_p.func_72872_a(Player.class, this.getArenaAABB()).iterator();
        if (iterator.hasNext() && !(near_pl = (Player)iterator.next()).func_184812_l_() && this.field_70173_aa % 10 == 0) {
            fired = true;
            double makeX = (this.func_174813_aQ().field_72340_a + this.func_174813_aQ().field_72336_d) / 2.0;
            double makeY = this.field_70163_u + (double)(this.field_70131_O / 2.0f) + 0.5;
            double makeZ = (this.func_174813_aQ().field_72339_c + this.func_174813_aQ().field_72334_f) / 2.0;
            double d2 = near_pl.field_70165_t - makeX;
            double d3 = near_pl.field_70163_u - makeY;
            double d4 = near_pl.field_70161_v - makeZ;
            EntityCryoBolt shot = new EntityCryoBolt(this.field_70170_p, (LivingEntity)this);
            float speed = 3.0f;
            shot.func_70186_c(d2, d3, d4, speed, 0.0f);
            shot.setThrower((LivingEntity)this);
            this.field_70170_p.func_72838_d((Entity)shot);
        }
        if (fired) {
            SoundEvent wepSound = SoundInit.MAGIC_WEAPON_1;
            this.soundPlayers(wepSound, 0.25f);
        }
    }

    protected SoundEvent func_184615_bR() {
        return SoundInit.CRYONUS_DEATH;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundInit.CRYONUS_HURT;
    }

    protected SoundEvent func_184639_G() {
        return SoundInit.CRYONUS_AMBIENT;
    }

    @Override
    protected int numberOfLives() {
        return 200;
    }

    @Override
    protected void updateLifeAction() {
        int lifePercent = Math.round(100 * (this.numberOfLives() - this.getLivesCount()) / this.numberOfLives());
        this.messagePlayers((Object)((Object)TextFmt.Gold) + "Cryonus is at " + lifePercent + "% health.");
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

    @Override
    public void trueDeathAction() {
        if (!this.field_70170_p.field_72995_K) {
            if (this.beam != null) {
                this.beam.func_70106_y();
            }
            if (this.blast != null) {
                this.blast.func_70106_y();
            }
            EntityInfinityStone stone = new EntityInfinityStone(this.field_70170_p);
            stone.setStoneNum((byte)13);
            stone.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
            this.field_70170_p.func_72838_d((Entity)stone);
            this.func_145779_a(ItemInit.arenaCard, 1);
        }
    }

    protected boolean func_70692_ba() {
        return false;
    }

    @Override
    protected EntityAIFloatAttack createShootAI() {
        return null;
    }
}

