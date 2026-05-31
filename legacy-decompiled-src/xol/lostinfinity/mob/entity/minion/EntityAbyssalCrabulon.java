/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.Mth
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.minion;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.minion.EntityMinion;
import xol.lostinfinity.mob.entity.misc.EntityTentacleTrap;

public class EntityAbyssalCrabulon
extends EntityMinion {
    private static final double MAX_DISTANCE = 20.0;
    private final Map<LivingEntity, EntityTentacleTrap> targetTrapMap = new ConcurrentHashMap<LivingEntity, EntityTentacleTrap>();

    public EntityAbyssalCrabulon(Level worldIn) {
        super(worldIn);
        this.func_70105_a(0.25f, 0.25f);
    }

    @Override
    protected void livingUpdate() {
        Player owner = this.getOwner();
        if (owner == null) {
            return;
        }
        this.updatePosition();
        if (!this.field_70170_p.field_72995_K && this.field_70173_aa % 40 == 0) {
            LivingEntity entity = owner.func_110144_aD();
            if (entity == null || entity instanceof EntityAbyssalCrabulon || entity instanceof EntityTentacleTrap || entity == owner) {
                return;
            }
            if (entity.func_70068_e((Entity)owner) > 400.0) {
                return;
            }
            EntityTentacleTrap oldTrap = this.targetTrapMap.get(entity);
            if (oldTrap != null && !oldTrap.field_70128_L) {
                return;
            }
            EntityTentacleTrap trap = new EntityTentacleTrap(this.field_70170_p);
            trap.func_70107_b(entity.field_70165_t, entity.field_70163_u, entity.field_70161_v);
            trap.setTarget(entity);
            trap.setOwner(owner);
            this.field_70170_p.func_72838_d((Entity)trap);
            this.field_70170_p.func_184133_a(null, entity.func_180425_c(), SoundInit.SKYCRAB_HURT, SoundSource.HOSTILE, 1.5f, 0.8f + this.field_70170_p.field_73012_v.nextFloat() * 0.4f);
            this.targetTrapMap.put(entity, trap);
            this.targetTrapMap.forEach((entityLivingBase, entityTentacleTrap) -> {
                if (entityLivingBase.field_70128_L || entityTentacleTrap.field_70128_L) {
                    this.targetTrapMap.remove(entityLivingBase);
                }
            });
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

