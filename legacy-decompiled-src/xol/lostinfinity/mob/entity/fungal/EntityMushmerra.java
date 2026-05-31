/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.PathfinderMob
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.ai.EntityAIBase
 *  net.minecraft.entity.ai.EntityAIWanderAvoidWater
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.fungal;

import java.util.Random;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import xol.lostinfinity.mob.entity.base.EntityMultipleLives;
import xol.lostinfinity.mob.entity.fungal.EntityMushmerraClone;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.load.LootTableRegistry;

public class EntityMushmerra
extends EntityMultipleLives {
    private static final int SPAWN_FREQUENCY_TICKS = 100;

    public EntityMushmerra(Level worldIn) {
        super(worldIn);
        this.func_70105_a(1.9f, 2.2f);
    }

    public void func_70071_h_() {
        BlockPos safeSpawn;
        super.func_70071_h_();
        if (this.field_70170_p.field_72995_K) {
            return;
        }
        if (this.field_70173_aa > 120 && this.field_70173_aa % 100 == 0 && new Random().nextBoolean() && (safeSpawn = this.getSafeLocationNearby()) != null) {
            EntityMushmerraClone clone = new EntityMushmerraClone(this.field_70170_p);
            clone.func_70107_b(safeSpawn.func_177958_n(), safeSpawn.func_177956_o(), safeSpawn.func_177952_p());
            this.field_70170_p.func_72838_d((Entity)clone);
        }
    }

    @Override
    protected int numberOfLives() {
        return 14;
    }

    @Override
    protected void func_184651_r() {
        super.func_184651_r();
        this.field_70714_bg.func_75776_a(0, (EntityAIBase)new EntityAIWanderAvoidWater((PathfinderMob)this, 1.0));
    }

    protected void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a((double)0.23f);
    }

    private BlockPos getSafeLocationNearby() {
        BlockPos pos = this.func_180425_c();
        Vec3 vec = new Vec3((double)pos.func_177958_n(), (double)pos.func_177956_o(), (double)pos.func_177952_p());
        for (int i = 0; i < 30; ++i) {
            BlockPos newPos = new BlockPos(vec = vec.func_72441_c((double)(this.field_70170_p.field_73012_v.nextInt(5) - 2), (double)(this.field_70170_p.field_73012_v.nextInt(5) - 2), (double)(this.field_70170_p.field_73012_v.nextInt(5) - 2)));
            if (!this.field_70170_p.func_175623_d(newPos) || !this.field_70170_p.func_175623_d(newPos.func_177974_f()) || !this.field_70170_p.func_175623_d(newPos.func_177976_e()) || !this.field_70170_p.func_175623_d(newPos.func_177978_c()) || !this.field_70170_p.func_175623_d(newPos.func_177968_d()) || !this.field_70170_p.func_175623_d(newPos.func_177984_a()) || !this.field_70170_p.func_175623_d(newPos.func_177984_a().func_177974_f()) || !this.field_70170_p.func_175623_d(newPos.func_177984_a().func_177976_e()) || !this.field_70170_p.func_175623_d(newPos.func_177984_a().func_177978_c()) || !this.field_70170_p.func_175623_d(newPos.func_177984_a().func_177968_d()) || !this.field_70170_p.func_175623_d(newPos.func_177984_a().func_177984_a()) || !this.field_70170_p.func_175623_d(newPos.func_177984_a().func_177984_a().func_177974_f()) || !this.field_70170_p.func_175623_d(newPos.func_177984_a().func_177984_a().func_177976_e()) || !this.field_70170_p.func_175623_d(newPos.func_177984_a().func_177984_a().func_177978_c()) || !this.field_70170_p.func_175623_d(newPos.func_177984_a().func_177984_a().func_177968_d()) || this.field_70170_p.func_175623_d(newPos.func_177977_b()) || this.field_70170_p.func_180495_p(newPos.func_177977_b()).func_185904_a().func_76224_d()) continue;
            return new BlockPos(vec);
        }
        return null;
    }

    public boolean func_70652_k(Entity entity) {
        super.func_70652_k(entity);
        if (this.func_70638_az() != null) {
            IMaxAttack.dealTrueDamage((Entity)this, this.func_70638_az(), this.func_70638_az().func_110138_aP() * 0.7f);
            return true;
        }
        return false;
    }

    protected ResourceLocation func_184647_J() {
        return LootTableRegistry.ENTITIES_MUSHMERRA;
    }
}

