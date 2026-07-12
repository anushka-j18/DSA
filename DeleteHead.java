import java.util.Scanner;

/*
------------------------------------------------------------
Problem : Delete Head of Linked List

Approach:
1. If the linked list is empty, return null.
2. Move the head to the next node.
3. The first node gets removed automatically by
   Java's Garbage Collector.
4. Print the modified linked list.

Time Complexity : O(1)
Space Complexity: O(1)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class DeleteHead {

    // Node class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Delete the head node
    static Node deleteHead(Node head) {

        if (head == null) {
            return null;
        }

        head = head.next;

        return head;
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

        // Number of nodes
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

        head = deleteHead(head);

        printList(head);

        sc.close();
    }
}