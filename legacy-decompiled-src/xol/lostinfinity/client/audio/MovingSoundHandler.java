/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Maps
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.audio.ISound
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.client.audio;

import com.google.common.collect.Maps;
import java.util.Map;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.audio.UniversalMovingSound;

@SideOnly(value=Side.CLIENT)
public class MovingSoundHandler {
    public static final MovingSoundHandler instance = new MovingSoundHandler();
    private final Map<Integer, UniversalMovingSound> activeSounds = Maps.newConcurrentMap();

    public void trackSound(int sourceId, UniversalMovingSound sound) {
        if (this.activeSounds.containsKey(sourceId)) {
            return;
        }
        Minecraft.func_71410_x().func_147118_V().func_147682_a((ISound)sound);
        this.activeSounds.put(sourceId, sound);
    }

    public void stopSound(int sourceId) {
        UniversalMovingSound sound = this.activeSounds.remove(sourceId);
        if (sound != null) {
            sound.setDonePlaying(true);
        }
    }
}

