/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.inventory.IInventory
 *  net.minecraft.inventory.ItemStackHelper
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.NBTBase
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.nbt.NBTTagList
 *  net.minecraft.network.NetworkManager
 *  net.minecraft.network.play.server.SPacketUpdateBlockEntity
 *  net.minecraft.tileentity.BlockEntity
 *  net.minecraft.util.ITickable
 *  net.minecraft.util.NonNullList
 *  net.minecraft.util.math.Mth
 */
package xol.lostinfinity.block.tileentity;

import javax.annotation.Nullable;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.util.ITickable;
import net.minecraft.core.NonNullList;
import net.minecraft.util.Mth;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.mob.entity.starforge.EntityDusker;

public class BlockEntityCompressionTable
extends BlockEntity
implements IInventory,
ITickable {
    public NonNullList<ItemStack> compressionItemStacks = NonNullList.func_191197_a((int)3, (Object)ItemStack.field_190927_a);
    private int progress = -1;
    private static final byte PROGRESS = 0;

    public BlockEntityCompressionTable() {
        this.func_174888_l();
    }

    public void func_145839_a(CompoundTag compound) {
        int NBT_TYPE_COMPOUND = 10;
        NBTTagList dataForSlots = compound.func_150295_c("Items", 10);
        this.compressionItemStacks = NonNullList.func_191197_a((int)3, (Object)ItemStack.field_190927_a);
        for (int i = 0; i < dataForSlots.func_74745_c(); ++i) {
            CompoundTag dataForSlot = dataForSlots.func_150305_b(i);
            byte slotNumber = dataForSlot.func_74771_c("Slot");
            if (slotNumber < 0 || slotNumber >= this.compressionItemStacks.size()) continue;
            this.compressionItemStacks.set((int)slotNumber, (Object)new ItemStack(dataForSlot));
        }
        this.progress = compound.func_74762_e("Progress");
        super.func_145839_a(compound);
    }

    public CompoundTag func_189515_b(CompoundTag compound) {
        NBTTagList dataForSlots = new NBTTagList();
        for (int i = 0; i < this.compressionItemStacks.size(); ++i) {
            if (((ItemStack)this.compressionItemStacks.get(i)).func_190926_b()) continue;
            CompoundTag dataForSlot = new CompoundTag();
            dataForSlot.func_74774_a("Slot", (byte)i);
            ((ItemStack)this.compressionItemStacks.get(i)).func_77955_b(dataForSlot);
            dataForSlots.func_74742_a((NBTBase)dataForSlot);
        }
        compound.func_74782_a("Items", (NBTBase)dataForSlots);
        compound.func_74768_a("Progress", this.progress);
        return super.func_189515_b(compound);
    }

    public int updateProgress(int increment) {
        this.progress = Math.min(this.progress + increment, 500);
        this.func_70296_d();
        return this.progress;
    }

    public void updateSlot(int index, ItemStack itemStack) {
        this.compressionItemStacks.set(index, (Object)itemStack);
        this.func_70296_d();
    }

    public int getProgress() {
        return this.progress;
    }

    public int setProgress(int newValue) {
        this.progress = newValue;
        this.func_70296_d();
        return this.progress;
    }

    public double getProgressAsFraction() {
        return Mth.func_151237_a((double)(this.getProgress() >= 0 ? (double)this.getProgress() / 500.0 : 0.0), (double)0.0, (double)1.0);
    }

    public ItemStack getResult() {
        return (ItemStack)this.compressionItemStacks.get(2);
    }

    public void func_73660_a() {
        boolean flag = this.progress > -1;
        boolean flag1 = false;
        if (flag) {
            ++this.progress;
        }
        if (!this.field_145850_b.field_72995_K) {
            ItemStack itemstack = (ItemStack)this.compressionItemStacks.get(0);
            if ((flag || !itemstack.func_190926_b()) && this.canProgress()) {
                if (this.progress % 100 == 0 && this.progress < 500) {
                    EntityDusker dusker = new EntityDusker(this.field_145850_b);
                    dusker.func_70107_b(this.field_174879_c.func_177958_n(), this.field_174879_c.func_177956_o() + 13, this.field_174879_c.func_177952_p());
                    this.field_145850_b.func_72838_d((Entity)dusker);
                }
                if (this.progress == -1 && this.canProgress()) {
                    this.progress = 0;
                    this.compressionItemStacks.set(2, (Object)itemstack.func_77946_l());
                    flag1 = true;
                }
                if (this.progress >= 500 && this.canProgress()) {
                    this.compressItem();
                    this.progress = -1;
                    flag1 = true;
                }
            }
            if (!this.canProgress()) {
                if (this.progress != -1) {
                    this.progress = -1;
                }
                flag1 = true;
            }
        }
        if (flag1) {
            this.func_70296_d();
        }
    }

    public ItemStack getResultFor(ItemStack iteminput1) {
        ItemStack result = ItemStack.field_190927_a;
        if (iteminput1.func_77973_b().equals(ItemInit.astralliumIngot)) {
            result = new ItemStack(ItemInit.astralliumCondensed);
        } else if (iteminput1.func_77973_b().equals(ItemInit.crystoniumIngot)) {
            result = new ItemStack(ItemInit.crystoniumCondensed);
        } else if (iteminput1.func_77973_b().equals(ItemInit.detheriumIngot)) {
            result = new ItemStack(ItemInit.detheriumCondensed);
        } else if (iteminput1.func_77973_b().equals(ItemInit.emberiumIngot)) {
            result = new ItemStack(ItemInit.emberiumCondensed);
        } else if (iteminput1.func_77973_b().equals(ItemInit.hextoriumIngot)) {
            result = new ItemStack(ItemInit.hextoriumCondensed);
        } else if (iteminput1.func_77973_b().equals(ItemInit.incadiumIngot)) {
            result = new ItemStack(ItemInit.incadiumCondensed);
        } else if (iteminput1.func_77973_b().equals(ItemInit.kylaxiumIngot)) {
            result = new ItemStack(ItemInit.kylaxiumCondensed);
        } else if (iteminput1.func_77973_b().equals(ItemInit.noxeriumIngot)) {
            result = new ItemStack(ItemInit.noxeriumCondensed);
        } else if (iteminput1.func_77973_b().equals(ItemInit.olysiumIngot)) {
            result = new ItemStack(ItemInit.olysiumCondensed);
        } else if (iteminput1.func_77973_b().equals(ItemInit.velloriumIngot)) {
            result = new ItemStack(ItemInit.velloriumCondensed);
        } else if (iteminput1.func_77973_b().equals(ItemInit.xeroviumIngot)) {
            result = new ItemStack(ItemInit.xeroviumCondensed);
        } else if (iteminput1.func_77973_b().equals(ItemInit.phytrosiumIngot)) {
            result = new ItemStack(ItemInit.phytrosiumCondensed);
        } else if (iteminput1.func_77973_b().equals(ItemInit.kyvoriumIngot)) {
            result = new ItemStack(ItemInit.kyvoriumCondensed);
        } else if (iteminput1.func_77973_b().equals(ItemInit.biosynthiumIngot)) {
            result = new ItemStack(ItemInit.biosynthiumCondensed);
        } else if (iteminput1.func_77973_b().equals(ItemInit.maliciumIngot)) {
            result = new ItemStack(ItemInit.maliciumCondensed);
        } else if (iteminput1.func_77973_b().equals(ItemInit.etheriumIngot)) {
            result = new ItemStack(ItemInit.etheriumCondensed);
        } else if (iteminput1.func_77973_b().equals(ItemInit.polariumIngot)) {
            result = new ItemStack(ItemInit.polariumCondensed);
        }
        return result;
    }

    private void compressItem() {
        ItemStack result = this.getResultFor((ItemStack)this.compressionItemStacks.get(0));
        this.compressionItemStacks.set(2, (Object)ItemStack.field_190927_a);
        ItemStack output = (ItemStack)this.compressionItemStacks.get(1);
        boolean yes = true;
        if (output.func_190926_b()) {
            this.compressionItemStacks.set(1, (Object)result.func_77946_l());
        } else if (output.func_77973_b() == result.func_77973_b()) {
            output.func_190917_f(1);
        } else {
            yes = false;
        }
        if (yes) {
            ((ItemStack)this.compressionItemStacks.get(0)).func_190918_g(25);
            if (!this.field_145850_b.field_72995_K) {
                this.field_145850_b.func_175718_b(1030, this.field_174879_c, 0);
            }
        }
    }

    public boolean canProgress() {
        return !((ItemStack)this.compressionItemStacks.get(0)).func_190926_b() && ((ItemStack)this.compressionItemStacks.get(0)).func_190916_E() >= 25;
    }

    @Nullable
    public SPacketUpdateBlockEntity func_189518_D_() {
        CompoundTag updateTag = this.func_189517_E_();
        boolean METADATA = false;
        return new SPacketUpdateBlockEntity(this.field_174879_c, 0, updateTag);
    }

    public void onDataPacket(NetworkManager net, SPacketUpdateBlockEntity packet) {
        CompoundTag updateTag = packet.func_148857_g();
        this.handleUpdateTag(updateTag);
    }

    public CompoundTag func_189517_E_() {
        CompoundTag nbtTagCompound = new CompoundTag();
        this.func_189515_b(nbtTagCompound);
        return nbtTagCompound;
    }

    public void handleUpdateTag(CompoundTag tag) {
        this.func_145839_a(tag);
    }

    public int func_174887_a_(int id) {
        if (id == 0) {
            return this.progress;
        }
        System.err.println("Invalid field ID in BlockEntityCompressionTable#getField:" + id);
        return 0;
    }

    public void func_174885_b(int id, int value) {
        if (id == 0) {
            this.progress = value;
        } else {
            System.err.println("Invalid field ID in BlockEntityCompressionTable#setField:" + id);
        }
    }

    public int func_174890_g() {
        return 1;
    }

    public void func_174888_l() {
        this.compressionItemStacks = NonNullList.func_191197_a((int)3, (Object)ItemStack.field_190927_a);
    }

    public boolean func_94041_b(int slotIndex, ItemStack itemstack) {
        return true;
    }

    public int func_70302_i_() {
        return this.compressionItemStacks.size();
    }

    public boolean func_191420_l() {
        return this.compressionItemStacks.stream().allMatch(it -> it.func_190926_b());
    }

    public ItemStack func_70301_a(int index) {
        return (ItemStack)this.compressionItemStacks.get(index);
    }

    public ItemStack func_70298_a(int index, int count) {
        return ItemStackHelper.func_188382_a(this.compressionItemStacks, (int)index, (int)count);
    }

    public ItemStack func_70304_b(int index) {
        return ItemStackHelper.func_188383_a(this.compressionItemStacks, (int)index);
    }

    public void func_70299_a(int index, ItemStack stack) {
        ItemStack itemstack = (ItemStack)this.compressionItemStacks.get(index);
        boolean flag = !stack.func_190926_b() && stack.func_77969_a(itemstack) && ItemStack.func_77970_a((ItemStack)stack, (ItemStack)itemstack);
        this.compressionItemStacks.set(index, (Object)stack);
        if (stack.func_190916_E() > this.func_70297_j_()) {
            stack.func_190920_e(this.func_70297_j_());
        }
        if (index == 0 && !flag) {
            this.progress = 0;
            this.func_70296_d();
        }
    }

    public int func_70297_j_() {
        return 64;
    }

    public boolean func_70300_a(Player player) {
        if (this.field_145850_b.func_175625_s(this.field_174879_c) != this) {
            return false;
        }
        double X_CENTRE_OFFSET = 0.5;
        double Y_CENTRE_OFFSET = 0.5;
        double Z_CENTRE_OFFSET = 0.5;
        double MAXIMUM_DISTANCE_SQ = 64.0;
        return player.func_70092_e((double)this.field_174879_c.func_177958_n() + 0.5, (double)this.field_174879_c.func_177956_o() + 0.5, (double)this.field_174879_c.func_177952_p() + 0.5) < 64.0;
    }

    public void func_174889_b(Player player) {
    }

    public void func_174886_c(Player player) {
    }

    public String func_70005_c_() {
        return null;
    }

    public boolean func_145818_k_() {
        return false;
    }
}

