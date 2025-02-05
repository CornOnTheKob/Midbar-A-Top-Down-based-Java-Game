/**
    This is a class that handles the Gemstone of Fire.

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


import javax.imageio.*;

import java.awt.image.BufferedImage;
import java.io.IOException;


public class FireStone extends Object  {

    public BufferedImage f1,f2,f3;
  
    
    public FireStone(){

      
      
        name = "Element-F";
        
       
        drawSprites();


        try {
            
                image = ImageIO.read(getClass().getResourceAsStream("Midbar/Objects/Elements/gem_f_1.png"));

            

               
    
        } catch (IOException e) {
            System.out.println("IOException on Object_Element_Fire");
        }


      
       

    }

    public void drawSprites(){

        try{
            f1 = ImageIO.read(getClass().getResourceAsStream("Midbar/Objects/Elements/gem_f_1.png"));
            f2 = ImageIO.read(getClass().getResourceAsStream("Midbar/Objects/Elements/gem_f_2.png"));
            f3 = ImageIO.read(getClass().getResourceAsStream("Midbar/Objects/Elements/gem_f_3.png"));
        }catch(IOException e){

        }
       
    }

   
  
    
}
