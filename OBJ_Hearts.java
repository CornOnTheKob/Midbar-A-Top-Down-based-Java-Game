/**
    This is a class that handles the appearance of the heart bar. AS WELL AS THE ITEM OF HEARTS SCATTERED AROUND THE MAP

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

public class OBJ_Hearts extends Object{
    
    GameFrame gp;
    public OBJ_Hearts(GameFrame gp){

        this.gp = gp;

        name = "Hearts";


        try {
            image = ImageIO.read(getClass().getResourceAsStream("Midbar/Objects/Hearts/heart.png"));
            image2 = ImageIO.read(getClass().getResourceAsStream("Midbar/Objects/Hearts/heart2.png"));
            image3 = ImageIO.read(getClass().getResourceAsStream("Midbar/Objects/Hearts/heart3.png"));

           
            image4 = ImageIO.read(getClass().getResourceAsStream("Midbar/Player/Player1/rolf_logo.png"));
            image5 = ImageIO.read(getClass().getResourceAsStream("Midbar/Player/Player2/lady_logo.png"));
           

            
        } catch (IOException e) {
            System.out.println("IOException on OBJ_Hearts");
        }
    }
}
