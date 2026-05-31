/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Optional
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.Mob
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.ai.EntityMoveHelper
 *  net.minecraft.entity.ai.EntityMoveHelper$Action
 *  net.minecraft.entity.player.Player
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Mth
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.nebula;

import com.google.common.base.Optional;
import java.util.List;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.world.entity.player.Player;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.core.Vec3i;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.misc.BlockNebulousBeacon;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.ai.EntityAIFloatAttack;
import xol.lostinfinity.mob.entity.base.EntityFloatingBase;
import xol.lostinfinity.projectile.entity.EntityNebulaSpell;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityNebulaWizard
extends EntityFloatingBase
implements IMaxAttack {
    private float modelAlpha = 0.0f;
    private static final DataParameter<Optional<BlockPos>> HOME_POS = EntityDataManager.func_187226_a(EntityNebulaWizard.class, (DataSerializer)DataSerializers.field_187201_k);
    private static final double SPELL_RANGE = 28.0;

    public EntityNebulaWizard(Level worldIn) {
        super(worldIn);
        this.func_70105_a(2.0f, 2.3f);
        this.field_70765_h = new AIMoveControl((Mob)this);
        this.field_70145_X = true;
    }

    public EntityNebulaWizard(Level worldIn, BlockPos parentBlock) {
        super(worldIn);
        this.func_70105_a(2.0f, 2.3f);
        this.func_184212_Q().func_187227_b(HOME_POS, (Object)Optional.of((Object)parentBlock));
        this.field_70765_h = new AIMoveControl((Mob)this);
        this.field_70145_X = true;
    }

    @Override
    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.2);
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(800.0);
        this.field_70765_h = new AIMoveControl((Mob)this);
    }

    @Override
    protected int numberOfLives() {
        return 7;
    }

    public float getModelAlpha() {
        return this.modelAlpha;
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null) {
            IMaxAttack.dealMaxHealth((Entity)this, this.func_70638_az(), 2);
            return true;
        }
        return false;
    }

    @Override
    protected void func_70088_a() {
        super.func_70088_a();
        this.func_184212_Q().func_187214_a(HOME_POS, (Object)Optional.absent());
    }

    @Override
    public void func_70636_d() {
        super.func_70636_d();
        if (!this.field_70170_p.field_72995_K) {
            BlockPos homePos;
            BlockState blockState;
            if (this.getHomePos().isPresent() && !((blockState = this.field_70170_p.func_180495_p(((BlockPos)this.getHomePos().get()).func_177982_a(0, -1, 0))).func_177230_c() instanceof BlockNebulousBeacon)) {
                this.setHomePos((Optional<BlockPos>)Optional.absent());
            }
            if (((Optional)this.func_184212_Q().func_187225_a(HOME_POS)).isPresent() && (homePos = (BlockPos)((Optional)this.func_184212_Q().func_187225_a(HOME_POS)).get()).func_177951_i((Vec3i)this.func_180425_c()) > 9.0) {
                this.func_70605_aq().func_75642_a((double)homePos.func_177958_n(), (double)homePos.func_177956_o(), (double)homePos.func_177952_p(), 0.3);
            }
            if (this.field_70173_aa % 60 == 0) {
                List list = this.field_70170_p.func_72872_a(Player.class, this.func_174813_aQ().func_186662_g(28.0));
                for (Player player : list) {
                    if (player.field_70128_L || player.func_175149_v() || player.func_184812_l_()) continue;
                    this.attackEntityWithRangedAttack(player);
                }
            }
        } else if (this.modelAlpha < 1.0f) {
            this.modelAlpha += 0.04f;
        }
    }

    @Override
    protected void func_82167_n(Entity entityIn) {
    }

    @Override
    protected EntityAIFloatAttack createShootAI() {
        return null;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundInit.NEBULA_WIZARD_HURT;
    }

    protected SoundEvent func_184639_G() {
        return SoundInit.NEBULA_WIZARD_AMBIENT;
    }

    protected SoundEvent func_184615_bR() {
        return SoundInit.NEBULA_WIZARD_DEATH;
    }

    private void attackEntityWithRangedAttack(Player target) {
        EntityNebulaSpell darkSpell = new EntityNebulaSpell(this.field_70170_p, (LivingEntity)this);
        double d0 = target.field_70165_t - this.field_70165_t;
        double d1 = target.func_174813_aQ().field_72338_b + (double)(target.field_70131_O / 3.0f) - darkSpell.field_70163_u;
        double d2 = target.field_70161_v - this.field_70161_v;
        darkSpell.func_70186_c(d0, d1, d2, 1.25f, 0.0f);
        this.field_70170_p.func_184133_a(null, this.func_180425_c(), SoundInit.NEBULA_WIZARD_SPELL, SoundSource.HOSTILE, 1.5f, 1.0f / (this.func_70681_au().nextFloat() * 0.4f + 0.8f));
        this.field_70170_p.func_72838_d((Entity)darkSpell);
    }

    public Optional<BlockPos> getHomePos() {
        return (Optional)this.func_184212_Q().func_187225_a(HOME_POS);
    }

    public void setHomePos(Optional<BlockPos> value) {
        this.func_184212_Q().func_187227_b(HOME_POS, value);
    }

    @Override
    public void func_70014_b(CompoundTag compound) {
        super.func_70014_b(compound);
        Optional<BlockPos> home = this.getHomePos();
        if (home.isPresent()) {
            compound.func_74780_a("x", (double)((BlockPos)home.get()).func_177958_n());
            compound.func_74780_a("y", (double)((BlockPos)home.get()).func_177956_o());
            compound.func_74780_a("z", (double)((BlockPos)home.get()).func_177952_p());
        }
    }

    @Override
    public void func_70037_a(CompoundTag compound) {
        super.func_70037_a(compound);
        double x = compound.func_74769_h("x");
        double y = compound.func_74769_h("y");
        double z = compound.func_74769_h("z");
        BlockPos pos = new BlockPos(x, y, z);
        Optional optPos = Optional.of((Object)pos);
        this.setHomePos((Optional<BlockPos>)optPos);
    }

    @Override
    public void trueDeathAction() {
        this.func_70106_y();
    }

    class AIMoveControl
    extends EntityMoveHelper {
        private final Mob entityLiving;

        public AIMoveControl(Mob vex) {
            super(vex);
            this.entityLiving = vex;
        }

        public void func_75641_c() {
            if (this.field_188491_h == EntityMoveHelper.Action.MOVE_TO) {
                double d0 = this.field_75646_b - this.entityLiving.field_70165_t;
                double d1 = this.field_75647_c - this.entityLiving.field_70163_u;
                double d2 = this.field_75644_d - this.entityLiving.field_70161_v;
                double d3 = d0 * d0 + d1 * d1 + d2 * d2;
                if ((d3 = (double)Mth.func_76133_a((double)d3)) < this.entityLiving.func_174813_aQ().func_72320_b()) {
                    this.field_188491_h = EntityMoveHelper.Action.WAIT;
                    this.entityLiving.field_70159_w *= 0.5;
                    this.entityLiving.field_70181_x *= 0.5;
                    this.entityLiving.field_70179_y *= 0.5;
                } else {
                    this.entityLiving.field_70159_w += d0 / d3 * 0.05 * this.field_75645_e;
                    this.entityLiving.field_70181_x += d1 / d3 * 0.05 * this.field_75645_e;
                    this.entityLiving.field_70179_y += d2 / d3 * 0.05 * this.field_75645_e;
                    if (this.entityLiving.func_70638_az() == null) {
                        this.entityLiving.field_70761_aq = this.entityLiving.field_70177_z = -((float)Mth.func_181159_b((double)this.entityLiving.field_70159_w, (double)this.entityLiving.field_70179_y)) * 57.295776f;
                    } else {
                        double d4 = this.entityLiving.func_70638_az().field_70165_t - this.entityLiving.field_70165_t;
                        double d5 = this.entityLiving.func_70638_az().field_70161_v - this.entityLiving.field_70161_v;
                        this.entityLiving.field_70761_aq = this.entityLiving.field_70177_z = -((float)Mth.func_181159_b((double)d4, (double)d5)) * 57.295776f;
                    }
                }
            }
        }
    }
}

