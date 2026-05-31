/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.util.DamageSource
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.common.network.simpleimpl.IMessage
 */
package xol.lostinfinity.mob.entity.base;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import xol.lostinfinity.common.packets.LostInfinityPacketHandler;
import xol.lostinfinity.common.packets.clientbound.PacketSyncParts;
import xol.lostinfinity.mob.entity.base.EntityMultipleLives;
import xol.lostinfinity.mob.entity.classify.ILostMultiPart;
import xol.lostinfinity.mob.entity.classify.IRelay;

public class EntityMultipleLivesRelay<T extends EntityMultipleLives>
extends EntityMultipleLives
implements IRelay<T> {
    protected T relay;
    protected int id;
    protected boolean awaitSync;
    protected double syncX;
    protected double syncY;
    protected double syncZ;
    protected float syncYaw;
    protected float syncPitch;

    public EntityMultipleLivesRelay(Level worldIn) {
        super(worldIn);
    }

    public EntityMultipleLivesRelay(T relay, float width, float height) {
        super(relay.func_130014_f_());
        this.relay = relay;
        this.func_70105_a(width, height);
        this.field_70145_X = true;
        this.func_189654_d(true);
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a((double)relay.func_110138_aP());
    }

    @Override
    public T getRelay() {
        return this.relay;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setPos(double x, double y, double z, float yaw, float pitch) {
        this.syncX = x;
        this.syncY = y;
        this.syncZ = z;
        this.syncYaw = yaw;
        this.syncPitch = pitch;
        this.awaitSync = true;
    }

    @Override
    public double getX() {
        return this.field_70165_t;
    }

    @Override
    public double getY() {
        return this.field_70163_u;
    }

    @Override
    public double getZ() {
        return this.field_70161_v;
    }

    @Override
    public float getYaw() {
        return this.field_70177_z;
    }

    @Override
    public float getPitch() {
        return this.field_70125_A;
    }

    public void func_70071_h_() {
        super.func_70071_h_();
        this.field_70133_I = false;
    }

    @Override
    protected void func_184651_r() {
    }

    public void func_70030_z() {
        super.func_70030_z();
        if (((EntityMultipleLives)this.relay).onFinalLife() && this.relay.func_110143_aJ() <= 0.0f) {
            this.func_70609_aI();
        }
        if (!this.field_70170_p.field_72995_K && this.field_70173_aa % 20 == 0) {
            PacketSyncParts syncParts = new PacketSyncParts(this);
            LostInfinityPacketHandler.INSTANCE.sendToAllTracking((IMessage)syncParts, this.relay);
        } else {
            this.field_70737_aN = ((EntityMultipleLives)this.relay).field_70737_aN;
            this.field_70738_aO = ((EntityMultipleLives)this.relay).field_70738_aO;
        }
    }

    public boolean func_70097_a(DamageSource source, float amount) {
        if (this.func_180431_b(source)) {
            return false;
        }
        if (this.relay instanceof ILostMultiPart) {
            return ((ILostMultiPart)this.relay).attackEntityFromPart((LivingEntity)this, source, amount);
        }
        return this.relay.func_70097_a(source, amount);
    }

    @Override
    public boolean didDeathAction() {
        return ((EntityMultipleLives)this.relay).didDeathAction();
    }

    @Override
    public void deathActionComplete() {
        ((EntityMultipleLives)this.relay).deathActionComplete();
    }

    @Override
    public int getLivesCount() {
        return ((EntityMultipleLives)this.relay).getLivesCount();
    }

    @Override
    public void setLivesCount(int f) {
        ((EntityMultipleLives)this.relay).setLivesCount(f);
    }

    @Override
    public void takewayLife() {
        ((EntityMultipleLives)this.relay).takewayLife();
    }

    @Override
    public void takeawayNumLives(int lives) {
        ((EntityMultipleLives)this.relay).takeawayNumLives(lives);
    }

    @Override
    public void func_70014_b(CompoundTag tag) {
    }

    @Override
    public void func_70037_a(CompoundTag tag) {
    }

    protected boolean func_70692_ba() {
        return false;
    }

    @Override
    public boolean func_70814_o() {
        return ((EntityMultipleLives)this.relay).func_70814_o();
    }

    @Override
    public boolean func_70601_bi() {
        return ((EntityMultipleLives)this.relay).func_70601_bi();
    }

    @Override
    public boolean onFinalLife() {
        return ((EntityMultipleLives)this.relay).onFinalLife();
    }

    @Override
    protected int numberOfLives() {
        return ((EntityMultipleLives)this.relay).numberOfLives();
    }

    @Override
    public int remainingLives() {
        return ((EntityMultipleLives)this.relay).remainingLives();
    }
}

