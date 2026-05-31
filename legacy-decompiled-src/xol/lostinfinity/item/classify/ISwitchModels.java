/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.item.IItemPropertyGetter
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.world.World
 */
package xol.lostinfinity.item.classify;

import javax.annotation.Nullable;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

public interface ISwitchModels {
    default public void setModelSwitch(final String overrideName, Item item, final int totalValues) {
        item.func_185043_a(new ResourceLocation("lostinfinity", overrideName), new IItemPropertyGetter(){

            public float func_185085_a(ItemStack stack, @Nullable Level worldIn, @Nullable LivingEntity entityIn) {
                return ISwitchModels.this.getProperty(stack, entityIn, overrideName + "_data", totalValues - 1);
            }
        });
    }

    default public float getProperty(ItemStack stack, @Nullable LivingEntity entityIn, String name, int divisor) {
        if (entityIn == null) {
            return 0.0f;
        }
        if (!stack.func_190926_b() && stack.func_77973_b() instanceof ISwitchModels) {
            if (stack.func_77942_o()) {
                float initial_data = (float)stack.func_77978_p().func_74762_e(name) / (float)divisor;
                int temp = (int)((double)initial_data * 100.0);
                float char_data = (float)((double)temp / 100.0);
                return char_data;
            }
            return 0.0f;
        }
        return 0.0f;
    }
}

