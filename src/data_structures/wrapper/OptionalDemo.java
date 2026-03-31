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

    }
}
