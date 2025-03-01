/************************************************************************/
/* Kevin Nevarez                                                        */
/* Email: kjnevarez@cpp.edu                                             */
/* CS 3310, Spring 2025                                                 */
/* Programming Assignment 1                                             */
/* AdjacencyList class: holds methods relating to the list and search   */
/************************************************************************/

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

class AdjacencyList {
    private HashMap<Integer, Vertex> graph = new HashMap<Integer, Vertex>();
    private String lineNum;



    //
    public HashMap<Integer, Vertex> returnGraph() {
        return graph;
    }

    public void addVertex(int vertNum) {
        graph.putIfAbsent(vertNum, new Vertex());
    }

    public void addAllVertices(int numOfVertices) {
        int n = numOfVertices;
        while(!(n == 0)) {
            addVertex(n);
            n--;
        }
    }

    public void setLine(String line) {
        lineNum = line;
    }
    public String getLine() {
        return lineNum;
    }

    /******************************************************************************************************/
    /* Method: createGraph                                                                                */
    /* Purpose: Using scanner, intake the numbers for input as nodes, add each pair of nodes as neighbors */
    /* for each other.                                                                                    */
    /* This creates the undirected graph as an adjacency list using a HashMap                             */
    /* of integers that have a Vertex as their value that holds the neighbor information and visit state. */
    /*                                                                                                    */
    /* Returns: void, the graph is accessed through other means later                                     */
    /******************************************************************************************************/

    public void createGraph() {
        try (Scanner scanner = new Scanner(getLine())) {
            scanner.useDelimiter("\\D");
            int sizeOfGraph = 0; //This int holds the number of vertices in the graph, which is used in addAllVertices
                                 //to create enough Vertex classes for the whole graph.
            
            
            sizeOfGraph = scanner.nextInt();  //takes in the first integer at the start of the line as an int into n, this will give us the size of the matrix later
            
            addAllVertices(sizeOfGraph); //I could've just put scanner.nextInt() here but I wanted to make it a bit clearer what what happening
            //

            //These two int nodes will hold the integer pair inputs from the input file, and each pair will become
            //each other's neighbor in the graph. Initialized to 0 for later changing.
            int node1 = 0; 
            int node2 = 0;
            
            while (scanner.hasNext()) { //while there is something on the line for scanner to read
                if (!scanner.hasNextInt()) { //if there is no integer next
                    scanner.next(); //go to the next thing for scanner to read
                }

                else {
                    node1 = scanner.nextInt(); //first node in the pair is node1
                    node2 = scanner.nextInt(); //second node in the pair is node2
                    graph.get(node1).addNeighbor(node2); //add node2 to node1's neighbor list
                    graph.get(node2).addNeighbor(node1); //add node1 to node2's neighbor list
                }
            }
            scanner.close();
        } 

    }
    
    //This DFS search method takes the graph and looks at each Vertex, if it has been visited it will not create a new connected
    //component. If it has been visited it creates a new connected component and calls the recursiveDFS method.
    //RecursiveDFS will search all of that connected components neighbors to map that component out.
    public void dfsSearch(HashMap<Integer, Vertex> graph) {
        ArrayList<ArrayList<Integer>> listOfComps = new ArrayList<ArrayList<Integer>>();
        for (Integer key: graph.keySet()) {
            if (!graph.get(key).traveledTo()) {
                ArrayList<Integer> connectedComp = new ArrayList<Integer>();
                recursiveDfs(graph, key, connectedComp);
                listOfComps.add(connectedComp);
            }
        }
        printList(listOfComps);
    }

    public void printList(ArrayList<ArrayList<Integer>> componentList) {
        System.out.println(componentList.size() + " Connected Components: " + componentList);
    }

    public void recursiveDfs(HashMap<Integer, Vertex> graph, Integer key, ArrayList<Integer> connectedComp) {
        
        graph.get(key).markTraveled();
        connectedComp.add(key);
        
        for(Integer neighbor: graph.get(key).returnNeighbors()){
            if(!graph.get(neighbor).traveledTo()) {
                recursiveDfs(graph, neighbor, connectedComp);
            }   
        }
    }
}