/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.monster.Monster
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
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.boss;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.monster.Monster;
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
import net.minecraft.world.level.Level;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.boss.EntityDroidBoss;

public class EntityArenaEvent
extends Monster {
    private int eventtimer = 250;
    private static final DataParameter<Byte> TYPE = EntityDataManager.func_187226_a(EntityArenaEvent.class, (DataSerializer)DataSerializers.field_187191_a);

    public EntityArenaEvent(Level worldIn) {
        super(worldIn);
        this.func_184224_h(true);
    }

    protected void func_70088_a() {
        super.func_70088_a();
        this.field_70180_af.func_187214_a(TYPE, (Object)0);
    }

    public byte getEventType() {
        return (Byte)this.field_70180_af.func_187225_a(TYPE);
    }

    public void setEventType(byte f) {
        this.field_70180_af.func_187227_b(TYPE, (Object)f);
    }

    public void func_70014_b(CompoundTag tag) {
        super.func_70014_b(tag);
        tag.func_74774_a("EventType", this.getEventType());
    }

    public void func_70037_a(CompoundTag tag) {
        super.func_70037_a(tag);
        this.setEventType(tag.func_74771_c("EventType"));
    }

    protected SoundEvent func_184639_G() {
        return null;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return null;
    }

    protected SoundEvent func_184615_bR() {
        return null;
    }

    private void messagePlayers(String str) {
        AABB aabb = new AABB(new BlockPos(-3.0, 60.0, -145.0), new BlockPos(52.0, 85.0, -40.0));
        for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, aabb)) {
            near_pl.func_145747_a((Component)new Component(str));
        }
    }

    public void func_70636_d() {
        super.func_70636_d();
        this.field_70143_R = -1.0f;
        this.field_70163_u = 64.0;
        if (!this.field_70170_p.field_72995_K && this.getEventType() == 0) {
            if (this.eventtimer == 245) {
                this.func_184185_a(SoundInit.ARENA_EVENT, 2.0f, 1.0f);
                this.messagePlayers((Object)((Object)TextFmt.Aqua) + "Detecting another presence entering the arena...");
            }
            if (this.eventtimer == 160) {
                this.func_184185_a(SoundInit.ARENA_EVENT, 2.0f, 1.0f);
                this.messagePlayers((Object)((Object)TextFmt.Red) + "Familiar Voice: Oh how I've missed this world.");
            }
            if (this.eventtimer == 100) {
                this.func_184185_a(SoundInit.ARENA_EVENT, 2.0f, 1.0f);
                this.messagePlayers((Object)((Object)TextFmt.Red) + "Familiar Voice: I had strings but now I'm free.");
            }
            if (this.eventtimer == 50) {
                this.messagePlayers((Object)((Object)TextFmt.Red) + "Familiar Voice: There are no strings on me.");
            }
            if (this.eventtimer == 0) {
                this.func_184185_a(SoundInit.DROID_SUMMON, 2.0f, 1.0f);
                EntityDroidBoss droid = new EntityDroidBoss(this.field_70170_p);
                droid.func_70107_b(25.5, 62.2, -90.0);
                droid.setForm((byte)0);
                this.field_70170_p.func_72838_d((Entity)droid);
                this.func_70106_y();
            }
        }
        --this.eventtimer;
    }
}

