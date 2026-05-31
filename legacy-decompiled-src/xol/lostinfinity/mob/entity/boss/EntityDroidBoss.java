/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.PathfinderMob
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.monster.Monster
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.EnumDifficulty
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.boss;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Difficulty;
import net.minecraft.world.level.Level;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.mob.ai.IBasicAI;
import xol.lostinfinity.mob.entity.boss.EntityUrogo;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityDroidBoss
extends Monster
implements IMaxAttack,
IBasicAI {
    private static final DataParameter<Byte> FORM = EntityDataManager.func_187226_a(EntityUrogo.class, (DataSerializer)DataSerializers.field_187191_a);

    public EntityDroidBoss(Level worldIn) {
        super(worldIn);
        this.func_70105_a(1.5f, 3.2f);
    }

    protected void func_184651_r() {
        this.initBasicTasks((PathfinderMob)this);
    }

    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a(FORM, (Object)0);
    }

    public byte getForm() {
        return (Byte)this.field_70180_af.func_187225_a(FORM);
    }

    public void setForm(byte f) {
        this.field_70180_af.func_187227_b(FORM, (Object)f);
    }

    public void func_70014_b(CompoundTag tag) {
        super.func_70014_b(tag);
        tag.func_74774_a("BossForm", this.getForm());
    }

    public void func_70037_a(CompoundTag tag) {
        super.func_70037_a(tag);
        this.setForm(tag.func_74771_c("BossForm"));
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.4);
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(1000.0);
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null) {
            IMaxAttack.dealMaxHealth((Entity)this, this.func_70638_az(), 20);
            return true;
        }
        return false;
    }

    protected SoundEvent func_184615_bR() {
        return SoundEvents.field_187599_cE;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundEvents.field_187602_cF;
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

    public void func_70645_a(DamageSource cause) {
        int droidsleft;
        if (this.getForm() == 0) {
            if (!this.field_70170_p.field_72995_K) {
                for (int k = 0; k < 12; ++k) {
                    EntityDroidBoss droid = new EntityDroidBoss(this.field_70170_p);
                    switch (k) {
                        case 0: {
                            droid.func_70107_b(10.0, 61.2, -79.0);
                            break;
                        }
                        case 1: {
                            droid.func_70107_b(10.0, 61.2, -87.0);
                            break;
                        }
                        case 2: {
                            droid.func_70107_b(10.0, 61.2, -94.0);
                            break;
                        }
                        case 3: {
                            droid.func_70107_b(10.0, 61.2, -102.0);
                            break;
                        }
                        case 4: {
                            droid.func_70107_b(41.0, 61.2, -79.0);
                            break;
                        }
                        case 5: {
                            droid.func_70107_b(41.0, 61.2, -87.0);
                            break;
                        }
                        case 6: {
                            droid.func_70107_b(41.0, 61.2, -94.0);
                            break;
                        }
                        case 7: {
                            droid.func_70107_b(41.0, 61.2, -102.0);
                            break;
                        }
                        case 8: {
                            droid.func_70107_b(34.0, 61.2, -79.0);
                            break;
                        }
                        case 9: {
                            droid.func_70107_b(34.0, 61.2, -102.0);
                            break;
                        }
                        case 10: {
                            droid.func_70107_b(17.0, 61.2, -79.0);
                            break;
                        }
                        case 11: {
                            droid.func_70107_b(17.0, 61.2, -102.0);
                        }
                    }
                    droid.setForm((byte)1);
                    this.field_70170_p.func_72838_d((Entity)droid);
                    if (this.func_70638_az() == null) continue;
                    droid.func_70624_b(this.func_70638_az());
                }
                AABB aabb = new AABB(new BlockPos(-3.0, 60.0, -145.0), new BlockPos(52.0, 85.0, -40.0));
                for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, aabb)) {
                    near_pl.func_145747_a((Component)new Component((Object)((Object)TextFmt.Red) + "Familiar Voice: You didn't really think this would be that easy?"));
                }
            }
        } else if (!this.field_70170_p.field_72995_K && (droidsleft = this.field_70170_p.func_72907_a(EntityDroidBoss.class)) <= 1) {
            EntityUrogo urogo = new EntityUrogo(this.field_70170_p);
            urogo.func_70107_b(25.5, 62.2, -90.0);
            urogo.setForm((byte)1);
            this.field_70170_p.func_72838_d((Entity)urogo);
            AABB aabb = new AABB(new BlockPos(-3.0, 60.0, -145.0), new BlockPos(52.0, 85.0, -40.0));
            for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, aabb)) {
                near_pl.func_145747_a((Component)new Component((Object)((Object)TextFmt.Gold) + "Urogo: Enough of this! Just surrender."));
            }
        }
        super.func_70645_a(cause);
    }
}

