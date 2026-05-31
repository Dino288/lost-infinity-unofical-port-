/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.Mth
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.minion;

import java.util.ArrayList;
import java.util.Collections;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import xol.lostinfinity.mob.entity.base.EntityImmaterial;
import xol.lostinfinity.mob.entity.minion.EntityMinion;
import xol.lostinfinity.projectile.entity.EntityLuminousGuardianLaser;

public class EntityLuminousGuardian
extends EntityMinion {
    public EntityLuminousGuardian(Level worldIn) {
        super(worldIn);
        this.func_70105_a(0.5f, 0.5f);
    }

    @Override
    protected void livingUpdate() {
        Player owner = this.getOwner();
        if (owner == null) {
            return;
        }
        this.updatePosition();
        if (!this.field_70170_p.field_72995_K && this.field_70173_aa % 20 == 0) {
            ArrayList<LivingEntity> nearEntities = new ArrayList<LivingEntity>();
            for (LivingEntity entity : this.field_70170_p.func_72872_a(LivingEntity.class, new AABB(this.func_180425_c()).func_186662_g(15.0))) {
                if (entity.func_110124_au().equals(owner.func_110124_au()) || entity.func_110124_au().equals(this.func_110124_au()) || entity instanceof EntityImmaterial) continue;
                nearEntities.add(entity);
            }
            if (!nearEntities.isEmpty()) {
                Collections.shuffle(nearEntities);
                LivingEntity target = (LivingEntity)nearEntities.get(0);
                EntityLuminousGuardianLaser laser = new EntityLuminousGuardianLaser(this.field_70170_p);
                laser.setOwnerID(this.func_145782_y());
                if (this.owner != null) {
                    laser.setPlayerOwner(this.owner);
                }
                laser.setOwner((LivingEntity)this);
                laser.setTargetPos(target.func_174791_d());
                laser.func_70634_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
                this.field_70170_p.func_72838_d((Entity)laser);
            }
        }
    }

    private void updatePosition() {
        float x = Mth.func_76126_a((float)((float)this.field_70173_aa * 0.01f));
        float y = Mth.func_76126_a((float)((float)this.field_70173_aa * 0.05f)) * 0.5f;
        float z = Mth.func_76134_b((float)((float)this.field_70173_aa * 0.01f));
        this.func_70080_a(this.owner.field_70165_t + (double)x, this.owner.field_70163_u + 2.0 + (double)y, this.owner.field_70161_v + (double)z, 0.0f, 0.0f);
        this.field_70759_as = 0.0f;
        this.field_70761_aq = 0.0f;
    }
}

