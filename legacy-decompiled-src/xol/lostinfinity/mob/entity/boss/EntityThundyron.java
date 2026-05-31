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
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.base.EntityMultipleLives;
import xol.lostinfinity.mob.entity.misc.EntityThunderBomb;
import xol.lostinfinity.stone.EntityInfinityStone;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityThundyron
extends EntityMultipleLives
implements IMaxAttack {
    private int thunderOrb = 0;
    private float thunderAlph = 0.0f;
    private boolean amAttackingNext = false;
    private BlockPos goalPos = null;
    private int graceHit = 0;

    public EntityThundyron(Level worldIn) {
        super(worldIn);
        this.func_70105_a(3.5f, 6.0f);
        this.func_189654_d(true);
    }

    @Override
    protected void func_184651_r() {
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.32);
        this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(5000.0);
    }

    protected void func_82167_n(Entity entityIn) {
        Player play;
        if (entityIn instanceof Player && !(play = (Player)entityIn).func_184812_l_() && this.graceHit == 0) {
            IMaxAttack.dealMaxHealth((Entity)this, (LivingEntity)play, 3);
            this.graceHit = 10;
            this.field_70170_p.func_184133_a(null, play.func_180425_c(), SoundInit.ELECTRIC_SHOCK, SoundSource.HOSTILE, 0.75f, 0.75f + 0.5f * this.field_70146_Z.nextFloat());
        }
        entityIn.func_70108_f((Entity)this);
    }

    private AABB getArenaAABB() {
        return new AABB(new BlockPos(-3.0, 60.0, -149.0), new BlockPos(52.0, 85.0, -36.0));
    }

    public void func_70636_d() {
        super.func_70636_d();
        this.field_70143_R = -1.0f;
        if (!this.field_70170_p.field_72995_K) {
            boolean lowHealth;
            if (this.graceHit > 0) {
                --this.graceHit;
            }
            if (this.field_70173_aa % 80 == 0) {
                this.findNewMove();
            } else if (this.goalPos != null && this.func_70011_f(this.goalPos.func_177958_n(), this.goalPos.func_177956_o(), this.goalPos.func_177952_p()) > 1.0 && this.field_70159_w > (double)-0.7f && this.field_70159_w < (double)0.7f && this.field_70179_y > (double)-0.7f && this.field_70179_y < (double)0.7f) {
                this.func_70024_g(((double)this.goalPos.func_177958_n() - this.field_70165_t) * 0.03, ((double)this.goalPos.func_177956_o() - this.field_70163_u) * 0.02, ((double)this.goalPos.func_177952_p() - this.field_70161_v) * 0.03);
                this.field_70133_I = true;
            }
            int bombTimer = this.field_70173_aa % 600;
            boolean bl = lowHealth = this.getLivesCount() > 75;
            if (bombTimer == 160) {
                this.messagePlayers((Object)((Object)TextFmt.Aqua) + "RAIN... OF... BOMBS...");
            } else if (bombTimer >= 200 && bombTimer < (lowHealth ? 560 : 400) && this.field_70173_aa % (lowHealth ? 2 : 4) == 0) {
                this.dropBomb();
            }
        } else {
            int ticksRemainder = this.field_70173_aa % 15;
            if (ticksRemainder == 0) {
                this.thunderOrb = this.field_70146_Z.nextInt(3);
            }
            if (ticksRemainder < 5) {
                this.thunderAlph += 0.18f;
            } else if (ticksRemainder < 10) {
                this.thunderAlph -= 0.18f;
            }
        }
    }

    private void dropBomb() {
        BlockPos bombPos = this.posInArena();
        if (this.field_70170_p.func_175623_d(bombPos)) {
            EntityThunderBomb bomb = new EntityThunderBomb(this.field_70170_p);
            bomb.func_70107_b(bombPos.func_177958_n(), bombPos.func_177956_o(), bombPos.func_177952_p());
            this.field_70170_p.func_72838_d((Entity)bomb);
        }
    }

    private BlockPos posInArena() {
        AABB aabb = this.getArenaAABB();
        int length = (int)Math.round(aabb.field_72336_d - aabb.field_72340_a) - 6;
        int width = (int)Math.round(aabb.field_72334_f - aabb.field_72339_c) - 6;
        return new BlockPos(aabb.field_72340_a + 3.0 + (double)this.field_70146_Z.nextInt(length), aabb.field_72338_b + (double)this.field_70146_Z.nextInt(20), aabb.field_72339_c + 3.0 + (double)this.field_70146_Z.nextInt(width));
    }

    private void findNewMove() {
        if (this.amAttackingNext) {
            Iterator iterator = this.field_70170_p.func_72872_a(Player.class, this.getArenaAABB()).iterator();
            if (iterator.hasNext()) {
                Player near_pl = (Player)iterator.next();
                this.goalPos = near_pl.func_180425_c();
            }
            this.amAttackingNext = false;
        } else {
            this.goalPos = this.posInArena();
            this.amAttackingNext = true;
        }
    }

    public float getThunderAlpha() {
        return this.thunderAlph;
    }

    public int getThunderOrb() {
        return this.thunderOrb;
    }

    protected SoundEvent func_184615_bR() {
        return SoundInit.GENERIC_STYLE3_DEATH;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundInit.GENERIC_STYLE3_HURT;
    }

    protected SoundEvent func_184639_G() {
        return null;
    }

    @Override
    protected int numberOfLives() {
        return 150;
    }

    @Override
    protected void updateLifeAction() {
        int lifePercent = Math.round(100 * (this.numberOfLives() - this.getLivesCount()) / this.numberOfLives());
        this.messagePlayers((Object)((Object)TextFmt.Gold) + "Thundyron is at " + lifePercent + "% health.");
    }

    @Override
    public void trueDeathAction() {
        if (!this.field_70170_p.field_72995_K) {
            EntityInfinityStone stone = new EntityInfinityStone(this.field_70170_p);
            stone.setStoneNum((byte)12);
            stone.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
            this.field_70170_p.func_72838_d((Entity)stone);
            this.func_145779_a(ItemInit.arenaCard, 1);
        }
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
}

