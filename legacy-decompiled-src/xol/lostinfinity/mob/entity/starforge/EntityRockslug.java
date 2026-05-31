/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.PathfinderMob
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.monster.Monster
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.EnumDifficulty
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.starforge;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.phys.Vec3;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Difficulty;
import net.minecraft.world.level.Level;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.ai.IBasicAI;
import xol.lostinfinity.projectile.entity.EntityCellularRock;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.load.LootTableRegistry;

public class EntityRockslug
extends Monster
implements IMaxAttack,
IBasicAI {
    private float chargerDist = 0.0f;
    private int feedLevel = 0;
    private static final DataParameter<Integer> ATTACK_TIME = EntityDataManager.func_187226_a(EntityRockslug.class, (DataSerializer)DataSerializers.field_187192_b);

    public EntityRockslug(Level worldIn) {
        super(worldIn);
        this.func_70105_a(1.85f, 3.0f);
    }

    protected void func_184651_r() {
        this.initBasicTasks((PathfinderMob)this);
    }

    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a(ATTACK_TIME, (Object)0);
    }

    public int getAttackTime() {
        return (Integer)this.field_70180_af.func_187225_a(ATTACK_TIME);
    }

    public void setAttackTime(int f) {
        this.field_70180_af.func_187227_b(ATTACK_TIME, (Object)f);
    }

    public float getChargerOffset() {
        return this.chargerDist;
    }

    public void func_70014_b(CompoundTag tag) {
        super.func_70014_b(tag);
        tag.func_74768_a("FeedLevel", this.feedLevel);
    }

    public void func_70037_a(CompoundTag tag) {
        super.func_70037_a(tag);
        this.feedLevel = tag.func_74762_e("FeedLevel");
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null) {
            IMaxAttack.dealMaxHealth((Entity)this, this.func_70638_az(), 3);
            return true;
        }
        return false;
    }

    public void func_70636_d() {
        super.func_70636_d();
        if (!this.field_70170_p.field_72995_K) {
            int time = this.getAttackTime();
            if (time > 0) {
                if (this.field_70173_aa > time + 80) {
                    this.setAttackTime(0);
                    this.fireRock();
                }
            } else if (this.field_70173_aa % 200 == 0 && this.feedLevel > 0) {
                this.setAttackTime(this.field_70173_aa);
                --this.feedLevel;
            }
        } else if (this.getAttackTime() > 0) {
            this.chargerDist += 0.005f;
        } else if (this.chargerDist > 0.0f) {
            this.chargerDist -= 0.1f;
            if (this.chargerDist < 0.0f) {
                this.chargerDist = 0.0f;
            }
        }
    }

    private void fireRock() {
        EntityCellularRock shot = new EntityCellularRock(this.field_70170_p);
        shot.setThrower((LivingEntity)this);
        shot.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
        Vec3 vec = this.func_70040_Z();
        shot.func_70186_c(vec.field_72450_a, vec.field_72448_b, vec.field_72449_c, 1.0f, 0.0f);
        this.field_70170_p.func_72838_d((Entity)shot);
        this.func_184185_a(SoundInit.ROCKSLUG_HURL, 1.0f, 0.8f + 0.4f * this.field_70146_Z.nextFloat());
    }

    public boolean func_184645_a(Player player, InteractionHand hand) {
        ItemStack itemstack = player.func_184586_b(hand);
        if (itemstack.func_77973_b() == ItemInit.rockfeed) {
            if (!this.field_70170_p.field_72995_K) {
                ++this.feedLevel;
                player.func_145747_a((Component)new Component((Object)((Object)TextFmt.Aqua) + "The rockslug gulps down the pebbles. It has " + this.feedLevel + " shots remaining."));
            }
            itemstack.func_190918_g(1);
        }
        return true;
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(1000.0);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.25);
        this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a(1.0);
    }

    protected SoundEvent func_184615_bR() {
        return SoundInit.ROCKSLUG_DEATH;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return SoundInit.ROCKSLUG_HURT;
    }

    protected SoundEvent func_184639_G() {
        return SoundInit.ROCKSLUG_AMBIENT;
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

    protected ResourceLocation func_184647_J() {
        return LootTableRegistry.ENTITIES_ROCKSLUG;
    }
}

