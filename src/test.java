import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class test {
    

    public static void main(String[] args) throws Exception {
        
        System.out.println("works");
        File file = new File("D:/school/CS3310 Project 1/lib/SampleInput.txt");
        
        try (Scanner scanner = new Scanner(file)) {
            
            int n = 0;
            n = scanner.nextInt();  //takes in the first integer at the start of the line as an int into n, 
            System.out.println(n);  //this will give us the size of the matrix later
/* 
            while(scanner.hasNext()) {
                if(scanner.hasNextInt()) {
                    n = scanner.nextInt();
                }
            }
*/
            int[][] inputarray = new int[n][n];
            //System.out.println(inputarray);
            int arraynode1;
            int arraynode2;
            String patterntoskip = "\\p{Punct}";
            

            while (scanner.hasNext()) {
                while (!scanner.hasNextInt() & scanner.hasNext()) {
                    System.out.print(scanner.next());
                }
                
                arraynode1 = scanner.nextInt();
                
                while (!scanner.hasNextInt() & scanner.hasNext()) {
                    scanner.next();
                }
                
                arraynode2 = scanner.nextInt();

                inputarray[arraynode1][arraynode2] = 1;
            }
            for (int[] x : inputarray) {
                for (int y : x) {
                    System.out.print(y + " ");
                }
                System.out.println();
            }
            scanner.close();
        } 
        catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
    
    }


}

//use pattern to skip the parentheses and commas, i think then it would just need to get next ints