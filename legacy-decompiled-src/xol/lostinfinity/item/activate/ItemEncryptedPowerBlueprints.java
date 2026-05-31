/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.block.Block
 *  net.minecraft.client.util.ITooltipFlag
 *  net.minecraft.creativetab.CreativeModeTab
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.util.InteractionResultHolder
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.item.activate;

import java.util.List;
import java.util.Random;
import javax.annotation.Nullable;
import net.minecraft.world.level.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.item.basics.ItemBasic;

public class ItemEncryptedPowerBlueprints
extends ItemBasic {
    private int first = 99;
    private int second = 99;
    private int third = 99;
    private int complete = 0;
    private static Block[] riddleBlocks = null;
    private static final String[] riddles = new String[]{"in an area light levels are extremely low", "in an ecosystem containing light absorbing creatures", "contained in a place with phosphorescent ores", "located in a section of the environment which is ripe with bioluminescent fauna", "triangulated in a well lit cave with blue walls", "close to a station for creature experiments", "surrounded by large vines and flora", "near to pyrokinetic plant species. Take precautions", "found by various fungal growths. Be warned of audiokinetic life-forms", "found nearby interesting ocular tentacle-like formations.", "hard to reach among the many turns and navigational issues in this section", "close to rock eating organisms which have a crystalizing digestive process", "placed at the root level of the tree specimen", "located by the ores that been encapsulated by wood growth", "close to dangerous humanoids which apply amplifying electricity to their prey", "in place designed for manufacturing", "found by neosteel structures", "located by a station for processing", "in Astrorock tunnels", "nearby dangerous ribbed creatures", "located in the central shafts", "located in a hollow area inside the tree", "overrun by hive insects, however they appear docile", "found behind a malleable section of sweet sticky substance", "inside a crystallized section", "located in a crevice formation", "by a device with a function for fabrication", "in the main quarry area", "in an area riddled with many different material ores", "located in a section with many glowing weeds"};

    public ItemEncryptedPowerBlueprints(String regName, CreativeModeTab tab) {
        super(regName, tab);
        this.func_77625_d(1);
    }

    public void initRiddleBlocks() {
        riddleBlocks = new Block[]{BlockInit.nightvines, BlockInit.lumioRock, BlockInit.sunderwood, BlockInit.enghouledAstrorock, BlockInit.cloviniteOre, BlockInit.neosteelBlack, BlockInit.astroSteel, BlockInit.beeHive, BlockInit.crystallizedAstrorockBlue, BlockInit.glowingWeeds};
    }

    public InteractionResultHolder<ItemStack> func_77659_a(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack stack;
        if (riddleBlocks == null) {
            this.initRiddleBlocks();
        }
        if (!(stack = playerIn.func_184586_b(handIn)).func_77942_o()) {
            this.generateRiddles(stack);
        }
        if (!worldIn.field_72995_K) {
            this.first = this.getFirst(stack);
            this.second = this.getSecond(stack);
            this.third = this.getThird(stack);
            this.complete = this.getCompletion(stack);
            switch (this.complete) {
                case 0: {
                    playerIn.func_145747_a((Component)new Component((Object)((Object)TextFmt.Italic) + "The first generator is " + this.getRiddle(this.first)));
                    break;
                }
                case 1: {
                    playerIn.func_145747_a((Component)new Component((Object)((Object)TextFmt.Italic) + "The second generator is " + this.getRiddle(this.second)));
                    break;
                }
                case 2: {
                    playerIn.func_145747_a((Component)new Component((Object)((Object)TextFmt.Italic) + "The third generator is " + this.getRiddle(this.third)));
                    break;
                }
                case 3: {
                    playerIn.func_145747_a((Component)new Component((Object)((Object)TextFmt.Italic) + "You have connected all the generators, return to the main power terminal."));
                }
            }
        }
        return super.func_77659_a(worldIn, playerIn, handIn);
    }

    private String getRiddle(int riddle) {
        if (riddles[riddle] != null) {
            return riddles[riddle];
        }
        return "";
    }

    public int getCompletion(ItemStack stack) {
        return stack.func_77978_p().func_74762_e("Complete");
    }

    public int getFirst(ItemStack stack) {
        return stack.func_77978_p().func_74762_e("First");
    }

    public int getSecond(ItemStack stack) {
        return stack.func_77978_p().func_74762_e("Second");
    }

    public int getThird(ItemStack stack) {
        return stack.func_77978_p().func_74762_e("Third");
    }

    private Block getRiddleBlock(int riddle) {
        int index = (int)Math.floor(riddle / 3);
        if (riddleBlocks[index] != null) {
            return riddleBlocks[index];
        }
        return null;
    }

    private void generateRiddles(ItemStack stack) {
        stack.func_77982_d(new CompoundTag());
        Random rand = new Random();
        this.first = rand.nextInt(30);
        this.second = rand.nextInt(30);
        this.third = rand.nextInt(30);
        while (this.second == this.first) {
            this.second = rand.nextInt(30);
        }
        while (this.third == this.second || this.third == this.first) {
            this.third = rand.nextInt(30);
        }
        this.complete = 0;
        stack.func_77978_p().func_74768_a("First", this.first);
        stack.func_77978_p().func_74768_a("Second", this.second);
        stack.func_77978_p().func_74768_a("Third", this.third);
        stack.func_77978_p().func_74768_a("Complete", this.complete);
    }

    public void progress(ItemStack stack, Player player) {
        int complete = this.getCompletion(stack);
        if (complete < 3) {
            stack.func_77978_p().func_74768_a("Complete", ++complete);
            player.func_145747_a((Component)new Component((Object)((Object)TextFmt.Italic) + "You have connected a power generator to the main grid!"));
        }
        if (complete == 3) {
            player.func_145747_a((Component)new Component((Object)((Object)TextFmt.Italic) + "You have connected all the generators, return to the main power terminal!"));
        }
    }

    public boolean matchBlock(ItemStack held, BlockPos pos, Level world) {
        Block riddleBlock;
        int complete = this.getCompletion(held);
        int first = this.getFirst(held);
        int second = this.getSecond(held);
        int third = this.getThird(held);
        switch (complete) {
            case 0: {
                riddleBlock = this.getRiddleBlock(first);
                break;
            }
            case 1: {
                riddleBlock = this.getRiddleBlock(second);
                break;
            }
            case 2: {
                riddleBlock = this.getRiddleBlock(third);
                break;
            }
            default: {
                return false;
            }
        }
        for (int i = 0; i < 5; ++i) {
            Block block = world.func_180495_p(pos.func_177982_a(0, -i, 0)).func_177230_c();
            if (!block.equals(riddleBlock)) continue;
            return true;
        }
        return false;
    }

    @SideOnly(value=Side.CLIENT)
    public void func_77624_a(ItemStack stack, @Nullable Level worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add((Object)((Object)TextFmt.Light_Purple) + "Encrypted Blueprints Detailing the Main Power Grid.");
    }
}

