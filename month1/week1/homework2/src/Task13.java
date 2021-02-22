import java.util.Scanner;

public class Task13 {
    public static void main(String[] args) {
        int first, second, third;
        int number, sum;

        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Enter sum:");
            sum = sc.nextInt();
        } while (sum < 2 || sum > 27);

        for (int i = 100; i <= 999; i++) {
            number = i;
            third = number % 10;
            number = number / 10;
            second = number % 10;
            first = number / 10;

            if (sum == first + second + third) {
                System.out.println(i);
            }
        }
    }
}
