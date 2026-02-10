package data_structures.stacks;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class BasicOperationsArrays {
    static ArrayList<Integer> stack=new ArrayList<>();
    static int stackSize;

    public static void main(String[] args) {

        System.out.println("Pushed data:");
        push(7);
        print();
        System.out.println("\nPushed data:");
        push(3);
        print();
        System.out.println("\nPushed data:");
        push(2);
        print();
        System.out.println("\nExisting Stack:");
        print();

        pop();

        System.out.println("\nExisting Stack:");
        print();
        peek();

        if (isValid("]")){
            System.out.println("\nvalid parentheses");
        } else {
            System.out.println("\ninvalid parentheses");
        }

    }

    public static boolean isEmpty(){
        return stackSize==0;
    }

    public static void push(int value) {
        stack.add(value);
        stackSize++;
    }

    public static void pop() {
        System.out.println("\npopped value: "+stack.get(stackSize-1));
        stack.remove(stackSize-1);
        stackSize--;
    }

    public static void peek() {
        System.out.println("\npeeked value: "+stack.get(stackSize-1));
    }

    public static void print(){
        System.out.println(stack);
    }

    public static boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;

        //can use ArrayList<Character> stack = new ArrayList<>(); as well, but Deque is more efficient for stack operations.
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
                //stack.add(c); // for ArrayList
            }
            else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                //char top = stack.remove(stack.size() - 1); // for ArrayList
                if ((c == ')' && top != '(') ||
                        (c == '}' && top != '{') ||
                        (c == ']' && top != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
                //&& stack.size() == 0; // for ArrayList
    }
    /*ArrayList vs ArrayDeque (important note)

        ArrayList works fine here
        But ArrayDeque is preferred for stack operations because:

        - Cleaner API (push/pop/peek)

        - Slightly better performance

        - Clearer intent */

}
