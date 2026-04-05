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

}
