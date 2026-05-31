/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.effect.EntityLightningBolt
 *  net.minecraft.entity.player.Player
 *  net.minecraft.entity.player.ServerPlayer
 *  net.minecraft.entity.projectile.EntityThrowable
 *  net.minecraft.init.Blocks
 *  net.minecraft.nbt.NBTBase
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.nbt.NBTTagList
 *  net.minecraft.nbt.NBTUtil
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Mth
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.cthulhu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import javax.annotation.Nullable;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import xol.lostinfinity.common.events.EventsClientRender;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.PotionInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.base.EntityMultipleLives;
import xol.lostinfinity.mob.entity.base.IConditionalDamage;
import xol.lostinfinity.mob.entity.classify.ILostMultiPart;
import xol.lostinfinity.mob.entity.cthulhu.EntityCelestialStatue;
import xol.lostinfinity.mob.entity.cthulhu.EntityCthulhuBlackHole;
import xol.lostinfinity.mob.entity.cthulhu.EntityCthulhuCloud;
import xol.lostinfinity.mob.entity.cthulhu.EntityCthulhuDeathFX;
import xol.lostinfinity.mob.entity.cthulhu.EntityCthulhuHealingOrb;
import xol.lostinfinity.mob.entity.cthulhu.EntityCthulhuPart;
import xol.lostinfinity.mob.entity.cthulhu.EntityCthulhuRift;
import xol.lostinfinity.mob.entity.cthulhu.EntityCthulhuTentacle;
import xol.lostinfinity.mob.entity.cthulhu.EntityCthulhuTentaclePersist;
import xol.lostinfinity.mob.entity.cthulhu.EntityCthulhuTurret;
import xol.lostinfinity.mob.entity.cthulhu.ICthulhuMinion;
import xol.lostinfinity.projectile.cthulhu.EntityCthulhuBeam;
import xol.lostinfinity.projectile.cthulhu.EntityCthulhuMeteor;
import xol.lostinfinity.projectile.cthulhu.EntityCthulhuMissile;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;
import xol.lostinfinity.util.animation.client.AnimationHandler;
import xol.lostinfinity.util.animation.entity.IXolAnimated;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.fx.IParticleSpawner;
import xol.lostinfinity.util.math.LMath;

public class EntityCthulhu
extends EntityMultipleLives
implements IConditionalDamage,
IMaxAttack,
IXolAnimated,
ILostMultiPart {
    public static final Map<Integer, EntityCthulhu> CTHULHUS = new HashMap<Integer, EntityCthulhu>();
    private static final DataParameter<Boolean> BARRIER = EntityDataManager.func_187226_a(EntityCthulhu.class, (DataSerializer)DataSerializers.field_187198_h);
    private static final DataParameter<Integer> BARRIER_CD_1 = EntityDataManager.func_187226_a(EntityCthulhu.class, (DataSerializer)DataSerializers.field_187192_b);
    private static final DataParameter<Integer> BARRIER_CD_2 = EntityDataManager.func_187226_a(EntityCthulhu.class, (DataSerializer)DataSerializers.field_187192_b);
    private static final DataParameter<Integer> BARRIER_CD_3 = EntityDataManager.func_187226_a(EntityCthulhu.class, (DataSerializer)DataSerializers.field_187192_b);
    private static final DataParameter<Integer> BARRIER_CD_4 = EntityDataManager.func_187226_a(EntityCthulhu.class, (DataSerializer)DataSerializers.field_187192_b);
    private static final DataParameter<Integer> PHASE = EntityDataManager.func_187226_a(EntityCthulhu.class, (DataSerializer)DataSerializers.field_187192_b);
    private static final DataParameter<Boolean> FIRST_SPAWN = EntityDataManager.func_187226_a(EntityCthulhu.class, (DataSerializer)DataSerializers.field_187198_h);
    private static final DataParameter<Boolean> ACTIVATED = EntityDataManager.func_187226_a(EntityCthulhu.class, (DataSerializer)DataSerializers.field_187198_h);
    private static final double AGGRO_RANGE = 9216.0;
    private static final double DAMAGEABLE_RANGE = 4096.0;
    private static final double PUNISH_RANGE = 4096.0;
    private static final double MAX_PUNISH_RANGE = 10000.0;
    private final EntityCthulhuPart[] parts = new EntityCthulhuPart[5];
    private final List<List<Runnable>> attacks = new ArrayList<List<Runnable>>();
    private final AnimationHandler handler = new AnimationHandler();
    private int currentAttack = 0;
    private boolean canChangeAttack = false;
    private int attackTimer = 0;
    private final List<Player> inRangePlayers = new ArrayList<Player>();
    private final List<EntityCthulhuRift> rifts = new ArrayList<EntityCthulhuRift>();
    private final List<EntityCthulhuBlackHole> blackHoles = new ArrayList<EntityCthulhuBlackHole>();
    private final List<EntityCthulhuTurret> turrets = new ArrayList<EntityCthulhuTurret>();
    private final List<EntityCthulhuMissile> missiles = new ArrayList<EntityCthulhuMissile>();
    private final List<EntityCthulhuCloud> clouds = new ArrayList<EntityCthulhuCloud>();
    private final List<EntityCthulhuHealingOrb> healingOrbs = new ArrayList<EntityCthulhuHealingOrb>();
    private final List<EntityCthulhuTentacle> tentacles = new ArrayList<EntityCthulhuTentacle>();
    private final List<EntityCthulhuTentaclePersist> tentaclePersists = new ArrayList<EntityCthulhuTentaclePersist>();
    private final List<EntityCelestialStatue> statues = new ArrayList<EntityCelestialStatue>();
    private final List<BlockPos> strikeLocations = new ArrayList<BlockPos>();
    private boolean essenceCharged = false;

    public EntityCthulhu(Level worldIn) {
        super(worldIn);
        this.attacks.add(new ArrayList());
        this.attacks.add(new ArrayList());
        this.attacks.add(new ArrayList());
        this.attacks.get(0).add(this::knockbackWave);
        this.attacks.get(0).add(this::tentacleWave);
        this.attacks.get(0).add(this::summonTurret);
        this.attacks.get(0).add(this::missileAttack);
        this.attacks.get(1).add(this::lightningStrike);
        this.attacks.get(1).add(this::openRifts);
        this.attacks.get(1).add(this::summonHealingOrb);
        this.attacks.get(1).add(this::beamAttack);
        this.attacks.get(2).add(this::toxicCloud);
        this.attacks.get(2).add(this::blackHole);
        this.attacks.get(2).add(this::summonLargeTentacle);
        this.attacks.get(2).add(this::meteorShower);
        this.func_70105_a(15.0f, 15.0f);
        for (int i = 0; i < this.parts.length; ++i) {
            this.parts[i] = new EntityCthulhuPart(this, 24.0f, 5.0f, i * 5 + 15);
            this.parts[i].updatePosition();
        }
    }

    @Override
    protected void func_184651_r() {
    }

    @Override
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a(BARRIER, (Object)false);
        this.field_70180_af.func_187214_a(BARRIER_CD_1, (Object)0);
        this.field_70180_af.func_187214_a(BARRIER_CD_2, (Object)0);
        this.field_70180_af.func_187214_a(BARRIER_CD_3, (Object)0);
        this.field_70180_af.func_187214_a(BARRIER_CD_4, (Object)0);
        this.field_70180_af.func_187214_a(PHASE, (Object)1);
        this.field_70180_af.func_187214_a(FIRST_SPAWN, (Object)true);
        this.field_70180_af.func_187214_a(ACTIVATED, (Object)false);
    }

    @Override
    protected void updateLifeAction() {
        if (this.isBarrierActive()) {
            return;
        }
        float ratio = (float)this.remainingLives() / (float)this.numberOfLives();
        if (ratio < 0.6666f && this.getPhase() == 1) {
            this.setPhase(2);
            this.setBarrierActive(true);
        } else if (ratio < 0.3333f && this.getPhase() == 2) {
            this.setPhase(3);
            this.setBarrierActive(true);
        }
    }

    public void func_70071_h_() {
        double x = this.field_70165_t;
        double y = this.field_70163_u;
        double z = this.field_70161_v;
        super.func_70071_h_();
        this.field_70165_t = x;
        this.field_70163_u = y;
        this.field_70161_v = z;
        for (EntityCthulhuPart part : this.parts) {
            this.field_70170_p.func_72866_a((Entity)part, true);
            part.updatePosition();
        }
    }

    protected void soundPlayers(SoundEvent sound, float vol, float pitch) {
        for (Player contender : this.field_70170_p.func_72872_a(Player.class, this.func_174813_aQ().func_186662_g(64.0))) {
            contender.field_70170_p.func_184133_a(null, contender.func_180425_c(), sound, SoundSource.MASTER, vol + 0.3f, pitch);
        }
    }

    protected void soundClosePlayers(SoundEvent sound, float vol, float pitch, BlockPos pos) {
        for (Player contender : this.field_70170_p.func_72872_a(Player.class, new AABB(pos).func_186662_g(15.0))) {
            contender.field_70170_p.func_184133_a(null, contender.func_180425_c(), sound, SoundSource.MASTER, vol + 0.3f, pitch);
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

    private SoundEvent randomAmbient() {
        switch (this.field_70146_Z.nextInt(5)) {
            case 0: {
                return SoundInit.TT_AMBIENT_1;
            }
            case 1: {
                return SoundInit.TT_AMBIENT_2;
            }
            case 2: {
                return SoundInit.TT_AMBIENT_3;
            }
            case 3: {
                return SoundInit.TT_AMBIENT_4;
            }
            case 4: {
                return SoundInit.TT_AMBIENT_5;
            }
        }
        return SoundInit.TT_AMBIENT_1;
    }

    public void func_70636_d() {
        super.func_70636_d();
        if (this.field_70170_p.field_72995_K || this.func_110143_aJ() <= 0.0f) {
            return;
        }
        this.checkBarrierDisable();
        this.decrementBarrierTimers();
        if (!this.isBarrierActive() && this.isActivated() && this.field_70173_aa % 140 == 0) {
            this.soundPlayers(this.randomAmbient(), 1.0f, 0.7f + this.field_70146_Z.nextFloat() * 0.4f);
        }
        if (this.isBarrierActive()) {
            this.barrierKnockback();
            return;
        }
        if (this.field_70173_aa == 190 && !this.isActivated()) {
            this.soundPlayers(SoundInit.TT_RISEUP, 1.75f, 1.0f);
        }
        if (this.field_70173_aa < 280 && !this.isActivated()) {
            return;
        }
        this.setActivated(true);
        this.inRangePlayers.clear();
        for (Player player : this.field_70170_p.field_73010_i) {
            if (!(player.func_70068_e((Entity)this) <= 9216.0)) continue;
            this.inRangePlayers.add(player);
        }
        if (this.field_70173_aa % 4 == 1) {
            this.punishRange();
        }
        this.canChangeAttack = true;
        ++this.attackTimer;
        for (int i = 0; i < this.getPhase(); ++i) {
            this.attacks.get(i).get(this.currentAttack).run();
        }
        if (this.canChangeAttack) {
            this.sendMessage("attack change");
            this.playAnimation("cast_" + (this.field_70146_Z.nextInt(2) + 1), 1.0f);
            this.canChangeAttack = false;
            this.currentAttack = (this.currentAttack + 1) % 4;
            this.attackTimer = 0;
        }
        this.rifts.removeIf(rift -> rift.field_70128_L);
        this.blackHoles.removeIf(blackHole -> blackHole.field_70128_L);
        this.turrets.removeIf(turret -> turret.field_70128_L);
        this.missiles.removeIf(missile -> missile.field_70128_L);
        this.clouds.removeIf(cloud -> cloud.field_70128_L);
        this.healingOrbs.removeIf(orb -> orb.field_70128_L);
        this.tentacles.removeIf(tentacle -> tentacle.field_70128_L);
        this.tentaclePersists.removeIf(tentaclePersist -> tentaclePersist.field_70128_L);
        this.statues.removeIf(statue -> statue.field_70128_L);
    }

    public boolean func_70097_a(DamageSource source, float amount) {
        return super.func_70097_a(source, amount);
    }

    protected void func_82167_n(Entity entityIn) {
    }

    public boolean func_70104_M() {
        return false;
    }

    protected boolean func_70692_ba() {
        return false;
    }

    private void punishRange() {
        for (Player player : this.field_70170_p.field_73010_i) {
            if (!(player.func_70068_e((Entity)this) > 4096.0) || !(player.func_70068_e((Entity)this) <= 10000.0)) continue;
            IMaxAttack.dealTrueDamage((Entity)this, (LivingEntity)player, player.func_110138_aP() * 0.05f);
        }
    }

    private void knockbackWave() {
        this.setAttackEnded(this.attackTimer >= 60);
        if (this.attackTimer == 1) {
            if (this.tentaclePersists.size() == 0) {
                this.sendMessage("knockbackWave");
            } else {
                this.sendMessage("knockbackWave + tentacle buffed");
            }
            this.tentaclePersists.forEach(EntityCthulhuTentaclePersist::cast);
            for (Player player : this.inRangePlayers) {
                double x = player.field_70165_t - this.field_70165_t;
                double y = player.field_70163_u - this.field_70163_u;
                double z = player.field_70161_v - this.field_70161_v;
                double distance = Mth.func_181161_i((double)(x * x + y * y + z * z));
                player.field_70159_w = (x *= distance) * 8.0 * (double)(this.tentaclePersists.size() + 1);
                player.field_70181_x = 4.5f * (float)(this.tentaclePersists.size() + 1);
                player.field_70179_y = (z *= distance) * 8.0 * (double)(this.tentaclePersists.size() + 1);
                player.field_70133_I = true;
                if (!this.field_70170_p.field_72995_K) continue;
                this.soundPlayers(SoundInit.ELECTRIC_WOOSH, 1.0f, 1.0f);
            }
        }
    }

    private void barrierKnockback() {
        for (ServerPlayer player2 : this.field_70170_p.func_73046_m().func_184103_al().func_181057_v().stream().filter(player -> this.func_70011_f(player.field_70165_t, this.field_70163_u, player.field_70161_v) <= 47.8).collect(Collectors.toList())) {
            double x = player2.field_70165_t - this.field_70165_t;
            double y = player2.field_70163_u - this.field_70163_u;
            double z = player2.field_70161_v - this.field_70161_v;
            double distance = Mth.func_181161_i((double)(x * x + y * y + z * z));
            player2.field_70159_w = (x *= distance) * 2.0;
            player2.field_70181_x = 1.5;
            player2.field_70179_y = (z *= distance) * 2.0;
            player2.field_70133_I = true;
        }
    }

    private void tentacleWave() {
        if (this.attackTimer == 1) {
            this.sendMessage("tentacleWave");
        }
        this.setAttackEnded(this.attackTimer >= 150);
        if (this.attackTimer % 5 == 1 && this.attackTimer <= 101) {
            EntityCthulhuTentacle tentacle = new EntityCthulhuTentacle(this.field_70170_p);
            tentacle.setSize(3.0f + this.field_70170_p.field_73012_v.nextFloat() * (4.0f + (float)this.getPhase() * 0.75f));
            tentacle.setOwner(this);
            tentacle.field_70759_as = tentacle.field_70177_z = this.field_70170_p.field_73012_v.nextFloat() * 360.0f;
            tentacle.func_70107_b(this.field_70165_t + (double)this.getRandom(64.0f), this.field_70163_u + (double)this.func_70047_e() + (double)this.getRandom(10.0f), this.field_70161_v + (double)this.getRandom(64.0f));
            this.soundClosePlayers(SoundInit.APPARITION_4, 1.0f, 0.7f + this.field_70146_Z.nextFloat() * 0.6f, tentacle.func_180425_c());
            this.field_70170_p.func_72838_d((Entity)tentacle);
            this.tentacles.add(tentacle);
        }
    }

    private void summonTurret() {
        if (this.attackTimer == 1) {
            this.sendMessage("summonTurret");
        }
        this.setAttackEnded(this.attackTimer >= 100);
        if (this.attackTimer % 15 == 0 && this.attackTimer <= 45) {
            this.turrets.removeIf(entityCthulhuTurret -> entityCthulhuTurret.field_70128_L);
            if (this.turrets.size() < 5) {
                EntityCthulhuTurret turret = new EntityCthulhuTurret(this.field_70170_p);
                turret.setOwner(this);
                turret.func_70107_b(this.field_70165_t, this.field_70163_u + (double)this.func_70047_e(), this.field_70161_v);
                Vec3 mot = LMath.fastNormalize(new Vec3((double)this.getRandom(1.0f), 0.0, (double)this.getRandom(1.0f))).func_186678_a(5.0);
                turret.field_70159_w = mot.field_72450_a;
                turret.field_70181_x = mot.field_72448_b;
                turret.field_70179_y = mot.field_72449_c;
                turret.field_70133_I = true;
                this.field_70170_p.func_72838_d((Entity)turret);
                this.turrets.add(turret);
                this.soundClosePlayers(SoundInit.EXECUTE_EFFECT, 1.0f, 0.7f + this.field_70146_Z.nextFloat() * 0.5f, turret.func_180425_c());
            }
        }
    }

    private void missileAttack() {
        if (this.attackTimer == 1) {
            if (this.tentaclePersists.size() == 0) {
                this.sendMessage("missileAttack");
            } else {
                this.sendMessage("missileAttack + tentacle buffed");
            }
            this.tentaclePersists.forEach(EntityCthulhuTentaclePersist::cast);
        }
        this.setAttackEnded(this.attackTimer >= 400);
        if (this.attackTimer % 10 == 0) {
            this.missiles.removeIf(missile -> missile.field_70128_L);
            if (this.missiles.size() < 50 && !this.inRangePlayers.isEmpty()) {
                this.spawnMissileAt(this.field_70165_t + (double)this.getRandom(24.0f), this.field_70163_u, this.field_70161_v + (double)this.getRandom(24.0f));
                this.tentaclePersists.forEach(ent -> this.spawnMissileAt(ent.field_70165_t + (double)this.getRandom(9.0f), ent.field_70163_u, ent.field_70161_v + (double)this.getRandom(9.0f)));
            }
        }
    }

    private void spawnMissileAt(double x, double y, double z) {
        EntityCthulhuMissile missile = new EntityCthulhuMissile(this.field_70170_p);
        missile.setThrower((LivingEntity)this);
        missile.setTarget((LivingEntity)this.getRandomPlayer());
        missile.func_70107_b(x, y, z);
        missile.func_70186_c(0.0, 1.0, 0.0, 2.0f, 0.0f);
        this.field_70170_p.func_72838_d((Entity)missile);
        this.soundClosePlayers(SoundInit.LASER_WEAPON_2, 1.0f, 0.6f + this.field_70146_Z.nextFloat() * 0.8f, missile.func_180425_c());
        this.missiles.add(missile);
    }

    private void lightningStrike() {
        if (this.attackTimer == 1) {
            this.sendMessage("lightningStrike");
        }
        this.setAttackEnded(this.attackTimer >= 200);
        if (this.field_70170_p.func_73046_m() == null) {
            return;
        }
        if (this.attackTimer % 40 > 0 && this.attackTimer % 40 <= 25) {
            if (this.strikeLocations.isEmpty()) {
                List nearbyPlayers = this.field_70170_p.func_73046_m().func_184103_al().func_181057_v().stream().filter(player -> player.func_70068_e((Entity)this) <= 12288.0).collect(Collectors.toList());
                if (nearbyPlayers.isEmpty()) {
                    int strikeCount = this.field_70170_p.field_73012_v.nextInt(4) + 3;
                    for (int i = 0; i < strikeCount; ++i) {
                        double x = this.field_70165_t + (double)this.field_70170_p.field_73012_v.nextInt(100) - 50.0;
                        double z = this.field_70161_v + (double)this.field_70170_p.field_73012_v.nextInt(100) - 50.0;
                        double y = this.field_70170_p.func_175672_r(new BlockPos(x, 0.0, z)).func_177956_o() + this.field_70170_p.field_73012_v.nextInt(20) + 5;
                        this.strikeLocations.add(new BlockPos(x, y, z));
                        for (int j = 0; j < 3; ++j) {
                            double x2 = x + (double)this.field_70170_p.field_73012_v.nextInt(20) - 10.0;
                            double z2 = z + (double)this.field_70170_p.field_73012_v.nextInt(20) - 10.0;
                            double y2 = this.field_70170_p.func_175672_r(new BlockPos(x2, 0.0, z2)).func_177956_o() + this.field_70170_p.field_73012_v.nextInt(20) + 5;
                            this.strikeLocations.add(new BlockPos(x2, y2, z2));
                        }
                    }
                } else {
                    int strikeCount1 = this.field_70170_p.field_73012_v.nextInt(nearbyPlayers.size()) + 1;
                    for (int i = 0; i < strikeCount1; ++i) {
                        Player player2 = (Player)nearbyPlayers.get(i);
                        if (player2.field_70128_L || player2.func_175149_v()) continue;
                        this.strikeLocations.add(new BlockPos(player2.field_70165_t + (double)this.field_70170_p.field_73012_v.nextInt(11) - 5.0, player2.field_70163_u, player2.field_70161_v + (double)this.field_70170_p.field_73012_v.nextInt(11) - 5.0));
                        for (int j = 0; j < 3; ++j) {
                            double x = player2.field_70165_t + (double)this.field_70170_p.field_73012_v.nextInt(20) - 10.0;
                            double z = player2.field_70161_v + (double)this.field_70170_p.field_73012_v.nextInt(20) - 10.0;
                            double y = this.field_70170_p.func_175672_r(new BlockPos(x, 0.0, z)).func_177956_o() + this.field_70170_p.field_73012_v.nextInt(20) + 5;
                            this.strikeLocations.add(new BlockPos(x, y, z));
                        }
                    }
                    int strikeCount2 = 3;
                    for (int i = 0; i < strikeCount2; ++i) {
                        double x = this.field_70165_t + (double)this.field_70170_p.field_73012_v.nextInt(100) - 50.0;
                        double z = this.field_70161_v + (double)this.field_70170_p.field_73012_v.nextInt(100) - 50.0;
                        double y = this.field_70170_p.func_175672_r(new BlockPos(x, 0.0, z)).func_177956_o() + this.field_70170_p.field_73012_v.nextInt(20) + 5;
                        this.strikeLocations.add(new BlockPos(x, y, z));
                        for (int j = 0; j < 3; ++j) {
                            double x2 = x + (double)this.field_70170_p.field_73012_v.nextInt(20) - 10.0;
                            double z2 = z + (double)this.field_70170_p.field_73012_v.nextInt(20) - 10.0;
                            double y2 = this.field_70170_p.func_175672_r(new BlockPos(x2, 0.0, z2)).func_177956_o() + this.field_70170_p.field_73012_v.nextInt(20) + 5;
                            this.strikeLocations.add(new BlockPos(x2, y2, z2));
                        }
                    }
                }
            } else if (this.attackTimer % 4 == 1) {
                for (BlockPos pos : this.strikeLocations) {
                    CustomParticleConfig config = new CustomParticleConfig();
                    config.createInstance().setParticle(ParticleInit.LIGHTNING_INDICATOR).setCount(1).setSpread(0.5, 0.0, 0.5).setIgnoreRange(true);
                    for (int i = 0; i <= 5; ++i) {
                        IParticleSpawner.spawnParticle(this.field_70170_p, config, (double)pos.func_177958_n() + 0.5, (double)(pos.func_177956_o() + i), (double)pos.func_177952_p() + 0.5);
                    }
                }
            }
        } else if (this.attackTimer % 40 == 31) {
            for (BlockPos pos : this.strikeLocations) {
                int x = pos.func_177958_n();
                int y = pos.func_177956_o();
                int z = pos.func_177952_p();
                this.field_70170_p.func_72942_c((Entity)new EntityLightningBolt(this.field_70170_p, (double)x, (double)y, (double)z, true));
                List entities = this.field_70170_p.func_72872_a(LivingEntity.class, new AABB((double)(x - 5), (double)(y - 5), (double)(z - 5), (double)(x + 5), (double)(y + 5), (double)(z + 5)));
                for (LivingEntity entity : entities) {
                    if (entity.equals((Object)this) || entity instanceof ICthulhuMinion) continue;
                    IMaxAttack.dealTrueDamage((Entity)this, entity, entity.func_110138_aP() * 0.3f);
                    entity.func_70015_d(10);
                }
            }
            this.strikeLocations.clear();
        }
    }

    private void openRifts() {
        if (this.attackTimer == 1) {
            this.sendMessage("openRifts");
        }
        this.setAttackEnded(this.attackTimer >= 200);
        if (this.attackTimer == 1) {
            if (this.rifts.size() >= 10) {
                return;
            }
            int spawnCount = this.field_70170_p.field_73012_v.nextInt(5) + 4;
            for (int i = 0; i < spawnCount && this.rifts.size() < 10; ++i) {
                double x = this.field_70165_t + (double)this.field_70170_p.field_73012_v.nextInt(100) - 50.0;
                double z = this.field_70161_v + (double)this.field_70170_p.field_73012_v.nextInt(100) - 50.0;
                for (double y = (double)this.field_70170_p.func_175672_r(new BlockPos(x, 0.0, z)).func_177956_o(); y <= 256.0 && this.field_70170_p.func_180495_p(new BlockPos(x, y, z)).func_177230_c() != Blocks.field_150350_a; y += 1.0) {
                }
                EntityCthulhuRift rift = new EntityCthulhuRift(this.field_70170_p);
                rift.setOwner(this);
                rift.func_70107_b(x, y += (double)(this.field_70170_p.field_73012_v.nextInt(25) + 5), z);
                if (rift.func_174813_aQ().func_72326_a(this.func_174813_aQ())) {
                    --i;
                    continue;
                }
                boolean shouldContinue = false;
                for (EntityCthulhuRift other : this.rifts) {
                    if (!rift.func_174813_aQ().func_72326_a(other.func_174813_aQ())) continue;
                    --i;
                    shouldContinue = true;
                    break;
                }
                if (shouldContinue) continue;
                this.field_70170_p.func_72838_d((Entity)rift);
                this.soundClosePlayers(SoundInit.RIFT_CREATE, 1.0f, 0.6f + this.field_70146_Z.nextFloat() * 0.7f, rift.func_180425_c());
                this.rifts.add(rift);
            }
        }
    }

    private void summonHealingOrb() {
        if (this.attackTimer == 1) {
            this.sendMessage("summonHealingOrb");
        }
        this.setAttackEnded(this.attackTimer >= 100);
        if (this.attackTimer == 1 && this.healingOrbs.size() < 3) {
            int amountToSpawn = this.field_70170_p.field_73012_v.nextInt(2) + 2;
            for (int i = 0; i < amountToSpawn && this.healingOrbs.size() < 3; ++i) {
                EntityCthulhuHealingOrb orb = new EntityCthulhuHealingOrb(this.field_70170_p, this);
                orb.updatePos();
                this.field_70170_p.func_72838_d((Entity)orb);
                this.healingOrbs.add(orb);
            }
            this.soundPlayers(SoundInit.MAGIC_WEAPON_3, 1.0f, 0.5f + this.field_70146_Z.nextFloat() * 0.6f);
        }
    }

    private void beamAttack() {
        if (this.attackTimer == 1) {
            this.sendMessage("beamAttack");
        }
        this.setAttackEnded(this.attackTimer >= 200);
        if (this.attackTimer < 200) {
            Player player = this.getRandomPlayer();
            if (player == null) {
                return;
            }
            EntityCthulhuBeam beam = new EntityCthulhuBeam(this.field_70170_p);
            double x = this.getRandom(24.0f);
            double z = this.getRandom(24.0f);
            beam.func_70107_b(this.field_70165_t + x + Math.signum(x) * 24.0, this.field_70163_u + (double)this.field_70131_O * 0.5 + (double)this.getRandom(this.field_70131_O * 0.5f), this.field_70161_v + z + Math.signum(z) * 24.0);
            beam.setDirection((float)((double)this.getRandom(10.0f) + player.field_70165_t - beam.field_70165_t), (float)((double)this.getRandom(10.0f) + player.field_70163_u - beam.field_70163_u), (float)((double)this.getRandom(10.0f) + player.field_70161_v - beam.field_70161_v));
            this.field_70170_p.func_72838_d((Entity)beam);
            if (this.field_70146_Z.nextBoolean()) {
                this.soundClosePlayers(SoundInit.LASER_WEAPON_9, 1.0f, 0.7f + this.field_70146_Z.nextFloat() * 0.6f, beam.func_180425_c());
            }
        }
    }

    private void toxicCloud() {
        if (this.attackTimer == 1) {
            this.sendMessage("toxicCloud");
        }
        this.setAttackEnded(this.attackTimer >= 300);
        if (this.clouds.size() >= 5) {
            return;
        }
        if (this.field_70170_p.func_73046_m() == null) {
            return;
        }
        List nearbyPlayers = this.field_70170_p.func_73046_m().func_184103_al().func_181057_v().stream().filter(player -> player.func_70068_e((Entity)this) <= 12288.0).collect(Collectors.toList());
        if (nearbyPlayers.isEmpty()) {
            for (int i = 0; i < 3 && this.clouds.size() < 5; ++i) {
                EntityCthulhuCloud cloud = new EntityCthulhuCloud(this.field_70170_p);
                cloud.setOwner(this);
                cloud.func_70107_b(this.field_70165_t + this.func_70040_Z().field_72450_a * 2.0, this.field_70163_u + (double)this.func_70047_e(), this.field_70161_v + this.func_70040_Z().field_72449_c * 2.0);
                this.field_70170_p.func_72838_d((Entity)cloud);
                this.clouds.add(cloud);
                this.field_70170_p.func_184133_a(null, cloud.func_180425_c(), SoundInit.MAGIC_WEAPON_13, SoundSource.HOSTILE, 1.0f, 0.7f + this.field_70146_Z.nextFloat() * 0.6f);
            }
        } else {
            for (Player player2 : nearbyPlayers) {
                boolean shouldContinue = false;
                for (EntityCthulhuCloud cloud : this.clouds) {
                    if (cloud.func_70638_az() == null || !cloud.func_70638_az().equals((Object)player2)) continue;
                    shouldContinue = true;
                    break;
                }
                if (shouldContinue) continue;
                EntityCthulhuCloud cloud = new EntityCthulhuCloud(this.field_70170_p);
                cloud.func_70624_b((LivingEntity)player2);
                cloud.func_70107_b(this.field_70165_t + this.func_70040_Z().field_72450_a * 2.0, this.field_70163_u + (double)this.func_70047_e(), this.field_70161_v + this.func_70040_Z().field_72449_c * 2.0);
                cloud.setOwner(this);
                this.field_70170_p.func_72838_d((Entity)cloud);
                this.clouds.add(cloud);
                this.field_70170_p.func_184133_a(null, cloud.func_180425_c(), SoundInit.MAGIC_WEAPON_13, SoundSource.HOSTILE, 1.0f, 0.7f + this.field_70146_Z.nextFloat() * 0.6f);
            }
        }
    }

    private void blackHole() {
        if (this.attackTimer == 1) {
            if (this.tentaclePersists.size() == 0) {
                this.sendMessage("blackHole");
            } else {
                this.sendMessage("blackHole + tentacle buffed");
            }
            this.tentaclePersists.forEach(EntityCthulhuTentaclePersist::cast);
        }
        this.setAttackEnded(this.attackTimer >= 300);
        if (this.attackTimer % 40 == 1) {
            if (this.blackHoles.size() >= 8 + this.tentaclePersists.size() * 2) {
                return;
            }
            int spawnCount = this.field_70170_p.field_73012_v.nextInt(3) + 1 + this.tentaclePersists.size() * 2;
            for (int i = 0; i < spawnCount && this.blackHoles.size() < 8 + this.tentaclePersists.size() * 2; ++i) {
                double x = this.field_70165_t + (double)this.field_70170_p.field_73012_v.nextInt(100) - 50.0;
                double z = this.field_70161_v + (double)this.field_70170_p.field_73012_v.nextInt(100) - 50.0;
                for (double y = (double)this.field_70170_p.func_175672_r(new BlockPos(x, 0.0, z)).func_177956_o(); y <= 256.0 && this.field_70170_p.func_180495_p(new BlockPos(x, y, z)).func_177230_c() != Blocks.field_150350_a; y += 1.0) {
                }
                EntityCthulhuBlackHole whirlpool = new EntityCthulhuBlackHole(this.field_70170_p);
                whirlpool.setOwner(this);
                whirlpool.func_70107_b(x, y += (double)(this.field_70170_p.field_73012_v.nextInt(25) + 5), z);
                if (whirlpool.func_174813_aQ().func_72326_a(this.func_174813_aQ())) {
                    --i;
                    continue;
                }
                boolean shouldContinue = false;
                for (EntityCthulhuBlackHole other : this.blackHoles) {
                    if (!whirlpool.func_174813_aQ().func_72326_a(other.func_174813_aQ())) continue;
                    --i;
                    shouldContinue = true;
                    break;
                }
                if (shouldContinue) continue;
                this.field_70170_p.func_72838_d((Entity)whirlpool);
                this.soundClosePlayers(SoundInit.PORTAL_OPEN, 1.0f, 0.7f + this.field_70146_Z.nextFloat() * 0.3f, whirlpool.func_180425_c());
                this.blackHoles.add(whirlpool);
            }
        }
    }

    private void summonLargeTentacle() {
        if (this.attackTimer == 1) {
            this.sendMessage("summonLargeTentacle");
            for (int i = 0; i < 2 && this.tentaclePersists.size() < 2; ++i) {
                EntityCthulhuTentaclePersist tentacle = new EntityCthulhuTentaclePersist(this.field_70170_p);
                tentacle.setOwner(this);
                tentacle.teleportRandom();
                this.tentaclePersists.add(tentacle);
                this.field_70170_p.func_72838_d((Entity)tentacle);
                this.soundClosePlayers(SoundInit.APPARITION_4, 1.0f, 0.7f + this.field_70146_Z.nextFloat() * 0.6f, tentacle.func_180425_c());
            }
        }
        this.setAttackEnded(this.attackTimer >= 100);
    }

    private void meteorShower() {
        if (this.attackTimer == 1) {
            this.sendMessage("meteorShower");
        }
        this.setAttackEnded(this.attackTimer >= 200);
        if (this.attackTimer % 20 == 1 && this.attackTimer <= 101) {
            for (int i = 0; i < 3; ++i) {
                double tx = this.getRandom(1.0f);
                double tz = this.getRandom(1.0f);
                double s = Mth.func_181161_i((double)(tx * tx + tz * tz)) * (double)this.getRandom(48.0f);
                tx *= s;
                tz *= s;
                double ty = this.field_70170_p.func_189649_b((int)(tx += this.field_70165_t), (int)(tz += this.field_70161_v));
                EntityCthulhuMeteor meteor = new EntityCthulhuMeteor(this.field_70170_p);
                meteor.setThrower((LivingEntity)this);
                meteor.func_70107_b(tx + 64.0, ty + 128.0, tz + 64.0);
                meteor.func_70186_c(-1.0, -2.0, -1.0, 3.0f, 0.0f);
                this.field_70170_p.func_72838_d((Entity)meteor);
            }
        }
    }

    private void sendMessage(String string) {
    }

    private void setAttackEnded(boolean flag) {
        this.canChangeAttack &= flag;
    }

    @Override
    public boolean canBeDamaged(Entity attacker) {
        if (this.isBarrierActive()) {
            return false;
        }
        if (!(attacker instanceof EntityThrowable)) {
            return LMath.getDistanceSquaredToAABB(attacker.func_174791_d(), this.func_174813_aQ()) < 4096.0;
        }
        LivingEntity thrower = ((EntityThrowable)attacker).func_85052_h();
        if (thrower != null) {
            return LMath.getDistanceSquaredToAABB(thrower.func_174791_d(), this.func_174813_aQ()) < 4096.0;
        }
        if (attacker instanceof EntityBaseThrowable) {
            thrower = ((EntityBaseThrowable)attacker).getSecondaryThrower();
        }
        if (thrower != null) {
            return LMath.getDistanceSquaredToAABB(thrower.func_174791_d(), this.func_174813_aQ()) < 4096.0;
        }
        return LMath.getDistanceSquaredToAABB(attacker.func_174791_d(), this.func_174813_aQ()) < 4096.0;
    }

    public void func_70106_y() {
        this.turrets.forEach(Entity::func_70106_y);
        this.rifts.forEach(Entity::func_70106_y);
        this.blackHoles.forEach(Entity::func_70106_y);
        this.missiles.forEach(Entity::func_70106_y);
        this.clouds.forEach(Entity::func_70106_y);
        this.healingOrbs.forEach(Entity::func_70106_y);
        this.tentacles.forEach(Entity::func_70106_y);
        this.tentaclePersists.forEach(Entity::func_70106_y);
        this.statues.forEach(Entity::func_70106_y);
        this.turrets.clear();
        this.missiles.clear();
        this.rifts.clear();
        this.blackHoles.clear();
        this.clouds.clear();
        this.healingOrbs.clear();
        this.tentacles.clear();
        this.tentaclePersists.clear();
        this.statues.clear();
        for (EntityCthulhuPart part : this.parts) {
            this.field_70170_p.func_72973_f((Entity)part);
        }
        if (!this.field_70170_p.field_72995_K) {
            EntityCthulhuDeathFX fx = new EntityCthulhuDeathFX(this.field_70170_p);
            fx.func_70107_b(this.field_70165_t, this.field_70163_u + (double)this.field_70131_O * 0.5, this.field_70161_v);
            this.field_70170_p.func_72838_d((Entity)fx);
            this.soundPlayers(SoundInit.TT_DEATH, 1.0f, 1.0f);
        }
        super.func_70106_y();
    }

    public void essenceKill() {
        this.essenceCharged = true;
        this.func_70106_y();
    }

    public boolean isEssenceCharged() {
        return this.essenceCharged;
    }

    private void decrementBarrierTimers() {
        if (this.getBarrierCd1() > 0) {
            this.setBarrierCd1(this.getBarrierCd1() - 1);
        }
        if (this.getBarrierCd2() > 0) {
            this.setBarrierCd2(this.getBarrierCd2() - 1);
        }
        if (this.getBarrierCd3() > 0) {
            this.setBarrierCd3(this.getBarrierCd3() - 1);
        }
        if (this.getBarrierCd4() > 0) {
            this.setBarrierCd4(this.getBarrierCd4() - 1);
        }
    }

    public void checkBarrierDisable() {
        if (!this.isBarrierActive()) {
            return;
        }
        if (this.getBarrierCd1() != 0 && this.getBarrierCd2() != 0 && this.getBarrierCd3() != 0 && this.getBarrierCd4() != 0) {
            this.setBarrierActive(false);
            this.setAllBarrierCd(0);
        }
    }

    public void setBarrierActive(boolean flag) {
        this.field_70180_af.func_187227_b(BARRIER, (Object)flag);
        if (flag) {
            this.func_70690_d(new PotionEffect(PotionInit.PROTECTED, Integer.MAX_VALUE, 0, false, false));
            this.knockbackWave();
            for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.func_174813_aQ().func_186662_g(60.0))) {
                this.field_70170_p.func_184133_a(null, near_pl.func_180425_c(), SoundInit.MAGIC_WEAPON_12, SoundSource.HOSTILE, 1.0f, 1.0f);
            }
            EntityCelestialStatue statue = new EntityCelestialStatue(this.field_70170_p);
            statue.setOwner(this);
            statue.setType(this.getPhase() == 2 ? 0 : 2);
            statue.func_70634_a(this.field_70165_t + 80.0, this.field_70163_u, this.field_70161_v);
            this.field_70170_p.func_72838_d((Entity)statue);
            this.statues.add(statue);
            statue = new EntityCelestialStatue(this.field_70170_p);
            statue.setOwner(this);
            statue.setType(this.getPhase() == 2 ? 1 : 3);
            statue.func_70634_a(this.field_70165_t - 80.0, this.field_70163_u, this.field_70161_v);
            this.field_70170_p.func_72838_d((Entity)statue);
            this.statues.add(statue);
            this.playAnimation("break", 0.33f);
            this.playAnimation("break_idle", 1.0f);
        } else {
            this.func_184589_d(PotionInit.PROTECTED);
            for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.func_174813_aQ().func_186662_g(60.0))) {
                this.field_70170_p.func_184133_a(null, near_pl.func_180425_c(), SoundInit.MAGIC_WEAPON_14, SoundSource.HOSTILE, 1.0f, 1.0f);
            }
            this.statues.forEach(Entity::func_70106_y);
            this.statues.clear();
            this.sendMessage("Barrier deactivated!");
            this.stopAnimation("break");
            this.stopAnimation("break_idle");
            this.playAnimation("recover", 1.0f);
        }
    }

    public boolean isBarrierActive() {
        return (Boolean)this.field_70180_af.func_187225_a(BARRIER);
    }

    public void setBarrierCd1(int cd) {
        this.field_70180_af.func_187227_b(BARRIER_CD_1, (Object)cd);
    }

    public int getBarrierCd1() {
        return (Integer)this.field_70180_af.func_187225_a(BARRIER_CD_1);
    }

    public void setBarrierCd2(int cd) {
        this.field_70180_af.func_187227_b(BARRIER_CD_2, (Object)cd);
    }

    public int getBarrierCd2() {
        return (Integer)this.field_70180_af.func_187225_a(BARRIER_CD_2);
    }

    public void setBarrierCd3(int cd) {
        this.field_70180_af.func_187227_b(BARRIER_CD_3, (Object)cd);
    }

    public int getBarrierCd3() {
        return (Integer)this.field_70180_af.func_187225_a(BARRIER_CD_3);
    }

    public void setBarrierCd4(int cd) {
        this.field_70180_af.func_187227_b(BARRIER_CD_4, (Object)cd);
    }

    public int getBarrierCd4() {
        return (Integer)this.field_70180_af.func_187225_a(BARRIER_CD_4);
    }

    public void setAllBarrierCd(int cd) {
        this.setBarrierCd1(cd);
        this.setBarrierCd2(cd);
        this.setBarrierCd3(cd);
        this.setBarrierCd4(cd);
    }

    private float getRandom(float mul) {
        return (this.field_70170_p.field_73012_v.nextFloat() - 0.5f) * 2.0f * mul;
    }

    private Player getRandomPlayer() {
        return this.inRangePlayers.isEmpty() ? null : this.inRangePlayers.get(this.field_70146_Z.nextInt(this.inRangePlayers.size()));
    }

    @Override
    public void func_70014_b(CompoundTag tag) {
        super.func_70014_b(tag);
        tag.func_74768_a("phase", this.getPhase());
        tag.func_74757_a("barrier", this.isBarrierActive());
        tag.func_74757_a("activated", this.isActivated());
        tag.func_74768_a("currentAttack", this.currentAttack);
        tag.func_74768_a("attackTimer", this.attackTimer);
        NBTTagList list = new NBTTagList();
        this.rifts.forEach(entity -> list.func_74742_a((NBTBase)NBTUtil.func_186862_a((UUID)entity.func_110124_au())));
        this.blackHoles.forEach(entity -> list.func_74742_a((NBTBase)NBTUtil.func_186862_a((UUID)entity.func_110124_au())));
        this.turrets.forEach(entity -> list.func_74742_a((NBTBase)NBTUtil.func_186862_a((UUID)entity.func_110124_au())));
        this.missiles.forEach(entity -> list.func_74742_a((NBTBase)NBTUtil.func_186862_a((UUID)entity.func_110124_au())));
        this.clouds.forEach(entity -> list.func_74742_a((NBTBase)NBTUtil.func_186862_a((UUID)entity.func_110124_au())));
        this.healingOrbs.forEach(entity -> list.func_74742_a((NBTBase)NBTUtil.func_186862_a((UUID)entity.func_110124_au())));
        this.tentacles.forEach(entity -> list.func_74742_a((NBTBase)NBTUtil.func_186862_a((UUID)entity.func_110124_au())));
        this.tentaclePersists.forEach(entity -> list.func_74742_a((NBTBase)NBTUtil.func_186862_a((UUID)entity.func_110124_au())));
        this.statues.forEach(entity -> list.func_74742_a((NBTBase)NBTUtil.func_186862_a((UUID)entity.func_110124_au())));
        tag.func_74782_a("minions", (NBTBase)list);
    }

    @Nullable
    public Entity[] func_70021_al() {
        return this.parts;
    }

    @Override
    public void trueDeathAction() {
        this.func_70106_y();
    }

    public void onAddedToWorld() {
        super.onAddedToWorld();
        CTHULHUS.put(this.func_145782_y(), this);
        if (this.field_70170_p.field_72995_K) {
            EventsClientRender.renderForce.put(this.func_145782_y(), (Entity)this);
            if (((Boolean)this.field_70180_af.func_187225_a(FIRST_SPAWN)).booleanValue()) {
                this.playAnimation("spawn", 1.0f);
            }
            this.playAnimation("idle", 1.0f);
            if (this.isBarrierActive()) {
                this.playAnimation("break_idle", 1.0f);
            }
        } else {
            this.func_70690_d(new PotionEffect(PotionInit.PROTECTED, 320, 0, false, false));
        }
        if (((Boolean)this.field_70180_af.func_187225_a(FIRST_SPAWN)).booleanValue()) {
            this.field_70180_af.func_187227_b(FIRST_SPAWN, (Object)false);
        }
    }

    public void onRemovedFromWorld() {
        super.onRemovedFromWorld();
        CTHULHUS.remove(this.func_145782_y());
    }

    @Override
    public void func_70037_a(CompoundTag tag) {
        super.func_70037_a(tag);
        this.setPhase(tag.func_74762_e("phase"));
        this.setBarrierActive(tag.func_74767_n("barrier"));
        this.setActivated(tag.func_74767_n("activated"));
        this.currentAttack = tag.func_74762_e("currentAttack");
        this.attackTimer = tag.func_74762_e("attackTimer");
        if (!this.field_70170_p.field_72995_K) {
            NBTTagList list = tag.func_150295_c("minions", 10);
            for (NBTBase base : list) {
                if (!(base instanceof CompoundTag)) continue;
                UUID uuid = NBTUtil.func_186860_b((CompoundTag)((CompoundTag)base));
                Entity entity = this.field_70170_p.func_73046_m().func_175576_a(uuid);
                this.registerMinion(entity);
            }
        }
    }

    @Override
    public AnimationHandler getAnimationHandler() {
        return this.handler;
    }

    public void registerMinion(Entity entity) {
        if (entity instanceof EntityCthulhuRift) {
            this.rifts.add((EntityCthulhuRift)entity);
        } else if (entity instanceof EntityCthulhuBlackHole) {
            this.blackHoles.add((EntityCthulhuBlackHole)entity);
        } else if (entity instanceof EntityCthulhuTurret) {
            this.turrets.add((EntityCthulhuTurret)entity);
        } else if (entity instanceof EntityCthulhuMissile) {
            this.missiles.add((EntityCthulhuMissile)entity);
        } else if (entity instanceof EntityCthulhuCloud) {
            this.clouds.add((EntityCthulhuCloud)entity);
        } else if (entity instanceof EntityCthulhuHealingOrb) {
            this.healingOrbs.add((EntityCthulhuHealingOrb)entity);
        } else if (entity instanceof EntityCthulhuTentaclePersist) {
            this.tentaclePersists.add((EntityCthulhuTentaclePersist)entity);
        } else if (entity instanceof EntityCthulhuTentacle) {
            this.tentacles.add((EntityCthulhuTentacle)entity);
        } else if (entity instanceof EntityCelestialStatue) {
            this.statues.add((EntityCelestialStatue)entity);
        }
    }

    public void setPhase(int phase) {
        this.field_70180_af.func_187227_b(PHASE, (Object)phase);
    }

    public int getPhase() {
        return (Integer)this.field_70180_af.func_187225_a(PHASE);
    }

    public void setActivated(boolean flag) {
        this.field_70180_af.func_187227_b(ACTIVATED, (Object)flag);
    }

    public boolean isActivated() {
        return (Boolean)this.field_70180_af.func_187225_a(ACTIVATED);
    }

    @Override
    public int numberOfLives() {
        return 15000;
    }

    @Override
    public boolean attackEntityFromPart(LivingEntity part, DamageSource source, float damage) {
        return this.func_70097_a(source, damage);
    }

    public Level func_82194_d() {
        return this.field_70170_p;
    }
}

