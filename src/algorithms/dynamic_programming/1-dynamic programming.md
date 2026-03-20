# Dynamic Programming (DP)

## Overview
Dynamic Programming (DP) is an algorithm design technique used to solve complex problems by breaking them down into smaller overlapping subproblems and storing the results of those subproblems to avoid repeated computation.

The key idea is to solve each subproblem only once and reuse the stored results whenever needed.

---

## Key Properties of Dynamic Programming

Dynamic programming problems usually have two important properties.

### 1. Overlapping Subproblems
The same subproblems are solved multiple times.

Example:
In a recursive Fibonacci calculation, values like `fib(3)` are computed repeatedly.

### 2. Optimal Substructure
The optimal solution to the main problem can be constructed from optimal solutions of its subproblems.

Example:
The shortest path between two nodes can be determined using the shortest paths of smaller segments.

---

## Approaches to Dynamic Programming

There are two main approaches to implementing dynamic programming.

### 1. Memoization (Top-Down Approach)

- Uses recursion
- Stores computed results
- Avoids recalculating subproblems

Example: Fibonacci using Memoization

```java
import java.util.*;

public class FibonacciMemo {

    static int[] dp = new int[100];

    static int fib(int n) {
        if (n <= 1)
            return n;

        if (dp[n] != 0)
            return dp[n];

        dp[n] = fib(n - 1) + fib(n - 2);
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(fib(6));
    }
}
```

### 2. Tabulation (Bottom-Up Dynamic Programming)

Tabulation is a Dynamic Programming technique where we solve problems by building a table (usually an array) from the smallest subproblems up to the final solution.

Instead of using recursion, tabulation uses **iteration** to fill a table step-by-step.

### Key Idea

1. Start with the **base cases**.
2. Use previously computed values to compute the next values.
3. Continue filling the table until the final result is obtained.

---

## Example: Fibonacci Using Tabulation

The Fibonacci sequence is defined as:

F(0) = 0  
F(1) = 1  

For n ≥ 2:
F(n) = F(n-1) + F(n-2)

### Java Implementation

```java
public class FibonacciTabulation {

    public static int fibonacci(int n) {

        int[] dp = new int[n + 1];

        // Base cases
        dp[0] = 0;
        dp[1] = 1;

        // Fill the table
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static void main(String[] args) {

        int n = 6;
        System.out.println("Fibonacci of " + n + " is " + fibonacci(n));
    }
}
```
#### Step-by-Step Table Construction (n = 6)

| i     | dp[i] |
|-------| ----- |
| 0     | 0     |
| 1     | 1     |
| 2     | 1     |
| 3     | 2     |
| 4     | 3     |
| 5     | 5     |
| 6     | 8     |
