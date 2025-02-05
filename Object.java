/**
    This is a superclass that is responsible for drawing objects.

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
*/


import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.*;

//Super Objects == Objects placed in the map
// Draw Objects

//OBJ_name = Values of object
//SuperObject = draw Object
//PlayerFrame = where you draw the Object to the GUI
public class Object {

    
    public java.awt.image.BufferedImage image, image2, image3, image4, image5;//updated
    public String name;
    public boolean collision = false;
    public int worldX, worldY;

    public Rectangle solidArea = new Rectangle(0, 0, 48, 48); // basically whole tile is solid
    public int solidAreaDefaultX = 0;
    public int solidAreaDefaultY = 0; //

    // For Stones

    public boolean stoneEquip = false;
    public int stoneEquipPlayer = 0;

    public boolean itemEquip = false;


    // fire stone counter

    public int spriteNum = 1;
    public int spriteCounter = 0;

    public void draw(Graphics2D g2d, GameFrame gp) {

        double screenX = worldX - gp.me.worldX + gp.me.screenX;
        double screenY = worldY - gp.me.worldY + gp.me.screenY; // tbh not sure how this works hahaha

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

            g2d.drawImage(image, (int) screenX, (int) screenY, gp.tileSize, gp.tileSize, null);

        }
        // If player is around the edge, draw everything
        else if (gp.me.worldX < gp.me.screenX ||
                gp.me.worldY < gp.me.screenY ||
                rightEdge > gp.worldWidth - gp.me.worldX ||
                bottomEdge > gp.worldHeight - gp.me.worldY) {
            g2d.drawImage(image, (int) screenX, (int) screenY, gp.tileSize, gp.tileSize, null);
        }

    }

    public void drawStones(Graphics2D g2d, GameFrame gp) {

        changeStoneStates(gp);

        // System.out.println(gp.stone[1].spriteCounter);

        double screenX = worldX - gp.me.worldX + gp.me.screenX;
        double screenY = worldY - gp.me.worldY + gp.me.screenY; // tbh not sure how this works hahaha

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

            g2d.drawImage(image, (int) screenX, (int) screenY, 80, 80, null);

        }
        // If player is around the edge, draw everything
        else if (gp.me.worldX < gp.me.screenX ||
                gp.me.worldY < gp.me.screenY ||
                rightEdge > gp.worldWidth - gp.me.worldX ||
                bottomEdge > gp.worldHeight - gp.me.worldY) {
            g2d.drawImage(image, (int) screenX, (int) screenY, 80, 80, null);
        }

    }

    public void changeStoneStates(GameFrame gp) {

      

        // Earth Stone change image
        gp.stone[0].spriteCounter++;

        if (gp.stone[0].spriteCounter > 370) {

            if (gp.stone[0].spriteNum == 1) {
                gp.stone[0].spriteNum = 2;
                try {
                    gp.stone[0].image = ImageIO
                            .read(getClass().getResourceAsStream("Midbar/Objects/Elements/gem_e_1.png"));

                } catch (IOException e) {

                }
            } else if (gp.stone[0].spriteNum == 2) {
                gp.stone[0].spriteNum = 1;
                try {
                    gp.stone[0].image = ImageIO
                            .read(getClass().getResourceAsStream("Midbar/Objects/Elements/gem_e_2.png"));

                } catch (IOException e) {

                }
            }

            else if (gp.stone[0].spriteNum == 3) {
                try {
                    gp.stone[0].image = ImageIO
                            .read(getClass().getResourceAsStream("Midbar/Objects/Elements/gem_e_3.png"));

                } catch (IOException e) {

                }
            }

            gp.stone[0].spriteCounter = 0;

        }

        // Fire
        gp.stone[1].spriteCounter++;
        if (gp.stone[1].spriteCounter > 370) {

            if (gp.stone[1].spriteNum == 1) {
                gp.stone[1].spriteNum = 2;
                try {
                    gp.stone[1].image = ImageIO
                            .read(getClass().getResourceAsStream("Midbar/Objects/Elements/gem_f_1.png"));

                } catch (IOException e) {

                }
            } else if (gp.stone[1].spriteNum == 2) {
                gp.stone[1].spriteNum = 1;
                try {
                    gp.stone[1].image = ImageIO
                            .read(getClass().getResourceAsStream("Midbar/Objects/Elements/gem_f_2.png"));

                } catch (IOException e) {

                }
            }

            else if (gp.stone[1].spriteNum == 3) {
                try {
                    gp.stone[1].image = ImageIO
                            .read(getClass().getResourceAsStream("Midbar/Objects/Elements/gem_f_3.png"));

                } catch (IOException e) {

                }
            }

            gp.stone[1].spriteCounter = 0;

        }

        // Water Stone change image
        gp.stone[2].spriteCounter++;

        if (gp.stone[2].spriteCounter > 370) {

            if (gp.stone[2].spriteNum == 1) {
                gp.stone[2].spriteNum = 2;
                try {
                    gp.stone[2].image = ImageIO
                            .read(getClass().getResourceAsStream("Midbar/Objects/Elements/gem_w_1.png"));

                } catch (IOException e) {

                }
            } else if (gp.stone[2].spriteNum == 2) {
                gp.stone[2].spriteNum = 1;
                try {
                    gp.stone[2].image = ImageIO
                            .read(getClass().getResourceAsStream("Midbar/Objects/Elements/gem_w_2.png"));

                } catch (IOException e) {

                }
            }

            else if (gp.stone[2].spriteNum == 3) {
                try {
                    gp.stone[2].image = ImageIO
                            .read(getClass().getResourceAsStream("Midbar/Objects/Elements/gem_w_3.png"));

                } catch (IOException e) {

                }
            }

            gp.stone[2].spriteCounter = 0;

        }

        // Air Stone change image
        gp.stone[3].spriteCounter++;

        if (gp.stone[3].spriteCounter > 370) {

            if (gp.stone[3].spriteNum == 1) {
                gp.stone[3].spriteNum = 2;
                try {
                    gp.stone[3].image = ImageIO
                            .read(getClass().getResourceAsStream("Midbar/Objects/Elements/gem_a_1.png"));

                } catch (IOException e) {

                }
            } else if (gp.stone[3].spriteNum == 2) {
                gp.stone[3].spriteNum = 1;
                try {
                    gp.stone[3].image = ImageIO
                            .read(getClass().getResourceAsStream("Midbar/Objects/Elements/gem_a_2.png"));

                } catch (IOException e) {

                }
            }

            else if (gp.stone[3].spriteNum == 3) {
                try {
                    gp.stone[3].image = ImageIO
                            .read(getClass().getResourceAsStream("Midbar/Objects/Elements/gem_a_3.png"));

                } catch (IOException e) {

                }
            }

            gp.stone[3].spriteCounter = 0;

        }

        // crystal

        gp.stone[4].spriteCounter++;

        if (gp.stone[4].spriteCounter > 120) {

            if (gp.stone[4].spriteNum == 1) {
                gp.stone[4].spriteNum = 2;
                try {
                    gp.stone[4].image = ImageIO
                            .read(getClass().getResourceAsStream("Midbar/Objects/Elements/gem_1.png"));

                } catch (IOException e) {

                }
            } else if (gp.stone[4].spriteNum == 2) {
                gp.stone[4].spriteNum = 1;
                try {
                    gp.stone[4].image = ImageIO
                            .read(getClass().getResourceAsStream("Midbar/Objects/Elements/gem_2.png"));

                } catch (IOException e) {

                }
            }

            else if (gp.stone[4].spriteNum == 3) {
                try {
                    gp.stone[4].image = ImageIO
                            .read(getClass().getResourceAsStream("Midbar/Objects/Elements/gem_3.png"));

                } catch (IOException e) {

                }
            }

            gp.stone[4].spriteCounter = 0;

        }

    }

  
}
