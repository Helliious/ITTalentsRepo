import java.util.Scanner;

public class Task8 {
    public static void main(String[] args) {
        int n;
        int number;

        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Enter N:");
            n = sc.nextInt();
        } while (n < 1);

        number = n -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(number);
            }

            number += 2;
            System.out.println();
        }
    }
}
