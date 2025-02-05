/**
 * This is a class that handles the checking of collision in the
 * game.
 * 
 * 
 * There are a variety of collision checker here:
 *  > Player to Mob
 * > Mob to Player
 * > Mob to Mob
 * > Mob to Map
 * > Player to Map
 * > Projectile to Player
 * > Projectile to Mob etc
 * 
 * 
 * @author Jacob Lorenzo A. Cano (221303)
 * @author Maigela Zia L. Garcia (222810)
 * @version May 12, 2023
 **/

/*
 * I have not discussed the Java language code in my program
 * with anyone other than my instructor or the teaching assistants
 * assigned to this course.
 * 
 * I have not used Java language code obtained from another student,
 * or any other unauthorized source, either modified or unmodified.
 * 
 * If any Java language code or documentation used in my program
 * was obtained from another source, such as a textbook or website,
 * that has been clearly noted with a proper citation in the comments
 * of my program.
 */

public class CollisionChecker {

    GameFrame gp;

    public CollisionChecker(GameFrame gp) {
        this.gp = gp;
    }

    public void checkTile(Creature e) { // not player but entity, because we will use this not only to check player but
                                        // also npc/object collission

        double entityLeftWorldX = e.worldX + e.solidArea.x;
        double entityRightWorldX = e.worldX + e.solidArea.x + e.solidArea.width;

        double entityTopWorldY = e.worldY + e.solidArea.y;
        double entityBottomWorldY = e.worldY + e.solidArea.y + e.solidArea.height;

        // e.solidArea values can be seen in PlayerSprite

        // row and col
        double entityLeftCol = entityLeftWorldX / gp.tileSize;
        double entityRightCol = entityRightWorldX / gp.tileSize;
        double entityTopRow = entityTopWorldY / gp.tileSize;
        double entityBottomRow = entityBottomWorldY / gp.tileSize;

        // tile num
        // we only need check two tiles, e.g. if player = up, it will check only top
        // left shoulder and right shoulder
        int tileNum1, tileNum2;

        switch (e.direction) {
            case "up":
                entityTopRow = (entityTopWorldY - e.speed) / gp.tileSize; // player's solid area - subtract player's
                                                                          // speed.
                tileNum1 = gp.tm.mapTileNum[(int) entityLeftCol][(int) entityTopRow]; // tile 1 is upper left point ng
                                                                                      // solid area
                tileNum2 = gp.tm.mapTileNum[(int) entityRightCol][(int) entityTopRow]; // tile 1 is upper right point ng
                                                                                       // solid area
                if (gp.tm.tile[tileNum1].collision == true || gp.tm.tile[tileNum2].collision == true) {
                    e.collisionOn = true;
                }
                break;
            case "down":
                entityBottomRow = (entityBottomWorldY + e.speed) / gp.tileSize; // player's solid area + subtract
                                                                                // player's speed. //check bottom row
                tileNum1 = gp.tm.mapTileNum[(int) entityLeftCol][(int) entityBottomRow]; // tile 1 is upper left point
                                                                                         // ng solid area
                tileNum2 = gp.tm.mapTileNum[(int) entityRightCol][(int) entityBottomRow]; // tile 1 is upper right point
                                                                                          // ng solid area
                if (gp.tm.tile[tileNum1].collision == true || gp.tm.tile[tileNum2].collision == true) {
                    e.collisionOn = true;
                }
                break;
            case "left":
                entityLeftCol = (entityLeftWorldX - e.speed) / gp.tileSize; // player's solid area - subtract player's
                                                                            // speed.
                tileNum1 = gp.tm.mapTileNum[(int) entityLeftCol][(int) entityTopRow]; // tile 1 is upper left point ng
                                                                                      // solid area
                tileNum2 = gp.tm.mapTileNum[(int) entityLeftCol][(int) entityBottomRow]; // tile 1 is upper right point
                                                                                         // ng solid area
                if (gp.tm.tile[tileNum1].collision == true || gp.tm.tile[tileNum2].collision == true) {
                    e.collisionOn = true;
                }
                break;
            case "right":
                entityRightCol = (entityRightWorldX + e.speed) / gp.tileSize; // player's solid area - subtract player's
                                                                              // speed.
                tileNum1 = gp.tm.mapTileNum[(int) entityRightCol][(int) entityTopRow]; // tile 1 is upper left point ng
                                                                                       // solid area
                tileNum2 = gp.tm.mapTileNum[(int) entityRightCol][(int) entityBottomRow]; // tile 1 is upper right point
                                                                                          // ng solid area
                if (gp.tm.tile[tileNum1].collision == true || gp.tm.tile[tileNum2].collision == true) {
                    e.collisionOn = true;
                }
                break;
        }

    }

    public int checkStoneObject(Creature e, boolean player) { // check if entity is player or not...

        // we used .intersect here since we only needed a limited number of items aka
        // stone.length;
        // also its not needed to check everytile in the map [ON THE SCREEN];
        int index = 777; // check if player is hitting any object

        for (int i = 0; i < gp.stone.length; i++) { // scan object-element array

            if (gp.stone[i] != null) {

                // Get obj's solid area position
                e.solidArea.x = (int) e.worldX + e.solidArea.x;
                e.solidArea.y = (int) e.worldY + e.solidArea.y;

                // Get object's solid area ; this will be helpful if i set object specific
                // values
                gp.stone[i].solidArea.x = gp.stone[i].worldX + gp.stone[i].solidArea.x;
                gp.stone[i].solidArea.y = gp.stone[i].worldY + gp.stone[i].solidArea.y;

                switch (e.direction) { // y position that the entity will be, after it moved.
                    case "up":
                        e.solidArea.y -= e.speed;
                        if (e.solidArea.intersects(gp.stone[i].solidArea)) { // checks if two rectangles are colliding
                            if (gp.stone[i].collision == true) { // check if object is solid or not; if it's solid then
                                                                 // e.collisionOn = true
                                e.collisionOn = true;
                            }
                            if (player == true) { // npcs/monsters cant pickup object
                                index = i;
                            }
                            // System.out.println("up collision!");
                        }
                        break;
                    case "down":
                        e.solidArea.y += e.speed;
                        if (e.solidArea.intersects(gp.stone[i].solidArea)) { // checks if two rectangles are colliding
                            if (gp.stone[i].collision == true) { // check if object is solid or not; if it's solid then
                                                                 // e.collisionOn = true
                                e.collisionOn = true;
                            }
                            if (player == true) { // npcs/monsters cant pickup object
                                index = i;
                            }
                            // System.out.println("down collision!");
                        }
                        break;
                    case "left":
                        e.solidArea.x -= e.speed;
                        if (e.solidArea.intersects(gp.stone[i].solidArea)) { // checks if two rectangles are colliding
                            if (gp.stone[i].collision == true) { // check if object is solid or not; if it's solid then
                                                                 // e.collisionOn = true
                                e.collisionOn = true;
                            }
                            if (player == true) { // npcs/monsters cant pickup object
                                index = i;
                            }
                            // System.out.println("left collision!");
                        }
                        break;
                    case "right":
                        e.solidArea.x += e.speed;
                        if (e.solidArea.intersects(gp.stone[i].solidArea)) { // checks if two rectangles are colliding
                            if (gp.stone[i].collision == true) { // check if object is solid or not; if it's solid then
                                                                 // e.collisionOn = true
                                e.collisionOn = true;
                            }
                            if (player == true) { // npcs/monsters cant pickup object
                                index = i;
                            }
                            // System.out.println("right collision!");
                        }
                        break;
                }
                e.solidArea.x = e.solidAreaDefaultX;
                e.solidArea.y = e.solidAreaDefaultY;
                gp.stone[i].solidArea.x = gp.stone[i].solidAreaDefaultX;
                gp.stone[i].solidArea.y = gp.stone[i].solidAreaDefaultY;
            }

        }

        return index;
    }

    public int checkObjects(Creature e, Object[] mob, boolean player) { // player to object

        // we used .intersect here since we only needed a limited number of items aka
        // stone.length;
        // also its not needed to check everytile in the map [ON THE SCREEN];
        int index = 777; // check if player is hitting any object

        for (int i = 0; i < mob.length; i++) { // scan object-element array

            if (mob[i] != null) {

                // Get obj's solid area position
                e.solidArea.x = (int) e.worldX + e.solidArea.x;
                e.solidArea.y = (int) e.worldY + e.solidArea.y;

                // Get object's solid area ; this will be helpful if i set object specific
                // values
                mob[i].solidArea.x = (int) mob[i].worldX + mob[i].solidArea.x;
                mob[i].solidArea.y = (int) mob[i].worldY + mob[i].solidArea.y;

                switch (e.direction) { // y position that the entity will be, after it moved.
                    case "up":
                        e.solidArea.y -= e.speed;
                        if (e.solidArea.intersects(mob[i].solidArea)) { // checks if two rectangles are colliding
                            // check if object is solid or not; if it's solid then e.collisionOn = true
                            e.collisionOn = true;

                            int boost = 2;

                            for (int s = 0; s < boost; s++) {
                                if (gp.me.life != gp.me.maxLife) {
                                    gp.me.life += 1;
                                }
                            }

                            if (player == true) { // npcs/monsters cant pickup object
                                index = i;
                            }

                            gp.obj[index].itemEquip = true;

                        }

                        break;
                    case "down":
                        e.solidArea.y += e.speed;
                        if (e.solidArea.intersects(mob[i].solidArea)) { // checks if two rectangles are colliding
                            // check if object is solid or not; if it's solid then e.collisionOn = true
                            int boost = 2;

                            for (int s = 0; s < boost; s++) {
                                if (gp.me.life != gp.me.maxLife) {
                                    gp.me.life += 1;
                                }
                            }

                            if (player == true) { // npcs/monsters cant pickup object
                                index = i;
                            }
                            // System.out.println("down collision!");
                        }
                        break;
                    case "left":
                        e.solidArea.x -= e.speed;
                        if (e.solidArea.intersects(mob[i].solidArea)) { // checks if two rectangles are colliding
                            // check if object is solid or not; if it's solid then e.collisionOn = true
                            int boost = 2;

                            for (int s = 0; s < boost; s++) {
                                if (gp.me.life != gp.me.maxLife) {
                                    gp.me.life += 1;
                                }
                            }

                            if (player == true) { // npcs/monsters cant pickup object
                                index = i;
                            }
                            // System.out.println("left collision!");
                        }
                        break;
                    case "right":
                        e.solidArea.x += e.speed;
                        if (e.solidArea.intersects(mob[i].solidArea)) { // checks if two rectangles are colliding
                            // check if object is solid or not; if it's solid then e.collisionOn = true
                            int boost = 2;

                            for (int s = 0; s < boost; s++) {
                                if (gp.me.life != gp.me.maxLife) {
                                    gp.me.life += 1;
                                }
                            }

                            if (player == true) { // npcs/monsters cant pickup object
                                index = i;
                            }
                            // System.out.println("right collision!");
                        }
                        break;
                }
                e.solidArea.x = e.solidAreaDefaultX;
                e.solidArea.y = e.solidAreaDefaultY;
                mob[i].solidArea.x = mob[i].solidAreaDefaultX;
                mob[i].solidArea.y = mob[i].solidAreaDefaultY;
            }

        }
        return index;
    }

    public int checkProjectile(Creature e, Creature[] mob, boolean player) { // PLAYER TO MOB

        // we used .intersect here since we only needed a limited number of items aka
        // stone.length;
        // also its not needed to check everytile in the map [ON THE SCREEN];
        int index = 777; // check if player is hitting any object

        for (int i = 0; i < mob.length; i++) { // scan object-element array

            if (mob[i] != null) {

                // Get obj's solid area position
                e.solidArea.x = (int) e.worldX + e.solidArea.x;
                e.solidArea.y = (int) e.worldY + e.solidArea.y;

                // Get object's solid area ; this will be helpful if i set object specific
                // values
                mob[i].solidArea.x = (int) mob[i].worldX + mob[i].solidArea.x;
                mob[i].solidArea.y = (int) mob[i].worldY + mob[i].solidArea.y;

                switch (e.direction) { // y position that the entity will be, after it moved.
                    case "up":
                        e.solidArea.y -= e.speed;
                        if (e.solidArea.intersects(mob[i].solidArea)) { // checks if two rectangles are colliding
                            // check if object is solid or not; if it's solid then e.collisionOn = true
                            if (mob[i] != e) {
                                e.collisionOn = true;
                            }

                            if (player == true) { // npcs/monsters cant pickup object
                                index = i;
                            }
                            // System.out.println("up collision!");

                        }

                        break;
                    case "down":
                        e.solidArea.y += e.speed;
                        if (e.solidArea.intersects(mob[i].solidArea)) { // checks if two rectangles are colliding
                            // check if object is solid or not; if it's solid then e.collisionOn = true
                            if (mob[i] != e) {
                                e.collisionOn = true;
                            }
                            if (player == true) { // npcs/monsters cant pickup object
                                index = i;
                            }
                            // System.out.println("down collision!");
                        }
                        break;
                    case "left":
                        e.solidArea.x -= e.speed;
                        if (e.solidArea.intersects(mob[i].solidArea)) { // checks if two rectangles are colliding
                            // check if object is solid or not; if it's solid then e.collisionOn = true
                            if (mob[i] != e) {
                                e.collisionOn = true;
                            }

                            if (player == true) { // npcs/monsters cant pickup object
                                index = i;
                            }
                            // System.out.println("left collision!");
                        }
                        break;
                    case "right":
                        e.solidArea.x += e.speed;
                        if (e.solidArea.intersects(mob[i].solidArea)) { // checks if two rectangles are colliding
                            // check if object is solid or not; if it's solid then e.collisionOn = true

                            if (mob[i] != e) {
                                e.collisionOn = true;
                            }

                            if (player == true) { // npcs/monsters cant pickup object
                                index = i;
                            }
                            // System.out.println("right collision!");
                        }
                        break;
                }

                if (e.solidArea.intersects(mob[i].solidArea)) { // checks if two rectangles are colliding
                    // check if object is solid or not; if it's solid then e.collisionOn = true
                    if (mob[i] != e) {
                        e.collisionOn = true;
                    }
                    if (player == true) { // npcs/monsters cant pickup object
                        index = i;
                    }
                    // System.out.println("down collision!");
                }
                e.solidArea.x = e.solidAreaDefaultX;
                e.solidArea.y = e.solidAreaDefaultY;
                mob[i].solidArea.x = mob[i].solidAreaDefaultX;
                mob[i].solidArea.y = mob[i].solidAreaDefaultY;
            }

        }
        return index;

    }

    public int checkProjectile2(Creature e, Creature[] mob, boolean player) { // PLAYER TO MOB

        // we used .intersect here since we only needed a limited number of items aka
        // stone.length;
        // also its not needed to check everytile in the map [ON THE SCREEN];
        int index = 777; // check if player is hitting any object

        for (int i = 0; i < mob.length; i++) { // scan object-element array

            if (mob[i] != null) {

                // Get obj's solid area position
                e.solidArea.x = (int) e.worldX + e.solidArea.x;
                e.solidArea.y = (int) e.worldY + e.solidArea.y;

                // Get object's solid area ; this will be helpful if i set object specific
                // values
                mob[i].solidArea.x = (int) mob[i].worldX + mob[i].solidArea.x;
                mob[i].solidArea.y = (int) mob[i].worldY + mob[i].solidArea.y;

                switch (e.direction) { // y position that the entity will be, after it moved.
                    case "up":
                        e.solidArea.y -= e.speed;
                        if (e.solidArea.intersects(mob[i].solidArea)) { // checks if two rectangles are colliding
                            // check if object is solid or not; if it's solid then e.collisionOn = true
                            if (mob[i] != e) {
                                e.collisionOn = true;
                                index = i;
                            }

                            if (player == true) { // npcs/monsters cant pickup object
                                index = i;
                            }
                            // System.out.println("up collision!");

                        }

                        break;
                    case "down":
                        e.solidArea.y += e.speed;
                        if (e.solidArea.intersects(mob[i].solidArea)) { // checks if two rectangles are colliding
                            // check if object is solid or not; if it's solid then e.collisionOn = true
                            if (mob[i] != e) {
                                e.collisionOn = true;
                                index = i;
                            }
                            if (player == true) { // npcs/monsters cant pickup object
                                index = i;
                            }
                            // System.out.println("down collision!");
                        }
                        break;
                    case "left":
                        e.solidArea.x -= e.speed;
                        if (e.solidArea.intersects(mob[i].solidArea)) { // checks if two rectangles are colliding
                            // check if object is solid or not; if it's solid then e.collisionOn = true
                            if (mob[i] != e) {
                                e.collisionOn = true;
                                index = i;
                            }

                            if (player == true) { // npcs/monsters cant pickup object
                                index = i;
                            }
                            // System.out.println("left collision!");
                        }
                        break;
                    case "right":
                        e.solidArea.x += e.speed;
                        if (e.solidArea.intersects(mob[i].solidArea)) { // checks if two rectangles are colliding
                            // check if object is solid or not; if it's solid then e.collisionOn = true

                            if (mob[i] != e) {
                                e.collisionOn = true;
                                index = i;
                            }

                            if (player == true) { // npcs/monsters cant pickup object
                                index = i;
                            }
                            // System.out.println("right collision!");
                        }
                        break;
                }

                if (e.solidArea.intersects(mob[i].solidArea)) { // checks if two rectangles are colliding
                    // check if object is solid or not; if it's solid then e.collisionOn = true
                    if (mob[i] != e) {
                        e.collisionOn = true;
                        index = i;
                    }
                    if (player == true) { // npcs/monsters cant pickup object
                        index = i;
                    }
                    // System.out.println("down collision!");
                }
                e.solidArea.x = e.solidAreaDefaultX;
                e.solidArea.y = e.solidAreaDefaultY;
                mob[i].solidArea.x = mob[i].solidAreaDefaultX;
                mob[i].solidArea.y = mob[i].solidAreaDefaultY;
            }

        }
        return index;

    }

    public int checkProjectile3(Creature e, Creature mob, boolean player) { // PLAYER TO MOB

        // we used .intersect here since we only needed a limited number of items aka
        // stone.length;
        // also its not needed to check everytile in the map [ON THE SCREEN];
        int index = 777; // check if player is hitting any object

        // scan object-element array

        if (mob != null) {

            // Get obj's solid area position
            e.solidArea.x = (int) e.worldX + e.solidArea.x;
            e.solidArea.y = (int) e.worldY + e.solidArea.y;

            // Get object's solid area ; this will be helpful if i set object specific
            // values
            mob.solidArea.x = (int) mob.worldX + mob.solidArea.x;
            mob.solidArea.y = (int) mob.worldY + mob.solidArea.y;

            switch (e.direction) { // y position that the entity will be, after it moved.
                case "up":
                    e.solidArea.y -= e.speed;
                    if (e.solidArea.intersects(mob.solidArea)) { // checks if two rectangles are colliding
                        // check if object is solid or not; if it's solid then e.collisionOn = true
                        if (mob != e) {
                            e.collisionOn = true;
                        }

                        if (player == true) { // npcs/monsters cant pickup object
                            index = 0;
                        }
                        // System.out.println("up collision!");

                    }

                    break;
                case "down":
                    e.solidArea.y += e.speed;
                    if (e.solidArea.intersects(mob.solidArea)) { // checks if two rectangles are colliding
                        // check if object is solid or not; if it's solid then e.collisionOn = true
                        if (mob != e) {
                            e.collisionOn = true;
                        }
                        if (player == true) { // npcs/monsters cant pickup object
                            index = 0;
                        }
                        // System.out.println("down collision!");
                    }
                    break;
                case "left":
                    e.solidArea.x -= e.speed;
                    if (e.solidArea.intersects(mob.solidArea)) { // checks if two rectangles are colliding
                        // check if object is solid or not; if it's solid then e.collisionOn = true
                        if (mob != e) {
                            e.collisionOn = true;
                        }

                        if (player == true) { // npcs/monsters cant pickup object
                            index = 0;
                        }
                        // System.out.println("left collision!");
                    }
                    break;
                case "right":
                    e.solidArea.x += e.speed;
                    if (e.solidArea.intersects(mob.solidArea)) { // checks if two rectangles are colliding
                        // check if object is solid or not; if it's solid then e.collisionOn = true

                        if (mob != e) {
                            e.collisionOn = true;
                        }

                        if (player == true) { // npcs/monsters cant pickup object
                            index = 0;
                        }
                        // System.out.println("right collision!");
                    }
                    break;
            }

            if (e.solidArea.intersects(mob.solidArea)) { // checks if two rectangles are colliding
                // check if object is solid or not; if it's solid then e.collisionOn = true
                if (mob != e) {
                    e.collisionOn = true;
                }
                if (player == true) { // npcs/monsters cant pickup object
                    index = 0;
                }
                // System.out.println("down collision!");
            }
            e.solidArea.x = e.solidAreaDefaultX;
            e.solidArea.y = e.solidAreaDefaultY;
            mob.solidArea.x = mob.solidAreaDefaultX;
            mob.solidArea.y = mob.solidAreaDefaultY;
        }

        return index;

    }

    // mobs colison

    public int checkMob(Creature e, Creature[] mob, boolean player) { // PLAYER TO MOB

        // we used .intersect here since we only needed a limited number of items aka
        // stone.length;
        // also its not needed to check everytile in the map [ON THE SCREEN];
        int index = 777; // check if player is hitting any object

        for (int i = 0; i < mob.length; i++) { // scan object-element array

            if (mob[i] != null) {

                // Get obj's solid area position
                e.solidArea.x = (int) e.worldX + e.solidArea.x;
                e.solidArea.y = (int) e.worldY + e.solidArea.y;

                // Get object's solid area ; this will be helpful if i set object specific
                // values
                mob[i].solidArea.x = (int) mob[i].worldX + mob[i].solidArea.x;
                mob[i].solidArea.y = (int) mob[i].worldY + mob[i].solidArea.y;

                switch (e.direction) { // y position that the entity will be, after it moved.
                    case "up":
                        e.solidArea.y -= e.speed;
                        if (gp.me.solidArea.intersects(mob[i].solidArea)) { // checks if two rectangles are colliding
                            // check if object is solid or not; if it's solid then e.collisionOn = true
                            if (mob[i] != e) {
                                e.collisionOn = true;
                            }

                            if (player == true) { // npcs/monsters cant pickup object
                                index = i;
                            }
                            // System.out.println("up collision!");

                        }

                        break;
                    case "down":
                        e.solidArea.y += e.speed;
                        if (gp.me.solidArea.intersects(mob[i].solidArea)) { // checks if two rectangles are colliding
                            // check if object is solid or not; if it's solid then e.collisionOn = true
                            if (mob[i] != e) {
                                e.collisionOn = true;
                            }
                            if (player == true) { // npcs/monsters cant pickup object
                                index = i;
                            }
                            // System.out.println("down collision!");
                        }
                        break;
                    case "left":
                        e.solidArea.x -= e.speed;
                        if (gp.me.solidArea.intersects(mob[i].solidArea)) { // checks if two rectangles are colliding
                            // check if object is solid or not; if it's solid then e.collisionOn = true
                            if (mob[i] != e) {
                                e.collisionOn = true;
                            }

                            if (player == true) { // npcs/monsters cant pickup object
                                index = i;
                            }
                            // System.out.println("left collision!");
                        }
                        break;
                    case "right":
                        e.solidArea.x += e.speed;
                        if (gp.me.solidArea.intersects(mob[i].solidArea)) { // checks if two rectangles are colliding
                            // check if object is solid or not; if it's solid then e.collisionOn = true

                            if (mob[i] != e) {
                                e.collisionOn = true;
                            }

                            if (player == true) { // npcs/monsters cant pickup object
                                index = i;
                            }
                            // System.out.println("right collision!");
                        }
                        break;
                }
                e.solidArea.x = e.solidAreaDefaultX;
                e.solidArea.y = e.solidAreaDefaultY;
                mob[i].solidArea.x = mob[i].solidAreaDefaultX;
                mob[i].solidArea.y = mob[i].solidAreaDefaultY;
            }

        }
        return index;

    }

    public int checkMob2(Creature e, Creature[] mob, boolean player) { // PLAYER2 TO MOB

        // we used .intersect here since we only needed a limited number of items aka
        // stone.length;
        // also its not needed to check everytile in the map [ON THE SCREEN];
        int index = 777; // check if player is hitting any object

        for (int i = 0; i < mob.length; i++) { // scan object-element array

            if (mob[i] != null) {

                // Get obj's solid area position
                e.solidArea.x = (int) e.worldX + e.solidArea.x;
                e.solidArea.y = (int) e.worldY + e.solidArea.y;

                // Get object's solid area ; this will be helpful if i set object specific
                // values
                mob[i].solidArea.x = (int) mob[i].worldX + mob[i].solidArea.x;
                mob[i].solidArea.y = (int) mob[i].worldY + mob[i].solidArea.y;

                switch (e.direction) { // y position that the entity will be, after it moved.
                    case "up":
                        e.solidArea.y -= e.speed;
                        if (gp.enemy[0].solidArea.intersects(mob[i].solidArea)) { // checks if two rectangles are
                                                                                  // colliding
                            // check if object is solid or not; if it's solid then e.collisionOn = true
                            if (mob[i] != e) {
                                e.collisionOn = true;
                            }

                            if (player == true) { // npcs/monsters cant pickup object
                                index = i;
                            }
                            // System.out.println("up collision!");

                        }

                        break;
                    case "down":
                        e.solidArea.y += e.speed;
                        if (gp.enemy[0].solidArea.intersects(mob[i].solidArea)) { // checks if two rectangles are
                                                                                  // colliding
                            // check if object is solid or not; if it's solid then e.collisionOn = true
                            if (mob[i] != e) {
                                e.collisionOn = true;
                            }
                            if (player == true) { // npcs/monsters cant pickup object
                                index = i;
                            }
                            // System.out.println("down collision!");
                        }
                        break;
                    case "left":
                        e.solidArea.x -= e.speed;
                        if (gp.enemy[0].solidArea.intersects(mob[i].solidArea)) { // checks if two rectangles are
                                                                                  // colliding
                            // check if object is solid or not; if it's solid then e.collisionOn = true
                            if (mob[i] != e) {
                                e.collisionOn = true;
                            }

                            if (player == true) { // npcs/monsters cant pickup object
                                index = i;
                            }
                            // System.out.println("left collision!");
                        }
                        break;
                    case "right":
                        e.solidArea.x += e.speed;
                        if (gp.enemy[0].solidArea.intersects(mob[i].solidArea)) { // checks if two rectangles are
                                                                                  // colliding
                            // check if object is solid or not; if it's solid then e.collisionOn = true

                            if (mob[i] != e) {
                                e.collisionOn = true;
                            }

                            if (player == true) { // npcs/monsters cant pickup object
                                index = i;
                            }
                            // System.out.println("right collision!");
                        }
                        break;
                }
                e.solidArea.x = e.solidAreaDefaultX;
                e.solidArea.y = e.solidAreaDefaultY;
                mob[i].solidArea.x = mob[i].solidAreaDefaultX;
                mob[i].solidArea.y = mob[i].solidAreaDefaultY;
            }

        }
        return index;

    }

    public int checkMobToShield(Creature e, Creature[] mob, boolean player) { // PLAYER TO MOB

        // we used .intersect here since we only needed a limited number of items aka
        // stone.length;
        // also its not needed to check everytile in the map [ON THE SCREEN];
        int index = 777; // check if player is hitting any object

        for (int i = 0; i < mob.length; i++) { // scan object-element array
            if (mob[i] != null) {

                // Get obj's solid area position
                e.solidArea.x = (int) e.worldX + e.solidArea.x;
                e.solidArea.y = (int) e.worldY + e.solidArea.y;

                // Get object's solid area ; this will be helpful if i set object specific
                // values
                mob[i].solidArea.x = (int) mob[i].worldX + mob[i].solidArea.x;
                mob[i].solidArea.y = (int) mob[i].worldY + mob[i].solidArea.y;

                switch (e.direction) { // y position that the entity will be, after it moved.
                    case "up":
                        e.solidArea.y -= e.speed;
                        if (mob[i].solidArea.intersects(e.solidArea)) { // checks if two rectangles are colliding
                            // check if object is solid or not; if it's solid then e.collisionOn = true
                            if (mob[i] != e) {
                                e.collisionOn = true;
                            }

                            if (player == true) { // npcs/monsters cant pickup object
                                index = i;
                            }
                            // System.out.println("up collision!");

                        }

                        break;
                    case "down":
                        e.solidArea.y += e.speed;
                        if (mob[i].solidArea.intersects(e.solidArea)) { // checks if two rectangles are colliding
                            // check if object is solid or not; if it's solid then e.collisionOn = true
                            if (mob[i] != e) {
                                e.collisionOn = true;
                            }
                            if (player == true) { // npcs/monsters cant pickup object
                                index = i;
                            }
                            // System.out.println("down collision!");
                        }
                        break;
                    case "left":
                        e.solidArea.x -= e.speed;
                        if (mob[i].solidArea.intersects(e.solidArea)) { // checks if two rectangles are colliding
                            // check if object is solid or not; if it's solid then e.collisionOn = true
                            if (mob[i] != e) {
                                e.collisionOn = true;
                            }

                            if (player == true) { // npcs/monsters cant pickup object
                                index = i;
                            }
                            // System.out.println("left collision!");
                        }
                        break;
                    case "right":
                        e.solidArea.x += e.speed;
                        if (mob[i].solidArea.intersects(e.solidArea)) { // checks if two rectangles are colliding
                            // check if object is solid or not; if it's solid then e.collisionOn = true

                            if (mob[i] != e) {
                                e.collisionOn = true;
                            }

                            if (player == true) { // npcs/monsters cant pickup object
                                index = i;
                            }
                            // System.out.println("right collision!");
                        }
                        break;
                }

                if (mob[i].solidArea.intersects(e.solidArea)) { // checks if two rectangles are colliding
                    // check if object is solid or not; if it's solid then e.collisionOn = true
                    if (mob[i] != e) {
                        e.collisionOn = true;
                    }
                    if (player == true) { // npcs/monsters cant pickup object
                        index = i;
                    }
                    // System.out.println("down collision!");
                }
                e.solidArea.x = e.solidAreaDefaultX;
                e.solidArea.y = e.solidAreaDefaultY;
                mob[i].solidArea.x = mob[i].solidAreaDefaultX;
                mob[i].solidArea.y = mob[i].solidAreaDefaultY;
            }

        }
        return index;

    }

    public int checkMobToPlayer(Creature e, Creature[] mob, boolean player) { // Mob to Player [bawas points]

        // we used .intersect here since we only needed a limited number of items aka
        // stone.length;
        // also its not needed to check everytile in the map [ON THE SCREEN];
        int index = 777; // check if player is hitting any object

        for (int i = 0; i < mob.length; i++) { // scan object-element array

            if (mob[i] != null) {

                // Get obj's solid area position
                e.solidArea.x = (int) e.worldX + e.solidArea.x;
                e.solidArea.y = (int) e.worldY + e.solidArea.y;

                // Get object's solid area ; this will be helpful if i set object specific
                // values
                mob[i].solidArea.x = (int) mob[i].worldX + mob[i].solidArea.x;
                mob[i].solidArea.y = (int) mob[i].worldY + mob[i].solidArea.y;

                switch (e.direction) { // y position that the entity will be, after it moved.
                    case "up":
                        e.solidArea.y -= e.speed;
                        if (mob[i].solidArea.intersects(gp.me.solidArea)) { // checks if two rectangles are colliding
                            // check if object is solid or not; if it's solid then e.collisionOn = true
                            if (mob[i] != e) {
                                e.collisionOn = true;
                            }

                            if (player == true) { // npcs/monsters cant pickup object
                                index = i;
                            }
                            // System.out.println("up collision!");

                        }

                        break;
                    case "down":
                        e.solidArea.y += e.speed;
                        if (mob[i].solidArea.intersects(gp.me.solidArea)) { // checks if two rectangles are colliding
                            // check if object is solid or not; if it's solid then e.collisionOn = true
                            if (mob[i] != e) {
                                e.collisionOn = true;
                            }
                            if (player == true) { // npcs/monsters cant pickup object
                                index = i;
                            }
                            // System.out.println("down collision!");
                        }
                        break;
                    case "left":
                        e.solidArea.x -= e.speed;
                        if (mob[i].solidArea.intersects(gp.me.solidArea)) { // checks if two rectangles are colliding
                            // check if object is solid or not; if it's solid then e.collisionOn = true
                            if (mob[i] != e) {
                                e.collisionOn = true;
                            }

                            if (player == true) { // npcs/monsters cant pickup object
                                index = i;
                            }
                            // System.out.println("left collision!");
                        }
                        break;
                    case "right":
                        e.solidArea.x += e.speed;
                        if (mob[i].solidArea.intersects(gp.me.solidArea)) { // checks if two rectangles are colliding
                            // check if object is solid or not; if it's solid then e.collisionOn = true

                            if (mob[i] != e) {
                                e.collisionOn = true;
                            }

                            if (player == true) { // npcs/monsters cant pickup object
                                index = i;
                            }
                            // System.out.println("right collision!");
                        }
                        break;
                }
                e.solidArea.x = e.solidAreaDefaultX;
                e.solidArea.y = e.solidAreaDefaultY;
                mob[i].solidArea.x = mob[i].solidAreaDefaultX;
                mob[i].solidArea.y = mob[i].solidAreaDefaultY;
            }

        }
        return index;

    }

    public boolean checkMobToPlayer_(Creature e) {

        boolean contact = false;
        // Get obj's solid area position
        e.solidArea.x = (int) e.worldX + e.solidArea.x;
        e.solidArea.y = (int) e.worldY + e.solidArea.y;

        // Get object's solid area ; this will be helpful if i set object specific
        // values
        gp.me.solidArea.x = (int) gp.me.worldX + gp.me.solidArea.x;
        gp.me.solidArea.y = (int) gp.me.worldY + gp.me.solidArea.y;

        switch (e.direction) { // y position that the entity will be, after it moved.
            case "up":
                e.solidArea.y -= e.speed;
                if (e.solidArea.intersects(gp.me.solidArea)) { // checks if two rectangles are colliding
                    // check if object is solid or not; if it's solid then e. On = true
                    e.collisionOn = true;

                    // System.out.println("up collision!");
                }
                break;
            case "down":
                e.solidArea.y += e.speed;
                if (e.solidArea.intersects(gp.me.solidArea)) { // checks if two rectangles are colliding
                    e.collisionOn = true;
                    // System.out.println("down collision!");
                }
                break;
            case "left":
                e.solidArea.x -= e.speed;
                if (e.solidArea.intersects(gp.me.solidArea)) { // checks if two rectangles are colliding
                    e.collisionOn = true;
                    // System.out.println("left collision!");
                }
                break;
            case "right":
                e.solidArea.x += e.speed;
                if (e.solidArea.intersects(gp.me.solidArea)) { // checks if two rectangles are colliding
                    e.collisionOn = true;
                    // System.out.println("right collision!");
                }
                break;
        }

        if (e.solidArea.intersects(gp.me.solidArea)) { // checks if two rectangles are colliding
            // check if object is solid or not; if it's solid then e. On = true
            e.collisionOn = true;
            contact = true;

            // System.out.println("up collision!");
        }
        e.solidArea.x = e.solidAreaDefaultX;
        e.solidArea.y = e.solidAreaDefaultY;
        gp.me.solidArea.x = gp.me.solidAreaDefaultX;
        gp.me.solidArea.y = gp.me.solidAreaDefaultY;

        return contact;

    }

    public void checkMobToPlayer_2(Creature e) {

        // Get obj's solid area position
        e.solidArea.x = (int) e.worldX + e.solidArea.x;
        e.solidArea.y = (int) e.worldY + e.solidArea.y;

        // Get object's solid area ; this will be helpful if i set object specific
        // values
        gp.enemy[0].solidArea.x = (int) gp.enemy[0].worldX + gp.enemy[0].solidArea.x;
        gp.enemy[0].solidArea.y = (int) gp.enemy[0].worldY + gp.enemy[0].solidArea.y;

        switch (e.direction) { // y position that the entity will be, after it moved.
            case "up":
                e.solidArea.y -= e.speed;
                if (e.solidArea.intersects(gp.enemy[0].solidArea)) { // checks if two rectangles are colliding
                    // check if object is solid or not; if it's solid then e. On = true
                    e.collisionOn = true;

                    // System.out.println("up collision!");
                }
                break;
            case "down":
                e.solidArea.y += e.speed;
                if (e.solidArea.intersects(gp.enemy[0].solidArea)) { // checks if two rectangles are colliding
                    e.collisionOn = true;
                    // System.out.println("down collision!");
                }
                break;
            case "left":
                e.solidArea.x -= e.speed;
                if (e.solidArea.intersects(gp.enemy[0].solidArea)) { // checks if two rectangles are colliding
                    e.collisionOn = true;
                    // System.out.println("left collision!");
                }
                break;
            case "right":
                e.solidArea.x += e.speed;
                if (e.solidArea.intersects(gp.enemy[0].solidArea)) { // checks if two rectangles are colliding
                    e.collisionOn = true;
                    // System.out.println("right collision!");
                }
                break;
        }
        e.solidArea.x = e.solidAreaDefaultX;
        e.solidArea.y = e.solidAreaDefaultY;
        gp.enemy[0].solidArea.x = gp.enemy[0].solidAreaDefaultX;
        gp.enemy[0].solidArea.y = gp.enemy[0].solidAreaDefaultY;

    }

    public int checkSign(Creature e, Creature[] sign, boolean player) {

        int index = 777; // check if player is hitting any object

        for (int i = 0; i < sign.length; i++) { // scan object-element array

            if (sign[i] != null) {

                // Get obj's solid area position
                e.solidArea.x = (int) e.worldX + e.solidArea.x;
                e.solidArea.y = (int) e.worldY + e.solidArea.y;

                // Get object's solid area ; this will be helpful if i set object specific
                // values
                sign[i].solidArea.x = (int) sign[i].worldX + sign[i].solidArea.x;
                sign[i].solidArea.y = (int) sign[i].worldY + sign[i].solidArea.y;

                switch (e.direction) { // y position that the entity will be, after it moved.
                    case "up":
                        e.solidArea.y -= e.speed;
                        if (gp.me.solidArea.intersects(sign[i].solidArea)) { // checks if two rectangles are colliding
                            // check if object is solid or not; if it's solid then e.collisionOn = true
                            // e.collisionOn = true;
                            index = i;
                            if (player == true) { // npcs/monsters cant pickup object

                            }
                            // System.out.println("up collision!");
                        }
                        break;
                    case "down":
                        e.solidArea.y += e.speed;
                        if (gp.me.solidArea.intersects(sign[i].solidArea)) { // checks if two rectangles are colliding
                            // check if object is solid or not; if it's solid then e.collisionOn = true
                            // e.collisionOn = true;
                            index = i;
                            if (player == true) { // npcs/monsters cant pickup object
                                index = i;
                            }
                            // System.out.println("down collision!");
                        }
                        break;
                    case "left":
                        e.solidArea.x -= e.speed;
                        if (gp.me.solidArea.intersects(sign[i].solidArea)) { // checks if two rectangles are colliding
                            // check if object is solid or not; if it's solid then e.collisionOn = true
                            // e.collisionOn = true;
                            index = i;
                            if (player == true) { // npcs/monsters cant pickup object
                                index = i;
                            }
                            // System.out.println("left collision!");
                        }
                        break;
                    case "right":
                        e.solidArea.x += e.speed;
                        if (gp.me.solidArea.intersects(sign[i].solidArea)) { // checks if two rectangles are colliding
                            // check if object is solid or not; if it's solid then e.collisionOn = true
                            // e.collisionOn = true;
                            index = i;
                            if (player == true) { // npcs/monsters cant pickup object
                                index = i;
                            }
                            // System.out.println("right collision!");
                        }
                        break;
                }
                e.solidArea.x = e.solidAreaDefaultX;
                e.solidArea.y = e.solidAreaDefaultY;
                sign[i].solidArea.x = sign[i].solidAreaDefaultX;
                sign[i].solidArea.y = sign[i].solidAreaDefaultY;
            }

        }
        return index;

    }

    public int checkMobToMob(Creature e, Creature[] sign, boolean player) {

        int index = 777; // check if player is hitting any object

        for (int i = 0; i < sign.length; i++) { // scan object-element array

            if (sign[i] != null) {

                // Get obj's solid area position
                e.solidArea.x = (int) e.worldX + e.solidArea.x;
                e.solidArea.y = (int) e.worldY + e.solidArea.y;

                // Get object's solid area ; this will be helpful if i set object specific
                // values
                sign[i].solidArea.x = (int) sign[i].worldX + sign[i].solidArea.x;
                sign[i].solidArea.y = (int) sign[i].worldY + sign[i].solidArea.y;

                switch (e.direction) { // y position that the entity will be, after it moved.
                    case "up":
                        e.solidArea.y -= e.speed;

                        if (e.solidArea.intersects(sign[i].solidArea)) { // checks if two rectangles are colliding
                            // check if object is solid or not; if it's solid then e.collisionOn = true

                            if (sign[i] != e) {
                                e.collisionOn = true;
                            }
                            // e.collisionOn = true;
                            index = i;
                            if (player == true) { // npcs/monsters cant pickup object

                            }
                            // System.out.println("up collision!");
                        }
                        break;
                    case "down":
                        e.solidArea.y += e.speed;
                        if (e.solidArea.intersects(sign[i].solidArea)) { // checks if two rectangles are colliding
                            // check if object is solid or not; if it's solid then e.collisionOn = true
                            if (sign[i] != e) {
                                e.collisionOn = true;
                            }
                            index = i;
                            if (player == true) { // npcs/monsters cant pickup object
                                index = i;
                            }
                            // System.out.println("down collision!");
                        }
                        break;
                    case "left":
                        e.solidArea.x -= e.speed;
                        if (e.solidArea.intersects(sign[i].solidArea)) { // checks if two rectangles are colliding
                            // check if object is solid or not; if it's solid then e.collisionOn = true
                            if (sign[i] != e) {
                                e.collisionOn = true;
                            }
                            index = i;
                            if (player == true) { // npcs/monsters cant pickup object
                                index = i;
                            }
                            // System.out.println("left collision!");
                        }
                        break;
                    case "right":
                        e.solidArea.x += e.speed;
                        if (e.solidArea.intersects(sign[i].solidArea)) { // checks if two rectangles are colliding
                            // check if object is solid or not; if it's solid then e.collisionOn = true
                            // e.collisionOn = true;
                            index = i;
                            if (player == true) { // npcs/monsters cant pickup object
                                index = i;
                            }
                            // System.out.println("right collision!");
                        }
                        break;
                }
                e.solidArea.x = e.solidAreaDefaultX;
                e.solidArea.y = e.solidAreaDefaultY;
                sign[i].solidArea.x = sign[i].solidAreaDefaultX;
                sign[i].solidArea.y = sign[i].solidAreaDefaultY;
            }

        }
        return index;

    }

}
