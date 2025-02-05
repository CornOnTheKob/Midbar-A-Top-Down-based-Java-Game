/**
    This is a class that lays out the tiles for the map.

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
import java.awt.*;
import java.io.*;

public class MapMaker extends Tile {


    GameFrame gp;
    public Tile[] tile;
    
    //for creating map using .txt
    public int[][] mapTileNum;

    public MapMaker(GameFrame gp){

        this.gp = gp;
        tile = new Tile[148];
        mapTileNum = new int[250][250];
        getTileImage();
        drawMap("/Midbar/Map/finalfinal.txt");

        }


    public void getTileImage(){


        try{ //read all time images

            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/Midbar/Tiles/000.png"));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/Midbar/Tiles/001.png"));

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/Midbar/Tiles/002.png"));
            tile[2].collision = true; //true = solid tile = collision = cannot walk through

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/Midbar/Tiles/003.png"));
            tile[3].collision = true;

            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/Midbar/Tiles/004.png"));
            tile[4].collision = true;

            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/Midbar/Tiles/005.png"));

            tile[6] = new Tile();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("/Midbar/Tiles/006.png"));
            tile[6].collision = true;

            tile[7] = new Tile();
            tile[7].image = ImageIO.read(getClass().getResourceAsStream("/Midbar/Tiles/007.png"));
            tile[7].collision = true;

            tile[8] = new Tile();
            tile[8].image = ImageIO.read(getClass().getResourceAsStream("/Midbar/Tiles/008.png"));
            tile[8].collision = true;

            tile[9] = new Tile();
            tile[9].image = ImageIO.read(getClass().getResourceAsStream("/Midbar/Tiles/009.png"));
            tile[9].collision = true;

            tile[10] = new Tile();
            tile[10].image = ImageIO.read(getClass().getResourceAsStream("/Midbar/Tiles/010.png"));

            tile[11] = new Tile();
            tile[11].image = ImageIO.read(getClass().getResourceAsStream("/Midbar/Tiles/011.png"));

            tile[12] = new Tile();
            tile[12].image = ImageIO.read(getClass().getResourceAsStream("/Midbar/Tiles/012.png"));

            tile[13] = new Tile();
            tile[13].image = ImageIO.read(getClass().getResourceAsStream("/Midbar/Tiles/013.png"));

            tile[14] = new Tile();
            tile[14].image = ImageIO.read(getClass().getResourceAsStream("/Midbar/Tiles/014.png"));

            tile[15] = new Tile();
            tile[15].image = ImageIO.read(getClass().getResourceAsStream("/Midbar/Tiles/015.png"));
            tile[15].collision = false;

            tile[16] = new Tile();
            tile[16].image = ImageIO.read(getClass().getResourceAsStream("/Midbar/Tiles/016.png"));

            tile[17] = new Tile();
            tile[17].image = ImageIO.read(getClass().getResourceAsStream("/Midbar/Tiles/017.png"));

            tile[18] = new Tile();
            tile[18].image = ImageIO.read(getClass().getResourceAsStream("/Midbar/Tiles/018.png"));
            tile[18].collision = true;

            tile[19] = new Tile();
            tile[19].image = ImageIO.read(getClass().getResourceAsStream("/Midbar/Tiles/019.png"));
            tile[19].collision = true;

            tile[20] = new Tile();
            tile[20].image = ImageIO.read(getClass().getResourceAsStream("/Midbar/Tiles/020.png"));
            tile[20].collision = true;

            tile[21] = new Tile();
            tile[21].image = ImageIO.read(getClass().getResourceAsStream("/Midbar/Tiles/021.png"));
            tile[21].collision = true;

            tile[22] = new Tile();
            tile[22].image = ImageIO.read(getClass().getResourceAsStream("/Midbar/Tiles/022.png"));
            tile[22].collision = true;

            tile[23] = new Tile();
            tile[23].image = ImageIO.read(getClass().getResourceAsStream("/Midbar/Tiles/023.png"));
            tile[23].collision = true;

            tile[24] = new Tile();
            tile[24].image = ImageIO.read(getClass().getResourceAsStream("/Midbar/Tiles/024.png"));
            tile[24].collision = true;

            tile[25] = new Tile();
            tile[25].image = ImageIO.read(getClass().getResourceAsStream("/Midbar/Tiles/025.png"));
            tile[25].collision = true;

            tile[26] = new Tile();
            tile[26].image = ImageIO.read(getClass().getResourceAsStream("/Midbar/Tiles/026.png"));
            tile[26].collision = true;

            tile[27] = new Tile();
            tile[27].image = ImageIO.read(getClass().getResourceAsStream("/Midbar/Tiles/027.png"));
            tile[27].collision = true;

            tile[28] = new Tile();
            tile[28].image = ImageIO.read(getClass().getResourceAsStream("/Midbar/Tiles/028.png"));
            tile[28].collision = true;

            tile[29] = new Tile();
            tile[29].image = ImageIO.read(getClass().getResourceAsStream("/Midbar/Tiles/029.png"));
            tile[29].collision = true;

            tile[30] = new Tile();
            tile[30].image = ImageIO.read(getClass().getResourceAsStream("/Midbar/Tiles/030.png"));
            tile[30].collision = true;

            tile[31] = new Tile();
            tile[31].image = ImageIO.read(getClass().getResourceAsStream("/Midbar/Tiles/031.png"));
            tile[31].collision = true;

            tile[32] = new Tile();
            tile[32].image = ImageIO.read(getClass().getResourceAsStream("/Midbar/Tiles/032.png"));
            tile[32].collision = true;

            tile[33] = new Tile();
            tile[33].image = ImageIO.read(getClass().getResourceAsStream("/Midbar/Tiles/033.png"));
            tile[33].collision = true;

            tile[34] = new Tile();
            tile[34].image = ImageIO.read(getClass().getResourceAsStream("/Midbar/Tiles/034.png"));
            tile[34].collision = true;

            tile[35] = new Tile();
            tile[35].image = ImageIO.read(getClass().getResourceAsStream("/Midbar/Tiles/035.png"));
            tile[35].collision = true;

            tile[36] = new Tile();
            tile[36].image = ImageIO.read(getClass().getResourceAsStream("/Midbar/Tiles/036.png"));
            tile[36].collision = true;

            tile[37] = new Tile();
            tile[37].image = ImageIO.read(getClass().getResourceAsStream("/Midbar/Tiles/037.png"));
            tile[37].collision = true;

            tile[38] = new Tile();
            tile[38].image = ImageIO.read(getClass().getResourceAsStream("/Midbar/Tiles/038.png"));
            tile[38].collision = true;

            tile[39] = new Tile();
            tile[39].image = ImageIO.read(getClass().getResourceAsStream("/Midbar/Tiles/039.png"));
            tile[39].collision = true;

            tile[40] = new Tile();
            tile[40].image = ImageIO.read(getClass().getResourceAsStream("/Midbar/Tiles/040.png"));
            tile[40].collision = true;

            tile[41] = new Tile();
            tile[41].image = ImageIO.read(getClass().getResourceAsStream("/Midbar/Tiles/041.png"));
            tile[41].collision = true;

            tile[42] = new Tile();
            tile[42].image = ImageIO.read(getClass().getResourceAsStream("/Midbar/Tiles/042.png"));
            tile[42].collision = true;

            tile[43] = new Tile();
            tile[43].image = ImageIO.read(getClass().getResourceAsStream("/Midbar/Tiles/043.png"));
            tile[43].collision = true;

            tile[44] = new Tile();
            tile[44].image = ImageIO.read(getClass().getResourceAsStream("/Midbar/Tiles/044.png"));
            tile[44].collision = true;

            tile[45] = new Tile();
            tile[45].image = ImageIO.read(getClass().getResourceAsStream("/Midbar/Tiles/045.png"));
            tile[45].collision = true;

            tile[46] = new Tile();
            tile[46].image = ImageIO.read(getClass().getResourceAsStream("/Midbar/Tiles/046.png"));
            tile[46].collision = true;

            tile[47] = new Tile();
            tile[47].image = ImageIO.read(getClass().getResourceAsStream("/Midbar/Tiles/047.png"));
            tile[47].collision = true;

            tile[48] = new Tile();
            tile[48].image = ImageIO.read(getClass().getResourceAsStream("/Midbar/Tiles/048.png"));
            tile[48].collision = true;

            tile[49] = new Tile();
            tile[49].image = ImageIO.read(getClass().getResourceAsStream("/Midbar/Tiles/049.png"));
            tile[49].collision = true;

            tile[50] = new Tile();
            tile[50].image = ImageIO.read(getClass().getResourceAsStream("/Midbar/Tiles/050.png"));
            tile[50].collision = true;


            for(int i = 51; i <= 99; i++){
                tile[i] = new Tile();
                tile[i].image = ImageIO.read(getClass().getResourceAsStream("/Midbar/Tiles/0" + i +".png"));
            }
           
            for(int i = 100; i <= 147; i++ ){
                tile[i] = new Tile();
                tile[i].image = ImageIO.read(getClass().getResourceAsStream("/Midbar/Tiles/" + i +".png"));
                tile[i].collision = true;
            }

        } catch(IOException ex){
            System.out.println("IOException in getTileImage");
            //ex.printStackTrace();
        }

    }


    public void drawMap(String mapLink){ //getting values from map.txt -- there's a parameter (mapLink) so we can change map files path directory
        try{

            InputStream is = getClass().getResourceAsStream(mapLink); //get content of Map.txt
            BufferedReader br = new BufferedReader(new InputStreamReader(is));


            int col = 0;
            int row = 0;

            while(col <  gp.maxWorldCol && row <  gp.maxWorldRow){ // 0 < 16 and 0 < 12 //this will read it per line
                
                String line = br.readLine(); //readLine gonna read a single line.

                while(col < gp.maxWorldCol){

                    String[] numbers = line.split(" "); //this will separate numbers in the horizontal line

                    int num = Integer.parseInt(numbers[col]); //from string to integer
                            // y  x
                    mapTileNum[col][row] = num; //store individual numbers 
                    col++; 

                }

                if(col == gp.maxWorldCol){
                    col = 0;
                    row++; //if from left to right is done, the reader will go to next row/line. 
                }
            
            
            }
            br.close();


        }catch(Exception ex){
            System.out.println("Exception on drawMap");
        }

    }

    public void draw(Graphics2D g2d){ //this will draw the tile which if called by PlayerFrame, it will be .draw(g2d);
       
        int worldCol = 0;
        int worldRow = 0;
 
        while(worldCol < gp.maxWorldCol && worldRow < gp.maxWorldCol){ // 0 < 16 and 0 < 12

            int tileNum = mapTileNum[worldCol][worldRow]; //e.g. if tileNum = 1 --> grass tile
            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX - (int)gp.me.worldX + (int)gp.me.screenX;
            int screenY = worldY - (int)gp.me.worldY + (int)gp.me.screenY;

            //stop camera at edge

            if(gp.me.screenX > gp.me.worldX){ //basically if nasa edge, hindi na center ung screenX and screenY... so this will "stop" the camera "function"
                screenX = worldX;
            }
            if(gp.me.screenY > gp.me.worldY){
                screenY = worldY;

            }

            //experiment edges ; stop camera 

            int rightEdge = gp.screenWidth - gp.me.screenX; //length between me screenX and right edge of screen
            if(rightEdge > gp.worldWidth - gp.me.worldX){
                screenX = gp.screenWidth - (gp.worldWidth - worldX); //tile's worldX is upperleft top, so we need to subtract 48 since this is the scale. // screenwidth - gp.tileSize
                // (worldWith - worldX) = removes the empty spaces.


            }
            int bottomEdge = gp.screenHeight - gp.me.screenY;

            if(bottomEdge > gp.worldHeight - gp.me.worldY){
                screenY = gp.screenHeight - (gp.worldHeight - worldY); 

            }

            

            //create a boundary from center of screen - screenX; center + screen X; center - screen Y ; center + screenY

            if (    worldX + gp.tileSize > gp.me.worldX - gp.me.screenX && 
                    worldX - gp.tileSize < gp.me.worldX + gp.me.screenX && 
                    worldY + gp.tileSize > gp.me.worldY - gp.me.screenY &&
                    worldY - gp.tileSize < gp.me.worldY + gp.me.screenY ){
                
                    g2d.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize,null); //will draw based on its index value 

                    }

        // If player is around the edge, draw everything
            else if (gp.me.worldX < gp.me.screenX ||
                     gp.me.worldY < gp.me.screenY || 
                    rightEdge > gp.worldWidth - gp.me.worldX || 
                    bottomEdge > gp.worldHeight - gp.me.worldY) {

                    g2d.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null); 
            }  
            worldCol ++;

            if(worldCol == gp.maxWorldCol){ //left to right; row is basically the y, so pag puno na ung isang col, next line na
                worldCol = 0;
                worldRow++;
    
            }

        }
       
 

    }



}
