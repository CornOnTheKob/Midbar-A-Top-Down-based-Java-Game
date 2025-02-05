/**
    This is a class that extends JComponent and overrides the
    paintComponent method in order to create the custom drawing.

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

The GameCanvas specializes in drawing all the mobs,gems, signs, and items found in midbar
        

*/

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JComponent;

public class GameCanvas extends JComponent {
    

    
    public DrawingComponent dc;

    public GameFrame pf;
    public GameCanvas(GameFrame pf){

        this.pf = pf;
        dc = new DrawingComponent();
    }

    class DrawingComponent extends JComponent{
        protected void paintComponent(Graphics g){


           


            Graphics2D g2d = (Graphics2D) g;

 //Rendering hints - anti_aliasing
 RenderingHints rh = new RenderingHints(
    RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON
    );
    g2d.setRenderingHints(rh); 
    //Map Draw
            pf.tm.draw(g2d);


            //Player DRaw
            pf.me.drawSprite(g2d); //Draw Sprite from playerSprite


            //Object Draw
            for(int i = 0; i< pf.obj.length; i++){
                if(pf.obj[i] != null){
                    repaint();

                    if(pf.obj[i].itemEquip == false){
                        pf.obj[i].draw(g2d, pf);
                        repaint();
                    }
                    else{


                        pf.obj[i].worldX = 1500;
                       
                     
                        
                    }
                   
                }
            }

            //element stone draw
            for(int i = 0; i< pf.stone.length; i++){
                if(pf.stone[i] != null){ // if not null
                    repaint();

                    if(pf.stone[i].stoneEquip == false){ //if not equipped

                    
                        if(i < 5){
                            pf.stone[i].drawStones(g2d, pf);
                        }
                        else if(pf.completeStoneDrawer == true){

                            /*
                               pf.stone[4].worldX = 85 * pf.tileSize;
                            pf.stone[4].worldY = 71 * pf.tileSize;

                            FAKE
                             pf.stone[4].worldX = 12 * pf.tileSize;
                            pf.stone[4].worldY = 22 * pf.tileSize;
                            pf.stone[4].drawStones(g2d, pf);
                             */

                             pf.stone[4].worldX = 85 * pf.tileSize;
                             pf.stone[4].worldY = 71 * pf.tileSize;
                            pf.stone[4].drawStones(g2d, pf);
                        }
                        
                        if(pf.completeStoneDrawer == true){
                            pf.stone[4].worldX = 85 * pf.tileSize;
                            pf.stone[4].worldY = 71 * pf.tileSize;
                            pf.stone[4].drawStones(g2d, pf);
                        }

                    }
                    repaint();
                }
            }

            //mobs
            for(int i = 0; i < pf.mob.length; i++){

                if(pf.mob[i] != null){
                  if(pf.mob[i].isMobDead == false){
              
                    repaint();
                    pf.mob[i].drawMob(g2d);
               
              
                     }
                     else if(pf.mob[i].isMobDead == true){
                        
                        pf.mob[i].worldY = 0;
                       

                     }


                     
            repaint();
             
            }
        }

        for(int i = 0; i < pf.giantMob.length; i++){

            if(pf.giantMob[i] != null){
              if(pf.giantMob[i].isMobDead == false){
          
                repaint();
                pf.giantMob[i].drawGiantMob(g2d);
           
          
                 }
                 else if(pf.giantMob[i].isMobDead == true){
                    
                    pf.giantMob[i].worldY = 0;
                   

                 }


                 
        repaint();
         
        }
    }
            //signs
            for(int i = 0 ; i < pf.signs.length; i++){
                if(pf.signs[i] != null){
                    repaint();
                    pf.signs[i].drawSigns(g2d);
                    repaint();
                }
            }

           // enemy.drawSprite(g2d);
           for(int i = 0; i< pf.enemy.length; i++){
            if(pf.enemy[i] != null){
                repaint();
                pf.enemy[i].drawEnemy(g2d);
                repaint();
            }


        }

        //projectile
        for(int i = 0; i < pf.projectileList.size(); i++){

            pf.projectileList.get(i).drawProjectile(g2d); //im so good 
        }

        for(int i = 0; i < pf.projectileList2.size(); i++){

            pf.projectileList2.get(i).drawProjectile(g2d); //im so good 
        }

        //projectile 2

        for(int i = 0; i < pf.projectileList2_1.size(); i++){

            pf.projectileList2_1.get(i).drawProjectile2(g2d); //im so good 
        }

        for(int i = 0; i < pf.projectileList2_2.size(); i++){

            pf.projectileList2_2.get(i).drawProjectile2(g2d); //im so good 
        }

        //projectile 3

        for(int i = 0; i < pf.projectileList3_1.size(); i++){

            pf.projectileList3_1.get(i).drawProjectile3(g2d); //im so good 
        }

        for(int i = 0; i < pf.projectileList3_2.size(); i++){

            pf.projectileList3_2.get(i).drawProjectile3(g2d); //im so good 
        }


        //projectile 4

        for(int i = 0; i < pf.projectileList4_1.size(); i++){

            pf.projectileList4_1.get(i).drawProjectile4(g2d); //im so good 
        }

        for(int i = 0; i < pf.projectileList4_2.size(); i++){

            pf.projectileList4_2.get(i).drawProjectile4(g2d); //im so good 
        }

        for(int i = 0; i < pf.projectileListMob.size(); i++){

            pf.projectileListMob.get(i).drawProjectileMob(g2d); //im so good 
        }

       
            
        pf.osUI.draw(g2d);

        if(pf.drawDialogue == true){
          
            pf.osUI.drawDialogueBox(g2d);
          
        }

        if(pf.drawMagicDialogue == true){
            pf.osUI.drawDialogueBox2(g2d);
        }
        g2d.dispose();
            //EnemySprite.draw(g2d);

        
    }

    }



}
