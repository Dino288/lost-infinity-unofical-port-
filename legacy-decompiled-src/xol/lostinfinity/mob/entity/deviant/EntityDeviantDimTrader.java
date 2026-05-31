/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.monster.EntityEnderman
 *  net.minecraft.entity.player.Player
 *  net.minecraft.entity.projectile.EntityArrow
 *  net.minecraft.entity.projectile.EntityFireball
 *  net.minecraft.entity.projectile.EntityThrowable
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.item.Item
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.EnumParticleTypes
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.world.World
 *  net.minecraft.world.ServerLevel
 */
package xol.lostinfinity.mob.entity.deviant;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.world.entity.player.Player;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.base.EntityDeviantMob;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantEnderman;
import xol.lostinfinity.projectile.entity.EntityVoidLaser;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.load.LootTableRegistry;

public class EntityDeviantDimTrader
extends EntityDeviantMob {
    private float scale = 1.0f;

    public EntityDeviantDimTrader(Level worldIn) {
        super(worldIn);
        this.func_70105_a(3.0f, 7.5f);
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.32);
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

    public float getMyScale() {
        return this.scale;
    }

    @Override
    protected Item playerInput() {
        return ItemInit.reinforcedBlade;
    }

    @Override
    protected Item mutantOutput() {
        return ItemInit.laserBlade;
    }

    protected SoundEvent func_184615_bR() {
        return SoundEvents.field_187911_gk;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundEvents.field_187912_gl;
    }

    protected SoundEvent func_184639_G() {
        return SoundEvents.field_187910_gj;
    }

    public void func_70636_d() {
        super.func_70636_d();
        if (this.scale < 3.7f) {
            this.scale += 0.1f;
        }
        LivingEntity target = this.func_70638_az();
        for (Entity proj : this.field_70170_p.func_72872_a(Entity.class, this.func_174813_aQ().func_72314_b(10.0, 10.0, 10.0))) {
            if (!(proj instanceof EntityThrowable) && !(proj instanceof EntityArrow) && !(proj instanceof EntityFireball) || proj instanceof EntityVoidLaser || this.field_70170_p.field_72995_K) continue;
            proj.func_70106_y();
            proj.func_184185_a(SoundInit.ITEM_AXIOMAVORUM, 1.0f, 0.5f + this.field_70146_Z.nextFloat());
            ((ServerLevel)this.field_70170_p).func_175739_a(EnumParticleTypes.SWEEP_ATTACK, proj.field_70165_t, proj.field_70163_u, proj.field_70161_v, 2, (-0.5 + this.field_70146_Z.nextDouble()) * 3.0, 0.3, (-0.5 + this.field_70146_Z.nextDouble()) * 3.0, (double)0.15f, new int[0]);
        }
        int ability = this.field_70173_aa % 100;
        if (ability < 60 + 10 * this.getMutation() && this.field_70173_aa % 3 == 0 && target != null) {
            if (!this.field_70170_p.field_72995_K) {
                Vec3 vec3d = this.func_70676_i(1.0f);
                double makeX = (this.func_174813_aQ().field_72340_a + this.func_174813_aQ().field_72336_d) / 2.0;
                double makeY = this.field_70163_u + (double)(this.field_70131_O / 2.0f);
                double makeZ = (this.func_174813_aQ().field_72339_c + this.func_174813_aQ().field_72334_f) / 2.0;
                double d2 = target.field_70165_t - makeX;
                double d3 = (target.func_174813_aQ().field_72338_b + target.func_174813_aQ().field_72337_e) / 2.0 - makeY;
                double d4 = target.field_70161_v - makeZ;
                EntityVoidLaser shot = new EntityVoidLaser(this.field_70170_p, makeX, makeY, makeZ);
                shot.setThrower((LivingEntity)this);
                shot.func_70186_c(d2, d3, d4, 2.5f, 0.0f);
                this.field_70170_p.func_72838_d((Entity)shot);
            }
            this.func_184185_a(SoundInit.LASER_WEAPON_1, 1.5f + 0.3f * (float)this.getMutation(), 0.7f + this.field_70146_Z.nextFloat() * 0.5f);
        }
        if (ability == 95) {
            if (!this.field_70170_p.field_72995_K) {
                this.teleportRandomly();
            }
        } else if (ability == 50 && !this.field_70170_p.field_72995_K) {
            AABB check = this.func_174813_aQ().func_72314_b(8.0, 8.0, 8.0);
            for (EntityEnderman ender : this.field_70170_p.func_72872_a(EntityEnderman.class, check)) {
                EntityDeviantEnderman newEntity = new EntityDeviantEnderman(this.field_70170_p);
                newEntity.func_70107_b(ender.field_70165_t, ender.field_70163_u, ender.field_70161_v);
                this.field_70170_p.func_72838_d((Entity)newEntity);
                ((ServerLevel)this.field_70170_p).func_175739_a(EnumParticleTypes.LAVA, ender.field_70165_t, ender.field_70163_u + 2.0 + this.field_70146_Z.nextDouble(), ender.field_70161_v, 2, (-0.5 + this.field_70146_Z.nextDouble()) * 3.0, 0.3, (-0.5 + this.field_70146_Z.nextDouble()) * 3.0, (double)0.15f, new int[0]);
                ender.func_70106_y();
            }
        }
    }

    private boolean teleportRandomly() {
        double d0 = this.field_70165_t + (this.field_70146_Z.nextDouble() - 0.5) * 32.0;
        double d1 = this.field_70163_u + (double)(this.field_70146_Z.nextInt(64) - 32);
        double d2 = this.field_70161_v + (this.field_70146_Z.nextDouble() - 0.5) * 32.0;
        return this.teleportTo(d0, d1, d2);
    }

    private boolean teleportTo(double x, double y, double z) {
        boolean flag = this.func_184595_k(x, y, z);
        if (flag) {
            this.field_70170_p.func_184148_a((Player)null, this.field_70169_q, this.field_70167_r, this.field_70166_s, SoundEvents.field_187534_aX, this.func_184176_by(), 1.0f, 1.0f);
            this.func_184185_a(SoundEvents.field_187534_aX, 1.5f, 1.0f);
        }
        return flag;
    }

    @Override
    protected int numberOfLives() {
        return this.getMutation() == 0 ? 15 : 10;
    }

    @Override
    protected ResourceLocation deviantDrop() {
        return LootTableRegistry.ENTITIES_DEVIANTDIMTRADER;
    }

    @Override
    protected ResourceLocation superMutatedDrop() {
        return LootTableRegistry.ENTITIES_SUPERMUTANT_DIMTRADER;
    }
}

