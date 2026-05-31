/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.network.datasync.EntityDataManager$DataEntry
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 *  org.lwjgl.util.vector.Quaternion
 */
package xol.lostinfinity.mob.entity.misc;

import java.util.Random;
import java.util.UUID;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.util.vector.Quaternion;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.base.EntityImmaterial;
import xol.lostinfinity.mob.entity.base.EntityMultipleLives;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.math.LMath;

public class EntityNuclearExplosion
extends EntityImmaterial
implements IMaxAttack {
    private static final DataParameter<Integer> ANIMATION_TICK = EntityDataManager.func_187226_a(EntityNuclearExplosion.class, (DataSerializer)DataSerializers.field_187192_b);
    private static final float PULL_STRENGTH = 0.2f;
    private UUID ownerUUID;
    private boolean hasExploded;
    @SideOnly(value=Side.CLIENT)
    private Quaternion[] rotations;

    public EntityNuclearExplosion(Level worldIn) {
        super(worldIn);
        this.func_70105_a(0.001f, 0.001f);
        this.func_82142_c(true);
        this.field_70145_X = true;
        if (worldIn.field_72995_K) {
            this.rotations = new Quaternion[6];
            Random random = worldIn.field_73012_v;
            for (int i = 0; i < this.rotations.length; ++i) {
                this.rotations[i] = LMath.fromEulerDegree(random.nextFloat() * 360.0f, random.nextFloat() * 360.0f, random.nextFloat() * 360.0f);
            }
        }
    }

    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a(ANIMATION_TICK, (Object)0);
    }

    public void addAnimationTick() {
        this.field_70180_af.func_187227_b(ANIMATION_TICK, (Object)(this.getAnimationTick() + 1));
        ((EntityDataManager.DataEntry)this.field_70180_af.func_187231_c().get(ANIMATION_TICK.func_187155_a())).func_187208_a(false);
    }

    public int getAnimationTick() {
        return (Integer)this.field_70180_af.func_187225_a(ANIMATION_TICK);
    }

    public void func_70014_b(CompoundTag tag) {
        super.func_70014_b(tag);
        tag.func_186854_a("OwnerUUID", this.ownerUUID);
    }

    public void func_70037_a(CompoundTag tag) {
        super.func_70037_a(tag);
        this.ownerUUID = tag.func_186857_a("OwnerUUID");
    }

    public void setOwner(UUID uuid) {
        this.ownerUUID = uuid;
    }

    @SideOnly(value=Side.CLIENT)
    public Quaternion getRotation(int i) {
        return this.rotations[i];
    }

    @Override
    public void func_70636_d() {
        super.func_70636_d();
        this.addAnimationTick();
        if (!this.field_70170_p.field_72995_K) {
            if (this.field_70173_aa > 200) {
                this.func_70106_y();
                return;
            }
            if (!this.hasExploded) {
                if (this.field_70173_aa > 160) {
                    this.explosion();
                } else {
                    this.pullNearby();
                }
            }
        } else if (this.getAnimationTick() % 5 == 0) {
            if (this.rotations.length - 1 >= 0) {
                System.arraycopy(this.rotations, 1, this.rotations, 0, this.rotations.length - 1);
            }
            this.rotations[this.rotations.length - 1] = LMath.fromEulerDegree(this.field_70170_p.field_73012_v.nextFloat() * 360.0f, this.field_70170_p.field_73012_v.nextFloat() * 360.0f, this.field_70170_p.field_73012_v.nextFloat() * 360.0f);
        }
    }

    protected void func_82167_n(Entity entityIn) {
    }

    private void pullNearby() {
        EntityNuclearExplosion attacker = this;
        Player ownerPlayer = this.field_70170_p.func_152378_a(this.ownerUUID);
        if (ownerPlayer != null) {
            attacker = ownerPlayer;
        }
        Vec3 origin = this.func_174791_d();
        for (LivingEntity target : this.field_70170_p.func_175647_a(LivingEntity.class, this.func_174813_aQ().func_72314_b(32.0, 32.0, 32.0), input -> !(input instanceof EntityImmaterial))) {
            if (target == attacker || target == this) continue;
            Vec3 dir = LMath.fastNormalize(origin.func_178788_d(target.func_174791_d())).func_186678_a((double)0.2f);
            target.func_70024_g(dir.field_72450_a, dir.field_72448_b, dir.field_72449_c);
            target.field_70133_I = true;
        }
        if (this.field_70173_aa % 20 == 0 && this.field_70173_aa < 140) {
            this.field_70170_p.func_184133_a(null, this.func_180425_c(), SoundInit.GENERIC_WEAPON_12, SoundSource.MASTER, 5.0f, 0.5f);
        }
    }

    private void explosion() {
        this.hasExploded = true;
        EntityNuclearExplosion attacker = this;
        Player ownerPlayer = this.field_70170_p.func_152378_a(this.ownerUUID);
        if (ownerPlayer != null) {
            attacker = ownerPlayer;
        }
        for (LivingEntity target : this.field_70170_p.func_72872_a(LivingEntity.class, this.func_174813_aQ().func_72314_b(60.0, 60.0, 60.0))) {
            if (target == attacker || target == this) continue;
            if (target.func_70032_d((Entity)this) < 15.0f) {
                if (IMaxAttack.dealTrueDamage((Entity)attacker, target, target.func_110138_aP() * 2.0f).wasTargetKilled() || !(target instanceof EntityMultipleLives)) continue;
                EntityMultipleLives multicreature = (EntityMultipleLives)target;
                multicreature.takeawayNumLives(8);
                continue;
            }
            IMaxAttack.dealMaxHealth((Entity)attacker, target, 1, 4.0f);
        }
        for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.func_174813_aQ().func_72314_b(70.0, 70.0, 70.0))) {
            this.field_70170_p.func_184133_a(null, near_pl.func_180425_c(), SoundInit.DEEP_EXPLOSION, SoundSource.MASTER, 1.5f, 0.75f + this.field_70146_Z.nextFloat() * 0.5f);
        }
    }
}

