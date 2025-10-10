import java.util.*;

class Node {
    Node next;
    int data;

    Node(int data){
        this.data = data;
        next = null;
    }
}

public class partitionList {

    public static Node insertNode(Node head, int data){
        Node newNode = new Node(data); 
        if(head == null){
            return newNode;
        }

        Node temp = head;

        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;

        return head;
    }

    public static void printList(Node head){
        while (head != null){
            System.out.print(head.data + "->");
            head = head.next;
        }

        System.out.print("null");
    }
    public static Node partition_list(Node head, int x){
        Node greaterEqualHead = new Node (-1);
        Node greaterEqualTail = greaterEqualHead;

        Node lesserHead = new Node (-1);
        Node lesserTail = lesserHead;

        Node curr = head;
        while (curr != null){
            if(curr.data < x){
                lesserTail.next = curr;
                lesserTail = lesserTail.next;
            }

            else {
                greaterEqualTail.next = curr;
                greaterEqualTail = greaterEqualTail.next;
            }

            curr = curr.next;
        }

        greaterEqualTail.next = null;
        lesserTail.next = greaterEqualHead.next;

        return lesserHead.next;
    }
    public static void main (String args[]){
        Scanner sc = new Scanner (System.in);
        Node head = null;
        
        int n = 0;
        n = sc.nextInt();
        int[] arr = new int[n];

        for (int i=0;i<arr.length;i++){
            arr[i] = sc.nextInt();
        }

        for (int data : arr){
            head = insertNode(head, data);
        }

        int x = sc.nextInt(); //value to partition list by
        head = partition_list(head, x);

        printList(head);

        sc.close();

    }

    
}
