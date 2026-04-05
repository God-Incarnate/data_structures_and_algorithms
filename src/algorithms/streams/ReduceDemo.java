package algorithms.streams;

import java.util.*;
import java.util.stream.*;

public class ReduceDemo {

    static class User {
        int id;
        String name;
        int salary;

        public User(int id, String name, int salary) {
            this.id = id;
            this.name = name;
            this.salary = salary;
        }

        public int getSalary() { return salary; }

        @Override
        public String toString() {
            return name + "(" + salary + ")";
        }
    }

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        List<User> users = Arrays.asList(
                new User(1, "A", 50000),
                new User(2, "B", 70000),
                new User(3, "C", 60000)
        );

        // 🔷 1. Basic reduce (sum)
        int sum = numbers.stream()
                .reduce(0, (a, b) -> a + b);
        System.out.println("Sum: " + sum);

        // 🔷 2. Using method reference
        int sum2 = numbers.stream()
                .reduce(0, Integer::sum);
        System.out.println("Sum (method ref): " + sum2);

        // 🔷 3. Reduce without identity (Optional)
        Optional<Integer> sumOptional = numbers.stream()
                .reduce((a, b) -> a + b);
        System.out.println("Sum Optional: " + sumOptional.get());


    }
}
