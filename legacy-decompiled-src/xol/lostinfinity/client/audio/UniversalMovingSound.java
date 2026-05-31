/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.audio.ISound$AttenuationType
 *  net.minecraft.client.audio.MovingSound
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.SoundEvent
 */
package xol.lostinfinity.client.audio;

import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.MovingSound;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvent;
import xol.lostinfinity.item.classify.IMovingSoundSource;

public class UniversalMovingSound
extends MovingSound {
    private final IMovingSoundSource.Special special;

    public UniversalMovingSound(SoundEvent soundIn, SoundSource categoryIn, IMovingSoundSource.Special special, float volume, float pitch) {
        super(soundIn, categoryIn);
        this.special = special;
        this.field_147662_b = volume;
        this.field_147663_c = pitch;
        special.onInit(this);
    }

    public void func_73660_a() {
        this.special.onUpdate(this);
    }

    public void setAttenuationType(ISound.AttenuationType type) {
        this.field_147666_i = type;
    }

    public void setRepeat(boolean flag) {
        this.field_147659_g = flag;
    }

    public void setRepeatDelay(int value) {
        this.field_147665_h = value;
    }

    public void setVolume(float value) {
        this.field_147662_b = value;
    }

    public void setPitch(float value) {
        this.field_147663_c = value;
    }

    public void setXPosF(float value) {
        this.field_147660_d = value;
    }

    public void setYPosF(float value) {
        this.field_147661_e = value;
    }

    public void setZPosF(float value) {
        this.field_147658_f = value;
    }

    public void setDonePlaying(boolean flag) {
        this.field_147668_j = flag;
    }

    public boolean func_147657_c() {
        if (!super.func_147657_c()) {
            this.special.onDone(this);
            return false;
        }
        return true;
    }
}

