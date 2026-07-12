import java.util.Scanner;

/*
------------------------------------------------------------
Problem : Search for a Key in a Singly Linked List

Approach:
1. Traverse the linked list from head to null.
2. Compare each node's data with the given key.
3. If the key is found, return true.
4. If the traversal ends without finding the key,
   return false.

Time Complexity : O(n)
Space Complexity: O(1)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class SearchInLinkedList {

    // Node class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Search for the key
    static boolean search(Node head, int key) {

        Node temp = head;

        while (temp != null) {

            if (temp.data == key) {
                return true;
            }

            temp = temp.next;
        }

        return false;
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

        // Read key
        int key = sc.nextInt();

        System.out.println(search(head, key));

        sc.close();
    }
}