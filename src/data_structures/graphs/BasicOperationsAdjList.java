package data_structures.graphs;

import java.util.*;

public class BasicOperationsAdjList {
    static Map<Integer, List<Integer>> adjList= new HashMap<>();

    static void main(String[] args) {
        for (int i=0;i<9;i++) {
            addVertex(i);
        }

        addEdge(0,1);
        addEdge(0,3);
        addEdge(1,2);
        addEdge(1,4);
        addEdge(2,5);
        addEdge(3,4);
        addEdge(3,6);
        addEdge(4,5);
        addEdge(4,7);
        addEdge(5,8);
        addEdge(6,7);
        addEdge(7,8);

        System.out.println("Actual graph:::::::::::::");
        print();


    }
    /*
     * Adds a new vertex to the graph.
     * In an adjacency list representation, each vertex
     * maps to a list of its neighboring vertices.
     */
    public static void addVertex(int val) {

        /*
         * Create a new empty list that will store
         * all the neighbors of this vertex.
         */
        List<Integer> newList = new ArrayList<>();

        /*
         * Insert the vertex into the adjacency list map.
         * Key   -> vertex value
         * Value -> list of connected vertices
         *
         * Example after insertion:
         * 5 -> []
         */
        adjList.put(val, newList);
    }


    /*
     * Removes a vertex from the graph.
     * This requires two operations:
     * 1. Remove the vertex itself.
     * 2. Remove all edges pointing to this vertex.
     */
    public static void removeVertex(int val) {

        /*
         * Check if the vertex exists in the graph.
         * If not, throw an exception to avoid invalid operations.
         */
        if (!adjList.containsKey(val)){
            throw new RuntimeException("Value does not exist!!");
        }

        /*
         * Remove the vertex and its adjacency list.
         *
         * Example:
         * 5 -> [2,7]
         *
         * After removal:
         * vertex 5 disappears from the graph.
         */
        adjList.remove(val);

        /*
         * Now remove all edges pointing TO this vertex.
         * Since other vertices may have 'val' in their neighbor lists,
         * we must iterate through all adjacency lists.
         */
        for (List<Integer> row : adjList.values()) {

            /*
             * Remove the vertex value from the neighbor list.
             * Integer.valueOf(val) ensures that the value is removed
             * instead of treating it as an index.
             */
            row.remove(Integer.valueOf(val));
        }
    }


    /*
     * Prints the graph using adjacency list format.
     */
    public static void print() {

        /*
         * Iterate through each entry in the adjacency list map.
         *
         * Map.Entry contains:
         * key   -> vertex
         * value -> list of neighbors
         */
        for(Map.Entry<Integer, List<Integer>> e : adjList.entrySet()) {

            /*
             * Print vertex and its connected neighbors.
             *
             * Example output:
             * 1 -> [2, 3]
             * 2 -> [1]
             */
            System.out.println(e.getKey() + " -> " + e.getValue());
        }
    }

    //val1, val2 are values(not indices)
    public static void addEdge(int val1,int val2) {
        if (!adjList.containsKey(val1) || !adjList.containsKey(val2) || val1==val2){
            throw new IllegalArgumentException();
        }
        adjList.get(val1).add(val2);
        adjList.get(val2).add(val1);
    }

    public static void removeEdge(int val1, int val2) {
        if (!adjList.containsKey(val1) || !adjList.containsKey(val2) || val1==val2){
            throw new IllegalArgumentException();
        }
        adjList.get(val1).remove(Integer.valueOf(val2));
        adjList.get(val2).remove(Integer.valueOf(val1));
    }

}
