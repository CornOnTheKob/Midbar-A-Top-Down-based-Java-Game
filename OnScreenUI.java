/**
    This is a class that handles the UI of the game. This changes depending on which player is holding

    This features four main UI

    > Game UI - with heart sprites / progress bar
    > Start UI - when players log in the game
    > END UI - when players die both
    > Win UI - when players win the game by acquiring the crystal!

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


import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.awt.geom.*;

import javax.imageio.ImageIO;

public class OnScreenUI{
    
    public GameFrame gp;
    public Font verdana_20, verdana_60B;
    public java.awt.image.BufferedImage gemStoneCounter;

    public boolean message = false, message2 = false;
    public String msg = "", msg2 = "";
    public int msgTimer = 0;
    public Graphics2D g2d;

    //MessageDialogue
    public String currentDialogue = "";

    public boolean gameFinishedMe, gameFinishedYou;
    public boolean gameDeadMe, gameDeadYou;
    public boolean gameDeadMeChecker, gameDeadYouChecker;
    public boolean gameStartedMe, gameStartedYou;


    public int endScreenCounter;
    public float alphaValue;
    public int separator;


    public java.awt.image.BufferedImage heartLogo1, heartLogo2, heartFull,heartHalf, heartEmpty, endScreen, startingScreen;
    //LIFE
    
    public Object hearts = new OBJ_Hearts(gp);


    public OnScreenUI(GameFrame gp){

        alphaValue = 0;
        endScreenCounter = 0;
        gameFinishedYou = false;
        gameFinishedMe = false;
        gameStartedYou = true;
        gameStartedMe = true;
        gameDeadMe = false;
        gameDeadYou = false;
        this.gp = gp;
    
        // GEMS
        try {
            gemStoneCounter = ImageIO.read(getClass().getResourceAsStream("Midbar/Objects/Elements/gem.png"));
        }catch(IOException e) {
            e.printStackTrace();
        }

        verdana_20 = new Font("Verdana", Font.PLAIN, 20);
        verdana_60B = new Font("Verdana", Font.BOLD, 60);

        // HEARTS
        Object hearts = new OBJ_Hearts(gp);
        heartFull = hearts.image;
        heartHalf = hearts.image2;
        heartEmpty = hearts.image3;
        separator = 100;

     
      


    }

   
    public void draw(Graphics2D g2d){

        AffineTransform at = g2d.getTransform();
        g2d.setTransform(at);

    

         if((gameFinishedYou == true || gameFinishedMe == true)) {

            gp.shot = false;
            gp.shot2 = false;
            gp.shot3 = false;
            gp.shot4 =  false;
            gp.enemyShot = false;
             gp.enemyShot2 = false;
             gp.enemyShot3 = false;
             gp.enemyShot4= false;
             gp.me.projectile.alive = true;
             gp.MeWaterAbilityChecker = false;
             gp.MeWindAbilityChecker = false;
             gp.MeEarthAbilityChecker = false;
             gp.MeFireAbilityChecker = false;

            endScreenCounter++;


            Rectangle2D.Double blank = new Rectangle2D.Double(0,0,gp.screenWidth, gp.screenHeight);
            g2d.fill(blank);

            if(endScreenCounter > 100 && endScreenCounter < 200){
                alphaValue = 0.1f;

            }
            else if(endScreenCounter > 200 && endScreenCounter < 300){

                alphaValue = 0.2f;


            }
            else if(endScreenCounter > 300 && endScreenCounter < 400){
                alphaValue = 0.3f;

            }
            else if(endScreenCounter > 400 && endScreenCounter < 500){
                alphaValue = 0.4f;

            }
            else if(endScreenCounter > 500 && endScreenCounter < 700){
                alphaValue = 0.5f;

            }
            else if(endScreenCounter > 700 && endScreenCounter < 800){
                alphaValue = 0.6f;

            }
            else if(endScreenCounter > 800 && endScreenCounter < 900){
                alphaValue = 0.7f;
               

            }
            else if(endScreenCounter > 900 && endScreenCounter < 1000){
                alphaValue = 0.8f;

            }
            else if(endScreenCounter > 1000 && endScreenCounter < 1100){
                alphaValue = 0.9f;

            }
            else if(endScreenCounter > 1100){
                alphaValue = 1f;


            }
            else if(endScreenCounter > 2000){
                gp.stopMusic();
            }
            try{
                endScreen =  ImageIO.read(getClass().getResourceAsStream("Midbar/Objects/WinScreen/end.png"));
                
            }catch(IOException e){

            }

                 
       
              g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alphaValue));
            
             g2d.drawImage(endScreen, 0,0,(int) gp.screenWidth, (int) gp.screenHeight, null);
             g2d.setTransform(at);

//            g2d.drawImage(sprite, (int) screenX, (int) screenY, gp.tileSize, gp.tileSize, null);

                
           // System.out.println("www");

            /*
            String text;
            int textLength;
            int x;
            int y; 

            g2d.setFont(verdana_20);
            g2d.setColor(Color.white);
            text = "You found the crystal!";
            textLength = (int)g2d.getFontMetrics().getStringBounds(text, g2d).getWidth();
            x = gp.screenWidth/2 - textLength/2;
            y = gp.screenHeight/2 - (gp.tileSize*3);
            g2d.drawString(text, x, y);

            g2d.setFont(verdana_60B);
            g2d.setColor(new Color(161,62,151,255));
            text = "Congratulations!";
            textLength = (int)g2d.getFontMetrics().getStringBounds(text, g2d).getWidth();
            x = gp.screenWidth/2 - textLength/2;
            y = gp.screenHeight/2 + (gp.tileSize*2);
            g2d.drawString(text, x, y);

            gp.gameThread = null;

             */


             g2d.setTransform(at);


        }else if(gameDeadYou == true || gameDeadMe == true){

          

             gp.shot = false;
             gp.shot2 = false;
             gp.shot3 = false;
             gp.shot4 =  false;
             gp.enemyShot = false;
              gp.enemyShot2 = false;
              gp.enemyShot3 = false;
              gp.enemyShot4= false;
              gp.me.projectile.alive = true;
              gp.MeWaterAbilityChecker = false;
              gp.MeWindAbilityChecker = false;
              gp.MeEarthAbilityChecker = false;
              gp.MeFireAbilityChecker = false;
             endScreenCounter++;


            Rectangle2D.Double blank = new Rectangle2D.Double(0,0,gp.screenWidth, gp.screenHeight);
            g2d.fill(blank);
            if(endScreenCounter > 100 && endScreenCounter < 199){
                alphaValue = 0.1f;

            }
            else if(endScreenCounter == 200){
                gp.playSFX(13);
            }
            else if(endScreenCounter > 200 && endScreenCounter < 300){
                

                alphaValue = 0.2f;


            }
            else if(endScreenCounter > 300 && endScreenCounter < 400){
                alphaValue = 0.3f;

            }
            else if(endScreenCounter > 400 && endScreenCounter < 500){
                alphaValue = 0.4f;

            }
            else if(endScreenCounter > 500 && endScreenCounter < 700){
                alphaValue = 0.5f;

            }
            else if(endScreenCounter > 700 && endScreenCounter < 800){
                alphaValue = 0.6f;

            }
            else if(endScreenCounter > 800 && endScreenCounter < 900){
                alphaValue = 0.7f;

            }
            else if(endScreenCounter > 900 && endScreenCounter < 1000){
                alphaValue = 0.8f;

            }
            else if(endScreenCounter > 1000 && endScreenCounter < 1100){
                alphaValue = 0.9f;

            }
            else if(endScreenCounter > 1100){
                alphaValue = 1f;
                

            }
            else if(endScreenCounter > 2000){
                gp.stopMusic();
            }
            try{
                endScreen =  ImageIO.read(getClass().getResourceAsStream("Midbar/Objects/WinScreen/endScreen.png"));
                
            }catch(IOException e){

            }

                 
       
              g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alphaValue));
            
             g2d.drawImage(endScreen, 0,0,(int) gp.screenWidth, (int) gp.screenHeight, null);
             g2d.setTransform(at);





        }
        else{

            this.g2d = g2d;

            if(gp.playerID == 1){
                heartLogo1 = hearts.image4; 
                heartLogo2 = hearts.image5;
                drawPlayerLife();

            }else{
                heartLogo2 = hearts.image4; 
                heartLogo1 = hearts.image5;
                drawPlayerLife();

            }
            
            // GEM BAR
            int oneScale = 60;
            int barValue = oneScale * gp.stoneCount;

            g2d.setFont(verdana_20);
            g2d.setColor(Color.white);
            g2d.drawString("Progress Meter", gp.tileSize/2 - 1, gp.tileSize/2 + 5);

            g2d.fillRect(gp.tileSize/2 - 1, gp.tileSize/2 - 1 + gp.tileSize/4, 242, gp.tileSize/2 + 2);

            g2d.setColor(new Color(192,192,192));
            g2d.fillRect(gp.tileSize/2, gp.tileSize/2 + gp.tileSize/4, 240, gp.tileSize/2);

            g2d.setColor(new Color(232,236,238,255));
            g2d.fillRect(gp.tileSize/2, gp.tileSize/2 + gp.tileSize/4, barValue, gp.tileSize/2);

            g2d.drawImage(gemStoneCounter, 265, gp.tileSize/2, gp.tileSize, gp.tileSize, null);
         
            g2d.setFont(new Font(Font.MONOSPACED, Font.BOLD, 14));
            g2d.setColor(Color.decode("#3d251e"));
            if(message == true){

                int separate = 100;
                for(String line: msg.split("\n")){ //get all dialogue and split all \n then we increase y so that the next line is below
                    g2d.drawString(line, 50, separate);
                    separate += 25;
        
                }
               // g2d.drawString(msg, 74, 100); //display message then poof it will be gone

                msgTimer++; 
                if(msgTimer > 2000){
                    msgTimer = 0;
                    message = false;
                }

                 
            }

            if(message2 == true){

                g2d.setColor(Color.MAGENTA);

                int separate = 175;
                for(String line: msg2.split("\n")){ //get all dialogue and split all \n then we increase y so that the next line is below
                    g2d.drawString(line, 50, separate);
                    separate += 25;
        
                }
               // g2d.drawString(msg, 74, 100); //display message then poof it will be gone

                msgTimer++; 
                if(msgTimer > 2000){
                    msgTimer = 0;
                    message2 = false;
                }

                 
            }

        }

    
        if(gameStartedMe == true || gameStartedYou == true){

            try{
                startingScreen =  ImageIO.read(getClass().getResourceAsStream("Midbar/Objects/WinScreen/startScreen.png"));
                
            }catch(IOException e){

            }

                 
       
             // g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alphaValue));
            
             g2d.drawImage(startingScreen, 0,0,(int) gp.screenWidth, (int) gp.screenHeight, null);
             g2d.setTransform(at);

        }
    
        
    }


    public void displayMessage(String text){
        message = true;
        msg = text;
    }

    public void displayMessage2(String text){
        message2 = true;
        msg2 = text;
    }

    public void drawPlayerLife(){


       int t = gp.screenWidth - (gp.tileSize *8) + 35;
       int u = (gp.tileSize / 2) - 20;
       int o = 0;

        g2d.drawImage(heartLogo1, t,u, 75,75, null);

         t = gp.screenWidth - (gp.tileSize *8) + 35;
         u = (gp.tileSize / 2) + 35;
         o = 0;
 
         g2d.drawImage(heartLogo2, t,u, 75,75, null);


        int x = gp.screenWidth - (gp.tileSize*6);
        int y= gp.tileSize / 2;
        int i = 0;

        //Draw Max [player 1]
        while(i < gp.me.maxLife/2){
            g2d.drawImage(heartEmpty,x,y,43,43,null);
            i++;
            x += gp.tileSize;
        }
        //reset
        x = gp.screenWidth - (gp.tileSize*6);
        y= gp.tileSize / 2;
        i = 0;

        //Draw Current [player 1]

        while(i < gp.me.life){ //if hindi puno pa half then if less than pa rin, full na then next heart...
            g2d.drawImage(heartHalf,x,y,43,43,null);
            i++;
            if(i < gp.me.life){
                g2d.drawImage(heartFull,x,y,43,43,null);
                
            }
            i++;
            x += gp.tileSize;

        }


        int a = gp.screenWidth - (gp.tileSize*6);
        int b = (gp.tileSize / 2) + gp.tileSize;
        int c = 0;

         //Draw Max [player 2]
         while(c < gp.enemy[0].maxLife/2){
            g2d.drawImage(heartEmpty,a,b,43,43,null);
            c++;
            a += gp.tileSize;
        }

        //reset
         a = gp.screenWidth - (gp.tileSize*6);
         b = (gp.tileSize / 2) + gp.tileSize;
         c = 0;


         //Draw Current [player 1]

         while(c < gp.enemy[0].life){ //if hindi puno pa half then if less than pa rin, full na then next heart...
            g2d.drawImage(heartHalf,a,b,43,43,null);
            c++;
            if(c < gp.enemy[0].life){
                g2d.drawImage(heartFull,a,b,43,43,null);
   
            }
            c++;
            a += gp.tileSize;

        }



    }




    public void drawDialogueBox(Graphics2D g2d){ //draw Dialogue Screen FOR THE SIGNS

        //windowrectangle
        
        int x = gp.tileSize * 1;
        int y = gp.screenHeight - (gp.tileSize*4) + 20;
        int height = gp.tileSize * 3;
        int width = gp.screenWidth - (gp.tileSize*2); 

        drawMessageBox(g2d, x, y, width, height);


        //where dialgoue message will be printed

       
        g2d.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 22));
        x += gp.tileSize;
        y += gp.tileSize;

        for(String line: currentDialogue.split("\n")){ //get all dialogue and split all \n then we increase y so that the next line is below
            g2d.drawString(line,x,y);
            y += 25;

        }


    }

    public void drawMessageBox(Graphics2D g2de, int x, int y, int width, int height){ //pass everything to this method

        java.awt.image.BufferedImage image_arrow  = null;

        try {
            image_arrow = ImageIO.read(getClass().getResourceAsStream("Midbar/Objects/Elements/gem_a_1.png"));
            
            
        } catch (IOException e) {
            System.out.println("IOException on Object_Element_Air");
        }

    Color c = new Color(255, 255, 255, 220); //transparency ung pang appat ALPHA VALUE
    g2de.setColor(c);
    g2de.fillRoundRect(x, y, width, height, 30, 30);

    c =  new Color(0,0,0);
    g2de.setColor(c);
    g2de.setStroke(new BasicStroke(4));
    g2de.drawRoundRect(x+5, y+5, width-10, height-10, 25, 25);

    g2de.setColor(Color.BLACK);

    g2d.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 21));
    g2de.drawString(">", x+620, y+120);

    //g2de.drawImage(image_arrow, x+20, y+20, gp.tileSize, gp.tileSize, null);


       //            g2d.drawImage(sprite, (int) screenX, (int) screenY, gp.tileSize, gp.tileSize, null);



    }

    public void drawDialogueBox2(Graphics2D g2d){ //draw for the signs of magicrect event thingy

        //windowrectangle

        int x = gp.tileSize * 1;
        int y = gp.screenHeight - (gp.tileSize*4) + 20;
        int height = gp.tileSize * 3;
        int width = gp.screenWidth - (gp.tileSize*2); 

        drawMessageBox2(g2d, x, y, width, height);


        //where dialgoue message will be printed

       
        g2d.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 22));
        x += gp.tileSize;
        y += gp.tileSize;

        for(String line: currentDialogue.split("\n")){ //get all dialogue and split all \n then we increase y so that the next line is below
            g2d.drawString(line,x,y);
            y += 40;

        }


    }

    public void drawMessageBox2(Graphics2D g2de, int x, int y, int width, int height){ //pass everything to this method

        java.awt.image.BufferedImage image_arrow  = null;

        try {
            image_arrow = ImageIO.read(getClass().getResourceAsStream("Midbar/Objects/Elements/gem_a_1.png"));
            
            
        } catch (IOException e) {
            System.out.println("IOException on Object_Element_Air");
        }

    Color c = new Color(255, 255, 255, 220); //transparency ung pang appat ALPHA VALUE
    g2de.setColor(c);
    g2de.fillRoundRect(x, y, width, height, 30, 30);

    c =  new Color(0,0,0);
    g2de.setColor(c);
    g2de.setStroke(new BasicStroke(4));
    g2de.drawRoundRect(x+5, y+5, width-10, height-10, 25, 25);

    g2de.setColor(Color.BLACK);

    g2d.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 21));
    g2de.drawString(">", x+620, y+120);

    //g2de.drawImage(image_arrow, x+20, y+20, gp.tileSize, gp.tileSize, null);


       //            g2d.drawImage(sprite, (int) screenX, (int) screenY, gp.tileSize, gp.tileSize, null);

    }
    

}
