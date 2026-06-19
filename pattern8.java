import java.util.Scanner;

public class pattern8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = n; i >= 1; i--) {

            // Print leading spaces
            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }

            // Print stars
            for (int j = 0; j < 2 * i - 1; j++) {
                System.out.print("*");
            }

            System.out.println();
        }

        sc.close();
    }
}