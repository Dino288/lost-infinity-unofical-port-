/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.util.Direction
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.mount;

import java.util.ArrayList;
import java.util.UUID;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.Vec3;
import net.minecraft.core.Vec3i;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.item.classify.IMovingSoundSource;
import xol.lostinfinity.mob.entity.base.EntityMultipleLivesMount;
import xol.lostinfinity.mob.entity.misc.EntityCourseRing;
import xol.lostinfinity.util.math.LMath;

public class EntityJetMount
extends EntityMultipleLivesMount
implements IMovingSoundSource {
    private static final double ACCELERATION = 1.0;
    private static final double AIR_DRAG = 0.1;
    private static final int NUM_RINGS = 15;
    private int ringCount = 0;
    private ArrayList<UUID> ringIds = new ArrayList();

    public EntityJetMount(Level worldIn) {
        super(worldIn);
        this.func_70105_a(1.0f, 1.0f);
    }

    @Override
    protected void func_184651_r() {
    }

    public void func_70106_y() {
        super.func_70106_y();
        if (!this.field_70170_p.field_72995_K) {
            this.clearRings();
        }
    }

    private void clearRings() {
        if (this.ringIds != null && !this.ringIds.isEmpty()) {
            for (UUID ringId : this.ringIds) {
                Entity entity = this.field_70170_p.func_73046_m().func_175576_a(ringId);
                if (entity == null) continue;
                ((EntityCourseRing)entity).func_70106_y();
            }
            this.ringIds.clear();
        }
    }

    @Override
    public void func_191986_a(float strafe, float vertical, float forward) {
        if (!this.field_70170_p.field_72995_K && this.field_70173_aa % 30 == 0) {
            this.playSoundAround(SoundInit.DRAGON_FIRE_BREATH, SoundSource.PLAYERS, (Entity)this, 5.0f, 0.3f, false, 0);
        }
        if (this.func_184207_aI() && this.func_82171_bF() && !this.field_70128_L) {
            LivingEntity entitylivingbase = (LivingEntity)this.func_184179_bs();
            if (entitylivingbase != null) {
                this.func_70101_b(entitylivingbase.field_70177_z, entitylivingbase.field_70125_A * 0.5f);
                this.field_70126_B = this.field_70177_z;
                this.field_70759_as = this.field_70761_aq = this.field_70177_z;
                if (this.field_70170_p.field_72995_K && entitylivingbase == Minecraft.func_71410_x().field_71439_g) {
                    Vec3 accel = Minecraft.func_71410_x().field_71439_g.func_70040_Z().func_186678_a(1.0);
                    Vec3 trail = new Vec3(0.0, 0.0, 0.0).func_178788_d(accel);
                    trail = LMath.fastNormalize(trail);
                    if (this.field_70173_aa % 2 == 0) {
                        for (double i = 0.0; i < 6.0; i += 0.2) {
                            this.field_70170_p.func_175688_a(ParticleInit.FLAME_LARGE, this.field_70146_Z.nextDouble() * 0.5 - 0.25 + this.field_70165_t + trail.field_72450_a * i - this.func_189651_aD().field_72450_a * 2.0, this.field_70146_Z.nextDouble() * 0.5 - 0.25 + this.field_70163_u + (double)this.field_70131_O / 2.0 + trail.field_72448_b * i - this.func_189651_aD().field_72448_b * 2.0, this.field_70146_Z.nextDouble() * 0.5 - 0.25 + this.field_70161_v + trail.field_72449_c - this.func_189651_aD().field_72449_c * 2.0, 0.0, 0.1, 0.0, new int[0]);
                        }
                    }
                    this.field_70159_w += accel.field_72450_a * 0.05;
                    this.field_70181_x += accel.field_72448_b * 0.05;
                    this.field_70179_y += accel.field_72449_c * 0.05;
                    this.field_70159_w += -0.1 * this.field_70159_w * 0.05;
                    this.field_70181_x += -0.1 * this.field_70181_x * 0.05;
                    this.field_70179_y += -0.1 * this.field_70179_y * 0.05;
                } else {
                    this.field_70159_w = 0.0;
                    this.field_70181_x = 0.0;
                    this.field_70179_y = 0.0;
                }
                this.func_70659_e((float)this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111126_e());
                boolean prevGround = this.field_70122_E;
                this.field_70122_E = true;
                double velX = this.field_70159_w;
                double velY = this.field_70181_x;
                double velZ = this.field_70179_y;
                this.originalTravel(0.0f, 0.0f, 0.0f);
                this.field_70159_w = velX;
                this.field_70181_x = velY;
                this.field_70179_y = velZ;
                this.field_70122_E = prevGround;
                this.prevSpeed = this.speed;
                this.speed = (float)LMath.fastLength(this.field_70159_w, 0.0, this.field_70179_y);
            }
        } else {
            this.originalTravel(strafe, vertical, forward);
        }
        this.updateOnGroundState();
    }

    public void startCourse(Player player) {
        this.ringCount = 0;
        this.placeRings(player.func_174811_aO(), this.func_180425_c(), 0);
        Entity entity = this.field_70170_p.func_73046_m().func_175576_a(this.ringIds.get(0));
        if (entity != null) {
            ((EntityCourseRing)entity).setNext();
        }
        player.func_145747_a((Component)new Component((Object)((Object)TextFmt.Gold) + "Navigate through the rings!"));
    }

    private void placeRings(Direction facing, BlockPos pos, int i) {
        Direction nextFacing;
        Vec3i forwardDir;
        if (i == 15) {
            return;
        }
        switch (facing) {
            case WEST: {
                forwardDir = new Vec3i(-1, 0, 0);
                nextFacing = Direction.NORTH;
                break;
            }
            case NORTH: {
                forwardDir = new Vec3i(0, 0, -1);
                nextFacing = Direction.EAST;
                break;
            }
            case EAST: {
                forwardDir = new Vec3i(1, 0, 0);
                nextFacing = Direction.SOUTH;
                break;
            }
            case SOUTH: {
                forwardDir = new Vec3i(0, 0, 1);
                nextFacing = Direction.WEST;
                break;
            }
            default: {
                forwardDir = new Vec3i(0, 0, 1);
                nextFacing = Direction.WEST;
            }
        }
        int randForward = this.field_70146_Z.nextInt(20) + 40;
        int randX = this.field_70146_Z.nextInt(17) - 8;
        int randZ = this.field_70146_Z.nextInt(17) - 8;
        int randY = this.field_70146_Z.nextInt(7);
        BlockPos chunkPos = new BlockPos(pos.func_177958_n() + randX + forwardDir.func_177958_n() * randForward, 0, pos.func_177952_p() + randZ + forwardDir.func_177952_p() * randForward);
        if (!this.field_70170_p.func_175726_f(chunkPos).func_177410_o()) {
            this.field_70170_p.func_175726_f(chunkPos).func_76631_c();
        }
        int height = this.field_70170_p.func_189649_b(pos.func_177958_n() + randX + forwardDir.func_177958_n() * randForward, pos.func_177952_p() + randZ + forwardDir.func_177952_p() * randForward) + randY + 10;
        BlockPos curPos = new BlockPos(pos.func_177958_n() + randX + forwardDir.func_177958_n() * randForward, height, pos.func_177952_p() + randZ + forwardDir.func_177952_p() * randForward);
        EntityCourseRing ring = new EntityCourseRing(this.field_70170_p);
        ring.setOwner((Player)this.func_184179_bs());
        ring.func_70634_a(curPos.func_177958_n(), curPos.func_177956_o(), curPos.func_177952_p());
        ring.setFacing(facing);
        ring.setIndex(i);
        this.field_70170_p.func_72838_d((Entity)ring);
        if (ring == null || ring.field_70128_L) {
            this.placeRings(facing, pos, height);
            return;
        }
        this.ringIds.add(ring.func_110124_au());
        if (this.field_70146_Z.nextInt(3) == 0) {
            this.placeRings(nextFacing, curPos, i + 1);
        } else {
            this.placeRings(facing, curPos, i + 1);
        }
    }

    public int getRingIndex() {
        return this.ringCount;
    }

    public void progressCourse(Player player) {
        Entity entity;
        ++this.ringCount;
        if (this.ringCount == 15) {
            this.ringCount = 0;
            player.func_145747_a((Component)new Component((Object)((Object)TextFmt.Green) + "Course Complete!"));
            player.func_191521_c(new ItemStack(ItemInit.navigationMechanism, 1));
            this.func_70106_y();
        } else if (this.ringIds != null && this.ringIds.size() > this.ringCount && (entity = this.field_70170_p.func_73046_m().func_175576_a(this.ringIds.get(this.ringCount))) != null && !entity.field_70128_L && this.field_70170_p.field_72996_f.contains(entity)) {
            if (!this.field_70170_p.func_72964_e(entity.field_70176_ah, entity.field_70164_aj).func_177410_o()) {
                this.field_70170_p.func_72964_e(entity.field_70176_ah, entity.field_70164_aj).func_76631_c();
            }
            ((EntityCourseRing)entity).setNext();
        }
    }

    @Override
    public void func_70014_b(CompoundTag tag) {
        super.func_70014_b(tag);
        for (int i = 0; i < this.ringIds.size(); ++i) {
            tag.func_186854_a("ringId" + i, this.ringIds.get(i));
        }
    }

    @Override
    public void func_70037_a(CompoundTag tag) {
        super.func_70037_a(tag);
        this.ringIds.clear();
        for (int i = 0; i < 15; ++i) {
            this.ringIds.add(tag.func_186857_a("ringId" + i));
        }
    }
}

