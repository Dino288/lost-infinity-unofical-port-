/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.BlockRotatedPillar
 *  net.minecraft.block.properties.Property
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.Direction$Axis
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.HitResult
 *  net.minecraft.util.math.HitResult$Type
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.world.World
 */
package xol.lostinfinity.projectile.entity;

import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.potion.PotionEffect;
import net.minecraft.core.Direction;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.HitResult;
import net.minecraft.core.Vec3i;
import net.minecraft.world.level.Level;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.PotionInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.projectile.entity.EntityBaseThrowable;
import xol.lostinfinity.util.data.CustomParticleConfig;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class EntityDryadsGripAttack
extends EntityBaseThrowable {
    private static final int range = 15;
    private int logNum = 0;
    private int leafNum = 0;
    private BlockPos treePos = null;
    private boolean foundPos = false;
    private static final Vec3i[] logs = new Vec3i[]{new Vec3i(0, 1, 0), new Vec3i(0, 2, 0), new Vec3i(0, 3, 0), new Vec3i(0, 4, 0), new Vec3i(0, 5, 0)};
    private static final Vec3i[] leaves = new Vec3i[]{new Vec3i(-1, 4, 0), new Vec3i(0, 4, -1), new Vec3i(0, 4, 1), new Vec3i(1, 4, 1), new Vec3i(1, 4, 0), new Vec3i(1, 4, -1), new Vec3i(1, 4, -2), new Vec3i(1, 4, 2), new Vec3i(-1, 4, -2), new Vec3i(-1, 4, 2), new Vec3i(-1, 4, 1), new Vec3i(-1, 4, -1), new Vec3i(-2, 4, 1), new Vec3i(-2, 4, 0), new Vec3i(0, 4, 2), new Vec3i(0, 4, -2), new Vec3i(-2, 4, -1), new Vec3i(-2, 4, -2), new Vec3i(-2, 4, 2), new Vec3i(2, 4, 0), new Vec3i(2, 4, 1), new Vec3i(2, 4, -1), new Vec3i(2, 4, -2), new Vec3i(2, 4, 2), new Vec3i(0, 5, 1), new Vec3i(0, 5, -1), new Vec3i(1, 5, 0), new Vec3i(-1, 5, 0), new Vec3i(1, 5, 1), new Vec3i(-1, 5, 1), new Vec3i(1, 5, -1), new Vec3i(-1, 5, -1), new Vec3i(1, 6, 0), new Vec3i(-1, 6, 0), new Vec3i(0, 6, 1), new Vec3i(0, 6, -1), new Vec3i(0, 6, 0)};

    public EntityDryadsGripAttack(Level par1World) {
        super(par1World);
    }

    public EntityDryadsGripAttack(Level par1World, LivingEntity par2Mob) {
        super(par1World, par2Mob);
    }

    public EntityDryadsGripAttack(Level par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
    }

    @Override
    protected void func_70184_a(HitResult result) {
        if (!this.field_70170_p.field_72995_K && result.field_72313_a == HitResult.Type.BLOCK && !this.foundPos) {
            this.foundPos = true;
            this.treePos = result.func_178782_a();
            this.field_70159_w = 0.0;
            this.field_70181_x = 0.0;
            this.field_70179_y = 0.0;
            this.func_189654_d(true);
            this.field_70133_I = true;
            CustomParticleConfig config1 = new CustomParticleConfig();
            config1.createInstance().setParticle(ParticleInit.NATURE_MAGIC).setSpread(4.0, 1.0, 4.0).setCount(10).setIgnoreRange(true);
            IParticleSpawner.spawnParticle(this.field_70170_p, config1, (double)this.treePos.func_177958_n(), (double)(this.treePos.func_177956_o() + 3), (double)this.treePos.func_177952_p());
            this.logNum = 0;
            this.leafNum = 0;
            AABB checkBox = new AABB(this.treePos.func_177982_a(-15, -15, -15), this.treePos.func_177982_a(15, 15, 15));
            for (LivingEntity entity : this.field_70170_p.func_72872_a(LivingEntity.class, checkBox)) {
                if (entity.equals((Object)this.func_85052_h())) continue;
                entity.func_70690_d(new PotionEffect(PotionInit.TETHERED, 400));
            }
        }
    }

    @Override
    public void func_70071_h_() {
        if (!this.field_70170_p.field_72995_K && this.treePos != null) {
            if (this.logNum < logs.length) {
                BlockPos log = this.treePos.func_177971_a(logs[this.logNum]);
                ++this.logNum;
                if (this.field_70170_p.func_175623_d(log)) {
                    this.field_70170_p.func_175656_a(log, BlockInit.logsNitro.func_176223_P().func_177226_a((Property)BlockRotatedPillar.field_176298_M, (Comparable)Direction.Axis.Y));
                }
            } else if (this.leafNum < leaves.length) {
                BlockPos leaf = this.treePos.func_177971_a(leaves[this.leafNum]);
                ++this.leafNum;
                if (this.field_70170_p.func_175623_d(leaf)) {
                    this.field_70170_p.func_175656_a(leaf, BlockInit.leavesNitro.func_176223_P());
                }
                if (this.leafNum < leaves.length) {
                    BlockPos leaf2 = this.treePos.func_177971_a(leaves[this.leafNum]);
                    ++this.leafNum;
                    if (this.field_70170_p.func_175623_d(leaf2)) {
                        this.field_70170_p.func_175656_a(leaf2, BlockInit.leavesNitro.func_176223_P());
                    }
                }
                this.func_184185_a(SoundInit.GENERIC_WEAPON_2, 0.5f, 0.7f + this.field_70146_Z.nextFloat() * 1.3f);
            } else {
                this.leafNum = 0;
                this.logNum = 0;
                this.func_70106_y();
            }
        }
        super.func_70071_h_();
    }

    protected float func_70185_h() {
        return 0.0f;
    }
}

