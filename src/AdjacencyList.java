import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

class AdjacencyList {
    private HashMap<Integer, Vertex> graph = new HashMap<Integer, Vertex>();
    private String lineNum;

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

    public void createGraph() {
        //File file = new File("D:/school/CS3310 Project 1/lib/SampleInput.txt");

        try (Scanner scanner = new Scanner(getLine())) {
            scanner.useDelimiter("\\D");
            int sizeOfGraph = 0;
            
            sizeOfGraph = scanner.nextInt();  //takes in the first integer at the start of the line as an int into n, this will give us the size of the matrix later
            
            addAllVertices(sizeOfGraph); //I could've just put scanner.nextInt() here but I wanted to make it a bit clearer what what happening
            //

            int node1 = 0;
            int node2 = 0;
            
            while (scanner.hasNext()) {
                if (!scanner.hasNextInt()) {
                    scanner.next(); 
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
    public void dfsSearch(HashMap<Integer, Vertex> graph) { //return lists of connected components, make a new list for each component
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