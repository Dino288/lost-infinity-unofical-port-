/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.player.Player
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.boss;

import java.util.ArrayList;
import java.util.Iterator;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.Vec3;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.base.EntityMultipleLives;
import xol.lostinfinity.projectile.entity.EntityPuzzleMasterArrow;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityPuzzleMaster
extends EntityMultipleLives {
    private boolean shockwave = false;
    private ArrayList<BlockPos> waveBlocks = new ArrayList();
    private BlockPos wavePos = null;
    private Vec3 waveDir = new Vec3(1.0, 0.0, 1.0);
    private static int waveLength = 17;
    private int curWaveDist = 0;
    private int floorHeight = 30;
    private int phase = 0;
    private int phaseTimer = 0;
    private int phaseLength = 400;
    private ArrayList<ArrayList<BlockPos>> quadrants = new ArrayList();
    private int curQuadrant = 0;
    private static final BlockState quadrantSafeState = BlockInit.puzzleArenaFloor.func_176203_a(1);
    private static final BlockState quadrantBadState = BlockInit.puzzleArenaFloor.func_176203_a(2);
    private static final BlockState shockwaveState = BlockInit.puzzleArenaFloor.func_176203_a(0);
    private static final BlockState platformState = BlockInit.labyrinthMetalBlack.func_176223_P();
    private static final BlockState turretActive = BlockInit.puzzleMasterTurret.func_176203_a(1);
    private static final BlockState turretInactive = BlockInit.puzzleMasterTurret.func_176203_a(0);
    private ArrayList<BlockPos> wallTurrets = new ArrayList();
    private ArrayList<Integer> inActiveTurrets = new ArrayList();
    private ArrayList<BlockPos> platforms = new ArrayList();
    private ArrayList<BlockPos> lavaPositions = new ArrayList();

    public EntityPuzzleMaster(Level worldIn) {
        super(worldIn);
        this.func_70105_a(2.0f, 6.0f);
    }

    public void func_70636_d() {
        super.func_70636_d();
        if (!this.field_70170_p.field_72995_K) {
            for (Player nearPlayer : this.field_70170_p.func_72872_a(Player.class, this.getArenaAABB())) {
                if (!nearPlayer.field_71075_bZ.field_75100_b) continue;
                IMaxAttack.dealTrueDamage((Entity)this, (LivingEntity)nearPlayer, nearPlayer.func_110138_aP() / 10.0f);
            }
            if (this.phaseTimer < this.phaseLength) {
                ++this.phaseTimer;
            } else {
                this.phaseUp();
            }
            if (this.phase != 2) {
                if (this.quadrants.isEmpty()) {
                    this.initQuadrants();
                    this.updateQuadrants();
                } else {
                    if (this.field_70173_aa % 99 == 0) {
                        this.curQuadrant = this.field_70146_Z.nextInt(4);
                        this.updateQuadrants();
                    }
                    if (this.field_70173_aa % 10 == 0) {
                        for (Player nearPlayer : this.field_70170_p.func_72872_a(Player.class, this.getArenaAABB())) {
                            if (this.field_70170_p.func_180495_p(nearPlayer.func_180425_c().func_177977_b()) != quadrantBadState) continue;
                            IMaxAttack.dealTrueDamage((Entity)this, (LivingEntity)nearPlayer, nearPlayer.func_110138_aP() / 6.0f);
                        }
                    }
                }
            }
            if (this.phase == 1) {
                if (this.wallTurrets.isEmpty()) {
                    this.initTurrets();
                } else if (this.field_70173_aa % 50 == 0) {
                    this.fireTurrets();
                    this.updateTurrets();
                }
            } else if (this.phase == 0) {
                if (!this.shockwave && this.field_70173_aa % 60 == 0) {
                    this.startShockwave();
                } else if (this.shockwave) {
                    this.progressWave();
                    if (this.field_70173_aa % 100 == 99) {
                        this.endShockwave();
                    }
                }
            } else if (this.phase == 2) {
                if (this.platforms.isEmpty()) {
                    this.initPlatforms();
                } else if (this.phaseTimer > 100 && this.lavaPositions.isEmpty()) {
                    this.initLava();
                }
            }
        }
    }

    private void initPlatforms() {
        this.messagePlayers("YOU BETTER HIDE SOMEWHERE HIGHER UP!");
        this.soundPlayers(SoundInit.CINEMATIC_WARNING, 1.25f);
        AABB arena = this.getArenaAABB();
        int xMin = (int)arena.field_72340_a + 1;
        int zMin = (int)arena.field_72339_c + 1;
        int y = this.floorHeight + 1;
        int xMax = (int)arena.field_72336_d - 1;
        int zMax = (int)arena.field_72334_f - 1;
        int xQuart = Math.abs(xMax - xMin) / 4;
        int zQuart = Math.abs(zMax - zMin) / 4;
        for (int i = -1; i <= 1; ++i) {
            for (int j = -1; j <= 1; ++j) {
                BlockPos platformPos1 = new BlockPos(xMin + xQuart + i, y, zMin + zQuart + j);
                BlockPos platformPos2 = new BlockPos(xMin + xQuart + i, y, zMax - zQuart + j);
                BlockPos platformPos3 = new BlockPos(xMax - xQuart + i, y, zMin + zQuart + j);
                BlockPos platformPos4 = new BlockPos(xMax - xQuart + i, y, zMax - zQuart + j);
                this.platforms.add(platformPos4);
                this.platforms.add(platformPos3);
                this.platforms.add(platformPos2);
                this.platforms.add(platformPos1);
            }
        }
        for (BlockPos platformPos : this.platforms) {
            this.field_70170_p.func_175656_a(platformPos, platformState);
        }
    }

    private void initLava() {
        this.soundPlayers(SoundInit.WATER_REVEAL, 1.25f);
        AABB arena = this.getArenaAABB();
        int xMin = (int)arena.field_72340_a + 2;
        int zMin = (int)arena.field_72339_c + 2;
        int y = this.floorHeight + 1;
        int xMax = (int)arena.field_72336_d - 2;
        int zMax = (int)arena.field_72334_f - 2;
        for (int i = xMin; i <= xMax; ++i) {
            for (int j = zMin; j <= zMax; ++j) {
                BlockPos lavaPos = new BlockPos(i, y, j);
                if (this.platforms.contains(lavaPos)) continue;
                this.lavaPositions.add(lavaPos);
                this.field_70170_p.func_175656_a(lavaPos, BlockInit.puzzleLava.func_176223_P());
            }
        }
    }

    private void endLava() {
        for (BlockPos platformPos : this.platforms) {
            this.field_70170_p.func_175698_g(platformPos);
        }
        for (BlockPos lavaPos : this.lavaPositions) {
            this.field_70170_p.func_175698_g(lavaPos);
        }
        this.lavaPositions.clear();
        this.platforms.clear();
    }

    private void updateTurrets() {
        int index;
        for (BlockPos turretPos : this.wallTurrets) {
            index = this.wallTurrets.indexOf(turretPos);
            if (!this.inActiveTurrets.contains(index)) continue;
            this.field_70170_p.func_175656_a(turretPos, turretActive);
        }
        for (int i = 0; i < this.inActiveTurrets.size(); ++i) {
            int curIndex = this.inActiveTurrets.get(i);
            if (curIndex < this.wallTurrets.size() - 1) {
                this.inActiveTurrets.set(i, curIndex + 1);
                continue;
            }
            this.inActiveTurrets.set(i, 0);
        }
        for (BlockPos turretPos : this.wallTurrets) {
            index = this.wallTurrets.indexOf(turretPos);
            if (!this.inActiveTurrets.contains(index)) continue;
            this.field_70170_p.func_175656_a(turretPos, turretInactive);
        }
    }

    private void fireTurrets() {
        this.soundPlayers(SoundInit.GENERIC_WEAPON_14, 1.25f);
        AABB arena = this.getArenaAABB();
        int xMin = (int)arena.field_72340_a + 1;
        int zMin = (int)arena.field_72339_c + 1;
        int zMax = (int)arena.field_72334_f - 1;
        for (BlockPos turretPos : this.wallTurrets) {
            int index = this.wallTurrets.indexOf(turretPos);
            if (this.inActiveTurrets.contains(index)) continue;
            Vec3 dir = new Vec3(-1.0, 0.0, 0.0);
            EntityPuzzleMasterArrow arrow = new EntityPuzzleMasterArrow(this.field_70170_p, (LivingEntity)this);
            arrow.func_70634_a((double)turretPos.func_177958_n() + dir.field_72450_a + 0.5, (double)turretPos.func_177956_o() + dir.field_72448_b + 0.5, (double)turretPos.func_177952_p() + dir.field_72449_c + 0.5);
            arrow.func_70186_c(dir.field_72450_a, dir.field_72448_b, dir.field_72449_c, 0.3f, 0.0f);
            this.field_70170_p.func_72838_d((Entity)arrow);
        }
    }

    private void initTurrets() {
        this.messagePlayers("DODGE THIS!");
        AABB arena = this.getArenaAABB();
        int xMin = (int)arena.field_72340_a + 1;
        int zMin = (int)arena.field_72339_c + 1;
        int y = this.floorHeight + 1;
        int xMax = (int)arena.field_72336_d - 1;
        int zMax = (int)arena.field_72334_f - 1;
        for (int i = zMin; i <= zMax; ++i) {
            BlockPos botPos = new BlockPos(xMax, y, i);
            this.wallTurrets.add(botPos);
            if (this.field_70146_Z.nextInt(2) == 0) {
                this.inActiveTurrets.add(i);
                continue;
            }
            this.field_70170_p.func_175656_a(botPos, turretActive);
        }
    }

    private void initQuadrants() {
        AABB arena = this.getArenaAABB();
        int xMin = (int)arena.field_72340_a + 1;
        int zMin = (int)arena.field_72339_c + 1;
        int y = this.floorHeight;
        int xMax = (int)arena.field_72336_d - 1;
        int zMax = (int)arena.field_72334_f - 1;
        int xMid = (xMax + xMin) / 2;
        int zMid = (zMax + zMin) / 2;
        ArrayList<BlockPos> quadrant1 = new ArrayList<BlockPos>();
        for (int i = xMin; i < xMid; ++i) {
            for (int k = zMin; k < zMid; ++k) {
                BlockPos floorPos = new BlockPos(i, y, k);
                quadrant1.add(floorPos);
            }
        }
        this.quadrants.add(quadrant1);
        ArrayList<BlockPos> quadrant2 = new ArrayList<BlockPos>();
        for (int i = xMin; i < xMid; ++i) {
            for (int k = zMid; k <= zMax; ++k) {
                BlockPos floorPos = new BlockPos(i, y, k);
                quadrant2.add(floorPos);
            }
        }
        this.quadrants.add(quadrant2);
        ArrayList<BlockPos> quadrant3 = new ArrayList<BlockPos>();
        for (int i = xMid; i <= xMax; ++i) {
            for (int k = zMid; k <= zMax; ++k) {
                BlockPos floorPos = new BlockPos(i, y, k);
                quadrant3.add(floorPos);
            }
        }
        this.quadrants.add(quadrant3);
        ArrayList<BlockPos> quadrant4 = new ArrayList<BlockPos>();
        for (int i = xMid; i < xMax; ++i) {
            for (int k = zMin; k <= zMid; ++k) {
                BlockPos floorPos = new BlockPos(i, y, k);
                quadrant4.add(floorPos);
            }
        }
        this.quadrants.add(quadrant4);
        this.curQuadrant = this.field_70146_Z.nextInt(4);
    }

    private void startShockwave() {
        this.messagePlayers("SHOCKWAVE!");
        this.soundPlayers(SoundInit.ENERGY_PULSE, 1.25f);
        Player player = null;
        Iterator iterator = this.field_70170_p.func_72872_a(Player.class, this.getArenaAABB()).iterator();
        if (iterator.hasNext()) {
            Player nearPlayer;
            player = nearPlayer = (Player)iterator.next();
        }
        if (player != null) {
            Vec3 dir = player.func_174791_d().func_178788_d(this.func_174791_d());
            this.waveDir = new Vec3(dir.field_72450_a, 0.0, dir.field_72449_c).func_72432_b();
            this.shockwave = true;
        }
    }

    private void endShockwave() {
        if (!this.waveBlocks.isEmpty()) {
            for (BlockPos wavePos : this.waveBlocks) {
                this.field_70170_p.func_175698_g(wavePos);
            }
            this.waveBlocks.clear();
        }
        this.curWaveDist = 0;
        this.shockwave = false;
        this.wavePos = null;
    }

    private void progressWave() {
        if (this.wavePos == null) {
            Object tempPos = this.func_180425_c();
            while (this.field_70170_p.func_175623_d((BlockPos)tempPos)) {
                tempPos = tempPos.func_177977_b();
            }
            this.wavePos = tempPos.func_177963_a(-this.waveDir.field_72450_a * (double)waveLength / 2.0, 0.0, -this.waveDir.field_72449_c * (double)waveLength / 2.0);
        }
        if (this.waveDir != null && this.field_70173_aa % 1 == 0) {
            if (!this.waveBlocks.isEmpty()) {
                for (BlockPos wavePos : this.waveBlocks) {
                    this.field_70170_p.func_175698_g(wavePos);
                }
                this.waveBlocks.clear();
            }
            AABB arena = this.getArenaAABB();
            int xMin = (int)arena.field_72340_a + 1;
            int zMin = (int)arena.field_72339_c + 1;
            int xMax = (int)arena.field_72336_d - 1;
            int zMax = (int)arena.field_72334_f - 1;
            for (int i = 0; i < waveLength; ++i) {
                BlockPos raisePos;
                double height = 2.0 * Math.cos(Math.PI * (double)i / 16.0 + Math.PI) + 3.0;
                int j = 1;
                while ((double)j <= height && (raisePos = this.wavePos.func_177963_a(this.waveDir.field_72450_a * (double)(i + this.curWaveDist), (double)j, this.waveDir.field_72449_c * (double)(i + this.curWaveDist))).func_177958_n() < xMax && raisePos.func_177952_p() < zMax && raisePos.func_177958_n() > xMin && raisePos.func_177952_p() > zMin) {
                    for (Player nearPlayer : this.field_70170_p.func_72872_a(Player.class, new AABB(raisePos))) {
                        IMaxAttack.dealTrueDamage((Entity)this, (LivingEntity)nearPlayer, nearPlayer.func_110138_aP() * 0.75f);
                        nearPlayer.func_70024_g(0.0, 1.0, 0.0);
                        nearPlayer.field_70133_I = true;
                    }
                    this.waveBlocks.add(raisePos);
                    this.field_70170_p.func_175656_a(raisePos, shockwaveState);
                    ++j;
                }
            }
            ++this.curWaveDist;
        }
    }

    private void updateQuadrants() {
        this.soundPlayers(SoundInit.LIGHT_MAGIC, 1.25f);
        for (int i = 0; i < this.quadrants.size(); ++i) {
            ArrayList<BlockPos> quadrant = this.quadrants.get(i);
            if (i == this.curQuadrant) {
                for (BlockPos quadPos : quadrant) {
                    this.field_70170_p.func_175656_a(quadPos, quadrantSafeState);
                }
                continue;
            }
            for (BlockPos quadPos : quadrant) {
                this.field_70170_p.func_175656_a(quadPos, quadrantBadState);
            }
        }
    }

    private void phaseUp() {
        this.phaseTimer = 0;
        if (this.phase == 0) {
            this.endShockwave();
        } else if (this.phase == 1) {
            this.endTurrets();
        } else if (this.phase == 2) {
            this.endLava();
        }
        this.phase = this.phase < 3 ? ++this.phase : 0;
    }

    private void endTurrets() {
        this.inActiveTurrets.clear();
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null) {
            IMaxAttack.dealMaxHealth((Entity)this, this.func_70638_az(), 3, 2.0f);
            return true;
        }
        return false;
    }

    protected boolean func_70692_ba() {
        return false;
    }

    @Override
    protected int numberOfLives() {
        return 300;
    }

    private AABB getArenaAABB() {
        return new AABB(new BlockPos(-9.0, 29.0, -9.0), new BlockPos(24.0, 40.0, 24.0));
    }

    @Override
    protected void updateLifeAction() {
        int lifePercent = Math.round(100 * (this.numberOfLives() - this.getLivesCount()) / this.numberOfLives());
        this.messagePlayers((Object)((Object)TextFmt.Gold) + "The Puzzle Master is at " + lifePercent + "% health.");
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
            this.messagePlayers((Object)((Object)TextFmt.Dark_Aqua) + "I never truly die. I am everywhere...");
            this.func_145779_a(ItemInit.interspaceTransmitter, 1);
        }
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.32);
        this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(15000.0);
    }
}

