package data_structures.graphs;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

/*
 * This class demonstrates basic operations on a Graph using
 * an Adjacency Matrix representation.
 *
 * Adjacency Matrix:
 * A 2D matrix where rows and columns represent vertices.
 * If an edge exists between vertex i and vertex j, the cell (i,j)
 * will contain 1 (or weight), otherwise 0.
 */
public class BasicOperationsAdjMatrix {

    // List to store all vertices of the graph
    static List<Integer> vertices = new ArrayList<>();

    // 2D structure representing the adjacency matrix
    // Each row represents connections from one vertex to others
    static List<List<Integer>> adjMatrix = new ArrayList<>();

    static void main(String[] args){

        /*
         * Randomly add vertices until the graph contains 4 vertices.
         * Each vertex value is a random number between 1 and 10.
         */
        while(vertices.size() < 4){
            addVertex(((int) (Math.random() * 10)) + 1);
        }
        addEdge(1, 3);
        addEdge(2, 0);
        addEdge(3, 0);

        print();

        removeVertex(1);
        print();

        removeEdge(0,2);
        print();

    }

    /*
     * Adds a new vertex to the graph and updates the adjacency matrix.
     */
    public static void addVertex(int val) {

        // Get the current number of vertices before adding the new one
        int n = size();

        // Add the vertex to the vertex list
        vertices.add(val);

        /*
         * Create a new row for the adjacency matrix.
         * Initially all connections are 0 (no edges).
         */
        List<Integer> newRow = new ArrayList<>(n);

        for (int num = 0; num < n; num++){
            newRow.add(0);
        }

        // Add the new row to the adjacency matrix
        adjMatrix.add(newRow);

        /*
         * Now every existing row must get one extra column
         * because the matrix size increases when a new vertex is added.
         *
         * Example:
         * Before adding vertex:
         * 0 0
         * 0 0
         *
         * After adding vertex:
         * 0 0 0
         * 0 0 0
         * 0 0 0
         */
        for (List<Integer> row : adjMatrix) {
            row.add(0);
        }
    }

    /*
     * Returns the current number of vertices in the graph
     */
    public static int size(){
        return vertices.size();
    }

    public static void removeVertex(int index) {
        if (index> size()) {
            throw new IndexOutOfBoundsException();
        }
        vertices.remove(index);
        adjMatrix.remove(index);
        for (List<Integer> listRow : adjMatrix){
            listRow.remove(index);
        }
    }

    //i,j are indices
    public static void addEdge(int i, int j) {
        if (i<0 || j<0 || i==j || i>size() || j>size()) {
            throw new IndexOutOfBoundsException();
        }
        adjMatrix.get(i).set(j,1);
        adjMatrix.get(j).set(i,1);
    }

    //i,j are indices
    public static void removeEdge(int i, int j) {
        if (i<0 || j<0 || i==j || i>size() || j>size()) {
            throw new IndexOutOfBoundsException();
        }
        adjMatrix.get(i).set(j,0);
        adjMatrix.get(j).set(i,0);
    }

    public static void print(){
        System.out.println("Graph::::::");
        System.out.println(vertices);

        for (List<Integer> row: adjMatrix) {
            System.out.println(row);
        }
    }

}
