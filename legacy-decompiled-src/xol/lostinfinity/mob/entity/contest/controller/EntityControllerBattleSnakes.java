/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.state.BlockState
 *  net.minecraft.entity.player.Player
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.math.AABB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.world.World
 */
package xol.lostinfinity.mob.entity.contest.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.world.level.Level;
import xol.lostinfinity.block.misc.BlockBattleSnake;
import xol.lostinfinity.block.misc.BlockBattleSnakePowerup;
import xol.lostinfinity.init.BlockInit;
import xol.lostinfinity.init.ItemInit;
import xol.lostinfinity.mob.entity.contest.controller.EntityControllerBase;
import xol.lostinfinity.util.coordinates.ContestCoordinates;

public class EntityControllerBattleSnakes
extends EntityControllerBase {
    private static final Vec3i dirRight = new Vec3i(1, 0, 0);
    private static final Vec3i dirUp = new Vec3i(0, 0, 1);
    private static final int powerupTimer = 200;
    private static final int numPowerups = 2;
    ArrayList<BattleSnake> snakes = null;
    HashMap<UUID, BattleSnake> snakeMap = new HashMap();
    HashMap<UUID, BlockPos> controllerMap = null;

    public EntityControllerBattleSnakes(Level worldIn) {
        super(worldIn);
        this.func_70105_a(1.0f, 1.0f);
    }

    public void setControllerMap(HashMap<UUID, BlockPos> controllerMap) {
        this.controllerMap = controllerMap;
    }

    @Override
    public AABB getArenaAABB() {
        return ContestCoordinates.battleSnakesArenaAABB();
    }

    protected AABB getBoardAABB() {
        return ContestCoordinates.battleSnakesBoardAABB();
    }

    public void turnSnake(BlockPos pos, boolean right) {
        BattleSnake snake;
        if (this.snakeMap == null || this.controllerMap == null) {
            return;
        }
        UUID playerID = null;
        block0: for (UUID pl_id : this.getPlayerList()) {
            BlockPos controlPos = this.controllerMap.get(pl_id);
            if (controlPos == null) continue;
            for (int i = -2; i <= 2; ++i) {
                for (int j = -2; j <= 2; ++j) {
                    BlockPos checkPos = pos.func_177982_a(i, 0, j);
                    if (!checkPos.equals((Object)controlPos)) continue;
                    playerID = pl_id;
                    break block0;
                }
            }
        }
        if (playerID != null && (snake = this.snakeMap.get(playerID)) != null) {
            snake.turn(right);
        }
    }

    @Override
    public void removePlayerByUUID(UUID playerID) {
        super.removePlayerByUUID(playerID);
        this.snakeMap.remove(playerID);
    }

    @Override
    public void func_70636_d() {
        super.func_70636_d();
        if (!this.field_70170_p.field_72995_K) {
            if (this.field_70173_aa > 2 && this.snakes == null || this.controllerMap == null || this.getPlayerList().isEmpty()) {
                this.func_70106_y();
            }
            if (this.snakes != null) {
                ArrayList<BattleSnake> dead = new ArrayList<BattleSnake>();
                for (BattleSnake snake : this.snakes) {
                    if (snake == null) continue;
                    if (snake.isDead()) {
                        this.removePlayerByUUID(snake.getPlayerID());
                        dead.add(snake);
                        continue;
                    }
                    snake.update(this.field_70170_p);
                    if (this.inBoard(snake)) continue;
                    snake.die(this.field_70170_p);
                    this.removePlayerByUUID(snake.getPlayerID());
                    dead.add(snake);
                }
                this.snakes.removeAll(dead);
                if (this.field_70173_aa % 200 == 0) {
                    AABB board = this.getBoardAABB();
                    int col = (int)board.field_72336_d - (int)board.field_72340_a;
                    int row = (int)board.field_72334_f - (int)board.field_72339_c;
                    for (int i = 0; i < 2; ++i) {
                        int randX = this.field_70170_p.field_73012_v.nextInt(col);
                        int randZ = this.field_70170_p.field_73012_v.nextInt(row);
                        int roll = this.field_70170_p.field_73012_v.nextInt(10);
                        BlockPos powerupPos = new BlockPos((int)board.field_72340_a + randX, (int)board.field_72338_b + 2, (int)board.field_72339_c + randZ);
                        if (!this.field_70170_p.func_175623_d(powerupPos)) continue;
                        if (roll == 0) {
                            this.field_70170_p.func_175656_a(powerupPos, BlockInit.battleSnakePowerup.func_176203_a(2));
                            continue;
                        }
                        if (roll <= 2) {
                            this.field_70170_p.func_175656_a(powerupPos, BlockInit.battleSnakePowerup.func_176203_a(1));
                            continue;
                        }
                        this.field_70170_p.func_175656_a(powerupPos, BlockInit.battleSnakePowerup.func_176203_a(0));
                    }
                }
            }
        }
    }

    private boolean inBoard(BattleSnake snake) {
        if (snake.getHead() != null) {
            int x = snake.getHead().getPos().func_177958_n();
            int z = snake.getHead().getPos().func_177952_p();
            AABB board = this.getBoardAABB();
            return x >= (int)Math.floor(board.field_72340_a) && x <= (int)board.field_72336_d && z >= (int)board.field_72339_c && z <= (int)board.field_72334_f;
        }
        return false;
    }

    @Override
    protected void endGame() {
        if (this.snakes != null) {
            for (BattleSnake snake : this.snakes) {
                if (snake.isDead()) continue;
                snake.die(this.field_70170_p);
            }
        }
        this.func_70106_y();
    }

    @Override
    protected BlockPos getSnapPos() {
        return ContestCoordinates.battleSnakesControllerPos();
    }

    @Override
    protected void rewardPlayer(Player player, int placement) {
        BlockPos teleTo = ContestCoordinates.battleSnakesLobbyPos();
        player.func_70634_a((double)teleTo.func_177958_n(), (double)teleTo.func_177956_o(), (double)teleTo.func_177952_p());
        int reward_count = Math.min(10 + 20 * placement + (placement == this.contenderCount - 1 ? this.contenderCount * 10 : 0), 50);
        player.func_191521_c(new ItemStack(ItemInit.zirconiaCeladon, reward_count));
    }

    public void setupSnakes() {
        int x1 = (int)this.getBoardAABB().field_72340_a;
        int z1 = (int)this.getBoardAABB().field_72339_c;
        int x2 = (int)this.getBoardAABB().field_72340_a;
        int z2 = (int)this.getBoardAABB().field_72334_f;
        int x3 = (int)this.getBoardAABB().field_72336_d;
        int z3 = (int)this.getBoardAABB().field_72334_f;
        int x4 = (int)this.getBoardAABB().field_72336_d;
        int z4 = (int)this.getBoardAABB().field_72339_c;
        int y = (int)this.getBoardAABB().field_72338_b + 2;
        List<UUID> players = this.getPlayerList();
        if (players.size() != this.contenderCount) {
            return;
        }
        this.snakes = new ArrayList();
        BattleSnake snake1 = new BattleSnake(players.get(0), 1);
        BattleSnake snake2 = new BattleSnake(players.get(1), 2);
        snake1.createSnake(new BlockPos(x1, y, z1), this.field_70170_p);
        snake2.createSnake(new BlockPos(x2, y, z2), this.field_70170_p);
        this.snakes.add(snake1);
        this.snakes.add(snake2);
        this.snakeMap.put(players.get(0), snake1);
        this.snakeMap.put(players.get(1), snake2);
        if (this.contenderCount > 2) {
            BattleSnake snake3 = new BattleSnake(players.get(2), 3);
            snake3.createSnake(new BlockPos(x3, y, z3), this.field_70170_p);
            this.snakes.add(snake3);
            this.snakeMap.put(players.get(2), snake3);
        }
        if (this.contenderCount == 4) {
            BattleSnake snake4 = new BattleSnake(players.get(3), 4);
            snake4.createSnake(new BlockPos(x4, y, z4), this.field_70170_p);
            this.snakes.add(snake4);
            this.snakeMap.put(players.get(3), snake4);
        }
        if (this.snakes.size() != this.snakeMap.size()) {
            System.out.println("Snake mapping does not match number of snakes!");
        }
    }

    private class BattleSnake {
        private UUID playerID = null;
        private int num = -1;
        private int dir = 0;
        private int timer = 13;
        private int time = 0;
        private SnakeNode head = null;
        private SnakeNode tail = null;
        private boolean isDead = false;
        private boolean turned = false;

        private BattleSnake(UUID playerID, int num) {
            this.playerID = playerID;
            this.num = num;
            this.dir = num - 1;
        }

        public UUID getPlayerID() {
            return this.playerID;
        }

        public boolean isDead() {
            return this.isDead;
        }

        public void setTimer(int timer) {
            this.timer = timer;
        }

        public int getTimer() {
            return this.timer;
        }

        private Vec3i getDirectionVec() {
            switch (this.dir) {
                case 0: {
                    return dirUp;
                }
                case 1: {
                    return dirRight;
                }
                case 2: {
                    return new Vec3i(dirUp.func_177958_n() * -1, 0, dirUp.func_177952_p() * -1);
                }
                case 3: {
                    return new Vec3i(dirRight.func_177958_n() * -1, 0, dirRight.func_177952_p() * -1);
                }
            }
            return dirUp;
        }

        public void turn(boolean right) {
            if (!this.turned) {
                this.dir = !right ? (this.dir < 3 ? ++this.dir : 0) : (this.dir > 0 ? --this.dir : 4);
                this.turned = true;
            }
        }

        public void createSnake(BlockPos pos, Level world) {
            BlockPos centrePos = null;
            BlockPos headPos = null;
            switch (this.num) {
                case 1: {
                    centrePos = pos.func_177971_a(dirUp);
                    headPos = centrePos.func_177971_a(dirUp);
                    break;
                }
                case 2: {
                    centrePos = pos.func_177971_a(dirRight);
                    headPos = centrePos.func_177971_a(dirRight);
                    break;
                }
                case 3: {
                    centrePos = pos.func_177973_b(dirUp);
                    headPos = centrePos.func_177973_b(dirUp);
                    break;
                }
                case 4: {
                    centrePos = pos.func_177973_b(dirRight);
                    headPos = centrePos.func_177973_b(dirRight);
                    break;
                }
                default: {
                    return;
                }
            }
            if (centrePos != null && headPos != null) {
                SnakeNode tail = new SnakeNode(pos);
                SnakeNode centre = new SnakeNode(centrePos);
                SnakeNode head = new SnakeNode(headPos);
                head.setNext(centre);
                centre.setNext(tail);
                this.head = head;
                this.tail = tail;
                world.func_175656_a(headPos, BlockInit.battleSnake.func_176203_a(this.num - 1));
                world.func_175656_a(centrePos, BlockInit.battleSnake.func_176203_a(this.num - 1));
                world.func_175656_a(pos, BlockInit.battleSnake.func_176203_a(this.num - 1));
            }
        }

        public void advance(Level world) {
            if (this.head == null || this.tail == null) {
                return;
            }
            BlockPos next = this.head.getPos().func_177971_a(this.getDirectionVec());
            boolean fed = false;
            boolean poisoned = false;
            if (!world.func_175623_d(next)) {
                BlockState state = world.func_180495_p(next);
                Block block = state.func_177230_c();
                if (block instanceof BlockBattleSnake) {
                    this.die(world);
                    return;
                }
                if (block instanceof BlockBattleSnakePowerup) {
                    int meta = ((BlockBattleSnakePowerup)block).func_176201_c(state);
                    switch (meta) {
                        case 0: {
                            fed = true;
                            break;
                        }
                        case 1: {
                            if (this.getTimer() <= 8) break;
                            this.setTimer(this.getTimer() - 2);
                            break;
                        }
                        case 2: {
                            poisoned = true;
                        }
                    }
                }
            }
            SnakeNode oldHead = this.head;
            this.head = null;
            this.head = new SnakeNode(next);
            this.head.setNext(oldHead);
            world.func_175656_a(next, BlockInit.battleSnakeHead.func_176203_a(this.num - 1));
            world.func_175656_a(oldHead.getPos(), BlockInit.battleSnake.func_176203_a(this.num - 1));
            SnakeNode prevTail = this.tail.getPrev();
            if (prevTail == null) {
                return;
            }
            SnakeNode prevTail2 = prevTail.getPrev();
            if (prevTail2 != null && poisoned) {
                world.func_175698_g(this.tail.getPos());
                world.func_175698_g(prevTail.getPos());
                prevTail = null;
                this.tail = null;
                this.tail = prevTail2;
                prevTail2.setNext(null);
                if (this.tail.equals(this.head)) {
                    this.die(world);
                }
            } else if (!fed) {
                world.func_175698_g(this.tail.getPos());
                this.tail = null;
                this.tail = prevTail;
                prevTail.setNext(null);
            }
        }

        private void die(Level world) {
            this.isDead = true;
            SnakeNode node = this.head;
            while (node != null) {
                SnakeNode next = node.getNext();
                world.func_175698_g(node.getPos());
                node = null;
                node = next;
            }
        }

        public SnakeNode getHead() {
            return this.head;
        }

        public void update(Level world) {
            if (this.time < this.timer) {
                ++this.time;
            } else {
                this.time = 0;
                this.turned = false;
                this.advance(world);
            }
        }

        private class SnakeNode {
            private BlockPos pos = null;
            private SnakeNode next = null;
            private SnakeNode prev = null;

            private SnakeNode(BlockPos pos) {
                this.setPos(pos);
            }

            public void setPos(BlockPos pos) {
                this.pos = new BlockPos((Vec3i)pos);
            }

            public BlockPos getPos() {
                return this.pos;
            }

            public void setNext(SnakeNode next) {
                this.next = next;
                if (next != null) {
                    next.setPrev(this);
                }
            }

            public void setPrev(SnakeNode prev) {
                this.prev = prev;
            }

            public SnakeNode getPrev() {
                return this.prev;
            }

            public SnakeNode getNext() {
                return this.next;
            }
        }
    }
}

