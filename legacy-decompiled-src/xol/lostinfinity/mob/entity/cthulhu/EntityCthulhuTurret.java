/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.SoundSource
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.cthulhu;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.cthulhu.AbstractCthulhuMinion;
import xol.lostinfinity.projectile.cthulhu.EntityCthulhuTurretBullet;

public class EntityCthulhuTurret
extends AbstractCthulhuMinion {
    public EntityCthulhuTurret(Level worldIn) {
        super(worldIn);
        this.func_70105_a(2.0f, 1.5f);
    }

    @Override
    protected void func_184651_r() {
    }

    public void func_70636_d() {
        super.func_70636_d();
        if (this.func_110143_aJ() <= 0.0f && this.didDeathAction()) {
            this.func_70106_y();
        }
        if (this.field_70170_p.field_72995_K) {
            return;
        }
        if (this.field_70173_aa % 4 == 0 && this.field_70122_E) {
            Player player = this.findClosestPlayer();
            if (player == null) {
                return;
            }
            EntityCthulhuTurretBullet bullet = new EntityCthulhuTurretBullet(this.field_70170_p);
            bullet.setThrower((LivingEntity)this);
            bullet.setSecondaryThrower((LivingEntity)this.owner);
            bullet.func_70107_b(this.field_70165_t, this.field_70163_u + 2.0, this.field_70161_v);
            bullet.func_70186_c(player.field_70165_t - bullet.field_70165_t, player.field_70163_u + 1.0 - bullet.field_70163_u, player.field_70161_v - bullet.field_70161_v, 2.0f, 0.0f);
            this.field_70170_p.func_72838_d((Entity)bullet);
            for (Player contender : this.field_70170_p.func_72872_a(Player.class, this.func_174813_aQ().func_186662_g(7.0))) {
                this.field_70170_p.func_184133_a(null, this.func_180425_c(), SoundInit.LASER_WEAPON_7, SoundSource.HOSTILE, 1.0f, 1.0f);
            }
        }
    }

    @Override
    protected boolean func_70692_ba() {
        return false;
    }

    public boolean func_70097_a(DamageSource source, float amount) {
        return source != DamageSource.field_76379_h && super.func_70097_a(source, amount);
    }

    private Player findClosestPlayer() {
        double dist = 2304.0;
        Player closest = null;
        for (Player player : this.field_70170_p.func_73046_m().func_184103_al().func_181057_v()) {
            double d = player.func_70068_e((Entity)this);
            if (!(dist > d)) continue;
            dist = d;
            closest = player;
        }
        return closest;
    }
}

