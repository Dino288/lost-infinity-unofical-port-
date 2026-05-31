/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Optional
 *  net.minecraft.client.entity.AbstractClientPlayer
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.math.Rotations
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.mob.entity.misc;

import com.google.common.base.Optional;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.InteractionHand;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.math.Rotations;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.mob.entity.base.EntityImmaterial;
import xol.lostinfinity.mob.model.ModelMultiverseGhost;
import xol.lostinfinity.util.data.IMaxAttack;
import xol.lostinfinity.util.fx.IParticleSpawner;

public class EntityMultiverseGhost
extends EntityImmaterial {
    protected static final DataParameter<Optional<UUID>> COPIED_ID = EntityDataManager.func_187226_a(EntityMultiverseGhost.class, (DataSerializer)DataSerializers.field_187203_m);
    protected static final DataParameter<Byte> POSE = EntityDataManager.func_187226_a(EntityMultiverseGhost.class, (DataSerializer)DataSerializers.field_187191_a);
    protected static final ItemStack MULTIVERSAL_BLADE = new ItemStack(ItemInit.multiversalBlade);
    private Vec3 motion;
    private final Set<Entity> collided = new HashSet<Entity>();
    private Player owner;

    public EntityMultiverseGhost(Level worldIn) {
        this(worldIn, Vec3.field_186680_a);
    }

    public EntityMultiverseGhost(Level worldIn, Vec3 motion) {
        super(worldIn);
        this.func_70105_a(2.0f, 2.0f);
        this.func_184224_h(true);
        this.func_184611_a(InteractionHand.MAIN_HAND, MULTIVERSAL_BLADE);
        this.field_70145_X = true;
        this.motion = motion;
    }

    @SideOnly(value=Side.CLIENT)
    public ResourceLocation getSkinForMyCopy() {
        Player player = this.getCopiedPlayer();
        if (player != null) {
            AbstractClientPlayer abPlayer = (AbstractClientPlayer)player;
            return abPlayer.func_110306_p();
        }
        return null;
    }

    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a(COPIED_ID, (Object)Optional.absent());
        this.field_70180_af.func_187214_a(POSE, (Object)((byte)this.field_70146_Z.nextInt(Pose.values().length)));
    }

    public void setCopiedPlay(Player player) {
        this.owner = player;
        this.field_70180_af.func_187227_b(COPIED_ID, (Object)Optional.fromNullable((Object)player.func_110124_au()));
    }

    public void setPose(Pose pose) {
        this.field_70180_af.func_187227_b(POSE, (Object)((byte)pose.ordinal()));
    }

    public Pose getPose() {
        byte b = (Byte)this.field_70180_af.func_187225_a(POSE);
        if (Pose.values().length <= b) {
            return Pose.STRAIGHT;
        }
        return Pose.values()[b];
    }

    private Player getCopiedPlayer() {
        if (((Optional)this.field_70180_af.func_187225_a(COPIED_ID)).orNull() != null) {
            return this.field_70170_p.func_152378_a((UUID)((Optional)this.field_70180_af.func_187225_a(COPIED_ID)).get());
        }
        return null;
    }

    @Override
    public void func_70636_d() {
        this.field_70759_as = this.field_70177_z;
        this.field_70761_aq = this.field_70177_z;
        super.func_70636_d();
        if (!this.field_70170_p.field_72995_K) {
            if (this.field_70173_aa >= 30) {
                this.func_70106_y();
                IParticleSpawner.spawnParticle(this.field_70170_p, 55, 0, this.field_70165_t, this.field_70163_u + (double)(this.field_70131_O / 2.0f), this.field_70161_v);
                return;
            }
            this.field_70159_w = this.motion.field_72450_a;
            this.field_70181_x = this.motion.field_72448_b;
            this.field_70179_y = this.motion.field_72449_c;
            this.field_70133_I = true;
            this.motion = this.motion.func_186678_a((double)1.15f);
        }
    }

    protected void func_82167_n(Entity entityIn) {
        if (entityIn == this.owner || entityIn instanceof EntityMultiverseGhost || this.collided.contains(entityIn)) {
            return;
        }
        if (entityIn instanceof LivingEntity) {
            LivingEntity livingBase = (LivingEntity)entityIn;
            this.collided.add((Entity)livingBase);
            IMaxAttack.dealTrueDamage((Entity)this.owner, livingBase, livingBase.func_110138_aP() * 0.7f, Arrays.asList("Darkborn"));
        }
    }

    public static enum Pose {
        STRAIGHT(new Vec3(0.0, 24.0, 0.0), new Vec3(0.0, 0.0, 0.0), new Vec3(0.0, 24.0, 0.0), new Vec3(-22.5, 0.0, 0.0), new Vec3(5.0, 22.0, 0.0), new Vec3(37.0, 21.6, -28.0), new Vec3(-5.0, 22.0, 0.0), new Vec3(45.0, -20.0, 18.5), new Vec3(1.9, 12.0, -2.0), new Vec3(-45.0, 0.0, 0.0), new Vec3(-1.9, 12.0, 5.0), new Vec3(-47.5, 0.0, 0.0), 0.0f, 0.0f, 0.0f, 0.0f),
        OVERHEAD(new Vec3(0.0, 24.0, 0.0), new Vec3(0.0, 0.0, 0.0), new Vec3(0.0, 24.0, 0.0), new Vec3(37.5, 0.0, 0.0), new Vec3(5.0, 22.0, 0.0), new Vec3(-125.6867, -22.9193, 15.6263), new Vec3(-5.0, 22.0, 0.0), new Vec3(-125.6867, 22.9193, -15.6263), new Vec3(1.9, 19.0, -10.0), new Vec3(27.5, 0.0, 0.0), new Vec3(-1.9, 14.0, -7.0), new Vec3(-30.0, 0.0, 0.0), 0.0f, 0.0f, 0.0f, 0.0f),
        THRUST(new Vec3(0.0, 24.0, 0.0), new Vec3(-2.5534, 27.4558, -2.235), new Vec3(0.0, 24.0, 0.0), new Vec3(-32.8166, 59.8098, -36.7252), new Vec3(1.7611, 20.589, -3.7767), new Vec3(92.5, 0.0, 90.0), new Vec3(-2.2695, 23.5961, 4.8669), new Vec3(-101.5084, 29.4987, -95.7251), new Vec3(-5.0097, 14.2438, -3.4539), new Vec3(-58.2783, 73.5874, -21.0242), new Vec3(-2.2908, 13.1267, 4.9127), new Vec3(-65.0663, 38.1243, -46.1556), -90.0f, 1.0f, 0.0f, 0.0f);

        public final Vec3 headOrigin;
        public final Vec3 bodyOrigin;
        public final Vec3 rightArmOrigin;
        public final Vec3 leftArmOrigin;
        public final Vec3 rightLegOrigin;
        public final Vec3 leftLegOrigin;
        public final Rotations headRot;
        public final Rotations bodyRot;
        public final Rotations rightArmRot;
        public final Rotations leftArmRot;
        public final Rotations rightLegRot;
        public final Rotations leftLegRot;
        public final float itemAngle;
        public final float itemAxisX;
        public final float itemAxisY;
        public final float itemAxisZ;

        private Pose(Vec3 headPos, Vec3 headRot, Vec3 bodyPos, Vec3 bodyRot, Vec3 rightArmPos, Vec3 rightArmRot, Vec3 leftArmPos, Vec3 leftArmRot, Vec3 rightLegPos, Vec3 rightLegRot, Vec3 leftLegPos, Vec3 leftLegRot, float itemAngle, float itemAxisX, float itemAxisY, float itemAxisZ) {
            Vec3 ORIGIN = new Vec3(0.0, 24.0, 0.0);
            this.headOrigin = ORIGIN.func_178788_d(headPos);
            this.bodyOrigin = ORIGIN.func_178788_d(bodyPos);
            this.rightArmOrigin = ORIGIN.func_178788_d(rightArmPos);
            this.leftArmOrigin = ORIGIN.func_178788_d(leftArmPos);
            this.rightLegOrigin = ORIGIN.func_178788_d(rightLegPos);
            this.leftLegOrigin = ORIGIN.func_178788_d(leftLegPos);
            this.headRot = Pose.convert(headRot);
            this.bodyRot = Pose.convert(bodyRot);
            this.rightArmRot = Pose.convert(rightArmRot);
            this.leftArmRot = Pose.convert(leftArmRot);
            this.rightLegRot = Pose.convert(rightLegRot);
            this.leftLegRot = Pose.convert(leftLegRot);
            this.itemAngle = itemAngle;
            this.itemAxisX = itemAxisX;
            this.itemAxisY = itemAxisY;
            this.itemAxisZ = itemAxisZ;
        }

        public void applyPose(ModelMultiverseGhost model) {
            this.apply(model.field_78116_c, this.headOrigin, this.headRot);
            this.apply(model.field_78115_e, this.bodyOrigin, this.bodyRot);
            this.apply(model.field_178723_h, this.rightArmOrigin, this.rightArmRot);
            this.apply(model.field_178724_i, this.leftArmOrigin, this.leftArmRot);
            this.apply(model.field_178721_j, this.rightLegOrigin, this.rightLegRot);
            this.apply(model.field_178722_k, this.leftLegOrigin, this.leftLegRot);
        }

        public void offsetItem() {
            float zOffset = 0.25f;
            GlStateManager.func_179109_b((float)0.0f, (float)0.0f, (float)zOffset);
            GlStateManager.func_179114_b((float)this.itemAngle, (float)this.itemAxisX, (float)this.itemAxisY, (float)this.itemAxisZ);
            GlStateManager.func_179109_b((float)0.0f, (float)0.0f, (float)(-zOffset));
        }

        private void apply(ModelRenderer renderer, Vec3 pos, Rotations rot) {
            renderer.field_78800_c = (float)pos.field_72450_a;
            renderer.field_78797_d = (float)pos.field_72448_b;
            renderer.field_78798_e = (float)(-pos.field_72449_c);
            renderer.field_78795_f = -rot.func_179415_b();
            renderer.field_78796_g = -rot.func_179416_c();
            renderer.field_78808_h = rot.func_179413_d();
        }

        private static Rotations convert(Vec3 vec3d) {
            return new Rotations((float)Math.toRadians(vec3d.field_72450_a), (float)Math.toRadians(vec3d.field_72448_b), (float)Math.toRadians(vec3d.field_72449_c));
        }
    }
}

