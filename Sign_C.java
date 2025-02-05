/**
    This is a class that handles the sign for the final crystal.

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

public class Sign_C extends Creature {


    public Sign_C(GameFrame gp){
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
                      
            up1 =  ImageIO.read(getClass().getResourceAsStream("Midbar/Tiles/043.png"));
            up2 =   ImageIO.read(getClass().getResourceAsStream("Midbar/Tiles/043.png"));
            down1 =   ImageIO.read(getClass().getResourceAsStream("Midbar/Tiles/043.png"));
            down2 =   ImageIO.read(getClass().getResourceAsStream("Midbar/Tiles/043.png"));
            left1 =  ImageIO.read(getClass().getResourceAsStream("Midbar/Tiles/043.png"));
            left2 =   ImageIO.read(getClass().getResourceAsStream("Midbar/Tiles/043.png"));
            right1 =   ImageIO.read(getClass().getResourceAsStream("Midbar/Tiles/043.png"));
            right2 =   ImageIO.read(getClass().getResourceAsStream("Midbar/Tiles/043.png"));

        }catch(IOException e){
            e.printStackTrace();

        }
    }

    public void setDialogue(){

        //The volcano lies craggy against the bright blue sky, like a bomb in wonderland. Beware, for Mt. Sinai has been simmering since the Great Separation. 
        dialogue[0] = "There was once an ancient legend about Midbar \nand the Enchanted Forests.";
        dialogue[1] = "Back before the Great War has unleashed its \nchaos onto this land, Midbar was a citadel \nof magic.";
        dialogue[2] = "In the heart of this once prominent realm, \nthe Crystal of Adonai resided.";
        dialogue[3] = "The crystal was said to possess limitless \nenergy, supplying all who lived there \nwith resources beyond their imaginations.";
        dialogue[4] = "But the era of peace came to an end when the \nZinians massacred the valley and separated \nthe crystal to four gemstones.";
        dialogue[5] = "It is believed that whoever can gather all \ngemstones shall be granted one irrevocable \nwish and restore peace once more.";
        dialogue[6] = "Sadly, these are all but tales of the old.";




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
