/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.init.MobEffects
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.network.datasync.EntityDataManager$DataEntry
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.SoundSource
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 *  org.lwjgl.util.vector.Quaternion
 */
package xol.lostinfinity.mob.entity.cthulhu;

import java.util.List;
import java.util.Random;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.init.MobEffects;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.PotionEffect;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.util.vector.Quaternion;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.PotionInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.cthulhu.EntityCthulhu;
import xol.lostinfinity.mob.entity.cthulhu.ICthulhuMinion;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.math.LMath;

public class EntityCthulhuBlackHole
extends Entity
implements ICthulhuMinion {
    private static final DataParameter<Integer> ANIMATION_TICK = EntityDataManager.func_187226_a(EntityCthulhuBlackHole.class, (DataSerializer)DataSerializers.field_187192_b);
    private static final double RANGE = 6.0;
    private float lastGrowth = 0.0f;
    private float growth = 0.0f;
    private float lastRotation = 0.0f;
    private float rotation = 0.0f;
    private float angle = 0.0f;
    protected EntityCthulhu owner;
    @SideOnly(value=Side.CLIENT)
    private Quaternion[] rotations;
    private static final int LIFESPAN_TICKS = 200;

    public EntityCthulhuBlackHole(Level worldIn) {
        super(worldIn);
        this.func_70105_a(0.5f, 0.5f);
        if (worldIn.field_72995_K) {
            this.rotations = new Quaternion[6];
            Random random = worldIn.field_73012_v;
            for (int i = 0; i < this.rotations.length; ++i) {
                this.rotations[i] = LMath.fromEulerDegree(random.nextFloat() * 360.0f, random.nextFloat() * 360.0f, random.nextFloat() * 360.0f);
            }
        }
    }

    protected void func_70088_a() {
        this.field_70180_af.func_187214_a(ANIMATION_TICK, (Object)0);
    }

    public void addAnimationTick() {
        this.field_70180_af.func_187227_b(ANIMATION_TICK, (Object)(this.getAnimationTick() + 1));
        ((EntityDataManager.DataEntry)this.field_70180_af.func_187231_c().get(ANIMATION_TICK.func_187155_a())).func_187208_a(false);
    }

    public int getAnimationTick() {
        return (Integer)this.field_70180_af.func_187225_a(ANIMATION_TICK);
    }

    @Override
    public void setOwner(EntityCthulhu owner) {
        this.owner = owner;
    }

    @Override
    public EntityCthulhu getOwner() {
        return this.owner;
    }

    public void func_70071_h_() {
        super.func_70071_h_();
        this.addAnimationTick();
        this.lastGrowth = this.growth;
        this.lastRotation = this.rotation;
        this.growth = this.field_70173_aa < 100 ? (this.growth += 0.1f) : (this.growth -= 0.075f);
        this.rotation += 0.2f;
        if (!this.field_70170_p.field_72995_K) {
            if (this.field_70173_aa % 5 == 0) {
                this.field_70170_p.func_184133_a(null, this.func_180425_c(), SoundInit.GHOSTLY_CLOUDS, SoundSource.PLAYERS, 1.5f, 0.5f + this.field_70146_Z.nextFloat() * 0.6f);
            }
            if (this.field_70173_aa >= 200) {
                this.func_70106_y();
                return;
            }
            List nearEntities = this.field_70170_p.func_72872_a(LivingEntity.class, this.func_174813_aQ().func_186662_g(6.0));
            for (LivingEntity entity : nearEntities) {
                if (entity.equals((Object)this.owner) || entity instanceof ICthulhuMinion || entity instanceof EntityCthulhu) continue;
                entity.func_70024_g((this.field_70165_t - entity.field_70165_t) / 30.0, (this.field_70163_u - entity.field_70163_u) / 20.0, (this.field_70161_v - entity.field_70161_v) / 30.0);
                entity.field_70133_I = true;
                if (!entity.func_174813_aQ().func_72326_a(this.func_174813_aQ().func_186662_g((double)this.growth)) || this.field_70173_aa % 10 != 0) continue;
                IMaxAttack.dealTrueDamage((Entity)this.owner, entity, entity.func_110138_aP() * 0.15f);
            }
        } else {
            for (int i = 0; i < 4; ++i) {
                float growthDist = this.growth * 1.06f;
                this.angle += 0.15f;
                double velocity_x = (double)growthDist * Math.cos(this.angle);
                double velocity_z = (double)growthDist * Math.sin(this.angle);
                this.field_70170_p.func_175688_a(ParticleInit.GENERIC_DOT_PINK, this.field_70165_t - velocity_x / 2.0, this.field_70163_u - 0.25, this.field_70161_v - velocity_z / 2.0, 0.0, 0.0, 0.0, new int[0]);
                this.field_70170_p.func_175688_a(ParticleInit.GENERIC_DOT_ACID, this.field_70165_t + velocity_x / 2.0, this.field_70163_u - 0.25, this.field_70161_v + velocity_z / 2.0, 0.0, 0.0, 0.0, new int[0]);
                this.field_70170_p.func_175688_a(this.field_70146_Z.nextBoolean() ? ParticleInit.GENERIC_DOT_BLACK : ParticleInit.GENERIC_DOT_WHITE, this.field_70165_t + velocity_x / 2.0, this.field_70163_u, this.field_70161_v + velocity_z / 2.0, 0.0, 0.0, 0.0, new int[0]);
            }
        }
        if (this.field_70170_p.field_72995_K && this.getAnimationTick() % 5 == 0) {
            if (this.rotations.length - 1 >= 0) {
                System.arraycopy(this.rotations, 1, this.rotations, 0, this.rotations.length - 1);
            }
            this.rotations[this.rotations.length - 1] = LMath.fromEulerDegree(this.field_70170_p.field_73012_v.nextFloat() * 360.0f, this.field_70170_p.field_73012_v.nextFloat() * 360.0f, this.field_70170_p.field_73012_v.nextFloat() * 360.0f);
        }
    }

    @SideOnly(value=Side.CLIENT)
    public Quaternion getRotation(int i) {
        return this.rotations[i];
    }

    public void func_70037_a(CompoundTag compound) {
        this.growth = compound.func_74760_g("growth");
        this.rotation = compound.func_74760_g("rotation");
        this.angle = compound.func_74760_g("angle");
        this.read(compound, this);
    }

    public void func_70014_b(CompoundTag compound) {
        compound.func_74776_a("growth", this.growth);
        compound.func_74776_a("rotation", this.rotation);
        compound.func_74776_a("angle", this.angle);
        this.write(compound);
    }

    public float getGrowth() {
        return this.growth;
    }

    public float getLastGrowth() {
        return this.lastGrowth;
    }

    public float getRotation() {
        return this.rotation;
    }

    public float getLastRotation() {
        return this.lastRotation;
    }

    public void func_70106_y() {
        this.field_70170_p.func_72876_a((Entity)this, this.field_70165_t, this.field_70163_u, this.field_70161_v, 5.0f, false);
        List nearbyEntities = this.field_70170_p.func_72872_a(LivingEntity.class, this.func_174813_aQ().func_186662_g(5.0));
        for (LivingEntity entity : nearbyEntities) {
            if (entity instanceof ICthulhuMinion || entity == this.owner) continue;
            entity.func_70690_d(new PotionEffect(PotionInit.PLAGUE, 200, 3, false, false));
            entity.func_70690_d(new PotionEffect(MobEffects.field_76436_u, 200, 3, false, false));
            entity.func_70690_d(new PotionEffect(MobEffects.field_76421_d, 200, 3, false, false));
            IMaxAttack.dealTrueDamage(this, entity, entity.func_110138_aP());
        }
        super.func_70106_y();
    }
}

