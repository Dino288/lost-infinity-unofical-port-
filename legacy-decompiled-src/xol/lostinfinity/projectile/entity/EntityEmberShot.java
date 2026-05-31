/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Optional
 *  javax.annotation.Nullable
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.util.math.HitResult$Type
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.world.World
 */
package xol.lostinfinity.projectile.entity;

import com.google.common.base.Optional;
import java.util.Arrays;
import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.item.basics.ItemChanneling;
import xol.lostinfinity.mob.entity.base.EntityMultipleLives;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.fx.IParticleSpawner;
import xol.lostinfinity.util.math.LMath;

public class EntityEmberShot
extends EntityBaseThrowable {
    private static final DataParameter<ItemStack> ITEM_STACK = EntityDataManager.func_187226_a(EntityEmberShot.class, (DataSerializer)DataSerializers.field_187196_f);
    private static final DataParameter<Optional<UUID>> OWNER = EntityDataManager.func_187226_a(EntityEmberShot.class, (DataSerializer)DataSerializers.field_187203_m);
    private static final DataParameter<Boolean> RELEASED = EntityDataManager.func_187226_a(EntityEmberShot.class, (DataSerializer)DataSerializers.field_187198_h);
    private int releaseTick = -1;

    public EntityEmberShot(Level worldIn) {
        super(worldIn);
        this.func_70105_a(0.25f, 0.25f);
    }

    protected void func_70088_a() {
        this.field_70180_af.func_187214_a(ITEM_STACK, (Object)ItemStack.field_190927_a);
        this.field_70180_af.func_187214_a(OWNER, (Object)Optional.absent());
        this.field_70180_af.func_187214_a(RELEASED, (Object)false);
    }

    public void setItemStack(ItemStack stack) {
        this.field_70180_af.func_187227_b(ITEM_STACK, (Object)stack);
    }

    public ItemStack getItemStack() {
        return (ItemStack)this.field_70180_af.func_187225_a(ITEM_STACK);
    }

    public void setReleased() {
        this.field_70180_af.func_187227_b(RELEASED, (Object)true);
    }

    public boolean isReleased() {
        return (Boolean)this.field_70180_af.func_187225_a(RELEASED);
    }

    @Nullable
    public LivingEntity func_85052_h() {
        if (this.field_70192_c != null) {
            return this.field_70192_c;
        }
        Optional uuidOptional = (Optional)this.field_70180_af.func_187225_a(OWNER);
        if (uuidOptional.isPresent()) {
            this.field_70192_c = this.field_70170_p.func_152378_a((UUID)uuidOptional.get());
        }
        return this.field_70192_c;
    }

    @Override
    public void setThrower(LivingEntity throwset) {
        super.setThrower(throwset);
        this.field_70180_af.func_187227_b(OWNER, (Object)Optional.of((Object)throwset.func_110124_au()));
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (!this.isReleased()) {
            return;
        }
        if (this.field_70170_p.field_72995_K || result.field_72313_a != HitResult.Type.ENTITY) {
            return;
        }
        if (result.field_72308_g instanceof LivingEntity && result.field_72308_g != this.field_70192_c) {
            LivingEntity target = (LivingEntity)result.field_72308_g;
            double mX = target.field_70159_w;
            double mY = target.field_70181_x;
            double mZ = target.field_70179_y;
            if (!IMaxAttack.dealTrueDamage((Entity)this.field_70192_c, target, target.func_110138_aP() * 0.25f, Arrays.asList("Darkborn")).wasTargetKilled() && target instanceof EntityMultipleLives) {
                EntityMultipleLives multiLifer = (EntityMultipleLives)target;
                ((EntityMultipleLives)target).takeawayNumLives(3);
            }
            target.field_70159_w = mX;
            target.field_70181_x = mY;
            target.field_70179_y = mZ;
            CustomParticleConfig config = new CustomParticleConfig();
            config.createInstance().setParticle(ParticleInit.EXPLOSION_RING).setIgnoreRange(true);
            IParticleSpawner.spawnParticle(this.field_70170_p, config, this.func_174791_d());
            this.func_70106_y();
        }
    }

    @Override
    public void func_70071_h_() {
        super.func_70071_h_();
        LivingEntity thrower = this.func_85052_h();
        if (thrower == null) {
            this.func_70106_y();
            return;
        }
        boolean released = this.isReleased();
        if (released && this.field_70173_aa - this.releaseTick >= 300) {
            this.func_70106_y();
            return;
        }
        boolean channeling = ItemChanneling.isChanneling(thrower, this.getItemStack());
        if (!channeling && !released) {
            this.setReleased();
            Vec3 dir = LMath.fastNormalize(new Vec3((double)this.getItemStack().func_77978_p().func_74760_g("targetX") - this.field_70165_t, (double)this.getItemStack().func_77978_p().func_74760_g("targetY") - this.field_70163_u, (double)this.getItemStack().func_77978_p().func_74760_g("targetZ") - this.field_70161_v)).func_186678_a(4.0);
            this.field_70159_w = dir.field_72450_a;
            this.field_70181_x = dir.field_72448_b;
            this.field_70179_y = dir.field_72449_c;
            this.field_70133_I = true;
            this.releaseTick = this.field_70173_aa;
        }
        if (this.field_70170_p.field_72995_K) {
            this.field_70170_p.func_175682_a(ParticleInit.FLAME_MEDIUM, true, this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0, 0.0, 0.0, new int[0]);
        }
    }

    protected float func_70185_h() {
        return 0.0f;
    }

    @Override
    protected boolean willDespawn() {
        return false;
    }
}

