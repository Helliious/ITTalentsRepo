import java.util.Scanner;

public class Task12 {
    public static void main(String[] args) {
        int n;
        int number = 1;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Enter n:");
            n = sc.nextInt();
        } while (n < 1);

        for (int i = 1; i <= n; i++) {
            number = i;
            for (int j = i; j < n + i; j++) {
                if (number >= 10) {
                    number = 1;
                }

                System.out.print(number + " ");
                number++;
            }

            System.out.println();
        }
    }
}
