/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.util.EnumParticleTypes
 *  net.minecraft.util.math.Vec3
 *  net.minecraft.world.World
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package xol.lostinfinity.client.fx;

import java.util.Random;
import net.minecraft.client.Minecraft;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xol.lostinfinity.init.ParticleInit;
import xol.lostinfinity.util.data.CustomParticleConfig;

@SideOnly(value=Side.CLIENT)
public class ClientParticleRenderer {
    public static void renderSimple(int id, int extra, double posX, double posY, double posZ) {
        Level world = Minecraft.func_71410_x().field_71439_g.field_70170_p;
        Random rand = world.field_73012_v;
        switch (id) {
            case 0: {
                int i;
                for (i = 0; i < 10; ++i) {
                    world.func_175682_a(ParticleInit.VENOM, true, posX + ClientParticleRenderer.getROD(rand, 4.0), posY + ClientParticleRenderer.getROD(rand, 1.0), posZ + ClientParticleRenderer.getROD(rand, 4.0), 0.0, 0.0, 0.0, new int[0]);
                }
                for (i = 0; i < 5; ++i) {
                    world.func_175682_a(ParticleInit.VENOM_RING, true, posX + ClientParticleRenderer.getROD(rand, 1.0), posY + ClientParticleRenderer.getROD(rand, 1.0), posZ + ClientParticleRenderer.getROD(rand, 1.0), 0.0, 0.0, 0.0, new int[0]);
                }
                break;
            }
            case 1: {
                for (int i = 0; i < 4; ++i) {
                    world.func_175682_a(ParticleInit.PLASMA_EXPLOSION, true, posX, posY, posZ, 0.0, 0.0, 0.0, new int[]{2});
                }
                break;
            }
            case 2: {
                for (int i = 0; i < 5 + extra; ++i) {
                    world.func_175682_a(EnumParticleTypes.DRAGON_BREATH, true, posX + ClientParticleRenderer.getROD(rand, 1.0), posY + 0.75, posZ + ClientParticleRenderer.getROD(rand, 1.0), ClientParticleRenderer.getROD(rand, 1.0), Math.abs(ClientParticleRenderer.getROD(rand, 1.0)), ClientParticleRenderer.getROD(rand, 1.0), new int[0]);
                }
                if (extra == 0) break;
                world.func_175682_a(EnumParticleTypes.EXPLOSION_HUGE, true, posX, posY, posZ, 0.0, 0.0, 0.0, new int[0]);
                break;
            }
            case 3: {
                for (int i = 0; i < 10; ++i) {
                    world.func_175682_a(ParticleInit.QUANTUM_MARK, true, posX + ClientParticleRenderer.getROD(rand, 2.0), posY + ClientParticleRenderer.getROD(rand, 1.0), posZ + ClientParticleRenderer.getROD(rand, 2.0), 0.0, 0.0, 0.0, new int[0]);
                }
                break;
            }
            case 4: {
                for (int i = 0; i < 3; ++i) {
                    world.func_175682_a(ParticleInit.ATTRACT_FIELD, true, posX + ClientParticleRenderer.getROD(rand, 1.0), posY + ClientParticleRenderer.getROD(rand, 1.0), posZ + ClientParticleRenderer.getROD(rand, 1.0), 0.0, 0.0, 0.0, new int[0]);
                }
                break;
            }
            case 5: {
                for (int i = 0; i < 3; ++i) {
                    world.func_175682_a(ParticleInit.REPEL_FIELD, true, posX + ClientParticleRenderer.getROD(rand, 1.0), posY + ClientParticleRenderer.getROD(rand, 1.0), posZ + ClientParticleRenderer.getROD(rand, 1.0), 0.0, 0.0, 0.0, new int[0]);
                }
                break;
            }
            case 6: {
                for (int i = 0; i < 2; ++i) {
                    world.func_175682_a(ParticleInit.SLAM, true, posX + ClientParticleRenderer.getROD(rand, 1.0), posY + ClientParticleRenderer.getROD(rand, 1.0), posZ + ClientParticleRenderer.getROD(rand, 1.0), 0.0, 0.0, 0.0, new int[0]);
                }
                break;
            }
            case 7: {
                world.func_175682_a(ParticleInit.WARP, true, posX, posY, posZ, 0.0, 0.0, 0.0, new int[0]);
                break;
            }
            case 8: {
                for (int i = 0; i < 5; ++i) {
                    world.func_175682_a(ParticleInit.GOO_RING, true, posX + ClientParticleRenderer.getROD(rand, 2.0), posY + ClientParticleRenderer.getROD(rand, 1.0), posZ + ClientParticleRenderer.getROD(rand, 2.0), 0.0, 0.0, 0.0, new int[0]);
                }
                break;
            }
            case 9: {
                world.func_175682_a(ParticleInit.EXPLOSION, true, posX, posY, posZ, 0.0, 0.0, 0.0, new int[0]);
                break;
            }
            case 10: {
                for (int i = 0; i < 3; ++i) {
                    world.func_175682_a(ParticleInit.EXPLOSION_RING, true, posX + ClientParticleRenderer.getROD(rand, 2.0), posY + ClientParticleRenderer.getROD(rand, 1.0), posZ + ClientParticleRenderer.getROD(rand, 2.0), 0.0, 0.0, 0.0, new int[0]);
                }
                break;
            }
            case 11: {
                for (int i = 0; i < 5; ++i) {
                    world.func_175682_a(ParticleInit.ZAP, true, posX + ClientParticleRenderer.getROD(rand, 3.0), posY + ClientParticleRenderer.getROD(rand, 1.0), posZ + ClientParticleRenderer.getROD(rand, 3.0), 0.0, 0.0, 0.0, new int[0]);
                }
                break;
            }
            case 12: {
                world.func_175682_a(ParticleInit.DARK_MAGIC, true, posX, posY, posZ, 0.0, 0.0, 0.0, new int[0]);
                world.func_175682_a(ParticleInit.PLAGUE, true, posX, posY, posZ, 0.0, 0.0, 0.0, new int[0]);
                break;
            }
            case 13: {
                for (int i = 0; i < 3; ++i) {
                    world.func_175682_a(ParticleInit.GLOOM_BURST, true, posX + ClientParticleRenderer.getROD(rand, 1.0), posY + ClientParticleRenderer.getROD(rand, 1.0), posZ + ClientParticleRenderer.getROD(rand, 1.0), 0.0, 0.0, 0.0, new int[0]);
                }
                break;
            }
            case 14: {
                for (int i = 0; i < 10; ++i) {
                    world.func_175682_a(ParticleInit.LIGHT_FLASH, true, posX + ClientParticleRenderer.getROD(rand, 4.0), posY + ClientParticleRenderer.getROD(rand, 1.0), posZ + ClientParticleRenderer.getROD(rand, 4.0), 0.0, 0.0, 0.0, new int[0]);
                }
                break;
            }
            case 15: {
                for (int i = 0; i < 10; ++i) {
                    world.func_175682_a(ParticleInit.DARK_FLASH, true, posX + ClientParticleRenderer.getROD(rand, 4.0), posY + ClientParticleRenderer.getROD(rand, 1.0), posZ + ClientParticleRenderer.getROD(rand, 4.0), 0.0, 0.0, 0.0, new int[0]);
                }
                break;
            }
            case 16: {
                for (int i = 0; i < 1 + extra; ++i) {
                    world.func_175682_a(ParticleInit.FLAME_SMALL, true, posX + ClientParticleRenderer.getROD(rand, 1.0), posY, posZ + ClientParticleRenderer.getROD(rand, 1.0), (double)0.3f * ClientParticleRenderer.getROD(rand, 1.0), 0.0, (double)0.3f * ClientParticleRenderer.getROD(rand, 1.0), new int[0]);
                }
                break;
            }
            case 17: {
                for (int i = 0; i < 1 + 2 * extra; ++i) {
                    world.func_175682_a(ParticleInit.FLAME_MEDIUM, true, posX + ClientParticleRenderer.getROD(rand, 1.0), posY, posZ + ClientParticleRenderer.getROD(rand, 1.0), (double)0.3f * ClientParticleRenderer.getROD(rand, 1.0), 0.0, (double)0.3f * ClientParticleRenderer.getROD(rand, 1.0), new int[0]);
                }
                break;
            }
            case 18: {
                for (int i = 0; i < 1 + 4 * extra; ++i) {
                    world.func_175682_a(ParticleInit.FLAME_LARGE, true, posX + ClientParticleRenderer.getROD(rand, 1.0), posY, posZ + ClientParticleRenderer.getROD(rand, 1.0), (double)0.3f * ClientParticleRenderer.getROD(rand, 1.0), 0.0, (double)0.3f * ClientParticleRenderer.getROD(rand, 1.0), new int[0]);
                }
                break;
            }
            case 19: {
                for (int i = 0; i < 8; ++i) {
                    world.func_175688_a(ParticleInit.FIREGOO, posX + ClientParticleRenderer.getROD(rand, 1.0), posY + ClientParticleRenderer.getROD(rand, 1.0), posZ + ClientParticleRenderer.getROD(rand, 1.0), ClientParticleRenderer.getROD(rand, 1.0), ClientParticleRenderer.getROD(rand, 1.0), ClientParticleRenderer.getROD(rand, 1.0), new int[0]);
                }
                break;
            }
            case 20: {
                world.func_175682_a(ParticleInit.BOMBER_EXPLOSION, true, posX + 0.5, posY, posZ + 0.5, 0.0, 0.0, 0.0, new int[0]);
                break;
            }
            case 21: {
                world.func_175682_a(ParticleInit.GLOMITE_WARP, true, posX, posY, posZ, 0.0, 0.0, 0.0, new int[0]);
                break;
            }
            case 22: {
                for (int i = 0; i < 8; ++i) {
                    world.func_175682_a(ParticleInit.SPACE_MAGIC, true, posX + ClientParticleRenderer.getROD(rand, 4.0), posY + ClientParticleRenderer.getROD(rand, 1.0), posZ + ClientParticleRenderer.getROD(rand, 4.0), 0.0, 0.0, 0.0, new int[0]);
                }
                break;
            }
            case 23: {
                world.func_175682_a(ParticleInit.POWER_FIELD, true, posX, posY, posZ, 0.0, 0.0, 0.0, new int[0]);
                break;
            }
            case 24: {
                world.func_175682_a(ParticleInit.POWER_LOSS, true, posX, posY, posZ, 0.0, 0.0, 0.0, new int[0]);
                break;
            }
            case 25: {
                for (int i = 0; i < 8; ++i) {
                    world.func_175682_a(ParticleInit.PLAGUE, true, posX, posY, posZ, 0.0, 0.0, 0.0, new int[0]);
                }
                break;
            }
            case 26: {
                for (int i = 0; i < 14; ++i) {
                    world.func_175682_a(ParticleInit.ANCIENT_SPELL, true, posX + ClientParticleRenderer.getROD(rand, 1.0), posY, posZ + ClientParticleRenderer.getROD(rand, 1.0), (double)0.3f * ClientParticleRenderer.getROD(rand, 1.0), 0.0, (double)0.3f * ClientParticleRenderer.getROD(rand, 1.0), new int[0]);
                }
                break;
            }
            case 27: {
                for (int i = 0; i < 8; ++i) {
                    world.func_175682_a(ParticleInit.CLAW_MARKS, true, posX + ClientParticleRenderer.getROD(rand, 4.0), posY + ClientParticleRenderer.getROD(rand, 1.0), posZ + ClientParticleRenderer.getROD(rand, 4.0), 0.0, 0.0, 0.0, new int[0]);
                }
                break;
            }
            case 28: {
                for (int i = 0; i < 3; ++i) {
                    world.func_175682_a(rand.nextBoolean() ? ParticleInit.ELECTRIC_EXPLOSION_BLUE : ParticleInit.ELECTRIC_EXPLOSION_YELLOW, true, posX + ClientParticleRenderer.getROD(rand, 2.0), posY + ClientParticleRenderer.getROD(rand, 1.0), posZ + ClientParticleRenderer.getROD(rand, 2.0), 0.0, 0.0, 0.0, new int[0]);
                }
                break;
            }
            case 29: {
                for (int i = 0; i < 10; ++i) {
                    world.func_175682_a(ParticleInit.CORRUPTION_MAGIC, true, posX + ClientParticleRenderer.getROD(rand, 4.0), posY + ClientParticleRenderer.getROD(rand, 1.0), posZ + ClientParticleRenderer.getROD(rand, 4.0), 0.0, 0.0, 0.0, new int[0]);
                }
                break;
            }
            case 30: {
                for (int i = 0; i < 3; ++i) {
                    world.func_175682_a(ParticleInit.NATURE_RING, true, posX, posY, posZ, 0.0, 0.0, 0.0, new int[0]);
                }
                break;
            }
            case 31: {
                for (int i = 0; i < 10; ++i) {
                    world.func_175682_a(ParticleInit.NATURE_MAGIC, true, posX + ClientParticleRenderer.getROD(rand, 4.0), posY + ClientParticleRenderer.getROD(rand, 1.0), posZ + ClientParticleRenderer.getROD(rand, 4.0), 0.0, 0.0, 0.0, new int[0]);
                }
                break;
            }
            case 32: {
                for (int i = 0; i < 10; ++i) {
                    world.func_175682_a(ParticleInit.CRYSTAL_MAGIC, true, posX + ClientParticleRenderer.getROD(rand, 4.0), posY + ClientParticleRenderer.getROD(rand, 1.0), posZ + ClientParticleRenderer.getROD(rand, 4.0), 0.0, 0.0, 0.0, new int[0]);
                }
                break;
            }
            case 33: {
                for (int i = 0; i < 2; ++i) {
                    world.func_175682_a(ParticleInit.VENOM, true, posX + ClientParticleRenderer.getROD(rand, 4.0), posY + ClientParticleRenderer.getROD(rand, 1.0), posZ + ClientParticleRenderer.getROD(rand, 4.0), 0.0, 0.0, 0.0, new int[0]);
                }
                world.func_175682_a(ParticleInit.VENOM_RING, true, posX + ClientParticleRenderer.getROD(rand, 1.0), posY + ClientParticleRenderer.getROD(rand, 1.0), posZ + ClientParticleRenderer.getROD(rand, 1.0), 0.0, 0.0, 0.0, new int[0]);
                break;
            }
            case 34: {
                world.func_175682_a(ParticleInit.SHADOW_BLAST, true, posX + ClientParticleRenderer.getROD(rand, 1.0), posY + ClientParticleRenderer.getROD(rand, 1.0), posZ + ClientParticleRenderer.getROD(rand, 1.0), 0.0, 0.0, 0.0, new int[0]);
                break;
            }
            case 35: {
                for (int i = 0; i < 10; ++i) {
                    world.func_175682_a(ParticleInit.POISON_BUBBLE, true, posX + ClientParticleRenderer.getROD(rand, 4.0), posY + ClientParticleRenderer.getROD(rand, 1.0), posZ + ClientParticleRenderer.getROD(rand, 4.0), 0.0, 0.0, 0.0, new int[0]);
                }
                break;
            }
            case 36: {
                for (int i = 0; i < 12; ++i) {
                    world.func_175682_a(ParticleInit.PURPLE_SKULL, true, posX + ClientParticleRenderer.getROD(rand, 4.0), posY + ClientParticleRenderer.getROD(rand, 1.0), posZ + ClientParticleRenderer.getROD(rand, 4.0), 0.0, 0.0, 0.0, new int[0]);
                }
                break;
            }
            case 37: {
                for (int i = 0; i < 4; ++i) {
                    world.func_175682_a(ParticleInit.BLIGHT_SPELL_GREEN, true, posX + ClientParticleRenderer.getROD(rand, 4.0), posY + ClientParticleRenderer.getROD(rand, 1.0), posZ + ClientParticleRenderer.getROD(rand, 4.0), 0.0, 0.0, 0.0, new int[0]);
                }
                break;
            }
            case 38: {
                for (int i = 0; i < 5; ++i) {
                    world.func_175682_a(ParticleInit.DARK_MAGIC, true, posX + ClientParticleRenderer.getROD(rand, 4.0), posY + ClientParticleRenderer.getROD(rand, 1.0), posZ + ClientParticleRenderer.getROD(rand, 4.0), 0.0, 0.0, 0.0, new int[0]);
                }
                break;
            }
            case 39: {
                world.func_175682_a(ParticleInit.BLUE_SKULL, true, posX + ClientParticleRenderer.getROD(rand, 1.0), posY + ClientParticleRenderer.getROD(rand, 1.0), posZ + ClientParticleRenderer.getROD(rand, 1.0), 0.0, 0.0, 0.0, new int[0]);
                break;
            }
            case 40: {
                for (int i = 0; i < 5; ++i) {
                    world.func_175682_a(ParticleInit.ION_BLAST, true, posX + ClientParticleRenderer.getROD(rand, 6.0), posY + ClientParticleRenderer.getROD(rand, 4.0), posZ + ClientParticleRenderer.getROD(rand, 6.0), 0.0, 0.0, 0.0, new int[0]);
                }
                break;
            }
            case 41: {
                for (int i = 0; i < 5; ++i) {
                    world.func_175682_a(ParticleInit.NUCLEAR_BLAST, true, posX + ClientParticleRenderer.getROD(rand, 1.0), posY + ClientParticleRenderer.getROD(rand, 1.0), posZ + ClientParticleRenderer.getROD(rand, 1.0), 0.0, 0.0, 0.0, new int[0]);
                }
                break;
            }
            case 42: {
                for (int i = 0; i < 10; ++i) {
                    world.func_175682_a(ParticleInit.EXPLOSION, true, posX + ClientParticleRenderer.getROD(rand, 8.0), posY + ClientParticleRenderer.getROD(rand, 2.0), posZ + ClientParticleRenderer.getROD(rand, 8.0), 0.0, 0.0, 0.0, new int[0]);
                }
                break;
            }
            case 43: {
                for (int i = 0; i < 8; ++i) {
                    world.func_175682_a(ParticleInit.PLASMA_RIFT, true, posX + ClientParticleRenderer.getROD(rand, 3.0), posY + ClientParticleRenderer.getROD(rand, 1.0), posZ + ClientParticleRenderer.getROD(rand, 3.0), 0.0, 0.0, 0.0, new int[0]);
                }
                break;
            }
            case 44: {
                for (int i = 0; i < 20; ++i) {
                    world.func_175682_a(ParticleInit.MURK, true, posX + ClientParticleRenderer.getROD(rand, 5.0), posY + ClientParticleRenderer.getROD(rand, 2.0), posZ + ClientParticleRenderer.getROD(rand, 5.0), 0.0, 0.0, 0.0, new int[0]);
                }
                break;
            }
            case 45: {
                world.func_175682_a(ParticleInit.SPECTRAL, true, posX + ClientParticleRenderer.getROD(rand, 1.0), posY + ClientParticleRenderer.getROD(rand, 1.0), posZ + ClientParticleRenderer.getROD(rand, 1.0), 0.0, 0.0, 0.0, new int[0]);
                break;
            }
            case 46: {
                block125: for (int i = 0; i < 5; ++i) {
                    switch (rand.nextInt(3)) {
                        case 0: {
                            world.func_175682_a(ParticleInit.PRISMATIC_EXPLOSION_TYPE1, true, posX + ClientParticleRenderer.getROD(rand, 1.0), posY + ClientParticleRenderer.getROD(rand, 1.0), posZ + ClientParticleRenderer.getROD(rand, 1.0), 0.0, 0.0, 0.0, new int[0]);
                            continue block125;
                        }
                        case 1: {
                            world.func_175682_a(ParticleInit.PRISMATIC_EXPLOSION_TYPE2, true, posX + ClientParticleRenderer.getROD(rand, 1.0), posY + ClientParticleRenderer.getROD(rand, 1.0), posZ + ClientParticleRenderer.getROD(rand, 1.0), 0.0, 0.0, 0.0, new int[0]);
                            continue block125;
                        }
                        case 2: {
                            world.func_175682_a(ParticleInit.PRISMATIC_EXPLOSION_TYPE3, true, posX + ClientParticleRenderer.getROD(rand, 1.0), posY + ClientParticleRenderer.getROD(rand, 1.0), posZ + ClientParticleRenderer.getROD(rand, 1.0), 0.0, 0.0, 0.0, new int[0]);
                        }
                    }
                }
                break;
            }
            case 47: {
                for (int i = 0; i < 5; ++i) {
                    world.func_175682_a(ParticleInit.PRISMATIC_EXPLOSION_TYPE1, true, posX + ClientParticleRenderer.getROD(rand, 1.0), posY + ClientParticleRenderer.getROD(rand, 1.0), posZ + ClientParticleRenderer.getROD(rand, 1.0), 0.0, 0.0, 0.0, new int[0]);
                }
                break;
            }
            case 48: {
                for (int i = 0; i < 5; ++i) {
                    world.func_175682_a(ParticleInit.PRISMATIC_EXPLOSION_TYPE2, true, posX + ClientParticleRenderer.getROD(rand, 1.0), posY + ClientParticleRenderer.getROD(rand, 1.0), posZ + ClientParticleRenderer.getROD(rand, 1.0), 0.0, 0.0, 0.0, new int[0]);
                }
                break;
            }
            case 49: {
                for (int i = 0; i < 5; ++i) {
                    world.func_175682_a(ParticleInit.PRISMATIC_EXPLOSION_TYPE3, true, posX + ClientParticleRenderer.getROD(rand, 1.0), posY + ClientParticleRenderer.getROD(rand, 1.0), posZ + ClientParticleRenderer.getROD(rand, 1.0), 0.0, 0.0, 0.0, new int[0]);
                }
                break;
            }
            case 50: {
                for (int i = 0; i < 5; ++i) {
                    world.func_175682_a(ParticleInit.EXPLOSION_RING_DARK, true, posX + ClientParticleRenderer.getROD(rand, 1.0), posY + ClientParticleRenderer.getROD(rand, 1.0), posZ + ClientParticleRenderer.getROD(rand, 1.0), 0.0, 0.0, 0.0, new int[0]);
                }
                break;
            }
            case 51: {
                int i;
                for (i = 0; i < 3; ++i) {
                    if (rand.nextBoolean()) {
                        world.func_175682_a(ParticleInit.EXPLOSION_BLUE, true, posX + ClientParticleRenderer.getROD(rand, 5.0), posY + ClientParticleRenderer.getROD(rand, 1.0), posZ + ClientParticleRenderer.getROD(rand, 5.0), 0.0, 0.0, 0.0, new int[0]);
                        continue;
                    }
                    world.func_175682_a(ParticleInit.EXPLOSION_TEAL, true, posX + ClientParticleRenderer.getROD(rand, 5.0), posY + ClientParticleRenderer.getROD(rand, 1.0), posZ + ClientParticleRenderer.getROD(rand, 5.0), 0.0, 0.0, 0.0, new int[0]);
                }
                for (i = 0; i < 7; ++i) {
                    world.func_175682_a(ParticleInit.MURK, true, posX + ClientParticleRenderer.getROD(rand, 10.0), posY + ClientParticleRenderer.getROD(rand, 2.0), posZ + ClientParticleRenderer.getROD(rand, 10.0), 0.0, 0.0, 0.0, new int[0]);
                }
                break;
            }
            case 52: {
                for (int i = 0; i < 2; ++i) {
                    world.func_175682_a(ParticleInit.CLAW_MARKS, true, posX + ClientParticleRenderer.getROD(rand, 2.0), posY + ClientParticleRenderer.getROD(rand, 1.0), posZ + ClientParticleRenderer.getROD(rand, 2.0), 0.0, 0.0, 0.0, new int[0]);
                    world.func_175682_a(ParticleInit.BLOOD_DROP, true, posX + ClientParticleRenderer.getROD(rand, 2.0), posY + ClientParticleRenderer.getROD(rand, 1.0), posZ + ClientParticleRenderer.getROD(rand, 2.0), 0.0, 0.0, 0.0, new int[0]);
                }
                break;
            }
            case 53: {
                for (int i = 0; i < 10; ++i) {
                    world.func_175682_a(ParticleInit.ION_BLAST, true, posX + ClientParticleRenderer.getROD(rand, 6.0), posY + ClientParticleRenderer.getROD(rand, 4.0), posZ + ClientParticleRenderer.getROD(rand, 6.0), 0.0, 0.0, 0.0, new int[0]);
                    world.func_175682_a(ParticleInit.EXPLOSION_LAVENDER, true, posX + ClientParticleRenderer.getROD(rand, 5.0), posY + ClientParticleRenderer.getROD(rand, 1.0), posZ + ClientParticleRenderer.getROD(rand, 5.0), 0.0, 0.0, 0.0, new int[0]);
                }
                break;
            }
            case 54: {
                int i;
                for (i = 0; i < 15; ++i) {
                    world.func_175682_a(ParticleInit.POISON_EXPLOSION, true, posX + ClientParticleRenderer.getROD(rand, 15.0), posY + ClientParticleRenderer.getROD(rand, 2.0), posZ + ClientParticleRenderer.getROD(rand, 15.0), 0.0, 0.0, 0.0, new int[0]);
                }
            }
            case 55: {
                int i;
                switch (rand.nextInt(4)) {
                    case 0: {
                        world.func_175682_a(ParticleInit.COSMIC_EXPLOSION_TYPE1, true, posX + ClientParticleRenderer.getROD(rand, 5.0), posY + ClientParticleRenderer.getROD(rand, 1.0), posZ + ClientParticleRenderer.getROD(rand, 5.0), 0.0, 0.0, 0.0, new int[0]);
                        break;
                    }
                    case 1: {
                        world.func_175682_a(ParticleInit.COSMIC_EXPLOSION_TYPE2, true, posX + ClientParticleRenderer.getROD(rand, 5.0), posY + ClientParticleRenderer.getROD(rand, 1.0), posZ + ClientParticleRenderer.getROD(rand, 5.0), 0.0, 0.0, 0.0, new int[0]);
                        break;
                    }
                    case 2: {
                        world.func_175682_a(ParticleInit.COSMIC_EXPLOSION_TYPE3, true, posX + ClientParticleRenderer.getROD(rand, 5.0), posY + ClientParticleRenderer.getROD(rand, 1.0), posZ + ClientParticleRenderer.getROD(rand, 5.0), 0.0, 0.0, 0.0, new int[0]);
                        break;
                    }
                    case 3: {
                        world.func_175682_a(ParticleInit.COSMIC_EXPLOSION_TYPE4, true, posX + ClientParticleRenderer.getROD(rand, 5.0), posY + ClientParticleRenderer.getROD(rand, 1.0), posZ + ClientParticleRenderer.getROD(rand, 5.0), 0.0, 0.0, 0.0, new int[0]);
                    }
                }
                block135: for (i = 0; i < 4; ++i) {
                    switch (rand.nextInt(4)) {
                        case 0: {
                            world.func_175682_a(ParticleInit.BASIC_STAR_TYPE1, true, posX + ClientParticleRenderer.getROD(rand, 5.0), posY + ClientParticleRenderer.getROD(rand, 3.0), posZ + ClientParticleRenderer.getROD(rand, 5.0), 0.0, 0.0, 0.0, new int[0]);
                            continue block135;
                        }
                        case 1: {
                            world.func_175682_a(ParticleInit.BASIC_STAR_TYPE2, true, posX + ClientParticleRenderer.getROD(rand, 5.0), posY + ClientParticleRenderer.getROD(rand, 3.0), posZ + ClientParticleRenderer.getROD(rand, 5.0), 0.0, 0.0, 0.0, new int[0]);
                            continue block135;
                        }
                        case 2: {
                            world.func_175682_a(ParticleInit.BASIC_STAR_TYPE3, true, posX + ClientParticleRenderer.getROD(rand, 5.0), posY + ClientParticleRenderer.getROD(rand, 3.0), posZ + ClientParticleRenderer.getROD(rand, 5.0), 0.0, 0.0, 0.0, new int[0]);
                            continue block135;
                        }
                        case 3: {
                            world.func_175682_a(ParticleInit.BASIC_STAR_TYPE4, true, posX + ClientParticleRenderer.getROD(rand, 5.0), posY + ClientParticleRenderer.getROD(rand, 3.0), posZ + ClientParticleRenderer.getROD(rand, 5.0), 0.0, 0.0, 0.0, new int[0]);
                        }
                    }
                }
                break;
            }
            case 56: {
                int i;
                for (i = 0; i < 4; ++i) {
                    world.func_175682_a(ParticleInit.VENOM_RING, true, posX + ClientParticleRenderer.getROD(rand, 15.0), posY + ClientParticleRenderer.getROD(rand, 2.0), posZ + ClientParticleRenderer.getROD(rand, 15.0), 0.0, 0.0, 0.0, new int[0]);
                    world.func_175682_a(ParticleInit.EXPLOSION_RING_DARK, true, posX + ClientParticleRenderer.getROD(rand, 15.0), posY + ClientParticleRenderer.getROD(rand, 2.0), posZ + ClientParticleRenderer.getROD(rand, 15.0), 0.0, 0.0, 0.0, new int[0]);
                }
            }
            case 57: {
                int i;
                for (i = 0; i < 5; ++i) {
                    world.func_175682_a(ParticleInit.MIASMA, true, posX + ClientParticleRenderer.getROD(rand, 4.0), posY + ClientParticleRenderer.getROD(rand, 1.0), posZ + ClientParticleRenderer.getROD(rand, 4.0), 0.0, 0.0, 0.0, new int[0]);
                }
                break;
            }
            case 58: {
                if (rand.nextBoolean()) {
                    for (int i = 0; i < 2; ++i) {
                        world.func_175682_a(ParticleInit.SUPERSONIC_BLUE, true, posX, posY, posZ, 0.0, 0.0, 0.0, new int[0]);
                    }
                } else {
                    for (int i = 0; i < 2; ++i) {
                        world.func_175682_a(ParticleInit.SUPERSONIC_RED, true, posX, posY, posZ, 0.0, 0.0, 0.0, new int[0]);
                    }
                }
                break;
            }
            case 59: {
                for (int i = 0; i < 15; ++i) {
                    if (rand.nextBoolean()) {
                        world.func_175682_a(ParticleInit.EXPLOSION_RED, true, posX + ClientParticleRenderer.getROD(rand, 25.0), posY + ClientParticleRenderer.getROD(rand, 4.0), posZ + ClientParticleRenderer.getROD(rand, 25.0), 0.0, 0.0, 0.0, new int[0]);
                        continue;
                    }
                    world.func_175682_a(ParticleInit.EXPLOSION_ORANGE, true, posX + ClientParticleRenderer.getROD(rand, 25.0), posY + ClientParticleRenderer.getROD(rand, 4.0), posZ + ClientParticleRenderer.getROD(rand, 25.0), 0.0, 0.0, 0.0, new int[0]);
                }
                break;
            }
            case 60: {
                world.func_175682_a(ParticleInit.POWER_FIELD, true, posX, posY, posZ, 0.0, 0.0, 0.0, new int[0]);
                for (int i = 0; i < 12; ++i) {
                    world.func_175682_a(rand.nextBoolean() ? ParticleInit.EXPLOSION_BLUE : ParticleInit.EXPLOSION_LAVENDER, true, posX + ClientParticleRenderer.getROD(rand, 18.0), posY + ClientParticleRenderer.getROD(rand, 2.0), posZ + ClientParticleRenderer.getROD(rand, 18.0), 0.0, 0.0, 0.0, new int[0]);
                }
                break;
            }
            case 61: {
                block142: for (int i = 0; i < 4 + extra; ++i) {
                    switch (rand.nextInt(4)) {
                        case 0: {
                            world.func_175682_a(ParticleInit.BASIC_STAR_TYPE1, true, posX + ClientParticleRenderer.getROD(rand, 5.0), posY + ClientParticleRenderer.getROD(rand, 3.0), posZ + ClientParticleRenderer.getROD(rand, 5.0), 0.0, 0.0, 0.0, new int[0]);
                            continue block142;
                        }
                        case 1: {
                            world.func_175682_a(ParticleInit.BASIC_STAR_TYPE2, true, posX + ClientParticleRenderer.getROD(rand, 5.0), posY + ClientParticleRenderer.getROD(rand, 3.0), posZ + ClientParticleRenderer.getROD(rand, 5.0), 0.0, 0.0, 0.0, new int[0]);
                            continue block142;
                        }
                        case 2: {
                            world.func_175682_a(ParticleInit.BASIC_STAR_TYPE3, true, posX + ClientParticleRenderer.getROD(rand, 5.0), posY + ClientParticleRenderer.getROD(rand, 3.0), posZ + ClientParticleRenderer.getROD(rand, 5.0), 0.0, 0.0, 0.0, new int[0]);
                            continue block142;
                        }
                        case 3: {
                            world.func_175682_a(ParticleInit.BASIC_STAR_TYPE4, true, posX + ClientParticleRenderer.getROD(rand, 5.0), posY + ClientParticleRenderer.getROD(rand, 3.0), posZ + ClientParticleRenderer.getROD(rand, 5.0), 0.0, 0.0, 0.0, new int[0]);
                        }
                    }
                }
                break;
            }
            case 62: {
                for (int i = 0; i < 5; ++i) {
                    world.func_175682_a(ParticleInit.LASER_FIZZLE, true, posX + ClientParticleRenderer.getROD(rand, 1.0), posY + ClientParticleRenderer.getROD(rand, 1.0), posZ + ClientParticleRenderer.getROD(rand, 1.0), 0.0, 0.0, 0.0, new int[0]);
                }
                break;
            }
        }
    }

    public static void renderComplex(CustomParticleConfig config) {
        Level world = Minecraft.func_71410_x().field_71439_g.field_70170_p;
        Random rand = world.field_73012_v;
        if (config.particles.size() == 1) {
            ClientParticleRenderer.renderInstance(world, config.origin, rand, config.particles.get(0));
            return;
        }
        int totalWeight = 0;
        for (CustomParticleConfig.Instance instance : config.particles) {
            totalWeight += instance.weight;
        }
        block1: for (int i = 0; i < config.count; ++i) {
            int landed = rand.nextInt(totalWeight);
            for (CustomParticleConfig.Instance instance : config.particles) {
                if ((landed -= instance.weight) >= 0) continue;
                ClientParticleRenderer.renderInstance(world, config.origin, rand, instance);
                continue block1;
            }
        }
    }

    private static void renderInstance(Level world, Vec3 origin, Random rand, CustomParticleConfig.Instance instance) {
        Vec3 offset = instance.offset;
        Vec3 speed = instance.speed;
        Vec3 spread = instance.spread;
        Vec3 velSpread = instance.velSpread;
        for (int i = 0; i < instance.count; ++i) {
            world.func_175682_a(instance.particleType, instance.ignoreRange, origin.field_72450_a + offset.field_72450_a + ClientParticleRenderer.getROD(rand, spread.field_72450_a), origin.field_72448_b + offset.field_72448_b + ClientParticleRenderer.getROD(rand, spread.field_72448_b), origin.field_72449_c + offset.field_72449_c + ClientParticleRenderer.getROD(rand, spread.field_72449_c), speed.field_72450_a * ClientParticleRenderer.getROD(rand, velSpread.field_72450_a), speed.field_72448_b * ClientParticleRenderer.getROD(rand, velSpread.field_72448_b), speed.field_72449_c * ClientParticleRenderer.getROD(rand, velSpread.field_72449_c), instance.args);
        }
    }

    private static double getROD(Random rand, double multi) {
        return (-0.5 + rand.nextDouble()) * multi;
    }
}

