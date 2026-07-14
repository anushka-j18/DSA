import java.util.Scanner;

/*
------------------------------------------------------------
Problem : Middle of a Singly Linked List

Approach:
1. Use two pointers:
      - slow moves one step at a time.
      - fast moves two steps at a time.
2. When fast reaches the end,
   slow will be at the middle.
3. For even-length lists, this naturally returns
   the second middle node.

Time Complexity : O(n)
Space Complexity: O(1)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class MiddleOfLinkedList {

    // Node class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Find middle node
    static Node findMiddle(Node head) {

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // Print linked list
    static void printList(Node head) {

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read number of nodes
        int n = sc.nextInt();

        Node head = null;
        Node tail = null;

        // Create linked list
        for (int i = 0; i < n; i++) {

            int value = sc.nextInt();

            Node newNode = new Node(value);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        Node middle = findMiddle(head);

        if (middle != null) {
            System.out.println(middle.data);
        }

        sc.close();
    }
}