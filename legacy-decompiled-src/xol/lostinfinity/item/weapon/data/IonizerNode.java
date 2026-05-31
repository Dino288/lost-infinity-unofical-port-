/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.util.math.Vec3
 */
package xol.lostinfinity.item.weapon.data;

import java.util.ArrayList;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;

public class IonizerNode {
    private LivingEntity origin = null;
    private Vec3 originPos = null;
    private double originHeight = 0.0;
    private ArrayList<IonizerNode> targets = null;
    private int timer = 0;
    private boolean active = false;

    public IonizerNode(LivingEntity origin) {
        this.origin = origin;
        this.originPos = origin.func_174791_d();
        this.originHeight = origin.field_70131_O;
    }

    public void updatePos() {
        if (this.origin != null && !this.origin.field_70128_L) {
            this.originPos = this.origin.func_174791_d();
        }
    }

    public double getHeight() {
        return this.originHeight;
    }

    public boolean isActive() {
        return this.active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public ArrayList<IonizerNode> getTargets() {
        return this.targets;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    public void setTargets(ArrayList<IonizerNode> targets) {
        this.targets = targets;
    }

    public LivingEntity getOrigin() {
        return this.origin;
    }

    public Vec3 getOriginPos() {
        return this.originPos;
    }

    public int getTimer() {
        return this.timer;
    }
}

