/**
    This is a class that manages the player's appearance and
    functionality.

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


import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player extends Creature {

    
    public Player (GameFrame gp, double a, double b, double c, Color d, String e, int f, int g){ // default values

        super(gp); //Entity.Entity(PlayerFrame)

        //player 1's --- accessing the default values from PlayerFrame
        screenX = f;
        screenY = g;
        worldX = a;
        worldY = b;

        size = 48;
        color = d;
        direction = e;

        //Player's current life
        maxLife = 10;
        life = maxLife;

        //Solid Area for Player Collision
        solidArea = new Rectangle(8, 28, 28, 16);

        //42823
        solidAreaDefaultX = solidArea.x; //recall x and y values
        solidAreaDefaultY = solidArea.y;

        //for first skill
        projectile = new OBJ_Iceball(gp);
       
        //for second skill
        speed = 2;
        projectile2 = new OBJ_Fireball(gp);
        projectile3 = new OBJ_Fireball(gp);
        projectile4 = new OBJ_Fireball(gp);
        projectile5 = new OBJ_Fireball(gp);
        projectile6 = new OBJ_Fireball(gp);
        projectile7 = new OBJ_Fireball(gp);
        projectile8 = new OBJ_Fireball(gp);
        projectile9 = new OBJ_Fireball(gp);

        //for third skill
        projectile10 = new OBJ_Earthball(gp);


        //for fourth skill
        projectile11 = new OBJ_Bubbleball(gp);



        getSpriteImage();


    }
    public void drawSprite(Graphics2D g2d){
         
        
        /*
         Rectangle2D.Double square = new Rectangle2D.Double(x, y, size, size);
        g2d.setColor(color);
        g2d.fill(square);
         */

        BufferedImage sprite = null;

        switch(direction){
            case "up":
                if(spriteNum == 1)
                    sprite = up1;
                if(spriteNum == 2)
                    sprite = up2;
                if(spriteNum == 3)
                    sprite = up3;    
                break;
            case "down":
                if(spriteNum == 1)
                    sprite = down1;
                if(spriteNum == 2)
                    sprite = down2;
                if(spriteNum == 3)
                    sprite = down3;
                break;
            case "left":
                if(spriteNum == 1)
                    sprite = left1;
                if(spriteNum == 2)
                    sprite = left2;
                if(spriteNum == 3)
                    sprite = left3;
                break;
            case "right":
                if(spriteNum == 1)
                    sprite = right1;
                if(spriteNum == 2)
                    sprite = right2;
                if(spriteNum == 3)
                    sprite = right3;
                break;
        }


            int x =  screenX;
            int y = screenY;

            if(screenX > worldX){
                x = (int)worldX;
            }
            if(screenY > worldY){
                y = (int)worldY;
            }
            int rightEdge = gp.screenWidth - screenX;
            if(rightEdge > gp.worldWidth - worldX){
                x =(int) (gp.screenWidth - (gp.worldWidth - worldX)); //tile's worldX is upperleft top, so we need to subtract 48 since this is the scale.

            }
            int bottomEdge = gp.screenHeight - screenY;

            if(bottomEdge > gp.worldHeight - worldY){
                y = (int)(gp.screenHeight - (gp.worldHeight - worldY)); 

            }

        g2d.drawImage(sprite, (int)x,(int) y, 55, 55,null); //draw it in 48x48 tile pixel
        
        
    }

    public void moveH(double n){
        worldX += n; 
    }

    public void moveV(double n){
        worldY += n;
    }

    public void setX(double n){ //Used that can Replace values of x and y completely...
        worldX = n;
    }
    public void setY(double n){
        worldY = n;
    }

    public double getX(){
        return worldX;

    }

    public double getY(){
        return worldY;
        
    }

    public int getLife(){
        return life;
    }

    public void setLife(int a){
        life = a;
    }

    //ryisnow

    public void getSpriteImage(){
        try{
            
            if(gp.playerID == 2){

                up1 = ImageIO.read(getClass().getResourceAsStream("Midbar/Player/Player2/lady_back.png"));
                up2 = ImageIO.read(getClass().getResourceAsStream("Midbar/Player/Player2/lady_back_1.png"));
                up3 = ImageIO.read(getClass().getResourceAsStream("Midbar/Player/Player2/lady_back_2.png"));
                down1 = ImageIO.read(getClass().getResourceAsStream("Midbar/Player/Player2/lady_front.png"));
                down2 = ImageIO.read(getClass().getResourceAsStream("Midbar/Player/Player2/lady_front_1.png"));
                down3 = ImageIO.read(getClass().getResourceAsStream("Midbar/Player/Player2/lady_front_2.png"));
                left1 = ImageIO.read(getClass().getResourceAsStream("Midbar/Player/Player2/lady_left_1.png"));
                left2 = ImageIO.read(getClass().getResourceAsStream("Midbar/Player/Player2/lady_left_2.png"));
                left3 = ImageIO.read(getClass().getResourceAsStream("Midbar/Player/Player2/lady_left_3.png"));
                right1 = ImageIO.read(getClass().getResourceAsStream("Midbar/Player/Player2/lady_right_1.png"));
                right2 = ImageIO.read(getClass().getResourceAsStream("Midbar/Player/Player2/lady_right_2.png"));
                right3 = ImageIO.read(getClass().getResourceAsStream("Midbar/Player/Player2/lady_right_3.png"));
                
            }
            else{

                up1 = ImageIO.read(getClass().getResourceAsStream("Midbar/Player/Player1/rolf_back_1.png"));
                up2 = ImageIO.read(getClass().getResourceAsStream("Midbar/Player/Player1/rolf_back_2.png"));
                up3 = ImageIO.read(getClass().getResourceAsStream("Midbar/Player/Player1/rolf_back_3.png"));
                down1 = ImageIO.read(getClass().getResourceAsStream("Midbar/Player/Player1/rolf_front_1.png"));
                down2 = ImageIO.read(getClass().getResourceAsStream("Midbar/Player/Player1/rolf_front_2.png"));
                down3 = ImageIO.read(getClass().getResourceAsStream("Midbar/Player/Player1/rolf_front_3.png"));
                left1 = ImageIO.read(getClass().getResourceAsStream("Midbar/Player/Player1/rolf_left_1.png"));
                left2 = ImageIO.read(getClass().getResourceAsStream("Midbar/Player/Player1/rolf_left_2.png"));
                left3 = ImageIO.read(getClass().getResourceAsStream("Midbar/Player/Player1/rolf_left_3.png"));
                right1 = ImageIO.read(getClass().getResourceAsStream("Midbar/Player/Player1/rolf_right_1.png"));
                right2 = ImageIO.read(getClass().getResourceAsStream("Midbar/Player/Player1/rolf_right_2.png"));
                right3 = ImageIO.read(getClass().getResourceAsStream("Midbar/Player/Player1/rolf_right_3.png"));
            
            }

        }catch(IOException e){
            e.printStackTrace();

        }
    }


}
