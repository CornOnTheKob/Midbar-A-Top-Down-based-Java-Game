/**
    This is a class that contains the main method that will start the
    game from the player's side.

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

 
public class GameStarter {


    public static void main(String[] args) {
        GameFrame gf = new GameFrame(640, 480);
    
        gf.setUpGame(); 
     //   gf.connectToServer();
        gf.setUpGUI();
        gf.setRandomSpawns();
        
    } 

    
}
