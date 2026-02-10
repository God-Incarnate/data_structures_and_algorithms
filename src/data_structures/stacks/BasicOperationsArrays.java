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
        //can use LinkedList<Character> stack = new LinkedList<>() as well, but ArrayDeque is more efficient for stack operations.
        //can use Stack<Character> stack = new Stack<>(); as well, but ArrayDeque is more efficient for stack operations.
        //can use ArrayList<Character> stack = new ArrayList<>(); as well, but Deque is more efficient for stack operations.
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
                //stack.add(c); // for ArrayList
                //stack.add(0, c); // for LinkedList
                //stack.push(c); // for Stack
            }
            else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                //char top = stack.remove(stack.size() - 1); // for ArrayList
                //char top = stack.removeFirst(); // for LinkedList
                //char top = stack.pop(); // for Stack
                if ((c == ')' && top != '(') ||
                        (c == '}' && top != '{') ||
                        (c == ']' && top != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
        //&& stack.size() == 0; // for ArrayList
        //&& stack.isEmpty(); // for LinkedList
        //&& stack.isEmpty(); // for Stack
    }
    /*ArrayList vs ArrayDeque (important note)

        ArrayList works fine here
        But ArrayDeque is preferred for stack operations because:

        - Cleaner API (push/pop/peek)

        - Slightly better performance

        - Clearer intent

        LinkedList allows O(1) insert/remove from the end

        Perfect fit for LIFO (stack) behavior

        Logic is identical to ArrayDeque, just a different backing structure

        ⚔️ Interview tip

        If asked:

        ArrayDeque vs LinkedList?

        Answer:

        ArrayDeque → faster & cache-friendly

        LinkedList → conceptually clearer, but extra memory overhead*/


}
