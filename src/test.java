import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
class Vertex {
    
    private List<Integer> neighborList = new ArrayList<Integer>(); //list of adjacent vertexs
    private boolean marked = false; //flag for if the vertex has been traveled to
    
    //to add an edge, take the first number/vertex and add the second vertex to its' neighbors, then add that first vertex to the second's neighbors

    public void addNeighbor(int neighbor) {
        neighborList.add(neighbor);
    }
    public boolean traveledTo() {
        return marked;
    }

}
class AdjacencyList {
    private HashMap<Integer, Vertex> graph = new HashMap<Integer, Vertex>();
    
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
     //figure out how to work this


    public void createGraph() {
        
        File file = new File("D:/school/CS3310 Project 1/lib/SampleInput.txt");

        try (Scanner scanner = new Scanner(file)) {
            scanner.useDelimiter("\\D");
            int sizeOfGraph = 7;
            sizeOfGraph = scanner.nextInt();  //takes in the first integer at the start of the line as an int into n, 
            System.out.println(sizeOfGraph);  //this will give us the size of the matrix later
            
            addAllVertices(sizeOfGraph);

            int node1 = 0;
            int node2 = 0;
            
            while (scanner.hasNext()) {
                if (!scanner.hasNextInt()) {
                    System.out.print(scanner.next()); 
                }
                else {
                    node1 = scanner.nextInt(); //first node in the pair is node1
                    node2 = scanner.nextInt(); //second node in the pair is node2
                    
                    graph.get(node1).addNeighbor(node2); //add node2 to node1's neighbor list
                    graph.get(node2).addNeighbor(node1); //add node1 to node2's neighbor list
                }
                
            }

            for (Integer key : graph.keySet()) {
                System.out.println("Key: " + key + ", Value: " + graph.get(key));
            }
            
            scanner.close();
        } 
        catch (FileNotFoundException err) {
            System.err.println("File not found: " + err.getMessage());
        }
    }
    public void dfsSearch(HashMap<Integer, Vertex> graph) { //return lists of connected components, make a new list for each component
        
    }


    
}

public class test {
    public static void main(String[] args) throws Exception {
        
        AdjacencyList tester = new AdjacencyList();
        tester.createGraph();

        //have a scanner for the file that checks if there is a line to read, then creates a new adjacency list if there is
        //have a list of adjacency lists maybe? makes it easy to create a new one with list[n] = new adjacencyList(); and to iterate through it for the dfs calls


        //scanner next line
        //while there is a next line, create a new adjacency list 
        //close scanner
        //do dfs on each adjacency list
        //output
        
    
    }


}

//use pattern to skip the parentheses and commas, i think then it would just need to get next ints
//in main check how many lines there are, then make however many adjacency lists then make their graphs
