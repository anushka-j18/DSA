import java.util.Scanner;

/*
------------------------------------------------------------
Problem : Delete Head of Doubly Linked List

Approach:
1. If the list is empty, return null.
2. If there is only one node, return null.
3. Move the head to the next node.
4. Set the new head's previous pointer to null.
5. Return the updated head.

Time Complexity : O(1)
Space Complexity: O(1)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class DeleteHeadDLL {

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

    // Delete head node
    static Node deleteHead(Node head) {

        // Empty list
        if (head == null) {
            return null;
        }

        // Only one node
        if (head.next == null) {
            return null;
        }

        Node newHead = head.next;
        newHead.prev = null;
        head.next = null;

        return newHead;
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

        head = deleteHead(head);

        printList(head);

        sc.close();
    }
}