/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Predicate
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.util.EnumParticleTypes
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.world.World
 */
package xol.lostinfinity.projectile.entity;

import com.google.common.base.Predicate;
import java.util.Collections;
import java.util.List;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import xol.lostinfinity.client.fx.ClientParticleRenderer;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.sea.leviathan.EntityLeviathanController;
import xol.lostinfinity.mob.entity.sea.leviathan.EntityLeviathanSegment;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.CustomHitResult;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.data.RayTraceBuilder;
import xol.lostinfinity.util.math.LMath;

public class EntityLeviathanBreath
extends Entity
implements IMaxAttack {
    private static final List<String> DAMAGE_TYPE = Collections.singletonList("Aquatic");
    private static final DataParameter<Integer> OWNER = EntityDataManager.func_187226_a(EntityLeviathanBreath.class, (DataSerializer)DataSerializers.field_187192_b);
    private static final double BREATH_RANGE = 192.0;
    private EntityLeviathanController owner;
    private Vec3 direction;
    private Vec3 prevDirection;
    private float size;

    public EntityLeviathanBreath(Level worldIn) {
        super(worldIn);
        this.func_70105_a(0.25f, 0.25f);
        this.func_189654_d(true);
        this.field_70158_ak = true;
    }

    protected void func_70088_a() {
        this.field_70180_af.func_187214_a(OWNER, (Object)0);
    }

    public void setOwner(EntityLeviathanController owner) {
        this.owner = owner;
        this.field_70180_af.func_187227_b(OWNER, (Object)owner.func_145782_y());
    }

    public EntityLeviathanController getOwner() {
        return this.owner;
    }

    public void func_184206_a(DataParameter<?> key) {
        Entity entity;
        if (OWNER.equals(key) && (entity = this.field_70170_p.func_73045_a(((Integer)this.field_70180_af.func_187225_a(OWNER)).intValue())) instanceof EntityLeviathanController) {
            this.owner = (EntityLeviathanController)entity;
            this.size = this.owner.getLeviathanSize();
        }
    }

    public void onAddedToWorld() {
        super.onAddedToWorld();
        if (!this.field_70170_p.field_72995_K) {
            this.field_70170_p.func_184133_a(null, this.func_180425_c(), SoundInit.GENERIC_WEAPON_14, SoundSource.HOSTILE, 16.0f, 1.0f);
        }
    }

    public void func_70030_z() {
        if (this.field_70173_aa > 200 || this.owner == null || this.owner.func_110143_aJ() <= 0.0f) {
            this.func_70106_y();
            return;
        }
        super.func_70030_z();
        EntityLeviathanSegment head = this.owner.segments[0];
        this.func_70634_a(head.field_70165_t, head.field_70163_u + (double)(head.field_70131_O / 2.0f), head.field_70161_v);
        if (this.field_70170_p.field_72995_K) {
            this.prevDirection = this.direction;
            Vec3 lookVec = head.func_70040_Z();
            this.direction = lookVec.func_186678_a(192.0);
            CustomParticleConfig config = new CustomParticleConfig();
            config.createInstance().setWeight(50).setParticle(ParticleInit.LARGE_BUBBLE).setSpread(this.size, this.size, this.size).setIgnoreRange(true);
            config.createInstance().setWeight(50).setParticle(ParticleInit.LARGE_BUBBLE_PURPLE).setSpread(this.size, this.size, this.size).setIgnoreRange(true);
            config.createInstance().setParticle(ParticleInit.TESLA_RING_YELLOW).setSpread(0.0, 0.0, 0.0).setIgnoreRange(true);
            float i = 0.0f;
            while ((double)i < 192.0) {
                config.setOrigin(head.field_70165_t + lookVec.field_72450_a * (double)i, head.field_70163_u + lookVec.field_72448_b * (double)i, head.field_70161_v + lookVec.field_72449_c * (double)i);
                ClientParticleRenderer.renderComplex(config);
                i += this.size;
            }
        } else if (this.field_70173_aa % 5 == 0) {
            CustomHitResult result = RayTraceBuilder.entity(LivingEntity.class, 100).maxEntity(0).entityFilter((Predicate<Entity>)((Predicate)input -> RayTraceBuilder.checkEntityImmaterial(input) && !(input instanceof EntityLeviathanSegment) && !(input instanceof EntityLeviathanController))).force(true).raySize(this.size / 2.0f).trace((Entity)head, true);
            if (result == null) {
                return;
            }
            for (Entity inline : result.getResultEntities()) {
                IMaxAttack.dealTrueDamage(this, (LivingEntity)inline, ((LivingEntity)inline).func_110138_aP() * 0.2f, DAMAGE_TYPE);
                this.field_70170_p.func_175688_a(EnumParticleTypes.EXPLOSION_HUGE, inline.field_70165_t, inline.field_70163_u, inline.field_70161_v, 0.0, 0.0, 0.0, new int[0]);
            }
            this.field_70170_p.func_184133_a(null, this.func_180425_c(), SoundInit.ELECTRIC_WOOSH, SoundSource.HOSTILE, 16.0f, 1.0f);
        }
    }

    public Vec3 getDirection(float partialTick) {
        if (this.owner == null) {
            return null;
        }
        if (this.direction == null) {
            this.direction = this.owner.segments[0].func_70040_Z().func_186678_a(192.0);
        }
        return this.prevDirection != null ? LMath.lerp(this.prevDirection, this.direction, (double)partialTick) : this.direction;
    }

    public float getOwnerSize() {
        return this.size;
    }

    protected void func_70037_a(CompoundTag compound) {
    }

    protected void func_70014_b(CompoundTag compound) {
    }

    public int func_70070_b() {
        return 0xF000F0;
    }

    public float func_70013_c() {
        return 1.0f;
    }
}

