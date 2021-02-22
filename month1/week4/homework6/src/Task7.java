import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {
        int number;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("Enter number: ");
            number = sc.nextInt();
        } while (number < 1);

        printNumbersModThree(1, number);
    }

    static void printNumbersModThree(int start, int end) {
        if (start == end) {
            System.out.println(end * 3);
        } else {
            System.out.print((start * 3) + " ");

            printNumbersModThree(++start, end);
        }
    }
}
