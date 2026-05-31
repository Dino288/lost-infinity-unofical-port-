/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.server.MinecraftServer
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.Rotation
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 *  net.minecraft.world.gen.feature.WorldGenerator
 *  net.minecraft.world.gen.structure.template.Template
 *  net.minecraft.world.gen.structure.template.TemplateManager
 */
package xol.lostinfinity.dimension.util;

import java.util.Random;
import javax.annotation.Nullable;
import net.minecraft.server.MinecraftServer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;
import xol.lostinfinity.util.load.IStructure;

public class WorldGenStructure
extends WorldGenerator
implements IStructure {
    public static String structureName;

    public WorldGenStructure(String name) {
        structureName = name;
    }

    public boolean func_180709_b(Level worldIn, Random rand, BlockPos position) {
        this.generateStructure(worldIn, position, Rotation.NONE);
        return true;
    }

    public void generateWithRotation(Level worldIn, Random rand, BlockPos position, Rotation rotation) {
        BlockPos new_position = this.posByRota(position, rotation, this.templateSize(worldIn));
        this.generateStructure(worldIn, new_position, rotation);
    }

    public void generateStructure(Level world, BlockPos pos, Rotation rot) {
        Template template = this.loadTemplate(world);
        if (template != null) {
            settings.func_186220_a(rot);
            template.func_186260_a(world, pos, settings);
        }
    }

    public BlockPos templateSize(Level world) {
        Template template = this.loadTemplate(world);
        if (template != null) {
            return template.func_186259_a();
        }
        return null;
    }

    private BlockPos posByRota(BlockPos position, Rotation rotation, BlockPos end_pos) {
        switch (rotation) {
            case NONE: {
                return position;
            }
            case CLOCKWISE_90: {
                return position.func_177982_a(end_pos.func_177952_p() - 1, 0, 0);
            }
            case CLOCKWISE_180: {
                return position.func_177982_a(end_pos.func_177958_n() - 1, 0, end_pos.func_177952_p() - 1);
            }
            case COUNTERCLOCKWISE_90: {
                return position.func_177982_a(0, 0, end_pos.func_177958_n() - 1);
            }
        }
        return position;
    }

    @Nullable
    private Template loadTemplate(Level world) {
        MinecraftServer mcServer = world.func_73046_m();
        TemplateManager manager = worldServer.func_184163_y();
        ResourceLocation location = new ResourceLocation("lostinfinity", structureName);
        return manager.func_189942_b(mcServer, location);
    }
}

