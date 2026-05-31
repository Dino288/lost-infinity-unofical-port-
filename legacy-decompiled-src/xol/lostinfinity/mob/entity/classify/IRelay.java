/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 */
package xol.lostinfinity.mob.entity.classify;

import net.minecraft.world.entity.Entity;

public interface IRelay<T extends Entity> {
    public T getRelay();

    public void setId(int var1);

    public int getId();

    public void setPos(double var1, double var3, double var5, float var7, float var8);

    public double getX();

    public double getY();

    public double getZ();

    public float getYaw();

    public float getPitch();
}

