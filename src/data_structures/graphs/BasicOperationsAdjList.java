package data_structures.graphs;

import java.util.*;

public class BasicOperationsAdjList {
    static Map<Integer, List<Integer>> adjList= new HashMap<>();

    static void main(String[] args) {
        for (int i=0;i<9;i++) {
            addVertex(i);
        }

    }

    public static void addVertex(int val) {
        List<Integer> newList = new ArrayList<>();
        adjList.put(val,newList);
    }

    public static void removeVertex(int val) {
        if (!adjList.containsKey(val)){
            throw new RuntimeException("Value does not exist!!");
        }
        adjList.remove(val);
        for (List<Integer> row: adjList.values()) {
            row.remove(Integer.valueOf(val));
        }
    }

    public static void print() {
        for(Map.Entry<Integer,List<Integer>> e : adjList.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }
    }
}
