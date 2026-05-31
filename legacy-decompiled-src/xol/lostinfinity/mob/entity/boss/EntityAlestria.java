/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.player.Player
 *  net.minecraft.entity.projectile.EntityArrow
 *  net.minecraft.entity.projectile.EntityFireball
 *  net.minecraft.entity.projectile.EntityThrowable
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.EnumParticleTypes
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 *  net.minecraft.world.ServerLevel
 */
package xol.lostinfinity.mob.entity.boss;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.base.EntityMultipleLives;
import xol.lostinfinity.projectile.entity.MonsterComet;
import xol.lostinfinity.stone.EntityInfinityStone;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityAlestria
extends EntityMultipleLives
implements IMaxAttack {
    public EntityAlestria(Level worldIn) {
        super(worldIn);
        this.func_70105_a(3.5f, 5.5f);
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.32);
        this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(5000.0);
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null) {
            IMaxAttack.dealMaxHealth((Entity)this, this.func_70638_az(), 4);
            return true;
        }
        return false;
    }

    private AABB getArenaAABB() {
        return new AABB(new BlockPos(-3.0, 60.0, -145.0), new BlockPos(52.0, 85.0, -40.0));
    }

    private void fireComet(float speed) {
        if (!this.field_70170_p.field_72995_K) {
            boolean fired = false;
            for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.getArenaAABB())) {
                if (near_pl.func_184812_l_()) continue;
                fired = true;
                double makeX = (this.func_174813_aQ().field_72340_a + this.func_174813_aQ().field_72336_d) / 2.0;
                double makeY = this.field_70163_u + (double)(this.field_70131_O / 2.0f) + 0.5;
                double makeZ = (this.func_174813_aQ().field_72339_c + this.func_174813_aQ().field_72334_f) / 2.0;
                double d2 = near_pl.field_70165_t - makeX;
                double d3 = near_pl.func_174813_aQ().field_72338_b + (double)(near_pl.field_70131_O / 2.0f) - makeY;
                double d4 = near_pl.field_70161_v - makeZ;
                MonsterComet shot = new MonsterComet(this.field_70170_p, (LivingEntity)this);
                shot.func_70186_c(d2, d3, d4, speed, 0.0f);
                this.field_70170_p.func_72838_d((Entity)shot);
                ((ServerLevel)this.field_70170_p).func_175739_a(EnumParticleTypes.LAVA, shot.field_70165_t, shot.field_70163_u, shot.field_70161_v, 2, this.field_70146_Z.nextDouble() * 3.0, 0.3, this.field_70146_Z.nextDouble() * 3.0, (double)0.15f, new int[0]);
            }
            if (fired) {
                this.func_184185_a(SoundInit.MAGIC_WEAPON_4, 2.0f, 1.0f);
            }
        }
    }

    public void func_70636_d() {
        super.func_70636_d();
        if (!this.field_70170_p.field_72995_K) {
            for (Entity proj : this.field_70170_p.func_72872_a(Entity.class, this.func_174813_aQ().func_72314_b(10.0, 10.0, 10.0))) {
                if (!(proj instanceof EntityThrowable) && !(proj instanceof EntityArrow) && !(proj instanceof EntityFireball) || proj instanceof MonsterComet) continue;
                proj.func_70106_y();
                proj.func_184185_a(SoundInit.ITEM_AXIOMAVORUM, 1.0f, 0.5f + this.field_70146_Z.nextFloat());
                ((ServerLevel)this.field_70170_p).func_175739_a(EnumParticleTypes.SWEEP_ATTACK, proj.field_70165_t, proj.field_70163_u, proj.field_70161_v, 2, (-0.5 + this.field_70146_Z.nextDouble()) * 3.0, 0.3, (-0.5 + this.field_70146_Z.nextDouble()) * 3.0, (double)0.15f, new int[0]);
            }
        }
        if (!this.field_70170_p.field_72995_K) {
            int modCheck = 40;
            if (this.getLivesCount() > 5) {
                modCheck = 20;
            }
            float spd = 1.25f;
            if (this.getLivesCount() > 7) {
                spd = 2.5f;
            }
            if (this.field_70173_aa % 300 < 200) {
                if (this.field_70173_aa % modCheck == 0) {
                    this.fireComet(spd);
                }
            } else if (this.field_70173_aa % (modCheck / 2) == 0) {
                this.fireComet(spd);
            }
        }
    }

    protected SoundEvent func_184615_bR() {
        return SoundInit.GENERIC_STYLE1_DEATH;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundInit.GENERIC_STYLE1_HURT;
    }

    protected SoundEvent func_184639_G() {
        return null;
    }

    public boolean func_180427_aV() {
        return true;
    }

    @Override
    protected int numberOfLives() {
        return 15;
    }

    @Override
    protected void updateLifeAction() {
        for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.getArenaAABB())) {
            near_pl.func_145747_a((Component)new Component((Object)((Object)TextFmt.Gold) + "Alestria is losing life."));
        }
    }

    @Override
    public void trueDeathAction() {
        if (!this.field_70170_p.field_72995_K) {
            EntityInfinityStone stone = new EntityInfinityStone(this.field_70170_p);
            stone.setStoneNum((byte)8);
            stone.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
            this.field_70170_p.func_72838_d((Entity)stone);
            this.func_145779_a(ItemInit.arenaCard, 1);
        }
    }

    protected boolean func_70692_ba() {
        return false;
    }

    @Override
    public boolean func_70814_o() {
        return true;
    }

    public int func_70641_bl() {
        return 1;
    }
}

