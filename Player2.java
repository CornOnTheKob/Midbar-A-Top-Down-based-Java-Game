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

import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player2 extends Creature {
    
    

    public Player2(GameFrame gp){

        super(gp);

        direction = "down";
        speed = 2;
        getSpriteImage();


        maxLife = 10;
        life = maxLife;

        //for first skill
        projectile = new OBJ_Iceball(gp);
    
        //for second skill
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
         projectile11 = new OBJ_Bubbleball(gp);

    }

    public void drawSprite(Graphics2D g2d){

         /*
         Rectangle2D.Double square = new Rectangle2D.Double(x, y, size, size);
        g2d.setColor(color);
        g2d.fill(square);
         */

         java.awt.image.BufferedImage sprite = null;

         


        
       //  g2d.drawImage(sprite, (int)screenX,(int) screenY, (int)48,(int)48,null); //draw it in 48x48 tile pixel
        

    }
    

    public void walkChecker(boolean f){ //check if basically key is pressed, so if not pressed, it should be false so the animation stops walking
        gp.enemy[0].walk = f;
    }
    public void spriteCounter(int s){ // basically a timer, for the walking animation that is sent to the server


    if(gp.enemy[0].walk == true){

     gp.enemy[0].spriteCounter += s;

    
        if(gp.enemy[0].spriteCounter > 5){

            if(gp.enemy[0].spriteNum == 1){
                gp.enemy[0].spriteNum = 2;
            }
            else if(gp.enemy[0].spriteNum == 2){
                gp.enemy[0].spriteNum = 1;
            }
            
            gp.enemy[0].spriteCounter = 0;

        }

    }
    // System.out.println(gp.enemy[0].spriteCounter);
        

    }

    public void getDirection(String d){ //set direction
        gp.enemy[0].direction = d;
    }
    public void moveH(double n){
        gp.enemy[0].worldX  += n; 
    }

    public void moveV(double n){
        gp.enemy[0].worldY  += n;
    }

    public void setX(double n){ //Used that can Replace values of x and y completely...
        gp.enemy[0].worldX  = n;
    }
    public void setY(double n){
        gp.enemy[0].worldY  = n;
    }

    public double getX(){
        return gp.enemy[0].worldX ;

    }

    public double getY(){
        return  gp.enemy[0].worldY ;
        
    }

    public void getSpriteImage(){
        try{
            
            up1 = ImageIO.read(getClass().getResourceAsStream("Midbar/Player/Player2/lady_back_2.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("Midbar/Player/Player2/lady_back_1.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("Midbar/Player/Player2/lady_front_2.png"));
            down2 =  ImageIO.read(getClass().getResourceAsStream("Midbar/Player/Player2/lady_front_1.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("Midbar/Player/Player2/lady_left_2.png"));
            left2 =  ImageIO.read(getClass().getResourceAsStream("Midbar/Player/Player2/lady_left_1.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("Midbar/Player/Player2/lady_right_2.png"));
            right2 =  ImageIO.read(getClass().getResourceAsStream("Midbar/Player/Player2/lady_right_1.png"));


        }catch(IOException e){
            e.printStackTrace();

        }
    }
    
}
