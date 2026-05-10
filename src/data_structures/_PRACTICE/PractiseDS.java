package data_structures._PRACTICE;

import java.util.*;
import java.util.stream.Collectors;

public class PractiseDS {
    static void main(String[] args){
        //Strings
        String p0="Hello"; //reuses the string pool
        String p=new String("Hello"); //creates a new object

        String ps=p0+"/ pes"+", ohm";

        char[] ch=p.toCharArray();
        for (char c: ch){
            System.out.println(c);
        }
        p=p.replaceFirst(String.valueOf(p.charAt(3)),"1");
        System.out.println(p);
        p=p.replace(p.charAt(3),'0');
        System.out.println(p);
        System.out.println(p0.contains("el"));
        ps=ps.replaceAll("[^a-zA-Z0-9]"," ");
        ps=ps.trim();
        System.out.println(ps);

        //Arrays

        int[] arr={2,4,65,8};

        int[] arr2=new int[10];
        arr[0]=0;
        for(int i=0;i<arr2.length;i++){
            arr2[i]=i;
        }

        int[] arr3=new int[arr2.length+1];
        for(int i=0;i<arr2.length;i++){
            arr3[i]=arr2[i];
        }
        arr3[arr3.length-1]=27;

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr3));


        //Lists
        List<Integer> l1=new ArrayList<>();
        List<Integer> l2=new ArrayList<>(Arrays.asList(1,2,3,4));
        List<Integer> l3=Arrays.asList(2,3,4,5); //Fixed size → cannot add/remove (but can update)
        List<Integer> l4=List.of(4,5,6,7);  //Immutable
        List<Integer> l5=new LinkedList<>();
        List<Integer> copyOfl2=new ArrayList<>(l2);

        l1.add(2);
        l1.add(1,4);
        l1.addAll(l3);

        l5.add(7);
        l5.add(1,9);

        l5.addAll(l1);

        l1.remove(1);
        l1.remove(Integer.valueOf(2));
        l5.removeAll(l1);
        l5.clear();

        l2.set(1,21);

        System.out.println(l2.get(1));
        System.out.println(l2.contains(6));
        System.out.println(l2.indexOf(6));
        System.out.println(l2.isEmpty());
        for (Integer integer : l2) {
            System.out.print(integer+" ");
        }

        System.out.println();
        Iterator<Integer> it=l2.iterator();

        while(it.hasNext()){
            System.out.print(it.next()+" ");
        }
        System.out.println();

        ListIterator<Integer> lit=l2.listIterator();
        while(lit.hasNext()){
            System.out.print(lit.next()+" ");
        }
        System.out.println();
        while(lit.hasPrevious()){
            System.out.print(lit.previous()+" ");
        }

        System.out.println();

        l2.forEach(System.out::print);
        System.out.println();

        l2.stream().forEach(System.out::print);

        //Set

        Set<Integer> s1=new HashSet<>();
        Set<Integer> s2=new HashSet<>(Arrays.asList(1,2,3));
        Set<Integer> s3=Set.of(2,3,4); //Immutable, for duplicates throws exception
        Set<Integer> s4=new LinkedHashSet<>();//maintains insertion order
        Set<Integer> s5=new TreeSet<>(); //sorted in ascending order, throws exception for duplicate
        Set<Integer> copyOfS2=new HashSet<>(s2);
        Set<Integer> copyOfS2ByStream=s2.stream().collect(Collectors.toSet());

        s2.add(81);
        s2.addAll(s3);
        s2.remove(81);
        s2.removeAll(s3);
        s2.contains(5);
        //Intersection
        s2.retainAll(s3);

        //Union
        s2.addAll(s3);

        //Difference
        s2.removeAll(s3);

        //iteraion on set
        /* SAME AS LISTS */

        //Map
        Map<Integer,Integer> m1=new HashMap<>();// no order
        Map<Integer,Integer> m2=Map.of(1,2,2,4); //Immutable, null not allowed, duplicate key exception
        Map<Integer,Integer> m3=Map.ofEntries(
                Map.entry(2,5),
                Map.entry(3,8)

        );

        Map<Integer,Integer> m4=new LinkedHashMap<>(); // insertion order
        Map<Integer,Integer> m5=new TreeMap<>(); //ascending order of keys
        Map<Integer,Integer> copyOfM2=new HashMap<>(m2);

        m2.put(3,5);
        m2.put(3,6);
        m2.putIfAbsent(4,5);
        m2.remove(3);
        m2.remove(4,5);
        m2.get(2);
        m2.getOrDefault(3,0);
        m2.containsKey(3);
        m2.containsValue(5);
        m2.size();
        m2.isEmpty();

        for(Map.Entry<Integer,Integer> entry:m2.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }

        for (Integer key: m2.keySet()){
            System.out.println(key+" "+m2.get(key)); //less efficient due to extra lookup
        }

        for(Integer value: m2.values()){
            System.out.println(value);
        }

        Iterator<Map.Entry<Integer,Integer>> mapIt=m2.entrySet().iterator();
        while(mapIt.hasNext()){
            Map.Entry<Integer,Integer> entry=mapIt.next();
            System.out.println(entry.getKey()+" "+entry.getValue());
        }

        m2.forEach((k,v)->System.out.println(k+" "+v));
        m2.replace(1,10);
        m2.replace(1,2,10);

        m2.compute(1,(k,v)->v==null?1:v+1);
        m2.computeIfAbsent(1,k->10);

        m2.merge(2,1,Integer::sum);// if 2 not present then add 2,1; else add 1 to old value of 2

        //queues
        Queue<Integer> q1=new LinkedList<>();
        Queue<Integer> qu = new LinkedList<>(Arrays.asList(1, 2, 3));
        Queue<Integer> q2=new ArrayDeque<>();// no null allowed
        Queue<Integer> q3=new PriorityQueue<>();//minHeap sorting, first is smallest.

        q1.add(1); //throw exception if fails
        q1.offer(2); // return fales if fails
        qu.add(4);
        qu.offer(5);
        q2.add(4);
        q2.offer(6);
        q2.remove(2);// removes head, throws exception if emtpy
        q2.poll();// removes head, returns null if empty

        q2.element();// throws exception if empty
        q2.peek();// returns null if empty

        q2.size();
        q2.isEmpty();

        for(int i:q2){
            System.out.println(i);
        }

        Iterator<Integer> it2=q2.iterator();
        while(it2.hasNext()){
            System.out.println(it2.next());
        }

        q2.forEach(System.out::println);

        //Trees
        /*
        for custom trees -> check Trees DS
        for TreeSet and TreeMap check collection framework DS
         */

        //graphs
        /*
        - Bellman-Ford vs Dijkstra
        - Graphs are non-linear data structures best represented using adjacency lists in Java,
          and most real-world problems revolve around BFS, DFS, shortest path, and cycle detection.
        - Internal Concepts
            🔹 BFS uses Queue
            Level-order traversal
            🔹 DFS uses Stack / Recursion
            🔹 Dijkstra uses PriorityQueue
         - When to Use What?
            Use BFS → shortest path (unweighted)
            Use DFS → cycle detection, connectivity
            Use Dijkstra → weighted shortest path
            Use Topo Sort → dependency resolution
         */
    }
}
