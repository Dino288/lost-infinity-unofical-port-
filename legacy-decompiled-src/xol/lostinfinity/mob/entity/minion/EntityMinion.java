/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Optional
 *  javax.annotation.Nullable
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.client.Minecraft
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.IEntityOwnable
 *  net.minecraft.entity.player.Player
 *  net.minecraft.entity.player.Inventory
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.mob.entity.minion;

import com.google.common.base.Optional;
import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.IEntityOwnable;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.common.special.CommonMinionHandler;
import xol.lostinfinity.mob.entity.base.EntityImmaterial;

public class EntityMinion
extends EntityImmaterial
implements IEntityOwnable {
    private static final DataParameter<Optional<UUID>> OWNER_UUID = EntityDataManager.func_187226_a(EntityMinion.class, (DataSerializer)DataSerializers.field_187203_m);
    private static final DataParameter<Boolean> ACTIVE = EntityDataManager.func_187226_a(EntityMinion.class, (DataSerializer)DataSerializers.field_187198_h);
    protected Player owner;
    protected InteractionHand hand;
    protected ItemStack trackedItemStack;
    protected int lastSeenSlot;

    public EntityMinion(Level worldIn) {
        super(worldIn);
        this.field_70145_X = true;
    }

    public void setLastSlot(int slot) {
        this.lastSeenSlot = slot;
    }

    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a(OWNER_UUID, (Object)Optional.absent());
        this.field_70180_af.func_187214_a(ACTIVE, (Object)false);
    }

    public void func_70106_y() {
        super.func_70106_y();
        this.onDeath();
        Optional uuid = (Optional)this.field_70180_af.func_187225_a(OWNER_UUID);
        if (uuid.isPresent()) {
            CommonMinionHandler.unregisterMinion((UUID)uuid.get(), this);
        }
    }

    public void setDeadNoTrigger() {
        super.func_70106_y();
        this.onDeath();
    }

    protected void onDeath() {
    }

    protected void func_184231_a(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
    }

    public void func_180430_e(float distance, float damageMultiplier) {
    }

    public boolean func_70112_a(double distance) {
        return true;
    }

    public void setOwner(Player player) {
        this.owner = player;
        this.field_70180_af.func_187227_b(OWNER_UUID, (Object)Optional.of((Object)this.owner.func_110124_au()));
        CommonMinionHandler.registerMinion(player.func_110124_au(), this);
    }

    public void setHand(InteractionHand hand) {
        this.hand = hand;
    }

    @Nullable
    public UUID func_184753_b() {
        return (UUID)((Optional)this.field_70180_af.func_187225_a(OWNER_UUID)).orNull();
    }

    @Nullable
    public Player getOwner() {
        Optional ownerId;
        if (this.owner == null && (ownerId = (Optional)this.field_70180_af.func_187225_a(OWNER_UUID)).isPresent()) {
            this.owner = this.field_70170_p.func_152378_a((UUID)ownerId.get());
        }
        return this.owner;
    }

    public void setActive(boolean flag) {
        this.field_70180_af.func_187227_b(ACTIVE, (Object)flag);
    }

    public boolean isActive() {
        return (Boolean)this.field_70180_af.func_187225_a(ACTIVE);
    }

    public void setTrackedItemStack(ItemStack stack) {
        this.trackedItemStack = stack;
    }

    @Override
    public void func_70636_d() {
        if (!(this.field_70170_p.field_72995_K || this.getOwner() != null && this.owner.field_70170_p == this.field_70170_p && !this.owner.field_70128_L && this.isStillHoldingItem())) {
            this.func_70106_y();
            return;
        }
        super.func_70636_d();
        this.livingUpdate();
    }

    protected void livingUpdate() {
    }

    public boolean func_70075_an() {
        return false;
    }

    public void func_180426_a(double x, double y, double z, float yaw, float pitch, int posRotationIncrements, boolean teleport) {
        super.func_180426_a(x, y, z, yaw, pitch, 1, teleport);
    }

    public boolean func_190631_cK() {
        return false;
    }

    @SideOnly(value=Side.CLIENT)
    public boolean shouldRender() {
        return this.isActive() || this.getOwner() != Minecraft.func_71410_x().field_71439_g || Minecraft.func_71410_x().field_71474_y.field_74320_O != 0;
    }

    protected boolean isStillHoldingItem() {
        if (this.owner == null) {
            return false;
        }
        ItemStack stack = this.owner.field_71071_by.func_70301_a(this.lastSeenSlot);
        if (this.trackedItemStack.func_77969_a(stack)) {
            this.trackedItemStack = stack;
            return true;
        }
        this.lastSeenSlot = this.getSlotFor(this.owner.field_71071_by, this.trackedItemStack);
        if (this.lastSeenSlot != -1) {
            this.trackedItemStack = this.owner.field_71071_by.func_70301_a(this.lastSeenSlot);
            return true;
        }
        return false;
    }

    protected double getRandomDouble(double mul) {
        return (-0.5 + (double)this.field_70146_Z.nextFloat()) * mul;
    }

    protected boolean validateTarget(Entity input) {
        if (!(input instanceof LivingEntity)) {
            return false;
        }
        if (input instanceof EntityImmaterial || input == this.getOwner() || input.field_70128_L || ((LivingEntity)input).func_110143_aJ() <= 0.0f) {
            return false;
        }
        if (input instanceof Player) {
            return !((Player)input).func_184812_l_() && !((Player)input).func_175149_v();
        }
        if (input instanceof IEntityOwnable) {
            return ((IEntityOwnable)input).func_70902_q() != this.getOwner();
        }
        return true;
    }

    private int getSlotFor(Inventory inventoryPlayer, ItemStack stack) {
        for (int i = 0; i < inventoryPlayer.field_70462_a.size(); ++i) {
            if (((ItemStack)inventoryPlayer.field_70462_a.get(i)).func_190926_b() || !stack.equals(inventoryPlayer.field_70462_a.get(i))) continue;
            return i;
        }
        return -1;
    }
}

