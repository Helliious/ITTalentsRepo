import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        int number;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("Enter number: ");
            number = sc.nextInt();
        } while (number < 1);

        System.out.println(sumElements(number));
    }

    static int sumElements(int endNumber) {
        if (endNumber == 1) {
            return endNumber;
        }

        return endNumber + sumElements(--endNumber);
    }
}
