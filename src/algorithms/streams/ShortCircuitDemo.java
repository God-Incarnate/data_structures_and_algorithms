package algorithms.streams;

import java.util.*;
import java.util.stream.*;

public class ShortCircuitDemo {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(2, 4, 6, 7, 8, 10);

        // findFirst (stops early)
        Optional<Integer> firstOdd =
                list.stream()
                        .filter(x -> {
                            System.out.println("Checking: " + x);
                            return x % 2 != 0;
                        })
                        .findFirst();

        System.out.println("First Odd: " + firstOdd.orElse(null));

        System.out.println("------------");

        // anyMatch (stops when condition is true)
        boolean hasOdd =
                list.stream()
                        .anyMatch(x -> {
                            System.out.println("Checking anyMatch: " + x);
                            return x % 2 != 0;
                        });

        System.out.println("Has Odd: " + hasOdd);

        System.out.println("------------");

        // allMatch (stops when false found)
        boolean allEven =
                list.stream()
                        .allMatch(x -> {
                            System.out.println("Checking allMatch: " + x);
                            return x % 2 == 0;
                        });

        System.out.println("All Even: " + allEven);

        System.out.println("------------");

        // noneMatch (stops when true found)
        boolean noneNegative =
                list.stream()
                        .noneMatch(x -> {
                            System.out.println("Checking noneMatch: " + x);
                            return x < 0;
                        });

        System.out.println("None Negative: " + noneNegative);

        System.out.println("------------");

        // limit (short-circuit intermediate)
        list.stream()
                .limit(3)
                .forEach(x -> System.out.println("Limit: " + x));
    }
}
