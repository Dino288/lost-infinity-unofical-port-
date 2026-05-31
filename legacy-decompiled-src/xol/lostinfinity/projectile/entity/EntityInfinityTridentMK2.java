/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
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
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
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
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class EntityInfinityTridentMK2
extends EntityBaseThrowable {
    private boolean rebound = false;
    private double speed = 0.1;
    private ArrayList<LivingEntity> entitiesToHit = new ArrayList();
    int curIndex = 0;
    private boolean returned = false;
    private static final int chainRadius = 15;

    public EntityInfinityTridentMK2(Level par1World) {
        super(par1World);
        this.func_70105_a(0.75f, 0.75f);
    }

    public EntityInfinityTridentMK2(Level par1World, LivingEntity par2Mob) {
        super(par1World, par2Mob);
        this.func_70105_a(0.75f, 0.75f);
    }

    public EntityInfinityTridentMK2(Level par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
        this.func_70105_a(0.75f, 0.75f);
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (!this.field_70170_p.field_72995_K) {
            if (result.field_72308_g != null && this.func_85052_h() != null) {
                LivingEntity thrower = this.func_85052_h();
                if (this.entitiesToHit.isEmpty()) {
                    if (!result.field_72308_g.equals((Object)thrower) && result.field_72308_g instanceof LivingEntity) {
                        IMaxAttack.dealTrueDamage((Entity)this, (LivingEntity)result.field_72308_g, ((LivingEntity)result.field_72308_g).func_110138_aP() * 1.0f, Arrays.asList("Aquatic"));
                        CustomParticleConfig config1 = new CustomParticleConfig();
                        config1.createInstance().setParticle(ParticleInit.CRYSTAL_MAGIC).setSpread(4.0, 1.0, 4.0).setCount(10).setIgnoreRange(true);
                        IParticleSpawner.spawnParticle(this.field_70170_p, config1, result.field_72308_g.field_70165_t, result.field_72308_g.field_70163_u + (double)(result.field_72308_g.field_70131_O / 2.0f), result.field_72308_g.field_70161_v);
                        ((ServerLevel)this.field_70170_p).func_175739_a(EnumParticleTypes.SWEEP_ATTACK, this.field_70165_t, this.field_70163_u, this.field_70161_v, 5, -0.5 + this.field_70146_Z.nextDouble(), 0.3, -0.5 + this.field_70146_Z.nextDouble(), (double)0.15f, new int[0]);
                        this.field_70170_p.func_184133_a(null, result.field_72308_g.func_180425_c(), SoundInit.MAGIC_WEAPON_14, SoundSource.PLAYERS, 1.5f, 0.8f + 0.4f * this.field_70146_Z.nextFloat());
                        this.field_70170_p.func_184133_a(null, result.field_72308_g.func_180425_c(), SoundInit.GENERIC_SLICE, SoundSource.PLAYERS, 1.5f, 0.5f + 0.4f * this.field_70146_Z.nextFloat());
                        for (LivingEntity near : this.field_70170_p.func_72872_a(LivingEntity.class, new AABB(this.func_180425_c()).func_186662_g(15.0))) {
                            if (near.func_110124_au().equals(thrower.func_110124_au()) || near.func_110124_au().equals(this.func_110124_au()) || near instanceof EntityImmaterial) continue;
                            this.entitiesToHit.add(near);
                        }
                    }
                } else if (result.field_72308_g.equals((Object)thrower) && thrower instanceof Player && !this.returned) {
                    Player player = (Player)thrower;
                    boolean found = false;
                    for (int i = 0; i < player.field_71071_by.func_70302_i_(); ++i) {
                        ItemStack playerStack = player.field_71071_by.func_70301_a(i);
                        if (playerStack.func_77973_b() != ItemInit.infinityTridentMK2) continue;
                        playerStack.func_77978_p().func_74768_a("empty_data", 0);
                        player.field_71071_by.func_70299_a(i, playerStack);
                        found = true;
                        break;
                    }
                    if (!found) {
                        player.field_71071_by.func_70441_a(new ItemStack(ItemInit.infinityTridentMK2));
                    }
                    this.returned = true;
                    this.func_70106_y();
                } else if (!result.field_72308_g.equals((Object)thrower) && result.field_72308_g instanceof LivingEntity) {
                    LivingEntity cur = this.entitiesToHit.get(this.curIndex);
                    while (cur == null || cur.field_70128_L) {
                        if (this.curIndex < this.entitiesToHit.size() - 1) {
                            ++this.curIndex;
                            cur = this.entitiesToHit.get(this.curIndex);
                            continue;
                        }
                        this.rebound = true;
                        return;
                    }
                    LivingEntity hitEntity = (LivingEntity)result.field_72308_g;
                    if (hitEntity.func_110124_au().equals(cur.func_110124_au())) {
                        IMaxAttack.dealTrueDamage((Entity)this, cur, cur.func_110138_aP() * 1.0f, Arrays.asList("Aquatic"));
                        CustomParticleConfig config1 = new CustomParticleConfig();
                        config1.createInstance().setParticle(ParticleInit.CRYSTAL_MAGIC).setSpread(4.0, 1.0, 4.0).setCount(10).setIgnoreRange(true);
                        IParticleSpawner.spawnParticle(this.field_70170_p, config1, result.field_72308_g.field_70165_t, result.field_72308_g.field_70163_u + (double)(result.field_72308_g.field_70131_O / 2.0f), result.field_72308_g.field_70161_v);
                        ((ServerLevel)this.field_70170_p).func_175739_a(EnumParticleTypes.SWEEP_ATTACK, this.field_70165_t, this.field_70163_u, this.field_70161_v, 5, -0.5 + this.field_70146_Z.nextDouble(), 0.3, -0.5 + this.field_70146_Z.nextDouble(), (double)0.15f, new int[0]);
                        this.field_70170_p.func_184133_a(null, result.field_72308_g.func_180425_c(), SoundInit.MAGIC_WEAPON_14, SoundSource.PLAYERS, 1.5f, 0.8f + 0.4f * this.field_70146_Z.nextFloat());
                        this.field_70170_p.func_184133_a(null, result.field_72308_g.func_180425_c(), SoundInit.GENERIC_SLICE, SoundSource.PLAYERS, 1.5f, 0.5f + 0.4f * this.field_70146_Z.nextFloat());
                        if (this.curIndex < this.entitiesToHit.size() - 1) {
                            ++this.curIndex;
                        } else {
                            this.rebound = true;
                            return;
                        }
                    }
                }
            }
            if (this.field_70192_c == null) {
                this.func_70106_y();
            }
            if (result.field_72308_g == null && this.field_70170_p.func_180495_p(result.func_178782_a()).func_185904_a().func_76230_c()) {
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
                        Player player = (Player)thrower;
                        boolean found = false;
                        for (int i = 0; i < player.field_71071_by.func_70302_i_(); ++i) {
                            ItemStack playerStack = player.field_71071_by.func_70301_a(i);
                            if (playerStack.func_77973_b() != ItemInit.infinityTridentMK2) continue;
                            playerStack.func_77978_p().func_74768_a("empty_data", 0);
                            player.field_71071_by.func_70299_a(i, playerStack);
                            found = true;
                            break;
                        }
                        if (!found) {
                            player.field_71071_by.func_70441_a(new ItemStack(ItemInit.infinityTridentMK2));
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
            } else if (!this.entitiesToHit.isEmpty()) {
                this.speed = 1.0;
                LivingEntity cur = this.entitiesToHit.get(this.curIndex);
                while (cur == null || cur.field_70128_L) {
                    if (this.curIndex < this.entitiesToHit.size() - 1) {
                        ++this.curIndex;
                        cur = this.entitiesToHit.get(this.curIndex);
                        continue;
                    }
                    this.rebound = true;
                    return;
                }
                if ((double)this.func_70032_d((Entity)cur) < 0.5) {
                    ++this.curIndex;
                    return;
                }
                Vec3 dir = cur.func_174791_d().func_72441_c(0.0, (double)cur.field_70131_O / 2.2, 0.0).func_178788_d(this.func_174791_d());
                dir = dir.func_72432_b();
                this.field_70159_w = dir.field_72450_a * this.speed;
                this.field_70181_x = dir.field_72448_b * this.speed;
                this.field_70179_y = dir.field_72449_c * this.speed;
                this.field_70133_I = true;
            }
        } else {
            this.field_70170_p.func_175688_a(ParticleInit.SPECTRAL, this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.25 * (-0.5 + this.field_70146_Z.nextDouble()), 0.0, 0.25 * (-0.5 + this.field_70146_Z.nextDouble()), new int[0]);
        }
    }

    protected float func_70185_h() {
        return 0.0f;
    }
}

