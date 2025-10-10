//take two lists
//carry = sum / 10
//digit = sum % 10
//while loop goes until list1 or list 2 gets over and until carry == 1

//only if list1 is not null, add to sum
//same for list2

//taking extra linked list 

//TIP: ALWAYS MAKE SUM 0 AFTER EVERY ITERATION SO THAT YOU ARE A CALCULATING A BRAND NEW SUM
//TIP: IN THE CONDITION ALWAYS USE ONLY LIST1 != NULL AND LIST2 != NULL, DONT USE NEXT

//CONSTRAINTS: NODE.DATA IS ALWAYS INCLUDE IN [0,9]

import java.util.*;

class Node {
    Node next;
    int data;

    Node(int data) {
        this.data = data;
        next = null;
    }
}

public class AddTwoNumbers {

    public static Node insertNode(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null) {
            return newNode;
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;

        return head;
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + "->");
            head = head.next;
        }

        System.out.print("null");
    }

    public static Node add_two_numbers(Node list1, Node list2) {
        int carry = 0;
        Node dummy = new Node(-1);
        Node result = dummy;

        while (list1 != null || list2 != null || carry != 0) {
            int sum = 0;
            if (list1 != null)
                sum += list1.data;
            if (list2 != null)
                sum += list2.data;

            sum += carry;

            carry = sum / 10;
            int digit = sum % 10;

            Node newNode = new Node(digit);
            result.next = newNode;
            result = result.next;

            if (list1 != null) {
                list1 = list1.next;
            }

            if (list2 != null) {
                list2 = list2.next;
            }
        }

        return dummy.next;
    }

    public static void main(String args[]) {
        // if the input is given as number

        Node head = null;

        Node list1 = null;
        Node list2 = null;

        Scanner sc = new Scanner(System.in);

        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        // base case
        if (n1 == 0 && n2 == 0) {
            System.out.println("0->null");
            sc.close();
            return;
        }

        while (n1 != 0) {
            int digit = n1 % 10;
            list1 = insertNode(list1, digit);
            n1 = n1 / 10;
        }

        while (n2 != 0) {
            int digit = n2 % 10;
            list2 = insertNode(list2, digit);
            n2 = n2 / 10;
        }
        head = add_two_numbers(list1, list2);

        printList(head);

        sc.close();
    }
}
