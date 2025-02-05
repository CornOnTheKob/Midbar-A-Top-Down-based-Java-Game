/**
    This is a class that contains the code that sets up the main
    JFrame for the player.

    @author Jacob Lorenzo A. Cano (221303)
    @author Maigela Zia L. Garcia (222810)
    @version May 12, 2023
**/

/*
    I have not discussed the Java language code in my program
    with anyone other than my instructor or the teaching assistants
    assigned to this course.

    I have not used Java language code obtained from another student,
    or any other unauthorized source, either modified or unmodified.

    If any Java language code or documentation used in my program
    was obtained from another source, such as a textbook or website,
    that has been clearly noted with a proper citation in the comments
    of my program.


    The GameFrame java class is what we believe to be the heart of the Midbar game. It features the ff attributes
        > Forefront for the networking [client-side]
        > Methods for Interaction with Mobs
        > Drawing Dialogues [calling the draw methods]
        > Projectiles Keys
        > Movement of Players
        > Random Spawn Generator from Networking
        > Checker variables to see if gemstones are collected.

*/

/*


References

Agner, N. (2023). Helping solve networking problem (Seeds).
OpenGameArt (n.d.). Sprites and Projectiles. https://opengameart.org/art-search?keys=pixel+bullet 
Sprite Sheet Cutter. https://ezgif.com/sprite-cutter
Pokemon Gen 1-7 Overworld Sprites [Download Link; GoogleDrive] (n.d.). https://www.reddit.com/r/PokemonRMXP/comments/mhrxup/
Jaganathan, V. (2021). How do I generate random numbers in Java without repetition? https://www.quora.com/How-do-I-generate-random-numbers-in-Java-without-repetition
Ryisnow. [Ryisnow]. (2021). World and Camera. [Video]. YouTube. https://www.youtube.com/watch?v=J51ncHP_BrY
Ryisnow. [Ryisnow]. (2021). Collision Detection. [Video]. YouTube. https://www.youtube.com/watch?v=oPzPpUcDiYY
Ryisnow. [Ryisnow]. (2021). Drawing Map. [Video]. YouTube https://www.youtube.com/watch?v=ugzxCcpoSdE
Tile Editor 2D (2021). https://www.youtube.com/watch?v=y06YDM5Kq9Q&t=138s
Stack Overflow (2017). Intersect method only works in certain examples. 
https://stackoverflow.com/questions/34844419/intersects-method-only-works-in-certain-examples.
    - https://stackoverflow.com/questions/34844419/intersects-method-only-works-in-certain-examples
Stack Overflow (2018). Reading and Writing an Array of Int Socket Programming. https://stackoverflow.com/questions/39513544/reading-and-writing-array-of-int-socket-programming-java
Cajic, D. (2020). Java Transparent White Image Background. https://www.linkedin.com/pulse/java-transparent-white-image-background-dino-cajic?articleId=6634106304464072704
Z-xian Xian. (n.d.). Map and Character Sprite Artist [Commissioned]. 
Gaming Sound FX. [Gaming Sound FX]. (2020). Pokemon (A Button) - Sound Effect (HD)  [Video]. YouTube.https://www.youtube.com/watch?v=5UHmxWsPNzg
Fix Terminal “Operation not permitted” Error in macOS Monterey, Big Sur, Catalina, Mojave (2018). https://osxdaily.com/2018/10/09/fix-operation-not-permitted-terminal-error-macos/
Java ServerSocket close() method. (n.d.). https://www.javatpoint.com/java-serversocket-close-method
[Ivanmtta] (2021). Java code to display a projectile's trajectory using 2D kinematics. https://gist.github.com/Ivanmtta/f7689eea4bd8c27bc171022a4076b7d9
Stack Overflow (2019). Opposite of Java Equals Method. https://stackoverflow.com/questions/16995809/opposite-of-java-equals-method

All Other Made Versions (progress files) of Midbar [by date] can be found here
https://drive.google.com/drive/folders/11NJSPgotUQAtndWqKm5xxDXmU7JZ9V4w


*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// 7pm
import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class GameFrame extends JFrame implements Runnable {

    public int randomGeneratedNumbers[];
    private int width, height;
    private Container contentPane;

    public Player me;
    // public EnemySprite enemy;
    public int playerID;
    public int playerSpeed = 7;
    public int runSpeed = 10;

    public GameCanvas gc;
    private Timer animationTimer;

    public boolean up, down, left, right, all, shot, enemyShot, shot2, enemyShot2, shot3, enemyShot3, shot4, enemyShot4; // all
                                                                                                                         // is
                                                                                                                         // basically
                                                                                                                         // checking
                                                                                                                         // if
                                                                                                                         // enemy
                                                                                                                         // is
                                                                                                                         // walking
                                                                                                                         // or
                                                                                                                         // not
    private String direction;
    // private Entity p1;

    // BLUEPRINT
    public final int originalTileSize; // 16 x 16 tile
    public final int scale;
    public final int tileSize; // 48 x 48 tile
    public final int maxScreenCol; // x-axis
    public final int maxScreenRow; // y-axis
    public final int screenWidth; // 48 x 16 = 768
    public final int screenHeight; // 48 * 12 = 576

    // Map
    public MapMaker tm; // "this" is basically the PlayerFrame object

    // World Settings

    public final int maxWorldCol = 250;
    public final int maxWorldRow = 250;
    public final int worldWidth;
    public final int worldHeight;

    // Center

    // Objects
    public Object[] obj; // Trial Items
    public Object[] objYou;
    public Object[] stone;
    public ObjectSetter aSetter;

    // Player 2
    public Creature[] enemy;
    public Player2 you;

    // Solid Area for Player Collision
    public CollisionChecker cc;

    // Networking
    private Socket socket; // for client to connect to server
    private readFromServer rfsRunnable;
    private writeToServer wtsRunnable;

    // Stone container

    public boolean waterStoneChecker = false;
    public int waterStoneMessageChecker = 0;
    public int waterStoneMsgChecker = 1;

    public boolean earthStoneChecker = false;
    public int earthStoneMessageChecker = 0;
    public int earthStoneMsgChecker = 1;

    public boolean airStoneChecker = false;
    public int airStoneMessageChecker = 0;
    public int airStoneMsgChecker = 1;

    public boolean fireStoneChecker = false;
    public int fireStoneMessageChecker = 0;
    public int fireStoneMsgChecker = 1;

    public boolean completeStoneDrawer = false;
    public boolean completeStoneMsgChecker = false;
    public String completeStoneMsg = "";
    public int stoneCount = 0;
    public int stoneLeft = 4;
    public int stoneMessageChecker = 0;

    public boolean crystalStoneChecker = false;
    public int crystalStoneMessageChecker = 0;
    public int crystalStoneMsgChecker = 1;

    // sound
    public Sound sound = new Sound();

    // On-Screen components
    public OnScreenUI osUI;

    // Mobs
    public Creature[] mob;
    public Creature[] giantMob;
    public boolean delay = false;
    public int delayCounter = 0;
    public int delayKey = 0;

    // Signs
    public Creature[] signs = new Creature[20];
    public boolean drawDialogue = false;
    int signNo = 0;
    int signChecker = 0;
    public boolean DialogueState = false;

    // MagicHandler
    public MagicHandler magicHandler = new MagicHandler(this);
    public boolean drawMagicDialogue = false;
    public boolean DialogueMagicState = false;

    // mobs

    public long seed, seed2, seed3, seed4, seed5, seed6, seed7, seed8, seed9, seed10;
    public long seed11, seed12, seed13, seed14, seed15, seed16, seed17, seed18, seed19, seed20;

    // mobs new seed version

    public long[] seeds;

    public int randomX1 = 0, randomY1 = 0;

    // cooldown
    public boolean cooldown = false;
    public int cooldownCounter = 0;

    // Projectile

    public ArrayList<Creature> projectileList = new ArrayList<>(); // proj1 - p1
    public ArrayList<Creature> projectileList2 = new ArrayList<>(); // proj1 - p2

    public ArrayList<Creature> projectileList2_1 = new ArrayList<>();
    public ArrayList<Creature> projectileList2_2 = new ArrayList<>();

    public ArrayList<Creature> projectileList3_1 = new ArrayList<>();
    public ArrayList<Creature> projectileList3_2 = new ArrayList<>();

    public ArrayList<Creature> projectileList4_1 = new ArrayList<>();
    public ArrayList<Creature> projectileList4_2 = new ArrayList<>();

    public ArrayList<Creature> projectileListMob = new ArrayList<>();

    public int randomX1_p1, randomY1_p1;
    public int randomX1_p2, randomY1_p2;

    // Projectile 1
    public double aa, bb;
    public String ccc;
    public boolean dd;

    // PROJ2

    private double[] proj2_worldX;
    private double[] proj2_worldY;
    private String[] proj2_direct;
    private boolean[] proj2_true;
    private boolean[] proj2_shot;

    // Ability Checker

    public boolean MeWaterAbilityChecker, YouWaterAbilityChecker;
    public boolean MeFireAbilityChecker, YouFireAbilityChecker;
    public boolean MeEarthAbilityChecker, YouEarthAbilityChecker;
    public boolean MeWindAbilityChecker, YouWindAbilityChecker;

    public boolean MeAliveChecker;

    Thread gameThread;

    public void playMusic(int i) {

        sound.setFile(i);
        sound.play();
        sound.loop();
    }

    public void stopMusic() {
        sound.stop();
    }

    public void playSFX(int i) {
        sound.setFile(i);
        sound.play2();
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

    }

    public GameFrame(int w, int h) {

        MeFireAbilityChecker = false;
        YouFireAbilityChecker = false;

        MeEarthAbilityChecker = false;
        YouEarthAbilityChecker = false;

        MeWindAbilityChecker = false;
        YouWindAbilityChecker = false;

        MeAliveChecker = false;
        MeWaterAbilityChecker = false;
        YouWaterAbilityChecker = false;

        proj2_worldX = new double[8];
        proj2_worldY = new double[8];
        proj2_direct = new String[8];
        proj2_true = new boolean[8];
        proj2_shot = new boolean[8];

        seeds = new long[24];

        osUI = new OnScreenUI(this);

        seed = seed2 = seed3 = seed4 = seed5 = seed6 = seed7 = seed8 = seed9 = seed10 = 0;
        seed11 = seed12 = seed13 = seed14 = seed15 = seed16 = seed17 = seed18 = seed19 = seed20 = 0;

        originalTileSize = 16; // 16 x 16 tile
        scale = 3;
        tileSize = originalTileSize * scale; // 48 x 48 tile
        maxScreenCol = 16; // x-axis
        maxScreenRow = 12; // y-axis
        screenWidth = tileSize * maxScreenCol; // 48 x 16 = 768
        screenHeight = tileSize * maxScreenRow; // 48 * 12 = 576

        worldWidth = maxWorldCol * tileSize;
        worldHeight = maxWorldRow * tileSize;

        randomGeneratedNumbers = new int[5];
        stone = new Object[5];
        mob = new Creature[40];
        giantMob = new Creature[4];
        obj = new Object[21];
        objYou = new Object[21];

        width = w;
        height = h;
        up = left = down = right = false;

        aSetter = new ObjectSetter(this);

        // Player 2
        enemy = new Creature[10];
        you = new Player2(this);

        // Solid Area for Player Collision
        cc = new CollisionChecker(this);

        randomX1_p1 = 115;
        randomY1_p1 = 84;
        randomX1_p2 = 116;
        randomY1_p2 = 84;

        setUpGame();
        // asetRandomSpawns();

    }

    public void createSprite() {

        // Default values // set default values

        Creature p1 = new Creature(this); // for entity #1
        p1.worldX = tileSize * 19;
        p1.worldY = tileSize * 28;

        p1.size = 50; // default
        p1.color = Color.ORANGE;
        p1.screenX = screenWidth / 2 - (tileSize / 2);
        p1.screenY = screenHeight / 2 - (tileSize / 2);
        p1.direction = "down";

        Creature p2 = new Creature(this); // for entity #1
        p2.worldX = tileSize * 18;
        p2.worldY = tileSize * 28;
        p2.size = 50; // default
        p2.color = Color.BLUE;
        p2.screenX = screenWidth / 2 - (tileSize / 2);
        p2.screenY = screenHeight / 2 - (tileSize / 2);
        p2.direction = "down";

        // OG ENEMY

        // SEND COORDINATES TO
        if (playerID == 1) { // if

            me = new Player(this, p1.worldX, p1.worldY, p1.size, p1.color, p1.direction, p1.screenX, p1.screenY);

            // ENEMY is found in Asset Setter
            // enemy = new PlayerSprite(p2.worldX, p2.worldY, p2.size,
            // p2.color,p2.direction, p2.screenX, p2.screenY);

        } else {
            // if player 2 = the one that will move is right side
            // player 0's GUI
            // enemy = new PlayerSprite(p1.worldX, p1.worldY, p1.size,
            // p1.color,p1.direction, p1.screenX, p1.screenY);

            me = new Player(this, enemy[0].worldX, enemy[0].worldY, p2.size, p2.color, p2.direction, p2.screenX,
                    p2.screenY);

            // me will become the enemy's coordinates, //enemy will become the p1's
            // coordinates

            this.enemy[0].worldX = p1.worldX;
            this.enemy[0].worldY = p1.worldY;

        }

        RandomSpawnGenerator();

    }

    private void setUpAnimationTimer() { // this is our "thread" // update()
        aSetter.setMobs();
        aSetter.setStones();
        aSetter.setObject();

        int interval = 17; // Basically 60fps
        ActionListener al = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if (up == true || down == true || left == true || right == true) { // stop walking when not walking

                    // CHECK TILE COLLISION
                    me.collisionOn = false;
                    cc.checkTile(me); // pass the player as entity,since player is a subclass of Entity, so checker
                                      // can accept class as entity

                    int objIndex = cc.checkStoneObject(me, true); // what happens if player touches object; new method
                    pickUpStoneObject(objIndex);

                    int objectIndex = cc.checkObjects(me, obj, true);
                    int objectIndex2 = cc.checkObjects(enemy[0], obj, true);

                    interactItems(objectIndex2);
                    interactItems(objectIndex);

                    // Check NPC/MOB/MONSTER COLISION IF PLAYER IS TOUCHING MOB
                    int mobIndex = cc.checkMob(me, mob, true);
                    // int mobIndex2 = cc.checkMob(enemy[0], mob, true);
                    interactMob(mobIndex, me.attack);

                    int giantMobIndex = cc.checkMob(me, giantMob, true);
                    interactGiantMob(giantMobIndex, me.attack);
                    // interactMob(mobIndex2);

                    // Check if Mob is touching player

                    // Check sign collision
                    int signIndex = cc.checkSign(me, signs, true);
                    interactSign(signIndex);

                    // Check magicEvent
                    magicHandler.checkMagic();

                    // IF COLLISION IS FALSE, PLAYER CAN MOVE
                    if (me.collisionOn == false) {

                        switch (me.direction) {
                            case "up":
                                me.moveV(-playerSpeed);
                                break;
                            case "down":
                                me.moveV(playerSpeed);
                                break;
                            case "left":
                                me.moveH(-playerSpeed);
                                break;
                            case "right":
                                me.moveH(playerSpeed);
                                break;
                        }

                    }

                    me.spriteCounter++; // every 12 frames it will change spriteNum = walking animation
                    // enemy[0].spriteCounter++;

                    if (me.spriteCounter > runSpeed || you.spriteCounter > runSpeed) {
                        if (me.spriteNum == 1) {
                            me.spriteNum = 2;
                        } else if (me.spriteNum == 2) {
                            me.spriteNum = 3;
                        } else if (me.spriteNum == 3) {
                            me.spriteNum = 1;
                        }

                        me.spriteCounter = 0;
                        // enemy[0].spriteCounter = 0;

                    }

                }

                delayCounter++;

                if (delayCounter >= 10) {

                    // System.out.println("Mob 1's X is:" + me.getX());
                    // System.out.println("Mob 2's X is:" + mob[1].getX());

                    if (delayKey == 1) {
                        playerSpeed = -playerSpeed;

                        delayKey = 2;
                    }

                    delayCounter = 0;
                    delay = false;

                }

                // provide cooldown
                if (cooldown == true) {
                    cooldownCounter++;
                    if (cooldownCounter > 75) {
                        cooldown = false;
                        cooldownCounter = 0;

                    }
                }

                // projecitle 1

                /*
                 * 
                 * playSFX(9);
                 * playSFX(10);
                 * playSFX(11);
                 * playSFX(12);
                 */

                // if shot key / space key is pressed
                if (shot == true && me.projectile.alive == false) {
                    playSFX(9);
                    // DEFAULT COORDINATES OF THE FIREBALLS
                    me.projectile.set(me.worldX, me.worldY, me.direction, true, me);
                    projectileList.add(me.projectile);

                }

                if (enemyShot == true && enemy[0].projectile.alive == false) {

                    enemy[0].projectile.set(aa, bb, ccc, true, enemy[0].projectile);
                    projectileList2.add(enemy[0].projectile);
                }

                // projecitle 2f

                if (shot2 == true && me.projectile2.alive == false) {

                    playSFX(10);

                    me.projectile2.set(me.worldX, me.worldY, "up", true, me);
                    projectileList2_1.add(me.projectile2);
                    me.projectile3.set(me.worldX, me.worldY, "down", true, me);
                    projectileList2_1.add(me.projectile3);
                    me.projectile4.set(me.worldX, me.worldY, "left", true, me);
                    projectileList2_1.add(me.projectile4);
                    me.projectile5.set(me.worldX, me.worldY, "right", true, me);
                    projectileList2_1.add(me.projectile5);

                    me.projectile6.set(me.worldX, me.worldY, "up-right", true, me);
                    projectileList2_1.add(me.projectile6);
                    me.projectile7.set(me.worldX, me.worldY, "up-left", true, me);
                    projectileList2_1.add(me.projectile7);
                    me.projectile8.set(me.worldX, me.worldY, "down-left", true, me);
                    projectileList2_1.add(me.projectile8);
                    me.projectile9.set(me.worldX, me.worldY, "down-right", true, me);
                    projectileList2_1.add(me.projectile9);

                }

                if (enemyShot2 == true && enemy[0].projectile2.alive == false) {

                    /*
                     * private double[] proj2_worldX = new double[8];
                     * private double[] proj2_worldY = new double[8];
                     * private String[] proj2_direct = new String[8];
                     * private boolean[] proj2_true = new boolean[8];
                     * private boolean[] proj2_shot = new boolean[8];
                     */
                    enemy[0].projectile2.set(aa, bb, "up", true, enemy[0].projectile);
                    projectileList2_2.add(enemy[0].projectile2);
                    enemy[0].projectile3.set(aa, bb, "down", true, enemy[0].projectile);
                    projectileList2_2.add(enemy[0].projectile3);
                    enemy[0].projectile4.set(aa, bb, "left", true, enemy[0].projectile);
                    projectileList2_2.add(enemy[0].projectile4);
                    enemy[0].projectile5.set(aa, bb, "right", true, enemy[0].projectile);
                    projectileList2_2.add(enemy[0].projectile5);

                    enemy[0].projectile6.set(aa, bb, "up-right", true, enemy[0].projectile);
                    projectileList2_2.add(enemy[0].projectile6);
                    enemy[0].projectile7.set(aa, bb, "up-left", true, enemy[0].projectile);
                    projectileList2_2.add(enemy[0].projectile7);
                    enemy[0].projectile8.set(aa, bb, "down-left", true, enemy[0].projectile);
                    projectileList2_2.add(enemy[0].projectile8);
                    enemy[0].projectile9.set(aa, bb, "down-right", true, enemy[0].projectile);
                    projectileList2_2.add(enemy[0].projectile9);

                }

                // p3 me

                if (shot3 == true && me.projectile10.alive == false && !me.direction.equals("up")
                        && !me.direction.equals("down")) {
                    playSFX(11);
                    me.projectile10.set(me.worldX, me.worldY, me.direction, true, me);
                    projectileList3_1.add(me.projectile10);

                }

                if (enemyShot3 == true && enemy[0].projectile10.alive == false) {

                    enemy[0].projectile10.set(aa, bb, ccc, true, enemy[0].projectile);
                    projectileList3_2.add(enemy[0].projectile10);
                }

                // p4 me

                if (shot4 == true && me.projectile11.alive == false) {
                    playSFX(12);
                    me.projectile11.set(me.worldX, me.worldY, me.direction, true, me);
                    projectileList4_1.add(me.projectile11);

                }

                if (enemyShot4 == true && enemy[0].projectile11.alive == false) {

                    enemy[0].projectile11.set(aa, bb, ccc, true, enemy[0].projectile);
                    projectileList4_2.add(enemy[0].projectile11);

                }

                // dc.repaint();
                gc.dc.repaint();
                update();

                checkIfMobDead();

                /*
                 * 
                 * System.out.println("Life of creature no. " + 0 + " is "+ mob[0].life);
                 * System.out.println("Life of creature no. " + 1 + " is "+ mob[1].life);
                 * System.out.println("Life of creature no. " + 2 + " is "+ mob[2].life);
                 */

            }
        };
        animationTimer = new Timer(interval, al);
        animationTimer.start();

    }

    public void RandomSpawnGenerator() {

        if (playerID == 1) {
            me.worldX = randomX1_p1 * tileSize;
            me.worldY = randomY1_p1 * tileSize;
            enemy[0].worldX = randomX1_p2 * tileSize;
            enemy[0].worldY = randomY1_p2 * tileSize;

        } else {
            enemy[0].worldX = randomX1_p1 * tileSize;
            enemy[0].worldY = randomY1_p1 * tileSize;
            me.worldX = randomX1_p2 * tileSize;
            me.worldY = randomY1_p2 * tileSize;
        }

    }

    public void setRandomSpawns() {

        /*
         * if(playerID == 0){
         * 
         * me = new Player(this, 85*tileSize, 57*tileSize, 48, Color.BLACK, "down",
         * (screenWidth / 2 - (tileSize / 2)),
         * (screenHeight / 2 - (tileSize / 2)));
         * 
         * this.enemy[0].worldX = 85*tileSize;
         * this.enemy[0].worldY = 59*tileSize;
         * 
         * }
         */
        // obj[0].worldX = 14 * tileSize;
        // obj[0].worldY = 25 * tileSize;

    }

    public void update() { // always

        for (int i = 0; i < obj.length; i++) {

            if (obj[i] != null) {
                if (obj[i].itemEquip == true || objYou[i].itemEquip == true) {
                    obj[i].worldX = -100;

                }
            }

        }
        for (int i = 0; i < mob.length; i++) {
            if (mob[i] != null) {
                mob[i].setUpdateMob();
                checkIfMobDead();
            }
        }

        for (int i = 0; i < giantMob.length; i++) {
            if (giantMob[i] != null) {
                giantMob[i].setUpdateMob();
                checkIfMobDead();
            }
        }

        for (int i = 0; i < projectileList.size(); i++) {
            if (projectileList.get(i) != null) {
                if (projectileList.get(i).alive == true) { // if alive, array list will be shown
                    projectileList.get(i).update();
                }
                if (projectileList.get(i).alive == false) { // if dead, arraylist will remove the projectile so nothing
                                                            // is drawn
                    projectileList.remove(i);
                }
            }
        }

        for (int i = 0; i < projectileList2.size(); i++) {
            if (projectileList2.get(i) != null) {
                if (projectileList2.get(i).alive == true) { // if alive, array list will be shown
                    projectileList2.get(i).update();
                }
                if (projectileList2.get(i).alive == false) { // if dead, arraylist will remove the projectile so nothing
                                                             // is drawn
                    projectileList2.remove(i);
                }
            }
        }

        // projectile 2[must be pairs]
        for (int i = 0; i < projectileList2_1.size(); i++) {
            if (projectileList2_1.get(i) != null) {
                if (projectileList2_1.get(i).alive == true) { // if alive, array list will be shown
                    projectileList2_1.get(i).update2();
                }
                if (projectileList2_1.get(i).alive == false) { // if dead, arraylist will remove the projectile so
                                                               // nothing
                                                               // is drawn
                    projectileList2_1.remove(i);
                }
            }
        }

        for (int i = 0; i < projectileList2_2.size(); i++) {
            if (projectileList2_2.get(i) != null) {
                if (projectileList2_2.get(i).alive == true) { // if alive, array list will be shown
                    projectileList2_2.get(i).update2();
                }
                if (projectileList2_2.get(i).alive == false) { // if dead, arraylist will remove the projectile so
                                                               // nothing
                                                               // is drawn
                    projectileList2_2.remove(i);
                }
            }
        }

        // projectile 3[must be pairs]
        for (int i = 0; i < projectileList3_1.size(); i++) {
            if (projectileList3_1.get(i) != null) {
                if (projectileList3_1.get(i).alive == true) { // if alive, array list will be shown
                    projectileList3_1.get(i).update3();
                }
                if (projectileList3_1.get(i).alive == false) { // if dead, arraylist will remove the projectile so
                                                               // nothing
                                                               // is drawn
                    projectileList3_1.remove(i);
                }
            }
        }

        for (int i = 0; i < projectileList3_2.size(); i++) {
            if (projectileList3_2.get(i) != null) {
                if (projectileList3_2.get(i).alive == true) { // if alive, array list will be shown
                    projectileList3_2.get(i).update3();
                }
                if (projectileList3_2.get(i).alive == false) { // if dead, arraylist will remove the projectile so
                                                               // nothing
                                                               // is drawn
                    projectileList3_2.remove(i);
                }
            }
        }

        // projectile 4
        for (int i = 0; i < projectileList4_1.size(); i++) {
            if (projectileList4_1.get(i) != null) {
                if (projectileList4_1.get(i).alive == true) { // if alive, array list will be shown
                    projectileList4_1.get(i).update4();
                }
                if (projectileList4_1.get(i).alive == false) { // if dead, arraylist will remove the projectile so
                                                               // nothing
                                                               // is drawn
                    projectileList4_1.remove(i);
                }
            }
        }
        for (int i = 0; i < projectileList4_2.size(); i++) {
            if (projectileList4_2.get(i) != null) {
                if (projectileList4_2.get(i).alive == true) { // if alive, array list will be shown
                    projectileList4_2.get(i).update4();
                }
                if (projectileList4_2.get(i).alive == false) { // if dead, arraylist will remove the projectile so
                                                               // nothing
                                                               // is drawn
                    projectileList4_2.remove(i);
                }
            }
        }

        for (int i = 0; i < projectileListMob.size(); i++) {
            if (projectileListMob.get(i) != null) {
                if (projectileListMob.get(i).alive == true) { // if alive, array list will be shown
                    projectileListMob.get(i).update5();
                }
                if (projectileListMob.get(i).alive == false) { // if dead, arraylist will remove the projectile so
                                                               // nothing
                                                               // is drawn
                    projectileListMob.remove(i);
                }
            }
        }

    }

    private void setUpKeyListener() {
        KeyListener kl = new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                Creature ae = new Creature(GameFrame.this);

                if (osUI.gameStartedMe == true || osUI.gameStartedYou == true) {

                    if (keyCode == KeyEvent.VK_ENTER) {

                        playSFX(5);
                        if (playerID < 1) {
                            osUI.gameStartedMe = false;
                            osUI.gameStartedYou = false;
                        } else {
                            osUI.gameStartedMe = false;

                        }

                        // osUI.gameStartedYou = false;

                        gc.dc.repaint();

                    }
                }

                if (DialogueState == false && DialogueMagicState == false && osUI.gameStartedMe == false) {
                    switch (keyCode) {
                        case KeyEvent.VK_W:
                            up = true;
                            all = true;
                            me.direction = "up"; // Pass the direction to PlayerSprite so it can know what image of
                                                 // walking animation will the code use.
                            // you.getDirection("up");
                            break;
                        case KeyEvent.VK_S:
                            down = true;
                            all = true;
                            me.direction = "down";
                            // you.getDirection("down");

                            break;
                        case KeyEvent.VK_A:
                            left = true;
                            all = true;
                            me.direction = "left";
                            // you.getDirection("left");

                            break;
                        case KeyEvent.VK_D:
                            right = true;
                            all = true;
                            me.direction = "right";
                            // you.getDirection("right");
                            break;
                        case KeyEvent.VK_R:
                            playerSpeed = 20;
                            runSpeed = 3;
                            break;
                        case KeyEvent.VK_SLASH:
                            me.setX(me.getX() + 10);
                            break;

                    }
                }

                // 1 fire 2 earth 3 air

                if (MeWindAbilityChecker == true || YouWindAbilityChecker == true) {
                    if (keyCode == KeyEvent.VK_3) {
                        shot4 = true;
                        all = true;

                    }
                }

                if (MeEarthAbilityChecker == true || YouEarthAbilityChecker == true) {
                    if (keyCode == KeyEvent.VK_2) {
                        shot3 = true;
                        all = true;

                    }
                }

                if (MeFireAbilityChecker == true || YouFireAbilityChecker == true) {
                    if (keyCode == KeyEvent.VK_1) {
                        shot2 = true;
                        all = true;

                    }
                }

                if (MeWaterAbilityChecker == true || YouWaterAbilityChecker == true) {

                    if (keyCode == KeyEvent.VK_SPACE) {
                        shot = true;
                        all = true;
                        System.out.println("Bam");
                    }

                }

                if ((drawDialogue == true && DialogueState == true)) {

                    if (keyCode == KeyEvent.VK_RIGHT) {
                        playSFX(5);
                        if (signs[signNo] != null)
                            signs[signNo].show();
                        me.speed = 7;
                        playerSpeed = 7;

                    }
                    if (keyCode == KeyEvent.VK_ENTER) {
                        playSFX(5);
                        signs[0].dialogueIndex = 0;
                        signs[1].dialogueIndex = 0;
                        drawDialogue = false;
                        DialogueState = false;
                        me.speed = 7;
                        playerSpeed = 7;

                    }
                }

                else if (drawMagicDialogue == true && DialogueMagicState == true) {

                    if (keyCode == KeyEvent.VK_ENTER || keyCode == KeyEvent.VK_RIGHT) {
                        drawMagicDialogue = false;
                        DialogueMagicState = false;
                        me.speed = 7;
                        playerSpeed = 7;

                    }
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {
                int keyCode = e.getKeyCode();

                switch (keyCode) {
                    case KeyEvent.VK_W:
                        up = false;
                        all = false;
                        break;
                    case KeyEvent.VK_S:
                        down = false;
                        all = false;

                        break;
                    case KeyEvent.VK_A:
                        left = false;
                        all = false;
                        break;
                    case KeyEvent.VK_D:
                        right = false;
                        all = false;
                        break;
                    case KeyEvent.VK_R:
                        playerSpeed = 9;
                        runSpeed = 10;
                    case KeyEvent.VK_3:
                        shot4 = false;
                        all = false;
                        break;

                }

                if (keyCode == KeyEvent.VK_SPACE) {
                    shot = false;
                    all = false;
                    // playSFX(9);
                }

                if (keyCode == KeyEvent.VK_1) {
                    shot2 = false;
                    all = false;

                }

                if (keyCode == KeyEvent.VK_2) {
                    shot3 = false;
                    all = false;

                }

                if (keyCode == KeyEvent.VK_3) {
                    shot4 = false;
                    all = false;

                }

            }

        };
        contentPane.addKeyListener(kl);
        contentPane.setFocusable(true);
    }

    void connectToServer() { // player to server; client to server

        try {

            // new socket that will create connection

            socket = new Socket("18.212.187.231", 55555); // establishes connection from IP and Port
            DataInputStream in = new DataInputStream(socket.getInputStream()); // Receive info from server
            DataOutputStream out = new DataOutputStream(socket.getOutputStream()); // Send out info to server

            playerID = in.readInt(); // get either 1 or 2 will be playerID;

            // receive the seed generated from server... this seed will be used when
            // creating the mobs' movement --> AssetSetter
            seed = in.readLong();
            seed11 = in.readLong();
            seed2 = in.readLong();
            seed12 = in.readLong();
            seed3 = in.readLong();
            seed13 = in.readLong();
            seed4 = in.readLong();
            seed14 = in.readLong();
            seed5 = in.readLong();
            seed15 = in.readLong();
            seed6 = in.readLong();
            seed16 = in.readLong();
            seed7 = in.readLong();
            seed17 = in.readLong();
            seed8 = in.readLong();
            seed18 = in.readLong();
            seed9 = in.readLong();
            seed19 = in.readLong();
            seed10 = in.readLong();
            seed20 = in.readLong();

            for (int i = 0; i < seeds.length; i++) {
                seeds[i] = in.readLong(); // 10 times
            }

            randomX1 = in.readInt();
            randomY1 = in.readInt();

            randomX1_p1 = in.readInt();
            randomY1_p1 = in.readInt();
            randomX1_p2 = in.readInt();
            randomY1_p2 = in.readInt();

            System.out.println("You are player no." + playerID);

            if (playerID == 1) {
                System.out.println("Player 1 connected. Waiting for Player 2...");
            }

            rfsRunnable = new readFromServer(in);
            wtsRunnable = new writeToServer(out);
            rfsRunnable.waitForStartMessage();

        } catch (IOException ex) {
            System.out.println("IOException from connectToServer");
        }

    }

    private class readFromServer implements Runnable { // receive new data from serve

        private DataInputStream dataIn;

        public readFromServer(DataInputStream in) {

            dataIn = in;
            System.out.println("RFS Runnable created.");

        }

        public void run() {

            try { // awdwd

                while (true) {

                    double setX = dataIn.readDouble();
                    double setY = dataIn.readDouble();
                    String getDirectionz = dataIn.readUTF();
                    boolean walkCheckerz = dataIn.readBoolean();
                    int spriteCounterz = dataIn.readInt();

                    Boolean[] stonecontainer = new Boolean[5];
                    for (int i = 0; i < stonecontainer.length; i++) {
                        stonecontainer[i] = dataIn.readBoolean();
                    }

                    int stoneLeftz = dataIn.readInt();
                    boolean completeStoneMsgCheckerz = dataIn.readBoolean();
                    boolean earthStoneCheckerz = dataIn.readBoolean();
                    boolean fireStoneCheckerz = dataIn.readBoolean();
                    boolean airStoneCheckerz = dataIn.readBoolean();
                    boolean waterStoneCheckerz = dataIn.readBoolean();
                    boolean crystalStoneCheckerz = dataIn.readBoolean();

                    int stoneCountz = dataIn.readInt();
                    int enemylife = dataIn.readInt();

                    int[] mobz = new int[40];
                    for (int i = 0; i < mobz.length; i++) {
                        mobz[i] = dataIn.readInt();
                    }

                    double aaz = dataIn.readDouble();
                    double bbz = dataIn.readDouble();
                    String cccz = dataIn.readUTF();
                    Boolean ddz = dataIn.readBoolean();

                    Boolean enemyShotz = dataIn.readBoolean();

                    Boolean[] objYouz = new Boolean[21];
                    for (int i = 0; i < objYouz.length; i++) {
                        objYouz[i] = dataIn.readBoolean();
                    }

                    boolean enemyShot2z = dataIn.readBoolean();
                    boolean enemyShot3z = dataIn.readBoolean();
                    boolean enemyShot4z = dataIn.readBoolean();
                    boolean osUIgameFinishedYouz = dataIn.readBoolean();
                    ;
                    boolean osUIgameDeadYouz = dataIn.readBoolean();
                    ;
                    boolean osUIgameDeadYouChekerz = dataIn.readBoolean();

                    int[] giantMobz = new int[4];
                    for (int i = 0; i < giantMobz.length; i++) {

                        giantMobz[i] = dataIn.readInt();
                    }

                    boolean osUIgameStartedYouz = dataIn.readBoolean();

                    if (you != null && enemy[0] != null && mob != null && obj != null && objYou != null
                            && giantMob != null) {
                        you.setX(setX);
                        you.setY(setY);
                        you.getDirection(getDirectionz);
                        you.walkChecker(walkCheckerz);
                        you.spriteCounter(spriteCounterz); // run animation

                        for (int i = 0; i < stone.length; i++) {
                            stone[i].stoneEquip = stonecontainer[i];

                        }

                        stoneLeft = stoneLeftz; //
                        completeStoneMsgChecker = completeStoneMsgCheckerz;
                        earthStoneChecker = earthStoneCheckerz;
                        fireStoneChecker = fireStoneCheckerz;
                        airStoneChecker = airStoneCheckerz;
                        waterStoneChecker = waterStoneCheckerz;
                        crystalStoneChecker = crystalStoneCheckerz;

                        stoneCount = stoneCountz;
                        enemy[0].life = enemylife;

                        for (int i = 0; i < mob.length; i++) {

                            mob[i].life = mobz[i];
                        }

                        // enemy[0].projectile.set(dataIn.readDouble(), dataIn.readDouble(),
                        // dataIn.readUTF(), dataIn.readBoolean(), enemy[0]);
                        aa = aaz;
                        bb = bbz;
                        ccc = cccz;
                        dd = ddz;

                        ///
                        enemyShot = enemyShotz;

                        for (int i = 0; i < objYou.length; i++) {
                            objYou[i].itemEquip = objYouz[i];
                        }

                        // System.out.println( mob[0].life);
                        enemyShot2 = enemyShot2z;
                        enemyShot3 = enemyShot3z;
                        enemyShot4 = enemyShot4z;
                        osUI.gameFinishedYou = osUIgameFinishedYouz;

                        osUI.gameDeadYou = osUIgameDeadYouz;
                        osUI.gameDeadYouChecker = osUIgameDeadYouChekerz;
                        /*
                         * 
                         * dataOut.writeBoolean(osUI.gameDeadMe);
                         * dataOut.writeBoolean(osUI.gameDeadMeChecker);
                         */

                        for (int i = 0; i < giantMob.length; i++) {

                            giantMob[i].life = giantMobz[i];
                        }

                        osUI.gameStartedYou = osUIgameStartedYouz;

                        pickUpStoneObjectUpdate();

                    }

                    // PlayerFrame.this.enemy[0].worldX = ;
                    // PlayerFrame.this.enemy[0].worldX = ;

                }

            } catch (IOException ex) {
                System.out.println("IOException from readFromServer run");
                System.exit(0);
            }

        }

        public void waitForStartMessage() {

            try {
                String startMsg = dataIn.readUTF();
                System.out.println("Message from Server: " + startMsg);
                Thread readThread = new Thread(rfsRunnable);
                Thread writeThread = new Thread(wtsRunnable);
                readThread.start();
                writeThread.start();

                playMusic(0);

            } catch (IOException ex) {
                System.out.println("IOException from wait for start message");
            }

        }

    }

    private class writeToServer implements Runnable {

        private DataOutputStream dataOut;

        public writeToServer(DataOutputStream out) {

            dataOut = out;
            System.out.println("WTS Runnable created.");

        }

        public void run() { // this will "Sending x and y values"

            try {

                while (true) { // add thread so that the network can hinga.
                    if (me != null && enemy[0] != null && mob != null && obj != null && giantMob != null) { // wait for
                                                                                                            // me object
                                                                                                            // to be
                        // created before it executes
                        dataOut.writeDouble(me.getX());
                        dataOut.writeDouble(me.getY());
                        dataOut.writeUTF(me.direction);
                        dataOut.writeBoolean(all);

                        for (int i = 0; i < stone.length; i++) {
                            dataOut.writeBoolean(stone[i].stoneEquip);

                        }

                        dataOut.writeInt(stoneLeft);
                        dataOut.writeBoolean(completeStoneMsgChecker);
                        dataOut.writeBoolean(earthStoneChecker);
                        dataOut.writeBoolean(fireStoneChecker);
                        dataOut.writeBoolean(airStoneChecker);
                        dataOut.writeBoolean(waterStoneChecker);
                        dataOut.writeBoolean(crystalStoneChecker);
                        dataOut.writeInt(stoneCount);
                        dataOut.writeInt(me.life);

                        for (int i = 0; i < mob.length; i++) {

                            dataOut.writeInt(mob[i].life);
                        }

                        dataOut.writeDouble(me.worldX);
                        dataOut.writeDouble(me.worldY);
                        dataOut.writeUTF(me.direction);
                        dataOut.writeBoolean(true);
                        dataOut.writeBoolean(shot);

                        for (int i = 0; i < obj.length; i++) {
                            dataOut.writeBoolean(obj[i].itemEquip);

                        }
                        dataOut.writeBoolean(shot2);
                        dataOut.writeBoolean(shot3);
                        dataOut.writeBoolean(shot4);
                        dataOut.writeBoolean(osUI.gameFinishedMe);

                        dataOut.writeBoolean(osUI.gameDeadMe);
                        dataOut.writeBoolean(osUI.gameDeadMeChecker);

                        for (int i = 0; i < giantMob.length; i++) {

                            dataOut.writeInt(giantMob[i].life);
                        }

                        dataOut.writeBoolean(osUI.gameStartedMe);

                        /*
                         * 
                         * osUI.gameFinishedYou = dataIn.readBoolean();
                         * 
                         */

                        /*
                         * me.projectile.set(me.worldX, me.worldY, me.direction, true, me);
                         * projectileList.add(me.projectile);
                         */

                        dataOut.flush();
                    }

                    try {

                        Thread.sleep(25);

                    } catch (InterruptedException e) {
                        System.out.println("InterruptedException from WTS run");

                    }

                }

            } catch (IOException e) {

                System.out.println("IOException from writeToServer run");
                System.exit(0);

            }

        }

    }

    public void setUpGUI() {
        contentPane = this.getContentPane();

        this.setTitle("Midbar: The Secrets of the Lost Wilderness (PLAYER " + playerID + ")");
        contentPane.setPreferredSize(new Dimension(screenWidth, screenHeight));
        createSprite();

        tm = new MapMaker(this);
        // dc = new DrawingComponent();
        gc = new GameCanvas(this);
        contentPane.add(gc.dc);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);
        setUpAnimationTimer();
        setUpKeyListener();
    }

    public void setUpGame() {
        aSetter.setMobs();
        aSetter.setStones();
        aSetter.setObject();
        aSetter.setEnemy();
        aSetter.setSigns();
        aSetter.setFakeObject();
        aSetter.setGiantMobs();

    }

    public void pickUpStoneObjectUpdate() {

        // checks if stones are completed ONCE ONLY CHECKS ONCE, then it will SEND
        // MESSAGE TO BOTH PLAYERS ONCE.

        // for the earthstone
        if (earthStoneChecker == true && earthStoneMsgChecker == 1) {
            earthStoneMessageChecker = 1;
            earthStoneMsgChecker = 2;

            if (earthStoneChecker == true && earthStoneMessageChecker == 1) {
                this.osUI.displayMessage(
                        "A Player has found the Earth Stone. \n With this, a new form of instability echoes within you. \n You are now trembling with a new ability (Press 2)");
                MeEarthAbilityChecker = true;

                System.out.println("Earth Stone Found.");
                System.out.println("Stone count: " + stoneCount);

                earthStoneMessageChecker = 2;

            }

        }

        // air

        else if (airStoneChecker == true && airStoneMsgChecker == 1) {
            airStoneMessageChecker = 1;
            airStoneMsgChecker = 2;

            if (airStoneChecker == true && airStoneMessageChecker == 1) {
                this.osUI.displayMessage(
                        "A Player has found the Air Stone. \n With this, the great Winds has coiled you its \n winding essence. You are now gifted with a new ability. (Press 3)");
                MeWindAbilityChecker = true;

                System.out.println("Air Stone Found.");
                System.out.println("Stone count: " + stoneCount);

                airStoneMessageChecker = 2;

            }

        }

        // fire

        else if (fireStoneChecker == true && fireStoneMsgChecker == 1) {
            fireStoneMessageChecker = 1;
            fireStoneMsgChecker = 2;
            if (fireStoneChecker == true && fireStoneMessageChecker == 1) {
                this.osUI.displayMessage(
                        "A Player has found the Fire Stone. \n With this, something blazes you from within. \n You are now engulfed with a new ability (Press 1)");
                MeFireAbilityChecker = true;
                System.out.println("Fire Stone Found.");
                System.out.println("Stone count: " + stoneCount);

                fireStoneMessageChecker = 2;

            }

        }

        // water
        else if (waterStoneChecker == true && waterStoneMsgChecker == 1) {
            waterStoneMessageChecker = 1;
            waterStoneMsgChecker = 2;
            if (waterStoneChecker == true && waterStoneMessageChecker == 1) {
                this.osUI.displayMessage(
                        "A Player has found the Water Stone. \n With this, the Waters of Jordan showers you \n with a new ability (Press Spacebar)!");
                MeWaterAbilityChecker = true;
                this.stopMusic();

                System.out.println("Water Stone Found.");
                System.out.println("Stone count: " + stoneCount);

                waterStoneMessageChecker = 2;

            }

        }

        // crystal

        if (crystalStoneChecker == true && crystalStoneMsgChecker == 1) {
            crystalStoneMessageChecker = 1;
            crystalStoneMsgChecker = 2;

        }

        if (crystalStoneChecker == true && crystalStoneMessageChecker == 1) {

            System.out.println("Crystal has been Found.");
            crystalStoneMessageChecker = 2;

        }

        if (stone[0].stoneEquip == true && stone[1].stoneEquip == true && stone[2].stoneEquip == true
                && stone[3].stoneEquip == true && stoneMessageChecker == 0) {
            completeStoneMsgChecker = true;
            stoneMessageChecker = 1; // only checks this once

        }

        if (completeStoneMsgChecker == true && stoneMessageChecker == 1) {
            completeStoneDrawer = true;
            completeStoneMsg = "All stones have been Collected...A Random Crystal has emerged from the wastelands.";
            this.osUI.displayMessage2(
                    "All stones have been Collected...A Random \n Crystal has emerged from the wastelands.");

            System.out.println(completeStoneMsg);
            stoneMessageChecker = 2;
            gc.dc.repaint();
            // gc.dc.update();

        }

        // System.out.println("Stones left: " + stoneLeft);

    }

    public void interactSign(int i) {
        if (i != 777) {
            signNo = i;
            if (delay == false) {

                this.me.speed = 0;
                this.playerSpeed = 0;
                signs[0].dialogueIndex = 0;
                signs[1].dialogueIndex = 0;
                signs[2].dialogueIndex = 0;
                signs[3].dialogueIndex = 0;
                signs[4].dialogueIndex = 0;
                signs[5].dialogueIndex = 0;

                signs[signNo].show();

                if (signChecker == 0) {
                    // signs[signNo].show();
                    signChecker = 1;
                }

                drawDialogue = true;
                DialogueState = true; // if nasa loob ng dialogue si madam

                // this.osUI.drawMessageBox(100,100,100,100);

                playerSpeed = -playerSpeed;

                delayKey = 1;
                System.out.println("You are hitting this sign # " + i);
                delay = true;

            }
        }
    }

    public void checkIfMobDead() {

        if (me.life <= 0 && enemy[0].life <= 0
                && (osUI.gameDeadMeChecker == false || osUI.gameDeadYouChecker == false)) {
            // System.out.println("DEAD");
            osUI.gameDeadMe = true;
            // playSFX(4);
        }
        if (me.life <= 0 && MeAliveChecker == false) {

            osUI.currentDialogue = "Welcome to Limbo! That's it. Stay here.";
            me.worldX = this.tileSize * 10;
            me.worldY = this.tileSize * 240;

            System.out.println(DialogueState);
            System.out.println(DialogueMagicState);
            MeAliveChecker = true;

        }

        if (me.life > 0) {
            // MeAliveChecker = false;

        }

        for (int i = 0; i < mob.length; i++) {

            if (mob[i] != null) {

                if (mob[i].life <= 0 || mob[i].life == 0) {
                    mob[i].isMobDead = true;
                    gc.dc.repaint();

                    // mob[i] = null;
                }

                if (mob[i].isMobDead == true) {
                    mob[i].life = 0;
                }

            }
        }

        for (int i = 0; i < giantMob.length; i++) {

            if (giantMob[i] != null) {

                if (giantMob[i].life <= 0 || giantMob[i].life == 0) {
                    giantMob[i].isMobDead = true;
                    gc.dc.repaint();

                    // mob[i] = null;
                }

                if (giantMob[i].isMobDead == true) {
                    giantMob[i].life = 0;
                }

            }
        }
    }

    public void interactItems(int i) { // player to object

        if (i != 777) {

            playSFX(1);
            if (i >= 0) {

                if (obj[i].itemEquip == false || objYou[i].itemEquip == false) {

                    System.out.println("You have walked on this object no." + i);
                    this.obj[i].itemEquip = true;
                    this.objYou[i].itemEquip = true;

                    gc.dc.repaint();

                    if (this.obj[i].itemEquip == true || this.objYou[i].itemEquip == true) {
                        obj[i].worldX = 1500;
                        objYou[i].worldX = 1500;

                    }

                    gc.dc.repaint();

                }

            } else {
                playSFX(1);

                System.out.println("This is power up no." + i);
                obj[i].itemEquip = true;
                if (obj[i].itemEquip == true) {

                    if (this.obj[i].itemEquip == true) {
                        obj[i].worldX = 1500;

                    }
                    obj[i].worldX = 1500;

                }

                gc.dc.repaint();

            }

        }

    }

    public void interactGiantMob(int i, int attack) { // PLAYER TO MOB

        if (i != 777) {

            if (delay == false) {

                if (giantMob[i].life < 0 || giantMob[i].life == 0 || giantMob[i].life < 1) {
                    giantMob[i].life = 0;
                    giantMob[i].isMobDead = true;
                    gc.dc.repaint();

                    // mob[i] = null;
                }
                playerSpeed = -playerSpeed;
                // me.life -= 1;

                if (giantMob[i] != null && giantMob[i].life != 0) {
                    giantMob[i].life -= 1;
                    gc.dc.repaint();
                }

                delayKey = 1;
                System.out.println("You are hitting this creature no. " + i);
                System.out.println("Life of creature no. " + i + " is " + giantMob[i].life);
                playSFX(6);

            }

            delay = true;

        }

    }

    public void interactMob(int i, int attack) { // PLAYER TO MOB

        if (i != 777) {

            if (delay == false) {

                playerSpeed = -playerSpeed;
                // me.life -= 1;

                if (mob[i] != null && mob[i].life != 0) {

                    mob[i].life -= 1;
                    gc.dc.repaint();

                }

                delayKey = 1;
                System.out.println("You are hitting this creature no. " + i);
                System.out.println("Life of creature no. " + i + " is " + mob[i].life);
                playSFX(6);

                if (mob[i].life < 0 || mob[i].life == 0 || mob[i].life < 1) {
                    mob[i].life = 0;
                    mob[i].isMobDead = true;
                    gc.dc.repaint();

                    // mob[i] = null;
                }

                delay = true;

            }

        }

    }

    public void pickUpStoneObject(int i) {

        if (i != 777) { // if this index is 777, then we didnt touch an object

            // this.stone[i] = null;
            String stone_name = this.stone[i].name;

            if (this.stone[i].stoneEquip == false) {
                switch (stone_name) {
                    case "Element-F":

                        if (fireStoneChecker == false) {
                            fireStoneChecker = true;
                        }
                        this.stone[i].stoneEquip = true;
                        this.stone[i].stoneEquipPlayer = playerID; // way to store who equipped the stone
                        stoneCount++;
                        playSFX(2);

                        if (this.stone[i].stoneEquip == true) {

                        }
                        break;
                    case "Element-W":
                        // System.out.println("Player " + playerID + " has found the Water Stone!");
                        if (waterStoneChecker == false) {
                            waterStoneChecker = true;
                        }
                        this.stone[i].stoneEquip = true;
                        this.stone[i].stoneEquipPlayer = playerID;
                        stoneCount++;
                        // this.osUI.displayMessage("You have found the Water Stone!");
                        playSFX(2);

                        if (this.stone[i].stoneEquip == true) {

                        }
                        break;
                    case "Element-E":

                        if (earthStoneChecker == false) {
                            // System.out.println("Player " + playerID + " has found the Fire Stone!");
                            earthStoneChecker = true;

                        }
                        // System.out.println("Player " + playerID + " has found the Earth Stone!");
                        this.stone[i].stoneEquip = true;
                        this.stone[i].stoneEquipPlayer = playerID;
                        stoneCount++;
                        playSFX(2);

                        // this.osUI.displayMessage("You have found the Earth Stone!");

                        if (this.stone[i].stoneEquip == true) {

                        }
                        break;
                    case "Element-A":
                        if (airStoneChecker == false) {
                            airStoneChecker = true;
                        }
                        this.stone[i].stoneEquip = true;
                        this.stone[i].stoneEquipPlayer = playerID; // way to store who equipped the stone
                        stoneCount++;
                        playSFX(2);

                        // this.osUI.displayMessage("You have found the Air Stone!");

                        if (this.stone[i].stoneEquip == true) {

                        }
                        break;
                    case "Crystal-C":
                        if (crystalStoneChecker == false) {
                            crystalStoneChecker = true;
                        }
                        this.stone[i].stoneEquip = true;
                        this.stone[i].stoneEquipPlayer = playerID; // way to store who equipped the stone
                        this.stopMusic();
                        this.osUI.gameFinishedMe = true;

                        playMusic(3);

                        break;
                    // pass message from server to client
                    // pass array
                }
            }
            stoneLeft = stoneLeft - 1;
            pickUpStoneObjectUpdate();

        }
    }

}

/*
 * 
 * // THE GAMEFRAME BASICALLY
 * //https://www.reddit.com/r/PokemonRMXP/comments/mhrxup/
 * pokemon_gen_17_overworld_sprites_download_link/
 * // Midbar: The Land of Elementos
 * 
 * 
 * /*
 * Bugs:
 * - Crystal sometimes not respawning
 * - Mobs not dying?!
 * - Collision error happens when sign is not first interacted
 * - No delay in player giving damage to mobs = instant kill
 * 
 * 
 * Features to do:
 *
 * - make generator for seeds of mobs (half down)
 * - make a trap where it instantly summons three monsters Magic Event -- summon
 * > make a loop counter++; if counter < 3 mob[i].setX and .setY near player; if
 * successful, += 1; counter...
 * 
 * - make giant mobs
 * - fix gamestones
 * 
 * 
 * First on my list
 * - projectile
 * - finish mini monsters
 * - fix crystals
 * - random spawnpoints
 * - giant mobs
 * 
 * - FIX SFX JUSQ
 * - fix pools
 * 
 * - Congrats screen <3
 * 
 * WE CAN DO PARANG IF NAKUHA NA UNG COORDINATES IT WILL REMOVE FROM THAT LIST.
 * https://gist.github.com/Ivanmtta/f7689eea4bd8c27bc171022a4076b7d9#file-
 * projectilemotion-java
 * 
 * 
 * THINGS LEFT TO DO
 * - GIANT MOBS
 * - RANDOM SPAWNS
 * - COA
 * - DESCRIPTIONR
 * 
 * 
 * Meters
 * 
 * SFX
 * > Signage: https://www.youtube.com/watch?v=5UHmxWsPNzg
 * > FireBall: https://opengameart.org/content/8-magic-attacks
 * > IceBall: https://opengameart.org/content/8-magic-attacks
 * > Mob being damaged / PLayer being damaged:
 * > River Heal: https://opengameart.org/content/8-magic-attacks
 * > Parabolic
 * https://gist.github.com/Ivanmtta/f7689eea4bd8c27bc171022a4076b7d9#file-
 * projectilemotion-java
 * IF BIGGER MOBS CHANGE SURFACE AREA and draw size
 * 
 */