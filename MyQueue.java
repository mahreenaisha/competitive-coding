import java.util.*;

class MyQueue {

    Stack<Integer> stackIn = new Stack<>();   // used for enqueue (push)
    Stack<Integer> stackOut = new Stack<>();  // used for dequeue (pop/peek)

    // Push element x to the back of queue
    public void push(int x) {
        stackIn.push(x);
    }

    // Removes the element from the front of queue and returns it
    public int pop() {
        // If stackOut is empty, move all elements from stackIn → stackOut
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
        return stackOut.pop();
    }

    // Get the front element
    public int peek() {
        // If stackOut is empty, move elements from stackIn → stackOut
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
        return stackOut.peek();
    }

    // Returns whether the queue is empty
    public boolean empty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }

    // Test the implementation
    public static void main(String[] args) {
        MyQueue q = new MyQueue();

        q.push(1);
        q.push(2);
        System.out.println(q.peek());  // Output: 1
        System.out.println(q.pop());   // Output: 1
        System.out.println(q.empty()); // Output: false

        q.push(10);
        q.push(20);
        q.push(30);
        System.out.println(q.pop());   // Output: 2
        System.out.println(q.peek());  // Output: 10
    }
}
