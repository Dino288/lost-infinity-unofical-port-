/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Optional
 *  javax.annotation.Nullable
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.PathfinderMob
 *  net.minecraft.entity.Mob
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.ai.EntityAIBase
 *  net.minecraft.entity.ai.EntityAINearestAttackableTarget
 *  net.minecraft.entity.ai.EntityMoveHelper
 *  net.minecraft.entity.monster.IMob
 *  net.minecraft.entity.player.Player
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.base;

import com.google.common.base.Optional;
import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.Mob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.entity.monster.IMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.level.Level;
import xol.lostinfinity.mob.ai.EntityAIFloatAttack;
import xol.lostinfinity.mob.ai.EntityAILookAround;
import xol.lostinfinity.mob.ai.EntityAIRandomFly;
import xol.lostinfinity.mob.ai.FloatMoveHelper;
import xol.lostinfinity.mob.entity.base.EntityFlyingCustom;

public abstract class EntityFloatingBase
extends EntityFlyingCustom
implements IMob {
    protected int attackCooldown = 0;
    protected int attackGracePeriod = 15;
    private static DataParameter<Optional<UUID>> TargetData = EntityDataManager.func_187226_a(EntityFloatingBase.class, (DataSerializer)DataSerializers.field_187203_m);

    public EntityFloatingBase(Level worldIn) {
        super(worldIn);
        this.field_70765_h = this.createMoveHelper();
    }

    public boolean func_145773_az() {
        return true;
    }

    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111265_b).func_111128_a(64.0);
    }

    @Override
    protected void func_70088_a() {
        super.func_70088_a();
        this.func_184212_Q().func_187214_a(TargetData, (Object)Optional.absent());
    }

    @Override
    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(5, (EntityAIBase)new EntityAIRandomFly((Mob)this));
        this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAILookAround((Mob)this));
        this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAINearestAttackableTarget((PathfinderMob)this, Player.class, false));
        EntityAIFloatAttack attack = this.createShootAI();
        if (attack != null) {
            this.field_70714_bg.func_75776_a(7, (EntityAIBase)attack);
        }
    }

    public void func_70636_d() {
        super.func_70636_d();
        if (this.attackCooldown > 0) {
            --this.attackCooldown;
        }
    }

    @Override
    protected int numberOfLives() {
        return 1;
    }

    @Nullable
    protected abstract EntityAIFloatAttack createShootAI();

    public void func_70100_b_(Player par1Player) {
        if (this.attackCooldown == 0) {
            this.func_70652_k((Entity)par1Player);
            this.attackCooldown = this.attackGracePeriod;
        }
    }

    protected void func_82167_n(Entity entityIn) {
        if (entityIn.equals((Object)this.func_70638_az()) && this.attackCooldown == 0) {
            this.func_70652_k(entityIn);
            this.attackCooldown = this.attackGracePeriod;
        }
    }

    protected EntityMoveHelper createMoveHelper() {
        return new FloatMoveHelper((Mob)this);
    }
}

