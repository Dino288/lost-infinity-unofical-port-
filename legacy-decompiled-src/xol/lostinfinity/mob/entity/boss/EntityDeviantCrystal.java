/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.monster.Monster
 *  net.minecraft.entity.player.Player
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.EnumDifficulty
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.boss;

import net.minecraft.world.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.deviant.EntityDeviantBear;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityDeviantCrystal
extends Monster
implements IMaxAttack {
    private boolean superMutated = false;

    public EntityDeviantCrystal(Level worldIn) {
        super(worldIn);
        this.func_70105_a(4.0f, 4.25f);
    }

    protected void func_184651_r() {
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.0);
        this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(500.0);
    }

    public void func_70014_b(CompoundTag tag) {
        super.func_70014_b(tag);
        tag.func_74757_a("SpawnForm", this.superMutated);
    }

    public void func_70037_a(CompoundTag tag) {
        super.func_70037_a(tag);
        this.setSuperMutated(tag.func_74767_n("SpawnForm"));
    }

    public void setSuperMutated(boolean b) {
        this.superMutated = b;
    }

    private AABB getArenaAABB() {
        return new AABB(new BlockPos(-3.0, 60.0, -145.0), new BlockPos(52.0, 85.0, -40.0));
    }

    public void func_70636_d() {
        super.func_70636_d();
        this.field_70143_R = -1.0f;
        if ((this.field_70173_aa + 50) % 100 == 0 && !this.field_70170_p.field_72995_K) {
            boolean found_pl = false;
            for (Object near_pl : this.field_70170_p.func_72872_a(Player.class, this.getArenaAABB())) {
                found_pl = true;
            }
            if (found_pl) {
                this.func_184185_a(SoundInit.DEVIATION, 2.0f, 0.5f + this.field_70146_Z.nextFloat());
                int count = 0;
                for (EntityDeviantBear creature_count : this.field_70170_p.func_72872_a(EntityDeviantBear.class, this.getArenaAABB())) {
                    ++count;
                }
                if (count < 5) {
                    EntityDeviantBear spawnEntity = new EntityDeviantBear(this.field_70170_p);
                    spawnEntity.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
                    if (this.superMutated) {
                        spawnEntity.setMutation(1);
                    }
                    this.field_70170_p.func_72838_d((Entity)spawnEntity);
                }
            } else {
                this.func_70106_y();
            }
        }
    }

    protected SoundEvent func_184615_bR() {
        return null;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return null;
    }

    protected SoundEvent func_184639_G() {
        return null;
    }

    protected boolean func_70692_ba() {
        return false;
    }

    public boolean func_70814_o() {
        return true;
    }

    public int func_70641_bl() {
        return 1;
    }

    public boolean func_70601_bi() {
        return this.field_70170_p.func_175659_aa() != EnumDifficulty.PEACEFUL;
    }
}

