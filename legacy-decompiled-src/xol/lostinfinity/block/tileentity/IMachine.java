/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.tileentity.BlockEntity
 *  net.minecraft.util.math.BlockPos
 */
package xol.lostinfinity.block.tileentity;

import java.util.ArrayList;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.core.BlockPos;

public interface IMachine {
    default public ArrayList<IMachine> getConnectedMachines(BlockEntity te, ArrayList<IMachine> machines) {
        if (machines == null) {
            machines = new ArrayList();
        }
        if (machines.contains(this)) {
            return machines;
        }
        machines.add(this);
        for (BlockPos checkPos : BlockPos.func_177980_a((BlockPos)te.func_174877_v().func_177982_a(-1, -1, -1), (BlockPos)te.func_174877_v().func_177982_a(1, 1, 1))) {
            IMachine newMachine;
            BlockEntity checkTe;
            if (checkPos.equals((Object)te.func_174877_v()) || (checkTe = te.func_145831_w().func_175625_s(checkPos)) == null || !(checkTe instanceof IMachine) || machines.contains(newMachine = (IMachine)checkTe)) continue;
            machines.addAll(newMachine.getConnectedMachines(checkTe, machines));
        }
        return machines;
    }

    default public boolean getPowered() {
        return false;
    }
}

