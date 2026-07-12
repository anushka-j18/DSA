import java.util.Scanner;

/*
------------------------------------------------------------
Problem : Insert Node at Head of Linked List

Approach:
1. Create a new node with value X.
2. Point the new node's next to the current head.
3. Update head to the new node.
4. Print the modified linked list.

Time Complexity : O(1)
Space Complexity: O(1)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class InsertAtHead {

    // Node class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Insert node at head
    static Node insertAtHead(Node head, int x) {

        Node newNode = new Node(x);
        newNode.next = head;
        head = newNode;

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

        // Value to insert
        int x = sc.nextInt();

        head = insertAtHead(head, x);

        printList(head);

        sc.close();
    }
}