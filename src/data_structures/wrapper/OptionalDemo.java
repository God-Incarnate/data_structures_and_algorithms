package data_structures.wrapper;

import java.util.*;

public class OptionalDemo {

    static class User {
        String name;

        User(String name) {
            this.name = name;
        }

        String getName() {
            return name;
        }
    }

    public static void main(String[] args) {

        // 🔷 1. Creating Optional

        Optional<String> opt1 = Optional.of("Java"); // must not be null
        Optional<String> opt2 = Optional.ofNullable(null); // safe for null
        Optional<String> opt3 = Optional.empty(); // empty optional

        System.out.println("opt1: " + opt1);
        System.out.println("opt2: " + opt2);
        System.out.println("opt3: " + opt3);

        // ------------------------------------------------------

        // 🔷 2. Checking value

        // ❌ Old style (not recommended)
        if (opt1.isPresent()) {
            System.out.println("isPresent: " + opt1.get());
        }

        // ✅ Modern way
        opt1.ifPresent(val -> System.out.println("ifPresent: " + val));

        // ------------------------------------------------------

        // 🔷 3. Getting values safely

        // orElse → always evaluated
        String val1 = opt2.orElse("Default Value");
        System.out.println("orElse: " + val1);

        // orElseGet → evaluated only if needed (lazy)
        String val2 = opt2.orElseGet(() -> "Generated Value");
        System.out.println("orElseGet: " + val2);

        // orElseThrow → throws exception if empty
        try {
            String val3 = opt2.orElseThrow(() -> new RuntimeException("Value not found"));
            System.out.println(val3);
        } catch (Exception e) {
            System.out.println("orElseThrow: " + e.getMessage());
        }

        // ------------------------------------------------------

        // 🔷 4. map() → transform value

        Optional<String> upper =
                opt1.map(s -> s.toUpperCase());

        System.out.println("map (toUpperCase): " + upper);

        // ------------------------------------------------------

        // 🔷 5. flatMap() → avoid nested Optional

        Optional<String> flat =
                opt1.flatMap(s -> Optional.of(s.toUpperCase()));

        System.out.println("flatMap: " + flat);

        // ------------------------------------------------------

        // 🔷 6. filter()

        Optional<Integer> number = Optional.of(10);

        number.filter(n -> n > 5)
                .ifPresent(n -> System.out.println("filter (>5): " + n));

        number.filter(n -> n > 20)
                .ifPresent(n -> System.out.println("This won't print"));

        // ------------------------------------------------------


    }
}
