import java.util.Scanner;

/*
------------------------------------------------------------
Problem : Reverse a Doubly Linked List

Approach:
1. Traverse the doubly linked list.
2. For every node:
      - Swap its next and previous pointers.
3. Move to the previous node
   (because pointers have been swapped).
4. The last processed node becomes the new head.
5. Return the new head.

Time Complexity : O(n)
Space Complexity: O(1)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class ReverseDLL {

    // Doubly Linked List Node
    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    // Reverse the doubly linked list
    static Node reverse(Node head) {

        Node current = head;
        Node temp = null;

        while (current != null) {

            // Swap previous and next pointers
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;

            // Move to the next node in original list
            current = current.prev;
        }

        // Update head
        if (temp != null) {
            head = temp.prev;
        }

        return head;
    }

    // Print Doubly Linked List
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

        // Create Doubly Linked List
        for (int i = 0; i < n; i++) {

            int value = sc.nextInt();

            Node newNode = new Node(value);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
        }

        head = reverse(head);

        printList(head);

        sc.close();
    }
}