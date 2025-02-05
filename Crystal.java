/**
    This is a class that handles the final crystal.

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
import java.io.IOException;

public class Crystal extends Object{
    
    public Crystal(){

        name = "Crystal-C";


        try {
            image = ImageIO.read(getClass().getResourceAsStream("Midbar/Objects/Elements/gem_1.png"));
            
        } catch (IOException e) {
            System.out.println("IOException on Object_Element_Crystal");
        }
    }
   

}
