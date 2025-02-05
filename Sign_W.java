/**
    This is a class that handles the sign for the water gemstone.

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

import java.awt.Rectangle;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sign_W extends Creature {


    public Sign_W(GameFrame gp){
        super(gp);
        this.gp = gp;

        solidArea = new Rectangle();

        solidArea.x = -2; 
        solidArea.y = 4;

        //42823
        solidAreaDefaultX = solidArea.x; //recall x and y values
        solidAreaDefaultY = solidArea.y;


        solidArea.height = 55;
        solidArea.width = 50;
        setDialogue();
        getSpriteImage();

    }

    public void getSpriteImage(){
        try{
                      
            up1 =  ImageIO.read(getClass().getResourceAsStream("Midbar/Tiles/042.png"));
            up2 =  ImageIO.read(getClass().getResourceAsStream("Midbar/Tiles/042.png"));
            down1 =  ImageIO.read(getClass().getResourceAsStream("Midbar/Tiles/042.png"));
            down2 =   ImageIO.read(getClass().getResourceAsStream("Midbar/Tiles/042.png"));
            left1 =  ImageIO.read(getClass().getResourceAsStream("Midbar/Tiles/042.png"));
            left2 =   ImageIO.read(getClass().getResourceAsStream("Midbar/Tiles/042.png"));
            right1 =   ImageIO.read(getClass().getResourceAsStream("Midbar/Tiles/042.png"));
            right2 =   ImageIO.read(getClass().getResourceAsStream("Midbar/Tiles/042.png"));

        }catch(IOException e){
            e.printStackTrace();

        }
    }

    public void setDialogue(){

        //The volcano lies craggy against the bright blue sky, like a bomb in wonderland. Beware, for Mt. Sinai has been simmering since the Great Separation. 
        dialogue[0] = "Across the trickling water and from within the \nmist, a hand reaches out beckoning you \ninto the hidden realms.";
        dialogue[1] = "Behold, the watery lands of Siloam and its \nsilver streams, cool and refreshing!";
        dialogue[2] = "It comes from within the belly of a sacred \nmountain, the tears of a slumbering titaness \ndreaming of a love that moves the world.";
        dialogue[3] = "May its waters infused with ancient magic \nflow within you!";

/*
 
Across the trickling water and from within the mist, a hand reaches out, beckoning you into the hidden realms. 
Behold, the watery lands of Siloam and its silver streams, cool and refreshing! 
It comes from within the belly of a sacred mountain, the tears of a slumbering titaness dreaming of a love that moves the world.


 */
    }
    public void show(){

        if(dialogue[dialogueIndex] == null){
            dialogueIndex = 0; //reset the dialogue back to first
            gp.drawDialogue = false;
            gp.DialogueState = false;
            gp.signs[0].dialogueIndex = 0; 
            gp.signs[1].dialogueIndex = 0; 

        }
        
 
        gp.osUI.currentDialogue = dialogue[dialogueIndex];
        dialogueIndex++;



    }
    
}
