/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Optional
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.cthulhu;

import com.google.common.base.Optional;
import java.util.UUID;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import xol.lostinfinity.common.lostinfinity;
import xol.lostinfinity.common.packets.serverbound.PacketCthulhuBarrier;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.item.basics.ItemChanneling;
import xol.lostinfinity.mob.entity.base.EntityImmaterial;
import xol.lostinfinity.mob.entity.cthulhu.EntityCthulhu;
import xol.lostinfinity.util.math.LMath;

public class EntityCthulhuSpear
extends EntityImmaterial {
    private static final DataParameter<Optional<UUID>> OWNER = EntityDataManager.func_187226_a(EntityCthulhuSpear.class, (DataSerializer)DataSerializers.field_187203_m);
    private Player owner;
    private double laserDistance;
    private int barrierTick;

    public EntityCthulhuSpear(Level worldIn) {
        super(worldIn);
    }

    @Override
    public void func_70636_d() {
        super.func_70636_d();
        if (this.getOwner() == null) {
            this.func_70106_y();
            return;
        }
        this.updatePosition();
        if (!this.field_70170_p.field_72995_K) {
            if (this.getOwner().func_184614_ca().func_77973_b() != ItemInit.cthulhuSpear || !ItemChanneling.isChanneling((LivingEntity)this.getOwner(), this.getOwner().func_184614_ca())) {
                this.func_70106_y();
            }
        } else {
            Vec3 normVec = this.getOwner().func_70040_Z();
            Vec3 laserEnd = this.getOwner().func_174824_e(1.0f);
            double accumDist = 0.0;
            double safeDistance = 256.0;
            int closest = -1;
            for (int i = 0; i < 100; ++i) {
                for (EntityCthulhu cthulhu : EntityCthulhu.CTHULHUS.values()) {
                    double z;
                    double x;
                    double d;
                    if (!cthulhu.isBarrierActive() || cthulhu.getPhase() != 2 || !((d = LMath.fastSqrt((x = cthulhu.field_70165_t - laserEnd.field_72450_a) * x + (z = cthulhu.field_70161_v - laserEnd.field_72449_c) * z) - 48.0) < safeDistance)) continue;
                    closest = cthulhu.func_145782_y();
                    safeDistance = d;
                }
                if (safeDistance < 0.25 || (accumDist += safeDistance) > 256.0) break;
                laserEnd = laserEnd.func_178787_e(normVec.func_186678_a(safeDistance));
                safeDistance = 256.0;
            }
            if (accumDist < 256.0) {
                this.laserDistance = accumDist;
                ++this.barrierTick;
                if (this.barrierTick == 40 && closest != -1) {
                    lostinfinity.instance.packetHandler.sendServerBasicPacket(new PacketCthulhuBarrier(5, 100, closest));
                }
            } else {
                this.laserDistance = 256.0;
                this.barrierTick = 0;
            }
        }
    }

    protected void func_82167_n(Entity entityIn) {
    }

    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a(OWNER, (Object)Optional.absent());
    }

    public void setOwner(Player player) {
        this.owner = player;
        this.field_70180_af.func_187227_b(OWNER, (Object)Optional.of((Object)player.func_110124_au()));
    }

    public Player getOwner() {
        Optional uuidOptional;
        if (this.owner == null && (uuidOptional = (Optional)this.field_70180_af.func_187225_a(OWNER)).isPresent()) {
            this.owner = this.field_70170_p.func_152378_a((UUID)uuidOptional.get());
        }
        return this.owner;
    }

    public void updatePosition() {
        Vec3 dir = this.getOwner().func_70040_Z().func_186678_a(3.0);
        this.func_70107_b(this.getOwner().field_70165_t + dir.field_72450_a, this.getOwner().field_70163_u + dir.field_72448_b, this.getOwner().field_70161_v + dir.field_72449_c);
    }

    public double getLaserDistance() {
        return this.laserDistance;
    }
}

