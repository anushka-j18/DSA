import java.util.Scanner;

/*
------------------------------------------------------------
Problem : Insert Node at Head of Doubly Linked List

Approach:
1. Create a new node with value X.
2. If the list is empty, the new node becomes the head.
3. Otherwise:
      - Set newNode.next = head.
      - Set head.prev = newNode.
      - Update head to newNode.
4. Print the modified doubly linked list.

Time Complexity : O(1)
Space Complexity: O(1)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class InsertAtHeadDLL {

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

    // Insert node before head
    static Node insertAtHead(Node head, int x) {

        Node newNode = new Node(x);

        if (head == null) {
            return newNode;
        }

        newNode.next = head;
        head.prev = newNode;

        head = newNode;

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

        // Read value to insert
        int x = sc.nextInt();

        head = insertAtHead(head, x);

        printList(head);

        sc.close();
    }
}