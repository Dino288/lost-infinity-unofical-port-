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

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.util.ITickable;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.init.BlockInit;

public class BlockEntityPortalNode
extends BlockEntity
implements ITickable {
    private boolean active = false;
    private BlockPos nexusPos = null;

    public void func_73660_a() {
        if (!this.field_145850_b.field_72995_K) {
            this.active = this.field_145850_b.func_180495_p(this.func_174877_v()).equals(BlockInit.portalNode.func_176203_a(1));
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

    public BlockPos getNexusPos() {
        return this.nexusPos;
    }

    public void setNexusPos(BlockPos nexusPos) {
        this.nexusPos = nexusPos;
    }
}

