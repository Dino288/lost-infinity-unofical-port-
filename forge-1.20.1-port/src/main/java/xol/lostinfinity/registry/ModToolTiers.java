package xol.lostinfinity.registry;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public final class ModToolTiers {
    public static final Tier LOST_INFINITY = new Tier() {
        @Override
        public int getUses() {
            return 4096;
        }

        @Override
        public float getSpeed() {
            return 12.0F;
        }

        @Override
        public float getAttackDamageBonus() {
            return 5.0F;
        }

        @Override
        public int getLevel() {
            return 4;
        }

        @Override
        public int getEnchantmentValue() {
            return 22;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.EMPTY;
        }
    };

    private ModToolTiers() {
    }
}
