/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.player.Player
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.galaxy;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.base.EntityMultipleLives;
import xol.lostinfinity.projectile.entity.EntityGalaxyLaser;
import xol.lostinfinity.util.coordinates.GalaxyCoordinates;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityLaserSpire
extends EntityMultipleLives
implements IMaxAttack {
    private int gameStyle = 0;
    private boolean fastFire = false;
    private int fireOffset = this.field_70146_Z.nextInt(6) * 5;

    public EntityLaserSpire(Level worldIn) {
        super(worldIn);
        this.func_70105_a(2.0f, 3.5f);
        this.func_184224_h(true);
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(10000.0);
        this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a(1.0);
    }

    @Override
    protected void func_184651_r() {
    }

    public void setGameStyle(int style) {
        this.gameStyle = style;
    }

    public int getGameStyle() {
        return this.gameStyle;
    }

    public void setFastFire() {
        this.fastFire = true;
    }

    protected SoundEvent func_184639_G() {
        return null;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return null;
    }

    protected SoundEvent func_184615_bR() {
        return null;
    }

    public boolean func_70104_M() {
        return false;
    }

    @Override
    public void func_70014_b(CompoundTag tag) {
        super.func_70014_b(tag);
        tag.func_74768_a("GameStyle", this.gameStyle);
        tag.func_74757_a("FastFire", this.fastFire);
    }

    @Override
    public void func_70037_a(CompoundTag tag) {
        super.func_70037_a(tag);
        this.gameStyle = tag.func_74762_e("GameStyle");
        this.fastFire = tag.func_74767_n("FastFire");
    }

    private AABB getMyAABB() {
        switch (this.gameStyle) {
            case 1: {
                return GalaxyCoordinates.getBlueAABB();
            }
            case 2: {
                return GalaxyCoordinates.getGreenAABB();
            }
            case 3: {
                return GalaxyCoordinates.getPinkAABB();
            }
            case 4: {
                return GalaxyCoordinates.getYellowAABB();
            }
            case 5: {
                return GalaxyCoordinates.getSwordAABB();
            }
            case 6: {
                return GalaxyCoordinates.getBombAABB();
            }
            case 7: {
                return GalaxyCoordinates.getKnifeAABB();
            }
        }
        return GalaxyCoordinates.getBlueAABB();
    }

    public void func_70636_d() {
        boolean valid_tick;
        super.func_70636_d();
        if (this.func_110143_aJ() > 0.0f) {
            this.func_70606_j(this.func_110138_aP());
        }
        this.field_70143_R = -1.0f;
        boolean bl = valid_tick = (this.field_70173_aa + this.fireOffset) % (this.fastFire ? 30 : 50) == 0;
        if (!this.field_70170_p.field_72995_K && valid_tick) {
            boolean fired = false;
            for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.getMyAABB())) {
                if (near_pl.func_184812_l_() || !(this.func_70032_d((Entity)near_pl) > 3.0f)) continue;
                fired = true;
                Vec3 vec3d = this.func_70676_i(1.0f);
                double makeX = (this.func_174813_aQ().field_72340_a + this.func_174813_aQ().field_72336_d) / 2.0;
                double makeY = this.field_70163_u + (double)(this.field_70131_O / 2.0f);
                double makeZ = (this.func_174813_aQ().field_72339_c + this.func_174813_aQ().field_72334_f) / 2.0;
                double d2 = near_pl.field_70165_t - makeX;
                double d3 = (near_pl.func_174813_aQ().field_72338_b + near_pl.func_174813_aQ().field_72337_e) / 2.0 - makeY;
                double d4 = near_pl.field_70161_v - makeZ;
                EntityGalaxyLaser shot = new EntityGalaxyLaser(this.field_70170_p, makeX, makeY, makeZ);
                shot.setThrower((LivingEntity)this);
                shot.func_70186_c(d2, d3, d4, 1.0f, 0.0f);
                this.field_70170_p.func_72838_d((Entity)shot);
            }
            if (fired) {
                this.func_184185_a(SoundInit.LASER_WEAPON_2, 2.0f, 1.0f);
            }
        }
    }

    @Override
    protected int numberOfLives() {
        return 200;
    }

    protected boolean func_70692_ba() {
        return false;
    }
}

