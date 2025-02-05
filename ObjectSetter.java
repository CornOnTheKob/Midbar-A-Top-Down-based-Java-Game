/**
    This is a class that handles the placing of objects in the game. Objects include Signs, Gemstones, Crystal
    Not only objects but also mobs!

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

public class ObjectSetter {

    GameFrame gp;

    public ObjectSetter(GameFrame gp){

        this.gp = gp;
    }

    public void setStones(){ //elemental stones

        gp.stone[0] = new EarthStone();
        gp.stone[0].worldX = 48 * gp.tileSize;
        gp.stone[0].worldY = 139 * gp.tileSize;

        gp.stone[1] = new FireStone();
        gp.stone[1].worldX = 204 * gp.tileSize;
        gp.stone[1].worldY = 150 * gp.tileSize;


        gp.stone[2] = new WaterStone();
        gp.stone[2].worldX = 150 * gp.tileSize;
        gp.stone[2].worldY = 29 * gp.tileSize;

        gp.stone[3] =  new AirStone();
        gp.stone[3].worldX = 110 * gp.tileSize;
        gp.stone[3].worldY = 23 * gp.tileSize;

        gp.stone[4] =  new Crystal();
        gp.stone[4].worldX = 1000 * gp.tileSize;
        gp.stone[4].worldY = 2000 * gp.tileSize;
    
           
        
      

                /*

                orig

            

            fake
             
            gp.stone[0] = new EarthStone();
            gp.stone[0].worldX = 4 * gp.tileSize;
            gp.stone[0].worldY = 22 * gp.tileSize;
    
            gp.stone[1] = new FireStone();
            gp.stone[1].worldX = 6 * gp.tileSize;
            gp.stone[1].worldY = 22 * gp.tileSize;
    
    
            gp.stone[2] = new WaterStone();
            gp.stone[2].worldX = 8 * gp.tileSize;
            gp.stone[2].worldY = 22 * gp.tileSize;
    
            gp.stone[3] =  new AirStone();
            gp.stone[3].worldX = 10 * gp.tileSize;
            gp.stone[3].worldY = 22 * gp.tileSize;
    
            gp.stone[4] =  new Crystal();
            gp.stone[4].worldX = 1000 * gp.tileSize;
            gp.stone[4].worldY = 2000 * gp.tileSize;
        
      
             */







    }

    public void setFakeObject(){
               //trial sprites
       gp.objYou[0] = new HeartSprite(); 
       gp.objYou[0].worldX = gp.randomX1 * gp.tileSize;
       gp.objYou[0].worldY =  gp.randomY1 * gp.tileSize;

       gp.objYou[1] = new HeartSprite(); 
       gp.objYou[1].worldX = 13 * gp.tileSize; //7 and 29 
       gp.objYou[1].worldY = 26 * gp.tileSize;

       
       gp.objYou[2] = new HeartSprite(); 
       gp.objYou[2].worldX = 13 * gp.tileSize;
       gp.objYou[2].worldY = 24 * gp.tileSize;
       

       //START OF REAL LOCATIONS WATER
       gp.objYou[3] = new HeartSprite();
       gp.objYou[3].worldX = 134 * gp.tileSize;
       gp.objYou[3].worldY = 58 * gp.tileSize;


       gp.objYou[4] = new HeartSprite(); 
       gp.objYou[4].worldX = 170 * gp.tileSize;
       gp.objYou[4].worldY = 62 * gp.tileSize;

       gp.objYou[5] = new HeartSprite();
       gp.objYou[5].worldX = 167 * gp.tileSize;
       gp.objYou[5].worldY = 76 * gp.tileSize;

       //FIRE
       gp.objYou[6] = new HeartSprite(); 
       gp.objYou[6].worldX = 206 * gp.tileSize;
       gp.objYou[6].worldY = 108 * gp.tileSize;

       gp.objYou[7] = new HeartSprite();
       gp.objYou[7].worldX = 210 * gp.tileSize;
       gp.objYou[7].worldY = 108 * gp.tileSize;

       gp.objYou[8] = new HeartSprite(); 
       gp.objYou[8].worldX = 203 * gp.tileSize;
       gp.objYou[8].worldY = 136 * gp.tileSize;

       gp.objYou[9] = new HeartSprite();
       gp.objYou[9].worldX = 202 * gp.tileSize;
       gp.objYou[9].worldY = 136 * gp.tileSize;

       //EARTH
       gp.objYou[10] = new HeartSprite(); 
       gp.objYou[10].worldX = 87 * gp.tileSize;
       gp.objYou[10].worldY = 127 * gp.tileSize;

       gp.objYou[11] = new HeartSprite();
       gp.objYou[11].worldX = 112 * gp.tileSize;
       gp.objYou[11].worldY = 138 * gp.tileSize;

       gp.objYou[12] = new HeartSprite(); 
       gp.objYou[12].worldX = 112 * gp.tileSize;
       gp.objYou[12].worldY = 141 * gp.tileSize;
       
       gp.objYou[13] = new HeartSprite();
       gp.objYou[13].worldX = 106 * gp.tileSize;
       gp.objYou[13].worldY = 141 * gp.tileSize;

       gp.objYou[14] = new HeartSprite(); 
       gp.objYou[14].worldX = 81 * gp.tileSize;
       gp.objYou[14].worldY = 136 * gp.tileSize;

       //Air
       gp.objYou[15] = new HeartSprite();    
       gp.objYou[15].worldX = 96 * gp.tileSize;
       gp.objYou[15].worldY = 80 * gp.tileSize;

       gp.objYou[16] = new HeartSprite(); 
       gp.objYou[16].worldX = 95 * gp.tileSize;
       gp.objYou[16].worldY = 68 * gp.tileSize;

       gp.objYou[17] = new HeartSprite();
       gp.objYou[17].worldX = 46 * gp.tileSize;
       gp.objYou[17].worldY = 38 * gp.tileSize;

       gp.objYou[18] = new HeartSprite(); 
       gp.objYou[18].worldX = 25 * gp.tileSize;
       gp.objYou[18].worldY = 24 * gp.tileSize;

       gp.objYou[19] = new HeartSprite();    
       gp.objYou[19].worldX = 7 * gp.tileSize;
       gp.objYou[19].worldY = 25 * gp.tileSize;

       gp.objYou[20] = new HeartSprite(); 
       gp.objYou[20].worldX = 116 * gp.tileSize;
       gp.objYou[20].worldY = 41 * gp.tileSize;

      

    }
    public void setObject(){ //gives values of coordinates you want to place-- world coordinates so its where on the map
       
       //trial sprites
        gp.obj[0] = new HeartSprite(); 
        gp.obj[0].worldX = gp.randomX1 * gp.tileSize;
        gp.obj[0].worldY =  gp.randomY1 * gp.tileSize;

        gp.obj[1] = new HeartSprite(); 
        gp.obj[1].worldX = 13 * gp.tileSize; //7 and 29 
        gp.obj[1].worldY = 26 * gp.tileSize;

        
        gp.obj[2] = new HeartSprite(); 
        gp.obj[2].worldX = 13 * gp.tileSize;
        gp.obj[2].worldY = 24 * gp.tileSize;
        

        //START OF REAL LOCATIONS WATER
        gp.obj[3] = new HeartSprite();
        gp.obj[3].worldX = 134 * gp.tileSize;
        gp.obj[3].worldY = 58 * gp.tileSize;


        gp.obj[4] = new HeartSprite(); 
        gp.obj[4].worldX = 170 * gp.tileSize;
        gp.obj[4].worldY = 62 * gp.tileSize;

        gp.obj[5] = new HeartSprite();
        gp.obj[5].worldX = 167 * gp.tileSize;
        gp.obj[5].worldY = 76 * gp.tileSize;

        //FIRE
        gp.obj[6] = new HeartSprite(); 
        gp.obj[6].worldX = 206 * gp.tileSize;
        gp.obj[6].worldY = 108 * gp.tileSize;

        gp.obj[7] = new HeartSprite();
        gp.obj[7].worldX = 210 * gp.tileSize;
        gp.obj[7].worldY = 108 * gp.tileSize;

        gp.obj[8] = new HeartSprite(); 
        gp.obj[8].worldX = 203 * gp.tileSize;
        gp.obj[8].worldY = 136 * gp.tileSize;

        gp.obj[9] = new HeartSprite();
        gp.obj[9].worldX = 202 * gp.tileSize;
        gp.obj[9].worldY = 136 * gp.tileSize;

        //EARTH
        gp.obj[10] = new HeartSprite(); 
        gp.obj[10].worldX = 87 * gp.tileSize;
        gp.obj[10].worldY = 127 * gp.tileSize;

        gp.obj[11] = new HeartSprite();
        gp.obj[11].worldX = 112 * gp.tileSize;
        gp.obj[11].worldY = 138 * gp.tileSize;

        gp.obj[12] = new HeartSprite(); 
        gp.obj[12].worldX = 112 * gp.tileSize;
        gp.obj[12].worldY = 141 * gp.tileSize;
        
        gp.obj[13] = new HeartSprite();
        gp.obj[13].worldX = 106 * gp.tileSize;
        gp.obj[13].worldY = 141 * gp.tileSize;

        gp.obj[14] = new HeartSprite(); 
        gp.obj[14].worldX = 81 * gp.tileSize;
        gp.obj[14].worldY = 136 * gp.tileSize;

        //Air
        gp.obj[15] = new HeartSprite();    
        gp.obj[15].worldX = 96 * gp.tileSize;
        gp.obj[15].worldY = 80 * gp.tileSize;

        gp.obj[16] = new HeartSprite(); 
        gp.obj[16].worldX = 95 * gp.tileSize;
        gp.obj[16].worldY = 68 * gp.tileSize;

        gp.obj[17] = new HeartSprite();
        gp.obj[17].worldX = 46 * gp.tileSize;
        gp.obj[17].worldY = 38 * gp.tileSize;

        gp.obj[18] = new HeartSprite(); 
        gp.obj[18].worldX = 25 * gp.tileSize;
        gp.obj[18].worldY = 24 * gp.tileSize;

        gp.obj[19] = new HeartSprite();    
        gp.obj[19].worldX = 7 * gp.tileSize;
        gp.obj[19].worldY = 25 * gp.tileSize;

        gp.obj[20] = new HeartSprite(); 
        gp.obj[20].worldX = 116 * gp.tileSize;
        gp.obj[20].worldY = 41 * gp.tileSize;




    }

    public void setGiantMobs(){
         //Earth: 450 

        //Air:  628.png 635s.png
        //Water:  614s.png
        //Fire: 697s.png

        //gp.seed[20];
        gp.giantMob[0] = new Giant_Mob_F(gp, 0);
        gp.giantMob[0].worldX = 200 * gp.tileSize;
        gp.giantMob[0].worldY = 143 * gp.tileSize;
        gp.giantMob[0].direction = "down";
        gp.giantMob[0].life = 20;
        gp.giantMob[0].maxLife = 20;

        gp.giantMob[1] = new Giant_Mob_W(gp, 0); //earth
        gp.giantMob[1].worldX = 60 * gp.tileSize;
        gp.giantMob[1].worldY = 146 * gp.tileSize;
        gp.giantMob[1].direction = "down";
        gp.giantMob[1].life = 20;
        gp.giantMob[1].maxLife = 20;

        gp.giantMob[2] = new Giant_Mob_E(gp,gp.seeds[22]); 
        gp.giantMob[2].worldX = 148 * gp.tileSize;
        gp.giantMob[2].worldY = 45 * gp.tileSize;
        gp.giantMob[2].direction = "down";
        gp.giantMob[2].life = 20;
        gp.giantMob[2].maxLife = 20;


        gp.giantMob[3] = new Giant_Mob_A(gp, gp.seeds[23]);
        gp.giantMob[3].worldX = 55 * gp.tileSize;
        gp.giantMob[3].worldY = 33 * gp.tileSize;
        gp.giantMob[3].direction = "down";
        gp.giantMob[3].life = 20;
        gp.giantMob[3].maxLife = 20;


        // AIR GIANT 55 33 
        // earth 60 146
        // 202 147 fire
        // WATER 148 45

        
    




    }
    
    public void setMobs(){


        //Earth: check

        //Air: 581 
        //Water: 444 
        //Fire: 571 check [kulang pa] 


        //giant mobv
     
        gp.mob[0] = new Mob_E(gp, gp.seed);
        gp.mob[0].worldX = 59 * gp.tileSize;
        gp.mob[0].worldY = 149 * gp.tileSize;
        gp.mob[0].direction = "down";
        gp.mob[0].life = 5;
        gp.mob[0].maxLife = 5;
    
        gp.mob[1] = new Mob_E(gp, gp.seed2);
        gp.mob[1].worldX = 63 * gp.tileSize;
        gp.mob[1].worldY = 148 * gp.tileSize;
        gp.mob[1].direction = "down";
        gp.mob[1].life = 5;
        gp.mob[1].maxLife = 5;

        gp.mob[2] = new Mob_E(gp, gp.seed3);
        gp.mob[2].worldX = 63 * gp.tileSize;
        gp.mob[2].worldY = 149 * gp.tileSize;
        gp.mob[2].direction = "down";
        gp.mob[2].life = 5;
        gp.mob[2].maxLife = 5;
    
        gp.mob[3] = new Mob_E(gp, gp.seed4);
        gp.mob[3].worldX = 56 * gp.tileSize;
        gp.mob[3].worldY = 143 * gp.tileSize;
        gp.mob[3].direction = "down";
        gp.mob[3].life = 5;
        gp.mob[3].maxLife = 5;

        gp.mob[4] = new Mob_E(gp, gp.seed5);
        gp.mob[4].worldX = 62 * gp.tileSize;
        gp.mob[4].worldY = 149 * gp.tileSize;
        gp.mob[4].direction = "down";
        gp.mob[4].life = 5;
        gp.mob[4].maxLife = 5;

        gp.mob[5] = new Mob_E(gp, gp.seed6);
        gp.mob[5].worldX = 56 * gp.tileSize;
        gp.mob[5].worldY = 143 * gp.tileSize;
        gp.mob[5].direction = "down";
        gp.mob[5].life = 5;
        gp.mob[5].maxLife = 5;

        gp.mob[6] = new Mob_E(gp, gp.seed7);
        gp.mob[6].worldX = 52 * gp.tileSize;
        gp.mob[6].worldY = 149 * gp.tileSize;
        gp.mob[6].direction = "down";
        gp.mob[6].life = 5;
        gp.mob[6].maxLife = 5;

        gp.mob[7] = new Mob_E(gp, gp.seed8);
        gp.mob[7].worldX = 63 * gp.tileSize;
        gp.mob[7].worldY = 156 * gp.tileSize;
        gp.mob[7].direction = "down";
        gp.mob[7].life = 5;
        gp.mob[7].maxLife = 5;

        gp.mob[8] = new Mob_E(gp, gp.seed9); //test mobs
        gp.mob[8].worldX = 18 * gp.tileSize;
        gp.mob[8].worldY = 27 * gp.tileSize;
        gp.mob[8].direction = "down";
        gp.mob[8].life = 5;
        gp.mob[8].maxLife = 5;

        gp.mob[9] = new Mob_E(gp, gp.seed10);
        gp.mob[9].worldX = 15 * gp.tileSize;
        gp.mob[9].worldY = 30 * gp.tileSize;
        gp.mob[9].direction = "down";
        gp.mob[9].life = 5;
        gp.mob[9].maxLife = 5;


        // fire mobs 

        gp.mob[10] = new Mob_F(gp, gp.seed11); //test mobs
        gp.mob[10].worldX = 15 * gp.tileSize;
        gp.mob[10].worldY = 28 * gp.tileSize;
        gp.mob[10].direction = "down";
        gp.mob[10].life = 5;
        gp.mob[10].maxLife = 5;
    
        gp.mob[11] = new Mob_F(gp, gp.seed12);
        gp.mob[11].worldX = 202 * gp.tileSize;
        gp.mob[11].worldY = 149 * gp.tileSize;
        gp.mob[11].direction = "down";
        gp.mob[11].life = 5;
        gp.mob[11].maxLife = 5;

        gp.mob[12] = new Mob_F(gp, gp.seed13);
        gp.mob[12].worldX = 203 * gp.tileSize;
        gp.mob[12].worldY = 149 * gp.tileSize;
        gp.mob[12].direction = "down";
        gp.mob[12].life = 5;
        gp.mob[12].maxLife = 5;
    
        gp.mob[13] = new Mob_F(gp, gp.seed14);
        gp.mob[13].worldX = 204 * gp.tileSize;
        gp.mob[13].worldY = 149 * gp.tileSize;
        gp.mob[13].direction = "down";
        gp.mob[13].life = 5;
        gp.mob[13].maxLife = 5;

        gp.mob[14] = new Mob_F(gp, gp.seed15);
        gp.mob[14].worldX = 204 * gp.tileSize;
        gp.mob[14].worldY = 150 * gp.tileSize;
        gp.mob[14].direction = "down";
        gp.mob[14].life = 5;
        gp.mob[14].maxLife = 5;

        gp.mob[15] = new Mob_F(gp, gp.seed16);
        gp.mob[15].worldX = 221 * gp.tileSize;
        gp.mob[15].worldY = 134 * gp.tileSize;
        gp.mob[15].direction = "down";
        gp.mob[15].life = 5;
        gp.mob[15].maxLife = 5;

        gp.mob[16] = new Mob_F(gp, gp.seed17);
        gp.mob[16].worldX = 221 * gp.tileSize;
        gp.mob[16].worldY = 127 * gp.tileSize;
        gp.mob[16].direction = "down";
        gp.mob[16].life = 5;
        gp.mob[16].maxLife = 5;

        gp.mob[17] = new Mob_F(gp, gp.seed18);
        gp.mob[17].worldX = 220 * gp.tileSize;
        gp.mob[17].worldY = 127 * gp.tileSize;
        gp.mob[17].direction = "down";
        gp.mob[17].life = 5;
        gp.mob[17].maxLife = 5;

        gp.mob[18] = new Mob_F(gp, gp.seed19);
        gp.mob[18].worldX = 207 * gp.tileSize;
        gp.mob[18].worldY = 108 * gp.tileSize;
        gp.mob[18].direction = "down";
        gp.mob[18].life = 5;
        gp.mob[18].maxLife = 5;

        gp.mob[19] = new Mob_F(gp, gp.seed20);
        gp.mob[19].worldX = 210 * gp.tileSize;
        gp.mob[19].worldY = 108 * gp.tileSize;
        gp.mob[19].direction = "down";
        gp.mob[19].life = 5;
        gp.mob[19].maxLife = 5;
        

        //Water
        gp.mob[20] = new Mob_W(gp, gp.seeds[0]);
        gp.mob[20].worldX = 13 * gp.tileSize;
        gp.mob[20].worldY = 28 * gp.tileSize;
        gp.mob[20].direction = "down";
        gp.mob[20].life = 5;
        gp.mob[20].maxLife = 5;

        gp.mob[21] = new Mob_W(gp, gp.seeds[1]);
        gp.mob[21].worldX = 150 * gp.tileSize;
        gp.mob[21].worldY = 49 * gp.tileSize;
        gp.mob[21].direction = "down";
        gp.mob[21].life = 5;
        gp.mob[21].maxLife = 5;

        gp.mob[22] = new Mob_W(gp, gp.seeds[2]);
        gp.mob[22].worldX = 150 * gp.tileSize;
        gp.mob[22].worldY = 45 * gp.tileSize;
        gp.mob[22].direction = "down";
        gp.mob[22].life = 5;
        gp.mob[22].maxLife = 5;

        gp.mob[23] = new Mob_W(gp, gp.seeds[3]);
        gp.mob[23].worldX = 143 * gp.tileSize;
        gp.mob[23].worldY = 39 * gp.tileSize;
        gp.mob[23].direction = "down";
        gp.mob[23].life = 5;
        gp.mob[23].maxLife = 5;

        gp.mob[24] = new Mob_W(gp, gp.seeds[4]);
        gp.mob[24].worldX = 144 * gp.tileSize;
        gp.mob[24].worldY = 39 * gp.tileSize;
        gp.mob[24].direction = "down";
        gp.mob[24].life = 5;
        gp.mob[24].maxLife = 5;
        
        gp.mob[25] = new Mob_W(gp, gp.seeds[5]);
        gp.mob[25].worldX = 155 * gp.tileSize;
        gp.mob[25].worldY = 37 * gp.tileSize;
        gp.mob[25].direction = "down";
        gp.mob[25].life = 5;
        gp.mob[25].maxLife = 5;

        gp.mob[26] = new Mob_W(gp, gp.seeds[6]);
        gp.mob[26].worldX = 149 * gp.tileSize;
        gp.mob[26].worldY = 91 * gp.tileSize;
        gp.mob[26].direction = "down";
        gp.mob[26].life = 5;
        gp.mob[26].maxLife = 5;

        gp.mob[27] = new Mob_W(gp, gp.seeds[7]);
        gp.mob[27].worldX = 167 * gp.tileSize;
        gp.mob[27].worldY = 81 * gp.tileSize;
        gp.mob[27].direction = "down";
        gp.mob[27].life = 5;
        gp.mob[27].maxLife = 5;
        
        gp.mob[28] = new Mob_W(gp, gp.seeds[8]);
        gp.mob[28].worldX = 167 * gp.tileSize;
        gp.mob[28].worldY = 82 * gp.tileSize;
        gp.mob[28].direction = "down";
        gp.mob[28].life = 5;
        gp.mob[28].maxLife = 5;

        gp.mob[29] = new Mob_W(gp, gp.seeds[9]);
        gp.mob[29].worldX = 148 * gp.tileSize;
        gp.mob[29].worldY = 90 * gp.tileSize;
        gp.mob[29].direction = "down";
        gp.mob[29].life = 5;
        gp.mob[29].maxLife = 5;




        //Air
        gp.mob[30] = new Mob_A(gp, gp.seeds[10]);
        gp.mob[30].worldX = 11 * gp.tileSize;
        gp.mob[30].worldY = 28 * gp.tileSize;
        gp.mob[30].direction = "down";
        gp.mob[30].life = 5;
        gp.mob[30].maxLife = 5;

        gp.mob[31] = new Mob_A(gp, gp.seeds[11]);
        gp.mob[31].worldX = 107 * gp.tileSize;
        gp.mob[31].worldY = 111 * gp.tileSize;
        gp.mob[31].direction = "down";
        gp.mob[31].life = 5;
        gp.mob[31].maxLife = 5;

        gp.mob[32] = new Mob_A(gp, gp.seeds[12]);
        gp.mob[32].worldX = 107 * gp.tileSize;
        gp.mob[32].worldY = 113 * gp.tileSize;
        gp.mob[32].direction = "down";
        gp.mob[32].life = 5;
        gp.mob[32].maxLife = 5;

        gp.mob[33] = new Mob_A(gp, gp.seeds[13]);
        gp.mob[33].worldX = 90 * gp.tileSize;
        gp.mob[33].worldY = 99 * gp.tileSize;
        gp.mob[33].direction = "down";
        gp.mob[33].life = 5;
        gp.mob[33].maxLife = 5;

        gp.mob[34] = new Mob_A(gp, gp.seeds[14]);
        gp.mob[34].worldX = 51 * gp.tileSize;
        gp.mob[34].worldY = 93 * gp.tileSize;
        gp.mob[34].direction = "down";
        gp.mob[34].life = 5;
        gp.mob[34].maxLife = 5;
    
        gp.mob[35] = new Mob_A(gp, gp.seeds[15]);
        gp.mob[35].worldX = 51 * gp.tileSize;
        gp.mob[35].worldY = 94 * gp.tileSize;
        gp.mob[35].direction = "down";
        gp.mob[35].life = 5;
        gp.mob[35].maxLife = 5;

        gp.mob[36] = new Mob_A(gp, gp.seeds[16]);
        gp.mob[36].worldX = 63 * gp.tileSize;
        gp.mob[36].worldY = 31 * gp.tileSize;
        gp.mob[36].direction = "down";
        gp.mob[36].life = 5;
        gp.mob[36].maxLife = 5;

        gp.mob[37] = new Mob_A(gp, gp.seeds[17]);
        gp.mob[37].worldX = 34 * gp.tileSize;
        gp.mob[37].worldY = 80 * gp.tileSize;
        gp.mob[37].direction = "down";
        gp.mob[37].life = 5;
        gp.mob[37].maxLife = 5;
        
        gp.mob[38] = new Mob_A(gp, gp.seeds[18]);
        gp.mob[38].worldX = 108 * gp.tileSize;
        gp.mob[38].worldY = 52 * gp.tileSize;
        gp.mob[38].direction = "down";
        gp.mob[38].life = 5;
        gp.mob[38].maxLife = 5;

        gp.mob[39] = new Mob_A(gp, gp.seeds[19]);
        gp.mob[39].worldX = 108 * gp.tileSize;
        gp.mob[39].worldY = 51 * gp.tileSize;
        gp.mob[39].direction = "down";
        gp.mob[39].life = 5;
        gp.mob[39].maxLife = 5;






    }

    public void setEnemy(){ //setNPC

        //ano diff ng you and gp.enemy ==> taga update ng values si you tas gp.enemy pag diretsuhan
        
        gp.enemy[0] = new Player2(gp);
        gp.enemy[0].worldX = (17 * gp.tileSize);
        gp.enemy[0].worldY = 27 * gp.tileSize;
        gp.enemy[0].direction = "down";
        gp.enemy[0].spriteNum = 1;
        gp.enemy[0].spriteCounter = 0;
        gp.enemy[0].walk = false;
        gp.enemy[0].maxLife = 10;
        gp.enemy[0].life = gp.enemy[0].maxLife;
       





    }

    public void setSigns(){

        gp.signs[0] = new Sign_F(gp);
        gp.signs[0].worldX = 180 * gp.tileSize;
        gp.signs[0].worldY = 118 * gp.tileSize;


        gp.signs[1] = new Sign_C(gp);
        gp.signs[1].worldX = 86 * gp.tileSize;
        gp.signs[1].worldY = 84 * gp.tileSize;
        
        gp.signs[2] = new Sign_A(gp);
        gp.signs[2].worldX = 108 * gp.tileSize;
        gp.signs[2].worldY = 48 * gp.tileSize;

        gp.signs[3] = new Sign_W(gp);
        gp.signs[3].worldX = 120 * gp.tileSize;
        gp.signs[3].worldY = 84 * gp.tileSize;

        gp.signs[4] = new Sign_E(gp);
        gp.signs[4].worldX = 87 * gp.tileSize;
        gp.signs[4].worldY = 129 * gp.tileSize;

        gp.signs[5] = new Sign_E(gp);
        gp.signs[5].worldX = 91 * gp.tileSize;
        gp.signs[5].worldY = 146 * gp.tileSize;
        

     
    }
    
}
