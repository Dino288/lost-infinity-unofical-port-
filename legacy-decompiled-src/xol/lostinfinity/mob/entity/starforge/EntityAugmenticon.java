/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.PathfinderMob
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.player.Player
 *  net.minecraft.entity.projectile.EntityArrow
 *  net.minecraft.entity.projectile.EntityThrowable
 *  net.minecraft.init.MobEffects
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.EnumParticleTypes
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 *  net.minecraft.world.ServerLevel
 */
package xol.lostinfinity.mob.entity.starforge;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.PotionInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.ai.IBasicAI;
import xol.lostinfinity.mob.entity.base.EntityMultipleLives;
import xol.lostinfinity.mob.entity.starforge.EntityGloboon;
import xol.lostinfinity.mob.entity.starforge.EntityRavager;
import xol.lostinfinity.mob.entity.starforge.EntitySightwalker;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;
import xol.lostinfinity.projectile.entity.EntityClusterBlast;
import xol.lostinfinity.projectile.entity.EntityExplosiveGoo;
import xol.lostinfinity.projectile.entity.EntityTetherBall;
import xol.lostinfinity.util.coordinates.GalaxyCoordinates;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.fx.IParticleSpawner;
import xol.lostinfinity.util.load.LootTableRegistry;

public class EntityAugmenticon
extends EntityMultipleLives
implements IMaxAttack,
IBasicAI {
    private List<String> abilities = new ArrayList<String>();
    private String lastAbility = "none";
    private boolean lastTextBlue = false;

    public EntityAugmenticon(Level worldIn) {
        super(worldIn);
        this.func_70105_a(3.0f, 3.0f);
    }

    @Override
    protected void func_184651_r() {
        this.initBasicTasks((PathfinderMob)this);
    }

    private int getAbilityTimer() {
        return Math.max(80 - 5 * this.abilities.size(), 20);
    }

    public void addAbility(String ability) {
        this.abilities.add(ability);
    }

    private String getRandomAbility() {
        int pick = this.field_70146_Z.nextInt(this.abilities.size());
        return this.abilities.get(pick);
    }

    private AABB getArenaAABB() {
        return GalaxyCoordinates.getAugmenticonAABB();
    }

    @Override
    protected void updateLifeAction() {
        int lifePercent = Math.round(100 * (this.numberOfLives() - this.getLivesCount()) / this.numberOfLives());
        AABB pullBox = new AABB(this.func_180425_c()).func_186662_g(45.0);
        for (Player entity : this.field_70170_p.func_72872_a(Player.class, pullBox)) {
            entity.func_145747_a((Component)new Component((Object)((Object)TextFmt.Gold) + "The Augmenticon is at " + lifePercent + "% health."));
        }
    }

    private void doAbility(String abilityName) {
        this.lastAbility = abilityName;
        switch (abilityName) {
            case "dash": {
                this.abilityDash();
                break;
            }
            case "slam": {
                this.abilitySlam();
                break;
            }
            case "invisibility": {
                this.abilityInvisibility();
                break;
            }
            case "forcefield": {
                this.abilityForcefield();
                break;
            }
            case "teleport": {
                this.abilityTeleport();
                break;
            }
            case "heal": {
                this.abilityHeal();
                break;
            }
            case "hurt": {
                this.abilityHurt();
                break;
            }
            case "summon": {
                this.abilitySummon();
                break;
            }
            case "blight": {
                this.abilityBlight();
                break;
            }
            case "plague": {
                this.abilityPlague();
                break;
            }
            case "emp": {
                this.abilityEMP();
                break;
            }
            case "shatter": {
                this.abilityShatter();
                break;
            }
            case "tether": {
                this.abilityTether();
                break;
            }
            case "unleash": {
                this.abilityUnleash();
                break;
            }
            case "gravity": {
                this.abilityGravity();
                break;
            }
            case "nightmares": {
                this.abilityNightmares();
                break;
            }
            case "explosive": {
                this.abilityExplosive();
                break;
            }
            case "trailing": {
                this.abilityTrailing();
                break;
            }
            case "destructive": {
                this.abilityDestructive();
                break;
            }
            case "regenerative": {
                this.abilityRegenerative();
            }
        }
    }

    private void abilityRegenerative() {
        this.messagePlayers("REGENERATIVE");
        int maxLives = this.numberOfLives();
        int curLives = this.remainingLives();
        if (maxLives / 10 + curLives < maxLives) {
            this.setLivesCount(maxLives / 10 + curLives);
        } else {
            this.setLivesCount(maxLives);
        }
    }

    private void abilityDestructive() {
        this.messagePlayers("DESTRUCTIVE");
    }

    private void abilityTrailing() {
        this.messagePlayers("TRAILING");
    }

    private void abilityExplosive() {
        this.messagePlayers("EXPLOSIVE");
        if (this.func_70638_az() != null) {
            LivingEntity target = this.func_70638_az();
            this.func_70024_g((target.field_70165_t - this.field_70165_t) * 0.145, 0.6, (target.field_70161_v - this.field_70161_v) * 0.145);
            this.field_70133_I = true;
        }
    }

    private void abilityNightmares() {
        this.messagePlayers("NIGHTMARES");
        BlockPos spawn1 = new BlockPos(1575, 10, -540);
        BlockPos spawn2 = new BlockPos(1565, 10, -556);
        BlockPos spawn3 = new BlockPos(1578, 10, -563);
        EntitySightwalker walker1 = new EntitySightwalker(this.field_70170_p);
        walker1.func_70634_a(spawn1.func_177958_n(), spawn1.func_177956_o(), spawn1.func_177952_p());
        this.field_70170_p.func_72838_d((Entity)walker1);
        EntitySightwalker walker2 = new EntitySightwalker(this.field_70170_p);
        walker2.func_70634_a(spawn2.func_177958_n(), spawn2.func_177956_o(), spawn2.func_177952_p());
        this.field_70170_p.func_72838_d((Entity)walker2);
        EntityRavager ravager = new EntityRavager(this.field_70170_p);
        ravager.func_70634_a(spawn3.func_177958_n(), spawn3.func_177956_o(), spawn3.func_177952_p());
        this.field_70170_p.func_72838_d((Entity)ravager);
    }

    private void abilityGravity() {
        this.messagePlayers("GRAVITY");
        this.func_70690_d(new PotionEffect(PotionInit.GRAVITATIONAL, 100, 4));
    }

    private void abilityUnleash() {
        this.messagePlayers("UNLEASH");
        this.func_70690_d(new PotionEffect(PotionInit.UNLEASHING, 200, 4));
    }

    private void abilityTether() {
        this.messagePlayers("TETHER");
    }

    private void abilityShatter() {
        this.messagePlayers("SHATTER");
        for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.getArenaAABB())) {
            near_pl.func_70690_d(new PotionEffect(PotionInit.SHATTERED, 200, 3));
        }
    }

    private void abilityEMP() {
        this.messagePlayers("EMP");
        for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.getArenaAABB())) {
            near_pl.func_70690_d(new PotionEffect(PotionInit.NULLIFIED, 200));
        }
    }

    private void abilityPlague() {
        this.messagePlayers("PLAGUE");
        for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.getArenaAABB())) {
            near_pl.func_70690_d(new PotionEffect(PotionInit.PLAGUE, this.getAbilityTimer(), 4));
        }
    }

    private void abilityBlight() {
        this.messagePlayers("BLIGHT");
        for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.getArenaAABB())) {
            near_pl.func_70690_d(new PotionEffect(PotionInit.BLIGHTED, 200, 5));
        }
    }

    private void abilityTeleport() {
        block0: {
            this.messagePlayers("TELEPORT");
            Iterator iterator = this.field_70170_p.func_72872_a(Player.class, this.getArenaAABB()).iterator();
            if (!iterator.hasNext()) break block0;
            Player near_pl = (Player)iterator.next();
            this.func_70634_a(near_pl.field_70165_t, near_pl.field_70163_u, near_pl.field_70161_v);
        }
    }

    private void abilityHeal() {
        this.messagePlayers("HEAL");
        this.setLivesCount(Math.max(this.getLivesCount() - 5, 0));
    }

    private void abilityHurt() {
        this.messagePlayers("HURT");
        for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.getArenaAABB())) {
            IMaxAttack.dealMaxHealth((Entity)this, (LivingEntity)near_pl, 2);
        }
    }

    private void abilitySummon() {
        this.messagePlayers("SUMMON");
        EntityGloboon globoon = new EntityGloboon(this.field_70170_p);
        globoon.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
        this.field_70170_p.func_72838_d((Entity)globoon);
    }

    private void abilityDash() {
        this.messagePlayers("DASH");
        if (this.func_70638_az() != null) {
            LivingEntity target = this.func_70638_az();
            this.func_70024_g((target.field_70165_t - this.field_70165_t) * 0.145, 0.6, (target.field_70161_v - this.field_70161_v) * 0.145);
            this.field_70133_I = true;
        }
    }

    private void abilitySlam() {
        this.messagePlayers("GROUND SLAM");
        this.func_70024_g(0.0, 2.0, 0.0);
        this.field_70133_I = true;
    }

    private void abilityInvisibility() {
        this.messagePlayers("INVISIBLE");
        this.func_70690_d(new PotionEffect(MobEffects.field_76441_p, this.getAbilityTimer()));
    }

    private void abilityForcefield() {
        this.messagePlayers("DESTROY PROJECTILES");
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null) {
            IMaxAttack.dealMaxHealth((Entity)this, this.func_70638_az(), 3);
            return true;
        }
        return false;
    }

    public void func_70636_d() {
        super.func_70636_d();
        if (!this.field_70170_p.field_72995_K && this.field_70173_aa > 5) {
            Iterator iterator;
            if (this.func_70638_az() == null && (iterator = this.field_70170_p.func_72872_a(Player.class, this.getArenaAABB()).iterator()).hasNext()) {
                Player near_pl = (Player)iterator.next();
                this.func_70624_b((LivingEntity)near_pl);
            }
            if (this.abilities.isEmpty()) {
                this.func_70106_y();
            } else {
                LivingEntity target;
                EntityBaseThrowable shot;
                if (this.field_70173_aa % this.getAbilityTimer() == 0) {
                    this.doAbility(this.getRandomAbility());
                }
                if (this.lastAbility.equals("forcefield")) {
                    for (Entity detected : this.field_70170_p.func_72872_a(Entity.class, this.func_174813_aQ().func_72314_b(15.0, 10.0, 15.0))) {
                        if (!(detected instanceof EntityThrowable) && !(detected instanceof EntityArrow)) continue;
                        detected.func_70106_y();
                        detected.func_184185_a(SoundInit.ITEM_AXIOMAVORUM, 1.0f, 0.5f + this.field_70146_Z.nextFloat());
                        ((ServerLevel)this.field_70170_p).func_175739_a(EnumParticleTypes.LAVA, detected.field_70165_t, detected.field_70163_u, detected.field_70161_v, 2, (-0.5 + this.field_70146_Z.nextDouble()) * 3.0, 0.3, (-0.5 + this.field_70146_Z.nextDouble()) * 3.0, (double)0.15f, new int[0]);
                        for (Player target2 : this.field_70170_p.func_72872_a(Player.class, detected.func_174813_aQ().func_72314_b(5.0, 5.0, 5.0))) {
                            IMaxAttack.dealMaxHealth((Entity)this, (LivingEntity)target2, 1);
                        }
                    }
                }
                if (this.lastAbility.equals("tether") && (this.field_70173_aa % this.getAbilityTimer() == 0 || this.field_70173_aa % this.getAbilityTimer() == this.getAbilityTimer() / 3 || this.field_70173_aa % this.getAbilityTimer() == 2 * this.getAbilityTimer() / 3)) {
                    float speed = 1.0f;
                    for (double i = 0.0; i < Math.PI * 2; i += 0.7853981633974483) {
                        double x = Math.cos(i);
                        double z = Math.sin(i);
                        double makeX = (this.func_174813_aQ().field_72340_a + this.func_174813_aQ().field_72336_d) / 2.0;
                        double makeY = this.field_70163_u + 1.0;
                        double makeZ = (this.func_174813_aQ().field_72339_c + this.func_174813_aQ().field_72334_f) / 2.0;
                        shot = new EntityTetherBall(this.field_70170_p, makeX, makeY, makeZ);
                        shot.setThrower((LivingEntity)this);
                        shot.func_70186_c(x, 0.0, z, speed, 0.0f);
                        this.field_70170_p.func_72838_d((Entity)shot);
                    }
                }
                if (this.lastAbility.equals("explosive") && this.field_70173_aa % this.getAbilityTimer() == this.getAbilityTimer() / 4) {
                    for (Player target3 : this.field_70170_p.func_72872_a(Player.class, this.func_174813_aQ().func_72314_b(8.0, 8.0, 8.0))) {
                        IMaxAttack.dealTrueDamage((Entity)this, (LivingEntity)target3, target3.func_110138_aP() * 0.75f);
                    }
                    CustomParticleConfig config1 = new CustomParticleConfig();
                    config1.createInstance().setParticle(ParticleInit.EXPLOSION_RING).setSpread(7.0, 1.0, 7.0).setCount(4).setIgnoreRange(true);
                    IParticleSpawner.spawnParticle(this.field_70170_p, config1, this.field_70165_t, this.field_70163_u, this.field_70161_v);
                    this.field_70170_p.func_184148_a(null, this.field_70165_t, this.field_70163_u, this.field_70161_v, SoundInit.GENERIC_WEAPON_6, SoundSource.HOSTILE, 1.0f, 0.8f + 0.4f * this.field_70146_Z.nextFloat());
                }
                if (this.lastAbility.equals("trailing") && this.field_70173_aa % 3 == 0 && this.field_70170_p.func_180495_p(this.func_180425_c().func_177977_b()).func_185914_p() && this.field_70170_p.func_180495_p(this.func_180425_c()).func_185904_a().func_76222_j()) {
                    this.field_70170_p.func_175656_a(this.func_180425_c(), BlockInit.acidicGel.func_176223_P());
                }
                if (this.lastAbility.equals("destructive") && this.field_70173_aa % 10 == 0 && (target = this.func_70638_az()) != null) {
                    double makeX = (this.func_174813_aQ().field_72340_a + this.func_174813_aQ().field_72336_d) / 2.0;
                    double makeY = this.field_70163_u + 0.6;
                    double makeZ = (this.func_174813_aQ().field_72339_c + this.func_174813_aQ().field_72334_f) / 2.0;
                    double d2 = target.field_70165_t - makeX;
                    double d3 = target.func_174813_aQ().field_72338_b + (double)(target.field_70131_O / 2.0f) - makeY;
                    double d4 = target.field_70161_v - makeZ;
                    if (this.field_70146_Z.nextBoolean()) {
                        shot = new EntityExplosiveGoo(this.field_70170_p, makeX, makeY, makeZ);
                        shot.setThrower((LivingEntity)this);
                        ((EntityExplosiveGoo)shot).setDenomAndSize(5, 3);
                        shot.func_70186_c(d2, d3, d4, 1.5f, 0.0f);
                        this.field_70170_p.func_72838_d((Entity)shot);
                        CustomParticleConfig config1 = new CustomParticleConfig();
                        config1.createInstance().setParticle(ParticleInit.FIREGOO).setSpread(1.0, 1.0, 1.0).setSpeed(1.0, 1.0, 1.0).setVelSpread(1.0, 1.0, 1.0).setCount(8).setIgnoreRange(true);
                        IParticleSpawner.spawnParticle(this.field_70170_p, config1, makeX, makeY, makeZ);
                        this.field_70170_p.func_184148_a(null, this.field_70165_t, this.field_70163_u, this.field_70161_v, SoundInit.GALAXYFIRE, SoundSource.HOSTILE, 2.0f, 1.0f);
                    } else {
                        shot = new EntityClusterBlast(this.field_70170_p, makeX, makeY, makeZ);
                        shot.setThrower((LivingEntity)this);
                        shot.func_70186_c(d2, d3 + 7.0, d4, 1.5f, 0.0f);
                        this.field_70170_p.func_72838_d((Entity)shot);
                        CustomParticleConfig config1 = new CustomParticleConfig();
                        config1.createInstance().setParticle(ParticleInit.CRYSTAL_MAGIC).setSpread(4.0, 1.0, 4.0).setCount(10).setIgnoreRange(true);
                        IParticleSpawner.spawnParticle(this.field_70170_p, config1, makeX, makeY, makeZ);
                        this.field_70170_p.func_184148_a(null, this.field_70165_t, this.field_70163_u, this.field_70161_v, SoundInit.CLUSTER_FIRE, SoundSource.HOSTILE, 2.0f, 0.8f + this.field_70146_Z.nextFloat() * 0.4f);
                    }
                }
            }
        }
    }

    public void func_180430_e(float distance, float damageMultiplier) {
        if (!this.field_70170_p.field_72995_K && this.lastAbility.equals("slam")) {
            for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.func_174813_aQ().func_72314_b(6.0, 6.0, 6.0))) {
                IMaxAttack.dealMaxHealth((Entity)this, (LivingEntity)near_pl, 2);
            }
            ((ServerLevel)this.field_70170_p).func_175739_a(EnumParticleTypes.SWEEP_ATTACK, this.field_70165_t - 1.0 + this.field_70146_Z.nextDouble() * 2.0, this.field_70163_u + 0.5, this.field_70161_v - 1.0 + this.field_70146_Z.nextDouble() * 2.0, 5, (-0.5 + this.field_70146_Z.nextDouble()) * 3.0, 0.3, (-0.5 + this.field_70146_Z.nextDouble()) * 3.0, (double)0.15f, new int[0]);
        }
    }

    private void messagePlayers(String message) {
        this.lastTextBlue = !this.lastTextBlue;
        this.func_184185_a(this.lastTextBlue ? SoundInit.AUGMENTICON_TALK1 : SoundInit.AUGMENTICON_TALK2, 1.0f, 0.75f + this.field_70146_Z.nextFloat() * 0.5f);
        for (Player contender : this.field_70170_p.func_72872_a(Player.class, this.func_174813_aQ().func_186662_g(30.0))) {
            contender.func_145747_a((Component)new Component((Object)((Object)(this.lastTextBlue ? TextFmt.Dark_Aqua : TextFmt.Gold)) + "Augmenticon: " + message));
        }
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(5000.0);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.25);
        this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a(1.0);
    }

    protected SoundEvent func_184615_bR() {
        return SoundInit.AUGMENTICON_DEATH;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundInit.AUGMENTICON_HURT;
    }

    protected SoundEvent func_184639_G() {
        return null;
    }

    @Override
    protected int numberOfLives() {
        return 100;
    }

    protected boolean func_70692_ba() {
        return false;
    }

    protected ResourceLocation func_184647_J() {
        return this.onFinalLife() ? this.lootTableQuality() : null;
    }

    private ResourceLocation lootTableQuality() {
        int abilityCount = this.abilities.size();
        if (abilityCount < 4) {
            return LootTableRegistry.ENTITIES_AUGMENTICON_0;
        }
        if (abilityCount < 8) {
            return LootTableRegistry.ENTITIES_AUGMENTICON_1;
        }
        if (abilityCount < 12) {
            return LootTableRegistry.ENTITIES_AUGMENTICON_2;
        }
        if (abilityCount < 16) {
            return LootTableRegistry.ENTITIES_AUGMENTICON_3;
        }
        if (abilityCount < 20) {
            return LootTableRegistry.ENTITIES_AUGMENTICON_4;
        }
        return LootTableRegistry.ENTITIES_AUGMENTICON_5;
    }
}

