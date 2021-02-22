import java.util.Scanner;

public class Task16 {
    public static void main(String[] args) {
        int n;
        int number = 1;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Enter N:");
            n = sc.nextInt();
        } while (n < 1);

        for (int i = 1; i <= n; i++) {
            number = i;

            for (int j = 0; j < n; j++) {
                System.out.print(number + " ");
                number++;

                if (number > n) {
                    number = 1;
                }
            }

            System.out.println();
        }
    }
}
