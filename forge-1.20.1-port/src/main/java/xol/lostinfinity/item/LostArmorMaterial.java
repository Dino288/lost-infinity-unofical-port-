package xol.lostinfinity.item;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import xol.lostinfinity.LostInfinity;

public final class LostArmorMaterial implements ArmorMaterial {
    private static final int[] DURABILITY_PER_SLOT = new int[] {13, 15, 16, 11};
    private final String name;
    private final int durabilityMultiplier;
    private final Map<ArmorItem.Type, Integer> defenses;
    private final int enchantmentValue;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;

    public LostArmorMaterial(String name, int durabilityMultiplier, int bootsDefense, int leggingsDefense, int chestplateDefense, int helmetDefense, int enchantmentValue, float toughness, float knockbackResistance) {
        this.name = LostInfinity.MODID + ":" + name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.defenses = new EnumMap<>(ArmorItem.Type.class);
        this.defenses.put(ArmorItem.Type.BOOTS, bootsDefense);
        this.defenses.put(ArmorItem.Type.LEGGINGS, leggingsDefense);
        this.defenses.put(ArmorItem.Type.CHESTPLATE, chestplateDefense);
        this.defenses.put(ArmorItem.Type.HELMET, helmetDefense);
        this.enchantmentValue = enchantmentValue;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = () -> Ingredient.EMPTY;
    }

    @Override
    public int getDurabilityForType(ArmorItem.Type type) {
        return DURABILITY_PER_SLOT[type.ordinal()] * this.durabilityMultiplier;
    }

    @Override
    public int getDefenseForType(ArmorItem.Type type) {
        return this.defenses.getOrDefault(type, 0);
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ARMOR_EQUIP_DIAMOND;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
