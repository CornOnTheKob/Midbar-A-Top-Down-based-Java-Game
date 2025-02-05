/**
    This is a class that manages the game server's functionality. It also
    contains the main method that instantiates and starts the server.




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


/*
 
    What does the Server do?

 


    Summary of Networking
Used to transfer data of Player 1 and Player 2 (e.g. life)
Used to transfer data of Mobs, Projectile Animation, and Gemstones/Crystal.
Changes UI depending on which Player is which. 
The server sends seeds for random mob movement so that both clients shall have the same mobs moving in the same direction.
The server also sends seeds for the item placement in the map [but there are already specified locations for it to go to.]
The server shall also send seeds for random player spawn points (spawn points are usually at the entrances of each biome or at the center of the map). 


 */


//once both clients have opened, threads should start when both players have connected;
import java.io.*;
import java.net.*;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.Iterator;


public class GameServer {
    
    //Sockets are commonly used for client and server interaction. The clients connect to the server, exchange information, and then disconnect
    //A ServerSocket is used to listen for incoming client connections, and is used to create a new Socket for each client that connects to it.
    //A Socket is used to establish a connection between two devices over a network, and is used for sending and receiving data. 
   
    private ServerSocket ss;
     
    private int numPlayers; 
    private int maxPlayers;

    //for runnables and store socket; eventually u can close them when game ends
    private Socket p1Socket;
    private Socket p2Socket;
    private readFromClient p1ReadRunnable; //
    private readFromClient p2ReadRunnable;
    private writeToClient p1WriteRunnable;
    private writeToClient p2WriteRunnable;

    private double p1x, p1y;
    private String p1d, p2d;
    private double p2x, p2y;
    private int p1s, p2s;
    private boolean p1w, p2w;

    private boolean[] so1 =  new boolean[5]; //stones
    private boolean[] so2 = new boolean[5];


    //For Stones CHECKER STATE IF EQUIPPED OR NOT EQUIP
    private int stonesLeftp1,stonesLeftp2;
    private boolean completeStoneMsgCheckerp1,completeStoneMsgCheckerp2;
    private boolean earthStoneCheckerp1, earthStoneCheckerp2; //earth fire air water
    private boolean fireStoneCheckerp1, fireStoneCheckerp2; //earth fire air water
    private boolean airStoneCheckerp1, airStoneCheckerp2;
    private boolean waterStoneCheckerp1, waterStoneCheckerp2;
    private boolean crystalStoneCheckerp1, crystalStoneCheckerp2;

    //for UI
    private int stoneCountp1, stoneCountp2;

    //
    private int lifep1, lifep2;
    

    private double[] mob_xp1 = new double[1];
    private double[] mob_yp1 = new double[1];
    private String[] mob_p1 = new String[1];

    private double[] mob_xp2 = new double[1];
    private double[] mob_yp2 = new double[1];
    private String[] mob_p2 = new String[1];
   
    

    //for the mobs 
    private long seed,seed2,seed3,seed4,seed5,seed6,seed7,seed8,seed9,seed10;
    private long seed11,seed12,seed13,seed14,seed15,seed16,seed17,seed18,seed19,seed20;

        // new version of seeds

        private long[] seeds;

    private Random random;

    //for mob health


    // mob health
    private int[] mob_p1s;
    private int[] mob_p2s;

    private int[] giantmob_p1s;
    private int[] giantmob_p2s;

    private int[] mob_p1s2;
    private int[] mob_p2s2;


    // projectile #1 FOR ONE PROJECTILE

    private double p1worldX, p2worldX;
    private double p1worldY, p2worldY;
    private String p1direct = "", p2direct = "";
    private boolean p1true, p2true;
    private boolean p1shot, p2shot;

    
    // projectile 2 3 4

    private boolean p1shot2, p2shot2;
    private boolean p1shot3, p2shot3;
    private boolean p1shot4, p2shot4;

    private boolean p1win, p2win;
    private boolean p1dead, p2dead;
    private boolean p1deadchecker, p2deadchecker;



    private double[] proj2_p1worldX = new double[8], proj2_p2worldX = new double[8];
    private double[] proj2_p1worldY = new double[8], proj2_p2worldY = new double[8];
    private String[] proj2_p1direct = new String[8], proj2_p2direct = new String[8];
    private boolean[] proj2_p1true = new boolean[8], proj2_p2true = new boolean[8];
    private boolean[] proj2_p1shot = new boolean[8], proj2_p2shot = new boolean[8];


    // items
    private boolean[] itemp1;
    private boolean[] itemp2;

    private int[] randomGeneratedNumbersArray;
    private  int randomX1,randomY1;
    private  int randomX1_p1,randomY1_p1;
    private  int randomX1_p2,randomY1_p2;

    private boolean p1startChecker, p2startChecker;

    
    public GameServer(){

        seeds = new long[24];
        randomGeneratedNumbersArray = new int[5];

        randomGeneratedNumbers();

        itemp1 = new boolean[21]; //hearts
        itemp2 = new boolean[21];

   

        for (int i = 0; i < 20; i++){
            itemp1[i] = false;
            itemp2[i] = false;

        }

        //For the mob's lives
        mob_p1s = mob_p2s = mob_p1s2 = mob_p2s2 = new int[40];
        giantmob_p1s = giantmob_p2s = new int[4];

        for(int i = 0; i < giantmob_p1s.length; i++){
            giantmob_p1s[i] = 20;
            giantmob_p1s[i] = 20;
        }

        for(int i = 0; i < mob_p1s.length; i++){
            mob_p1s[i] = 5;
            mob_p2s[i] = 5;
        }
        
        //old version
        random = new Random();
        seed = random.nextLong();    seed11 = random.nextLong();           
        seed2 = random.nextLong();   seed12 = random.nextLong();       
        seed3 = random.nextLong();   seed13 = random.nextLong();         
        seed4 = random.nextLong();   seed14 = random.nextLong();   
        seed5 = random.nextLong();   seed15 = random.nextLong();       
        seed6 = random.nextLong();   seed16 = random.nextLong();        
        seed7 = random.nextLong();   seed17 = random.nextLong();       
        seed8 = random.nextLong();   seed18 = random.nextLong();
        seed9 = random.nextLong();   seed19 = random.nextLong();
        seed10 = random.nextLong();  seed20 = random.nextLong(); 
        //new version
        for(int i = 0; i < seeds.length; i++){
            seeds[i] = random.nextLong();
        }

        
    
       
        System.out.println("--- Game Server ---");
        numPlayers = 0; //starting players
        maxPlayers = 2;


        //Initialize Values of p1,p2 w/ same
        p1x =  48 * 18; //tileSize * worldX
        p1y =  48 * 28;
        p1d = "down";
        


        p2x =  48 * 16;
        p2y =  48 * 27; //tileSize * worldY
        p2d = "down";
        
       

        //Instantiate the socket
        try{
            ss = new ServerSocket(55555); //port //2444
        }
        catch(IOException ex){ //Input/Output exceptions (I/O), and they occur whenever an input or output operation is failed or interpreted
            System.out.println("IOException from Game Server Constructor");
        }
    }

    public void randomGeneratedNumbers(){


        //0-10; choose 5;
        Set<Integer> hs = new HashSet<Integer>();

    
        while(hs.size()<1){
        
        int num=(int)(Math.random()*10);
        
        hs.add(num);
        
        }
        
        Iterator it=hs.iterator();
        
        int i = -1;
     
        while(it.hasNext()){
           i++;
           randomGeneratedNumbersArray[i] = (int)it.next();
            //System.out.println(randomGeneratedNumbersArray[i]);
        
        }

        if(randomGeneratedNumbersArray[0] >= 0 && randomGeneratedNumbersArray[0] <= 2 ){
            randomX1 = 10;
            randomY1 = 25;

            //player 1
            randomX1_p1 = 85;
            randomY1_p1 = 57;

            //player 2
            randomX1_p2 = 85;
            randomY1_p2 = 60;


        } else if(randomGeneratedNumbersArray[0] > 2 && randomGeneratedNumbersArray[0] < 4 ){

             //player 1
             randomX1_p1 = 70;
             randomY1_p1 = 96;
 
             //player 2
             randomX1_p2 = 66;
             randomY1_p2 = 98;
 
 

        }
        else if(randomGeneratedNumbersArray[0] >= 4 && randomGeneratedNumbersArray[0] < 6 ){

             //player 1
             randomX1_p1 = 116;
             randomY1_p1 = 83;
 
             //player 2
             randomX1_p2 = 119;
             randomY1_p2 = 82;
 
 

        }
        else if(randomGeneratedNumbersArray[0] >= 6 && randomGeneratedNumbersArray[0] < 8 ){

             //player 1
             randomX1_p1 = 178;
             randomY1_p1 = 114;
 
             //player 2
             randomX1_p2 = 176;
             randomY1_p2 = 114;
 
 

        }else if(randomGeneratedNumbersArray[0] >= 8 && randomGeneratedNumbersArray[0] <= 10 ){

               //player 1
               randomX1_p1 = 85;
               randomY1_p1 = 127;
   
               //player 2
               randomX1_p2 = 89;
               randomY1_p2 = 128;
   

        }



        else{
            randomX1 = 13;
            randomY1 = 25; 
        }
    }

    public void acceptConnections(){ //WTC objects

        try{
            System.out.println("Waiting for connection...");
            while(numPlayers < maxPlayers){
                Socket s = ss.accept(); // tells the server to begin client acception
                DataInputStream in = new DataInputStream(s.getInputStream()); //get input from socket?
                DataOutputStream out = new DataOutputStream(s.getOutputStream()); //get input from socket?

            
                
                
                numPlayers++; //will determine the player no. 
                out.writeInt(numPlayers); //send the current number of num players
                out.writeLong(seed);  
                out.writeLong(seed2); 
                out.writeLong(seed3); 
                out.writeLong(seed4); 
                out.writeLong(seed5); 
                out.writeLong(seed6); 
                out.writeLong(seed7); 
                out.writeLong(seed8); 
                out.writeLong(seed9); 
                out.writeLong(seed10);
                out.writeLong(seed11); 
                out.writeLong(seed12); 
                out.writeLong(seed13); 
                out.writeLong(seed14); 
                out.writeLong(seed15); 
                out.writeLong(seed16); 
                out.writeLong(seed17); 
                out.writeLong(seed18); 
                out.writeLong(seed19); 
                out.writeLong(seed20);
                

                for(int i = 0; i < seeds.length; i++){
                    out.writeLong(seeds[i]);
                }

                


                //trial 
                out.writeInt(randomX1);
                out.writeInt(randomY1);

                out.writeInt(randomX1_p1);
                out.writeInt(randomY1_p1);

                out.writeInt(randomX1_p2);
                out.writeInt(randomY1_p2);
                

                System.out.println("Player no. " + numPlayers + " has connected.");

               
                //create RTC AND WTC objects
                readFromClient rfc = new readFromClient(numPlayers, in); //pass the output/input streams here so that the RFC and WTC objects can access them as wel
                writeToClient wtc = new writeToClient(numPlayers, out);

                if(numPlayers == 1 ){ //This will...
                    p1Socket = s;
                    p1ReadRunnable = rfc;
                    p1WriteRunnable = wtc;

                }
                else{  //once player 2, connected, also player 1 can continue
                    p2Socket = s;
                    p2ReadRunnable = rfc;
                    p2WriteRunnable = wtc;
                    p1WriteRunnable.sendStartMsg();
                    p2WriteRunnable.sendStartMsg();
                    Thread readThreadp1 = new Thread(p1ReadRunnable);
                    Thread readThreadp2 = new Thread(p2ReadRunnable);
                    readThreadp1.start();
                    readThreadp2.start();

                    Thread writeThreadp1 = new Thread(p1WriteRunnable);
                    Thread writeThreadp2 = new Thread(p2WriteRunnable);
                    writeThreadp1.start();
                    writeThreadp2.start();


                }

            }
            System.out.println("Server full. No longer accepting players.");


        }
        catch(IOException ex){
            System.out.println("IOException from Accept Connection Server Constructor");

        }

    }

    //Read is different from Write so we need to create separate threads, otherwise, it could mess with the GUI updates
    //inner class for writing and reading
    private class readFromClient implements Runnable{

        private int playerID; 
        private DataInputStream dataIn;

        public readFromClient(int playerID, DataInputStream dataIn){

            this.playerID = playerID;
            this.dataIn = dataIn;
            System.out.println("RFC " + playerID + "Runnable created.");
        }

        public void run(){ //receive from PlayerFrame

            try{
                while(true){ //constantly receiving
                    if(playerID == 1){
                        p1x = dataIn.readDouble(); //get WorldX's from p1
                        p1y = dataIn.readDouble();
                        p1d = dataIn.readUTF();
                        p1w = dataIn.readBoolean();
                        for(int i = 0; i < so1.length; i++){
                            so1[i] = dataIn.readBoolean();

                        }
                        stonesLeftp1 = dataIn.readInt();
                        completeStoneMsgCheckerp1 = dataIn.readBoolean();
                        earthStoneCheckerp1 = dataIn.readBoolean();
                        fireStoneCheckerp1 = dataIn.readBoolean();
                        airStoneCheckerp1 = dataIn.readBoolean();
                        waterStoneCheckerp1 = dataIn.readBoolean();
                        crystalStoneCheckerp1 = dataIn.readBoolean();
                        stoneCountp1 = dataIn.readInt();
                        lifep1 = dataIn.readInt();


                        for(int i = 0; i < mob_p1s.length; i++){
                            mob_p1s[i] = dataIn.readInt();
                           
                        }

                      
                      

                        p1worldX = dataIn.readDouble();
                        p1worldY = dataIn.readDouble();
                        p1direct = dataIn.readUTF();
                        p1true = dataIn.readBoolean();
                        p1shot = dataIn.readBoolean();

                        for(int i = 0; i < itemp1.length; i++){
                            itemp1[i] = dataIn.readBoolean();

                        }

                        
                         p1shot2 = dataIn.readBoolean();
                         p1shot3 = dataIn.readBoolean();
                         p1shot4 = dataIn.readBoolean();

                         p1win = dataIn.readBoolean();
                         p1dead = dataIn.readBoolean();
                         p1deadchecker = dataIn.readBoolean();
                   

                         for(int i = 0; i < giantmob_p1s.length; i++){
                            giantmob_p1s[i] = dataIn.readInt();
                           
                        }

                        p1startChecker = dataIn.readBoolean();


                    }
                    else{
                        p2x = dataIn.readDouble(); //get WorldX's from p2 
                        p2y = dataIn.readDouble();
                        p2d = dataIn.readUTF();
                        p2w = dataIn.readBoolean();
                        for(int i = 0; i < so2.length; i++){
                            so2[i] = dataIn.readBoolean();

                        }

                        stonesLeftp2 = dataIn.readInt();
                        completeStoneMsgCheckerp2 = dataIn.readBoolean();
                        earthStoneCheckerp2 = dataIn.readBoolean();
                        fireStoneCheckerp2 = dataIn.readBoolean();
                        airStoneCheckerp2 = dataIn.readBoolean();
                        waterStoneCheckerp2 = dataIn.readBoolean();
                        crystalStoneCheckerp2 = dataIn.readBoolean();
                        stoneCountp2 = dataIn.readInt();
                        lifep2 = dataIn.readInt();
                        for(int i = 0; i < mob_p1s.length; i++){
                            mob_p2s[i] = dataIn.readInt();
                           
                        }

                        p2worldX = dataIn.readDouble();
                        p2worldY = dataIn.readDouble();
                        p2direct = dataIn.readUTF();
                        p2true = dataIn.readBoolean();
                        p2shot = dataIn.readBoolean();
                        for(int i = 0; i < itemp2.length; i++){
                            itemp2[i] = dataIn.readBoolean();

                        }
                        p2shot2 = dataIn.readBoolean();
                        p2shot3 = dataIn.readBoolean();
                        p2shot4 = dataIn.readBoolean();

                        p2win = dataIn.readBoolean();
                        p2dead = dataIn.readBoolean();
                        p2deadchecker = dataIn.readBoolean();
                  

                        for(int i = 0; i < giantmob_p1s.length; i++){
                            giantmob_p2s[i] = dataIn.readInt();
                           
                        }

                        p2startChecker = dataIn.readBoolean();


                    }
                }

            
            }catch(IOException e){
                System.out.println("IOException from RFC method");

            }


        }

        } 

        private class writeToClient implements Runnable{  //once nakuha info from RFC, this will send back the info to the PlayerFrame/Client

            private int playerID; 
            private DataOutputStream dataOut;
    
            public writeToClient(int playerID, DataOutputStream dataOut){
    
                this.playerID = playerID;
                this.dataOut = dataOut;
                System.out.println("WTC " + playerID + " Runnable created.");


            }
    
            public void run(){

                try{

                    while(true){ //constantly sending
                        if(playerID == 1){
                            dataOut.writeDouble(p2x);
                            dataOut.writeDouble(p2y);
                            dataOut.writeUTF(p2d);
                            dataOut.writeBoolean(p2w);
                            dataOut.writeInt(1);

                            for(int i = 0; i < so2.length; i++){
                                dataOut.writeBoolean(so2[i]);
    
                            }

                            dataOut.writeInt(stonesLeftp2);
                            dataOut.writeBoolean(completeStoneMsgCheckerp2);
                            dataOut.writeBoolean(earthStoneCheckerp2);
                            dataOut.writeBoolean(fireStoneCheckerp2);
                            dataOut.writeBoolean(airStoneCheckerp2);
                            dataOut.writeBoolean(waterStoneCheckerp2);
                            dataOut.writeBoolean(crystalStoneCheckerp2);
                            dataOut.writeInt(stoneCountp2);
                            dataOut.writeInt(lifep2);

                            for(int i = 0; i < mob_p1s.length; i++){
                                dataOut.writeInt(mob_p2s[i]);
                               
                            }

                           
                            dataOut.writeDouble(p2worldX);
                            dataOut.writeDouble(p2worldY);
                            dataOut.writeUTF(p2direct);
                            dataOut.writeBoolean(p2true);
                            dataOut.writeBoolean(p2shot);

                            for(int i = 0; i < itemp2.length; i++){
                                dataOut.writeBoolean(itemp2[i]);
    
                            }

                            dataOut.writeBoolean(p2shot2);
                            //                    //    private boolean p1shot2, p2shot2;

                            dataOut.writeBoolean(p2shot3);
                            dataOut.writeBoolean(p2shot4);
                            dataOut.writeBoolean(p2win);

                            dataOut.writeBoolean(p2dead);
                            dataOut.writeBoolean(p2deadchecker);

                       
                            for(int i = 0; i < giantmob_p1s.length; i++){
                                dataOut.writeInt(giantmob_p2s[i]);
                               
                            }
                            dataOut.writeBoolean(p2startChecker);




                            dataOut.flush();

                        }else{
                            dataOut.writeDouble(p1x);
                            dataOut.writeDouble(p1y);
                            dataOut.writeUTF(p1d);
                            dataOut.writeBoolean(p1w);
                            dataOut.writeInt(1);
                            for(int i = 0; i < so1.length; i++){
                                dataOut.writeBoolean(so1[i]);
    
                            }
                            dataOut.writeInt(stonesLeftp1);
                            dataOut.writeBoolean(completeStoneMsgCheckerp1);
                            dataOut.writeBoolean(earthStoneCheckerp1);
                            dataOut.writeBoolean(fireStoneCheckerp1);
                            dataOut.writeBoolean(airStoneCheckerp1);
                            dataOut.writeBoolean(waterStoneCheckerp1);
                            dataOut.writeBoolean(crystalStoneCheckerp1);
                            dataOut.writeInt(stoneCountp1);
                            dataOut.writeInt(lifep1);
                            for(int i = 0; i < mob_p1s.length; i++){
                                dataOut.writeInt(mob_p1s[i]);
                               
                            }

                            dataOut.writeDouble(p1worldX);
                            dataOut.writeDouble(p1worldY);
                            dataOut.writeUTF(p1direct);
                            dataOut.writeBoolean(p1true);
                            dataOut.writeBoolean(p1shot);

                            for(int i = 0; i < itemp1.length; i++){
                                dataOut.writeBoolean(itemp1[i]);
    
                            }

                            dataOut.writeBoolean(p1shot2);
                            dataOut.writeBoolean(p1shot3);
                            dataOut.writeBoolean(p1shot4);
                            dataOut.writeBoolean(p1win);

                            dataOut.writeBoolean(p1dead);
                            dataOut.writeBoolean(p1deadchecker);

                      
                            for(int i = 0; i < giantmob_p2s.length; i++){
                                dataOut.writeInt(giantmob_p1s[i]);
                               
                            }

                            dataOut.writeBoolean(p1startChecker);

                            dataOut.flush();
                        }

                        try{
                            Thread.sleep(25);
                        }
                        catch(InterruptedException ex){
                            System.out.println("InterruptedException from WTC method");
                        }
                    }

                }catch(IOException ex){

                    System.out.println("IOException from WTC method");
                    System.exit(0);
           

                }
            
    

            }

            public void sendStartMsg(){
                try{

                    dataOut.writeUTF("We now have 2 players. Starting GUIs...");

                    
                }catch(IOException ex){
                    System.out.println("IOException from sendStartMsg");

                }
            }
    
            }  


    public static void main(String[] args){ //instantiate gameserver

        GameServer gs = new GameServer();
        gs.acceptConnections();


    }

}
