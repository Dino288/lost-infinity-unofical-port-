/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.PathfinderMob
 *  net.minecraft.entity.IMobData
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.ai.EntityAIAttackMelee
 *  net.minecraft.entity.ai.EntityAIBase
 *  net.minecraft.entity.ai.EntityAINearestAttackableTarget
 *  net.minecraft.entity.player.Player
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.world.DifficultyInstance
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.fungal;

import javax.annotation.Nullable;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.entity.IMobData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.level.Level;
import xol.lostinfinity.mob.entity.base.EntityMultipleLives;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.load.LootTableRegistry;

public class EntityShroomite
extends EntityMultipleLives {
    private static final DataParameter<Boolean> BURROWED = EntityDataManager.func_187226_a(EntityShroomite.class, (DataSerializer)DataSerializers.field_187198_h);

    public EntityShroomite(Level worldIn) {
        super(worldIn);
        this.func_70105_a(0.8f, 1.5f);
    }

    @Nullable
    public IMobData func_180482_a(DifficultyInstance difficulty, @Nullable IMobData livingdata) {
        this.func_189654_d(true);
        for (int i = 0; i < 256; ++i) {
            if (!this.field_70170_p.func_180495_p(this.func_180425_c().func_177979_c(i)).func_185913_b()) continue;
            this.func_70107_b(this.func_180425_c().func_177958_n(), (double)(this.func_180425_c().func_177956_o() - i) + 0.25, this.func_180425_c().func_177952_p());
            break;
        }
        return super.func_180482_a(difficulty, livingdata);
    }

    @Override
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a(BURROWED, (Object)true);
    }

    @Override
    protected int numberOfLives() {
        return 8;
    }

    @Override
    protected void func_184651_r() {
        super.func_184651_r();
        this.field_70714_bg.func_75776_a(1, (EntityAIBase)new EntityAIShroomiteBurrow(this));
        this.field_70714_bg.func_75776_a(2, (EntityAIBase)new EntityAIShroomiteUnburrow(this));
        this.field_70714_bg.func_75776_a(3, (EntityAIBase)new EntityAIAttackMelee((PathfinderMob)this, 1.0, false));
        this.field_70715_bh.func_75776_a(2, (EntityAIBase)new EntityAINearestAttackableTarget((PathfinderMob)this, Player.class, false));
    }

    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.3300000041723251);
    }

    public boolean isBurrowed() {
        return (Boolean)this.field_70180_af.func_187225_a(BURROWED);
    }

    public void setBurrowed(boolean burrowed) {
        this.field_70180_af.func_187227_b(BURROWED, (Object)burrowed);
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null) {
            IMaxAttack.dealTrueDamage((Entity)this, this.func_70638_az(), this.func_70638_az().func_110138_aP() * 0.5f);
            return true;
        }
        return false;
    }

    protected ResourceLocation func_184647_J() {
        return LootTableRegistry.ENTITIES_SHROOMITE;
    }

    private static class EntityAIShroomiteUnburrow
    extends EntityAIBase {
        private final EntityShroomite shroomite;

        public EntityAIShroomiteUnburrow(EntityShroomite shroomite) {
            this.shroomite = shroomite;
        }

        public boolean func_75250_a() {
            return this.shroomite.func_70638_az() != null && this.shroomite.func_70638_az().func_70032_d((Entity)this.shroomite) < 12.0f;
        }

        public boolean func_75253_b() {
            return this.shroomite.isBurrowed();
        }

        public void func_75246_d() {
            super.func_75246_d();
            if (this.shroomite.func_189652_ae()) {
                this.shroomite.func_189654_d(false);
                this.shroomite.field_70181_x += 0.65;
                this.shroomite.setBurrowed(false);
            }
        }
    }

    private static class EntityAIShroomiteBurrow
    extends EntityAIBase {
        private final EntityShroomite shroomite;

        public EntityAIShroomiteBurrow(EntityShroomite shroomite) {
            this.shroomite = shroomite;
        }

        public boolean func_75250_a() {
            return (this.shroomite.func_70638_az() == null || this.shroomite.func_70638_az().field_70128_L || this.shroomite.func_70638_az().func_70032_d((Entity)this.shroomite) > 30.0f) && !this.shroomite.isBurrowed();
        }

        public boolean func_75253_b() {
            return !this.shroomite.isBurrowed();
        }

        public void func_75246_d() {
            super.func_75246_d();
            if (this.shroomite.field_70181_x == -0.0784000015258789) {
                this.shroomite.func_189654_d(true);
                this.shroomite.func_70634_a(this.shroomite.field_70165_t, this.shroomite.field_70163_u - 0.25, this.shroomite.field_70161_v);
                this.shroomite.setBurrowed(true);
            }
        }
    }
}

