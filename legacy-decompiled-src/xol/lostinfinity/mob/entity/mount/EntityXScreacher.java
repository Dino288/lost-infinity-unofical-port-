/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.mount;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.base.EntityMultipleLivesMount;
import xol.lostinfinity.mob.entity.base.IConditionalDamage;
import xol.lostinfinity.projectile.entity.EntityXSonicAttack;

public class EntityXScreacher
extends EntityMultipleLivesMount
implements IConditionalDamage {
    private static final Vec3 GROUND_OFFSET = new Vec3(0.0, 1.3, 1.0);
    private static final Vec3 AIR_OFFSET = new Vec3(0.0, 0.765, 1.0);
    private long nextFireAttack;

    public EntityXScreacher(Level worldIn) {
        super(worldIn);
        this.func_70105_a(2.0f, 1.53f);
    }

    @Override
    protected void func_184651_r() {
    }

    @Override
    protected int numberOfLives() {
        return 25;
    }

    public float func_70047_e() {
        return this.field_70131_O;
    }

    public void func_184232_k(Entity passenger) {
        if (this.func_184196_w(passenger)) {
            Vec3 forward = new Vec3(0.0, 0.0, 1.0).func_178785_b(-this.field_70177_z * ((float)Math.PI / 180));
            passenger.func_70107_b(this.field_70165_t - 1.3 * forward.field_72450_a, this.field_70163_u + this.func_70042_X() + passenger.func_70033_W(), this.field_70161_v - 1.3 * forward.field_72449_c);
        }
    }

    @Override
    public double func_70042_X() {
        return super.func_70042_X() + 1.5;
    }

    public Vec3 getHeadOffset() {
        return this.func_174791_d().func_178787_e((this.isActuallyOnGround ? GROUND_OFFSET : AIR_OFFSET).func_178785_b(-this.field_70177_z * ((float)Math.PI / 180)));
    }

    public void fireAttack(Player driver) {
        if (System.currentTimeMillis() < this.nextFireAttack) {
            return;
        }
        Vec3 driverVec = driver.func_70040_Z();
        Vec3 location = this.getHeadOffset();
        EntityXSonicAttack shot = new EntityXSonicAttack(this.field_70170_p, location.field_72450_a, location.field_72448_b, location.field_72449_c);
        shot.setThrower((LivingEntity)this);
        shot.setSecondaryThrower((LivingEntity)driver);
        driverVec = driverVec.func_186678_a(3.0);
        shot.func_70024_g(driverVec.field_72450_a, driverVec.field_72448_b, driverVec.field_72449_c);
        this.field_70170_p.func_72838_d((Entity)shot);
        this.func_184185_a(SoundInit.STARFORGE_SCREACHER_ATTACK, 2.0f, 0.5f + this.field_70146_Z.nextFloat());
        this.nextFireAttack = System.currentTimeMillis() + 500L;
    }

    @Override
    public boolean canBeDamaged(Entity attacker) {
        return attacker != this.owner;
    }

    public void func_70636_d() {
        Entity rider;
        super.func_70636_d();
        if (!this.field_70170_p.field_72995_K && (rider = this.func_184179_bs()) != null && rider instanceof Player) {
            Player player = (Player)rider;
            player.func_70691_i(player.func_110138_aP() / 20.0f);
            this.func_70691_i(this.func_110138_aP() / 10.0f);
        }
    }
}

