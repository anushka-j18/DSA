import java.util.Scanner;

/*
------------------------------------------------------------
Problem : Reverse a Singly Linked List

Approach:
1. Initialize three pointers:
      - prev = null
      - current = head
      - next = null
2. Traverse the linked list.
3. For each node:
      - Store the next node.
      - Reverse the current node's link.
      - Move prev and current one step ahead.
4. At the end, prev becomes the new head.
5. Return the new head.

Time Complexity : O(n)
Space Complexity: O(1)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class ReverseLinkedList {

    // Node class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Reverse linked list
    static Node reverse(Node head) {

        Node prev = null;
        Node current = head;

        while (current != null) {

            Node next = current.next;

            current.next = prev;

            prev = current;

            current = next;
        }

        return prev;
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

        head = reverse(head);

        printList(head);

        sc.close();
    }
}