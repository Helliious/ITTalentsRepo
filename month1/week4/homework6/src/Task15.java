import java.util.Scanner;

public class Task15 {
    public static void main(String[] args) {
        int number;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("Enter number: ");
            number = sc.nextInt();
        } while (number < 1);

        System.out.println(sum(number));
    }

    static int sum(int number) {
        if (number == 1) {
            return number;
        }

        return number + sum(--number);
    }
}
