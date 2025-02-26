import java.io.*;
import java.util.Scanner;

public class Prog1 {
    static int[] inputArray; {
        //need to read input
        File file = new File("SampleInput.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                System.out.println(number);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
/*
        while(scanFile.hasNext()) {
            if (!scanFile.hasNextInt()) {
                 scanFile.next();
                 continue;
            }
        
            System.out.println(scanFile.nextInt());

*/
        int[] adjmatrix = new int[n]; //makes a matrix initialized with 0, size n x n
        while(i = 0;i < n; i++) { //this loops until it reaches the number of nodes that n said would be given in the input

        }
    }


    public static void main(String[] args) throws Exception {
        //in here call the input and create array function
        //call search function
        //print connected components
    }
}

//first input is the number of vertices, n
//create an array of size nxn with all elements being 0
//This will be the adjacency matrix, 0 means no connection, 1 means there is a connection

//need a function to add a connection between elements

//once done adding connections, need to search through the array for connected components
//until number of searched elements is zero
    //use a dfs to search through the vertices
        //put each connected element into a list
        //if an element has no connections it is in its own connected component list
    //if there is no unsearched elements, done searching

