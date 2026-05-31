/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.PathfinderMob
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.EnumParticleTypes
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.DimensionType
 *  net.minecraft.world.EnumDifficulty
 *  net.minecraft.world.World
 *  net.minecraft.world.ServerLevel
 */
package xol.lostinfinity.mob.entity.base;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.DimensionType;
import net.minecraft.world.Difficulty;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.mob.ai.IBasicAI;
import xol.lostinfinity.mob.entity.base.EntityMultipleLives;
import xol.lostinfinity.mob.entity.deviant.prime.EntityAzross;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityDeviantMob
extends EntityMultipleLives
implements IMaxAttack,
IBasicAI {
    private static final DataParameter<Integer> MUTATION = EntityDataManager.func_187226_a(EntityDeviantMob.class, (DataSerializer)DataSerializers.field_187192_b);

    public EntityDeviantMob(Level worldIn) {
        super(worldIn);
    }

    @Override
    protected void func_184651_r() {
        this.initBasicTasks((PathfinderMob)this);
    }

    @Override
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a(MUTATION, (Object)0);
    }

    public int getMutation() {
        return (Integer)this.field_70180_af.func_187225_a(MUTATION);
    }

    public void setMutation(int f) {
        this.field_70180_af.func_187227_b(MUTATION, (Object)f);
    }

    public boolean atMaxMutation() {
        return this.getMutation() == 3;
    }

    public void increaseMutation() {
        this.setMutation(this.getMutation() + 1);
    }

    @Override
    public void func_70014_b(CompoundTag tag) {
        super.func_70014_b(tag);
        tag.func_74768_a("Mutation", this.getMutation());
    }

    @Override
    public void func_70037_a(CompoundTag tag) {
        super.func_70037_a(tag);
        this.setMutation(tag.func_74762_e("Mutation"));
    }

    @Override
    protected int numberOfLives() {
        return this.getMutation() == 0 ? 2 : 5;
    }

    @Override
    public boolean func_70814_o() {
        return true;
    }

    public int func_70641_bl() {
        return 1;
    }

    public boolean func_180427_aV() {
        return true;
    }

    @Override
    public boolean func_70601_bi() {
        return this.field_70170_p.func_175659_aa() != EnumDifficulty.PEACEFUL;
    }

    protected boolean func_70692_ba() {
        if (this.field_70170_p.field_73011_w.func_186058_p() == DimensionType.OVERWORLD) {
            int time = (int)(this.field_70170_p.func_72820_D() % 24000L);
            return time > 13000 && time < 18000;
        }
        return false;
    }

    public void updateSupermutationAI() {
    }

    public boolean func_184645_a(Player player, InteractionHand hand) {
        ItemStack itemstack = player.func_184586_b(hand);
        if (this.playerInput() != null && this.atMaxMutation() && itemstack.func_77973_b().equals(this.playerInput())) {
            this.func_184185_a(SoundEvents.field_187626_cN, 2.0f, 1.0f);
            if (!this.field_70170_p.field_72995_K) {
                this.func_145779_a(this.mutantOutput(), 1);
                this.setMutation(1);
                this.updateSupermutationAI();
            }
            itemstack.func_190918_g(1);
            return true;
        }
        return false;
    }

    @Override
    public void trueDeathAction() {
        if (!this.field_70170_p.field_72995_K && this.field_70146_Z.nextInt(20) == 10 && this.field_70170_p.field_73011_w.func_186058_p() == DimensionType.OVERWORLD) {
            EntityAzross azross = new EntityAzross(this.field_70170_p);
            azross.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
            this.field_70170_p.func_72838_d((Entity)azross);
            ((ServerLevel)this.field_70170_p).func_175739_a(EnumParticleTypes.DRAGON_BREATH, this.field_70165_t, this.field_70163_u + 1.0, this.field_70161_v, 10, (-0.5 + this.field_70146_Z.nextDouble()) * 3.0, 0.3, (-0.5 + this.field_70146_Z.nextDouble()) * 3.0, (double)0.15f, new int[0]);
            for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.func_174813_aQ().func_72314_b(25.0, 25.0, 25.0))) {
                near_pl.func_145747_a((Component)new Component((Object)((Object)TextFmt.Dark_Aqua) + "Prime Deviant Azross: Stop killing my kind!"));
            }
        }
    }

    protected Item playerInput() {
        return null;
    }

    protected Item mutantOutput() {
        return null;
    }

    protected ResourceLocation deviantDrop() {
        return null;
    }

    protected ResourceLocation superMutatedDrop() {
        return null;
    }

    protected ResourceLocation func_184647_J() {
        return this.atMaxMutation() ? this.superMutatedDrop() : this.deviantDrop();
    }
}

