import java.util.Scanner;

/*
------------------------------------------------------------
Problem : Detect Loop in a Singly Linked List

Approach:
1. Use Floyd's Cycle Detection Algorithm.
2. Maintain two pointers:
      - slow moves one step.
      - fast moves two steps.
3. If both pointers meet, a loop exists.
4. If fast reaches null, no loop exists.

Time Complexity : O(n)
Space Complexity: O(1)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class DetectLoopInLinkedList {

    // Node class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Detect loop
    static boolean hasLoop(Node head) {

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Number of nodes
        int n = sc.nextInt();

        Node[] nodes = new Node[n];

        // Create nodes
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(sc.nextInt());
        }

        // Connect nodes
        for (int i = 0; i < n - 1; i++) {
            nodes[i].next = nodes[i + 1];
        }

        // Position where tail connects (-1 if no loop)
        int pos = sc.nextInt();

        if (pos != -1 && n > 0) {
            nodes[n - 1].next = nodes[pos];
        }

        System.out.println(hasLoop(nodes[0]));

        sc.close();
    }
}