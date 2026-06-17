import java.util.*;

class InputOutput {
    void printNumber(Scanner sc) {
        System.out.print(sc.nextInt());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InputOutput obj = new InputOutput();
        obj.printNumber(sc);
    }
}