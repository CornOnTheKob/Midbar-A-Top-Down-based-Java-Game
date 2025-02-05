import java.util.HashSet;
import java.util.Set;
import java.io.*;
import java.net.*;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.Iterator;


public class trial {
    
    private static int[] randomGeneratedNumbersArray;

    public static void main(String[] args){
        
        randomGeneratedNumbersArray = new int[5];
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
            System.out.println(randomGeneratedNumbersArray[i]);
        
        }

    }

}
