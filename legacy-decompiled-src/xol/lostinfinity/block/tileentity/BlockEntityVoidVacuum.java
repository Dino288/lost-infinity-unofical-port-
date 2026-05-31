/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.item.ItemEntity
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.NetworkManager
 *  net.minecraft.network.play.server.SPacketUpdateBlockEntity
 *  net.minecraft.tileentity.BlockEntity
 *  net.minecraft.util.ITickable
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.Vec3
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.block.tileentity;

import java.util.List;
import java.util.UUID;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.util.ITickable;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.util.damagesource.DeathMessage;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class BlockEntityVoidVacuum
extends BlockEntity
implements ITickable {
    boolean active = false;
    LivingEntity target = null;
    boolean hasPulled = false;

    public void resetPulled() {
        this.hasPulled = false;
    }

    public void setTarget(LivingEntity target) {
        this.target = target;
    }

    public LivingEntity getTarget() {
        return this.target;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean getActive() {
        return this.active;
    }

    public boolean shouldRenderInPass(int pass) {
        return true;
    }

    public AABB getRenderBoundingBox() {
        AABB bb = INFINITE_EXTENT_AABB;
        return bb;
    }

    @SideOnly(value=Side.CLIENT)
    public double func_145833_n() {
        return 65536.0;
    }

    public void func_73660_a() {
        if (!this.field_145850_b.field_72995_K) {
            this.field_145850_b.func_184138_a(this.func_174877_v(), this.field_145850_b.func_180495_p(this.func_174877_v()), this.field_145850_b.func_180495_p(this.func_174877_v()), 2);
            if (this.active && !this.hasPulled && this.target != null) {
                Vec3 vecPos = new Vec3((double)this.func_174877_v().func_177958_n(), (double)this.func_174877_v().func_177956_o(), (double)this.func_174877_v().func_177952_p());
                double dist = this.target.func_174791_d().func_72438_d(vecPos);
                if (dist < 1.5) {
                    this.hasPulled = true;
                    this.active = false;
                    this.target.func_70606_j(0.0f);
                    DeathMessage.broadcastDeathMessage(this.target.func_184102_h(), (Object)((Object)TextFmt.Red) + this.target.func_70005_c_() + " was sucked into the void.");
                    this.target = null;
                    ItemEntity bone = new ItemEntity(this.field_145850_b, (double)this.field_174879_c.func_177958_n(), (double)(this.field_174879_c.func_177956_o() + 1), (double)this.field_174879_c.func_177952_p(), new ItemStack(ItemInit.voidsplitBone));
                    bone.field_70159_w = 0.0;
                    bone.field_70181_x = 0.0;
                    bone.field_70179_y = 0.0;
                    this.field_145850_b.func_72838_d((Entity)bone);
                    CustomParticleConfig config1 = new CustomParticleConfig();
                    config1.createInstance().setParticle(ParticleInit.CORRUPTION_MAGIC).setSpread(4.0, 1.0, 4.0).setCount(10).setIgnoreRange(true);
                    IParticleSpawner.spawnParticle(this.field_145850_b, config1, (double)this.field_174879_c.func_177958_n(), (double)(this.field_174879_c.func_177956_o() + 1), (double)this.field_174879_c.func_177952_p());
                    this.field_145850_b.func_184133_a(null, this.field_174879_c, SoundInit.ELECTRIC_WOOSH, SoundSource.BLOCKS, 1.5f, 1.0f);
                } else {
                    Vec3 pullDir = vecPos.func_178788_d(this.target.func_174791_d());
                    pullDir = pullDir.func_72432_b();
                    this.target.func_70024_g(pullDir.field_72450_a / 5.0, pullDir.field_72448_b / 5.0 + (double)0.1f, pullDir.field_72449_c / 5.0);
                    this.target.field_70133_I = true;
                }
            }
        }
    }

    public CompoundTag func_189517_E_() {
        CompoundTag compound = super.func_189517_E_();
        if (this.target != null) {
            compound.func_186854_a("PlayerID", this.target.func_110124_au());
        } else {
            compound.func_82580_o("PlayerID");
        }
        return compound;
    }

    public void handleUpdateTag(CompoundTag tag) {
        if (tag.func_186855_b("PlayerID") && tag.func_186857_a("PlayerID") != null) {
            this.target = this.entityByID(tag.func_186857_a("PlayerID"));
            if (this.target != null && !this.target.field_70128_L) {
                this.active = true;
            } else {
                System.out.println("failed");
                this.active = false;
            }
        } else {
            this.active = false;
        }
        super.handleUpdateTag(tag);
    }

    public SPacketUpdateBlockEntity func_189518_D_() {
        return new SPacketUpdateBlockEntity(this.func_174877_v(), 1, this.func_189517_E_());
    }

    public void onDataPacket(NetworkManager net, SPacketUpdateBlockEntity pkt) {
        this.handleUpdateTag(pkt.func_148857_g());
    }

    private LivingEntity entityByID(UUID id) {
        List entityList = this.field_145850_b.func_72910_y();
        for (Entity e : entityList) {
            if (!e.func_110124_au().equals(id) || !(e instanceof LivingEntity)) continue;
            return (LivingEntity)e;
        }
        return null;
    }
}

