/**
    This is a class that extends Projectile and is responsible for
    the fireballs.  This is only one of the few projectiles found in the game!

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


import java.io.IOException;
import javax.imageio.ImageIO;

public class OBJ_Fireball extends Projectile { //can access projectile -- projectile can access entity

    GameFrame gp;

    public OBJ_Fireball(GameFrame gp) {
        super(gp);
        this.gp = gp;

        name = "Fire-Ball";
        speed = 12;
        maxLife = 50; //
        life = maxLife;
        attack = 2;
        useCost = 1; //used 1 mana 
        alive = false;

        drawSprites();
    }

    public void drawSprites(){

        try{
            up1 = ImageIO.read(getClass().getResourceAsStream("Midbar/Objects/Projectiles/p2_ud.png")); //up
            up2 = ImageIO.read(getClass().getResourceAsStream("Midbar/Objects/Projectiles/p2_ul.png")); // up-left
            down1 = ImageIO.read(getClass().getResourceAsStream("Midbar/Objects/Projectiles/p2_ud.png")); // down
            down2 = ImageIO.read(getClass().getResourceAsStream("Midbar/Objects/Projectiles/p2_dl.png")); //down -left
            left1 = ImageIO.read(getClass().getResourceAsStream("Midbar/Objects/Projectiles/p2_l.png")); // left
            left2 = ImageIO.read(getClass().getResourceAsStream("Midbar/Objects/Projectiles/p2_dr.png"));  // down-right
            right1 = ImageIO.read(getClass().getResourceAsStream("Midbar/Objects/Projectiles/p2_r.png")); // right
            right2 = ImageIO.read(getClass().getResourceAsStream("Midbar/Objects/Projectiles/p2_ur.png")); // up-right
           
        }catch(IOException e){

        }
       
    }
    
}
