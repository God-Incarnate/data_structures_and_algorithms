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


    }
}
