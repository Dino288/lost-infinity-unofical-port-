/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.player.Player
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.murk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.PotionInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.ai.EntityAIFloatAttack;
import xol.lostinfinity.mob.entity.base.EntityFloatingBase;
import xol.lostinfinity.projectile.entity.EntityDoomBlast;
import xol.lostinfinity.projectile.entity.EntityDoomShot;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.load.LootTableRegistry;

public class EntityDoomsday
extends EntityFloatingBase
implements IMaxAttack {
    private ArrayList<Player> targetList = new ArrayList();
    private Map<Player, Vec3> rootPositions = new HashMap<Player, Vec3>();

    public EntityDoomsday(Level worldIn) {
        super(worldIn);
        this.func_70105_a(3.0f, 7.0f);
        this.rawFlySpeed = 0.95f;
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null) {
            IMaxAttack.dealMaxHealth((Entity)this, this.func_70638_az(), 2, Arrays.asList("Darkborn"));
            return true;
        }
        return false;
    }

    @Override
    public void func_70636_d() {
        super.func_70636_d();
        if (!this.field_70170_p.field_72995_K) {
            if (this.field_70163_u > 110.0) {
                this.field_70181_x = -2.0;
                this.field_70133_I = true;
            }
            int meteorRemain = this.field_70173_aa % 800;
            if (this.field_70173_aa % 5 == 0) {
                this.targetList.clear();
                int radius = 55;
                boolean fired = false;
                AABB pullBox = new AABB(this.func_180425_c()).func_186662_g((double)radius);
                for (Player entityPlayer : this.field_70170_p.func_72872_a(Player.class, pullBox)) {
                    if (entityPlayer.func_184812_l_()) continue;
                    this.targetList.add(entityPlayer);
                    if (entityPlayer.func_70032_d((Entity)this) > (float)(radius - 5)) {
                        Vec3 dir = this.func_174791_d().func_178788_d(entityPlayer.func_174791_d());
                        dir = dir.func_72432_b();
                        entityPlayer.func_70024_g(dir.field_72450_a / 3.0, dir.field_72448_b / 3.0 + (double)0.1f, dir.field_72449_c / 3.0);
                        entityPlayer.field_70133_I = true;
                        continue;
                    }
                    if (this.field_70173_aa % 400 == 200) {
                        entityPlayer.func_70690_d(new PotionEffect(PotionInit.ULTRAHEAVY, 100, 2));
                    }
                    if (this.field_70173_aa % 20 != 0 && (meteorRemain <= 700 || this.field_70173_aa % 5 != 0)) continue;
                    fired = true;
                    double makeX = (this.func_174813_aQ().field_72340_a + this.func_174813_aQ().field_72336_d) / 2.0;
                    double makeY = this.field_70163_u + (double)(this.field_70131_O / 2.0f) + 0.5;
                    double makeZ = (this.func_174813_aQ().field_72339_c + this.func_174813_aQ().field_72334_f) / 2.0;
                    double d2 = entityPlayer.field_70165_t - makeX;
                    double d3 = entityPlayer.field_70163_u - makeY;
                    double d4 = entityPlayer.field_70161_v - makeZ;
                    EntityDoomBlast shot = new EntityDoomBlast(this.field_70170_p, (LivingEntity)this);
                    float speed = 1.5f;
                    shot.func_70186_c(d2, d3, d4, speed, 1.0f);
                    shot.setThrower((LivingEntity)this);
                    this.field_70170_p.func_72838_d((Entity)shot);
                }
                if (fired) {
                    this.field_70170_p.func_184133_a(null, this.func_180425_c(), SoundInit.DOOMSDAY_SPELL_2, SoundSource.HOSTILE, 1.5f, 0.8f + this.field_70146_Z.nextFloat() * 0.4f);
                }
            }
            if (meteorRemain > 100 && meteorRemain < 500 && this.field_70173_aa % 2 == 0) {
                EntityDoomShot shot = new EntityDoomShot(this.field_70170_p, this.field_70165_t + this.getROD(60), this.field_70163_u + 50.0, this.field_70161_v + this.getROD(60));
                shot.setThrower((LivingEntity)this);
                shot.func_70186_c(0.0, -0.15, 0.0, 0.7f, 0.0f);
                this.field_70170_p.func_72838_d((Entity)shot);
                if (this.field_70146_Z.nextInt(10) == 0) {
                    this.field_70170_p.func_184133_a(null, this.func_180425_c(), SoundInit.DOOMSDAY_SPELL_1, SoundSource.HOSTILE, 1.5f, 0.8f + this.field_70146_Z.nextFloat() * 0.4f);
                }
            }
            if (this.targetList.size() > 0) {
                int rootRemain = this.field_70173_aa % 600;
                if (rootRemain == 80) {
                    this.rootPositions.clear();
                    for (Player targetPlayer : this.targetList) {
                        this.rootPositions.put(targetPlayer, targetPlayer.func_174791_d());
                        targetPlayer.func_145747_a((Component)new Component((Object)((Object)TextFmt.Light_Purple) + "Stay put. Your efforts are futile!"));
                    }
                }
                if (rootRemain > 80 && rootRemain < 200) {
                    double pullSpeed = 0.4;
                    if (this.rootPositions.size() > 0) {
                        for (Map.Entry entry : this.rootPositions.entrySet()) {
                            Player targetPlayer = (Player)entry.getKey();
                            Vec3 rootPos = (Vec3)entry.getValue();
                            double x = targetPlayer.field_70165_t;
                            double y = targetPlayer.field_70163_u;
                            double z = targetPlayer.field_70161_v;
                            double dist = rootPos.func_72438_d(targetPlayer.func_174791_d());
                            if (!(dist > 0.0)) continue;
                            double diffX = rootPos.field_72450_a - x;
                            double diffY = rootPos.field_72448_b - y;
                            double diffZ = rootPos.field_72449_c - z;
                            Vec3 dir = new Vec3(diffX, diffY, diffZ);
                            dir.func_72432_b();
                            targetPlayer.field_70159_w = dir.field_72450_a * pullSpeed;
                            targetPlayer.field_70181_x = dir.field_72448_b * pullSpeed;
                            targetPlayer.field_70179_y = dir.field_72449_c * pullSpeed;
                            targetPlayer.field_70133_I = true;
                        }
                    }
                }
            }
            if (this.func_70638_az() != null) {
                LivingEntity target = this.func_70638_az();
                this.func_70605_aq().func_75642_a(target.field_70165_t, target.field_70163_u, target.field_70161_v, 1.0);
                if (target instanceof Player && this.field_70173_aa % 200 == 130) {
                    this.func_70634_a(target.field_70165_t, target.field_70163_u + 1.0, target.field_70161_v);
                    this.field_70170_p.func_184133_a(null, this.func_180425_c(), SoundInit.DOOMSDAY_TELEPORT, SoundSource.HOSTILE, 1.5f, 1.0f);
                    target.func_145747_a((Component)new Component((Object)((Object)TextFmt.Dark_Blue) + "You cannot escape the darkness."));
                }
            }
        }
    }

    @Override
    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(5000.0);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.25);
        this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a(1.0);
    }

    protected SoundEvent func_184615_bR() {
        return SoundInit.DOOMSDAY_DEATH;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundInit.DOOMSDAY_HURT;
    }

    protected SoundEvent func_184639_G() {
        return SoundInit.DOOMSDAY_AMBIENT;
    }

    @Override
    protected int numberOfLives() {
        return 100;
    }

    @Override
    protected void updateLifeAction() {
        int lifePercent = Math.round(100 * (this.numberOfLives() - this.getLivesCount()) / this.numberOfLives());
        AABB pullBox = new AABB(this.func_180425_c()).func_186662_g(45.0);
        for (Player entity : this.field_70170_p.func_72872_a(Player.class, pullBox)) {
            entity.func_145747_a((Component)new Component((Object)((Object)TextFmt.Gold) + "Doomsday is at " + lifePercent + "% health."));
        }
    }

    protected boolean func_70692_ba() {
        return false;
    }

    protected ResourceLocation func_184647_J() {
        return LootTableRegistry.ENTITIES_DOOMSDAY;
    }

    @Override
    protected EntityAIFloatAttack createShootAI() {
        return null;
    }

    private double getROD(int multi) {
        return (-0.5 + this.field_70146_Z.nextDouble()) * (double)multi;
    }
}

