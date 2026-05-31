/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Optional
 *  net.minecraft.entity.Entity
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
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import xol.lostinfinity.common.events.EventsClientRender;
import xol.lostinfinity.mob.entity.base.IConditionalDamage;
import xol.lostinfinity.mob.entity.cthulhu.AbstractCthulhuMinion;
import xol.lostinfinity.mob.entity.cthulhu.EntityCthulhu;
import xol.lostinfinity.util.animation.client.AnimationHandler;
import xol.lostinfinity.util.animation.entity.IXolAnimated;
import xol.lostinfinity.util.math.LMath;

public class EntityCelestialStatue
extends AbstractCthulhuMinion
implements IXolAnimated,
IConditionalDamage {
    private static final DataParameter<Optional<UUID>> OWNER = EntityDataManager.func_187226_a(EntityCelestialStatue.class, (DataSerializer)DataSerializers.field_187203_m);
    private static final DataParameter<Integer> TYPE = EntityDataManager.func_187226_a(EntityCelestialStatue.class, (DataSerializer)DataSerializers.field_187192_b);
    private static final Vec3 OFFSET_1 = new Vec3(-8.0, 25.5, 0.0);
    private static final Vec3 OFFSET_2 = new Vec3(8.0, 25.5, 0.0);
    private final AnimationHandler handler = new AnimationHandler();
    private EntityCthulhu owner;
    private float rot;

    public EntityCelestialStatue(Level worldIn) {
        super(worldIn);
        this.func_70105_a(10.0f, 30.0f);
    }

    public void func_70636_d() {
        if (this.getOwner() != null && this.field_70173_aa % 100 == 0) {
            this.rot = LMath.toPitchYaw(this.getOwner().func_174791_d().func_178786_a(this.field_70165_t, this.field_70163_u, this.field_70161_v)).func_179416_c();
        }
        this.field_70177_z = this.rot;
        this.field_70759_as = this.rot;
        this.field_70761_aq = this.rot;
        super.func_70636_d();
    }

    @Override
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a(OWNER, (Object)Optional.absent());
        this.field_70180_af.func_187214_a(TYPE, (Object)0);
    }

    public void onAddedToWorld() {
        super.onAddedToWorld();
        if (this.getOwner() != null) {
            this.rot = LMath.toPitchYaw(this.getOwner().func_174791_d().func_178786_a(this.field_70165_t, this.field_70163_u, this.field_70161_v)).func_179416_c();
        }
        if (this.field_70170_p.field_72995_K) {
            this.playAnimation("pose_" + (this.getType() + 1), 1.0f);
            EventsClientRender.renderForce.put(this.func_145782_y(), (Entity)this);
        }
    }

    public Vec3 getBeamOriginOffset() {
        switch (this.getType()) {
            case 1: 
            case 3: {
                return OFFSET_2;
            }
        }
        return OFFSET_1;
    }

    @Override
    public void setOwner(EntityCthulhu owner) {
        this.owner = owner;
        this.field_70180_af.func_187227_b(OWNER, (Object)Optional.of((Object)owner.func_110124_au()));
    }

    @Override
    public EntityCthulhu getOwner() {
        Optional uuidOptional;
        if (this.owner == null && (uuidOptional = (Optional)this.field_70180_af.func_187225_a(OWNER)).isPresent()) {
            UUID uuid = (UUID)uuidOptional.get();
            this.owner = this.field_70170_p.field_72996_f.stream().filter(entity -> entity.func_110124_au().equals(uuid) && entity instanceof EntityCthulhu).map(entity -> (EntityCthulhu)entity).findFirst().orElse(null);
        }
        return this.owner;
    }

    public void setType(int i) {
        this.field_70180_af.func_187227_b(TYPE, (Object)i);
    }

    public int getType() {
        return (Integer)this.field_70180_af.func_187225_a(TYPE);
    }

    @Override
    public AnimationHandler getAnimationHandler() {
        return this.handler;
    }

    @Override
    protected int numberOfLives() {
        return 10000;
    }

    @Override
    public boolean canBeDamaged(Entity attacker) {
        return false;
    }
}

