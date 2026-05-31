/*
 * Decompiled with CFR 0.152.
 */
package xol.lostinfinity.dimension.data;

public class ChunkPairing {
    private int chunkPairX;
    private int chunkPairZ;

    public ChunkPairing(int x, int z) {
        this.chunkPairX = x;
        this.chunkPairZ = z;
    }

    public int chunkX() {
        return this.chunkPairX;
    }

    public int chunkZ() {
        return this.chunkPairZ;
    }

    public boolean sameChunkAs(ChunkPairing compareChunk) {
        return compareChunk.chunkZ() == this.chunkPairZ && compareChunk.chunkX() == this.chunkPairX;
    }
}

