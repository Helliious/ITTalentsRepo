import java.util.Scanner;

public class Task14 {
    public static void main(String[] args) {
        int number;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("Enter number: ");
            number = sc.nextInt();
        } while (number < 10 || number > 200);

        printNumbersModSeven(--number);
    }

    static void printNumbersModSeven(int number) {
        if (number == 0) {
            System.out.println();
        } else {
            if (number % 7 == 0) {
                System.out.print(number + ", ");
            }

            printNumbersModSeven(--number);
        }
    }
}
