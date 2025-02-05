/**
    

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

    *This is one of the four giant mobs that you will see in the Game. Like the other three, this one IS A MAMMOTH in size compared
    to normal mobs in the game. Also, this one shoots projectiles! One for every biome. 

*/


import java.awt.Rectangle;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Giant_Mob_E extends Creature {
    
    public Random r;

    public Giant_Mob_E(GameFrame gp, long seede){
        super(gp);
        direction = "down";
        speed = 4;
        type = 3;

        name = "Earth-A";

        solidArea = new Rectangle();
        solidArea.x = 20; 
        solidArea.y = 36;

        maxLife = 20;
        life = maxLife;

        //42823
        solidAreaDefaultX = solidArea.x; //recall x and y values
        solidAreaDefaultY = solidArea.y;

        //projectile
        projectile = new OBJ_Mobball(gp);

       solidArea.height = 100;
        solidArea.width = 100;

        getSpriteImage();
        r  = new Random(seede);
    }

// //7 and 29 

    public void getSpriteImage(){
        try{
            
            up1 = ImageIO.read(getClass().getResourceAsStream("Midbar/Objects/Mobs/GiantMob1/u1.png"));
            up2 =  ImageIO.read(getClass().getResourceAsStream("Midbar/Objects/Mobs/GiantMob1/u2.png"));
            down1 =  ImageIO.read(getClass().getResourceAsStream("Midbar/Objects/Mobs/GiantMob1/d1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("Midbar/Objects/Mobs/GiantMob1/d2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("Midbar/Objects/Mobs/GiantMob1/l1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("Midbar/Objects/Mobs/GiantMob1/l2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("Midbar/Objects/Mobs/GiantMob1/r1.png"));
            right2 =  ImageIO.read(getClass().getResourceAsStream("Midbar/Objects/Mobs/GiantMob1/r2.png"));


        }catch(IOException e){
            e.printStackTrace();

        }
    }


    public void setActionMob(){

        actionMove++; //for fixing random actions

        int i = r.nextInt(100)+1; //0-99 --> 1-100

        if(actionMove == 70){
             
            if(i <= 25){
                direction = "up";
            }
            else if( i <= 50 ){
                direction = "down";
            }
            else if(i <= 75){
                direction = "left";
            }
            else if(i <= 100){
                direction = "right";
            }
    

        actionMove = 0;

        

    }

    int a = r.nextInt(100)+1;
    if(a > 92 && projectile.alive == false){

        projectile.set(worldX+50,worldY+50,direction,true,this);
        gp.projectileListMob.add(projectile);
        

    }
    }


    //for all mobs
    public void setX(int i, int n){
        gp.mob[i].worldX = n; 
    }
    public double getX(int i){
        return gp.mob[i].worldX;

    }

    public void moveV(double n){
        worldY += n;
    }

    public void moveH(double n){ //Used that can Replace values of x and y completely...
        worldX = n;
    }
    public void setY(double n){
        worldY = n;
    }

   

    public double getY(){
        return worldY;
        
    }
    public String getDirection(){ //set direction
        return direction;

    }

    public void setDirection(String d){
        direction = d;
    }

}
