/**
    This is a class that handles the sign for the earth gemstone.

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

public class Sign_E extends Creature {


    public Sign_E(GameFrame gp){
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
                      
            up1 =  ImageIO.read(getClass().getResourceAsStream("Midbar/Tiles/040.png"));
            up2 =  ImageIO.read(getClass().getResourceAsStream("Midbar/Tiles/040.png"));
            down1 =  ImageIO.read(getClass().getResourceAsStream("Midbar/Tiles/040.png"));
            down2 =   ImageIO.read(getClass().getResourceAsStream("Midbar/Tiles/040.png"));
            left1 =  ImageIO.read(getClass().getResourceAsStream("Midbar/Tiles/040.png"));
            left2 =   ImageIO.read(getClass().getResourceAsStream("Midbar/Tiles/040.png"));
            right1 =   ImageIO.read(getClass().getResourceAsStream("Midbar/Tiles/040.png"));
            right2 =   ImageIO.read(getClass().getResourceAsStream("Midbar/Tiles/040.png"));

        }catch(IOException e){
            e.printStackTrace();

        }
    }

    public void setDialogue(){

        dialogue[0] = "From dust it came, and to dust it shall \nreturn.";
        dialogue[1] = "Midian was once a paradise of lush gardens \nbedecked by lazy butterflies and flowers \nthat tempted you to rest your weary head.";
        dialogue[2] = "But after the Great Calamity when the sky \nrained rocks and ash the city was laid \nto ruin.";
        dialogue[3] = "Now it holds the mysteries of the desert \nbeyond, where apparently the dead walks!";


 //        //*From dust it came, and to dust it shall return. Midian was once a paradise of lush gardens bedecked by lazy butterflies and flowers that tempted you to rest your weary head. 
 //But after the Great Calamity when the sky rained rocks and ash, the city was laid to ruin. Now it holds the mysteries of the desert beyond, where apparently the dead walks!

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
