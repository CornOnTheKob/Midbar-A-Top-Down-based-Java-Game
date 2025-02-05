/**
    This is a class that handles the sign for the air gemstone.

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

public class Sign_A extends Creature {


    public Sign_A(GameFrame gp){
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

        dialogue[0] = "A pastel of the breeze sketches the old \nkingdom of Tof, once blessed by the gods";
        dialogue[1] = "Its people used to thrive in mini cities \natop the branches of tall forest trees that \npractically brush the clouds....";
        dialogue[2] = "Sending down messages and songs of wisdom \nacross the land...";
        dialogue[3] = "Bottling jars of knowledge and new ideas \nin the form of whispers in the wind.!";

        /*
        
        
        A pastel of the breeze sketches the old kingdom of Tof, once blessed by the gods. 
        Its people used to thrive in mini cities atop the branches of tall forest trees that practically brush the clouds, 
        sending down messages and songs of wisdom across the land, bottling jars of knowledge and new ideas in the form of whispers in the wind.

        
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
