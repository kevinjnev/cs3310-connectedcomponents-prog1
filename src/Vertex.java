import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class Vertex {    
    private ArrayList<Integer> neighborList = new ArrayList<Integer>(); //list of adjacent vertexs
    private boolean marked = false; //flag for if the vertex has been traveled to
    
    public ArrayList<Integer> returnNeighbors() {
        return neighborList;
    }

    public void addNeighbor(int neighbor) {
        neighborList.add(neighbor);
    }
    public boolean traveledTo() {
        return marked;
    }
    public void markTraveled() {
        marked = true;
    }
}