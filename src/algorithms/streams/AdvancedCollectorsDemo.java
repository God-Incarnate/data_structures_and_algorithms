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
    
}
