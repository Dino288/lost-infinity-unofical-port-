/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.Player
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.misc;

import java.util.ArrayList;
import java.util.UUID;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.DimensionInit;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.PotionInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.base.EntityImmaterial;
import xol.lostinfinity.mob.entity.contest.controller.EntityControllerBombers;
import xol.lostinfinity.util.coordinates.ContestCoordinates;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class EntityBomberBomb
extends EntityImmaterial
implements IMaxAttack {
    private UUID creator_UUID;
    private int deploymentTime = 60;
    private int currentSize = 0;
    private int maxSize = 1;
    private boolean[] continueExploding = new boolean[]{true, true, true, true};

    public EntityBomberBomb(Level worldIn) {
        super(worldIn);
        this.func_70105_a(0.3f, 0.3f);
    }

    public void setCreator(UUID uuid) {
        this.creator_UUID = uuid;
    }

    public void setDeploymentTime(int newDeploy) {
        this.deploymentTime = newDeploy;
    }

    public void setBombSize(int newSize) {
        this.maxSize = newSize;
    }

    @Override
    public void func_70636_d() {
        super.func_70636_d();
        this.field_70159_w = 0.0;
        this.field_70179_y = 0.0;
        this.field_70181_x = -1.0;
        if (!this.field_70170_p.field_72995_K && this.field_70173_aa > 1) {
            if (this.creator_UUID == null) {
                this.func_70106_y();
            } else {
                if (this.deploymentTime <= 0 && this.deploymentTime % 2 == 0) {
                    this.explosionEffect();
                }
                --this.deploymentTime;
            }
        }
    }

    public void explosionEffect() {
        BlockPos pos = this.func_180425_c();
        if (this.currentSize == 0) {
            this.explosionFX(pos);
        } else {
            BlockPos reference_pos;
            if (this.continueExploding[0] && !this.tileExplosion(reference_pos = pos.func_177982_a(-this.currentSize, 0, 0))) {
                this.continueExploding[0] = false;
            }
            if (this.continueExploding[1] && !this.tileExplosion(reference_pos = pos.func_177982_a(this.currentSize, 0, 0))) {
                this.continueExploding[1] = false;
            }
            if (this.continueExploding[2] && !this.tileExplosion(reference_pos = pos.func_177982_a(0, 0, -this.currentSize))) {
                this.continueExploding[2] = false;
            }
            if (this.continueExploding[3] && !this.tileExplosion(reference_pos = pos.func_177982_a(0, 0, this.currentSize))) {
                this.continueExploding[3] = false;
            }
        }
        if (this.currentSize == this.maxSize) {
            this.func_70106_y();
        } else {
            ++this.currentSize;
        }
    }

    private boolean tileExplosion(BlockPos pos) {
        if (this.field_70170_p.func_175623_d(pos)) {
            this.explosionFX(pos);
            return true;
        }
        if (this.field_70170_p.func_180495_p(pos).func_177230_c() == BlockInit.bomberWallSoft) {
            this.field_70170_p.func_175698_g(pos);
            this.field_70170_p.func_175698_g(pos.func_177984_a());
            this.explosionFX(pos);
            return false;
        }
        return false;
    }

    private void explosionFX(BlockPos pos) {
        this.playerCheck(pos);
        CustomParticleConfig config1 = new CustomParticleConfig();
        config1.createInstance().setParticle(ParticleInit.BOMBER_EXPLOSION).setIgnoreRange(true);
        IParticleSpawner.spawnParticle(this.field_70170_p, config1, (double)pos.func_177958_n() + 0.5, (double)pos.func_177956_o() + 0.3, (double)pos.func_177952_p() + 0.5);
        this.func_184185_a(SoundInit.GENERIC_WEAPON_5, 2.0f, 1.0f);
    }

    private void playerCheck(BlockPos pos) {
        block5: {
            block4: {
                if (this.field_70170_p.field_73011_w.func_186058_p() != DimensionInit.grandmasterOutpost) break block4;
                AABB arena_aabb = ContestCoordinates.bombersArenaAABB();
                if (!((double)pos.func_177958_n() >= arena_aabb.field_72340_a) || !((double)pos.func_177958_n() <= arena_aabb.field_72336_d) || !((double)pos.func_177952_p() >= arena_aabb.field_72339_c) || !((double)pos.func_177952_p() <= arena_aabb.field_72334_f)) break block5;
                AABB aabb = new AABB(pos);
                ArrayList<Player> caughtInExplosion = new ArrayList<Player>();
                for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, aabb)) {
                    caughtInExplosion.add(near_pl);
                }
                for (EntityControllerBombers search_cont : this.field_70170_p.func_72872_a(EntityControllerBombers.class, ContestCoordinates.bombersControllerAABB())) {
                    for (Player player : caughtInExplosion) {
                        if (player.func_70644_a(PotionInit.PROTECTED)) continue;
                        search_cont.removePlayer(player);
                    }
                }
                break block5;
            }
            AABB aabb = new AABB(pos);
            ArrayList caughtInExplosion = new ArrayList();
            for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, aabb)) {
                near_pl.func_70606_j(0.0f);
            }
        }
    }
}

