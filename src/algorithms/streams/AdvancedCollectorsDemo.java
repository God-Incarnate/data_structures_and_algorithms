package algorithms.streams;

import java.util.*;
import java.util.stream.*;

public class AdvancedCollectorsDemo {

    static class User {
        int id;
        String name;
        String city;
        String department;
        int salary;
        int age;
        List<String> skills;

        public User(int id, String name, String city, String department, int salary, int age, List<String> skills) {
            this.id = id;
            this.name = name;
            this.city = city;
            this.department = department;
            this.salary = salary;
            this.age = age;
            this.skills = skills;
        }

        public int getId() { return id; }
        public String getName() { return name; }
        public String getCity() { return city; }
        public String getDepartment() { return department; }
        public int getSalary() { return salary; }
        public int getAge() { return age; }
        public List<String> getSkills() { return skills; }

        @Override
        public String toString() {
            return name + "(" + salary + ")";
        }
    }

    public static void main(String[] args) {

        List<User> users = Arrays.asList(
                new User(1, "A", "Bangalore", "IT", 60000, 25, Arrays.asList("Java", "Spring")),
                new User(2, "B", "Bangalore", "IT", 80000, 30, Arrays.asList("Java", "AWS")),
                new User(3, "C", "Delhi", "HR", 40000, 28, Arrays.asList("Excel")),
                new User(4, "D", "Delhi", "IT", 90000, 35, Arrays.asList("Java", "Docker")),
                new User(5, "E", "Mumbai", "Finance", 70000, 40, Arrays.asList("Accounting"))
        );

        // 1. groupingBy (city)
        Map<String, List<User>> byCity =
                users.stream().collect(Collectors.groupingBy(User::getCity));
        System.out.println("groupingBy city: " + byCity);

        // 2. groupingBy + counting
        Map<String, Long> countByCity =
                users.stream().collect(Collectors.groupingBy(
                        User::getCity,
                        Collectors.counting()
                ));
        System.out.println("countByCity: " + countByCity);

        // 3. groupingBy + summing
        Map<String, Integer> salaryByCity =
                users.stream().collect(Collectors.groupingBy(
                        User::getCity,
                        Collectors.summingInt(User::getSalary)
                ));
        System.out.println("salaryByCity: " + salaryByCity);

        // 4. groupingBy + averaging
        Map<String, Double> avgSalary =
                users.stream().collect(Collectors.groupingBy(
                        User::getCity,
                        Collectors.averagingInt(User::getSalary)
                ));
        System.out.println("avgSalary: " + avgSalary);

        // 5. groupingBy + maxBy
        Map<String, Optional<User>> maxSalaryUser =
                users.stream().collect(Collectors.groupingBy(
                        User::getCity,
                        Collectors.maxBy(Comparator.comparing(User::getSalary))
                ));
        System.out.println("maxSalaryUser: " + maxSalaryUser);

        // 6. groupingBy + mapping
        Map<String, List<String>> namesByCity =
                users.stream().collect(Collectors.groupingBy(
                        User::getCity,
                        Collectors.mapping(User::getName, Collectors.toList())
                ));
        System.out.println("namesByCity: " + namesByCity);

        // 7. Multi-level grouping
        Map<String, Map<String, List<User>>> multiGroup =
                users.stream().collect(Collectors.groupingBy(
                        User::getCity,
                        Collectors.groupingBy(User::getDepartment)
                ));
        System.out.println("multiGroup: " + multiGroup);

        // 8. partitioningBy
        Map<Boolean, List<User>> partition =
                users.stream().collect(Collectors.partitioningBy(u -> u.getAge() > 30));
        System.out.println("partition age>30: " + partition);

        // 9. partitioningBy + counting
        Map<Boolean, Long> partitionCount =
                users.stream().collect(Collectors.partitioningBy(
                        u -> u.getAge() > 30,
                        Collectors.counting()
                ));
        System.out.println("partitionCount: " + partitionCount);

        // 10. collectingAndThen
        List<User> immutableList =
                users.stream().collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        Collections::unmodifiableList
                ));
        System.out.println("immutableList: " + immutableList);

        // 11. joining
        String names =
                users.stream()
                        .map(User::getName)
                        .collect(Collectors.joining(", "));
        System.out.println("joining: " + names);

        // 12. summarizing
        IntSummaryStatistics stats =
                users.stream().collect(Collectors.summarizingInt(User::getSalary));
        System.out.println("stats: " + stats);

        // 13. toMap (handle duplicates)
        Map<Integer, String> idToName =
                users.stream().collect(Collectors.toMap(
                        User::getId,
                        User::getName,
                        (a, b) -> a
                ));
        System.out.println("toMap: " + idToName);

        // 14. filtering (Java 9+)
        Map<String, List<User>> filtered =
                users.stream().collect(Collectors.groupingBy(
                        User::getCity,
                        Collectors.filtering(
                                u -> u.getSalary() > 60000,
                                Collectors.toList()
                        )
                ));
        System.out.println("filtered: " + filtered);

        // 15. flatMapping (Java 9+)
        Map<String, List<String>> skillsByCity =
                users.stream().collect(Collectors.groupingBy(
                        User::getCity,
                        Collectors.flatMapping(
                                u -> u.getSkills().stream(),
                                Collectors.toList()
                        )
                ));
        System.out.println("skillsByCity: " + skillsByCity);

        // 16. teeing (Java 12+)
        double avg =
                users.stream().collect(Collectors.teeing(
                        Collectors.summingInt(User::getSalary),
                        Collectors.counting(),
                        (sum, count) -> (double) sum / count
                ));
        System.out.println("teeing avg salary: " + avg);
    }
}
