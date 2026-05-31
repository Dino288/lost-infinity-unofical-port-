/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.tileentity.BlockEntity
 *  net.minecraft.util.ITickable
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.block.tileentity;

import java.util.ArrayList;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.util.ITickable;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.init.BlockInit;

public class BlockEntityPortalNexus
extends BlockEntity
implements ITickable {
    private boolean active = false;
    private ArrayList<BlockPos> nodePositions = null;
    private double growth = 0.05;
    private static final double maxGrowth = 20.0;
    private static final double growthSpeed = 0.1;
    private float rotation = 0.0f;
    private static final double rotationSpeed = (double)0.2f;

    public void func_73660_a() {
        if (this.field_145850_b.func_180495_p(this.func_174877_v()).equals(BlockInit.portalNexus.func_176203_a(1))) {
            this.active = true;
        } else {
            this.active = false;
            this.growth = 0.05;
            this.rotation = 0.0f;
        }
        this.rotation = (float)((double)this.rotation + (double)0.2f);
        if (this.growth <= 20.0) {
            this.growth += 0.1;
        }
    }

    public boolean isActive() {
        return this.active;
    }

    public boolean shouldRenderInPass(int pass) {
        return true;
    }

    public AABB getRenderBoundingBox() {
        AABB bb = INFINITE_EXTENT_AABB;
        return bb;
    }

    @SideOnly(value=Side.CLIENT)
    public double func_145833_n() {
        return 65536.0;
    }

    public void addNodePos(BlockPos pos) {
        if (this.nodePositions == null) {
            this.nodePositions = new ArrayList();
        }
        if (!this.nodePositions.contains(pos)) {
            this.nodePositions.add(pos);
        }
        if (this.nodePositions.size() >= 4) {
            this.field_145850_b.func_175656_a(this.func_174877_v(), BlockInit.portalNexus.func_176203_a(1));
        }
    }

    public double getGrowth() {
        return this.growth;
    }

    public float getRotation() {
        return this.rotation;
    }
}

