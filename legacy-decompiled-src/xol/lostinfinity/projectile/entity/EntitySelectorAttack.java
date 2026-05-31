/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Optional
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.Player
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.datasync.DataParameter
 *  net.minecraft.network.datasync.DataSerializer
 *  net.minecraft.network.datasync.DataSerializers
 *  net.minecraft.network.datasync.EntityDataManager
 *  net.minecraft.util.math.AABB
 *  net.minecraft.world.World
 */
package xol.lostinfinity.projectile.entity;

import com.google.common.base.Optional;
import java.util.ArrayList;
import java.util.UUID;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.Level;
import xol.lostinfinity.item.weapon.ItemTheSelector;
import xol.lostinfinity.item.weapon.data.IonizerNode;
import xol.lostinfinity.mob.entity.base.EntityMultipleLives;
import xol.lostinfinity.util.data.IMaxAttack;

public class EntitySelectorAttack
extends Entity
implements IMaxAttack {
    protected static final DataParameter<Optional<UUID>> CASTER_ID = EntityDataManager.func_187226_a(EntitySelectorAttack.class, (DataSerializer)DataSerializers.field_187203_m);
    protected static final DataParameter<Integer> ORIGIN_ID = EntityDataManager.func_187226_a(EntitySelectorAttack.class, (DataSerializer)DataSerializers.field_187192_b);
    protected static final DataParameter<Integer> CHARACTER_DATA = EntityDataManager.func_187226_a(EntitySelectorAttack.class, (DataSerializer)DataSerializers.field_187192_b);
    private IonizerNode targets = null;
    private ArrayList<LivingEntity> visited = null;
    private static final double radius = 7.0;

    public EntitySelectorAttack(Level worldIn) {
        super(worldIn);
    }

    public void func_70071_h_() {
        super.func_70071_h_();
        Player caster = this.getCaster();
        if (caster == null) {
            if (!this.field_70170_p.field_72995_K) {
                this.func_70106_y();
            }
        } else {
            this.func_70107_b(caster.field_70165_t, caster.field_70163_u + (double)(caster.field_70131_O / 2.0f), caster.field_70161_v);
            if (this.targets == null) {
                this.visited = new ArrayList();
                this.targets = this.getTargetsNode(caster, (LivingEntity)this.field_70170_p.func_73045_a(this.getOriginID()), 0);
            } else {
                this.activateNodes(caster, this.targets);
            }
            if (this.field_70173_aa == 1000 && !this.field_70170_p.field_72995_K) {
                this.func_70106_y();
            }
        }
    }

    private int getOriginID() {
        return (Integer)this.field_70180_af.func_187225_a(ORIGIN_ID);
    }

    public void setOriginID(int id) {
        this.field_70180_af.func_187227_b(ORIGIN_ID, (Object)id);
    }

    private void activateNodes(Player caster, IonizerNode node) {
        if (node == null) {
            return;
        }
        if (!this.field_70170_p.field_72995_K && this.field_70173_aa == node.getTimer() && node.getOrigin() != null) {
            IMaxAttack.dealTrueDamage((Entity)caster, node.getOrigin(), node.getOrigin().func_110138_aP() * 0.25f);
            if (node.getOrigin() instanceof EntityMultipleLives) {
                EntityMultipleLives multiTarget = (EntityMultipleLives)node.getOrigin();
                multiTarget.takeawayNumLives(4);
            }
        }
        if (this.field_70173_aa >= node.getTimer() && this.field_70173_aa <= node.getTimer() + 10) {
            node.setActive(true);
        } else {
            node.setActive(false);
        }
        if (node.getTargets() != null) {
            for (IonizerNode target : node.getTargets()) {
                this.activateNodes(caster, target);
            }
        }
    }

    private IonizerNode getTargetsNode(Player caster, LivingEntity origin, int count) {
        if (origin == null || origin.func_70032_d((Entity)caster) > 70.0f) {
            return null;
        }
        ArrayList<IonizerNode> targetNodes = new ArrayList<IonizerNode>();
        ArrayList<LivingEntity> toAdd = new ArrayList<LivingEntity>();
        AABB checkBox = new AABB(origin.func_180425_c().func_177963_a(-7.0, -7.0, -7.0), origin.func_180425_c().func_177963_a(7.0, 7.0, 7.0));
        for (LivingEntity entity : (ArrayList)this.field_70170_p.func_72872_a(LivingEntity.class, checkBox)) {
            String hit_name = entity.func_70005_c_().toLowerCase();
            if (hit_name.isEmpty() || !ItemTheSelector.regexMatch(this.getCharacterData(), hit_name.substring(0, 1)) || entity.func_110124_au().equals(caster.func_110124_au()) || this.visited.contains(entity)) continue;
            if (!this.field_70170_p.field_72995_K) {
                // empty if block
            }
            this.visited.add(entity);
            toAdd.add(entity);
        }
        for (LivingEntity entity : toAdd) {
            int count2 = count + 1;
            targetNodes.add(this.getTargetsNode(caster, entity, count2));
        }
        IonizerNode node = new IonizerNode(origin);
        node.setTargets(targetNodes);
        node.setTimer(count * 5);
        return node;
    }

    private int getCharacterData() {
        return (Integer)this.field_70180_af.func_187225_a(CHARACTER_DATA);
    }

    public IonizerNode getTargets() {
        return this.targets;
    }

    protected void func_70037_a(CompoundTag compound) {
    }

    protected void func_70014_b(CompoundTag compound) {
    }

    protected void func_70088_a() {
        this.field_70180_af.func_187214_a(CASTER_ID, (Object)Optional.absent());
        this.field_70180_af.func_187214_a(ORIGIN_ID, (Object)0);
        this.field_70180_af.func_187214_a(CHARACTER_DATA, (Object)0);
    }

    public Player getCaster() {
        if (((Optional)this.field_70180_af.func_187225_a(CASTER_ID)).orNull() != null) {
            return this.field_70170_p.func_152378_a((UUID)((Optional)this.field_70180_af.func_187225_a(CASTER_ID)).get());
        }
        return null;
    }

    public void setCaster(Player player) {
        this.field_70180_af.func_187227_b(CASTER_ID, (Object)Optional.fromNullable((Object)player.func_110124_au()));
    }

    public void setCharacterData(int data) {
        this.field_70180_af.func_187227_b(CHARACTER_DATA, (Object)data);
    }
}

