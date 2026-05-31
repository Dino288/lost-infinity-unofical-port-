/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.player.Player
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
package xol.lostinfinity.mob.entity.starforge;

import java.util.Iterator;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.entity.player.Player;
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
import xol.lostinfinity.block.misc.BlockNeoshocker;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.ai.EntityAIFloatAttack;
import xol.lostinfinity.mob.entity.base.EntityFloatingBase;
import xol.lostinfinity.util.coordinates.GalaxyCoordinates;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityGalacticTerror
extends EntityFloatingBase
implements IMaxAttack {
    private static final DataParameter<Boolean> STEALTH = EntityDataManager.func_187226_a(EntityGalacticTerror.class, (DataSerializer)DataSerializers.field_187198_h);
    private int floorStyle = 0;
    private float renderAlpha = 1.0f;

    public EntityGalacticTerror(Level worldIn) {
        super(worldIn);
        this.func_70105_a(2.5f, 2.25f);
        this.rawFlySpeed = 0.97f;
    }

    @Override
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a(STEALTH, (Object)false);
    }

    public boolean isInStealth() {
        return (Boolean)this.field_70180_af.func_187225_a(STEALTH);
    }

    public void setStealtActive(boolean s) {
        this.field_70180_af.func_187227_b(STEALTH, (Object)s);
    }

    public float getRenderAlpha() {
        return this.renderAlpha;
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null) {
            IMaxAttack.dealMaxHealth((Entity)this, this.func_70638_az(), 2);
            return true;
        }
        return false;
    }

    @Override
    public void func_70636_d() {
        super.func_70636_d();
        if (!this.field_70170_p.field_72995_K) {
            Player near_pl;
            Iterator iterator;
            if (this.field_70173_aa % 180 == 0) {
                this.floorIncrement();
            }
            if (this.field_70173_aa % 10 == 0) {
                iterator = this.field_70170_p.func_72872_a(Player.class, this.getArenaAABB()).iterator();
                while (iterator.hasNext()) {
                    near_pl = (Player)iterator.next();
                    if (near_pl.func_184812_l_() || !near_pl.field_71075_bZ.field_75100_b) continue;
                    IMaxAttack.dealTrueDamage((Entity)this, (LivingEntity)near_pl, near_pl.func_110138_aP() * 0.3f);
                }
            }
            if (this.field_70173_aa % 200 == 0 && this.getLivesCount() >= this.numberOfLives() / 2) {
                if (this.isInStealth()) {
                    this.setStealtActive(false);
                } else {
                    this.setStealtActive(true);
                    this.soundPlayers(SoundInit.GALACTIC_TERROR_SCREACH, 1.0f);
                    this.messagePlayers((Object)((Object)TextFmt.Red) + "SCCCREEEAAACCCCHHHH!");
                }
            }
            if (this.func_70638_az() != null) {
                LivingEntity target = this.func_70638_az();
                this.func_70605_aq().func_75642_a(target.field_70165_t, target.field_70163_u, target.field_70161_v, 1.0);
                if (this.field_70173_aa % 40 == 0 && this.func_70638_az().field_70163_u < this.field_70163_u) {
                    this.field_70181_x = -0.5;
                    this.field_70133_I = true;
                }
            } else if (this.field_70173_aa % 40 == 0 && (iterator = this.field_70170_p.func_72872_a(Player.class, this.getArenaAABB()).iterator()).hasNext()) {
                near_pl = (Player)iterator.next();
                this.func_70624_b((LivingEntity)near_pl);
            }
        } else if (this.isInStealth()) {
            if (this.renderAlpha > 0.0f) {
                this.renderAlpha -= 0.05f;
            }
        } else if (this.renderAlpha < 1.0f) {
            this.renderAlpha += 0.05f;
        }
    }

    private void floorIncrement() {
        ++this.floorStyle;
        if (this.floorStyle == 3) {
            this.floorStyle = 0;
        }
        AABB aabb = this.getArenaAABB();
        double blockY = aabb.field_72338_b;
        switch (this.floorStyle) {
            case 0: {
                this.soundPlayers(SoundInit.GENERIC_POP, 1.0f);
                for (double blockX = aabb.field_72340_a; blockX < aabb.field_72336_d; blockX += 1.0) {
                    for (double blockZ = aabb.field_72339_c; blockZ < aabb.field_72334_f; blockZ += 1.0) {
                        BlockPos checkPos = new BlockPos(blockX, blockY, blockZ);
                        BlockState floorState = this.field_70170_p.func_180495_p(checkPos);
                        if (floorState.func_177230_c() != BlockInit.neoshocker) continue;
                        BlockNeoshocker shock = (BlockNeoshocker)floorState.func_177230_c();
                        this.field_70170_p.func_175656_a(checkPos, shock.func_176203_a(0));
                    }
                }
                break;
            }
            case 1: {
                this.soundPlayers(SoundInit.GENERIC_POP, 1.0f);
                for (double blockX = aabb.field_72340_a; blockX < aabb.field_72336_d; blockX += 1.0) {
                    for (double blockZ = aabb.field_72339_c; blockZ < aabb.field_72334_f; blockZ += 1.0) {
                        BlockPos checkPos = new BlockPos(blockX, blockY, blockZ);
                        BlockState floorState = this.field_70170_p.func_180495_p(checkPos);
                        if (floorState.func_177230_c() != BlockInit.neoshocker || this.field_70146_Z.nextInt(5) != 0) continue;
                        BlockNeoshocker shock = (BlockNeoshocker)floorState.func_177230_c();
                        this.field_70170_p.func_175656_a(checkPos, shock.func_176203_a(1));
                    }
                }
                break;
            }
            case 2: {
                this.soundPlayers(SoundInit.ELECTRIC_SHOCK, 1.0f);
                for (double blockX = aabb.field_72340_a; blockX < aabb.field_72336_d; blockX += 1.0) {
                    for (double blockZ = aabb.field_72339_c; blockZ < aabb.field_72334_f; blockZ += 1.0) {
                        BlockNeoshocker shock;
                        int meta;
                        BlockPos checkPos = new BlockPos(blockX, blockY, blockZ);
                        BlockState floorState = this.field_70170_p.func_180495_p(checkPos);
                        if (floorState.func_177230_c() != BlockInit.neoshocker || (meta = (shock = (BlockNeoshocker)floorState.func_177230_c()).func_176201_c(floorState)) != 1) continue;
                        this.field_70170_p.func_175656_a(checkPos, shock.func_176203_a(2));
                    }
                }
                break;
            }
        }
    }

    private AABB getArenaAABB() {
        return GalaxyCoordinates.getShockArenaAABB();
    }

    @Override
    protected void updateLifeAction() {
        int lifePercent = Math.round(100 * (this.numberOfLives() - this.getLivesCount()) / this.numberOfLives());
        this.messagePlayers((Object)((Object)TextFmt.Gold) + "The Galactic Terror is at " + lifePercent + "% health.");
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
    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(10000.0);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.25);
        this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a(1.0);
    }

    protected SoundEvent func_184615_bR() {
        return SoundInit.GALACTIC_TERROR_DEATH;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundInit.GALACTIC_TERROR_HURT;
    }

    protected SoundEvent func_184639_G() {
        return SoundInit.GALACTIC_TERROR_AMBIENT;
    }

    @Override
    protected int numberOfLives() {
        return 250;
    }

    @Override
    public void trueDeathAction() {
        if (!this.field_70170_p.field_72995_K) {
            this.func_145779_a(ItemInit.multigalacticPowerCrystal, 1);
        }
    }

    @Override
    protected EntityAIFloatAttack createShootAI() {
        return null;
    }
}

