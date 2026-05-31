/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.Mob
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.monster.EntityBlaze
 *  net.minecraft.entity.monster.EntityCreeper
 *  net.minecraft.entity.monster.EntityEnderman
 *  net.minecraft.entity.monster.EntityMagmaCube
 *  net.minecraft.entity.monster.Monster
 *  net.minecraft.entity.monster.EntityPigZombie
 *  net.minecraft.entity.monster.EntityShulker
 *  net.minecraft.entity.monster.EntitySkeleton
 *  net.minecraft.entity.monster.EntitySpider
 *  net.minecraft.entity.monster.EntityStray
 *  net.minecraft.entity.monster.EntityVex
 *  net.minecraft.entity.monster.EntityZombie
 *  net.minecraft.entity.passive.EntityLlama
 *  net.minecraft.entity.player.Player
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.EnumDifficulty
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.deviant.titan;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntityShulker;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityStray;
import net.minecraft.entity.monster.EntityVex;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityLlama;
import net.minecraft.world.entity.player.Player;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Difficulty;
import net.minecraft.world.level.Level;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.mob.entity.base.EntityDeviantMob;
import xol.lostinfinity.mob.entity.base.EntityDeviantTitan;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantBlaze;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantCreeper;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantEnderman;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantLlama;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantMagmacube;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantPiglin;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantShulker;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantSkeleton;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantSpider;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantStray;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantVex;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantZombie;
import xol.lostinfinity.mob.entity.deviant.titan.EntityTitanBlaze;
import xol.lostinfinity.mob.entity.deviant.titan.EntityTitanCreeper;
import xol.lostinfinity.mob.entity.deviant.titan.EntityTitanEnderman;
import xol.lostinfinity.mob.entity.deviant.titan.EntityTitanLlama;
import xol.lostinfinity.mob.entity.deviant.titan.EntityTitanMagmacube;
import xol.lostinfinity.mob.entity.deviant.titan.EntityTitanPiglin;
import xol.lostinfinity.mob.entity.deviant.titan.EntityTitanShulker;
import xol.lostinfinity.mob.entity.deviant.titan.EntityTitanSkeleton;
import xol.lostinfinity.mob.entity.deviant.titan.EntityTitanSpider;
import xol.lostinfinity.mob.entity.deviant.titan.EntityTitanStray;
import xol.lostinfinity.mob.entity.deviant.titan.EntityTitanVex;
import xol.lostinfinity.mob.entity.deviant.titan.EntityTitanZombie;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityTrialObserver
extends Monster
implements IMaxAttack {
    private static final DataParameter<Byte> TYPE = EntityDataManager.func_187226_a(EntityTrialObserver.class, (DataSerializer)DataSerializers.field_187191_a);
    private static final DataParameter<Byte> STAGE = EntityDataManager.func_187226_a(EntityTrialObserver.class, (DataSerializer)DataSerializers.field_187191_a);

    public EntityTrialObserver(Level worldIn) {
        super(worldIn);
        this.func_70105_a(5.0f, 4.0f);
        this.func_184224_h(true);
    }

    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a(TYPE, (Object)0);
        this.field_70180_af.func_187214_a(STAGE, (Object)0);
    }

    public byte getEventType() {
        return (Byte)this.field_70180_af.func_187225_a(TYPE);
    }

    public void setEventType(byte f) {
        this.field_70180_af.func_187227_b(TYPE, (Object)f);
    }

    public byte getStage() {
        return (Byte)this.field_70180_af.func_187225_a(STAGE);
    }

    public void setStage(byte f) {
        this.field_70180_af.func_187227_b(STAGE, (Object)f);
    }

    public void func_70014_b(CompoundTag tag) {
        super.func_70014_b(tag);
        tag.func_74774_a("EventType", this.getEventType());
        tag.func_74774_a("EventStage", this.getStage());
    }

    public void func_70037_a(CompoundTag tag) {
        super.func_70037_a(tag);
        this.setEventType(tag.func_74771_c("EventType"));
        this.setStage(tag.func_74771_c("EventStage"));
    }

    protected SoundEvent func_184639_G() {
        return null;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return null;
    }

    protected SoundEvent func_184615_bR() {
        return null;
    }

    private void messagePlayers(String str) {
        for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.getArenaAABB())) {
            near_pl.func_145747_a((Component)new Component(str));
        }
    }

    protected AABB getArenaAABB() {
        return new AABB(new BlockPos(-493.0, 60.0, 407.0), new BlockPos(548.0, 85.0, 460.0));
    }

    public void func_70636_d() {
        super.func_70636_d();
        this.field_70143_R = -1.0f;
        this.func_70634_a(522.0, 75.0, 438.0);
        if (this.field_70170_p.func_175659_aa() == EnumDifficulty.PEACEFUL) {
            this.func_70106_y();
        }
        if (!this.field_70170_p.field_72995_K && this.field_70173_aa % 15 == 0) {
            for (Player player : this.field_70170_p.func_72872_a(Player.class, this.getArenaAABB())) {
                if (!player.field_71075_bZ.field_75100_b || player.func_184812_l_()) continue;
                IMaxAttack.dealMaxHealth((Entity)this, (LivingEntity)player, 4, 3.0f);
                player.func_145747_a((Component)new Component((Object)((Object)TextFmt.Red) + "Flying is prohibited in the trial. Cheaters will be punished!"));
            }
        }
        if (!this.field_70170_p.field_72995_K && this.field_70173_aa % 40 == 0) {
            boolean empty = true;
            for (Mob entity : this.field_70170_p.func_72872_a(Mob.class, this.getArenaAABB())) {
                if (entity.func_110124_au().equals(this.func_110124_au())) continue;
                empty = false;
            }
            if (empty) {
                if (this.getStage() < 7) {
                    this.setStage((byte)(this.getStage() + 1));
                    if (!this.field_70170_p.field_72995_K) {
                        this.summonWave(this.field_70170_p);
                    }
                } else if (!this.field_70170_p.field_72995_K) {
                    this.messagePlayers("The trial has been completed.");
                    this.func_70106_y();
                }
            }
        }
    }

    private void summonWave(Level worldIn) {
        switch (this.getStage()) {
            case 1: {
                this.messagePlayers("The first wave has arrived.");
                for (int repeats = 0; repeats < 10; ++repeats) {
                    this.summonBasic(worldIn);
                }
                break;
            }
            case 2: {
                this.messagePlayers("The deviant wave has arrived.");
                for (int repeats = 0; repeats < 6; ++repeats) {
                    this.summonDeviant(worldIn);
                }
                break;
            }
            case 3: {
                this.messagePlayers("The super mutated wave has arrived.");
                for (int repeats = 0; repeats < 2; ++repeats) {
                    this.summonSuperMutant(worldIn);
                }
                break;
            }
            case 4: {
                this.messagePlayers("The second deviant wave has arrived.");
                for (int repeats = 0; repeats < 10; ++repeats) {
                    this.summonDeviant(worldIn);
                }
                break;
            }
            case 5: {
                this.messagePlayers("The second super mutated wave has arrived.");
                for (int repeats = 0; repeats < 5; ++repeats) {
                    this.summonSuperMutant(worldIn);
                }
                break;
            }
            case 6: {
                this.messagePlayers("The mixed wave has arrived.");
                for (int repeats = 0; repeats < 5; ++repeats) {
                    this.summonDeviant(worldIn);
                    this.summonSuperMutant(worldIn);
                }
                break;
            }
            case 7: {
                this.messagePlayers("The final wave has arrived.");
                for (int repeats = 0; repeats < 2; ++repeats) {
                    this.summonBasic(worldIn);
                    this.summonDeviant(worldIn);
                    this.summonSuperMutant(worldIn);
                }
                EntityDeviantTitan titan = this.getTitanCreature(worldIn);
                titan.func_70107_b(522.0, 65.0, 438.0);
                worldIn.func_72838_d((Entity)titan);
            }
        }
    }

    private void summonBasic(Level worldIn) {
        Mob mob = this.getBasicCreature(worldIn);
        BlockPos spawnLoc = this.validSpawnPos(worldIn);
        mob.func_70107_b((double)spawnLoc.func_177958_n(), (double)spawnLoc.func_177956_o(), (double)spawnLoc.func_177952_p());
        worldIn.func_72838_d((Entity)mob);
    }

    private void summonDeviant(Level worldIn) {
        EntityDeviantMob mob = this.getDeviantCreature(worldIn);
        BlockPos spawnLoc = this.validSpawnPos(worldIn);
        mob.func_70107_b(spawnLoc.func_177958_n(), spawnLoc.func_177956_o(), spawnLoc.func_177952_p());
        worldIn.func_72838_d((Entity)mob);
    }

    private void summonSuperMutant(Level worldIn) {
        EntityDeviantMob mob = this.getDeviantCreature(worldIn);
        mob.setMutation(1);
        BlockPos spawnLoc = this.validSpawnPos(worldIn);
        mob.func_70107_b(spawnLoc.func_177958_n(), spawnLoc.func_177956_o(), spawnLoc.func_177952_p());
        worldIn.func_72838_d((Entity)mob);
    }

    private BlockPos validSpawnPos(Level worldIn) {
        boolean inAir = false;
        int x_pos = 0;
        int z_pos = 0;
        BlockPos pos = null;
        while (!inAir) {
            x_pos = this.field_70146_Z.nextInt(44);
            pos = new BlockPos(500 + x_pos, 63, 420 + (z_pos = this.field_70146_Z.nextInt(34)));
            if (!this.field_70170_p.func_175623_d(pos)) continue;
            inAir = true;
        }
        return pos;
    }

    private Mob getBasicCreature(Level worldin) {
        switch (this.getEventType()) {
            case 0: {
                return new EntityBlaze(this.field_70170_p);
            }
            case 1: {
                return new EntitySkeleton(this.field_70170_p);
            }
            case 2: {
                return new EntitySpider(this.field_70170_p);
            }
            case 3: {
                return new EntityCreeper(this.field_70170_p);
            }
            case 4: {
                return new EntityEnderman(this.field_70170_p);
            }
            case 5: {
                return new EntityLlama(this.field_70170_p);
            }
            case 6: {
                return new EntityMagmaCube(this.field_70170_p);
            }
            case 7: {
                return new EntityPigZombie(this.field_70170_p);
            }
            case 8: {
                return new EntityStray(this.field_70170_p);
            }
            case 9: {
                return new EntityVex(this.field_70170_p);
            }
            case 10: {
                return new EntityZombie(this.field_70170_p);
            }
            case 11: {
                return new EntityShulker(this.field_70170_p);
            }
        }
        return new EntityBlaze(this.field_70170_p);
    }

    private EntityDeviantMob getDeviantCreature(Level worldin) {
        switch (this.getEventType()) {
            case 0: {
                return new EntityDeviantBlaze(this.field_70170_p);
            }
            case 1: {
                return new EntityDeviantSkeleton(this.field_70170_p);
            }
            case 2: {
                return new EntityDeviantSpider(this.field_70170_p);
            }
            case 3: {
                return new EntityDeviantCreeper(this.field_70170_p);
            }
            case 4: {
                return new EntityDeviantEnderman(this.field_70170_p);
            }
            case 5: {
                return new EntityDeviantLlama(this.field_70170_p);
            }
            case 6: {
                return new EntityDeviantMagmacube(this.field_70170_p);
            }
            case 7: {
                return new EntityDeviantPiglin(this.field_70170_p);
            }
            case 8: {
                return new EntityDeviantStray(this.field_70170_p);
            }
            case 9: {
                return new EntityDeviantVex(this.field_70170_p);
            }
            case 10: {
                return new EntityDeviantZombie(this.field_70170_p);
            }
            case 11: {
                return new EntityDeviantShulker(this.field_70170_p);
            }
        }
        return new EntityDeviantBlaze(this.field_70170_p);
    }

    private EntityDeviantTitan getTitanCreature(Level worldin) {
        switch (this.getEventType()) {
            case 0: {
                return new EntityTitanBlaze(this.field_70170_p);
            }
            case 1: {
                return new EntityTitanSkeleton(this.field_70170_p);
            }
            case 2: {
                return new EntityTitanSpider(this.field_70170_p);
            }
            case 3: {
                return new EntityTitanCreeper(this.field_70170_p);
            }
            case 4: {
                return new EntityTitanEnderman(this.field_70170_p);
            }
            case 5: {
                return new EntityTitanLlama(this.field_70170_p);
            }
            case 6: {
                return new EntityTitanMagmacube(this.field_70170_p);
            }
            case 7: {
                return new EntityTitanPiglin(this.field_70170_p);
            }
            case 8: {
                return new EntityTitanStray(this.field_70170_p);
            }
            case 9: {
                return new EntityTitanVex(this.field_70170_p);
            }
            case 10: {
                return new EntityTitanZombie(this.field_70170_p);
            }
            case 11: {
                return new EntityTitanShulker(this.field_70170_p);
            }
        }
        return new EntityTitanBlaze(this.field_70170_p);
    }
}

