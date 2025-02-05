/**
    This is a class that handles the projectiles in the game.


    There are different methods for different projectiles so that every projectile is special

    > update() - first projectile normal
    > update2() - second projectile shoots 1 boomeang per direction
    > update3() - third projectile throws 1 big boulder
    > update4() - foruth projectile casts a bubble that if stepped by a mob it will die
    > update5() - projectile for mob normla

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

public class Projectile extends Creature {

    private int x;
    Creature user;

    public Projectile(GameFrame gp) {
        super(gp);

    }

    public void set(double worldX, double worldY, String direction, boolean alive, Creature user) {

        // pass its coordinates, direction, alive status, if player uses projectile

        this.worldX = worldX;
        this.worldY = worldY;
        this.direction = direction;
        this.alive = alive;
        this.user = user;
        this.life = this.maxLife; // reset life
        size = 20;
        x = 0;

    }


    public void update5(){

        switch (direction) {
            case "up":
                worldY -= speed;
                size += 1;
                break;
            case "down":
                worldY += speed;
                size += 1;
                break;
            case "left":
                worldX -= speed;
                size += 1;
                break;
            case "right":
                worldX += speed;
                size += 1;
                break;

        }

        int projectileIndex = gp.cc.checkProjectile3(this, gp.me, true);

        if (projectileIndex != 777) {
            gp.playSFX(7);
            System.out.println("interacted");
            alive = false;
            gp.me.life -= 1;
        }

        life--;
        if (life <= 0) {
            alive = false; // once shoot, it will gradually lose its life, if it hits 0, the projectile
                           // disappears after 80 frames it disappears

        }

        spriteCounter++;

        if (spriteCounter > 12) {
            if (spriteNum == 1) {
                spriteNum = 2;
            } else if (spriteNum == 2) {
                spriteNum = 1;
            }
            spriteCounter = 0;
        }


    }
    public void update4(){

        
          // just like PLAYERS PROJECTILES IS BASED ON DIRECTION

        // System.out.println("Projectile X:" + gp.projectileList.get(0).worldX);
//checkMobToShield
   


        switch (direction) {
            case "up":

            if(x <=50){
                x += 5;
                worldY -= 8;
                size += 1;
            }
            else{
                size += 1;
            }
                break;
            case "down":
            if(x <=50){
                x += 5;
                worldY += 8;
                size += 1;
            }
            else{
                size += 1;
            }
                break;
            case "left":
               
                if(x <=50){
                    x += 5;
                    worldX -= 8;
                    size += 1;
                }
                else{
                    size += 1;
                }
                
                
                break;
            case "right":
            if(x <=50){
                x += 5;
                worldX += 8;
                size += 1;
            }
            else{
                size += 1;
            }
            
                break;

        }

        life--;
        if (life <= 0) {
            alive = false; // once shoot, it will gradually lose its life, if it hits 0, the projectile
                           // disappears after 80 frames it disappears

        }

        spriteCounter++;

        if (spriteCounter > 12) {
            if (spriteNum == 1) {
                spriteNum = 2;
            } else if (spriteNum == 2) {
                spriteNum = 1;
            }
            spriteCounter = 0;
        }

        int projectileIndex = gp.cc.checkMobToShield(this, gp.mob, true);
        if (projectileIndex != 777) {
           
            gp.mob[projectileIndex].life -= 5;
            alive = false;
           
           
        }
        


    }
    public void update3() {

        if (user != gp.me) {

        }
        life = (int) (life - 0.75);
        switch (direction) {
            case "up":

                worldX = 0;
                worldY = 0;
                break;
            case "down":
                worldX = 0;
                worldY = 0;
                break;
            case "left":

                if (life > 23) {
                    worldY -= 10;
                    worldX -= 6;

                } else {
                    worldY += 4;

                    if (life <= 100) {

                        int projectileIndex = gp.cc.checkProjectile(this, gp.mob, true);

                        if (projectileIndex != 777) {
                            gp.playSFX(7);
                            System.out.println("interacted");
                            alive = false;
                            gp.mob[projectileIndex].life -= 4;
                        }

                        int projectileIndex2 = gp.cc.checkProjectile2(this, gp.giantMob, true);

                        if (projectileIndex2 != 777) {
                            gp.playSFX(7);
                            System.out.println("interacted2");
                            alive = false;
                            gp.giantMob[projectileIndex2].life -= 4;
                
                        }
                           
                       


                    }

                }

                worldX -= 4;
                break;
            case "right":

                if (life > 23) {
                    worldY -= 10;
                    worldX += 6;

                } else {
                    worldY += 4;
                    if (life < 20) {

                        int projectileIndex = gp.cc.checkProjectile(this, gp.mob, true);
                        if (projectileIndex != 777) {
                            gp.playSFX(7);
                            System.out.println("interacted");
                            alive = false;
                            gp.mob[projectileIndex].life -= 4;
                        }

                        int projectileIndex2 = gp.cc.checkProjectile2(this, gp.giantMob, true);

                        if (projectileIndex2 != 777) {
                            gp.playSFX(7);
                            System.out.println("interacted");
                            alive = false;
                            gp.giantMob[projectileIndex2].life -= 4;
                
                        }
                           
                      
                    }

                }
                worldX += 4;

                break;

        }

        if (life <= 0) {
            alive = false; // once shoot, it will gradually lose its life, if it hits 0, the projectile
                           // disappears after 80 frames it disappears

        }

        spriteCounter++;

        if (spriteCounter > 12) {
            if (spriteNum == 1) {
                spriteNum = 2;
            } else if (spriteNum == 2) {
                spriteNum = 1;
            }
            spriteCounter = 0;
        }

    }

    public void update() { // projectile1

        // just like PLAYERS PROJECTILES IS BASED ON DIRECTION

        // System.out.println("Projectile X:" + gp.projectileList.get(0).worldX);

        int projectileIndex = gp.cc.checkProjectile(this, gp.mob, true);
        if (projectileIndex != 777) {
            gp.playSFX(7);
            System.out.println("interacted");
            alive = false;
            gp.mob[projectileIndex].life -= 1;
        }

        int projectileIndex2 = gp.cc.checkProjectile2(this, gp.giantMob, true);

        if (projectileIndex2 != 777) {
            gp.playSFX(7);
            System.out.println("interacted");
            alive = false;
            gp.giantMob[projectileIndex2].life -= 4;

        }
                    

        if (user != gp.me) {

        }

        switch (direction) {
            case "up":
                worldY -= speed;
                size += 1;
                break;
            case "down":
                worldY += speed;
                size += 1;
                break;
            case "left":
                worldX -= speed;
                size += 1;
                break;
            case "right":
                worldX += speed;
                size += 1;
                break;

        }

        life--;
        if (life <= 0) {
            alive = false; // once shoot, it will gradually lose its life, if it hits 0, the projectile
                           // disappears after 80 frames it disappears

        }

        spriteCounter++;

        if (spriteCounter > 12) {
            if (spriteNum == 1) {
                spriteNum = 2;
            } else if (spriteNum == 2) {
                spriteNum = 1;
            }
            spriteCounter = 0;
        }

    }

    public void update2() { // projectile 2

        // just like PLAYERS PROJECTILES IS BASED ON DIRECTION

        // System.out.println("Projectile X:" + gp.projectileList.get(0).worldX);

        int projectileIndex = gp.cc.checkProjectile(this, gp.mob, true);
        if (projectileIndex != 777) {
            gp.playSFX(7);
            System.out.println("interacted");
            alive = false;
            gp.mob[projectileIndex].life -= 1;
        }

        int projectileIndex2 = gp.cc.checkProjectile2(this, gp.giantMob, true);

        if (projectileIndex2 != 777) {
            gp.playSFX(7);
            System.out.println("interacted 2");
            System.out.println("Life of giant monster" + projectileIndex2 + "is: " + gp.giantMob[projectileIndex2].life);
            alive = false;
            gp.giantMob[projectileIndex2].life -= 4;

        }
           

       


        if (user != gp.me) {

        }

        switch (direction) {
            case "up":
                worldY -= speed;
                break;
            case "down":
                worldY += speed;
                break;
            case "left":
                worldX -= speed;
                break;
            case "right":
                worldX += speed;
                break;
            case "up-right":
                worldX += speed;
                worldY -= speed;
                break;
            case "up-left":
                worldX -= speed;
                worldY -= speed;
                break;
            case "down-right":
                worldX += speed;
                worldY += speed;
                break;
            case "down-left":
                worldX -= speed;
                worldY += speed;
                break;

        }

        life--;
        if (life <= 0) {
            alive = false; // once shoot, it will gradually lose its life, if it hits 0, the projectile
                           // disappears after 80 frames it disappears

        }

        spriteCounter++;

        if (spriteCounter > 12) {
            if (spriteNum == 1) {
                spriteNum = 2;
            } else if (spriteNum == 2) {
                spriteNum = 1;
            }
            spriteCounter = 0;
        }

    }

}
