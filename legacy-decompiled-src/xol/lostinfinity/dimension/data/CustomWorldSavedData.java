/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 *  net.minecraft.world.storage.MapStorage
 *  net.minecraft.world.storage.WorldSavedData
 */
package xol.lostinfinity.dimension.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.storage.MapStorage;
import net.minecraft.world.storage.WorldSavedData;
import xol.lostinfinity.dimension.data.BlockData;

public class CustomWorldSavedData
extends WorldSavedData {
    private static final String DATA_NAME = "lostinfinity_custom_data";
    private HashMap<Integer, ArrayList<BlockData>> dataMap = new HashMap();
    private ArrayList<Integer> tileIDs = new ArrayList();
    private HashMap<Integer, BlockPos> tilePositions = new HashMap();

    public CustomWorldSavedData() {
        super(DATA_NAME);
    }

    public CustomWorldSavedData(String s) {
        super(s);
    }

    public void func_76184_a(CompoundTag nbt) {
        if (this.tileIDs.size() > 0) {
            this.tileIDs.clear();
        }
        if (this.tilePositions.size() > 0) {
            this.tilePositions.clear();
        }
        if (this.dataMap.size() > 0) {
            this.dataMap.clear();
        }
        if (nbt.func_74764_b("tileIDs")) {
            int[] tempids = nbt.func_74759_k("tileIDs");
            for (int i = 0; i < tempids.length; ++i) {
                this.tileIDs.add(tempids[i]);
            }
        }
        for (int id : this.tileIDs) {
            String id_str = String.valueOf(id);
            if (!nbt.func_74764_b("tileX" + id_str) || !nbt.func_74764_b("tileY" + id_str) || !nbt.func_74764_b("tileZ" + id_str)) continue;
            int tileX = nbt.func_74762_e("tileX" + id_str);
            int tileY = nbt.func_74762_e("tileY" + id_str);
            int tileZ = nbt.func_74762_e("tileZ" + id_str);
            BlockPos tilePos = new BlockPos(tileX, tileY, tileZ);
            this.tilePositions.put(id, tilePos);
            if (!nbt.func_74764_b("xPos" + id_str) || !nbt.func_74764_b("yPos" + id_str) || !nbt.func_74764_b("zPos" + id_str) || !nbt.func_74764_b("meta" + id_str) || !nbt.func_74764_b("ids" + id_str)) continue;
            int[] xPos = nbt.func_74759_k("xPos" + id_str);
            int[] yPos = nbt.func_74759_k("yPos" + id_str);
            int[] zPos = nbt.func_74759_k("zPos" + id_str);
            int[] meta = nbt.func_74759_k("meta" + id_str);
            int[] ids = nbt.func_74759_k("ids" + id_str);
            if (xPos.length <= 0 || yPos.length <= 0 || zPos.length <= 0 || meta.length <= 0) continue;
            ArrayList<BlockData> newData = new ArrayList<BlockData>();
            for (int i = 0; i < xPos.length; ++i) {
                if (i >= yPos.length || i >= zPos.length || i >= meta.length) {
                    return;
                }
                BlockPos pos = new BlockPos(xPos[i], yPos[i], zPos[i]);
                BlockData data = new BlockData(pos, meta[i], ids[i]);
                newData.add(data);
            }
            if (newData.size() <= 1) continue;
            this.dataMap.put(id, newData);
        }
    }

    public CompoundTag func_189551_b(CompoundTag compound) {
        int[] tileids = new int[this.tileIDs.size()];
        for (int j = 0; j < this.tileIDs.size(); ++j) {
            int id;
            tileids[j] = id = this.tileIDs.get(j).intValue();
            String id_str = String.valueOf(id);
            ArrayList<BlockData> block_data = this.dataMap.get(id);
            if (!this.tilePositions.containsKey(id)) continue;
            BlockPos tilePos = this.tilePositions.get(id);
            compound.func_74768_a("tileX" + id_str, tilePos.func_177958_n());
            compound.func_74768_a("tileY" + id_str, tilePos.func_177956_o());
            compound.func_74768_a("tileZ" + id_str, tilePos.func_177952_p());
            compound.func_74783_a("tileIDs", tileids);
            if (block_data == null || block_data.size() <= 0) continue;
            int[] xPos = new int[block_data.size()];
            int[] yPos = new int[block_data.size()];
            int[] zPos = new int[block_data.size()];
            int[] meta = new int[block_data.size()];
            int[] ids = new int[block_data.size()];
            for (int i = 0; i < block_data.size(); ++i) {
                BlockData data = block_data.get(i);
                if (data == null) continue;
                BlockPos pos = data.getPos();
                int blockid = data.getId();
                int metaNum = data.getMeta();
                if (pos == null) continue;
                xPos[i] = pos.func_177958_n();
                yPos[i] = pos.func_177956_o();
                zPos[i] = pos.func_177952_p();
                meta[i] = metaNum;
                ids[i] = blockid;
            }
            compound.func_74783_a("xPos" + id_str, xPos);
            compound.func_74783_a("yPos" + id_str, yPos);
            compound.func_74783_a("zPos" + id_str, zPos);
            compound.func_74783_a("meta" + id_str, meta);
            compound.func_74783_a("ids" + id_str, ids);
        }
        return compound;
    }

    public static CustomWorldSavedData get(Level world) {
        MapStorage storage = world.getPerWorldStorage();
        CustomWorldSavedData instance = (CustomWorldSavedData)storage.func_75742_a(CustomWorldSavedData.class, DATA_NAME);
        if (instance == null) {
            instance = new CustomWorldSavedData();
            storage.func_75745_a(DATA_NAME, (WorldSavedData)instance);
        }
        return instance;
    }

    public void setBlockData(ArrayList<BlockData> block_data, BlockPos pos) {
        if (this.tilePositions.containsValue(pos)) {
            for (int id : this.tileIDs) {
                BlockPos tilePos = this.tilePositions.get(id);
                if (tilePos == null || !tilePos.equals((Object)pos)) continue;
                this.dataMap.put(id, block_data);
            }
        } else {
            Random rand = new Random();
            int randId = rand.nextInt();
            while (this.tileIDs.contains(randId) || randId == -1) {
                randId = rand.nextInt();
            }
            this.tileIDs.add(randId);
            this.tilePositions.put(randId, pos);
            this.dataMap.put(randId, block_data);
        }
        this.func_76185_a();
    }

    public ArrayList<BlockData> getBlockData(BlockPos pos) {
        if (this.tilePositions.containsValue(pos)) {
            for (int id : this.tileIDs) {
                BlockPos tilePos = this.tilePositions.get(id);
                if (tilePos == null || !tilePos.equals((Object)pos)) continue;
                return this.dataMap.get(id);
            }
        }
        return null;
    }

    public void clearBlockData(BlockPos pos) {
        if (this.tilePositions.containsValue(pos)) {
            int toRemove = -1;
            for (int id : this.tileIDs) {
                BlockPos tilePos = this.tilePositions.get(id);
                if (tilePos == null || !tilePos.equals((Object)pos)) continue;
                toRemove = id;
                break;
            }
            if (toRemove != -1) {
                this.dataMap.remove(toRemove);
                this.tilePositions.remove(toRemove);
                this.tileIDs.remove((Object)toRemove);
            }
        }
    }
}

