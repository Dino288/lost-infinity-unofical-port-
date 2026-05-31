/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Optional
 *  javax.annotation.Nullable
 *  net.minecraft.block.material.Material
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.client.Minecraft
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.IEntityOwnable
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.player.Player
 *  net.minecraft.entity.player.ServerPlayer
 *  net.minecraft.network.NetHandlerPlayServer
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.MovementInput
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.common.ObfuscationReflectionHelper
 */
package xol.lostinfinity.mob.entity.base;

import com.google.common.base.Optional;
import java.lang.reflect.Field;
import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.block.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.IEntityOwnable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.MovementInput;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import xol.lostinfinity.mob.entity.base.EntityMultipleLives;
import xol.lostinfinity.util.data.CustomDamageResult;
import xol.lostinfinity.util.math.LMath;

public class EntityMultipleLivesMount
extends EntityMultipleLives
implements IEntityOwnable {
    private static final Field VEHICLE_FLOATING_TICK_COUNT;
    private static final DataParameter<Optional<UUID>> OWNER_ID;
    protected float ascendSpeed = 1.0f;
    protected boolean isActuallyOnGround;
    protected float prevSpeed;
    protected float speed;
    protected Player owner;

    public EntityMultipleLivesMount(Level worldIn) {
        super(worldIn);
    }

    @Override
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a(OWNER_ID, (Object)Optional.absent());
    }

    public void func_70071_h_() {
        if (this.field_70173_aa % 20 == 0) {
            this.resetFloatTime();
        }
        super.func_70071_h_();
    }

    public void setOwner(Player player) {
        this.owner = player;
        this.field_70180_af.func_187227_b(OWNER_ID, (Object)Optional.of((Object)player.func_110124_au()));
    }

    public void onDriverCommand(Player driver) {
    }

    public void onDriverDamaged(Entity driver, CustomDamageResult result) {
    }

    protected void func_184231_a(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
    }

    public void func_180430_e(float distance, float damageMultiplier) {
    }

    public boolean func_82171_bF() {
        return this.func_184179_bs() instanceof LivingEntity;
    }

    public double func_70042_X() {
        return super.func_70042_X();
    }

    public boolean shouldDismountInWater(Entity rider) {
        return false;
    }

    @Nullable
    public Entity func_184179_bs() {
        return this.func_184188_bt().isEmpty() ? null : (Entity)this.func_184188_bt().get(0);
    }

    public void func_191986_a(float strafe, float vertical, float forward) {
        if (this.func_184207_aI() && this.func_82171_bF() && !this.field_70128_L) {
            LivingEntity entitylivingbase = (LivingEntity)this.func_184179_bs();
            if (entitylivingbase != null) {
                this.func_70101_b(entitylivingbase.field_70177_z, entitylivingbase.field_70125_A * 0.5f);
                this.field_70126_B = this.field_70177_z;
                this.field_70759_as = this.field_70761_aq = this.field_70177_z;
                strafe = entitylivingbase.field_70702_br * 0.5f;
                forward = entitylivingbase.field_191988_bg;
                if (this.field_70170_p.field_72995_K && entitylivingbase == Minecraft.func_71410_x().field_71439_g) {
                    MovementInput input = Minecraft.func_71410_x().field_71439_g.field_71158_b;
                    this.field_70181_x = input.field_78901_c ? (double)this.ascendSpeed : (input.field_78899_d ? (double)(-this.ascendSpeed) : 0.0);
                } else {
                    this.field_70181_x = 0.0;
                }
                this.func_70659_e((float)this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111126_e());
                boolean prevGround = this.field_70122_E;
                this.field_70122_E = true;
                this.originalTravel(strafe, vertical, forward);
                this.field_70122_E = prevGround;
                this.prevSpeed = this.speed;
                this.speed = (float)LMath.fastLength(this.field_70159_w, 0.0, this.field_70179_y);
            }
        } else {
            this.originalTravel(strafe, vertical, forward);
        }
        this.updateOnGroundState();
    }

    protected void originalTravel(float strafe, float vertical, float forward) {
        super.func_191986_a(strafe, vertical, forward);
    }

    protected void resetFloatTime() {
        Entity controller = this.func_184179_bs();
        if (controller instanceof ServerPlayer) {
            try {
                VEHICLE_FLOATING_TICK_COUNT.set(((ServerPlayer)controller).field_71135_a, 0);
            }
            catch (IllegalAccessException ignored) {
                throw new RuntimeException("Failed to reset vehicle floating tick!");
            }
        }
    }

    protected void updateOnGroundState() {
        this.isActuallyOnGround = this.field_70170_p.func_180495_p(this.func_180425_c().func_177977_b()).func_185904_a() != Material.field_151579_a;
    }

    protected boolean func_184645_a(Player player, InteractionHand hand) {
        if (this.field_70170_p.field_72995_K) {
            return !player.func_70093_af();
        }
        if (!player.func_70093_af()) {
            player.func_184220_m((Entity)this);
            return true;
        }
        return false;
    }

    public boolean canDismount() {
        return this.field_70128_L || this.field_70122_E || this.func_110143_aJ() <= 0.0f;
    }

    public boolean isActuallyOnGround() {
        return this.isActuallyOnGround;
    }

    public float getPrevSpeed() {
        return this.prevSpeed;
    }

    public float getSpeed() {
        return this.speed;
    }

    @Nullable
    public UUID func_184753_b() {
        return (UUID)((Optional)this.field_70180_af.func_187225_a(OWNER_ID)).orNull();
    }

    @Nullable
    public Player getOwner() {
        Optional ownerId;
        if (this.owner == null && (ownerId = (Optional)this.field_70180_af.func_187225_a(OWNER_ID)).isPresent()) {
            this.owner = this.field_70170_p.func_152378_a((UUID)ownerId.get());
        }
        return this.owner;
    }

    static {
        OWNER_ID = EntityDataManager.func_187226_a(EntityMultipleLivesMount.class, (DataSerializer)DataSerializers.field_187203_m);
        VEHICLE_FLOATING_TICK_COUNT = ObfuscationReflectionHelper.findField(NetHandlerPlayServer.class, (String)"field_184346_E");
        VEHICLE_FLOATING_TICK_COUNT.setAccessible(true);
    }
}

