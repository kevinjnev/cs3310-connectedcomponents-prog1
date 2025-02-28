import java.io.*;
import java.util.Scanner;



public class test {
    

    public static void main(String[] args) throws Exception {
        
        System.out.println("works");
        File file = new File("D:/school/CS3310-Project-1/lib/SampleInput.txt");
        
        try (Scanner scanner = new Scanner(file)) {
            scanner.useDelimiter("\\D");
            int n = 0;
            n = scanner.nextInt();  //takes in the first integer at the start of the line as an int into n, 
            System.out.println(n);  //this will give us the size of the matrix later

            int[][] inputarray = new int[n][n];
            
            int arraynode1 = 0;
            int arraynode2 = 0;
            
            int i = 0;

            while (scanner.hasNext()) {
                while (!scanner.hasNextInt()) {
                    System.out.print(scanner.next());
                }
                if(i % 2 == 0) {
                    arraynode1 = scanner.nextInt();
                }
                else {
                    arraynode2 = scanner.nextInt();
                }
                inputarray[arraynode1][arraynode2] = 1;
                i++;
            }

            for (int[] x : inputarray) {
                for (int y : x) {
                    System.out.print(y + " ");
                }
                System.out.println();
            }
            scanner.close();
        } 
        catch (FileNotFoundException err) {
            System.err.println("File not found: " + err.getMessage());
        }
    
    }


}

//use pattern to skip the parentheses and commas, i think then it would just need to get next ints