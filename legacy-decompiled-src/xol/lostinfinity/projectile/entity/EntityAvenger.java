/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.potion.Potion
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.EnumParticleTypes
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.world.World
 *  net.minecraft.world.ServerLevel
 */
package xol.lostinfinity.projectile.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.base.EntityImmaterial;
import xol.lostinfinity.projectile.entity.EntityAvengerLightning;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;
import xol.lostinfinity.util.PotionBasic;
import xol.lostinfinity.util.data.CustomDamageResult;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class EntityAvenger
extends EntityBaseThrowable {
    private boolean rebound = false;
    private double speed = 0.1;
    private ArrayList<Entity> entitiesHit = null;
    private boolean returned = false;
    private static final double bounceRadius = 8.0;

    public EntityAvenger(Level par1World) {
        super(par1World);
        this.func_70105_a(0.75f, 0.75f);
    }

    public EntityAvenger(Level par1World, LivingEntity par2Mob) {
        super(par1World, par2Mob);
        this.func_70105_a(0.75f, 0.75f);
    }

    public EntityAvenger(Level par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
        this.func_70105_a(0.75f, 0.75f);
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (!this.field_70170_p.field_72995_K) {
            if (this.entitiesHit == null) {
                this.entitiesHit = new ArrayList();
            }
            if (result.field_72308_g != null && this.func_85052_h() != null) {
                LivingEntity thrower = this.func_85052_h();
                if (!result.field_72308_g.equals((Object)thrower) && result.field_72308_g instanceof LivingEntity && !this.entitiesHit.contains(result.field_72308_g)) {
                    LivingEntity target = (LivingEntity)result.field_72308_g;
                    float target_pre = target.func_110143_aJ();
                    CustomDamageResult dr = IMaxAttack.dealTrueDamage((Entity)this, target, target.func_110138_aP() * 0.5f, Arrays.asList("Aquatic"));
                    float damageDealt = dr.getDamageDealt();
                    if (dr.didSuccessfulHit()) {
                        this.field_70170_p.func_184133_a(null, this.func_180425_c(), SoundInit.SWING_HIT, SoundSource.PLAYERS, 1.5f, 0.6f + this.field_70146_Z.nextFloat() * 0.4f);
                        boolean bounced = false;
                        for (LivingEntity entity : this.field_70170_p.func_72872_a(LivingEntity.class, new AABB(this.func_180425_c()).func_186662_g(8.0))) {
                            if (entity.func_110124_au().equals(thrower.func_110124_au()) || entity.func_110124_au().equals(target.func_110124_au()) || entity instanceof EntityImmaterial) continue;
                            EntityAvengerLightning lightning = new EntityAvengerLightning(this.field_70170_p);
                            lightning.func_70107_b(thrower.field_70165_t, target.field_70163_u, target.field_70161_v);
                            lightning.setOrigin(target);
                            lightning.setTarget(entity);
                            this.field_70170_p.func_72838_d((Entity)lightning);
                            bounced = true;
                        }
                        if (bounced) {
                            this.field_70170_p.func_184133_a(null, this.func_180425_c(), SoundInit.ELECTRIC_SHOCK, SoundSource.PLAYERS, 1.5f, 0.6f + this.field_70146_Z.nextFloat() * 0.4f);
                        }
                    }
                    if (dr.wasTargetKilled()) {
                        this.killReward(this.func_85052_h());
                    } else if (dr.didSuccessfulHit()) {
                        this.func_85052_h().func_70691_i(damageDealt);
                    }
                    this.entitiesHit.add((Entity)target);
                    IParticleSpawner.spawnParticle(this.field_70170_p, 28, 0, target.field_70165_t, target.field_70163_u + (double)(target.field_70131_O / 2.0f), target.field_70161_v);
                    ((ServerLevel)this.field_70170_p).func_175739_a(EnumParticleTypes.SWEEP_ATTACK, this.field_70165_t, this.field_70163_u, this.field_70161_v, 5, -0.5 + this.field_70146_Z.nextDouble(), 0.3, -0.5 + this.field_70146_Z.nextDouble(), (double)0.15f, new int[0]);
                } else if (result.field_72308_g.equals((Object)thrower) && thrower instanceof Player && !this.returned) {
                    Player player = (Player)thrower;
                    boolean found = false;
                    for (int i = 0; i < player.field_71071_by.func_70302_i_(); ++i) {
                        ItemStack playerStack = player.field_71071_by.func_70301_a(i);
                        if (playerStack.func_77973_b() != ItemInit.avenger) continue;
                        playerStack.func_77978_p().func_74768_a("empty_data", 0);
                        player.field_71071_by.func_70299_a(i, playerStack);
                        found = true;
                        break;
                    }
                    if (!found) {
                        player.field_71071_by.func_70441_a(new ItemStack(ItemInit.avenger));
                    }
                    this.returned = true;
                    this.func_70106_y();
                }
            }
            if (this.field_70192_c == null) {
                this.func_70106_y();
            }
            if (result.field_72308_g != null || this.field_70170_p.func_180495_p(result.func_178782_a()).func_185904_a().func_76230_c()) {
                this.rebound = true;
            }
        }
    }

    @Override
    public void func_70071_h_() {
        super.func_70071_h_();
        if (!this.field_70170_p.field_72995_K) {
            if (this.rebound) {
                LivingEntity thrower = this.func_85052_h();
                if (thrower != null) {
                    Vec3 dir = thrower.func_174791_d().func_178787_e(new Vec3(0.0, (double)thrower.field_70131_O / 1.5, 0.0)).func_178788_d(this.func_174791_d());
                    if (dir.func_72433_c() < 3.5 && thrower instanceof Player && !this.field_70128_L && !this.returned) {
                        boolean found = false;
                        Player player = (Player)thrower;
                        for (int i = 0; i < player.field_71071_by.func_70302_i_(); ++i) {
                            ItemStack playerStack = player.field_71071_by.func_70301_a(i);
                            if (playerStack.func_77973_b() != ItemInit.avenger) continue;
                            playerStack.func_77978_p().func_74768_a("empty_data", 0);
                            player.field_71071_by.func_70299_a(i, playerStack);
                            found = true;
                            break;
                        }
                        if (!found) {
                            player.field_71071_by.func_70441_a(new ItemStack(ItemInit.avenger));
                        }
                        this.returned = true;
                        this.func_70106_y();
                    }
                    dir = dir.func_72432_b();
                    this.field_70159_w = dir.field_72450_a * this.speed;
                    this.field_70181_x = dir.field_72448_b * this.speed;
                    this.field_70179_y = dir.field_72449_c * this.speed;
                    if (this.speed < 1.5) {
                        this.speed += 0.1;
                    }
                    this.field_70133_I = true;
                }
            } else {
                this.field_70159_w *= 0.96;
                this.field_70181_x *= 0.96;
                this.field_70179_y *= 0.96;
                this.field_70133_I = true;
                if (this.field_70173_aa > 40) {
                    this.rebound = true;
                }
            }
        } else {
            this.field_70170_p.func_175688_a(ParticleInit.SPECTRAL, this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.25 * (-0.5 + this.field_70146_Z.nextDouble()), 0.0, 0.25 * (-0.5 + this.field_70146_Z.nextDouble()), new int[0]);
        }
    }

    protected float func_70185_h() {
        return 0.0f;
    }

    private void killReward(LivingEntity player) {
        ArrayList<PotionEffect> potionsToAdd = new ArrayList<PotionEffect>();
        List potionList = player.func_70651_bq().stream().map(PotionEffect::func_188419_a).collect(Collectors.toList());
        for (Potion potion : potionList) {
            if (potion instanceof PotionBasic) {
                PotionBasic lost_potion = (PotionBasic)potion;
                PotionEffect scaledEffect = this.scalePotionEffect(player.func_70660_b(potion), lost_potion.negativeLostEffect());
                if (scaledEffect == null) continue;
                potionsToAdd.add(scaledEffect);
                continue;
            }
            PotionEffect scaledEffect = this.scalePotionEffect(player.func_70660_b(potion), potion.func_76398_f());
            if (scaledEffect == null) continue;
            potionsToAdd.add(scaledEffect);
        }
        player.func_70674_bp();
        for (PotionEffect pe : potionsToAdd) {
            player.func_70690_d(pe);
        }
        player.func_70691_i(player.func_110138_aP());
    }

    private PotionEffect scalePotionEffect(PotionEffect effect, boolean bad) {
        if (!bad) {
            return effect;
        }
        int level = effect.func_76458_c() - 1;
        int duration = effect.func_76459_b();
        if (level >= 0) {
            return new PotionEffect(effect.func_188419_a(), duration, level);
        }
        return null;
    }
}

