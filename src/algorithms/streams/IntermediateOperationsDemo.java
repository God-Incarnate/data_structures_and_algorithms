package algorithms.streams;

import java.util.*;
import java.util.stream.*;

public class IntermediateOperationsDemo {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(5, 2, 8, 1, 3, 2, 4);

        List<Integer> result = list.stream()
                .filter(x -> x > 2)          // filter
                .map(x -> x * 2)             // map
                .distinct()                  // remove duplicates
                .sorted()                   // ascending sort
                .peek(x -> System.out.println("Processing: " + x)) // debug
                .limit(4)                   // limit
                .skip(1)                    // skip
                .collect(Collectors.toList()); // terminal (trigger)

        System.out.println("Final Result: " + result);
    }
}
