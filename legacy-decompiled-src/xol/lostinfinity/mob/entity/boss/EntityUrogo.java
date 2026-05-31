/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.PathfinderMob
 *  net.minecraft.entity.Mob
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.ai.EntityAIAttackMelee
 *  net.minecraft.entity.ai.EntityAIBase
 *  net.minecraft.entity.ai.EntityAIHurtByTarget
 *  net.minecraft.entity.ai.EntityAILookIdle
 *  net.minecraft.entity.ai.EntityAIMoveThroughVillage
 *  net.minecraft.entity.ai.EntityAIMoveTowardsRestriction
 *  net.minecraft.entity.ai.EntityAINearestAttackableTarget
 *  net.minecraft.entity.ai.EntityAISwimming
 *  net.minecraft.entity.ai.EntityAIWanderAvoidWater
 *  net.minecraft.entity.ai.EntityAIWatchClosest
 *  net.minecraft.entity.monster.EntityIronGolem
 *  net.minecraft.entity.monster.Monster
 *  net.minecraft.entity.monster.EntityPigZombie
 *  net.minecraft.entity.passive.EntityVillager
 *  net.minecraft.entity.player.Player
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
import net.minecraft.world.entity.Mob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.world.entity.player.Player;
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
import xol.lostinfinity.init.DimensionInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.boss.EntityArenaEvent;
import xol.lostinfinity.stone.EntityInfinityStone;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityUrogo
extends Monster
implements IMaxAttack {
    private static final DataParameter<Byte> FORM = EntityDataManager.func_187226_a(EntityUrogo.class, (DataSerializer)DataSerializers.field_187191_a);

    public EntityUrogo(Level worldIn) {
        super(worldIn);
        this.func_70105_a(2.0f, 3.2f);
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

    protected void func_184651_r() {
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAISwimming((Mob)this));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAIAttackMelee((PathfinderMob)this, 1.0, true));
        this.field_70714_bg.func_75776_a(5, (EntityAIBase)new EntityAIMoveTowardsRestriction((PathfinderMob)this, 1.0));
        this.field_70714_bg.func_75776_a(7, (EntityAIBase)new EntityAIWanderAvoidWater((PathfinderMob)this, 1.0));
        this.field_70714_bg.func_75776_a(8, (EntityAIBase)new EntityAIWatchClosest((Mob)this, Player.class, 8.0f));
        this.field_70714_bg.func_75776_a(8, (EntityAIBase)new EntityAILookIdle((Mob)this));
        this.func_175456_n();
    }

    protected void func_175456_n() {
        this.field_70714_bg.func_75776_a(6, (EntityAIBase)new EntityAIMoveThroughVillage((PathfinderMob)this, 1.0, false));
        this.field_70715_bh.func_75776_a(1, (EntityAIBase)new EntityAIHurtByTarget((PathfinderMob)this, true, new Class[]{EntityPigZombie.class}));
        this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAINearestAttackableTarget((PathfinderMob)this, Player.class, true));
        this.field_70715_bh.func_75776_a(3, (EntityAIBase)new EntityAINearestAttackableTarget((PathfinderMob)this, EntityVillager.class, false));
        this.field_70715_bh.func_75776_a(3, (EntityAIBase)new EntityAINearestAttackableTarget((PathfinderMob)this, EntityIronGolem.class, true));
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.35);
        this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(5000.0);
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null) {
            IMaxAttack.dealMaxHealth((Entity)this, this.func_70638_az(), 14);
            this.func_70638_az().func_70024_g(this.field_70159_w * 7.5, this.field_70181_x * 0.5, this.field_70179_y * 7.0);
            return true;
        }
        return false;
    }

    public void func_70636_d() {
        super.func_70636_d();
        this.field_70143_R = -1.0f;
        if ((this.getForm() == 0 && this.field_70173_aa % 120 == 0 || this.getForm() == 1 && this.field_70173_aa % 50 == 0) && !this.field_70170_p.field_72995_K && this.func_70638_az() != null) {
            int pick = this.field_70146_Z.nextInt(3);
            switch (pick) {
                case 0: {
                    this.func_70634_a(this.func_70638_az().field_70165_t, this.func_70638_az().field_70163_u, this.func_70638_az().field_70161_v);
                    this.func_70652_k((Entity)this.func_70638_az());
                    this.func_70638_az().func_145747_a((Component)new Component((Object)((Object)TextFmt.Gold) + "Urogo: Surprise!"));
                    break;
                }
                case 1: {
                    this.func_70638_az().func_70634_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
                    this.func_70652_k((Entity)this.func_70638_az());
                    this.func_70638_az().func_145747_a((Component)new Component((Object)((Object)TextFmt.Gold) + "Urogo: You can't run."));
                    break;
                }
                case 2: {
                    this.func_70634_a(25.5, 62.2, -92.0);
                    this.func_70638_az().func_70634_a(25.5, 62.2, -88.0);
                    this.func_70638_az().func_145747_a((Component)new Component((Object)((Object)TextFmt.Gold) + "Urogo: Stay, and fight!"));
                }
            }
        }
    }

    public void func_70645_a(DamageSource cause) {
        if (this.field_70170_p.field_73011_w.func_186058_p() == DimensionInit.celestialVoid && !this.field_70170_p.field_72995_K) {
            switch (this.getForm()) {
                case 0: {
                    EntityArenaEvent event = new EntityArenaEvent(this.field_70170_p);
                    event.func_70107_b(25.5, 62.2, -90.0);
                    event.setEventType((byte)0);
                    this.field_70170_p.func_72838_d((Entity)event);
                    AABB aabb = new AABB(new BlockPos(-3.0, 60.0, -145.0), new BlockPos(52.0, 85.0, -40.0));
                    for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, aabb)) {
                        near_pl.func_145747_a((Component)new Component((Object)((Object)TextFmt.Dark_Red) + "Urogo: I'm not done with you yet."));
                    }
                    break;
                }
                case 1: {
                    EntityInfinityStone badlandsStone = new EntityInfinityStone(this.field_70170_p);
                    badlandsStone.setStoneNum((byte)2);
                    badlandsStone.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
                    this.field_70170_p.func_72838_d((Entity)badlandsStone);
                    this.func_145779_a(ItemInit.arenaCard, 1);
                }
            }
        }
        super.func_70645_a(cause);
    }

    protected SoundEvent func_184615_bR() {
        return SoundInit.UROGO_DEATH;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundInit.UROGO_HIT;
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

