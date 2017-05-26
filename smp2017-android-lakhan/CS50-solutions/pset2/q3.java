/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;
*/
//import for Scanner and other utility  classes
import java.util.*;
import java.io.*;


class TestClassQ3 {
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
*/
        //Scanner
        Scanner s = new Scanner(System.in);
        String W = s.nextLine(); 
        
        for (int i = 0; i < W.length(); i++) 
        {
          
           char[] chararray = W.toCharArray();
           if(W!=NULL)
            {
              if(chararray[i]>='A' && chararray[i]<='Z')
                chararray[i] = chararray[i].toUpperCase();

             if(chararray[i]>='a' && chararray[i]<='z')
                chararray[i] = chararray[i].toLowerCase();
               
            }
        }
  
        for(int j =0;j<W.length();j++)
           System.out.println(chararray[j]); 

    }
}