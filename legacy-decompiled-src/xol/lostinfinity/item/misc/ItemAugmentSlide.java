/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  mezz.jei.api.recipe.IIngredientType
 */
package xol.lostinfinity.item.misc;

import mezz.jei.api.recipe.IIngredientType;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.TabsInit;
import xol.lostinfinity.item.basics.ItemBasicDescription;

public class ItemAugmentSlide
extends ItemBasicDescription {
    public static final IIngredientType<ItemAugmentSlide> SLIDE = () -> ItemAugmentSlide.class;
    public final SlideType type;

    public ItemAugmentSlide(SlideType type) {
        super("augment_slide_" + type.registryName, TabsInit.TAB_AUXMATS, (Object)((Object)TextFmt.Green) + "Used in the Augmentor with an Augmenticon Box.\n" + (Object)((Object)TextFmt.Red) + type.description);
        this.func_77625_d(1);
        this.type = type;
    }

    public static enum SlideType {
        DASH("dash", "Ability: Dash"),
        SLAM("slam", "Ability: Ground Slam"),
        INVIS("invisibility", "Ability: Invisbility"),
        FORCEFIELD("forcefield", "Ability: Projectile Forcefield"),
        TELEPORT("teleport", "Ability: Teleport"),
        HEAL("heal", "Ability: Life Restore"),
        HURT("hurt", "Ability: Instant Damage"),
        SUMMON("summon", "Ability: Summon Globoon"),
        BLIGHT("blight", "Ability: Blight"),
        PLAGUE("plague", "Ability: Plague"),
        EMP("emp", "Ability: EMP"),
        SHATTER("shatter", "Ability: Shatter"),
        TETHER("tether", "Ability: Tether"),
        UNLEASH("unleash", "Ability: Unleash"),
        GRAVITY("gravity", "Ability: Gravity"),
        NIGHTMARES("nightmares", "Ability: Nightmares"),
        EXPLOSIVE("explosive", "Ability: Explosive"),
        TRAILING("trailing", "Ability: Trailing"),
        DESTRUCTIVE("destructive", "Ability: Destructive"),
        REGENERATIVE("regenerative", "Ability: Regenerative");

        public final String registryName;
        public final String description;

        private SlideType(String registryName, String description) {
            this.registryName = registryName;
            this.description = description;
        }
    }
}

