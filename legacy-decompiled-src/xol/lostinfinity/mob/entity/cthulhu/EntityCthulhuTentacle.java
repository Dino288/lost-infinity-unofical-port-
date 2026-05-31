/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.util.SoundSource
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.cthulhu;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import xol.lostinfinity.common.events.EventsClientRender;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.cthulhu.AbstractCthulhuMinion;
import xol.lostinfinity.util.animation.client.AnimationHandler;
import xol.lostinfinity.util.animation.client.AnimationProperty;
import xol.lostinfinity.util.animation.entity.IXolAnimated;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityCthulhuTentacle
extends AbstractCthulhuMinion
implements IXolAnimated {
    private static final DataParameter<Float> SIZE = EntityDataManager.func_187226_a(EntityCthulhuTentacle.class, (DataSerializer)DataSerializers.field_187193_c);
    private static final DataParameter<Boolean> INVERTED = EntityDataManager.func_187226_a(EntityCthulhuTentacle.class, (DataSerializer)DataSerializers.field_187198_h);
    private static final double ATTACK_COOLDOWN = 400.0;
    private final AnimationHandler handler = new AnimationHandler();
    private final Map<Entity, Long> attackCooldown = new ConcurrentHashMap<Entity, Long>();

    public EntityCthulhuTentacle(Level worldIn) {
        super(worldIn);
        this.func_70105_a(1.5f * this.getSize(), 9.75f * this.getSize());
        this.func_189654_d(true);
    }

    public void func_70636_d() {
        super.func_70636_d();
        this.livingUpdate();
    }

    protected void livingUpdate() {
        if (this.field_70173_aa > 280) {
            this.takeawayNumLives(this.getLivesCount() + 1);
        }
    }

    protected void func_70609_aI() {
        if (this.field_70170_p.field_72995_K) {
            this.field_70737_aN = 0;
            AnimationProperty property = this.getAnimationHandler().getAnimations().get("death");
            if (property == null) {
                this.playAnimation("death", 0.5f);
            } else if (property.stopped) {
                this.field_70725_aQ = 19;
                super.func_70609_aI();
            }
        } else {
            super.func_70609_aI();
        }
    }

    protected void func_82167_n(Entity entityIn) {
        Player player;
        Long time;
        if (entityIn instanceof Player && ((time = this.attackCooldown.get(player = (Player)entityIn)) == null || (double)(System.currentTimeMillis() - time) >= 400.0)) {
            IMaxAttack.dealTrueDamage((Entity)this, (LivingEntity)player, player.func_110138_aP() * 0.5f);
            this.attackCooldown.put(entityIn, System.currentTimeMillis());
            this.field_70170_p.func_184133_a(null, player.func_180425_c(), SoundInit.GENERIC_WHACK, SoundSource.HOSTILE, 1.0f, 1.0f);
        }
    }

    public boolean func_70067_L() {
        return false;
    }

    public boolean func_70104_M() {
        return false;
    }

    public void func_184206_a(DataParameter<?> key) {
        super.func_184206_a(key);
        if (SIZE.equals(key)) {
            this.func_70105_a(1.5f * this.getSize(), 9.75f * this.getSize());
        }
    }

    @Override
    protected void func_184651_r() {
    }

    @Override
    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a(SIZE, (Object)Float.valueOf(3.0f));
        this.field_70180_af.func_187214_a(INVERTED, (Object)true);
    }

    @Override
    protected void doDamageTint() {
    }

    protected void damageTint() {
        super.doDamageTint();
    }

    @Override
    protected boolean func_70692_ba() {
        return false;
    }

    public void onAddedToWorld() {
        super.onAddedToWorld();
        this.playAnimation("spawn", 0.5f);
        this.playAnimation("idle", 0.5f);
        if (this.field_70170_p.field_72995_K) {
            EventsClientRender.renderForce.put(this.func_145782_y(), (Entity)this);
        }
    }

    @Override
    public AnimationHandler getAnimationHandler() {
        return this.handler;
    }

    public void setSize(float size) {
        this.field_70180_af.func_187227_b(SIZE, (Object)Float.valueOf(size));
    }

    public float getSize() {
        return ((Float)this.field_70180_af.func_187225_a(SIZE)).floatValue();
    }

    public void setInverted(boolean flag) {
        this.field_70180_af.func_187227_b(INVERTED, (Object)flag);
    }

    public boolean isInverted() {
        return (Boolean)this.field_70180_af.func_187225_a(INVERTED);
    }
}

