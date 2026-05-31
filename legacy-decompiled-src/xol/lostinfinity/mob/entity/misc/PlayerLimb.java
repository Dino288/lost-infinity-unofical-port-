/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Optional
 *  net.minecraft.client.entity.AbstractClientPlayer
 *  net.minecraft.entity.player.Player
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.util.EnumParticleTypes
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.mob.entity.misc;

import com.google.common.base.Optional;
import java.util.UUID;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.mob.entity.base.EntityImmaterial;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class PlayerLimb
extends EntityImmaterial {
    private static final DataParameter<Integer> LIMB = EntityDataManager.func_187226_a(PlayerLimb.class, (DataSerializer)DataSerializers.field_187192_b);
    private static final DataParameter<Optional<UUID>> OWNER = EntityDataManager.func_187226_a(PlayerLimb.class, (DataSerializer)DataSerializers.field_187203_m);

    public PlayerLimb(Level worldIn) {
        super(worldIn);
        this.field_70145_X = true;
    }

    public PlayerLimb(Level worldIn, UUID targetUUID) {
        super(worldIn);
        this.field_70145_X = true;
        this.setSkinOwner(targetUUID);
    }

    protected void func_70088_a() {
        super.func_70088_a();
        this.func_184212_Q().func_187214_a(LIMB, (Object)this.field_70170_p.field_73012_v.nextInt(4));
        this.func_184212_Q().func_187214_a(OWNER, (Object)Optional.absent());
    }

    @Override
    public void func_70636_d() {
        super.func_70636_d();
        if (this.field_70173_aa % 5 == 0) {
            CustomParticleConfig config = new CustomParticleConfig();
            config.createInstance().setSpread(0.5, 0.5, 0.5).setCount(3).setParticle(EnumParticleTypes.REDSTONE);
            if (this.getLimb() == 0 || this.getLimb() == 1) {
                IParticleSpawner.spawnParticle(this.field_70170_p, config, this.field_70165_t, this.field_70163_u + 1.0, this.field_70161_v);
            } else {
                IParticleSpawner.spawnParticle(this.field_70170_p, config, this.field_70165_t, this.field_70163_u, this.field_70161_v);
            }
        }
        this.field_70181_x -= 0.03;
        if (this.field_70173_aa > 40) {
            this.func_70106_y();
        }
    }

    public int getLimb() {
        return (Integer)this.func_184212_Q().func_187225_a(LIMB);
    }

    public void setSkinOwner(UUID uuid) {
        this.func_184212_Q().func_187227_b(OWNER, (Object)Optional.of((Object)uuid));
    }

    @SideOnly(value=Side.CLIENT)
    public ResourceLocation getSkin() {
        if (((Optional)this.func_184212_Q().func_187225_a(OWNER)).isPresent()) {
            Player player = this.field_70170_p.func_152378_a((UUID)((Optional)this.func_184212_Q().func_187225_a(OWNER)).get());
            AbstractClientPlayer clientPlayer = (AbstractClientPlayer)player;
            return clientPlayer.func_110306_p();
        }
        return new ResourceLocation("textures/entity/alex.png");
    }
}

