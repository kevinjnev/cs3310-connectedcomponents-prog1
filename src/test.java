import java.io.*;
import java.util.Scanner;

public class test {
    

    public static void main(String[] args) throws Exception {
        
        File file = new File("D:/school/CS3310 Project 1/lib/SampleInput.txt");
        
        try (Scanner scanner = new Scanner(file)) 
        {
            int n = scanner.nextInt();
            int[][] inputarray = new int[n][n];
            System.out.println(inputarray);
            int arraynode1;
            int arraynode2;
            while (scanner.hasNext()) 
            {
                while (!scanner.hasNextInt() && scanner.hasNext()) 
                {
                    scanner.next();
                }
                
                arraynode1 = scanner.nextInt();
                
                while (!scanner.hasNextInt() && scanner.hasNext()) 
                {
                    scanner.next();
                }
                
                arraynode2 = scanner.nextInt();

                inputarray[arraynode1][arraynode2] = 1;
            }

        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
    
    }


}