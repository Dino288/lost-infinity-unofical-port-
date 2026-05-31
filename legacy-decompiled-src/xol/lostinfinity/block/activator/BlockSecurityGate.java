/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.Item
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.Direction
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.activator;

import java.util.Map;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.potion.PotionEffect;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.Vec3;
import net.minecraft.core.Vec3i;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasic;
import xol.lostinfinity.init.PotionInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.item.tool.ItemSecurityPass;
import xol.lostinfinity.util.coordinates.GalaxyCoordinates;

public class BlockSecurityGate
extends BlockBasic {
    private int securityLevel = 0;

    public BlockSecurityGate(String name, int security) {
        super(name);
        this.securityLevel = security;
        this.func_149715_a(1.0f);
    }

    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        ItemSecurityPass pass;
        int passLevel;
        Item heldItem;
        if (!worldIn.field_72995_K && (heldItem = playerIn.func_184614_ca().func_77973_b()) instanceof ItemSecurityPass && (passLevel = (pass = (ItemSecurityPass)heldItem).getSecurityLevel()) >= this.securityLevel) {
            playerIn.func_70690_d(new PotionEffect(PotionInit.SECURITY_CLEARANCE, 300, this.securityLevel));
            worldIn.func_184133_a(null, pos, SoundInit.SECURITY_CLEAR, SoundSource.MASTER, 1.0f, 1.0f);
            Map<BlockPos, String> specialGates = GalaxyCoordinates.securityWithMSG();
            for (Map.Entry<BlockPos, String> entry : specialGates.entrySet()) {
                if (!this.posNearAABB(pos, entry.getKey())) continue;
                playerIn.func_145747_a((Component)new Component(entry.getValue()));
            }
        }
        return true;
    }

    private boolean posNearAABB(BlockPos posGate, BlockPos check) {
        AABB aabb = new AABB(check).func_186662_g(2.0);
        Vec3 vec = new Vec3((Vec3i)posGate);
        return aabb.func_72318_a(vec);
    }
}

