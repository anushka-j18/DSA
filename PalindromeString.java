import java.util.Scanner;

public class PalindromeString {

    static boolean isPalindrome(String s, int left, int right) {
        if (left >= right) {
            return true;
        }

        if (s.charAt(left) != s.charAt(right)) {
            return false;
        }

        return isPalindrome(s, left + 1, right - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        System.out.println(isPalindrome(s, 0, s.length() - 1));

        sc.close();
    }
}