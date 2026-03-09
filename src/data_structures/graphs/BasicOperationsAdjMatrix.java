package data_structures.graphs;

import java.util.ArrayList;
import java.util.List;

public class BasicOperationsAdjMatrix {
    static List<Integer> vertices=new ArrayList<>();
    static List<List<Integer>> adjMatrix=new ArrayList<>();

    static void main(String[] args){
        while(vertices.size()<4){
            addVertex(((int) (Math.random() * 10))+1);
        }

    }

    public static void addVertex(int val) {
        int n=size();
        vertices.add(val);
        List<Integer> newRow = new ArrayList<>(n);
        for (int num=0;num<n;num++){
            newRow.add(0);
        }
        adjMatrix.add(newRow);

        for (List<Integer> row: adjMatrix) {
            row.add(0);
        }
    }
    public static int size(){
        return vertices.size();
    }



}
