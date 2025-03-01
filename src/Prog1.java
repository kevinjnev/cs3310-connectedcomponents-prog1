import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class Prog1 {
    public static void main(String[] args) throws Exception {
        File fileForLines = new File("D:/school/CS3310 Project 1/lib/SampleInput.txt");
        int graphNum = 1;
        try (Scanner scan = new Scanner(fileForLines)) {
            do{
                System.out.print("Graph " + graphNum + " = ");
                AdjacencyList adjList = new AdjacencyList();
                adjList.setLine(scan.nextLine());
                adjList.createGraph();
                adjList.dfsSearch(adjList.returnGraph());
                graphNum++;
            } while(scan.hasNextLine());
            
            scan.close();
        }

        catch (FileNotFoundException err) {
            System.err.println("File not found: " + err.getMessage());
        }
    }
}