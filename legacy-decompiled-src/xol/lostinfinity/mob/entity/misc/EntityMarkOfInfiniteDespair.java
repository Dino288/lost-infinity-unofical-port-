/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Optional
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.misc;

import com.google.common.base.Optional;
import java.util.UUID;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;

public class EntityMarkOfInfiniteDespair
extends Entity {
    protected static final DataParameter<Optional<UUID>> OWNER_ID = EntityDataManager.func_187226_a(EntityMarkOfInfiniteDespair.class, (DataSerializer)DataSerializers.field_187203_m);
    protected static final DataParameter<Optional<UUID>> TARGET_PLAYER_ID = EntityDataManager.func_187226_a(EntityMarkOfInfiniteDespair.class, (DataSerializer)DataSerializers.field_187203_m);
    private static final int pitRadius = 2;
    private int timer = 180;
    private double speed = -1.0;

    public EntityMarkOfInfiniteDespair(Level worldIn) {
        super(worldIn);
        this.func_184224_h(true);
    }

    public Player getOwner() {
        if (((Optional)this.field_70180_af.func_187225_a(OWNER_ID)).orNull() != null) {
            return this.field_70170_p.func_152378_a((UUID)((Optional)this.field_70180_af.func_187225_a(OWNER_ID)).get());
        }
        return null;
    }

    public void setOwner(Player player) {
        this.field_70180_af.func_187227_b(OWNER_ID, (Object)Optional.fromNullable((Object)player.func_110124_au()));
    }

    public Player getPlayerTarget() {
        if (((Optional)this.field_70180_af.func_187225_a(TARGET_PLAYER_ID)).orNull() != null) {
            return this.field_70170_p.func_152378_a((UUID)((Optional)this.field_70180_af.func_187225_a(TARGET_PLAYER_ID)).get());
        }
        return null;
    }

    public void setPlayerTarget(Player player) {
        this.field_70180_af.func_187227_b(TARGET_PLAYER_ID, (Object)Optional.fromNullable((Object)player.func_110124_au()));
    }

    public void func_70071_h_() {
        super.func_70071_h_();
        this.field_70143_R = -1.0f;
        Player owner = this.getOwner();
        Player target = this.getPlayerTarget();
        if (!this.field_70170_p.field_72995_K) {
            if (owner == null || owner.field_70128_L || target == null || target.field_70128_L) {
                this.func_70106_y();
            } else {
                if (this.timer % 10 == 0) {
                    this.func_184185_a(SoundInit.ELECTRIC_WOOSH, 2.0f, 0.8f + this.field_70146_Z.nextFloat() * 0.4f);
                }
                for (int i = -2; i <= 2; ++i) {
                    for (int k = -2; k <= 2; ++k) {
                        for (int j = -8; j <= 0; ++j) {
                            BlockPos clear;
                            if (i * i + k * k > 4 || this.field_70170_p.func_175623_d(clear = target.func_180425_c().func_177982_a(i, j, k))) continue;
                            this.field_70170_p.func_175698_g(clear);
                        }
                    }
                }
                target.func_189654_d(true);
                target.field_70181_x = this.speed;
                target.field_70133_I = true;
                this.func_70634_a(target.field_70165_t, target.field_70163_u + 1.5, target.field_70161_v);
                --this.timer;
                if (this.timer == 0 || target.field_70163_u < 2.0) {
                    target.func_70606_j(0.0f);
                    target.func_189654_d(false);
                    owner.func_191521_c(new ItemStack(ItemInit.voidAlteredSpine, 1));
                    this.func_70106_y();
                }
            }
        }
    }

    protected void func_70088_a() {
        this.field_70180_af.func_187214_a(OWNER_ID, (Object)Optional.absent());
        this.field_70180_af.func_187214_a(TARGET_PLAYER_ID, (Object)Optional.absent());
    }

    protected void func_70037_a(CompoundTag compound) {
    }

    protected void func_70014_b(CompoundTag compound) {
    }
}

