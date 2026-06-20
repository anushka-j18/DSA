import java.util.Scanner;

public class pattern18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            char start = (char)('A' + n - i - 1);

            for (char ch = start; ch <= 'A' + n - 1; ch++) {
                System.out.print(ch + " ");
            }

            System.out.println();
        }

        sc.close();
    }
}