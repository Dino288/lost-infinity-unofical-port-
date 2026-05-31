/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.item.ItemEntity
 *  net.minecraft.entity.monster.Monster
 *  net.minecraft.entity.player.Player
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.util.DamageSource
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.galaxy;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.Vec3;
import net.minecraft.core.Vec3i;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.misc.BlockAstroBarrier;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.mob.entity.galaxy.EntityLaserSpire;
import xol.lostinfinity.projectile.entity.EntityGalaxyBlast;
import xol.lostinfinity.util.coordinates.GalaxyCoordinates;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntityGalaxySpire
extends Monster
implements IMaxAttack {
    private int crystalsGiven = 0;
    private int challengeState = 0;
    private int itemType = 0;
    private int gameStyle = 0;
    private boolean elite_mode = false;

    public EntityGalaxySpire(Level worldIn) {
        super(worldIn);
        this.func_70105_a(3.5f, 6.0f);
        this.func_184224_h(true);
    }

    public void func_110147_ax() {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(10000.0);
        this.func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a(1.0);
    }

    public void setItemDrop(int d) {
        this.itemType = d;
    }

    public void setElite() {
        this.elite_mode = true;
    }

    public boolean getElite() {
        return this.elite_mode;
    }

    public void setGameStyle(int style) {
        this.gameStyle = style;
    }

    public int getGameStyle() {
        return this.gameStyle;
    }

    public boolean func_70104_M() {
        return false;
    }

    private AABB getMyAABB() {
        switch (this.gameStyle) {
            case 1: {
                return GalaxyCoordinates.getBlueAABB();
            }
            case 2: {
                return GalaxyCoordinates.getGreenAABB();
            }
            case 3: {
                return GalaxyCoordinates.getPinkAABB();
            }
            case 4: {
                return GalaxyCoordinates.getYellowAABB();
            }
            case 5: {
                return GalaxyCoordinates.getSwordAABB();
            }
            case 6: {
                return GalaxyCoordinates.getBombAABB();
            }
            case 7: {
                return GalaxyCoordinates.getKnifeAABB();
            }
        }
        return GalaxyCoordinates.getBlueAABB();
    }

    private void messagePlayers(String str) {
        for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.getMyAABB())) {
            near_pl.func_145747_a((Component)new Component(str));
        }
    }

    private void randomizeTarget() {
        int bl_count;
        AABB box = this.getMyAABB();
        double height = box.field_72338_b + 6.0;
        int target_choose = this.field_70146_Z.nextInt(this.getElite() ? 8 : 4);
        for (bl_count = 0; bl_count < 4; ++bl_count) {
            this.field_70170_p.func_175656_a(new BlockPos(box.field_72340_a + 1.0, height + (double)Math.floorDiv(bl_count, 2), box.field_72339_c + 15.0 + (double)(bl_count % 2)), target_choose == 0 ? BlockInit.galDungeonTarget.func_176223_P() : BlockInit.astroSteel.func_176223_P());
        }
        for (bl_count = 0; bl_count < 4; ++bl_count) {
            this.field_70170_p.func_175656_a(new BlockPos(box.field_72336_d - 1.0, height + (double)Math.floorDiv(bl_count, 2), box.field_72339_c + 15.0 + (double)(bl_count % 2)), target_choose == 1 ? BlockInit.galDungeonTarget.func_176223_P() : BlockInit.astroSteel.func_176223_P());
        }
        for (bl_count = 0; bl_count < 4; ++bl_count) {
            this.field_70170_p.func_175656_a(new BlockPos(box.field_72340_a + 15.0 + (double)(bl_count % 2), height + (double)Math.floorDiv(bl_count, 2), box.field_72339_c + 1.0), target_choose == 2 ? BlockInit.galDungeonTarget.func_176223_P() : BlockInit.astroSteel.func_176223_P());
        }
        for (bl_count = 0; bl_count < 4; ++bl_count) {
            this.field_70170_p.func_175656_a(new BlockPos(box.field_72340_a + 15.0 + (double)(bl_count % 2), height + (double)Math.floorDiv(bl_count, 2), box.field_72334_f - 1.0), target_choose == 3 ? BlockInit.galDungeonTarget.func_176223_P() : BlockInit.astroSteel.func_176223_P());
        }
        if (this.getElite()) {
            for (bl_count = 0; bl_count < 4; ++bl_count) {
                this.field_70170_p.func_175656_a(new BlockPos(box.field_72340_a + 1.0, height + (double)Math.floorDiv(bl_count, 2), box.field_72339_c + 47.0 + (double)(bl_count % 2)), target_choose == 4 ? BlockInit.galDungeonTarget.func_176223_P() : BlockInit.astroSteel.func_176223_P());
            }
            for (bl_count = 0; bl_count < 4; ++bl_count) {
                this.field_70170_p.func_175656_a(new BlockPos(box.field_72336_d - 1.0, height + (double)Math.floorDiv(bl_count, 2), box.field_72339_c + 47.0 + (double)(bl_count % 2)), target_choose == 5 ? BlockInit.galDungeonTarget.func_176223_P() : BlockInit.astroSteel.func_176223_P());
            }
            for (bl_count = 0; bl_count < 4; ++bl_count) {
                this.field_70170_p.func_175656_a(new BlockPos(box.field_72340_a + 47.0 + (double)(bl_count % 2), height + (double)Math.floorDiv(bl_count, 2), box.field_72339_c + 1.0), target_choose == 6 ? BlockInit.galDungeonTarget.func_176223_P() : BlockInit.astroSteel.func_176223_P());
            }
            for (bl_count = 0; bl_count < 4; ++bl_count) {
                this.field_70170_p.func_175656_a(new BlockPos(box.field_72340_a + 47.0 + (double)(bl_count % 2), height + (double)Math.floorDiv(bl_count, 2), box.field_72334_f - 1.0), target_choose == 7 ? BlockInit.galDungeonTarget.func_176223_P() : BlockInit.astroSteel.func_176223_P());
            }
        }
    }

    public void func_70636_d() {
        super.func_70636_d();
        if (this.func_110143_aJ() > 0.0f) {
            this.func_70606_j(this.func_110138_aP());
        }
        this.field_70143_R = -1.0f;
        if (!this.field_70170_p.field_72995_K) {
            if (this.field_70173_aa % 15 == 0) {
                this.hurtFlying();
            }
            int targetInterval = 200;
            targetInterval = !this.getElite() ? (targetInterval -= this.challengeState >= 1 ? 70 : 0) : 400;
            if ((this.field_70173_aa + 195) % targetInterval == 0) {
                this.randomizeTarget();
                this.playSoundToPlayers(SoundInit.SPIRE_TARGET);
            }
            if (this.field_70173_aa % (40 - (this.challengeState == 3 ? 20 : 0)) == 0) {
                boolean fired = false;
                for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.getMyAABB())) {
                    if (near_pl.func_184812_l_() || !(this.func_70032_d((Entity)near_pl) > 6.0f)) continue;
                    Vec3 vec3d = this.func_70676_i(1.0f);
                    double makeX = (this.func_174813_aQ().field_72340_a + this.func_174813_aQ().field_72336_d) / 2.0;
                    double makeY = this.field_70163_u + 5.0;
                    double makeZ = (this.func_174813_aQ().field_72339_c + this.func_174813_aQ().field_72334_f) / 2.0;
                    double d2 = near_pl.field_70165_t - makeX;
                    double d3 = 0.5 + (near_pl.func_174813_aQ().field_72338_b + near_pl.func_174813_aQ().field_72337_e) / 2.0 - makeY;
                    double d4 = near_pl.field_70161_v - makeZ;
                    EntityGalaxyBlast shot = new EntityGalaxyBlast(this.field_70170_p, makeX, makeY, makeZ);
                    shot.setThrower((LivingEntity)this);
                    shot.func_70186_c(d2, d3, d4, this.getElite() ? 2.0f : 1.0f, 0.0f);
                    this.field_70170_p.func_72838_d((Entity)shot);
                    fired = true;
                }
                if (fired) {
                    this.playSoundToPlayers(SoundInit.GALAXYFIRE);
                }
            }
        }
    }

    private void playSoundToPlayers(SoundEvent sound) {
        for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.getMyAABB())) {
            this.field_70170_p.func_184133_a(null, near_pl.func_180425_c(), sound, SoundSource.MASTER, 1.0f, 1.0f);
        }
    }

    public boolean func_184645_a(Player player, InteractionHand hand) {
        ItemStack itemstack = player.func_184586_b(hand);
        if (itemstack.func_77973_b().equals(ItemInit.chargedGalaxyCrystal)) {
            this.clearGroundCrystals();
            if (!player.func_184812_l_()) {
                for (int i = 0; i < player.field_71071_by.func_70302_i_(); ++i) {
                    if (player.field_71071_by.func_70301_a(i).func_77973_b() != ItemInit.chargedGalaxyCrystal) continue;
                    player.field_71071_by.func_70299_a(i, ItemStack.field_190927_a);
                }
            }
            if (!player.field_70170_p.field_72995_K) {
                int rate;
                this.playSoundToPlayers(SoundEvents.field_187626_cN);
                ++this.crystalsGiven;
                int n = rate = this.elite_mode ? 4 : 2;
                if (this.crystalsGiven % rate == 0) {
                    this.playSoundToPlayers(SoundInit.SPIRE_DIFFICULTY);
                    ++this.challengeState;
                    this.handleDifficulty();
                }
            }
            return true;
        }
        return false;
    }

    public void winChallenge() {
        if (!this.field_70170_p.field_72995_K) {
            for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.getMyAABB())) {
                BlockPos teleport_back = GalaxyCoordinates.galaxyDungeonEntry();
                near_pl.func_70634_a((double)teleport_back.func_177958_n(), (double)teleport_back.func_177956_o(), (double)teleport_back.func_177952_p());
                near_pl.field_70170_p.func_184133_a(null, new BlockPos((Vec3i)teleport_back), SoundEvents.field_187802_ec, SoundSource.MASTER, 2.0f, 1.0f);
                if (near_pl.func_191521_c(new ItemStack(this.getMyItem(), 1))) continue;
                ItemEntity reward = new ItemEntity(this.field_70170_p, near_pl.field_70165_t, near_pl.field_70163_u, near_pl.field_70161_v, new ItemStack(this.getMyItem()));
                reward.field_70159_w = 0.0;
                reward.field_70181_x = 0.0;
                reward.field_70179_y = 0.0;
                this.field_70170_p.func_72838_d((Entity)reward);
            }
            this.func_70106_y();
        }
    }

    private void handleDifficulty() {
        switch (this.challengeState) {
            case 1: {
                if (!this.getElite()) {
                    this.messagePlayers((Object)((Object)TextFmt.Italic) + "Targets now switch faster.");
                    break;
                }
                this.summonLaserSpires();
                this.messagePlayers((Object)((Object)TextFmt.Italic) + "Laser Spires have been summoned.");
                break;
            }
            case 2: {
                this.removeFloor();
                this.messagePlayers((Object)((Object)TextFmt.Italic) + "The floor has been removed.");
                break;
            }
            case 3: {
                if (!this.getElite()) {
                    this.messagePlayers((Object)((Object)TextFmt.Italic) + "The Spire now fires faster.");
                    break;
                }
                this.upgradeLaserSpires();
                this.messagePlayers((Object)((Object)TextFmt.Italic) + "EVERYTHING now fires faster.");
                break;
            }
            case 4: {
                this.winChallenge();
            }
        }
    }

    private void summonLaserSpires() {
        AABB aabb = this.getMyAABB();
        for (int i = 0; i < 4; ++i) {
            EntityLaserSpire spire = new EntityLaserSpire(this.field_70170_p);
            spire.func_70107_b(aabb.field_72340_a + 16.0 + 32.0 * Math.floor(i / 2), aabb.field_72338_b + 9.0, aabb.field_72339_c + 16.0 + (double)(32 * (i % 2)));
            spire.setGameStyle(this.gameStyle);
            this.field_70170_p.func_72838_d((Entity)spire);
        }
    }

    private void upgradeLaserSpires() {
        for (EntityLaserSpire spire : this.field_70170_p.func_72872_a(EntityLaserSpire.class, this.getMyAABB())) {
            spire.setFastFire();
        }
    }

    private void removeFloor() {
        AABB box = this.getMyAABB();
        int size = 32;
        if (this.getElite()) {
            size = 64;
        }
        for (int blx = 0; blx < size; ++blx) {
            for (int blz = 0; blz < size; ++blz) {
                BlockPos pos = new BlockPos(box.field_72340_a + (double)blx, box.field_72338_b, box.field_72339_c + (double)blz);
                if (!(this.field_70170_p.func_180495_p(pos).func_177230_c() instanceof BlockAstroBarrier)) continue;
                this.field_70170_p.func_175698_g(pos);
            }
        }
    }

    private void hurtFlying() {
        for (Player near_pl : this.field_70170_p.func_72872_a(Player.class, this.getMyAABB())) {
            if (near_pl.func_184812_l_() || !near_pl.field_71075_bZ.field_75100_b) continue;
            IMaxAttack.dealTrueDamage((Entity)this, (LivingEntity)near_pl, near_pl.func_110138_aP() - 1.0f);
            near_pl.func_145747_a((Component)new Component((Object)((Object)TextFmt.Dark_Red) + "FLIGHT DETECTED. DEALING SEVERE DAMAGE"));
        }
    }

    private void clearGroundCrystals() {
        for (ItemEntity item : this.field_70170_p.func_72872_a(ItemEntity.class, this.getMyAABB())) {
            if (!item.func_92059_d().func_77973_b().equals(ItemInit.chargedGalaxyCrystal)) continue;
            item.func_70106_y();
        }
    }

    private Item getMyItem() {
        switch (this.gameStyle) {
            case 1: {
                switch (this.itemType) {
                    case 0: {
                        return ItemInit.moonglowBlade;
                    }
                    case 1: {
                        return ItemInit.moonglowWand;
                    }
                    case 2: {
                        return ItemInit.moonglowThrowingKnife;
                    }
                    case 3: {
                        return ItemInit.moonglowBomb;
                    }
                }
                break;
            }
            case 2: {
                switch (this.itemType) {
                    case 0: {
                        return ItemInit.aurorusBlade;
                    }
                    case 1: {
                        return ItemInit.aurorusWand;
                    }
                    case 2: {
                        return ItemInit.aurorusThrowingKnife;
                    }
                    case 3: {
                        return ItemInit.aurorusBomb;
                    }
                }
                break;
            }
            case 3: {
                switch (this.itemType) {
                    case 0: {
                        return ItemInit.novacronBlade;
                    }
                    case 1: {
                        return ItemInit.novacronWand;
                    }
                    case 2: {
                        return ItemInit.novacronThrowingKnife;
                    }
                    case 3: {
                        return ItemInit.novacronBomb;
                    }
                }
                break;
            }
            case 4: {
                switch (this.itemType) {
                    case 0: {
                        return ItemInit.starfireBlade;
                    }
                    case 1: {
                        return ItemInit.starfireWand;
                    }
                    case 2: {
                        return ItemInit.starfireThrowingKnife;
                    }
                    case 3: {
                        return ItemInit.starfireBomb;
                    }
                }
                break;
            }
            case 5: {
                return ItemInit.incarnationOfTheSword;
            }
            case 6: {
                return ItemInit.incarnationOfTheBomb;
            }
            case 7: {
                return ItemInit.incarnationOfTheKnife;
            }
        }
        return ItemInit.starfireBlade;
    }

    public void func_70014_b(CompoundTag tag) {
        super.func_70014_b(tag);
        tag.func_74768_a("Crystals", this.crystalsGiven);
        tag.func_74768_a("ChallengeState", this.challengeState);
        tag.func_74768_a("ItemStyle", this.itemType);
        tag.func_74768_a("GameStyle", this.gameStyle);
        tag.func_74757_a("EliteMode", this.elite_mode);
    }

    public void func_70037_a(CompoundTag tag) {
        super.func_70037_a(tag);
        this.crystalsGiven = tag.func_74762_e("Crystals");
        this.challengeState = tag.func_74762_e("ChallengeState");
        this.itemType = tag.func_74762_e("ItemStyle");
        this.gameStyle = tag.func_74762_e("GameStyle");
        this.elite_mode = tag.func_74767_n("EliteMode");
    }

    protected boolean func_70692_ba() {
        return false;
    }

    protected SoundEvent func_184639_G() {
        return null;
    }

    protected SoundEvent func_184601_bQ(DamageSource damageSourceIn) {
        return null;
    }

    protected SoundEvent func_184615_bR() {
        return null;
    }
}

