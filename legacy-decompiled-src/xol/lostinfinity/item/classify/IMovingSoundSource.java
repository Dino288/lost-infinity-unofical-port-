/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.audio.ISound$AttenuationType
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.SoundEvent
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.item.classify;

import java.util.concurrent.atomic.AtomicInteger;
import net.minecraft.client.audio.ISound;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.audio.MovingSoundHandler;
import xol.lostinfinity.client.audio.UniversalMovingSound;
import xol.lostinfinity.common.lostinfinity;
import xol.lostinfinity.common.packets.clientbound.PacketUniversalMovingSound;

public interface IMovingSoundSource {
    public static final AtomicInteger idCounter = new AtomicInteger();
    public static final Special NORMAL = new Special(){};
    public static final Special MOVING = new Special(){

        @Override
        public void onInit(UniversalMovingSound sound) {
            sound.setAttenuationType(ISound.AttenuationType.NONE);
        }
    };

    default public void playSound(SoundEvent soundIn, SoundSource categoryIn, float volume, float pitch) {
        this.playSound(soundIn, categoryIn, NORMAL, volume, pitch);
    }

    default public void playSound(SoundEvent soundIn, SoundSource categoryIn, Special special, float volume, float pitch) {
        lostinfinity.proxy.playMovingSound(soundIn, categoryIn, special, volume, pitch);
    }

    default public int playSoundAround(SoundEvent soundIn, SoundSource categoryIn, Entity source, float volume, float pitch, boolean repeat, int repeatDelay) {
        int soundId = idCounter.getAndIncrement();
        lostinfinity.instance.packetHandler.sendToPlayerExcept(source, new PacketUniversalMovingSound(soundId, soundIn, categoryIn, source.func_145782_y(), volume, pitch, repeat, repeatDelay));
        return soundId;
    }

    default public void stopSoundAround(int soundId, Entity source) {
        lostinfinity.instance.packetHandler.sendToPlayerExcept(source, new PacketUniversalMovingSound(soundId));
    }

    @SideOnly(value=Side.CLIENT)
    public static class Follower
    implements Special {
        private final int soundId;
        private final Entity source;
        private final boolean repeat;
        private final int repeatDelay;

        public Follower(int soundId, Entity source) {
            this(soundId, source, false, 0);
        }

        public Follower(int soundId, Entity source, boolean repeat, int repeatDelay) {
            this.soundId = soundId;
            this.source = source;
            this.repeat = repeat;
            this.repeatDelay = repeatDelay;
        }

        @Override
        public void onInit(UniversalMovingSound sound) {
            sound.setRepeat(this.repeat);
            sound.setRepeatDelay(this.repeatDelay);
        }

        @Override
        public void onUpdate(UniversalMovingSound sound) {
            sound.setXPosF((float)this.source.field_70165_t);
            sound.setYPosF((float)this.source.field_70163_u);
            sound.setZPosF((float)this.source.field_70161_v);
        }

        @Override
        public void onDone(UniversalMovingSound sound) {
            MovingSoundHandler.instance.stopSound(this.soundId);
        }
    }

    public static class Repeating
    implements Special {
        private final int repeatDelay;

        public Repeating(int repeatDelay) {
            this.repeatDelay = repeatDelay;
        }

        @Override
        public void onInit(UniversalMovingSound sound) {
            sound.setRepeat(true);
            sound.setRepeatDelay(this.repeatDelay);
            sound.setAttenuationType(ISound.AttenuationType.NONE);
        }
    }

    public static interface Special {
        default public void onInit(UniversalMovingSound sound) {
        }

        default public void onUpdate(UniversalMovingSound sound) {
        }

        default public void onDone(UniversalMovingSound sound) {
        }
    }
}

