import java.util.Scanner;

/*
------------------------------------------------------------
Problem : Count Nodes in a Singly Linked List

Approach:
1. Initialize a counter to 0.
2. Traverse the linked list from head to null.
3. Increment the counter for every node visited.
4. Print the total count.

Time Complexity : O(n)
Space Complexity: O(1)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class CountNodes {

    // Node class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Count the number of nodes
    static int countNodes(Node head) {

        int count = 0;
        Node temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        return count;
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

        System.out.println(countNodes(head));

        sc.close();
    }
}