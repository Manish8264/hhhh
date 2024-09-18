package epam;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class StackUsingQueues {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;
    private int top;

    public StackUsingQueues() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        queue1.offer(x); // Add the element to the primary queue
        top = x; // Update the top element
    }

    public int pop() {
        while (queue1.size() > 1) {
            top = queue1.poll(); // Update the top element until only one element remains
            queue2.offer(top); // Move elements from queue1 to queue2
        }

        int popValue = queue1.poll(); // Remove the last element from queue1 (i.e., the top element)

        // Swap queue1 and queue2 references for future operations
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return popValue;
    }

    public int top() {
        return top; // Return the top element
    }

    public boolean isEmpty() {
        return queue1.isEmpty(); // Check if the stack is empty
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StackUsingQueues stack = new StackUsingQueues();

        System.out.println("Enter elements to push onto the stack (Enter -1 to stop):");
        int element = scanner.nextInt();
        while (element != -1) {
            stack.push(element);
            element = scanner.nextInt();
        }

        System.out.println("Top element: " + stack.top());
        System.out.println("Popped element: " + stack.pop());

        System.out.println("Top element: " + stack.top());
        System.out.println("Popped element: " + stack.pop());

        System.out.println("Top element: " + stack.top());
        System.out.println("Popped element: " + stack.pop());

        System.out.println("Is the stack empty? " + stack.isEmpty());
    }
}

