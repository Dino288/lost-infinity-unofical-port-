/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.material.Material
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.monster.Monster
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.Direction
 *  net.minecraft.util.InteractionHand
 *  net.minecraft.util.SoundSource
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.text.Component
 *  net.minecraft.util.text.Component
 *  net.minecraft.world.DimensionType
 *  net.minecraft.world.World
 */
package xol.lostinfinity.block.activator;

import net.minecraft.block.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.DimensionType;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.basic.BlockBasic;
import xol.lostinfinity.client.TextFmt;
import xol.lostinfinity.dimension.util.DimensionActivator;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.init.SoundInit;
import xol.lostinfinity.item.basics.ItemArenaToken;
import xol.lostinfinity.mob.entity.base.EntityMultipleLives;
import xol.lostinfinity.mob.entity.boss.EntityAlestria;
import xol.lostinfinity.mob.entity.boss.EntityArash;
import xol.lostinfinity.mob.entity.boss.EntityAtlasSpire;
import xol.lostinfinity.mob.entity.boss.EntityBarul;
import xol.lostinfinity.mob.entity.boss.EntityCryonus;
import xol.lostinfinity.mob.entity.boss.EntityDarrio;
import xol.lostinfinity.mob.entity.boss.EntityNuxuro;
import xol.lostinfinity.mob.entity.boss.EntityOzor;
import xol.lostinfinity.mob.entity.boss.EntityRikarus;
import xol.lostinfinity.mob.entity.boss.EntityThundyron;
import xol.lostinfinity.mob.entity.boss.EntityUrogo;
import xol.lostinfinity.mob.entity.boss.EntityVelo;
import xol.lostinfinity.mob.entity.boss.EntityVycellia;

public class BlockArenaBoss
extends BlockBasic {
    public BlockArenaBoss(String name) {
        super(name, Material.field_151576_e);
    }

    public boolean func_180639_a(Level worldIn, BlockPos pos, BlockState state, Player playerIn, InteractionHand hand, Direction facing, float hitX, float hitY, float hitZ) {
        if (!playerIn.func_70093_af()) {
            if (pos.func_177958_n() < 350) {
                if (pos.func_177952_p() > 0) {
                    DimensionActivator.transferEntityWithCoords((Entity)playerIn, DimensionType.OVERWORLD, 0.0, 0.0, 0.0);
                } else {
                    ItemStack heldstack = playerIn.func_184586_b(hand);
                    if (heldstack.func_77973_b() instanceof ItemArenaToken) {
                        AABB aabb = this.getArenaAABB();
                        boolean found_pl = false;
                        for (Player playerCheck : worldIn.func_72872_a(Player.class, aabb)) {
                            found_pl = true;
                        }
                        if (!found_pl) {
                            if (!worldIn.field_72995_K) {
                                playerIn.func_70634_a(25.5, 61.2, -73.0);
                            }
                            worldIn.func_184148_a(playerIn, 25.5, 61.2, -73.0, SoundInit.ARENA_CHALLENGE, SoundSource.MASTER, 2.0f, 1.0f);
                            this.spawnMyBoss(heldstack.func_77973_b(), worldIn, playerIn);
                            heldstack.func_190918_g(1);
                        } else if (!worldIn.field_72995_K) {
                            playerIn.func_145747_a((Component)new Component((Object)((Object)TextFmt.Red) + "The arena is currently in use."));
                        }
                    } else if (heldstack.func_77973_b() == ItemInit.arenaCard) {
                        playerIn.func_184185_a(SoundInit.ARENA_TELEPORT, 3.0f, 1.0f);
                        heldstack.func_190918_g(1);
                        if (!worldIn.field_72995_K) {
                            playerIn.func_70634_a(25.5, 61.2, -33.0);
                        }
                    }
                }
            } else {
                DimensionActivator.transferEntityWithCoords((Entity)playerIn, DimensionType.OVERWORLD, 0.0, 0.0, 0.0);
            }
        }
        return true;
    }

    private AABB getArenaAABB() {
        return new AABB(new BlockPos(-3.0, 60.0, -145.0), new BlockPos(52.0, 85.0, -40.0));
    }

    private void spawnMyBoss(Item held, Level world, Player play) {
        EntityMultipleLives velo;
        AABB aabb = this.getArenaAABB();
        for (Monster mob_die : world.func_72872_a(Monster.class, aabb)) {
            mob_die.func_70106_y();
        }
        if (held == ItemInit.tokenUrogo) {
            if (!world.field_72995_K) {
                EntityUrogo urogo = new EntityUrogo(world);
                urogo.func_70107_b(25.5, 62.2, -90.0);
                world.func_72838_d((Entity)urogo);
            } else {
                play.func_145747_a((Component)new Component((Object)((Object)TextFmt.Aqua) + play.func_70005_c_() + " challenges Urogo!"));
                play.func_145747_a((Component)new Component((Object)((Object)TextFmt.Red) + "Urogo: Let's make this quick."));
            }
        } else if (held == ItemInit.tokenVelo) {
            if (!world.field_72995_K) {
                velo = new EntityVelo(world);
                velo.func_70107_b(25.5, 62.2, -90.0);
                world.func_72838_d((Entity)velo);
            } else {
                play.func_145747_a((Component)new Component((Object)((Object)TextFmt.Aqua) + play.func_70005_c_() + " challenges Velo!"));
                play.func_145747_a((Component)new Component((Object)((Object)TextFmt.Red) + "Velo: I'll battle you here, I'll battle you anywhere..."));
            }
        } else if (held == ItemInit.tokenNuxuro) {
            if (!world.field_72995_K) {
                velo = new EntityNuxuro(world);
                velo.func_70107_b(25.5, 62.2, -90.0);
                world.func_72838_d((Entity)velo);
            } else {
                play.func_145747_a((Component)new Component((Object)((Object)TextFmt.Aqua) + play.func_70005_c_() + " challenges Velo!"));
                play.func_145747_a((Component)new Component((Object)((Object)TextFmt.Red) + "Nuxuro: Run little being, while you still have the chance."));
            }
        } else if (held == ItemInit.tokenRikarus) {
            if (!world.field_72995_K) {
                EntityRikarus rikarus = new EntityRikarus(world);
                rikarus.func_70107_b(25.5, 62.2, -90.0);
                world.func_72838_d((Entity)rikarus);
            } else {
                play.func_145747_a((Component)new Component((Object)((Object)TextFmt.Aqua) + play.func_70005_c_() + " challenges Rikarus!"));
                play.func_145747_a((Component)new Component((Object)((Object)TextFmt.Red) + "Rikarus: Your life now belongs to me."));
            }
        } else if (held == ItemInit.tokenArash) {
            if (!world.field_72995_K) {
                EntityArash arash = new EntityArash(world);
                arash.func_70107_b(25.5, 62.2, -90.0);
                world.func_72838_d((Entity)arash);
            } else {
                play.func_145747_a((Component)new Component((Object)((Object)TextFmt.Aqua) + play.func_70005_c_() + " challenges Arash!"));
                play.func_145747_a((Component)new Component((Object)((Object)TextFmt.Red) + "Arash: You? A challenge? We'll see about that."));
            }
        } else if (held == ItemInit.tokenAlestria) {
            if (!world.field_72995_K) {
                EntityAlestria alestria = new EntityAlestria(world);
                alestria.func_70107_b(25.5, 62.2, -90.0);
                world.func_72838_d((Entity)alestria);
            } else {
                play.func_145747_a((Component)new Component((Object)((Object)TextFmt.Aqua) + play.func_70005_c_() + " challenges Alestria!"));
                play.func_145747_a((Component)new Component((Object)((Object)TextFmt.Red) + "Alestria: Your life will soon be as empty as the void around us."));
            }
        } else if (held == ItemInit.tokenDario) {
            if (!world.field_72995_K) {
                EntityDarrio darrio = new EntityDarrio(world);
                darrio.func_70107_b(25.5, 62.2, -90.0);
                world.func_72838_d((Entity)darrio);
            } else {
                play.func_145747_a((Component)new Component((Object)((Object)TextFmt.Aqua) + play.func_70005_c_() + " challenges Darrio!"));
                play.func_145747_a((Component)new Component((Object)((Object)TextFmt.Red) + "Darrio: I'm already dead, what can you possibly do to me?"));
            }
        } else if (held == ItemInit.tokenAtlasspire) {
            if (!world.field_72995_K) {
                EntityAtlasSpire spire = new EntityAtlasSpire(world);
                spire.func_70107_b(25.5, 62.2, -90.0);
                world.func_72838_d((Entity)spire);
            } else {
                play.func_145747_a((Component)new Component((Object)((Object)TextFmt.Aqua) + play.func_70005_c_() + " challenges The Atlas Spire!"));
                play.func_145747_a((Component)new Component((Object)((Object)TextFmt.Red) + "Looming Voice: Interesting choice."));
            }
        } else if (held == ItemInit.tokenVycellia) {
            if (!world.field_72995_K) {
                EntityVycellia vycel = new EntityVycellia(world);
                vycel.func_70107_b(25.5, 62.2, -90.0);
                world.func_72838_d((Entity)vycel);
            } else {
                play.func_145747_a((Component)new Component((Object)((Object)TextFmt.Aqua) + play.func_70005_c_() + " challenges Spider Queen Vycellia!"));
                play.func_145747_a((Component)new Component((Object)((Object)TextFmt.Red) + "Vycellia: My army is eternal, and YOU. ARE. NOT."));
            }
        } else if (held == ItemInit.tokenOzor) {
            if (!world.field_72995_K) {
                EntityOzor ozor = new EntityOzor(world);
                ozor.func_70107_b(25.5, 62.2, -90.0);
                world.func_72838_d((Entity)ozor);
            } else {
                play.func_145747_a((Component)new Component((Object)((Object)TextFmt.Aqua) + play.func_70005_c_() + " challenges Ozor!"));
                play.func_145747_a((Component)new Component((Object)((Object)TextFmt.Red) + "Ozor: Your life is but an illusion... a mirage waiting to disappear."));
            }
        } else if (held == ItemInit.tokenThundyron) {
            if (!world.field_72995_K) {
                EntityThundyron thund = new EntityThundyron(world);
                thund.func_70107_b(25.5, 62.2, -90.0);
                world.func_72838_d((Entity)thund);
            } else {
                play.func_145747_a((Component)new Component((Object)((Object)TextFmt.Aqua) + play.func_70005_c_() + " challenges Thundyron!"));
                play.func_145747_a((Component)new Component((Object)((Object)TextFmt.Red) + "Thundyron: YOU... HAVE... NO... POWER..."));
            }
        } else if (held == ItemInit.tokenBarul) {
            if (!world.field_72995_K) {
                EntityBarul barul = new EntityBarul(world);
                barul.func_70107_b(25.5, 62.2, -90.0);
                world.func_72838_d((Entity)barul);
            } else {
                play.func_145747_a((Component)new Component((Object)((Object)TextFmt.Aqua) + play.func_70005_c_() + " challenges Barul!"));
                play.func_145747_a((Component)new Component((Object)((Object)TextFmt.Red) + "Barul: You like tiny and weak.... and like you're about to be dead."));
            }
        } else if (held == ItemInit.tokenCryonus) {
            if (!world.field_72995_K) {
                EntityCryonus cryro = new EntityCryonus(world);
                cryro.func_70107_b(25.5, 62.2, -90.0);
                world.func_72838_d((Entity)cryro);
            } else {
                play.func_145747_a((Component)new Component((Object)((Object)TextFmt.Aqua) + play.func_70005_c_() + " challenges Cryonus!"));
                play.func_145747_a((Component)new Component((Object)((Object)TextFmt.Red) + "Cryonus: What is it you fear " + play.func_70005_c_() + "?"));
            }
        }
    }
}

