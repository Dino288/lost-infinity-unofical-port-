/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.item.ItemStack
 *  net.minecraft.potion.Potion
 *  net.minecraft.util.ResourceLocation
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.util;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PotionBasic
extends Potion {
    private boolean negativeLostEffect = false;
    private int potionPage = 0;

    public PotionBasic(String name, boolean isLostBadEffect, int liquidColorIn, int x, int y) {
        super(false, liquidColorIn);
        this.negativeLostEffect = isLostBadEffect;
        this.potionPage = Math.floorDiv(x, 24);
        this.func_76390_b("effect." + name);
        this.func_76399_b(x - this.potionPage * 24, y);
        this.setRegistryName(new ResourceLocation("lostinfinity:" + name));
    }

    public boolean negativeLostEffect() {
        return this.negativeLostEffect;
    }

    @SideOnly(value=Side.CLIENT)
    public boolean func_76400_d() {
        switch (this.potionPage) {
            case 0: {
                Minecraft.func_71410_x().func_110434_K().func_110577_a(new ResourceLocation("lostinfinity", "textures/gui/potion_icons.png"));
                break;
            }
            case 1: {
                Minecraft.func_71410_x().func_110434_K().func_110577_a(new ResourceLocation("lostinfinity", "textures/gui/potion_icons2.png"));
                break;
            }
        }
        return true;
    }

    public List<ItemStack> getCurativeItems() {
        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
        return ret;
    }
}

