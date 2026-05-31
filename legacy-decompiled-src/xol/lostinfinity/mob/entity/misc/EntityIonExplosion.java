/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.entity.player.ServerPlayer
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.util.SoundSource
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.misc;

import java.util.UUID;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.base.EntityImmaterial;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityIonExplosion
extends EntityImmaterial
implements IMaxAttack {
    private UUID creator_UUID;
    private boolean hasExploded = false;

    public EntityIonExplosion(Level worldIn) {
        super(worldIn);
        this.func_70105_a(0.001f, 0.001f);
        this.func_184224_h(true);
        this.func_82142_c(true);
        this.func_189654_d(true);
    }

    public void func_70014_b(CompoundTag tag) {
        super.func_70014_b(tag);
        tag.func_186854_a("CreatorUUID", this.creator_UUID);
    }

    public void func_70037_a(CompoundTag tag) {
        super.func_70037_a(tag);
        this.creator_UUID = tag.func_186857_a("CreatorUUID");
    }

    public void setCreator(UUID uuid) {
        this.creator_UUID = uuid;
    }

    @Override
    public void func_70636_d() {
        super.func_70636_d();
        if (this.field_70170_p.field_72995_K) {
            double radius = 5 + this.field_70173_aa;
            float angle = 0.0f;
            while ((double)angle <= Math.PI * 2) {
                double velocity_x = radius * Math.cos(angle);
                double velocity_z = radius * Math.sin(angle);
                this.field_70170_p.func_175682_a(ParticleInit.ION_BLAST, true, this.field_70165_t + velocity_x, this.field_70163_u + 3.0, this.field_70161_v + velocity_z, 0.0, 0.0, 0.0, new int[0]);
                this.field_70170_p.func_175682_a(ParticleInit.NUCLEAR_BLAST, true, this.field_70165_t + velocity_x / 2.0, this.field_70163_u + 6.0, this.field_70161_v + velocity_z / 2.0, 0.0, 0.0, 0.0, new int[0]);
                angle = (float)((double)angle + 0.39269908169872414);
            }
        }
        if (!this.field_70170_p.field_72995_K) {
            if (!this.hasExploded && this.field_70173_aa >= 1 && this.creator_UUID != null) {
                this.explosion();
            }
            if (this.field_70173_aa >= 20) {
                this.func_70106_y();
            }
        }
    }

    private void explosion() {
        this.hasExploded = true;
        EntityIonExplosion attacker = this;
        ServerPlayer ownerPlayer = this.field_70170_p.func_73046_m().func_184103_al().func_177451_a(this.creator_UUID);
        if (ownerPlayer != null) {
            attacker = ownerPlayer;
        }
        for (LivingEntity target : this.field_70170_p.func_72872_a(LivingEntity.class, this.func_174813_aQ().func_72314_b(24.0, 24.0, 24.0))) {
            if (target.func_110124_au().equals(this.creator_UUID) || target.func_110124_au().equals(this.func_110124_au())) continue;
            IMaxAttack.dealMaxHealth((Entity)attacker, target, 1, 2.0f);
        }
        for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.func_174813_aQ().func_72314_b(70.0, 70.0, 70.0))) {
            this.field_70170_p.func_184133_a(null, near_pl.func_180425_c(), SoundInit.GENERIC_EXPLOSION, SoundSource.MASTER, 1.5f, 0.75f + this.field_70146_Z.nextFloat() * 0.5f);
        }
    }
}

