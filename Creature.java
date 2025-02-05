/**
    This is a superclass that handles variables for all the creatures
    in the game (e.g. player, mobs, etc).

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


    Beyond this file homes the mechanism/methods for handling the interaction to mobs as well as mob movement
    
*/


import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Creature {

    public GameFrame gp;

    public int screenX, screenY;
    public double worldX, worldY, size;
    public Color color;
    public double speed;

    public BufferedImage up1, up2, up3, down1, down2, down3, left1, left2, left3, right1, right2, right3;
    public String direction;

    // For the Sprite-Player Walkamations
    public int spriteNum = 1;
    public int spriteCounter = 0;

    public int playerID;

    // TRY: networking x and y

    public int displayX, displayY;

    // For Collision
    public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
    public boolean collisionOn = false;

    // For walking the character in da other gui
    public boolean walk;

    // For Object Collision 42823
    public int solidAreaDefaultX;
    public int solidAreaDefaultY;

    // for mob to player
    public int type; // 2 = mob
    public String name;

    // Mob movement
    public double actionMove = 0;

    // Dialogue msg
    public String[] dialogue = new String[10];
    public int dialogueIndex = 0;

    // Player Life Info -- pwede rin mobs
    public int maxLife = 3;
    public int life = maxLife;

    // check if Mob is dead
    public boolean isMobDead;

    // projectile bullets magic
    public int attack;
    public int maxMana;
    public int mana;
    public Projectile projectile; // iceball
    public Projectile projectile2, projectile3, projectile4, projectile5, projectile6, projectile7, projectile8,
            projectile9, projectile10, projectile11; 
            // fireball //earthball     //airball       


    public int level;
    public int useCost; // cost to shoot a projectile
    public boolean alive;

    public Creature(GameFrame gp) {
        this.gp = gp;

    }

    public void draw(Graphics2D g2d) {

        BufferedImage sprite = null;

        double screenX = worldX - gp.me.worldX + gp.me.screenX;
        double screenY = worldY - gp.me.worldY + gp.me.screenY;
        switch (direction) {
            case "up":
                if (spriteNum == 1) {
                    sprite = up1;
                } else {
                    sprite = up2;
                }

                break;
            case "down":
                if (spriteNum == 1) {
                    sprite = down1;
                } else {
                    sprite = down2;
                }
                break;
            case "left":
                if (spriteNum == 1) {
                    sprite = left1;
                } else {
                    sprite = left2;
                }
                break;
            case "right":
                if (spriteNum == 1) {
                    sprite = right1;
                } else {
                    sprite = right2;
                }
                break;

        }

        // STOP MOVING CAMERA
        if (gp.me.worldX < gp.me.screenX) {
            screenX = worldX;
        }
        if (gp.me.worldY < gp.me.screenY) {
            screenY = worldY;
        }
        int rightEdge = gp.screenWidth - gp.me.screenX;
        if (rightEdge > gp.worldWidth - gp.me.worldX) {
            screenX = gp.screenWidth - (gp.worldWidth - worldX);
        }
        int bottomEdge = gp.screenHeight - gp.me.screenY;
        if (bottomEdge > gp.worldHeight - gp.me.worldY) {
            screenY = gp.screenHeight - (gp.worldHeight - worldY);
        }

        if (worldX + gp.tileSize > gp.me.worldX - gp.me.screenX &&
                worldX - gp.tileSize < gp.me.worldX + gp.me.screenX &&
                worldY + gp.tileSize > gp.me.worldY - gp.me.screenY &&
                worldY - gp.tileSize < gp.me.worldY + gp.me.screenY) {
            g2d.drawImage(sprite, (int) screenX, (int) screenY, gp.tileSize, gp.tileSize, null);
        }
        // If me is around the edge, draw everything
        else if (gp.me.worldX < gp.me.screenX ||
                gp.me.worldY < gp.me.screenY ||
                rightEdge > gp.worldWidth - gp.me.worldX ||
                bottomEdge > gp.worldHeight - gp.me.worldY) {
            g2d.drawImage(sprite, (int) screenX, (int) screenY, gp.tileSize, gp.tileSize, null);
        }

    }

    public void drawEnemy(Graphics2D g2d) {

        try {

            if (gp.playerID == 1) {

                up1 = ImageIO.read(getClass().getResourceAsStream("Midbar/Player/Player2/lady_back_2.png"));
                up2 = ImageIO.read(getClass().getResourceAsStream("Midbar/Player/Player2/lady_back_1.png"));
                down1 = ImageIO.read(getClass().getResourceAsStream("Midbar/Player/Player2/lady_front_2.png"));
                down2 = ImageIO.read(getClass().getResourceAsStream("Midbar/Player/Player2/lady_front_1.png"));
                left1 = ImageIO.read(getClass().getResourceAsStream("Midbar/Player/Player2/lady_left_2.png"));
                left2 = ImageIO.read(getClass().getResourceAsStream("Midbar/Player/Player2/lady_left_1.png"));
                right1 = ImageIO.read(getClass().getResourceAsStream("Midbar/Player/Player2/lady_right_2.png"));
                right2 = ImageIO.read(getClass().getResourceAsStream("Midbar/Player/Player2/lady_right_1.png"));

            } else {
                up1 = ImageIO.read(getClass().getResourceAsStream("Midbar/Player/Player1/rolf_back_2.png"));
                up2 = ImageIO.read(getClass().getResourceAsStream("Midbar/Player/Player1/rolf_back_3.png"));
                down1 = ImageIO.read(getClass().getResourceAsStream("Midbar/Player/Player1/rolf_front_2.png"));
                down2 = ImageIO.read(getClass().getResourceAsStream("Midbar/Player/Player1/rolf_front_3.png"));
                left1 = ImageIO.read(getClass().getResourceAsStream("Midbar/Player/Player1/rolf_left_2.png"));
                left2 = ImageIO.read(getClass().getResourceAsStream("Midbar/Player/Player1/rolf_left_3.png"));
                right1 = ImageIO.read(getClass().getResourceAsStream("Midbar/Player/Player1/rolf_right_2.png"));
                right2 = ImageIO.read(getClass().getResourceAsStream("Midbar/Player/Player1/rolf_right_3.png"));
            }

        } catch (IOException e) {
            e.printStackTrace();

        }

        BufferedImage sprite = null;

        double screenX = worldX - gp.me.worldX + gp.me.screenX;
        double screenY = worldY - gp.me.worldY + gp.me.screenY; 

        switch (gp.enemy[0].direction) {
            case "up":
                if (gp.enemy[0].spriteNum == 1) {
                    sprite = up1;
                } else {
                    sprite = up2;
                }

                break;
            case "down":
                if (gp.enemy[0].spriteNum == 1) {
                    sprite = down1;
                } else {
                    sprite = down2;
                }
                break;
            case "left":
                if (gp.enemy[0].spriteNum == 1) {
                    sprite = left1;
                } else {
                    sprite = left2;
                }
                break;
            case "right":
                if (gp.enemy[0].spriteNum == 1) {
                    sprite = right1;
                } else {
                    sprite = right2;
                }
                break;

        }

        // STOP MOVING CAMERA
        if (gp.me.worldX < gp.me.screenX) {
            screenX = worldX;
        }
        if (gp.me.worldY < gp.me.screenY) {
            screenY = worldY;
        }
        int rightEdge = gp.screenWidth - gp.me.screenX;
        if (rightEdge > gp.worldWidth - gp.me.worldX) {
            screenX = gp.screenWidth - (gp.worldWidth - worldX);
        }
        int bottomEdge = gp.screenHeight - gp.me.screenY;
        if (bottomEdge > gp.worldHeight - gp.me.worldY) {
            screenY = gp.screenHeight - (gp.worldHeight - worldY);
        }

        if (worldX + gp.tileSize > gp.me.worldX - gp.me.screenX &&
                worldX - gp.tileSize < gp.me.worldX + gp.me.screenX &&
                worldY + gp.tileSize > gp.me.worldY - gp.me.screenY &&
                worldY - gp.tileSize < gp.me.worldY + gp.me.screenY) {
            g2d.drawImage(sprite, (int) screenX, (int) screenY, 55, 55, null);
        }
        // If me is around the edge, draw everything
        else if (gp.me.worldX < gp.me.screenX ||
                gp.me.worldY < gp.me.screenY ||
                rightEdge > gp.worldWidth - gp.me.worldX ||
                bottomEdge > gp.worldHeight - gp.me.worldY) {
            g2d.drawImage(sprite, (int) screenX, (int) screenY, 55, 55, null);
        }

    }

    public void show() {

    }

    public void update() {

    }

    public void update2() {

    }

    public void update3() {

    }

    public void update4() {

    }
    public void update5() {

    }
    public void setActionMob() {

    }

    public void setUpdateMob() {
        setActionMob(); // subclass > supclass
        collisionOn = false;
        gp.cc.checkTile(this);
        // gp.cc.checkStoneObject(this, false);
        // gp.cc.checkMob(gp.me, gp.mob);
        boolean contactPlayer = gp.cc.checkMobToPlayer_(this);

        gp.cc.checkMobToPlayer_2(this);
        
        gp.cc.checkMobToMob(this, gp.mob, true);
        gp.cc.checkMobToMob(this, gp.giantMob, true);

        gp.cc.checkMob(this, gp.mob, true); // ME
        gp.cc.checkMob2(this, gp.mob, true); // YOU

        gp.cc.checkMob(this, gp.giantMob, true); // ME
        gp.cc.checkMob2(this, gp.giantMob, true); // YOU


        if(contactPlayer == true){
           // gp.playSFX(7);
        }
        if (this.type == 2 && contactPlayer == true) {

            if (gp.cooldown == false) {
                gp.cooldown = true;
                gp.me.life -= 1;
                gp.playSFX(7);

            }

        }

        if (this.type == 3 && contactPlayer == true) {

            if (gp.cooldown == false) {
                gp.cooldown = true;
                gp.me.life -= 3;
                gp.playSFX(7);
            }

        }

        if (collisionOn == false) {

            switch (direction) {
                case "up":
                    worldY -= speed;
                    break;
                case "down":
                    worldY += speed;
                    break;
                case "left":
                    worldX -= speed;
                    break;
                case "right":
                    worldX += speed;
                    break;
            }

        }

        spriteCounter++; // every 12 frames it will change spriteNum = walking animation
        // enemy[0].spriteCounter++;

        if (spriteCounter > 12) {
            if (spriteNum == 1) {
                spriteNum = 2;

                // enemy[0].spriteNum =2;

            } else if (spriteNum == 2) {
                spriteNum = 1;
                // enemy[0].spriteNum = 1;

            }

            spriteCounter = 0;
            // enemy[0].spriteCounter = 0;

        }

    }

    public void drawGiantMob(Graphics2D g2d) {

        AffineTransform at = g2d.getTransform();
        g2d.setTransform(at);
        BufferedImage sprite = null;

        double screenX = worldX - gp.me.worldX + gp.me.screenX;
        double screenY = worldY - gp.me.worldY + gp.me.screenY;

        // STOP MOVING CAMERA
        if (gp.me.worldX < gp.me.screenX) {
            screenX = worldX;
        }
        if (gp.me.worldY < gp.me.screenY) {
            screenY = worldY;
        }
        int rightEdge = gp.screenWidth - gp.me.screenX;
        if (rightEdge > gp.worldWidth - gp.me.worldX) {
            screenX = gp.screenWidth - (gp.worldWidth - worldX);
        }
        int bottomEdge = gp.screenHeight - gp.me.screenY;
        if (bottomEdge > gp.worldHeight - gp.me.worldY) {
            screenY = gp.screenHeight - (gp.worldHeight - worldY);
        }
        ///////////////////

        if (worldX + gp.tileSize > gp.me.worldX - gp.me.screenX &&
                worldX - gp.tileSize < gp.me.worldX + gp.me.screenX &&
                worldY + gp.tileSize > gp.me.worldY - gp.me.screenY &&
                worldY - gp.tileSize < gp.me.worldY + gp.me.screenY) {

            switch (direction) {
                case "up":
                    if (spriteNum == 1) {
                        sprite = up1;
                    } else {
                        sprite = up2;
                    }

                    break;
                case "down":
                    if (spriteNum == 1) {
                        sprite = down1;
                    } else {
                        sprite = down2;
                    }
                    break;
                case "left":
                    if (spriteNum == 1) {
                        sprite = left1;
                    } else {
                        sprite = left2;
                    }
                    break;
                case "right":
                    if (spriteNum == 1) {
                        sprite = right1;
                    } else {
                        sprite = right2;
                    }
                    break;

            }

            g2d.drawImage(sprite, (int) screenX, (int) screenY, 150, 150, null);
            g2d.setTransform(at);

        }
        // If player is around the edge, draw everything
        else if (gp.me.worldX < gp.me.screenX ||
                gp.me.worldY < gp.me.screenY ||
                rightEdge > gp.worldWidth - gp.me.worldX ||
                bottomEdge > gp.worldHeight - gp.me.worldY) {
            g2d.drawImage(sprite, (int) screenX, (int) screenY, 150, 150, null);
        }
    }

    public void drawMob(Graphics2D g2d) {

        AffineTransform at = g2d.getTransform();
        g2d.setTransform(at);
        BufferedImage sprite = null;

        double screenX = worldX - gp.me.worldX + gp.me.screenX;
        double screenY = worldY - gp.me.worldY + gp.me.screenY;

        // STOP MOVING CAMERA
        if (gp.me.worldX < gp.me.screenX) {
            screenX = worldX;
        }
        if (gp.me.worldY < gp.me.screenY) {
            screenY = worldY;
        }
        int rightEdge = gp.screenWidth - gp.me.screenX;
        if (rightEdge > gp.worldWidth - gp.me.worldX) {
            screenX = gp.screenWidth - (gp.worldWidth - worldX);
        }
        int bottomEdge = gp.screenHeight - gp.me.screenY;
        if (bottomEdge > gp.worldHeight - gp.me.worldY) {
            screenY = gp.screenHeight - (gp.worldHeight - worldY);
        }
        ///////////////////

        if (worldX + gp.tileSize > gp.me.worldX - gp.me.screenX &&
                worldX - gp.tileSize < gp.me.worldX + gp.me.screenX &&
                worldY + gp.tileSize > gp.me.worldY - gp.me.screenY &&
                worldY - gp.tileSize < gp.me.worldY + gp.me.screenY) {

            switch (direction) {
                case "up":
                    if (spriteNum == 1) {
                        sprite = up1;
                    } else {
                        sprite = up2;
                    }

                    break;
                case "down":
                    if (spriteNum == 1) {
                        sprite = down1;
                    } else {
                        sprite = down2;
                    }
                    break;
                case "left":
                    if (spriteNum == 1) {
                        sprite = left1;
                    } else {
                        sprite = left2;
                    }
                    break;
                case "right":
                    if (spriteNum == 1) {
                        sprite = right1;
                    } else {
                        sprite = right2;
                    }
                    break;

            }

            g2d.drawImage(sprite, (int) screenX, (int) screenY, gp.tileSize, gp.tileSize, null);
            g2d.setTransform(at);

        }
        // If player is around the edge, draw everything
        else if (gp.me.worldX < gp.me.screenX ||
                gp.me.worldY < gp.me.screenY ||
                rightEdge > gp.worldWidth - gp.me.worldX ||
                bottomEdge > gp.worldHeight - gp.me.worldY) {
            g2d.drawImage(sprite, (int) screenX, (int) screenY, gp.tileSize, gp.tileSize, null);
        }
    }


    public void drawProjectile4(Graphics2D g2d) {
        BufferedImage sprite = null;

        double screenX = worldX - gp.me.worldX + gp.me.screenX;
        double screenY = worldY - gp.me.worldY + gp.me.screenY;

        // STOP MOVING CAMERA
        if (gp.me.worldX < gp.me.screenX) {
            screenX = worldX;
        }
        if (gp.me.worldY < gp.me.screenY) {
            screenY = worldY;
        }
        int rightEdge = gp.screenWidth - gp.me.screenX;
        if (rightEdge > gp.worldWidth - gp.me.worldX) {
            screenX = gp.screenWidth - (gp.worldWidth - worldX);
        }
        int bottomEdge = gp.screenHeight - gp.me.screenY;
        if (bottomEdge > gp.worldHeight - gp.me.worldY) {
            screenY = gp.screenHeight - (gp.worldHeight - worldY);
        }
        ///////////////////

        if (worldX + gp.tileSize > gp.me.worldX - gp.me.screenX &&
                worldX - gp.tileSize < gp.me.worldX + gp.me.screenX &&
                worldY + gp.tileSize > gp.me.worldY - gp.me.screenY &&
                worldY - gp.tileSize < gp.me.worldY + gp.me.screenY) {

            switch (direction) {
                case "up":
                    if (spriteNum == 1) {
                        sprite = up1;
                    } else {
                        sprite = up1;
                    }

                    break;
                case "down":
                    if (spriteNum == 1) {
                        sprite = down1;
                    } else {
                        sprite = down1;
                    }
                    break;
                case "left":
                    if (spriteNum == 1) {
                        sprite = left1;
                    } else {
                        sprite = left1;
                    }
                    break;
                case "right":
                    if (spriteNum == 1) {
                        sprite = right1;
                    } else {
                        sprite = right1;
                    }
                    break;
                case "up-right":
                    if (spriteNum == 1) {
                        sprite = right2;
                    } else {
                        sprite = right2;
                    }

                    break;

                case "up-left":
                    if (spriteNum == 1) {
                        sprite = up2;
                    } else {
                        sprite = up2;
                    }

                    break;
                case "down-right":
                    if (spriteNum == 1) {
                        sprite = left2;
                    } else {
                        sprite = left2;
                    }

                    break;

                case "down-left":
                    if (spriteNum == 1) {
                        sprite = down2;
                    } else {
                        sprite = down2;
                    }

                    break;

            }
            /*
             * float alpha = 2 * 0.1f;
             * AlphaComposite alcom = AlphaComposite.getInstance(
             * AlphaComposite.SRC_OVER, alpha);
             * g2d.setComposite(alcom);
             */

            if(size >= 65){
                size = 65;
            }
            g2d.drawImage(sprite, (int) screenX, (int) screenY, (int)size, (int)size, null);

        }
        // If player is around the edge, draw everything
        else if (gp.me.worldX < gp.me.screenX ||
                gp.me.worldY < gp.me.screenY ||
                rightEdge > gp.worldWidth - gp.me.worldX ||
                bottomEdge > gp.worldHeight - gp.me.worldY) {
            g2d.drawImage(sprite, (int) screenX, (int) screenY, (int)size, (int)size, null);
        }
    }

    public void drawProjectileMob(Graphics2D g2d) {
        BufferedImage sprite = null;

        double screenX = worldX - gp.me.worldX + gp.me.screenX;
        double screenY = worldY - gp.me.worldY + gp.me.screenY; 

        // STOP MOVING CAMERA
        if (gp.me.worldX < gp.me.screenX) {
            screenX = worldX;
        }
        if (gp.me.worldY < gp.me.screenY) {
            screenY = worldY;
        }
        int rightEdge = gp.screenWidth - gp.me.screenX;
        if (rightEdge > gp.worldWidth - gp.me.worldX) {
            screenX = gp.screenWidth - (gp.worldWidth - worldX);
        }
        int bottomEdge = gp.screenHeight - gp.me.screenY;
        if (bottomEdge > gp.worldHeight - gp.me.worldY) {
            screenY = gp.screenHeight - (gp.worldHeight - worldY);
        }
        ///////////////////

        if (worldX + gp.tileSize > gp.me.worldX - gp.me.screenX &&
                worldX - gp.tileSize < gp.me.worldX + gp.me.screenX &&
                worldY + gp.tileSize > gp.me.worldY - gp.me.screenY &&
                worldY - gp.tileSize < gp.me.worldY + gp.me.screenY) {

            switch (direction) {
                case "up":
                    if (spriteNum == 1) {
                        sprite = up1;
                    } else {
                        sprite = up1;
                    }

                    break;
                case "down":
                    if (spriteNum == 1) {
                        sprite = down1;
                    } else {
                        sprite = down1;
                    }
                    break;
                case "left":
                    if (spriteNum == 1) {
                        sprite = left1;
                    } else {
                        sprite = left1;
                    }
                    break;
                case "right":
                    if (spriteNum == 1) {
                        sprite = right1;
                    } else {
                        sprite = right1;
                    }
                    break;
                case "up-right":
                    if (spriteNum == 1) {
                        sprite = right2;
                    } else {
                        sprite = right2;
                    }

                    break;

                case "up-left":
                    if (spriteNum == 1) {
                        sprite = up2;
                    } else {
                        sprite = up2;
                    }

                    break;
                case "down-right":
                    if (spriteNum == 1) {
                        sprite = left2;
                    } else {
                        sprite = left2;
                    }

                    break;

                case "down-left":
                    if (spriteNum == 1) {
                        sprite = down2;
                    } else {
                        sprite = down2;
                    }

                    break;

            }
            /*
             * float alpha = 2 * 0.1f;
             * AlphaComposite alcom = AlphaComposite.getInstance(
             * AlphaComposite.SRC_OVER, alpha);
             * g2d.setComposite(alcom);
             */

            if(size >= 60){
                size = 65;
            }
            g2d.drawImage(sprite, (int) screenX, (int) screenY, (int)80, (int)80, null);

        }
        // If player is around the edge, draw everything
        else if (gp.me.worldX < gp.me.screenX ||
                gp.me.worldY < gp.me.screenY ||
                rightEdge > gp.worldWidth - gp.me.worldX ||
                bottomEdge > gp.worldHeight - gp.me.worldY) {
            g2d.drawImage(sprite, (int) screenX, (int) screenY, (int)80, (int)80, null);
        }
    }
    public void drawProjectile(Graphics2D g2d) {
        BufferedImage sprite = null;

        double screenX = worldX - gp.me.worldX + gp.me.screenX;
        double screenY = worldY - gp.me.worldY + gp.me.screenY; 

        // STOP MOVING CAMERA
        if (gp.me.worldX < gp.me.screenX) {
            screenX = worldX;
        }
        if (gp.me.worldY < gp.me.screenY) {
            screenY = worldY;
        }
        int rightEdge = gp.screenWidth - gp.me.screenX;
        if (rightEdge > gp.worldWidth - gp.me.worldX) {
            screenX = gp.screenWidth - (gp.worldWidth - worldX);
        }
        int bottomEdge = gp.screenHeight - gp.me.screenY;
        if (bottomEdge > gp.worldHeight - gp.me.worldY) {
            screenY = gp.screenHeight - (gp.worldHeight - worldY);
        }
        ///////////////////

        if (worldX + gp.tileSize > gp.me.worldX - gp.me.screenX &&
                worldX - gp.tileSize < gp.me.worldX + gp.me.screenX &&
                worldY + gp.tileSize > gp.me.worldY - gp.me.screenY &&
                worldY - gp.tileSize < gp.me.worldY + gp.me.screenY) {

            switch (direction) {
                case "up":
                    if (spriteNum == 1) {
                        sprite = up1;
                    } else {
                        sprite = up1;
                    }

                    break;
                case "down":
                    if (spriteNum == 1) {
                        sprite = down1;
                    } else {
                        sprite = down1;
                    }
                    break;
                case "left":
                    if (spriteNum == 1) {
                        sprite = left1;
                    } else {
                        sprite = left1;
                    }
                    break;
                case "right":
                    if (spriteNum == 1) {
                        sprite = right1;
                    } else {
                        sprite = right1;
                    }
                    break;
                case "up-right":
                    if (spriteNum == 1) {
                        sprite = right2;
                    } else {
                        sprite = right2;
                    }

                    break;

                case "up-left":
                    if (spriteNum == 1) {
                        sprite = up2;
                    } else {
                        sprite = up2;
                    }

                    break;
                case "down-right":
                    if (spriteNum == 1) {
                        sprite = left2;
                    } else {
                        sprite = left2;
                    }

                    break;

                case "down-left":
                    if (spriteNum == 1) {
                        sprite = down2;
                    } else {
                        sprite = down2;
                    }

                    break;

            }
            /*
             * float alpha = 2 * 0.1f;
             * AlphaComposite alcom = AlphaComposite.getInstance(
             * AlphaComposite.SRC_OVER, alpha);
             * g2d.setComposite(alcom);
             */

            if(size >= 60){
                size = 65;
            }
            g2d.drawImage(sprite, (int) screenX, (int) screenY, (int)size, (int)size, null);

        }
        // If player is around the edge, draw everything
        else if (gp.me.worldX < gp.me.screenX ||
                gp.me.worldY < gp.me.screenY ||
                rightEdge > gp.worldWidth - gp.me.worldX ||
                bottomEdge > gp.worldHeight - gp.me.worldY) {
            g2d.drawImage(sprite, (int) screenX, (int) screenY, (int)size, (int)size, null);
        }
    }


    public void drawProjectile2(Graphics2D g2d) {
        BufferedImage sprite = null;

        double screenX = worldX - gp.me.worldX + gp.me.screenX;
        double screenY = worldY - gp.me.worldY + gp.me.screenY; 

        // STOP MOVING CAMERA
        if (gp.me.worldX < gp.me.screenX) {
            screenX = worldX;
        }
        if (gp.me.worldY < gp.me.screenY) {
            screenY = worldY;
        }
        int rightEdge = gp.screenWidth - gp.me.screenX;
        if (rightEdge > gp.worldWidth - gp.me.worldX) {
            screenX = gp.screenWidth - (gp.worldWidth - worldX);
        }
        int bottomEdge = gp.screenHeight - gp.me.screenY;
        if (bottomEdge > gp.worldHeight - gp.me.worldY) {
            screenY = gp.screenHeight - (gp.worldHeight - worldY);
        }
        ///////////////////

        if (worldX + gp.tileSize > gp.me.worldX - gp.me.screenX &&
                worldX - gp.tileSize < gp.me.worldX + gp.me.screenX &&
                worldY + gp.tileSize > gp.me.worldY - gp.me.screenY &&
                worldY - gp.tileSize < gp.me.worldY + gp.me.screenY) {

            switch (direction) {
                case "up":
                    if (spriteNum == 1) {
                        sprite = up1;
                    } else {
                        sprite = up1;
                    }

                    break;
                case "down":
                    if (spriteNum == 1) {
                        sprite = down1;
                    } else {
                        sprite = down1;
                    }
                    break;
                case "left":
                    if (spriteNum == 1) {
                        sprite = left1;
                    } else {
                        sprite = left1;
                    }
                    break;
                case "right":
                    if (spriteNum == 1) {
                        sprite = right1;
                    } else {
                        sprite = right1;
                    }
                    break;
                case "up-right":
                    if (spriteNum == 1) {
                        sprite = right2;
                    } else {
                        sprite = right2;
                    }

                    break;

                case "up-left":
                    if (spriteNum == 1) {
                        sprite = up2;
                    } else {
                        sprite = up2;
                    }

                    break;
                case "down-right":
                    if (spriteNum == 1) {
                        sprite = left2;
                    } else {
                        sprite = left2;
                    }

                    break;

                case "down-left":
                    if (spriteNum == 1) {
                        sprite = down2;
                    } else {
                        sprite = down2;
                    }

                    break;

            }
            /*
             * float alpha = 2 * 0.1f;
             * AlphaComposite alcom = AlphaComposite.getInstance(
             * AlphaComposite.SRC_OVER, alpha);
             * g2d.setComposite(alcom);
             */

            g2d.drawImage(sprite, (int) screenX, (int) screenY, 80, 50, null);

        }
        // If player is around the edge, draw everything
        else if (gp.me.worldX < gp.me.screenX ||
                gp.me.worldY < gp.me.screenY ||
                rightEdge > gp.worldWidth - gp.me.worldX ||
                bottomEdge > gp.worldHeight - gp.me.worldY) {
            g2d.drawImage(sprite, (int) screenX, (int) screenY, 80, 50, null);
        }
    }

    public void drawProjectile3(Graphics2D g2d) {
        BufferedImage sprite = null;

        double screenX = worldX - gp.me.worldX + gp.me.screenX;
        double screenY = worldY - gp.me.worldY + gp.me.screenY; 

        // STOP MOVING CAMERA
        if (gp.me.worldX < gp.me.screenX) {
            screenX = worldX;
        }
        if (gp.me.worldY < gp.me.screenY) {
            screenY = worldY;
        }
        int rightEdge = gp.screenWidth - gp.me.screenX;
        if (rightEdge > gp.worldWidth - gp.me.worldX) {
            screenX = gp.screenWidth - (gp.worldWidth - worldX);
        }
        int bottomEdge = gp.screenHeight - gp.me.screenY;
        if (bottomEdge > gp.worldHeight - gp.me.worldY) {
            screenY = gp.screenHeight - (gp.worldHeight - worldY);
        }
        ///////////////////

        if (worldX + gp.tileSize > gp.me.worldX - gp.me.screenX &&
                worldX - gp.tileSize < gp.me.worldX + gp.me.screenX &&
                worldY + gp.tileSize > gp.me.worldY - gp.me.screenY &&
                worldY - gp.tileSize < gp.me.worldY + gp.me.screenY) {

            switch (direction) {
                case "up":
                    if (spriteNum == 1) {
                        sprite = up1;
                    } else {
                        sprite = up1;
                    }

                    break;
                case "down":
                    if (spriteNum == 1) {
                        sprite = down1;
                    } else {
                        sprite = down1;
                    }
                    break;
                case "left":
                    if (spriteNum == 1) {
                        sprite = left1;
                    } else {
                        sprite = left1;
                    }
                    break;
                case "right":
                    if (spriteNum == 1) {
                        sprite = right1;
                    } else {
                        sprite = right1;
                    }
                    break;
                case "up-right":
                    if (spriteNum == 1) {
                        sprite = right2;
                    } else {
                        sprite = right2;
                    }

                    break;

                case "up-left":
                    if (spriteNum == 1) {
                        sprite = up2;
                    } else {
                        sprite = up2;
                    }

                    break;
                case "down-right":
                    if (spriteNum == 1) {
                        sprite = left2;
                    } else {
                        sprite = left2;
                    }

                    break;

                case "down-left":
                    if (spriteNum == 1) {
                        sprite = down2;
                    } else {
                        sprite = down2;
                    }

                    break;

            }
            /*
             * float alpha = 2 * 0.1f;
             * AlphaComposite alcom = AlphaComposite.getInstance(
             * AlphaComposite.SRC_OVER, alpha);
             * g2d.setComposite(alcom);
             */

            g2d.drawImage(sprite, (int) screenX, (int) screenY, 80, 80, null);

        }
        // If player is around the edge, draw everything
        else if (gp.me.worldX < gp.me.screenX ||
                gp.me.worldY < gp.me.screenY ||
                rightEdge > gp.worldWidth - gp.me.worldX ||
                bottomEdge > gp.worldHeight - gp.me.worldY) {
            g2d.drawImage(sprite, (int) screenX, (int) screenY, 80, 80, null);
        }
    }


    public void drawSigns(Graphics2D g2d) {

        BufferedImage sprite = null;

        double screenX = worldX - gp.me.worldX + gp.me.screenX;
        double screenY = worldY - gp.me.worldY + gp.me.screenY; 

        // STOP MOVING CAMERA
        if (gp.me.worldX < gp.me.screenX) {
            screenX = worldX;
        }
        if (gp.me.worldY < gp.me.screenY) {
            screenY = worldY;
        }
        int rightEdge = gp.screenWidth - gp.me.screenX;
        if (rightEdge > gp.worldWidth - gp.me.worldX) {
            screenX = gp.screenWidth - (gp.worldWidth - worldX);
        }
        int bottomEdge = gp.screenHeight - gp.me.screenY;
        if (bottomEdge > gp.worldHeight - gp.me.worldY) {
            screenY = gp.screenHeight - (gp.worldHeight - worldY);
        }
        ///////////////////

        if (worldX + gp.tileSize > gp.me.worldX - gp.me.screenX &&
                worldX - gp.tileSize < gp.me.worldX + gp.me.screenX &&
                worldY + gp.tileSize > gp.me.worldY - gp.me.screenY &&
                worldY - gp.tileSize < gp.me.worldY + gp.me.screenY) {

            sprite = up1 = up2 = down1 = down2;

            g2d.drawImage(sprite, (int) screenX, (int) screenY, gp.tileSize, gp.tileSize, null);

        }
        // If player is around the edge, draw everything
        else if (gp.me.worldX < gp.me.screenX ||
                gp.me.worldY < gp.me.screenY ||
                rightEdge > gp.worldWidth - gp.me.worldX ||
                bottomEdge > gp.worldHeight - gp.me.worldY) {
            g2d.drawImage(sprite, (int) screenX, (int) screenY, gp.tileSize, gp.tileSize, null);
        }

    }

    public void setX(int i, double n) {
        gp.mob[i].worldX = n;
    }

    public double getX(int i) {
        return gp.mob[i].worldX;

    }

    public void setY(int i, double n) {
        gp.mob[i].worldY = n;
    }

    public double getY(int i) {
        return gp.mob[i].worldY;

    }

    public String getDirection(int i) { // set direction
        return gp.mob[i].direction;

    }

    public void moveV(double n) {
        worldY += n;
    }

    public void setDirection(int i, String d) {
        gp.mob[i].direction = d;

    }

}
