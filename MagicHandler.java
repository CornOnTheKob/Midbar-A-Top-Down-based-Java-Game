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


    This is a class that handles the healing pool ability found in the game where if a player steps near a open body of water, they will heal


*/


import java.awt.Rectangle;

public class MagicHandler {

    public GameFrame gp;
    public Rectangle magicRect;
    public int magicDefaultX, magicDefaultY;

    public MagicHandler(GameFrame gp){

         this.gp = gp;

         magicRect = new Rectangle(); //send it to center of a tile
         magicRect.x = 23;
         magicRect.y = 23;
         magicRect.width = 2;
         magicRect.height = 2;
         magicDefaultX =  magicRect.x;
         magicDefaultY = magicRect.y;


    }

    public void checkMagic(){

        // sample 12 x y 22

        if(hit(11, 21,"up") == true){ 
       
            gp.me.speed = 0;
            gp.playerSpeed= 0;
            damagePit();
            gp.me.setY(gp.me.getY()+1);
            
        }


        if(hit(4, 21,"up") == true || hit(134,57,"up") == true || hit(135,57,"up")== true || hit(30,45,"up")==true|| hit(31,45,"up")==true || hit(32,45,"up")==true){
       
            gp.me.speed = 0;
            gp.playerSpeed= 0;
            healingPool();
            gp.me.setY(gp.me.getY()+1);
            
        }

        if(hit(63, 73,"left") == true || hit(63, 74,"left") == true){
       
            gp.me.speed = 0;
            gp.playerSpeed= 0;
            healingPool();
            gp.me.setX(gp.me.getX()+1);
            
        }
        if(hit(75, 44,"left") == true || hit(75, 45,"left") == true){
       
            gp.me.speed = 0;
            gp.playerSpeed= 0;
            healingPool();
            gp.me.setX(gp.me.getX()+1);
            
        }

        if(hit(91, 136,"down") == true || hit(97, 152,"down") == true ||hit(96, 152,"down") == true || hit(98, 152,"down") == true|| hit(185,123,"down") == true|| hit(186,123,"down")==true){
       
            gp.me.speed = 0;
            gp.playerSpeed= 0;
            healingPool();
            gp.me.setY(gp.me.getY()-1);
            
        }

        if(hit(214, 117,"right") == true || hit(214, 118,"right") == true){
       
            gp.me.speed = 0;
            gp.playerSpeed= 0;
            healingPool();
            gp.me.setY(gp.me.getY()-1);
            
        }


    }
    public boolean hit(int magicCol, int magicRow, String reqDirection){ //collision

        boolean hit = false;

        gp.me.solidArea.x = (int)gp.me.worldX + gp.me.solidArea.x; //getting player's solid area position
        gp.me.solidArea.y = (int)gp.me.worldY + gp.me.solidArea.y;
        magicRect.x = (magicCol*gp.tileSize) + magicRect.x;
        magicRect.y = (magicRow*gp.tileSize) + magicRect.y;


        if(gp.me.solidArea.intersects(magicRect)){
            if(gp.me.direction.equals(reqDirection) ){ //if collision is true, we check player direction as well so we can create events when a player is looking at specific diection
            
                   
                    hit = true;
                
               
            }
        }

        gp.me.solidArea.x = gp.me.solidAreaDefaultX;
        gp.me.solidArea.y = gp.me.solidAreaDefaultY;
        magicRect.x  = magicDefaultX;
        magicRect.y = magicDefaultY;


        return hit;

    } 
    
    //sample
    public void damagePit(){

      
        gp.drawMagicDialogue = true;
        gp.DialogueMagicState = true;
        gp.osUI.currentDialogue = "Ouch. A mysterious force has damaged you. \nBe more careful next time.";
        gp.me.life -=  1;
        gp.playSFX(7);


    }

    public void healingPool(){

        gp.playSFX(8);
        gp.drawMagicDialogue = true;
        gp.DialogueMagicState = true;
        gp.osUI.currentDialogue = "Refreshing! It seems that the water from the \nriver Jordan has quenched your health!";
        gp.me.life =  gp.me.maxLife; 
       


    }

    
}
