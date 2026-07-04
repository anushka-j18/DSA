import java.util.Scanner;

/*
------------------------------------------------------------
Problem : Allocate Books

Approach:
1. If the number of students is greater than the number
   of books, allocation is impossible.
2. The minimum possible maximum pages is the maximum
   pages in a single book.
3. The maximum possible maximum pages is the sum of
   all pages.
4. Apply Binary Search on the answer.
5. For every maximum page limit:
      - Allocate books greedily.
      - If the required students are less than or equal
        to m, try a smaller limit.
      - Otherwise, increase the limit.
6. The smallest valid limit is the answer.

Time Complexity : O(n × log(sum of pages))
Space Complexity: O(1)

Author: Anushka Joshi
------------------------------------------------------------
*/

public class AllocateBooks {

    // Returns the number of students required
    static int countStudents(int[] books, int maxPages) {

        int students = 1;
        int pages = 0;

        for (int book : books) {

            if (pages + book <= maxPages) {

                pages += book;

            } else {

                students++;
                pages = book;
            }
        }

        return students;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Read number of books
        int n = sc.nextInt();

        int[] books = new int[n];

        int maxBook = 0;
        int totalPages = 0;

        // Read pages in each book
        for (int i = 0; i < n; i++) {
            books[i] = sc.nextInt();
            maxBook = Math.max(maxBook, books[i]);
            totalPages += books[i];
        }

        // Read number of students
        int m = sc.nextInt();

        // Allocation not possible
        if (m > n) {
            System.out.println(-1);
            return;
        }

        int low = maxBook;
        int high = totalPages;
        int answer = totalPages;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int studentsRequired = countStudents(books, mid);

            if (studentsRequired <= m) {

                answer = mid;
                high = mid - 1;

            } else {

                low = mid + 1;
            }
        }

        System.out.println(answer);

        sc.close();
    }
}

/*
------------------------------------------------------------
Dry Run

Input:
books = [12, 34, 67, 90]
m = 2

Search Space:
90 ... 203

mid = 146

Student 1:
12 + 34 + 67 = 113

Student 2:
90

Students = 2

Possible.

Try smaller answer.

--------------------------------------------

mid = 118

Students = 2

Possible.

--------------------------------------------

mid = 103

Students = 3

Not possible.

Increase limit.

--------------------------------------------

Eventually,

Answer = 113

Allocation:

Student 1:
12 + 34 + 67 = 113

Student 2:
90

Output:
113

Key Observation:
If a maximum page limit is feasible,
then every larger page limit is also feasible.

This monotonic property allows Binary Search
on the answer.

------------------------------------------------------------
*/