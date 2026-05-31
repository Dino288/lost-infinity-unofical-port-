/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.boss;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import xol.lostinfinity.mob.ai.IBasicAI;
import xol.lostinfinity.mob.entity.base.EntityMultipleLives;
import xol.lostinfinity.mob.entity.starforge.EntityDusker;
import xol.lostinfinity.projectile.entity.EntityDuskerQueenWeb;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.load.LootTableRegistry;

public class EntityDuskerQueen
extends EntityMultipleLives
implements IMaxAttack,
IBasicAI {
    private EntityDuskerQueenWeb web = null;
    private boolean hasPulled = false;
    private int moveDownTime = 20;

    public EntityDuskerQueen(Level worldIn) {
        super(worldIn);
        this.func_70105_a(4.0f, 5.5f);
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null) {
            IMaxAttack.dealMaxHealth((Entity)this, this.func_70638_az(), 2, 3.0f);
            return true;
        }
        return false;
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(700.0);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.3);
        this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a(1.0);
    }

    public void func_70636_d() {
        super.func_70636_d();
        this.field_70143_R = -1.0f;
        if (!this.field_70170_p.field_72995_K) {
            Player pl;
            Player target;
            if (this.field_70134_J) {
                this.func_70024_g(0.0, -1.0, 0.0);
                this.moveDownTime = 20;
            } else if (this.moveDownTime > 0) {
                --this.moveDownTime;
            } else {
                this.field_70159_w = 0.0;
                this.field_70181_x = 0.0;
                this.field_70179_y = 0.0;
                this.field_70133_I = true;
            }
            if (this.field_70173_aa % 60 == 0) {
                EntityDusker dusker = new EntityDusker(this.field_70170_p);
                dusker.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
                this.field_70170_p.func_72838_d((Entity)dusker);
            }
            if (this.web != null && !this.hasPulled && this.web.getGrowth() >= 1.0f && (target = this.web.getTarget()) != null && this.web.getStopPos() == null) {
                double dist = target.func_174791_d().func_72438_d(this.web.func_174791_d());
                if (dist < 5.0) {
                    this.hasPulled = true;
                    this.web.func_70106_y();
                    this.web = null;
                    IMaxAttack.dealMaxHealth((Entity)this, (LivingEntity)target, 3);
                    return;
                }
                Vec3 pullDir = this.web.func_174791_d().func_178788_d(target.func_174791_d());
                pullDir = pullDir.func_72432_b();
                target.func_70024_g(pullDir.field_72450_a / 5.0, pullDir.field_72448_b / 5.0 + (double)0.1f, pullDir.field_72449_c / 5.0);
                target.field_70133_I = true;
            }
            if (this.field_70173_aa % 100 == 20) {
                this.hasPulled = false;
                if (this.web != null) {
                    this.web.func_70106_y();
                    this.web = null;
                }
                if (this.func_70638_az() != null && this.func_70638_az() instanceof Player) {
                    pl = (Player)this.func_70638_az();
                    this.web = new EntityDuskerQueenWeb(this.field_70170_p);
                    this.web.setTarget(pl);
                    this.web.setOwner(this);
                    this.web.func_70107_b(this.field_70165_t, this.field_70163_u + (double)(this.field_70131_O / 2.0f), this.field_70161_v);
                    this.field_70170_p.func_72838_d((Entity)this.web);
                }
            }
            if (this.field_70173_aa % 100 == 0 && this.func_70638_az() != null && this.func_70638_az() instanceof Player) {
                pl = (Player)this.func_70638_az();
                this.func_70024_g((pl.field_70165_t - this.field_70165_t) * 0.145, 1.0, (pl.field_70161_v - this.field_70161_v) * 0.145);
            }
        }
    }

    @Override
    public void trueDeathAction() {
        if (this.web != null) {
            this.web.func_70106_y();
            this.web = null;
        }
    }

    protected SoundEvent func_184615_bR() {
        return SoundEvents.field_187819_fL;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundEvents.field_187821_fM;
    }

    protected SoundEvent func_184639_G() {
        return SoundEvents.field_187817_fK;
    }

    protected ResourceLocation func_184647_J() {
        return LootTableRegistry.ENTITIES_DUSKERQUEEN;
    }

    @Override
    protected int numberOfLives() {
        return 150;
    }

    protected boolean func_70692_ba() {
        return false;
    }
}

