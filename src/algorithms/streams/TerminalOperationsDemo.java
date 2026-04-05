package algorithms.streams;

import java.util.*;
import java.util.stream.*;

public class TerminalOperationsDemo {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        // forEach
        list.stream().forEach(x -> System.out.println("forEach: " + x));

        // collect
        List<Integer> collected =
                list.stream()
                        .filter(x -> x > 2)
                        .collect(Collectors.toList());
        System.out.println("collect: " + collected);

        // count
        long count = list.stream().count();
        System.out.println("count: " + count);

        // reduce
        int sum = list.stream().reduce(0, Integer::sum);
        System.out.println("reduce (sum): " + sum);

        // findFirst
        Optional<Integer> first =
                list.stream().findFirst();
        System.out.println("findFirst: " + first.get());

        // anyMatch
        boolean anyMatch =
                list.stream().anyMatch(x -> x > 3);
        System.out.println("anyMatch (>3): " + anyMatch);

        // allMatch
        boolean allMatch =
                list.stream().allMatch(x -> x > 0);
        System.out.println("allMatch (>0): " + allMatch);

        // noneMatch
        boolean noneMatch =
                list.stream().noneMatch(x -> x < 0);
        System.out.println("noneMatch (<0): " + noneMatch);
    }
}
