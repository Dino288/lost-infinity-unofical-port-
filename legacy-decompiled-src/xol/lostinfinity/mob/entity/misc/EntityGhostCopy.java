/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Optional
 *  net.minecraft.client.entity.AbstractClientPlayer
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.math.Mth
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.mob.entity.misc;

import com.google.common.base.Optional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.mob.entity.base.EntityImmaterial;

public class EntityGhostCopy
extends EntityImmaterial {
    protected static final DataParameter<Optional<UUID>> COPIED_ID = EntityDataManager.func_187226_a(EntityGhostCopy.class, (DataSerializer)DataSerializers.field_187203_m);
    private float ghostScale = 1.0f;
    private float ghostAlpha = 0.9f;
    private float ghostColor;
    private List<Float> ghostAngles = new ArrayList<Float>();
    private List<Integer> movementAdjustments = new ArrayList<Integer>();

    public EntityGhostCopy(Level worldIn) {
        super(worldIn);
        this.func_70105_a(0.1f, 0.1f);
        this.func_184224_h(true);
        this.ghostScale = 0.5f + this.field_70146_Z.nextFloat();
        for (int i = 0; i < 9; ++i) {
            this.ghostAngles.add(Float.valueOf(this.field_70146_Z.nextFloat() - 0.5f));
            this.movementAdjustments.add(-2 + this.field_70146_Z.nextInt(5));
        }
        this.ghostColor = 0.25f + 0.5f * this.field_70146_Z.nextFloat();
    }

    public float getGhostScale() {
        return this.ghostScale;
    }

    public float getGhostAngle(int index) {
        return this.ghostAngles.get(index).floatValue();
    }

    public int getMoveAdjustment(int index) {
        return this.movementAdjustments.get(index);
    }

    public float getGhostAlpha() {
        return this.ghostAlpha;
    }

    public float getGhostColor() {
        return this.ghostColor;
    }

    @SideOnly(value=Side.CLIENT)
    public ResourceLocation getSkinForMyCopy() {
        Player player = this.getCopiedPlayer();
        if (player != null) {
            AbstractClientPlayer abPlayer = (AbstractClientPlayer)player;
            return abPlayer.func_110306_p();
        }
        return null;
    }

    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a(COPIED_ID, (Object)Optional.absent());
    }

    public void setCopiedPlay(Player player) {
        this.field_70180_af.func_187227_b(COPIED_ID, (Object)Optional.fromNullable((Object)player.func_110124_au()));
    }

    private Player getCopiedPlayer() {
        if (((Optional)this.field_70180_af.func_187225_a(COPIED_ID)).orNull() != null) {
            return this.field_70170_p.func_152378_a((UUID)((Optional)this.field_70180_af.func_187225_a(COPIED_ID)).get());
        }
        return null;
    }

    @Override
    public void func_70636_d() {
        super.func_70636_d();
        if (!this.field_70170_p.field_72995_K) {
            if (this.field_70173_aa >= 12) {
                this.func_70106_y();
            }
        } else if (this.field_70173_aa % 3 == 2) {
            this.ghostAlpha = this.ghostAlpha != 0.0f ? 0.0f : 0.2f + this.field_70146_Z.nextFloat() * (0.6f - (float)Mth.func_76141_d((float)(this.field_70173_aa / 2)) * 0.1f);
        }
    }

    protected void func_82167_n(Entity entityIn) {
    }
}

