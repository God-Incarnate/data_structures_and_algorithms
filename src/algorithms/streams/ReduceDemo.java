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

        // 🔷 4. Find max
        int max = numbers.stream()
                .reduce(Integer.MIN_VALUE, Integer::max);
        System.out.println("Max: " + max);

        // 🔷 5. Find min
        int min = numbers.stream()
                .reduce(Integer.MAX_VALUE, Integer::min);
        System.out.println("Min: " + min);

        // 🔷 6. Product (multiplication)
        int product = numbers.stream()
                .reduce(1, (a, b) -> a * b);
        System.out.println("Product: " + product);

        // 🔷 7. String concatenation
        List<String> names = Arrays.asList("Java", "Streams", "Reduce");

        String result = names.stream()
                .reduce("", (a, b) -> a + " " + b);
        System.out.println("Concatenation: " + result);

        // 🔷 8. Reduce on objects (max salary user)
        Optional<User> maxSalaryUser =
                users.stream()
                        .reduce((u1, u2) ->
                                u1.salary > u2.salary ? u1 : u2
                        );
        System.out.println("Max salary user: " + maxSalaryUser.get());

        // 🔷 9. Reduce after map (sum salaries)
        int totalSalary =
                users.stream()
                        .map(User::getSalary)
                        .reduce(0, Integer::sum);
        System.out.println("Total salary: " + totalSalary);

        // 🔷 10. Parallel reduce with combiner
        int parallelSum =
                numbers.parallelStream()
                        .reduce(
                                0,
                                (a, b) -> a + b,
                                (a, b) -> a + b
                        );
        System.out.println("Parallel Sum: " + parallelSum);


    }
}
