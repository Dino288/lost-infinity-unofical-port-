package xol.lostinfinity.entity;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Snowball;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.level.Level;

public class LostCombatProjectile extends Snowball {
    private final float damage;

    public LostCombatProjectile(Level level, LivingEntity owner, float damage) {
        super(level, owner);
        this.damage = damage;
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        if (!level().isClientSide()) {
            result.getEntity().hurt(damageSources().thrown(this, getOwner()), damage);
        }
    }
}
