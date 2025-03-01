/**************************************************************/
/* Kevin Nevarez                                              */
/* Email: kjnevarez@cpp.edu                                   */
/* CS 3310, Spring 2025                                       */
/* Programming Assignment 1                                   */
/* Prog1 class: main class that runs the program              */
/**************************************************************/

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class Prog1 {
    public static void main(String[] args) throws Exception {
        File fileForLines = new File("SampleInput.txt");
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