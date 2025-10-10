//keep adding numbers
//take two stacks
//operations must be push, pop, top, empty

import java.util.*;

class MinStack {

    Stack<Integer> s;
    Stack<Integer> minStack;

    MinStack() {
        s = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        s.push(x);

        if (minStack.isEmpty() || minStack.peek() >= x) {
            minStack.push(x);
        }
    }

    public void pop() {

        if (!s.isEmpty()) {
            int x = s.pop();

            if (minStack.peek() == x) {
                minStack.pop();
            }
        }
    }

    public int top() {
        return (!s.isEmpty()) ? s.peek() : -1;
    }

    public int getMin() {
        return (!minStack.isEmpty()) ? minStack.peek() : -1;
    }
}

public class minStackProgram {

    public static void main(String args[]) {

        MinStack obj = new MinStack();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String[] operations = new String[n];

        for (int i = 0; i < n; i++) {
            operations[i] = sc.next();

            switch (operations[i]) {
                case "push":
                    int x = sc.nextInt();
                    obj.push(x);
                    break;

                case "pop":
                    obj.pop();
                    break;

                case "top":
                    System.out.println(obj.top());
                    break;

                case "getMin":
                    System.out.println(obj.getMin());
                    break;

                default:
                    System.out.println("Invalid operation");
            }
        }

        sc.close();

    }
}
