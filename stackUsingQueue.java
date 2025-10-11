import java.util.*;

class MyStack {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    // Push element onto stack
    public void push(int x) {
        q2.add(x);
        while (!q1.isEmpty()) {
            q2.add(q1.poll());
        }
        // swap q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    // Removes the element on top of the stack and returns it
    public int pop() {
        if (q1.isEmpty()) return -1;
        return q1.poll();
    }

    // Get the top element
    public int top() {
        if (q1.isEmpty()) return -1;
        return q1.peek();
    }

    // Return whether the stack is empty
    public boolean empty() {
        return q1.isEmpty();
    }
}

public class stackUsingQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyStack stack = new MyStack();

        int n = sc.nextInt();  // number of operations
        for (int i = 0; i < n; i++) {
            String op = sc.next();

            switch (op) {
                case "push":
                    int x = sc.nextInt();
                    stack.push(x);
                    break;
                case "pop":
                    System.out.println(stack.pop());
                    break;
                case "top":
                    System.out.println(stack.top());
                    break;
                case "empty":
                    System.out.println(stack.empty());
                    break;
                default:
                    System.out.println("Invalid operation");
            }
        }

        sc.close();
    }
}
