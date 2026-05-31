/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nonnull
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockMobSpawner
 *  net.minecraft.block.IBlockEntityProvider
 *  net.minecraft.item.Item
 *  net.minecraft.item.BlockItem
 *  net.minecraft.nbt.NBTBase
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.tileentity.BlockEntity
 *  net.minecraft.util.LazyLoadBase
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.common.registry.ForgeRegistries
 */
package xol.lostinfinity.block.basic;

import javax.annotation.Nonnull;
import net.minecraft.world.level.block.Block;
import net.minecraft.block.BlockMobSpawner;
import net.minecraft.block.IBlockEntityProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.util.LazyLoadBase;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.util.load.CustomLazyLoad;

public class BlockBasicSpawner
extends BlockMobSpawner {
    protected String mobName;
    private final LazyLoadBase<IBlockEntityProvider> spawnerReference;

    public BlockBasicSpawner(String name, String mobName) {
        this.mobName = mobName;
        this.func_149663_c(name);
        this.setRegistryName("lostinfinity", name);
        this.func_149647_a(TabsInit.TAB_BLOCKS);
        this.func_149711_c(5.0f);
        this.func_149675_a(true);
        BlockInit.BLOCKS.add((Block)this);
        ItemInit.ITEMS.add((Item)new BlockItem((Block)this).setRegistryName(this.getRegistryName()));
        this.spawnerReference = new CustomLazyLoad<IBlockEntityProvider>(() -> {
            Block spawner = (Block)ForgeRegistries.BLOCKS.getValue(new ResourceLocation("mob_spawner"));
            if (spawner instanceof IBlockEntityProvider) {
                return (IBlockEntityProvider)spawner;
            }
            return null;
        });
    }

    public BlockEntity func_149915_a(Level world, int par1) {
        BlockEntity spawner = null;
        IBlockEntityProvider entityProvider = (IBlockEntityProvider)this.spawnerReference.func_179281_c();
        if (entityProvider != null && (spawner = entityProvider.func_149915_a(world, par1)) != null) {
            this.insertModData(spawner);
        }
        return spawner;
    }

    private void insertModData(@Nonnull BlockEntity spawner) {
        CompoundTag spawnerNBT = spawner.func_189515_b(new CompoundTag());
        spawnerNBT.func_74778_a("SpawnPotentials", this.mobName);
        CompoundTag compound2 = new CompoundTag();
        compound2.func_74778_a("id", "lostinfinity:" + this.mobName);
        spawnerNBT.func_74782_a("SpawnData", (NBTBase)compound2);
        spawner.func_145839_a(spawnerNBT);
        spawner.func_70296_d();
    }
}

