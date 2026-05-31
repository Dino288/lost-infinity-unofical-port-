/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.player.Player
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.boss;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.base.EntityMultipleLives;
import xol.lostinfinity.projectile.entity.EntityVeloMagic;
import xol.lostinfinity.stone.EntityInfinityStone;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityNuxuro
extends EntityMultipleLives
implements IMaxAttack {
    public EntityNuxuro(Level worldIn) {
        super(worldIn);
        this.func_70105_a(3.5f, 5.5f);
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.32);
        this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(5000.0);
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null) {
            IMaxAttack.dealMaxHealth((Entity)this, this.func_70638_az(), 2);
            return true;
        }
        return false;
    }

    private AABB getArenaAABB() {
        return new AABB(new BlockPos(-3.0, 60.0, -145.0), new BlockPos(52.0, 85.0, -40.0));
    }

    private void playSoundToPlayers(SoundEvent sound) {
        for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.getArenaAABB())) {
            this.field_70170_p.func_184133_a(null, near_pl.func_180425_c(), sound, SoundSource.MASTER, 0.35f + this.field_70146_Z.nextFloat() * 0.2f, 0.5f + this.field_70146_Z.nextFloat());
        }
    }

    public void func_70636_d() {
        super.func_70636_d();
        this.field_70143_R = -1.0f;
        for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.func_174813_aQ().func_72314_b(3.0, 3.0, 3.0))) {
            near_pl.func_70024_g(Math.signum(this.field_70165_t - near_pl.field_70165_t) * -1.1, 0.5, Math.signum(this.field_70161_v - near_pl.field_70161_v) * -1.1);
            near_pl.field_70133_I = true;
        }
        if (!this.field_70170_p.field_72995_K && (this.field_70173_aa % 30 == 0 || this.field_70173_aa % 120 < 20 && this.field_70173_aa % 7 == 0)) {
            boolean didSound = false;
            for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.getArenaAABB())) {
                if (this.func_70638_az() == null) {
                    this.func_70624_b((LivingEntity)near_pl);
                    this.func_70024_g((near_pl.field_70165_t - this.field_70165_t) * 0.2, (near_pl.field_70163_u - this.field_70163_u) * 0.1, (near_pl.field_70161_v - this.field_70161_v) * 0.2);
                    this.field_70133_I = true;
                }
                double makeX = (this.func_174813_aQ().field_72340_a + this.func_174813_aQ().field_72336_d) / 2.0;
                double makeY = this.field_70163_u + (double)(this.field_70131_O / 2.0f) + 0.5;
                double makeZ = (this.func_174813_aQ().field_72339_c + this.func_174813_aQ().field_72334_f) / 2.0;
                double d2 = near_pl.field_70165_t - makeX;
                double d3 = near_pl.func_174813_aQ().field_72338_b + (double)(near_pl.field_70131_O / 4.0f) - makeY;
                double d4 = near_pl.field_70161_v - makeZ;
                EntityVeloMagic shot = new EntityVeloMagic(this.field_70170_p, (LivingEntity)this);
                shot.func_70186_c(d2, d3, d4, 2.0f, 0.0f);
                shot.setDenom(5);
                shot.setGravity(Float.valueOf(0.0f));
                this.field_70170_p.func_72838_d((Entity)shot);
                didSound = true;
            }
            if (didSound) {
                this.playSoundToPlayers(SoundInit.MAGIC_WEAPON_4);
            }
        }
        if (!this.field_70170_p.field_72995_K && this.field_70173_aa % 70 == 50) {
            double x0 = this.field_70165_t;
            double y0 = this.field_70163_u + 2.5;
            double z0 = this.field_70161_v;
            double radius = 5.0;
            this.playSoundToPlayers(SoundInit.MAGIC_WEAPON_3);
            float angle = 0.0f;
            while ((double)angle <= Math.PI * 2) {
                EntityVeloMagic shot = new EntityVeloMagic(this.field_70170_p, (LivingEntity)this);
                shot.func_70107_b(x0, y0, z0);
                double velocity_x = radius * Math.cos(angle);
                double velocity_z = radius * Math.sin(angle);
                shot.setThrower((LivingEntity)this);
                shot.calculateVelocity(velocity_x, -1.5, velocity_z);
                shot.func_184538_a((Entity)this, shot.field_70125_A, shot.field_70177_z, 0.0f, 1.5f, 0.0f);
                shot.setGravity(Float.valueOf(0.05f));
                this.field_70170_p.func_72838_d((Entity)shot);
                angle = (float)((double)angle + 0.3141592653589793);
            }
        }
    }

    protected SoundEvent func_184615_bR() {
        return SoundInit.GENERIC_STYLE1_DEATH;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundInit.GENERIC_STYLE1_HURT;
    }

    protected SoundEvent func_184639_G() {
        return null;
    }

    @Override
    protected int numberOfLives() {
        return 6;
    }

    @Override
    public void trueDeathAction() {
        if (!this.field_70170_p.field_72995_K) {
            EntityInfinityStone stone = new EntityInfinityStone(this.field_70170_p);
            stone.setStoneNum((byte)5);
            stone.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
            this.field_70170_p.func_72838_d((Entity)stone);
            this.func_145779_a(ItemInit.arenaCard, 1);
        }
    }

    protected boolean func_70692_ba() {
        return false;
    }

    @Override
    public boolean func_70814_o() {
        return true;
    }

    public int func_70641_bl() {
        return 1;
    }
}

